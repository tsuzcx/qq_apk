import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.PhotoSelecter;

public class vjt
  implements Comparable<vjt>
{
  public int a;
  Bitmap a;
  public vim a;
  
  public int a(@NonNull vjt paramvjt)
  {
    return (int)(this.jdField_a_of_type_Vim.b - paramvjt.jdField_a_of_type_Vim.b);
  }
  
  public Bitmap a(Context paramContext)
  {
    BitmapFactory.Options localOptions;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localOptions = new BitmapFactory.Options();
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Vim.a(paramContext, 1, localOptions);
      this.jdField_a_of_type_AndroidGraphicsBitmap = vju.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        xvv.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjt
 * JD-Core Version:    0.7.0.1
 */