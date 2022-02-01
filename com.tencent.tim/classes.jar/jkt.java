import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class jkt
{
  private ClipDrawable b;
  private LayerDrawable c;
  private Drawable ch;
  private Activity l;
  
  public jkt(Activity paramActivity)
  {
    this.l = paramActivity;
    initDrawable();
  }
  
  private void initDrawable()
  {
    this.ch = this.l.getResources().getDrawable(2130842889);
    this.b = ((ClipDrawable)this.l.getResources().getDrawable(2130842888));
    this.c = new LayerDrawable(new Drawable[] { this.ch, this.b });
    this.c.setLayerInset(0, 0, 0, 0, 0);
    this.c.setLayerInset(1, 0, 0, 0, 0);
    this.c.setBounds(0, 0, this.ch.getIntrinsicWidth(), this.ch.getIntrinsicHeight());
  }
  
  public Drawable ag()
  {
    return this.c;
  }
  
  public void nM(int paramInt)
  {
    this.b.setLevel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkt
 * JD-Core Version:    0.7.0.1
 */