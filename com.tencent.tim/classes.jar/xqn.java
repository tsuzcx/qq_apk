import android.view.View;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import java.io.File;

class xqn
  implements xqk.c.a
{
  xqn(xqk.c paramc, String paramString, xqk.c.b paramb) {}
  
  public void N(int paramInt)
  {
    if (new File(this.val$videoPath).exists())
    {
      this.a.a.play(this.val$videoPath);
      this.a.wZ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqn
 * JD-Core Version:    0.7.0.1
 */