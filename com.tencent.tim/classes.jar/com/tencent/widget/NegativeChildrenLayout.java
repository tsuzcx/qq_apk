package com.tencent.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import autw.b;
import auul;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NegativeChildrenLayout
  extends LinearLayout
{
  View Lt;
  public autw.b c;
  View.OnClickListener clickListener = new auul(this);
  int index;
  Context mContext;
  ArrayList<View> mViewList = new ArrayList();
  LinearLayout mi;
  
  public NegativeChildrenLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initUI(paramContext);
  }
  
  public NegativeChildrenLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initUI(paramContext);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo)
  {
    if (paramView == null) {
      return;
    }
    if ((paramDislikeInfo == null) || (TextUtils.isEmpty(paramDislikeInfo.agQ)))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    paramView.setTag(paramDislikeInfo);
    a(paramView, paramDislikeInfo, "", false);
  }
  
  private void a(View paramView, DislikeInfo paramDislikeInfo, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131370351);
        TextView localTextView1 = (TextView)paramView.findViewById(2131380083);
        TextView localTextView2 = (TextView)paramView.findViewById(2131369478);
        j = 8;
        str = "";
        if (!paramBoolean) {
          continue;
        }
        i = 0;
        paramView = str;
        localTextView2.setText(paramView);
        localImageView.setVisibility(i);
        if (paramString != null) {
          localTextView1.setText(paramString);
        }
      }
      catch (Exception paramView)
      {
        int j;
        String str;
        int i;
        continue;
      }
      paramView = "";
      if (paramDislikeInfo != null) {
        paramView = paramDislikeInfo.toString();
      }
      QLog.e("NegativeChildrenLayout", 1, "updateItemData:" + paramView + " ,name:" + paramString);
      return;
      paramView = str;
      i = j;
      if (paramDislikeInfo != null)
      {
        paramView = str;
        i = j;
        if (!TextUtils.isEmpty(paramDislikeInfo.agQ))
        {
          paramView = paramDislikeInfo.agQ;
          i = j;
        }
      }
    }
  }
  
  private void initUI(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560432, this);
    this.mi = ((LinearLayout)paramContext.findViewById(2131371095));
    this.Lt = paramContext.findViewById(2131367119);
    paramContext = this.Lt.findViewById(2131378043);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    paramContext.setLayoutParams(localLayoutParams);
    this.Lt.setBackgroundResource(0);
  }
  
  public void a(DislikeInfo paramDislikeInfo)
  {
    if (this.mViewList.size() > 6) {}
    while ((paramDislikeInfo == null) || (TextUtils.isEmpty(paramDislikeInfo.agQ))) {
      return;
    }
    View localView = LayoutInflater.from(this.mContext).inflate(2131560433, this.mi, false);
    this.mi.addView(localView);
    localView.setOnClickListener(this.clickListener);
    localView.setTag(paramDislikeInfo);
    this.mViewList.add(localView);
  }
  
  public void setData(ArrayList<DislikeInfo> paramArrayList, String paramString, autw.b paramb)
  {
    if (paramArrayList == null) {
      return;
    }
    setVisibility(0);
    this.index = 0;
    a(this.Lt, null, paramString, true);
    int i = 0;
    while ((i < paramArrayList.size()) && (i < 6))
    {
      if (i > this.mViewList.size() - 1) {
        a((DislikeInfo)paramArrayList.get(i));
      }
      if (i < this.mViewList.size())
      {
        a((View)this.mViewList.get(i), (DislikeInfo)paramArrayList.get(i));
        this.index = i;
      }
      i += 1;
    }
    setLastSeparateLineUnvis();
    i = this.index + 1;
    while (i < this.mViewList.size())
    {
      a((View)this.mViewList.get(i), null);
      i += 1;
    }
    this.c = paramb;
  }
  
  public void setLastSeparateLineUnvis()
  {
    int i = 0;
    View localView2;
    if (i < this.mViewList.size())
    {
      View localView1 = (View)this.mViewList.get(i);
      localView2 = localView1.findViewById(2131378043);
      if (i != this.index) {
        break label68;
      }
      localView1.setBackgroundResource(2130843775);
    }
    label68:
    for (int j = 4;; j = 0)
    {
      if (localView2 != null) {
        localView2.setVisibility(j);
      }
      i += 1;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.NegativeChildrenLayout
 * JD-Core Version:    0.7.0.1
 */