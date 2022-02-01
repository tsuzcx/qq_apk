import com.tencent.image.URLDrawable.DownloadListener;

class apiw
  implements URLDrawable.DownloadListener
{
  apiw(apit paramapit) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    apit.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apiw
 * JD-Core Version:    0.7.0.1
 */