import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class lcg
  extends aczc.b
{
  lcg(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    lcf.access$002(false);
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "onLocationFinish errCode = ", Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      ocp.y(100, new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcg
 * JD-Core Version:    0.7.0.1
 */