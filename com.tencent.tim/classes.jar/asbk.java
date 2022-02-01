import com.tencent.qphone.base.util.QLog;

class asbk
  implements asbh.b
{
  asbk(asbh paramasbh, asbh.b paramb) {}
  
  public void ea(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "updatePreAuthFromServer onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    this.a.ea(paramInt, paramString);
  }
  
  public void onSuccess()
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "updatePreAuthFromServer onSuccess");
    this.a.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     asbk
 * JD-Core Version:    0.7.0.1
 */