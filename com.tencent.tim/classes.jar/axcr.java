import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

class axcr
  implements axzv<Boolean>
{
  axcr(axco paramaxco) {}
  
  public void d(@Nullable Boolean paramBoolean)
  {
    int i = 200;
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = axco.a(this.a).getActivity().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if ((axco.a(this.a).aOx()) && (i != 202))
      {
        axco.a(this.a).setVisibility(0);
        return;
      }
      axco.a(this.a).setVisibility(8);
      return;
    }
    axco.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcr
 * JD-Core Version:    0.7.0.1
 */