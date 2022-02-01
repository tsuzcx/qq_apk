package io.flutter.plugin.editing;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;

class InputConnectionAdaptor
  extends BaseInputConnection
{
  private int mBatchCount;
  private final int mClient;
  private final Editable mEditable;
  private final View mFlutterView;
  private InputMethodManager mImm;
  private final Layout mLayout;
  private final TextInputChannel textInputChannel;
  
  public InputConnectionAdaptor(View paramView, int paramInt, TextInputChannel paramTextInputChannel, Editable paramEditable)
  {
    super(paramView, true);
    this.mFlutterView = paramView;
    this.mClient = paramInt;
    this.textInputChannel = paramTextInputChannel;
    this.mEditable = paramEditable;
    this.mBatchCount = 0;
    this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.mImm = ((InputMethodManager)paramView.getContext().getSystemService("input_method"));
  }
  
  private static int clampIndexToEditable(int paramInt, Editable paramEditable)
  {
    int i = Math.max(0, Math.min(paramEditable.length(), paramInt));
    if (i != paramInt)
    {
      paramEditable = new StringBuilder();
      paramEditable.append("Text selection index was clamped (");
      paramEditable.append(paramInt);
      paramEditable.append("->");
      paramEditable.append(i);
      paramEditable.append(") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
      Log.d("flutter", paramEditable.toString());
    }
    return i;
  }
  
  private void updateEditingState()
  {
    if (this.mBatchCount > 0) {
      return;
    }
    int i = Selection.getSelectionStart(this.mEditable);
    int j = Selection.getSelectionEnd(this.mEditable);
    int k = BaseInputConnection.getComposingSpanStart(this.mEditable);
    int m = BaseInputConnection.getComposingSpanEnd(this.mEditable);
    this.mImm.updateSelection(this.mFlutterView, i, j, k, m);
    this.textInputChannel.updateEditingState(this.mClient, this.mEditable.toString(), i, j, k, m);
  }
  
  public boolean beginBatchEdit()
  {
    this.mBatchCount += 1;
    return super.beginBatchEdit();
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    boolean bool = super.commitText(paramCharSequence, paramInt);
    updateEditingState();
    return bool;
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    if (Selection.getSelectionStart(this.mEditable) == -1) {
      return true;
    }
    boolean bool = super.deleteSurroundingText(paramInt1, paramInt2);
    updateEditingState();
    return bool;
  }
  
  public boolean endBatchEdit()
  {
    boolean bool = super.endBatchEdit();
    this.mBatchCount -= 1;
    updateEditingState();
    return bool;
  }
  
  public Editable getEditable()
  {
    return this.mEditable;
  }
  
  public boolean performEditorAction(int paramInt)
  {
    if (paramInt != 7) {
      switch (paramInt)
      {
      default: 
        this.textInputChannel.done(this.mClient);
      }
    }
    for (;;)
    {
      return true;
      this.textInputChannel.next(this.mClient);
      continue;
      this.textInputChannel.send(this.mClient);
      continue;
      this.textInputChannel.search(this.mClient);
      continue;
      this.textInputChannel.go(this.mClient);
      continue;
      this.textInputChannel.newline(this.mClient);
      continue;
      this.textInputChannel.unspecifiedAction(this.mClient);
      continue;
      this.textInputChannel.previous(this.mClient);
    }
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      if (paramKeyEvent.getKeyCode() == 67)
      {
        i = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
        j = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
        if (j > i)
        {
          Selection.setSelection(this.mEditable, i);
          this.mEditable.delete(i, j);
          updateEditingState();
        }
      }
      do
      {
        return true;
        if (i <= 0) {
          break;
        }
        if (this.mLayout.isRtlCharAt(this.mLayout.getLineForOffset(i))) {}
        try
        {
          Selection.extendRight(this.mEditable, this.mLayout);
          for (;;)
          {
            i = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
            j = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
            Selection.setSelection(this.mEditable, Math.min(i, j));
            this.mEditable.delete(Math.min(i, j), Math.max(i, j));
            updateEditingState();
            return true;
            Selection.extendLeft(this.mEditable, this.mLayout);
          }
        }
        catch (IndexOutOfBoundsException paramKeyEvent)
        {
          for (;;)
          {
            Selection.setSelection(this.mEditable, i, i - 1);
          }
        }
        if (paramKeyEvent.getKeyCode() == 21)
        {
          i = Math.max(Selection.getSelectionStart(this.mEditable) - 1, 0);
          setSelection(i, i);
          return true;
        }
        if (paramKeyEvent.getKeyCode() == 22)
        {
          i = Math.min(Selection.getSelectionStart(this.mEditable) + 1, this.mEditable.length());
          setSelection(i, i);
          return true;
        }
        i = paramKeyEvent.getUnicodeChar();
      } while (i == 0);
      int j = Math.max(0, Selection.getSelectionStart(this.mEditable));
      int k = Math.max(0, Selection.getSelectionEnd(this.mEditable));
      if (k != j) {
        this.mEditable.delete(j, k);
      }
      this.mEditable.insert(j, String.valueOf((char)i));
      int i = j + 1;
      setSelection(i, i);
      updateEditingState();
      return true;
    }
    return false;
  }
  
  public boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    boolean bool = super.setComposingRegion(paramInt1, paramInt2);
    updateEditingState();
    return bool;
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence.length() == 0) {}
    for (boolean bool = super.commitText(paramCharSequence, paramInt);; bool = super.setComposingText(paramCharSequence, paramInt))
    {
      updateEditingState();
      return bool;
    }
  }
  
  public boolean setSelection(int paramInt1, int paramInt2)
  {
    boolean bool = super.setSelection(paramInt1, paramInt2);
    updateEditingState();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.editing.InputConnectionAdaptor
 * JD-Core Version:    0.7.0.1
 */