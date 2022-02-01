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
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
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

public class szy
  extends accg
{
  public static final String TAG = MessageForDeviceFile.class.getSimpleName();
  public static String aIj = "FileMsg";
  public static String aIk = "CloudPrintMsg";
  public static String aIl = "ImgMsg";
  public static String aIm = "VideoMsg";
  public static String aIn = "AudioMsg";
  public static String aIo = "Device";
  public static String aIp = "7000-NASDevPushFile";
  public static HashMap<String, List<MessageRecord>> go = new HashMap();
  aclm jdField_a_of_type_Aclm = new tab(this);
  public szv a;
  private szw jdField_a_of_type_Szw;
  public szx a;
  private BroadcastReceiver ar = new taa(this);
  public szd b;
  private szg b;
  public ConcurrentHashMap<Long, MessageRecord> cE = new ConcurrentHashMap(10);
  public ConcurrentHashMap<Long, MessageRecord> cF = new ConcurrentHashMap(10);
  public HashMap<String, List<szg>> gn = new HashMap();
  private List<Long> pL = new ArrayList();
  private List<Long> pM = new ArrayList();
  
  public szy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Szg = new szz(this);
    paramQQAppInterface.addObserver(this.jdField_b_of_type_Szg);
    this.jdField_a_of_type_Szw = new szw(paramQQAppInterface);
    this.jdField_a_of_type_Szv = new szv(paramQQAppInterface);
    this.jdField_b_of_type_Szd = new szd();
    this.jdField_a_of_type_Szx = new szx(paramQQAppInterface);
    a(aIn, this.jdField_b_of_type_Szd);
    a(aIm, this.jdField_b_of_type_Szd);
    a(aIo, this.jdField_b_of_type_Szd);
    a(aIo, this.jdField_a_of_type_Szv);
    a(aIo, this.jdField_a_of_type_Szx);
    a(aIj, this.jdField_a_of_type_Szw);
    a(aIk, this.jdField_a_of_type_Szw);
    a(aIl, this.jdField_a_of_type_Szw);
    a(aIp, this.jdField_a_of_type_Szw);
    a("8000-NASDevMusicFile", this.jdField_a_of_type_Szw);
    a("8001-NASDevVideoFile", this.jdField_a_of_type_Szw);
    a("8002-NASDevDocumentFile", this.jdField_a_of_type_Szw);
    a("8003-NASDevCommonFile", this.jdField_a_of_type_Szw);
    a("", this.jdField_a_of_type_Szw);
    a("", this.jdField_b_of_type_Szd);
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
    paramQQAppInterface.getApp().registerReceiver(this.ar, localIntentFilter, "com.tencent.tim.smartdevice.permission.broadcast", null);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Aclm);
    paramQQAppInterface = (acll)paramQQAppInterface.getBusinessHandler(34);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.queryDevLockStatus();
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "DeviceMsgHandle init success!");
    }
  }
  
  private void M(String paramString, long paramLong)
  {
    paramString = b(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new DeviceMsgHandle.3(this, paramString), 0L);
  }
  
  private void N(String paramString, long paramLong)
  {
    paramString = b(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    paramString.extraflag = 32768;
    this.app.a().e(paramString.frienduin, paramString.istroop, paramString.uniseq);
    String str = paramString.frienduin;
    int i = paramString.istroop;
    paramLong = paramString.uniseq;
    ((MessageHandler)this.app.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramString.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(paramLong) });
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)anbi.d(-4508);
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
    fl(paramString1);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    paramString4 = jqn.a(paramString4, 45, "UTF-8", "...");
    paramString5 = jqn.a(paramString5, 90, "UTF-8", "...");
    String str = ujs.aLM + "http://maps.google.com/maps?q=" + paramString2 + "," + paramString3 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
    if (!paramContext.getResources().getString(2131698324).equals(paramString4)) {}
    for (paramContext = paramContext.getResources().getString(2131692313) + " " + paramString4;; paramContext = paramContext.getResources().getString(2131692313))
    {
      paramString2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString2 + "&lon=" + paramString3 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramContext = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(32).a(paramContext).d(str).a("plugin", paramString2, paramString2, paramString2, paramString2).a();
      paramString2 = anrd.a(2);
      paramString2.aU("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramContext.addItem(paramString2);
      paramContext = anbi.a(this.app, this.app.getCurrentAccountUin(), paramString1, this.app.getCurrentAccountUin(), 9501, 100L, paramContext);
      this.app.b().b(paramContext, this.app.getCurrentAccountUin());
      return;
    }
  }
  
  private void asB()
  {
    DeviceInfo[] arrayOfDeviceInfo = ((syw)this.app.getBusinessHandler(51)).b();
    if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
      this.app.q(1, true, true);
    }
  }
  
  public static MessageRecord b(String paramString, long paramLong)
  {
    List localList = (List)go.get(paramString);
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
  
  private void fl(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.app.b().s(paramList, this.app.getCurrentAccountUin());
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  private boolean gu(String paramString)
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
  
  public static void s(MessageRecord paramMessageRecord)
  {
    Object localObject = (List)go.get(paramMessageRecord.frienduin);
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramMessageRecord);
      go.put(paramMessageRecord.frienduin, localObject);
      return;
    }
    ((List)localObject).add(paramMessageRecord);
  }
  
  public szd a()
  {
    return this.jdField_b_of_type_Szd;
  }
  
  public szv a()
  {
    return this.jdField_a_of_type_Szv;
  }
  
  public szw a()
  {
    return this.jdField_a_of_type_Szw;
  }
  
  public szx a()
  {
    return this.jdField_a_of_type_Szx;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForDeviceText paramMessageForDeviceText)
  {
    paramQQAppInterface.b().t(paramSessionInfo.aTl, paramSessionInfo.cZ, paramMessageForDeviceText.uniseq);
    if ("device_groupchat".equals(paramMessageForDeviceText.extStr)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, paramSessionInfo, paramMessageForDeviceText.msg, bool);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = aqft.a(paramString, 560, 20, null, new ArrayList());
    int i = 0;
    if (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      paramString = "";
      if (str1 != null) {
        paramString = anbk.a(str1, true, null);
      }
      int j = (int)anaz.gQ();
      str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramSessionInfo.aTl;
      long l = anbk.I(i);
      MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)anbi.d(-4508);
      localMessageForDeviceText.init(str1, paramSessionInfo.aTl, str2, paramString, j, -4508, paramSessionInfo.cZ, i);
      localMessageForDeviceText.longMsgCount = localArrayList.size();
      localMessageForDeviceText.longMsgIndex = ((byte)i);
      localMessageForDeviceText.longMsgId = i;
      localMessageForDeviceText.isread = true;
      localMessageForDeviceText.msgUid = l;
      localMessageForDeviceText.shmsgseq = anbk.d(i, paramSessionInfo.cZ);
      localMessageForDeviceText.issend = 1;
      localMessageForDeviceText.mAnimFlag = true;
      if (paramBoolean) {
        localMessageForDeviceText.extStr = "device_groupchat";
      }
      if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
        localMessageForDeviceText.extraflag = 32768;
      }
      paramQQAppInterface.b().b(localMessageForDeviceText, str1);
      s(localMessageForDeviceText);
      if (localMessageForDeviceText.extraflag == 32768) {}
      for (;;)
      {
        if (localMessageForDeviceText.extraflag != 32768)
        {
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          ((syw)paramQQAppInterface.getBusinessHandler(51)).b(localMessageForDeviceText.msg, Long.parseLong(localMessageForDeviceText.frienduin), l, localMessageForDeviceText.msgseq);
        }
        i += 1;
        break;
        paramQQAppInterface.a().az(localMessageForDeviceText);
      }
    }
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
      localMessageForGrayTips = (MessageForGrayTips)anbi.d(paramInt);
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
      fl(paramString1);
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
      localMessageForNewGrayTips = (MessageForNewGrayTips)anbi.d(i);
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
      fl(paramString1);
      return;
      i = -5000;
      break;
    }
  }
  
  public boolean a(String paramString, szg paramszg)
  {
    List localList = (List)this.gn.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.gn.put(paramString, localObject);
    }
    if (!((List)localObject).contains(paramszg)) {
      ((List)localObject).add(paramszg);
    }
    return true;
  }
  
  public void b(DataPoint paramDataPoint)
  {
    try
    {
      Object localObject = new JSONObject(paramDataPoint.mValue);
      long l = ((JSONObject)localObject).optLong("msg_time", anaz.gQ());
      localObject = ((JSONObject)localObject).optString("text", " ");
      b(Long.toString(paramDataPoint.mDin), (String)localObject, l, null);
      return;
    }
    catch (Exception paramDataPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "onRecvRawTextMsg parse from json error:" + paramDataPoint.getMessage());
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)anbi.d(-4508);
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
    fl(paramString1);
  }
  
  public boolean b(String paramString, szg paramszg)
  {
    paramString = (List)this.gn.get(paramString);
    if (paramString != null) {
      paramString.remove(paramszg);
    }
    return true;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acci.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(aIn, this.jdField_b_of_type_Szd);
    b(aIm, this.jdField_b_of_type_Szd);
    b(aIo, this.jdField_b_of_type_Szd);
    b(aIo, this.jdField_a_of_type_Szv);
    b(aIj, this.jdField_a_of_type_Szw);
    b(aIk, this.jdField_a_of_type_Szw);
    b(aIl, this.jdField_a_of_type_Szw);
    b(aIp, this.jdField_a_of_type_Szw);
    b("8000-NASDevMusicFile", this.jdField_a_of_type_Szw);
    b("8001-NASDevVideoFile", this.jdField_a_of_type_Szw);
    b("8002-NASDevDocumentFile", this.jdField_a_of_type_Szw);
    b("8003-NASDevCommonFile", this.jdField_a_of_type_Szw);
    b("", this.jdField_a_of_type_Szw);
    b("", this.jdField_b_of_type_Szd);
    this.app.removeObserver(this.jdField_b_of_type_Szg);
    this.app.getApp().unregisterReceiver(this.ar);
    this.app.removeObserver(this.jdField_a_of_type_Aclm);
    this.jdField_a_of_type_Szw = null;
    this.jdField_a_of_type_Szv = null;
    this.jdField_b_of_type_Szd = null;
    this.jdField_a_of_type_Szx = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szy
 * JD-Core Version:    0.7.0.1
 */