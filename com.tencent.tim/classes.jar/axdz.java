import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class axdz
  implements View.OnClickListener
{
  axdz(axdy paramaxdy, int paramInt) {}
  
  public void onClick(View paramView)
  {
    axdy.a(this.b, this.val$position);
    axby localaxby;
    if (this.val$position != axdy.a(this.b))
    {
      int i = axdy.a(this.b);
      axdy.a(this.b, this.val$position);
      this.b.notifyItemChanged(this.val$position);
      this.b.notifyItemChanged(i);
      if (axdy.a(this.b) != null)
      {
        axdy.a locala = axdy.a(this.b);
        if (this.val$position != 0) {
          break label136;
        }
        localaxby = null;
        locala.c(localaxby);
        if (this.val$position != 0) {
          break label161;
        }
        axip.a().acY("none");
        axim.a().eLm();
        axiy.i("AEGIFStickerAdapter", "【Gif Material Click】: null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label136:
      localaxby = (axby)axdy.a(this.b).get(this.val$position - 1);
      break;
      label161:
      axip.a().acY(((axby)axdy.a(this.b).get(this.val$position - 1)).id);
      axim.a().eLm();
      axiy.i("AEGIFStickerAdapter", "【Gif Material Click】: " + ((axby)axdy.a(this.b).get(this.val$position - 1)).id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdz
 * JD-Core Version:    0.7.0.1
 */