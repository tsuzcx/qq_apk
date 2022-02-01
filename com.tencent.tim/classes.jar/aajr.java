import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.c;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ThemeImageView;

public class aajr
  extends aakb
{
  protected String bdm;
  View.OnTouchListener onTouchListener = new aajs(this);
  
  aajr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramViewGroup = null;
    paramaajx = paramViewGroup;
    if (paramView != null)
    {
      paramaajx = paramViewGroup;
      if ((paramView.getTag() instanceof aajr.a)) {
        paramaajx = (aajr.a)paramView.getTag();
      }
    }
    if (paramaajx == null)
    {
      paramaajx = new aajr.a();
      paramView = a(paramContext, 2131559112, paramaajx);
      paramaajx.b = ((ThemeImageView)paramView.findViewById(2131365365));
      paramView.setOnTouchListener(this.onTouchListener);
      paramViewGroup = paramaajx.b.getLayoutParams();
      int i = rex.b(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramaajx.b.setLayoutParams(paramViewGroup);
      paramaajx.b.setMaskShape(auvj.euL);
      paramView.setTag(paramaajx);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof LoginWelcomeManager.c)))
        {
          paramObject = (LoginWelcomeManager.c)paramObject.mUser.extraInfo;
          if (paramObject.E != null)
          {
            paramaajx.b.setImageDrawable(paramObject.E);
            paramObject.E.setURLDrawableListener(null);
          }
          LoginWelcomeManager.dfp += 1;
        }
      }
      this.bdm = ThemeUtil.curThemeId;
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(acfp.m(2131713660));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
  
  public static class a
    extends aakb.a
  {
    public ThemeImageView b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajr
 * JD-Core Version:    0.7.0.1
 */