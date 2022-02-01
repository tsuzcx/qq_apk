package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupLabel;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqho;
import aqnm;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import wja;

public class TroopLabelLayout
  extends ViewGroup
{
  static final SparseIntArray aj = new SparseIntArray();
  ArrayList<GroupLabel> CA = new ArrayList();
  private String TAG = "TroopLabelLayout";
  TextView abq;
  boolean cSM = false;
  boolean cSN;
  int dXA = 0;
  int dXz = 5;
  private Drawable fM;
  Runnable hO = new TroopLabelLayout.1(this);
  private Map<Integer, TroopLabelTextView> nT;
  
  static
  {
    aj.put(1, 1);
    aj.put(4, 2);
    aj.put(8, 3);
    aj.put(7, 4);
    aj.put(6, 5);
    aj.put(5, 6);
    aj.put(3, 8);
    aj.put(2, 9);
    aj.put(101, 10);
  }
  
  public TroopLabelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean O(ArrayList<GroupLabel> paramArrayList)
  {
    label357:
    label749:
    label762:
    label764:
    for (;;)
    {
      HashMap localHashMap;
      int i;
      GroupLabel localGroupLabel;
      synchronized (this.CA)
      {
        this.CA.clear();
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
          break label762;
        }
        localHashMap = new HashMap();
        int m = paramArrayList.size();
        i = 0;
        int j = 0;
        if ((j >= m) || (i >= this.dXz)) {
          break label749;
        }
        localGroupLabel = (GroupLabel)paramArrayList.get(j);
        if (TextUtils.isEmpty(localGroupLabel.strWording)) {
          j += 1;
        }
      }
      if ((localGroupLabel.type != 2001L) && ((this.dXA >= 2) || (localGroupLabel.type < 1000L) || (localGroupLabel.type >= 2000L)) && ((this.dXA != 2) || (localGroupLabel.type >= 1000L)))
      {
        synchronized (this.CA)
        {
          this.CA.add(localGroupLabel);
          if ((!this.cSN) && (localGroupLabel.type == 4L))
          {
            if (this.abq == null) {
              break label764;
            }
            this.abq.setText(localGroupLabel.strWording);
          }
        }
        Object localObject2 = a(i);
        int k = android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B);
        int n = android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B);
        if (localObject2 == null)
        {
          ??? = new TroopLabelTextView(getContext(), k, n, this.dXA);
          if (i >= this.dXz) {
            break label749;
          }
          addView((View)???);
          setTroopLabel(i, (TroopLabelTextView)???);
          ((TroopLabelTextView)???).bringToFront();
          if (this.dXA == 2)
          {
            k = wja.dp2px(42.0F, getResources());
            n = wja.dp2px(16.0F, getResources());
            ((TroopLabelTextView)???).setWidth(k);
            ((TroopLabelTextView)???).setHeight(n);
            ((TroopLabelTextView)???).setMaskImage(2130844661);
            if (localGroupLabel.strWording.length() < 2) {
              break label681;
            }
            k = 2;
            localGroupLabel.strWording = localGroupLabel.strWording.substring(0, k);
          }
          if (localGroupLabel.type != 1L) {
            break label707;
          }
          localObject2 = new SpannableString("[icon]" + " " + localGroupLabel.strWording);
          if (this.fM == null)
          {
            if (this.dXA != 0) {
              break label687;
            }
            this.fM = getContext().getResources().getDrawable(2130851819);
          }
          k = (int)(((TroopLabelTextView)???).getTextSize() * 0.8D + 0.5D);
          this.fM.setBounds(0, 0, k, k);
          ((SpannableString)localObject2).setSpan(new ImageSpan(this.fM, 1), 0, "[icon]".length(), 17);
          ((TroopLabelTextView)???).setText((CharSequence)localObject2);
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording + acfp.m(2131715831));
        }
        for (;;)
        {
          ((TroopLabelTextView)???).setVisibility(0);
          localHashMap.put(Integer.valueOf(i), Boolean.valueOf(true));
          i += 1;
          break;
          ((TroopLabelTextView)localObject2).setColor(k, n);
          ??? = localObject2;
          if (!QLog.isColorLevel()) {
            break label357;
          }
          QLog.d(this.TAG, 2, "labeltextview cache");
          ??? = localObject2;
          break label357;
          k = 1;
          break label428;
          this.fM = getContext().getResources().getDrawable(2130844659);
          break label521;
          ((TroopLabelTextView)???).setText(localGroupLabel.strWording + "");
          ((TroopLabelTextView)???).setContentDescription(localGroupLabel.strWording);
        }
        setLabelsUnVisible(localHashMap);
        localHashMap.clear();
        return true;
      }
    }
  }
  
  public TroopLabelTextView a(int paramInt)
  {
    if (this.nT == null) {}
    while (!this.nT.containsKey(Integer.valueOf(paramInt))) {
      return null;
    }
    return (TroopLabelTextView)this.nT.get(Integer.valueOf(paramInt));
  }
  
  public boolean a(List<RecommendLabel> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dXA = paramInt3;
    paramInt3 = 0;
    if (paramList != null) {
      paramInt3 = paramList.size();
    }
    int k;
    if ((paramInt2 == 0) || (paramInt2 == 1)) {
      k = 1;
    }
    for (int j = paramInt3 + 1;; j = paramInt3)
    {
      int i = 0;
      removeAllViews();
      paramInt3 = 0;
      Object localObject;
      label111:
      TroopLabelTextView localTroopLabelTextView;
      if ((paramInt3 < j) && (i < this.dXz))
      {
        if ((k != 0) && (paramInt3 == 0))
        {
          if (paramInt1 > 0)
          {
            localObject = "[icon]" + " " + paramInt1 + "";
            localObject = new SpannableString((CharSequence)localObject);
            if (paramInt2 != 0) {
              break label292;
            }
            m = android.graphics.Color.rgb(0, 202, 252);
          }
          for (this.fM = getContext().getResources().getDrawable(2130846772);; this.fM = getContext().getResources().getDrawable(2130846770))
          {
            localTroopLabelTextView = new TroopLabelTextView(getContext(), m, -1, this.dXA);
            if (i >= this.dXz) {
              break label510;
            }
            addView(localTroopLabelTextView);
            m = (int)(localTroopLabelTextView.getTextSize() * 0.8D + 0.5D);
            this.fM.setBounds(0, 0, m, m);
            ((SpannableString)localObject).setSpan(new ImageSpan(this.fM, 1), 0, "[icon]".length(), 17);
            localTroopLabelTextView.setText((CharSequence)localObject);
            i += 1;
            label258:
            paramInt3 += 1;
            break;
            localObject = "[icon]" + " ";
            break label111;
            label292:
            m = android.graphics.Color.rgb(255, 128, 191);
          }
        }
        if (k == 0) {
          break label534;
        }
      }
      label534:
      for (int m = paramInt3 - 1;; m = paramInt3)
      {
        if ((paramList != null) && (paramList.size() > m))
        {
          localObject = (RecommendLabel)paramList.get(m);
          m = ((RecommendLabel)localObject).edging_color;
          int n = ((RecommendLabel)localObject).text_color;
          localTroopLabelTextView = new TroopLabelTextView(getContext(), m, n, this.dXA);
          if (i < this.dXz)
          {
            addView(localTroopLabelTextView);
            localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
            localTroopLabelTextView.bringToFront();
            if (((RecommendLabel)localObject).bytes_name != null)
            {
              localTroopLabelTextView.setText(((RecommendLabel)localObject).bytes_name);
              localTroopLabelTextView.setContentDescription(((RecommendLabel)localObject).bytes_name);
              if (((k == 0) || (paramInt3 != 1)) && ((k != 0) || (paramInt3 != 0))) {
                break;
              }
              localTroopLabelTextView.setMaxWidth(aqnm.dip2px(150.0F));
              break;
            }
            localTroopLabelTextView.setText("");
            localTroopLabelTextView.setContentDescription("");
            break;
          }
          label510:
          if (j == 0) {
            setVisibility(8);
          }
          for (;;)
          {
            return true;
            setVisibility(0);
          }
        }
        break label258;
      }
      k = 0;
    }
  }
  
  public boolean b(MayKnowRecommend paramMayKnowRecommend)
  {
    int i;
    int m;
    if (paramMayKnowRecommend != null)
    {
      i = 0;
      if (paramMayKnowRecommend.msgLabel != null) {
        i = paramMayKnowRecommend.msgLabel.size();
      }
      if ((paramMayKnowRecommend.gender != 0) && (paramMayKnowRecommend.gender != 1)) {
        break label551;
      }
      m = 1;
    }
    for (int k = i + 1;; k = i)
    {
      int j = 0;
      removeAllViews();
      i = 0;
      Object localObject;
      label119:
      TroopLabelTextView localTroopLabelTextView;
      if ((i < k) && (j < this.dXz))
      {
        if ((m != 0) && (i == 0))
        {
          if (paramMayKnowRecommend.age > 0)
          {
            localObject = "[icon]" + " " + paramMayKnowRecommend.age + "";
            localObject = new SpannableString((CharSequence)localObject);
            if (paramMayKnowRecommend.gender != 0) {
              break label298;
            }
            n = android.graphics.Color.rgb(0, 202, 252);
          }
          for (this.fM = getContext().getResources().getDrawable(2130846772);; this.fM = getContext().getResources().getDrawable(2130846770))
          {
            localTroopLabelTextView = new TroopLabelTextView(getContext(), n, -1, this.dXA);
            if (j >= this.dXz) {
              break label521;
            }
            addView(localTroopLabelTextView);
            n = (int)(localTroopLabelTextView.getTextSize() * 0.8D + 0.5D);
            this.fM.setBounds(0, 0, n, n);
            ((SpannableString)localObject).setSpan(new ImageSpan(this.fM, 1), 0, "[icon]".length(), 17);
            localTroopLabelTextView.setText((CharSequence)localObject);
            j += 1;
            label266:
            i += 1;
            break;
            localObject = "[icon]" + " ";
            break label119;
            label298:
            n = android.graphics.Color.rgb(255, 128, 191);
          }
        }
        if (m == 0) {
          break label545;
        }
      }
      label521:
      label545:
      for (int n = i - 1;; n = i)
      {
        if ((paramMayKnowRecommend.msgLabel != null) && (paramMayKnowRecommend.msgLabel.size() > n))
        {
          localObject = (MayKnowRecommend.MayKnowRecommendLabel)paramMayKnowRecommend.msgLabel.get(n);
          n = ((MayKnowRecommend.MayKnowRecommendLabel)localObject).edging_color;
          int i1 = ((MayKnowRecommend.MayKnowRecommendLabel)localObject).text_color;
          localTroopLabelTextView = new TroopLabelTextView(getContext(), n, i1, this.dXA);
          if (j < this.dXz)
          {
            addView(localTroopLabelTextView);
            localTroopLabelTextView.setEllipsize(TextUtils.TruncateAt.END);
            localTroopLabelTextView.bringToFront();
            if (((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name != null)
            {
              localTroopLabelTextView.setText(((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name);
              localTroopLabelTextView.setContentDescription(((MayKnowRecommend.MayKnowRecommendLabel)localObject).bytes_name);
              if (((m == 0) || (i != 1)) && ((m != 0) || (i != 0))) {
                break;
              }
              localTroopLabelTextView.setMaxWidth(aqnm.dip2px(150.0F));
              break;
            }
            localTroopLabelTextView.setText("");
            localTroopLabelTextView.setContentDescription("");
            break;
          }
          if (k == 0) {
            setVisibility(8);
          }
          for (;;)
          {
            return true;
            setVisibility(0);
          }
        }
        break label266;
      }
      label551:
      m = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = (int)aqho.convertDpToPixel(getContext(), 2.0F);
    int n = getChildCount();
    paramInt2 = getPaddingLeft();
    int i1 = getPaddingTop();
    paramInt4 = 0;
    View localView;
    if (paramInt4 < n)
    {
      localView = getChildAt(paramInt4);
      if (localView.getVisibility() != 8) {}
    }
    for (;;)
    {
      paramInt4 += 1;
      break;
      int i2 = localView.getMeasuredWidth();
      int i3 = localView.getMeasuredHeight();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (paramInt2 + i2 > paramInt3 - paramInt1 - j - k)
      {
        if (this.cSM) {
          post(this.hO);
        }
        return;
      }
      int i = localLayoutParams.rightMargin + (m + i2) + paramInt2;
      localView.layout(paramInt2, i1, i2 + paramInt2, i3 + i1);
      paramInt2 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    View localView;
    switch (n)
    {
    default: 
      paramInt1 = 0;
      switch (m)
      {
      default: 
        paramInt2 = j;
        if (getChildCount() > 0)
        {
          localView = getChildAt(0);
          i = 0 + (getPaddingBottom() + getPaddingTop());
          paramInt2 = i;
          if (localView == null) {}
        }
        break;
      }
      break;
    }
    for (paramInt2 = i + localView.getMeasuredHeight();; paramInt2 = k)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = i;
      break;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt1 < getChildCount())
      {
        paramInt2 += getChildAt(paramInt1).getWidth();
        paramInt1 += 1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 <= i) {
        break;
      }
      paramInt1 = i;
      break;
    }
  }
  
  public void setAutoCreateDistanceTextView(boolean paramBoolean)
  {
    this.cSN = paramBoolean;
  }
  
  public void setDistanceTextView(TextView paramTextView)
  {
    this.abq = paramTextView;
  }
  
  public void setLabelType(int paramInt)
  {
    this.dXA = paramInt;
  }
  
  public void setLabelsUnVisible(Map<Integer, Boolean> paramMap)
  {
    if (this.nT == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.nT.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!paramMap.containsKey(localEntry.getKey())) {
          ((TroopLabelTextView)localEntry.getValue()).setVisibility(8);
        }
      }
    }
  }
  
  public void setMaxLabelCount(int paramInt)
  {
    this.dXz = paramInt;
  }
  
  public void setTroopLabel(int paramInt, TroopLabelTextView paramTroopLabelTextView)
  {
    if (this.nT == null) {
      this.nT = new HashMap();
    }
    if (!this.nT.containsKey(Integer.valueOf(paramInt))) {
      this.nT.put(Integer.valueOf(paramInt), paramTroopLabelTextView);
    }
  }
  
  public void setmIsNeedPriority(boolean paramBoolean)
  {
    this.cSM = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelLayout
 * JD-Core Version:    0.7.0.1
 */