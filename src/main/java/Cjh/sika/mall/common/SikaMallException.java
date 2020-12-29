
package Cjh.sika.mall.common;

public class SikaMallException extends RuntimeException {

    public SikaMallException() {
    }

    public SikaMallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     *
     * @param message
     */
    public static void fail(String message) {
        throw new SikaMallException(message);
    }

}
