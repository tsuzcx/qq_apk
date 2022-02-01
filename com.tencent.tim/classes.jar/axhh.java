import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axhh
  implements axic.a
{
  public axhh(AETemplateInfoFragment paramAETemplateInfoFragment, String paramString, Bitmap paramBitmap, long paramLong) {}
  
  public void bl(List<axic.b> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      AETemplateInfoFragment.a(this.this$0, new ArrayList());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        axic.b localb = (axic.b)paramList.next();
        if (localb.isSuccess)
        {
          String str = AETemplateInfoFragment.aTZ + System.currentTimeMillis();
          BitmapUtils.saveBitmap(localb.hp, str);
          AETemplateInfoFragment.a(this.this$0).add(str);
          BitmapUtils.recycle(localb.hp);
        }
        else
        {
          AETemplateInfoFragment.a(this.this$0).add(this.cUv);
        }
      }
      BitmapUtils.recycle(this.val$bitmap);
      AETemplateInfoFragment.a(this.this$0, true);
    }
    for (;;)
    {
      AETemplateInfoFragment.b(this.this$0, false);
      return;
      BitmapUtils.recycle(this.val$bitmap);
      QLog.e("AETemplateInfoFragment", 1, "changeFace---failed to get face changed bitmaps");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhh
 * JD-Core Version:    0.7.0.1
 */