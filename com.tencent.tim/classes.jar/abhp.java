import android.os.Bundle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class abhp
  extends aquy
{
  abhp(abhh paramabhh) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + paramaquz.httpCode + ", status: " + paramaquz.getStatus());
    }
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    if (paramaquz == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramaquz.getParams();
    } while (localBundle == null);
    int i = localBundle.getInt(paramaquz.currUrl);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + paramaquz.httpCode + ", status: " + paramaquz.getStatus() + ",task.currUrl:" + paramaquz.currUrl);
    }
    if (1 == i) {}
    try
    {
      super.onDone(paramaquz);
      if (paramaquz.getStatus() != 3) {
        this.this$0.a.m(Boolean.valueOf(false));
      }
      this.this$0.Yb();
      VipUtils.a(this.this$0.mApp, "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception paramaquz)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", paramaquz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhp
 * JD-Core Version:    0.7.0.1
 */