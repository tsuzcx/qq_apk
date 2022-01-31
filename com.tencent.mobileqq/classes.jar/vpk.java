import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.DownloadGftData;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.Observable;
import java.util.Observer;

public abstract class vpk
  extends BaseBubbleBuilder.ViewHolder
  implements Observer
{
  public ViewGroup a;
  public Button a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private QQAppInterface a;
  public MessageForTroopGift a;
  public BubbleImageView a;
  public View b;
  public ViewGroup b;
  public Button b;
  public TextView b;
  public View c;
  public Button c;
  public Button d;
  
  public vpk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = (AIOAnimationControlManager.DownloadGftData)paramObject;
    if ((paramObservable.a.equals(TroopGiftUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading)) {
      this.c.post(new vpl(this, paramObservable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpk
 * JD-Core Version:    0.7.0.1
 */