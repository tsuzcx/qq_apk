package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import ahbj;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment.a;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import rxn.b;
import ryx;
import rze;
import sbn;
import sjp;
import sjq;

public class SubScribeDraftItemView
  extends BaseWidgetView<SubscribeDraftBean>
{
  private static String TAG = "SubScribeDraftItemView";
  private TextView Ar;
  private sbn c;
  private AsyncRichTextView d;
  private RoundCornerImageView g;
  private String mUin;
  private TextView mVideoDuration;
  private int mWidth = ImmersiveUtils.getScreenWidth() / 2;
  private ImageView os;
  private ImageView ot;
  
  public SubScribeDraftItemView(@NonNull Context paramContext, sbn paramsbn)
  {
    super(paramContext);
    this.c = paramsbn;
  }
  
  private boolean MY()
  {
    if (this.c != null)
    {
      Object localObject = this.c.getShareData("share_key_subscribe_opus");
      if ((localObject != null) && ((((rxn.b)localObject).by instanceof SubscribeBaseBottomPersonalFragment.a)))
      {
        localObject = (SubscribeBaseBottomPersonalFragment.a)((rxn.b)localObject).by;
        if ((((SubscribeBaseBottomPersonalFragment.a)localObject).a != null) && (((SubscribeBaseBottomPersonalFragment.a)localObject).a.user.youZhan.size() > 0)) {
          return ((CertifiedAccountMeta.StYouZanShop)((SubscribeBaseBottomPersonalFragment.a)localObject).a.user.youZhan.get(0)).type.get() > 1;
        }
      }
    }
    return false;
  }
  
  private String getPostUin()
  {
    if (this.c != null)
    {
      rxn.b localb = this.c.getShareData("share_key_subscribe_opus");
      if ((localb != null) && ((localb.by instanceof SubscribeBaseBottomPersonalFragment.a))) {
        return ((SubscribeBaseBottomPersonalFragment.a)localb.by).aDM;
      }
    }
    return "";
  }
  
  protected void b(SubscribeDraftBean paramSubscribeDraftBean)
  {
    if (paramSubscribeDraftBean == null) {
      return;
    }
    String str2 = paramSubscribeDraftBean.getTitle();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramSubscribeDraftBean.getDescirbeSource();
    }
    float f;
    if (TextUtils.isEmpty(str1))
    {
      this.d.setVisibility(8);
      if (paramSubscribeDraftBean.getWidth() < paramSubscribeDraftBean.getHeight()) {
        break label290;
      }
      f = 0.75F;
      label60:
      this.g.getLayoutParams().height = ((int)(f * this.mWidth));
      this.g.getLayoutParams().width = this.mWidth;
      this.g.requestLayout();
      if ((!TextUtils.isEmpty(paramSubscribeDraftBean.getCoverUrl())) && (ahbj.isFileExists(paramSubscribeDraftBean.getCoverUrl()))) {
        break label296;
      }
      this.g.setImageResource(2130842474);
      label128:
      this.Ar.setText(rze.aC(paramSubscribeDraftBean.getDraftId()));
      if (paramSubscribeDraftBean.getDrafTtype() != SubscribeDraftBean.TYPE_VIDEO) {
        break label318;
      }
      int i = (int)(paramSubscribeDraftBean.getDuration() / 1000L / 60L);
      int j = (int)(paramSubscribeDraftBean.getDuration() / 1000L % 60L);
      if ((i != 0) || (j != 0))
      {
        this.mVideoDuration.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        this.mVideoDuration.setVisibility(0);
        this.ot.setVisibility(0);
      }
    }
    for (;;)
    {
      this.g.setOnClickListener(new sjp(this, paramSubscribeDraftBean));
      this.os.setOnClickListener(new sjq(this, paramSubscribeDraftBean));
      return;
      this.d.setVisibility(0);
      this.d.setText(str1);
      break;
      label290:
      f = 1.333333F;
      break label60;
      label296:
      ryx.a(paramSubscribeDraftBean.getCoverUrl(), this.g, ryx.b(this.g), true);
      break label128;
      label318:
      this.mVideoDuration.setVisibility(8);
      this.ot.setVisibility(8);
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.g = ((RoundCornerImageView)paramView.findViewById(2131366117));
    this.d = ((AsyncRichTextView)paramView.findViewById(2131366123));
    this.os = ((ImageView)paramView.findViewById(2131366118));
    this.ot = ((ImageView)paramView.findViewById(2131366121));
    this.mUin = ((PublicFragmentActivity)paramContext).app.getCurrentUin();
    this.mVideoDuration = ((TextView)paramView.findViewById(2131366124));
    this.Ar = ((TextView)paramView.findViewById(2131366122));
  }
  
  public int getLayoutId()
  {
    return 2131558838;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView
 * JD-Core Version:    0.7.0.1
 */