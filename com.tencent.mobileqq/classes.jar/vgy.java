import android.graphics.Bitmap;
import android.graphics.Canvas;

class vgy
{
  int jdField_a_of_type_Int;
  uxv jdField_a_of_type_Uxv;
  ver jdField_a_of_type_Ver;
  ves jdField_a_of_type_Ves;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public vgy(vgu paramvgu)
  {
    this.jdField_a_of_type_Int = actj.a(15.0F, paramvgu.a());
    this.b = actj.a(12.0F, paramvgu.a());
    this.c = actj.a(2.0F, paramvgu.a());
    this.d = ((axlk.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Uxv = new uxv(actj.a(3.0F, paramvgu.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Ver = ((ver)paramvgu.a(ver.class));
    this.jdField_a_of_type_Ves = ((ves)paramvgu.a(ves.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Ver != null) {
      if (this.jdField_a_of_type_Ver.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ves != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Ves.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Ver.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Ves != null) {
            this.jdField_a_of_type_Ves.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = vxv.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Ver.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Uxv.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(vjr paramvjr, vgz paramvgz)
  {
    Bitmap localBitmap = vxv.a(paramvjr.c, this.e, this.f, false);
    paramvjr = null;
    if (localBitmap != null) {
      paramvjr = this.jdField_a_of_type_Uxv.a(localBitmap);
    }
    paramvgz.b = paramvjr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgy
 * JD-Core Version:    0.7.0.1
 */