import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class akyu
  implements Comparable<akyu>
{
  public String action;
  public String actionType;
  public String bUP;
  public String bUQ;
  public String bUR;
  public String contentDescription;
  public int dqk;
  public int dql;
  public Drawable fi;
  public String iconPress;
  public int id;
  public Drawable mDrawable;
  public int[] mn;
  public String nV;
  public int order;
  public int tag;
  
  public int a(akyu paramakyu)
  {
    if (paramakyu != null) {
      return this.order - paramakyu.order;
    }
    return 0;
  }
  
  public Drawable aM()
  {
    try
    {
      if ((this.mDrawable == null) && (!TextUtils.isEmpty(this.nV)) && (!TextUtils.isEmpty(this.iconPress)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.nV, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.iconPress, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.mDrawable = localStateListDrawable;
      }
      return this.mDrawable;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public Drawable aN()
  {
    try
    {
      if ((this.fi == null) && (!TextUtils.isEmpty(this.bUQ)) && (!TextUtils.isEmpty(this.bUR)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.bUQ, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.bUR, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.fi = localStateListDrawable;
      }
      return this.fi;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyu
 * JD-Core Version:    0.7.0.1
 */