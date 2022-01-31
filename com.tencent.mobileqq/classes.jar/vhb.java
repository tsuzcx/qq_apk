import android.graphics.Bitmap;
import android.graphics.Canvas;

class vhb
{
  int jdField_a_of_type_Int;
  uxy jdField_a_of_type_Uxy;
  veu jdField_a_of_type_Veu;
  vev jdField_a_of_type_Vev;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public vhb(vgx paramvgx)
  {
    this.jdField_a_of_type_Int = actn.a(15.0F, paramvgx.a());
    this.b = actn.a(12.0F, paramvgx.a());
    this.c = actn.a(2.0F, paramvgx.a());
    this.d = ((axli.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Uxy = new uxy(actn.a(3.0F, paramvgx.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Veu = ((veu)paramvgx.a(veu.class));
    this.jdField_a_of_type_Vev = ((vev)paramvgx.a(vev.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Veu != null) {
      if (this.jdField_a_of_type_Veu.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Vev != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Vev.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Veu.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Vev != null) {
            this.jdField_a_of_type_Vev.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = vxy.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Veu.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Uxy.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(vju paramvju, vhc paramvhc)
  {
    Bitmap localBitmap = vxy.a(paramvju.c, this.e, this.f, false);
    paramvju = null;
    if (localBitmap != null) {
      paramvju = this.jdField_a_of_type_Uxy.a(localBitmap);
    }
    paramvhc.b = paramvju;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhb
 * JD-Core Version:    0.7.0.1
 */