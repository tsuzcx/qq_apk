import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class yzk
  extends GridLayoutManager.SpanSizeLookup
{
  yzk(yzj paramyzj) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = yzj.a(this.a, paramInt);
    yzp localyzp = this.a.a(paramInt);
    if (localyzp != null) {
      return localyzp.c(localyzp.a(paramInt));
    }
    return ((GridLayoutManager)yzj.a(this.a)).getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzk
 * JD-Core Version:    0.7.0.1
 */