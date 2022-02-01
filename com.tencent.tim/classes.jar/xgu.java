import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xgu
  extends xeh.a
{
  xgu(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xaq(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xgu
 * JD-Core Version:    0.7.0.1
 */