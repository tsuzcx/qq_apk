import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.HornPublishActivity;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.utils.VipUtils;

public class cwr
  implements TextWatcher
{
  public cwr(HornPublishActivity paramHornPublishActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((!VipUtils.a(this.a.b)) && (!TextUtils.isEmpty(paramEditable.toString())) && (this.a.a.d + this.a.a.e + this.a.a.f == 0)) {
      HornPublishActivity.a(this.a);
    }
    HornPublishActivity.c(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwr
 * JD-Core Version:    0.7.0.1
 */