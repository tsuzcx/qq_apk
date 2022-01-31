import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAGameItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bwb
  implements View.OnClickListener
{
  public bwb(PAGameItemBuilder paramPAGameItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - PAGameItemBuilder.a(this.a)) < 1000L) {}
    bwc localbwc;
    do
    {
      do
      {
        do
        {
          return;
          PAGameItemBuilder.a(this.a, l);
          localbwc = (bwc)paramView.getTag();
          paramView = AIOUtils.a(paramView);
        } while ((localbwc == null) || (!(paramView instanceof MessageForPubAccount)));
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.items != null) && (!paramView.mPAMessage.items.isEmpty())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(ChatItemBuilder.a, 2, "PAGameItemBuilder onClickListener mPAMessage or items is empty !");
      return;
      PAMessage.Item localItem = (PAMessage.Item)paramView.mPAMessage.items.get(localbwc.c);
      if (localItem != null) {
        PAGameItemBuilder.a(this.a, localItem);
      }
    } while (!(PAGameItemBuilder.b(this.a) instanceof QQAppInterface));
    ReportController.b(PAGameItemBuilder.c(this.a), "P_CliOper", "Pb_account_lifeservice", PAGameItemBuilder.c(this.a).a, "mp_msg_game_xiazai_click", "aio_game_xiazai_click", localbwc.c + 1, 0, "", "", Long.toString(paramView.mPAMessage.mMsgId), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwb
 * JD-Core Version:    0.7.0.1
 */