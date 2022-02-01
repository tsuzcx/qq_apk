import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class orq
  extends ogm<oqr>
  implements View.OnClickListener
{
  private KandianUrlImageView K;
  private KandianUrlImageView ac;
  private KandianUrlImageView ad;
  private stNewIconStyle b;
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private TextView mText;
  private View nB;
  
  public orq(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.b != null) && (!TextUtils.isEmpty(this.b.title)))
    {
      this.mText.setVisibility(0);
      this.K.setVisibility(0);
      this.ac.setVisibility(0);
      this.mText.setText(this.b.title);
      if (!TextUtils.isEmpty(this.b.iconUrl)) {
        this.K.setImage(opn.b(this.b.iconUrl));
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.ac.setImageResource(2130843529);
        }
        return;
        this.K.setImageResource(2130844013);
      }
    }
    this.K.setVisibility(8);
    this.mText.setVisibility(8);
    this.ac.setVisibility(8);
  }
  
  private void bgE()
  {
    al(true, true);
    this.ac.setImageResource(2130843529);
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed)))
    {
      this.h = ((stSimpleMetaFeed)localoqr.B());
      this.b = this.h.new_icon;
    }
  }
  
  protected int gn()
  {
    return 2131560220;
  }
  
  protected void initView()
  {
    this.nB = findViewById(2131381562);
    this.ad = ((KandianUrlImageView)findViewById(2131381546));
    this.ac = ((KandianUrlImageView)findViewById(2131381561));
    this.K = ((KandianUrlImageView)findViewById(2131381564));
    this.mText = ((TextView)findViewById(2131381563));
    this.nB.setOnClickListener(this);
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
    if ((this.b != null) && ((this.b.tag_type == 1) || (this.b.tag_type == 2)))
    {
      this.nB.setVisibility(0);
      int i = this.b.tag_type;
      String str = this.b.img_url;
      if (i == 1)
      {
        this.ad.setVisibility(8);
        bgE();
      }
      while (i != 2) {
        return;
      }
      al(false, false);
      this.ad.setVisibility(0);
      if (!TextUtils.isEmpty(str))
      {
        this.ad.setImage(opn.b(str));
        return;
      }
      this.ad.setImage(opn.b("https://isee.weishi.qq.com/qq/doudi_ban.png"));
      return;
    }
    this.nB.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orq
 * JD-Core Version:    0.7.0.1
 */