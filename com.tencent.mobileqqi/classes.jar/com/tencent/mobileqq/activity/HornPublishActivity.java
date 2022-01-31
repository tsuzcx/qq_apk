package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.maproam.Utils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.XEditText;
import cqk;
import cql;
import cqm;
import cqn;
import cqp;
import cqq;
import cqr;

public class HornPublishActivity
  extends BaseHornListActivity
  implements View.OnClickListener, View.OnTouchListener
{
  protected static int q = 1;
  protected static int r = 2;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new cql(this);
  public Button a;
  protected ImageView a;
  protected RelativeLayout a;
  public BaseHornListActivity a;
  NearHornObserver jdField_a_of_type_ComTencentMobileqqAppNearHornObserver = new cqk(this);
  protected SystemEmoticonPanel a;
  public XEditText a;
  protected ImageView b;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  private String e;
  protected TextView f;
  protected int s = 24;
  protected int t;
  
  public HornPublishActivity()
  {
    this.jdField_e_of_type_JavaLangString = "http://imgcache.qq.com/club/horn/rel/help.html?_bid=179&pvsrc=horn&_wv=5123";
  }
  
  private SystemEmoticonPanel a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemEmoticonPanel(this.jdField_a_of_type_AndroidContentContext, new cqq(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.a.setOnClickListener(new cqr(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 150.0F));
    localLayoutParams.addRule(12);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundResource(2130837627);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel;
  }
  
  private void e()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_e_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.g;
    int i = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.d;
    int j = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_e_of_type_Int;
    i = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_f_of_type_Int + (i + j);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.c.booleanValue())
    {
      str2 = "-";
      str1 = "-";
      if ((!VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) && (i <= 0)) {
        break label166;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.f.setVisibility(8);
    }
    for (;;)
    {
      this.c.setText(str2);
      str1 = "喇叭置顶展示，有效期为" + str1;
      this.d.setText(str1);
      this.s = this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.h;
      f();
      return;
      str2 = Integer.toString(i);
      break;
      label166:
      this.f.setVisibility(0);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void f()
  {
    int i = StringUtil.e(this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString()).length();
    String str = Integer.toString(this.s - i);
    if (i > this.s)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), 0, str.length(), 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  private void g()
  {
    Utils.a(this.jdField_a_of_type_AndroidContentContext, 2131562519, this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_f_of_type_JavaLangString, new cqm(this), null);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == r)
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditText, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840157);
      this.jdField_a_of_type_ComTencentWidgetXEditText.requestFocus();
      this.t = r;
    }
    while (paramInt != q) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837653);
    this.t = q;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getWindowToken(), 0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903676);
    super.setTitle(2131562224);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity = this;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233366));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText = ((XEditText)findViewById(2131233373));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231169));
    this.jdField_a_of_type_ComTencentWidgetXEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentWidgetXEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_ComTencentWidgetXEditText.setOnTouchListener(this);
    this.t = r;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233377));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233374));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131233369));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233368));
    this.d = ((TextView)findViewById(2131233376));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233370));
    this.f = ((TextView)findViewById(2131233371));
    e();
    super.a(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    super.b();
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("确认发布该喇叭");
    this.k.setContentDescription(this.k.getText().toString());
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("表情面板");
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription("喇叭数量" + this.c.getText().toString() + "个");
    this.c.setContentDescription("");
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("喇叭规则说明");
    this.f.setContentDescription("申请开通");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.b(this.jdField_a_of_type_ComTencentMobileqqAppNearHornObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131233372: 
    case 2131233373: 
    case 2131233375: 
    case 2131233376: 
    default: 
    case 2131233377: 
    case 2131233374: 
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.d + this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.jdField_f_of_type_Int == 0)
        {
          if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(2131562529);
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_hornPublish", 0, 0, "isSvip", "1", "hasPriviledge", "0");
            return;
          }
          g();
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_hornPublish", 0, 0, "isSvip", "0", "priviledge", "0");
          return;
        }
        QQAppInterface localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
        if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {}
        int i;
        for (paramView = "1";; paramView = "0")
        {
          ReportController.b(localQQAppInterface, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_horn_publish", 0, 0, "isSvip", paramView, "priviledge", "1");
          paramView = BaseHornListActivity.a(this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString());
          i = paramView.length();
          if (i != 0) {
            break;
          }
          super.a(2131561874);
          return;
        }
        if (i > this.s)
        {
          super.a(2131563218);
          return;
        }
        if (NetworkUtil.e(this))
        {
          if (super.a(0, "").booleanValue())
          {
            Utils.a(this.jdField_a_of_type_AndroidContentContext, 2131562224, getResources().getString(2131561624), new cqn(this, paramView), null);
            return;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqp(this, paramView));
          return;
        }
        super.a(2131562652);
        return;
        if (this.t == r)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("输入法面板");
          b(q);
          return;
        }
      } while (this.t != q);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("表情面板");
      b(r);
      return;
    case 2131233371: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_applyHorn", 0, 0, "", "", "", "");
      g();
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
      b(r);
      return false;
      if (this.t == r)
      {
        ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditText.getWindowToken(), 0);
        return false;
      }
    } while (this.t != q);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840157);
    this.t = r;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HornPublishActivity
 * JD-Core Version:    0.7.0.1
 */