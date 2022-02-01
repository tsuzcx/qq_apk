import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StGPSV2;

public class ouq
{
  private static volatile ouq jdField_a_of_type_Ouq;
  private FeedCloudMeta.StGPSV2 jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2 = new FeedCloudMeta.StGPSV2();
  private boolean ayD;
  
  public static ouq a()
  {
    if (jdField_a_of_type_Ouq == null) {}
    try
    {
      if (jdField_a_of_type_Ouq == null) {
        jdField_a_of_type_Ouq = new ouq();
      }
      return jdField_a_of_type_Ouq;
    }
    finally {}
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    this.ayD = true;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2.lat.set(Double.valueOf(paramSosoLbsInfo.a.cd * 1000000.0D).intValue());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2.lon.set(Double.valueOf(paramSosoLbsInfo.a.ce * 1000000.0D).intValue());
  }
  
  public boolean HA()
  {
    return (Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
  }
  
  public FeedCloudMeta.StGPSV2 a()
  {
    if (this.ayD) {
      return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2;
    }
    return null;
  }
  
  public void bhM()
  {
    this.ayD = false;
    if (HA())
    {
      SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a("qqcircle");
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
      {
        a(localSosoLbsInfo);
        QLog.d("QCircleGpsHelper", 2, "preGetLocation get GpsInfo from cache");
      }
    }
    else
    {
      return;
    }
    QLog.d("QCircleGpsHelper", 2, "preGetLocation get GpsInfo from request");
    aczc.a(new our(this, "qqcircle", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouq
 * JD-Core Version:    0.7.0.1
 */