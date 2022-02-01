package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import com.tencent.mobileqq.app.ThreadManager;
import itf;
import java.lang.ref.WeakReference;

public class RedPacketRollTextView
  extends TextSwitcher
  implements Animation.AnimationListener
{
  private boolean UK = true;
  private a jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView$a;
  private b jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView$b = new b(this);
  private int aal;
  protected boolean mAcitive = true;
  private Context mContext;
  private int mFrom;
  private int mTextSize = 50;
  private int mTo;
  
  public RedPacketRollTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, true);
  }
  
  public RedPacketRollTextView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mTextSize = paramInt;
    init(paramContext, true);
  }
  
  public RedPacketRollTextView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    bQ(paramInt1, paramInt2);
    this.mTextSize = paramInt3;
    init(paramContext, true);
  }
  
  public RedPacketRollTextView(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.mTextSize = paramInt;
    init(paramContext, paramBoolean);
  }
  
  public RedPacketRollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, true);
  }
  
  private void aqv()
  {
    if (this.UK)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(this.aal);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(true);
      setInAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      localTranslateAnimation.setDuration(this.aal);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localTranslateAnimation.setFillAfter(false);
      setOutAnimation(localTranslateAnimation);
      localTranslateAnimation.setAnimationListener(this);
      return;
    }
    setInAnimation(null);
    setOutAnimation(null);
  }
  
  private void bQ(int paramInt1, int paramInt2)
  {
    if ((this.mFrom != paramInt1) || (this.mTo != paramInt2))
    {
      this.mFrom = paramInt1;
      this.mTo = paramInt2;
      paramInt1 = (this.mTo - this.mFrom + 10) % 10;
      if (paramInt1 <= 0) {
        break label70;
      }
    }
    label70:
    for (paramInt1 = 250 / paramInt1;; paramInt1 = 0)
    {
      if (this.aal != paramInt1)
      {
        this.aal = paramInt1;
        aqv();
      }
      return;
    }
  }
  
  private void setIsRool(boolean paramBoolean)
  {
    if (this.UK != paramBoolean)
    {
      this.UK = paramBoolean;
      aqv();
    }
  }
  
  public void init(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    setIsRool(paramBoolean);
    setFactory(new itf(this, paramBoolean));
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Log.e("RollTextView", "WL_DEBUG onAnimationEnd");
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    Log.e("RollTextView", "WL_DEBUG onAnimationRepeat");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Log.e("RollTextView", "WL_DEBUG onAnimationStart");
  }
  
  public void setListener(a parama)
  {
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketRollTextView$a = parama;
  }
  
  public void setScope(int paramInt1, int paramInt2)
  {
    if (!this.UK)
    {
      bQ(paramInt2, paramInt2);
      return;
    }
    bQ(paramInt1, paramInt2);
  }
  
  public void show()
  {
    ThreadManager.postImmediately(new ContentSupplyThread(), null, true);
  }
  
  public void stopRoll()
  {
    this.mAcitive = false;
  }
  
  class ContentSupplyThread
    implements Runnable
  {
    ContentSupplyThread() {}
    
    public void run()
    {
      while ((RedPacketRollTextView.b(RedPacketRollTextView.this) != RedPacketRollTextView.c(RedPacketRollTextView.this)) && (RedPacketRollTextView.this.mAcitive)) {
        try
        {
          if (RedPacketRollTextView.b(RedPacketRollTextView.this) != RedPacketRollTextView.c(RedPacketRollTextView.this)) {
            RedPacketRollTextView.a(RedPacketRollTextView.this, (RedPacketRollTextView.b(RedPacketRollTextView.this) + 1) % 10);
          }
          int i = RedPacketRollTextView.b(RedPacketRollTextView.this);
          Message localMessage = RedPacketRollTextView.a(RedPacketRollTextView.this).obtainMessage();
          localMessage.what = 1;
          Bundle localBundle = new Bundle();
          localBundle.putString("content", Integer.toString(i % 10));
          localMessage.setData(localBundle);
          RedPacketRollTextView.a(RedPacketRollTextView.this).sendMessage(localMessage);
          Thread.sleep(RedPacketRollTextView.d(RedPacketRollTextView.this));
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (RedPacketRollTextView.a(RedPacketRollTextView.this) != null) {
        RedPacketRollTextView.a(RedPacketRollTextView.this).onRollTextComplete();
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void onRollTextChanged(Bitmap paramBitmap);
    
    public abstract void onRollTextComplete();
  }
  
  static class b
    extends Handler
  {
    WeakReference<RedPacketRollTextView> mRootView;
    
    b(RedPacketRollTextView paramRedPacketRollTextView)
    {
      this.mRootView = new WeakReference(paramRedPacketRollTextView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      RedPacketRollTextView localRedPacketRollTextView = (RedPacketRollTextView)this.mRootView.get();
      if (localRedPacketRollTextView == null) {}
      do
      {
        Bundle localBundle;
        do
        {
          return;
          localBundle = paramMessage.getData();
        } while (localBundle == null);
        switch (paramMessage.what)
        {
        default: 
          return;
        }
        localRedPacketRollTextView.setText(localBundle.getString("content"));
      } while (RedPacketRollTextView.a(localRedPacketRollTextView) == null);
      RedPacketRollTextView.a(localRedPacketRollTextView).onRollTextChanged(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketRollTextView
 * JD-Core Version:    0.7.0.1
 */