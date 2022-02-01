package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class PageInfoCacheController
{
  private static final String TAG = "PageInfoCacheController";
  private WeakHashMap<Context, Set<View>> mAttachedPageStore = new WeakHashMap();
  private Set<View> mUnattachedPageStore = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  
  private void addToAttachedPageStore(View paramView, Context paramContext)
  {
    Set localSet2 = (Set)this.mAttachedPageStore.get(paramContext);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = Collections.newSetFromMap(new WeakHashMap());
      this.mAttachedPageStore.put(paramContext, localSet1);
    }
    localSet1.add(paramView);
    Log.d("PageInfoCacheController", "view = " + paramView + ", context = " + paramContext);
  }
  
  private void addToUnattachedStore(View paramView)
  {
    this.mUnattachedPageStore.add(paramView);
  }
  
  private Context getRefContext(Object paramObject, View paramView)
  {
    if (((paramObject instanceof View)) && (!ViewCompatUtils.isAttachedToWindow((View)paramObject))) {}
    while (paramView == null) {
      return null;
    }
    return paramView.getRootView().getContext();
  }
  
  private View getRefView(Object paramObject)
  {
    if ((paramObject instanceof View)) {
      return (View)paramObject;
    }
    if ((paramObject instanceof Activity)) {
      return ((Activity)paramObject).getWindow().getDecorView();
    }
    if (((paramObject instanceof Dialog)) && (((Dialog)paramObject).getWindow() != null)) {
      return ((Dialog)paramObject).getWindow().getDecorView();
    }
    return null;
  }
  
  private void tryTransferToAttachedStore()
  {
    Iterator localIterator = this.mUnattachedPageStore.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      Context localContext = getRefContext(localView, localView);
      if (localContext != null)
      {
        addToAttachedPageStore(localView, localContext);
        localIterator.remove();
      }
    }
  }
  
  public void appendPageStore(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    View localView = getRefView(paramObject);
    Context localContext = getRefContext(paramObject, localView);
    if (localContext == null)
    {
      addToUnattachedStore((View)paramObject);
      return;
    }
    addToAttachedPageStore(localView, localContext);
  }
  
  public Set<View> getPageStore(@NonNull Context paramContext)
  {
    tryTransferToAttachedStore();
    return (Set)this.mAttachedPageStore.get(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageInfoCacheController
 * JD-Core Version:    0.7.0.1
 */