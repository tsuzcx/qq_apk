import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class ajdc
  extends aqvd
{
  public ajdc(ChatBackgroundManager paramChatBackgroundManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    super.a(paramLong, paramInt, paramBundle);
    paramBundle = ChatBackgroundManager.c(true, paramLong + "");
    if (new File(paramBundle).exists()) {
      wkj.a(this.this$0.mApp.getApp().getApplicationContext(), this.this$0.mApp.getCurrentUin(), this.SO, paramBundle, this.bRQ, this.alR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdc
 * JD-Core Version:    0.7.0.1
 */