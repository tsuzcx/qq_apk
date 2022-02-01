import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;

public class mmk
  implements TextWatcher
{
  public mmk(EditVideoFragment paramEditVideoFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    EditVideoFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */