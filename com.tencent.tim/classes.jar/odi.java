import com.tencent.widget.RangeButtonView.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "lastPosition", "", "newPosition", "onChange"}, k=3, mv={1, 1, 16})
final class odi
  implements RangeButtonView.a
{
  odi(odg paramodg) {}
  
  public final void dy(int paramInt1, int paramInt2)
  {
    odg.a(this.this$0, paramInt2);
    Object localObject = odg.a(this.this$0);
    if (localObject != null) {}
    for (float f = ((ncy)localObject).l(odg.a(this.this$0));; f = 0.0F)
    {
      awit.H("readinjoy_font_size_sp", Float.valueOf(f));
      awit.H("readinjoy_font_size_index_sp" + kxm.getAccount(), Integer.valueOf(odg.a(this.this$0)));
      localObject = odg.a(this.this$0);
      if (localObject != null) {
        ((odg.c)localObject).i(odg.a(this.this$0), f);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odi
 * JD-Core Version:    0.7.0.1
 */