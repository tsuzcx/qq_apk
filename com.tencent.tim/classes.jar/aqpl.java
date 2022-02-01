import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aqpl
  extends GridLayoutManager.SpanSizeLookup
{
  aqpl(aqpk paramaqpk) {}
  
  public int getSpanSize(int paramInt)
  {
    int i = 3;
    switch (this.b.getItemViewType(paramInt))
    {
    default: 
      i = 1;
    case 1: 
    case 2: 
    case 4: 
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpl
 * JD-Core Version:    0.7.0.1
 */