import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xgw
  extends xeh.a
{
  xgw(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new xat(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xgw
 * JD-Core Version:    0.7.0.1
 */