import android.graphics.Bitmap;
import android.graphics.Canvas;

class uuf
{
  int jdField_a_of_type_Int;
  ulc jdField_a_of_type_Ulc;
  ury jdField_a_of_type_Ury;
  urz jdField_a_of_type_Urz;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public uuf(uub paramuub)
  {
    this.jdField_a_of_type_Int = aciy.a(15.0F, paramuub.a());
    this.b = aciy.a(12.0F, paramuub.a());
    this.c = aciy.a(2.0F, paramuub.a());
    this.d = ((awmc.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Ulc = new ulc(aciy.a(3.0F, paramuub.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Ury = ((ury)paramuub.a(ury.class));
    this.jdField_a_of_type_Urz = ((urz)paramuub.a(urz.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Ury != null) {
      if (this.jdField_a_of_type_Ury.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Urz != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Urz.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Ury.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Urz != null) {
            this.jdField_a_of_type_Urz.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = vlc.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Ury.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Ulc.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(uwy paramuwy, uug paramuug)
  {
    Bitmap localBitmap = vlc.a(paramuwy.c, this.e, this.f, false);
    paramuwy = null;
    if (localBitmap != null) {
      paramuwy = this.jdField_a_of_type_Ulc.a(localBitmap);
    }
    paramuug.b = paramuwy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuf
 * JD-Core Version:    0.7.0.1
 */