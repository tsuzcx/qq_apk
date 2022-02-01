import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import java.io.File;

public class ayql
{
  String aBc;
  boolean aIH;
  boolean aIJ;
  boolean aIK;
  int asi;
  String bN;
  double bo;
  double bp;
  int bsU;
  int bsV;
  Bitmap cL;
  float dw;
  int gP;
  String mFileDir;
  int mOrientationDegree;
  int mThumbWidth;
  
  public ayql(int paramInt1, int paramInt2, String paramString1, float paramFloat, boolean paramBoolean1, int paramInt3, double paramDouble1, double paramDouble2, String paramString2, int paramInt4, boolean paramBoolean2)
  {
    this.bsU = paramInt1;
    this.bsV = paramInt2;
    this.mFileDir = paramString1;
    this.dw = paramFloat;
    this.aIH = paramBoolean1;
    this.mOrientationDegree = paramInt3;
    this.bo = paramDouble1;
    this.bp = paramDouble2;
    this.aBc = paramString2;
    this.asi = paramInt4;
    this.aIK = paramBoolean2;
  }
  
  public ayql(@NonNull Bitmap paramBitmap, @NonNull String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat, double paramDouble1, double paramDouble2, int paramInt4)
  {
    this.bN = paramString;
    this.mOrientationDegree = paramInt3;
    this.dw = paramFloat;
    this.bo = paramDouble1;
    this.bp = paramDouble2;
    this.bsU = paramInt1;
    this.bsV = paramInt2;
    this.asi = paramInt4;
    this.cL = paramBitmap;
  }
  
  private void bvk()
  {
    this.mThumbWidth = 320;
    this.gP = ((int)(this.mThumbWidth / this.dw));
    if (this.gP % 2 > 0) {
      this.gP -= 1;
    }
    if (this.bsU > 0) {
      this.mThumbWidth = this.bsU;
    }
    if (this.bsV > 0) {
      this.gP = this.bsV;
    }
    ram.d("Q.qqstory.publish.edit.GenerateThumbTask", "FlowSendTask():mFileDir:" + this.mFileDir + ", mThumbWidth: " + this.mThumbWidth + ", mThumbHeight:" + this.gP + ", mThumbOK:" + this.aIJ + ", mShowLastFrameThumb:" + this.aIH + ", mExistThumbPath:" + this.aBc + ", mExistThumbOk:" + this.aIK);
  }
  
  private int tD()
  {
    int i = 0;
    if ((this.cL == null) || (this.bN == null))
    {
      ram.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. bitmap = null or path = null.");
      i = 1;
    }
    for (;;)
    {
      return i;
      if (!rop.d(this.cL, this.bN))
      {
        ram.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb error. compress thumb bitmap to file error.");
        return 1;
      }
      try
      {
        aqhu.a(this.bN, this.bo, this.bp);
        if (!new File(this.bN).exists())
        {
          ram.e("Q.qqstory.publish.edit.GenerateThumbTask", "saveThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", new Object[] { this.mFileDir, this.bN });
          return 1;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        if (this.bN == null) {}
      }
    }
    for (boolean bool = new File(this.bN).exists();; bool = false)
    {
      rar.b("video_edit", "update_LBS_exif_failed", 0, 0, new String[] { this.bN, String.valueOf(bool) });
      break;
    }
  }
  
  private int tE()
  {
    int i = 0;
    if ((this.aIH) && (VideoEnvironment.Jr() >= 21)) {
      RecordThumbnailUtils.nativeSetLastFrameCover(RecordThumbnailUtils.nu(this.mFileDir));
    }
    this.bN = RecordThumbnailUtils.a(this.mFileDir, this.mThumbWidth, this.gP, this.mOrientationDegree, Bitmap.Config.ARGB_8888);
    if ((this.mOrientationDegree == 90) || (this.mOrientationDegree == 270))
    {
      int j = this.mThumbWidth;
      this.mThumbWidth = this.gP;
      this.gP = j;
    }
    if (TextUtils.isEmpty(this.bN))
    {
      ram.e("Q.qqstory.publish.edit.GenerateThumbTask", "generateThumb, getNativeCover result is empty, vf dir = %s", new Object[] { this.mFileDir });
      i = 1;
    }
    for (;;)
    {
      return i;
      try
      {
        aqhu.a(this.bN, this.bo, this.bp);
        if (!new File(this.bN).exists())
        {
          ram.e("Q.qqstory.publish.edit.GenerateThumbTask", "generateThumb, coverFile not exists, vf dir = %s, mThumbPath = %s", new Object[] { this.mFileDir, this.bN });
          return 1;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        if (this.bN == null) {}
      }
    }
    for (boolean bool = new File(this.bN).exists();; bool = false)
    {
      rar.b("video_edit", "update_LBS_exif_failed", 0, 0, new String[] { this.bN, String.valueOf(bool) });
      break;
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l1 = SystemClock.uptimeMillis();
    bvk();
    if ((this.cL != null) && (this.bN != null)) {}
    for (int i = tD();; i = tE())
    {
      long l2 = SystemClock.uptimeMillis();
      if (i == 0) {
        rar.b("take_video", "create_thumb_time", 0, 0, new String[] { "" + (l2 - l1) });
      }
      rar.b("take_video", "create_thumb_result", 0, i, new String[0]);
      return Integer.valueOf(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayql
 * JD-Core Version:    0.7.0.1
 */