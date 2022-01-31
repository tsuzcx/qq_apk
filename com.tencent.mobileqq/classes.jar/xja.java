import com.tencent.qphone.base.util.QLog;

class xja
  implements axrl
{
  xja(xiz paramxiz) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (xiz.a(this.a))
    {
      xiz.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(xiz.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      xiz.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (xiz.a(this.a))
    {
      xiz.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(xiz.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      xiz.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xja
 * JD-Core Version:    0.7.0.1
 */