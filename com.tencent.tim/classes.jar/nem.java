import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView.a;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class nem
  implements KandianProgressView.a
{
  public nem(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup) {}
  
  public void aK(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID");
    ReadInJoyBaseListViewGroup.a(this.c, str);
    mit.aD(paramBundle);
  }
  
  public void f(String paramString, Bundle paramBundle)
  {
    paramString = this.c.getCurrentActivity();
    Intent localIntent;
    if ((paramBundle != null) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localIntent.setClass(paramString, KandianVideoUploadService.class);
    }
    try
    {
      paramString.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("KandianVideoUpload", 1, "Kandian retryFail", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nem
 * JD-Core Version:    0.7.0.1
 */