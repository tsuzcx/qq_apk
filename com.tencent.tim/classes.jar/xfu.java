import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xfu
  extends xeh.a
{
  xfu(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xkx(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e, xeh.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfu
 * JD-Core Version:    0.7.0.1
 */