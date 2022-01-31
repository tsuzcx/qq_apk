import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class wyx
  extends wzv
{
  public wyx(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(wzu paramwzu)
  {
    if ((paramwzu instanceof wzp)) {
      this.a.jdField_a_of_type_Wze.a("", false, "download failed! msg = " + paramwzu.d);
    }
    do
    {
      return;
      if ((paramwzu instanceof wzh))
      {
        this.a.jdField_a_of_type_Wze.a("", false, "combine failed! msg = " + paramwzu.d);
        return;
      }
    } while (!(paramwzu instanceof wzs));
    this.a.jdField_a_of_type_Wze.a("", false, "sending failed! msg = " + paramwzu.d);
  }
  
  public void b(wzu paramwzu)
  {
    if ((paramwzu instanceof wzs))
    {
      paramwzu = paramwzu.a();
      this.a.jdField_a_of_type_Wze.a(paramwzu.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyx
 * JD-Core Version:    0.7.0.1
 */