import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;

public class aakv
  extends aajv
{
  private static void j(Context paramContext, View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772187);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772186);
    localAnimation.setAnimationListener(new aakw(paramView, paramContext));
    paramContext.setAnimationListener(new aakx(paramView, localAnimation));
    paramView.startAnimation(localAnimation);
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    aakv.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof aakv.a)))
    {
      locala = new aakv.a(null);
      View localView = a(paramContext, 2131562961, locala);
      locala.b = ((RecentDynamicAvatarView)localView.findViewById(2131368698));
      locala.d = ((DragTextView)localView.findViewById(2131381288));
      locala.g = ((SingleLineTextView)localView.findViewById(2131379769));
      locala.h = ((SingleLineTextView)localView.findViewById(2131365748));
      locala.h.setGravity(16);
      locala.iK = ((RelativeLayout)localView.findViewById(2131362716));
      locala.wj = ((ImageView)localView.findViewById(2131362715));
      Object localObject = paramContext.getResources();
      float f = aqgz.getDesity();
      paramView = ((Resources)localObject).getColorStateList(2131167383);
      ColorStateList localColorStateList = ((Resources)localObject).getColorStateList(2131167311);
      localObject = ((Resources)localObject).getColorStateList(2131167384);
      locala.g.setTextColor(localColorStateList);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null))
      {
        locala.g.setExtendTextColor((ColorStateList)localObject, 0);
        locala.g.setExtendTextSize(12.0F, 0);
        locala.g.setCompoundDrawablePadding((int)(3.0F * f));
        locala.g.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        locala.g.setExtendTextPadding((int)(5.0F * f), 2);
        locala.g.setExtendTextColor(paramView, 2);
        locala.g.setExtendTextSize(17.0F, 2);
        locala.h.setTextColor(paramView);
        locala.h.setExtendTextPadding((int)(f * 2.0F), 1);
        locala.h.setExtendTextSize(14.0F, 1);
        localView.setTag(locala);
        paramView = localView;
        if (this.c != null)
        {
          locala.d.setOnModeChangeListener(this.c.a());
          paramView = localView;
        }
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramObject, paramaajx, paramView, paramViewGroup, paramContext, paramOnClickListener, paramOnLongClickListener, paramc);
      locala.g.setExtendTextColor(paramView, 0);
      break;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof aakv.a)) {}
    for (aakv.a locala = (aakv.a)paramView.getTag();; locala = null)
    {
      if (locala == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      super.a(paramView, paramRecentBaseData, paramContext, paramDrawable);
      paramView = (RelativeLayout.LayoutParams)locala.iK.getLayoutParams();
      paramView.height = locala.h.getMeasuredHeight();
      locala.iK.setLayoutParams(paramView);
      j(paramContext, locala.wj);
      return;
    }
  }
  
  static class a
    extends aajv.a
  {
    public RelativeLayout iK;
    public ImageView wj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakv
 * JD-Core Version:    0.7.0.1
 */