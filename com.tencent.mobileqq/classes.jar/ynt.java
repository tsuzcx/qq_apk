import com.tencent.qphone.base.util.QLog;

class ynt
  extends yoh
{
  ynt(ynm paramynm, ynu paramynu, String paramString1, String paramString2)
  {
    super(paramynm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Ynm.a));
      this.jdField_a_of_type_Ynm.a = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ynu.a(this.jdField_a_of_type_JavaLangString, true, "cmobine auido video done.");
      return;
    }
    this.jdField_a_of_type_Ynu.a(this.b, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynt
 * JD-Core Version:    0.7.0.1
 */