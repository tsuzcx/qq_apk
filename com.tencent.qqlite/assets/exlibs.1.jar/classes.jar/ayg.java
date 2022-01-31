import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;

public class ayg
  implements TextWatcher
{
  public ayg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    NearbyPeopleProfileActivity.a(this.a, NearbyPeopleProfileActivity.b(this.a), 40);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayg
 * JD-Core Version:    0.7.0.1
 */