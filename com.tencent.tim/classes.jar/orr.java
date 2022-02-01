import UserGrowth.stOpVideo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class orr
  extends ogm<oqr>
  implements View.OnClickListener
{
  private stOpVideo a;
  private KandianUrlImageView ae;
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private TextView vq;
  
  public orr(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private static WSDownloadParams a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt, String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = oql.aX(paramWSVerticalPageFragment.getFrom());
    localWSDownloadParams.mLinkStrategyType = ohy.a().rp();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = opn.getSceneTypeTestId(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void bel()
  {
    String str2;
    String str3;
    ojw localojw;
    WSVerticalPageFragment localWSVerticalPageFragment;
    if (this.a != null)
    {
      str2 = this.c.getFrom();
      str3 = this.c.getPlayScene();
      localojw = new ojw(getContext()).a(this.a.jump);
      localWSVerticalPageFragment = this.c;
      if (this.a.jump == null) {
        break label103;
      }
    }
    label103:
    for (String str1 = this.a.jump.schema;; str1 = "")
    {
      localojw.a(a(localWSVerticalPageFragment, 17, str1)).a(new ors(this, str2, str3)).bfC();
      return;
    }
  }
  
  protected void Hp() {}
  
  protected int gn()
  {
    return 2131560221;
  }
  
  protected void initView()
  {
    this.ae = ((KandianUrlImageView)findViewById(2131369965));
    this.vq = ((TextView)findViewById(2131381034));
    this.ae.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bel();
    }
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    Object localObject = (oqr)getData();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(((oqr)localObject).B() instanceof stSimpleMetaFeed));
        this.h = ((stSimpleMetaFeed)((oqr)localObject).B());
        this.a = this.h.opVideo;
      } while (this.a == null);
      if (!TextUtils.isEmpty(this.a.img_url))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130842541);
        opn.a(this.ae, this.a.img_url, (Drawable)localObject);
        osv.a(this.h, this.c.getFrom(), this.c.getPlayScene());
      }
    } while (TextUtils.isEmpty(this.a.text));
    this.vq.setText(this.a.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orr
 * JD-Core Version:    0.7.0.1
 */