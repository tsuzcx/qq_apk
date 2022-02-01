import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.call.qcall.PstnSessionInfo;

final class alka
  implements ausj.a
{
  alka(ausj paramausj, int[] paramArrayOfInt, int paramInt1, QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt2, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.t.dismiss();
    switch (this.mJ[paramInt])
    {
    default: 
    case 0: 
      do
      {
        return;
        if ((this.duN == 1) || (this.duN == 2))
        {
          ChatActivityUtils.a(this.val$app, this.val$context, this.b, this.val$from);
          return;
        }
      } while (this.duN != 5);
      jkm.a(this.val$app, this.val$context, 1, 3);
      return;
    }
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.bwr));
    if ((!aqoq.cVe) && (aqoo.a().aFs())) {
      aqoo.a().k(paramView);
    }
    this.val$context.startActivity(paramView);
    paramView = this.val$app.a();
    long l = anaz.gQ();
    paramView.b(this.bwr, 26, -1, l, this.bwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alka
 * JD-Core Version:    0.7.0.1
 */