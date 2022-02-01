import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

class zxr
  implements FFmpegExecuteResponseCallback
{
  zxr(zxq paramzxq, zxs paramzxs, zxt paramzxt) {}
  
  public void onFailure(String paramString)
  {
    if (this.jdField_a_of_type_Zxs != null)
    {
      this.jdField_a_of_type_Zxt.a(943004);
      this.jdField_a_of_type_Zxt.a(paramString);
      this.jdField_a_of_type_Zxs.failed(this.jdField_a_of_type_Zxt);
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
    if (this.jdField_a_of_type_Zxs != null) {
      this.jdField_a_of_type_Zxs.success(this.jdField_a_of_type_Zxt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxr
 * JD-Core Version:    0.7.0.1
 */