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
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.utils.s;

public class UtilsModSetMobileStep1Activity
  extends BaseActivity
  implements View.OnClickListener
{
  private String mCountryCode = "+86";
  private int mCountryIndex = -1;
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new afg(this);
  private int mOpType;
  private int mPageId;
  private String mSmsPrefix;
  private EditText mStep1MobileText;
  private String mTitle;
  private View mcountry;
  
  private void init()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    if ((localBundle.getInt("op_type", 0) == 0) || (localBundle.getString("title") == null))
    {
      finish();
      return;
    }
    this.mPageId = localBundle.getInt("page_id");
    this.mOpType = localBundle.getInt("op_type", 0);
    this.mTitle = localBundle.getString("title");
    setTitle(this.mTitle);
    this.mStep1MobileText = ((EditText)findViewById(2131296655));
    if (this.mStep1MobileText != null) {
      this.mStep1MobileText.clearFocus();
    }
    this.mcountry = findViewById(2131296651);
    this.mCountry_name = ((TextView)findViewById(2131296652));
    this.mCountry_number = ((TextView)findViewById(2131296654));
    this.mcountry.setOnClickListener(new afi(this));
    if (this.mOpType == 3)
    {
      ((TextView)findViewById(2131296650)).setText(getResources().getString(2131362209));
      this.mStep1MobileText.setHint(getResources().getString(2131362209));
    }
    for (;;)
    {
      findViewById(2131296656).setOnClickListener(this);
      return;
      ((TextView)findViewById(2131296650)).setText(getResources().getString(2131362208));
      this.mStep1MobileText.setHint(getResources().getString(2131362208));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 == 1111) {}
    for (paramIntent = "+1";; paramIntent = "+" + paramInt2)
    {
      this.mCountryCode = paramIntent;
      this.mCountryIndex = paramInt2;
      s.a(paramInt2, this.mCountry_name, this.mCountry_number);
      return;
    }
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
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    paramView = this.mStep1MobileText.getText().toString();
    if ((paramView != null) && (paramView.length() != 0))
    {
      af.a().b(0L, this.mOpType, paramView, this.mCountryCode, this.mHandler);
      showProDialog(this, 2131361808, 2131362215, null);
      return;
    }
    showToast(2131361947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903105);
    init();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    af.a().a(getClass().getName());
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