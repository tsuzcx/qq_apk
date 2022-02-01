import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.b;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import org.json.JSONObject;

class mxd
  implements ReadInJoyDisLikeDialogView.b
{
  mxd(mwq.b paramb, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = kxm.getAccount();
    if (this.n != null) {
      lbz.a().a(Long.valueOf(paramView).longValue(), mwq.a(this.a.b).articleInfo.makeDislikeParam(paramArrayList, mwq.a(this.a.b).Wz));
    }
    QQToast.a(mwq.a(this.a.b), -1, mwq.a(this.a.b).getString(2131701914), 0).show(mwq.a(this.a.b).getResources().getDimensionPixelSize(2131299627));
    mwq.a(this.a.b).dismiss();
    mwq.b(this.a.b, false);
    kbp.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new nce.a(kct.a(null, null, null, null, this.aA)).h(this.n.Wz).a(paramArrayList).a().toJsonString(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxd
 * JD-Core Version:    0.7.0.1
 */