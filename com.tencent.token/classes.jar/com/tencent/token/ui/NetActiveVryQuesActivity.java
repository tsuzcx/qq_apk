package com.tencent.token.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.global.h;
import com.tencent.token.widget.InputMethodRelativeLayout;
import com.tencent.token.widget.a;
import java.util.List;

public class NetActiveVryQuesActivity
  extends BaseActivity
  implements View.OnFocusChangeListener
{
  private final int CHECK_TYPE_CORRECT = 1;
  private final int CHECK_TYPE_NULL = 4;
  private final int CHECK_TYPE_OTHER = 3;
  private final int CHECK_TYPE_SPACE = 2;
  private boolean isFirstFactor = false;
  private String[] mAnswer = new String[3];
  private View.OnClickListener mCompleteButtonListener = new re(this);
  Button mConfirmBtn;
  private View.OnClickListener mConfirmMobileButtonListener = new rf(this);
  private View.OnClickListener mConfirmQuesButtonListener = new rh(this);
  private String mCountryCode = "+86";
  private View.OnClickListener mCountryListener = new rg(this);
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new rd(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mMobileText;
  InputMethodRelativeLayout mRootLayout;
  View mScrollAreaLayout;
  private boolean mText1HasFocus;
  private cw mTokenCore = cw.a();
  private int[] mType = new int[3];
  private QQUser mUser;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private View mcountry;
  private int originBtnY;
  private int originH;
  private int originLayoutY;
  
  private int checkDate(String paramString)
  {
    int j = 3;
    int i = j;
    if (paramString.matches("^\\d{8}$"))
    {
      int k = Integer.parseInt(paramString.substring(0, 4));
      int m = Integer.parseInt(paramString.substring(4, 6));
      int n = Integer.parseInt(paramString.substring(6, 8));
      i = j;
      if (k < 2100)
      {
        i = j;
        if (k > 1900)
        {
          i = j;
          if (m > 0)
          {
            i = j;
            if (m < 13)
            {
              i = j;
              if (n > 0)
              {
                i = j;
                if (n < 32) {
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  private int checkName(String paramString)
  {
    if (paramString.matches("^[一-龥]{1,30}|[A-Za-z ]{2,60}$")) {
      return 1;
    }
    return 3;
  }
  
  private int checkNumber(String paramString)
  {
    if (paramString.matches("^\\d{2,16}$")) {
      return 1;
    }
    return 3;
  }
  
  private int checkQuesAnswer(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 4;
    }
    if (paramString.matches("^\\s+.*|.*\\s+$")) {
      return 2;
    }
    switch (paramInt)
    {
    default: 
      return 1;
    case 0: 
      return checkNumber(paramString);
    case 1: 
      return checkName(paramString);
    }
    return checkDate(paramString);
  }
  
  private void init()
  {
    List localList = this.mVerifyResult.k();
    if ((localList.size() != 3) || (localList == null) || (localList.size() == 0))
    {
      h.c("Ques Info err, question size = " + localList.size());
      finish();
      return;
    }
    this.mConfirmBtn = ((Button)findViewById(2131559094));
    this.mConfirmBtn.setOnClickListener(this.mConfirmQuesButtonListener);
    this.mRootLayout = ((InputMethodRelativeLayout)findViewById(2131559086));
    this.mScrollAreaLayout = findViewById(2131559015);
    this.mRootLayout.setOnSizeChangedListenner(new ri(this));
    TextView localTextView1 = (TextView)findViewById(2131559088);
    TextView localTextView2 = (TextView)findViewById(2131559090);
    TextView localTextView3 = (TextView)findViewById(2131559092);
    String[] arrayOfString = new String[3];
    EditText[] arrayOfEditText = new EditText[3];
    arrayOfEditText[0] = ((EditText)findViewById(2131559089));
    arrayOfEditText[1] = ((EditText)findViewById(2131559091));
    arrayOfEditText[2] = ((EditText)findViewById(2131559093));
    arrayOfEditText[0].setOnFocusChangeListener(this);
    arrayOfEditText[1].setOnFocusChangeListener(this);
    arrayOfEditText[2].setOnFocusChangeListener(this);
    int i = 0;
    while (i < 3)
    {
      DeterminVerifyFactorsResult.QuesInfoItem localQuesInfoItem = (DeterminVerifyFactorsResult.QuesInfoItem)localList.get(i);
      arrayOfString[i] = ((DeterminVerifyFactorsResult.QuesInfoItem)localList.get(i)).b();
      this.mType[i] = localQuesInfoItem.c();
      if ((this.mType[i] == 0) || (this.mType[i] == 2)) {
        arrayOfEditText[i].setInputType(2);
      }
      i += 1;
    }
    localTextView1.setText(getString(2131230780) + arrayOfString[0]);
    localTextView2.setText(getString(2131230781) + arrayOfString[1]);
    localTextView3.setText(getString(2131230782) + arrayOfString[2]);
    this.mIsActiveSuccess = false;
    setTitle(2131231657);
    ((TextView)findViewById(2131558740)).setOnClickListener(new rj(this));
  }
  
  private void sendDnaBind()
  {
    this.mTokenCore.b(this.mUser.mRealUin, this.mVerifyType.a(), this.mMobile, this.mCountryCode, this.mHandler);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = cx.c();
    ((cx)localObject).i();
    ((cx)localObject).n();
    localObject = this.mUser.mRealUin + "";
    Intent localIntent = new Intent(this, VerifySuccActivity.class);
    localIntent.putExtra("mRealUin", Long.parseLong((String)localObject));
    localIntent.putExtra("mMobile", this.mMobile);
    if (!this.mVerifyResult.b()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isHaveMobie", bool);
      localIntent.putExtra("bindMobileSucc", paramBoolean);
      startActivity(localIntent);
      finish();
      return;
    }
  }
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        default: 
          if ((this.isFirstFactor) && (paramKeyEvent.getAction() == 0)) {}
          switch (paramKeyEvent.getKeyCode())
          {
          case 4: 
            return super.dispatchKeyEvent(paramKeyEvent);
          }
          break;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      startActivity(abi.a().a(this));
      return true;
    }
    return true;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("intent.determin_from_list", false)) {
      overridePendingTransition(0, 0);
    }
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
    this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
    this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
    this.isFirstFactor = getIntent().getBooleanExtra("intent.determin_first_verify_factor", false);
    if ((this.mUser == null) || (this.mVerifyResult == null) || (this.mVerifyType == null))
    {
      finish();
      return;
    }
    if ((this.mVerifyResult != null) && (this.mVerifyResult.c() == 2)) {
      setNeverShowLockVerifyView();
    }
    h.a("NetActiveVryQuesActivity start");
    setContentView(2130968706);
    if (Build.MODEL.equals("K-Touch W619")) {
      getWindow().setSoftInputMode(2);
    }
    for (;;)
    {
      init();
      return;
      getWindow().setSoftInputMode(18);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    finish();
    abi.c();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.getId() == 2131559089) {
      this.mText1HasFocus = paramBoolean;
    }
    while ((paramView.getId() != 2131559091) || (!paramBoolean)) {
      return;
    }
    this.mRootLayout.a.a(true, 0, 0);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void setDefaultBackArrow()
  {
    super.setDefaultBackArrow();
    if (this.isFirstFactor) {
      this.mBackArrow.setOnClickListener(new rk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryQuesActivity
 * JD-Core Version:    0.7.0.1
 */