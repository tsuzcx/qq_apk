import com.tencent.qphone.base.util.QLog;

class wzk
  extends waa
{
  wzk(wze paramwze, wzo paramwzo) {}
  
  public void onFailure(String paramString)
  {
    QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + paramString);
    this.jdField_a_of_type_Wzo.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + paramString);
      QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Wze.a.a));
    }
    this.jdField_a_of_type_Wze.a.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzk
 * JD-Core Version:    0.7.0.1
 */