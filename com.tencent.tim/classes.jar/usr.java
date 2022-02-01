import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class usr
  extends acdl
{
  public usr(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    if (i == 0) {
      this.this$0.n(9, acbn.bkw, 6003);
    }
    while (i != 1) {
      return;
    }
    this.this$0.n(8, acbn.bkx, 6003);
  }
  
  protected void c(boolean paramBoolean, long paramLong, String paramString)
  {
    super.c(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.this$0.n(8, acbn.bkw, 6000);
    }
    while (i != 1) {
      return;
    }
    this.this$0.n(8, acbn.bkx, 6000);
  }
  
  protected void d(boolean paramBoolean, long paramLong, String paramString)
  {
    super.d(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.this$0.n(8, acbn.bkw, 6000);
    }
    while (i != 1) {
      return;
    }
    this.this$0.n(8, acbn.bkx, 6003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */