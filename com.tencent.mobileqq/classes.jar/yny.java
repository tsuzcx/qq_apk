import com.tencent.qphone.base.util.QLog;
import java.io.File;

class yny
  implements ynu
{
  yny(ynx paramynx, ynw paramynw) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Ynw.a)
      {
        this.jdField_a_of_type_Ynx.jdField_a_of_type_Yol.b(this.jdField_a_of_type_Ynx);
        return;
      }
      if (this.jdField_a_of_type_Ynx.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Ynx.jdField_a_of_type_Ynm.a(paramString1, this.jdField_a_of_type_Ynx.jdField_a_of_type_JavaLangString, new ynz(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Ynx.a(localFile, this.jdField_a_of_type_Ynx.b, new yob(this, l));
      return;
    }
    this.jdField_a_of_type_Ynx.d = paramString2;
    this.jdField_a_of_type_Ynx.jdField_a_of_type_Yol.a(this.jdField_a_of_type_Ynx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yny
 * JD-Core Version:    0.7.0.1
 */