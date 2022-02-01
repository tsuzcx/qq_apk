import com.tencent.qphone.base.util.QLog;

class ylp
  implements bagj
{
  ylp(ylo paramylo) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (ylo.a(this.a))
    {
      ylo.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(ylo.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      ylo.a(this.a).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (ylo.a(this.a))
    {
      ylo.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(ylo.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      ylo.a(this.a).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylp
 * JD-Core Version:    0.7.0.1
 */