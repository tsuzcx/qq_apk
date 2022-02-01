import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.1;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FrdCustomOnlineStatusChange;

public class aqqb
{
  private long atB;
  private String cuV = "";
  private int ebx;
  private int eby = 30000;
  private int ebz = -1;
  private final ArrayList<WeakReference<Runnable>> mListeners = new ArrayList();
  HashMap<String, Long> pb = new HashMap();
  
  public static aqqb a()
  {
    return aqqb.a.b();
  }
  
  private final void eeU()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "resetOnEnableToggle");
    }
    this.cuV = "";
    this.ebx = 0;
    this.atB = 0L;
  }
  
  private void onChange()
  {
    ThreadManager.getUIHandler().post(new CustomOnlineStatusManager.1(this));
  }
  
  public final String Ct()
  {
    if (aFv())
    {
      long l = System.currentTimeMillis();
      if (Math.abs(this.atB - l) > this.eby)
      {
        this.atB = l;
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "sync owner status");
        }
        aqqb.b.access$200();
      }
      if (aqqb.b.mE(this.ebx)) {
        return this.cuV;
      }
    }
    return "";
  }
  
  public void Vs(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.pb.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public final void a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    this.ebx = aqqb.b.b(paramCustomOnlineStatusMsg);
    this.cuV = aqqb.b.a(paramCustomOnlineStatusMsg);
    this.eby = aqqb.b.a(paramCustomOnlineStatusMsg);
    onChange();
  }
  
  public final boolean aFv()
  {
    int j = this.ebz;
    aeqq localaeqq = (aeqq)aeif.a().o(479);
    if ((localaeqq == null) || (localaeqq.bVU)) {}
    for (int i = 1;; i = 0)
    {
      this.ebz = i;
      if (j != this.ebz) {
        eeU();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "featureEnable = " + this.ebz);
      }
      if (this.ebz != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void aq(Runnable paramRunnable)
  {
    this.mListeners.add(new WeakReference(paramRunnable));
  }
  
  public boolean rC(String paramString)
  {
    if (paramString != null)
    {
      paramString = (Long)this.pb.get(paramString);
      if (paramString != null) {
        return Math.abs(System.currentTimeMillis() - paramString.longValue()) > this.eby;
      }
    }
    return true;
  }
  
  static class a
  {
    private static final aqqb a = new aqqb(null);
  }
  
  public static class b
  {
    public static void J(Activity paramActivity, String paramString)
    {
      if (paramActivity == null)
      {
        QLog.e("CustomOnlineStatusManager", 1, "activity == null");
        return;
      }
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localObject = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1";
      if ("panel".equals(paramString))
      {
        paramString = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1" + "&src=1";
        localObject = "0X8009F76";
      }
      for (;;)
      {
        VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString, 256L, localIntent, false, -1);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
        return;
        if ("settings".equals(paramString))
        {
          paramString = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1" + "&src=2";
          localObject = "0X8009F77";
        }
        else if ("aio".equals(paramString))
        {
          paramString = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1" + "&src=3";
          localObject = "0X8009F78";
        }
        else
        {
          String str = "";
          paramString = (String)localObject;
          localObject = str;
        }
      }
    }
    
    private static void Vt(String paramString)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(1);
      try
      {
        localFriendListHandler.bE(paramString, false);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("CustomOnlineStatusManager", 1, paramString, new Object[0]);
      }
    }
    
    public static int a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
    {
      if ((paramCustomOnlineStatusMsg != null) && (paramCustomOnlineStatusMsg.uUpdateInterval.get() > 0)) {
        return paramCustomOnlineStatusMsg.uUpdateInterval.get();
      }
      return 30000;
    }
    
    public static String a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
    {
      if (paramCustomOnlineStatusMsg != null) {
        try
        {
          if (paramCustomOnlineStatusMsg.uHasCustomInfo.get() == 1)
          {
            String str = paramCustomOnlineStatusMsg.sCustomDesc.get();
            paramCustomOnlineStatusMsg = paramCustomOnlineStatusMsg.sCustomModel.get();
            if ((str != null) && (paramCustomOnlineStatusMsg != null))
            {
              paramCustomOnlineStatusMsg = str + paramCustomOnlineStatusMsg;
              return paramCustomOnlineStatusMsg;
            }
          }
        }
        catch (Exception paramCustomOnlineStatusMsg)
        {
          QLog.d("CustomOnlineStatusManager", 1, paramCustomOnlineStatusMsg, new Object[0]);
        }
      }
      return "";
    }
    
    public static void a(SubMsgType0x27.FrdCustomOnlineStatusChange paramFrdCustomOnlineStatusChange)
    {
      long l = paramFrdCustomOnlineStatusChange.uint64_uin.get();
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "onPush uni = " + paramFrdCustomOnlineStatusChange.uint64_uin.get());
      }
      if (l == BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "sync owner");
        }
        eeV();
      }
      while (TextUtils.isEmpty(String.valueOf(l))) {
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "sync friend");
      }
      Vt(String.valueOf(l));
    }
    
    public static int b(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
    {
      if (paramCustomOnlineStatusMsg != null) {
        return paramCustomOnlineStatusMsg.uHasCustomInfo.get();
      }
      return 0;
    }
    
    public static String b(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
    {
      if (paramCustomOnlineStatusMsg != null) {
        try
        {
          if (paramCustomOnlineStatusMsg.uHasCustomInfo.get() == 1)
          {
            paramCustomOnlineStatusMsg = paramCustomOnlineStatusMsg.sCustomModel.get();
            if (paramCustomOnlineStatusMsg != null) {
              return paramCustomOnlineStatusMsg;
            }
          }
        }
        catch (Exception paramCustomOnlineStatusMsg)
        {
          QLog.d("CustomOnlineStatusManager", 1, paramCustomOnlineStatusMsg, new Object[0]);
        }
      }
      return "";
    }
    
    private static void eeV()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((acny)localQQAppInterface.getBusinessHandler(27)).hZ(localQQAppInterface.getLongAccountUin());
    }
    
    public static boolean mE(int paramInt)
    {
      return paramInt == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqb
 * JD-Core Version:    0.7.0.1
 */