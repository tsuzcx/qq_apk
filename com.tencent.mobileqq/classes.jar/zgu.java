import com.tencent.qphone.base.util.QLog;

class zgu
  implements batv
{
  zgu(zgt paramzgt) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (zgt.a(this.a))
    {
      zgt.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(zgt.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      zgt.a(this.a).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (zgt.a(this.a))
    {
      zgt.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(zgt.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      zgt.a(this.a).notifyAll();
      return;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgu
 * JD-Core Version:    0.7.0.1
 */