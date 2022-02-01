import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public final class awdz
  implements avzi
{
  public awdz(Handler paramHandler) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.uploadCommentVideo".equals(paramString))
    {
      paramString = new Message();
      paramString.obj = paramBundle;
      this.val$handler.sendMessage(paramString);
      if ((paramBundle.getBundle("data") != null) && (paramBundle.getBundle("data").getInt("status") != 2)) {
        avzf.a().b(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdz
 * JD-Core Version:    0.7.0.1
 */