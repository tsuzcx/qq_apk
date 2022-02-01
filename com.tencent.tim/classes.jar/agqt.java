import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqt
  implements View.OnClickListener
{
  agqt(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
    if (this.val$activity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = ahbj.getFileSize(this.val$localPath);
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if (l <= 10485760L)
      {
        int i = ahav.r(this.val$localPath);
        Bitmap localBitmap = BitmapFactory.decodeResource(this.val$activity.getResources(), i);
        localWXShareHelper.D(this.val$localPath, localBitmap);
        anot.a(null, "dc00898", "", "", "0X800AEE1", "0X800AEE1", 0, 0, "", "", "", "");
      }
      else
      {
        anot.a(null, "dc00898", "", "", "0X800AEE2", "0X800AEE2", 0, 0, "", "", "", "");
        ahal.a(this.val$activity, "", 2131700306, new agqu(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqt
 * JD-Core Version:    0.7.0.1
 */