import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xez
  extends xeh.a
{
  xez(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xpo(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xez
 * JD-Core Version:    0.7.0.1
 */