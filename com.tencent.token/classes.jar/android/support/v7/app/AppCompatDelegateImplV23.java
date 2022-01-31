package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(23)
class AppCompatDelegateImplV23
  extends AppCompatDelegateImplV14
{
  private final UiModeManager mUiModeManager;
  
  AppCompatDelegateImplV23(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
    this.mUiModeManager = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  int mapNightMode(int paramInt)
  {
    if ((paramInt == 0) && (this.mUiModeManager.getNightMode() == 0)) {
      return -1;
    }
    return super.mapNightMode(paramInt);
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplV23.AppCompatWindowCallbackV23(this, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV23
 * JD-Core Version:    0.7.0.1
 */