package com.tencent.token;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class gj
  extends gi
{
  private final UiModeManager w;
  
  gj(Context paramContext, Window paramWindow, ge paramge)
  {
    super(paramContext, paramWindow, paramge);
    this.w = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  final int f(int paramInt)
  {
    if ((paramInt == 0) && (this.w.getNightMode() == 0)) {
      return -1;
    }
    return super.f(paramInt);
  }
  
  class a
    extends gi.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if ((gj.this.o) && (paramInt == 0)) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gj
 * JD-Core Version:    0.7.0.1
 */