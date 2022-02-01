import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;

public class ucu
  implements View.OnClickListener
{
  public ucu(AccountManageActivity paramAccountManageActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.val$dialog.findViewById(2131364575)).isChecked();
    this.this$0.aQW = bool;
    SettingCloneUtil.writeValue(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), this.this$0.getString(2131718627), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.A(this.this$0.getActivity(), this.this$0.aQW);
    int i = this.this$0.app.b().bl();
    int j = this.this$0.app.a().HD();
    Object localObject = this.this$0.getActivity().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.this$0.bFv();
    this.this$0.app.aQW = this.this$0.aQW;
    com.tencent.mobileqq.activity.MainFragment.aYv = true;
    if (QQPlayerService.isPlaying())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.this$0.getActivity().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.this$0.getActivity(), this.this$0.app.getCurrentAccountUin(), true);
    localObject = new Intent("QQ_ACTION_MENU_QUIT");
    ((Intent)localObject).setClass(this.this$0.getActivity(), SplashActivity.class);
    ((Intent)localObject).addFlags(67108864);
    try
    {
      this.this$0.startActivity((Intent)localObject);
      label275:
      anot.a(this.this$0.app, "CliOper", "", "", "0X800932A", "0X800932A", 0, 0, "0", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label275;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucu
 * JD-Core Version:    0.7.0.1
 */