package dov.com.qq.im.ptv;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import ayag;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinnableBitmapDrawable;
import mqq.os.MqqHandler;

public final class AIOBusinessOperation$2
  implements Runnable
{
  public AIOBusinessOperation$2(String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    int i = ayag.access$400(this.val$themeId);
    if (i == 0)
    {
      ayag.b(this.IJ.getResources(), this.val$themeId);
      i = ayag.access$400(this.val$themeId);
    }
    for (;;)
    {
      Object localObject = this.IJ.getResources().getDrawable(2130845317);
      boolean bool;
      if ((localObject instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        bool = false;
      }
      for (;;)
      {
        if (localObject != null)
        {
          localObject = ayag.j((Bitmap)localObject, i);
          ThreadManager.getUIHandler().post(new AIOBusinessOperation.2.1(this, (Bitmap)localObject, bool));
        }
        return;
        if ((localObject instanceof SkinnableBitmapDrawable))
        {
          localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
          bool = true;
        }
        else
        {
          bool = false;
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.2
 * JD-Core Version:    0.7.0.1
 */