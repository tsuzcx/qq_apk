package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

public class BaseChatItemLayout
  extends RelativeLayout
{
  public static final float a;
  public static final int a = 0;
  public static final float b;
  public static final int b = 1;
  public static final float c;
  public static final int c = 2131230779;
  @Deprecated
  public static final float d;
  public static final int d = 108;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  public static final int u;
  public static final int v;
  public static final int w;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public TextView a;
  public URLImageView a;
  public ImageView b;
  TextView b;
  public ImageView c;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  private TextView h;
  int x = 0;
  int y;
  
  static
  {
    Context localContext = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localContext.getResources().getDisplayMetrics();
    jdField_d_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Float = localContext.getResources().getDimensionPixelSize(2131427359);
    jdField_b_of_type_Float = localContext.getResources().getDimensionPixelSize(2131427352);
    jdField_c_of_type_Float = localContext.getResources().getDimensionPixelSize(2131427359);
    i = localContext.getResources().getDimensionPixelSize(2131427459);
    j = localContext.getResources().getDimensionPixelSize(2131427460);
    k = localContext.getResources().getDimensionPixelSize(2131427461);
    l = localContext.getResources().getDimensionPixelSize(2131427462);
    m = localContext.getResources().getDimensionPixelSize(2131427463);
    n = localContext.getResources().getDimensionPixelSize(2131427465);
    o = localContext.getResources().getDimensionPixelSize(2131427466);
    p = localContext.getResources().getDimensionPixelSize(2131427467);
    q = localContext.getResources().getDimensionPixelSize(2131427468);
    t = localContext.getResources().getDimensionPixelSize(2131427475);
    s = localContext.getResources().getDimensionPixelSize(2131427474);
    r = localContext.getResources().getDimensionPixelSize(2131427464);
    jdField_e_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    jdField_f_of_type_Int = (int)(jdField_e_of_type_Int - 108.0F * jdField_d_of_type_Float);
    jdField_g_of_type_Int = jdField_f_of_type_Int - k - l;
    jdField_h_of_type_Int = jdField_g_of_type_Int - t * 2;
    u = localContext.getResources().getDimensionPixelSize(2131427472);
    v = localContext.getResources().getDimensionPixelSize(2131427473);
    w = localContext.getResources().getDimensionPixelSize(2131427471);
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.y != paramInt)
    {
      this.y = paramInt;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(3, this.y);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams()).addRule(3, this.y);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.y);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.y);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.y);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)))
      {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.y);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setTopId mTopId = " + this.y);
        }
      }
    }
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setTextSize(2, 12.0F);
    paramTextView.setIncludeFontPadding(false);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    paramTextView.setSingleLine();
    paramTextView.setText(paramCharSequence);
    paramTextView.setTag(paramCharSequence);
    paramTextView.setTextColor(paramColorStateList);
  }
  
  private void a(CharSequence paramCharSequence, ColorStateList paramColorStateList, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    a(paramBoolean2);
    if (this.jdField_f_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_f_of_type_AndroidWidgetTextView = new TextView(getContext());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    }
    Object localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    int i1;
    if (paramBoolean1)
    {
      i1 = jdField_g_of_type_Int - (int)(100.0F * jdField_d_of_type_Float);
      ((TextView)localObject).setMaxWidth(i1);
      a(this.jdField_f_of_type_AndroidWidgetTextView, paramCharSequence, paramColorStateList);
      if (!paramBoolean1) {
        break label400;
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_g_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramCharSequence = new LinearLayout.LayoutParams(-2, -2);
        paramCharSequence.leftMargin = AIOUtils.a(9.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_g_of_type_AndroidWidgetTextView, paramCharSequence);
      }
      i1 = 0;
      if (paramInt2 != 0) {
        break label292;
      }
      i1 = 2130838067;
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(" ");
      if (paramInt1 > 0) {
        paramCharSequence.append(paramInt1).append(getResources().getString(2131560281)).append("  ");
      }
      if (paramInt3 > 100) {
        break label306;
      }
      new StringBuilder().append(100).append(getResources().getString(2131560282)).toString();
      a(this.jdField_g_of_type_AndroidWidgetTextView, paramCharSequence.toString(), paramColorStateList);
    }
    label292:
    label306:
    while (this.jdField_g_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        return;
        i1 = jdField_g_of_type_Int;
        break;
        if (paramInt2 == 1)
        {
          i1 = 2130838066;
          continue;
          if (paramInt3 <= 1000) {
            new StringBuilder().append((paramInt3 / 100 + 1) * 100).append(getResources().getString(2131560282)).toString();
          } else {
            new StringBuilder().append(getResources().getString(2131560283)).append(1000).append(getResources().getString(2131560282)).toString();
          }
        }
      }
    }
    label400:
    a(this.jdField_g_of_type_AndroidWidgetTextView, null, paramColorStateList);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView == null) && (paramBoolean))
    {
      this.jdField_e_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
      this.jdField_e_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
      this.jdField_e_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131560279));
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130840353);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = AIOUtils.a(3.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidWidgetTextView, 0, localLayoutParams);
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if (!paramBoolean) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      addView(paramView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewView.setId(2131230779);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i1 = paramView.getContext().getResources().getDimensionPixelSize(2131427476);
      localLayoutParams.leftMargin = i1;
      localLayoutParams.rightMargin = i1;
      if (this.x == 1)
      {
        localLayoutParams.addRule(0, 2131230773);
        localLayoutParams.addRule(1, 0);
      }
    }
    else
    {
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label166;
      }
      paramView.addRule(3, 2131230775);
      paramView.topMargin = 0;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_nick_name");
      }
    }
    label166:
    label212:
    do
    {
      do
      {
        return;
        localLayoutParams.addRule(1, 2131230773);
        localLayoutParams.addRule(0, 0);
        break;
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
          break label212;
        }
        paramView.addRule(3, 2131230776);
        paramView.topMargin = 0;
      } while (!QLog.isColorLevel());
      QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_opentroop_nick_area");
      return;
      paramView.addRule(3, this.y);
      paramView.topMargin = m;
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setBubbleView mTopId  = " + this.y);
  }
  
  void a(boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_c_of_type_AndroidWidgetTextView.setId(2131230774);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840353);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131427478);
        localLayoutParams.bottomMargin = this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131427479);
        localLayoutParams.leftMargin = this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131427480);
        localLayoutParams.addRule(3, this.y);
        localLayoutParams.addRule(1, 2131230773);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131230775);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberLevel mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_d_of_type_AndroidWidgetTextView.setId(2131230775);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_d_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_d_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(jdField_g_of_type_Int);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131427478);
        localLayoutParams.bottomMargin = this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131427479);
        localLayoutParams.addRule(3, this.y);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131230775);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_d_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        localLayoutParams.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131230774);
        if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)
        {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131230775);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
            }
          }
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        this.jdField_d_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          localLayoutParams.leftMargin = this.jdField_d_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131427480);
          localLayoutParams.addRule(1, 2131230773);
          break;
        } while ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 8));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      } while (this.jdField_a_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.y);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setNick mTopId = " + this.y);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence, ColorStateList paramColorStateList, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean3)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131230776);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(2131427478);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131427479);
        localLayoutParams.leftMargin = AIOUtils.a(12.0F, getContext().getResources());
        localLayoutParams.addRule(3, this.y);
        localLayoutParams.addRule(1, 2131230773);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131230776);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNickArea mTopId = R.id.chat_item_opentroop_nick_area");
          }
        }
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).leftMargin = AIOUtils.a(2.0F, getContext().getResources());
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131230776);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNickArea mTopId = R.id.chat_item_opentroop_nick_area");
            }
          }
        }
        a(paramCharSequence, paramColorStateList, paramBoolean2, paramInt1, paramInt2, paramInt3, paramBoolean3);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).leftMargin = AIOUtils.a(12.0F, getContext().getResources());
          break;
        } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } while (this.jdField_a_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.y);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setNickArea mTopId = " + this.y);
  }
  
  public boolean a()
  {
    return this.x == 1;
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131230778);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131562864));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.a(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131230779);
      if (this.x != 1) {
        break label155;
      }
      localLayoutParams.addRule(0, 2131230779);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(paramObject);
      return;
      label155:
      localLayoutParams.addRule(1, 2131230779);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130837678, paramOnClickListener);
    }
    while (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
  }
  
  public void setGrayTipsText(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    int i2 = 0;
    int i1;
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131230772);
        i1 = AIOUtils.a(12.0F, getContext().getResources());
        i2 = AIOUtils.a(5.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838669);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i1, i2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
        paramColorStateList = new RelativeLayout.LayoutParams(AIOUtils.a(235.0F, getContext().getResources()), -2);
        paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131427470);
        i1 = AIOUtils.a(45.0F, getContext().getResources());
        paramColorStateList.leftMargin = i1;
        paramColorStateList.rightMargin = i1;
        paramColorStateList.addRule(14);
        paramColorStateList.addRule(3, 2131230771);
        addView(this.jdField_b_of_type_AndroidWidgetTextView, paramColorStateList);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!paramCharSequence.equals(this.jdField_b_of_type_AndroidWidgetTextView.getTag()))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
      }
      a(2131230772);
    }
    do
    {
      while ((this.y == 2131230771) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        paramCharSequence.topMargin = getContext().getResources().getDimensionPixelSize(2131427469);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
        return;
        if (this.jdField_b_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          i1 = i2;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            i1 = i2;
            if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
              i1 = 2131230771;
            }
          }
          a(i1);
        }
      }
    } while ((this.y != 2131230772) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramCharSequence.topMargin = AIOUtils.a(10.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      setPendantImageVisible(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label56:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setHeaderIcon(Drawable paramDrawable)
  {
    int i1 = getContext().getResources().getDimensionPixelSize(2131427477);
    int i2 = AIOUtils.a(5.0F, getContext().getResources());
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131230773);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      int i3 = AIOUtils.a(40.0F, getContext().getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i3, i3);
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131230772);
      if (this.x == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, this.y);
        addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        localLayoutParams.leftMargin = i2;
        localLayoutParams.rightMargin = 0;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.topMargin = i1;
    localLayoutParams.addRule(3, 2131230772);
    if (this.x == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = i2;
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.y);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.leftMargin = i2;
      localLayoutParams.rightMargin = 0;
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    int i2;
    if (this.x != paramInt)
    {
      this.x = paramInt;
      if (paramInt != 1) {
        break label456;
      }
      i2 = 1;
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label565;
      }
    }
    label144:
    label546:
    label565:
    for (paramInt = this.jdField_a_of_type_AndroidWidgetTextView.getId();; paramInt = 0)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
        paramInt = this.jdField_b_of_type_AndroidWidgetTextView.getId();
      }
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        int i1;
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          i1 = AIOUtils.a(5.0F, getContext().getResources());
          if (i2 != 0)
          {
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.rightMargin = i1;
            localLayoutParams.leftMargin = 0;
            localLayoutParams.addRule(3, paramInt);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
            if (this.x != 1) {
              break label491;
            }
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            label203:
            localLayoutParams.addRule(3, this.y);
          }
          i1 = paramInt;
          if (this.jdField_d_of_type_AndroidWidgetTextView != null)
          {
            i1 = paramInt;
            if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0)
            {
              ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, paramInt);
              i1 = this.jdField_d_of_type_AndroidWidgetTextView.getId();
            }
          }
          paramInt = i1;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
          {
            paramInt = i1;
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
            {
              ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, i1);
              paramInt = this.jdField_a_of_type_AndroidWidgetLinearLayout.getId();
            }
          }
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
            if (i2 == 0) {
              break label509;
            }
            localLayoutParams.addRule(0, 2131230773);
            localLayoutParams.addRule(1, 0);
            label340:
            localLayoutParams.addRule(3, paramInt);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setHearIconPosition mTopId = " + paramInt);
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
            if (i2 == 0) {
              break label528;
            }
            localLayoutParams.addRule(0, 2131230779);
            localLayoutParams.addRule(1, 0);
          }
        }
        for (;;)
        {
          if (this.jdField_b_of_type_AndroidWidgetImageView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            if (i2 == 0) {
              break label546;
            }
            localLayoutParams.addRule(0, 2131230779);
            localLayoutParams.addRule(1, 0);
          }
          return;
          label456:
          i2 = 0;
          break;
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          localLayoutParams.leftMargin = i1;
          localLayoutParams.rightMargin = 0;
          break label144;
          label491:
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          break label203;
          label509:
          localLayoutParams.addRule(1, 2131230773);
          localLayoutParams.addRule(0, 0);
          break label340;
          localLayoutParams.addRule(1, 2131230779);
          localLayoutParams.addRule(0, 0);
        }
        localLayoutParams.addRule(1, 2131230779);
        localLayoutParams.addRule(0, 0);
        return;
      }
    }
  }
  
  public void setPendantImage(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131230781);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, getContext().getResources()), AIOUtils.a(59.0F, getContext().getResources()));
      localLayoutParams.addRule(3, 2131230772);
      if (this.x == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = 0;
      }
      for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = 0)
      {
        localLayoutParams.addRule(3, this.y);
        addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        localLayoutParams.rightMargin = 0;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.addRule(3, 2131230772);
    if (this.x == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = 0;
    }
    for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = 0)
    {
      localLayoutParams.addRule(3, this.y);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.rightMargin = 0;
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131230777);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130837854));
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.bottomMargin = AIOUtils.a(18.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131230779);
        if (this.x == 1)
        {
          localLayoutParams.rightMargin = AIOUtils.a(4.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131230779);
          localLayoutParams.addRule(1, 0);
          addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      for (;;)
      {
        int i1;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131230779);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_h_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_h_of_type_AndroidWidgetTextView.setId(2131230780);
        this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(2130838173);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(3, 2131230779);
        localLayoutParams.addRule(5, 2131230779);
        localLayoutParams.addRule(7, 0);
        addView(this.jdField_h_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramCharSequence != this.jdField_h_of_type_AndroidWidgetTextView.getTag()) {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
      paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.x == 1)
      {
        paramCharSequence.leftMargin = l;
        this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      }
    }
    while (this.jdField_h_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramCharSequence.leftMargin = k;
      }
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setTimeStamp(boolean paramBoolean, long paramLong, ColorStateList paramColorStateList)
  {
    int i1 = 2131230772;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131230771);
        i1 = AIOUtils.a(14.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 11.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, 0, i1, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        paramColorStateList = new RelativeLayout.LayoutParams(-2, -2);
        paramColorStateList.topMargin = getContext().getResources().getDimensionPixelOffset(2131427469);
        paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131427470);
        paramColorStateList.addRule(14);
        addView(this.jdField_a_of_type_AndroidWidgetTextView, paramColorStateList);
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramLong)
      {
        paramColorStateList = TimeFormatterUtils.a(getContext(), 3, 1000L * paramLong);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColorStateList);
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        i1 = 2131230772;
        a(i1);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        return;
        i1 = 2131230771;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (;;)
    {
      a(i1);
      return;
      i1 = 0;
    }
  }
  
  public void setUnread(boolean paramBoolean, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramOnClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnClickListener.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      paramOnClickListener.leftMargin = AIOUtils.a(-3.0F, getContext().getResources());
      paramOnClickListener.addRule(6, 2131230779);
      paramOnClickListener.addRule(1, 2131230779);
      addView(this.jdField_c_of_type_AndroidWidgetImageView, paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840208);
    }
    while (this.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */