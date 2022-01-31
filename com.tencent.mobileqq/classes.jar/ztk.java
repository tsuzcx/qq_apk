import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.data.DeviceMsgHandle.3;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ztk
  extends alko
{
  public static final String a;
  public static String b;
  public static HashMap<String, List<MessageRecord>> b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  alxu jdField_a_of_type_Alxu = new ztn(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ztm(this);
  public HashMap<String, List<zqp>> a;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap<Long, MessageRecord> a;
  public zqi a;
  private zqp jdField_a_of_type_Zqp = new ztl(this);
  public zte a;
  private zti jdField_a_of_type_Zti;
  public ztj a;
  private List<Long> b;
  public ConcurrentHashMap<Long, MessageRecord> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = MessageForDeviceFile.class.getSimpleName();
    jdField_b_of_type_JavaLangString = "FileMsg";
    c = "CloudPrintMsg";
    d = "ImgMsg";
    e = "VideoMsg";
    f = "AudioMsg";
    g = "Device";
    h = "7000-NASDevPushFile";
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ztk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Zqp);
    this.jdField_a_of_type_Zti = new zti(paramQQAppInterface);
    this.jdField_a_of_type_Zte = new zte(paramQQAppInterface);
    this.jdField_a_of_type_Zqi = new zqi();
    this.jdField_a_of_type_Ztj = new ztj(paramQQAppInterface);
    a(f, this.jdField_a_of_type_Zqi);
    a(e, this.jdField_a_of_type_Zqi);
    a(g, this.jdField_a_of_type_Zqi);
    a(g, this.jdField_a_of_type_Zte);
    a(g, this.jdField_a_of_type_Ztj);
    a(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Zti);
    a(c, this.jdField_a_of_type_Zti);
    a(d, this.jdField_a_of_type_Zti);
    a(h, this.jdField_a_of_type_Zti);
    a("8000-NASDevMusicFile", this.jdField_a_of_type_Zti);
    a("8001-NASDevVideoFile", this.jdField_a_of_type_Zti);
    a("8002-NASDevDocumentFile", this.jdField_a_of_type_Zti);
    a("8003-NASDevCommonFile", this.jdField_a_of_type_Zti);
    a("", this.jdField_a_of_type_Zti);
    a("", this.jdField_a_of_type_Zqi);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("SmartDevice_DeviceUnBindRst");
    localIntentFilter.addAction("SmartDevice_DeviceAdminUnbind");
    localIntentFilter.addAction("DeviceSomebodyJoin");
    localIntentFilter.addAction("DeviceSomebodyQuit");
    localIntentFilter.addAction("DeviceSomebodyReject");
    localIntentFilter.addAction("SmartDevice_receiveDPMsg");
    localIntentFilter.addAction("SmartDevice_DeviceVasFlagChange");
    localIntentFilter.addAction("SmartDevice_QueryIsDeviceBinded");
    localIntentFilter.addAction("SmartDevice_sendCCDataPointMsgResult");
    localIntentFilter.addAction("SmartDevice_OnMiniFileTransferProgress");
    localIntentFilter.addAction("SmartDevice_OnMiniFileTransferComplete");
    localIntentFilter.addAction("SmartDevice_OnDataPointFileMsgProgress");
    localIntentFilter.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    localIntentFilter.addAction("SmartDevice_DeviceBindRst");
    localIntentFilter.addAction("On_OccupyMicrophoneNotify_Push");
    localIntentFilter.addAction("SmartDevice_sendToAIO_Capture");
    localIntentFilter.addAction("SmartDevice_sendToAIO_Mp4");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.smartdevice.permission.broadcast", null);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alxu);
    paramQQAppInterface = (alxt)paramQQAppInterface.a(34);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DeviceMsgHandle init success!");
    }
  }
  
  public static MessageRecord a(String paramString, long paramLong)
  {
    List localList = (List)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localList == null) {
      return null;
    }
    paramString = null;
    int i = 0;
    for (;;)
    {
      if (i < localList.size())
      {
        paramString = (MessageRecord)localList.get(i);
        if (paramString.uniseq == paramLong) {
          localList.remove(i);
        }
      }
      else
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  private void a()
  {
    DeviceInfo[] arrayOfDeviceInfo = ((zpa)this.app.a(51)).a();
    if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
      this.app.a(1, true, true);
    }
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)ayvw.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.app.getCurrentAccountUin();
    localMessageForDeviceText.senderuin = String.valueOf(paramLong1);
    localMessageForDeviceText.frienduin = paramString1;
    localMessageForDeviceText.msg = paramString2;
    localMessageForDeviceText.time = paramLong2;
    if (paramBoolean) {
      localMessageForDeviceText.extStr = "device_groupchat";
    }
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceText);
    a(paramString1);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    paramString4 = ndp.a(paramString4, 45, "UTF-8", "...");
    paramString5 = ndp.a(paramString5, 90, "UTF-8", "...");
    String str = acew.f + "http://maps.google.com/maps?q=" + paramString2 + "," + paramString3 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
    if (!paramContext.getResources().getString(2131696567).equals(paramString4)) {}
    for (paramContext = paramContext.getResources().getString(2131691348) + " " + paramString4;; paramContext = paramContext.getResources().getString(2131691348))
    {
      paramString2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString2 + "&lon=" + paramString3 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramContext = new azqg(StructMsgForGeneralShare.class).c(32).a(paramContext).d(str).a("plugin", paramString2, paramString2, paramString2, paramString2).a();
      paramString2 = azqt.a(2);
      paramString2.a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramContext.addItem(paramString2);
      paramContext = ayvw.a(this.app, this.app.getCurrentAccountUin(), paramString1, this.app.getCurrentAccountUin(), 9501, 100L, paramContext);
      this.app.a().a(paramContext, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject = (List)jdField_b_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin);
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramMessageRecord);
      jdField_b_of_type_JavaUtilHashMap.put(paramMessageRecord.frienduin, localObject);
      return;
    }
    ((List)localObject).add(paramMessageRecord);
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new DeviceMsgHandle.3(this, paramString), 0L);
  }
  
  private void a(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.app.a().a(paramList, this.app.getCurrentAccountUin());
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  private boolean a(String paramString)
  {
    bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("nodisturb", 0);
        if (i != 1) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    paramString.extraflag = 32768;
    this.app.a().a(paramString.frienduin, paramString.istroop, paramString.uniseq);
    String str = paramString.frienduin;
    int i = paramString.istroop;
    paramLong = paramString.uniseq;
    ((MessageHandler)this.app.a(0)).notifyUI(MessageHandler.a(paramString.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(paramLong) });
  }
  
  public zqi a()
  {
    return this.jdField_a_of_type_Zqi;
  }
  
  public zte a()
  {
    return this.jdField_a_of_type_Zte;
  }
  
  public zti a()
  {
    return this.jdField_a_of_type_Zti;
  }
  
  public ztj a()
  {
    return this.jdField_a_of_type_Ztj;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      Object localObject = new JSONObject(paramDataPoint.mValue);
      long l = ((JSONObject)localObject).optLong("msg_time", ayvc.a());
      localObject = ((JSONObject)localObject).optString("text", " ");
      a(Long.toString(paramDataPoint.mDin), (String)localObject, l, null);
      return;
    }
    catch (Exception paramDataPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramDataPoint.getMessage());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForDeviceText paramMessageForDeviceText)
  {
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForDeviceText.uniseq);
    if ("device_groupchat".equals(paramMessageForDeviceText.extStr)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, paramSessionInfo, paramMessageForDeviceText.msg, bool);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = bdal.a(paramString, 560, 20, null, new ArrayList());
    int i = 0;
    if (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      paramString = "";
      if (str1 != null) {
        paramString = ayvy.a(str1, true, null);
      }
      int j = (int)ayvc.a();
      str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      long l = ayvy.a(i);
      MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)ayvw.a(-4508);
      localMessageForDeviceText.init(str1, paramSessionInfo.jdField_a_of_type_JavaLangString, str2, paramString, j, -4508, paramSessionInfo.jdField_a_of_type_Int, i);
      localMessageForDeviceText.longMsgCount = localArrayList.size();
      localMessageForDeviceText.longMsgIndex = ((byte)i);
      localMessageForDeviceText.longMsgId = i;
      localMessageForDeviceText.isread = true;
      localMessageForDeviceText.msgUid = l;
      localMessageForDeviceText.shmsgseq = ayvy.a(i, paramSessionInfo.jdField_a_of_type_Int);
      localMessageForDeviceText.issend = 1;
      localMessageForDeviceText.mAnimFlag = true;
      if (paramBoolean) {
        localMessageForDeviceText.extStr = "device_groupchat";
      }
      if (!bdee.g(BaseApplicationImpl.getContext())) {
        localMessageForDeviceText.extraflag = 32768;
      }
      paramQQAppInterface.a().a(localMessageForDeviceText, str1);
      a(localMessageForDeviceText);
      if (localMessageForDeviceText.extraflag == 32768) {}
      for (;;)
      {
        if (localMessageForDeviceText.extraflag != 32768)
        {
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          ((zpa)paramQQAppInterface.a(51)).a(localMessageForDeviceText.msg, Long.parseLong(localMessageForDeviceText.frienduin), l, localMessageForDeviceText.msgseq);
        }
        i += 1;
        break;
        paramQQAppInterface.a().d(localMessageForDeviceText);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)ayvw.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.app.getCurrentAccountUin();
    localMessageForDeviceText.senderuin = paramString1;
    localMessageForDeviceText.frienduin = paramString1;
    localMessageForDeviceText.msg = paramString2;
    localMessageForDeviceText.time = paramLong;
    localMessageForDeviceText.extStr = paramString3;
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceText);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    int i = 0;
    MessageForGrayTips localMessageForGrayTips;
    switch (paramInt)
    {
    default: 
      paramInt = i;
      localMessageForGrayTips = (MessageForGrayTips)ayvw.a(paramInt);
      localMessageForGrayTips.init(this.app.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong, paramInt, 9501, paramLong);
      localMessageForGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      localMessageForGrayTips.issend = paramInt;
      paramString1 = new ArrayList();
      paramString1.add(localMessageForGrayTips);
      a(paramString1);
      return;
      paramInt = -4505;
      break;
      paramInt = -4507;
      break;
      paramInt = -4506;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageForNewGrayTips localMessageForNewGrayTips;
    if (paramBoolean3)
    {
      i = -5001;
      localMessageForNewGrayTips = (MessageForNewGrayTips)ayvw.a(i);
      localMessageForNewGrayTips.init(this.app.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong, i, 9501, paramLong);
      localMessageForNewGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break label104;
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      localMessageForNewGrayTips.issend = i;
      localMessageForNewGrayTips.spans = null;
      localMessageForNewGrayTips.updateMsgData();
      paramString1 = new ArrayList();
      paramString1.add(localMessageForNewGrayTips);
      a(paramString1);
      return;
      i = -5000;
      break;
    }
  }
  
  public boolean a(String paramString, zqp paramzqp)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (!((List)localObject).contains(paramzqp)) {
      ((List)localObject).add(paramzqp);
    }
    return true;
  }
  
  public boolean b(String paramString, zqp paramzqp)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.remove(paramzqp);
    }
    return true;
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return alkr.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(f, this.jdField_a_of_type_Zqi);
    b(e, this.jdField_a_of_type_Zqi);
    b(g, this.jdField_a_of_type_Zqi);
    b(g, this.jdField_a_of_type_Zte);
    b(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Zti);
    b(c, this.jdField_a_of_type_Zti);
    b(d, this.jdField_a_of_type_Zti);
    b(h, this.jdField_a_of_type_Zti);
    b("8000-NASDevMusicFile", this.jdField_a_of_type_Zti);
    b("8001-NASDevVideoFile", this.jdField_a_of_type_Zti);
    b("8002-NASDevDocumentFile", this.jdField_a_of_type_Zti);
    b("8003-NASDevCommonFile", this.jdField_a_of_type_Zti);
    b("", this.jdField_a_of_type_Zti);
    b("", this.jdField_a_of_type_Zqi);
    this.app.removeObserver(this.jdField_a_of_type_Zqp);
    this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.app.removeObserver(this.jdField_a_of_type_Alxu);
    this.jdField_a_of_type_Zti = null;
    this.jdField_a_of_type_Zte = null;
    this.jdField_a_of_type_Zqi = null;
    this.jdField_a_of_type_Ztj = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ztk
 * JD-Core Version:    0.7.0.1
 */