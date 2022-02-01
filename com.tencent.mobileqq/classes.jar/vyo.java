import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.PhotoSelecter;

public class vyo
  implements Comparable<vyo>
{
  public int a;
  Bitmap a;
  public vxh a;
  
  public int a(@NonNull vyo paramvyo)
  {
    return (int)(this.jdField_a_of_type_Vxh.b - paramvyo.jdField_a_of_type_Vxh.b);
  }
  
  public Bitmap a(Context paramContext)
  {
    BitmapFactory.Options localOptions;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localOptions = new BitmapFactory.Options();
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Vxh.a(paramContext, 1, localOptions);
      this.jdField_a_of_type_AndroidGraphicsBitmap = vyp.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ykq.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyo
 * JD-Core Version:    0.7.0.1
 */