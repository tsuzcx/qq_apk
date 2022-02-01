package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import wja;

public class KPLScoreView
  extends LinearLayout
{
  TextView abY;
  TextView abZ;
  TextView aca;
  TextView acb;
  private Context context;
  LinearLayout ll;
  LinearLayout lm;
  LinearLayout ln;
  LinearLayout lo;
  
  public KPLScoreView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KPLScoreView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    initView();
  }
  
  private void initView()
  {
    LayoutInflater.from(this.context).inflate(2131561389, this, true);
    this.ll = ((LinearLayout)findViewById(2131372147));
    this.abY = ((TextView)this.ll.findViewById(2131380771));
    this.lm = ((LinearLayout)findViewById(2131379017));
    this.abZ = ((TextView)this.lm.findViewById(2131380774));
    this.ln = ((LinearLayout)findViewById(2131376625));
    this.aca = ((TextView)this.ln.findViewById(2131380772));
    this.lo = ((LinearLayout)findViewById(2131377578));
    this.acb = ((TextView)this.lo.findViewById(2131380773));
  }
  
  public void setKplValue(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i;
    int j;
    label30:
    int k;
    if (paramString1.length() > 0)
    {
      i = paramString1.length() - 1;
      if (paramString2.length() <= 0) {
        break label487;
      }
      j = paramString2.length() - 1;
      if (paramString3.length() <= 0) {
        break label493;
      }
      k = paramString3.length() - 1;
      label45:
      if (paramString4.length() <= 0) {
        break label499;
      }
    }
    label487:
    label493:
    label499:
    for (int m = paramString4.length() - 1;; m = 0)
    {
      paramString1 = new SpannableString(paramString1);
      paramString2 = new SpannableString(paramString2);
      paramString3 = new SpannableString(paramString3);
      paramString4 = new SpannableString(paramString4);
      AbsoluteSizeSpan localAbsoluteSizeSpan1 = new AbsoluteSizeSpan(27, true);
      AbsoluteSizeSpan localAbsoluteSizeSpan2 = new AbsoluteSizeSpan(14, true);
      StyleSpan localStyleSpan = new StyleSpan(1);
      paramString1.setSpan(localAbsoluteSizeSpan1, 0, i, 17);
      paramString1.setSpan(localAbsoluteSizeSpan2, i, i + 1, 17);
      paramString1.setSpan(localStyleSpan, 0, i, 17);
      paramString2.setSpan(localAbsoluteSizeSpan1, 0, j, 17);
      paramString2.setSpan(localAbsoluteSizeSpan2, j, j + 1, 17);
      paramString2.setSpan(localStyleSpan, 0, j, 17);
      paramString3.setSpan(localAbsoluteSizeSpan1, 0, k, 17);
      paramString3.setSpan(localAbsoluteSizeSpan2, k, k + 1, 17);
      paramString3.setSpan(localStyleSpan, 0, k, 17);
      paramString4.setSpan(localAbsoluteSizeSpan1, 0, m, 17);
      paramString4.setSpan(localAbsoluteSizeSpan2, m, m + 1, 17);
      paramString4.setSpan(localStyleSpan, 0, m, 17);
      this.abY.setText(paramString1);
      this.abZ.setText(paramString2);
      this.aca.setText(paramString3);
      this.acb.setText(paramString4);
      this.abY.measure(0, 0);
      this.abZ.measure(0, 0);
      this.aca.measure(0, 0);
      this.acb.measure(0, 0);
      i = this.abY.getMeasuredWidth();
      j = this.abZ.getMeasuredWidth();
      k = this.aca.getMeasuredWidth();
      m = this.acb.getMeasuredWidth();
      i = (((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - (i + j + k + m) - wja.dp2px(24.0F, this.context.getResources())) / 3;
      paramString1 = new LinearLayout.LayoutParams(-2, -2);
      paramString1.setMargins(i, 0, 0, 0);
      this.lm.setLayoutParams(paramString1);
      this.ln.setLayoutParams(paramString1);
      this.lo.setLayoutParams(paramString1);
      return;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.KPLScoreView
 * JD-Core Version:    0.7.0.1
 */