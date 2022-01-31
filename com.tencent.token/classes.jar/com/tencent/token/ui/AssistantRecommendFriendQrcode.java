package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.token.ch;
import com.tencent.token.cw;

public class AssistantRecommendFriendQrcode
  extends BaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  public Handler mHandler = new ba(this);
  private int mPageId;
  private String mRecommendFriendGroupStr;
  private String mRecommendFriendStr;
  private IWXAPI mWeChatApi;
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131230843, getString(2131231435), 2131231294, 2131231265, new bd(this), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ch.a().a(System.currentTimeMillis(), 41);
    setContentView(2130968737);
    this.mWeChatApi = WXAPIFactory.createWXAPI(this, "wx68451b483ebd18ce", false);
    this.mWeChatApi.registerApp("wx68451b483ebd18ce");
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.mPageId = paramBundle.getInt("page_id");
      if (this.mPageId != 9) {
        break label148;
      }
    }
    label148:
    for (this.mRecommendFriendStr = getResources().getString(2131231447);; this.mRecommendFriendStr = getResources().getString(2131231445))
    {
      this.mRecommendFriendGroupStr = getResources().getString(2131231446);
      findViewById(2131559187).setOnClickListener(new bb(this));
      findViewById(2131559190).setOnClickListener(new bc(this));
      cw.a().c(this.mHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AssistantRecommendFriendQrcode
 * JD-Core Version:    0.7.0.1
 */