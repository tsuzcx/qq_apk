import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xge
  extends xeh.a
{
  xge(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xiz(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xge
 * JD-Core Version:    0.7.0.1
 */