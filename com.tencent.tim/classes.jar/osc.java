import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class osc
  extends ogm<oqr>
  implements View.OnClickListener
{
  private KandianUrlImageView K;
  private stNewIconStyle a;
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private TextView mText;
  private View nB;
  
  public osc(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private boolean b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return (paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.floatingLayerCardStyle != null) && (paramstSimpleMetaFeed.floatingLayerCardStyle.cardType == 1);
  }
  
  private void qY(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a != null) && (!TextUtils.isEmpty(this.a.title)))
    {
      this.mText.setVisibility(0);
      this.K.setVisibility(0);
      this.nB.setVisibility(0);
      Object localObject = this.nB;
      if (b(this.h)) {}
      for (int i = 2130843530;; i = 2130843529)
      {
        ((View)localObject).setBackgroundResource(i);
        if ((b(this.h)) && (TextUtils.isEmpty(this.a.iconUrl))) {
          this.a.iconUrl = "https://isee.weishi.qq.com/news/wesee_logo_yunying.png";
        }
        this.mText.setText(this.a.title);
        if (TextUtils.isEmpty(this.a.iconUrl)) {
          break;
        }
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130844013);
        opn.a(this.K, this.a.iconUrl, (Drawable)localObject);
        return;
      }
      this.K.setImageResource(2130844013);
      return;
    }
    this.K.setVisibility(8);
    this.mText.setVisibility(8);
    this.nB.setVisibility(8);
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed)))
    {
      this.h = ((stSimpleMetaFeed)localoqr.B());
      this.a = this.h.new_icon;
    }
  }
  
  protected int gn()
  {
    return 2131560228;
  }
  
  protected void initView()
  {
    this.nB = findViewById(2131381562);
    this.nB.setOnClickListener(this);
    this.K = ((KandianUrlImageView)findViewById(2131381564));
    this.mText = ((TextView)findViewById(2131381563));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381562) {
      opw.c(this.c, this.h);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    if ((this.a != null) && (this.a.tag_type == 0))
    {
      qY(true);
      return;
    }
    qY(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osc
 * JD-Core Version:    0.7.0.1
 */