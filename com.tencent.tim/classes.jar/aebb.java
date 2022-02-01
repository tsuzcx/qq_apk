import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCResult;

public class aebb
  extends QIPCModule
  implements Handler.Callback
{
  private static aebb jdField_a_of_type_Aebb;
  private aeba jdField_a_of_type_Aeba;
  private boolean bSO;
  private BroadcastReceiver bc;
  
  private aebb()
  {
    super("ColorNoteIPCServer");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Aeba = new aeba(localQQAppInterface, localQQAppInterface.a().a());
    cB(localQQAppInterface);
    this.bSO = true;
  }
  
  public static aebb a()
  {
    if (jdField_a_of_type_Aebb == null) {}
    try
    {
      if (jdField_a_of_type_Aebb == null) {
        jdField_a_of_type_Aebb = new aebb();
      }
      return jdField_a_of_type_Aebb;
    }
    finally {}
  }
  
  private void cB(QQAppInterface paramQQAppInterface)
  {
    this.bc = new aebc(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    paramQQAppInterface.getApp().registerReceiver(this.bc, localIntentFilter);
  }
  
  private void cVE()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      aebo localaebo = localQQAppInterface.a().a();
      this.jdField_a_of_type_Aeba.setApp(localQQAppInterface);
      this.jdField_a_of_type_Aeba.a(localaebo);
    }
  }
  
  private void cVF()
  {
    this.jdField_a_of_type_Aeba.setApp(null);
    this.jdField_a_of_type_Aeba.a(null);
  }
  
  EIPCResult b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("extra_unikey");
    boolean bool = this.jdField_a_of_type_Aeba.lq(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_is_colornote_exists", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult c(Bundle paramBundle)
  {
    boolean bool = this.jdField_a_of_type_Aeba.z(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_add_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public void cOY()
  {
    cVE();
    if (!this.bSO)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        cB(localQQAppInterface);
        this.bSO = true;
      }
    }
  }
  
  EIPCResult d(Bundle paramBundle)
  {
    String str = paramBundle.getString("extra_unikey");
    int i = paramBundle.getInt("color_note_extra_type");
    boolean bool = this.jdField_a_of_type_Aeba.W(str, i);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_delete_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult e(Bundle paramBundle)
  {
    boolean bool = this.jdField_a_of_type_Aeba.agl();
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_can_add_colornote", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult f(Bundle paramBundle)
  {
    String str = paramBundle.getString("extra_unikey");
    boolean bool = paramBundle.getBoolean("extra_update_colornote_state");
    return EIPCResult.createResult(0, this.jdField_a_of_type_Aeba.a(str, bool));
  }
  
  public void ff()
  {
    cVF();
    if (this.bSO)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        localQQAppInterface.getApp().unregisterReceiver(this.bc);
        this.bSO = false;
      }
    }
  }
  
  EIPCResult g(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("extra_unikey");
    String str2 = paramBundle.getString("extra_field_name");
    paramBundle = paramBundle.getString("extra_field_value");
    boolean bool = this.jdField_a_of_type_Aeba.p(str1, str2, paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_update_colornote_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  EIPCResult h(Bundle paramBundle)
  {
    paramBundle = (ColorNote)paramBundle.getSerializable("color_note_recently_viewed_comparator");
    boolean bool = this.jdField_a_of_type_Aeba.e(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putBoolean("color_note_clear_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  EIPCResult i(Bundle paramBundle)
  {
    boolean bool = aedc.jc(paramBundle.getInt("color_note_service_type"));
    paramBundle = new Bundle();
    paramBundle.putBoolean("extra_clear_history_succ", bool);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!aqmr.isEmpty(paramString))
    {
      if (!paramString.equalsIgnoreCase("cmd_query_isexists")) {
        break label33;
      }
      localObject1 = b(paramBundle);
    }
    label33:
    do
    {
      return localObject1;
      if (paramString.equalsIgnoreCase("cmd_add_colornote")) {
        return c(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_delete_colornote")) {
        return d(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_can_add_colornote")) {
        return e(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_update_colornote_state")) {
        return f(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_update_colornote")) {
        return g(paramBundle);
      }
      if (paramString.equalsIgnoreCase("cmd_clear_color_note")) {
        return h(paramBundle);
      }
      localObject1 = localObject2;
    } while (!paramString.equalsIgnoreCase("cmd_clear_history_color_notes"));
    return i(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebb
 * JD-Core Version:    0.7.0.1
 */