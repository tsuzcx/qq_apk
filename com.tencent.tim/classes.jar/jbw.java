import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class jbw
  implements AdapterView.OnItemClickListener
{
  public jbw(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    Intent localIntent;
    String str;
    if (this.a.Xp)
    {
      localObject = (VideoController.b)this.a.iM.get(paramInt);
      localIntent = new Intent(this.a, QQBrowserActivity.class);
      localObject = String.valueOf(((VideoController.b)localObject).uin);
      str = this.a.mApp.getCurrentAccountUin();
      if (((String)localObject).equals(str))
      {
        localObject = "https://qvideo.qq.com/mobile/client/level/detail.html?_bid=2176&uin=" + str;
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("isShowAd", false);
        this.a.startActivity(localIntent);
        anot.a(null, "P_CliOper", "Grp_qiqiqun", "", "show_member", "Clk_people", 0, 0, "" + this.a.a.kJ, "" + this.a.mApp.getCurrentAccountUin(), "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject = "https://qvideo.qq.com/mobile/client/level/pk.html?_bid=2176&my=" + str + "&pk=" + (String)localObject;
      break;
      localObject = (VideoController.b)this.a.iM.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("MultiVideoMembersListviewAvtivity", 2, "onItemClick # mRelationUinStr = " + this.a.Ry + " # memberUin = " + String.valueOf(((VideoController.b)localObject).uin));
      }
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.GaudioOpenTroopCard");
      localIntent.putExtra("troopUin", this.a.Ry);
      localIntent.putExtra("memberUin", String.valueOf(((VideoController.b)localObject).uin));
      localIntent.putExtra("uinType", this.a.mUinType);
      localIntent.setPackage(this.a.mApp.getApplication().getPackageName());
      this.a.mApp.getApp().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbw
 * JD-Core Version:    0.7.0.1
 */