import android.os.Handler;

class aewk
  implements jnn.a
{
  aewk(aewi paramaewi, jnn[] paramArrayOfjnn) {}
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      aewi.a(this.this$0).removeCallbacks(aewi.a(this.this$0));
      aewi.a(this.this$0).run();
      if (this.a[0] != null) {
        this.a[0].destroy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewk
 * JD-Core Version:    0.7.0.1
 */