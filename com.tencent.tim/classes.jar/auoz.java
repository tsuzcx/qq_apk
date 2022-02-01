import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.TodoNewActivity.6.1;
import java.io.UnsupportedEncodingException;

public class auoz
  implements TextWatcher
{
  private int mCurrentSize = 25;
  private int[] tl = { 15, 18, 20, 22, 25 };
  
  public auoz(TodoNewActivity paramTodoNewActivity, int paramInt) {}
  
  private int a(CharSequence paramCharSequence, float paramFloat, Rect paramRect)
  {
    int i = 0;
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.set(TodoNewActivity.a(this.this$0).getPaint());
    localTextPaint.setTextSize(paramFloat);
    paramCharSequence = new StaticLayout(paramCharSequence, localTextPaint, Math.round(paramRect.right), Layout.Alignment.ALIGN_NORMAL, 1.5F, 0.0F, false);
    if (Build.MODEL.equals("OPPO A53")) {
      i = (int)(paramFloat / 2.0F);
    }
    return paramCharSequence.getHeight() + i;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TodoNewActivity.a(this.this$0).getText() != null)
    {
      TodoNewActivity.a(this.this$0, TodoNewActivity.a(this.this$0).getText().toString());
      TodoNewActivity.d(this.this$0);
    }
    int i = TodoNewActivity.a(this.this$0).getMeasuredWidth();
    int j = TodoNewActivity.a(this.this$0).getMeasuredHeight();
    if ((i <= 0) || (j <= 0)) {}
    Rect localRect;
    do
    {
      return;
      localRect = new Rect();
      localRect.right = i;
      localRect.bottom = j;
      if (this.mCurrentSize != this.tl[(this.tl.length - 1)]) {
        break;
      }
      i = a(paramEditable.toString(), TodoNewActivity.a(this.this$0).getTextSize(), localRect);
      if (i == localRect.bottom) {
        break;
      }
      j = i + TodoNewActivity.a(this.this$0).getMeasuredHeight() - localRect.bottom;
      i = j;
      if (j > this.erR) {
        i = this.erR;
      }
      TodoNewActivity.a(this.this$0).getLayoutParams().height = i;
      TodoNewActivity.a(this.this$0).requestLayout();
    } while (i != this.erR);
    localRect.bottom = i;
    j = 0;
    i = 1;
    int k = this.tl.length - 1;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(paramEditable.toString(), this.tl[m] * this.this$0.getResources().getDisplayMetrics().density, localRect) <= localRect.bottom)
      {
        j = i;
        i = m + 1;
      }
      else
      {
        k = m - 1;
        j = k;
      }
    }
    this.mCurrentSize = this.tl[j];
    TodoNewActivity.a(this.this$0).setTextSize(this.mCurrentSize);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (paramCharSequence.toString().getBytes("UTF-8").length > TodoNewActivity.erP)
      {
        if (TextUtils.isEmpty(TodoNewActivity.a(this.this$0)))
        {
          TodoNewActivity.a(this.this$0).setText(aqmr.aL(TodoNewActivity.a(this.this$0).getText().toString(), TodoNewActivity.erP));
          return;
        }
        TodoNewActivity.a(this.this$0).setText(TodoNewActivity.a(this.this$0));
        TodoNewActivity.a(this.this$0).setSelection(TodoNewActivity.a(this.this$0).getText().length());
        if (this.this$0.djn)
        {
          this.this$0.djn = false;
          QQToast.a(this.this$0, "文字已达上限。", 0).show();
          TodoNewActivity.a(this.this$0).postDelayed(new TodoNewActivity.6.1(this), 3000L);
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auoz
 * JD-Core Version:    0.7.0.1
 */