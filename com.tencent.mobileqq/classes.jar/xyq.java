import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class xyq
{
  int jdField_a_of_type_Int;
  xpn jdField_a_of_type_Xpn;
  xwj jdField_a_of_type_Xwj;
  xwk jdField_a_of_type_Xwk;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public xyq(xym paramxym)
  {
    this.jdField_a_of_type_Int = AIOUtils.dp2px(15.0F, paramxym.a());
    this.b = AIOUtils.dp2px(12.0F, paramxym.a());
    this.c = AIOUtils.dp2px(2.0F, paramxym.a());
    this.d = ((ScreenUtil.SCREEN_WIDTH - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Xpn = new xpn(AIOUtils.dp2px(3.0F, paramxym.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Xwj = ((xwj)paramxym.a(xwj.class));
    this.jdField_a_of_type_Xwk = ((xwk)paramxym.a(xwk.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Xwj != null) {
      if (this.jdField_a_of_type_Xwj.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Xwk != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Xwk.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Xwj.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Xwk != null) {
            this.jdField_a_of_type_Xwk.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = yoy.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Xwj.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Xpn.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(ybh paramybh, xyr paramxyr)
  {
    Bitmap localBitmap = yoy.a(paramybh.c, this.e, this.f, false);
    paramybh = null;
    if (localBitmap != null) {
      paramybh = this.jdField_a_of_type_Xpn.a(localBitmap);
    }
    paramxyr.b = paramybh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyq
 * JD-Core Version:    0.7.0.1
 */