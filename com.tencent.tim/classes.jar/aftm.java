import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aftm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View Cb;
  public TextView RH;
  public TextView RI;
  private afte jdField_a_of_type_Afte;
  private afvb jdField_a_of_type_Afvb;
  private afwg jdField_a_of_type_Afwg;
  public ExtendFriendFeedView a;
  private ExtendFriendLabelFlowLayout b;
  public ExtendFriendVoiceView b;
  private int backgroundColor;
  public ETTextView c;
  private int cUn;
  private boolean caI;
  private boolean caJ;
  private int clothesId;
  private int fontId;
  private int fontType;
  public LinearLayout iJ;
  private FragmentActivity mActivity;
  private aqrn mVasRes;
  public ImageView qP;
  public ImageView zb;
  public ImageView zc;
  public ImageView zd;
  public ImageView ze;
  public ImageView zf;
  
  public aftm(View paramView, afwg paramafwg, afte paramafte, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Afte = paramafte;
    this.jdField_a_of_type_Afwg = paramafwg;
    if ((paramActivity instanceof FragmentActivity)) {
      this.mActivity = ((FragmentActivity)paramActivity);
    }
    this.Cb = paramView.findViewById(2131366596);
    this.zb = ((ImageView)paramView.findViewById(2131369031));
    this.RH = ((TextView)paramView.findViewById(2131381101));
    this.zc = ((ImageView)paramView.findViewById(2131369664));
    this.RI = ((TextView)paramView.findViewById(2131380909));
    this.iJ = ((LinearLayout)paramView.findViewById(2131370728));
    this.zd = ((ImageView)paramView.findViewById(2131363904));
    this.ze = ((ImageView)paramView.findViewById(2131363769));
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131367174));
    this.c = ((ETTextView)paramView.findViewById(2131381075));
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131369082));
    this.zf = ((ImageView)paramView.findViewById(2131363969));
    this.qP = ((ImageView)paramView.findViewById(2131382021));
    this.qP.setOnClickListener(this);
    this.Cb.setOnTouchListener((View.OnTouchListener)paramView);
    this.Cb.setOnClickListener(this);
    this.zb.setOnClickListener(this);
    this.zb.setOnTouchListener(afyk.A);
    this.zd.setOnClickListener(this);
    this.ze.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)paramActivity);
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.IK(true);
    this.zf.setOnClickListener(this);
  }
  
  private void dcb()
  {
    this.caJ = false;
    this.caI = false;
    this.fontId = 0;
    this.fontType = 0;
    this.clothesId = 0;
    this.c.setFont(0, System.currentTimeMillis());
    this.Cb.setBackground(null);
  }
  
  public int DE()
  {
    return this.clothesId;
  }
  
  public void a(aftm paramaftm, afua paramafua, int paramInt)
  {
    int i;
    if (paramafua.mIsMyFeed)
    {
      paramaftm.zd.setVisibility(8);
      paramaftm.ze.setVisibility(8);
      if (!paramafua.mbAllowStrangerVote) {
        paramaftm.zd.setVisibility(8);
      }
      Object localObject1 = paramaftm.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramafua.mVoiceUrl)) {
        break label560;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramaftm.getPosition();
      paramaftm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramafua.mVoiceUrl, paramInt);
      paramaftm.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramafua.mVoiceUrl);
      paramaftm.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramafua.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Afte.a(paramafua.mUin, paramafua.mNickName, paramaftm.zb);
      paramaftm.zb.setImageDrawable((Drawable)localObject1);
      paramaftm.RH.setText(paramafua.mNickName);
      paramaftm.c.setTextMsg(new aofk(awif.sj(paramafua.mDeclaration), 3, 24));
      paramaftm.c.setTextColor(-16777216);
      localObject1 = paramaftm.zd;
      if (!paramafua.mLiked) {
        break label573;
      }
      if (paramafua.mAvailLikeCount != 0) {
        break label566;
      }
      paramInt = 2130846022;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramafua, paramaftm.qP);
      paramaftm.qP.setTag(paramafua);
      dcb();
      if (!anlm.ayn())
      {
        setClothes(paramafua.clothesId);
        setFont(paramafua.fontId, paramafua.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = afxu.a(paramafua, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = afxu.b(paramafua, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = afxu.a(paramafua, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label597;
      }
      paramaftm.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramaftm.jdField_a_of_type_Afvb == null) {
        break label580;
      }
      paramaftm.jdField_a_of_type_Afvb.clearData();
      label387:
      paramaftm.jdField_a_of_type_Afvb.Iy(this.caJ);
      paramaftm.jdField_a_of_type_Afvb.kA((List)localObject1);
      label407:
      paramaftm.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramaftm.jdField_a_of_type_Afvb);
      if ((paramafua.mSchoolInfos == null) || (paramafua.mSchoolInfos.size() <= 0)) {
        break label634;
      }
      paramafua = (afua.b)paramafua.mSchoolInfos.get(0);
      if (paramafua == null) {
        break label622;
      }
      this.iJ.setVisibility(0);
      if (!TextUtils.isEmpty(paramafua.schoolName)) {
        paramaftm.RI.setText(paramafua.schoolName);
      }
      if (paramafua.authState != 2L) {
        break label609;
      }
      paramaftm.zc.setImageResource(2130846073);
      label505:
      if ((!this.caJ) && (!this.caI)) {
        break label646;
      }
    }
    label646:
    for (paramaftm = "2";; paramaftm = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", paramaftm);
      return;
      paramaftm.zd.setVisibility(0);
      paramaftm.ze.setVisibility(0);
      break;
      label560:
      i = 0;
      break label61;
      label566:
      paramInt = 2130846021;
      break label212;
      label573:
      paramInt = 2130846018;
      break label212;
      label580:
      paramaftm.jdField_a_of_type_Afvb = new afvb(BaseApplicationImpl.getContext());
      break label387;
      label597:
      paramaftm.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      break label407;
      label609:
      paramaftm.zc.setImageResource(2130846075);
      break label505;
      label622:
      this.iJ.setVisibility(8);
      break label505;
      label634:
      this.iJ.setVisibility(8);
      break label505;
    }
  }
  
  public boolean akl()
  {
    return this.caJ;
  }
  
  public int getFontId()
  {
    return this.fontId;
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_Afwg != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363904) || (l - this.jdField_a_of_type_Afwg.fC() >= 500L)) {
        break label46;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label46:
      this.jdField_a_of_type_Afwg.jf(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363769: 
        this.jdField_a_of_type_Afwg.Nj(i);
        break;
      case 2131366596: 
        this.jdField_a_of_type_Afwg.hT(i, 2);
        break;
      case 2131369031: 
        this.jdField_a_of_type_Afwg.hT(i, 1);
        break;
      case 2131382068: 
        this.jdField_a_of_type_Afwg.Nh(i);
        break;
      case 2131363904: 
        this.jdField_a_of_type_Afwg.Ni(i);
        break;
      case 2131363969: 
        this.jdField_a_of_type_Afwg.Nk(i);
        break;
      case 2131382021: 
        VipUtils.a(paramView, (afua)paramView.getTag());
      }
    }
  }
  
  public boolean pE()
  {
    return this.caI;
  }
  
  public void setClothes(int paramInt)
  {
    if (paramInt > 10000)
    {
      this.clothesId = paramInt;
      this.caJ = true;
      this.Cb.setVisibility(0);
      if ((this.Cb.getBackground() instanceof VasResDrawable)) {
        ((VasResDrawable)this.Cb.getBackground()).update(paramInt);
      }
    }
    else
    {
      return;
    }
    VasResDrawable localVasResDrawable = new VasResDrawable(this.mActivity.app, paramInt);
    aqry localaqry = new aqry(localVasResDrawable, this.mActivity.app, 2130847025);
    localaqry.SR(true);
    localaqry.a(new aftn(this));
    localVasResDrawable.a(localaqry);
    this.Cb.setBackgroundDrawable(localVasResDrawable);
  }
  
  public void setETTextColorFromClothes(aqqs paramaqqs)
  {
    if ((paramaqqs.fontColor != null) && (!TextUtils.isEmpty(paramaqqs.fontColor)))
    {
      this.cUn = Color.parseColor(paramaqqs.fontColor);
      if ((this.c != null) && (this.cUn != 0)) {
        this.c.setTextColor(this.cUn);
      }
    }
    if ((paramaqqs != null) && (paramaqqs.backgroundColor != null) && (!TextUtils.isEmpty(paramaqqs.backgroundColor)))
    {
      this.backgroundColor = Color.parseColor(paramaqqs.backgroundColor);
      if (SignTextEditFragment.isColorDark(this.backgroundColor))
      {
        this.RH.setTextColor(-1);
        this.zf.setColorFilter(null);
      }
    }
    else
    {
      return;
    }
    this.zf.setColorFilter(-1291845633);
    this.RH.setTextColor(-16777216);
  }
  
  public void setFont(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (this.mActivity == null)) {
      return;
    }
    this.c.setVisibility(0);
    this.c.setFont(0, System.currentTimeMillis());
    this.c.mMsgId = System.currentTimeMillis();
    this.caI = true;
    this.fontId = paramInt1;
    this.fontType = paramInt2;
    if (this.mVasRes == null)
    {
      this.mVasRes = new aqrn(this.mActivity.app, paramInt1);
      aqsa localaqsa = new aqsa(this.mVasRes, this.mActivity.app, paramInt2);
      localaqsa.a(this.c, this.c.getTextSize(), true);
      this.mVasRes.a(localaqsa);
      localaqsa.XS(-1);
      return;
    }
    ((aqsa)this.mVasRes.a()).a(this.c, this.c.getTextSize(), true);
    ((aqsa)this.mVasRes.a()).update(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftm
 * JD-Core Version:    0.7.0.1
 */