import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class icv
  implements View.OnClickListener
{
  public icv(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(View paramView)
  {
    QzoneWebMusicJsPlugin.access$200(this.a, "buttonclick");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icv
 * JD-Core Version:    0.7.0.1
 */