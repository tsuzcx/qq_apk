import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xib
  extends xeh.a
{
  xib(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new wyk(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xib
 * JD-Core Version:    0.7.0.1
 */