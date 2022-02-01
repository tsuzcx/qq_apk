package moai.rx;

import retrofit.converter.ConversionException;

public class ServiceException
  extends ConversionException
{
  private static final long serialVersionUID = -7245244123737581257L;
  private int errcode = 0;
  
  public ServiceException(String paramString, int paramInt)
  {
    super(paramString);
    this.errcode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errcode;
  }
  
  public String toString()
  {
    return "ServiceException: errcode: " + this.errcode + ", errmsg: " + getMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.ServiceException
 * JD-Core Version:    0.7.0.1
 */