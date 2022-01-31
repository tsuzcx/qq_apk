package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.x;

public class FacePKActivity
  extends EmbedWebBaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  private Handler mHandler = new ea(this);
  private String mPKDesc;
  private String mPKTitle;
  private View.OnClickListener mRightTitleButtonClickListener = new eb(this);
  private String mUrl;
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131361808, getString(2131362386), 2131361812, 2131361813, new ed(this), null);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      if ((this.mTitleMenu != null) && (this.mTitleMenu.getVisibility() == 0))
      {
        this.mTitleMenu.a();
        return true;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mUrl = paramBundle.getStringExtra("help_url");
    this.mPKDesc = paramBundle.getStringExtra("share_desc");
    this.mPKTitle = paramBundle.getStringExtra("share_title");
    if (this.mUrl == null) {
      this.mUrl = getString(2131361973);
    }
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (this.mUrl.contains("qq.com"))) {
      x.a(RqdApplication.i()).a("" + paramBundle.mRealUin, this.mHandler);
    }
    for (;;)
    {
      setRightTitleImage(2130837953, this.mRightTitleButtonClickListener);
      this.alsoShowMenu = true;
      this.mWeChatApi = WXAPIFactory.createWXAPI(this, "wx68451b483ebd18ce", false);
      this.mWeChatApi.registerApp("wx68451b483ebd18ce");
      return;
      this.mWebView.loadUrl(this.mUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FacePKActivity
 * JD-Core Version:    0.7.0.1
 */