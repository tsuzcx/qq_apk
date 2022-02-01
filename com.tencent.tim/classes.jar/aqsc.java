import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.e;
import com.tencent.mobileqq.data.ChatMessage;

class aqsc
  extends ETTextView.e
{
  aqsc(aqsa paramaqsa) {}
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    if ((aqsa.a(this.a) < 0) || (aqsa.b(this.a) < aqsa.a(this.a)))
    {
      aqsa.a(this.a).shouldStartAnimation = true;
      aqsa.a(this.a).startAnimation(false, false);
      if (aqsa.a(this.a) > 0) {
        aqsa.c(this.a);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsc
 * JD-Core Version:    0.7.0.1
 */