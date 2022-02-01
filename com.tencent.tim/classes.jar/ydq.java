import android.app.Dialog;
import android.os.Handler;
import java.util.HashMap;

class ydq
  extends ashx
{
  ydq(ycd paramycd) {}
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.this$0.DG(2);
      this.this$0.mHandler.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.this$0.DG(1);
      this.this$0.mHandler.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.this$0.blK = true;
    this.this$0.chg();
    if ((ycd.a(this.this$0) != null) && (ycd.a(this.this$0).isShowing())) {
      ycd.a(this.this$0).dismiss();
    }
    this.this$0.chh();
  }
  
  protected void h(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.this$0.blN = true;
    this.this$0.blM = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.this$0.chg();
    this.this$0.chh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydq
 * JD-Core Version:    0.7.0.1
 */