import com.etrump.mixlayout.ETTextView.e;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.7.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class xpb
  extends ETTextView.e
{
  xpb(xov paramxov) {}
  
  public void a(ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (paramChatMessage != null))
    {
      paramChatMessage.saveExtInfoToExtStr("font_animation_played", "1");
      ThreadManager.excute(new TextItemBuilder.7.1(this, paramChatMessage), 128, null, true);
    }
    String str = this.this$0.app.getCurrentUin();
    if (paramBoolean) {}
    for (paramChatMessage = "1";; paramChatMessage = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "Font_Mall", "0X800813C", "0", 0, 1, 1, null, paramChatMessage, "" + paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpb
 * JD-Core Version:    0.7.0.1
 */