import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.widget.AdapterView.b;

public class nfc
  extends AdapterView.b
{
  public nfc(ReadInJoyFlowLayout paramReadInJoyFlowLayout)
  {
    super(paramReadInJoyFlowLayout);
  }
  
  public void clearSavedState()
  {
    super.clearSavedState();
  }
  
  public void onChanged()
  {
    super.onChanged();
    ReadInJoyFlowLayout.a(this.a);
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    ReadInJoyFlowLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nfc
 * JD-Core Version:    0.7.0.1
 */