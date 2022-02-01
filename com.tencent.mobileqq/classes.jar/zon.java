import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class zon
{
  static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  protected static zon a;
  amop jdField_a_of_type_Amop;
  protected ServiceConnection a;
  final Messenger jdField_a_of_type_AndroidOsMessenger = new Messenger(new zoq(this));
  SparseArray<BusinessObserver> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<BusinessObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<Integer, zop> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  nnf jdField_a_of_type_Nnf;
  nni jdField_a_of_type_Nni;
  private zop jdField_a_of_type_Zop;
  Messenger jdField_b_of_type_AndroidOsMessenger = null;
  private HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  List<Message> jdField_b_of_type_JavaUtilList = new ArrayList();
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private zon()
  {
    this.jdField_a_of_type_AndroidContentServiceConnection = new zoo(this);
  }
  
  public static String a()
  {
    if (jdField_a_of_type_JavaLangString != null) {
      return jdField_a_of_type_JavaLangString;
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
        jdField_a_of_type_JavaLangString = (String)localObject;
        return localObject;
      }
    }
    return null;
  }
  
  public static zon a()
  {
    if (jdField_a_of_type_Zon == null) {}
    try
    {
      if (jdField_a_of_type_Zon == null) {
        jdField_a_of_type_Zon = new zon();
      }
      return jdField_a_of_type_Zon;
    }
    finally {}
  }
  
  public int a(int paramInt, Bundle paramBundle, zop paramzop)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    int i = a(paramzop);
    localBundle.putInt("seq", i);
    localBundle.putString("processName", a());
    a(paramInt, localBundle);
    return i;
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString1);
    localBundle.putInt("type", paramInt1);
    localBundle.putInt("msgfrom", paramInt2);
    localBundle.putString("senderUin", paramString2);
    localBundle.putString("chatId", paramString3);
    localBundle.putString("source", paramString4);
    localBundle.putString("originUrl", paramString5);
    return a(121, localBundle, paramzop);
  }
  
  public int a(zop paramzop)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramzop);
    return i;
  }
  
  public nnf a()
  {
    if (this.jdField_a_of_type_Nnf == null) {
      this.jdField_a_of_type_Nnf = new nnf(this);
    }
    return this.jdField_a_of_type_Nnf;
  }
  
  public nni a()
  {
    if (this.jdField_a_of_type_Nni == null) {
      this.jdField_a_of_type_Nni = new nni(this);
    }
    return this.jdField_a_of_type_Nni;
  }
  
  public zop a(int paramInt)
  {
    return (zop)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(1) == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localBaseApplication.bindService(new Intent(localBaseApplication, TroopMemberApiService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
      }
    }
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fontSize", paramInt);
    a(53, localBundle);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("topicId", paramInt1);
    localBundle.putInt("followInfo", paramInt2);
    a(106, localBundle);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 1);
    localBundle.putInt("effectId", paramInt1);
    localBundle.putInt("svipLevel", paramInt2);
    localBundle.putInt("svipType", paramInt3);
    localBundle.putString("effectName", paramString);
    a(85, localBundle);
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomid", paramLong);
    localBundle.putInt("roomType", paramInt1);
    localBundle.putString("vasname", paramString1);
    localBundle.putString("userdata", paramString2);
    localBundle.putInt("fromid", paramInt2);
    a(32, localBundle);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    localMessage.replyTo = this.jdField_a_of_type_AndroidOsMessenger;
    localMessage.setData(paramBundle);
    if (this.jdField_b_of_type_AndroidOsMessenger == null) {
      try
      {
        this.jdField_b_of_type_JavaUtilList.add(localMessage);
        return;
      }
      finally {}
    }
    try
    {
      this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, BusinessObserver paramBusinessObserver)
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    localSparseArray.append(i, paramBusinessObserver);
    paramBundle.putString("processName", a());
    paramBundle.putInt("req_seq", jdField_a_of_type_Int);
    a(paramInt, paramBundle);
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
    a(142, localBundle);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString4);
    localBundle.putInt("seq", a(paramzop));
    localBundle.putInt("appid", paramInt);
    localBundle.putString("openGroupId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putString("url", paramString3);
    a(28, localBundle);
  }
  
  public void a(int paramInt, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("appId", paramInt);
    localBundle.putInt("seq", a(paramzop));
    a(44, localBundle);
  }
  
  public void a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("roomId", paramLong);
    a(88, localBundle);
  }
  
  public void a(long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("followUin", paramLong);
    localBundle.putInt("followInfo", paramInt);
    a(119, localBundle);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopCode", paramLong1);
    localBundle.putString("filePath", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("fileSize", paramLong2);
    localBundle.putInt("busid", paramInt);
    localBundle.putInt("seq", a(paramzop));
    a(20, localBundle);
  }
  
  public void a(long paramLong, long[] paramArrayOfLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLongArray("troopUinList", paramArrayOfLong);
    localBundle.putLong("troopPubAccountUin", paramLong);
    a(45, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    a(114, paramBundle);
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putInt("start", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putInt("count", paramInteger3.intValue());
    a(129, localBundle);
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("clearType", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putString("uin", paramString);
    a(130, localBundle);
  }
  
  public void a(Integer paramInteger1, String paramString, Integer paramInteger2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("deleteType", paramInteger1.intValue());
    localBundle.putInt("msgType", paramInteger2.intValue());
    localBundle.putString("uin", paramString);
    a(131, localBundle);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putInt("appid", paramInteger.intValue());
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    a(60, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", a());
    a(39, localBundle);
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putByte("cIsGetGroupAlbum", paramByte);
    localBundle.putLong("dwTimeStamp", paramLong);
    localBundle.putInt("cStatOption", paramInt);
    a(37, localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopMngTest", 4, String.format("getGroupInfoReq [%s]", new Object[] { paramString }));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", Long.parseLong(paramString));
    localBundle.putInt("flag", paramInt);
    a(51, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putInt("opType", paramInt);
    localBundle.putString("startTroopUin", paramString2);
    a(156, localBundle);
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
    a(94, localBundle);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, zop paramzop1, zop paramzop2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_local_path", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putInt("seq1", a(paramzop2));
    localBundle.putInt("seq", a(paramzop1));
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    a(21, localBundle);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, String paramString3, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putLong("bubbleId", paramLong);
    localBundle.putInt("headId", paramInt1);
    localBundle.putString("nickName", paramString2);
    localBundle.putInt("expireTime", paramInt2);
    localBundle.putString("rankColor", paramString3);
    localBundle.putInt("seq", a(paramzop));
    a(13, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, int paramInt, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("volumeIsOn", paramInt);
    localBundle.putInt("seq", a(paramzop));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient setReadinjoySkin skinId = " + paramString1);
    }
    a(109, localBundle);
  }
  
  public void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putString("skinName", paramString3);
    localBundle.putLong("skinSeq", paramLong1);
    localBundle.putLong("startTime", paramLong2);
    localBundle.putLong("endTime", paramLong3);
    localBundle.putInt("seq", a(paramzop));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient startLoadReadinjoySkin skinId = " + paramString1);
    }
    a(107, localBundle);
  }
  
  public void a(String paramString, AIOImageData paramAIOImageData, int paramInt, zop paramzop)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putString("filePath", paramAIOImageData.h);
    localBundle.putString("fileName", paramAIOImageData.g);
    localBundle.putInt("busId", paramAIOImageData.c);
    localBundle.putInt("size", paramInt);
    int i = a(paramzop);
    localBundle.putInt("seq", i);
    paramString = paramAIOImageData.h + "/" + paramInt;
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i));
    a(58, localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("opn", paramString2);
    a(31, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memberUin", paramString2);
    localBundle.putInt("titleId", paramInt);
    a(29, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopName", paramString2);
    localBundle.putInt("troopTypeId", paramInt);
    a(19, localBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("troopUin", paramString2);
    localBundle.putInt("msgTailType", paramInt);
    localBundle.putInt("seq", a(paramzop));
    a(87, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    a(96, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("appID", paramString2);
    localBundle.putString("url", paramString3);
    localBundle.putString("source", paramString4);
    a(150, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appType", paramString1);
    localBundle.putString("openType", paramString2);
    localBundle.putString("uri", paramString3);
    localBundle.putString("action", paramString4);
    localBundle.putString("pluginPackageName", paramString5);
    localBundle.putString("pluginParams", paramString6);
    a(67, localBundle);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("chatType", paramString2);
    localBundle.putString("callback", paramString3);
    localBundle.putInt("seq", a(paramzop));
    a(111, localBundle);
  }
  
  public void a(String paramString1, String paramString2, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("groupCode", paramString1);
    localBundle.putString("groupMemberUin", paramString2);
    localBundle.putInt("seq", a(paramzop));
    a(72, localBundle);
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    paramHashMap = new Bundle();
    paramHashMap.putString("from", paramString);
    a(127, paramHashMap);
  }
  
  public void a(String paramString, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("troopUin", paramString);
    localBundle.putString("processName", a());
    a(59, localBundle);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(36, localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("subCmd", 2);
    localBundle.putStringArrayList("statusList", paramArrayList);
    a(85, localBundle);
  }
  
  public void a(ArrayList<String> paramArrayList, zop paramzop)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("tinyIdList", paramArrayList);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramzop);
    a(102, localBundle);
  }
  
  public void a(JSONObject paramJSONObject, Parcelable paramParcelable, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("BUNDLE_KEY_JS_OBJ", paramJSONObject.toString());
    localBundle.putParcelable("BUNDLE_KEY_CREATE_COMMENT_DATA", paramParcelable);
    a(154, localBundle);
  }
  
  public void a(JSONObject paramJSONObject, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("ALD_CONFIG_RESULT", paramJSONObject.toString());
    a(155, localBundle);
  }
  
  public void a(zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("processName", a());
    a(81, localBundle);
  }
  
  public void a(short paramShort, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putShort("tmpPushType", paramShort);
    a(151, localBundle);
  }
  
  public void a(short paramShort, boolean paramBoolean, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putShort("tmpPushType", paramShort);
    localBundle.putBoolean("enable", paramBoolean);
    a(152, localBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopAppListChanged", paramBoolean);
    a(30, localBundle);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isTroopProfileAppListChanged", paramBoolean);
    localBundle.putString("profileAppListChangedTroopUin", paramString);
    a(105, localBundle);
  }
  
  public void a(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("xmlData", paramArrayOfByte);
    localBundle.putString("friendUin", paramString);
    localBundle.putInt("directionFlag", paramInt1);
    localBundle.putInt("from", paramInt2);
    a(73, localBundle);
  }
  
  public int b(zop paramzop)
  {
    Bundle localBundle = new Bundle();
    int i = a(paramzop);
    localBundle.putInt("seq", i);
    a(52, localBundle);
    return i;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
      QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
    }
    for (;;)
    {
      return;
      BaseApplication localBaseApplication;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) == 0)
      {
        localBaseApplication = BaseApplicationImpl.getContext();
        if (this.jdField_b_of_type_AndroidOsMessenger == null) {}
      }
      try
      {
        Message localMessage = Message.obtain(null, 2);
        localMessage.replyTo = this.jdField_a_of_type_AndroidOsMessenger;
        Bundle localBundle = new Bundle();
        localBundle.putString("processName", a());
        localMessage.obj = localBundle;
        this.jdField_b_of_type_AndroidOsMessenger.send(localMessage);
        label93:
        localBaseApplication.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_b_of_type_AndroidOsMessenger = null;
        try
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilMap.clear();
          a().a();
          if (QLog.isColorLevel()) {
            QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
          return;
        }
        finally {}
      }
      catch (RemoteException localRemoteException)
      {
        break label93;
      }
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("reqUserSetEnableAlbumScan", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("UserEnableAlbumScan", 2, "TroopMemberApiClient setUserEnableAlbumScan value = " + paramInt);
    }
    a(125, localBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBundle("reportData", paramBundle);
    a(117, localBundle);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + paramBusinessObserver.hashCode());
      }
    } while (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver));
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(34, localBundle);
  }
  
  public void b(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    localBundle.putInt("index", paramInt);
    a(95, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putInt("statOption", paramInt);
    localBundle.putString("authKey", paramString2);
    a(69, localBundle);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, zop paramzop1, zop paramzop2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_server_id", paramString1);
    localBundle.putInt("is_showProgress_tips", paramInt);
    localBundle.putString("pic_puin", paramString2);
    localBundle.putBoolean("is_pic_or_voice", paramBoolean);
    localBundle.putInt("seq1", a(paramzop2));
    localBundle.putInt("seq", a(paramzop1));
    a(22, localBundle);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("gcode", paramString1);
    localBundle.putString("anId", paramString2);
    a(7, localBundle);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("memUin", paramString2);
    localBundle.putInt("serviceType", paramInt);
    a(70, localBundle);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    localBundle.putString("nick", paramString3);
    a(99, localBundle);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramString1);
    localBundle.putString("openid", paramString2);
    localBundle.putString("troopuin", paramString3);
    a(146, localBundle, paramzop);
  }
  
  public void b(String paramString1, String paramString2, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("rewardId", paramString2);
    localBundle.putInt("seq", a(paramzop));
    a(55, localBundle);
  }
  
  public void b(String paramString, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("hashName", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("allen", 2, "此时发送请求");
    }
    a(66, localBundle);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(120, localBundle);
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("preloadList", paramArrayList);
    a(103, localBundle);
  }
  
  public void b(zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    a(84, localBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("force_install_new", paramBoolean);
    a(91, localBundle);
  }
  
  public void c()
  {
    a(6, null);
  }
  
  public void c(Bundle paramBundle)
  {
    a(148, paramBundle);
  }
  
  public void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    a(35, localBundle);
  }
  
  public void c(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schoolName", paramString);
    localBundle.putInt("isValid", paramInt);
    a(74, localBundle);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginPackageName", paramString1);
    localBundle.putString("appType", paramString2);
    a(71, localBundle);
  }
  
  public void c(String paramString1, String paramString2, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("photoPath", paramString2);
    localBundle.putInt("seq", a(paramzop));
    a(75, localBundle);
  }
  
  public void c(String paramString, zop paramzop)
  {
    if (paramzop == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("callback", paramString);
    }
    localBundle.putInt("seq", a(paramzop));
    a(15, localBundle);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isChecked", paramBoolean);
    a(153, localBundle);
  }
  
  public void c(zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    a(76, localBundle);
  }
  
  public void d()
  {
    a(93, new Bundle());
  }
  
  public void d(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString);
    a(98, localBundle);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("troopCode", paramString2);
    a(41, localBundle);
  }
  
  public void d(String paramString1, String paramString2, zop paramzop)
  {
    int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("rid", paramString2);
    localBundle.putInt("seq", i);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramzop);
    a(101, localBundle);
  }
  
  public void d(String paramString, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    localBundle.putString("content", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient sendToComputer");
    }
    a(122, localBundle);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString);
    localBundle.putBoolean("isOpen", paramBoolean);
    a(145, localBundle);
  }
  
  public void d(zop paramzop)
  {
    if (QLog.isColorLevel()) {
      QLog.d("getReadinjoyShareToWxConfig", 2, "get config");
    }
    a(113, null, paramzop);
  }
  
  public void e()
  {
    a(77, new Bundle());
  }
  
  public void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fromId", paramString);
    a(149, localBundle);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("localFilePath", paramString1);
    localBundle.putString("fileDisPlayName", paramString2);
    a(47, localBundle);
  }
  
  public void e(String paramString1, String paramString2, zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("skinId", paramString1);
    localBundle.putString("skinUrl", paramString2);
    localBundle.putInt("seq", a(paramzop));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient cancelLoadReadinjoySkin skinId = " + paramString1);
    }
    a(108, localBundle);
  }
  
  public void e(zop paramzop)
  {
    a(128, new Bundle(), paramzop);
  }
  
  public void f()
  {
    a(27, new Bundle());
  }
  
  public void f(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramString);
    a(144, localBundle);
  }
  
  public void f(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    a(97, localBundle);
  }
  
  public void f(zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    a(80, localBundle);
  }
  
  public void g()
  {
    a(92, null);
  }
  
  public void g(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopCode", paramString1);
    localBundle.putString("uin", paramString2);
    a(100, localBundle);
  }
  
  public void g(zop paramzop)
  {
    this.jdField_a_of_type_Zop = paramzop;
  }
  
  public void h()
  {
    this.jdField_a_of_type_Zop = null;
  }
  
  public void h(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troopUin", paramString1);
    localBundle.putString("type", paramString2);
    a(115, localBundle);
  }
  
  public void h(zop paramzop)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", a(paramzop));
    if (QLog.isColorLevel()) {
      QLog.d("Readinjoy", 2, "TroopMemberApiClient getReadinjoyCurrentSkin");
    }
    a(110, localBundle);
  }
  
  public void i()
  {
    a(89, null);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("nick", paramString2);
    a(143, localBundle);
  }
  
  public void i(zop paramzop)
  {
    a(141, new Bundle(), paramzop);
    AdReporterForAnalysis.reportForAPIInvoked(BaseApplicationImpl.getApplication(), true, "com.tencent.biz.troop.TroopMemberApiClient#gdtGetCurrentUserInfo(Callback)", "");
  }
  
  public void j()
  {
    a(104, new Bundle());
  }
  
  public void k()
  {
    a(116, new Bundle());
  }
  
  public void l()
  {
    a(124, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zon
 * JD-Core Version:    0.7.0.1
 */