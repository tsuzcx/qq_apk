import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.adapter.HeadCardAdapter;
import com.tencent.mobileqq.activity.contacts.adapter.HeadCardAdapter.HeadAdapterCallback;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.util.List;

public class wrv
  implements IIconListener
{
  public wrv(HeadCardAdapter paramHeadCardAdapter) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null))
    {
      List localList = HeadCardAdapter.a(this.a).a();
      paramInt2 = 0;
      if (paramInt2 < localList.size())
      {
        Object localObject2 = (View)localList.get(paramInt2);
        if (localObject2 == null) {}
        label167:
        for (;;)
        {
          paramInt2 += 1;
          break;
          if ((((View)localObject2).getTag() instanceof wrw)) {}
          for (Object localObject1 = (wrw)((View)localObject2).getTag();; localObject1 = null)
          {
            if ((localObject1 == null) || (!(((wrw)localObject1).a instanceof MayKnowRecommend))) {
              break label167;
            }
            localObject1 = (MayKnowRecommend)((wrw)localObject1).a;
            RichStatus localRichStatus = ((MayKnowRecommend)localObject1).getRichStatus();
            if ((localRichStatus == null) || (localRichStatus.actId != paramInt1)) {
              break;
            }
            localObject2 = (TextView)((View)localObject2).findViewById(2131363876);
            if (localObject2 == null) {
              break;
            }
            HeadCardAdapter.a(this.a, (MayKnowRecommend)localObject1, (TextView)localObject2, paramBitmap);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wrv
 * JD-Core Version:    0.7.0.1
 */