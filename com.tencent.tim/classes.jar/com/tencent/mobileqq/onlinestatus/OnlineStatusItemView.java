package com.tencent.mobileqq.onlinestatus;

import akti;
import aktk;
import akto;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aofk.a;
import auun;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import wja;

public class OnlineStatusItemView
  extends LinearLayout
{
  private int OE;
  private TextView WJ;
  private ImageView aL;
  public akto b;
  public boolean cuy;
  public boolean isSelected;
  
  public OnlineStatusItemView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void Nl(boolean paramBoolean)
  {
    this.aL = new ImageView(getContext());
    this.aL.setId(2131372640);
    Object localObject = new LinearLayout.LayoutParams(this.OE, this.OE);
    addView(this.aL, (ViewGroup.LayoutParams)localObject);
    this.WJ = new TextView(getContext());
    this.WJ.setId(2131372641);
    this.WJ.setTextSize(1, 14.0F);
    TextView localTextView = this.WJ;
    if (paramBoolean) {}
    for (localObject = "#FFFFFF";; localObject = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor((String)localObject));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(8.0F, getResources());
      addView(this.WJ, (ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private String xI()
  {
    return "";
  }
  
  public void Nm(boolean paramBoolean)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    int i;
    TextView localTextView;
    String str;
    if (bool)
    {
      i = 2130839672;
      setBackgroundResource(i);
      this.isSelected = paramBoolean;
      setSelected(paramBoolean);
      localTextView = this.WJ;
      if (!bool) {
        break label65;
      }
      str = "#FFFFFF";
    }
    for (;;)
    {
      localTextView.setTextColor(Color.parseColor(str));
      invalidate();
      return;
      i = 2130839673;
      break;
      label65:
      if (paramBoolean) {
        str = "#FFFFFF";
      } else {
        str = "#03081A";
      }
    }
  }
  
  public void b(akto paramakto)
  {
    if (paramakto == null) {}
    for (;;)
    {
      return;
      this.b = paramakto;
      this.WJ.setText(paramakto.title);
      if (paramakto.itemType == 2) {
        paramakto = aktk.a(paramakto.f);
      }
      while (paramakto != null)
      {
        paramakto.setBounds(0, 0, this.OE, this.OE);
        this.aL.setImageDrawable(paramakto);
        return;
        if ((this.cuy) && (!TextUtils.isEmpty(xI())))
        {
          paramakto = new aofk(xI(), 3).mSpans[0];
          if ((paramakto instanceof aofk.a)) {
            paramakto = ((aofk.a)paramakto).getDrawable();
          }
        }
        else
        {
          if (akti.a().a(paramakto))
          {
            int i = akti.Hc();
            paramakto = new auun().i(i, 1);
            continue;
          }
          paramakto = URLDrawable.getDrawable(this.b.iconUrl, URLDrawable.URLDrawableOptions.obtain());
          continue;
        }
        paramakto = null;
      }
    }
  }
  
  public void init()
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    setOrientation(0);
    setGravity(17);
    if (bool) {}
    for (int i = 2130839672;; i = 2130839673)
    {
      setBackgroundResource(i);
      this.OE = wja.dp2px(16.0F, getResources());
      Nl(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView
 * JD-Core Version:    0.7.0.1
 */