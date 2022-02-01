import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.requests.QCircleGetSessionInfoRequest;
import com.tencent.biz.qqcircle.requests.QCircleHeartbeatSignalReportRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
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

public class pcr
{
  private static volatile pcr a;
  private String OG;
  private String asy;
  private String asz;
  private boolean azn;
  private volatile ConcurrentHashMap<Integer, byte[]> bN = new ConcurrentHashMap();
  private volatile ConcurrentHashMap<Integer, Long> bO = new ConcurrentHashMap();
  private int bhh;
  private int bhi;
  private volatile byte[] bx;
  private volatile byte[] by;
  private volatile Stack<Integer> d = new Stack();
  private boolean mIsForeground;
  private String mToUin;
  private long zF;
  private long zG;
  
  private pcr()
  {
    QLog.d("QCircleReportHelper", 1, "newInstance");
  }
  
  public static boolean HN()
  {
    return ((BaseActivity.sTopActivity instanceof QCircleFolderActivity)) || ((BaseActivity.sTopActivity instanceof QCircleFragmentActivity));
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
  
  public static pcr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pcr();
      }
      return a;
    }
    finally {}
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
  
  private void a(FeedCloudCommon.StCommonExt paramStCommonExt, int paramInt)
  {
    paramStCommonExt = new QCircleGetSessionInfoRequest(paramStCommonExt, paramInt);
    VSNetworkHelper.a().a(paramStCommonExt, new pcs(this, paramInt));
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
          this.by = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
          this.bhh = paramStGetSessionInfoRsp.expireTime.get();
          long l = System.currentTimeMillis();
          this.zF = l;
          this.zG = l;
          QLog.d("QCircleReportHelper", 1, "handleReportSessionRsp scene:" + paramInt + ",Session:" + new String(this.by));
          bjy();
        } while (this.by == null);
        pcu.a().M(this.by);
        return;
      } while (1 != paramStGetSessionInfoRsp.sessionType.get());
      this.by = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
      this.bhh = paramStGetSessionInfoRsp.expireTime.get();
      this.zF = System.currentTimeMillis();
      return;
    } while (2 != paramStGetSessionInfoRsp.sessionType.get());
    g(36, paramStGetSessionInfoRsp.subSessonID.get().toByteArray());
  }
  
  private void bjA() {}
  
  private void bjx()
  {
    QLog.w("QCircleReportHelper", 1, "retireSession");
    this.bx = this.by;
    this.by = null;
    this.bN.clear();
  }
  
  private void bjy()
  {
    if ((this.azn) || (TextUtils.isEmpty(this.asy))) {}
    while (this.by == null) {
      return;
    }
    QLog.w("QCircleReportHelper", 1, "reportLaunch launchFrom:" + this.asy);
    pcj.a(this.mToUin, this.asy, this.asz, this.zG, this.bhi);
    this.azn = true;
  }
  
  private void bjz()
  {
    if ((HN()) && (this.zF > 0L) && (System.currentTimeMillis() - this.zF >= 600000L))
    {
      vs(3);
      if (this.mIsForeground) {
        this.zF = System.currentTimeMillis();
      }
    }
  }
  
  public static String getNetworkType()
  {
    int j = NetworkState.getNetworkType();
    int i = j;
    if (j == 0) {
      i = 9;
    }
    return String.valueOf(i);
  }
  
  private void vr(int paramInt)
  {
    if (this.bO != null)
    {
      long l = ((Long)this.bO.get(Integer.valueOf(paramInt))).longValue();
      if (l > 0L) {
        pcn.c(this.zG, System.currentTimeMillis() - l, paramInt, paramInt);
      }
    }
  }
  
  private void vs(int paramInt)
  {
    if (this.zF != 0L)
    {
      long l = System.currentTimeMillis() - this.zF;
      this.zF = 0L;
      QLog.w("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime intervalTime:" + l + "ms,signalOptType:" + paramInt);
      if (this.by == null) {}
      for (Object localObject = this.bx;; localObject = this.by)
      {
        localObject = new QCircleHeartbeatSignalReportRequest(l, paramInt, (byte[])localObject);
        VSNetworkHelper.a().a((VSBaseRequest)localObject, new pct(this, (QCircleHeartbeatSignalReportRequest)localObject));
        bjy();
        return;
      }
    }
    QLog.d("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime invalid intervalTime,direct return!");
  }
  
  public byte[] G()
  {
    return this.by;
  }
  
  public boolean HM()
  {
    return (this.bx != null) || (this.by != null);
  }
  
  public List<FeedCloudCommon.BytesEntry> a(int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramStFeed != null) && (paramStFeed.busiReport.has())) {
      localArrayList.add(a("FeedReportInfo", paramStFeed.busiReport.get().toByteArray()));
    }
    if (this.by != null) {
      localArrayList.add(a("SessionID", this.by));
    }
    for (;;)
    {
      if (e(paramInt) != null) {
        localArrayList.add(a("SubSessionID", e(paramInt)));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      return localArrayList;
      if (this.bx != null)
      {
        localArrayList.add(a("SessionID", this.bx));
        QLog.w("QCircleReportHelper", 2, "newSessionEntries mSession retired!try use oldSession");
      }
      else
      {
        QLog.e("QCircleReportHelper", 2, "newSessionEntries mSession is null!");
      }
    }
    return null;
  }
  
  public void aX(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        this.azn = false;
        this.asy = paramIntent.getString("key_jump_from", "");
        this.asz = paramIntent.getString("key_push_id", "");
        this.mToUin = paramIntent.getString("key_to_uin", "");
        if (TextUtils.isEmpty(this.asy)) {
          QLog.e("QCircleReportHelper", 1, "setLaunchIntent invalid launchfrom params");
        }
        bjy();
      }
    }
  }
  
  public void bjv()
  {
    QLog.w("QCircleReportHelper", 1, "initReportSession");
    this.bx = null;
    a(null, 1);
  }
  
  public void bjw()
  {
    a(null, 3);
  }
  
  public List<FeedCloudCommon.Entry> bz()
  {
    bjz();
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { a("uin", String.valueOf(aroi.a().getUin())), a("network_type", getNetworkType()), a("app_version", "3.4.4.3058"), a("qua", avpq.getQUA3()), a("platform", "android"), a("report_from", "1"), a("os_version", Build.VERSION.RELEASE), a("mobile_type", Build.MODEL), a("respond_type", arxr.getResolution()), a("device_info", Build.DEVICE), a("imei", arxr.getImei()), a("idfa", ""), a("idfv", "") }));
  }
  
  public byte[] e(int paramInt)
  {
    if (this.bN.containsKey(Integer.valueOf(paramInt))) {
      return (byte[])this.bN.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean eA(int paramInt)
  {
    return sb() == paramInt;
  }
  
  public boolean ex(int paramInt)
  {
    if (this.d != null) {
      return this.d.contains(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public boolean ey(int paramInt)
  {
    QLog.d("QCircleReportHelper", 2, "pushPageScene scene:" + paramInt);
    if (this.d != null)
    {
      if ((this.d.size() > 0) && (this.d.contains(Integer.valueOf(0))) && (paramInt == 0))
      {
        QLog.w("QCircleReportHelper", 2, "pushPageScene scene:" + paramInt + ",PageStack leak:" + this.d + ",force clear");
        this.d.clear();
        this.bO.clear();
        vs(1);
        bjx();
      }
      if (((this.d.size() == 0) && (paramInt != 36)) || ((this.d.size() == 1) && (((Integer)this.d.peek()).intValue() == 36))) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool)
        {
          this.bhi = paramInt;
          bjv();
          QLog.w("QCircleReportHelper", 1, "pushPageScene isFirstShowPageScene:" + paramInt);
        }
        this.d.push(Integer.valueOf(paramInt));
        this.bO.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
        pcu.a().flush();
        QLog.d("QCircleReportHelper", 2, "pushPageScene success");
        return bool;
      }
    }
    return false;
  }
  
  public boolean ez(int paramInt)
  {
    return getPageId() == paramInt;
  }
  
  public void g(int paramInt, byte[] paramArrayOfByte)
  {
    this.bN.put(Integer.valueOf(paramInt), paramArrayOfByte);
  }
  
  public int getPageId()
  {
    try
    {
      if ((this.d != null) && (this.d.size() > 0))
      {
        int i = ((Integer)this.d.peek()).intValue();
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
    return 0;
  }
  
  public String ma()
  {
    return this.OG;
  }
  
  public void onEnterBackground()
  {
    QLog.d("QCircleReportHelper", 2, "onQQEnterBackground!");
    if (HN())
    {
      vs(2);
      pcu.a().flush();
    }
    this.mIsForeground = false;
  }
  
  public void qz(String paramString)
  {
    this.OG = paramString;
  }
  
  public int sb()
  {
    try
    {
      if ((this.d != null) && (this.d.size() > 1))
      {
        int i = ((Integer)this.d.elementAt(this.d.size() - 2)).intValue();
        QZLog.d("QCircleReportHelper", 4, "getParentPageId:" + i);
        return i;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleReportHelper", 1, "getParentPageId exception:" + localException.toString());
      return 0;
    }
    return 0;
  }
  
  public int sc()
  {
    return this.d.size();
  }
  
  public void vq(int paramInt)
  {
    QLog.d("QCircleReportHelper", 2, "popPageScene scene:" + paramInt);
    if (this.d != null) {
      if (this.d.contains(Integer.valueOf(paramInt)))
      {
        if (((Integer)this.d.peek()).intValue() != paramInt) {
          break label132;
        }
        this.d.pop();
        vr(paramInt);
        QLog.d("QCircleReportHelper", 2, "popPageScene success");
      }
    }
    for (;;)
    {
      if (this.d.size() == 0)
      {
        QLog.w("QCircleReportHelper", 2, "popAllPage no QQCircle Page Alive");
        bjx();
        this.bO.clear();
        if (!HN())
        {
          vs(1);
          bjA();
        }
      }
      return;
      label132:
      QLog.e("QCircleReportHelper", 2, "popPageScene error!mismatch scene,current Page:" + this.d);
      if (36 == paramInt) {
        try
        {
          if (this.d.contains(Integer.valueOf(paramInt)))
          {
            paramInt = this.d.indexOf(Integer.valueOf(paramInt));
            if (paramInt != -1) {
              this.d.remove(paramInt);
            }
            QLog.w("QCircleReportHelper", 2, "after fix,mPageStack:" + this.d);
          }
        }
        catch (Exception localException)
        {
          QLog.e("QCircleReportHelper", 2, "fix error,exception:" + localException.toString() + ",mPageStack:" + this.d);
        }
      }
    }
  }
  
  public List<FeedCloudCommon.BytesEntry> z(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.by != null) {
      localArrayList.add(a("SessionID", this.by));
    }
    for (;;)
    {
      if (e(paramInt) != null) {
        localArrayList.add(a("SubSessionID", e(paramInt)));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      return localArrayList;
      if (this.bx != null)
      {
        localArrayList.add(a("SessionID", this.bx));
        QLog.w("QCircleReportHelper", 1, "newSessionEntries mSession retired!try use oldSession");
      }
      else
      {
        QLog.e("QCircleReportHelper", 1, "newSessionEntries mSession is null!");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcr
 * JD-Core Version:    0.7.0.1
 */