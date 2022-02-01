import android.graphics.Bitmap;
import com.tencent.component.media.utils.LruCache;

class vgu
{
  public int a;
  
  public vgu(vgl paramvgl, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void finalize()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      Bitmap localBitmap = (Bitmap)vgx.a().a().remove(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgu
 * JD-Core Version:    0.7.0.1
 */