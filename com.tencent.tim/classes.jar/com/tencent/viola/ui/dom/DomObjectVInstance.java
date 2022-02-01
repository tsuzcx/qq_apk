package com.tencent.viola.ui.dom;

import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.List;

public class DomObjectVInstance
  extends DomObject
  implements DomObject.Consumer
{
  private ArrayMap<String, AppearEventRectangle> appearEventRectangleMap;
  
  private void initEvent(DomObject paramDomObject)
  {
    ArrayList localArrayList = paramDomObject.getEvents();
    if ((localArrayList.contains("willAppear")) || (localArrayList.contains("didAppear")) || (localArrayList.contains("didDisappear")))
    {
      if (this.appearEventRectangleMap == null) {
        this.appearEventRectangleMap = new ArrayMap();
      }
      this.appearEventRectangleMap.put(paramDomObject.getRef(), new AppearEventRectangle(paramDomObject));
    }
  }
  
  public void accept(DomObject paramDomObject)
  {
    initEvent(paramDomObject);
  }
  
  public ArrayMap<String, AppearEventRectangle> getAppearEventRectangleMap()
  {
    return this.appearEventRectangleMap;
  }
  
  public String getId()
  {
    return (String)getAttributes().get("id");
  }
  
  public void tryAddAppearEvents()
  {
    traverseTree(new DomObject.Consumer[] { this });
  }
  
  public static class AppearEventRectangle
  {
    DomObject dom;
    public int end;
    public int start;
    DomObjectCell.ComponentState state = DomObjectCell.ComponentState.DIDDISAPPEAR;
    
    AppearEventRectangle(DomObject paramDomObject)
    {
      this.dom = paramDomObject;
      initEvent(paramDomObject);
    }
    
    private void initEvent(DomObject paramDomObject)
    {
      if (paramDomObject == null) {
        return;
      }
      int i = 0;
      Object localObject = paramDomObject;
      DomObject localDomObject;
      do
      {
        if ((localObject instanceof DomObjectVInstance))
        {
          this.start = i;
          this.end = ((int)(this.start + paramDomObject.getLayoutHeight()));
          return;
        }
        i = (int)(i + ((DomObject)localObject).getLayoutY());
        localDomObject = ((DomObject)localObject).getDomParent();
        localObject = localDomObject;
      } while (localDomObject != null);
    }
    
    private void transformState(DomObjectCell.ComponentState paramComponentState)
    {
      this.state = paramComponentState;
    }
    
    public String getRef()
    {
      return this.dom.getRef();
    }
    
    public boolean hasEvent(String paramString)
    {
      return this.dom.getEvents().contains(paramString);
    }
    
    public boolean isDidAppearState()
    {
      return this.state == DomObjectCell.ComponentState.DIDAPPEAR;
    }
    
    public boolean isDidDisappearState()
    {
      return this.state == DomObjectCell.ComponentState.DIDDISAPPEAR;
    }
    
    public boolean isWillAppearState()
    {
      return this.state == DomObjectCell.ComponentState.WILLAPPEAR;
    }
    
    public void transformToDidAppearState()
    {
      transformState(DomObjectCell.ComponentState.DIDAPPEAR);
    }
    
    public void transformToDidDisappearState()
    {
      transformState(DomObjectCell.ComponentState.DIDDISAPPEAR);
    }
    
    public void transformToWillAppearState()
    {
      transformState(DomObjectCell.ComponentState.WILLAPPEAR);
    }
    
    public boolean wantDidAppear()
    {
      return hasEvent("didAppear");
    }
    
    public boolean wantDidDisAppear()
    {
      return hasEvent("didDisappear");
    }
    
    public boolean wantWillAppear()
    {
      return hasEvent("willAppear");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectVInstance
 * JD-Core Version:    0.7.0.1
 */