import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;

public class unp
  implements unn
{
  public unp(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 17) && (uki.g(ReadInJoyArticleBottomVideoView.a(this.a)))) {
      uki.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
    }
    long l;
    do
    {
      return;
      if (paramInt != 21) {
        break;
      }
      ois.a(new ufy().a(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).a(1).b(ReadInJoyArticleBottomVideoView.a(this.a)).a(JumpMode.UNKNOWN).a(ReadInJoyArticleBottomVideoView.a(this.a)).d(paramInt).a());
      l = System.currentTimeMillis();
    } while (l - ReadInJoyArticleBottomVideoView.a(this.a) <= 500L);
    ReadInJoyArticleBottomVideoView.a(this.a, l);
    ReadInJoyArticleBottomVideoView.e(this.a);
    return;
    Object localObject;
    boolean bool1;
    boolean bool2;
    if (ReadInJoyArticleBottomVideoView.a(this.a) != null) {
      if (ReadInJoyArticleBottomVideoView.a(this.a).v != null)
      {
        localObject = ReadInJoyArticleBottomVideoView.a(this.a).v;
        bool1 = bhfn.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = oil.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        if (bool1) {
          break label348;
        }
      }
      label348:
      for (localObject = new ufu(false);; localObject = null)
      {
        AdvertisementInfo localAdvertisementInfo = ukt.a(ReadInJoyArticleBottomVideoView.a(this.a));
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        paramView = uvp.d(paramView.getContext(), localAdvertisementInfo, null, 2, true, (ufu)localObject);
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        uec.a(ReportAction.CLICK, paramView, (Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), localAdvertisementInfo, 2, 1, 3);
        return;
        ReadInJoyArticleBottomVideoView.a(this.a, paramView, true, paramInt);
        return;
      }
      bool2 = false;
      continue;
      bool1 = false;
      localObject = "";
      break;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unp
 * JD-Core Version:    0.7.0.1
 */