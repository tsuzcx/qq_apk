package com.tencent.biz.pubaccount.readinjoySearch;

import aenl;
import aenm;
import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqfo;
import aqha;
import aqju;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import kbp;
import nxy;
import nxz;
import nya;
import yof;
import yof.a;

public class ReadInJoyNewSearchActivity
  extends FragmentActivity
  implements View.OnClickListener, yof.a
{
  private ImageButton A;
  private yof a;
  private Button aK;
  private XListView g;
  private EditText mEditText;
  protected Handler mHandler = new nxy(this);
  private View mRootView;
  private View ni;
  private TextWatcher textWatcher = new nxz(this);
  
  private void aC()
  {
    if (ThemeUtil.isInNightMode(this.app)) {}
    while (ImmersiveUtils.isSupporImmersive() != 1) {
      return;
    }
    super.getWindow().addFlags(67108864);
    if (this.mSystemBarComp == null) {
      this.mSystemBarComp = new SystemBarCompact(this, true, -1);
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    this.mSystemBarComp.init();
    if (!aqfo.isFlyme())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  private void bcq()
  {
    this.a = new yof(this, null, this);
    this.g = ((XListView)super.findViewById(2131377828));
    this.g.setAdapter(this.a);
    this.ni = super.findViewById(2131377830);
    bcr();
  }
  
  private void bcr()
  {
    ThreadManager.post(new ReadInJoyNewSearchActivity.4(this), 10, null, true);
  }
  
  private void dp(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.ni.setVisibility(8);
    }
    for (;;)
    {
      this.a.bJ(paramList);
      return;
      this.ni.setVisibility(0);
      this.ni.setFocusable(false);
      this.g.setVisibility(0);
      this.g.setFocusable(false);
    }
  }
  
  @TargetApi(14)
  private void initViews()
  {
    this.mRootView = super.findViewById(2131377546);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mRootView.setFitsSystemWindows(true);
    }
    this.aK = ((Button)super.findViewById(2131363801));
    this.aK.setOnClickListener(this);
    this.A = ((ImageButton)super.findViewById(2131368696));
    this.A.setOnClickListener(this);
    this.mEditText = ((EditText)super.findViewById(2131366542));
    this.mEditText.requestFocus();
    this.mEditText.addTextChangedListener(this.textWatcher);
    this.mEditText.setImeOptions(3);
    this.mEditText.setOnKeyListener(new a(null));
  }
  
  private void oS(String paramString)
  {
    try
    {
      String str = Uri.encode(paramString.trim());
      Object localObject = aenm.a().bzW;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (!((String)localObject).contains("$KEYWORD$")) {}
      }
      for (paramString = ((String)localObject).replace("$KEYWORD$", str);; paramString = "https://so.mp.qq.com/search/index?key=" + str + "&_wv=3&_bid=2321")
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNewSearchActivity", 2, "jumpToHotWord(). jumpUrl=" + paramString);
        }
        localObject = new Intent(this, PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("url", paramString);
        startActivity((Intent)localObject);
        localObject = Uri.decode(str);
        paramString = (String)localObject;
        if (((String)localObject).contains("|")) {
          paramString = ((String)localObject).replaceAll("\\|", " ");
        }
        kbp.a(null, null, "0X80067C4", "0X80067C4", 0, 0, "", "", paramString, "", false);
        return;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    this.mEditText.setText(paramReadInJoySearchHistoryEntity.keyWord);
    if (!TextUtils.isEmpty(paramReadInJoySearchHistoryEntity.keyWord)) {
      this.mEditText.setSelection(this.mEditText.getText().length());
    }
    oS(paramReadInJoySearchHistoryEntity.keyWord);
    oR(paramReadInJoySearchHistoryEntity.keyWord);
    String str = paramReadInJoySearchHistoryEntity.keyWord.trim();
    paramReadInJoySearchHistoryEntity = str;
    if (str.contains("|")) {
      paramReadInJoySearchHistoryEntity = str.replaceAll("\\|", " ");
    }
    kbp.a(null, null, "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity, "", "", "", false);
  }
  
  public void bcs()
  {
    aqju localaqju = aqha.a(this, 230);
    Object localObject = new nya(this);
    localaqju.setPositiveButton(2131698203, (DialogInterface.OnClickListener)localObject);
    localaqju.setNegativeButton(2131698202, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131698204);
    localaqju.setTitle(2131699480);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165625));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localaqju.addView(localTextView);
    localaqju.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560456);
    aC();
    initViews();
    bcq();
    if (VersionUtils.isIceScreamSandwich()) {
      getWindow().setFlags(16777216, 16777216);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.textWatcher != null) {
      this.mEditText.removeTextChangedListener(this.textWatcher);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bcr();
    if (this.mEditText != null) {
      this.mEditText.setText("");
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void oR(String paramString)
  {
    ThreadManager.post(new ReadInJoyNewSearchActivity.3(this, paramString), 10, null, true);
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
      finish();
      continue;
      this.mEditText.setText("");
    }
  }
  
  class a
    implements View.OnKeyListener
  {
    private a() {}
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      paramView = ReadInJoyNewSearchActivity.a(ReadInJoyNewSearchActivity.this).getText().toString().trim();
      if ((66 == paramInt) && (paramKeyEvent.getAction() == 0) && (!TextUtils.isEmpty(paramView)))
      {
        paramKeyEvent = (InputMethodManager)ReadInJoyNewSearchActivity.this.getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(ReadInJoyNewSearchActivity.a(ReadInJoyNewSearchActivity.this).getWindowToken(), 2);
        }
        ReadInJoyNewSearchActivity.a(ReadInJoyNewSearchActivity.this, paramView);
        ReadInJoyNewSearchActivity.this.oR(paramView);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity
 * JD-Core Version:    0.7.0.1
 */