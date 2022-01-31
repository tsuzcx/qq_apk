package android.support.v4.app;

import java.util.List;

public class FragmentManagerNonConfig
{
  private final List mChildNonConfigs;
  private final List mFragments;
  private final List mViewModelStores;
  
  FragmentManagerNonConfig(List paramList1, List paramList2, List paramList3)
  {
    this.mFragments = paramList1;
    this.mChildNonConfigs = paramList2;
    this.mViewModelStores = paramList3;
  }
  
  List getChildNonConfigs()
  {
    return this.mChildNonConfigs;
  }
  
  List getFragments()
  {
    return this.mFragments;
  }
  
  List getViewModelStores()
  {
    return this.mViewModelStores;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerNonConfig
 * JD-Core Version:    0.7.0.1
 */