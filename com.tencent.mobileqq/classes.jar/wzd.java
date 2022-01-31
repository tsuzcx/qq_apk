import com.tencent.qphone.base.util.QLog;

class wzd
  extends wzr
{
  wzd(wyw paramwyw, wze paramwze, String paramString1, String paramString2)
  {
    super(paramwyw);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Wyw.a));
      this.jdField_a_of_type_Wyw.a = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wze.a(this.jdField_a_of_type_JavaLangString, true, "cmobine auido video done.");
      return;
    }
    this.jdField_a_of_type_Wze.a(this.b, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzd
 * JD-Core Version:    0.7.0.1
 */