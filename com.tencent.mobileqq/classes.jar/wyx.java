import com.tencent.qphone.base.util.QLog;

class wyx
  extends wzo
{
  wyx(wyt paramwyt, wzb paramwzb, String paramString)
  {
    super(paramwyt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Wyt.a));
      this.jdField_a_of_type_Wyt.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Wzb.a(this.jdField_a_of_type_JavaLangString, false, "splitAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyx
 * JD-Core Version:    0.7.0.1
 */