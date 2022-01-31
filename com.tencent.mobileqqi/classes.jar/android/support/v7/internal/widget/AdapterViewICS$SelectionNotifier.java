package android.support.v7.internal.widget;

class AdapterViewICS$SelectionNotifier
  implements Runnable
{
  private AdapterViewICS$SelectionNotifier(AdapterViewICS paramAdapterViewICS) {}
  
  public void run()
  {
    if (this.this$0.mDataChanged)
    {
      if (this.this$0.getAdapter() != null) {
        this.this$0.post(this);
      }
      return;
    }
    AdapterViewICS.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewICS.SelectionNotifier
 * JD-Core Version:    0.7.0.1
 */