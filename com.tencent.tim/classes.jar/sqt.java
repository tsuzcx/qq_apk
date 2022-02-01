import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.opengl.EGL14;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class sqt
{
  private aman jdField_a_of_type_Aman;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private final String aBk;
  private boolean aIM = true;
  private int btI = 42;
  private final int mBitRate;
  private long mDuration;
  private final int mHeight;
  private int mOrientation;
  private long mTimeStamp;
  private final int mWidth;
  private ArrayList<Integer> ot = new ArrayList();
  
  public sqt(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean, int paramInt4)
  {
    this.aBk = paramString;
    this.mDuration = paramLong;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mBitRate = paramInt3;
    this.aIM = paramBoolean;
    this.mOrientation = paramInt4;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0)) {
      if (paramBitmap == null) {
        paramInt1 = i;
      }
    }
    do
    {
      return paramInt1;
      return GlUtil.createTexture(3553, paramBitmap);
      i = GlUtil.createTexture(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChain(new int[] { 170 }, null);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      paramInt1 = paramInt2;
    } while (i <= 0);
    GlUtil.deleteTexture(i);
    return paramInt2;
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      if (paramBitmap == null) {
        return 0;
      }
      return GlUtil.createTexture(3553, paramBitmap);
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    float f = paramInt1 * 1.0F / paramInt2;
    f = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(i * -0.5F, j * -0.5F);
    if ((this.mOrientation != 180) && (this.mOrientation != 270)) {
      localMatrix.postRotate(-180.0F, 0.0F, 1.0F);
    }
    localMatrix.postScale(-1.0F, 1.0F);
    f = paramInt1 * 1.0F / paramBitmap.getWidth();
    localMatrix.postScale(f, f);
    localMatrix.postTranslate(paramInt1 * 0.5F, paramInt2 * 0.5F);
    localCanvas.drawBitmap(paramBitmap, localMatrix, null);
    return GlUtil.createTexture(3553, localBitmap);
  }
  
  @TargetApi(17)
  @RequiresApi(api=17)
  public void a(List<Bitmap> paramList, sqo.a parama)
  {
    sqo.b localb = new sqo.b(0, "success");
    this.jdField_a_of_type_Aman = new aman();
    amae localamae = new amae(this.aBk, this.mWidth, this.mHeight, this.mBitRate, 1, false, 0);
    localamae.a(EGL14.eglGetCurrentContext());
    QLog.d("MuiltiImageToVideo", 2, this.aBk + " " + this.mWidth + " " + this.mHeight + " " + this.mBitRate);
    this.jdField_a_of_type_Aman.a(localamae, new squ(this, paramList, parama, localb));
    try
    {
      try
      {
        wait();
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void yN(int paramInt)
  {
    this.btI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqt
 * JD-Core Version:    0.7.0.1
 */