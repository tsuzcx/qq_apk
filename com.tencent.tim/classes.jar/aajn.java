import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class aajn
  extends aakb
{
  protected int mListItemLayout = 2131562956;
  private List<String> vo;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof aajn.a)))
    {
      paramc = (aajn.a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramc;
      localObject1 = paramContext.getResources();
      paramc = ((Resources)localObject1).getColorStateList(2131167383);
      localObject1 = ((Resources)localObject1).getColorStateList(2131167384);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label522;
      }
      paramView.g.setExtendTextColor((ColorStateList)localObject1, 0);
    }
    for (;;)
    {
      paramView.d.setTag(Integer.valueOf(paramInt));
      if (AppSetting.enableTalkBack) {
        paramViewGroup.setContentDescription(null);
      }
      if ((paramObject instanceof RecentItemAppletsFolderData))
      {
        paramc = (RecentItemAppletsFolderData)paramObject;
        if (paramaajx != null) {
          a(paramViewGroup, paramc, paramContext, paramaajx.a(paramc.mUser.uin, paramView.b.getMeasuredWidth(), paramView.b.getMeasuredHeight(), paramc.iconUrl, paramc.iconUrlSimple));
        }
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      paramView = new aajn.a();
      paramViewGroup = a(paramContext, this.mListItemLayout, paramView);
      paramView.b = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131368698));
      paramView.g = ((SingleLineTextView)paramViewGroup.findViewById(2131379769));
      paramView.d = ((DragTextView)paramViewGroup.findViewById(2131381288));
      paramView.h = ((SingleLineTextView)paramViewGroup.findViewById(2131365748));
      Object localObject2 = paramContext.getResources();
      float f = aqgz.getDesity();
      paramc = ((Resources)localObject2).getColorStateList(2131167383);
      localObject1 = ((Resources)localObject2).getColorStateList(2131167311);
      localObject2 = ((Resources)localObject2).getColorStateList(2131167384);
      paramView.g.setTextColor((ColorStateList)localObject1);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramView.g.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramView.g.setExtendTextSize(12.0F, 0);
        paramView.g.setCompoundDrawablePadding((int)(3.0F * f));
        paramView.g.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramView.g.setExtendTextPadding((int)(5.0F * f), 2);
        paramView.g.setExtendTextColor(paramc, 2);
        paramView.g.setExtendTextSize(17.0F, 2);
        paramView.h.setTextColor(paramc);
        paramView.h.setExtendTextPadding((int)(f * 2.0F), 1);
        paramView.h.setExtendTextSize(14.0F, 1);
        paramViewGroup.setTag(paramView);
        if (this.c != null) {
          paramView.d.setOnModeChangeListener(this.c.a());
        }
        break;
        paramView.g.setExtendTextColor(paramc, 0);
      }
      label522:
      paramView.g.setExtendTextColor(paramc, 0);
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.vo == null)
    {
      this.vo = new ArrayList();
      j = i & 0xF0;
      if (j != 32) {
        break label115;
      }
      this.vo.add(paramRecentBaseData.getString(fy[2]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.vo.add(paramRecentBaseData.getString(fy[0]));
      }
      return this.vo;
      this.vo.clear();
      break;
      label115:
      if (j == 16) {
        this.vo.add(paramRecentBaseData.getString(fy[3]));
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    int k = 0;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof aajn.a)) {}
    for (aajn.a locala = (aajn.a)paramView.getTag();; locala = null) {
      for (;;)
      {
        if (locala == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        locala.b.setImageDrawable(paramDrawable);
        fN(locala.b);
        locala.g.setExtendText(paramRecentBaseData.mShowTime, 0);
        locala.g.setText(paramRecentBaseData.mTitleName);
        try
        {
          locala.h.setText(paramRecentBaseData.mLastMsg);
          j = paramRecentBaseData.mUnreadNum;
          i = paramRecentBaseData.mUnreadFlag;
          if (j > 0) {
            if (i == 0)
            {
              locala.d.setDragViewType(-1, paramView);
              j = 0;
              i = 0;
              aute.updateCustomNoteTxt(locala.d, i, j, k, 99, null);
              if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {
                break label340;
              }
            }
          }
        }
        catch (Exception paramDrawable)
        {
          for (;;)
          {
            try
            {
              locala.Lz.setBackgroundResource(2130839643);
              if (!AppSetting.enableTalkBack) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              paramDrawable = paramDrawable;
              paramDrawable.printStackTrace();
              locala.h.setText(paramRecentBaseData.mLastMsg + " ");
              continue;
              if (i == 2)
              {
                i = 1;
                locala.d.setDragViewType(-1, paramView);
                j = 0;
                continue;
              }
              i = 3;
              locala.d.setDragViewType(0, paramView);
              locala.d.setTextColor(paramContext.getResources().getColor(2131167429));
              k = 2130851404;
              continue;
              label340:
              locala.Lz.setBackgroundResource(2130839642);
              continue;
            }
            catch (Throwable paramContext)
            {
              continue;
            }
            int j = 0;
            int i = 0;
          }
        }
      }
    }
  }
  
  public int xV()
  {
    return 2;
  }
  
  public static class a
    extends aakb.a
  {
    public RecentDynamicAvatarView b;
    public DragTextView d;
    public SingleLineTextView g;
    public SingleLineTextView h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajn
 * JD-Core Version:    0.7.0.1
 */