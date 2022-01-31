import com.tencent.av.gaudio.GAudioObserver;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;

public class cli
  extends GAudioObserver
{
  public cli(Conversation paramConversation) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.b(new cll(this));
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.a.a(8, Long.toString(paramLong1), 3000);
    this.a.k();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.a.b(new clm(this));
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.a()).longValue()) {
      this.a.b(new clj(this));
    }
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.a()).longValue()) {
      this.a.b(new clk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cli
 * JD-Core Version:    0.7.0.1
 */