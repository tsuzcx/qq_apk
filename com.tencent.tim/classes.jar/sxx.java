import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.widget.Gallery;

public class sxx
{
  public static Rect getAnimationEndDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    return getAnimationEndDstRect(paramInt1, paramInt2, paramInt3, paramInt4, true, paramObject);
  }
  
  public static Rect getAnimationEndDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Object paramObject)
  {
    float f = Gallery.getAIOImageScale(paramInt1, paramInt2, paramInt3, paramInt4, paramObject);
    int i;
    label67:
    label79:
    Rect localRect;
    if (paramInt2 >= paramInt1 * 3)
    {
      i = 1;
      if ((i == 0) || ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4)) || ((paramInt1 < aoop.AIO_IMAGE_MAX_SIZE) && (paramInt2 < aoop.AIO_IMAGE_MAX_SIZE))) {
        break label119;
      }
      f = Math.min(paramInt3 / paramInt1, Gallery.MAX_SCALE_DEFAULT);
      i = 49;
      if ((paramBoolean) || (f <= 1.0F)) {
        break label126;
      }
      localRect = new Rect(0, 0, paramInt1, paramInt2);
      if (i != 49) {
        break label143;
      }
      localRect.offset((paramInt3 - paramInt1) / 2, 0);
    }
    label119:
    label126:
    do
    {
      do
      {
        do
        {
          return localRect;
          i = 0;
          break;
          i = 17;
          break label67;
          paramInt1 = (int)(paramInt1 * f);
          paramInt2 = (int)(paramInt2 * f);
          break label79;
        } while (i != 17);
        localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      } while ((paramObject == null) || (!(paramObject instanceof AIOImageData)));
      paramObject = (AIOImageData)paramObject;
    } while ((paramObject.aWi == null) || (paramObject.aWi.length() == 0) || (paramObject.aWi.equals("null")));
    label143:
    localRect.offset(0, (int)(-15.0F * BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density * f));
    return localRect;
  }
  
  public static float getScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt3 <= 0) || (paramInt4 <= 0)) {}
    do
    {
      do
      {
        return 1.0F;
        if ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4 * paramInt1 / paramInt3)) {
          return paramInt3 / paramInt1;
        }
      } while ((paramInt1 < paramInt3) && (paramInt2 >= paramInt4));
      if ((paramInt1 >= paramInt3) && (paramInt2 < paramInt4 * paramInt1 / paramInt3)) {
        return paramInt3 / paramInt1;
      }
      if ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) {
        return Math.min(paramInt4 / paramInt2, paramInt3 / paramInt1);
      }
    } while ((paramInt1 >= paramInt3) || (paramInt1 <= paramInt3 / 2) || (paramInt4 <= paramInt3 / paramInt1 * paramInt2));
    return paramInt3 / paramInt1;
  }
  
  public static Rect getViewRect(View paramView)
  {
    Rect localRect = new Rect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom());
    getViewRect(paramView, localRect);
    return localRect;
  }
  
  public static boolean getViewRect(View paramView, Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    Point localPoint = new Point();
    if ((i > 0) && (j > 0))
    {
      Rect localRect = paramRect;
      if (paramRect == null)
      {
        localRect = new Rect();
        localRect.set(0, 0, i, j);
      }
      localPoint.set(-paramView.getScrollX(), -paramView.getScrollY());
      localRect.offset((i - localRect.width()) / 2, (j - localRect.height()) / 2);
      return (localViewGroup == null) || (localViewGroup.getChildVisibleRect(paramView, localRect, localPoint));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxx
 * JD-Core Version:    0.7.0.1
 */