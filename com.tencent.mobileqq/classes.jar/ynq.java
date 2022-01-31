import com.tencent.qphone.base.util.QLog;

class ynq
  extends yoh
{
  ynq(ynm paramynm, ynu paramynu, String paramString)
  {
    super(paramynm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Ynm.a));
      this.jdField_a_of_type_Ynm.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Ynu.a(this.jdField_a_of_type_JavaLangString, false, "splitAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynq
 * JD-Core Version:    0.7.0.1
 */