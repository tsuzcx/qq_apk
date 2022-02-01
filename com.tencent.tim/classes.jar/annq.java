import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class annq
{
  public static String ceT = "";
  
  private static String a(String paramString1, String paramString2, String paramString3, annq.a parama, int paramInt)
  {
    QLog.e("AVShortVideoReportController", 1, "getReportingDetail");
    paramString1 = new StringBuilder(64);
    paramString1.append(paramString2).append('|');
    paramString1.append(paramString3).append('|');
    paramString1.append("${count_unknown}").append('|');
    paramString1.append(parama.ceU).append('|');
    paramString1.append(parama.roomid).append('|');
    paramString1.append(parama.ceV).append('|');
    paramString1.append(parama.ceW).append('|');
    paramString1.append(parama.ceX).append('|');
    paramString1.append(parama.ceY).append('|');
    paramString1.append(parama.ceZ).append('|');
    paramString1.append(parama.function).append('|');
    paramString1.append(parama.cfa).append('|');
    paramString1.append(parama.cfb).append('|');
    paramString1.append(parama.cfc).append('|');
    paramString1.append(parama.cfd).append('|');
    paramString1.append(parama.cfe).append('|');
    paramString1.append(parama.cff).append('|');
    paramString1.append(parama.cfg).append('|');
    paramString1.append(parama.cfh).append('|');
    paramString1.append(parama.cfi).append('|');
    paramString1.append(parama.cfj).append('|');
    paramString1.append(parama.cfk).append('|');
    paramString1.append(parama.cfl).append('|');
    paramString1.append(parama.cfm).append('|');
    paramString1.append(parama.cfn).append('|');
    return paramString1.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, annq.a parama)
  {
    paramString1 = a(paramString2, paramString1, paramString3, parama, 1);
    if (QLog.isColorLevel()) {
      QLog.i("AVShortVideoReportController", 2, "POST getReportingDetail=" + paramString1);
    }
    paramString3 = new Intent();
    paramString3.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
    paramString3.putExtra("reporting_tag", paramString2);
    paramString3.putExtra("reporting_detail", paramString1);
    paramString3.putExtra("reporting_count", 1);
    paramString3.putExtra("is_runtime", 0);
    BaseApplicationImpl.getApplication().sendBroadcast(paramString3);
  }
  
  public static class a
  {
    public String ceU = "";
    public String ceV = "";
    public String ceW = "";
    public String ceX = "";
    public String ceY = "";
    public String ceZ = "";
    public String cfa = "";
    public String cfb = "";
    public String cfc = "";
    public String cfd = "";
    public String cfe = "";
    public String cff = "";
    public String cfg = "";
    public String cfh = "";
    public String cfi = "";
    public String cfj = "";
    public String cfk = "";
    public String cfl = "";
    public String cfm = "";
    public String cfn = "";
    public String function = "";
    public String roomid = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annq
 * JD-Core Version:    0.7.0.1
 */