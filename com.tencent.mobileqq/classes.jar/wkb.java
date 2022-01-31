import com.tencent.qphone.base.util.QLog;

class wkb
  extends wkp
{
  wkb(wju paramwju, wkc paramwkc, String paramString1, String paramString2)
  {
    super(paramwju);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Wju.a));
      this.jdField_a_of_type_Wju.a = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wkc.a(this.jdField_a_of_type_JavaLangString, true, "cmobine auido video done.");
      return;
    }
    this.jdField_a_of_type_Wkc.a(this.b, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wkb
 * JD-Core Version:    0.7.0.1
 */