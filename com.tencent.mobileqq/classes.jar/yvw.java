import com.tencent.qphone.base.util.QLog;

class yvw
  implements xpb
{
  yvw(yvv paramyvv, yvx paramyvx, yvy paramyvy) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Yvx != null)
    {
      this.jdField_a_of_type_Yvy.a(943004);
      this.jdField_a_of_type_Yvy.a(paramString);
      this.jdField_a_of_type_Yvx.b(this.jdField_a_of_type_Yvy);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo failure");
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo finish");
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (this.jdField_a_of_type_Yvx != null) {
      this.jdField_a_of_type_Yvx.a(this.jdField_a_of_type_Yvy);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvw
 * JD-Core Version:    0.7.0.1
 */