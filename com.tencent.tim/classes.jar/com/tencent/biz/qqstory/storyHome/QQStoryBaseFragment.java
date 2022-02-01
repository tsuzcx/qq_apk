package com.tencent.biz.qqstory.storyHome;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import pmi;

public abstract class QQStoryBaseFragment
  extends IphoneTitleBarFragment
  implements IEventReceiver
{
  protected final boolean DEBUG = false;
  protected ProgressView a;
  protected boolean aEN;
  protected Map<Subscriber, String> fY = new HashMap();
  protected Dialog g;
  public AppInterface mApp;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  
  public <T extends View> T $(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected void O(@NonNull Map<Subscriber, String> paramMap) {}
  
  public void bpm()
  {
    if (this.g != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(new QQStoryBaseFragment.3(this));
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    O((Map)localObject1);
    this.fY.clear();
    this.fY.putAll((Map)localObject1);
    localObject1 = this.fY.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      pmi.a().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.aEN = true;
    QQStoryContext.a();
    this.mApp = QQStoryContext.c();
    Bosses.get().postLightWeightJob(new QQStoryBaseFragment.1(this), 10);
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
      this.rightViewText.setContentDescription(this.rightViewText.getText() + acfp.m(2131712204));
    }
  }
  
  public boolean isFinishing()
  {
    return (getActivity() != null) && (getActivity().isFinishing());
  }
  
  public boolean isValidate()
  {
    return (this.aEN) && (!isFinishing());
  }
  
  public void onDestroyView()
  {
    bpm();
    this.aEN = false;
    Iterator localIterator = this.fY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      pmi.a().unRegisterSubscriber(localSubscriber);
    }
    super.onDestroyView();
  }
  
  public void onStop()
  {
    this.mHandler.removeCallbacks(null);
    super.onStop();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */