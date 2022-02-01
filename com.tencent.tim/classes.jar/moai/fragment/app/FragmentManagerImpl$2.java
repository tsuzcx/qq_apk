package moai.fragment.app;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.ArrayList;

class FragmentManagerImpl$2
  implements SwipeBackLayout.SwipeListener
{
  FragmentManagerImpl$2(FragmentManagerImpl paramFragmentManagerImpl) {}
  
  public void onDragBack()
  {
    if ((this.this$0.mBackStack != null) && (this.this$0.mBackStack.size() >= 1)) {
      ((BackStackRecord)this.this$0.mBackStack.get(this.this$0.mBackStack.size() - 1)).last().fragment.onDragBack();
    }
  }
  
  public void onEdgeTouch(int paramInt)
  {
    if ((this.this$0.mBackStack != null) && (this.this$0.mBackStack.size() >= 2))
    {
      Fragment localFragment = ((BackStackRecord)this.this$0.mBackStack.get(this.this$0.mBackStack.size() - 2)).last().fragment;
      ViewGroup localViewGroup = (ViewGroup)this.this$0.mContainer.onFindViewById(localFragment.mContainerId);
      localViewGroup.addView(localFragment.performCreateView(localFragment.getLayoutInflater(localFragment.mSavedFragmentState), localViewGroup, localFragment.mSavedFragmentState), 0);
      return;
    }
    this.this$0.mHost.getActivity().getWindow().getDecorView().setBackgroundColor(0);
    Utils.convertActivityToTranslucent(this.this$0.mHost.getActivity());
  }
  
  public void onScrollOverThreshold() {}
  
  public void onScrollStateChange(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    }
    do
    {
      Object localObject;
      ViewGroup localViewGroup;
      do
      {
        do
        {
          return;
          if (paramFloat > 0.0F) {
            break;
          }
        } while ((this.this$0.mBackStack == null) || (this.this$0.mBackStack.size() < 2));
        localObject = (BackStackRecord)this.this$0.mBackStack.get(this.this$0.mBackStack.size() - 2);
        localObject = ((BackStackRecord.Op)((BackStackRecord)localObject).mOps.get(((BackStackRecord)localObject).mOps.size() - 1)).fragment;
        localViewGroup = (ViewGroup)this.this$0.mContainer.onFindViewById(((Fragment)localObject).mContainerId);
        localViewGroup.removeView(((Fragment)localObject).performCreateView(((Fragment)localObject).getLayoutInflater(((Fragment)localObject).mSavedFragmentState), localViewGroup, ((Fragment)localObject).mSavedFragmentState));
        return;
      } while (paramFloat < 1.0F);
      if ((this.this$0.mBackStack != null) && (this.this$0.mBackStack.size() >= 2))
      {
        localObject = ((BackStackRecord)this.this$0.mBackStack.get(this.this$0.mBackStack.size() - 2)).last().fragment;
        localViewGroup = (ViewGroup)this.this$0.mContainer.onFindViewById(((Fragment)localObject).mContainerId);
        localViewGroup.removeView(((Fragment)localObject).performCreateView(((Fragment)localObject).getLayoutInflater(((Fragment)localObject).mSavedFragmentState), localViewGroup, ((Fragment)localObject).mSavedFragmentState));
        localObject = (BackStackRecord)this.this$0.mBackStack.get(this.this$0.mBackStack.size() - 1);
        ((BackStackRecord)localObject).last().popExitAnim = -1;
        ((BackStackRecord)localObject).last().popEnterAnim = -1;
        localObject = ((BackStackRecord)localObject).mOps;
        if (((ArrayList)localObject).size() > 1)
        {
          localObject = (BackStackRecord.Op)((ArrayList)localObject).get(((ArrayList)localObject).size() - 2);
          if (((BackStackRecord.Op)localObject).cmd == 3)
          {
            ((BackStackRecord.Op)localObject).popEnterAnim = -1;
            ((BackStackRecord.Op)localObject).popExitAnim = -1;
          }
        }
      }
      for (;;)
      {
        this.this$0.noteStateNotSaved();
        this.this$0.popBackStackImmediate();
        return;
        if (!this.this$0.mHost.getActivity().isFinishing())
        {
          this.this$0.mHost.getActivity().finish();
          this.this$0.mHost.getActivity().overridePendingTransition(0, 0);
        }
      }
    } while ((this.this$0.mBackStack == null) || (this.this$0.mBackStack.size() < 1));
    ((BackStackRecord)this.this$0.mBackStack.get(this.this$0.mBackStack.size() - 1)).last().fragment.onDragging();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */