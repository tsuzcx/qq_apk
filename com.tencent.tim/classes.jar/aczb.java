import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs.LbsData;
import com.tencent.biz.qqstory.network.pb.qqstory_lbs.ReqLbsReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class aczb
  implements Manager, BusinessObserver
{
  private long RF;
  private boolean bKt;
  private boolean bKu;
  private double bY;
  private double bZ;
  private long ib;
  private QQAppInterface mApp;
  private int mSeqKey;
  private ArrayList<LbsReportInfo> tX;
  
  public aczb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.tX = new ArrayList();
    aM(null);
  }
  
  public static void a(SosoInterface.SosoLocation paramSosoLocation, String paramString)
  {
    int i = 1;
    if ((paramSosoLocation.cd == 0.0D) || (paramSosoLocation.ce == 0.0D)) {
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1) {}
    Intent localIntent;
    for (;;)
    {
      localIntent = new Intent();
      localIntent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      localIntent.putExtra("is_runtime", 1001);
      localIntent.putExtra("lat", paramSosoLocation.cd);
      localIntent.putExtra("lng", paramSosoLocation.ce);
      localIntent.putExtra("alt", paramSosoLocation.altitude);
      localIntent.putExtra("accuracy", paramSosoLocation.accuracy);
      localIntent.putExtra("businessTag", paramString);
      if (!TextUtils.isEmpty(paramSosoLocation.nation)) {
        localIntent.putExtra("nation", paramSosoLocation.nation);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.province)) {
        localIntent.putExtra("province", paramSosoLocation.province);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.city)) {
        localIntent.putExtra("city", paramSosoLocation.city);
      }
      if (!TextUtils.isEmpty(paramSosoLocation.district)) {
        localIntent.putExtra("district", paramSosoLocation.district);
      }
      if (i == 0) {
        break label229;
      }
      paramSosoLocation = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramSosoLocation == null) {
        break;
      }
      ((aczb)paramSosoLocation.getManager(126)).dm(localIntent);
      return;
      i = 0;
    }
    label229:
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  private void aM(@Nullable JSONObject paramJSONObject)
  {
    boolean bool = true;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      paramJSONObject = v(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
      if (TextUtils.isEmpty(paramJSONObject)) {
        return;
      }
      localJSONObject = new JSONObject(paramJSONObject);
      if (localJSONObject.optInt("is_close_old_report") != 1) {
        break label79;
      }
    }
    catch (JSONException paramJSONObject)
    {
      while (QLog.isColorLevel())
      {
        QLog.e("LBSReport", 2, paramJSONObject, new Object[0]);
        return;
        label79:
        bool = false;
      }
    }
    this.bKu = bool;
    return;
  }
  
  private ArrayList<String> ae(ArrayList<LbsReportInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.get(i);
      if ((localLbsReportInfo != null) && (!TextUtils.isEmpty(localLbsReportInfo.content))) {
        localArrayList.add("dc01864");
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void cPl()
  {
    List localList = this.mApp.a().createEntityManager().query(LbsReportInfo.class);
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.tX.addAll(localList);
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list size is: " + localList.size());
      }
    }
    for (;;)
    {
      this.bKt = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "initLbsReportInfoFromDB info list is empty.");
      }
    }
  }
  
  private void k(byte[] paramArrayOfByte, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.mApp;
    if ((localQQAppInterface == null) || (paramArrayOfByte == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), jnl.class);
    localNewIntent.putExtra("cmd", "LbsSvc.lbs_report");
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("DataType", 2);
    localNewIntent.putExtra("retryTime", paramInt + 1);
    localNewIntent.putExtra("copyData", paramArrayOfByte);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  private int nextSeqKey()
  {
    for (;;)
    {
      try
      {
        if (this.mSeqKey <= 0)
        {
          this.mSeqKey = (new Random().nextInt(1000000) + 100);
          int i = this.mSeqKey;
          return i;
        }
        if (this.mSeqKey >= 1000100) {
          this.mSeqKey = 100;
        } else {
          this.mSeqKey += 1;
        }
      }
      finally {}
    }
  }
  
  private String v(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "lbs_report_config", "");
    if (QLog.isColorLevel()) {
      QLog.d("LBSReport", 2, "getLBSNewReport,lbs_report_config:" + paramContext);
    }
    return paramContext;
  }
  
  private void z(Context paramContext, String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramString1 + "_" + "lbs_report_config", paramString2).commit();
  }
  
  public void C(ArrayList<LbsReportInfo> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LBSReport", 2, "ProtoServlet StorySvc.lbs_report doNewReportLbsInfo: size = " + paramArrayList.size());
    }
    qqstory_lbs.ReqLbsReport localReqLbsReport = new qqstory_lbs.ReqLbsReport();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.next();
      qqstory_lbs.LbsData localLbsData = new qqstory_lbs.LbsData();
      localLbsData.alt.set(localLbsReportInfo.alt);
      localLbsData.lng.set(localLbsReportInfo.lng);
      localLbsData.lat.set(localLbsReportInfo.lat);
      localLbsData.accuracy.set(localLbsReportInfo.accuracy);
      if (!TextUtils.isEmpty(localLbsReportInfo.businessTag)) {
        localLbsData.bussinessTag.set(localLbsReportInfo.businessTag);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.nation)) {
        localLbsData.nation.set(localLbsReportInfo.nation);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.province)) {
        localLbsData.province.set(localLbsReportInfo.province);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.city)) {
        localLbsData.city.set(localLbsReportInfo.city);
      }
      if (!TextUtils.isEmpty(localLbsReportInfo.district)) {
        localLbsData.district.set(localLbsReportInfo.district);
      }
      localLbsData.plat_type.set(2);
      localLbsData.oper_time.set((int)localLbsReportInfo.operTime);
      localReqLbsReport.list_data.add(localLbsData);
    }
    k(localReqLbsReport.toByteArray(), paramInt);
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt1, int paramInt2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty()) || (paramArrayList2 == null) || (paramArrayList2.isEmpty())) {
      return;
    }
    QQAppInterface localQQAppInterface = this.mApp;
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), anfa.class);
    localNewIntent.putExtra("sendType", 10);
    localNewIntent.putExtra("seqKey", paramInt1);
    localNewIntent.putExtra("tags", paramArrayList1);
    localNewIntent.putExtra("contents", paramArrayList2);
    localNewIntent.putExtra("retryTime", paramInt2 + 1);
    localNewIntent.setObserver(this);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void aL(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("lbs_report_config");
    if (paramJSONObject != null) {
      z(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramJSONObject.toString());
    }
    aM(paramJSONObject);
  }
  
  public void dm(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("LBSReport", 2, "onReceiveLbsInfo intent is null. return.");
      }
    }
    double d1;
    double d2;
    double d3;
    float f;
    String str1;
    String str2;
    String str3;
    String str4;
    double d4;
    double d5;
    do
    {
      do
      {
        return;
        d1 = paramIntent.getDoubleExtra("lat", 0.0D);
        d2 = paramIntent.getDoubleExtra("lng", 0.0D);
        d3 = paramIntent.getDoubleExtra("alt", 0.0D);
        f = paramIntent.getFloatExtra("accuracy", 0.0F);
        str1 = paramIntent.getStringExtra("businessTag");
        str2 = paramIntent.getStringExtra("nation");
        str3 = paramIntent.getStringExtra("province");
        str4 = paramIntent.getStringExtra("city");
        paramIntent = paramIntent.getStringExtra("district");
        if ((d1 != 0.0D) && (d2 != 0.0D)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("LBSReport", 2, "onReceiveLbsInfo lat or lng is 0.0d. return.");
      return;
      d4 = TencentLocationUtils.distanceBetween(d1, d2, this.bY, this.bZ);
      d5 = SystemClock.elapsedRealtime() - this.RF;
      if ((d4 >= 20.0D) || (d5 >= 180000.0D)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("LBSReport", 2, "onReceiveLbsInfo distance is: " + d4 + " collectGap: " + d5);
    return;
    ThreadManager.executeOnSubThread(new LbsInfoReportManager.1(this, d1, d2, d3, f, str1, str2, str3, str4, paramIntent));
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    if (paramInt == 10)
    {
      j = paramBundle.getInt("seqKey");
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + j);
      }
      paramInt = i;
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      QQAppInterface localQQAppInterface = this.mApp;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null)) {
        a(paramBundle.getStringArrayList("tags"), paramBundle.getStringArrayList("contents"), j, paramInt);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramBundle.containsKey("cmd")) || (!"LbsSvc.lbs_report".equals(paramBundle.getString("cmd"))));
      paramInt = j;
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSReport", 2, "ProtoServlet StorySvc.lbs_report OnReceive: isSuccess =" + paramBoolean + ", retryTime = " + paramInt);
      }
    } while ((paramBoolean) || (paramInt >= 2));
    k(paramBundle.getByteArray("copyData"), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczb
 * JD-Core Version:    0.7.0.1
 */