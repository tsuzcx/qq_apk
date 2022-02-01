import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Set;

class xer
  extends xeh.a
{
  xer(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected boolean Sy()
  {
    return false;
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    paramChatMessage = new xiy(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
    xeh.a(this.b).add(paramChatMessage);
    return paramChatMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xer
 * JD-Core Version:    0.7.0.1
 */