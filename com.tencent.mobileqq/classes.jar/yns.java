import com.tencent.qphone.base.util.QLog;

class yns
  extends yoh
{
  yns(ynm paramynm, ynu paramynu, String paramString)
  {
    super(paramynm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "mixAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "mixAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Ynm.a));
      this.jdField_a_of_type_Ynm.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Ynu.a(this.jdField_a_of_type_JavaLangString, false, "mixAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yns
 * JD-Core Version:    0.7.0.1
 */