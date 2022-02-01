import android.app.Activity;
import android.os.Bundle;
import mqq.util.WeakReference;

class aswj
  extends aeaz.b
{
  aswj(aswg paramaswg) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (aswg.a(this.a) == null) {}
    do
    {
      return;
      paramBundle = (Activity)aswg.a(this.a).get();
    } while (paramBundle == null);
    paramBundle.moveTaskToBack(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswj
 * JD-Core Version:    0.7.0.1
 */