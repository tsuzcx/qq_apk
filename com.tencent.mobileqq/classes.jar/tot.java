import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity;

public class tot
  implements TextView.OnEditorActionListener
{
  public tot(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.getKeyCode() == 66;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tot
 * JD-Core Version:    0.7.0.1
 */