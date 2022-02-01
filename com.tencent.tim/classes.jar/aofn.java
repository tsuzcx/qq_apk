import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

class aofn
  implements ausj.a
{
  aofn(aofk paramaofk, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, int paramInt2, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      ((ClipboardManager)this.val$context.getSystemService("clipboard")).setText(this.chR);
      anot.a(this.val$app, "dc00898", "", "", "0X800A926", "0X800A926", this.dOs, 0, "", "", "", "");
      aofk.access$300("2", "1");
      continue;
      xov.a(this.val$app, (Activity)this.val$context, (ChatMessage)this.p, this.chR);
      anot.a(this.val$app, "dc00898", "", "", "0X800A927", "0X800A927", this.dOs, 0, "", "", "", "");
      continue;
      if (this.dOr == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.chR)), this.val$context.getString(2131695601));
        paramView.putExtra("big_brother_source_key", aofk.a(this.b));
        this.val$context.startActivity(paramView);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92D", "0X800A92D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.chR));
        paramView.putExtra("big_brother_source_key", aofk.a(this.b));
        this.val$context.startActivity(paramView);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92A", "0X800A92A", this.dOs, 0, "", "", "", "");
        aofk.access$300("1", "2");
        continue;
        aofk.ca(this.val$context, this.chR);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92B", "0X800A92B", this.dOs, 0, "", "", "", "");
        aofk.hF("0X800A00A", "0X800A00A");
        continue;
        aqep.c((Activity)this.val$context, this.val$app.getCurrentUin(), this.p.frienduin, this.p.istroop, this.chR);
        anot.a(this.val$app, "dc00898", "", "", "0X800A92C", "0X800A92C", this.dOs, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofn
 * JD-Core Version:    0.7.0.1
 */