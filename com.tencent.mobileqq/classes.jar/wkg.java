import com.tencent.qphone.base.util.QLog;
import java.io.File;

class wkg
  implements wkc
{
  wkg(wkf paramwkf, wke paramwke) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Wke.a)
      {
        this.jdField_a_of_type_Wkf.jdField_a_of_type_Wkt.b(this.jdField_a_of_type_Wkf);
        return;
      }
      if (this.jdField_a_of_type_Wkf.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Wkf.jdField_a_of_type_Wju.a(paramString1, this.jdField_a_of_type_Wkf.jdField_a_of_type_JavaLangString, new wkh(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Wkf.a(localFile, this.jdField_a_of_type_Wkf.b, new wkj(this, l));
      return;
    }
    this.jdField_a_of_type_Wkf.d = paramString2;
    this.jdField_a_of_type_Wkf.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Wkf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wkg
 * JD-Core Version:    0.7.0.1
 */