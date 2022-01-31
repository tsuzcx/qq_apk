import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.StatisticAssist;
import java.util.Iterator;
import java.util.List;

public class cqr
  implements View.OnClickListener
{
  public cqr(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = EmosmActivity.a(this.a).getSelectedPackages().iterator();
    while (paramView.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramView.next();
      EmosmActivity.a(this.a).b(localEmoticonPackage.epId);
      EmosmActivity.a(this.a).setNotifyOnChange(true);
      EmosmActivity.a(this.a).remove(localEmoticonPackage);
      EmoticonController.a(this.a.b).b(localEmoticonPackage);
      StatisticAssist.a(this.a, this.a.b.a(), "Delete_ep");
      EmosmActivity.a(this.a, localEmoticonPackage);
    }
    EmosmActivity.a(this.a).clearSelectStatus();
    EmosmActivity.a(this.a).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqr
 * JD-Core Version:    0.7.0.1
 */