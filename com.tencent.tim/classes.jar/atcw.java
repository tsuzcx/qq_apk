import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.activity.CallActivity;

public class atcw
  extends acdv
{
  public atcw(CallActivity paramCallActivity) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.this$0.etd();
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallTab", 2, "call onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.this$0.etd();
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcw
 * JD-Core Version:    0.7.0.1
 */