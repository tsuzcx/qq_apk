import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wjw
  extends wkt
{
  public wjw(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(wks paramwks)
  {
    do
    {
      synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramwks.c);
        if ((paramwks instanceof wkn))
        {
          this.a.jdField_a_of_type_Wkc.a("", false, "download failed! msg = " + paramwks.d);
          return;
        }
      }
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
    wke localwke = paramwks.a();
    if (((paramwks instanceof wkf)) || (localwke.b)) {}
    synchronized (this.a.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.a.this$0.jdField_a_of_type_JavaUtilHashMap.remove(paramwks.c);
      this.a.jdField_a_of_type_Wkc.a(localwke.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */