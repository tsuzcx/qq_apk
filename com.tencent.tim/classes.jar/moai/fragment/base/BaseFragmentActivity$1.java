package moai.fragment.base;

import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;

class BaseFragmentActivity$1
  implements BaseFragmentActivity.TransactInterceptor
{
  BaseFragmentActivity$1(BaseFragmentActivity paramBaseFragmentActivity) {}
  
  public FragmentTransaction intercept(BaseFragment paramBaseFragment)
  {
    paramBaseFragment = paramBaseFragment.onFetchTransitionConfig();
    return this.this$0.getSupportFragmentManager().beginTransaction().setCustomAnimations(paramBaseFragment.enter, paramBaseFragment.exit, paramBaseFragment.popEnter, paramBaseFragment.popExit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.base.BaseFragmentActivity.1
 * JD-Core Version:    0.7.0.1
 */