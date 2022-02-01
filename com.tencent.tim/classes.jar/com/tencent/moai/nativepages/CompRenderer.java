package com.tencent.moai.nativepages;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.moai.nativepages.component.AdLandingPageBaseComp;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class CompRenderer
{
  public static final String TAG = "CompRenderer";
  private int bgColor;
  private List<AdLandingPageComponentInfo> componentList;
  private ViewGroup container;
  private Context context;
  private LinkedHashMap<String, AdLandingPageBaseComp> pageComp;
  private int screenHeight;
  private int screenWidth;
  private LayoutInflater vi;
  
  public CompRenderer(List<AdLandingPageComponentInfo> paramList, Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    this.componentList = paramList;
    this.context = paramContext;
    this.bgColor = paramInt;
    this.container = paramViewGroup;
  }
  
  public Collection<AdLandingPageBaseComp> getAllComp()
  {
    if (this.pageComp == null) {
      return Collections.EMPTY_LIST;
    }
    return this.pageComp.values();
  }
  
  public void layout()
  {
    if ((this.componentList == null) || (this.componentList.isEmpty())) {
      return;
    }
    if (this.pageComp == null) {
      this.pageComp = new LinkedHashMap();
    }
    Object localObject;
    if (this.vi == null)
    {
      this.vi = ((LayoutInflater)this.context.getSystemService("layout_inflater"));
      localObject = (WindowManager)this.context.getSystemService("window");
      this.screenWidth = ((WindowManager)localObject).getDefaultDisplay().getWidth();
      this.screenHeight = ((WindowManager)localObject).getDefaultDisplay().getHeight();
    }
    int i = 0;
    while (i < this.componentList.size())
    {
      AdLandingPageComponentInfo localAdLandingPageComponentInfo = (AdLandingPageComponentInfo)this.componentList.get(i);
      localObject = (AdLandingPageBaseComp)this.pageComp.get(localAdLandingPageComponentInfo.cId);
      if (localObject != null) {
        ((AdLandingPageBaseComp)localObject).updateDataSet(localAdLandingPageComponentInfo);
      }
      try
      {
        label156:
        if (this.container != ((AdLandingPageBaseComp)localObject).getView().getParent())
        {
          if (this.container.getChildCount() <= i) {
            break label255;
          }
          this.container.addView(((AdLandingPageBaseComp)localObject).getView(), i);
        }
        for (;;)
        {
          i += 1;
          break;
          AdLandingPageBaseComp localAdLandingPageBaseComp = AdLandingPagesLayoutHelper.LayoutBaseComponent(this.context, localAdLandingPageComponentInfo, this.container, this.vi, this.screenWidth, this.screenHeight, this.bgColor);
          localObject = localAdLandingPageBaseComp;
          if (localAdLandingPageBaseComp == null) {
            break label156;
          }
          this.pageComp.put(localAdLandingPageComponentInfo.cId, localAdLandingPageBaseComp);
          localObject = localAdLandingPageBaseComp;
          break label156;
          label255:
          this.container.addView(((AdLandingPageBaseComp)localObject).getView());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void notify(List<AdLandingPageComponentInfo> paramList)
  {
    if ((paramList != null) && (!paramList.equals(this.componentList)))
    {
      this.componentList = paramList;
      layout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.CompRenderer
 * JD-Core Version:    0.7.0.1
 */