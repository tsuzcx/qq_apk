package android.support.v7.widget;

class DropDownListView$ResolveHoverRunnable
  implements Runnable
{
  private DropDownListView$ResolveHoverRunnable(DropDownListView paramDropDownListView) {}
  
  public void cancel()
  {
    DropDownListView.access$102(this.this$0, null);
    this.this$0.removeCallbacks(this);
  }
  
  public void post()
  {
    this.this$0.post(this);
  }
  
  public void run()
  {
    DropDownListView.access$102(this.this$0, null);
    this.this$0.drawableStateChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.DropDownListView.ResolveHoverRunnable
 * JD-Core Version:    0.7.0.1
 */