import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class axar
  extends aczc.b
{
  axar(axaq paramaxaq, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;
        axaq.a(this.b, paramSosoLbsInfo.a);
        double d1 = localSosoLocation.cd;
        double d2 = localSosoLocation.ce;
        axiy.i(axaq.access$100(), "LbsManagerService.startLocation: success");
        axaq.a(this.b, d1, d2);
        return;
      }
      axiy.i(axaq.access$100(), "LbsManagerService.startLocation: location is null");
      QLog.i("Q.videostory.capture", 2, "LbsManagerService.startLocation: location is null");
      return;
    }
    axiy.i(axaq.access$100(), "LbsManagerService.startLocation: failed");
    axaq.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axar
 * JD-Core Version:    0.7.0.1
 */