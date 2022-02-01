package com.tencent.richmediabrowser.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.progress.AbstractProgressView;

public class BrowserBaseAdapter
  extends BaseAdapter
{
  BasePresenter basePresenter;
  private AbstractProgressView progressView;
  
  private AbstractProgressView getProgressView(int paramInt)
  {
    if ((this.basePresenter != null) && (this.basePresenter.baseModel != null) && (paramInt == this.basePresenter.baseModel.getSelectedIndex())) {
      return this.progressView;
    }
    return null;
  }
  
  public BasePresenter getBasePresenter()
  {
    return this.basePresenter;
  }
  
  public int getCount()
  {
    if ((this.basePresenter == null) || (this.basePresenter.baseModel == null)) {
      return 0;
    }
    return this.basePresenter.baseModel.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.basePresenter == null) || (this.basePresenter.baseModel == null)) {
      return null;
    }
    return this.basePresenter.baseModel.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.stop();
    }
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt1);
    if ((localAbstractProgressView != null) && (localAbstractProgressView.isShow())) {
      localAbstractProgressView.start(paramInt2);
    }
  }
  
  public void onLoadProgressUpdate(View paramView, int paramInt) {}
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = getProgressView(paramInt1);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.start(paramInt2);
    }
  }
  
  public void setPresenter(BasePresenter paramBasePresenter)
  {
    this.basePresenter = paramBasePresenter;
  }
  
  public void setProgressView(AbstractProgressView paramAbstractProgressView)
  {
    this.progressView = paramAbstractProgressView;
  }
  
  public static class URLImageView2
    extends URLImageView
  {
    public boolean ignoreLayout = false;
    public URLDrawable mDecoding;
    
    public URLImageView2(Context paramContext)
    {
      super();
    }
    
    public URLImageView2(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public void destory()
    {
      setDecodingDrawble(null);
      setImageDrawable(null);
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      if (paramURLDrawable == this.mDecoding)
      {
        setImageDrawable(this.mDecoding);
        return;
      }
      super.onLoadFialed(paramURLDrawable, paramThrowable);
    }
    
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      if (paramURLDrawable == this.mDecoding)
      {
        Drawable localDrawable = getDrawable();
        if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
        {
          this.ignoreLayout = true;
          setImageDrawable(this.mDecoding);
          this.ignoreLayout = false;
          return;
        }
        setImageDrawable(this.mDecoding);
        return;
      }
      super.onLoadSuccessed(paramURLDrawable);
    }
    
    public void requestLayout()
    {
      if (!this.ignoreLayout) {
        super.requestLayout();
      }
    }
    
    public void setDecodingDrawble(URLDrawable paramURLDrawable)
    {
      if (this.mDecoding != null) {
        this.mDecoding.setURLDrawableListener(null);
      }
      paramURLDrawable.setURLDrawableListener(this);
      this.mDecoding = paramURLDrawable;
    }
    
    public void setImageDrawable(Drawable paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      if (this.mDecoding != null)
      {
        this.mDecoding.setURLDrawableListener(null);
        this.mDecoding = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseAdapter
 * JD-Core Version:    0.7.0.1
 */