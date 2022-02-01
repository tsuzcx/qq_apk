import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment;

public class mkc
  implements TextWatcher
{
  private int aTA;
  
  public mkc(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int k = paramEditable.length();
    int i;
    int j;
    label24:
    Drawable[] arrayOfDrawable;
    if (this.aTA > 0)
    {
      i = 1;
      if (k <= 0) {
        break label156;
      }
      j = 1;
      if ((j ^ i) != 0)
      {
        arrayOfDrawable = ReadInJoyUgcSearchTopicFragment.a(this.this$0).getCompoundDrawables();
        if (k <= 0) {
          break label161;
        }
        Drawable localDrawable = this.this$0.getResources().getDrawable(2130839802);
        localDrawable.setBounds(0, 0, aqnm.dpToPx(16.0F), aqnm.dpToPx(16.0F));
        arrayOfDrawable[2] = localDrawable;
      }
    }
    for (;;)
    {
      ReadInJoyUgcSearchTopicFragment.a(this.this$0).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      this.aTA = k;
      ReadInJoyUgcSearchTopicFragment.a(this.this$0, paramEditable.toString());
      if (paramEditable.length() <= 0) {
        break label169;
      }
      lbz.a().mV(ReadInJoyUgcSearchTopicFragment.a(this.this$0));
      return;
      i = 0;
      break;
      label156:
      j = 0;
      break label24;
      label161:
      arrayOfDrawable[2] = null;
    }
    label169:
    ReadInJoyUgcSearchTopicFragment.a(this.this$0).setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkc
 * JD-Core Version:    0.7.0.1
 */