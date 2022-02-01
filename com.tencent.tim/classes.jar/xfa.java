import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xfa
  extends xeh.a
{
  xfa(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xpn(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfa
 * JD-Core Version:    0.7.0.1
 */