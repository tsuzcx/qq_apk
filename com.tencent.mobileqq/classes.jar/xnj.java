import com.tencent.qphone.base.util.QLog;

class xnj
  implements axvu
{
  xnj(xni paramxni) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (xni.a(this.a))
    {
      xni.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(xni.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      xni.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (xni.a(this.a))
    {
      xni.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(xni.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      xni.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnj
 * JD-Core Version:    0.7.0.1
 */