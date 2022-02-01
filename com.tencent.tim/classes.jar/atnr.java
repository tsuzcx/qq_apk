import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.ScheduleTipsDialog;

class atnr
  extends AsyncTask<Void, Void, Boolean>
{
  atnr(atnq paramatnq, DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData) {}
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    return Boolean.valueOf(atni.cz(atnq.a(this.this$0).getApp().getApplicationContext()));
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    Intent localIntent = new Intent(atnq.a(this.this$0).getApp().getApplicationContext(), ScheduleTipsDialog.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("isforeground", paramBoolean);
    localIntent.putExtra("summaryinfo", this.a);
    atnq.a(this.this$0).getApp().getApplicationContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnr
 * JD-Core Version:    0.7.0.1
 */