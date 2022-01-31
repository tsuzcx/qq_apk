package android.support.v4.view;

import android.content.ClipData;
import android.support.annotation.RequiresApi;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.DragShadowBuilder;

@RequiresApi(24)
class ViewCompat$ViewCompatApi24Impl
  extends ViewCompat.ViewCompatApi23Impl
{
  public void cancelDragAndDrop(View paramView)
  {
    paramView.cancelDragAndDrop();
  }
  
  public void dispatchFinishTemporaryDetach(View paramView)
  {
    paramView.dispatchFinishTemporaryDetach();
  }
  
  public void dispatchStartTemporaryDetach(View paramView)
  {
    paramView.dispatchStartTemporaryDetach();
  }
  
  public void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat)
  {
    if (paramPointerIconCompat != null) {}
    for (paramPointerIconCompat = paramPointerIconCompat.getPointerIcon();; paramPointerIconCompat = null)
    {
      paramView.setPointerIcon((PointerIcon)paramPointerIconCompat);
      return;
    }
  }
  
  public boolean startDragAndDrop(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
  {
    return paramView.startDragAndDrop(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
  }
  
  public void updateDragShadow(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
  {
    paramView.updateDragShadow(paramDragShadowBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi24Impl
 * JD-Core Version:    0.7.0.1
 */