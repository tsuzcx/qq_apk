package dov.com.qq.im.ptv;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import ayag;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.HashMap;

class AIOBusinessOperation$2$1
  implements Runnable
{
  AIOBusinessOperation$2$1(AIOBusinessOperation.2 param2, Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$newBitmap != null)
    {
      if (this.dxr) {}
      for (Object localObject = new SkinnableBitmapDrawable(this.val$newBitmap);; localObject = new BitmapDrawable(this.val$newBitmap))
      {
        this.this$0.IJ.setImageDrawable((Drawable)localObject);
        ayag.access$100().put(this.this$0.val$themeId, localObject);
        return;
      }
    }
    ayag.access$100().put(this.this$0.val$themeId, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.2.1
 * JD-Core Version:    0.7.0.1
 */