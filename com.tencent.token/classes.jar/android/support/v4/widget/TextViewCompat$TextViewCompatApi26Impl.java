package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.ActionMode.Callback;
import android.widget.TextView;

@RequiresApi(26)
class TextViewCompat$TextViewCompatApi26Impl
  extends TextViewCompat.TextViewCompatApi23Impl
{
  public void setCustomSelectionActionModeCallback(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    if ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))
    {
      super.setCustomSelectionActionModeCallback(paramTextView, paramCallback);
      return;
    }
    paramTextView.setCustomSelectionActionModeCallback(new TextViewCompat.TextViewCompatApi26Impl.1(this, paramCallback, paramTextView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat.TextViewCompatApi26Impl
 * JD-Core Version:    0.7.0.1
 */