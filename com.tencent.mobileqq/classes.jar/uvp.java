import android.text.Editable;
import android.text.TextWatcher;

class uvp
  implements TextWatcher
{
  uvp(uvm paramuvm) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    uut localuut = this.a.a;
    if (this.a.a.a()) {}
    for (paramEditable = "2";; paramEditable = "1")
    {
      localuut.a("search_poi", 0, 0, new String[] { paramEditable });
      urq.a("0X80076D1");
      urq.b("0X80075E6");
      uvm.a(this.a);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvp
 * JD-Core Version:    0.7.0.1
 */