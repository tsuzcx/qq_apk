import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.tencent.litetransfersdk.Session;

class acip
  extends acdl
{
  acip(acio paramacio) {}
  
  protected void a(Session paramSession, float paramFloat)
  {
    this.this$0.a(1, paramSession, paramFloat, false);
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void a(Session paramSession, boolean paramBoolean)
  {
    this.this$0.a(2, paramSession, 0.0D, paramBoolean);
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void b(Session paramSession)
  {
    this.this$0.a(3, paramSession, 0.0D, false);
    if (this.this$0.b != null)
    {
      this.this$0.b.ck();
      this.this$0.b.notifyDataSetChanged();
      LiteActivity.a(this.this$0.b.b.a, this.this$0.b.b.mListView);
      LiteActivity.a(this.this$0.b.b.mListView);
    }
  }
  
  protected void c(Session paramSession)
  {
    this.this$0.a(0, paramSession, 0.0D, false);
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
  
  protected void c(boolean paramBoolean, Long paramLong)
  {
    this.this$0.a(paramLong, paramBoolean);
    if (this.this$0.b != null) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acip
 * JD-Core Version:    0.7.0.1
 */