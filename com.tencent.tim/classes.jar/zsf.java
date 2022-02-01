import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.b;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.b.a;
import com.tencent.widget.AbsListView.g;

public class zsf
  implements AbsListView.g
{
  public zsf(QzonePhotoPreviewActivity.b paramb) {}
  
  public void onMovedToScrapHeap(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof QzonePhotoPreviewActivity.b.a))) {
      ((QzonePhotoPreviewActivity.b.a)paramView).I.setImageDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsf
 * JD-Core Version:    0.7.0.1
 */