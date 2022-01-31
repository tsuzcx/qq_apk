package android.support.v4.app;

import java.util.ArrayList;

class FragmentManagerImpl$PopBackStackState
  implements FragmentManagerImpl.OpGenerator
{
  final int mFlags;
  final int mId;
  final String mName;
  
  FragmentManagerImpl$PopBackStackState(FragmentManagerImpl paramFragmentManagerImpl, String paramString, int paramInt1, int paramInt2)
  {
    this.mName = paramString;
    this.mId = paramInt1;
    this.mFlags = paramInt2;
  }
  
  public boolean generateOps(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((this.this$0.mPrimaryNav != null) && (this.mId < 0) && (this.mName == null))
    {
      FragmentManager localFragmentManager = this.this$0.mPrimaryNav.peekChildFragmentManager();
      if ((localFragmentManager != null) && (localFragmentManager.popBackStackImmediate())) {
        return false;
      }
    }
    return this.this$0.popBackStackState(paramArrayList1, paramArrayList2, this.mName, this.mId, this.mFlags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.PopBackStackState
 * JD-Core Version:    0.7.0.1
 */