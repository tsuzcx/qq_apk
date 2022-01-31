import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAGameItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bwy
  implements View.OnClickListener
{
  public bwy(PAGameItemBuilder paramPAGameItemBuilder) {}
  
  public void onClick(View paramView)
  {
    bxa localbxa = (bxa)paramView.getTag();
    paramView = AIOUtils.a(paramView);
    if ((localbxa == null) || (!(paramView instanceof MessageForPubAccount))) {
      if (QLog.isColorLevel()) {
        QLog.d(ChatItemBuilder.a, 2, "PAGameItemBuilder onClickListener holder = " + localbxa + ", msg = " + paramView);
      }
    }
    do
    {
      return;
      paramView = (MessageForPubAccount)paramView;
      if ((paramView.mPAMessage != null) && (paramView.mPAMessage.items != null) && (!paramView.mPAMessage.items.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(ChatItemBuilder.a, 2, "PAGameItemBuilder onClickListener mPAMessage or items is empty !");
    return;
    PASingleItemBuilder.a(PAGameItemBuilder.a(this.a), PAGameItemBuilder.a(this.a), localbxa.a, localbxa.b, localbxa.c, PAGameItemBuilder.a(this.a).a, PAGameItemBuilder.b(this.a).d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwy
 * JD-Core Version:    0.7.0.1
 */