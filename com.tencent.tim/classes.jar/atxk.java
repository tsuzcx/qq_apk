import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atxk
  implements View.OnClickListener
{
  atxk(String paramString, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    acde localacde = (acde)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(8);
    if (!aueh.fileExistsAndNotEmpty(this.bIW)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localacde.b.B(audx.getFileName(this.bIW))) {
        if (!localacde.b.Y()) {
          this.val$activity.startActivity(new Intent(this.val$activity, PrinterDefaultActivity.class));
        } else {
          localacde.a.a((BaseActivity)this.val$activity, this.bIW);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxk
 * JD-Core Version:    0.7.0.1
 */