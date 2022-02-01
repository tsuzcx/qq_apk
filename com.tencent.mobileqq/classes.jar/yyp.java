import android.text.Editable;
import android.text.TextWatcher;

class yyp
  implements TextWatcher
{
  yyp(yym paramyym) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    yxt localyxt = this.a.a;
    if (this.a.a.a()) {}
    for (paramEditable = "2";; paramEditable = "1")
    {
      localyxt.a("search_poi", 0, 0, new String[] { paramEditable });
      yuq.a("0X80076D1");
      yuq.b("0X80075E6");
      yym.a(this.a);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyp
 * JD-Core Version:    0.7.0.1
 */