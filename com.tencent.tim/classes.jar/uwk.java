import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView.f;

public class uwk
  implements DragSortListView.f
{
  public uwk(EmosmActivity paramEmosmActivity) {}
  
  public void drop(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.this$0.a.getItem(paramInt1);
      this.this$0.a.remove(localEmoticonPackage);
      this.this$0.a.setNotifyOnChange(true);
      this.this$0.a.insert(localEmoticonPackage, paramInt2);
      afkd.a().d(localEmoticonPackage, paramInt1, paramInt2);
      this.this$0.aVW = true;
      anot.a(this.this$0.app, "CliOper", "", "", "EmosSetting", "EpMove", 0, 0, "", "", "", "");
      if (this.this$0.mLaunchMode == 1) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AB10", "0X800AB10", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    anot.a(this.this$0.app, "dc00898", "", "", "0X800AB18", "0X800AB18", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwk
 * JD-Core Version:    0.7.0.1
 */