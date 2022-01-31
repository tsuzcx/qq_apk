import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ysd
  extends yta
{
  public ysd(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(ysz paramysz)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramysz.c);
        if ((paramysz instanceof ysu))
        {
          this.a.jdField_a_of_type_Ysj.a("", false, "download failed! msg = " + paramysz.d);
          return;
        }
      }
      if ((paramysz instanceof ysm))
      {
        this.a.jdField_a_of_type_Ysj.a("", false, "combine failed! msg = " + paramysz.d);
        return;
      }
    } while (!(paramysz instanceof ysx));
    this.a.jdField_a_of_type_Ysj.a("", false, "sending failed! msg = " + paramysz.d);
  }
  
  public void b(ysz paramysz)
  {
    ysl localysl = paramysz.a();
    if (((paramysz instanceof ysm)) || (localysl.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramysz.c);
      this.a.jdField_a_of_type_Ysj.a(localysl.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysd
 * JD-Core Version:    0.7.0.1
 */