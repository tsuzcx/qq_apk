import com.tencent.qphone.base.util.QLog;

class wyg
  implements vnq
{
  wyg(wyf paramwyf, wyh paramwyh, wyi paramwyi) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Wyh != null)
    {
      this.jdField_a_of_type_Wyi.a(943004);
      this.jdField_a_of_type_Wyi.a(paramString);
      this.jdField_a_of_type_Wyh.b(this.jdField_a_of_type_Wyi);
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
    if (this.jdField_a_of_type_Wyh != null) {
      this.jdField_a_of_type_Wyh.a(this.jdField_a_of_type_Wyi);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wyg
 * JD-Core Version:    0.7.0.1
 */