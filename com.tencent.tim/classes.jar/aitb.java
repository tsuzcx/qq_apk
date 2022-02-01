import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.location.ui.LocationPickFragment;

public class aitb
  implements TextWatcher
{
  public aitb(LocationPickFragment paramLocationPickFragment, View paramView1, View paramView2, View paramView3) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      this.DR.setVisibility(8);
      this.DS.setVisibility(0);
      this.DT.setVisibility(0);
    }
    for (;;)
    {
      paramEditable = paramEditable.toString().trim();
      if (TextUtils.isEmpty(paramEditable)) {
        break;
      }
      LocationPickFragment.a(this.this$0).Iq(paramEditable);
      return;
      this.DR.setVisibility(0);
      this.DS.setVisibility(8);
      this.DT.setVisibility(8);
    }
    LocationPickFragment.a(this.this$0).Iq("");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitb
 * JD-Core Version:    0.7.0.1
 */