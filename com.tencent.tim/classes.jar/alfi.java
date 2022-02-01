import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.9.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

public class alfi
  implements TextWatcher
{
  private CharSequence aa;
  private int mEnd;
  private int mStart;
  
  public alfi(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.aa != null) && (aofy.ao(String.valueOf(this.aa), 3) > 300))
    {
      QQToast.a(this.a.getActivity(), 1, 2131690679, 0).show();
      paramEditable.delete(this.mStart, this.mEnd);
    }
    paramEditable = ales.d(StickyNotePublishFragment.a(this.a));
    if ((TextUtils.isEmpty(paramEditable)) || (TextUtils.isEmpty(paramEditable.trim()))) {
      this.a.NH(false);
    }
    for (;;)
    {
      if (StickyNotePublishFragment.a(this.a) != null) {
        StickyNotePublishFragment.a(this.a).post(new StickyNotePublishFragment.9.1(this));
      }
      return;
      this.a.NH(true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.aa = paramCharSequence;
    this.mStart = paramInt1;
    this.mEnd = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfi
 * JD-Core Version:    0.7.0.1
 */