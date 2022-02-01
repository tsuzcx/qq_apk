import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class rln
{
  public int bte;
  public int btf;
  public LruCache<String, rrk> h;
  protected Context mContext;
  public Handler mUIHandler;
  
  protected Bitmap B(Bitmap paramBitmap)
  {
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap start.");
    float f2 = this.mContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < this.bte * f2) {
        f1 = i / this.bte;
      }
    }
    this.bte = ((int)(this.bte * f1));
    this.btf = ((int)(f1 * this.btf));
    i = this.bte;
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap end.");
    return aqhu.b(paramBitmap, i, this.bte, this.btf);
  }
  
  public Bitmap t(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "localPath = null!");
      return null;
    }
    ram.d("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath start. localPath:%s.", paramString);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      if (paramString == null)
      {
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile return null!");
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile error : %s.", paramString);
        paramString = null;
      }
      Bitmap localBitmap = B(paramString);
      if (localBitmap == null)
      {
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap return null!");
        return null;
      }
      if ((paramString != null) && (!paramString.isRecycled())) {
        paramString.recycle();
      }
      ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath end.");
      return localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rln
 * JD-Core Version:    0.7.0.1
 */