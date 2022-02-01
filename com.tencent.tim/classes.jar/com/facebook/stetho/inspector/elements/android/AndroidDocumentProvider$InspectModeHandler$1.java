package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.common.Predicate;

class AndroidDocumentProvider$InspectModeHandler$1
  implements Predicate<View>
{
  AndroidDocumentProvider$InspectModeHandler$1(AndroidDocumentProvider.InspectModeHandler paramInspectModeHandler) {}
  
  public boolean apply(View paramView)
  {
    return !(paramView instanceof DocumentHiddenView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDocumentProvider.InspectModeHandler.1
 * JD-Core Version:    0.7.0.1
 */