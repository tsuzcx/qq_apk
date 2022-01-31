import com.tencent.qphone.base.util.QLog;

class wyy
  extends wzo
{
  wyy(wyt paramwyt, wzb paramwzb, String paramString)
  {
    super(paramwyt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitVideoUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_Wyt.a));
      this.jdField_a_of_type_Wyt.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_Wzb.a(this.jdField_a_of_type_JavaLangString, false, "splitVideo done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyy
 * JD-Core Version:    0.7.0.1
 */