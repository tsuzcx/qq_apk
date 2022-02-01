import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public abstract class ayob
  extends Drawable
{
  public static final int eLN = dp2px(1.0F, BaseApplicationImpl.getContext().getResources());
  protected ArrayList<Integer> Gv;
  protected ValueAnimator a;
  protected aynr a;
  private ayob.a a;
  protected Bitmap hQ;
  protected Context mContext = BaseApplicationImpl.getContext();
  protected String mData;
  protected int mType;
  
  public ayob(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Aynr = new aynr();
    this.mData = paramString;
  }
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public abstract String[] G(String paramString);
  
  protected abstract void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList);
  
  protected int b(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramArrayList != null)
    {
      i = paramInt2;
      if (paramArrayList.size() > paramInt1)
      {
        paramArrayList = (Integer)paramArrayList.get(paramInt1);
        i = paramInt2;
        if (paramArrayList != null) {
          i = paramArrayList.intValue();
        }
      }
    }
    return i;
  }
  
  public Bitmap ba()
  {
    return g(this.jdField_a_of_type_Aynr.getDuration());
  }
  
  protected Bitmap bb()
  {
    if (this.hQ == null) {
      this.hQ = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    }
    for (;;)
    {
      return this.hQ;
      new Canvas(this.hQ).drawColor(0, PorterDuff.Mode.CLEAR);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.Gv != null) {
      a(paramCanvas, this.Gv);
    }
  }
  
  protected void eST()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofObject(this.jdField_a_of_type_Aynr, new Object[] { this.jdField_a_of_type_Aynr.eQ(), this.jdField_a_of_type_Aynr.eP() });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayoc(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ayod(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_Aynr.getDuration());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public Bitmap g(long paramLong)
  {
    Bitmap localBitmap = bb();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_Aynr.s(paramLong);
    if (localArrayList != null) {
      a(localCanvas, localArrayList);
    }
    return localBitmap;
  }
  
  public String getData()
  {
    return this.mData;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  protected abstract void init();
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public static abstract interface a
  {
    public abstract void onEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayob
 * JD-Core Version:    0.7.0.1
 */