import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class ugs
  implements RecyclerView.OnChildAttachStateChangeListener
{
  ugs(ugk paramugk) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (ugc)ugk.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == ugk.a(this.a)))
    {
      paramView.b();
      wsv.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (ugc)ugk.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == ugk.a(this.a)))
    {
      paramView.c();
      wsv.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugs
 * JD-Core Version:    0.7.0.1
 */