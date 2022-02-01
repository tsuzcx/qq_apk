import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class znx
  extends QIPCModule
  implements Handler.Callback
{
  private static znx jdField_a_of_type_Znx;
  private znx.a jdField_a_of_type_Znx$a;
  private znx.a b;
  private boolean brL;
  private long by;
  private znx.a c;
  private Handler mHandler;
  
  private znx()
  {
    super("MiniMsgIPCServer");
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("mini_msg", 0);
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public static void Fq(int paramInt)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      ((znv)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(147)).i(Integer.valueOf(paramInt));
    }
  }
  
  public static znx a()
  {
    if (jdField_a_of_type_Znx == null) {}
    try
    {
      if (jdField_a_of_type_Znx == null) {
        jdField_a_of_type_Znx = new znx();
      }
      return jdField_a_of_type_Znx;
    }
    finally {}
  }
  
  private void bF(Bundle paramBundle)
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "actionMiniCreateUpdatableMsgCallback", paramBundle, null);
    }
  }
  
  private void bG(Bundle paramBundle)
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "actionMiniReportEvent", paramBundle, null);
    }
  }
  
  private void bH(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Znx$a != null)
    {
      String str1 = paramBundle.getString("param_proc_name");
      String str2 = paramBundle.getString("param_proc_modulename");
      paramBundle.getString("param_proc_businame");
      if ((str1 != null) && (str1.equals(this.jdField_a_of_type_Znx$a.getProcName())) && (str2 != null) && (str2.equals(this.jdField_a_of_type_Znx$a.getModuleName()))) {
        this.brL = false;
      }
    }
  }
  
  private void bI(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("param_proc_name");
    String str2 = paramBundle.getString("param_proc_modulename");
    int i = paramBundle.getInt("param_proc_businame");
    this.jdField_a_of_type_Znx$a = new znx.a(str1, str2);
    this.b = new znx.a(str1, "aio_client_module");
    if (("mini_app_client_module".equals(str2) | "mini_sdk_client_module".equals(str2))) {
      this.c = new znx.a(str1, str2);
    }
    this.jdField_a_of_type_Znx$a.busiID = i;
    this.brL = true;
    boolean bool = paramBundle.getBoolean("param_proc_first_start", false);
    if (QLog.isColorLevel())
    {
      QLog.d("MiniMsgIPCServer", 2, str1 + "doOnProcForeGround isFirst = " + bool);
      QLog.d("MiniMsgIPCServer", 2, "moduleName:" + str2);
    }
    if (bool) {
      cqb();
    }
  }
  
  private void bJ(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("param_proc_uin");
    int j = paramBundle.getInt("param_proc_uin_type");
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramBundle = null)
    {
      znx.a locala = this.b;
      if ((paramBundle == null) || (locala == null)) {
        break;
      }
      paramBundle = paramBundle.b();
      if (paramBundle != null) {}
      for (int i = paramBundle.m(j, str);; i = 0)
      {
        paramBundle = new Bundle();
        paramBundle.putString("param_proc_uin", str);
        paramBundle.putInt("param_proc_uin_type", j);
        paramBundle.putInt("param_proc_single_con_badge_count", i);
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_IPCServer", 2, "doNotifySingleConUnreadState uin = " + str + "; unread = " + i);
        }
        QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_sync_single_con_unread_count", paramBundle, null);
        if (this.c == null) {
          break;
        }
        QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "action_sync_single_con_unread_count", paramBundle, null);
        return;
      }
    }
  }
  
  private void cpX()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "actionMiniDirectShareFailCallback", null, null);
    }
  }
  
  private void cpY()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "actionMiniDirectShareSucCallback", null, null);
    }
  }
  
  private void cpZ()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "actionMiniShareSucCallback", null, null);
    }
  }
  
  private void cqa()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "actionMiniShareFailCallback", null, null);
    }
  }
  
  private void cqc()
  {
    long l = System.currentTimeMillis();
    if ((this.by > l) && (this.by - l < 5000L)) {
      return;
    }
    this.by = l;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      znx.a locala = this.jdField_a_of_type_Znx$a;
      if ((localObject == null) || (locala == null)) {
        break;
      }
      localObject = ((QQAppInterface)localObject).b();
      if (localObject != null) {}
      for (int i = ((QQMessageFacade)localObject).vd();; i = 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("param_proc_badge_count", i);
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_IPCServer", 2, "doNotifyUnreadState unread = " + i);
        }
        QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_sync_unreadcount", (Bundle)localObject, null);
        if (this.c == null) {
          break;
        }
        QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "action_sync_unreadcount", (Bundle)localObject, null);
        return;
      }
    }
  }
  
  private void cqe()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      znx.a locala = this.jdField_a_of_type_Znx$a;
      if ((localObject != null) && (locala != null))
      {
        localObject = new Bundle();
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_IPCServer", 2, "doNotifyGoToConversation  ");
        }
        QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_mini_msgtab_notify_to_conversation", (Bundle)localObject, null);
      }
      return;
    }
  }
  
  private void cqf()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      znx.a locala = this.jdField_a_of_type_Znx$a;
      QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).b();
      if (localQQMessageFacade != null) {}
      for (int i = localQQMessageFacade.vd();; i = 0)
      {
        if ((localObject != null) && (locala != null))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("param_proc_badge_count", i);
          if (QLog.isColorLevel()) {
            QLog.d("MiniMsgIPCServer", 2, "doNotifyUnreadState unread = " + i);
          }
          QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_msg_tab_back_refresh", (Bundle)localObject, null);
        }
        return;
      }
    }
  }
  
  private void cqg()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      znx.a locala = this.jdField_a_of_type_Znx$a;
      QQMessageFacade localQQMessageFacade = ((QQAppInterface)localObject).b();
      if (localQQMessageFacade != null) {}
      for (int i = localQQMessageFacade.vd();; i = 0)
      {
        if ((localObject != null) && (locala != null))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("param_proc_badge_count", i);
          if (QLog.isColorLevel()) {
            QLog.d("mini_msg_IPCServer", 2, "notifyGetUnread unread = " + i);
          }
          QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_get_unread", (Bundle)localObject, null);
        }
        return;
      }
    }
  }
  
  private void t(int paramInt, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if ((this.by > l) && (this.by - l < 5000L)) {
      return;
    }
    this.by = l;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      znx.a locala = this.jdField_a_of_type_Znx$a;
      if ((localObject == null) || (locala == null)) {
        break;
      }
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      for (;;)
      {
        localObject = ((QQAppInterface)localObject).b();
        if (localObject != null) {}
        for (int i = ((QQMessageFacade)localObject).vd();; i = 0)
        {
          paramBundle.putInt("param_cmd", 0);
          paramBundle.putInt("param_proc_badge_count", i);
          localObject = new EIPCResult();
          ((EIPCResult)localObject).data = paramBundle;
          callbackResult(paramInt, (EIPCResult)localObject);
          paramBundle.putInt("param_proc_badge_count", i);
          QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_sync_unreadcount", paramBundle, null);
          if (this.c != null) {
            QIPCServerHelper.getInstance().callClient(znx.a.a(this.c), znx.a.b(this.c), "action_sync_unreadcount", paramBundle, null);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MiniMsgIPCServer", 2, "doNotifyUnreadState unread = " + i);
          return;
        }
      }
    }
  }
  
  public boolean Vx()
  {
    return this.brL;
  }
  
  public znx.a a()
  {
    return this.jdField_a_of_type_Znx$a;
  }
  
  void cK(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_uin", paramString);
    localBundle.putInt("param_proc_uin_type", paramInt);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void cqb()
  {
    this.mHandler.sendEmptyMessage(3);
  }
  
  public void cqd()
  {
    this.mHandler.sendEmptyMessage(5);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      bI((Bundle)paramMessage.obj);
      continue;
      bH((Bundle)paramMessage.obj);
      continue;
      if (MiniMsgTabServerInitStep.brR)
      {
        cqc();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MiniMsgIPCServer", 2, "isAfterActionB = " + MiniMsgTabServerInitStep.brR);
        continue;
        bJ(paramMessage.getData());
        continue;
        if (MiniMsgTabServerInitStep.brR)
        {
          t(paramMessage.arg1, (Bundle)paramMessage.obj);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("MiniMsgIPCServer", 2, "isAfterActionB = " + MiniMsgTabServerInitStep.brR);
          continue;
          cqf();
          continue;
          cpZ();
          continue;
          cqa();
          continue;
          cqg();
          continue;
          cqe();
          continue;
          bG((Bundle)paramMessage.obj);
          continue;
          cpY();
          continue;
          cpX();
          continue;
          bF((Bundle)paramMessage.obj);
        }
      }
    }
  }
  
  public void notifyFromMiniAIOToAIO()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      znx.a locala = this.jdField_a_of_type_Znx$a;
      if ((localObject != null) && (locala != null))
      {
        localObject = new Bundle();
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgIPCServer", 2, "notifyFromMiniAIOToAIO ");
        }
        QIPCServerHelper.getInstance().callClient(znx.a.a(locala), znx.a.b(locala), "action_mini_aio_to_aio", (Bundle)localObject, null);
      }
      return;
    }
  }
  
  public void notifyGoToConversation()
  {
    cqe();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramBundle != null)) {
      QLog.d("MiniMsgIPCServer", 2, new Object[] { "MiniMsgIPCServer : " + paramString + ", " + paramBundle.toString(), ", " + paramInt });
    }
    Message localMessage = Message.obtain();
    localMessage.obj = paramBundle;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equalsIgnoreCase("cmd_proc_foregound")) {
        break label125;
      }
      localMessage.what = 1;
    }
    for (;;)
    {
      this.mHandler.sendMessage(localMessage);
      return null;
      label125:
      if (paramString.equalsIgnoreCase("cmd_proc_backgound"))
      {
        localMessage.what = 2;
      }
      else if (paramString.equalsIgnoreCase("cmd_refresh_mini_badge"))
      {
        localMessage.what = 4;
        localMessage.arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_msg_tab_back_refresh"))
      {
        localMessage.what = 8;
        localMessage.arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_suc"))
      {
        localMessage.what = 6;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_fail"))
      {
        localMessage.what = 7;
      }
      else if (paramString.equalsIgnoreCase("cmd_get_unread"))
      {
        localMessage.what = 8;
        localMessage.arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_clear_business"))
      {
        if (paramBundle != null) {
          Fq(paramBundle.getInt("PARAM_CMD_BUSIID"));
        }
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_report_event"))
      {
        localMessage.what = 10;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_direct_share_suc"))
      {
        localMessage.what = 12;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_direct_share_fail"))
      {
        localMessage.what = 13;
      }
      else if (paramString.equals("cmd_mini_create_updatable_msg_callback"))
      {
        localMessage.what = 14;
      }
    }
  }
  
  public static class a
  {
    private String bap;
    public int busiID;
    private String mModuleName;
    
    public a(String paramString1, String paramString2)
    {
      this.bap = paramString1;
      this.mModuleName = paramString2;
    }
    
    public String getModuleName()
    {
      return this.mModuleName;
    }
    
    public String getProcName()
    {
      return this.bap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znx
 * JD-Core Version:    0.7.0.1
 */