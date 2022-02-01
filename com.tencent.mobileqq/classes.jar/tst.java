import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;

public class tst
  implements tss
{
  public tst(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == nzq.aA) && (tpp.g(ReadInJoyArticleBottomVideoView.a(this.a))))
    {
      tpp.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
      return;
    }
    if (paramInt == nzq.aB)
    {
      nzq.a(new tlx().a(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).a(nzq.a).b(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).d(paramInt).a());
      ReadInJoyArticleBottomVideoView.a(this.a);
      return;
    }
    Object localObject;
    boolean bool1;
    boolean bool2;
    if (ReadInJoyArticleBottomVideoView.a(this.a) != null) {
      if (ReadInJoyArticleBottomVideoView.a(this.a).v != null)
      {
        localObject = ReadInJoyArticleBottomVideoView.a(this.a).v;
        bool1 = bhny.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        long l = ReadInJoyArticleBottomVideoView.a(this.a).b;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = nzj.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        if (bool1) {
          break label325;
        }
      }
      label325:
      for (localObject = new tlt(false);; localObject = null)
      {
        AdvertisementInfo localAdvertisementInfo = tqb.a(ReadInJoyArticleBottomVideoView.a(this.a));
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        ubd.c(paramView.getContext(), localAdvertisementInfo, null, 2, true, (tlt)localObject);
        if (localAdvertisementInfo != null) {
          localAdvertisementInfo.setClickPos(paramInt);
        }
        tku.a(true, (Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), localAdvertisementInfo, 2, nzq.a, 3);
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
 * Qualified Name:     tst
 * JD-Core Version:    0.7.0.1
 */