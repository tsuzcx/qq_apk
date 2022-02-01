import android.database.DataSetObserver;
import com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel;

public class ajtt
  extends DataSetObserver
{
  public ajtt(PlayerInvitePanel paramPlayerInvitePanel) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.b.layoutChildren();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtt
 * JD-Core Version:    0.7.0.1
 */