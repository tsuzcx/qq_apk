import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class ulb
  implements RecyclerView.OnChildAttachStateChangeListener
{
  ulb(ukt paramukt) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (ukl)ukt.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == ukt.a(this.a)))
    {
      paramView.b();
      wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (ukl)ukt.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == ukt.a(this.a)))
    {
      paramView.c();
      wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ulb
 * JD-Core Version:    0.7.0.1
 */