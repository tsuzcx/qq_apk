import android.app.Activity;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.qphone.base.util.QLog;

public class yxy
  implements ApolloSoLoader.OnCmSoLoadCompleteCallback
{
  public yxy(CmGameLauncher paramCmGameLauncher) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    ApolloSoLoader.b(CmGameLauncher.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!CmGameLauncher.b(this.a)))
      {
        CmGameLauncher.a(this.a, true);
        this.a.a(localActivity, CmGameLauncher.a(this.a));
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxy
 * JD-Core Version:    0.7.0.1
 */