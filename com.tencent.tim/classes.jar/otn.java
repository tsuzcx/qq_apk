import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity;
import com.tencent.qphone.base.util.QLog;

public class otn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public otn(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void onGlobalLayout()
  {
    int i = PublicAccountImageCollectionCommentActivity.a(this.a).getRootView().getHeight() - PublicAccountImageCollectionCommentActivity.a(this.a).getHeight();
    if (QLog.isDevelopLevel()) {
      QLog.d("ImageCollectionCommentActivity", 2, "heightDiff:" + i);
    }
    if (i > 150) {
      PublicAccountImageCollectionCommentActivity.a(this.a, true);
    }
    while (!PublicAccountImageCollectionCommentActivity.a(this.a)) {
      return;
    }
    PublicAccountImageCollectionCommentActivity.a(this.a, false);
    PublicAccountImageCollectionCommentActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otn
 * JD-Core Version:    0.7.0.1
 */