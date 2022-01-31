import com.tencent.qphone.base.util.QLog;
import java.io.File;

class wki
  implements wkc
{
  wki(wkh paramwkh, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineWordingTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wke.e = paramString1;
      this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wkf.a.b(this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wkf);
      this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wkf.b();
      return;
    }
    this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wkf.d = paramString2;
    this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wkf.a.a(this.jdField_a_of_type_Wkh.a.jdField_a_of_type_Wkf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wki
 * JD-Core Version:    0.7.0.1
 */