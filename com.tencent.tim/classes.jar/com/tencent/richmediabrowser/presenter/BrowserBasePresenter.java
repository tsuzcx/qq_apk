package com.tencent.richmediabrowser.presenter;

import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.page.Gallery;
import java.util.concurrent.ConcurrentHashMap;

public class BrowserBasePresenter
  extends BasePresenter
  implements IDownloadEventListener, IGalleryImageListener
{
  public BrowserBaseView browserBaseView;
  public ConcurrentHashMap<Integer, URLDrawable> mActiveDrawable = new ConcurrentHashMap();
  public MainBrowserPresenter mainBrowserPresenter;
  
  public void back()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.back();
    }
  }
  
  public RelativeLayout getContentView()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.getContentView();
    }
    return null;
  }
  
  public int getCount()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getCount();
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (this.mainBrowserPresenter != null) {
      return this.mainBrowserPresenter.getCurrentPosition();
    }
    return -1;
  }
  
  public Gallery getGallery()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.mGallery;
    }
    return null;
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.getItem(paramInt);
    }
    return null;
  }
  
  public RelativeLayout getRootView()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.mRoot;
    }
    return null;
  }
  
  public int getSelectedIndex()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getSelectedIndex();
    }
    return 0;
  }
  
  public RichMediaBrowserInfo getSelectedItem()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getSelectedItem();
    }
    return null;
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.notifyDataSetChanged();
    }
  }
  
  public void notifyProgress(String paramString, int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItemProgress(paramString, paramInt);
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItemStatus(paramString, paramInt);
    }
  }
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      this.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.onLoadFinish(paramInt, paramBoolean);
    }
  }
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.onLoadStart(paramInt1, paramInt2);
    }
  }
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.onLoadSuccessed(paramInt, paramBoolean);
    }
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof BrowserBaseView)) {
      this.browserBaseView = ((BrowserBaseView)paramBaseView);
    }
  }
  
  public void setMainBrowserPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    if ((paramBasePresenter instanceof MainBrowserPresenter)) {
      setMainBrowserPresenter((MainBrowserPresenter)paramBasePresenter);
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.showContentView(paramBoolean);
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItem(paramRichMediaBrowserInfo);
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo, int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItem(paramRichMediaBrowserInfo, paramInt);
    }
  }
  
  public void updateSystemUIVisablity()
  {
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.updateSystemUIVisablity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.BrowserBasePresenter
 * JD-Core Version:    0.7.0.1
 */