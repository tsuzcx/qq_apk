import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class yno
  extends yol
{
  public yno(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(yok paramyok)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramyok.c);
        if ((paramyok instanceof yof))
        {
          this.a.jdField_a_of_type_Ynu.a("", false, "download failed! msg = " + paramyok.d);
          return;
        }
      }
      if ((paramyok instanceof ynx))
      {
        this.a.jdField_a_of_type_Ynu.a("", false, "combine failed! msg = " + paramyok.d);
        return;
      }
    } while (!(paramyok instanceof yoi));
    this.a.jdField_a_of_type_Ynu.a("", false, "sending failed! msg = " + paramyok.d);
  }
  
  public void b(yok paramyok)
  {
    ynw localynw = paramyok.a();
    if (((paramyok instanceof ynx)) || (localynw.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramyok.c);
      this.a.jdField_a_of_type_Ynu.a(localynw.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yno
 * JD-Core Version:    0.7.0.1
 */