package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import awkj;
import java.lang.ref.WeakReference;

class MsgPhotoView$WeakVipResourcesListener$1
  implements Runnable
{
  MsgPhotoView$WeakVipResourcesListener$1(MsgPhotoView.a parama, Drawable paramDrawable) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)MsgPhotoView.a.a(this.this$0).get();
    if ((localImageView != null) && (this.val$drawable != null))
    {
      localImageView.setImageDrawable(this.val$drawable);
      localImageView.setVisibility(0);
      if (!MsgPhotoView.a.a(this.this$0)) {
        if (MsgPhotoView.a.a(this.this$0) != 2) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 11;; i = 10)
    {
      awkj.lm(i, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.WeakVipResourcesListener.1
 * JD-Core Version:    0.7.0.1
 */