package moai.rx;

import com.alibaba.fastjson.JSONObject;

import retrofit.client.Response;

public class ObservableError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//错误信息定义
	public static final String ERROR_MSG_NETWOEK_CANCELED = "Canceled";
	
	//错误码定义
	public static final int ERROR_CODE_NETWORK_ERROR = 0;
	public static final int ERROR_CODE_NETWORK_CANCELED = 1;
	
	private int reponseStatus = 200;
	private int errorCode = 0;
	private int errorType = ERROR_CODE_NETWORK_ERROR;
    private Response response;
	private Object extension;
	private JSONObject info;

	public int getStatus() {
		return reponseStatus;
	}

	public void setStatus(int status) {
		this.reponseStatus = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Object getExtension() {
		return extension;
	}

	public void setExtension(Object extension) {
		this.extension = extension;
	}

	public ObservableError(int errorType, String errorMsg) {
		super(errorMsg);
		
		this.errorType = errorType;
	}
	
	public ObservableError(int errorType, int errorCode, int status, String errorMsg, JSONObject info) {
		super(errorMsg);
		
		this.errorType = errorType;
		this.errorCode = errorCode;
		this.reponseStatus = status;
		this.info = info;
	}
	
	public int getErrorType() {
		return errorType;
	}

	public void setErrorType(int errorCode) {
		this.errorType = errorCode;
	}
	
	public String getErrorMsg() {
		return getMessage();
	}
	
	public static ObservableError createNetworkError(int errorCode, int status, String errorMsg, JSONObject info) {
		return (new ObservableError(ERROR_CODE_NETWORK_ERROR, errorCode, status, errorMsg, info));
	}

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

	public JSONObject getInfo() {
		return info;
	}

	public void setInfo(JSONObject info) {
		this.info = info;
	}
}
