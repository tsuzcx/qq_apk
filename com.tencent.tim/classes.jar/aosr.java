import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aosr
  extends AsyncTask<Void, Void, String>
{
  public aosr(MediaPreviewActivity paramMediaPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.x.saveTo(this.val$targetPath);
      if (paramVarArgs != null)
      {
        aqhu.cn(this.this$0, paramVarArgs);
        return this.this$0.getString(2131696988) + " " + paramVarArgs;
      }
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoPreviewActivity", 2, QLog.getStackTraceString(paramVarArgs));
        }
        paramVarArgs = null;
      }
    }
    return this.this$0.getString(2131696986);
  }
  
  protected void onPostExecute(String paramString)
  {
    QQToast.a(this.this$0, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosr
 * JD-Core Version:    0.7.0.1
 */