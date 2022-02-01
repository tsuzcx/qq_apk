import com.tencent.qphone.base.util.QLog;

class zaa
  extends boiw
{
  zaa(yzz paramyzz) {}
  
  public void onCancel(String paramString) {}
  
  public void onFinish(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager onFinish key=" + paramString + " result=" + paramBoolean);
    }
  }
  
  public void onNetChange(int paramInt) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void onStart(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaa
 * JD-Core Version:    0.7.0.1
 */