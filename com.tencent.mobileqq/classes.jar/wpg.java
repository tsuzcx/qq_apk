import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class wpg
  extends GridLayoutManager.SpanSizeLookup
{
  wpg(wpf paramwpf) {}
  
  public int getSpanSize(int paramInt)
  {
    wpc localwpc = this.a.b(paramInt);
    if (localwpc != null) {
      return localwpc.a(localwpc.b(paramInt));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpg
 * JD-Core Version:    0.7.0.1
 */