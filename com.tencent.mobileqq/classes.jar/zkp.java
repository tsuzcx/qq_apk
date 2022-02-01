import com.tencent.qphone.base.util.QLog;

class zkp
  implements bbmo
{
  zkp(zko paramzko) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (zko.a(this.a))
    {
      zko.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(zko.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      zko.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (zko.a(this.a))
    {
      zko.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(zko.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      zko.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkp
 * JD-Core Version:    0.7.0.1
 */