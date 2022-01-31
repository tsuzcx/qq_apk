import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface.1.1;
import com.tencent.mobileqq.app.ThreadManager;

public class yoq
  extends yor
{
  yoq(yop paramyop) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    yny.a("GdtC2SReporter", "onCheckC2SReport: " + paramInt + "， request ADID: " + paramString2);
    yom.a(BaseApplicationImpl.getApplication(), this.a, paramInt, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_Long = -2147483648L;
    if (yop.a(this.a).equals(paramString2))
    {
      awqx.a(null, "dc00898", "", "", "0X8009EBD", "0X8009EBD", this.a.jdField_a_of_type_Int, paramInt, "", "", yop.a(this.a), "");
      if ((paramInt != 1) && (paramInt != 2)) {
        ThreadManager.executeOnNetWorkThread(new GdtC2SReportInterface.1.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yoq
 * JD-Core Version:    0.7.0.1
 */