import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.b;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.13;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.17;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.21;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.24;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_short_video_label.FeedInfo;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp;
import com.tencent.pb.now.ilive_short_video_label.VideoInfo;
import com.tencent.pb.now.ilive_short_video_label.VideoStatus;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ajzv
{
  public static final String bST;
  public static final String bSU;
  public static final String bSV;
  public static final String bSW;
  public static final String bSX;
  private static int boK = -1;
  public static int dlP = 2;
  private static int dlY;
  private URLDrawable F;
  public View Fb;
  public View Fc;
  private boolean Oe;
  ajvm jdField_a_of_type_Ajvm = new akac(this);
  private ajzv.a jdField_a_of_type_Ajzv$a = new ajzv.a(null);
  private ajzv.b jdField_a_of_type_Ajzv$b = new ajzv.b(null);
  private ajzv.c jdField_a_of_type_Ajzv$c = new ajzv.c(null);
  public volatile boolean aYL;
  private final long adJ = 500L;
  private long adK;
  private long adL;
  private long adM;
  private long adN;
  private long adO;
  private View.OnClickListener ao;
  public QQAppInterface app;
  private AnimatorSet aq;
  private Dialog aw;
  VideoData jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData = new VideoData();
  private StuffContainerView.b jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b;
  private boolean cqY;
  private boolean cqZ;
  private boolean cra;
  private boolean crb;
  public volatile boolean crc;
  private boolean crd = true;
  private boolean cre = true;
  private boolean crf;
  boolean crg = false;
  private int dlO = 1;
  private int dlQ = 6;
  private int dlR = 7;
  private int dlS;
  private int dlT = -1;
  private int dlU;
  private int dlV;
  private int dlW;
  int dlX;
  private int dlw;
  private int dly;
  private String extraInfo;
  private String feedsId;
  String headUrl;
  private boolean isFirstTime = true;
  private boolean isLiked;
  private boolean isLocal;
  private boolean isMine;
  private boolean isRecord;
  String jumpUrl;
  private GestureDetector mGestureDetector;
  private String nickName;
  
  static
  {
    bST = acfp.m(2131709734);
    bSU = acfp.m(2131709722);
    bSV = acfp.m(2131709714);
    bSW = acfp.m(2131709723);
    bSX = acfp.m(2131709733);
    dlY = -15550475;
  }
  
  public ajzv(View paramView, QQAppInterface paramQQAppInterface)
  {
    this.Fb = paramView;
    this.app = paramQQAppInterface;
    this.app.addObserver(this.jdField_a_of_type_Ajvm);
    this.Fb.setOnTouchListener(new ajzw(this));
    this.mGestureDetector = new GestureDetector(this.Fb.getContext(), new akaf(this));
    this.mGestureDetector.setOnDoubleTapListener(new akar(this));
    dAp();
    dAq();
  }
  
  private void Nh(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feeds_id", paramString);
      paramString = localJSONObject.toString();
      localSharedPreferences.edit().putString("nearby_now_delete_success_js_param", paramString).commit();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private AnimatorSet a(View paramView)
  {
    AnimatorSet localAnimatorSet1 = new AnimatorSet();
    AnimatorSet localAnimatorSet2 = new AnimatorSet();
    localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet2.setDuration(200L);
    AnimatorSet localAnimatorSet3 = new AnimatorSet();
    localAnimatorSet3.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }) });
    localAnimatorSet3.setDuration(350L);
    localAnimatorSet1.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet1.playSequentially(new Animator[] { localAnimatorSet3, localAnimatorSet2 });
    return localAnimatorSet1;
  }
  
  private void al(View paramView, int paramInt)
  {
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramView.invalidateSelf();
    }
  }
  
  private void dAo()
  {
    this.aq.cancel();
    this.aq.start();
  }
  
  private void dAp()
  {
    this.aq = new AnimatorSet();
    this.aq.setInterpolator(new AccelerateDecelerateInterpolator());
    this.aq.playTogether(new Animator[] { a(this.Fb.findViewById(2131378796)) });
  }
  
  private void dAq()
  {
    this.Fb.findViewById(2131364996).setOnTouchListener(new akam(this));
    this.Fb.findViewById(2131370436).setOnTouchListener(new akan(this));
    this.Fb.findViewById(2131378177).setOnTouchListener(new akao(this));
    this.Fb.findViewById(2131371934).setOnTouchListener(new akap(this));
  }
  
  private void dAs()
  {
    ((TextView)this.Fc.findViewById(2131372369)).setTextColor(Color.parseColor("#000000"));
    ((TextView)this.Fc.findViewById(2131366617)).setTextColor(Color.parseColor("#bbbbbb"));
    ((TextView)this.Fc.findViewById(2131367378)).setTextColor(boK);
    ((TextView)this.Fc.findViewById(2131367403)).setTextColor(boK);
    al(this.Fc.findViewById(2131367413), boK);
    this.dlX = dlY;
    if (!this.crg)
    {
      this.Fc.findViewById(2131367401).setBackgroundColor(dlY);
      this.Fc.findViewById(2131367402).setBackgroundDrawable(null);
    }
    for (;;)
    {
      this.Fc.findViewById(2131368405).setBackgroundColor(-1);
      this.Fc.findViewById(2131364696).setVisibility(8);
      this.Fc.findViewById(2131364695).setVisibility(0);
      View localView = this.Fc.findViewById(2131368405).findViewById(2131363558);
      if (localView.getVisibility() == 8) {
        localView.setVisibility(0);
      }
      return;
      al(this.Fc.findViewById(2131367402), dlY);
    }
  }
  
  private void dAt()
  {
    if (this.Fc.findViewById(2131367413) == null) {
      return;
    }
    this.Fc.findViewById(2131367402).clearAnimation();
    this.Fc.findViewById(2131367398).clearAnimation();
    int i = (int)jll.dp2px(this.Fc.getContext(), 20.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Fc.findViewById(2131367378), "translationY", new float[] { 0.0F, -i });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Fc.findViewById(2131367403), "translationY", new float[] { 0.0F, -i });
    Object localObject = ObjectAnimator.ofFloat(this.Fc.findViewById(2131367413), "translationY", new float[] { i, 0.0F });
    this.Fc.findViewById(2131367413).setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.Fc.findViewById(2131367404), "scaleX", new float[] { 1.0F, 0.75F, 0.5F, 0.2F, 0.0F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.Fc.findViewById(2131367404), "scaleY", new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F });
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    ((AnimatorSet)localObject).addListener(new akas(this));
    ((AnimatorSet)localObject).setDuration(500L);
    ((AnimatorSet)localObject).setStartDelay(800L);
    ((AnimatorSet)localObject).start();
  }
  
  private void kJ()
  {
    this.Fc.findViewById(2131368427).setOnClickListener(new akat(this));
    this.Fc.findViewById(2131372369).setOnClickListener(new akau(this));
    this.Fc.findViewById(2131367404).setOnClickListener(new akav(this));
    this.Fc.findViewById(2131364694).setOnClickListener(new akaw(this));
    this.Fb.findViewById(2131364996).setOnClickListener(new akax(this));
    this.Fb.findViewById(2131370436).setOnClickListener(new akay(this));
    this.Fb.findViewById(2131378177).setOnClickListener(new ajzx(this));
    this.Fb.findViewById(2131371934).setOnClickListener(new ajzy(this));
    this.Fb.findViewById(2131378799).setOnClickListener(new ajzz(this));
  }
  
  public void MA(boolean paramBoolean)
  {
    this.isLocal = paramBoolean;
    View localView = this.Fc.findViewById(2131379818);
    if ((this.isRecord) || (this.isLocal)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void MB(boolean paramBoolean)
  {
    this.isRecord = paramBoolean;
    View localView = this.Fc.findViewById(2131379818);
    if ((this.isRecord) || (this.isLocal)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void MC(boolean paramBoolean)
  {
    this.isLiked = paramBoolean;
    this.Fb.findViewById(2131378795).setSelected(this.isLiked);
  }
  
  public void MD(boolean paramBoolean)
  {
    this.isMine = paramBoolean;
  }
  
  public void ME(boolean paramBoolean)
  {
    this.Oe = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "is follow? " + paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "is Mine? " + this.isMine);
    }
    if (this.Fc != null)
    {
      if ((this.Oe) || (this.isMine)) {
        this.Fc.findViewById(2131367404).setVisibility(8);
      }
    }
    else {
      return;
    }
    this.Fc.findViewById(2131367404).setVisibility(0);
  }
  
  public void Mu(boolean paramBoolean)
  {
    int i = 8;
    if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type == 1))
    {
      this.Fb.findViewById(2131372730).setVisibility(8);
      return;
    }
    View localView = this.Fb.findViewById(2131372730);
    if (paramBoolean) {
      i = 0;
    }
    localView.setVisibility(i);
  }
  
  public void My(boolean paramBoolean)
  {
    this.cqY = paramBoolean;
  }
  
  public void Mz(boolean paramBoolean)
  {
    this.cqZ = paramBoolean;
  }
  
  public void Nf(String paramString)
  {
    this.headUrl = paramString;
    if (this.Fc != null) {
      ajxr.a().a((ImageView)this.Fc.findViewById(2131368427), paramString, this.Fc.getResources().getDrawable(2130846334), this.Fc.getResources().getDrawable(2130846334), null, true);
    }
  }
  
  public void Ng(String paramString) {}
  
  public void RG(int paramInt)
  {
    this.dlw = paramInt;
    if (paramInt > 0)
    {
      if (this.dlU == 1) {
        if (this.isLiked) {
          ((ImageView)this.Fb.findViewById(2131378796)).setImageResource(2130846382);
        }
      }
      for (;;)
      {
        ((TextView)this.Fb.findViewById(2131378795)).setText(ajxp.bz(paramInt));
        return;
        ((ImageView)this.Fb.findViewById(2131378796)).setImageResource(2130846400);
        continue;
        if (this.isLiked) {
          ((ImageView)this.Fb.findViewById(2131378796)).setImageResource(2130846382);
        } else {
          ((ImageView)this.Fb.findViewById(2131378796)).setImageResource(2130846381);
        }
      }
    }
    if (this.dlU == 1) {
      ((ImageView)this.Fb.findViewById(2131378796)).setImageResource(2130846400);
    }
    for (;;)
    {
      ((TextView)this.Fb.findViewById(2131378795)).setText(acfp.m(2131709725));
      return;
      ((ImageView)this.Fb.findViewById(2131378796)).setImageResource(2130846381);
    }
  }
  
  public void RH(int paramInt)
  {
    int i = -1;
    this.dlU = paramInt;
    Object localObject = this.Fb.findViewById(2131363685);
    if (this.dlU == 0)
    {
      paramInt = 2130846458;
      ((View)localObject).setBackgroundResource(paramInt);
      localObject = (ImageView)this.Fb.findViewById(2131378787);
      if (this.dlU != 0) {
        break label252;
      }
      paramInt = 2130846379;
      label59:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = (ImageView)this.Fb.findViewById(2131378802);
      if (this.dlU != 0) {
        break label259;
      }
      paramInt = 2130846385;
      label89:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = (ImageView)this.Fb.findViewById(2131378798);
      if (this.dlU != 0) {
        break label266;
      }
      paramInt = 2130846383;
      label119:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = (TextView)this.Fb.findViewById(2131378786);
      if (this.dlU != 0) {
        break label273;
      }
      paramInt = -1;
      label147:
      ((TextView)localObject).setTextColor(paramInt);
      localObject = (TextView)this.Fb.findViewById(2131378795);
      if (this.dlU != 0) {
        break label280;
      }
      paramInt = -1;
      label175:
      ((TextView)localObject).setTextColor(paramInt);
      localObject = (TextView)this.Fb.findViewById(2131378801);
      if (this.dlU != 0) {
        break label287;
      }
      paramInt = -1;
      label203:
      ((TextView)localObject).setTextColor(paramInt);
      localObject = (TextView)this.Fb.findViewById(2131378797);
      if (this.dlU != 0) {
        break label294;
      }
    }
    label259:
    label266:
    label273:
    label280:
    label287:
    label294:
    for (paramInt = i;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      RG(this.dlw);
      return;
      paramInt = 2130846459;
      break;
      label252:
      paramInt = 2130846380;
      break label59;
      paramInt = 2130846386;
      break label89;
      paramInt = 2130846384;
      break label119;
      paramInt = -16777216;
      break label147;
      paramInt = -16777216;
      break label175;
      paramInt = -16777216;
      break label203;
    }
  }
  
  public void RI(int paramInt)
  {
    if ((this.Fc == null) || (!this.cre)) {}
    View localView;
    Object localObject;
    label669:
    do
    {
      return;
      localView = this.Fc.findViewById(2131368405).findViewById(2131363558);
      if ((paramInt > 10) && (paramInt < 70))
      {
        float f = (paramInt - 10) / 60.0F;
        localObject = new ArgbEvaluator();
        paramInt = ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(-1), Integer.valueOf(-16777216))).intValue();
        int i = ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(-1), Integer.valueOf(-4473925))).intValue();
        int j = ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(-637534209), Integer.valueOf(dlY))).intValue();
        ((Integer)((ArgbEvaluator)localObject).evaluate(f, Integer.valueOf(dlY), Integer.valueOf(-1))).intValue();
        ((TextView)this.Fc.findViewById(2131372369)).setTextColor(paramInt);
        ((TextView)this.Fc.findViewById(2131366617)).setTextColor(i);
        ((TextView)this.Fc.findViewById(2131367378)).setTextColor(boK);
        ((TextView)this.Fc.findViewById(2131367403)).setTextColor(boK);
        al(this.Fc.findViewById(2131367413), boK);
        this.dlX = j;
        if (!this.crg)
        {
          this.Fc.findViewById(2131367401).setBackgroundColor(dlY);
          this.Fc.findViewById(2131367402).setBackgroundDrawable(null);
        }
        for (;;)
        {
          this.Fc.findViewById(2131368405).setBackgroundColor(Color.parseColor("#ffffff"));
          this.Fc.findViewById(2131368405).getBackground().setAlpha((int)(255.0F * f));
          this.Fc.findViewById(2131364696).setAlpha(1.0F - f);
          this.Fc.findViewById(2131364695).setAlpha(f);
          this.Fb.findViewById(2131378799).setVisibility(8);
          if (localView.getVisibility() != 0) {
            break;
          }
          localView.setVisibility(8);
          return;
          al(this.Fc.findViewById(2131367402), dlY);
        }
      }
      if (paramInt <= 10)
      {
        ((TextView)this.Fc.findViewById(2131372369)).setTextColor(Color.parseColor("#ffffff"));
        ((TextView)this.Fc.findViewById(2131366617)).setTextColor(Color.parseColor("#b3ffffff"));
        ((TextView)this.Fc.findViewById(2131367378)).setTextColor(boK);
        ((TextView)this.Fc.findViewById(2131367403)).setTextColor(boK);
        al(this.Fc.findViewById(2131367413), boK);
        this.dlX = -637534209;
        if (!this.crg)
        {
          this.Fc.findViewById(2131367401).setBackgroundColor(dlY);
          this.Fc.findViewById(2131367402).setBackgroundDrawable(null);
          this.Fc.findViewById(2131368405).setBackgroundResource(2130846460);
          this.Fc.findViewById(2131364696).setAlpha(1.0F);
          this.Fc.findViewById(2131364695).setAlpha(0.0F);
          if (localView.getVisibility() == 0) {
            localView.setVisibility(8);
          }
          localView = this.Fb.findViewById(2131378799);
          if (!this.crb) {
            break label669;
          }
        }
        for (paramInt = 0;; paramInt = 8)
        {
          localView.setVisibility(paramInt);
          return;
          al(this.Fc.findViewById(2131367402), dlY);
          break;
        }
      }
    } while (paramInt < 70);
    ((TextView)this.Fc.findViewById(2131372369)).setTextColor(Color.parseColor("#000000"));
    ((TextView)this.Fc.findViewById(2131366617)).setTextColor(Color.parseColor("#bbbbbb"));
    ((TextView)this.Fc.findViewById(2131367378)).setTextColor(boK);
    ((TextView)this.Fc.findViewById(2131367403)).setTextColor(boK);
    al(this.Fc.findViewById(2131367413), boK);
    this.dlX = dlY;
    if (!this.crg)
    {
      this.Fc.findViewById(2131367401).setBackgroundColor(dlY);
      this.Fc.findViewById(2131367402).setBackgroundDrawable(null);
    }
    for (;;)
    {
      this.Fc.findViewById(2131368405).setBackgroundColor(-1);
      this.Fc.findViewById(2131364696).setAlpha(0.0F);
      this.Fc.findViewById(2131364695).setAlpha(1.0F);
      if (localView.getVisibility() != 8) {
        break;
      }
      localView.setVisibility(0);
      return;
      localObject = this.Fc.findViewById(2131367402).getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(-16777216, dlY));
        ((Drawable)localObject).invalidateSelf();
      }
    }
  }
  
  public void a(ilive_short_video_label.GetShortVideoVideoLabelRsp paramGetShortVideoVideoLabelRsp)
  {
    if (paramGetShortVideoVideoLabelRsp == null) {
      return;
    }
    this.dlS = paramGetShortVideoVideoLabelRsp.video_status.root_room_id.get();
    this.dlV = paramGetShortVideoVideoLabelRsp.type.get();
    TextView localTextView = (TextView)this.Fb.findViewById(2131381721);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)this.Fb.findViewById(2131378799);
    localRoundRelativeLayout.init(10);
    localRoundRelativeLayout.requestLayout();
    switch (this.dlV)
    {
    default: 
      localRoundRelativeLayout.setVisibility(8);
      if (this.dlV != 0) {
        break;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      this.crb = bool;
      return;
      this.jdField_a_of_type_Ajzv$a.roomId = paramGetShortVideoVideoLabelRsp.video_status.root_room_id.get();
      localTextView.setText(acfp.m(2131709712));
      localRoundRelativeLayout.setBackgroundResource(2130846419);
      localRoundRelativeLayout.setVisibility(0);
      break;
      this.jdField_a_of_type_Ajzv$c.feedId = paramGetShortVideoVideoLabelRsp.feed_info.feed_id.get().toStringUtf8();
      this.jdField_a_of_type_Ajzv$c.topic = paramGetShortVideoVideoLabelRsp.feed_info.topic.get();
      this.jdField_a_of_type_Ajzv$c.url = paramGetShortVideoVideoLabelRsp.feed_info.url.get();
      localTextView.setText(this.jdField_a_of_type_Ajzv$c.topic);
      localRoundRelativeLayout.setBackgroundResource(2130846421);
      localRoundRelativeLayout.setVisibility(0);
      break;
      this.jdField_a_of_type_Ajzv$b.jumpUrl = paramGetShortVideoVideoLabelRsp.video_info.url.get();
      this.jdField_a_of_type_Ajzv$b.coverUrl = paramGetShortVideoVideoLabelRsp.video_info.cover_url.get();
      localTextView.setText(acfp.m(2131709715));
      localRoundRelativeLayout.setBackgroundResource(2130846422);
      localRoundRelativeLayout.setVisibility(0);
      break;
    }
  }
  
  public boolean cv(long paramLong)
  {
    new ajww(this.app).a(paramLong, this.feedsId, new akaq(this));
    return true;
  }
  
  public void d(VideoData paramVideoData)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "updateShowInfo:mVideoData=" + this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    }
    this.feedsId = paramVideoData.id;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    if (paramVideoData.type == 1)
    {
      Mu(false);
      return;
    }
    this.jumpUrl = paramVideoData.jumpUrl;
    this.adO = paramVideoData.adt;
    this.dlW = paramVideoData.dlx;
    if (paramVideoData.adw == paramVideoData.adu)
    {
      Nf(paramVideoData.bSI);
      setNickName(paramVideoData.bSH);
      this.adL = paramVideoData.adu;
      this.adK = paramVideoData.ads;
      setWatchCount(paramVideoData.dly);
      iS(paramVideoData.age, paramVideoData.gender);
      if (paramVideoData.type != 1) {
        break label305;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 3) {
        break label344;
      }
      bool1 = true;
      label174:
      My(bool1);
      if (paramVideoData.type != 1) {
        break label349;
      }
      bool1 = true;
      label189:
      MB(bool1);
      if (paramVideoData.type != 4) {
        break label354;
      }
      bool1 = true;
      label204:
      MA(bool1);
      ME(paramVideoData.isFollowed);
      if (TextUtils.isEmpty(paramVideoData.jumpUrl)) {
        break label359;
      }
    }
    label305:
    label344:
    label349:
    label354:
    label359:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Mz(bool1);
      setFeedType(paramVideoData.feedType);
      dAn();
      if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType == 4) && (this.isFirstTime)) {}
      this.isFirstTime = false;
      return;
      Nf(paramVideoData.headerUrl);
      setNickName(paramVideoData.bSG);
      this.adL = paramVideoData.ads;
      this.adK = paramVideoData.adu;
      break;
      if (paramVideoData.dlC == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        MD(bool1);
        MC(paramVideoData.isLike);
        RG(paramVideoData.dlw);
        break;
      }
      bool1 = false;
      break label174;
      bool1 = false;
      break label189;
      bool1 = false;
      break label204;
    }
  }
  
  public void dAn()
  {
    if ((this.isRecord) || (this.isLocal)) {
      return;
    }
    this.Fb.findViewById(2131363685).setVisibility(0);
    this.Fb.findViewById(2131363685).setAlpha(1.0F);
  }
  
  public void dAr()
  {
    dAs();
    this.cre = false;
    RH(1);
  }
  
  public void destroy()
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b = null;
    this.app.removeObserver(this.jdField_a_of_type_Ajvm);
    if (this.aw != null)
    {
      this.aw.dismiss();
      this.aw = null;
    }
  }
  
  public void dzV()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "initCommentsWidget:mVideoData=" + this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "initCommentsWidget:mRoomid=" + this.dlS + "isHasVideoLabel=" + this.crb);
    }
    this.dlS = 0;
    cv(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adw);
    Ng(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.headerUrl);
  }
  
  public void hC(String paramString)
  {
    this.extraInfo = paramString;
    ((TextView)this.Fc.findViewById(2131366617)).setText(paramString);
  }
  
  public void hl(View paramView)
  {
    this.Fc = paramView;
    ((RoundRelativeLayout)this.Fc.findViewById(2131367401)).init(16);
    this.Fc.findViewById(2131367401).requestLayout();
    ((RoundRelativeLayout)this.Fc.findViewById(2131367400)).init(16);
    this.Fc.findViewById(2131367400).requestLayout();
    kJ();
  }
  
  public void hm(View paramView)
  {
    if (!this.crb) {
      return;
    }
    new ajxs().h("video").i("playpage_label_click").b().dy(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModel.13(this, (ajpj)this.app.getManager(106)), 16, null, false);
    switch (this.dlV)
    {
    case 3: 
    default: 
      return;
    case 1: 
      localObject = String.format("nowmqqapi://now/openroom?first=2&roomid=%s&roomtype=0&fromid=qq_smallvideo", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ajzv$a.roomId) });
      aqik.c(this.app, paramView.getContext(), (String)localObject).ace();
      new ajxs().h("video").i("playpage_live_click").b().dy(this.app);
      return;
    }
    Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Ajzv$c.url);
    paramView.getContext().startActivity((Intent)localObject);
  }
  
  public void hn(View paramView)
  {
    if (!jqi.isNetworkAvailable(this.Fb.getContext()))
    {
      QQToast.a(this.Fb.getContext(), 1, acfp.m(2131709719), 1).show();
      return;
    }
    this.cra = true;
    dAo();
    paramView = new ajww(this.app);
    VideoData localVideoData;
    int i;
    int j;
    if (!this.isLiked)
    {
      localVideoData = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData;
      View localView = this.Fb.findViewById(2131372730);
      i = localView.getWidth() / 2;
      j = localView.getHeight() / 2;
      if ((i != 0) && (j != 0)) {
        break label252;
      }
      i = jll.getScreenWidth(this.Fb.getContext()) / 2;
      j = jll.getScreenHeight(this.Fb.getContext()) / 2;
    }
    label252:
    for (;;)
    {
      if ((localVideoData != null) && (localVideoData.type != 6)) {
        ((LikeAniView)this.Fb.findViewById(2131370435)).iT(i, j);
      }
      paramView.a(this.feedsId, new akaa(this, localVideoData), null);
      anot.a(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_like", 0, 0, "", "", "", "2");
      return;
      this.crd = true;
      localVideoData = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData;
      paramView.b(this.feedsId, new akab(this, localVideoData), null);
      return;
    }
  }
  
  public void ho(View paramView)
  {
    ((ajpj)this.app.getManager(106)).go.put(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adw + "", Integer.valueOf(1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&from=3");
    int i = 3;
    if (this.app.getCurrentAccountUin().equals("" + this.adL)) {
      i = 2;
    }
    ((StringBuilder)localObject).append("&mode=" + i);
    localObject = "mqq://card/show_pslcard/?uin=" + this.adL + "&card_type=nearby" + ((StringBuilder)localObject).toString() + "&now_id=" + this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adt + "&now_user_type=" + this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.dlx;
    paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject)));
    new ajxs().h("video").i("playpage_post_click").b().dy(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModel.17(this, (ajpj)this.app.getManager(106)), 16, null, false);
    anot.a(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_card", 0, 0, "", "", "", "2");
  }
  
  public void hp(View paramView) {}
  
  public void hq(View paramView)
  {
    Object localObject = new HashMap();
    paramView = "";
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType == 4) {
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.yf.get(0) == null) {}
    }
    for (paramView = ((ajwh)this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.yf.get(0)).imageUrl;; paramView = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.coverUrl)
    {
      ((Map)localObject).put("record_title", this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSJ);
      ((Map)localObject).put("id", this.feedsId);
      ((Map)localObject).put("anchor_nick_name", this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSG);
      ((Map)localObject).put("feed_type", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType));
      ((Map)localObject).put("recorder_nick_name", this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSH);
      ((Map)localObject).put("roomName", this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSJ);
      ((Map)localObject).put("bNewQZone", Boolean.valueOf(false));
      ((Map)localObject).put("source", Integer.valueOf(6));
      ((Map)localObject).put("play_operatro_view_model", this);
      ((Map)localObject).put("anchor_uin", Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.ads));
      ((Map)localObject).put("record_uin", Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adu));
      String str1 = "https://now.qq.com/h5/view_record.html?_wv=1&_bid=2424&from=6&feeds_id=" + this.feedsId;
      String str2 = acfp.m(2131709729);
      localObject = acfp.m(2131709727);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSG)) {
        localObject = "“「" + this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSG + "」”" + acfp.m(2131709724);
      }
      ajxd.a(this.app, (BaseActivity)this.Fb.getContext(), String.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.ads), "", str1, str2, (String)localObject, paramView, paramView, this.F, new akad(this));
      this.aYL = true;
      return;
    }
  }
  
  public void hr(View paramView)
  {
    if (!ajrk.isNetworkConnected(paramView.getContext()))
    {
      QQToast.a(paramView.getContext(), 0, paramView.getContext().getResources().getString(2131696270), 0).show();
      return;
    }
    paramView = new ajww(this.app);
    if (this.Oe)
    {
      paramView.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adw, this.adO, this.dlW, 11, false, new akae(this));
      return;
    }
    this.crf = true;
    paramView.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adw, this.adO, this.dlW, 11, true, new akag(this));
  }
  
  public void hs(View paramView)
  {
    new ajxs().h("video").i("playpage_more_click").b().dy(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModel.21(this, (ajpj)this.app.getManager(106)), 16, null, false);
    paramView = (BaseActivity)this.Fb.getContext();
    ausj localausj = ausj.b(paramView);
    if (!this.isMine) {
      localausj.addButton(2131718050, 1);
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new akah(this, paramView, localausj));
      localausj.a(new akal(this));
      localausj.show();
      this.crc = true;
      return;
      localausj.addButton(acfp.m(2131709708), 1);
    }
  }
  
  public void ht(View paramView)
  {
    new ajxs().h("video").i("playpage_com_click").b().dy(this.app);
    ThreadManagerV2.excute(new PlayOperationViewModel.24(this, (ajpj)this.app.getManager(106)), 16, null, false);
    if (this.ao != null) {
      this.ao.onClick(paramView);
    }
  }
  
  public void hu(View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b.lP(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType);
    }
  }
  
  public void iS(int paramInt1, int paramInt2)
  {
    ImageView localImageView;
    if (this.Fc != null)
    {
      localImageView = (ImageView)this.Fc.findViewById(2131362336);
      localImageView.setVisibility(0);
      if (paramInt2 != 1) {
        break label63;
      }
      localImageView.setBackgroundDrawable(localImageView.getResources().getDrawable(2130846416));
    }
    while ((paramInt2 == 255) || (paramInt2 == 0))
    {
      localImageView.setVisibility(8);
      return;
      label63:
      localImageView.setBackgroundDrawable(localImageView.getResources().getDrawable(2130846414));
    }
    localImageView.setVisibility(0);
  }
  
  public void kn(long paramLong)
  {
    if (paramLong <= 0L)
    {
      ((TextView)this.Fb.findViewById(2131378786)).setText(acfp.m(2131709732));
      return;
    }
    ((TextView)this.Fb.findViewById(2131378786)).setText(ajxp.bz(paramLong));
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlayOperationViewModel", 2, "setCurrentAnchorUin,currentAnchorUin:" + paramLong);
    }
    this.adM = paramLong;
  }
  
  public void setFeedType(int paramInt)
  {
    if ((this.Fc != null) && (!this.isLocal)) {
      this.Fc.findViewById(2131379818).setVisibility(0);
    }
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
    ((TextView)this.Fc.findViewById(2131372369)).setText(paramString);
  }
  
  public void setOnCloseListener(StuffContainerView.b paramb)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b = paramb;
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ao = paramOnClickListener;
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.dlT = paramInt;
  }
  
  public void setWatchCount(int paramInt)
  {
    this.dly = paramInt;
    hC(ajxp.bA(this.dly) + acfp.m(2131709730));
  }
  
  class a
  {
    public int roomId;
    
    private a() {}
  }
  
  class b
  {
    public String coverUrl;
    public String jumpUrl;
    
    private b() {}
  }
  
  class c
  {
    public String feedId;
    public String topic;
    public String url;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzv
 * JD-Core Version:    0.7.0.1
 */