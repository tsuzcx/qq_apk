import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class rxo
  extends GridLayoutManager.SpanSizeLookup
{
  rxo(rxn paramrxn) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = rxn.a(this.this$0, paramInt);
    rxq localrxq = this.this$0.a(paramInt);
    if (localrxq != null) {
      return localrxq.getSpanCount(localrxq.getLocalPosition(paramInt));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxo
 * JD-Core Version:    0.7.0.1
 */