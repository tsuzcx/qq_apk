import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

class xfw
  extends xeh.a
{
  xfw(xeh paramxeh)
  {
    super(paramxeh, null);
  }
  
  protected wko b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new szq(this.b.app, paramBaseAdapter, this.b.mContext, this.b.d, this.b.e, xeh.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfw
 * JD-Core Version:    0.7.0.1
 */