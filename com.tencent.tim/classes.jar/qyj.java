import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

class qyj
  extends qwo
{
  qyj(qyi paramqyi) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if (rpq.isFastDoubleClick()) {}
    label6:
    do
    {
      do
      {
        do
        {
          break label6;
          do
          {
            return;
          } while ((paramInt < 0) || (paramInt >= this.a.la.size()));
          paramObject = (StoryVideoItem)this.a.la.get(paramInt);
        } while (TextUtils.isEmpty(paramObject.mOwnerUid));
        paramObject = qyi.a(this.a).b(paramObject.mOwnerUid);
      } while (paramObject == null);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (qyi.a(this.a) == null);
    qyi.a(this.a).a(paramView, this.a.e, paramObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qyj
 * JD-Core Version:    0.7.0.1
 */