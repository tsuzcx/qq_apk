import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;

public class vhe
  implements View.OnClickListener
{
  public vhe(MainFragment paramMainFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.val$dialog.findViewById(2131364575)).isChecked();
    this.this$0.aQW = bool;
    SettingCloneUtil.writeValue(this.this$0.getActivity(), MainFragment.a(this.this$0).getCurrentAccountUin(), this.this$0.getString(2131718627), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.A(this.this$0.getActivity(), this.this$0.aQW);
    int i = MainFragment.a(this.this$0).b().bl();
    int j = MainFragment.a(this.this$0).a().HD();
    Object localObject = this.this$0.getActivity().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.this$0.bFv();
    MainFragment.a(this.this$0).aQW = this.this$0.aQW;
    MainFragment.aYv = true;
    if (QQPlayerService.isPlaying())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.this$0.getActivity().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.this$0.getActivity(), MainFragment.a(this.this$0).getCurrentAccountUin(), true);
    this.this$0.getActivity().finish();
    anot.a(MainFragment.a(this.this$0), "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhe
 * JD-Core Version:    0.7.0.1
 */