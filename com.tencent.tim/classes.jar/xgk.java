import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

class xgk
  extends xeh.a
{
  xgk(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new MarketFaceItemBuilder(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xgk
 * JD-Core Version:    0.7.0.1
 */