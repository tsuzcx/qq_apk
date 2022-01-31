import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class ynn
  extends yol
{
  public ynn(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(yok paramyok)
  {
    if ((paramyok instanceof yof)) {
      this.a.jdField_a_of_type_Ynu.a("", false, "download failed! msg = " + paramyok.d);
    }
    do
    {
      return;
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
    if ((paramyok instanceof yoi))
    {
      paramyok = paramyok.a();
      this.a.jdField_a_of_type_Ynu.a(paramyok.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynn
 * JD-Core Version:    0.7.0.1
 */