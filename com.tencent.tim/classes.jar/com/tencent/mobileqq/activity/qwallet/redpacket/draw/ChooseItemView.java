package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aady;
import aadz;
import aaea;
import aaeb;
import aaec;
import aagd;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public class ChooseItemView
  extends FrameLayout
{
  public a a;
  private String bcC;
  private View.OnClickListener eF;
  private View.OnClickListener eG;
  private View.OnClickListener eH = new aaea(this);
  private LinearLayout mContent = new LinearLayout(getContext());
  private List<String> mItems = new LinkedList();
  
  public ChooseItemView(Context paramContext)
  {
    super(paramContext);
    this.mContent.setOrientation(1);
    addView(this.mContent);
    paramContext = (FrameLayout.LayoutParams)this.mContent.getLayoutParams();
    paramContext.width = -1;
    paramContext.height = -2;
    setOnClickListener(new aady(this));
    this.mContent.setOnTouchListener(new aadz(this));
  }
  
  private TextView a(Context paramContext, String paramString)
  {
    TextView localTextView = new TextView(paramContext);
    if ((!TextUtils.isEmpty(this.bcC)) && (this.bcC.equals(paramString)))
    {
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(2130848158);
    }
    for (;;)
    {
      localTextView.setTextSize(1, 13.0F);
      localTextView.setGravity(16);
      int i = aqcx.dip2px(paramContext, 13.0F);
      localTextView.setPadding(i, 0, i, 0);
      localTextView.setText(paramString);
      localTextView.setOnClickListener(this.eF);
      aagd.k(localTextView, 0.6F);
      paramString = new LinearLayout.LayoutParams(-2, aqcx.dip2px(paramContext, 30.0F));
      paramString.leftMargin = aqcx.dip2px(paramContext, 12.0F);
      localTextView.setLayoutParams(paramString);
      localTextView.measure(0, 0);
      return localTextView;
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130848157);
      if ((localTextView.getBackground() instanceof GradientDrawable)) {
        ((GradientDrawable)localTextView.getBackground()).setColor(-1315339);
      }
    }
  }
  
  private void ctP()
  {
    QLog.i("ChooseItemView", 2, "updatePageInner....");
    this.mContent.removeAllViews();
    this.mContent.setPadding(aqcx.dip2px(getContext(), 8.0F), 0, this.mContent.getPaddingRight(), aqcx.dip2px(getContext(), 10.0F));
    Object localObject1 = new TextView(getContext());
    this.mContent.addView((View)localObject1);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).height = -2;
    ((LinearLayout.LayoutParams)localObject2).width = -2;
    ((LinearLayout.LayoutParams)localObject2).gravity = 5;
    localObject2 = getContext().getResources().getDrawable(2130844260);
    ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(aqcx.dip2px(getContext(), 7.0F));
    ((TextView)localObject1).setPadding(aqcx.dip2px(getContext(), 5.0F), 0, aqcx.dip2px(getContext(), 20.0F), aqcx.dip2px(getContext(), 10.0F));
    ((TextView)localObject1).setText(acfp.m(2131703839));
    ((TextView)localObject1).setTextColor(-1694379);
    ((TextView)localObject1).setTextSize(1, 14.0F);
    ((TextView)localObject1).setOnClickListener(this.eH);
    aagd.k((View)localObject1, 0.6F);
    int m = this.mContent.getWidth();
    int i = 0;
    int j = 0;
    localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setGravity(16);
    int k = aqcx.dip2px(getContext(), 6.0F);
    ((LinearLayout)localObject2).setPadding(0, k, 0, k);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    this.mContent.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = (String)this.mItems.get(i);
    localObject1 = a(getContext(), (String)localObject1);
    k = 0;
    for (;;)
    {
      k = ((TextView)localObject1).getMeasuredWidth() + aqcx.dip2px(getContext(), 12.0F) + k;
      ((LinearLayout)localObject2).addView((View)localObject1);
      i += 1;
      if (i < this.mItems.size())
      {
        localObject1 = (String)this.mItems.get(i);
        localObject1 = a(getContext(), (String)localObject1);
      }
      if ((i >= this.mItems.size()) || (((TextView)localObject1).getMeasuredWidth() + k + aqcx.dip2px(getContext(), 12.0F) * 2 > m))
      {
        j += 1;
        if ((j >= 4) || (i >= this.mItems.size())) {
          return;
        }
        break;
      }
    }
  }
  
  public void Ah(String paramString)
  {
    if (getVisibility() == 0)
    {
      dismiss();
      return;
    }
    bo(paramString, false);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, a parama)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            String str = paramString.optString(i);
            if (!TextUtils.isEmpty(str)) {
              this.mItems.add(str);
            }
            i += 1;
          }
        }
        this.eF = new aaec(this, paramOnClickListener1);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        if ((this.mItems != null) && (this.mItems.size() > 1)) {
          Collections.shuffle(this.mItems);
        }
      }
    }
    this.eG = paramOnClickListener2;
    this.a = parama;
  }
  
  public void a(List<String> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, a parama)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (!TextUtils.isEmpty(str)) {
            this.mItems.add(str);
          }
        }
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        if ((this.mItems != null) && (this.mItems.size() > 1)) {
          Collections.shuffle(this.mItems);
        }
        this.eF = new aaeb(this, paramOnClickListener1);
        this.eG = paramOnClickListener2;
        this.a = parama;
      }
    }
  }
  
  public void bo(String paramString, boolean paramBoolean)
  {
    this.bcC = paramString;
    if (!isValid()) {
      return;
    }
    setVisibility(0);
    this.mContent.post(new ChooseItemView.3(this));
    QLog.i("ChooseItemView", 2, "show....");
  }
  
  public void dismiss()
  {
    setVisibility(8);
  }
  
  public boolean isValid()
  {
    return (this.mItems != null) && (this.mItems.size() > 0);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.a != null) {
      this.a.FM(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void FM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView
 * JD-Core Version:    0.7.0.1
 */