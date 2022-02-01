import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class qym
  implements INetInfoHandler
{
  qym(qyk paramqyk) {}
  
  public void onNetMobile2None()
  {
    qyk.b(this.this$0, qyk.eK(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    qyk.b(this.this$0, qyk.eK(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    qyk.b(this.this$0, qyk.eK(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    qyk.b(this.this$0, qyk.eK(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    qyk.b(this.this$0, qyk.eK(2));
  }
  
  public void onNetWifi2None()
  {
    qyk.b(this.this$0, qyk.eK(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qym
 * JD-Core Version:    0.7.0.1
 */