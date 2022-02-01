package com.tencent.mobileqq.extendfriend.fragment;

import acff;
import acfp;
import afsg;
import afsi;
import afsi.a;
import afsr;
import afte;
import afth.a;
import aftm;
import afua;
import afud;
import afue;
import afuf;
import afwd;
import afwe;
import afwf;
import afwg;
import afxv;
import afxx;
import afyg;
import afyg.a;
import afyk;
import ahyo;
import ahyq;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.widget.ImageView;
import anlm;
import anot;
import aqdf;
import aqdf.a;
import aqhu;
import aqiw;
import auru;
import ausj;
import awmc;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import wja;

public class ExtendFriendBaseFragment
  extends afwd
  implements afte, afth.a, afwg, afyg.a, Handler.Callback, aqdf.a
{
  private static boolean caP;
  public static final Object dD = new Object();
  protected static final Object dE = new Object();
  public long XN;
  protected long XO = 2L;
  protected long XP = -1L;
  protected afsi a;
  public afwe a;
  public afwf a;
  protected afyg a;
  protected ahyq a;
  protected RecyclerView.AdapterDataObserver a;
  public aqdf a;
  protected PullToRefreshRecyclerView a;
  protected NearbyZanAnimLayout a;
  public ausj ae;
  protected Dialog ao;
  public afsg b;
  protected String bFE;
  protected String bFF;
  public int bMU;
  protected CardHandler c;
  protected int cUA;
  private int cUB;
  protected int cUv = -1;
  protected int cUw = -1;
  public int cUx = -1;
  protected int cUy;
  protected int cUz;
  public boolean caM;
  public boolean caN;
  protected boolean caQ;
  private afsr d;
  protected QQToast d;
  protected auru f;
  private ConcurrentHashMap<String, a> fm = new ConcurrentHashMap();
  private Runnable gu = new ExtendFriendBaseFragment.3(this);
  protected long iu;
  public Map<ImageView, String> kq;
  protected Map<String, Integer> kr = new HashMap();
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  protected GdtAppReceiver mGdtAppReceiver;
  public LinearLayoutManager mLayoutManager;
  public RecyclerView mRecyclerView;
  public boolean mScrolling;
  public String mSearchKey = afsi.DEFAULT_TAG;
  
  public ExtendFriendBaseFragment()
  {
    this.jdField_d_of_type_Afsr = new afuf(this);
  }
  
  private ArrayList<a> cY()
  {
    localArrayList = new ArrayList();
    try
    {
      int i = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
      int j = this.mLayoutManager.findLastCompletelyVisibleItemPosition();
      if ((i >= 0) && (i < this.mLayoutManager.getItemCount()) && (j >= 0) && (j < this.mLayoutManager.getItemCount()) && (i <= j)) {
        while (i <= j)
        {
          if (this.jdField_a_of_type_Afwe.getItemViewType(i) == 0)
          {
            afua localafua = this.jdField_a_of_type_Afwe.a(i);
            if (localafua != null)
            {
              a locala = new a(null);
              locala.bFG = this.mSearchKey;
              locala.feedPosition = i;
              locala.b = localafua;
              localArrayList.add(locala);
            }
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("ExtendFriendBaseFragment", 1, "findCurrentVisibleItems fail.", localThrowable);
    }
  }
  
  protected int DF()
  {
    return 0;
  }
  
  protected int DG()
  {
    return 0;
  }
  
  public int DH()
  {
    return this.cUv;
  }
  
  public void Iu(boolean paramBoolean) {}
  
  public void Iv(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Afwe == null) || (this.jdField_a_of_type_Afwe.af() <= 0) || (this.mActivity == null) || (this.mLayoutManager == null) || (this.mApp == null)) {
      return;
    }
    this.f.removeCallbacks(this.gu);
    if (paramBoolean)
    {
      this.f.postDelayed(this.gu, 500L);
      return;
    }
    this.gu.run();
  }
  
  public void Iw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.6(this));
    }
  }
  
  public void Nh(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedVoiceClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.jdField_a_of_type_Afwe != null)
    {
      afua localafua = this.jdField_a_of_type_Afwe.a(paramInt);
      if (localafua != null)
      {
        int i = localafua.mVoiceDuration / 10;
        anot.c(this.mApp, "dc00898", "", localafua.mUin, "0X80092CF", "0X80092CF", i + 1, 0, "", String.valueOf(paramInt + 1), afxv.kK(localafua.mStrRecomTrace), this.mSearchKey);
        anot.c(this.mApp, "dc00898", "", localafua.mUin, "0X8009C70", "0X8009C70", 0, 0, "", String.valueOf(paramInt + 1), afxv.kK(localafua.mStrRecomTrace), this.mSearchKey);
      }
    }
    if (paramInt != this.cUv) {
      dck();
    }
    Nn(paramInt);
  }
  
  public void Ni(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedLikeClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    afua localafua = this.jdField_a_of_type_Afwe.a(paramInt);
    if (localafua != null)
    {
      if (localafua.mAvailLikeCount <= 0) {
        break label304;
      }
      if (aqiw.isNetSupport(this.mActivity))
      {
        localafua.mLiked = true;
        localafua.mAvailLikeCount -= 1;
        anot.c(this.mApp, "dc00898", "", localafua.mUin, "0X80092CD", "0X80092CD", 0, 0, "", String.valueOf(paramInt + 1), afxv.kK(localafua.mStrRecomTrace), this.mSearchKey);
        anot.b(this.mApp, "CliOper", "", "", "P_prof", "Prof_good", 9, 1, 0, Integer.toString(53), "1", this.mApp.getCurrentAccountUin(), localafua.mUin);
      }
    }
    else
    {
      synchronized (dE)
      {
        localObject3 = (Integer)this.kr.get(localafua.mUin);
        Object localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = Integer.valueOf(0);
        }
        this.kr.put(localafua.mUin, Integer.valueOf(((Integer)localObject1).intValue() + 1));
        if (!this.f.hasMessages(10))
        {
          localObject1 = Message.obtain();
          ((Message)localObject1).what = 10;
          this.f.sendMessageDelayed((Message)localObject1, 1000L);
        }
        this.jdField_a_of_type_Afwe.notifyItemChanged(paramInt);
        No(paramInt);
        return;
      }
    }
    ci(getString(2131721956), 1);
    return;
    label304:
    Object localObject3 = acfp.m(2131705995);
    String str;
    if ((localafua.mGender == 1) || (localafua.mGender == 2)) {
      if (localafua.mGender == 2) {
        str = acfp.m(2131705992);
      }
    }
    for (;;)
    {
      ci(String.format((String)localObject3, new Object[] { str, Integer.valueOf(DG()) }), 0);
      return;
      str = acfp.m(2131705974);
      continue;
      str = acfp.m(2131705999);
    }
  }
  
  public void Nj(int paramInt)
  {
    if (this.mActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "onFeedSendMsgClick() mActivity is null just return");
      }
    }
    afua localafua;
    do
    {
      return;
      localafua = this.jdField_a_of_type_Afwe.a(paramInt);
    } while (localafua == null);
    afxx.a(this.mApp).a(this.mApp, localafua.mUin, localafua.mNickName, localafua.voiceCode, 2, new afud(this));
    afxv.a().c(3, localafua.mUin, "", String.valueOf(paramInt + 1), afxv.kK(localafua.mStrRecomTrace), this.mSearchKey);
  }
  
  public void Nk(int paramInt)
  {
    afua localafua = this.jdField_a_of_type_Afwe.a(paramInt);
    if ((this.mActivity == null) || (localafua == null)) {
      return;
    }
    if (!caP)
    {
      if (((acff)this.mApp.getManager(51)).b(this.mApp.getCurrentAccountUin()).declaration == null) {
        ((afsg)this.mApp.getBusinessHandler(127)).k(this.mApp.getCurrentAccountUin(), false);
      }
      caP = false;
    }
    RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.findViewHolderForPosition(paramInt);
    boolean bool1;
    boolean bool2;
    if ((localViewHolder != null) && ((localViewHolder instanceof aftm)))
    {
      bool1 = ((aftm)localViewHolder).akl();
      bool2 = ((aftm)localViewHolder).pE();
    }
    for (;;)
    {
      this.ae = ausj.b(this.mActivity);
      this.ae.addButton(2131689651, 3);
      if (!anlm.ayn())
      {
        if (bool1) {
          this.ae.addButton(2131719584);
        }
        if (bool2) {
          this.ae.addButton(2131719585);
        }
        if ((!bool2) && (!bool1)) {
          this.ae.addButton(2131719586);
        }
      }
      this.ae.addCancelButton(2131721058);
      this.ae.a(new afue(this, localafua, bool1, bool2, localViewHolder));
      if (!this.mActivity.isFinishing()) {
        this.ae.show();
      }
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_click", "", 0, "", "");
      return;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public void Nl(int paramInt)
  {
    if (this.jdField_a_of_type_Afwe != null)
    {
      this.jdField_a_of_type_Afwe.remove(paramInt);
      this.jdField_a_of_type_Afwe.notifyDataSetChanged();
      QLog.i("ExtendFriendBaseFragment", 1, "@gdtadv onClickFeedBackHideAdv");
    }
  }
  
  public void Nm(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.5(this));
  }
  
  protected void Nn(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("toggleVoice position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject = this.mRecyclerView.findViewHolderForPosition(paramInt);
    if ((localObject != null) && ((localObject instanceof aftm)))
    {
      localObject = (aftm)localObject;
      if (((aftm)localObject).b.isAnimating())
      {
        ((aftm)localObject).b.stopAnimation();
        if (this.jdField_a_of_type_Afyg != null) {
          this.jdField_a_of_type_Afyg.stop();
        }
        this.cUv = -1;
      }
    }
    else
    {
      return;
    }
    ((aftm)localObject).b.startAnimation();
    if (this.jdField_a_of_type_Afwe != null)
    {
      localObject = this.jdField_a_of_type_Afwe.a(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((afua)localObject).mVoiceUrl)) && (this.jdField_a_of_type_Afyg != null)) {
        this.jdField_a_of_type_Afyg.play(((afua)localObject).mVoiceUrl);
      }
    }
    this.cUv = paramInt;
  }
  
  public void No(int paramInt)
  {
    aftm localaftm = (aftm)this.mRecyclerView.findViewHolderForPosition(paramInt);
    if (localaftm == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localaftm.zd.getLocationInWindow(arrayOfInt);
    NearbyZanAnimLayout localNearbyZanAnimLayout = this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
    Bitmap localBitmap = this.jdField_a_of_type_Ahyq.a(3, this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.b).ax();
    float f1 = arrayOfInt[0] + localaftm.zd.getPaddingLeft() + this.cUz;
    paramInt = arrayOfInt[1];
    int i = this.bMU;
    localNearbyZanAnimLayout.a(localBitmap, f1, localaftm.zd.getPaddingTop() + (paramInt - i) + this.cUA);
  }
  
  public boolean PA()
  {
    if (afsi.me(this.mApp.getCurrentAccountUin()))
    {
      if (this.mActivity != null)
      {
        if (this.ao == null) {
          this.ao = afyk.b(this.mActivity);
        }
        if ((!this.ao.isShowing()) && (!this.mActivity.isFinishing())) {
          this.ao.show();
        }
      }
      return true;
    }
    return false;
  }
  
  public Drawable a(String paramString1, String paramString2, ImageView paramImageView)
  {
    Bitmap localBitmap = null;
    synchronized (dD)
    {
      if (this.jdField_a_of_type_Aqdf != null) {
        localBitmap = this.jdField_a_of_type_Aqdf.b(1, paramString1);
      }
      if (localBitmap == null) {
        if (!this.mScrolling)
        {
          if (paramImageView != null) {
            paramImageView.setTag(2131379178, paramString1);
          }
          if ((this.kq != null) && (this.jdField_a_of_type_Aqdf != null))
          {
            this.jdField_a_of_type_Aqdf.i(paramString1, 1, true);
            if (QLog.isColorLevel()) {
              QLog.d("ExtendFriendBaseFragment", 2, String.format("requestDecodeFace uin=%s nick=%s", new Object[] { paramString1, paramString2 }));
            }
          }
          if ((this.kq != null) && (paramImageView != null)) {
            this.kq.put(paramImageView, paramString1);
          }
        }
      }
      while ((this.kq == null) || (paramImageView == null))
      {
        paramString1 = localBitmap;
        if (localBitmap == null) {
          paramString1 = aqhu.G();
        }
        return new BitmapDrawable(paramString1);
      }
      this.kq.remove(paramImageView);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder)
  {
    int j = 0;
    Object localObject = ((acff)this.mApp.getManager(51)).c(this.mApp.getCurrentAccountUin());
    Intent localIntent = new Intent();
    localObject = new ExtendFriendProfileEditFragment.ExtendFriendInfo((Card)localObject);
    if ((paramViewHolder != null) && ((paramViewHolder instanceof aftm))) {
      j = ((aftm)paramViewHolder).getFontId();
    }
    for (int i = ((aftm)paramViewHolder).DE();; i = 0)
    {
      if (paramBoolean1)
      {
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cUM = j;
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cbi = true;
      }
      if (paramBoolean2)
      {
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cUN = i;
        ((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).cbj = true;
      }
      localIntent.putExtra("key_extend_friend_info", (Parcelable)localObject);
      PublicFragmentActivity.startForResult(this.mActivity, localIntent, ExtendFriendEditFragment.class, 4097);
      return;
    }
  }
  
  protected void bOS()
  {
    synchronized (dE)
    {
      if (this.c != null)
      {
        long l1 = Long.valueOf(this.mActivity.getCurrentAccountUin()).longValue();
        Iterator localIterator = this.kr.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int i = ((Integer)this.kr.get(str)).intValue();
          if (i > 0)
          {
            long l2 = Long.valueOf(str).longValue();
            this.c.a(l1, l2, null, 53, i, 0);
          }
        }
      }
    }
    this.kr.clear();
  }
  
  protected void bV(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("syncSwitchStatus syncProfileComplete=%s syncShowCard=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    Card localCard;
    if ((paramBoolean1) || (paramBoolean2))
    {
      localCard = ((acff)this.mApp.getManager(51)).b(this.mApp.getCurrentUin());
      if (localCard != null) {
        if (paramBoolean1) {
          if (TextUtils.isEmpty(localCard.declaration)) {
            break label105;
          }
        }
      }
    }
    label105:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.caM = paramBoolean1;
      if (paramBoolean2) {
        this.caN = localCard.isShowCard;
      }
      return;
    }
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("playerCompletion path=%s", new Object[] { paramString }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendBaseFragment.4(this));
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  protected void ci(String paramString, int paramInt)
  {
    if (this.mActivity != null)
    {
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast == null) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast = new QQToast(this.mActivity);
      }
      if ((!this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast.isShowing()) || (!TextUtils.equals(this.bFE, paramString)) || (this.cUy != paramInt))
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast.setToastIcon(QQToast.getIconRes(paramInt));
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast.setType(paramInt);
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast.setToastMsg(paramString);
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast.setDuration(0);
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQToast.show(this.mActivity.getTitleBarHeight());
        this.bFE = paramString;
        this.cUy = paramInt;
      }
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public void dca() {}
  
  public void dcd()
  {
    if ((this.mLayoutManager != null) && (this.jdField_a_of_type_Afwe != null))
    {
      int i = this.mLayoutManager.findFirstVisibleItemPosition();
      int j = this.mLayoutManager.findLastVisibleItemPosition();
      while (i <= j)
      {
        Object localObject1 = this.jdField_a_of_type_Afwe.a(i);
        Object localObject2 = this.mRecyclerView.findViewHolderForPosition(i);
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof aftm)))
        {
          localObject2 = (aftm)localObject2;
          localObject1 = a(((afua)localObject1).mUin, ((afua)localObject1).mNickName, ((aftm)localObject2).zb);
          ((aftm)localObject2).zb.setImageDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  public void dce()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    Iu(true);
    this.jdField_a_of_type_Afwe.bx(0, true);
  }
  
  public void dcf() {}
  
  protected void dcg()
  {
    if ((this.caQ) && (!TextUtils.isEmpty(this.bFF)) && (this.XP > 0L))
    {
      long l = System.currentTimeMillis() - this.XP;
      if ((l > 0L) && (l < 3600000L)) {
        anot.a(this.mApp, "dc00898", "", this.bFF, "0X8009C71", "0X8009C71", 0, 0, String.valueOf(l), "", "", this.mSearchKey);
      }
      this.caQ = false;
      this.bFF = null;
      this.XP = -1L;
    }
  }
  
  public void dch()
  {
    if ((this.fm == null) || (this.fm.isEmpty()) || (this.mActivity == null) || (this.mLayoutManager == null) || (this.mApp == null) || (this.mActivity.isFinishing())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.fm.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        localObject = (a)((Map.Entry)localObject).getValue();
        if (System.currentTimeMillis() - ((a)localObject).exposureTime >= this.XO)
        {
          this.fm.remove(str1);
          String str2 = afxv.a(((a)localObject).b);
          str2 = String.format("%s_%s", new Object[] { ((a)localObject).bFG, str2 });
          anot.a(this.mApp, "dc00898", "", str1, "0X8009C6E", "0X8009C6E", 1, 0, "", String.valueOf(((a)localObject).feedPosition + 1), afxv.kK(((a)localObject).b.mStrRecomTrace), str2);
        }
      }
    }
  }
  
  protected void dci()
  {
    this.fm.clear();
  }
  
  public void dcj()
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void dck()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("stopLastVoice mLastPlayVoicePos=%s", new Object[] { Integer.valueOf(this.cUv) }));
    }
    if (this.cUv >= 0)
    {
      if (this.jdField_a_of_type_Afyg != null) {
        this.jdField_a_of_type_Afyg.stop();
      }
      Object localObject = this.mRecyclerView.findViewHolderForPosition(this.cUv);
      if ((localObject != null) && ((localObject instanceof aftm)))
      {
        localObject = (aftm)localObject;
        if (((aftm)localObject).b.isAnimating()) {
          ((aftm)localObject).b.stopAnimation();
        }
      }
      this.cUv = -1;
    }
  }
  
  public void dcl()
  {
    this.cUB = ((afsg)this.mApp.getBusinessHandler(127)).k(this.mApp.getCurrentUin(), true);
  }
  
  protected void dcm()
  {
    if (this.cUx >= 0)
    {
      afua localafua = this.jdField_a_of_type_Afwe.a(this.cUx);
      if (localafua != null)
      {
        Card localCard = ((acff)this.mApp.getManager(51)).b(localafua.mUin);
        if (localCard != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("syncLikeStatus bVoted=%s bAvailVoteCnt=%s mAvailLikeCount=%s", new Object[] { Byte.valueOf(localCard.bVoted), Short.valueOf(localCard.bAvailVoteCnt), Integer.valueOf(localafua.mAvailLikeCount) }));
          }
          if ((localCard.bVoted > 0) && (localCard.bAvailVoteCnt < localafua.mAvailLikeCount))
          {
            localafua.mLiked = true;
            localafua.mAvailLikeCount = localCard.bAvailVoteCnt;
            this.jdField_a_of_type_Afwe.notifyItemChanged(this.cUx);
          }
        }
      }
    }
  }
  
  public long fC()
  {
    return this.iu;
  }
  
  public void hT(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onFeedItemClick position=%s", new Object[] { Integer.valueOf(paramInt1) }));
    }
    afua localafua = this.jdField_a_of_type_Afwe.a(paramInt1);
    if (localafua != null)
    {
      afxv.ae(this.mApp, localafua.mStrRecomTrace);
      anot.c(this.mApp, "dc00898", "", localafua.mUin, "0X80092D0", "0X80092D0", 0, 0, "", String.valueOf(paramInt1 + 1), afxv.kK(localafua.mStrRecomTrace), this.mSearchKey);
      anot.c(this.mApp, "dc00898", "", localafua.mUin, "0X8009C6F", "0X8009C6F", paramInt2, 0, "", String.valueOf(paramInt1 + 1), afxv.kK(localafua.mStrRecomTrace), this.mSearchKey);
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(localafua.mUin, 96);
      localAllInOne.nickname = localafua.mNickName;
      localAllInOne.ch = localafua.voiceCode;
      localAllInOne.subSourceId = 1;
      ProfileActivity.b(getActivity(), localAllInOne, DF());
      this.cUx = paramInt1;
      this.caQ = true;
      this.bFF = localafua.mUin;
      this.XP = System.currentTimeMillis();
      afxv.a(2, paramInt1, localafua.mStrRecomTrace, this.mSearchKey, localafua);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      bOS();
    }
  }
  
  public void jf(long paramLong)
  {
    this.iu = paramLong;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
    this.mApp = this.mActivity.app;
    this.b = ((afsg)this.mApp.getBusinessHandler(127));
    this.c = ((CardHandler)this.mApp.getBusinessHandler(2));
    this.jdField_a_of_type_Afsi = ((afsi)this.mApp.getManager(264));
    this.jdField_a_of_type_Aqdf = new aqdf(this.mApp);
    this.jdField_a_of_type_Aqdf.a(this);
    this.kq = new HashMap();
    this.jdField_a_of_type_Ahyq = new ahyq(this.mActivity);
    this.cUz = wja.dp2px(17.5F, getResources());
    this.cUA = wja.dp2px(7.0F, getResources());
    this.jdField_a_of_type_Afyg = new afyg(this, this.mActivity);
    this.f = new auru(ThreadManager.getSubThreadLooper(), this);
    paramBundle = this.jdField_a_of_type_Afsi.a();
    if (paramBundle != null) {
      this.XO = paramBundle.cUd;
    }
    this.mApp.addObserver(this.jdField_d_of_type_Afsr);
    if (this.mGdtAppReceiver == null) {
      this.mGdtAppReceiver = new GdtAppReceiver();
    }
    this.mGdtAppReceiver.register(this.mActivity);
    awmc.a().eEr();
    QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver register");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDecodeTaskCompleted uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
    }
    for (;;)
    {
      synchronized (dD)
      {
        Iterator localIterator = this.kq.entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          ImageView localImageView = (ImageView)((Map.Entry)localObject1).getKey();
          localObject1 = (String)((Map.Entry)localObject1).getValue();
          if ((localObject1 == null) || (!((String)localObject1).equals(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendBaseFragment", 2, String.format("responseDecodeFace hit cache uin=%s avatar=%s", new Object[] { paramString, paramBitmap }));
          }
          localObject1 = localImageView.getTag(2131379178);
          if ((localObject1 == null) || (!(localObject1 instanceof String))) {
            break label219;
          }
          localObject1 = (String)localObject1;
          if (TextUtils.equals(paramString, (CharSequence)localObject1)) {
            localImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
          }
          localIterator.remove();
        }
      }
      return;
      label219:
      Object localObject1 = null;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dcg();
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.a(null);
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
    if (this.kq != null)
    {
      this.kq.clear();
      this.kq = null;
    }
    this.f.removeCallbacksAndMessages(null);
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_d_of_type_Afsr);
    }
    if (this.mGdtAppReceiver != null)
    {
      this.mGdtAppReceiver.unregister(this.mActivity);
      QLog.d("ExtendFriendBaseFragment", 2, "mGdtAppReceiver unregister");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    dck();
    dch();
    dci();
  }
  
  public void onResume()
  {
    super.onResume();
    afxv.ae(this.mApp, "");
    afxv.ddN();
    dcg();
    Iv(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.f.hasMessages(10))
    {
      this.f.removeMessages(10);
      bOS();
    }
  }
  
  public void u(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBaseFragment", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
  }
  
  static class a
  {
    public afua b;
    public String bFG;
    public long exposureTime;
    public int feedPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment
 * JD-Core Version:    0.7.0.1
 */