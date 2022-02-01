package moai.rx;

import retrofit.converter.ConversionException;

/**
 * Created by ayangxu.
 */
public class ServiceException extends ConversionException {
	private static final long serialVersionUID = -7245244123737581257L;
	private int errcode = 0;
    public ServiceException(String message, int errcode) {
        super(message);
        this.errcode = errcode;
    }

	public int getErrorCode() {
		return this.errcode;
	}

    @Override
    public String toString() {
        return "ServiceException: errcode: " + errcode + ", errmsg: " + getMessage();
    }
}
