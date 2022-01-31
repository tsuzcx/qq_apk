import com.tencent.qphone.base.util.QLog;

class vui
  implements avzm
{
  vui(vuh paramvuh) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (vuh.a(this.a))
    {
      vuh.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(vuh.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      vuh.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (vuh.a(this.a))
    {
      vuh.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(vuh.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      vuh.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vui
 * JD-Core Version:    0.7.0.1
 */