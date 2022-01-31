package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$AutoCompleteTextViewReflector
{
  private Method doAfterTextChanged;
  private Method doBeforeTextChanged;
  private Method ensureImeVisible;
  private Method showSoftInputUnchecked;
  
  SearchView$AutoCompleteTextViewReflector()
  {
    try
    {
      this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.doBeforeTextChanged.setAccessible(true);
      try
      {
        label27:
        this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.doAfterTextChanged.setAccessible(true);
        try
        {
          label50:
          this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          this.ensureImeVisible.setAccessible(true);
          try
          {
            label79:
            this.showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[] { Integer.TYPE, ResultReceiver.class });
            this.showSoftInputUnchecked.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label79;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        break label50;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException4)
    {
      break label27;
    }
  }
  
  void doAfterTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.doAfterTextChanged != null) {}
    try
    {
      this.doAfterTextChanged.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  void doBeforeTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.doBeforeTextChanged != null) {}
    try
    {
      this.doBeforeTextChanged.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
  {
    if (this.ensureImeVisible != null) {}
    try
    {
      this.ensureImeVisible.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  void showSoftInputUnchecked(InputMethodManager paramInputMethodManager, View paramView, int paramInt)
  {
    if (this.showSoftInputUnchecked != null) {
      try
      {
        this.showSoftInputUnchecked.invoke(paramInputMethodManager, new Object[] { Integer.valueOf(paramInt), null });
        return;
      }
      catch (Exception localException) {}
    }
    paramInputMethodManager.showSoftInput(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView.AutoCompleteTextViewReflector
 * JD-Core Version:    0.7.0.1
 */