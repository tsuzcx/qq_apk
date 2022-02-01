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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class anuc
{
  private anqv a;
  private int dMx = -1;
  private int dMy;
  private Context mContext;
  
  public anuc(anqv paramanqv, Context paramContext, int paramInt)
  {
    this.a = paramanqv;
    this.mContext = paramContext;
    this.dMx = paramInt;
    this.dMy = this.mContext.getResources().getDimensionPixelSize(2131296468);
  }
  
  private TextView a(anux paramanux, View paramView)
  {
    Resources localResources = this.mContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.mContext);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.setMargins(0, 0, 0, 0);
      localTextView.setLayoutParams(paramView);
      localTextView.setMaxLines(3);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setLineSpacing(wja.dp2px(2.5F, localResources), 1.0F);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      int i = wja.dp2px(15.0F, localResources);
      int j = wja.dp2px(12.0F, localResources);
      localTextView.setPadding(j, wja.dp2px(18.0F, localResources), j, i);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramanux.getText()))
      {
        localTextView.setText(paramanux.getText().trim());
        paramView = localTextView;
      }
    }
    do
    {
      return paramView;
      localTextView = (TextView)paramView;
      paramView = localTextView;
    } while (TextUtils.isEmpty(paramanux.getText()));
    localTextView.setText(paramanux.getText().trim());
    return localTextView;
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
      localTextView.setIncludeFontPadding(false);
      if (paramBoolean) {
        localTextView.setBackgroundResource(2130842480);
      }
      int i = wja.dp2px(8.0F, localResources);
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
    Object localObject = null;
    if (BaseApplicationImpl.sApplication != null) {
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    }
    if ((localObject == null) || (TextUtils.isEmpty(paramanqv.uin)) || ((!ocp.m((QQAppInterface)localObject, paramanqv.uin)) && (!"2909288299".equals(paramanqv.uin)) && (!"3338705755".equals(paramanqv.uin)))) {}
    int j;
    label83:
    do
    {
      do
      {
        return false;
      } while (paramInt != 0);
      int i = 0;
      j = 0;
      paramInt = 0;
      if (i < paramanqv.rz.size())
      {
        localObject = ((anqu)paramanqv.rz.get(i)).mTypeName;
        int m;
        int k;
        if ("picture".equals(localObject))
        {
          m = paramInt + 1;
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          paramInt = m;
          break label83;
          if ("summary".equals(localObject))
          {
            k = j;
            m = paramInt;
            if (paramInt != 0)
            {
              k = j + 1;
              m = paramInt;
            }
          }
          else
          {
            if (!"title".equals(localObject)) {
              break;
            }
            k = j;
            m = paramInt;
          }
        }
      }
    } while ((paramInt != 1) || (j > 1));
    return true;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3 = null;
    paramContext.getResources();
    Object localObject2 = null;
    if (!a(this.a, this.dMx))
    {
      paramContext = this.a.a(paramContext, paramView, paramBundle);
      return paramContext;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout6Adapter", 2, "layout6 use new style!");
    }
    Object localObject1 = localObject3;
    FrameLayout localFrameLayout;
    int i;
    int j;
    int k;
    label117:
    String str;
    int m;
    if (paramView != null)
    {
      localObject1 = localObject3;
      if ((paramView instanceof LinearLayout))
      {
        localObject1 = (LinearLayout)paramView;
        localFrameLayout = (FrameLayout)((LinearLayout)localObject1).findViewById(2131378957);
        if (localFrameLayout != null)
        {
          paramView = null;
          localObject3 = new ArrayList();
          i = 0;
          j = 0;
          k = 0;
          paramContext = (Context)localObject2;
          if (k < this.a.rz.size())
          {
            localObject2 = (anqu)this.a.rz.get(k);
            str = ((anqu)localObject2).mTypeName;
            if ("title".equals(str))
            {
              localObject2 = ((StructMsgItemTitle)localObject2).getText();
              m = j;
              paramView = paramContext;
              paramContext = (Context)localObject2;
              j = i;
              i = m;
            }
          }
        }
      }
    }
    for (;;)
    {
      m = k + 1;
      localObject2 = paramContext;
      paramContext = paramView;
      k = j;
      j = i;
      i = k;
      paramView = (View)localObject2;
      k = m;
      break label117;
      if ("picture".equals(str))
      {
        localObject2 = a((anqu)localObject2, localFrameLayout, paramBundle);
        m = 1;
        paramContext = paramView;
        paramView = (View)localObject2;
        j = i;
        i = m;
      }
      else
      {
        if ("summary".equals(str))
        {
          localObject2 = (anux)localObject2;
          if ((j != 0) && (!TextUtils.isEmpty(((anux)localObject2).getText())))
          {
            if (((anux)localObject2).getText().trim().length() <= 0)
            {
              localObject2 = paramContext;
              m = i;
              i = j;
              j = m;
              paramContext = paramView;
              paramView = (View)localObject2;
              continue;
            }
            ((ArrayList)localObject3).add(a((anux)localObject2, ((LinearLayout)localObject1).findViewById(i + 2131378972)));
            localObject2 = paramContext;
            paramContext = paramView;
            m = i + 1;
            i = j;
            j = m;
            paramView = (View)localObject2;
            continue;
            ((LinearLayout)localObject1).removeAllViews();
            if (paramContext != null)
            {
              paramBundle = (TextView)paramContext.findViewById(2131378970);
              if (!TextUtils.isEmpty(paramView)) {
                if (paramBundle == null)
                {
                  paramView = a(paramView, null, true);
                  paramView.setId(2131378970);
                  paramBundle = new ViewGroup.LayoutParams(-1, this.dMy);
                  ((ViewGroup)paramContext).addView(paramView, paramBundle);
                  label449:
                  ((LinearLayout)localObject1).addView(paramContext);
                }
              }
            }
            for (;;)
            {
              paramContext = (Context)localObject1;
              if (((ArrayList)localObject3).size() <= 0) {
                break;
              }
              paramView = ((ArrayList)localObject3).iterator();
              for (;;)
              {
                paramContext = (Context)localObject1;
                if (!paramView.hasNext()) {
                  break;
                }
                ((LinearLayout)localObject1).addView((View)paramView.next());
              }
              a(paramView, paramBundle, true);
              break label449;
              if (paramBundle == null) {
                break label449;
              }
              ((ViewGroup)paramContext).removeView(paramBundle);
              break label449;
              if (!TextUtils.isEmpty(paramView))
              {
                paramContext = a(paramView.trim(), null, false);
                paramView = new ViewGroup.LayoutParams(-1, -2);
                paramContext.setGravity(16);
                ((LinearLayout)localObject1).addView(paramContext, 0, paramView);
              }
            }
            ((LinearLayout)localObject1).removeAllViews();
            if (localObject1 == null)
            {
              localObject1 = new LinearLayout(paramContext);
              ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
              ((LinearLayout)localObject1).setOrientation(1);
            }
            for (;;)
            {
              i = 0;
              j = 0;
              paramContext = null;
              paramView = null;
              if (j < this.a.rz.size())
              {
                localObject2 = (anqu)this.a.rz.get(j);
                localObject3 = ((anqu)localObject2).mTypeName;
                if ("title".equals(localObject3))
                {
                  localObject2 = ((StructMsgItemTitle)localObject2).getText();
                  paramView = paramContext;
                  paramContext = (Context)localObject2;
                }
                for (;;)
                {
                  j += 1;
                  localObject2 = paramContext;
                  paramContext = paramView;
                  paramView = (View)localObject2;
                  break;
                  if ("picture".equals(localObject3))
                  {
                    localObject2 = a((anqu)localObject2, null, paramBundle);
                    ((LinearLayout)localObject1).addView((View)localObject2);
                    i = 1;
                    paramContext = paramView;
                    paramView = (View)localObject2;
                  }
                  else
                  {
                    if ("summary".equals(localObject3))
                    {
                      localObject2 = (anux)localObject2;
                      if ((i != 0) && (!TextUtils.isEmpty(((anux)localObject2).getText())))
                      {
                        if (((anux)localObject2).getText().trim().length() <= 0)
                        {
                          localObject2 = paramContext;
                          paramContext = paramView;
                          paramView = (View)localObject2;
                          continue;
                        }
                        localObject2 = a((anux)localObject2, null);
                        ((TextView)localObject2).setId(2131378972 + j);
                        ((LinearLayout)localObject1).addView((View)localObject2);
                      }
                    }
                    localObject2 = paramContext;
                    paramContext = paramView;
                    paramView = (View)localObject2;
                  }
                }
              }
              if ((paramContext != null) && (!TextUtils.isEmpty(paramView)))
              {
                paramBundle = new ViewGroup.LayoutParams(-1, this.dMy);
                paramView = a(paramView.trim(), null, true);
                paramView.setId(2131378970);
                ((ViewGroup)paramContext).addView(paramView, paramBundle);
              }
              for (;;)
              {
                return localObject1;
                if ((!TextUtils.isEmpty(paramView)) && (paramView.trim().length() > 0))
                {
                  paramContext = a(paramView.trim(), null, false);
                  paramView = new LinearLayout.LayoutParams(-1, -2);
                  paramContext.setGravity(16);
                  ((LinearLayout)localObject1).addView(paramContext, 0, paramView);
                }
              }
            }
          }
        }
        localObject2 = paramContext;
        m = i;
        i = j;
        j = m;
        paramContext = paramView;
        paramView = (View)localObject2;
      }
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
    if ((paramanqu != null) && ((paramanqu instanceof PAImageView))) {
      ((PAImageView)paramanqu).setUseRadiusRound(true, localResources.getDimensionPixelSize(2131296467));
    }
    paramView.addView(paramanqu, paramBundle);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuc
 * JD-Core Version:    0.7.0.1
 */