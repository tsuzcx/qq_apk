import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xfy
  extends xeh.a
{
  xfy(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xqs(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */