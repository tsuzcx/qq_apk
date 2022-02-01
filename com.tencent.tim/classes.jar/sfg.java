import android.os.Environment;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class sfg
{
  public static final String PE = Environment.getExternalStorageDirectory() + "/qgtest/FaceSharpe/";
  public PtvTemplateManager.PtvTemplateInfo a;
  public String aDO;
  public String aDP;
  public boolean aLk = true;
  private int bwF = 0;
  public int bwG;
  public int bwH;
  public String mBid;
  public String mIconUrl;
  public String mId;
  public String mName;
  public int mType;
  public String mVideoUrl;
  
  public boolean MG()
  {
    return this.bwF == 1;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof sfg)) && (this.mId.equals(((sfg)paramObject).mId));
  }
  
  public String toString()
  {
    return "StoryGameInfo{mId='" + this.mId + '\'' + ", mName='" + this.mName + '\'' + ", mType=" + this.mType + ", mBid='" + this.mBid + '\'' + ", mIconUrl='" + this.mIconUrl + '\'' + ", mVideoUrl='" + this.mVideoUrl + "', mRankListId='" + this.aDO + '\'' + ", mIntroWording='" + this.aDP + '\'' + ", mDownloadProgress=" + this.bwG + ", mDownloadState=" + this.bwF + ", mPostureDance=" + this.a + ", bgmtype=" + this.bwH + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfg
 * JD-Core Version:    0.7.0.1
 */