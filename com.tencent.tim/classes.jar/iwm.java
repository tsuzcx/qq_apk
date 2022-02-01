import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;

public class iwm
  extends iqq
{
  private Bitmap bq;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  Canvas mCanvas = new Canvas();
  private int mTextureId;
  
  private void onUpdate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceTexture", 2, "WL_DEBUG onUpdate start");
    }
    int j;
    int m;
    int i;
    int k;
    if ((this.mBitmapWidth > 0) && (this.mBitmapHeight > 0) && (this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      if (this.mBitmapWidth * this.viewHeight > this.mBitmapHeight * this.viewWidth)
      {
        j = this.viewWidth * this.mBitmapHeight / this.viewHeight;
        m = (this.mBitmapWidth - j) / 2;
        i = this.mBitmapHeight;
        k = 0;
        if ((this.bq == null) || (this.bq.isRecycled()) || (j != this.bq.getWidth()) || (i != this.bq.getHeight())) {
          break label278;
        }
        Rect localRect = new Rect(m, k, m + j, k + i);
        RectF localRectF = new RectF(0.0F, 0.0F, j, i);
        this.mCanvas.setBitmap(this.bq);
        this.mCanvas.drawBitmap(this.mBitmap, localRect, localRectF, null);
        this.mCanvas.setBitmap(null);
        label206:
        invalidateContent();
        setTextureSize(this.bq.getWidth(), this.bq.getHeight());
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceTexture", 2, "WL_DEBUG onUpdate end");
      }
      return;
      i = this.viewHeight * this.mBitmapWidth / this.viewWidth;
      k = (this.mBitmapHeight - i) / 2;
      j = this.mBitmapWidth;
      m = 0;
      break;
      label278:
      if ((this.bq != null) && (!this.bq.isRecycled()) && (this.bq != this.mBitmap))
      {
        this.bq.recycle();
        this.bq = null;
      }
      this.bq = Bitmap.createBitmap(this.mBitmap, m, k, j, i);
      this.mState = 0;
      break label206;
      if ((this.bq != null) && (!this.bq.isRecycled()))
      {
        this.bq.recycle();
        this.bq = null;
      }
    }
  }
  
  public void E(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceTexture", 2, "WL_DEBUG setTextureId start");
    }
    this.mTextureId = paramInt1;
    this.mBitmapWidth = paramInt2;
    this.mBitmapHeight = paramInt3;
    if ((this.mBitmapWidth > 0) && (this.mBitmapHeight > 0)) {
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (this.mBitmap.getWidth() == this.mBitmapWidth) && (this.mBitmap.getHeight() == this.mBitmapHeight))
      {
        RendererUtils.saveTextureToBitmap(this.mTextureId, this.mBitmapWidth, this.mBitmapHeight, this.mBitmap);
        onUpdate();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceTexture", 2, "WL_DEBUG setTextureId end");
      }
      return;
      Bitmap localBitmap = RendererUtils.saveTexture(this.mTextureId, this.mBitmapWidth, this.mBitmapHeight);
      if (this.mBitmap != localBitmap)
      {
        if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          this.mBitmap.recycle();
        }
        this.mBitmap = localBitmap;
        onUpdate();
        continue;
        if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
        {
          this.mBitmap.recycle();
          this.mBitmap = null;
        }
      }
    }
  }
  
  public void lr(int paramInt)
  {
    if (this.viewWidth != paramInt)
    {
      super.lr(paramInt);
      onUpdate();
    }
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap) {}
  
  protected Bitmap onGetBitmap()
  {
    return this.bq;
  }
  
  public void setViewHeight(int paramInt)
  {
    if (this.viewHeight != paramInt)
    {
      super.setViewHeight(paramInt);
      onUpdate();
    }
  }
  
  public boolean vP()
  {
    return (this.mTextureId != 0) && (this.mBitmapWidth != 0) && (this.mBitmapHeight != 0) && (this.bq != null) && (!this.bq.isRecycled());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwm
 * JD-Core Version:    0.7.0.1
 */