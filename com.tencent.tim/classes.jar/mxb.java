import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView.b;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class mxb
  implements ReadInJoyDisLikeDialogView.b
{
  mxb(mwq parammwq, VideoInfo paramVideoInfo) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = kxm.getAccount();
    AdvertisementInfo localAdvertisementInfo;
    if (this.n != null)
    {
      if (mwq.a(this.b).articleInfo == null) {
        muj.x(this.n);
      }
      lbz.a().a(Long.valueOf(paramView).longValue(), this.n.articleInfo.makeDislikeParam(paramArrayList, this.n.Wz));
      localAdvertisementInfo = jzk.a(this.n.b);
      if ((paramObject == null) || (!(paramObject instanceof DislikeInfo))) {
        break label304;
      }
    }
    label301:
    label304:
    for (long l = ((DislikeInfo)paramObject).vf;; l = 0L)
    {
      paramView = "";
      int i = 0;
      if (i < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(i);
        if (paramObject == null) {
          break label301;
        }
        paramObject = paramView + paramObject.vf;
        paramView = paramObject;
        if (i != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
      for (;;)
      {
        i += 1;
        break;
        jzk.a(new kku.a().a(mwq.a(this.b)).a(jzk.aEL).b(jzk.aFA).a(localAdvertisementInfo).a(this.n.b).a(l).a(paramView).a());
        QQToast.a(mwq.a(this.b), -1, mwq.a(this.b).getString(2131701915), 0).show(mwq.a(this.b).getResources().getDimensionPixelSize(2131299627));
        mwq.a(this.b).dismiss();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxb
 * JD-Core Version:    0.7.0.1
 */