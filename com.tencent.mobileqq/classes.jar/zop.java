import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class zop
  extends GridLayoutManager.SpanSizeLookup
{
  zop(zoo paramzoo) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = zoo.a(this.a, paramInt);
    zou localzou = this.a.a(paramInt);
    if (localzou != null) {
      return localzou.c(localzou.a(paramInt));
    }
    return ((GridLayoutManager)zoo.a(this.a)).getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zop
 * JD-Core Version:    0.7.0.1
 */