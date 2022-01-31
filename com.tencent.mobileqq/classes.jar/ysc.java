import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class ysc
  extends yta
{
  public ysc(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(ysz paramysz)
  {
    if ((paramysz instanceof ysu)) {
      this.a.jdField_a_of_type_Ysj.a("", false, "download failed! msg = " + paramysz.d);
    }
    do
    {
      return;
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
    if ((paramysz instanceof ysx))
    {
      paramysz = paramysz.a();
      this.a.jdField_a_of_type_Ysj.a(paramysz.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysc
 * JD-Core Version:    0.7.0.1
 */