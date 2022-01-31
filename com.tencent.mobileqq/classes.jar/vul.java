import com.tencent.qphone.base.util.QLog;

class vul
  implements avzk
{
  vul(vuk paramvuk) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (vuk.a(this.a))
    {
      vuk.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(vuk.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      vuk.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (vuk.a(this.a))
    {
      vuk.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(vuk.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      vuk.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vul
 * JD-Core Version:    0.7.0.1
 */