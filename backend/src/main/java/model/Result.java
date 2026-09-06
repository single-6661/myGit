package model;
//前后端分离需要result反映错误或成功信息
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    //成功静态方法
    public static <T> Result<T> success(T data){
        Result<T> r = new Result<>();
        r.code = 200;
        r.msg = "成功";
        r.data = data;
        return r;
    }
    //失败静态方法
    public static <T> Result<T> fail(){
        Result<T> r = new Result<>();
        r.code = 500;
        r.msg = "失败";
        r.data = null;
        return r;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
