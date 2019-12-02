package com.test.myretails.product;

    public class ResposeDTO {
        private boolean success;
        private String message;
        private Object output;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getOutput() {
            return output;
        }

        public void setOutput(Object output) {
            this.output = output;
        }
    }
