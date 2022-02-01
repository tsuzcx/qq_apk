import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

public class skj
{
  static int bxw;
  protected static skj e;
  private static String sProcessName;
  accd jdField_a_of_type_Accd;
  joi jdField_a_of_type_Joi;
  jol jdField_a_of_type_Jol;
  private skj.a jdField_a_of_type_Skj$a;
  AtomicInteger at = new AtomicInteger(0);
  AtomicInteger au = new AtomicInteger(0);
  SparseArray<acci> bf = new SparseArray();
  Map<Integer, skj.a> callbacks = new ConcurrentHashMap();
  private HashMap<String, Integer> fM = new HashMap();
  private HashMap<String, Integer> fN = new HashMap();
  List<acci> jC = new ArrayList();
  protected ServiceConnection mConnection = new skk(this);
  final Messenger mMessenger = new Messenger(new skj.b());
  List<Message> mQueue = new ArrayList();
  Messenger mService = null;
  
  public static skj a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new skj();
      }
      return e;
    }
    finally {}
  }
  
  public static String getCurrentProcessName()
  {
    if (sProcessName != null) {
      return sProcessName;
    }
    int i = Process.myPid();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i)
      {
        localObject = localRunningAppProcessInfo.processName;
        sProcessName = (String)localObject;
        return localObject;
      }
    }
    return null;
  }
  
  public void G(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopProfileAppListChanged", paramBoolean);
    localBundle.putString("profileAppListChangedTroopUin", paramString);
    i(105, localBundle);
  }
  
  public void R(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    i(96, localBundle);
  }
  
  public void S(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    i(99, localBundle);
  }
  
  public int a(skj.a parama)
  {
    int i = this.au.addAndGet(1);
    this.callbacks.put(Integer.valueOf(i), parama);
    return i;
  }
  
  public joi a()
  {
    if (this.jdField_a_of_type_Joi == null) {
      this.jdField_a_of_type_Joi = new joi(this);
    }
    return this.jdField_a_of_type_Joi;
  }
  
  public jol a()
  {
    if (this.jdField_a_of_type_Jol == null) {
      this.jdField_a_of_type_Jol = new jol(this);
    }
    return this.jdField_a_of_type_Jol;
  }
  
  public skj.a a(int paramInt)
  {
    return (skj.a)this.callbacks.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomid", paramLong);
    localBundle.putInt("roomType", paramInt1);
    localBundle.putString("vasname", paramString1);
    localBundle.putString("userdata", paramString2);
    localBundle.putInt("fromid", paramInt2);
    i(32, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle, acci paramacci)
  {
    SparseArray localSparseArray = this.bf;
    int i = bxw + 1;
    bxw = i;
    localSparseArray.append(i, paramacci);
    paramBundle.putString("processName", getCurrentProcessName());
    paramBundle.putInt("req_seq", bxw);
    i(paramInt, paramBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle, skj.a parama)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("seq", a(parama));
    localBundle.putString("processName", getCurrentProcessName());
    i(paramInt, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("uploadType", paramInt);
    localBundle.putString("url", paramString1);
    localBundle.putString("originUrl", paramString2);
    i(142, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString4);
    localBundle.putInt("seq", a(parama));
    localBundle.putInt("appid", paramInt);
    localBundle.putString("openGroupId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putString("url", paramString3);
    i(28, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramString1);
    localBundle.putString("pluginId", paramString2);
    localBundle.putString("startParam", paramString3);
    localBundle.putInt("action", paramInt);
    localBundle.putInt("seq", a(parama));
    i(79, localBundle);
  }
  
  public void a(int paramInt, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("appId", paramInt);
    localBundle.putInt("seq", a(parama));
    i(44, localBundle);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopCode", paramLong1);
    localBundle.putString("filePath", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("fileSize", paramLong2);
    localBundle.putInt("busid", paramInt);
    localBundle.putInt("seq", a(parama));
    i(20, localBundle);
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    localBundle.putInt("start", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putInt("count", paramInteger3.intValue());
    i(129, localBundle);
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("clearType", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putString("uin", paramString);
    i(130, localBundle);
  }
  
  public void a(Integer paramInteger1, String paramString, Integer paramInteger2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("deleteType", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putString("uin", paramString);
    i(131, localBundle);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    localBundle.putInt("appid", paramInteger.intValue());
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    i(60, localBundle);
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putByte("cIsGetGroupAlbum", paramByte);
    localBundle.putLong("dwTimeStamp", paramLong);
    localBundle.putInt("cStatOption", paramInt);
    i(37, localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopMngTest", 4, String.format("getGroupInfoReq [%s]", new Object[] { paramString }));
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString1);
    localBundle.putInt("type", paramInt1);
    localBundle.putInt("msgfrom", paramInt2);
    localBundle.putString("senderUin", paramString2);
    localBundle.putString("chatId", paramString3);
    localBundle.putString("source", paramString4);
    localBundle.putString("originUrl", paramString5);
    a(121, localBundle, parama);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("roomId", paramString1);
    localBundle.putInt("isGroupCode", paramInt);
    localBundle.putString("action", paramString2);
    localBundle.putString("fromId", paramString3);
    localBundle.putString("backType", paramString4);
    localBundle.putString("openType", paramString5);
    localBundle.putString("extra", paramString6);
    i(94, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, skj.a parama1, skj.a parama2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_local_path", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putInt("seq1", a(parama2));
    localBundle.putInt("seq", a(parama1));
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    i(21, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("bubbleId", paramLong);
    localBundle.putInt("headId", paramInt1);
    localBundle.putString("nickName", paramString2);
    localBundle.putInt("expireTime", paramInt2);
    localBundle.putString("rankColor", paramString3);
    localBundle.putInt("seq", a(parama));
    i(13, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, int paramInt, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("volumeIsOn", paramInt);
    localBundle.putInt("seq", a(parama));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient setReadinjoySkin skinId = " + paramString1);
    }
    i(109, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("seq", a(parama));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient startLoadReadinjoySkin skinId = " + paramString1);
    }
    i(107, localBundle);
  }
  
  public void a(String paramString, AIOImageData paramAIOImageData, int paramInt, skj.a parama)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("filePath", paramAIOImageData.filePath);
    localBundle.putString("fileName", paramAIOImageData.fileName);
    localBundle.putInt("busId", paramAIOImageData.busId);
    localBundle.putInt("size", paramInt);
    int i = a(parama);
    localBundle.putInt("seq", i);
    paramString = paramAIOImageData.filePath + "/" + paramInt;
    this.fN.put(paramString, Integer.valueOf(i));
    i(58, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(parama));
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopName", paramString2);
    localBundle.putInt("troopTypeId", paramInt);
    i(19, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("troopUin", paramString2);
    localBundle.putInt("msgTailType", paramInt);
    localBundle.putInt("seq", a(parama));
    i(87, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("packageName", paramString1);
    localBundle.putString("pluginId", paramString2);
    localBundle.putString("versionCode", paramString3);
    localBundle.putInt("seq", a(parama));
    i(78, localBundle);
  }
  
  public void a(String paramString1, String paramString2, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("groupMemberUin", paramString2);
    localBundle.putInt("seq", a(parama));
    i(72, localBundle);
  }
  
  public void a(String paramString, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", getCurrentProcessName());
    i(59, localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList, skj.a parama)
  {
    int i = this.au.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("tinyIdList", paramArrayList);
    localBundle.putInt("seq", i);
    this.callbacks.put(Integer.valueOf(i), parama);
    i(102, localBundle);
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("xmlData", paramArrayOfByte);
    localBundle.putString("friendUin", paramString);
    localBundle.putInt("directionFlag", paramInt1);
    localBundle.putInt("from", paramInt2);
    i(73, localBundle);
  }
  
  public void aD(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    i(36, localBundle);
  }
  
  public void aE(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    i(120, localBundle);
  }
  
  public void aF(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isOpen", paramBoolean);
    i(145, localBundle);
  }
  
  public void aY(Bundle paramBundle)
  {
    i(114, paramBundle);
  }
  
  public void aZ(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBundle("reportData", paramBundle);
    i(117, localBundle);
  }
  
  public void addObserver(acci paramacci)
  {
    if (paramacci == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + paramacci.hashCode());
      }
    } while (this.jC.contains(paramacci));
    this.jC.add(paramacci);
  }
  
  public void af(long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("followUin", paramLong);
    localBundle.putInt("followInfo", paramInt);
    i(119, localBundle);
  }
  
  public void b(long paramLong, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("troopUinList", paramArrayOfLong);
    localBundle.putLong("troopPubAccountUin", paramLong);
    i(45, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, skj.a parama1, skj.a parama2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_server_id", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    localBundle.putInt("seq1", a(parama2));
    localBundle.putInt("seq", a(parama1));
    i(22, localBundle);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("chatType", paramString2);
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(parama));
    i(111, localBundle);
  }
  
  public void b(String paramString1, String paramString2, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("rewardId", paramString2);
    localBundle.putInt("seq", a(parama));
    i(55, localBundle);
  }
  
  public void b(String paramString, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    localBundle.putString("hashName", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("allen", 2, "此时发送请求");
    }
    i(66, localBundle);
  }
  
  public void bA(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", Long.parseLong(paramString));
    localBundle.putInt("flag", paramInt);
    i(51, localBundle);
  }
  
  public void bB(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schoolName", paramString);
    localBundle.putInt("isValid", paramInt);
    i(74, localBundle);
  }
  
  public void ba(Bundle paramBundle)
  {
    i(148, paramBundle);
  }
  
  public void bdy()
  {
    i(27, new Bundle());
  }
  
  public void bzj()
  {
    if (this.at.getAndAdd(1) == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localBaseApplication.bindService(new Intent(localBaseApplication, TroopMemberApiService.class), this.mConnection, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
      }
    }
  }
  
  public void bzk()
  {
    if (this.at.get() == 0) {
      QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
    }
    for (;;)
    {
      return;
      BaseApplication localBaseApplication;
      if (this.at.addAndGet(-1) == 0)
      {
        localBaseApplication = BaseApplicationImpl.getContext();
        if (this.mService == null) {}
      }
      try
      {
        Message localMessage = Message.obtain(null, 2);
        localMessage.replyTo = this.mMessenger;
        Bundle localBundle = new Bundle();
        localBundle.putString("processName", getCurrentProcessName());
        localMessage.obj = localBundle;
        this.mService.send(localMessage);
        label94:
        localBaseApplication.unbindService(this.mConnection);
        this.mService = null;
        try
        {
          this.mQueue.clear();
          this.callbacks.clear();
          a().clear();
          if (QLog.isColorLevel()) {
            QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
          }
          if (this.at.get() >= 0) {
            continue;
          }
          this.at.set(0);
          QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
          return;
        }
        finally {}
      }
      catch (RemoteException localRemoteException)
      {
        break label94;
      }
    }
  }
  
  public void bzl()
  {
    i(6, null);
  }
  
  public void bzm()
  {
    i(93, new Bundle());
  }
  
  public void bzn()
  {
    i(77, new Bundle());
  }
  
  public void bzo()
  {
    i(92, null);
  }
  
  public void bzp()
  {
    this.jdField_a_of_type_Skj$a = null;
  }
  
  public void bzq()
  {
    i(89, null);
  }
  
  public void bzr()
  {
    i(104, new Bundle());
  }
  
  public void bzs()
  {
    i(116, new Bundle());
  }
  
  public void bzt()
  {
    i(124, new Bundle());
  }
  
  public void c(String paramString1, String paramString2, String paramString3, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramString1);
    localBundle.putString("openid", paramString2);
    localBundle.putString("troopuin", paramString3);
    a(146, localBundle, parama);
  }
  
  public void c(String paramString1, String paramString2, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("photoPath", paramString2);
    localBundle.putInt("seq", a(parama));
    i(75, localBundle);
  }
  
  public void c(String paramString, skj.a parama)
  {
    if (parama == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("callback", paramString);
    }
    localBundle.putInt("seq", a(parama));
    i(15, localBundle);
  }
  
  public void cA(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 2);
    localBundle.putStringArrayList("statusList", paramArrayList);
    i(85, localBundle);
  }
  
  public void cB(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("preloadList", paramArrayList);
    i(103, localBundle);
  }
  
  public void cD(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("opn", paramString2);
    i(31, localBundle);
  }
  
  public void cE(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gcode", paramString1);
    localBundle.putString("anId", paramString2);
    i(7, localBundle);
  }
  
  public void cF(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginPackageName", paramString1);
    localBundle.putString("appType", paramString2);
    i(71, localBundle);
  }
  
  public void cG(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopCode", paramString2);
    i(41, localBundle);
  }
  
  public void cH(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localFilePath", paramString1);
    localBundle.putString("fileDisPlayName", paramString2);
    i(47, localBundle);
  }
  
  public void cI(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    i(97, localBundle);
  }
  
  public void cJ(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    i(100, localBundle);
  }
  
  public void cK(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("type", paramString2);
    i(115, localBundle);
  }
  
  public void cL(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("nick", paramString2);
    i(143, localBundle);
  }
  
  public void d(String paramString1, String paramString2, skj.a parama)
  {
    int i = this.au.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("rid", paramString2);
    localBundle.putInt("seq", i);
    this.callbacks.put(Integer.valueOf(i), parama);
    i(101, localBundle);
  }
  
  public void d(String paramString, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    localBundle.putString("content", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient sendToComputer");
    }
    i(122, localBundle);
  }
  
  public void d(skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    localBundle.putString("processName", getCurrentProcessName());
    i(81, localBundle);
  }
  
  public void e(String paramString1, String paramString2, skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putInt("seq", a(parama));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient cancelLoadReadinjoySkin skinId = " + paramString1);
    }
    i(108, localBundle);
  }
  
  public void e(skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    i(84, localBundle);
  }
  
  public void eD(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("topicId", paramInt1);
    localBundle.putInt("followInfo", paramInt2);
    i(106, localBundle);
  }
  
  public void f(skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    i(76, localBundle);
  }
  
  public void fs(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong);
    i(88, localBundle);
  }
  
  public void g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appType", paramString1);
    localBundle.putString("openType", paramString2);
    localBundle.putString("uri", paramString3);
    localBundle.putString("action", paramString4);
    localBundle.putString("pluginPackageName", paramString5);
    localBundle.putString("pluginParams", paramString6);
    i(67, localBundle);
  }
  
  public void g(skj.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("getReadinjoyShareToWxConfig", 2, "get config");
    }
    a(113, null, parama);
  }
  
  public void h(String paramString, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramString);
    if (paramString.equals(String.valueOf(16)))
    {
      localBundle.putString("redpackid", (String)paramHashMap.get("redpackid"));
      int i = aurg.t((String)paramHashMap.get("plat_source"));
      localBundle.putInt("plat_source", i);
      awit.eDL();
      if (!awit.aME())
      {
        RIJRedPacketManager.a().a(BaseActivity.sTopActivity, (String)paramHashMap.get("redpackid"), 3, i, true, this);
        return;
      }
      i(127, localBundle);
      return;
    }
    i(127, localBundle);
  }
  
  public void h(skj.a parama)
  {
    a(128, new Bundle(), parama);
  }
  
  public void i(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.replyTo = this.mMessenger;
    localMessage.setData(paramBundle);
    if (this.mService == null) {
      try
      {
        this.mQueue.add(localMessage);
        return;
      }
      finally {}
    }
    try
    {
      this.mService.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void i(skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    i(52, localBundle);
  }
  
  public void j(skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    i(80, localBundle);
  }
  
  public void k(skj.a parama)
  {
    this.jdField_a_of_type_Skj$a = parama;
  }
  
  public void l(skj.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(parama));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient getReadinjoyCurrentSkin");
    }
    i(110, localBundle);
  }
  
  public void m(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 1);
    localBundle.putInt("effectId", paramInt1);
    localBundle.putInt("svipLevel", paramInt2);
    localBundle.putInt("svipType", paramInt3);
    localBundle.putString("effectName", paramString);
    i(85, localBundle);
  }
  
  public void m(skj.a parama)
  {
    a(141, new Bundle(), parama);
  }
  
  public void p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("appID", paramString2);
    localBundle.putString("url", paramString3);
    localBundle.putString("source", paramString4);
    i(150, localBundle);
  }
  
  public void removeObserver(acci paramacci)
  {
    if (paramacci == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + paramacci.hashCode());
      }
    } while (!this.jC.contains(paramacci));
    this.jC.remove(paramacci);
  }
  
  public void s(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memberUin", paramString2);
    localBundle.putInt("titleId", paramInt);
    i(29, localBundle);
  }
  
  public void t(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memUin", paramString2);
    localBundle.putInt("serviceType", paramInt);
    i(70, localBundle);
  }
  
  public void ti(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", getCurrentProcessName());
    i(39, localBundle);
  }
  
  public void tj(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    i(34, localBundle);
  }
  
  public void tk(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    i(35, localBundle);
  }
  
  public void tl(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString);
    i(98, localBundle);
  }
  
  public void tm(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fromId", paramString);
    i(149, localBundle);
  }
  
  public void tn(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramString);
    i(144, localBundle);
  }
  
  public void uP(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopAppListChanged", paramBoolean);
    i(30, localBundle);
  }
  
  public void uQ(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("force_install_new", paramBoolean);
    i(91, localBundle);
  }
  
  public void vI(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("reqUserSetEnableAlbumScan", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("UserEnableAlbumScan", 2, "TroopMemberApiClient setUserEnableAlbumScan value = " + paramInt);
    }
    i(125, localBundle);
  }
  
  public void y(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putInt("statOption", paramInt);
    localBundle.putString("authKey", paramString2);
    i(69, localBundle);
  }
  
  public void yB(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fontSize", paramInt);
    i(53, localBundle);
  }
  
  public static abstract interface a
  {
    public abstract void callback(Bundle paramBundle);
  }
  
  class b
    extends Handler
  {
    public b()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage == null) {}
      Bundle localBundle;
      int i;
      boolean bool;
      int j;
      Iterator localIterator;
      label710:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localBundle = paramMessage.getData();
            } while (localBundle == null);
            i = localBundle.getInt("seq", -1);
            switch (paramMessage.what)
            {
            }
          } while (i == -1);
          paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        } while (paramMessage == null);
        paramMessage.callback(localBundle);
        return;
        i = localBundle.getInt("type");
        bool = localBundle.getBoolean("isSuccess", false);
        paramMessage = localBundle.getSerializable("data");
        j = localBundle.getInt("observer_type");
        localIterator = skj.this.jC.iterator();
      } while (!localIterator.hasNext());
      acci localacci = (acci)localIterator.next();
      Object localObject;
      if (((j == 1) && ((localacci instanceof acgs))) || ((j == 2) && ((localacci instanceof acfd)))) {
        if (28 == i)
        {
          localObject = localBundle.getByteArray("groupInfo");
          paramMessage = new cmd0x7f5.GroupInfo();
          if (localObject == null) {
            break label2414;
          }
        }
      }
      label2414:
      for (;;)
      {
        try
        {
          paramMessage.mergeFrom((byte[])localObject);
          localObject = new Object[2];
          localObject[0] = Integer.valueOf(localBundle.getInt("count"));
          localObject[1] = paramMessage;
          paramMessage = (Message)localObject;
          localacci.onUpdate(i, bool, paramMessage);
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          paramMessage.printStackTrace();
          paramMessage = null;
          continue;
        }
        if ((j == 3) && ((localacci instanceof acnd)))
        {
          ((acnd)localacci).onUpdate(i, bool, paramMessage);
          break label710;
        }
        if ((j == 4) && ((localacci instanceof accd)))
        {
          ((accd)localacci).onUpdate(i, bool, paramMessage);
          break label710;
        }
        if ((j != 5) || (!(localacci instanceof acgf))) {
          break label710;
        }
        ((acgf)localacci).onUpdate(i, bool, paramMessage);
        break label710;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i != -1)
        {
          j = localBundle.getInt("retCode", -1);
          int k = localBundle.getInt("rate", -1);
          paramMessage = (skj.a)skj.this.callbacks.get(Integer.valueOf(i));
          if (paramMessage != null)
          {
            paramMessage.callback(localBundle);
            if ((j != 0) || (k == 100))
            {
              QLog.d("ReadInJoy", 4, "download finish:" + localBundle);
              skj.this.callbacks.remove(Integer.valueOf(i));
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN retCode=" + j + ",rate=" + k);
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN callback null");
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN seq=" + i);
        return;
        if (skj.this.a == null) {
          break;
        }
        paramMessage = localBundle.getString("pageUrl");
        localObject = localBundle.getStringArrayList("lstVideoUrl");
        i = localBundle.getInt("totalTime", 0);
        skj.this.a.onUpdate(localBundle.getInt("type"), true, new Object[] { paramMessage, localObject, Integer.valueOf(i) });
        return;
        skj.this.a().al(localBundle);
        return;
        skj.this.a().al(localBundle);
        return;
        localObject = (acci)skj.this.bf.get(localBundle.getInt("req_seq"));
        if (localObject == null) {
          break;
        }
        skj.this.bf.remove(localBundle.getInt("req_seq"));
        ((acci)localObject).onUpdate(paramMessage.what, true, localBundle);
        return;
        if (localBundle == null) {
          break;
        }
        i = localBundle.getInt("seq1", -1);
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (localBundle == null) {
          break;
        }
        i = localBundle.getInt("seq", -1);
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (localBundle == null) {
          break;
        }
        i = localBundle.getInt("seq1", -1);
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (localBundle == null) {
          break;
        }
        i = localBundle.getInt("seq", -1);
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if ((i == -1) || (paramMessage == null)) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (localBundle == null) {
          break;
        }
        i = localBundle.getInt("seq", -1);
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        paramMessage = localBundle.getString("FileName");
        i = localBundle.getInt("Status");
        if ((skj.a(skj.this) == null) || (paramMessage == null) || (skj.a(skj.this).get(paramMessage) == null)) {
          break;
        }
        j = ((Integer)skj.a(skj.this).get(paramMessage)).intValue();
        if (j == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.get(Integer.valueOf(j));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        if (i != 11) {
          break;
        }
        skj.this.callbacks.remove(Integer.valueOf(j));
        return;
        paramMessage = localBundle.getString("FilePath");
        i = localBundle.getInt("size");
        localObject = paramMessage + "/" + i;
        if ((skj.b(skj.this) == null) || (paramMessage == null) || (skj.b(skj.this).get(localObject) == null)) {
          break;
        }
        i = ((Integer)skj.b(skj.this).get(localObject)).intValue();
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        bool = localBundle.getBoolean("actionFinish");
        paramMessage = (skj.a)skj.this.callbacks.get(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        if (!bool) {
          break;
        }
        skj.this.callbacks.remove(Integer.valueOf(i));
        return;
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (skj.a(skj.this) == null) {
          break;
        }
        skj.a(skj.this).callback(localBundle);
        return;
        if (skj.a(skj.this) == null) {
          break;
        }
        skj.a(skj.this).callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        localBundle.putString("type", "troopCreateOpenAIO");
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.remove(Integer.valueOf(i));
        if (paramMessage == null) {
          break;
        }
        localBundle.putBoolean("isSuccess", localBundle.getBoolean("isSuccess"));
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        paramMessage = (skj.a)skj.this.callbacks.get(Integer.valueOf(i));
        if ((paramMessage == null) || (localBundle == null)) {
          break;
        }
        paramMessage.callback(localBundle);
        return;
        if (i == -1) {
          break;
        }
        skj.this.callbacks.remove(Integer.valueOf(i));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skj
 * JD-Core Version:    0.7.0.1
 */