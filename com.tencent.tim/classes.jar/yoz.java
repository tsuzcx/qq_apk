import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

class yoz
  implements aqdf.a
{
  yoz(yoy paramyoy) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = yoy.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = yoy.a(this.a).getChildViewHolder(yoy.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof yoy.a))
        {
          localObject = (yoy.a)localObject;
          if (((yoy.a)localObject).uin.equals(paramString)) {
            ((yoy.a)localObject).up.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoz
 * JD-Core Version:    0.7.0.1
 */