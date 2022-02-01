import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xgs
  extends xeh.a
{
  xgs(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xal(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xgs
 * JD-Core Version:    0.7.0.1
 */