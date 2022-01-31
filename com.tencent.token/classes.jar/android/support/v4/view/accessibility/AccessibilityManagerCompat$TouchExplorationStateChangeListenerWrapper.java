package android.support.v4.view.accessibility;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

@RequiresApi(19)
class AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  final AccessibilityManagerCompat.TouchExplorationStateChangeListener mListener;
  
  AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat.TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener)
  {
    this.mListener = paramTouchExplorationStateChangeListener;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (TouchExplorationStateChangeListenerWrapper)paramObject;
    return this.mListener.equals(paramObject.mListener);
  }
  
  public int hashCode()
  {
    return this.mListener.hashCode();
  }
  
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    this.mListener.onTouchExplorationStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */