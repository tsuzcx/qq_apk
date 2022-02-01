import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class sme
  implements URLDrawable.URLDrawableListener
{
  sme(slz paramslz, DisplayMetrics paramDisplayMetrics) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.this$0.ny.setVisibility(8);
    this.this$0.hasImage = false;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.this$0.ny.setVisibility(8);
    this.this$0.hasImage = false;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.this$0.ny.setImageDrawable(null);
    this.this$0.ny.setImageDrawable(paramURLDrawable);
    float f1 = paramURLDrawable.getIntrinsicHeight();
    float f2 = paramURLDrawable.getIntrinsicWidth();
    paramURLDrawable = this.this$0.ny.getLayoutParams();
    int j = 0;
    if (f2 != 0.0F) {
      if (f1 <= aqho.convertDpToPixel(this.this$0.mContext, 150.0F)) {
        break label109;
      }
    }
    label109:
    for (j = (int)aqho.convertDpToPixel(this.this$0.mContext, 150.0F);; j = (int)((this.i.widthPixels - aqho.convertDpToPixel(this.this$0.mContext, 60.0F)) * (f1 / f2)))
    {
      if (j > 0)
      {
        paramURLDrawable.height = j;
        this.this$0.ny.setLayoutParams(paramURLDrawable);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sme
 * JD-Core Version:    0.7.0.1
 */