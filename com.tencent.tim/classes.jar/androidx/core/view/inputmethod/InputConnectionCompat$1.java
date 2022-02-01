package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

final class InputConnectionCompat$1
  extends InputConnectionWrapper
{
  InputConnectionCompat$1(InputConnection paramInputConnection, boolean paramBoolean, InputConnectionCompat.OnCommitContentListener paramOnCommitContentListener)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitContent(InputContentInfo paramInputContentInfo, int paramInt, Bundle paramBundle)
  {
    if (this.val$listener.onCommitContent(InputContentInfoCompat.wrap(paramInputContentInfo), paramInt, paramBundle)) {
      return true;
    }
    return super.commitContent(paramInputContentInfo, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.inputmethod.InputConnectionCompat.1
 * JD-Core Version:    0.7.0.1
 */