import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ysq
  implements ysj
{
  ysq(ysn paramysn, long paramLong) {}
  
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
      this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysl.e = paramString1;
      this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysm.a.b(this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysm);
      this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysm.b();
      return;
    }
    this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysm.d = paramString2;
    this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysm.a.a(this.jdField_a_of_type_Ysn.jdField_a_of_type_Ysm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysq
 * JD-Core Version:    0.7.0.1
 */