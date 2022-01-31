import android.os.AsyncTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import cooperation.troop.TroopProxyActivity;
import java.util.ArrayList;

public class dwh
  extends AsyncTask
{
  public dwh(SendBottomBar paramSendBottomBar) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a).c();
    int i = SendBottomBar.a(this.a).a();
    if (i == 5)
    {
      TroopProxyActivity.a.addAll(FMDataCache.b());
      return null;
    }
    if (paramVarArgs.equals(AppConstants.T))
    {
      paramVarArgs = FMDataCache.b();
      ((DataLineHandler)SendBottomBar.a(this.a).a(8)).a(paramVarArgs);
      return null;
    }
    if (i == 1)
    {
      SendBottomBar.a(this.a).a().a(paramVarArgs);
      return null;
    }
    String str = SendBottomBar.a(this.a).d();
    SendBottomBar.a(this.a).a().a(str, paramVarArgs, i);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.c();
    FMDataCache.b();
    SendBottomBar.a(this.a);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.a(2131364058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dwh
 * JD-Core Version:    0.7.0.1
 */