package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqnm;
import java.util.ArrayList;
import java.util.List;

public class LabelLayout
  extends LinearLayout
{
  public LabelLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LabelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LabelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOrientation(0);
  }
  
  public int a(int paramInt1, List<a> paramList, boolean paramBoolean, int paramInt2)
  {
    removeAllViews();
    int j = aqnm.dpToPx(12.0F);
    int k = aqnm.dpToPx(1.0F);
    int m = aqnm.dpToPx(8.0F);
    int n = aqnm.dpToPx(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(aqnm.dpToPx(paramInt2));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    a locala;
    if (i < i1)
    {
      locala = (a)paramList.get(i);
      if (TextUtils.isEmpty(locala.J)) {
        break label366;
      }
      int i2 = (int)(((Paint)localObject).measureText(locala.J.toString()) + m * 2);
      if (paramInt1 >= i2 + n)
      {
        localArrayList.add(locala);
        paramInt1 = paramInt1 - i2 - n;
      }
    }
    label366:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(locala);
      }
      i = localArrayList.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject = (a)localArrayList.get(paramInt1);
        paramList = new LabelTextView(getContext());
        paramList.setParam(((a)localObject).bgColor, ((a)localObject).textColor, j);
        paramList.setTextSize(paramInt2);
        paramList.setText(((a)localObject).J);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt1 != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt1 += 1;
      }
      if (paramBoolean)
      {
        addView(new View(getContext()), 0, new LinearLayout.LayoutParams(0, 0, 1.0F));
        addView(new View(getContext()), getChildCount(), new LinearLayout.LayoutParams(0, 0, 1.0F));
      }
      return localArrayList.size();
    }
  }
  
  public static class a
  {
    public CharSequence J;
    public int bgColor;
    public int textColor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.LabelLayout
 * JD-Core Version:    0.7.0.1
 */