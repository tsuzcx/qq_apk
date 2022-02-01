import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class yvu
  extends GridLayoutManager.SpanSizeLookup
{
  yvu(yvt paramyvt, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.a.gN(paramInt)) || (this.a.gO(paramInt)) || (this.a.gP(paramInt)) || (this.a.UE())) {
      return this.b.getSpanCount();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvu
 * JD-Core Version:    0.7.0.1
 */