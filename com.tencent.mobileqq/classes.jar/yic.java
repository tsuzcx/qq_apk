import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class yic
  extends GridLayoutManager.SpanSizeLookup
{
  yic(yib paramyib) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = this.a.a(paramInt);
    yhy localyhy = this.a.a(paramInt);
    if (localyhy != null) {
      return localyhy.getSpanCount(localyhy.getLocalPosition(paramInt));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yic
 * JD-Core Version:    0.7.0.1
 */