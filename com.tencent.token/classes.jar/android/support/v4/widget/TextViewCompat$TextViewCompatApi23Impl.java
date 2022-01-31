package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.widget.TextView;

@RequiresApi(23)
class TextViewCompat$TextViewCompatApi23Impl
  extends TextViewCompat.TextViewCompatApi18Impl
{
  public void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    paramTextView.setTextAppearance(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat.TextViewCompatApi23Impl
 * JD-Core Version:    0.7.0.1
 */