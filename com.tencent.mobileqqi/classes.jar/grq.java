import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class grq
  implements AdapterView.OnItemLongClickListener
{
  public grq(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.c) {
      TroopAvatarWallPreviewActivity.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     grq
 * JD-Core Version:    0.7.0.1
 */