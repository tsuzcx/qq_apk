import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.27.1;
import com.dataline.activities.LiteActivity.27.10;
import com.dataline.activities.LiteActivity.27.2;
import com.dataline.activities.LiteActivity.27.3;
import com.dataline.activities.LiteActivity.27.4;
import com.dataline.activities.LiteActivity.27.5;
import com.dataline.activities.LiteActivity.27.6;
import com.dataline.activities.LiteActivity.27.7;
import com.dataline.activities.LiteActivity.27.8;
import com.dataline.activities.LiteActivity.27.9;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class ao
  extends acdl
{
  public ao(LiteActivity paramLiteActivity) {}
  
  @TargetApi(11)
  protected void a(int paramInt, String paramString, long paramLong)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.this$0.runOnUiThread(new LiteActivity.27.7(this, paramString, paramInt));
      return;
    }
    this.this$0.runOnUiThread(new LiteActivity.27.8(this, paramString, paramInt));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.this$0.runOnUiThread(new LiteActivity.27.3(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    this.this$0.runOnUiThread(new LiteActivity.27.4(this, paramInt, paramLong1));
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    this.this$0.runOnUiThread(new LiteActivity.27.6(this, i));
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    this.this$0.runOnUiThread(new LiteActivity.27.5(this, paramInt, paramLong1));
  }
  
  protected void b(boolean paramBoolean, long paramLong)
  {
    super.b(paramBoolean, paramLong);
  }
  
  protected void bJ()
  {
    this.this$0.runOnUiThread(new LiteActivity.27.10(this));
  }
  
  protected void c(boolean paramBoolean, long paramLong, String paramString)
  {
    super.c(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.this$0.runOnUiThread(new LiteActivity.27.2(this, paramBoolean, i, paramLong, paramString));
  }
  
  protected void d(boolean paramBoolean, long paramLong, String paramString)
  {
    super.d(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.this$0.runOnUiThread(new LiteActivity.27.1(this, i, paramLong));
  }
  
  protected void i(long paramLong)
  {
    this.this$0.runOnUiThread(new LiteActivity.27.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ao
 * JD-Core Version:    0.7.0.1
 */