package com.tencent.biz.qqstory.storyHome;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import com.tribe.async.dispatch.Subscriber.SubscriberWrapper;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import pmb;
import pmi;
import pso;
import psx;
import ptb;
import qqq;
import ram;
import rar;
import rop.b;

public class QQStoryBaseActivity
  extends IphoneTitleBarActivity
  implements IEventReceiver
{
  protected final boolean DEBUG = false;
  private long[] P = new long[4];
  public final String TAG = "Q.qqstory.QQStoryBaseActivity";
  protected ProgressView a;
  private pso a;
  protected boolean aEM = true;
  protected boolean aEN;
  protected Bitmap cu;
  protected int[] dN;
  protected Map<Subscriber, String> fY = new HashMap();
  protected Dialog g;
  public AppInterface mApp;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  public ImageView mW;
  Animation.AnimationListener p = new qqq(this);
  
  private void aY(Intent paramIntent)
  {
    if (paramIntent == null) {}
    pmb localpmb;
    SoftReference localSoftReference;
    do
    {
      do
      {
        int i;
        int j;
        int k;
        int m;
        do
        {
          return;
          i = paramIntent.getIntExtra("positionX", 0);
          j = paramIntent.getIntExtra("positionY", 0);
          k = paramIntent.getIntExtra("viewWidth", -1);
          m = paramIntent.getIntExtra("viewHeight", -1);
          this.aEM = paramIntent.getBooleanExtra("need_image_animation", true);
          paramIntent = paramIntent.getStringExtra("viewImageKey");
        } while ((k < 0) || (m < 0));
        this.dN = new int[4];
        this.dN[0] = i;
        this.dN[1] = j;
        this.dN[2] = k;
        this.dN[3] = m;
      } while (TextUtils.isEmpty(paramIntent));
      localpmb = (pmb)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(181);
      localSoftReference = (SoftReference)localpmb.bF.get(paramIntent);
    } while ((localSoftReference == null) || (localSoftReference.get() == null));
    this.cu = ((Bitmap)localSoftReference.get());
    localpmb.bF.remove(paramIntent);
  }
  
  private boolean eI(int paramInt)
  {
    long l = SystemClock.elapsedRealtime() - this.P[paramInt];
    if (l < 1000L)
    {
      ram.w("Q.qqstory.QQStoryBaseActivity", "startActivity fail, open twice take time:%d", new Object[] { Long.valueOf(l) });
      return true;
    }
    this.P[paramInt] = SystemClock.elapsedRealtime();
    return false;
  }
  
  public <T extends View> T $(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public <T extends ViewGroup.LayoutParams> T $lp(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  protected void O(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new Subscriber.SubscriberWrapper(Looper.getMainLooper(), new a(this)), "root_group");
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    a(paramCharSequence, paramBoolean, paramLong, null);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.postDelayed(new QQStoryBaseActivity.2(this, this, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  protected void bpG()
  {
    ram.d("Q.qqstory.QQStoryBaseActivity", "onOutOfMemory");
  }
  
  public void bpm()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.post(new QQStoryBaseActivity.3(this));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    rR("onActivityResult");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    O((Map)localObject1);
    this.fY.clear();
    this.fY.putAll((Map)localObject1);
    rQ("register subscriber size : " + this.fY.size());
    localObject1 = this.fY.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      pmi.a().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreate(paramBundle);
    rR("onCreate");
    this.aEN = true;
    this.a = ((pso)psx.a(18));
    this.a.a(this);
    QQStoryContext.a();
    this.mApp = QQStoryContext.c();
    Bosses.get().postLightWeightJob(new QQStoryBaseActivity.1(this), 10);
    ((ptb)psx.a(26)).vV(0);
    aY(getIntent());
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    rR("onDestroy");
    this.aEN = false;
    this.a.b(this);
    rQ("unregister subscriber size : " + this.fY.size());
    Iterator localIterator = this.fY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      pmi.a().unRegisterSubscriber(localSubscriber);
    }
    if ((this.cu != null) && (!this.cu.isRecycled()))
    {
      this.cu.recycle();
      this.cu = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    rar.d(rar.a(getClass(), 0), this.currentActivityStayTime, getActivityName());
    rR("onPause");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    rR("onResume");
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    rR("onStart");
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    rR("onStop");
    this.mHandler.removeCallbacks(null);
  }
  
  public void e(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.enableTalkBack) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + acfp.m(2131712209));
    }
  }
  
  public void f(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void g(CharSequence paramCharSequence)
  {
    a(paramCharSequence, true, 0L);
  }
  
  public boolean isValidate()
  {
    return (this.aEN) && (!isFinishing());
  }
  
  protected void rQ(String paramString) {}
  
  protected void rR(String paramString) {}
  
  public void startActivity(Intent paramIntent)
  {
    if (eI(0)) {
      return;
    }
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (eI(1)) {
      return;
    }
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (eI(2)) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (eI(3)) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void wt(int paramInt)
  {
    a(getString(paramInt), true, 0L);
  }
  
  static class ProgressView
    extends FrameLayout
  {
    private ProgressBar mProgressBar;
    private TextView nM;
    
    public ProgressView(Context paramContext)
    {
      super();
      init(paramContext);
    }
    
    public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init(paramContext);
    }
    
    private void init(Context paramContext)
    {
      LayoutInflater.from(paramContext).inflate(2131562047, this);
      this.mProgressBar = ((ProgressBar)findViewById(2131373659));
      this.nM = ((TextView)findViewById(2131379401));
    }
    
    public void setProgressText(CharSequence paramCharSequence)
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
      {
        this.nM.setVisibility(8);
        return;
      }
      this.nM.setVisibility(0);
      this.nM.setText(paramCharSequence);
    }
  }
  
  class a
    implements Subscriber
  {
    private WeakReference<QQStoryBaseActivity> activityRef;
    
    public a(QQStoryBaseActivity paramQQStoryBaseActivity)
    {
      this.activityRef = new WeakReference(paramQQStoryBaseActivity);
    }
    
    public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
    {
      paramList.add(rop.b.class);
    }
    
    public void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
    {
      paramDispatchable = (QQStoryBaseActivity)this.activityRef.get();
      if (paramDispatchable != null) {
        paramDispatchable.bpG();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity
 * JD-Core Version:    0.7.0.1
 */