import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class eln
  implements AdapterView.OnItemLongClickListener
{
  public eln(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.c) {
      TroopAvatarWallPreviewActivity.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eln
 * JD-Core Version:    0.7.0.1
 */