package com.tencent.token;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public final class il
{
  public static InputConnection a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    if ((paramInputConnection != null) && (paramEditorInfo.hintText == null)) {
      for (paramView = paramView.getParent(); (paramView instanceof View); paramView = paramView.getParent()) {
        if ((paramView instanceof jp))
        {
          paramEditorInfo.hintText = ((jp)paramView).a();
          return paramInputConnection;
        }
      }
    }
    return paramInputConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.il
 * JD-Core Version:    0.7.0.1
 */