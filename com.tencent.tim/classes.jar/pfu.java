import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagView.b;

public class pfu
  implements DialogInterface.OnClickListener
{
  public pfu(QCircleFollowTagView paramQCircleFollowTagView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.ru(false);
    if (QCircleFollowTagView.a(this.a) != null) {
      QCircleFollowTagView.a(this.a).bky();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfu
 * JD-Core Version:    0.7.0.1
 */