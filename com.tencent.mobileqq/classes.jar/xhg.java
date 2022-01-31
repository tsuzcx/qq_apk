import com.tencent.qphone.base.util.QLog;

class xhg
  implements wam
{
  xhg(xhf paramxhf, xhh paramxhh, xhi paramxhi) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Xhh != null)
    {
      this.jdField_a_of_type_Xhi.a(943004);
      this.jdField_a_of_type_Xhi.a(paramString);
      this.jdField_a_of_type_Xhh.b(this.jdField_a_of_type_Xhi);
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
    if (this.jdField_a_of_type_Xhh != null) {
      this.jdField_a_of_type_Xhh.a(this.jdField_a_of_type_Xhi);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhg
 * JD-Core Version:    0.7.0.1
 */