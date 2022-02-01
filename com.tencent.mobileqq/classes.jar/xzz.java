import android.text.Editable;
import android.text.TextWatcher;

class xzz
  implements TextWatcher
{
  xzz(xzw paramxzw) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    xzd localxzd = this.a.a;
    if (this.a.a.a()) {}
    for (paramEditable = "2";; paramEditable = "1")
    {
      localxzd.a("search_poi", 0, 0, new String[] { paramEditable });
      xwb.a("0X80076D1");
      xwb.b("0X80075E6");
      xzw.a(this.a);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzz
 * JD-Core Version:    0.7.0.1
 */