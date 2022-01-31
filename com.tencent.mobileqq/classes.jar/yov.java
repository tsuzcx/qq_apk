import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteContext;

public class yov
  implements Runnable
{
  public yov(SpriteBridge paramSpriteBridge) {}
  
  public void run()
  {
    if ((SpriteBridge.a(this.a) != null) && (SpriteBridge.a(this.a).a() != null)) {
      SpriteBridge.a(this.a).a().f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yov
 * JD-Core Version:    0.7.0.1
 */