import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

final class odt
  implements ViewBase.OnClickListener
{
  odt(ArticleInfo paramArticleInfo, Activity paramActivity, ndi paramndi, int paramInt1, int paramInt2, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool2 = false;
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.d;
    ods.b(this.val$context, localAdvertisementInfo, this.c, this.aMH);
    int j = this.bev;
    int i = j;
    if (j == 6) {
      if ((this.c != null) && (this.c.a() != null))
      {
        i = j;
        if (this.c.a().isPlaying()) {}
      }
      else
      {
        i = 5;
      }
    }
    if (this.bev == 103) {
      i = 101;
    }
    for (j = 1;; j = 0)
    {
      if (this.bev == 104)
      {
        i = 102;
        j = 1;
      }
      for (;;)
      {
        knd.a(localAdvertisementInfo, i, null);
        paramViewBase = null;
        if (this.c != null) {
          paramViewBase = this.c.a();
        }
        if ((knd.m((AdvertisementInfo)this.d)) && ((this.bev == 4) || (this.bev == 3) || (this.bev == 1)))
        {
          if (this.bev == 1) {
            i = 3;
          }
          knd.h(this.val$context, 1);
          ods.cn(this.val$context);
          ods.b(this.val$context, (AdvertisementInfo)this.d);
          jzk.a(new kku.a().a(this.val$context).a(jzk.aEJ).b(jzk.aFT).a((AdvertisementInfo)this.d).d(i).a());
        }
        while (ods.a(this.d, this.b, this.val$context, this.aMH, paramViewBase, localAdvertisementInfo)) {
          return;
        }
        boolean bool1 = bool2;
        if (this.bev != 6)
        {
          bool1 = bool2;
          if (this.bev != 5) {
            if ((this.c != null) && ((this.aMH == 0) || (kys.du(this.aMH))))
            {
              paramViewBase = this.c;
              bool1 = bool2;
              if (ndi.b(localAdvertisementInfo, this.aMH) != 104)
              {
                paramViewBase = this.c;
                bool1 = bool2;
                if (ndi.b(localAdvertisementInfo, this.aMH) == 105) {}
              }
            }
            else
            {
              if (j != 0) {
                break label479;
              }
              bool1 = bool2;
              if (this.bev != 101) {
                if (this.bev != 102) {
                  break label479;
                }
              }
            }
          }
        }
        label479:
        for (bool1 = bool2;; bool1 = true)
        {
          paramViewBase = new kks();
          if (this.bev == 8) {
            paramViewBase.afZ = true;
          }
          if (ods.b(this.val$context, this.c, this.d)) {
            break;
          }
          ods.a(this.val$context, localAdvertisementInfo, this.c, this.aMH, bool1, knc.b((AdvertisementInfo)this.d), paramViewBase);
          knj.a().pl(4);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odt
 * JD-Core Version:    0.7.0.1
 */