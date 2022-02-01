package com.tencent.qqmail.bottle.view;

import android.graphics.Bitmap;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.qqmail.utilities.ui.InsertionListView.OnRowAdditionAnimationListener;

public class BottleListViewInsertAnimation
{
  private static final int NEW_ROW_DURATION = 200;
  private static final String TAG = BottleListViewInsertAnimation.class.getSimpleName();
  private ImageView mImageView;
  private ListView mListView;
  private InsertionListView.OnRowAdditionAnimationListener mRowAdditionAnimationListener;
  
  public BottleListViewInsertAnimation(ListView paramListView, Adapter paramAdapter, ImageView paramImageView)
  {
    this.mListView = paramListView;
    this.mImageView = paramImageView;
  }
  
  private void prepareListViewBitmap()
  {
    this.mListView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(this.mListView.getDrawingCache());
    this.mListView.setDrawingCacheEnabled(false);
    this.mImageView.setImageBitmap(localBitmap);
    this.mImageView.setVisibility(0);
  }
  
  public void prepareAnimation()
  {
    prepareListViewBitmap();
  }
  
  public void setRowAdditionAnimationListener(InsertionListView.OnRowAdditionAnimationListener paramOnRowAdditionAnimationListener)
  {
    this.mRowAdditionAnimationListener = paramOnRowAdditionAnimationListener;
  }
  
  public void startAnimation()
  {
    ViewTreeObserver localViewTreeObserver = this.mListView.getViewTreeObserver();
    localViewTreeObserver.addOnPreDrawListener(new BottleListViewInsertAnimation.1(this, localViewTreeObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleListViewInsertAnimation
 * JD-Core Version:    0.7.0.1
 */