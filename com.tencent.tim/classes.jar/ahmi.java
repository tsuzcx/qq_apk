import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ahmi
  extends GridLayoutManager.SpanSizeLookup
{
  ahmi(ahme.a parama) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.b.getItemViewType(paramInt) == ahme.cZX) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmi
 * JD-Core Version:    0.7.0.1
 */