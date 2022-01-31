package android.support.v7.internal.widget;

class ProgressBarICS$RefreshProgressRunnable
  implements Runnable
{
  private boolean mFromUser;
  private int mId;
  private int mProgress;
  
  ProgressBarICS$RefreshProgressRunnable(ProgressBarICS paramProgressBarICS, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mId = paramInt1;
    this.mProgress = paramInt2;
    this.mFromUser = paramBoolean;
  }
  
  public void run()
  {
    ProgressBarICS.access$000(this.this$0, this.mId, this.mProgress, this.mFromUser, true);
    ProgressBarICS.access$102(this.this$0, this);
  }
  
  public void setup(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mId = paramInt1;
    this.mProgress = paramInt2;
    this.mFromUser = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ProgressBarICS.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */