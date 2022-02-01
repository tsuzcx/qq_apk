package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.moai.nativepages.CompRenderer;
import com.tencent.moai.nativepages.model.AdLandingPageComponentFrameLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdLandingPageFrameLayout
  extends AdLandingPageBaseComp
{
  private List<AdLandingPageBaseComp> children = new ArrayList();
  private CompRenderer renderer;
  
  public AdLandingPageFrameLayout(Context paramContext, AdLandingPageComponentFrameLayoutInfo paramAdLandingPageComponentFrameLayoutInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentFrameLayoutInfo, paramViewGroup);
  }
  
  protected View customLayout()
  {
    return new FrameLayout(this.context);
  }
  
  protected void fillItem()
  {
    if (this.renderer == null)
    {
      this.renderer = new CompRenderer(getInfo().children, this.context, 0, (FrameLayout)this.contentView);
      this.renderer.layout();
      return;
    }
    this.renderer.notify(getInfo().children);
  }
  
  public AdLandingPageComponentFrameLayoutInfo getInfo()
  {
    return (AdLandingPageComponentFrameLayoutInfo)this.adLandingPageComponentInfo;
  }
  
  public void viewAppeared(int paramInt1, int paramInt2, int paramInt3)
  {
    super.viewAppeared(paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext()) {
      ((AdLandingPageBaseComp)localIterator.next()).viewAppeared(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void viewWillAppear()
  {
    super.viewWillAppear();
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext()) {
      ((AdLandingPageBaseComp)localIterator.next()).viewWillAppear();
    }
  }
  
  public void viewWillDestroy()
  {
    super.viewWillDestroy();
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext()) {
      ((AdLandingPageBaseComp)localIterator.next()).viewWillDestroy();
    }
  }
  
  public void viewWillDisappear()
  {
    super.viewWillDisappear();
    Iterator localIterator = this.children.iterator();
    while (localIterator.hasNext()) {
      ((AdLandingPageBaseComp)localIterator.next()).viewWillDisappear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageFrameLayout
 * JD-Core Version:    0.7.0.1
 */