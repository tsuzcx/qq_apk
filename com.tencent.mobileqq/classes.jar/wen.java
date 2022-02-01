import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class wen
  implements RecyclerView.OnChildAttachStateChangeListener
{
  wen(wef paramwef) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (wdx)wef.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == wef.a(this.a)))
    {
      paramView.b();
      yqp.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (wdx)wef.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == wef.a(this.a)))
    {
      paramView.c();
      yqp.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wen
 * JD-Core Version:    0.7.0.1
 */