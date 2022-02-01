import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class ynj
{
  int jdField_a_of_type_Int;
  yei jdField_a_of_type_Yei;
  ylc jdField_a_of_type_Ylc;
  yld jdField_a_of_type_Yld;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public ynj(ynf paramynf)
  {
    this.jdField_a_of_type_Int = AIOUtils.dp2px(15.0F, paramynf.a());
    this.b = AIOUtils.dp2px(12.0F, paramynf.a());
    this.c = AIOUtils.dp2px(2.0F, paramynf.a());
    this.d = ((ScreenUtil.SCREEN_WIDTH - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Yei = new yei(AIOUtils.dp2px(3.0F, paramynf.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Ylc = ((ylc)paramynf.a(ylc.class));
    this.jdField_a_of_type_Yld = ((yld)paramynf.a(yld.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Ylc != null) {
      if (this.jdField_a_of_type_Ylc.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Yld != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Yld.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Ylc.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Yld != null) {
            this.jdField_a_of_type_Yld.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = zdr.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Ylc.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Yei.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(yqa paramyqa, ynk paramynk)
  {
    Bitmap localBitmap = zdr.a(paramyqa.c, this.e, this.f, false);
    paramyqa = null;
    if (localBitmap != null) {
      paramyqa = this.jdField_a_of_type_Yei.a(localBitmap);
    }
    paramynk.b = paramyqa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */