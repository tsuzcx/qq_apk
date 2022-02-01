import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;

public class tzn
  implements tzl
{
  public tzn(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == obb.aB) && (twh.g(ReadInJoyArticleBottomVideoView.a(this.a)))) {
      twh.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
    }
    long l;
    do
    {
      return;
      if (paramInt != obb.aC) {
        break;
      }
      obb.a(new trn().a(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).a(obb.a).b(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).d(paramInt).a());
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
        bool1 = bfwv.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = oau.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        if (bool1) {
          break label345;
        }
      }
      label345:
      for (localObject = new trj(false);; localObject = null)
      {
        AdvertisementInfo localAdvertisementInfo = tws.a(ReadInJoyArticleBottomVideoView.a(this.a));
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        uhs.c(paramView.getContext(), localAdvertisementInfo, null, 2, true, (trj)localObject);
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        tqk.a(true, (Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), localAdvertisementInfo, 2, obb.a, 3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tzn
 * JD-Core Version:    0.7.0.1
 */