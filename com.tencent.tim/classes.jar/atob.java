import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FMLocalFileActivity;
import mqq.app.MobileQQ;

public class atob
  implements View.OnClickListener
{
  public atob(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.H()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.TAG, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.aM();
      Object localObject = (atwc.a)paramView.getTag();
      if (((atwc.a)localObject).category != 0)
      {
        int i = ((atwc.a)localObject).category;
        localObject = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("last_select_All", true);
        ((SharedPreferences.Editor)localObject).commit();
        FMLocalFileActivity.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atob
 * JD-Core Version:    0.7.0.1
 */