import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.data.AppShareID;
import mqq.os.MqqHandler;

public class usk
  extends accz
{
  public usk(Conversation paramConversation) {}
  
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if ((!paramBoolean1.booleanValue()) && (paramBoolean2.booleanValue()) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      anot.a(this.this$0.app, "dc00898", "", "", "0X8008272", "0X8008272", 0, 0, "", "", "", "");
      if (!this.this$0.isDestroy) {
        this.this$0.g.obtainMessage(1134068, new String[] { paramString1, paramString2, paramString3 }).sendToTarget();
      }
    }
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.this$0.fI(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usk
 * JD-Core Version:    0.7.0.1
 */