import android.os.Handler;

class aewp
  implements jnn.a
{
  aewp(aewn paramaewn, jnn[] paramArrayOfjnn) {}
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      aewn.a(this.this$0).removeCallbacks(aewn.a(this.this$0));
      aewn.a(this.this$0).run();
      if (this.a[0] != null) {
        this.a[0].destroy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewp
 * JD-Core Version:    0.7.0.1
 */