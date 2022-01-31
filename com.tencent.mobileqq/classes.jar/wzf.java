import com.tencent.qphone.base.util.QLog;
import java.io.File;

class wzf
  implements wzb
{
  wzf(wze paramwze, wzd paramwzd) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Wzd.a)
      {
        this.jdField_a_of_type_Wze.jdField_a_of_type_Wzs.b(this.jdField_a_of_type_Wze);
        return;
      }
      if (this.jdField_a_of_type_Wze.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Wze.jdField_a_of_type_Wyt.a(paramString1, this.jdField_a_of_type_Wze.jdField_a_of_type_JavaLangString, new wzg(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Wze.a(localFile, this.jdField_a_of_type_Wze.b, new wzi(this, l));
      return;
    }
    this.jdField_a_of_type_Wze.d = paramString2;
    this.jdField_a_of_type_Wze.jdField_a_of_type_Wzs.a(this.jdField_a_of_type_Wze);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzf
 * JD-Core Version:    0.7.0.1
 */