import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;

class alfo
  implements DialogInterface.OnClickListener
{
  alfo(alfl paramalfl, Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str;
    if (alfl.a(this.b).dsM == 1) {
      str = "&g_ch=suixintie&actId=460973&isAskFriendPay=0";
    }
    for (;;)
    {
      aqrf.a((Activity)this.val$context, this.mS + str, this.bWk, this.bWl, 0);
      paramDialogInterface.dismiss();
      return;
      if (alfl.a(this.b).dsM == 2) {
        str = "&g_ch=扩列装扮&actId=466499&isAskFriendPay=0";
      } else {
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfo
 * JD-Core Version:    0.7.0.1
 */