package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.qqmail.utilities.validate.ValidateHelper;

class SdcardFileExplorer$14
  extends PagerAdapter
{
  SdcardFileExplorer$14(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  private View getPageView(SdcardFileExplorer.FileExplorerPage paramFileExplorerPage)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (SdcardFileExplorer.15.$SwitchMap$com$tencent$qqmail$activity$sdcardfileexplorer$SdcardFileExplorer$FileExplorerPage[paramFileExplorerPage.ordinal()])
    {
    default: 
      return null;
    case 1: 
      if (SdcardFileExplorer.access$300(this.this$0) != null) {}
      for (;;)
      {
        ValidateHelper.assertInDebug("", bool1);
        if (SdcardFileExplorer.access$300(this.this$0) == null) {
          break;
        }
        return SdcardFileExplorer.access$300(this.this$0).getListView();
        bool1 = false;
      }
    }
    if (SdcardFileExplorer.access$100(this.this$0) != null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ValidateHelper.assertInDebug("", bool1);
      if (SdcardFileExplorer.access$100(this.this$0) == null) {
        break;
      }
      return SdcardFileExplorer.access$100(this.this$0).getListView();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return SdcardFileExplorer.FileExplorerPage.SIZE.ordinal();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = getPageView(SdcardFileExplorer.FileExplorerPage.from(paramInt));
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.14
 * JD-Core Version:    0.7.0.1
 */