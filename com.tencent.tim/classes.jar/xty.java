import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;

public class xty
  extends angu.a
{
  public xty(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, angq paramangq)
  {
    xui localxui = this.this$0.c;
    if (paramangq.mResult == 0)
    {
      paramangq = (akxb.a)paramangq.en;
      if (localxui != null) {
        localxui.b(this.val$id, this.bWI, this.val$type, 1, paramangq.bUF, false);
      }
      this.this$0.c(this.val$id, this.bWI, this.val$type, paramangq.bUF);
      return;
    }
    if (localxui != null) {
      localxui.b(this.val$id, this.bWI, this.val$type, 2, "step:" + paramangq.c.bUI + ", desc:" + paramangq.c.bUJ, false);
    }
    this.this$0.c(this.val$id, this.bWI, this.val$type, "I:E");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    xui localxui = this.this$0.c;
    if (localxui != null) {
      localxui.b(this.val$id, this.bWI, this.val$type, paramInt, 0L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xty
 * JD-Core Version:    0.7.0.1
 */