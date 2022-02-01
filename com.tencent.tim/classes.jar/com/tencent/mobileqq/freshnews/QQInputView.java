package com.tencent.mobileqq.freshnews;

import acfp;
import afmf;
import afmi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aofy;
import aurd;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tat;

public class QQInputView
  extends RelativeLayout
  implements afmf, TextWatcher, View.OnClickListener
{
  private long Ap;
  private Button X;
  private InputBar jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private a jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a;
  private FrameLayout bG;
  private boolean chR;
  private int dav;
  private int daw;
  private int dax;
  private XEditTextEx h;
  private BaseActivity mActivity;
  private Handler mHandler = new Handler();
  private int mLastTop = 2147483647;
  private int mMaxLength = 50;
  private int mMode = 0;
  private ImageView zX;
  
  public QQInputView(Context paramContext)
  {
    super(paramContext);
    initViews(paramContext);
  }
  
  public QQInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews(paramContext);
  }
  
  private void Eh(int paramInt)
  {
    this.mMode = paramInt;
    this.h.requestFocus();
    if (this.mMode == 0)
    {
      this.mHandler.post(new QQInputView.2(this));
      return;
    }
    aurd.hide(this.h);
    if (this.dav == this.daw)
    {
      this.mHandler.postDelayed(new QQInputView.3(this), 50L);
      return;
    }
    this.chR = true;
  }
  
  private void caR()
  {
    String str = this.h.getText().toString();
    str = Pattern.compile("\n").matcher(str).replaceAll("");
    str = Pattern.compile("^ +").matcher(str).replaceAll("");
    str = Pattern.compile(" +$").matcher(str).replaceAll("");
    if (!jU(str.length())) {}
    while (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a.eh(str);
  }
  
  private void initViews(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561365, this, true);
    this.mActivity = ((BaseActivity)paramContext);
    this.zX = ((ImageView)super.findViewById(2131366307));
    this.h = ((XEditTextEx)super.findViewById(2131369276));
    this.X = ((Button)super.findViewById(2131377990));
    this.bG = ((FrameLayout)super.findViewById(2131370190));
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)super.findViewById(2131369277));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(getContext(), this.bG, this.h, this);
    this.zX.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.h.addTextChangedListener(this);
    this.h.setOnClickListener(this);
    if (AppSetting.enableTalkBack)
    {
      this.h.setContentDescription(acfp.m(2131711811));
      this.X.setContentDescription(acfp.m(2131711807));
    }
    tat.b(getContext(), this.h);
  }
  
  private void resetUI()
  {
    this.mMode = 0;
    this.zX.setImageResource(2130848765);
    if (AppSetting.enableTalkBack) {
      this.zX.setContentDescription(acfp.m(2131711808));
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
  }
  
  public void a(afmi paramafmi)
  {
    if (this.h.getText() == null) {}
    for (Object localObject = null;; localObject = this.h.getText().toString())
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() < 49))) {
        paramafmi.a(this.mActivity.app, this.mActivity, this.h, null);
      }
      return;
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.h.getText().toString();
    paramEditable = Pattern.compile("\n").matcher(paramEditable).replaceAll("");
    paramEditable = Pattern.compile("^ +").matcher(paramEditable).replaceAll("");
    if (Pattern.compile(" +$").matcher(paramEditable).replaceAll("").length() > 0)
    {
      this.X.setEnabled(true);
      this.X.setSelected(true);
      return;
    }
    this.X.setEnabled(false);
    this.X.setSelected(false);
  }
  
  public void b(afmi paramafmi) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void delete()
  {
    aofy.g(this.h);
  }
  
  public void dpn()
  {
    Eh(this.mMode);
  }
  
  public String getHint()
  {
    return "";
  }
  
  public void gq() {}
  
  public boolean jU(int paramInt)
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.zX)
      {
        if (System.currentTimeMillis() - this.Ap >= 500L)
        {
          this.Ap = System.currentTimeMillis();
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 8) {}
          for (this.mMode = 1;; this.mMode = 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a != null) {
              this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a.dpo();
            }
            dpn();
            break;
          }
        }
      }
      else if (paramView == this.X) {
        caR();
      } else if (paramView == this.h) {
        Eh(0);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getBottom();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop();
    if (paramInt2 <= 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("input", 2, "onLayout.bottom=" + paramInt1 + ",top=" + paramInt2 + ",mFistBottom" + this.daw + " mLastBottom=" + this.dav + ",mFirstTop=" + this.dax + ",mLastTop=" + this.mLastTop);
    }
    if (this.daw == 0) {
      this.daw = paramInt1;
    }
    if (this.dax == 0) {
      this.dax = paramInt2;
    }
    if ((paramBoolean) && (paramInt4 == this.daw) && (this.dav < paramInt4)) {
      if (this.chR)
      {
        this.chR = false;
        post(new QQInputView.4(this));
      }
    }
    for (;;)
    {
      this.dav = paramInt1;
      this.mLastTop = paramInt2;
      return;
      String str;
      if ((paramInt2 == this.dax) && (paramInt2 > this.mLastTop))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview hide");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a != null)
        {
          str = this.h.getText().toString();
          str = Pattern.compile("\n").matcher(str).replaceAll("");
          str = Pattern.compile("^ +").matcher(str).replaceAll("");
          str = Pattern.compile(" +$").matcher(str).replaceAll("");
          paramInt3 = str.length();
          if ((paramInt3 == 0) || (paramInt3 < 0) || (paramInt3 > this.mMaxLength)) {
            str = "";
          }
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a.Kp(str);
        }
        this.h.setHint(getHint());
        resetUI();
      }
      else if ((this.mLastTop == this.dax) && (paramInt2 != this.mLastTop))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview show");
        }
        if (TextUtils.isEmpty(this.h.getText().toString()))
        {
          str = null;
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a != null) {
            str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a.getHint();
          }
          if (!TextUtils.isEmpty(str))
          {
            this.h.setHint(str);
            this.X.setEnabled(false);
            this.X.setSelected(false);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a.bpI();
        }
      }
      else if ((paramInt2 != this.mLastTop) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a.Pk(paramInt2);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void send() {}
  
  public void setCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$a = parama;
    this.mHandler.post(new QQInputView.1(this));
  }
  
  public void setContentMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
    this.h.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setHintTextColor(int paramInt)
  {
    if (this.h != null) {
      this.h.setHintTextColor(paramInt);
    }
  }
  
  public void setting() {}
  
  public static abstract interface a
  {
    public abstract void Kp(String paramString);
    
    public abstract void Pk(int paramInt);
    
    public abstract void bpI();
    
    public abstract void dpo();
    
    public abstract void eh(String paramString);
    
    public abstract String getHint();
    
    public abstract String wt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView
 * JD-Core Version:    0.7.0.1
 */