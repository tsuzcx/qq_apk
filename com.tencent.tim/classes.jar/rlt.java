import android.media.MediaFormat;

public class rlt
{
  public String aBm;
  public String aBn;
  public int bth = 1;
  public String mFile;
  public boolean mHasAudioTrack;
  public long mID = -1L;
  public MediaFormat mMediaFormat;
  public int mResult = -1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Image2result.result ").append("src: ").append(this.aBm);
    localStringBuilder.append("result ").append(this.mResult);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlt
 * JD-Core Version:    0.7.0.1
 */