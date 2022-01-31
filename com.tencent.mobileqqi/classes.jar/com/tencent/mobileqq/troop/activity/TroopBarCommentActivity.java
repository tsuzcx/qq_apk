package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import gwe;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarCommentActivity
  extends BaseActivity
  implements View.OnClickListener, EmoticonCallback, HttpWebCgiAsyncTask.Callback, InputMethodRelativeLayout.onSizeChangedListenner
{
  int jdField_a_of_type_Int = 0;
  protected long a;
  protected Handler a;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  protected FrameLayout a;
  public ImageView a;
  public SystemAndEmojiEmoticonPanel a;
  InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  String jdField_a_of_type_JavaLangString;
  protected boolean a;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f = "0";
  
  public TroopBarCommentActivity()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.optInt("retcode", -1);
      if (paramInt != -1)
      {
        paramBundle = paramJSONObject.optString("msg");
        paramJSONObject = paramBundle;
        if (android.text.TextUtils.isEmpty(paramBundle)) {
          paramJSONObject = getString(2131560704, new Object[] { Integer.valueOf(paramInt) });
        }
        QQToast.a(this, 1, paramJSONObject, 0).b(d());
        TroopBarUtils.a("two_comment", "fail", this.jdField_a_of_type_JavaLangString, "4", "", "");
        return;
      }
      TroopBarUtils.a("two_comment", "suc", this.jdField_a_of_type_JavaLangString, this.f, "", "");
      this.jdField_a_of_type_Boolean = true;
      QQToast.a(this, 2, 2131560742, 1).b(d());
      paramBundle = new Intent();
      paramBundle.putExtra("result", paramJSONObject.toString());
      setResult(-1, paramBundle);
      finish();
      return;
    }
    QQToast.a(this, 1, 2131560703, 0).b(d());
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839367);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131558489));
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 8) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    finish();
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b()
  {
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    int i = str.length();
    if (i == 0)
    {
      QQToast.a(this, 2131560733, 0).b(d());
      TroopBarUtils.a("two_comment", "fail", this.jdField_a_of_type_JavaLangString, "0", "", "");
      return;
    }
    if (i < this.jdField_c_of_type_Int)
    {
      QQToast.a(this, getString(2131560734, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 0).b(d());
      TroopBarUtils.a("two_comment", "fail", this.jdField_a_of_type_JavaLangString, "0", "", "");
      return;
    }
    if (i > this.jdField_b_of_type_Int)
    {
      QQToast.a(this, getString(2131560735, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(d());
      TroopBarUtils.a("two_comment", "fail", this.jdField_a_of_type_JavaLangString, "1", "", "");
      return;
    }
    if (!HttpUtil.a(this))
    {
      QQToast.a(this, 2131562450, 0).b(d());
      TroopBarUtils.a("two_comment", "fail", this.jdField_a_of_type_JavaLangString, "7", "", "");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("pid", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("cid", this.jdField_c_of_type_JavaLangString);
    localBundle.putString("target_rid", this.d);
    localBundle.putString("comment", TroopBarPublishActivity.a(str, null));
    TroopBarUtils.b(this, localBundle, "http://xiaoqu.qq.com/cgi-bin/bar/post/recomment", 6, null, this);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  protected boolean c()
  {
    String str = (String)TroopBarUtils.c.get(this.e);
    TroopBarUtils.c.clear();
    if (!android.text.TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      return true;
    }
    return false;
  }
  
  public void d() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903400);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131231116));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231207));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231206));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232064));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232469));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131232470).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishActivity.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    paramBundle = getIntent().getExtras().getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "Comment option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramBundle);
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString("bid");
        this.jdField_b_of_type_JavaLangString = localJSONObject.optString("pid");
        this.jdField_c_of_type_JavaLangString = localJSONObject.optString("cid");
        this.d = localJSONObject.optString("rid");
        if ("detail".equals(localJSONObject.optString("from")))
        {
          paramBundle = "0";
          this.f = paramBundle;
          this.jdField_b_of_type_Int = localJSONObject.optInt("maxContentLength");
          this.jdField_c_of_type_Int = localJSONObject.optInt("minContentLength");
          paramBundle = localJSONObject.optString("contentPlaceholder");
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramBundle);
          this.e = ("bid:" + this.jdField_a_of_type_JavaLangString + "&pid:" + this.jdField_b_of_type_JavaLangString + "&cid:" + this.jdField_c_of_type_JavaLangString + "&rid:" + this.d);
          c();
          TroopBarUtils.a("two_comment", "exp", this.jdField_a_of_type_JavaLangString, this.f, "", "");
          return true;
        }
      }
      catch (JSONException paramBundle)
      {
        finish();
        return false;
      }
      paramBundle = "1";
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    if (!this.jdField_a_of_type_Boolean) {
      e();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!android.text.TextUtils.isEmpty(str)) {
      TroopBarUtils.c.put(this.e, str);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968590);
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) {}
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("two_comment", "un", this.jdField_a_of_type_JavaLangString, str, "", "");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131232470: 
    case 2131231207: 
      do
      {
        return;
        finish();
        return;
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839367);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131558489));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gwe(this), 200L);
      return;
    }
    b();
  }
  
  public void u_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentActivity
 * JD-Core Version:    0.7.0.1
 */