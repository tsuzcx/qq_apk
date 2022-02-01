import com.tencent.qphone.base.util.QLog;
import java.io.File;

class zqf
  implements zpy
{
  zqf(zqc paramzqc, long paramLong) {}
  
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
      this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqa.e = paramString1;
      this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqb.a.b(this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqb);
      this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqb.b();
      return;
    }
    this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqb.d = paramString2;
    this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqb.a.a(this.jdField_a_of_type_Zqc.jdField_a_of_type_Zqb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqf
 * JD-Core Version:    0.7.0.1
 */