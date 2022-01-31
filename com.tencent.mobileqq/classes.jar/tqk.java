import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class tqk
  extends ampn
{
  tqk(tqj paramtqj, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        tqj.a(this.a, paramSosoLbsInfo);
        return;
      }
      QLog.d("QCircleGpsHelper", 2, "preGetLocation get GpsInfo from request: location is null");
      return;
    }
    QLog.d("QCircleGpsHelper", 2, "preGetLocation get GpsInfo from request: failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqk
 * JD-Core Version:    0.7.0.1
 */