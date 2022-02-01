package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import acci;
import acff;
import acfp;
import aetb;
import aetb.a;
import aetb.b;
import aetc;
import afcy;
import ajdo;
import albb;
import alcn;
import alcs;
import alde;
import aldf;
import alem;
import algi;
import algj;
import algk;
import algl;
import algm;
import algn;
import algo;
import algp;
import algq;
import amhj;
import amii;
import amii.a;
import amij;
import amin;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aofk;
import aqae;
import aqaf;
import aqdj;
import aqep;
import aqft;
import aqgv;
import aqnm;
import argi;
import arjh;
import aurf;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView.b;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements amii.a, View.OnClickListener, BounceScrollView.b
{
  public static String TAG = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
  public static int dti = 1000;
  public static int dtj = 1003;
  public alcn a;
  private Handler.Callback a;
  public QQAppInterface app;
  public int bHA;
  public int bsd;
  public afcy c;
  private boolean cwJ;
  public AtomicBoolean dA = new AtomicBoolean(false);
  public int dth;
  public int dtk;
  public AtomicBoolean dz = new AtomicBoolean(false);
  protected acci g = new a(this);
  public aurf i = new aurf(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private View.OnTouchListener j = new algn(this);
  protected float jG;
  public BaseActivity mActivity;
  public String mCoverUrl;
  protected float mDensity;
  public HashMap<String, View> mt = new HashMap();
  protected float of;
  public long pendantId = 0L;
  private float yA;
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, alcn paramalcn)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new algi(this);
    this.mActivity = paramBaseActivity;
    this.app = paramBaseActivity.app;
    this.jdField_a_of_type_Alcn = paramalcn;
    paramBaseActivity = getResources().getDisplayMetrics();
    this.mDensity = paramBaseActivity.density;
    this.of = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jG = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.yA = (this.of - ankt.dip2px(127.0F));
  }
  
  private String a(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "combineNickNameAndNumber");
    }
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = localTextPaint;
    if (localTextPaint == null)
    {
      paramTextView = new TextPaint(1);
      paramTextView.density = this.mDensity;
    }
    float f1 = paramTextView.measureText("…");
    float f2 = this.mDensity;
    float f3 = paramTextView.measureText(String.format("QQ：%s ()", new Object[] { paramString2 }));
    paramString1 = TextUtils.ellipsize(paramString1, paramTextView, this.yA - f3 - (f1 + 5.0F * f2), TextUtils.TruncateAt.END);
    paramTextView = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramTextView = "…";
    }
    return String.format("QQ：%s (%s)", new Object[] { paramString2, paramTextView });
  }
  
  private void dFJ()
  {
    if ((this.dA.get()) && (this.dz.get()) && (this.i != null) && (!this.cwJ))
    {
      this.cwJ = true;
      Message localMessage = this.i.obtainMessage(dti);
      if (localMessage != null) {
        this.i.sendMessage(localMessage);
      }
    }
  }
  
  private void r(alcn paramalcn)
  {
    int m = 2;
    if (paramalcn != null)
    {
      aqep.a(paramalcn, this.app, this.mActivity);
      int k = m;
      if (paramalcn.e != null)
      {
        k = m;
        if (paramalcn.e.pa == 0) {
          k = 1;
        }
      }
      anot.a(this.app, "dc00898", "", "", "0X8009999", "0X8009999", k, 0, "", "", "", "");
    }
  }
  
  private void y(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof aqdj)) {
        ((aqdj)paramImageView).setSupportMaskView(false);
      }
    }
  }
  
  public int Hx()
  {
    return 0;
  }
  
  public void L(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if (!aldf.a().bo(this.app))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = aetc.a();
    if ((localObject == null) || (((aetb)localObject).isEmpty()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131380763);
    ImageView localImageView = (ImageView)paramView.findViewById(2131369705);
    ArrayList localArrayList = ((aetb)localObject).a().jQ;
    localTextView.setText(aldf.a().a((aetb)localObject));
    int k = 0;
    int m;
    while (k < ((aetb)localObject).a().jQ.size()) {
      if (TextUtils.isEmpty(((aetb.b)localArrayList.get(k)).topicName))
      {
        k += 1;
      }
      else
      {
        m = ((aetb.b)localArrayList.get(k)).topicId;
        localObject = ((aetb.b)localArrayList.get(k)).topicName;
      }
    }
    for (k = m;; k = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new algl(this, (String)localObject, k, paramView));
      }
      localImageView.setOnClickListener(new algm(this, paramView));
      anot.a(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  public void SP(int paramInt) {}
  
  public SpannableStringBuilder a(alcn paramalcn, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramalcn.e.pa == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramalcn = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130846762);
      paramalcn = paramSpannableString;
    }
    catch (OutOfMemoryError paramSpannableString)
    {
      for (;;)
      {
        int k;
        paramSpannableString.printStackTrace();
      }
    }
    catch (Throwable paramSpannableString)
    {
      for (;;)
      {
        paramSpannableString.printStackTrace();
      }
    }
    paramalcn = new arjh(getResources(), paramalcn, false, false);
    k = (int)(paramTextView.getTextSize() + 0.5F);
    paramalcn.setBounds(0, 0, k, k);
    paramalcn = new argi(paramalcn, 0);
    paramalcn.a(-0.1F);
    localSpannableStringBuilder.setSpan(paramalcn, 0, "[S]".length(), 17);
    return localSpannableStringBuilder;
  }
  
  public void a(alcn paramalcn, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.mt.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
      }
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteView)localObject).cQn;
      }
      if ((paramalcn.d != null) && (paramalcn.d.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).ejk();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(paramalcn.mOnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.mActivity.getString(2131692171), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(alcn paramalcn, String paramString)
  {
    paramString = (View)this.mt.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      a((TextView)paramString, paramalcn);
    }
  }
  
  public void a(alcn paramalcn, HashMap<String, String> paramHashMap)
    throws ProfileTemplateException
  {
    paramalcn = paramalcn.jdField_b_of_type_Alcs.gB;
    String str1 = getClass().getName();
    if ((paramalcn == null) || (paramalcn.size() <= 0)) {
      throw new ProfileTemplateException(str1 + " template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label435:
    label438:
    for (;;)
    {
      Object localObject1;
      String str2;
      Object localObject2;
      int k;
      String str3;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramalcn.get(str2);
        String[] arrayOfString = ((String)localObject1).split(",");
        int m = arrayOfString.length;
        k = 0;
        if (k >= m) {
          break label435;
        }
        str3 = arrayOfString[k];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          if ((str3.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            k = 1;
          }
        }
      }
      for (;;)
      {
        if (k != 0) {
          break label438;
        }
        throw new ProfileTemplateException(str1 + " template attr " + str2 + " type is not " + (String)localObject1);
        if ((str3.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          k = 1;
        }
        else if ((str3.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          k = 1;
        }
        else
        {
          k += 1;
          break;
          return;
          k = 0;
        }
      }
    }
  }
  
  public void a(amii paramamii, View paramView)
  {
    paramamii = paramamii.getData();
    if ((paramamii instanceof com.tencent.util.Pair))
    {
      paramamii = (com.tencent.util.Pair)paramamii;
      amin.u(this.mActivity, amin.K(((Integer)paramamii.first).intValue(), (String)paramamii.second), -1);
    }
  }
  
  public void a(LinearLayout paramLinearLayout, alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle");
    }
    if ((paramalcn == null) || (paramLinearLayout == null)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    List localList = aqep.a(this.mActivity, paramalcn.d);
    boolean bool = localList.isEmpty();
    int k;
    int m;
    if ((paramalcn.e != null) && (paramalcn.e.pa == 0))
    {
      k = 1;
      if ((bool) && (k != 0)) {
        localList.add(android.util.Pair.create(this.mActivity.getString(2131701531), ""));
      }
      if (!localList.isEmpty())
      {
        m = localList.size();
        k = 0;
      }
    }
    else
    {
      for (;;)
      {
        for (;;)
        {
          String str;
          TextView localTextView;
          if (k < m)
          {
            android.util.Pair localPair = (android.util.Pair)localList.get(k);
            str = (String)localPair.first;
            localTextView = new TextView(this.mActivity);
            localTextView.setText(str);
            localTextView.setTextColor(getResources().getColor(2131167304));
            if (!TextUtils.isEmpty((CharSequence)localPair.second))
            {
              localTextView.setBackgroundResource(2130844876);
              localTextView.setPadding(aqnm.dpToPx(8.0F), aqnm.dpToPx(4.5F), aqnm.dpToPx(8.0F), aqnm.dpToPx(4.5F));
            }
            localTextView.setTextSize(14.0F);
            paramLinearLayout.addView(localTextView);
          }
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = aqnm.dpToPx(6.0F);
            paramLinearLayout.measure(0, 0);
            QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.yA + ", " + paramLinearLayout.getMeasuredWidth());
            if (paramLinearLayout.getMeasuredWidth() > this.yA)
            {
              paramLinearLayout.removeView(localTextView);
              paramLinearLayout.setOnTouchListener(this.j);
              paramLinearLayout.setOnClickListener(new algk(this, paramalcn));
              return;
              k = 0;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            if (!bool) {
              aqep.a(localTextView, null, null, paramalcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
            }
            k += 1;
          }
        }
      }
    }
    paramLinearLayout.setVisibility(8);
  }
  
  public void a(TextView paramTextView, alcn paramalcn)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramalcn == null) {}
    for (Card localCard = null; (paramalcn == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramalcn.e)) || (ProfileActivity.AllInOne.k(paramalcn.e)); localCard = paramalcn.d)
    {
      this.mt.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    boolean bool;
    String str1;
    if (paramalcn.cwc)
    {
      localObject1 = ((TroopManager)this.app.getManager(52)).b(paramalcn.troopUin, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
        localObject2 = localCard.strNick;
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = aqgv.b(this.app, localCard.uin, false);
        }
        if (!TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin)) {
          break;
        }
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        paramTextView.setText((CharSequence)localObject1);
        paramTextView.setOnTouchListener(this.j);
        paramTextView.setOnClickListener(new algq(this, paramalcn));
        aqep.a(paramTextView, localCard.uin, (String)localObject2, paramalcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
        return;
        if (TextUtils.isEmpty(localCard.strReMark)) {
          localObject2 = localCard.strNick;
        } else {
          localObject2 = localCard.strReMark;
        }
      }
      localObject2 = localCard.uin;
      if (!localCard.isNoCover()) {}
      for (bool = true;; bool = false)
      {
        str1 = a(paramTextView, (String)localObject1, (String)localObject2, bool);
        localObject2 = localObject1;
        localObject1 = str1;
        break;
      }
    }
    if ((paramalcn.gh != null) && (!TextUtils.isEmpty(paramalcn.gh[5])) && (!TextUtils.equals(paramalcn.gh[5], localCard.strNick))) {}
    for (int k = 1;; k = 0)
    {
      if ((!TextUtils.isEmpty(localCard.strReMark)) || (k != 0))
      {
        localObject1 = localCard.strNick;
        localObject2 = localCard.uin;
        if (!localCard.isNoCover()) {}
        for (bool = true;; bool = false)
        {
          String str2 = a(paramTextView, (String)localObject1, (String)localObject2, bool);
          str1 = localCard.strNick;
          localObject1 = str2;
          localObject2 = str1;
          if (!TextUtils.isEmpty(str2)) {
            break;
          }
          localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
          localObject2 = str1;
          break;
        }
      }
      localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
      break;
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.pa == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.uin, false);
      return;
    }
    String str;
    if (paramAllInOne.pa == 80)
    {
      str = aqep.a(paramAllInOne);
      if ((str != null) && (str.length() > 0))
      {
        localObject = (ajdo)this.app.getManager(11);
        if (localObject == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject = ((ajdo)localObject).c(str);; localObject = null)
    {
      if (localObject != null)
      {
        a(paramAllInOne, 1, str, false);
        return;
      }
      a(paramAllInOne, 0, paramAllInOne.uin, false);
      return;
      a(paramAllInOne, 0, paramAllInOne.uin, false);
      return;
      if (ProfileActivity.AllInOne.g(paramAllInOne))
      {
        if (((paramAllInOne.pa == 41) || (paramAllInOne.pa == 86)) && (!TextUtils.isEmpty(paramAllInOne.uin)) && (paramAllInOne.uin.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.uid)))
        {
          a(paramAllInOne, 0, paramAllInOne.uid, false);
          return;
        }
        a(paramAllInOne, 0, paramAllInOne.uin, true);
        return;
      }
      localObject = aqep.a(paramAllInOne);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (paramAllInOne.pa == 53)
        {
          if (paramAllInOne.bindQQ) {}
          for (int k = 1;; k = 3)
          {
            a(paramAllInOne, k, (String)localObject, false);
            return;
          }
        }
        a(paramAllInOne, 1, (String)localObject, false);
        return;
      }
      a(paramAllInOne, 2, paramAllInOne.uin, false);
      return;
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString + ",isDynamicMode:" + paramBoolean);
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      ThreadManager.post(new ProfileHeaderView.3(this, paramInt, paramAllInOne, paramString), 8, null, true);
      return;
    }
    this.mActivity.runOnUiThread(new ProfileHeaderView.4(this, paramAllInOne, paramInt, paramString));
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject = (View)this.mt.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
      }
      ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
  }
  
  public abstract void b(alcn paramalcn, boolean paramBoolean);
  
  public void b(TextView paramTextView, alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfo");
    }
    if ((paramalcn == null) || (paramTextView == null)) {
      return;
    }
    List localList = aqep.a(this.app, this.mActivity, paramalcn.d);
    boolean bool = localList.isEmpty();
    int k;
    label70:
    SpannableStringBuilder localSpannableStringBuilder;
    int i2;
    Object localObject2;
    Object localObject3;
    int i1;
    int m;
    int n;
    if ((paramalcn.e != null) && (paramalcn.e.pa == 0))
    {
      k = 1;
      if ((bool) && (k != 0)) {
        localList.add(new SpannableString(this.mActivity.getString(2131701531)));
      }
      if (localList.isEmpty()) {
        break label585;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      i2 = localList.size();
      localObject2 = aqep.a(localList, 0, i2, "  ", localSpannableStringBuilder);
      localObject3 = paramTextView.getPaint();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.mDensity;
      }
      if (((TextPaint)localObject1).measureText((CharSequence)localObject2, 0, ((SpannableStringBuilder)localObject2).length() - 1) <= this.yA) {
        break label592;
      }
      localObject2 = new SpannableStringBuilder();
      k = 0;
      i1 = 1;
      label265:
      do
      {
        localObject3 = aqep.a(localList, k, i1, "  ", localSpannableStringBuilder);
        if (((TextPaint)localObject1).measureText((CharSequence)localObject3, 0, ((SpannableStringBuilder)localObject3).length() - 1) >= this.yA) {
          break label479;
        }
        m = i1 + 1;
        n = k;
        i1 = m;
        k = n;
        if (n < 0) {
          break;
        }
        i1 = m;
        k = n;
        if (m > i2) {
          break;
        }
        i1 = m;
        k = n;
      } while (n < m);
      k = n;
      i1 = m;
      label312:
      if ((i1 > 1) && (k < i1 - 1) && (i1 - 1 == i2))
      {
        localObject1 = aqep.a(localList, k, i1 - 1, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      }
    }
    label585:
    label592:
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((View)paramTextView.getParent()).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
      ((View)paramTextView.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramTextView.setVisibility(0);
      paramTextView.setSingleLine(true);
      paramTextView.setText((CharSequence)localObject1);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramTextView.setOnTouchListener(this.j);
      paramTextView.setOnClickListener(new algj(this, paramalcn));
      if (bool) {
        break;
      }
      aqep.a(paramTextView, null, null, paramalcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
      return;
      k = 0;
      break label70;
      label479:
      if (i1 - k == 1)
      {
        localObject1 = aqep.a(localList, k, i2, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        break label312;
      }
      localObject3 = aqep.a(localList, k, i1 - 1, "  ", localSpannableStringBuilder);
      if (((SpannableStringBuilder)localObject2).length() > 0) {
        ((SpannableStringBuilder)localObject2).append("\n");
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject3);
      n = i1 - 1;
      m = i1;
      break label265;
      paramTextView.setVisibility(8);
      return;
    }
  }
  
  public void c(alcn paramalcn, boolean paramBoolean)
  {
    Object localObject = (View)this.mt.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramalcn.e))
      {
        ((ImageView)localObject).setVisibility(4);
        this.pendantId = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new ProfileHeaderView.8(this, paramalcn, paramBoolean), 8, null, true);
  }
  
  protected boolean d(alcn paramalcn)
  {
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if ((paramalcn != null) && (paramalcn.d != null))
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramalcn.e.uin, this.app.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramalcn.e);
      if ((bool5) || (bool6)) {
        break label178;
      }
      if ((!bool2) || (!paramalcn.d.strangerVoteOpen)) {
        break label173;
      }
      bool1 = true;
    }
    label70:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramalcn.e.uin;
        if (bool2) {
          bool4 = paramalcn.d.strangerVoteOpen;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("isShowZan updateLike show=%b uin=%sself=%b frd=%b cardOk=%b open=%b ", new Object[] { Boolean.valueOf(bool3), str, Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      }
      return bool3;
      bool2 = false;
      break;
      bool1 = false;
      break label70;
    }
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void e(alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ProfileHeaderView onInit");
    }
    g(paramalcn);
    if (paramalcn.jdField_b_of_type_Alcs != null) {
      o(paramalcn);
    }
    this.app.addObserver(this.g);
  }
  
  public void e(CoverCacheData paramCoverCacheData)
  {
    Object localObject = (View)this.mt.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateQzonePhotoView");
      }
      ((QzonePhotoView)localObject).f(paramCoverCacheData);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateVipPhotoViewForSimple");
    }
    ((VipPhotoViewForSimple)localObject).f(paramCoverCacheData);
  }
  
  public void f(alcn paramalcn)
  {
    Object localObject = (View)this.mt.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = aqep.b(this.mActivity, paramalcn);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + aqft.pl(str));
      }
      if (paramalcn.e.pa != 33) {
        break label126;
      }
      paramalcn = this.mActivity.getString(2131701525);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramalcn);
      ((TextView)localObject).setContentDescription(paramalcn);
    }
    label126:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.mActivity.getString(2131692156) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void fz(String paramString, int paramInt) {}
  
  public void g(alcn paramalcn)
  {
    this.dtk &= 0xFFFFFFFE;
    this.dz.set(false);
    View localView = (View)this.mt.get("map_key_tips_net_voice");
    paramalcn = localView;
    if (localView == null) {
      paramalcn = View.inflate(this.mActivity, 2131562237, null);
    }
    if (paramalcn != null)
    {
      this.dz.set(true);
      dFJ();
    }
    this.mt.put("map_key_tips_net_voice", paramalcn);
  }
  
  public CoverCacheData getCoverCacheData()
  {
    Object localObject = (View)this.mt.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateQzonePhotoView");
      }
      return ((QzonePhotoView)localObject).getCoverCacheData();
    }
    if ((localObject instanceof VipPhotoViewForSimple))
    {
      localObject = (VipPhotoViewForSimple)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateVipPhotoViewForSimple");
      }
      return ((VipPhotoViewForSimple)localObject).getCoverCacheData();
    }
    return null;
  }
  
  public void i(alcn paramalcn)
  {
    if ((paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.mt.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    boolean bool1 = d(paramalcn);
    boolean bool2 = TextUtils.equals(paramalcn.e.uin, this.app.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      Object localObject2;
      int m;
      int k;
      if ((paramalcn == null) || (paramalcn.d == null))
      {
        localObject1 = this.mActivity.getString(2131692248);
        localObject2 = null;
        m = 0;
        k = 0;
        bool1 = false;
        localVoteView.a(bool2, bool1, k, m, this.c, false);
        localVoteView.setTag(localObject2);
        if (paramalcn == null) {
          break label431;
        }
        localVoteView.setOnClickListener(paramalcn.mOnClickListener);
      }
      for (;;)
      {
        localVoteView.setContentDescription((CharSequence)localObject1);
        return;
        if (this.c == null) {
          this.c = new afcy(this.mActivity, this.app, 1, 1);
        }
        m = (int)paramalcn.d.lVoteCount;
        k = paramalcn.d.iVoteIncrement;
        this.c.zn = paramalcn.d.getLastPraiseInfoList();
        if (k <= this.c.zn.size()) {
          this.c.zn = this.c.zn.subList(0, k);
        }
        this.c.zn = alem.bp(this.c.zn);
        if (1 == paramalcn.d.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          if (!bool2) {
            break label364;
          }
          localObject2 = new albb(10, paramalcn.d);
          localObject1 = String.format(this.mActivity.getString(2131692246), new Object[] { String.valueOf(m) });
          n = k;
          k = m;
          m = n;
          break;
        }
        label364:
        localObject2 = new albb(10, paramalcn.d);
        localObject1 = String.format(this.mActivity.getString(2131692159), new Object[] { String.valueOf(m) });
        if (paramalcn.d.bAvailVoteCnt == 0) {
          localVoteView.ejk();
        }
        int n = k;
        k = m;
        m = n;
        break;
        label431:
        localVoteView.setOnClickListener(null);
      }
    }
    localVoteView.setVisibility(4);
  }
  
  public void i(String paramString, int paramInt, List<alde> paramList) {}
  
  public void j(alcn paramalcn)
  {
    Object localObject = (View)this.mt.get("map_key_profile_nick_name");
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130846647);
    }
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramalcn.e;
      str = paramalcn.a.a.value;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + aqft.pl(str));
      }
      if (str != null)
      {
        localObject = str;
        if (str.length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label223;
        }
        localObject = String.valueOf(localAllInOne.uin);
      }
      localTextView.setText((CharSequence)localObject);
      str = this.mActivity.getString(2131692177) + ":";
      localTextView.setContentDescription(str + (String)localObject);
      localTextView.setTag(new albb(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(paramalcn.mOnClickListener);
      localTextView.setOnLongClickListener(paramalcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
    }
    label223:
    while (!(localObject instanceof ProfileNameView)) {
      for (;;)
      {
        TextView localTextView;
        ProfileActivity.AllInOne localAllInOne;
        String str;
        return;
        localObject = " ";
      }
    }
    ((ProfileNameView)localObject).b(this.app, paramalcn);
  }
  
  @TargetApi(16)
  public void l(alcn paramalcn)
  {
    View localView = (View)this.mt.get("map_key_tag_jueban");
    Object localObject = (View)this.mt.get("map_key_like");
    if (((localView instanceof ImageView)) && (localObject != null) && (paramalcn.d != null) && (d(paramalcn)) && (aqep.P(paramalcn.d.getBgTypeArray())))
    {
      localObject = "1";
      if (paramalcn.e.pa == 0) {
        localObject = "0";
      }
      anot.a(this.app, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
      localView.setVisibility(0);
      localView.setTag(new albb(34, null));
      localView.setOnClickListener(paramalcn.mOnClickListener);
    }
  }
  
  public void m(alcn paramalcn)
  {
    if ((paramalcn != null) && (paramalcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, paramalcn.troopUin))) {}
    Object localObject1;
    View localView;
    TextView localTextView;
    Object localObject4;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = (View)this.mt.get("map_key_sign");
          localView = (View)this.mt.get("map_key_sign_common_topic");
        } while ((!(localObject1 instanceof TextView)) || (paramalcn == null) || (paramalcn.e == null));
        localTextView = (TextView)localObject1;
        if (paramalcn.d != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localObject4 = paramalcn.d.getRichStatus();
      if ((ProfileActivity.AllInOne.g(paramalcn.e)) && (localObject4 != null)) {
        break;
      }
      if (paramalcn.e.pa == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130846762, 0, 0, 0);
        localTextView.setText(acfp.m(2131709962));
        localTextView.setVisibility(0);
        localTextView.setTag(new albb(3, ""));
        localTextView.setOnClickListener(paramalcn.mOnClickListener);
        localTextView.setContentDescription(this.mActivity.getString(2131692237));
        L(localView, true);
        return;
      }
      localTextView.setVisibility(8);
    } while (localView == null);
    localView.setVisibility(8);
    return;
    SpannableString localSpannableString = new SpannableString(((RichStatus)localObject4).toSpannableStringWithTopic("", -8947849, -2039584, this));
    Object localObject5;
    label464:
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(((RichStatus)localObject4).actionText))
    {
      localObject5 = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject5).insert(0, "[S] ");
      localObject1 = (amhj)this.app.getManager(15);
      if (localObject1 != null)
      {
        localObject1 = ((amhj)localObject1).i(((RichStatus)localObject4).actionId, 200);
        localObject1 = new arjh(getResources(), (Bitmap)localObject1, false, false);
        int k = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, k, k);
        localObject1 = new argi((Drawable)localObject1, 0);
        ((argi)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject5).setSpan(localObject1, 0, "[S]".length(), 17);
        this.bsd = k;
        if (paramalcn.e.pa == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130846762, 0, 0, 0);
        }
        localTextView.setText(new aofk((CharSequence)localObject5, 1, 14));
        localTextView.setMovementMethod(amij.getInstance());
        localTextView.setVisibility(0);
        if (localSpannableString.length() > 0)
        {
          if ((!aldf.a().bm(this.app)) && (((RichStatus)localObject4).topics != null) && (((RichStatus)localObject4).topics.size() > 0)) {
            localTextView.post(new ProfileHeaderView.5(this, (RichStatus)localObject4, localTextView));
          }
          aldf.a().c(this.app, (RichStatus)localObject4);
          bool2 = aldf.a().bn(this.app);
          if (localView != null)
          {
            if (paramalcn.e.pa != 0) {
              break label1082;
            }
            bool1 = true;
            label565:
            localObject4 = (TextView)localView.findViewById(2131380763);
            localObject5 = (ImageView)localView.findViewById(2131369705);
            localObject1 = new oidb_0xd9f.RspBody();
            if ((paramalcn.d == null) || (paramalcn.d.vLongNickTopicInfo == null)) {
              break label1143;
            }
          }
        }
      }
    }
    try
    {
      ((oidb_0xd9f.RspBody)localObject1).mergeFrom(paramalcn.d.vLongNickTopicInfo);
      localObject1 = (oidb_0xd9f.LongNickItem)((oidb_0xd9f.RspBody)localObject1).longnick_item.get();
      if (localObject1 == null) {
        break label1087;
      }
      localObject1 = ((oidb_0xd9f.LongNickItem)localObject1).rpt_topic_item.get();
      label658:
      if ((!bool2) && (!aldf.a().k(this.app, aldf.a().e((List)localObject1)))) {
        break label1133;
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (aldf.a().w((List)localObject1) <= 0)) {
        break label1093;
      }
      localView.setTag(new albb(97, aldf.a().d((List)localObject1)));
      localView.setOnClickListener(paramalcn.mOnClickListener);
      ((TextView)localObject4).setText(acfp.m(2131709961) + aldf.a().w((List)localObject1) + acfp.m(2131709959));
      ((ImageView)localObject5).setOnClickListener(new algo(this, localView));
      localView.setVisibility(0);
      anot.a(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label839:
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
        }
        label914:
        label1082:
        label1087:
        label1093:
        L(localView, bool1);
        continue;
        label1133:
        L(localView, bool1);
      }
    }
    if ((paramalcn.e.pa == 0) || (ProfileActivity.AllInOne.b(paramalcn.e))) {
      localTextView.setOnClickListener(paramalcn.mOnClickListener);
    }
    if ((ProfileActivity.AllInOne.b(paramalcn.e)) && (paramalcn.e.pa != 0)) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130846763, 0);
    }
    if (!TextUtils.isEmpty(localSpannableString))
    {
      localObject1 = localSpannableString.toString();
      localTextView.setTag(new albb(3, localObject1));
      localTextView.setOnLongClickListener(paramalcn.jdField_b_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.mActivity.getString(2131692237)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label1161;
      }
    }
    label1161:
    for (paramalcn = localSpannableString.toString();; paramalcn = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramalcn);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130850435);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          localObject3 = null;
        }
      }
      break;
      this.bsd = 0;
      localTextView.setText(new aofk(a(paramalcn, localSpannableString, localTextView), 1, 14));
      localTextView.setMovementMethod(amij.getInstance());
      localTextView.setVisibility(0);
      break label464;
      bool1 = false;
      break label565;
      Object localObject3 = null;
      break label658;
      L(localView, bool1);
      break label839;
      label1143:
      L(localView, bool1);
      break label839;
      String str = "";
      break label914;
    }
  }
  
  public void n(alcn paramalcn)
  {
    View localView = (View)this.mt.get("map_key_details");
    if ((localView instanceof TextView)) {
      b((TextView)localView, paramalcn);
    }
    while (!(localView instanceof LinearLayout)) {
      return;
    }
    a((LinearLayout)localView, paramalcn);
  }
  
  public void o(alcn paramalcn)
  {
    this.dtk &= 0xFFFFFFFD;
    this.dA.set(false);
    View localView = (View)this.mt.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.mActivity, 2131562220, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramalcn == null) || (paramalcn.d == null))
      {
        this.dA.set(true);
        dFJ();
        return;
      }
      this.mt.put("map_key_tips_set_card", localView);
      if ((paramalcn.e.pa == 0) || (this.app.getCurrentAccountUin().equals(paramalcn.e.uin)))
      {
        long l1 = paramalcn.d.lCurrentStyleId;
        long l2 = paramalcn.d.lCurrentBgId;
        int k = paramalcn.d.templateRet;
        Object localObject1 = paramalcn.d.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "updateSetCardBar bgtype = " + localObject1);
        }
        localObject1 = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131368272);
        ImageView localImageView = (ImageView)localView.findViewById(2131368252);
        Object localObject2 = this.app.getPreferences();
        boolean bool = false;
        if (localObject2 != null) {
          bool = ((SharedPreferences)localObject2).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "isShowTips" + bool + ",templateRet=" + k + ",myTemplateId=" + l1);
        }
        if (((101107 == k) || (101108 == k)) && (!bool) && (localObject2 != null))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject2 = this.mActivity;
          if (101107 != k) {
            break label460;
          }
        }
        label460:
        for (localObject1 = ((Resources)localObject1).getString(2131697320);; localObject1 = ((Resources)localObject1).getString(2131720669))
        {
          localObject1 = ((BaseActivity)localObject2).getString(2131718637, new Object[] { localObject1 });
          localTextView.setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new albb(24, Integer.valueOf(k)));
          localView.setOnClickListener(paramalcn.mOnClickListener);
          this.dtk |= 0x2;
          this.dA.set(true);
          dFJ();
          return;
        }
      }
      ThreadManager.post(new UpdateProfileSetCardTask(this), 5, null, true);
      return;
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    this.mDensity = paramConfiguration.density;
    this.of = Math.min(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
    this.jG = Math.max(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
  }
  
  public void onDestroy()
  {
    if (this.app != null) {
      this.app.removeObserver(this.g);
    }
    if (this.i != null) {
      this.i.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.mt.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).onDestroy();
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void p(alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.mt.get("map_key_tips");
    LinearLayout localLinearLayout;
    if ((localObject instanceof LinearLayout))
    {
      localLinearLayout = (LinearLayout)localObject;
      if (((this.dtk & 0x1) == 0) || ((this.dtk & 0x2) == 0)) {
        break label241;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "ProfileHeaderView updateTips netvoice and setcard");
      }
      paramalcn = (View)this.mt.get("map_key_tips_net_voice");
      localObject = (View)this.mt.get("map_key_tips_set_card");
      if ((paramalcn != null) && (localObject != null))
      {
        if (localLinearLayout.getChildCount() != 0) {
          break label171;
        }
        localLinearLayout.addView(paramalcn);
        localLinearLayout.setVisibility(0);
        if (this.dth < 4)
        {
          this.dth += 1;
          paramalcn = this.i.obtainMessage(dti);
          this.i.sendMessageDelayed(paramalcn, 4000L);
        }
      }
    }
    label171:
    label241:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              View localView;
              do
              {
                return;
                localView = localLinearLayout.getChildAt(0);
              } while (localView == null);
              if (localView.getId() == 2131373652) {
                paramalcn = (alcn)localObject;
              }
              for (;;)
              {
                localObject = AnimationUtils.loadAnimation(this.mActivity, 2130772337);
                ((Animation)localObject).setFillAfter(true);
                ((Animation)localObject).setAnimationListener(new algp(this, localLinearLayout, paramalcn));
                localLinearLayout.setVisibility(0);
                localView.startAnimation((Animation)localObject);
                return;
              }
              if ((this.dtk & 0x1) == 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ProfileHeaderView updateTips netvoice");
              }
              paramalcn = (View)this.mt.get("map_key_tips_net_voice");
            } while (paramalcn == null);
            localLinearLayout.removeAllViews();
            localLinearLayout.addView(paramalcn);
            localLinearLayout.setVisibility(0);
            return;
            if ((this.dtk & 0x2) == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "ProfileHeaderView updateTips setcard");
            }
            localObject = (View)this.mt.get("map_key_tips_set_card");
          } while (localObject == null);
          localLinearLayout.removeAllViews();
          localLinearLayout.addView((View)localObject);
          localLinearLayout.setVisibility(0);
        } while (!paramalcn.cwc);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
      } while ((paramalcn == null) || (paramalcn.d == null) || (paramalcn.d.lCurrentStyleId != alcs.agk));
      localLinearLayout.setVisibility(8);
      paramalcn = (View)this.mt.get("map_key_space_view");
    } while (paramalcn == null);
    localObject = (RelativeLayout.LayoutParams)paramalcn.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height += aqep.v(this.mActivity, 18);
    paramalcn.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramalcn.setFocusable(true);
    paramalcn.setFocusableInTouchMode(true);
  }
  
  public void q(alcn paramalcn) {}
  
  public void setShoppingBgBlur(boolean paramBoolean) {}
  
  public static class UpdateProfileSetCardTask
    implements Runnable
  {
    WeakReference<ProfileHeaderView> hy;
    
    UpdateProfileSetCardTask(ProfileHeaderView paramProfileHeaderView)
    {
      this.hy = new WeakReference(paramProfileHeaderView);
    }
    
    public void run()
    {
      ProfileHeaderView localProfileHeaderView = (ProfileHeaderView)this.hy.get();
      if (localProfileHeaderView != null) {
        for (;;)
        {
          try
          {
            Object localObject1 = localProfileHeaderView.a;
            QQAppInterface localQQAppInterface = localProfileHeaderView.app;
            long l1 = ((alcn)localObject1).d.lCurrentStyleId;
            long l2 = ((alcn)localObject1).d.lCurrentBgId;
            int i = ((alcn)localObject1).d.templateRet;
            Object localObject2 = ((alcn)localObject1).d.getBgTypeArray();
            SharedPreferences localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("ProfileCardTips" + localQQAppInterface.getCurrentAccountUin(), 0);
            String str = ((alcn)localObject1).e.uin;
            if ((aqep.S((ArrayList)localObject2)) || (((alcn)localObject1).d.lCurrentBgId == 160L))
            {
              localProfileHeaderView.dtk &= 0xFFFFFFFD;
              localProfileHeaderView.dA.set(true);
              if (QLog.isColorLevel()) {
                QLog.d(ProfileHeaderView.TAG, 2, "updateSetCardBar isSpecilaBg");
              }
              if (!localProfileHeaderView.dA.get()) {
                break;
              }
              ProfileHeaderView.a(localProfileHeaderView);
              return;
            }
            if ((str == null) || (l2 <= 0L) || (l1 <= 0L) || (i != 0)) {
              break label450;
            }
            localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
            localObject2 = ((acff)localQQAppInterface.getManager(51)).b(localQQAppInterface.getCurrentAccountUin());
            if (localObject2 != null)
            {
              l1 = ((Card)localObject2).lCurrentBgId;
              localObject2 = localSharedPreferences.getString(String.valueOf(l2), "");
              if (QLog.isColorLevel()) {
                QLog.d(ProfileHeaderView.TAG, 2, "updateSetCardBar today=" + (String)localObject1 + ",userLastAccessDay=" + (String)localObject2 + ",friendBackgroundId=" + l2 + ",myBackgroundId=" + l1);
              }
              if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(localObject2)) || (l1 == l2)) {
                break label438;
              }
              localSharedPreferences.edit().putString(String.valueOf(l2), (String)localObject1).commit();
              localProfileHeaderView.dtk |= 0x2;
              localQQAppInterface.runOnUiThread(new ProfileHeaderView.UpdateProfileSetCardTask.1(this, localProfileHeaderView));
              continue;
            }
            l1 = 0L;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
          continue;
          label438:
          localException.dA.set(true);
          continue;
          label450:
          localException.dA.set(true);
        }
      }
    }
  }
  
  static class a
    implements acci
  {
    private WeakReference<ProfileHeaderView> mViewRef;
    
    public a(ProfileHeaderView paramProfileHeaderView)
    {
      this.mViewRef = new WeakReference(paramProfileHeaderView);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      if ((paramBoolean) && (paramInt == 66) && ((paramObject instanceof Set)))
      {
        paramObject = (Set)paramObject;
        ProfileHeaderView localProfileHeaderView = (ProfileHeaderView)this.mViewRef.get();
        if (localProfileHeaderView == null) {
          break label80;
        }
        if (paramObject.contains(localProfileHeaderView.a.e.uin))
        {
          localProfileHeaderView.c(localProfileHeaderView.a, false);
          localProfileHeaderView.app.removeObserver(this);
        }
      }
      label80:
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(ProfileHeaderView.TAG, 2, "Can't get reference to ProfileHeadView.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */