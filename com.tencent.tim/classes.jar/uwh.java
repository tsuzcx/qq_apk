import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class uwh
  extends acea
{
  public uwh(EmosmActivity paramEmosmActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramObject = (EmoticonResp)paramObject;
        this.this$0.AG(paramObject.delEpId);
        this.this$0.bF();
        this.this$0.a.cZL();
      }
    }
    label119:
    do
    {
      do
      {
        return;
        this.this$0.bNE();
        EmosmActivity.a(this.this$0, (EmoticonResp)paramObject);
        break;
        if (paramInt != 2) {
          break label119;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EmosmActivity", 2, "emoticon fetch:" + paramBoolean);
        }
      } while (!paramBoolean);
      this.this$0.runOnUiThread(this.this$0.dP);
      return;
    } while (paramInt != 17);
    if (paramBoolean)
    {
      paramObject = ((EmoticonResp)paramObject).ids.iterator();
      while (paramObject.hasNext())
      {
        Integer localInteger = (Integer)paramObject.next();
        this.this$0.AG(localInteger.intValue());
      }
    }
    this.this$0.bNE();
    EmosmActivity.a(this.this$0, (EmoticonResp)paramObject);
    this.this$0.bF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwh
 * JD-Core Version:    0.7.0.1
 */