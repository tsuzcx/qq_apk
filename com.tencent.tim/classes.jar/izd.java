import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class izd
  implements View.OnClickListener
{
  izd(izc paramizc) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    izc.a locala = (izc.a)paramView.getTag();
    if (izc.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8009E26", "0X8009E26", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMemberListCtrl", 2, "onItemClick # mRelationUinStr = " + this.a.md + " # memberUin = " + String.valueOf(locala.uin));
    }
    izc.a(this.a).getCurrentAccountUin();
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.GaudioOpenTroopCard");
    localIntent.putExtra("troopUin", String.valueOf(this.a.md));
    localIntent.putExtra("memberUin", String.valueOf(locala.uin));
    if (this.a.aqx == 1) {
      i = 1000;
    }
    for (;;)
    {
      localIntent.putExtra("uinType", i);
      localIntent.setPackage(izc.a(this.a).getApplication().getPackageName());
      izc.a(this.a).getApp().sendBroadcast(localIntent);
      break;
      if (this.a.aqx == 2) {
        i = 1004;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izd
 * JD-Core Version:    0.7.0.1
 */