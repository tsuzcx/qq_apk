import android.opengl.EGLContext;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;

public class amae
{
  public amai a;
  public amaq a;
  public ambf.a a;
  public int adjustRotation;
  public int agP = 8;
  public FollowCaptureParam b;
  public String bZF;
  public int bitRate;
  public boolean cBA;
  public boolean cBB;
  public boolean cBC;
  public boolean cBD;
  public boolean cBE;
  public boolean cBF = true;
  public int dBc;
  public int dBd;
  public int dBe;
  public int dzA = -1;
  public int dzB = -1;
  public int filterType;
  public int frameRate = 30;
  public int height;
  public String mosaicPath;
  public int orientation;
  public String outputFilePath;
  public EGLContext sharedContext;
  public String subtitleData;
  public String watermarkPath;
  public int width;
  
  public amae(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, String paramString2, String paramString3, String paramString4, boolean paramBoolean2)
  {
    this.outputFilePath = paramString1;
    this.width = paramInt1;
    this.height = paramInt2;
    this.bitRate = paramInt3;
    this.agP = paramInt4;
    this.filterType = paramInt6;
    this.cBA = paramBoolean1;
    this.watermarkPath = paramString2;
    this.mosaicPath = paramString3;
    this.frameRate = paramInt5;
    this.orientation = paramInt7;
    this.subtitleData = paramString4;
  }
  
  public amae(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    this(paramString, paramInt1, paramInt2, paramInt3, paramInt4, 30, 0, paramBoolean, paramInt5, null, null, null, false);
  }
  
  public EGLContext a()
  {
    return this.sharedContext;
  }
  
  public void a(EGLContext paramEGLContext)
  {
    this.sharedContext = paramEGLContext;
  }
  
  public String toString()
  {
    return "EncodeConfig{sharedContext=" + this.sharedContext + ", outputFilePath='" + this.outputFilePath + '\'' + ", width='" + this.width + '\'' + ", height='" + this.height + '\'' + ", bitRate='" + this.bitRate + '\'' + ", frameRate='" + this.frameRate + '\'' + ", iFrameInterval='" + this.agP + '\'' + ", filterType=" + this.filterType + ", needGenerateThumb=" + this.cBA + ", watermarkPath='" + this.watermarkPath + '\'' + ", mosaicPath='" + this.mosaicPath + '\'' + ", orientation=" + this.orientation + ", adjustRotation=" + this.adjustRotation + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amae
 * JD-Core Version:    0.7.0.1
 */