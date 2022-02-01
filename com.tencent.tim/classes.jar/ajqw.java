import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;

public class ajqw
{
  protected int dkI;
  protected Drawable eY;
  public int mCurIndex;
  public Handler mUiHandler;
  protected ImageView po;
  public ArrayList<String> xY;
  
  public void MN(String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.eY;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.eY;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.dkI;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.dkI;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_reddot_face";
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    paramString.setTag(aqbn.e(this.dkI, this.dkI));
    paramString.setDecodeHandler(aqbn.b);
    if (this.xY.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(this.po, "alpha", new float[] { 1.0F, 0.1F });
      ((ObjectAnimator)localObject).addListener(new ajqx(this, paramString));
      ((ObjectAnimator)localObject).setDuration(1500L).start();
      return;
    }
    this.po.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqw
 * JD-Core Version:    0.7.0.1
 */