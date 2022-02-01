package moai.fragment.base;

import java.util.concurrent.ConcurrentHashMap;

class BaseFragment$4
  implements Runnable
{
  BaseFragment$4(BaseFragment paramBaseFragment, Runnable paramRunnable) {}
  
  public void run()
  {
    BaseFragment.access$100(this.this$0).remove(this.val$r);
    if ((!this.this$0.isRemoving()) && (BaseFragment.access$200(this.this$0) != null)) {
      this.val$r.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.base.BaseFragment.4
 * JD-Core Version:    0.7.0.1
 */