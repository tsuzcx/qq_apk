import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class wpd
  extends GridLayoutManager.SpanSizeLookup
{
  wpd(wpc paramwpc) {}
  
  public int getSpanSize(int paramInt)
  {
    woz localwoz = this.a.b(paramInt);
    if (localwoz != null) {
      return localwoz.a(localwoz.b(paramInt));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpd
 * JD-Core Version:    0.7.0.1
 */