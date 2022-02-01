import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.a;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;

public class xjm
  implements ajdq<EmoticonPackage>
{
  public xjm(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.b paramb, arhz paramarhz) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    anot.a(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "ep_mall", "Clk_button_follow", 0, 0, "", "", this.a.c.e.eId, "");
    if (paramEmoticonPackage == null)
    {
      this.this$0.a.a(107, this.this$0.app, this.this$0.mContext, this.a.c, this.this$0.sessionInfo, MarketFaceItemBuilder.a(this.this$0));
      afkd.a().a(this.this$0.a);
      this.this$0.b.ex(this.a.c.e.epId, afke.cRu);
      return;
    }
    MarketFaceItemBuilder.a(107, this.this$0.mContext, this.this$0.app, paramEmoticonPackage, this.a.c, this.this$0.sessionInfo, this.val$dialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */