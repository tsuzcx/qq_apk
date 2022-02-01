import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tim.dingdong.DingdongPluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

final class atnj
  extends AsyncTask<Void, Void, Boolean>
{
  atnj(Intent paramIntent, int paramInt) {}
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    return Boolean.valueOf(atni.cy(BaseApplicationImpl.getApplication().getRuntime().getApplication()));
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = BaseApplicationImpl.getApplication().getRuntime();
      Intent localIntent = new Intent(this.val$intent);
      localIntent.putExtra("_inner_cmd_", this.qA);
      DingdongPluginProxyBroadcastReceiver.c(paramBoolean, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnj
 * JD-Core Version:    0.7.0.1
 */