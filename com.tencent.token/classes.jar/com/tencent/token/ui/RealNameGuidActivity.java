package com.tencent.token.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.CommonActionSheetDialog;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.ui.base.ba;
import com.tencent.token.ui.base.i;
import com.tencent.token.utils.k;
import com.tencent.token.utils.t;

public class RealNameGuidActivity
  extends BaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  CommonActionSheetDialog dialog;
  i listener = new vp(this);
  RealNameStatusResult mResult;
  private IWXAPI mWeChatApi;
  Button openface;
  QQUser user;
  
  private void initView()
  {
    setContentView(2130903176);
    Object localObject = new ba(GradientDrawable.Orientation.BOTTOM_TOP, getResources().getColor(2131165309), getResources().getColor(2131165310));
    this.mTitleBar.setBackgroundDrawable((Drawable)localObject);
    this.mTitleDivider.setBackgroundColor(getResources().getColor(2131165310));
    this.mBackArrowImg.setImageDrawable(getResources().getDrawable(2130837537));
    this.mTitleText.setTextColor(getResources().getColor(2131165297));
    setRightTitleImage(2130837898, new vn(this));
    ((TextView)findViewById(2131296991)).setText(String.valueOf(this.mResult.realnameday));
    localObject = (RoundImageView)findViewById(2131296984);
    ImageView localImageView1 = (ImageView)findViewById(2131296985);
    this.user = ax.a().e();
    if (this.user != null)
    {
      ((RoundImageView)localObject).setVisibility(0);
      ((RoundImageView)localObject).setImageDrawable(k.a(this.user.mRealUin + "", this.user.mUin + ""));
      localImageView1.setVisibility(0);
      localObject = new vo(this);
      localImageView1 = (ImageView)findViewById(2131296986);
      ImageView localImageView2 = (ImageView)findViewById(2131296987);
      ImageView localImageView3 = (ImageView)findViewById(2131296988);
      localImageView1.setOnClickListener((View.OnClickListener)localObject);
      localImageView2.setOnClickListener((View.OnClickListener)localObject);
      localImageView3.setOnClickListener((View.OnClickListener)localObject);
      this.openface = ((Button)findViewById(2131296992));
      if (t.e() == 0L) {
        break label335;
      }
      this.openface.setVisibility(8);
    }
    for (;;)
    {
      this.openface.setOnClickListener((View.OnClickListener)localObject);
      return;
      localImageView1.setVisibility(8);
      break;
      label335:
      this.openface.setVisibility(0);
    }
  }
  
  private void shareToWechat(int paramInt)
  {
    this.mWeChatApi = WXAPIFactory.createWXAPI(this, "wx68451b483ebd18ce", false);
    this.mWeChatApi.registerApp("wx68451b483ebd18ce");
    Object localObject;
    SendMessageToWX.Req localReq;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.mWeChatApi.isWXAppInstalled())
      {
        if (this.mWeChatApi.getWXAppSupportAPI() >= 553779201)
        {
          p.a().a(System.currentTimeMillis(), 74);
          localObject = new WXWebpageObject();
          ((WXWebpageObject)localObject).webpageUrl = this.mResult.urlShare;
          localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
          ((WXMediaMessage)localObject).title = this.mResult.shareTitle;
          ((WXMediaMessage)localObject).description = this.mResult.shareFriendText;
          ((WXMediaMessage)localObject).setThumbImage(t.a(getResources(), 2130837851));
          localReq = new SendMessageToWX.Req();
          localReq.transaction = String.valueOf(System.currentTimeMillis());
          localReq.message = ((WXMediaMessage)localObject);
          localReq.scene = 0;
          this.mWeChatApi.sendReq(localReq);
          return;
        }
        showToast(getString(2131362385));
        return;
      }
      showWechatBindDialog();
      return;
    }
    if (this.mWeChatApi.isWXAppInstalled())
    {
      if (this.mWeChatApi.getWXAppSupportAPI() >= 553779201)
      {
        p.a().a(System.currentTimeMillis(), 74);
        localObject = new WXWebpageObject();
        ((WXWebpageObject)localObject).webpageUrl = this.mResult.urlShare;
        localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
        ((WXMediaMessage)localObject).title = this.mResult.shareCircleText;
        ((WXMediaMessage)localObject).description = "";
        ((WXMediaMessage)localObject).setThumbImage(t.a(getResources(), 2130837851));
        localReq = new SendMessageToWX.Req();
        localReq.transaction = String.valueOf(System.currentTimeMillis());
        localReq.message = ((WXMediaMessage)localObject);
        localReq.scene = 1;
        this.mWeChatApi.sendReq(localReq);
        return;
      }
      showToast(getString(2131362385));
      return;
    }
    showWechatBindDialog();
  }
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131361808, getString(2131362386), 2131361812, 2131361813, new vq(this), null);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("result"));
    if (this.mResult == null)
    {
      finish();
      e.c("RealNameShareActivity result = null");
    }
    do
    {
      return;
      initView();
      paramBundle = RqdApplication.i().getSharedPreferences("sp_name_global", 0);
    } while (!paramBundle.getBoolean("key_realname_firsttime", true));
    Intent localIntent = new Intent(this, RealNameFirstJoinActivity.class);
    localIntent.putExtra("result", this.mResult);
    startActivity(localIntent);
    paramBundle.edit().putBoolean("key_realname_firsttime", false).commit();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (t.e() != 0L)
    {
      this.openface.setVisibility(8);
      return;
    }
    this.openface.setVisibility(0);
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new vm(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameGuidActivity
 * JD-Core Version:    0.7.0.1
 */