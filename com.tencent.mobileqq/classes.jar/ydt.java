import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ydt
  extends GridLayoutManager.SpanSizeLookup
{
  ydt(yds paramyds) {}
  
  public int getSpanSize(int paramInt)
  {
    ydp localydp = this.a.b(paramInt);
    if (localydp != null) {
      return localydp.a(localydp.b(paramInt));
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydt
 * JD-Core Version:    0.7.0.1
 */