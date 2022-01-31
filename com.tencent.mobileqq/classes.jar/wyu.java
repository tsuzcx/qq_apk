import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class wyu
  extends wzs
{
  public wyu(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(wzr paramwzr)
  {
    if ((paramwzr instanceof wzm)) {
      this.a.jdField_a_of_type_Wzb.a("", false, "download failed! msg = " + paramwzr.d);
    }
    do
    {
      return;
      if ((paramwzr instanceof wze))
      {
        this.a.jdField_a_of_type_Wzb.a("", false, "combine failed! msg = " + paramwzr.d);
        return;
      }
    } while (!(paramwzr instanceof wzp));
    this.a.jdField_a_of_type_Wzb.a("", false, "sending failed! msg = " + paramwzr.d);
  }
  
  public void b(wzr paramwzr)
  {
    if ((paramwzr instanceof wzp))
    {
      paramwzr = paramwzr.a();
      this.a.jdField_a_of_type_Wzb.a(paramwzr.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */