import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class zxp
  extends GridLayoutManager.SpanSizeLookup
{
  zxp(zxo paramzxo) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = zxo.a(this.a, paramInt);
    zxu localzxu = this.a.a(paramInt);
    if (localzxu != null) {
      return localzxu.getSpanCount(localzxu.getLocalPosition(paramInt));
    }
    return ((GridLayoutManager)zxo.a(this.a)).getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxp
 * JD-Core Version:    0.7.0.1
 */