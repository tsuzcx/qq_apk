package android.support.v4.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.util.Collection;

@RequiresApi(26)
class ViewCompat$ViewCompatApi26Impl
  extends ViewCompat.ViewCompatApi24Impl
{
  public void addKeyboardNavigationClusters(@NonNull View paramView, @NonNull Collection paramCollection, int paramInt)
  {
    paramView.addKeyboardNavigationClusters(paramCollection, paramInt);
  }
  
  public int getImportantForAutofill(@NonNull View paramView)
  {
    return paramView.getImportantForAutofill();
  }
  
  public int getNextClusterForwardId(@NonNull View paramView)
  {
    return paramView.getNextClusterForwardId();
  }
  
  public boolean hasExplicitFocusable(@NonNull View paramView)
  {
    return paramView.hasExplicitFocusable();
  }
  
  public boolean isFocusedByDefault(@NonNull View paramView)
  {
    return paramView.isFocusedByDefault();
  }
  
  public boolean isImportantForAutofill(@NonNull View paramView)
  {
    return paramView.isImportantForAutofill();
  }
  
  public boolean isKeyboardNavigationCluster(@NonNull View paramView)
  {
    return paramView.isKeyboardNavigationCluster();
  }
  
  public View keyboardNavigationClusterSearch(@NonNull View paramView1, View paramView2, int paramInt)
  {
    return paramView1.keyboardNavigationClusterSearch(paramView2, paramInt);
  }
  
  public boolean restoreDefaultFocus(@NonNull View paramView)
  {
    return paramView.restoreDefaultFocus();
  }
  
  public void setAutofillHints(@NonNull View paramView, @Nullable String... paramVarArgs)
  {
    paramView.setAutofillHints(paramVarArgs);
  }
  
  public void setFocusedByDefault(@NonNull View paramView, boolean paramBoolean)
  {
    paramView.setFocusedByDefault(paramBoolean);
  }
  
  public void setImportantForAutofill(@NonNull View paramView, int paramInt)
  {
    paramView.setImportantForAutofill(paramInt);
  }
  
  public void setKeyboardNavigationCluster(@NonNull View paramView, boolean paramBoolean)
  {
    paramView.setKeyboardNavigationCluster(paramBoolean);
  }
  
  public void setNextClusterForwardId(@NonNull View paramView, int paramInt)
  {
    paramView.setNextClusterForwardId(paramInt);
  }
  
  public void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    paramView.setTooltipText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi26Impl
 * JD-Core Version:    0.7.0.1
 */