import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class vxy
  extends acfd
{
  public vxy(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.this$0.a == null) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean1);
      this.this$0.hp = aizp.a().a(this.this$0.app, this.this$0.rj);
    } while (this.this$0.hp == null);
    this.this$0.a.ac(this.this$0.hp);
    this.this$0.a.notifyDataSetChanged();
    this.this$0.bWo();
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    if (this.this$0.a == null) {
      return;
    }
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Integer localInteger = (Integer)paramMap.get(str);
        if (localInteger != null) {
          this.this$0.hp.put(str, localInteger);
        }
      }
      this.this$0.a.ac(this.this$0.hp);
      this.this$0.a.notifyDataSetChanged();
      this.this$0.bWo();
      return;
    }
    this.this$0.a.notifyDataSetChanged();
    this.this$0.bWo();
    QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131721435), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxy
 * JD-Core Version:    0.7.0.1
 */