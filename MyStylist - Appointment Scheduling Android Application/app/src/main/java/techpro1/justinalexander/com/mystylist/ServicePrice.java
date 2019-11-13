package techpro1.justinalexander.com.mystylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServicePrice extends AppCompatActivity {

    private RecyclerView rcvService;
    private RecyclerView.Adapter adapter;
    private List<String> list;
    private List<String> list1;
    private List<String> list2;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        rcvService = findViewById(R.id.rcv_service);
        final Button btnBack = findViewById(R.id.btnBack_service);

        list = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
//        list1.add( "HairCut $50");
//        list1.add("HairCut w/face $70");
//        list1.add("HairCut line w/face $80");
//        list1.add("Hair line $60");

        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://cgi.sice.indiana.edu/~team21/service.php")
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();

                ItemData itemData = new Gson().fromJson(json, ItemData.class);
                for (int i = 0; i < itemData.getData().size(); i++) {
                    list.add("http://cgi.sice.indiana.edu/~team21" + itemData.getData().get(i).getService());
                    list1.add(itemData.getData().get(i).getPrice());
                    list2.add(itemData.getData().get(i).getStyle());
                    Log.d("------", list.get(i));
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

        rcvService.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdpater();
        rcvService.setAdapter(adapter);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServicePrice.this, Main2Activity.class));
            }
        });
    }

    class MyAdpater extends RecyclerView.Adapter<MyAdpater.MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_service, viewGroup, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            Glide.with(ServicePrice.this).load(list.get(i).replaceAll("\\\"", "")).into(myViewHolder.iv);
            myViewHolder.tv.setText(list1.get(i));
            myViewHolder.tv2.setText(list2.get(i));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView iv;
            TextView tv;
            TextView tv2;

            MyViewHolder(View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv_item);
                tv = itemView.findViewById(R.id.tv_item);
                tv2 = itemView.findViewById(R.id.tv_style);
            }
        }
    }
}
