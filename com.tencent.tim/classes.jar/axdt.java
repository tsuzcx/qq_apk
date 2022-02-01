import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class axdt
  implements axzv<axdl.a>
{
  axdt(axdr paramaxdr, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable axdl.a parama)
  {
    if (parama != null)
    {
      this.b.setTextColor(parama.textColor);
      this.b.setOutlineColor(parama.cTQ);
      if (parama.textColor.equals("#ccffffff"))
      {
        this.b.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
        this.b.setShadow(true);
        this.b.setStroke(false);
      }
    }
    else
    {
      return;
    }
    this.b.setShadow(false);
    this.b.setStroke(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdt
 * JD-Core Version:    0.7.0.1
 */