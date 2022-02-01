import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;
import java.util.List;

public class arqr
  implements AdapterView.c
{
  public arqr(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.mSearchResultList.get(paramInt);
    if ((paramAdapterView == null) || (this.a.a.so(paramAdapterView.openId))) {
      return;
    }
    if (this.a.a.bA() >= this.a.ekM)
    {
      this.a.elh();
      return;
    }
    paramView = (OpenFrame)this.a.b.getCurrentView();
    this.a.aQ.add(paramAdapterView);
    this.a.a.WZ(paramAdapterView.openId);
    this.a.cAc();
    paramView.notifyDataSetChanged();
    this.a.cz(false);
    this.a.I.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqr
 * JD-Core Version:    0.7.0.1
 */