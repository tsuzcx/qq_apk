import android.view.View;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;

public class xoq
  implements ausj.a
{
  public xoq(StructingMsgItemBuilder paramStructingMsgItemBuilder, boolean paramBoolean, ChatMessage paramChatMessage, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.bia) {
      if ((this.b instanceof MessageForStructing)) {
        new aobs(this.this$0.app).a((MessageForStructing)this.b, this.this$0.sessionInfo);
      }
    }
    for (;;)
    {
      this.val$sheet.cancel();
      return;
      String str1;
      String str2;
      try
      {
        paramInt = Integer.parseInt(this.b.getExtInfoFromExtStr("peerType"));
        paramView = this.b.getExtInfoFromExtStr("filePath");
        str1 = this.b.getExtInfoFromExtStr("peerUin");
        str2 = this.b.getExtInfoFromExtStr("strSendUin");
        if (1 != paramInt) {
          break label133;
        }
        this.this$0.app.a().aV(paramView, str1);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      continue;
      label133:
      this.this$0.app.a().a(paramView, str2, str1, paramInt, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xoq
 * JD-Core Version:    0.7.0.1
 */