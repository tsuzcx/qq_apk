package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import java.lang.ref.WeakReference;

public class PageInfo
{
  private WeakReference<Object> mPage;
  private WeakReference<View> mPageView;
  
  PageInfo(@NonNull Object paramObject, @NonNull View paramView)
  {
    this.mPage = new WeakReference(paramObject);
    this.mPageView = new WeakReference(paramView);
  }
  
  @Nullable
  public Object getPage()
  {
    return this.mPage.get();
  }
  
  @Nullable
  public View getPageView()
  {
    return (View)this.mPageView.get();
  }
  
  public String toString()
  {
    Object localObject3 = this.mPage.get();
    Object localObject1;
    String str;
    if (localObject3 == null)
    {
      localObject1 = "_null_page_";
      if (localObject3 != null) {
        break label132;
      }
      str = "_null_page_";
      label25:
      if (localObject3 != null) {
        break label141;
      }
      localObject2 = null;
      label32:
      if (localObject2 != null) {
        break label150;
      }
    }
    label132:
    label141:
    label150:
    for (Object localObject2 = "_null_params_";; localObject2 = localObject2.toString())
    {
      localObject1 = new StringBuilder().append("pageId = ").append((String)localObject1).append(", contentId = ").append(str).append(", pageParams = ").append((String)localObject2).append(", page = ");
      if (localObject3 != this.mPageView.get()) {
        ((StringBuilder)localObject1).append(localObject3).append(", ");
      }
      return "pageView = " + this.mPageView.get();
      localObject1 = DataRWProxy.getPageId(localObject3);
      break;
      str = DataRWProxy.getContentId(localObject3);
      break label25;
      localObject2 = DataRWProxy.getPageParams(localObject3);
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageInfo
 * JD-Core Version:    0.7.0.1
 */