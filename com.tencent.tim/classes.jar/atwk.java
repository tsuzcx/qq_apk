import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AccountNotMatchException;

class atwk
  implements ahcj.b
{
  atwk(atwj paramatwj, String paramString) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    this.a.b.a(paramString, paramLong, paramBundle);
    Object localObject = paramBundle.getBundle("_CB_USERDATA");
    paramBundle = ((Bundle)localObject).getString("sha");
    String str1 = ((Bundle)localObject).getString("fileId");
    String str2 = ((Bundle)localObject).getString("fileName");
    localObject = ((Bundle)localObject).getString("preViewUrl");
    try
    {
      ((ateh)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.mUin)).getBusinessHandler(180)).b(str2, str1, (String)localObject, paramBundle, paramLong, paramString);
    }
    catch (AccountNotMatchException paramString)
    {
      for (;;)
      {
        try
        {
          atur.a().IW(this.val$downloadUrl);
          return;
        }
        catch (Exception paramString) {}
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.b.b(paramInt, paramString, paramBundle);
  }
  
  public void p(int paramInt, Bundle paramBundle)
  {
    this.a.b.cE(paramBundle);
  }
  
  public void q(int paramInt, Bundle paramBundle)
  {
    this.a.b.q(paramInt, paramBundle);
  }
  
  public void r(int paramInt, Bundle paramBundle)
  {
    this.a.b.r(paramInt, paramBundle);
  }
  
  public void s(int paramInt, Bundle paramBundle)
  {
    this.a.b.s(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwk
 * JD-Core Version:    0.7.0.1
 */