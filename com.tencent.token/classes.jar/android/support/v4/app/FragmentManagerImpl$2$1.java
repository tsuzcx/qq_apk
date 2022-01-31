package android.support.v4.app;

class FragmentManagerImpl$2$1
  implements Runnable
{
  FragmentManagerImpl$2$1(FragmentManagerImpl.2 param2) {}
  
  public void run()
  {
    if (this.this$1.val$fragment.getAnimatingAway() != null)
    {
      this.this$1.val$fragment.setAnimatingAway(null);
      this.this$1.this$0.moveToState(this.this$1.val$fragment, this.this$1.val$fragment.getStateAfterAnimating(), 0, 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.2.1
 * JD-Core Version:    0.7.0.1
 */