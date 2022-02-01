import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xhq
  extends xeh.a
{
  xhq(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new szl(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xhq
 * JD-Core Version:    0.7.0.1
 */