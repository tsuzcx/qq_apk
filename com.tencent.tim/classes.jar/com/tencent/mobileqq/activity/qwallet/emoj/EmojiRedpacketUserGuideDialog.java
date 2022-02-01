package com.tencent.mobileqq.activity.qwallet.emoj;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aoop;
import aqcl;
import aqcx;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import rpq;

public class EmojiRedpacketUserGuideDialog
  extends ReportDialog
{
  private static final String TAG = EmojiRedpacketUserGuideDialog.class.getSimpleName();
  public static String URL_DEFAULT = "https://i.gtimg.cn/channel/imglib/201904/upload_13e561ae68d934abd06b8b6830d99754.png";
  
  public EmojiRedpacketUserGuideDialog(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public EmojiRedpacketUserGuideDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    try
    {
      super.setContentView(new UserGuidView(getContext()));
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle.setLayout(-1, -1);
        paramBundle.setBackgroundDrawable(new ColorDrawable(0));
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          paramBundle.addFlags(67108864);
        }
      }
      super.setCancelable(true);
      return;
    }
    catch (Exception paramBundle) {}catch (OutOfMemoryError paramBundle) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      try
      {
        super.cancel();
        return false;
      }
      catch (Exception paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramKeyEvent.printStackTrace();
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class UserGuidView
    extends FrameLayout
  {
    public UserGuidView(@NonNull Context paramContext)
    {
      super();
      Object localObject1 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject1).setClickable(true);
      addView((View)localObject1);
      Object localObject2 = (FrameLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).width = -1;
      ((FrameLayout.LayoutParams)localObject2).height = -1;
      ((RelativeLayout)localObject1).setOnClickListener(new EmojiRedpacketUserGuideDialog.UserGuidView.1(this, EmojiRedpacketUserGuideDialog.this));
      this$1 = new View(paramContext);
      ((RelativeLayout)localObject1).addView(EmojiRedpacketUserGuideDialog.this);
      localObject2 = (RelativeLayout.LayoutParams)EmojiRedpacketUserGuideDialog.this.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      ((RelativeLayout.LayoutParams)localObject2).width = aqcx.dip2px(paramContext, 40.0F);
      ((RelativeLayout.LayoutParams)localObject2).height = aqcx.dip2px(paramContext, 40.0F);
      localObject2 = getResources().getDrawable(2130844271);
      EmojiRedpacketUserGuideDialog.this.setBackgroundDrawable((Drawable)localObject2);
      ((Animatable)localObject2).start();
      this$1 = new LinearLayout(paramContext);
      EmojiRedpacketUserGuideDialog.this.setOrientation(1);
      ((RelativeLayout)localObject1).addView(EmojiRedpacketUserGuideDialog.this);
      localObject1 = (RelativeLayout.LayoutParams)EmojiRedpacketUserGuideDialog.this.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      ((RelativeLayout.LayoutParams)localObject1).width = -1;
      ((RelativeLayout.LayoutParams)localObject1).height = -2;
      localObject1 = new RoundImageView(paramContext);
      ((RoundImageView)localObject1).setmRadius(rpq.dip2px(paramContext, 10.0F), false);
      ((RoundImageView)localObject1).setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(EmojiRedpacketUserGuideDialog.URL_DEFAULT, aoop.TRANSPARENT, aoop.TRANSPARENT));
      EmojiRedpacketUserGuideDialog.this.addView((View)localObject1);
      localObject1 = (LinearLayout.LayoutParams)((RoundImageView)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      ((LinearLayout.LayoutParams)localObject1).height = ((int)(rpq.getWindowScreenHeight(paramContext) * 0.7D));
      ((LinearLayout.LayoutParams)localObject1).width = rpq.dip2px(paramContext, 320.0F);
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setImageResource(2130847409);
      EmojiRedpacketUserGuideDialog.this.addView((View)localObject1);
      this$1 = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      EmojiRedpacketUserGuideDialog.this.topMargin = ((int)(rpq.getWindowScreenHeight(paramContext) * 0.02D));
      EmojiRedpacketUserGuideDialog.this.gravity = 1;
      EmojiRedpacketUserGuideDialog.this.width = rpq.dip2px(paramContext, 37.0F);
      EmojiRedpacketUserGuideDialog.this.height = rpq.dip2px(paramContext, 37.0F);
      aqcl.changeAccessibilityForView((View)localObject1, acfp.m(2131705779), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedpacketUserGuideDialog
 * JD-Core Version:    0.7.0.1
 */