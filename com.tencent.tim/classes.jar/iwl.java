import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.RGBATexSaveProcess;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Arrays;
import java.util.List;

public class iwl
{
  public List<PointF> fz;
  public float hA = 0.5F;
  public float hB = 0.5F;
  public float hC = 0.5F;
  public float hD;
  public float hE;
  public float hF;
  public Frame mCopyFrame;
  public byte[] mData;
  public int mHeight;
  public RectF mRectF = new RectF();
  public int mTextureId;
  public int mWidth;
  
  private boolean isSkinColor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 80) && (paramInt2 <= 80) && (paramInt3 <= 80)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return false;
      } while (((paramInt1 < 230) && (paramInt2 < 230) && (paramInt3 < 230) && ((paramInt3 >= paramInt2) || (paramInt2 >= paramInt1))) || (paramInt1 + paramInt2 > 400));
      l1 = 12800 - paramInt1 * 32 + paramInt2 * 48 - paramInt3 * 12;
      l2 = paramInt1 * 44 + 12800 - paramInt2 * 37 - paramInt3 * 7;
    } while ((l1 < 8500L) || (l1 > 13500L) || (l2 < 26000L - l1) || (l2 > 28000L - l1));
    return true;
  }
  
  public void a(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    float f = 320.0F / Math.max(paramInt1, paramInt2);
    paramList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList));
    float[] arrayOfFloat1 = new float[4];
    arrayOfFloat1[0] = ((PointF)paramList.get(99)).x;
    arrayOfFloat1[1] = ((PointF)paramList.get(101)).x;
    arrayOfFloat1[2] = ((PointF)paramList.get(103)).x;
    arrayOfFloat1[3] = ((PointF)paramList.get(105)).x;
    float[] arrayOfFloat2 = new float[4];
    arrayOfFloat2[0] = ((PointF)paramList.get(99)).y;
    arrayOfFloat2[1] = ((PointF)paramList.get(101)).y;
    arrayOfFloat2[2] = ((PointF)paramList.get(103)).y;
    arrayOfFloat2[3] = ((PointF)paramList.get(105)).y;
    Arrays.sort(arrayOfFloat1);
    Arrays.sort(arrayOfFloat2);
    this.mRectF.left = (arrayOfFloat1[0] * f);
    this.mRectF.right = (arrayOfFloat1[3] * f);
    this.mRectF.top = (arrayOfFloat2[0] * f);
    this.mRectF.bottom = (f * arrayOfFloat2[3]);
  }
  
  public boolean a(RGBATexSaveProcess paramRGBATexSaveProcess)
  {
    float f = 320.0F / Math.max(this.mWidth, this.mHeight);
    int i = (int)(this.mWidth * f);
    int j = (int)(f * this.mHeight);
    if ((this.mData == null) || (this.mData.length != i * j * 4)) {
      this.mData = new byte[i * j * 4];
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceProcessorItem", 2, "WL_DEBUG retrieveData w=" + i + "h=" + j);
    }
    this.mData = paramRGBATexSaveProcess.retrieveData(this.mTextureId, i, j);
    return true;
  }
  
  public void arA()
  {
    int m = 0;
    int n = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    if (m < this.mData.length)
    {
      int i11 = this.mData[m] & 0xFF;
      int i10 = this.mData[(m + 1)] & 0xFF;
      int i9 = this.mData[(m + 2)] & 0xFF;
      int i4 = (m >> 2) / 240;
      if ((this.mRectF.contains((m >> 2) % 240, i4)) && (isSkinColor(i11, i10, i9))) {}
      for (int i8 = 1;; i8 = 0)
      {
        int i7 = n;
        int i6 = i1;
        int i5 = i2;
        i4 = i3;
        if (i8 != 0)
        {
          i4 = i3 + i11;
          i5 = i2 + i10;
          i6 = i1 + i9;
          i7 = n + 1;
        }
        k += i11;
        j += i10;
        i += i9;
        m += 4;
        n = i7;
        i1 = i6;
        i2 = i5;
        i3 = i4;
        break;
      }
    }
    float f3;
    float f2;
    if (n == 0)
    {
      f1 = (this.mData.length >> 2) * 255;
      f3 = k / f1;
      f2 = j / f1;
    }
    for (float f1 = i / f1;; f1 = i1 / f1)
    {
      this.hA = f3;
      this.hB = f2;
      this.hC = f1;
      return;
      f1 = n * 255;
      f3 = i3 / f1;
      f2 = i2 / f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwl
 * JD-Core Version:    0.7.0.1
 */