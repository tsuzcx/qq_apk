import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyApngImageView.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import java.util.Date;

public class lsp
  extends ImageBase
{
  private Drawable cv = new ColorDrawable(Color.parseColor("#00000000"));
  public NativeReadInjoyImageView l;
  
  public lsp(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.l = new NativeReadInjoyImageView(paramVafContext.getContext());
  }
  
  private static long a(Date paramDate1, Date paramDate2)
  {
    return Math.abs((paramDate1.getTime() - paramDate2.getTime()) / 86400000L);
  }
  
  private void nr(String paramString)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ReadInjoyApngImageView.1(this, paramString), 1500L);
  }
  
  public int getComMeasuredHeight()
  {
    return this.l.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.l.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.l;
  }
  
  public void loadImage(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")) && (!DateUtils.isToday(aqmj.bd("search_word_prefix_ug_weishi_opt_day_show_time"))))
    {
      aqmj.bn("search_word_prefix_ug_weishi_opt_day_show_time", System.currentTimeMillis());
      if (a(new Date(System.currentTimeMillis()), new Date(aqmj.bd("search_word_prefix_ug_weishi_opt_week_first_show_time"))) <= 7L) {
        break label87;
      }
      aqmj.bn("search_word_prefix_ug_weishi_opt_week_first_show_time", System.currentTimeMillis());
      aqmj.go("search_word_prefix_ug_weishi_opt_week_first_show_count", 1);
      nr(paramString);
    }
    label87:
    while (aqmj.fl("search_word_prefix_ug_weishi_opt_week_first_show_count") >= 3) {
      return;
    }
    aqmj.go("search_word_prefix_ug_weishi_opt_week_first_show_count", aqmj.fl("search_word_prefix_ug_weishi_opt_week_first_show_count") + 1);
    nr(paramString);
  }
  
  public void onComDraw(Canvas paramCanvas)
  {
    super.onComDraw(paramCanvas);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.l.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.l.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.l.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.l.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.l.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.l.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.l.setImageDrawable(paramDrawable);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lsp(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsp
 * JD-Core Version:    0.7.0.1
 */