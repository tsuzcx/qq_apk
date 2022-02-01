import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

public class auwr
  extends GridLayoutManager.SpanSizeLookup
{
  private GridLayoutManager.SpanSizeLookup jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup;
  private final auwz jdField_a_of_type_Auwz;
  private final GridLayoutManager mLayoutManager;
  
  public auwr(auwz paramauwz, GridLayoutManager paramGridLayoutManager)
  {
    this.jdField_a_of_type_Auwz = paramauwz;
    this.mLayoutManager = paramGridLayoutManager;
  }
  
  public int getSpanSize(int paramInt)
  {
    int j = 1;
    int i;
    if ((this.jdField_a_of_type_Auwz.ni(paramInt)) || (this.jdField_a_of_type_Auwz.nj(paramInt)))
    {
      i = 1;
      if (i == 0) {
        break label45;
      }
      i = this.mLayoutManager.getSpanCount();
    }
    label45:
    do
    {
      return i;
      i = 0;
      break;
      i = j;
    } while (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup == null);
    return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup.getSpanSize(paramInt - this.jdField_a_of_type_Auwz.rl());
  }
  
  public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager$SpanSizeLookup = paramSpanSizeLookup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwr
 * JD-Core Version:    0.7.0.1
 */