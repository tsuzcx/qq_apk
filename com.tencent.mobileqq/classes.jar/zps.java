import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class zps
  extends zqp
{
  public zps(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(zqo paramzqo)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramzqo.c);
        if ((paramzqo instanceof zqj))
        {
          this.a.jdField_a_of_type_Zpy.a("", false, "download failed! msg = " + paramzqo.d);
          return;
        }
      }
      if ((paramzqo instanceof zqb))
      {
        this.a.jdField_a_of_type_Zpy.a("", false, "combine failed! msg = " + paramzqo.d);
        return;
      }
    } while (!(paramzqo instanceof zqm));
    this.a.jdField_a_of_type_Zpy.a("", false, "sending failed! msg = " + paramzqo.d);
  }
  
  public void b(zqo paramzqo)
  {
    zqa localzqa = paramzqo.a();
    if (((paramzqo instanceof zqb)) || (localzqa.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramzqo.c);
      this.a.jdField_a_of_type_Zpy.a(localzqa.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zps
 * JD-Core Version:    0.7.0.1
 */