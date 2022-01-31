import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wyy
  extends wzv
{
  public wyy(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(wzu paramwzu)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramwzu.c);
        if ((paramwzu instanceof wzp))
        {
          this.a.jdField_a_of_type_Wze.a("", false, "download failed! msg = " + paramwzu.d);
          return;
        }
      }
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
    wzg localwzg = paramwzu.a();
    if (((paramwzu instanceof wzh)) || (localwzg.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramwzu.c);
      this.a.jdField_a_of_type_Wze.a(localwzg.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyy
 * JD-Core Version:    0.7.0.1
 */