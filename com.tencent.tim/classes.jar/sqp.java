import com.tencent.qphone.base.util.QLog;

class sqp
  implements rqi
{
  sqp(sqo paramsqo, sqo.a parama, sqo.b paramb) {}
  
  public void onFailure(String paramString)
  {
    if (this.a != null)
    {
      this.b.setCode(943004);
      this.b.setMessage(paramString);
      this.a.b(this.b);
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
    if (this.a != null) {
      this.a.a(this.b);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqp
 * JD-Core Version:    0.7.0.1
 */