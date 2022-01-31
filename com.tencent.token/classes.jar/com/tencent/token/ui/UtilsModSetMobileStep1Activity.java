package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.cw;
import com.tencent.token.global.h;

public class UtilsModSetMobileStep1Activity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean isOrangeToastShowing;
  private String mCountryCode = "+86";
  private int mCountryIndex = -1;
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new adv(this);
  private int mOpType;
  private int mPageId;
  private String mSmsPrefix;
  private EditText mStep1MobileText;
  private String mTitle;
  private View mcountry;
  
  private void init()
  {
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      finish();
      return;
    }
    if ((((Bundle)localObject).getInt("op_type", 0) == 0) || (((Bundle)localObject).getString("title") == null))
    {
      finish();
      return;
    }
    this.mPageId = ((Bundle)localObject).getInt("page_id");
    this.mOpType = ((Bundle)localObject).getInt("op_type", 0);
    this.mTitle = ((Bundle)localObject).getString("title");
    setTitle(this.mTitle);
    this.mStep1MobileText = ((EditText)findViewById(2131558964));
    if (this.mStep1MobileText != null) {
      this.mStep1MobileText.clearFocus();
    }
    this.mcountry = findViewById(2131558960);
    this.mCountry_name = ((TextView)findViewById(2131558961));
    this.mCountry_number = ((TextView)findViewById(2131558963));
    this.mcountry.setOnClickListener(new adx(this));
    if (this.mOpType == 3)
    {
      if (((this.mPageId == 15) || (this.mPageId == 16)) && (!this.isOrangeToastShowing))
      {
        this.isOrangeToastShowing = true;
        localObject = getResources().getString(2131231003);
        RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131558958);
        localRelativeLayout.setVisibility(0);
        TextView localTextView = (TextView)findViewById(2131558987);
        ImageView localImageView = (ImageView)findViewById(2131558986);
        localTextView.setText((CharSequence)localObject);
        localImageView.setImageDrawable(getResources().getDrawable(2130838018));
        localTextView.postDelayed(new ady(this, localRelativeLayout), 3000L);
      }
      ((TextView)findViewById(2131558959)).setText(getResources().getString(2131231583));
      this.mStep1MobileText.setHint(getResources().getString(2131231583));
    }
    for (;;)
    {
      findViewById(2131558965).setOnClickListener(this);
      h.c("test mbinfo, positon=, optype=" + this.mOpType + ", area_code=" + this.mCountryCode + ",title=" + this.mTitle);
      return;
      this.mStep1MobileText.setHint(getResources().getString(2131231589));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("name");
    this.mCountryCode = ("+" + paramInt2);
    this.mCountry_name.setText(paramIntent);
    this.mCountry_number.setText(this.mCountryCode);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.mStep1MobileText == null);
    if (this.mStep1MobileText != null) {
      this.mStep1MobileText.clearFocus();
    }
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    paramView = this.mStep1MobileText.getText().toString();
    if ((paramView != null) && (paramView.length() != 0))
    {
      cw.a().a(0L, this.mOpType, paramView, this.mCountryCode, this.mHandler);
      showProDialog(this, 2131230843, 2131231571, null);
      return;
    }
    showToast(2131230957);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("finish", false))
    {
      finish();
      return;
    }
    setContentView(2130968676);
    init();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cw.a().a(getClass().getName());
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsModSetMobileStep1Activity
 * JD-Core Version:    0.7.0.1
 */