import com.tencent.qphone.base.util.QLog;
import java.io.File;

class yob
  implements ynu
{
  yob(yny paramyny, long paramLong) {}
  
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
      this.jdField_a_of_type_Yny.jdField_a_of_type_Ynw.e = paramString1;
      this.jdField_a_of_type_Yny.jdField_a_of_type_Ynx.a.b(this.jdField_a_of_type_Yny.jdField_a_of_type_Ynx);
      this.jdField_a_of_type_Yny.jdField_a_of_type_Ynx.b();
      return;
    }
    this.jdField_a_of_type_Yny.jdField_a_of_type_Ynx.d = paramString2;
    this.jdField_a_of_type_Yny.jdField_a_of_type_Ynx.a.a(this.jdField_a_of_type_Yny.jdField_a_of_type_Ynx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yob
 * JD-Core Version:    0.7.0.1
 */