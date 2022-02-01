import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;

public class cfg
  implements Runnable
{
  public cfg(Conversation paramConversation) {}
  
  public void run()
  {
    Object localObject = this.a.a.a();
    localObject = this.a.a.b((String)localObject);
    if ((localObject != ImageUtil.a()) && (this.a.X == 4096))
    {
      if (!Conversation.d(this.a)) {
        break label80;
      }
      this.a.b(3500L);
    }
    for (;;)
    {
      this.a.b(new cfh(this, (Drawable)localObject));
      return;
      label80:
      this.a.b(4500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfg
 * JD-Core Version:    0.7.0.1
 */