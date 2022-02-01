package moai.fragment.app;

import java.util.List;

public class FragmentManagerNonConfig
{
  private final List<FragmentManagerNonConfig> mChildNonConfigs;
  private final List<Fragment> mFragments;
  
  FragmentManagerNonConfig(List<Fragment> paramList, List<FragmentManagerNonConfig> paramList1)
  {
    this.mFragments = paramList;
    this.mChildNonConfigs = paramList1;
  }
  
  List<FragmentManagerNonConfig> getChildNonConfigs()
  {
    return this.mChildNonConfigs;
  }
  
  List<Fragment> getFragments()
  {
    return this.mFragments;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentManagerNonConfig
 * JD-Core Version:    0.7.0.1
 */