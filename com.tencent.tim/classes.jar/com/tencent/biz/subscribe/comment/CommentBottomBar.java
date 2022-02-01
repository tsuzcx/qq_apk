package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import acfp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import rwv;
import rwx;
import rze;
import sca;
import scb;
import scc;
import scd;
import sce;
import scf;
import scg;
import scw;
import scw.c;
import sds;
import spp;

public class CommentBottomBar
  extends LinearLayout
  implements rwx
{
  public static final String TAG = CommentBottomBar.class.getSimpleName();
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private scw jdField_a_of_type_Scw;
  private boolean aKV;
  private boolean aKW;
  private boolean azH = true;
  private View.OnClickListener cD;
  private CertifiedAccountMeta.StFeed mFeed;
  private ImageView mx;
  private ImageView nT;
  private ImageView nU;
  private TextView vY;
  private TextView vZ;
  private TextView zI;
  
  public CommentBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
    aAz();
  }
  
  private String a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label108;
      }
      paramStComment = "";
      if ("".length() > 10)
      {
        paramStComment = "".substring(0, 10);
        paramStComment = paramStComment + "...";
      }
    }
    do
    {
      return paramStComment;
      if ((paramStComment == null) || (paramStComment.postUser == null)) {
        break;
      }
      paramStComment = "";
    } while ("".length() <= 10);
    paramStComment = "".substring(0, 10);
    return paramStComment + "...";
    label108:
    return null;
  }
  
  private void aAz()
  {
    rwv.a().a(this);
    this.nT.setOnClickListener(new sca(this));
    this.nU.setOnClickListener(new scb(this));
    this.mx.setOnClickListener(new scc(this));
    this.vY.setOnClickListener(new scd(this));
  }
  
  private void biA()
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = null;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = null;
    qv(getContext().getString(2131703545));
  }
  
  private void bxW()
  {
    this.mx.setBackgroundResource(2130848386);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(600L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(5);
    localScaleAnimation.setAnimationListener(new scg(this));
    this.mx.startAnimation(localScaleAnimation);
  }
  
  private void initView()
  {
    setClickable(true);
    setOrientation(0);
    setBackgroundColor(-1);
    setGravity(16);
    LayoutInflater.from(getContext()).inflate(2131558874, this);
    this.nT = ((ImageView)findViewById(2131369841));
    this.vY = ((TextView)findViewById(2131380547));
    this.mx = ((ImageView)findViewById(2131369896));
    this.nU = ((ImageView)findViewById(2131369714));
    this.vZ = ((TextView)findViewById(2131369713));
    this.zI = ((TextView)findViewById(2131369843));
    this.aKV = ((String)spp.a().getValue("is_open_sharing", "1")).equals("1");
    ImageView localImageView = this.mx;
    if (this.aKV) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void uw(boolean paramBoolean)
  {
    if (this.mx == null) {
      return;
    }
    this.mx.setBackgroundResource(2130839218);
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);; localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F))
    {
      localScaleAnimation.setDuration(1000L);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setRepeatCount(0);
      localScaleAnimation.setAnimationListener(new scf(this, paramBoolean));
      this.mx.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void yn(int paramInt)
  {
    boolean bool = true;
    ImageView localImageView;
    if (paramInt == 1)
    {
      this.aKW = bool;
      localImageView = this.nT;
      if (paramInt != 0) {
        break label36;
      }
    }
    label36:
    for (paramInt = 2130839209;; paramInt = 2130839210)
    {
      localImageView.setBackgroundResource(paramInt);
      return;
      bool = false;
      break;
    }
  }
  
  public void Hx()
  {
    if (this.jdField_a_of_type_Scw != null) {
      this.jdField_a_of_type_Scw.beM();
    }
  }
  
  public boolean Mx()
  {
    return this.aKW;
  }
  
  public boolean My()
  {
    return (this.jdField_a_of_type_Scw != null) && (this.jdField_a_of_type_Scw.MA());
  }
  
  public boolean Mz()
  {
    return (this.jdField_a_of_type_Scw != null) && (this.jdField_a_of_type_Scw.MB());
  }
  
  public scw a()
  {
    return this.jdField_a_of_type_Scw;
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, scw.c paramc)
  {
    a(paramActivity, paramStFeed, paramc, null);
  }
  
  public void a(Activity paramActivity, CertifiedAccountMeta.StFeed paramStFeed, scw.c paramc, ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_Scw = new scw(paramActivity, false, paramStFeed, paramc, paramExtraTypeInfo);
  }
  
  public void bxT()
  {
    if (this.mFeed == null) {
      return;
    }
    if (!this.azH)
    {
      QQToast.a(getContext(), acfp.m(2131704186), 0).show();
      return;
    }
    this.azH = false;
    DoLikeRequest localDoLikeRequest = new DoLikeRequest(this.mFeed);
    VSNetworkHelper.a().a(localDoLikeRequest, new sce(this));
  }
  
  public void bxU()
  {
    this.mx.clearAnimation();
    this.mx.setBackgroundResource(2130839218);
  }
  
  public void bxV()
  {
    uw(false);
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void ek(int paramInt)
  {
    if (this.zI == null) {
      return;
    }
    if (paramInt > 0)
    {
      this.zI.setText(sds.aO(paramInt));
      this.zI.setVisibility(0);
      return;
    }
    this.zI.setText("");
    this.zI.setVisibility(8);
  }
  
  @SuppressLint({"DefaultLocale", "SetTextI18n"})
  public void el(int paramInt)
  {
    if (this.vZ == null) {
      return;
    }
    if (paramInt > 0)
    {
      this.vZ.setText(sds.aO(paramInt));
      this.vZ.setVisibility(0);
      return;
    }
    this.vZ.setText("");
    this.vZ.setVisibility(8);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    localArrayList.add(CommentReplyEvent.class);
    return localArrayList;
  }
  
  public void l(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Scw != null) {
      this.jdField_a_of_type_Scw.l(paramStFeed);
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.jdField_a_of_type_Scw != null) {
      return this.jdField_a_of_type_Scw.onBackPress();
    }
    return false;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.mFeed != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)) && (this.mFeed.id.get().equals(((PraisedUpdateEvents)paramSimpleBaseEvent).mTargetFeedId))) {
      if (this.nT != null)
      {
        paramSimpleBaseEvent = (PraisedUpdateEvents)paramSimpleBaseEvent;
        yn(paramSimpleBaseEvent.mPraisedStatus);
        ek(paramSimpleBaseEvent.mPraisedNum);
      }
    }
    while (!(paramSimpleBaseEvent instanceof CommentReplyEvent)) {
      return;
    }
    paramSimpleBaseEvent = (CommentReplyEvent)paramSimpleBaseEvent;
    setTargetCommentAndReply(paramSimpleBaseEvent.mStComment, paramSimpleBaseEvent.mStReply);
  }
  
  public void qv(String paramString)
  {
    if (this.vY == null) {
      return;
    }
    this.vY.setText(paramString);
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_Scw != null) {
      this.jdField_a_of_type_Scw.recycle();
    }
    rwv.a().b(this);
  }
  
  public void setCurrentFeed(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
    yn(paramStFeed.likeInfo.status.get());
    el(paramStFeed.commentCount.get());
    ek(paramStFeed.likeInfo.count.get());
    if (this.mx != null)
    {
      if ((this.aKV) && (rze.fh(paramStFeed.status.get()))) {
        this.mx.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mx.setVisibility(8);
  }
  
  public void setShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cD = paramOnClickListener;
  }
  
  public void setTargetCommentAndReply(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = paramStReply;
    paramStComment = a(paramStComment, paramStReply);
    if (!TextUtils.isEmpty(paramStComment)) {
      qv(paramStComment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar
 * JD-Core Version:    0.7.0.1
 */