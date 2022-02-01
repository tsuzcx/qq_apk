import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ahjp
  extends GridLayoutManager.SpanSizeLookup
{
  ahjp(ahjl.a parama) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.b.getItemViewType(paramInt) == ahjl.cZX) {
      return 5;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjp
 * JD-Core Version:    0.7.0.1
 */