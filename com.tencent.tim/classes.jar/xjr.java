import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.model.QueryTask.a;

public class xjr
  implements QueryTask.a<MarkFaceMessage, Void>
{
  public xjr(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.b paramb) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = ((ajdg)this.this$0.app.getManager(14)).a(paramMarkFaceMessage);
    this.a.c = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.e != null)) {
      this.a.b = ((ajdg)this.this$0.app.getManager(14)).b(paramMarkFaceMessage.e.epId);
    }
    aiyr.apU();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xjr
 * JD-Core Version:    0.7.0.1
 */