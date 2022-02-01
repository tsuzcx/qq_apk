import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

class xio
  extends xeh.a
{
  xio(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new QQStoryItemBuilder(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xio
 * JD-Core Version:    0.7.0.1
 */