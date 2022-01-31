package android.support.v4.app;

import java.util.ArrayList;

class FragmentManagerImpl$StartEnterTransitionListener
  implements Fragment.OnStartEnterTransitionListener
{
  private final boolean mIsBack;
  private int mNumPostponed;
  private final BackStackRecord mRecord;
  
  FragmentManagerImpl$StartEnterTransitionListener(BackStackRecord paramBackStackRecord, boolean paramBoolean)
  {
    this.mIsBack = paramBoolean;
    this.mRecord = paramBackStackRecord;
  }
  
  public void cancelTransaction()
  {
    FragmentManagerImpl.access$600(this.mRecord.mManager, this.mRecord, this.mIsBack, false, false);
  }
  
  public void completeTransaction()
  {
    boolean bool1 = false;
    if (this.mNumPostponed > 0) {}
    for (int i = 1;; i = 0)
    {
      localFragmentManagerImpl = this.mRecord.mManager;
      int k = localFragmentManagerImpl.mAdded.size();
      int j = 0;
      while (j < k)
      {
        localObject = (Fragment)localFragmentManagerImpl.mAdded.get(j);
        ((Fragment)localObject).setOnStartEnterTransitionListener(null);
        if ((i != 0) && (((Fragment)localObject).isPostponed())) {
          ((Fragment)localObject).startPostponedEnterTransition();
        }
        j += 1;
      }
    }
    FragmentManagerImpl localFragmentManagerImpl = this.mRecord.mManager;
    Object localObject = this.mRecord;
    boolean bool2 = this.mIsBack;
    if (i == 0) {
      bool1 = true;
    }
    FragmentManagerImpl.access$600(localFragmentManagerImpl, (BackStackRecord)localObject, bool2, bool1, true);
  }
  
  public boolean isReady()
  {
    return this.mNumPostponed == 0;
  }
  
  public void onStartEnterTransition()
  {
    this.mNumPostponed -= 1;
    if (this.mNumPostponed != 0) {
      return;
    }
    FragmentManagerImpl.access$500(this.mRecord.mManager);
  }
  
  public void startListening()
  {
    this.mNumPostponed += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener
 * JD-Core Version:    0.7.0.1
 */