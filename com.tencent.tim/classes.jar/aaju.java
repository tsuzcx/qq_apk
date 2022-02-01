import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class aaju
  extends aakb
{
  public static int chn;
  private List<String> vo;
  
  public static void a(int paramInt, TextView paramTextView, View... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramInt <= 0)) {}
    label276:
    label283:
    for (;;)
    {
      return;
      int m = paramVarArgs.length;
      int j = 0;
      int i = 0;
      Object localObject;
      if (j < m)
      {
        localObject = paramVarArgs[j];
        if (((View)localObject).getVisibility() == 8) {}
        int k;
        do
        {
          j += 1;
          break;
          if (!(localObject instanceof TextView)) {
            break label240;
          }
          String str = ((TextView)localObject).getText().toString();
          if (TextUtils.isEmpty(str)) {
            break label276;
          }
          TextPaint localTextPaint = ((TextView)localObject).getPaint();
          float f = i;
          i = (int)(localTextPaint.measureText(str) + 0.5F + f);
          i = i + ((View)localObject).getPaddingLeft() + ((View)localObject).getPaddingRight();
          localObject = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          k = ((LinearLayout.LayoutParams)localObject).leftMargin + i + ((LinearLayout.LayoutParams)localObject).rightMargin;
          i = k;
        } while (k <= paramInt);
        j = 0;
        i = k;
      }
      for (;;)
      {
        if (i == 0) {
          break label283;
        }
        if (j != 0)
        {
          paramVarArgs = paramTextView.getText().toString();
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            j = (int)(paramTextView.getPaint().measureText(paramVarArgs) + 0.5F);
            label211:
            if (j + i < paramInt) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramTextView = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
          if (paramInt != 0)
          {
            paramTextView.weight = 0.0F;
            return;
            label240:
            i = ((View)localObject).getWidth() + i;
            break;
            paramInt = 0;
            continue;
          }
          paramTextView.weight = 1.0F;
          return;
          j = 0;
          break label211;
          paramInt = j;
        }
        break;
        j = 1;
      }
    }
  }
  
  private int r(View paramView)
  {
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int m = paramView.leftMargin;
    return i - (paramView.rightMargin + (k + (0 + j) + m));
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramc = null;
    paramViewGroup = paramc;
    if (paramView != null)
    {
      paramViewGroup = paramc;
      if ((paramView.getTag() instanceof aaju.a)) {
        paramViewGroup = (aaju.a)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramc = new aaju.a();
      localObject = a(paramContext, 2131562954, paramc);
      paramc.c = ((ThemeImageView)((View)localObject).findViewById(2131368698));
      paramc.c.setSupportMaskView(true);
      paramc.d = ((DragTextView)((View)localObject).findViewById(2131381288));
      paramc.NX = ((TextView)((View)localObject).findViewById(2131370129));
      paramc.wf = ((ImageView)((View)localObject).findViewById(2131365434));
      paramc.title = ((TextView)((View)localObject).findViewById(16908308));
      paramc.wg = ((ImageView)((View)localObject).findViewById(2131378717));
      paramc.NY = ((TextView)((View)localObject).findViewById(2131368128));
      paramc.NZ = ((TextView)((View)localObject).findViewById(2131366616));
      paramc.description = ((TextView)((View)localObject).findViewById(16908309));
      paramc.description.setGravity(16);
      a((View)localObject, paramc.NX, paramContext);
      ((View)localObject).setTag(paramc);
      paramView = (View)localObject;
      paramViewGroup = paramc;
      if (this.c != null)
      {
        paramc.d.setOnModeChangeListener(this.c.a());
        paramViewGroup = paramc;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.d.setTag(Integer.valueOf(paramInt));
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(null);
      }
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramc = null;
        if (paramaajx != null) {
          paramc = paramaajx.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramc);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.c.setOnClickListener(paramOnClickListener);
          paramViewGroup.c.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.enableTalkBack) {
            paramViewGroup.c.setContentDescription(String.format(acfp.m(2131713661), new Object[] { ((RecentItemEcShop)paramObject).getTitleName() }));
          }
        }
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.title.setText("");
          paramViewGroup.wg.setVisibility(8);
          paramViewGroup.NY.setVisibility(8);
          paramViewGroup.NY.setText("");
          paramViewGroup.NZ.setText("");
          paramViewGroup.description.setText("");
          paramViewGroup.NX.setText("");
          paramViewGroup.wf.setImageDrawable(null);
        }
      }
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
      j = 0xF0000 & i;
      if (j != 131072) {
        break label149;
      }
      this.vo.add(paramRecentBaseData.getString(fy[5]));
      label72:
      j = i & 0xF0;
      if (j != 32) {
        break label179;
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
      label149:
      if (j != 65536) {
        break label72;
      }
      this.vo.add(paramRecentBaseData.getString(fy[4]));
      break label72;
      label179:
      if (j == 16) {
        this.vo.add(paramRecentBaseData.getString(fy[3]));
      }
    }
  }
  
  public void a(aaju.a parama, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      parama.wf.setVisibility(8);
      parama.wf.setImageDrawable(null);
      return;
    case 1: 
      parama.wf.setVisibility(0);
      parama.wf.setImageResource(2130842967);
      return;
    case 2: 
      parama.wf.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        parama.wf.setImageResource(2130842977);
        return;
      }
      parama.wf.setImageResource(2130842967);
      return;
    case 3: 
      parama.wf.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        parama.wf.setImageResource(2130842977);
        return;
      }
      parama.wf.setImageResource(2130842978);
      return;
    case 5: 
      parama.wf.setVisibility(0);
      parama.wf.setImageResource(2130842978);
      return;
    }
    parama.wf.setVisibility(0);
    parama.wf.setImageResource(2130839799);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131379403);
      paramView = aale.a().t("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = aale.a().qy();
        if ((!TextUtils.isEmpty(paramView)) && (paramView.length() != "yyyy-MM-dd".length()))
        {
          i = 1;
          int j;
          if ((chn <= 0) || (i != 0))
          {
            f = paramContext.getResources().getDisplayMetrics().density;
            paramContext = paramTextView.getPaint();
            paramTextView = paramContext;
            if (paramContext == null)
            {
              paramTextView = new TextPaint();
              paramTextView.setTextSize(12.0F * f);
            }
            if (i == 0) {
              break label242;
            }
            i = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
            j = (int)(paramTextView.measureText(paramView) + f * 6.0F);
            if (j <= i) {
              break label215;
            }
          }
          label215:
          for (chn = j; localLinearLayout.getPaddingRight() < chn; chn = i)
          {
            i = localLinearLayout.getPaddingLeft();
            j = localLinearLayout.getPaddingTop();
            int k = localLinearLayout.getPaddingBottom();
            int m = chn;
            localLinearLayout.setPadding(i, j, chn, k);
            return;
          }
        }
      }
    }
    catch (Exception paramView)
    {
      int i;
      float f;
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentDefaultItemBuilder", 4, paramView.toString());
        return;
        label242:
        chn = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
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
    Object localObject = paramView.getTag();
    if ((localObject instanceof aaju.a)) {}
    for (aaju.a locala = (aaju.a)localObject;; locala = null) {
      for (;;)
      {
        if (locala == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        locala.c.setImageDrawable(paramDrawable);
        localObject = paramRecentBaseData.mTitleName;
        CharSequence localCharSequence = locala.title.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          locala.title.setText(paramDrawable);
        }
        int i = paramRecentBaseData.mAuthenIconId;
        if (i > 0)
        {
          locala.wg.setVisibility(0);
          locala.wg.setImageResource(i);
          label175:
          localObject = paramRecentBaseData.mExtraInfo;
          localCharSequence = locala.NY.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!TextUtils.isEmpty(paramDrawable)) {
            break label623;
          }
          locala.NY.setVisibility(8);
          a(r((View)locala.title.getParent()), locala.title, new View[] { locala.wg, locala.NY });
          localObject = paramRecentBaseData.mMsgExtroInfo;
          localCharSequence = locala.NZ.getText();
          i = locala.NZ.getCurrentTextColor();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            locala.NZ.setText(paramDrawable);
          }
          if ((i != paramRecentBaseData.mExtraInfoColor) && (paramRecentBaseData.mExtraInfoColor != 0)) {
            locala.NZ.setTextColor(paramRecentBaseData.mExtraInfoColor);
          }
          localObject = paramRecentBaseData.mLastMsg;
          localCharSequence = locala.description.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          locala.description.setText(paramDrawable);
          localObject = paramRecentBaseData.mShowTime;
          localCharSequence = locala.NX.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            locala.NX.setText(paramDrawable);
          }
          a(locala, paramRecentBaseData);
          m = paramRecentBaseData.mUnreadNum;
          i = paramRecentBaseData.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              locala.d.setDragViewType(-1, paramView);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              aute.updateCustomNoteTxt(locala.d, i, m, j, k, null);
              if (locala.NX.getVisibility() != 0) {
                locala.NX.setVisibility(0);
              }
              if (AppSetting.enableTalkBack) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {
                break label825;
              }
              locala.Lz.setBackgroundResource(2130839643);
              long l = paramRecentBaseData.eK();
              if (!(locala.c instanceof autv)) {
                break;
              }
              ((autv)locala.c).nx(l);
              return;
              locala.wg.setVisibility(8);
              break label175;
              label623:
              if (!paramDrawable.equals(localCharSequence)) {
                locala.NY.setText(paramDrawable);
              }
              locala.NY.setVisibility(0);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int k;
            int j;
            localException.printStackTrace();
            locala.description.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              locala.d.setDragViewType(-1, paramView);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130851408;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              locala.d.setDragViewType(1, paramView);
              locala.d.setTextColor(paramContext.getResources().getColor(2131167428));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130851404;
              locala.d.setDragViewType(0, paramView);
              locala.d.setTextColor(paramContext.getResources().getColor(2131167429));
              k = 99;
              i = 3;
              continue;
              label825:
              locala.Lz.setBackgroundResource(2130839642);
              continue;
              k = 99;
              m = 0;
              j = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public int xV()
  {
    return 3;
  }
  
  public static class a
    extends aakb.a
  {
    public TextView NX;
    public TextView NY;
    public TextView NZ;
    public ThemeImageView c;
    public DragTextView d;
    public TextView description;
    public TextView title;
    public ImageView wf;
    public ImageView wg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaju
 * JD-Core Version:    0.7.0.1
 */