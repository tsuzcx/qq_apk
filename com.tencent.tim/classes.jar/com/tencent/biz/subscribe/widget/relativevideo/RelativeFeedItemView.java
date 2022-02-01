package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import ankt;
import aqhq;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import ram;
import rwv;
import rwx;
import ryx;
import rzd;
import sjg;
import sji;
import sqn;

public class RelativeFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements rwx
{
  private TextView Ab;
  private TextView Ad;
  private boolean aLJ;
  private boolean avA;
  private volatile boolean azH = true;
  private AsyncRichTextView e;
  public RoundCornerImageView f;
  private Drawable mDefaultDrawable = getResources().getDrawable(2130840645);
  private TextView mVideoDuration;
  private int mWidth = ImmersiveUtils.getScreenWidth() / 2;
  private SquareImageView o;
  private ImageView ol;
  private View qc;
  
  public RelativeFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void t(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed.likeInfo.count.get() == 0)
    {
      this.Ad.setVisibility(8);
      if (!this.avA) {
        break label94;
      }
      localImageView = this.ol;
      if (paramStFeed.likeInfo.status.get() != 1) {
        break label88;
      }
    }
    label88:
    for (int i = 2130839222;; i = 2130839220)
    {
      localImageView.setImageResource(i);
      return;
      this.Ad.setText(String.valueOf(paramStFeed.likeInfo.count.get()));
      this.Ad.setVisibility(0);
      break;
    }
    label94:
    ImageView localImageView = this.ol;
    if (paramStFeed.likeInfo.status.get() == 1) {}
    for (i = 2130839221;; i = 2130839219)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void yz(int paramInt)
  {
    if (getData() == null) {
      return;
    }
    String str2 = ((CertifiedAccountMeta.StFeed)getData()).poster.id.get();
    String str1;
    int j;
    if (paramInt == 1)
    {
      str1 = "like";
      sqn.b(str2, "auth_feeds", str1, 0, this.bvX, new String[] { "", "", ((CertifiedAccountMeta.StFeed)getData()).poster.nick.get(), ((CertifiedAccountMeta.StFeed)getData()).title.get() });
      j = ((CertifiedAccountMeta.StFeed)getData()).likeInfo.count.get();
      if (paramInt != 1) {
        break label177;
      }
    }
    label177:
    for (int i = 1;; i = -1)
    {
      ((CertifiedAccountMeta.StFeed)getData()).likeInfo.count.set(j + i);
      ((CertifiedAccountMeta.StFeed)getData()).likeInfo.status.set(paramInt);
      t((CertifiedAccountMeta.StFeed)getData());
      return;
      str1 = "cancel_like";
      break;
    }
  }
  
  public float a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    float f1 = 1.333333F;
    if ((paramStFeed.cover.width.get() == 0) || (paramStFeed.cover.height.get() == 0))
    {
      ram.i("RelativeFeedItemView", "getImageScale()  return 3/4");
      return 0.75F;
    }
    float f2 = paramStFeed.cover.height.get() / paramStFeed.cover.width.get();
    if (f2 > 1.333333F) {}
    for (;;)
    {
      ram.i("RelativeFeedItemView", "getImageScale()  feed.width:" + paramStFeed.cover.width.get() + "  feed.height:" + paramStFeed.cover.height.get() + "  realHeight=" + f1);
      return f1;
      f1 = f2;
    }
  }
  
  public View aB()
  {
    return this;
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.e = ((AsyncRichTextView)findViewById(2131380702));
    this.Ab = ((TextView)findViewById(2131380565));
    this.Ad = ((TextView)findViewById(2131380698));
    this.f = ((RoundCornerImageView)findViewById(2131369745));
    this.f.setCorner(ImmersiveUtils.dpToPx(4.0F));
    this.o = ((SquareImageView)findViewById(2131369666));
    this.mVideoDuration = ((TextView)findViewById(2131380695));
    this.qc = findViewById(2131370761);
    this.ol = ((ImageView)findViewById(2131369844));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131558869;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.aLJ = true;
    rwv.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.aLJ = false;
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((getData() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)) && (((CertifiedAccountMeta.StFeed)getData()).id.get().equals(((PraisedUpdateEvents)paramSimpleBaseEvent).mTargetFeedId)) && (this.Ad != null)) {
      yz(((PraisedUpdateEvents)paramSimpleBaseEvent).mPraisedStatus);
    }
  }
  
  @RequiresApi(api=8)
  protected void q(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    Object localObject;
    label52:
    label196:
    label243:
    label631:
    do
    {
      return;
      String str = paramStFeed.title.get();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramStFeed.content.get();
      }
      float f1;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.e.setVisibility(8);
        if (paramStFeed.poster != null) {
          this.Ab.setText(paramStFeed.poster.nick.get());
        }
        if (paramStFeed.likeInfo != null) {
          t(paramStFeed);
        }
        if (!rzd.fe(paramStFeed.type.get())) {
          break label554;
        }
        int i = paramStFeed.video.duration.get() / 1000 / 60;
        int j = paramStFeed.video.duration.get() / 1000;
        this.mVideoDuration.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
        if (paramStFeed.video.width.get() < paramStFeed.video.height.get()) {
          break label548;
        }
        f1 = 0.75F;
        this.f.getLayoutParams().height = ((int)(f1 * this.mWidth));
        this.f.getLayoutParams().width = this.mWidth;
        this.f.requestLayout();
        this.mVideoDuration.setVisibility(0);
        ryx.a(paramStFeed.cover.url.get(), this.f, null, aqhq.rq(paramStFeed.cover.url.get()));
        this.o.getLayoutParams().width = ankt.dip2px(18.0F);
        this.o.getLayoutParams().height = ankt.dip2px(18.0F);
        ryx.b(paramStFeed.poster.icon.get(), this.o);
        if ((paramStFeed.status.get() != 3) || (!BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStFeed.poster.id.get()))) {
          break label609;
        }
        this.qc.setVisibility(0);
      }
      for (;;)
      {
        this.ol.setOnClickListener(new sjg(this, paramStFeed));
        if (this.avA)
        {
          this.o.setFilterColor(1711276032);
          this.e.setTextColor(-5723992);
          this.f.setColorFilter(1711276032);
          this.Ab.setTextColor(-10132123);
          this.mVideoDuration.setTextColor(-5723992);
          this.Ad.setTextColor(-10132123);
        }
        localObject = getExtraTypeInfo();
        if (localObject == null) {
          break;
        }
        if (((ExtraTypeInfo)localObject).pageType != 7003) {
          break label631;
        }
        sqn.b(paramStFeed.poster.id.get(), "auth_follow", "new_c_exp", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
        return;
        this.e.setText((CharSequence)localObject);
        this.e.setVisibility(0);
        break label52;
        f1 = 1.333333F;
        break label196;
        this.f.getLayoutParams().height = ((int)(this.mWidth * a(paramStFeed)));
        this.f.getLayoutParams().width = this.mWidth;
        this.f.requestLayout();
        this.mVideoDuration.setVisibility(8);
        break label243;
        if (this.qc.getVisibility() == 0) {
          this.qc.setVisibility(8);
        }
      }
    } while (((ExtraTypeInfo)localObject).pageType != 7004);
    label548:
    label554:
    label609:
    sqn.c(paramStFeed.poster.id.get(), "auth_discover", "exp_content", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public View.OnClickListener v()
  {
    return new sji(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView
 * JD-Core Version:    0.7.0.1
 */