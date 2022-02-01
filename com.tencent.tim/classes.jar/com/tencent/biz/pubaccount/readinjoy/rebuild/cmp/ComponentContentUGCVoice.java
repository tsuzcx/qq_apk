package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import kbp;
import lis;
import lwk;
import lwm.a;
import mbv;
import mrh.a;

public class ComponentContentUGCVoice
  extends LinearLayout
  implements lwk, mrh.a
{
  public static final String TAG = ComponentContentUGCVoice.class.getSimpleName();
  private SocializeFeedsInfo.UGCVoiceInfo a;
  private ArticleInfo b;
  private LinearLayout dT;
  private ImageView jl;
  private TextView qs;
  
  public ComponentContentUGCVoice(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public void P(Object paramObject)
  {
    this.b = ((lis)paramObject).a();
    if ((this.b == null) || (this.b.mSocialFeedInfo == null) || (this.b.mSocialFeedInfo.a == null) || (this.b.mSocialFeedInfo.a.lc == null)) {}
    do
    {
      return;
      paramObject = this.b.mSocialFeedInfo.a.lc;
    } while (paramObject.isEmpty());
    int i;
    if (this.b.mFeedType == 1)
    {
      i = 1;
      if (i == 0) {
        break label317;
      }
      if ((getParent() != null) && (getParent().getParent() != null)) {
        ((View)getParent().getParent()).setBackgroundColor(-460552);
      }
      label132:
      this.dT.setVisibility(0);
      this.a = ((SocializeFeedsInfo.UGCVoiceInfo)paramObject.get(0));
      this.qs.setText(String.format("%02d″", new Object[] { Integer.valueOf(this.a.duration) }));
      paramObject = (LinearLayout.LayoutParams)this.dT.getLayoutParams();
      if (this.a.duration <= 50) {
        break label355;
      }
      paramObject.width = aqcx.dip2px(getContext(), 277.0F);
    }
    for (;;)
    {
      this.dT.setLayoutParams(paramObject);
      kbp.a(null, "", "0X8009CA3", "0X8009CA3", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), this.b.mFeedId + "", "", "", false);
      if (!this.a.isPlaying) {
        break label483;
      }
      this.jl.setImageResource(2130850377);
      ((AnimationDrawable)this.jl.getDrawable()).start();
      return;
      i = 0;
      break;
      label317:
      if ((getParent() == null) || (getParent().getParent() == null)) {
        break label132;
      }
      ((View)getParent().getParent()).setBackgroundColor(-1);
      break label132;
      label355:
      if (this.a.duration > 40) {
        paramObject.width = aqcx.dip2px(getContext(), 237.0F);
      } else if (this.a.duration > 30) {
        paramObject.width = aqcx.dip2px(getContext(), 197.0F);
      } else if (this.a.duration > 20) {
        paramObject.width = aqcx.dip2px(getContext(), 157.0F);
      } else if (this.a.duration > 10) {
        paramObject.width = aqcx.dip2px(getContext(), 117.0F);
      } else {
        paramObject.width = aqcx.dip2px(getContext(), 85.0F);
      }
    }
    label483:
    this.jl.setImageResource(2130850376);
  }
  
  public void a(SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.a)
    {
      this.jl.setImageResource(2130850377);
      ((AnimationDrawable)this.jl.getDrawable()).start();
    }
  }
  
  public void a(lwm.a parama) {}
  
  public void b(SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.a) {
      this.jl.setImageResource(2130850376);
    }
  }
  
  public void cG(View paramView)
  {
    this.dT = ((LinearLayout)paramView.findViewById(2131381198));
    this.qs = ((TextView)paramView.findViewById(2131381199));
    this.jl = ((ImageView)paramView.findViewById(2131381197));
    this.dT.setOnClickListener(new mbv(this));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560312, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice
 * JD-Core Version:    0.7.0.1
 */