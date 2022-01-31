import com.tencent.ad.tangram.net.AdHttp.Params;

class yqy
  extends AdHttp.Params
{
  public int a = -2147483648;
  
  public boolean isSuccess()
  {
    return (super.isSuccess()) && (this.responseData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yqy
 * JD-Core Version:    0.7.0.1
 */