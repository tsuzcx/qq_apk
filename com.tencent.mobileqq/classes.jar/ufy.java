import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.PhotoSelecter;

public class ufy
  implements Comparable<ufy>
{
  public int a;
  Bitmap a;
  public uer a;
  
  public int a(@NonNull ufy paramufy)
  {
    return (int)(this.jdField_a_of_type_Uer.b - paramufy.jdField_a_of_type_Uer.b);
  }
  
  public Bitmap a(Context paramContext)
  {
    BitmapFactory.Options localOptions;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localOptions = new BitmapFactory.Options();
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Uer.a(paramContext, 1, localOptions);
      this.jdField_a_of_type_AndroidGraphicsBitmap = ufz.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        wsv.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufy
 * JD-Core Version:    0.7.0.1
 */