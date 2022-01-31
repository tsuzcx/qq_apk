import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class xmd
{
  public int a;
  protected Context a;
  public Handler a;
  public LruCache<String, xur> a;
  public int b;
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    wxe.c("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap start.");
    float f2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < this.jdField_a_of_type_Int * f2) {
        f1 = i / this.jdField_a_of_type_Int;
      }
    }
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * f1));
    this.b = ((int)(f1 * this.b));
    i = this.jdField_a_of_type_Int;
    wxe.c("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap end.");
    return bdhj.a(paramBitmap, i, this.jdField_a_of_type_Int, this.b);
  }
  
  public Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wxe.e("Q.qqstory.record.StoryFaceDrawableFactory", "localPath = null!");
      return null;
    }
    wxe.b("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath start. localPath:%s.", paramString);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      if (paramString == null)
      {
        wxe.e("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile return null!");
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        wxe.c("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile error : %s.", paramString);
        paramString = null;
      }
      Bitmap localBitmap = a(paramString);
      if (localBitmap == null)
      {
        wxe.e("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap return null!");
        return null;
      }
      if ((paramString != null) && (!paramString.isRecycled())) {
        paramString.recycle();
      }
      wxe.c("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath end.");
      return localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xmd
 * JD-Core Version:    0.7.0.1
 */