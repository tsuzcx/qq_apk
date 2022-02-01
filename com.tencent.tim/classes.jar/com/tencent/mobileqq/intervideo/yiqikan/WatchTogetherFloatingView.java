package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class WatchTogetherFloatingView
  extends FrameLayout
{
  private TextView Uf;
  private a a = new a(this);
  private TouchWebView c;
  private LinearLayout dH;
  private int dds;
  private ViewGroup eh;
  private RelativeLayout kO;
  private ImageView xC;
  
  public WatchTogetherFloatingView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  private void dsx()
  {
    View localView;
    String str;
    if ((getParent() instanceof FrameLayout))
    {
      localView = ((FrameLayout)getParent().getParent()).findViewById(2131375037);
      if (localView != null)
      {
        str = getContext().getString(2131701821);
        switch (this.dds)
        {
        }
      }
    }
    for (;;)
    {
      localView.setContentDescription(str);
      return;
      str = getContext().getString(2131701819);
      continue;
      str = getContext().getString(2131701821);
      continue;
      str = getContext().getString(2131701818);
    }
  }
  
  private void initView()
  {
    this.eh = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561206, this, true));
    this.kO = ((RelativeLayout)this.eh.findViewById(2131377414));
    this.Uf = ((TextView)this.eh.findViewById(2131380790));
    this.dH = ((LinearLayout)this.eh.findViewById(2131370688));
    this.xC = ((ImageView)this.eh.findViewById(2131369880));
  }
  
  public int FC()
  {
    return this.dds;
  }
  
  public void La(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.sendEmptyMessage(1);
      this.kO.setVisibility(0);
      this.Uf.setVisibility(0);
      this.dH.setVisibility(8);
    }
    for (this.dds = 0;; this.dds = 1)
    {
      dsx();
      return;
      this.a.sendEmptyMessage(3);
      this.Uf.setVisibility(8);
      this.kO.setVisibility(8);
      this.dH.setVisibility(8);
    }
  }
  
  public void Le(String paramString)
  {
    La(true);
    if (this.c != null)
    {
      this.c.loadUrl("about:blank");
      this.c.loadUrl(paramString);
    }
  }
  
  public void b(TouchWebView paramTouchWebView)
  {
    if ((this.eh == null) || (paramTouchWebView == null)) {
      return;
    }
    if ((this.c != null) && (this.c.getParent() == this.eh)) {
      this.eh.removeView(this.c);
    }
    paramTouchWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.eh.addView(paramTouchWebView, 0);
    this.c = paramTouchWebView;
  }
  
  public void dsw()
  {
    this.a.sendEmptyMessage(3);
    this.kO.setVisibility(0);
    this.Uf.setVisibility(8);
    this.dH.setVisibility(0);
    this.dds = 2;
    dsx();
    if (this.c != null) {
      this.c.loadUrl("about:blank");
    }
  }
  
  static class a
    extends Handler
  {
    WeakReference<WatchTogetherFloatingView> aD;
    
    public a(WatchTogetherFloatingView paramWatchTogetherFloatingView)
    {
      this.aD = new WeakReference(paramWatchTogetherFloatingView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        sendEmptyMessageDelayed(2, 20000L);
        return;
        removeMessages(2);
        return;
        try
        {
          ((WatchTogetherFloatingView)this.aD.get()).dsw();
          return;
        }
        catch (NullPointerException paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.d("WatchTogetherFloatingView", 2, "MESSAGE_WAIT_LOADING END, but View missing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView
 * JD-Core Version:    0.7.0.1
 */