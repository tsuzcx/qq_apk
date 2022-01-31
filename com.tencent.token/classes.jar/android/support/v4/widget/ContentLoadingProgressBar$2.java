package android.support.v4.widget;

class ContentLoadingProgressBar$2
  implements Runnable
{
  ContentLoadingProgressBar$2(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public void run()
  {
    this.this$0.mPostedShow = false;
    if (!this.this$0.mDismissed)
    {
      this.this$0.mStartTime = System.currentTimeMillis();
      this.this$0.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar.2
 * JD-Core Version:    0.7.0.1
 */