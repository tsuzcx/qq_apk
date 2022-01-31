package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.h;

public class GetOtherBarcodeActivity
  extends BaseActivity
{
  private final byte URL_ID_DANGER_WEB_URL = 2;
  private final byte URL_ID_NOT_WEB_URL = 0;
  private final byte URL_ID_SAFE_IS_QQ_WEB_URL = 4;
  private final byte URL_ID_SAFE_NOT_QQ_WEB_URL = 3;
  private final byte URL_ID_UNKNOWN_WEB_URL = 1;
  private Handler mHandler = new kz(this);
  private Button mResultBtn;
  private ImageView mResultImg;
  private TextView mResultTipTxt;
  private TextView mResultTxt;
  private EditText mResultUrl;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968673);
    Object localObject = getIntent().getBundleExtra("com.tencent.input_param");
    paramBundle = ((Bundle)localObject).getString("barcode_result");
    int i = ((Bundle)localObject).getInt("url_id");
    localObject = ((Bundle)localObject).getString("url_txt");
    h.a("barcode: " + paramBundle + ", id=" + i + ", tip=" + (String)localObject);
    setTitle(2131230850);
    this.mResultBtn = ((Button)findViewById(2131558755));
    this.mResultUrl = ((EditText)findViewById(2131558944));
    if (this.mResultUrl != null) {
      this.mResultUrl.clearFocus();
    }
    this.mResultImg = ((ImageView)findViewById(2131558752));
    this.mResultTxt = ((TextView)findViewById(2131558942));
    this.mResultTipTxt = ((TextView)findViewById(2131558943));
    this.mResultBtn.setOnClickListener(new la(this));
    this.mResultUrl.setText(paramBundle);
    this.mResultTxt.setText((CharSequence)localObject);
    switch (i)
    {
    default: 
      return;
    case 0: 
      this.mResultTipTxt.setVisibility(8);
      this.mResultImg.setVisibility(8);
      this.mResultTxt.setVisibility(8);
      this.mResultBtn.setVisibility(4);
      return;
    case 1: 
      this.mResultTipTxt.setVisibility(0);
      this.mResultImg.setImageResource(2130837650);
      this.mResultBtn.setVisibility(0);
      this.mResultBtn.setText(2131230852);
      return;
    case 2: 
      this.mResultTipTxt.setVisibility(8);
      this.mResultImg.setImageResource(2130837652);
      this.mResultBtn.setVisibility(4);
      return;
    }
    this.mResultTipTxt.setVisibility(8);
    this.mResultBtn.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.GetOtherBarcodeActivity
 * JD-Core Version:    0.7.0.1
 */