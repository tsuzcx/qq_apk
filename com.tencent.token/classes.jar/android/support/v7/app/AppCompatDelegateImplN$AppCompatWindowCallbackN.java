package android.support.v7.app;

import android.view.Menu;
import android.view.Window.Callback;
import java.util.List;

class AppCompatDelegateImplN$AppCompatWindowCallbackN
  extends AppCompatDelegateImplV23.AppCompatWindowCallbackV23
{
  AppCompatDelegateImplN$AppCompatWindowCallbackN(AppCompatDelegateImplN paramAppCompatDelegateImplN, Window.Callback paramCallback)
  {
    super(paramAppCompatDelegateImplN, paramCallback);
  }
  
  public void onProvideKeyboardShortcuts(List paramList, Menu paramMenu, int paramInt)
  {
    AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = this.this$0.getPanelState(0, true);
    if ((localPanelFeatureState != null) && (localPanelFeatureState.menu != null))
    {
      super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.menu, paramInt);
      return;
    }
    super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplN.AppCompatWindowCallbackN
 * JD-Core Version:    0.7.0.1
 */