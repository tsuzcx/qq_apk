import android.app.Activity;
import java.lang.ref.WeakReference;

public class rks
{
  public final String aBa;
  public final boolean aGI;
  public final boolean aIH;
  public final double bo;
  public final double bp;
  public final int bsU;
  public final int bsV;
  public final float dw;
  public final WeakReference<Activity> mActivity;
  public final String mFileDir;
  public final int mOrientation;
  
  public rks(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, float paramFloat, boolean paramBoolean1, int paramInt3, double paramDouble1, double paramDouble2, String paramString2, boolean paramBoolean2)
  {
    this.bsU = paramInt1;
    this.bsV = paramInt2;
    this.mActivity = new WeakReference(paramActivity);
    this.mFileDir = paramString1;
    this.dw = paramFloat;
    this.aIH = paramBoolean1;
    this.mOrientation = paramInt3;
    this.bo = paramDouble1;
    this.bp = paramDouble2;
    this.aBa = paramString2;
    this.aGI = paramBoolean2;
  }
  
  public String toString()
  {
    return "GenerateThumbArgs{mFileDir='" + this.mFileDir + '\'' + ", mRatioWH=" + this.dw + ", mShowLastFrameThumb=" + this.aIH + ", mOrientation=" + this.mOrientation + ", mLatitude=" + this.bo + ", mLongitude=" + this.bp + ", mExistsThumbPath=" + this.aBa + ", mThumbOk=" + this.aGI + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rks
 * JD-Core Version:    0.7.0.1
 */