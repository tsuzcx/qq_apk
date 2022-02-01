import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class ksf
  extends Editable.Factory
{
  public ksf(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof kpo)) {
      return (Editable)paramCharSequence;
    }
    return new kpo(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksf
 * JD-Core Version:    0.7.0.1
 */