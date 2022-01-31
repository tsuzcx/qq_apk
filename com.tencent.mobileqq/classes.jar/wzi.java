import com.tencent.qphone.base.util.QLog;
import java.io.File;

class wzi
  implements wze
{
  wzi(wzh paramwzh, wzg paramwzg) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Wzg.a)
      {
        this.jdField_a_of_type_Wzh.jdField_a_of_type_Wzv.b(this.jdField_a_of_type_Wzh);
        return;
      }
      if (this.jdField_a_of_type_Wzh.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Wzh.jdField_a_of_type_Wyw.a(paramString1, this.jdField_a_of_type_Wzh.jdField_a_of_type_JavaLangString, new wzj(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Wzh.a(localFile, this.jdField_a_of_type_Wzh.b, new wzl(this, l));
      return;
    }
    this.jdField_a_of_type_Wzh.d = paramString2;
    this.jdField_a_of_type_Wzh.jdField_a_of_type_Wzv.a(this.jdField_a_of_type_Wzh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzi
 * JD-Core Version:    0.7.0.1
 */