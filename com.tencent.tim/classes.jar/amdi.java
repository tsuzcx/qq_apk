import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;

final class amdi
  extends AsyncTask<Void, Void, Boolean>
{
  amdi(File paramFile1, File paramFile2, Activity paramActivity, amdf.a parama) {}
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    try
    {
      if (dx.copyFile(this.aK, this.K))
      {
        aqhu.b(BaseApplicationImpl.getApplication(), this.K);
        aqhu.cn(this.val$activity, this.K.getAbsolutePath());
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryUtils", 4, "savePhoto exception = " + paramVarArgs.getMessage());
    }
    return Boolean.valueOf(false);
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if ((this.val$activity instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)this.val$activity).getTitleBarHeight();; i = 0)
    {
      if (paramBoolean.booleanValue()) {}
      for (String str = this.val$activity.getString(2131696960);; str = this.val$activity.getString(2131696986))
      {
        QQToast.a(this.val$activity, 2, str, 0).show(i);
        if (this.a != null) {
          this.a.OM(paramBoolean.booleanValue());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdi
 * JD-Core Version:    0.7.0.1
 */