import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;

public class khk
  extends Editable.Factory
{
  public khk(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof kpo)) {
      return (Editable)paramCharSequence;
    }
    return new kpo(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khk
 * JD-Core Version:    0.7.0.1
 */