import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;

public abstract class ambs
{
  public static final String ROOT_PATH = CameraCaptureView.e.bZi;
  private String mBasePath;
  public long mSeed;
  
  public ambs(long paramLong)
  {
    this.mSeed = paramLong;
  }
  
  private void dMi()
  {
    if (this.mBasePath == null) {
      this.mBasePath = (ROOT_PATH + this.mSeed + "/");
    }
  }
  
  public final String getAudioPath()
  {
    dMi();
    return this.mBasePath + "audio.mp4";
  }
  
  public String getBasePath()
  {
    dMi();
    return this.mBasePath;
  }
  
  public final String getThumbPath()
  {
    dMi();
    return this.mBasePath + "thumb.jpg";
  }
  
  public final String yK()
  {
    dMi();
    return this.mBasePath + "combine.mp4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambs
 * JD-Core Version:    0.7.0.1
 */