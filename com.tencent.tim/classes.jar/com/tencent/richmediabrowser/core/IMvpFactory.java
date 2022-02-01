package com.tencent.richmediabrowser.core;

import android.app.Activity;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BaseView;

public abstract interface IMvpFactory
{
  public abstract BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter);
  
  public abstract BasePresenter createPresenter(int paramInt);
  
  public abstract BaseView createView(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.IMvpFactory
 * JD-Core Version:    0.7.0.1
 */