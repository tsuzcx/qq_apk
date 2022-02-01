import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StGPSV2;

public class uyq
{
  private static volatile uyq jdField_a_of_type_Uyq;
  private FeedCloudMeta.StGPSV2 jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2 = new FeedCloudMeta.StGPSV2();
  private boolean jdField_a_of_type_Boolean;
  
  public static uyq a()
  {
    if (jdField_a_of_type_Uyq == null) {}
    try
    {
      if (jdField_a_of_type_Uyq == null) {
        jdField_a_of_type_Uyq = new uyq();
      }
      return jdField_a_of_type_Uyq;
    }
    finally {}
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2.lat.set(Double.valueOf(paramSosoLbsInfo.a.a * 1000000.0D).intValue());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2.lon.set(Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue());
  }
  
  public FeedCloudMeta.StGPSV2 a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StGPSV2;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (a())
    {
      SosoInterface.SosoLbsInfo localSosoLbsInfo = apch.a("qqcircle");
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
    apch.a(new uyr(this, "qqcircle", true));
  }
  
  public boolean a()
  {
    return (Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyq
 * JD-Core Version:    0.7.0.1
 */