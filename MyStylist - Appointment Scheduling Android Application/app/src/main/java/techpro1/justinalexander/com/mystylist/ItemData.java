package techpro1.justinalexander.com.mystylist;

import java.util.List;

public class ItemData {


    /**
     * code : 1
     * msg : success
     * data : [{"service":"/pictures/one.jpg","price":"$50"},{"service":"/pictures/two.jpg","price":"$70"},{"service":"/pictures/three.jpg","price":"$80"},{"service":"/pictures/four.jpg","price":"$60"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * service : /pictures/one.jpg
         * price : $50
         */

        private String service;
        private String price;
        private String style;

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStyle() { return style; }

        public void setStyle(String style) { this.style = style;
        }
    }
}
