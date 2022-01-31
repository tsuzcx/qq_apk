package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.token.af;
import com.tencent.token.p;

public class AssistantRecommendFriendQrcode
  extends BaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  public Handler mHandler = new ao(this);
  private int mPageId;
  private String mRecommendFriendGroupStr;
  private String mRecommendFriendStr;
  private IWXAPI mWeChatApi;
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131361808, getString(2131362386), 2131361812, 2131361813, new ar(this), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    p.a().a(System.currentTimeMillis(), 41);
    setContentView(2130903179);
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
    for (this.mRecommendFriendStr = getResources().getString(2131362389);; this.mRecommendFriendStr = getResources().getString(2131362387))
    {
      this.mRecommendFriendGroupStr = getResources().getString(2131362388);
      findViewById(2131296999).setOnClickListener(new ap(this));
      findViewById(2131297002).setOnClickListener(new aq(this));
      af.a().c(this.mHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AssistantRecommendFriendQrcode
 * JD-Core Version:    0.7.0.1
 */