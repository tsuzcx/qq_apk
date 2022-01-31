import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagView;

public class udr
  implements DialogInterface.OnClickListener
{
  public udr(QCircleFollowTagView paramQCircleFollowTagView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(false);
    if (QCircleFollowTagView.a(this.a) != null) {
      QCircleFollowTagView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udr
 * JD-Core Version:    0.7.0.1
 */