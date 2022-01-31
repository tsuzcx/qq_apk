import com.tencent.qphone.base.util.QLog;

class vhp
  implements auzr
{
  vhp(vho paramvho) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (vho.a(this.a))
    {
      vho.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(vho.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      vho.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (vho.a(this.a))
    {
      vho.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(vho.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      vho.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhp
 * JD-Core Version:    0.7.0.1
 */