import com.tencent.qphone.base.util.QLog;

class zal
  implements xtk
{
  zal(zak paramzak, zam paramzam, zan paramzan) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Zam != null)
    {
      this.jdField_a_of_type_Zan.a(943004);
      this.jdField_a_of_type_Zan.a(paramString);
      this.jdField_a_of_type_Zam.b(this.jdField_a_of_type_Zan);
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
    if (this.jdField_a_of_type_Zam != null) {
      this.jdField_a_of_type_Zam.a(this.jdField_a_of_type_Zan);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zal
 * JD-Core Version:    0.7.0.1
 */