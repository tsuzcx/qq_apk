import com.tencent.qphone.base.util.QLog;

class wjy
  extends wkp
{
  wjy(wju paramwju, wkc paramwkc, String paramString)
  {
    super(paramwju);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Wju.a));
      this.jdField_a_of_type_Wju.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Wkc.a(this.jdField_a_of_type_JavaLangString, false, "splitAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wjy
 * JD-Core Version:    0.7.0.1
 */