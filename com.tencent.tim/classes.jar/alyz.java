import com.tencent.qphone.base.util.QLog;

class alyz
  implements amal
{
  alyz(alyy paramalyy, int[] paramArrayOfInt) {}
  
  public void a(int paramInt, Throwable arg2)
  {
    String str;
    if (??? != null) {
      str = ???.getMessage();
    }
    for (;;)
    {
      rar.b("video_edit", "reEncodeResult", this.mV[0], 0, new String[] { "", str });
      ram.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      alyy.a(this.a, paramInt);
      synchronized (alyy.a(this.a))
      {
        alyy.a(this.a, true);
        alyy.a(this.a).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void auv()
  {
    QLog.w("MergeEditVideo", 1, "mp4ReEncoder start!");
  }
  
  public void btD() {}
  
  public void kf(String arg1)
  {
    rar.b("video_edit", "reEncodeResult", this.mV[0], 0, new String[] { ??? });
    synchronized (alyy.a(this.a))
    {
      alyy.a(this.a, true);
      alyy.a(this.a).notifyAll();
      QLog.w("MergeEditVideo", 1, "mp4ReEncoder encode finish!");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyz
 * JD-Core Version:    0.7.0.1
 */