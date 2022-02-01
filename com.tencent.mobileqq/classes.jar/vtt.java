import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetSessionInfoRequest;
import com.tencent.biz.qqcircle.requests.QCircleHeartbeatSignalReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleReport.SingleDcData;

public class vtt
{
  private static volatile vtt jdField_a_of_type_Vtt;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private volatile Stack<Integer> jdField_a_of_type_JavaUtilStack = new Stack();
  private volatile ConcurrentHashMap<Integer, byte[]> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private volatile byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private volatile ConcurrentHashMap<Long, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private volatile byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private volatile ConcurrentHashMap<Long, String> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile ConcurrentHashMap<Integer, Long> d = new ConcurrentHashMap();
  
  private vtt()
  {
    QLog.d("QCircleReportHelper", 1, "newInstance");
  }
  
  public static FeedCloudCommon.BytesEntry a(String paramString, byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    if (paramString != null) {
      localBytesEntry.key.set(paramString);
    }
    if (paramArrayOfByte != null) {
      localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    return localBytesEntry;
  }
  
  public static FeedCloudCommon.Entry a(String paramString1, String paramString2)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  public static FeedCloudCommon.Entry a(Map.Entry<String, String> paramEntry)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramEntry.getKey() != null) {
      localEntry.key.set((String)paramEntry.getKey());
    }
    if (paramEntry.getValue() != null) {
      localEntry.value.set((String)paramEntry.getValue());
    }
    return localEntry;
  }
  
  public static QQCircleReport.SingleDcData a(int paramInt, List<FeedCloudCommon.Entry> paramList1, List<FeedCloudCommon.Entry> paramList2, List<FeedCloudCommon.BytesEntry> paramList)
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      localSingleDcData.byteExtinfo.addAll(paramList);
    }
    return localSingleDcData;
  }
  
  public static vtt a()
  {
    if (jdField_a_of_type_Vtt == null) {}
    try
    {
      if (jdField_a_of_type_Vtt == null) {
        jdField_a_of_type_Vtt = new vtt();
      }
      return jdField_a_of_type_Vtt;
    }
    finally {}
  }
  
  private void a(FeedCloudCommon.StCommonExt paramStCommonExt, int paramInt)
  {
    paramStCommonExt = new QCircleGetSessionInfoRequest(paramStCommonExt, paramInt);
    VSNetworkHelper.a().a(paramStCommonExt, new vtu(this, paramInt));
  }
  
  private void a(FeedCloudRead.StGetSessionInfoRsp paramStGetSessionInfoRsp, int paramInt)
  {
    if (paramStGetSessionInfoRsp != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (1 != paramStGetSessionInfoRsp.sessionType.get());
          this.jdField_b_of_type_ArrayOfByte = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
          this.jdField_a_of_type_Int = paramStGetSessionInfoRsp.expireTime.get();
          long l = System.currentTimeMillis();
          this.jdField_a_of_type_Long = l;
          this.jdField_b_of_type_Long = l;
          QLog.d("QCircleReportHelper", 1, "handleReportSessionRsp scene:" + paramInt + ",Session:" + new String(this.jdField_b_of_type_ArrayOfByte));
          h();
        } while (this.jdField_b_of_type_ArrayOfByte == null);
        vtw.a().a(this.jdField_b_of_type_ArrayOfByte);
        return;
      } while (1 != paramStGetSessionInfoRsp.sessionType.get());
      this.jdField_b_of_type_ArrayOfByte = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
      this.jdField_a_of_type_Int = paramStGetSessionInfoRsp.expireTime.get();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    } while (2 != paramStGetSessionInfoRsp.sessionType.get());
    a(36, paramStGetSessionInfoRsp.subSessonID.get().toByteArray());
  }
  
  public static String b()
  {
    int j = NetworkState.getNetworkType();
    int i = j;
    if (j == 0) {
      i = 9;
    }
    return String.valueOf(i);
  }
  
  public static boolean b()
  {
    return ((BaseActivity.sTopActivity instanceof QCircleFolderActivity)) || ((BaseActivity.sTopActivity instanceof QCircleFragmentActivity)) || (c());
  }
  
  public static boolean c()
  {
    if ((BaseActivity.sTopActivity instanceof PublicTransFragmentActivity))
    {
      PublicTransFragmentActivity localPublicTransFragmentActivity = (PublicTransFragmentActivity)BaseActivity.sTopActivity;
      if ((localPublicTransFragmentActivity != null) && (localPublicTransFragmentActivity.a() != null) && ((localPublicTransFragmentActivity.a() instanceof QCircleContentDetailFragment))) {
        return true;
      }
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    if (this.d != null)
    {
      Long localLong = (Long)this.d.get(Integer.valueOf(paramInt));
      if ((localLong != null) && (localLong.longValue() > 0L))
      {
        vtp.a(this.jdField_b_of_type_Long, System.currentTimeMillis() - localLong.longValue(), paramInt, paramInt);
        QLog.d("QCircleReportHelper", 2, "recordPageEndShow:scene:" + paramInt + ",cost:" + (System.currentTimeMillis() - localLong.longValue()) + "ms");
        this.d.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  private void f()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= this.jdField_a_of_type_Int * 1000)
    {
      b();
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      QLog.w("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime intervalTime:" + l + "ms,signalOptType:" + paramInt);
      if (this.jdField_b_of_type_ArrayOfByte == null) {}
      for (Object localObject = this.jdField_a_of_type_ArrayOfByte;; localObject = this.jdField_b_of_type_ArrayOfByte)
      {
        localObject = new QCircleHeartbeatSignalReportRequest(l, paramInt, (byte[])localObject);
        VSNetworkHelper.a().a((VSBaseRequest)localObject, new vtv(this, (QCircleHeartbeatSignalReportRequest)localObject));
        h();
        return;
      }
    }
    QLog.d("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime invalid intervalTime,direct return!");
  }
  
  private void g()
  {
    QLog.w("QCircleReportHelper", 1, "retireSession");
    this.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (this.jdField_b_of_type_ArrayOfByte == null) {
      return;
    }
    QLog.w("QCircleReportHelper", 1, "reportLaunch launchFrom:" + this.jdField_a_of_type_JavaLangString);
    vtl.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void i()
  {
    if ((b()) && (this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 600000L))
    {
      f(3);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  private void j() {}
  
  @Deprecated
  public int a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilStack != null) && (this.jdField_a_of_type_JavaUtilStack.size() > 0))
      {
        int i = ((Integer)this.jdField_a_of_type_JavaUtilStack.peek()).intValue();
        QZLog.d("QCircleReportHelper", 4, "getPageId:" + i);
        return i;
      }
      QZLog.e("QCircleReportHelper", 1, new Object[] { "getPageId error!" });
      return 0;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleReportHelper", 1, "getPageId exception:" + localException.toString());
    }
    return -1;
  }
  
  public String a()
  {
    return (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(uzg.a()));
  }
  
  public List<FeedCloudCommon.Entry> a()
  {
    i();
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { a("uin", String.valueOf(bjjo.a().a())), a("network_type", b()), a("app_version", "8.4.5.4745"), a("qua", bmsw.a()), a("platform", "android"), a("report_from", "1"), a("os_version", Build.VERSION.RELEASE), a("mobile_type", Build.MODEL), a("respond_type", bjve.e()), a("device_info", Build.DEVICE), a("imei", bjve.c()), a("idfa", ""), a("idfv", "") }));
  }
  
  public List<FeedCloudCommon.BytesEntry> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_ArrayOfByte != null) {
      localArrayList.add(a("SessionID", this.jdField_b_of_type_ArrayOfByte));
    }
    for (;;)
    {
      if (a(paramInt) != null) {
        localArrayList.add(a("SubSessionID", a(paramInt)));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      return localArrayList;
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        localArrayList.add(a("SessionID", this.jdField_a_of_type_ArrayOfByte));
        QLog.w("QCircleReportHelper", 1, "newSessionEntries mSession retired!try use oldSession");
      }
      else
      {
        QLog.e("QCircleReportHelper", 1, "newSessionEntries mSession is null!");
      }
    }
    return null;
  }
  
  public List<FeedCloudCommon.BytesEntry> a(int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.busiReport.has())) {
      return a(paramInt, paramStFeed.busiReport.get().toByteArray());
    }
    return a(paramInt);
  }
  
  public List<FeedCloudCommon.BytesEntry> a(int paramInt, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte != null) {
      localArrayList.add(a("FeedReportInfo", paramArrayOfByte));
    }
    if (this.jdField_b_of_type_ArrayOfByte != null) {
      localArrayList.add(a("SessionID", this.jdField_b_of_type_ArrayOfByte));
    }
    for (;;)
    {
      if (a(paramInt) != null) {
        localArrayList.add(a("SubSessionID", a(paramInt)));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      return localArrayList;
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        localArrayList.add(a("SessionID", this.jdField_a_of_type_ArrayOfByte));
        QLog.w("QCircleReportHelper", 2, "newSessionEntries mSession retired!try use oldSession");
      }
      else
      {
        QLog.e("QCircleReportHelper", 2, "newSessionEntries mSession is null!");
      }
    }
    return null;
  }
  
  public void a()
  {
    QLog.w("QCircleReportHelper", 1, "initReportSession");
    this.jdField_a_of_type_ArrayOfByte = null;
    a(null, 1);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleReportHelper", 2, "pushPageScene scene:" + paramInt);
    if (this.jdField_a_of_type_JavaUtilStack != null)
    {
      if ((this.jdField_a_of_type_JavaUtilStack.size() > 0) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 0)) && (this.jdField_a_of_type_JavaUtilStack.contains(Integer.valueOf(paramInt))))
      {
        QLog.w("QCircleReportHelper", 2, "pushPageScene scene:" + paramInt + ",PageStack leak:" + this.jdField_a_of_type_JavaUtilStack + ",force clear");
        this.jdField_a_of_type_JavaUtilStack.clear();
        this.d.clear();
        f(1);
        g();
      }
      this.jdField_a_of_type_JavaUtilStack.push(Integer.valueOf(paramInt));
      vtw.a().a();
      QLog.d("QCircleReportHelper", 2, "pushPageScene success");
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent.getExtras();
      paramIntent = (QCircleInitBean)paramIntent.getSerializableExtra("key_bundle_common_init_bean");
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = paramIntent.getLaunchFrom();
      this.jdField_b_of_type_JavaLangString = paramIntent.getLaunchId();
      this.jdField_c_of_type_JavaLangString = paramIntent.getUin();
      this.jdField_b_of_type_Int = paramInt;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        QLog.e("QCircleReportHelper", 1, "setLaunchIntent invalid launchfrom params");
      }
      a();
      QLog.w("QCircleReportHelper", 1, "launchPageScene:" + paramInt);
      h();
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramArrayOfByte);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(uzg.a()));
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(uzg.a()), paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_b_of_type_ArrayOfByte != null);
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (byte[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilStack.size();
  }
  
  public void b()
  {
    a(null, 2);
  }
  
  public void b(int paramInt)
  {
    QLog.d("QCircleReportHelper", 2, "popPageScene scene:" + paramInt);
    if ((this.jdField_a_of_type_JavaUtilStack != null) && (this.jdField_a_of_type_JavaUtilStack.contains(Integer.valueOf(paramInt))))
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilStack.peek()).intValue() != paramInt) {
        break label127;
      }
      this.jdField_a_of_type_JavaUtilStack.pop();
      QLog.d("QCircleReportHelper", 2, "popPageScene success");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilStack.size() == 0)
      {
        QLog.w("QCircleReportHelper", 2, "no QQCircle Page Alive");
        g();
        this.d.clear();
        if (!b())
        {
          f(1);
          j();
        }
      }
      return;
      label127:
      QLog.e("QCircleReportHelper", 2, "popPageScene error!mismatch scene,current Page:" + this.jdField_a_of_type_JavaUtilStack);
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(uzg.a()));
      return;
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(uzg.a()), paramString);
  }
  
  public void c()
  {
    a(null, 3);
  }
  
  public void c(int paramInt)
  {
    this.d.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    QLog.d("QCircleReportHelper", 2, "recordPageStartShow:scene:" + paramInt);
  }
  
  public void d()
  {
    QLog.d("QCircleReportHelper", 2, "onQQEnterForeground!");
    if (b()) {
      f();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void d(int paramInt)
  {
    e(paramInt);
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_JavaUtilStack.contains(Integer.valueOf(0))) && (this.jdField_a_of_type_JavaUtilStack.size() == 1)) || (this.jdField_a_of_type_JavaUtilStack.size() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public void e()
  {
    QLog.d("QCircleReportHelper", 2, "onQQEnterBackground!");
    if (b())
    {
      f(2);
      vtw.a().a();
    }
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtt
 * JD-Core Version:    0.7.0.1
 */