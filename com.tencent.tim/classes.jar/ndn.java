import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.17.2;
import java.util.ArrayList;

public class ndn
  implements autw.a
{
  ndn(ndi paramndi, int paramInt, lgf.i parami, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (paramInt == this.aKd)
    {
      this.this$0.aVX();
      paramView = (Animation)this.a.itemView.getTag(2131370016);
      paramView.setAnimationListener(new ndo(this, paramArrayList, paramObject));
      this.a.itemView.post(new ReadInJoyBaseAdapter.17.2(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndn
 * JD-Core Version:    0.7.0.1
 */