package com.tencent.mobileqq.emosm.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;

public class SimpleFloatViewManager
  implements DragSortListView.FloatViewManager
{
  private int mFloatBGColor = -16777216;
  private Bitmap mFloatBitmap;
  private ImageView mImageView;
  private ListView mListView;
  
  public SimpleFloatViewManager(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public View onCreateFloatView(int paramInt)
  {
    View localView = this.mListView.getChildAt(this.mListView.getHeaderViewsCount() + paramInt - this.mListView.getFirstVisiblePosition());
    if (localView == null) {}
    do
    {
      return null;
      localView.setPressed(false);
      localView.setDrawingCacheEnabled(true);
    } while (localView.getDrawingCache() == null);
    this.mFloatBitmap = Bitmap.createBitmap(localView.getDrawingCache());
    localView.setDrawingCacheEnabled(false);
    if (this.mImageView == null) {
      this.mImageView = new ImageView(this.mListView.getContext());
    }
    this.mImageView.setBackgroundColor(this.mFloatBGColor);
    this.mImageView.setPadding(0, 0, 0, 0);
    this.mImageView.setImageBitmap(this.mFloatBitmap);
    this.mImageView.setLayoutParams(new ViewGroup.LayoutParams(localView.getWidth(), localView.getHeight()));
    return this.mImageView;
  }
  
  public void onDestroyFloatView(View paramView)
  {
    ((ImageView)paramView).setImageDrawable(null);
    this.mFloatBitmap.recycle();
    this.mFloatBitmap = null;
  }
  
  public void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2) {}
  
  public void setBackgroundColor(int paramInt)
  {
    this.mFloatBGColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.SimpleFloatViewManager
 * JD-Core Version:    0.7.0.1
 */