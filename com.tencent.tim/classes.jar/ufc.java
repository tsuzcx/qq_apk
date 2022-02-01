import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AddRequestActivity.13.1;
import com.tencent.mobileqq.activity.AddRequestActivity.13.2;
import com.tencent.mobileqq.activity.AddRequestActivity.13.3;
import java.util.ArrayList;

public class ufc
  extends acdv
{
  public ufc(AddRequestActivity paramAddRequestActivity) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.this$0.Fj != 0L) && (String.valueOf(this.this$0.Fj).equals(paramString))) {
      this.this$0.runOnUiThread(new AddRequestActivity.13.1(this));
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.this$0.Fj) && (this.this$0.Fj != 0L)) {
      this.this$0.runOnUiThread(new AddRequestActivity.13.3(this));
    }
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    if ((this.this$0.Fj != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.this$0.Fj)))) {
      this.this$0.runOnUiThread(new AddRequestActivity.13.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufc
 * JD-Core Version:    0.7.0.1
 */