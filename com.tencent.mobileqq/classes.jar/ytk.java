import android.graphics.Bitmap;
import android.graphics.Canvas;

class ytk
{
  int jdField_a_of_type_Int;
  ykh jdField_a_of_type_Ykh;
  yrd jdField_a_of_type_Yrd;
  yre jdField_a_of_type_Yre;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public ytk(ytg paramytg)
  {
    this.jdField_a_of_type_Int = afur.a(15.0F, paramytg.a());
    this.b = afur.a(12.0F, paramytg.a());
    this.c = afur.a(2.0F, paramytg.a());
    this.d = ((bclx.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Ykh = new ykh(afur.a(3.0F, paramytg.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Yrd = ((yrd)paramytg.a(yrd.class));
    this.jdField_a_of_type_Yre = ((yre)paramytg.a(yre.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Yrd != null) {
      if (this.jdField_a_of_type_Yrd.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Yre != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Yre.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Yrd.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Yre != null) {
            this.jdField_a_of_type_Yre.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = zkh.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Yrd.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Ykh.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(ywd paramywd, ytl paramytl)
  {
    Bitmap localBitmap = zkh.a(paramywd.c, this.e, this.f, false);
    paramywd = null;
    if (localBitmap != null) {
      paramywd = this.jdField_a_of_type_Ykh.a(localBitmap);
    }
    paramytl.b = paramywd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytk
 * JD-Core Version:    0.7.0.1
 */