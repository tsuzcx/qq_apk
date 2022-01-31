import com.tencent.qphone.base.util.QLog;

class ynr
  extends yoh
{
  ynr(ynm paramynm, ynu paramynu, String paramString)
  {
    super(paramynm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitVideoUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Ynm.a));
      this.jdField_a_of_type_Ynm.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Ynu.a(this.jdField_a_of_type_JavaLangString, false, "splitVideo done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynr
 * JD-Core Version:    0.7.0.1
 */