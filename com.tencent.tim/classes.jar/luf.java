import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import java.util.List;

class luf
  extends EventCallback
{
  luf(lty paramlty) {}
  
  public void onPagerChange(int paramInt)
  {
    lty.dh(paramInt);
    if ((lty.aW() != null) && (!lty.aW().contains(Integer.valueOf(paramInt)))) {
      lty.aW().add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     luf
 * JD-Core Version:    0.7.0.1
 */