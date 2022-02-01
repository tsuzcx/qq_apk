import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class wii
  implements RecyclerView.OnChildAttachStateChangeListener
{
  wii(wia paramwia) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (whs)wia.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == wia.a(this.a)))
    {
      paramView.b();
      yuk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (whs)wia.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == wia.a(this.a)))
    {
      paramView.c();
      yuk.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wii
 * JD-Core Version:    0.7.0.1
 */