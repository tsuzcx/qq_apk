import com.tencent.qphone.base.util.QLog;

class rmh
  implements amal
{
  rmh(rmg paramrmg) {}
  
  public void a(int paramInt, Throwable arg2)
  {
    synchronized (rmg.a(this.b))
    {
      rmg.b(this.b, true);
      if (QLog.isColorLevel()) {
        QLog.d(rmg.TAG, 2, "onEncodeError, errorCode= " + paramInt);
      }
      rmg.a(this.b).notifyAll();
      return;
    }
  }
  
  public void auv() {}
  
  public void btD() {}
  
  public void kf(String paramString)
  {
    synchronized (rmg.a(this.b))
    {
      rmg.a(this.b, true);
      if (QLog.isColorLevel()) {
        QLog.d(rmg.TAG, 2, "onEncodeFinish, filePath= " + paramString);
      }
      rmg.a(this.b).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmh
 * JD-Core Version:    0.7.0.1
 */