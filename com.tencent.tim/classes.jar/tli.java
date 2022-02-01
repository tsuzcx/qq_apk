import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface.1.1;
import com.tencent.mobileqq.app.ThreadManager;

public class tli
  extends tlj
{
  tli(tlh paramtlh) {}
  
  public void o(int paramInt, String paramString1, String paramString2)
  {
    tkw.d("GdtC2SReporter", "onCheckC2SReport: " + paramInt + "， request ADID: " + paramString2);
    this.a.Ew = -2147483648L;
    if (tlh.a(this.a).equals(paramString2))
    {
      anot.c(null, "dc00898", "", "", "0X8009EBD", "0X8009EBD", this.a.bBZ, paramInt, "", "", tlh.a(this.a), "");
      if ((paramInt != 1) && (paramInt != 2)) {
        ThreadManager.executeOnNetWorkThread(new GdtC2SReportInterface.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tli
 * JD-Core Version:    0.7.0.1
 */