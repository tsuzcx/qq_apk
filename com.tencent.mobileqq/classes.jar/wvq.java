import android.graphics.Bitmap;
import android.graphics.Canvas;

class wvq
{
  int jdField_a_of_type_Int;
  wmn jdField_a_of_type_Wmn;
  wtj jdField_a_of_type_Wtj;
  wtk jdField_a_of_type_Wtk;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public wvq(wvm paramwvm)
  {
    this.jdField_a_of_type_Int = aekt.a(15.0F, paramwvm.a());
    this.b = aekt.a(12.0F, paramwvm.a());
    this.c = aekt.a(2.0F, paramwvm.a());
    this.d = ((azgq.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Wmn = new wmn(aekt.a(3.0F, paramwvm.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Wtj = ((wtj)paramwvm.a(wtj.class));
    this.jdField_a_of_type_Wtk = ((wtk)paramwvm.a(wtk.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Wtj != null) {
      if (this.jdField_a_of_type_Wtj.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Wtk != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Wtk.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Wtj.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Wtk != null) {
            this.jdField_a_of_type_Wtk.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = xmn.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Wtj.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Wmn.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(wyj paramwyj, wvr paramwvr)
  {
    Bitmap localBitmap = xmn.a(paramwyj.c, this.e, this.f, false);
    paramwyj = null;
    if (localBitmap != null) {
      paramwyj = this.jdField_a_of_type_Wmn.a(localBitmap);
    }
    paramwvr.b = paramwyj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvq
 * JD-Core Version:    0.7.0.1
 */