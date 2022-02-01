import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class plp
  implements RecyclerView.OnChildAttachStateChangeListener
{
  plp(plh paramplh) {}
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (plc)plh.a(this.this$0).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == plh.a(this.this$0)))
    {
      paramView.startPlay();
      ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (plc)plh.a(this.this$0).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == plh.a(this.this$0)))
    {
      paramView.stopPlay();
      ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plp
 * JD-Core Version:    0.7.0.1
 */