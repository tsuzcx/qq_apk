import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class ajqi
  implements DialogInterface.OnClickListener
{
  ajqi(ajqh paramajqh, boolean paramBoolean, String paramString1, ajqh.d paramd, QQAppInterface paramQQAppInterface, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.cpQ)
    {
      this.b.dyI();
      if (!this.b.ars()) {
        break label104;
      }
      this.b.K(Long.valueOf(this.val$uin).longValue(), 0, 1);
      this.a.cA(this.val$uin, false);
      ajqh.b(this.val$app, "pay_like", this.val$uin, this.val$from, "", "", "");
    }
    for (;;)
    {
      ajqh.j(this.val$app, "clk_no_warm", this.val$from);
      return;
      this.b.dyJ();
      break;
      label104:
      this.b.G(this.val$activity, this.val$from);
      ajqh.j(this.val$app, "exp_pay", this.val$from);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqi
 * JD-Core Version:    0.7.0.1
 */