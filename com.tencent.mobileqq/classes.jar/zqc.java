import com.tencent.qphone.base.util.QLog;
import java.io.File;

class zqc
  implements zpy
{
  zqc(zqb paramzqb, zqa paramzqa) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Zqa.a)
      {
        this.jdField_a_of_type_Zqb.jdField_a_of_type_Zqp.b(this.jdField_a_of_type_Zqb);
        return;
      }
      if (this.jdField_a_of_type_Zqb.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Zqb.jdField_a_of_type_Zpq.a(paramString1, this.jdField_a_of_type_Zqb.jdField_a_of_type_JavaLangString, new zqd(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Zqb.a(localFile, this.jdField_a_of_type_Zqb.b, new zqf(this, l));
      return;
    }
    this.jdField_a_of_type_Zqb.d = paramString2;
    this.jdField_a_of_type_Zqb.jdField_a_of_type_Zqp.a(this.jdField_a_of_type_Zqb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqc
 * JD-Core Version:    0.7.0.1
 */