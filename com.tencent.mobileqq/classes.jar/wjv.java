import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class wjv
  extends wkt
{
  public wjv(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(wks paramwks)
  {
    if ((paramwks instanceof wkn)) {
      this.a.jdField_a_of_type_Wkc.a("", false, "download failed! msg = " + paramwks.d);
    }
    do
    {
      return;
      if ((paramwks instanceof wkf))
      {
        this.a.jdField_a_of_type_Wkc.a("", false, "combine failed! msg = " + paramwks.d);
        return;
      }
    } while (!(paramwks instanceof wkq));
    this.a.jdField_a_of_type_Wkc.a("", false, "sending failed! msg = " + paramwks.d);
  }
  
  public void b(wks paramwks)
  {
    if ((paramwks instanceof wkq))
    {
      paramwks = paramwks.a();
      this.a.jdField_a_of_type_Wkc.a(paramwks.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wjv
 * JD-Core Version:    0.7.0.1
 */