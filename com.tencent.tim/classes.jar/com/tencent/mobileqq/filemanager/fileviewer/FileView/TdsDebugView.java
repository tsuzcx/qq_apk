package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import acfp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.kwstudio.office.debug.Debugger.IDebugCallback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.lang.ref.WeakReference;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String bIZ = acfp.m(2131715134);
  private static final String bJa = acfp.m(2131715131);
  private static final String bJb = acfp.m(2131715128);
  private static final String bJc = acfp.m(2131715129);
  private static final String bJd = acfp.m(2131715127);
  private static final String bJe = acfp.m(2131715130);
  private static final String bJf = acfp.m(2131715133);
  private static final String bJg = acfp.m(2131715132);
  private static final String bJh = acfp.m(2131715135);
  private final c a;
  private boolean ceS;
  private boolean ceT;
  private boolean ceU;
  private final Handler mHandler;
  private TextView my;
  
  public TdsDebugView(Context paramContext, c paramc)
  {
    super(paramContext.getApplicationContext());
    this.a = paramc;
    this.mHandler = new Handler(Looper.getMainLooper(), new b(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131563176, this, true);
    this.my = ((TextView)paramContext.findViewById(2131379724));
    paramContext.findViewById(2131364637).setOnClickListener(this);
    paramContext.findViewById(2131368012).setOnClickListener(this);
    paramContext.findViewById(2131381306).setOnClickListener(this);
    paramContext.findViewById(2131364636).setOnClickListener(this);
    paramContext.findViewById(2131364677).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131379064);
    paramContext.setOnCheckedChangeListener(this);
    paramContext.setChecked(Debugger.isUserEnable("11"));
  }
  
  public static boolean mC(String paramString)
  {
    return (TextUtils.equals(paramString, "TdsDebug.xlsx")) && (TdsReaderGlobal.isEnable());
  }
  
  private void onCleanCache(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, "11")) {}
    do
    {
      return;
      this.ceU = false;
    } while (getVisibility() != 0);
    if (paramInt == 0) {}
    for (paramString = bJg;; paramString = bJh + paramInt)
    {
      setTips(paramString);
      return;
    }
  }
  
  private void onCleanPlugin(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, "11")) {}
    do
    {
      return;
      this.ceS = false;
    } while (getVisibility() != 0);
    if (paramInt == 0) {}
    for (paramString = bJa;; paramString = bJb + paramInt)
    {
      setTips(paramString);
      return;
    }
  }
  
  private void onUpgradePlugin(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, "11")) {}
    do
    {
      return;
      this.ceT = false;
    } while (getVisibility() != 0);
    if (paramInt == 0) {}
    for (paramString = bJd;; paramString = bJe + paramInt)
    {
      setTips(paramString);
      return;
    }
  }
  
  private void setTips(String paramString)
  {
    this.my.setText(paramString);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Debugger.setUserEnable("11", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364637)
    {
      setTips(bIZ);
      if (!this.ceS)
      {
        this.ceS = true;
        Debugger.cleanPlugin("11", new a(this, null));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131368012)
      {
        setTips(Debugger.getVersionInfo("11"));
      }
      else if (i == 2131381306)
      {
        setTips(bJc);
        if (!this.ceT)
        {
          this.ceT = true;
          Debugger.upgradePlugin("11", new a(this, null));
        }
      }
      else if (i == 2131364636)
      {
        setTips(bJf);
        if (!this.ceU)
        {
          this.ceU = true;
          Debugger.cleanCache("11", new a(this, null));
        }
      }
      else if ((i == 2131364677) && (this.a != null))
      {
        this.a.djn();
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      setTips("");
    }
  }
  
  static final class a
    implements Debugger.IDebugCallback
  {
    private final WeakReference<TdsDebugView> gS;
    
    private a(TdsDebugView paramTdsDebugView)
    {
      this.gS = new WeakReference(paramTdsDebugView);
    }
    
    public void onCleanCache(String paramString, int paramInt)
    {
      Log.d("TdsDebugView", "onCleanCache: m=" + paramString + ", r=" + paramInt);
      TdsDebugView localTdsDebugView = (TdsDebugView)this.gS.get();
      if (localTdsDebugView == null) {
        return;
      }
      Message.obtain(TdsDebugView.a(localTdsDebugView), 3, paramInt, 0, paramString).sendToTarget();
    }
    
    public void onCleanPlugin(String paramString, int paramInt)
    {
      Log.d("TdsDebugView", "onCleanPlugin: m=" + paramString + ", r=" + paramInt);
      TdsDebugView localTdsDebugView = (TdsDebugView)this.gS.get();
      if (localTdsDebugView == null) {
        return;
      }
      Message.obtain(TdsDebugView.a(localTdsDebugView), 1, paramInt, 0, paramString).sendToTarget();
    }
    
    public void onUpgradePlugin(String paramString, int paramInt)
    {
      Log.d("TdsDebugView", "onUpgradePlugin: m=" + paramString + ", r=" + paramInt);
      TdsDebugView localTdsDebugView = (TdsDebugView)this.gS.get();
      if (localTdsDebugView == null) {
        return;
      }
      Message.obtain(TdsDebugView.a(localTdsDebugView), 2, paramInt, 0, paramString).sendToTarget();
    }
  }
  
  static final class b
    implements Handler.Callback
  {
    private final WeakReference<TdsDebugView> gS;
    
    private b(TdsDebugView paramTdsDebugView)
    {
      this.gS = new WeakReference(paramTdsDebugView);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      TdsDebugView localTdsDebugView = (TdsDebugView)this.gS.get();
      if (localTdsDebugView == null) {
        return true;
      }
      switch (paramMessage.what)
      {
      default: 
        return true;
      case 1: 
        TdsDebugView.a(localTdsDebugView, (String)paramMessage.obj, paramMessage.arg1);
        return true;
      case 2: 
        TdsDebugView.b(localTdsDebugView, (String)paramMessage.obj, paramMessage.arg1);
        return true;
      }
      TdsDebugView.c(localTdsDebugView, (String)paramMessage.obj, paramMessage.arg1);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract void djn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsDebugView
 * JD-Core Version:    0.7.0.1
 */