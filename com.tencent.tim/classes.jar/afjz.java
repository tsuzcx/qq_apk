import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.a;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class afjz
  implements EmojiIPCAlarmer.a
{
  afjz(afjy paramafjy) {}
  
  public void onTimeOut(int paramInt)
  {
    afjy.a locala = this.this$0.a(paramInt);
    if (locala != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.this$0.a(localBundle, 1001);
      locala.aK.putBundle("response", localBundle);
      this.this$0.runOnUiThread(new WebIPCOperator.5.1(this, locala));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjz
 * JD-Core Version:    0.7.0.1
 */