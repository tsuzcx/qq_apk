package android.support.v4.view;

import android.support.compat.R.id;
import android.view.ViewGroup;

class ViewGroupCompat$ViewGroupCompatBaseImpl
{
  public int getLayoutMode(ViewGroup paramViewGroup)
  {
    return 0;
  }
  
  public int getNestedScrollAxes(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewGroup).getNestedScrollAxes();
    }
    return 0;
  }
  
  public boolean isTransitionGroup(ViewGroup paramViewGroup)
  {
    Boolean localBoolean = (Boolean)paramViewGroup.getTag(R.id.tag_transition_group);
    return ((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (ViewCompat.getTransitionName(paramViewGroup) != null);
  }
  
  public void setLayoutMode(ViewGroup paramViewGroup, int paramInt) {}
  
  public void setTransitionGroup(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramViewGroup.setTag(R.id.tag_transition_group, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */