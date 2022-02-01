package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.android.FragmentCompatUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

final class ViewGroupDescriptor
  extends AbstractChainedDescriptor<ViewGroup>
{
  private final Map<View, Object> mViewToElementMap = Collections.synchronizedMap(new WeakHashMap());
  
  private Object getElement(View paramView, Object paramObject)
  {
    if (paramObject == this) {
      return paramView;
    }
    return ((WeakReference)paramObject).get();
  }
  
  private Object getElementForView(ViewGroup paramViewGroup, View paramView)
  {
    Object localObject = this.mViewToElementMap.get(paramView);
    if (localObject != null)
    {
      localObject = getElement(paramView, localObject);
      if ((localObject != null) && (paramView.getParent() == paramViewGroup)) {
        return localObject;
      }
      this.mViewToElementMap.remove(paramView);
    }
    paramViewGroup = FragmentCompatUtil.findFragmentForView(paramView);
    if ((paramViewGroup != null) && (!FragmentCompatUtil.isDialogFragment(paramViewGroup)))
    {
      this.mViewToElementMap.put(paramView, new WeakReference(paramViewGroup));
      return paramViewGroup;
    }
    this.mViewToElementMap.put(paramView, this);
    return paramView;
  }
  
  private boolean isChildVisible(View paramView)
  {
    return !(paramView instanceof DocumentHiddenView);
  }
  
  protected void onGetChildren(ViewGroup paramViewGroup, Accumulator<Object> paramAccumulator)
  {
    int i = 0;
    int j = paramViewGroup.getChildCount();
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if (isChildVisible(localView)) {
        paramAccumulator.store(getElementForView(paramViewGroup, localView));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ViewGroupDescriptor
 * JD-Core Version:    0.7.0.1
 */