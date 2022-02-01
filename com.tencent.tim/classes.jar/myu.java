import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.b;
import java.util.ArrayList;
import org.json.JSONObject;

public class myu
  implements ReadInJoyDisLikeDialogView.b
{
  myu(myq parammyq, BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    myq.c(this.a, true);
    kxm.getAccount();
    myq.a(this.a).dismiss();
    ((Animation)myq.a(this.a).getTag(2131370016)).setAnimationListener(new myv(this, paramArrayList));
    myq.a(this.a).startAnimation((Animation)myq.a(this.a).getTag(2131370016));
    kbp.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new nce.a(kct.a(null, null, null, null, this.aA)).h(this.m.innerUniqueID).a(paramArrayList).a().toJsonString(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myu
 * JD-Core Version:    0.7.0.1
 */