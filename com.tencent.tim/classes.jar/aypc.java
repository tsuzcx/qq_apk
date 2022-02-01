import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public abstract class aypc
  implements TextWatcher, TextView.OnEditorActionListener
{
  protected aypc.a a;
  protected EditText editText;
  protected TextView hintText;
  
  @NonNull
  public static aypc a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unSupport interactType:" + paramInt);
    }
    return new aypd();
  }
  
  public void a(Context paramContext, aypc.b paramb, EditText paramEditText, TextView paramTextView, aypc.a parama)
  {
    this.editText = paramEditText;
    this.hintText = paramTextView;
    this.editText.setOnEditorActionListener(this);
    this.editText.addTextChangedListener(this);
    this.a = parama;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public abstract aypc.b b();
  
  protected void b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.editText.setHint(paramCharSequence);
      this.editText.getText().clear();
      return;
    }
    this.editText.setText(paramCharSequence);
    this.editText.setSelection(this.editText.getText().length());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected abstract View cO();
  
  protected void d(CharSequence paramCharSequence, int paramInt)
  {
    int i = aqmr.getWordCountNeo(paramCharSequence.toString());
    if (paramInt - i <= 6)
    {
      this.hintText.setVisibility(0);
      this.hintText.setText(String.format("%s/%s", new Object[] { Integer.valueOf(i / 2), Integer.valueOf(paramInt / 2) }));
      return;
    }
    this.hintText.setVisibility(4);
  }
  
  public void onDetachedFromWindow() {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void eTg();
  }
  
  public static class b
  {
    public final Bitmap bitmap;
    public final Rect[] d;
    public final boolean dzo;
    public final String[] jn;
    
    public b(Bitmap paramBitmap, String[] paramArrayOfString, Rect[] paramArrayOfRect, boolean paramBoolean)
    {
      this.bitmap = paramBitmap;
      this.jn = paramArrayOfString;
      this.d = paramArrayOfRect;
      this.dzo = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypc
 * JD-Core Version:    0.7.0.1
 */