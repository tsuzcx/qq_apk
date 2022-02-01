import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView.UpdateTroopMembersFaceTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apwd
  implements View.OnClickListener
{
  public apwd(TroopMoreDetailView.UpdateTroopMembersFaceTask paramUpdateTroopMembersFaceTask, TroopMoreDetailView paramTroopMoreDetailView) {}
  
  public void onClick(View paramView)
  {
    this.b.bLg();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwd
 * JD-Core Version:    0.7.0.1
 */