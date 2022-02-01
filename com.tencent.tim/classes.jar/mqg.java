import com.tencent.image.URLDrawable.DownloadListener;

class mqg
  implements URLDrawable.DownloadListener
{
  mqg(mpy parammpy) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    mpy.b(this.b);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    mpy.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqg
 * JD-Core Version:    0.7.0.1
 */