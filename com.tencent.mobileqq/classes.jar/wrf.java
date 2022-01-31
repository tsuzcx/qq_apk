import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

class wrf
  implements bhwg<Boolean>
{
  wrf(wrc paramwrc) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    int i = 200;
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = wrc.a(this.a).a().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if ((wrc.a(this.a).a()) && (i != 202))
      {
        wrc.a(this.a).setVisibility(0);
        return;
      }
      wrc.a(this.a).setVisibility(8);
      return;
    }
    wrc.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrf
 * JD-Core Version:    0.7.0.1
 */