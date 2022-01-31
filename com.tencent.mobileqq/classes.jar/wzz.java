import android.graphics.Bitmap;
import android.graphics.Canvas;

class wzz
{
  int jdField_a_of_type_Int;
  wqw jdField_a_of_type_Wqw;
  wxs jdField_a_of_type_Wxs;
  wxt jdField_a_of_type_Wxt;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public wzz(wzv paramwzv)
  {
    this.jdField_a_of_type_Int = aepi.a(15.0F, paramwzv.a());
    this.b = aepi.a(12.0F, paramwzv.a());
    this.c = aepi.a(2.0F, paramwzv.a());
    this.d = ((azkz.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Wqw = new wqw(aepi.a(3.0F, paramwzv.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Wxs = ((wxs)paramwzv.a(wxs.class));
    this.jdField_a_of_type_Wxt = ((wxt)paramwzv.a(wxt.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Wxs != null) {
      if (this.jdField_a_of_type_Wxs.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Wxt != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Wxt.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Wxs.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Wxt != null) {
            this.jdField_a_of_type_Wxt.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = xqw.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Wxs.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Wqw.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(xcs paramxcs, xaa paramxaa)
  {
    Bitmap localBitmap = xqw.a(paramxcs.c, this.e, this.f, false);
    paramxcs = null;
    if (localBitmap != null) {
      paramxcs = this.jdField_a_of_type_Wqw.a(localBitmap);
    }
    paramxaa.b = paramxcs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzz
 * JD-Core Version:    0.7.0.1
 */