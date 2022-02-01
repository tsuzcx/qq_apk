package com.tencent.token;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class ha
  extends gz
{
  private final UiModeManager w;
  
  ha(Context paramContext, Window paramWindow, gv paramgv)
  {
    super(paramContext, paramWindow, paramgv);
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
    extends gz.a
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
      if ((ha.this.o) && (paramInt == 0)) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ha
 * JD-Core Version:    0.7.0.1
 */