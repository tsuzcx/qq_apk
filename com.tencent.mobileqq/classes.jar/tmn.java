import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.weather.WeatherServlet;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class tmn
  extends SosoInterface.OnLocationListener
{
  tmn(tmm paramtmm, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramInt = (int)(paramSosoLbsInfo.a.a * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.a.b * 1000000.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onLocationFinish latitude:" + paramInt + ",longtitude:" + i);
      }
      WeatherServlet.a(this.a.a.a, paramInt, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmn
 * JD-Core Version:    0.7.0.1
 */