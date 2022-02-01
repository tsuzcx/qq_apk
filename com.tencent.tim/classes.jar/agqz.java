import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqz
  implements View.OnClickListener
{
  agqz(String paramString, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    acde localacde = (acde)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(8);
    if (!ahbj.fileExistsAndNotEmpty(this.bIW)) {}
    label152:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localacde.b.B(ahav.getFileName(this.bIW)))
      {
        Activity localActivity = this.c.getActivity();
        if (!localacde.b.Y()) {
          localActivity.startActivity(new Intent(localActivity, PrinterDefaultActivity.class));
        }
        for (;;)
        {
          if (!this.c.bY()) {
            break label152;
          }
          long l = this.c.a().fR();
          ahav.l(this.c.getApp(), l);
          break;
          localacde.a.a((BaseActivity)localActivity, this.bIW);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqz
 * JD-Core Version:    0.7.0.1
 */