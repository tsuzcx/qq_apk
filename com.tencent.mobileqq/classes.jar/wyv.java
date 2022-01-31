import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wyv
  extends wzs
{
  public wyv(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(wzr paramwzr)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramwzr.c);
        if ((paramwzr instanceof wzm))
        {
          this.a.jdField_a_of_type_Wzb.a("", false, "download failed! msg = " + paramwzr.d);
          return;
        }
      }
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
    wzd localwzd = paramwzr.a();
    if (((paramwzr instanceof wze)) || (localwzd.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramwzr.c);
      this.a.jdField_a_of_type_Wzb.a(localwzd.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyv
 * JD-Core Version:    0.7.0.1
 */