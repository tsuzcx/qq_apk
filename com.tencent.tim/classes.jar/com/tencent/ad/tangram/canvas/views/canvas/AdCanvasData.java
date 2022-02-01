package com.tencent.ad.tangram.canvas.views.canvas;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c;
import com.tencent.ad.tangram.log.AdLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Keep
public class AdCanvasData
  implements Serializable
{
  private static final String TAG = "AdCanvasData";
  public Ad ad;
  public ArrayList<c> appFixedButtonComponentDataList = new ArrayList();
  private boolean autodownload;
  public int basicWidth = -2147483648;
  public String commonPageId;
  public String firstPictureComponentIdWithHotArea = "";
  public ArrayList<com.tencent.ad.tangram.canvas.views.canvas.components.fixedbutton.a> fixedButtonComponentDataList = new ArrayList();
  public boolean hasFixedButtonData = false;
  public String id;
  public String name;
  public long pageId = -2147483648L;
  public String pageType;
  public String pageUrl;
  public List<com.tencent.ad.tangram.canvas.views.canvas.framework.a> pages;
  public String sourceId;
  public ArrayList<com.tencent.ad.tangram.canvas.views.canvas.components.button.a> webFixedButtonComponentDataList = new ArrayList();
  
  public boolean getAutoDownLoad()
  {
    if (isValid()) {
      return this.autodownload;
    }
    return false;
  }
  
  public com.tencent.ad.tangram.canvas.views.canvas.framework.a getPage(int paramInt)
  {
    if ((!isValid()) || (paramInt < 0) || (paramInt > getSize()))
    {
      AdLog.e("AdCanvasData", "getPage error");
      return null;
    }
    return (com.tencent.ad.tangram.canvas.views.canvas.framework.a)this.pages.get(paramInt);
  }
  
  public int getSize()
  {
    if (isValid()) {
      return this.pages.size();
    }
    return 0;
  }
  
  public int getSizeOfComponents()
  {
    if (!isValid()) {
      return 0;
    }
    Iterator localIterator = this.pages.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      com.tencent.ad.tangram.canvas.views.canvas.framework.a locala = (com.tencent.ad.tangram.canvas.views.canvas.framework.a)localIterator.next();
      if (locala != null) {}
      for (int j = locala.getSize();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    return i;
  }
  
  public int getToLoadIdsize()
  {
    if (!isValid()) {
      return 0;
    }
    Iterator localIterator = this.pages.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      com.tencent.ad.tangram.canvas.views.canvas.framework.a locala = (com.tencent.ad.tangram.canvas.views.canvas.framework.a)localIterator.next();
      if (locala != null) {}
      for (int j = locala.getToLoadIdSize();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    return i;
  }
  
  public boolean isPageWithoutButton()
  {
    int j;
    if ((getPage(0) != null) && (getPage(0).components != null)) {
      if (getPage(0).components.size() == 0) {
        j = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) && (this.fixedButtonComponentDataList.size() == 0) && (this.webFixedButtonComponentDataList.size() == 0) && (this.appFixedButtonComponentDataList.size() == 0))
      {
        return true;
        Iterator localIterator = getPage(0).components.iterator();
        int i = 1;
        j = i;
        if (!localIterator.hasNext()) {
          continue;
        }
        if (!((AdCanvasComponentData)localIterator.next() instanceof com.tencent.ad.tangram.canvas.views.canvas.components.button.a)) {
          break label122;
        }
        i = 0;
      }
      label122:
      for (;;)
      {
        break;
        return false;
      }
      j = 1;
    }
  }
  
  public boolean isValid()
  {
    return (this.ad != null) && (this.basicWidth > 0) && (this.pages != null);
  }
  
  public void setAutodownload(boolean paramBoolean)
  {
    this.autodownload = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData
 * JD-Core Version:    0.7.0.1
 */