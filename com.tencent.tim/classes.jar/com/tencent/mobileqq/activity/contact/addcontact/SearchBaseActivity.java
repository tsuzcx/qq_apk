package com.tencent.mobileqq.activity.contact.addcontact;

import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.regex.Pattern;
import yog;
import yoh;
import yoi;
import yoj;
import yok;

public class SearchBaseActivity
  extends FragmentActivity
{
  public static final Pattern Q = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  public static final Pattern R = Pattern.compile("[^0-9]");
  public static final Pattern S = Pattern.compile("^1[0-9]{2}\\d{8}$");
  public SearchBaseFragment a;
  public EditText aN;
  protected String aZi;
  public ImageButton ap;
  public final int cam = 64;
  private int can;
  public Button eg;
  protected int fromType;
  public int mFrom;
  private Handler uiHandler = new yok(this);
  ImageView uo;
  
  protected void Ie()
  {
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("from_key"))
    {
      this.mFrom = localIntent.getIntExtra("from_key", 0);
      this.aZi = localIntent.getStringExtra("last_key_words");
      this.can = localIntent.getIntExtra("jump_src_key", 1);
    }
    if (localIntent.hasExtra("fromType")) {
      this.fromType = localIntent.getIntExtra("fromType", -1);
    }
  }
  
  protected SearchBaseFragment a()
  {
    return new SearchBaseFragment();
  }
  
  public boolean a(boolean paramBoolean, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager == null) || (paramView == null)) {
      return false;
    }
    if (localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0))
    {
      if (paramBoolean) {
        paramView.clearFocus();
      }
      return true;
    }
    return false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561650);
    paramBundle = super.findViewById(2131377546);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    super.getWindow().setBackgroundDrawable(null);
    Ie();
    initViews();
    this.a = a();
    if ((this.a instanceof ClassificationSearchFragment)) {
      ((ClassificationSearchFragment)this.a).nA(this.fromType);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("from_key", this.mFrom);
    paramBundle.putString("last_key_words", this.aZi);
    paramBundle.putString("start_search_key", getIntent().getStringExtra("start_search_key"));
    paramBundle.putBoolean("auto_add_and_prohibit_auto_search", getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false));
    this.a.setArguments(paramBundle);
    this.a.t(this.uiHandler);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131365322, this.a);
    paramBundle.commit();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ViewFactory.a().destory();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    setContentBackgroundResource(2130838901);
  }
  
  protected void initViews()
  {
    this.eg = ((Button)findViewById(2131363801));
    this.eg.setTextColor(getResources().getColor(2131167312));
    this.eg.setOnClickListener(new yog(this));
    if (AppSetting.enableTalkBack) {
      this.eg.setContentDescription(this.eg.getText());
    }
    this.aN = ((EditText)findViewById(2131366542));
    this.aN.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.aN.setTextSize(0, getResources().getDimension(2131299558));
    this.aN.setImeOptions(3);
    this.aN.setSingleLine();
    this.aN.setOnEditorActionListener(new yoh(this));
    this.ap = ((ImageButton)findViewById(2131368696));
    this.ap.setOnClickListener(new yoi(this));
    this.uo = ((ImageView)findViewById(2131369671));
    if (AppSetting.enableTalkBack) {
      this.uo.setContentDescription(acfp.m(2131714090));
    }
    this.uo.setOnClickListener(new yoj(this));
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public int xj()
  {
    return this.can;
  }
  
  public static final class a
  {
    public static String cQ(int paramInt)
    {
      if (paramInt == 0) {
        return "1";
      }
      if (paramInt == 1) {
        return "2";
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */