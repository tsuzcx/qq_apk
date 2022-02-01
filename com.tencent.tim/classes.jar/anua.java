import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class anua
{
  private View Hx;
  private anqv a;
  private int dMx = -1;
  private int dMy;
  private Context mContext;
  private TextView mTitleView;
  
  public anua(anqv paramanqv, Context paramContext, int paramInt)
  {
    this.a = paramanqv;
    this.mContext = paramContext;
    this.dMx = paramInt;
    this.dMy = this.mContext.getResources().getDimensionPixelSize(2131296468);
  }
  
  private TextView a(String paramString, View paramView, boolean paramBoolean)
  {
    Resources localResources = this.mContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.mContext);
      localTextView.setMaxLines(2);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 19.0F);
      localTextView.setMaxLines(2);
      localTextView.setLineSpacing(wja.dp2px(2.5F, localResources), 1.0F);
      localTextView.setGravity(80);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      if (paramBoolean) {
        localTextView.setBackgroundResource(2130842480);
      }
      int i = wja.dp2px(12.5F, localResources);
      int j = wja.dp2px(12.0F, localResources);
      localTextView.setPadding(j, 0, j, i);
      localTextView.setId(2131378973);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramString))
      {
        localTextView.setText(paramString);
        paramView = localTextView;
      }
    }
    do
    {
      do
      {
        return paramView;
        localTextView = (TextView)paramView;
        if (!TextUtils.isEmpty(paramString)) {
          localTextView.setText(paramString);
        }
        paramView = localTextView;
      } while (!paramBoolean);
      paramView = localTextView;
    } while (localTextView.getBackground() != null);
    localTextView.setBackgroundResource(2130842480);
    return localTextView;
  }
  
  public static boolean a(anqv paramanqv, int paramInt)
  {
    if (paramInt != 0) {
      return false;
    }
    paramanqv = paramanqv.rz.iterator();
    label14:
    String str;
    if (paramanqv.hasNext())
    {
      str = ((anqu)paramanqv.next()).mTypeName;
      if (!"picture".equals(str)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (!"title".equals(str)) {
        break;
      }
      break label14;
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!a(this.a, this.dMx)) {
      paramContext = this.a.a(paramContext, paramView, paramBundle);
    }
    LinearLayout localLinearLayout;
    Object localObject1;
    Object localObject2;
    do
    {
      return paramContext;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayout5Adapter", 2, "layout5 use new style");
      }
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break label598;
      }
      localLinearLayout = (LinearLayout)paramView;
      localObject1 = (FrameLayout)localLinearLayout.findViewById(2131378957);
      if (localObject1 == null) {
        break label381;
      }
      localObject2 = this.a.rz.iterator();
      paramView = null;
      if (((Iterator)localObject2).hasNext())
      {
        anqu localanqu = (anqu)((Iterator)localObject2).next();
        String str = localanqu.mTypeName;
        if ("title".equals(str)) {
          paramView = ((StructMsgItemTitle)localanqu).getText();
        }
        for (;;)
        {
          break;
          if ("picture".equals(str)) {
            this.Hx = a(localanqu, (View)localObject1, paramBundle);
          }
        }
      }
      if (this.Hx == null) {
        break;
      }
      paramBundle = (TextView)this.Hx.findViewById(2131378970);
      if (!TextUtils.isEmpty(paramView))
      {
        if (paramBundle != null)
        {
          a(paramView, paramBundle, true);
          return localLinearLayout;
        }
        paramContext = a(paramView, null, true);
        paramView = new ViewGroup.LayoutParams(-1, this.dMy);
        paramContext.setId(2131378970);
        ((ViewGroup)this.Hx).addView(paramContext, paramView);
        return localLinearLayout;
      }
      paramContext = localLinearLayout;
    } while (paramBundle == null);
    ((ViewGroup)this.Hx).removeView(paramBundle);
    return localLinearLayout;
    localLinearLayout.removeAllViews();
    for (;;)
    {
      if (localLinearLayout == null)
      {
        localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localLinearLayout.setOrientation(1);
        localLinearLayout.setId(2131378971);
      }
      for (;;)
      {
        localObject1 = this.a.rz.iterator();
        label331:
        if (((Iterator)localObject1).hasNext())
        {
          paramContext = (anqu)((Iterator)localObject1).next();
          localObject2 = paramContext.mTypeName;
          if ("title".equals(localObject2)) {}
          for (paramContext = ((StructMsgItemTitle)paramContext).getText();; paramContext = paramView)
          {
            paramView = paramContext;
            break label331;
            label381:
            localLinearLayout.removeAllViews();
            paramView = null;
            break;
            if ("picture".equals(localObject2)) {
              this.Hx = a(paramContext, null, paramBundle);
            }
          }
        }
        if (this.Hx != null)
        {
          if (!TextUtils.isEmpty(paramView))
          {
            paramContext = new ViewGroup.LayoutParams(-1, this.dMy);
            paramView = a(paramView.trim(), null, true);
            paramView.setId(2131378970);
            ((ViewGroup)this.Hx).addView(paramView, paramContext);
          }
          localLinearLayout.addView(this.Hx);
        }
        for (;;)
        {
          return localLinearLayout;
          if ((!TextUtils.isEmpty(paramView)) && (paramView.trim().length() > 0))
          {
            this.mTitleView = a(paramView.trim(), null, false);
            paramContext = new ViewGroup.LayoutParams(-2, -2);
            this.mTitleView.setLayoutParams(paramContext);
            int i = wja.dp2px(12.0F, this.mContext.getResources());
            this.mTitleView.setPadding(i, i, i, i);
            this.mTitleView.setId(2131378973);
            this.mTitleView.setGravity(16);
            localLinearLayout.addView(this.mTitleView);
          }
        }
      }
      label598:
      paramView = null;
      localLinearLayout = null;
    }
  }
  
  public View a(anqu paramanqu, View paramView, Bundle paramBundle)
  {
    Resources localResources = this.mContext.getResources();
    if ((paramView != null) && ((paramView instanceof FrameLayout)))
    {
      paramView = (FrameLayout)paramView;
      paramanqu.a(this.mContext, paramView.findViewById(2131369004), paramBundle);
      return paramView;
    }
    paramView = new FrameLayout(this.mContext);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    paramView.setId(2131378957);
    if (paramBundle != null) {
      paramBundle.putBoolean("pa_should_change", true);
    }
    paramanqu = (ImageView)paramanqu.a(this.mContext, null, paramBundle).findViewById(2131369004);
    paramBundle = new FrameLayout.LayoutParams(-1, this.dMy);
    if ((paramanqu != null) && ((paramanqu instanceof PAImageView)))
    {
      PAImageView localPAImageView = (PAImageView)paramanqu;
      localPAImageView.setUseRadiusRound(true, localResources.getDimensionPixelSize(2131296467));
      localPAImageView.setTag(2131373782, Integer.valueOf(1));
    }
    paramView.addView(paramanqu, paramBundle);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anua
 * JD-Core Version:    0.7.0.1
 */