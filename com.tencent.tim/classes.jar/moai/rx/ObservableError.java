package moai.rx;

import com.alibaba.fastjson.JSONObject;
import retrofit.client.Response;

public class ObservableError
  extends RuntimeException
{
  public static final int ERROR_CODE_NETWORK_CANCELED = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 0;
  public static final String ERROR_MSG_NETWOEK_CANCELED = "Canceled";
  private static final long serialVersionUID = 1L;
  private int errorCode = 0;
  private int errorType = 0;
  private Object extension;
  private JSONObject info;
  private int reponseStatus = 200;
  private Response response;
  
  public ObservableError(int paramInt1, int paramInt2, int paramInt3, String paramString, JSONObject paramJSONObject)
  {
    super(paramString);
    this.errorType = paramInt1;
    this.errorCode = paramInt2;
    this.reponseStatus = paramInt3;
    this.info = paramJSONObject;
  }
  
  public ObservableError(int paramInt, String paramString)
  {
    super(paramString);
    this.errorType = paramInt;
  }
  
  public static ObservableError createNetworkError(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    return new ObservableError(0, paramInt1, paramInt2, paramString, paramJSONObject);
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMsg()
  {
    return getMessage();
  }
  
  public int getErrorType()
  {
    return this.errorType;
  }
  
  public Object getExtension()
  {
    return this.extension;
  }
  
  public JSONObject getInfo()
  {
    return this.info;
  }
  
  public Response getResponse()
  {
    return this.response;
  }
  
  public int getStatus()
  {
    return this.reponseStatus;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorType(int paramInt)
  {
    this.errorType = paramInt;
  }
  
  public void setExtension(Object paramObject)
  {
    this.extension = paramObject;
  }
  
  public void setInfo(JSONObject paramJSONObject)
  {
    this.info = paramJSONObject;
  }
  
  public void setResponse(Response paramResponse)
  {
    this.response = paramResponse;
  }
  
  public void setStatus(int paramInt)
  {
    this.reponseStatus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ObservableError
 * JD-Core Version:    0.7.0.1
 */