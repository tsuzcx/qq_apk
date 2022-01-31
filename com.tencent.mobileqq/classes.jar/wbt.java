import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class wbt
  extends GridLayoutManager.SpanSizeLookup
{
  wbt(wbs paramwbs) {}
  
  public int getSpanSize(int paramInt)
  {
    wbp localwbp = this.a.b(paramInt);
    if (localwbp != null) {
      return localwbp.a(localwbp.b(paramInt));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wbt
 * JD-Core Version:    0.7.0.1
 */