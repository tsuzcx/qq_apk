package androidx.fragment.app;

class FragmentManagerImpl$3$1
  implements Runnable
{
  FragmentManagerImpl$3$1(FragmentManagerImpl.3 param3) {}
  
  public void run()
  {
    if (this.this$1.val$fragment.getAnimatingAway() != null)
    {
      this.this$1.val$fragment.setAnimatingAway(null);
      this.this$1.this$0.moveToState(this.this$1.val$fragment, this.this$1.val$fragment.getStateAfterAnimating(), 0, 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl.3.1
 * JD-Core Version:    0.7.0.1
 */