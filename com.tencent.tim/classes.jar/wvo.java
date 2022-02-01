import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class wvo
  implements wvs
{
  private BaseChatPie mBaseChatPie;
  
  public wvo(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  public static boolean a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass)
  {
    Intent localIntent1 = paramActivity.getIntent();
    if (!localIntent1.getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("back_for_hidden_chat", true);
    localIntent2.setFlags(603979776);
    localIntent1.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.startForResult(paramActivity, localIntent1, paramClass, -1);
    paramActivity.overridePendingTransition(2130772000, 2130772001);
    return true;
  }
  
  public static boolean a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramInt == 1) && (c(paramString, paramQQAppInterface))) {}
    while ((paramInt == 0) && (b(paramString, paramQQAppInterface))) {
      return true;
    }
    return false;
  }
  
  public static boolean b(Activity paramActivity, Class<?> paramClass)
  {
    if (!paramActivity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("back_for_hidden_chat", true);
    paramClass.setFlags(603979776);
    paramActivity.startActivity(paramClass);
    paramActivity.overridePendingTransition(2130772000, 2130772001);
    return true;
  }
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface)
  {
    ExtensionInfo localExtensionInfo = ((acff)paramQQAppInterface.getManager(51)).a(String.valueOf(paramString));
    paramQQAppInterface = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramQQAppInterface = new ExtensionInfo();
      paramQQAppInterface.uin = String.valueOf(paramString);
    }
    return paramQQAppInterface.hiddenChatSwitch == 1;
  }
  
  public static boolean c(Activity paramActivity, Class<?> paramClass)
  {
    if (!paramActivity.getIntent().getBooleanExtra("back_for_hidden_chat", false)) {
      return false;
    }
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.setFlags(603979776);
    paramClass.putExtra("tab_index", MainFragment.bIk);
    paramClass.putExtra("fragment_id", 1);
    paramActivity.startActivity(paramClass);
    paramActivity.overridePendingTransition(2130772000, 2130772001);
    return true;
  }
  
  public static boolean c(String paramString, QQAppInterface paramQQAppInterface)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    paramQQAppInterface = localTroopInfo;
    if (localTroopInfo == null)
    {
      paramQQAppInterface = new TroopInfo();
      paramQQAppInterface.troopuin = paramString;
    }
    return TroopInfo.isCmdUinFlagEx2Open(paramQQAppInterface.cmdUinFlagEx2, 512);
  }
  
  public int[] C()
  {
    return new int[] { 8 };
  }
  
  public void Ck(int paramInt)
  {
    if ((paramInt == 8) && (a(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.app))) {
      anot.a(null, "dc00898", "", "", "0X800A34E", "0X800A34E", this.mBaseChatPie.mActivity.getIntent().getIntExtra("hidden_aio_msg_source", 999), 0, "0", "0", "", "");
    }
  }
  
  public boolean Sb()
  {
    boolean bool = a(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.app);
    if (bool)
    {
      Intent localIntent = this.mBaseChatPie.mActivity.getIntent();
      if (localIntent.getIntExtra("entrance", 0) == 2) {
        localIntent.putExtra("FromType", 2);
      }
      localIntent.putExtra("back_for_hidden_chat", true);
      a(this.mBaseChatPie.mActivity, HiddenChatFragment.class);
      localIntent.removeExtra("back_for_hidden_chat");
    }
    return bool;
  }
  
  public boolean c(QQMessageFacade.Message paramMessage)
  {
    if (a(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.app)) {
      return true;
    }
    return a(paramMessage.frienduin, paramMessage.istroop, this.mBaseChatPie.app);
  }
  
  public void ccu()
  {
    if (a(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.app)) {
      anot.a(null, "dc00898", "", "", "0X800A34F", "0X800A34F", 0, 0, "0", "0", "", "");
    }
  }
  
  public void cn(Intent paramIntent)
  {
    if (a(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.app)) {
      paramIntent.putExtra("hidden_aio_msg_source", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvo
 * JD-Core Version:    0.7.0.1
 */