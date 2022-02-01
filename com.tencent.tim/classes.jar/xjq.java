import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.EmoticonPackage;

public class xjq
  implements ajdq<EmoticonPackage>
{
  public xjq(MarketFaceItemBuilder paramMarketFaceItemBuilder, int paramInt, ChatMessage paramChatMessage) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    String str = "0";
    int i = -1;
    if (paramEmoticonPackage != null)
    {
      str = paramEmoticonPackage.epId;
      if ((3 == paramEmoticonPackage.jobType) || (5 == paramEmoticonPackage.jobType)) {
        i = 2;
      }
    }
    else
    {
      if (this.val$id != 2131365686) {
        break label98;
      }
      ujt.b(this.this$0.mContext, this.this$0.app, this.b);
      anot.a(this.this$0.app, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
    }
    label98:
    do
    {
      return;
      i = 1;
      break;
      if (this.val$id == 2131362240)
      {
        this.this$0.a(paramEmoticonPackage, str, i);
        return;
      }
    } while ((this.val$id != 2131367539) && (this.val$id != 2131367229));
    this.this$0.a(paramEmoticonPackage, str, i, this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjq
 * JD-Core Version:    0.7.0.1
 */