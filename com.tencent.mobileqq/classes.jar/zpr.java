import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class zpr
  extends zqp
{
  public zpr(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(zqo paramzqo)
  {
    if ((paramzqo instanceof zqj)) {
      this.a.jdField_a_of_type_Zpy.a("", false, "download failed! msg = " + paramzqo.d);
    }
    do
    {
      return;
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
    if ((paramzqo instanceof zqm))
    {
      paramzqo = paramzqo.a();
      this.a.jdField_a_of_type_Zpy.a(paramzqo.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpr
 * JD-Core Version:    0.7.0.1
 */