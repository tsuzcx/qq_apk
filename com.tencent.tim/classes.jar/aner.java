import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;

final class aner
  extends aczc.b
{
  aner(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----locate");
    long l1 = System.currentTimeMillis();
    long l2 = aneq.access$100();
    avzj.j(paramInt, this.businessId, l1 - l2);
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      aneq.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.a));
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onLocationFinish succeed! gps=" + aneq.b());
    }
    for (;;)
    {
      aneq.Ir(paramInt);
      return;
      QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE]onLocationFinish failed: error in force gps info update..");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aner
 * JD-Core Version:    0.7.0.1
 */