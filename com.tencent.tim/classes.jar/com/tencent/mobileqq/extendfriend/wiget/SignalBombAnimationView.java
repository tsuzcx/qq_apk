package com.tencent.mobileqq.extendfriend.wiget;

import afwv;
import afzd;
import afze;
import afzf;
import afzi;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import aqgz;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignalBombAnimationView
  extends FrameLayout
  implements Handler.Callback
{
  private View Cz;
  private a a;
  private AnimatorSet ap;
  boolean bInit = false;
  public final int cVA = 2;
  private int cVx = 48;
  int cVy = 0;
  public final int cVz = 1;
  private boolean cbV;
  public QQAnimationDrawable f;
  QQAnimationDrawable g;
  private Handler mHandler;
  private ImageView zu;
  private ImageView zv;
  private ImageView zw;
  
  public SignalBombAnimationView(Context paramContext)
  {
    this(paramContext, null);
    initView(paramContext);
  }
  
  public SignalBombAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    initView(paramContext);
  }
  
  public SignalBombAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void ded()
  {
    this.bInit = true;
    int i = this.Cz.getTop();
    int j = this.zw.getTop();
    this.cVy = (i - j);
    QLog.d("SignalBombAnimationViewExtendFriendLimitChat", 2, "SignalBombAnimationView. deltaY = " + this.cVy + " beginY" + j + "destinyY " + i);
    Object localObject = g(afwv.uO());
    if ((localObject != null) && (localObject.length > 0))
    {
      this.f.Q((String[])localObject);
      this.f.setOneShot(true);
      this.f.setDuration(2480L);
      this.zu.setImageDrawable(this.f);
      this.f.a(new afzd(this));
    }
    localObject = g(afwv.uP());
    if ((localObject != null) && (localObject.length > 0))
    {
      if (this.cVx > localObject.length)
      {
        this.cVx = (localObject.length * 2 / 3);
        QLog.e("SignalBombAnimationView", 2, "traceStartOnFrameIndexOfBomb > bombPaths.length straceStartOnFrameIndexOfBomb set" + this.cVx);
      }
      this.g.Q((String[])localObject);
      this.g.setOneShot(true);
      this.g.setDuration(2880L);
      this.zv.setImageDrawable(this.g);
      this.g.a(new afze(this));
    }
    this.ap = new AnimatorSet();
    localObject = ObjectAnimator.ofFloat(this.zw, "translationY", new float[] { 0.0F, this.cVy });
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.zw, "alpha", new float[] { 0.0F, 1.0F });
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    ((ObjectAnimator)localObject).setDuration(860L);
    ((ObjectAnimator)localObject).setInterpolator(localAccelerateDecelerateInterpolator);
    localObjectAnimator.setDuration(860L);
    this.ap.playTogether(new Animator[] { localObject, localObjectAnimator });
    this.ap.addListener(new afzf(this));
  }
  
  private String[] g(String paramString)
  {
    int j = 0;
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("SignalBombAnimationView", 2, "exist Animation Pic!");
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        Arrays.sort(paramString, new afzi(this));
        ArrayList localArrayList = new ArrayList();
        boolean bool = aqgz.aCI();
        int i = 1;
        if (bool) {
          i = 3;
        }
        int k = aqgz.getPerfLevel();
        this.cVx = (48 / i);
        QLog.e("SignalBombAnimationView", 2, "isLowLevelMachine 50% cut frames isLowLevel:" + bool + " level :" + k + " cut time:" + i + " traceindex:" + this.cVx);
        int m = paramString.length;
        k = 0;
        while (j < m)
        {
          Object localObject = paramString[j];
          if ((!bool) || (k % i == 0) || (k + 1 == paramString.length)) {
            localArrayList.add(localObject.getPath());
          }
          k += 1;
          j += 1;
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
    }
    return null;
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561343, this, true);
    this.zu = ((ImageView)findViewById(2131378413));
    this.zv = ((ImageView)findViewById(2131378410));
    this.zw = ((ImageView)findViewById(2131363582));
    this.Cz = findViewById(2131366698);
    this.f = new QQAnimationDrawable();
    this.g = new QQAnimationDrawable();
    this.mHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public void Destroy()
  {
    def();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (this.zw != null) {
      this.zw.clearAnimation();
    }
    if (this.zu != null) {
      this.zu.setImageDrawable(null);
    }
    if (this.zv != null) {
      this.zv.setImageDrawable(null);
    }
    if (this.f != null) {
      this.f.cVj();
    }
    if (this.g != null) {
      this.g.cVj();
    }
  }
  
  void ddZ()
  {
    if (this.ap != null) {
      this.ap.cancel();
    }
    this.ap.start();
    this.zw.setVisibility(0);
  }
  
  public void dee()
  {
    QLog.d("SignalBombAnimationView", 2, "startBombAnim()");
    if (!this.bInit) {
      ded();
    }
    if (this.a != null) {
      this.a.onAnimationStart();
    }
    def();
    this.cbV = true;
    if (this.zv != null)
    {
      this.zv.setImageDrawable(this.g);
      QLog.d("SignalBombAnimationView", 2, "mSignalBomb SET mBombDrawable");
    }
    if (this.g != null)
    {
      this.g.start();
      if (this.a != null) {
        this.a.onAnimationStart();
      }
      QLog.d("SignalBombAnimationView", 2, "mBombDrawable start");
    }
  }
  
  public void def()
  {
    QLog.d("SignalBombAnimationView", 2, "stopBombAnim()");
    this.cbV = false;
    if (this.g != null)
    {
      this.g.stop();
      QLog.d("SignalBombAnimationView", 2, "mBombDrawable stop");
    }
    if (this.f != null)
    {
      this.f.stop();
      QLog.d("SignalBombAnimationView", 2, "mFireDrawable stop");
    }
    if (this.ap != null) {
      this.ap.cancel();
    }
    if (this.zu != null) {
      this.zu.setImageDrawable(null);
    }
    if (this.zv != null) {
      this.zv.setImageDrawable(null);
    }
    if (this.zw != null) {
      this.zw.setTranslationY(0.0F);
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      ddZ();
      continue;
      dee();
    }
  }
  
  public void setListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView
 * JD-Core Version:    0.7.0.1
 */