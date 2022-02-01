import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class arzp
  implements DialogInterface.OnClickListener
{
  arzp(arzk paramarzk, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    arwt.d("MyAppApi", "---onConfirm--onClick");
    if (!arzk.aHx())
    {
      this.this$0.a = new arzk.d(this.this$0);
      this.this$0.a.autoDownload = true;
      this.this$0.a.ddH = true;
      this.this$0.a.t = null;
      this.this$0.a.y = this.bB;
      this.this$0.a.dix = 2;
      if (this.ddF) {
        this.this$0.r(this.val$activity, this.cCm, 0);
      }
    }
    for (;;)
    {
      this.this$0.ddB = true;
      arxt.br("201", arxt.cj(this.cCm, "NEWYYB"), this.val$appid);
      return;
      new arzk.c(this.this$0, this.val$activity, this.this$0.a).execute(new Void[0]);
      continue;
      this.this$0.a(this.val$activity, this.ae);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzp
 * JD-Core Version:    0.7.0.1
 */