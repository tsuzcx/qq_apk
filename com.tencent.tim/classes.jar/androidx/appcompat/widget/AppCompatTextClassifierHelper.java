package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper
{
  @Nullable
  private TextClassifier mTextClassifier;
  @NonNull
  private TextView mTextView;
  
  AppCompatTextClassifierHelper(TextView paramTextView)
  {
    this.mTextView = ((TextView)Preconditions.checkNotNull(paramTextView));
  }
  
  @NonNull
  @RequiresApi(api=26)
  public TextClassifier getTextClassifier()
  {
    if (this.mTextClassifier == null)
    {
      TextClassificationManager localTextClassificationManager = (TextClassificationManager)this.mTextView.getContext().getSystemService(TextClassificationManager.class);
      if (localTextClassificationManager != null) {
        return localTextClassificationManager.getTextClassifier();
      }
      return TextClassifier.NO_OP;
    }
    return this.mTextClassifier;
  }
  
  @RequiresApi(api=26)
  public void setTextClassifier(@Nullable TextClassifier paramTextClassifier)
  {
    this.mTextClassifier = paramTextClassifier;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextClassifierHelper
 * JD-Core Version:    0.7.0.1
 */