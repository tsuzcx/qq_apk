package com.tencent.mobileqq.richstatus.comment.widget;

import amhr;
import amhs;
import amhu;
import amhv;
import amhw;
import amhx;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aofk;
import atau.a;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import wja;

public class CommentsView
  extends LinearLayout
  implements ViewGroup.OnHierarchyChangeListener
{
  private String TAG = "CommentsView";
  private amhu<View> jdField_a_of_type_Amhu;
  private a jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView$a;
  private b jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView$b;
  private c jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView$c;
  private int dBX;
  private int gT;
  private List<CommentItem> kZ;
  private LayoutInflater layoutInflater;
  private int mNormalTextColor;
  
  public CommentsView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CommentsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
    f(paramAttributeSet);
  }
  
  public CommentsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    f(paramAttributeSet);
  }
  
  private void O(View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView;
    amhs localamhs = new amhs(this.dBX, this.dBX);
    CommentItem localCommentItem = (CommentItem)this.kZ.get(paramInt);
    String str = localCommentItem.user.nickName;
    paramView = "";
    if (localCommentItem.toReplyUser != null) {
      paramView = localCommentItem.toReplyUser.nickName;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(a(str, localCommentItem.user.uin));
    if (!TextUtils.isEmpty(paramView))
    {
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(getContext().getString(2131718804));
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(a(paramView, localCommentItem.toReplyUser.uin));
    }
    localSpannableStringBuilder.append(": ");
    paramView = localCommentItem.content;
    if (!TextUtils.isEmpty(paramView)) {
      localSpannableStringBuilder.append(paramView);
    }
    localTextView.setText(new aofk(localSpannableStringBuilder, 3, 16));
    localTextView.setTextColor(this.mNormalTextColor);
    localTextView.setMovementMethod(localamhs);
    localTextView.setOnClickListener(new amhv(this, localamhs, paramInt));
    localTextView.setOnLongClickListener(new amhw(this, localamhs, paramInt));
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new amhx(this, this.gT, paramString2), 0, paramString1.length(), 33);
    return paramString1;
  }
  
  private View getView(int paramInt)
  {
    View localView2 = (View)this.jdField_a_of_type_Amhu.get();
    View localView1 = localView2;
    if (localView2 == null)
    {
      if (this.layoutInflater == null) {
        this.layoutInflater = LayoutInflater.from(getContext());
      }
      localView1 = this.layoutInflater.inflate(2131562246, null, false);
    }
    O(localView1, paramInt);
    return localView1;
  }
  
  private void init()
  {
    this.jdField_a_of_type_Amhu = new amhu();
    setOnHierarchyChangeListener(this);
    this.mNormalTextColor = getResources().getColor(2131167507);
  }
  
  protected void f(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.pZ, 0, 0);
    try
    {
      this.gT = paramAttributeSet.getColor(0, getResources().getColor(2131166733));
      this.dBX = paramAttributeSet.getColor(1, getResources().getColor(2131167224));
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  public void lY(List<CommentItem> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.kZ = ((List)localObject);
    notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged()
  {
    int i = 0;
    if ((this.kZ == null) || (this.kZ.size() == 0)) {
      setVisibility(8);
    }
    do
    {
      return;
      setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = wja.dp2px(2.0F, getResources());
      if (i < this.kZ.size())
      {
        if (getChildCount() > i) {
          O(getChildAt(i), i);
        }
        for (;;)
        {
          i += 1;
          break;
          View localView = getView(i);
          if (localView == null)
          {
            QLog.e(this.TAG, 1, "listView item layout is null, please check getView()...");
            return;
          }
          addView(localView, i, localLayoutParams);
        }
      }
    } while (getChildCount() <= this.kZ.size());
    removeViews(this.kZ.size(), getChildCount() - this.kZ.size());
  }
  
  public void onChildViewAdded(View paramView1, View paramView2) {}
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.jdField_a_of_type_Amhu.put(paramView2);
  }
  
  public void setItemColor(int paramInt)
  {
    this.gT = paramInt;
  }
  
  public void setNormalTextColor(int paramInt)
  {
    this.mNormalTextColor = paramInt;
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView$a = parama;
  }
  
  public void setOnItemLongClickListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView$b = paramb;
  }
  
  public void setOnSpanItemClick(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView$c = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void j(int paramInt, View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void onItemLongClick(int paramInt, View paramView);
  }
  
  public static abstract interface c
  {
    public abstract void PC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.CommentsView
 * JD-Core Version:    0.7.0.1
 */