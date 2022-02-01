package moai.rx;


public class ObservableResult<T> {
	public static enum ResultType{
		DEFAULT, LOCAL_SUCCESS, NETWORK_LOADING, NETWORK_SUCCESS, NETWORK_OFFLINE, NETWORK_ERROR
	}
	
	private ResultType type = ResultType.DEFAULT;
	
	private T result = null;
	
	private Throwable throwable;
	
	public ObservableResult(ResultType type, T result) {
		this.type = type;
		this.result = result;
	}
	
	public ObservableResult(ResultType type, T result, Throwable e) {
		this.type = type;
		this.result = result;
		this.throwable = e;
	}
	
	public ResultType getType() {
		return type;
	}
	
	public void setType(ResultType type) {
		this.type = type;
	}
	
	public T getResult() {
		return result;
	}
	
	public void setResult(T result) {
		this.result = result;
	}

	public Throwable getException() {
		return throwable;
	}

	public void setException(Throwable e) {
		this.throwable = e;
	}
}
