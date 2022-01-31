import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ysn
  implements ysj
{
  ysn(ysm paramysm, ysl paramysl) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Ysl.a)
      {
        this.jdField_a_of_type_Ysm.jdField_a_of_type_Yta.b(this.jdField_a_of_type_Ysm);
        return;
      }
      if (this.jdField_a_of_type_Ysm.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Ysm.jdField_a_of_type_Ysb.a(paramString1, this.jdField_a_of_type_Ysm.jdField_a_of_type_JavaLangString, new yso(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Ysm.a(localFile, this.jdField_a_of_type_Ysm.b, new ysq(this, l));
      return;
    }
    this.jdField_a_of_type_Ysm.d = paramString2;
    this.jdField_a_of_type_Ysm.jdField_a_of_type_Yta.a(this.jdField_a_of_type_Ysm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysn
 * JD-Core Version:    0.7.0.1
 */