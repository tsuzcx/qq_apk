import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class wko
  implements wkp
{
  public static final boolean aTl = AppSetting.enableTalkBack;
  public int bOY;
  
  public abstract View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz);
  
  public abstract void a(View paramView, ChatMessage paramChatMessage, int paramInt);
  
  public abstract void destroy();
  
  public static class a
  {
    public StringBuilder E;
    public ChatMessage mMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */