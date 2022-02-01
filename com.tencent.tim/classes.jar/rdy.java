import android.text.Editable;
import android.text.TextWatcher;

class rdy
  implements TextWatcher
{
  rdy(rdv paramrdv) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    rdc localrdc = this.this$0.b;
    if (this.this$0.b.La()) {}
    for (paramEditable = "2";; paramEditable = "1")
    {
      localrdc.c("search_poi", 0, 0, new String[] { paramEditable });
      ras.so("0X80076D1");
      ras.sp("0X80075E6");
      rdv.a(this.this$0);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdy
 * JD-Core Version:    0.7.0.1
 */