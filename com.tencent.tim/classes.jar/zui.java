import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zui
  implements View.OnClickListener
{
  zui(zug paramzug) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.this$0.mActivity).flashPicCb.toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zui
 * JD-Core Version:    0.7.0.1
 */