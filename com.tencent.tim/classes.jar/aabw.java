import android.widget.EditText;

public class aabw
  extends aabi
{
  private int digits = 2;
  
  public aabw(EditText paramEditText)
  {
    super(paramEditText);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.toString().contains("."))
    {
      localCharSequence = paramCharSequence;
      if (paramCharSequence.length() - 1 - paramCharSequence.toString().indexOf(".") > this.digits)
      {
        localCharSequence = paramCharSequence.toString().subSequence(0, paramCharSequence.toString().indexOf(".") + this.digits + 1);
        this.editText.setText(localCharSequence);
        this.editText.setSelection(localCharSequence.length());
      }
    }
    paramCharSequence = localCharSequence;
    if (localCharSequence.toString().trim().substring(0).equals("."))
    {
      paramCharSequence = "0" + localCharSequence;
      this.editText.setText(paramCharSequence);
      this.editText.setSelection(2);
    }
    if ((paramCharSequence.toString().startsWith("0")) && (paramCharSequence.toString().trim().length() > 1) && (!paramCharSequence.toString().substring(1, 2).equals(".")))
    {
      this.editText.setText(paramCharSequence.subSequence(0, 1));
      this.editText.setSelection(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabw
 * JD-Core Version:    0.7.0.1
 */