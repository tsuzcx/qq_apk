import com.tencent.qphone.base.util.QLog;

class axre
  extends axrh
{
  axre(axrd paramaxrd) {}
  
  public void ax(String paramString, boolean paramBoolean) {}
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloadListener", 2, "notifyDownloadFinish key: " + paramString + ", success " + paramBoolean);
    }
    paramString = this.b;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.b.b.mProgress = 100;
        this.b.eNJ();
        return;
      }
      finally {}
      this.b.b.mProgress = -1;
      this.b.aeD(4);
    }
  }
  
  public void onCancel(String paramString) {}
  
  public void onProgress(String arg1, int paramInt)
  {
    synchronized (this.b)
    {
      this.b.b.mProgress = paramInt;
      return;
    }
  }
  
  public void vS(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axre
 * JD-Core Version:    0.7.0.1
 */