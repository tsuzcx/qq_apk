package com.tencent.token;

import android.content.Context;
import android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

final class gk
  extends gm
{
  gk(Context paramContext, Window paramWindow, gh paramgh)
  {
    super(paramContext, paramWindow, paramgh);
  }
  
  final Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  final class a
    extends gm.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = gk.this.g(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.j, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gk
 * JD-Core Version:    0.7.0.1
 */