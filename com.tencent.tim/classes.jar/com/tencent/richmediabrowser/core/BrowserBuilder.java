package com.tencent.richmediabrowser.core;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BaseView;

public class BrowserBuilder
  implements IBrowserBuilder
{
  private static final String TAG = "BrowserBuilder";
  private Activity mActivity;
  private int mType;
  private BrowserBaseModel model;
  private BasePresenter presenter;
  private BasePresenter relyPresenter;
  private BaseView view;
  
  public BrowserBuilder(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mType = paramInt;
  }
  
  public void buildComplete()
  {
    if (this.presenter != null) {
      this.presenter.buildComplete();
    }
    if (this.view != null) {
      this.view.buildComplete();
    }
    if (this.model != null) {
      this.model.buildComplete();
    }
  }
  
  public void buildModel()
  {
    if (this.model != null) {
      this.model.buildModel();
    }
  }
  
  public void buildParams(Intent paramIntent)
  {
    if (this.presenter != null) {
      this.presenter.buildParams(paramIntent);
    }
    if (this.view != null) {
      this.view.buildParams(paramIntent);
    }
    if (this.model != null) {
      this.model.buildParams(paramIntent);
    }
  }
  
  public void buildPresenter()
  {
    MVPFactory localMVPFactory = new MVPFactory();
    this.presenter = localMVPFactory.createPresenter(this.mType);
    if (this.presenter == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserBuilder", 4, "buildPresenter presenter is null!");
      return;
    }
    this.presenter.setRelyPresenter(this.relyPresenter);
    this.view = localMVPFactory.createView(this.mActivity, this.mType, this.presenter);
    this.presenter.setGalleryView(this.view);
    this.model = localMVPFactory.createModel(this.mType, this.presenter);
    this.presenter.setGalleryModel(this.model);
    this.presenter.buildPresenter();
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    if (this.view != null) {
      this.view.buildView(paramViewGroup);
    }
  }
  
  public BasePresenter getPresenter()
  {
    return this.presenter;
  }
  
  public void onDestroy()
  {
    if (this.presenter != null) {
      this.presenter.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.presenter != null) {
      this.presenter.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.presenter != null) {
      this.presenter.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.presenter != null) {
      this.presenter.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.presenter != null) {
      this.presenter.onStop();
    }
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    this.relyPresenter = paramBasePresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.BrowserBuilder
 * JD-Core Version:    0.7.0.1
 */