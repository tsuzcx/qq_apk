import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xgn
  extends xeh.a
{
  xgn(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xkb(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xgn
 * JD-Core Version:    0.7.0.1
 */