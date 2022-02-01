import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class ckk
  implements DragSortListView.DropListener
{
  public ckk(EmosmActivity paramEmosmActivity) {}
  
  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)EmosmActivity.a(this.a).getItem(paramInt1);
      EmosmActivity.a(this.a).remove(localEmoticonPackage);
      EmosmActivity.a(this.a).setNotifyOnChange(true);
      EmosmActivity.a(this.a).insert(localEmoticonPackage, paramInt2);
      EmoticonController.a(this.a.b).a(localEmoticonPackage, paramInt1, paramInt2);
      this.a.c = true;
      StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "Ep_order");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckk
 * JD-Core Version:    0.7.0.1
 */