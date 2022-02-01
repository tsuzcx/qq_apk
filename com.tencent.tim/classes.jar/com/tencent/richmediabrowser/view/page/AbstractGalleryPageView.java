package com.tencent.richmediabrowser.view.page;

import android.content.Context;
import com.tencent.richmediabrowser.view.BrowserBaseScene;

public abstract class AbstractGalleryPageView
{
  public abstract void init(Context paramContext, BrowserBaseScene paramBrowserBaseScene, int paramInt);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void startPageAnimation(AdapterView paramAdapterView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.AbstractGalleryPageView
 * JD-Core Version:    0.7.0.1
 */