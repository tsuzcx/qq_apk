package com.tencent.mobileqq.campuscircle;

import acfp;
import aeal;
import afmf;
import afmi;
import afqr;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import aofy;
import aprv;
import aurd;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(12)
public class CampusCircleReplyActivity
  extends IphoneTitleBarActivity
  implements afmf, TextWatcher, View.OnClickListener, InputMethodRelativeLayout.a
{
  public static LruCache<String, String> r = new LruCache(3);
  protected long Ap;
  private CheckBox I;
  private TextView QW;
  protected ImageButton aw;
  protected SystemEmoticonPanel b;
  protected InputMethodRelativeLayout b;
  protected boolean bSH = true;
  protected boolean bSI;
  protected boolean bSJ;
  protected String bwy;
  protected FrameLayout bx;
  protected int cLN;
  protected int cLO;
  protected int cLP;
  protected int cLQ;
  protected Button cd;
  protected EditText mEditText;
  protected String mFeedId;
  protected String mFrom;
  protected Handler mHandler = new Handler();
  
  private void Aj(int paramInt)
  {
    this.bx.setBackgroundResource(2130838096);
    switch (paramInt)
    {
    default: 
      this.bx.setBackgroundColor(0);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.aw.setImageResource(2130849924);
      return;
    }
    aurd.hide(this.mEditText);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.aw.setImageResource(2130848766);
  }
  
  public void a(afmi paramafmi)
  {
    if (((paramafmi instanceof afqr)) && (this.mEditText != null)) {
      ((afqr)paramafmi).a(this.app, this, this.mEditText, null);
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  protected void aN(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    this.cLN = paramJSONObject.optInt("minlen", 3);
    this.cLO = paramJSONObject.optInt("maxlen", 700);
    this.bwy = paramJSONObject.optString("hint", "");
    if (paramJSONObject.optInt("emoji", 1) == 1)
    {
      bool1 = true;
      this.bSH = bool1;
      if (paramJSONObject.optInt("anonymous", 0) != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bSI = bool1;
      this.mFrom = paramJSONObject.optString("from", "default");
      this.mFeedId = paramJSONObject.optString("feedId", "");
      return;
      bool1 = false;
      break;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int k = 0;
    this.cLP = this.mEditText.getSelectionStart();
    this.cLQ = this.mEditText.getSelectionEnd();
    String str = aprv.f(this.mEditText);
    if (str == null) {}
    for (int i = 0;; i = str.length())
    {
      int j = k;
      if (this.cLO > 0)
      {
        j = k;
        if (i > this.cLO)
        {
          j = i - this.cLO;
          paramEditable.delete(this.cLP - j, this.cLQ);
          this.cLP -= j;
          this.cLQ -= j;
        }
      }
      this.mEditText.setSelection(j + this.cLP);
      return;
    }
  }
  
  public void b(afmi paramafmi) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void bsq()
  {
    String str = aprv.f(this.mEditText).replace("\n", " ");
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((!this.bSI) || (this.I == null) || (!this.I.isChecked())) {
          continue;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("CampusCircleReplyActivity", 2, localJSONException, new Object[] { "onSend, exception" });
        continue;
        if (i == 0) {
          continue;
        }
        int i = 1;
        continue;
      }
      localJSONObject.put("anonymous", i);
      localJSONObject.put("text", str);
      localIntent.putExtra("result", localJSONObject.toString());
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "onSend, text=" + str);
      }
      setResult(-1, localIntent);
      this.bSJ = true;
      finish();
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void delete()
  {
    if (this.mEditText != null) {
      aofy.g(this.mEditText);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "bundle is null");
      }
      QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(990) }), 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "publish option: " + paramBundle);
      }
      paramBundle = new JSONObject(paramBundle);
      aN(paramBundle);
      initUI();
      return true;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(999) }), 0).show(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.e("CampusCircleReplyActivity", 2, paramBundle, new Object[] { "onCreate parse json failed" });
      }
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((!this.bSJ) && (!TextUtils.isEmpty(this.mFeedId)))
    {
      String str = this.mEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(str)) {
        r.put(this.mFeedId, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "save draft, text=" + str);
      }
    }
    if (this.mEditText != null) {
      this.mEditText.removeTextChangedListener(this);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.mEditText != null) {
      aurd.hide(this.mEditText);
    }
    overridePendingTransition(0, 2130771990);
  }
  
  public void gq() {}
  
  protected void initUI()
  {
    setContentView(2131561257);
    Object localObject = findViewById(2131377361);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131377556));
    this.aw = ((ImageButton)findViewById(2131368967));
    this.mEditText = ((EditText)findViewById(2131366529));
    this.cd = ((Button)findViewById(2131377990));
    this.bx = ((FrameLayout)findViewById(2131370190));
    this.I = ((CheckBox)findViewById(2131362732));
    this.QW = ((TextView)findViewById(2131362733));
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.bx, this.mEditText, this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    findViewById(2131380165).setOnClickListener(this);
    this.aw.setOnClickListener(this);
    this.cd.setSelected(true);
    this.cd.setPressed(false);
    this.cd.setOnClickListener(this);
    this.mEditText.addTextChangedListener(this);
    this.mEditText.setHint(this.bwy);
    localObject = this.aw;
    int i;
    if (this.bSH)
    {
      i = 0;
      ((ImageButton)localObject).setVisibility(i);
      if (!this.bSI) {
        break label480;
      }
      this.I.setVisibility(0);
      this.I.setChecked(false);
      this.I.setOnCheckedChangeListener(new aeal(this));
      this.QW.setVisibility(0);
      if (!this.mFrom.equalsIgnoreCase("comment")) {
        break label447;
      }
      localObject = acfp.m(2131703397);
      label295:
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleReplyActivity", 2, "anonymous str=" + (String)localObject);
      }
      this.QW.setText((CharSequence)localObject);
      this.QW.setTextColor(getResources().getColorStateList(2131166617));
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mFeedId))
      {
        localObject = (String)r.get(this.mFeedId);
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleReplyActivity", 2, "getDraft, mFeedId=" + this.mFeedId + ", draft=" + (String)localObject);
        }
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          this.mEditText.setText((CharSequence)localObject);
        }
      }
      return;
      i = 8;
      break;
      label447:
      if (this.mFrom.equalsIgnoreCase("publish"))
      {
        localObject = acfp.m(2131703388);
        break label295;
      }
      localObject = acfp.m(2131703399);
      break label295;
      label480:
      this.I.setVisibility(8);
      this.QW.setVisibility(8);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      Aj(0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("CampusCircleReplyActivity", 2, "transparent_space click!");
      }
      finish();
      continue;
      if (System.currentTimeMillis() - this.Ap >= 500L)
      {
        this.Ap = System.currentTimeMillis();
        if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          this.jdField_b_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
          aurd.aO(this.mEditText);
        }
        else
        {
          aurd.hide(this.mEditText);
          this.mHandler.postDelayed(new CampusCircleReplyActivity.2(this), 200L);
          continue;
          bsq();
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity
 * JD-Core Version:    0.7.0.1
 */