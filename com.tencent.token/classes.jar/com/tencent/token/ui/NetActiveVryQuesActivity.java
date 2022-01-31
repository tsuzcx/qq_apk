package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.bean.UpgradeDeterminResult.QuesInfoItem;
import com.tencent.token.global.e;
import com.tencent.token.utils.k;
import com.tencent.token.utils.s;
import com.tencent.token.widget.InputMethodRelativeLayout;
import java.util.List;

public class NetActiveVryQuesActivity
  extends BaseActivity
  implements View.OnFocusChangeListener
{
  private final int CHECK_TYPE_CORRECT = 1;
  private final int CHECK_TYPE_NULL = 4;
  private final int CHECK_TYPE_OTHER = 3;
  private final int CHECK_TYPE_SPACE = 2;
  private String[] mAnswer = new String[3];
  private View.OnClickListener mBindButtonListener = new sd(this);
  private View.OnClickListener mCompleteButtonListener = new rz(this);
  Button mConfirmBtn;
  private View.OnClickListener mConfirmMobileButtonListener = new sa(this);
  private View.OnClickListener mConfirmQuesButtonListener = new sc(this);
  private String mCountryCode = "+86";
  private View.OnClickListener mCountryListener = new sb(this);
  private TextView mCountry_name;
  private TextView mCountry_number;
  private Handler mHandler = new ry(this);
  private boolean mIsActiveSuccess = false;
  private String mMobile = "";
  private EditText mMobileText;
  InputMethodRelativeLayout mRootLayout;
  View mScrollAreaLayout;
  private boolean mText1HasFocus;
  private af mTokenCore = af.a();
  private int[] mType = new int[3];
  private UpgradeDeterminResult mUpDetermin;
  private QQUser mUser;
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
    if (this.mUpDetermin.mQuesAppear == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      finish();
      return;
    }
    List localList = this.mUpDetermin.mQuesInfo;
    if ((localList.size() != 3) || (localList == null)) {
      e.c("Ques Info err, question size = " + localList.size());
    }
    this.mConfirmBtn = ((Button)findViewById(2131296900));
    this.mConfirmBtn.setOnClickListener(this.mConfirmQuesButtonListener);
    this.mRootLayout = ((InputMethodRelativeLayout)findViewById(2131296892));
    this.mScrollAreaLayout = findViewById(2131296815);
    this.mRootLayout.a = new se(this);
    TextView localTextView1 = (TextView)findViewById(2131296894);
    TextView localTextView2 = (TextView)findViewById(2131296896);
    TextView localTextView3 = (TextView)findViewById(2131296898);
    String[] arrayOfString = new String[3];
    EditText[] arrayOfEditText = new EditText[3];
    arrayOfEditText[0] = ((EditText)findViewById(2131296895));
    arrayOfEditText[1] = ((EditText)findViewById(2131296897));
    arrayOfEditText[2] = ((EditText)findViewById(2131296899));
    arrayOfEditText[0].setOnFocusChangeListener(this);
    arrayOfEditText[1].setOnFocusChangeListener(this);
    arrayOfEditText[2].setOnFocusChangeListener(this);
    i = 0;
    while (i < 3)
    {
      UpgradeDeterminResult.QuesInfoItem localQuesInfoItem = (UpgradeDeterminResult.QuesInfoItem)localList.get(i);
      arrayOfString[i] = ((UpgradeDeterminResult.QuesInfoItem)localList.get(i)).mContent;
      this.mType[i] = localQuesInfoItem.mType;
      if ((this.mType[i] == 0) || (this.mType[i] == 2)) {
        arrayOfEditText[i].setInputType(2);
      }
      i += 1;
    }
    localTextView1.setText(getString(2131361828) + arrayOfString[0]);
    localTextView2.setText(getString(2131361829) + arrayOfString[1]);
    localTextView3.setText(getString(2131361830) + arrayOfString[2]);
    this.mIsActiveSuccess = false;
    setTitle(2131362363);
  }
  
  private void sendDnaBind()
  {
    this.mTokenCore.c(this.mUser.mRealUin, 1, this.mMobile, this.mCountryCode, this.mHandler);
  }
  
  private void setActiveSucc(boolean paramBoolean)
  {
    Object localObject = ag.c();
    ((ag)localObject).i();
    ((ag)localObject).n();
    localObject = this.mUser.mRealUin + "";
    this.mIsActiveSuccess = true;
    int i;
    if (this.mUpDetermin.mHaveMobile == 1)
    {
      i = 1;
      if (i != 0) {
        break label266;
      }
      if (!paramBoolean) {
        break label256;
      }
      setContentView(2130903052);
      label71:
      this.mBackArrow.setVisibility(4);
      ax.a().f(Long.parseLong((String)localObject));
      ((Button)findViewById(2131296398)).setOnClickListener(this.mCompleteButtonListener);
      setTitle(2131361842);
      ((ImageView)findViewById(2131296395)).setImageDrawable(k.a((String)localObject, s.f(Long.parseLong((String)localObject)) + " "));
      if (this.mUpDetermin.mHaveMobile != 1) {
        break label276;
      }
      i = 1;
      label169:
      if (i == 0)
      {
        localObject = (TextView)findViewById(2131296402);
        if (!paramBoolean) {
          break label281;
        }
        String str = getString(2131361843) + " ";
        ((TextView)localObject).setText(str + this.mMobile);
      }
    }
    for (;;)
    {
      com.tencent.token.core.push.a.a().a(8);
      return;
      i = 0;
      break;
      label256:
      setContentView(2130903051);
      break label71;
      label266:
      setContentView(2130903050);
      break label71;
      label276:
      i = 0;
      break label169;
      label281:
      ((Button)findViewById(2131296403)).setOnClickListener(this.mBindButtonListener);
      ((TextView)localObject).setText(getResources().getString(2131361832));
    }
  }
  
  public void cancelRequest()
  {
    this.mTokenCore.a(getClass().getName());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsActiveSuccess) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
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
      s.a(paramInt2, this.mCountry_name, this.mCountry_number);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903150);
    this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
    this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
    if ((this.mUser == null) || (this.mUpDetermin == null))
    {
      finish();
      return;
    }
    e.a("NetActiveVryQuesActivity start");
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
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.getId() == 2131296895) {
      this.mText1HasFocus = paramBoolean;
    }
    while ((paramView.getId() != 2131296897) || (!paramBoolean)) {
      return;
    }
    this.mRootLayout.a.a(true, 0);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.NetActiveVryQuesActivity
 * JD-Core Version:    0.7.0.1
 */