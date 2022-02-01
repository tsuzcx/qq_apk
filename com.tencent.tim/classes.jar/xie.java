import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xie
  extends xeh.a
{
  xie(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new wzr(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xie
 * JD-Core Version:    0.7.0.1
 */