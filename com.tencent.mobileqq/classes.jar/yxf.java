import android.graphics.Bitmap;
import android.graphics.Canvas;

class yxf
{
  int jdField_a_of_type_Int;
  yoc jdField_a_of_type_Yoc;
  yuy jdField_a_of_type_Yuy;
  yuz jdField_a_of_type_Yuz;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public yxf(yxb paramyxb)
  {
    this.jdField_a_of_type_Int = agej.a(15.0F, paramyxb.a());
    this.b = agej.a(12.0F, paramyxb.a());
    this.c = agej.a(2.0F, paramyxb.a());
    this.d = ((bdep.jdField_a_of_type_Int - this.jdField_a_of_type_Int * 2 - this.b * 5) / 6);
    this.e = (this.d - this.c * 2);
    this.f = (this.e * 8 / 5);
    this.jdField_a_of_type_Yoc = new yoc(agej.a(3.0F, paramyxb.a()), 0, this.f * 1.0F / this.e, null, null);
    this.jdField_a_of_type_Yuy = ((yuy)paramyxb.a(yuy.class));
    this.jdField_a_of_type_Yuz = ((yuz)paramyxb.a(yuz.class));
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Yuy != null) {
      if (this.jdField_a_of_type_Yuy.a(paramInt))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Yuz != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Yuz.a(paramInt)) {}
        }
      }
      else
      {
        Bitmap localBitmap1 = this.jdField_a_of_type_Yuy.a(paramInt);
        localObject1 = localObject2;
        if (localBitmap1 != null)
        {
          if (this.jdField_a_of_type_Yuz != null) {
            this.jdField_a_of_type_Yuz.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
          }
          Bitmap localBitmap2 = zoc.a(localBitmap1, this.e, this.f, false);
          this.jdField_a_of_type_Yuy.a(localBitmap1);
          localObject1 = localObject2;
          if (localBitmap2 != null) {
            localObject1 = this.jdField_a_of_type_Yoc.a(localBitmap2);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(yzy paramyzy, yxg paramyxg)
  {
    Bitmap localBitmap = zoc.a(paramyzy.c, this.e, this.f, false);
    paramyzy = null;
    if (localBitmap != null) {
      paramyzy = this.jdField_a_of_type_Yoc.a(localBitmap);
    }
    paramyxg.b = paramyzy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxf
 * JD-Core Version:    0.7.0.1
 */