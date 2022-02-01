package dov.com.qq.im.capture.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import axxu;
import axxv;

public abstract class StoryToastView
  extends LinearLayout
  implements Handler.Callback
{
  private Handler mHandler = new Handler(this);
  private Animator n;
  private Animator o;
  
  public StoryToastView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public StoryToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public StoryToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private Animator a()
  {
    if (this.n == null)
    {
      this.n = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
      this.n.setDuration(300L);
      this.n.addListener(new axxu(this));
    }
    return this.n;
  }
  
  private Animator b()
  {
    if (this.o == null)
    {
      this.o = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
      this.o.setDuration(300L);
      this.o.addListener(new axxv(this));
    }
    return this.o;
  }
  
  private void ePm()
  {
    if (getVisibility() == 8) {
      return;
    }
    this.mHandler.removeMessages(1);
    b().start();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ePm();
    }
  }
  
  public void hide()
  {
    if (a().isRunning()) {
      a().cancel();
    }
    if (getVisibility() == 0)
    {
      this.mHandler.removeMessages(1);
      setVisibility(4);
    }
  }
  
  protected abstract void init(Context paramContext);
  
  public void show()
  {
    show(true);
  }
  
  public void show(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(0);
      a().start();
      return;
    }
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryToastView
 * JD-Core Version:    0.7.0.1
 */