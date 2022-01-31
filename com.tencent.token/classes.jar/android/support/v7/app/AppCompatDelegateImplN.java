package android.support.v7.app;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(24)
class AppCompatDelegateImplN
  extends AppCompatDelegateImplV23
{
  AppCompatDelegateImplN(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplN.AppCompatWindowCallbackN(this, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplN
 * JD-Core Version:    0.7.0.1
 */