import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.3;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.4;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.7;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

public class aicu
  implements aihd, Manager
{
  private static UpgradeablePluginManager jdField_a_of_type_ComTencentHydevteamPluginframeworkPluginmanagerUpgradeablePluginManager = new UpgradeablePluginManager(aidq.f(BaseApplicationImpl.getContext()), "group_video", aida.aoS());
  private int QV;
  private arhz jdField_a_of_type_Arhz;
  private final aicj jdField_b_of_type_Aicj = new aicj();
  private INetEventHandler jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new aicz(this);
  private volatile boolean cjR;
  private volatile QQAppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public aicu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    AppNetConnInfo.registerNetChangeReceiver(this.mApp.getApp(), this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    aigi.a().z(paramQQAppInterface);
    this.jdField_b_of_type_Aicj.z(paramQQAppInterface);
  }
  
  private aicu.b a(String paramString1, String paramString2, String paramString3)
  {
    aicu.b localb = new aicu.b(null);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("0")))
    {
      localb.dcY = 0;
      localb.bMS = paramString2;
      return localb;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals("0")))
    {
      localb.dcY = 2;
      localb.bMS = paramString1;
      return localb;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals("0")))
    {
      localb.dcY = 1;
      localb.bMS = paramString3;
      return localb;
    }
    localb.bMS = "0";
    localb.dcY = 0;
    QLog.e("GroupVideoManager", 2, "房间号没有给");
    return localb;
  }
  
  private void a(aicu.c paramc, aihf paramaihf)
  {
    this.jdField_b_of_type_Aicj.a(paramaihf);
    QLog.i("GroupVideoManager", 2, "receive watchTogetherParam: " + paramc.toString());
    paramaihf = new JsonObject();
    paramaihf.addProperty("isTogetherWatch", Boolean.valueOf(true));
    paramaihf.addProperty("fromGroupId", Long.valueOf(Long.parseLong(paramc.bMW)));
    paramaihf.addProperty("fromGroupOwnerUin", Long.valueOf(Long.parseLong(paramc.bMX)));
    paramaihf.addProperty("fromGroupName", aqgv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramc.bMW, false));
    paramaihf.addProperty("sKey", i(this.mApp));
    aicu.b localb = a(paramc.roomId, paramc.bMU, paramc.bMT);
    a(paramc.context, paramc.uin, localb.bMS, paramc.bMV, paramc.openType, localb.dcY, paramaihf.toString());
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    Object localObject = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
    ((Intent)localObject).putExtra("isPreload", true);
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
    localObject = (aifl)this.mApp.getManager(306);
    localObject = new Intent(paramContext, ODLoadingActivity.class);
    ((Intent)localObject).putExtra("bizType", "GVideo");
    ((Intent)localObject).putExtra("plugin_id", "Od");
    ((Intent)localObject).putExtra("appid", "1104763709");
    ((Intent)localObject).putExtra("authtype", 1);
    ((Intent)localObject).putExtra("isGroupCode", paramInt);
    ((Intent)localObject).putExtra("roomCodeType", paramInt);
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("roomid", Long.valueOf(paramString2));
    ((Intent)localObject).putExtra("fromId", paramString3);
    ((Intent)localObject).putExtra("extra", paramString5);
    ((Intent)localObject).putExtra("ts_click_millisecond", System.currentTimeMillis());
    ((Intent)localObject).putExtra("openType", paramString4);
    ((Intent)localObject).putExtra("show_status_bar", true);
    ((Intent)localObject).setFlags(268435456);
    try
    {
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("prefs_key_gvideo_roominfo_entry_" + paramString1, ((Intent)localObject).toUri(4)).commit();
      paramContext.startActivity((Intent)localObject);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("GroupVideoManager", 2, paramString1.getMessage());
      }
    }
  }
  
  public static void a(String paramString, aicu.a parama)
  {
    ThreadManager.executeOnFileThread(new GroupVideoManager.7(paramString, parama));
  }
  
  private void b(Bundle paramBundle, aihf paramaihf)
  {
    this.jdField_b_of_type_Aicj.a(paramBundle, paramaihf);
  }
  
  private void bF()
  {
    if (this.jdField_a_of_type_Arhz != null)
    {
      this.jdField_a_of_type_Arhz.dismiss();
      Context localContext2 = this.jdField_a_of_type_Arhz.getContext();
      Context localContext1 = localContext2;
      if ((localContext2 instanceof ContextWrapper)) {
        localContext1 = ((ContextWrapper)localContext2).getBaseContext();
      }
      if ((localContext1 instanceof JumpActivity)) {
        ((Activity)localContext1).finish();
      }
      this.jdField_a_of_type_Arhz = null;
    }
  }
  
  private void c(Bundle paramBundle, long paramLong)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle.putString("bizType", "GVideo");
      paramBundle.putString("plugin_id", "Od");
      paramBundle.putString("appid", "1104763709");
      paramBundle.putInt("authtype", 1);
      if (this.mApp != null) {
        paramBundle.putString("uin", this.mApp.getCurrentUin());
      }
      paramBundle.putBoolean("preload", true);
      ExecutorService localExecutorService = acmo.a(192);
      localExecutorService.submit(new GroupVideoManager.3(this, localExecutorService.submit(new aicw(this)), paramLong, paramBundle));
      return;
      paramBundle = new Bundle();
    }
  }
  
  private static String i(AppInterface paramAppInterface)
  {
    TicketManager localTicketManager = (TicketManager)paramAppInterface.getManager(2);
    if ((localTicketManager != null) && (!TextUtils.isEmpty(paramAppInterface.getAccount()))) {
      return localTicketManager.getSkey(paramAppInterface.getAccount());
    }
    QLog.e("GroupVideoManager", 1, "get sKey error");
    return "";
  }
  
  private static int z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("prefs_key_gvideo_entry_" + paramString, 0);
  }
  
  public void F(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null) {}
    Object localObject;
    do
    {
      int i;
      int j;
      do
      {
        return;
        localObject = paramConfig.msg_content_list.get();
        i = paramConfig.version.get();
        j = z(BaseApplicationImpl.getContext(), this.mApp.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.i("GroupVideoManager", 2, "handleDynamicConfig, version=" + i + ", oldversion=" + j);
        }
      } while (i <= j);
      localObject = ((List)localObject).iterator();
    } while (!((Iterator)localObject).hasNext());
    paramConfig = (ConfigurationService.Content)((Iterator)localObject).next();
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("GroupVideoManager", 2, "handleDynamicConfig, contentStr=" + paramConfig);
      }
      catch (UnsupportedEncodingException paramConfig)
      {
        QLog.e("GroupVideoManager", 1, "handleDynamicConfig new String error, e=" + paramConfig.toString());
      }
      paramConfig = "";
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
    }
  }
  
  public void KV(String paramString)
  {
    if (this.mApp == null) {}
    while (!aqiw.isWifiEnabled(this.mApp.getApp())) {
      return;
    }
    jjq.a().a(this.mApp, paramString, new aicv(this, paramString));
  }
  
  public void KW(boolean paramBoolean)
  {
    if (this.mApp == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = this.mApp.a().a();
          } while (localObject1 == null);
          localObject2 = ((acxw)localObject1).q(false);
        } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if (localRecentUser.getType() == 1) {
            try
            {
              ((List)localObject1).add(Long.valueOf(Long.parseLong(localRecentUser.uin)));
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        localObject2 = new GroupVideoManager.4(this, paramBoolean);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.mHandler.removeCallbacks((Runnable)localObject2);
        this.QV = 0;
      } while (this.mApp == null);
      localObject2 = (acms)this.mApp.getBusinessHandler(20);
    } while (localObject2 == null);
    ((acms)localObject2).a((List)localObject1, new aicy(this));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "updateGroupVideoStateList try count:" + this.QV);
    }
    if ((this.QV < 8) && (paramBoolean))
    {
      this.QV += 1;
      this.mHandler.postDelayed((Runnable)localObject2, 1000L);
      return;
    }
    this.QV = 0;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AVNotifyCenter localAVNotifyCenter = this.mApp.a();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = paramString1;
      if (!localAVNotifyCenter.y(paramContext, (String)localObject)) {
        break label69;
      }
      QLog.i("GroupVideoManager", 1, "openNewGroupVideoLoadPage, blocked, roomCode[" + paramString1 + "]");
    }
    for (;;)
    {
      return;
      localObject = "0";
      break;
      label69:
      localObject = new Intent(paramContext, HuayangLoadbackgroudActivity.class);
      ((Intent)localObject).putExtra("isPreload", true);
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      localObject = (aifl)this.mApp.getManager(306);
      localObject = new Intent(paramContext, ODLoadingActivity.class);
      ((Intent)localObject).putExtra("bizType", "GVideo");
      ((Intent)localObject).putExtra("plugin_id", "Od");
      ((Intent)localObject).putExtra("appid", "1104763709");
      ((Intent)localObject).putExtra("authtype", 1);
      ((Intent)localObject).putExtra("roomCodeType", paramInt);
      ((Intent)localObject).putExtra("uin", paramString2);
      ((Intent)localObject).putExtra("roomid", Long.valueOf(paramString1));
      ((Intent)localObject).putExtra("fromId", paramString4);
      ((Intent)localObject).putExtra("openType", paramString6);
      ((Intent)localObject).putExtra("action", paramString3);
      ((Intent)localObject).putExtra("backType", paramString5);
      ((Intent)localObject).putExtra("extra", paramString7);
      ((Intent)localObject).putExtra("ts_click_millisecond", System.currentTimeMillis());
      ((Intent)localObject).putExtra("show_status_bar", true);
      ((Intent)localObject).setFlags(268435456);
      try
      {
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("prefs_key_gvideo_roominfo_entry_" + paramString2, ((Intent)localObject).toUri(4)).commit();
        paramContext.startActivity((Intent)localObject);
        if (!(paramContext instanceof Activity)) {
          continue;
        }
        ((Activity)paramContext).overridePendingTransition(0, 0);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("GroupVideoManager", 2, paramString1.getMessage());
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, aidc paramaidc)
  {
    aida.a(paramContext, "com.tencent.od").a("group_video", "openGroupvideo", paramString1, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7, paramaidc);
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, aihf paramaihf)
  {
    paramBundle = new aicu.c(BaseActivity.sTopActivity, this.mApp.getCurrentUin());
    paramBundle.KZ(paramNewTogetherRoomMessageData.QD);
    paramBundle.La(paramNewTogetherRoomMessageData.bNH);
    paramBundle.KY(paramNewTogetherRoomMessageData.bNJ);
    paramBundle.setRoomId(String.valueOf(paramNewTogetherRoomMessageData.abz));
    paramBundle.KW(paramNewTogetherRoomMessageData.bNI);
    paramBundle.KX(String.valueOf(paramNewTogetherRoomMessageData.ddp));
    a(paramBundle, paramaihf);
  }
  
  public aihg b()
  {
    return this.jdField_b_of_type_Aicj.a();
  }
  
  public void b(Bundle paramBundle, long paramLong)
  {
    if (this.mApp == null) {}
    while (!aqiw.isWifiEnabled(this.mApp.getApp())) {
      return;
    }
    QLog.e("GroupVideoManager", 2, "preload in wifi");
    c(paramBundle, paramLong);
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, aihf paramaihf)
  {
    b(paramBundle, paramaihf);
  }
  
  public void d(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramNewTogetherRoomMessageData.bNJ);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("GroupVideoManager", 2, "fromId not long");
      }
    }
    QLog.i("GroupVideoManager", 2, "receive preload message: " + paramNewTogetherRoomMessageData.toString());
    c(null, l1);
  }
  
  public void e(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JsonObject localJsonObject = new JsonObject();
    localJsonObject.addProperty("sKey", i(this.mApp));
    a(paramContext, paramString1, paramString2, paramString3, paramString4, 1, localJsonObject.toString());
  }
  
  public void eu(Context paramContext)
  {
    aida.a(paramContext, "com.tencent.od").cancel();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "onDestroy");
    }
    bF();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.mHandler.removeCallbacksAndMessages(null);
    jjq.a().axo();
    eu(this.mApp.getApp());
    this.jdField_b_of_type_Aicj.unInit();
    this.mApp = null;
    aigi.destroyInstance();
  }
  
  public static abstract interface a
  {
    public abstract void KU(boolean paramBoolean);
  }
  
  static class b
  {
    String bMS;
    int dcY;
  }
  
  public static class c
  {
    String bMT = "";
    String bMU = "";
    String bMV;
    String bMW;
    String bMX;
    final Context context;
    String openType;
    String roomId = "";
    final String uin;
    
    public c(Context paramContext, String paramString)
    {
      this.context = paramContext;
      this.uin = paramString;
    }
    
    public void KW(String paramString)
    {
      this.bMT = paramString;
    }
    
    public void KX(String paramString)
    {
      this.bMU = paramString;
    }
    
    public void KY(String paramString)
    {
      this.bMV = paramString;
    }
    
    public void KZ(String paramString)
    {
      this.bMW = paramString;
    }
    
    public void La(String paramString)
    {
      this.bMX = paramString;
    }
    
    public void setRoomId(String paramString)
    {
      this.roomId = paramString;
    }
    
    @NonNull
    public String toString()
    {
      return "uin: " + this.uin + " roomId: " + this.roomId + " roomGroupCode: " + this.bMT + " roomShowNumber: " + this.bMU + " fromId: " + this.bMV + " openType: " + this.openType + " fromGroupId: " + this.bMW + " fromGroupOwnerUin: " + this.bMX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicu
 * JD-Core Version:    0.7.0.1
 */