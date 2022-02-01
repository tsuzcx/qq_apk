package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class WereWolvesLoadingView
  extends FrameLayout
{
  a a;
  TextView cK;
  boolean cZj;
  Runnable hW = new WereWolvesLoadingView.1(this);
  Runnable hX = new WereWolvesLoadingView.2(this);
  boolean isStop = false;
  int mProgress = 0;
  Handler mUIHandler = new Handler(Looper.getMainLooper());
  int maxWidth;
  public TextView my;
  View pw;
  public View root;
  
  public WereWolvesLoadingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public WereWolvesLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public void ehy()
  {
    this.isStop = false;
    this.mUIHandler.postDelayed(this.hX, 10L);
  }
  
  public void ehz()
  {
    this.isStop = true;
  }
  
  void init()
  {
    this.root = LayoutInflater.from(getContext()).inflate(2131559692, this);
    this.maxWidth = findViewById(2131373671).getLayoutParams().width;
    this.pw = findViewById(2131373668);
    this.cK = ((TextView)findViewById(2131373697));
    setProgress(0);
    this.my = ((TextView)findViewById(2131379724));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.root.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void setComplete(a parama)
  {
    this.isStop = true;
    this.mUIHandler.removeCallbacks(this.hX);
    this.a = parama;
    this.mUIHandler.post(this.hW);
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 0;
      paramInt = this.maxWidth * i / 100;
      if (paramInt == 0) {
        break label129;
      }
      ViewGroup.LayoutParams localLayoutParams = this.pw.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.pw.setVisibility(0);
      this.pw.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.mProgress = i;
      this.cK.setText(String.format("%d%%", new Object[] { Integer.valueOf(i) }));
      if (this.mProgress < 100) {
        break label141;
      }
      if ((this.a != null) && (!this.cZj))
      {
        this.a.onComplete();
        this.cZj = true;
      }
      return;
      i = paramInt;
      if (paramInt <= 100) {
        break;
      }
      i = 100;
      break;
      label129:
      this.pw.setVisibility(8);
    }
    label141:
    this.cZj = false;
  }
  
  public void setTips(String paramString)
  {
    this.my.setText(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WereWolvesLoadingView
 * JD-Core Version:    0.7.0.1
 */