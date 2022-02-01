import android.content.Context;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;

final class ocv
  implements ausj.a
{
  ocv(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean, Context paramContext, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      this.val$actionSheet.dismiss();
      return;
      this.val$app.b().t(this.apO, this.ber, this.rJ);
      if (this.awo) {
        PublicAccountHandler.a(this.val$app, this.apO, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
      }
      for (;;)
      {
        this.val$app.b().cc(this.apO, this.ber);
        break;
        PublicAccountHandler.a(this.val$app, this.apO, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
      }
    } while (!this.apO.equals("2010741172"));
    paramView = this.val$app.b().a(this.apO, this.ber, this.rJ);
    if (paramView != null)
    {
      paramView = wna.a(paramView);
      if (paramView != null)
      {
        paramView = (PAMessage.Item)paramView.items.get(0);
        if (paramView.url != null) {
          ocp.b(this.val$app, this.val$context, paramView.url);
        }
      }
    }
    this.val$app.b().t(this.apO, this.ber, this.rJ);
    if (this.awo) {
      PublicAccountHandler.a(this.val$app, this.apO, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
    }
    for (;;)
    {
      this.val$app.b().cc(this.apO, this.ber);
      break;
      PublicAccountHandler.a(this.val$app, this.apO, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocv
 * JD-Core Version:    0.7.0.1
 */