import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zou
  implements View.OnClickListener
{
  public zou(AvatarPendantActivity paramAvatarPendantActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    aqrf.a(null, this.this$0, "mvip.gxh.android.faceaddon_nati_dft", this.ces, "1450000515", this.bau, this.bav, "");
    String str = "0";
    if (!TextUtils.isEmpty(this.bav)) {
      if (!"QQ会员".equals(this.bav)) {
        break label91;
      }
    }
    label91:
    for (str = "0";; str = "1")
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005FD2", "0X8005FD2", 0, 0, str, "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zou
 * JD-Core Version:    0.7.0.1
 */