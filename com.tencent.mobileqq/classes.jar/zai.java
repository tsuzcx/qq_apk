import com.tencent.qphone.base.util.QLog;

class zai
  implements bbmy
{
  zai(zah paramzah) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (zah.a(this.a))
    {
      zah.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(zah.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      zah.a(this.a).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (zah.a(this.a))
    {
      zah.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(zah.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      zah.a(this.a).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zai
 * JD-Core Version:    0.7.0.1
 */