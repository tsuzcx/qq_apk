package com.tencent.mobileqq.extendfriend.fragment;

import acfd;
import aepf.a;
import afsg;
import afsi;
import afsr;
import aftf;
import aftg;
import aftl;
import aftm;
import aftq;
import afua;
import afuc;
import afuc.a;
import afvl;
import afvw;
import afvx;
import afvy;
import afvz;
import afwa;
import afwb;
import afwc;
import afwe;
import afwf;
import afxf;
import afxn;
import afxv;
import afzj;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import anot;
import aqiw;
import aqmu;
import auru;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.c;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.a;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import wja;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements PullToRefreshBase.c<RecyclerView>, ExtendFriendCampusVerifyTipsView.a
{
  public long XR = -1L;
  private acfd jdField_a_of_type_Acfd = new afvx(this);
  private aftf jdField_a_of_type_Aftf = new aftf();
  private aftq jdField_a_of_type_Aftq = new aftq();
  private afvl jdField_a_of_type_Afvl;
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private boolean bZx;
  private afsr c = new afvw(this);
  private int cUO = 1;
  public int cUP;
  public int cUQ = 480;
  private int cUh;
  private int cUt;
  private int cUu = -1;
  private boolean caO;
  private boolean cbn;
  private boolean cbo;
  public boolean cbp;
  private boolean cbq;
  private boolean cbr;
  private byte[] dF;
  private boolean mLoading;
  private long mUpdateTime;
  private auru n;
  
  private void Nu(int paramInt)
  {
    int i = 1;
    afxf localafxf = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
    if (paramInt == 1) {
      if (i == 0) {
        break label57;
      }
    }
    label57:
    for (i = 2131701186;; i = 2131701204)
    {
      localafxf.setRefreshingLabel(getResources().getString(i));
      this.mRecyclerView.setTag(2131376994, Integer.valueOf(paramInt));
      return;
      i = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<afua> paramList, aftq paramaftq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Afwe == null)) {
      return;
    }
    paramString = this.mRecyclerView.getTag(2131376994);
    if ((paramString != null) && ((paramString instanceof Integer))) {}
    for (int i = ((Integer)paramString).intValue();; i = 0)
    {
      paramString = this.jdField_a_of_type_Afwe;
      int j;
      if (paramBoolean1)
      {
        j = 0;
        paramString.Nw(j);
        if ((paramBoolean1) && (paramList != null)) {
          break label292;
        }
        if (this.bZx) {
          this.jdField_a_of_type_Afwe.bx(1, true);
        }
        if (this.cUO != 0) {
          break label278;
        }
        paramInt = 2131696743;
        label131:
        if (i == 1)
        {
          if (this.cUO != 0) {
            break label285;
          }
          paramInt = 2131696743;
        }
        label148:
        ci(getString(paramInt), 1);
        label159:
        if (this.jdField_a_of_type_Afwe.getItemCount() == 0) {
          this.jdField_a_of_type_Afwe.ID(true);
        }
        this.jdField_a_of_type_Afwe.notifyDataSetChanged();
        if ((!this.bZx) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null))
        {
          if (!paramBoolean1) {
            break label627;
          }
          paramInt = 2131701205;
          label206:
          if (i != 1) {
            break label641;
          }
          if (!paramBoolean1) {
            break label634;
          }
          paramInt = 2131701185;
        }
      }
      label641:
      for (;;)
      {
        paramString = getResources().getString(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.ddB();
        Nu(0);
        this.mLoading = false;
        dch();
        Iv(true);
        return;
        j = 1;
        break;
        label278:
        paramInt = 2131701203;
        break label131;
        label285:
        paramInt = 2131701184;
        break label148;
        label292:
        this.caO = paramBoolean2;
        this.dF = paramArrayOfByte;
        this.caM = paramBoolean3;
        this.caN = paramBoolean4;
        this.cUt = paramInt;
        this.jdField_a_of_type_Aftq.cUo = paramaftq.cUo;
        this.jdField_a_of_type_Aftq.cUp = paramaftq.cUp;
        this.jdField_a_of_type_Aftq.cUq = paramaftq.cUq;
        this.jdField_a_of_type_Aftq.list.clear();
        this.jdField_a_of_type_Aftq.list.addAll(paramaftq.list);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.kC(this.jdField_a_of_type_Aftq.list);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.caO), this.dF, Boolean.valueOf(this.caM), Boolean.valueOf(this.caN), Integer.valueOf(this.cUt), Integer.valueOf(paramaftq.cUo), Integer.valueOf(paramaftq.cUp) }));
        }
        if (!this.bZx)
        {
          this.jdField_a_of_type_Afwe.clear();
          ddb();
        }
        if (this.caO) {
          this.jdField_a_of_type_Afwe.bx(2, false);
        }
        this.jdField_a_of_type_Afwe.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null)
          {
            this.mUpdateTime = System.currentTimeMillis();
            this.cUu = Calendar.getInstance().get(6);
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131720481), aqmu.a(this.mUpdateTime, true, "yyyy-MM-dd") }));
          }
        }
        ddc();
        break label159;
        label627:
        paramInt = 2131701203;
        break label206;
        label634:
        paramInt = 2131701184;
      }
    }
  }
  
  private boolean akt()
  {
    if (this.cUu < 0) {}
    while (Calendar.getInstance().get(6) == this.cUu) {
      return false;
    }
    return true;
  }
  
  private boolean b(boolean paramBoolean, String paramString)
  {
    boolean bool2 = false;
    List localList = this.jdField_a_of_type_Afsi.Y(2);
    boolean bool1 = bool2;
    int i;
    int j;
    Object localObject;
    if (afsi.a != null)
    {
      bool1 = bool2;
      if (afsi.a.Ay != null)
      {
        bool1 = bool2;
        if (afsi.a.Ay.size() > 0)
        {
          if (!paramBoolean) {
            break label567;
          }
          paramString = afsi.a.a();
          if ((paramString == null) || (paramString.mList.size() <= 0) || (!localList.contains(paramString.mSearchKey))) {
            break label561;
          }
          bool1 = true;
          if (bool1)
          {
            this.caM = afsi.a.caM;
            this.caN = afsi.a.caN;
            this.cUt = afsi.a.cUt;
            this.caO = paramString.caO;
            this.dF = paramString.dF;
            this.mUpdateTime = paramString.mUpdateTime;
            this.cUu = paramString.cUu;
            this.mSearchKey = paramString.mSearchKey;
            i = paramString.mCurPos;
            j = paramString.mOffset;
            if (paramString.mList.size() > 0)
            {
              localObject = (afua)paramString.mList.get(0);
              if (!(localObject instanceof aftq)) {
                break label603;
              }
              localObject = (aftq)localObject;
              if (this.jdField_a_of_type_Aftq != localObject)
              {
                this.jdField_a_of_type_Aftq.cUo = ((aftq)localObject).cUo;
                this.jdField_a_of_type_Aftq.cUp = ((aftq)localObject).cUp;
                this.jdField_a_of_type_Aftq.cUq = ((aftq)localObject).cUq;
                this.jdField_a_of_type_Aftq.list.clear();
                this.jdField_a_of_type_Aftq.list.addAll(((aftq)localObject).list);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.kC(this.jdField_a_of_type_Aftq.list);
              }
            }
            label315:
            if (paramBoolean)
            {
              int k = localList.indexOf(this.mSearchKey);
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, k);
            }
            if (this.jdField_a_of_type_Afwe != null)
            {
              if (!this.caO) {
                break label621;
              }
              this.jdField_a_of_type_Afwe.bx(2, false);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Afwe.clear();
      this.jdField_a_of_type_Afwe.addAll(paramString.mList);
      ddb();
      this.jdField_a_of_type_Afwe.notifyDataSetChanged();
      if (Math.abs(System.currentTimeMillis() - this.mUpdateTime) < 60000L) {
        this.mRecyclerView.postDelayed(new ExtendFriendSquareFragment.9(this, i, j), 100L);
      }
      dch();
      Iv(true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null) {
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131720481), aqmu.a(this.mUpdateTime, true, "yyyy-MM-dd") }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(this.mUpdateTime), this.mSearchKey }));
      }
      return bool1;
      label561:
      bool1 = false;
      break;
      label567:
      paramString = afsi.a.a(paramString);
      if ((paramString != null) && (paramString.mList.size() > 0)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label603:
      if (!(localObject instanceof aftf)) {
        break label315;
      }
      localObject = (aftf)localObject;
      break label315;
      label621:
      this.jdField_a_of_type_Afwe.bx(0, false);
    }
  }
  
  private void brD()
  {
    if ((!isAdded()) || (this.jdField_a_of_type_Afwe == null)) {}
    do
    {
      do
      {
        return;
      } while (this.cbo);
      if (!aqiw.isNetworkAvailable(this.mActivity)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null);
    Nu(1);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.isRefreshing())
    {
      Iu(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
    this.jdField_a_of_type_Afwe.bx(0, true);
    return;
    this.cUO = 0;
    dcY();
  }
  
  private void dcY()
  {
    a(false, this.mSearchKey, false, null, false, false, 0, null, null);
  }
  
  private void dcq()
  {
    List localList = null;
    if (this.jdField_a_of_type_Afsi != null) {
      localList = this.jdField_a_of_type_Afsi.Y(2);
    }
    if (localList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.n.post(new ExtendFriendSquareFragment.10(this));
    }
  }
  
  private void dda()
  {
    this.jdField_a_of_type_Aftf.wt = new ArrayList(5);
    Object localObject = new aftg();
    ((aftg)localObject).type = 0;
    ((aftg)localObject).title = getResources().getString(2131701147);
    ((aftg)localObject).cUj = -20771;
    ((aftg)localObject).cUk = -31578;
    ((aftg)localObject).wu = new ArrayList(10);
    this.jdField_a_of_type_Aftf.wt.add(localObject);
    localObject = ((afsi)this.mApp.getManager(264)).cX();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        aepf.a locala = (aepf.a)((Iterator)localObject).next();
        aftg localaftg = new aftg();
        localaftg.title = locala.title;
        localaftg.appId = locala.id;
        localaftg.subTitle = locala.subTitle;
        if ("0".equals(locala.type)) {
          localaftg.type = 0;
        }
        for (;;)
        {
          localaftg.jumpUrl = locala.bAt;
          localaftg.iconUrl = locala.iconUrl;
          localaftg.bv = locala.bv;
          try
          {
            if (locala.bAr != null) {
              localaftg.cUj = Color.parseColor(locala.bAr);
            }
            if (locala.bAs != null) {
              localaftg.cUk = Color.parseColor(locala.bAs);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, "parse banner color " + localException);
              }
            }
          }
          this.jdField_a_of_type_Aftf.wt.add(localaftg);
          break;
          if ("1".equals(locala.type)) {
            localaftg.type = 1;
          } else if ("2".equals(locala.type)) {
            localaftg.type = 2;
          } else if ("3".equals(locala.type)) {
            localaftg.type = 3;
          } else {
            localaftg.type = -1;
          }
        }
      }
    }
  }
  
  private void ddb()
  {
    afsi localafsi;
    boolean bool;
    Object localObject1;
    int j;
    Object localObject2;
    aftg localaftg;
    if ((this.jdField_a_of_type_Afwe != null) && (this.mApp != null) && (afsi.DEFAULT_TAG.equals(this.mSearchKey)))
    {
      if (this.cUR != 0) {
        break label639;
      }
      localafsi = (afsi)this.mApp.getManager(264);
      bool = localafsi.akb();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner limitChatSwitch=%s mTabPos=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.cUR) }));
      }
      if (!bool) {
        break label677;
      }
      this.cbq = true;
      localObject1 = this.jdField_a_of_type_Afwe.a(0);
      if (!(localObject1 instanceof aftf)) {
        break label526;
      }
      localObject1 = (aftf)localObject1;
      j = 0;
      i = j;
      if (((aftf)localObject1).wt != null)
      {
        localObject2 = ((aftf)localObject1).wt.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localaftg = (aftg)((Iterator)localObject2).next();
            if (localaftg.type == 0)
            {
              if ((this.jdField_a_of_type_Aftq.list != null) && (!this.jdField_a_of_type_Aftq.list.isEmpty())) {
                localaftg.wu = new ArrayList(this.jdField_a_of_type_Aftq.list);
              }
              localObject2 = localaftg;
              if (this.jdField_a_of_type_Aftq.cUq > 0)
              {
                if (((aftf)localObject1).wt.size() > 1)
                {
                  localaftg.subTitle = String.format(getResources().getString(2131701144), new Object[] { Integer.valueOf(this.jdField_a_of_type_Aftq.cUq) });
                  localObject2 = localaftg;
                }
              }
              else
              {
                label292:
                i = j;
                if (localObject2 != null) {
                  this.jdField_a_of_type_Afwe.b((aftg)localObject2);
                }
              }
            }
          }
        }
      }
    }
    label526:
    label677:
    for (int i = j;; i = 0)
    {
      bool = localafsi.aka();
      int k = localafsi.DA();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner needShowVerifyTips=%s verifyStatus=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(k) }));
      }
      if (this.cbq)
      {
        j = 1;
        label369:
        localObject1 = this.jdField_a_of_type_Afwe.a(j);
        bool = ExtendFriendCampusVerifyTipsView.e(bool, k);
        localObject2 = ExtendFriendCampusVerifyTipsView.a(k);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner showVerifyTips=%s tipsType=%s", new Object[] { Boolean.valueOf(bool), localObject2 }));
        }
        if (!bool) {
          break label618;
        }
        if (!(localObject1 instanceof aftl)) {
          break label596;
        }
        localObject1 = (aftl)localObject1;
        label448:
        ((aftl)localObject1).a = ExtendFriendCampusVerifyTipsView.a(k);
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          this.jdField_a_of_type_Afwe.notifyDataSetChanged();
        }
        if ((this.cbq) && (!this.cbr))
        {
          anot.a(this.mApp, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
          this.cbr = true;
        }
        return;
        this.jdField_a_of_type_Afwe.a(0, this.jdField_a_of_type_Aftf);
        localObject1 = this.jdField_a_of_type_Aftf;
        j = 1;
        break;
        localaftg.subTitle = (this.jdField_a_of_type_Aftq.cUq + getString(2131701170));
        localObject2 = localaftg;
        break label292;
        j = 0;
        break label369;
        label596:
        localObject1 = new aftl();
        this.jdField_a_of_type_Afwe.a(j, (afua)localObject1);
        break label448;
        label618:
        if ((localObject1 instanceof aftl))
        {
          this.jdField_a_of_type_Afwe.remove(j);
          i = 1;
          continue;
          label639:
          if ((this.jdField_a_of_type_Afwe.a(0) instanceof aftf))
          {
            this.jdField_a_of_type_Afwe.remove(0);
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
      }
      localObject2 = null;
      break label292;
    }
  }
  
  private void ddc()
  {
    if (afsi.a == null) {
      afsi.a = new afuc();
    }
    if (this.jdField_a_of_type_Afwe != null)
    {
      localObject = new afuc.a();
      ((afuc.a)localObject).mList.addAll(this.jdField_a_of_type_Afwe.getList());
      ((afuc.a)localObject).mUpdateTime = this.mUpdateTime;
      ((afuc.a)localObject).cUu = this.cUu;
      ((afuc.a)localObject).caO = this.caO;
      ((afuc.a)localObject).dF = this.dF;
      ((afuc.a)localObject).mSearchKey = this.mSearchKey;
      ((afuc.a)localObject).mCurPos = this.mLayoutManager.findFirstVisibleItemPosition();
      if (((afuc.a)localObject).mCurPos < 0) {
        ((afuc.a)localObject).mCurPos = 0;
      }
      View localView = this.mLayoutManager.findViewByPosition(((afuc.a)localObject).mCurPos);
      if (localView != null) {
        ((afuc.a)localObject).mOffset = localView.getTop();
      }
      afsi.a.caM = this.caM;
      afsi.a.caN = this.caN;
      afsi.a.cUt = this.cUt;
      afsi.a.a((afuc.a)localObject, this.caM, this.caN, this.cUt);
    }
    if (QLog.isColorLevel()) {
      if (afsi.a != null) {
        break label221;
      }
    }
    label221:
    for (Object localObject = "null";; localObject = afsi.a.toString())
    {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject }));
      return;
    }
  }
  
  private void kB(List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("updateAddFrdState count=%d", new Object[] { Integer.valueOf(paramList.size()) }));
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        int i = this.jdField_a_of_type_Afwe.cS((String)localObject);
        if (i >= 0)
        {
          localObject = this.jdField_a_of_type_Afwe.a(i);
          if ((localObject != null) && (!((afua)localObject).mAddFriendVerified))
          {
            ((afua)localObject).mAddFriendVerified = true;
            this.jdField_a_of_type_Afwe.notifyItemChanged(i);
          }
        }
      }
    }
  }
  
  private void r(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "updateSearchBarState scrollY: " + paramInt + "  speed: " + paramFloat);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null)
    {
      if (paramInt >= this.cUQ) {
        break label96;
      }
      if (paramInt <= this.cUh / 2) {
        break label86;
      }
      if (paramFloat > 0.0F) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.In();
      }
    }
    for (;;)
    {
      IC(false);
      return;
      label86:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.Im();
      continue;
      label96:
      if (paramFloat < -5.0F) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.Im();
      } else if (paramFloat > 0.5D) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.In();
      }
    }
  }
  
  protected int DF()
  {
    return 1031;
  }
  
  protected int DG()
  {
    return this.cUt;
  }
  
  public int DI()
  {
    if (this.mLayoutManager == null) {}
    int i;
    View localView;
    do
    {
      return 0;
      i = this.mLayoutManager.findFirstVisibleItemPosition();
      localView = this.mLayoutManager.findViewByPosition(i);
    } while (localView == null);
    return localView.getHeight() * i - (localView.getTop() - wja.dp2px(11.0F, getResources()));
  }
  
  public void IC(boolean paramBoolean)
  {
    if ((!this.cbp) || (paramBoolean))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.NG(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getHeight());
      }
      this.cbp = true;
    }
  }
  
  public void Iu(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.bZx = paramBoolean;
    if (!this.bZx)
    {
      this.caO = false;
      this.dF = null;
    }
    if (this.jdField_b_of_type_Afsg != null)
    {
      this.XN = System.currentTimeMillis();
      this.jdField_b_of_type_Afsg.a(this.mApp.getCurrentUin(), this.dF, 20, this.mSearchKey, this.XN, afsi.DEFAULT_TAG, true);
      this.mLoading = true;
    }
    if (!paramBoolean) {}
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullDownToRefresh  mRecyclerViewScrollY:" + this.cUP);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "onPullDownToRefresh state:" + paramPullToRefreshBase.a() + " lastCacheOk:" + this.cbo);
    }
    if (this.f.hasMessages(10))
    {
      this.f.removeMessages(10);
      bOS();
    }
    anot.a(this.mApp, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.a() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.cbo)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.ddB();
    }
    for (;;)
    {
      r(this.cUP, 0.0F);
      return;
      if (aqiw.isNetworkAvailable(this.mActivity))
      {
        Iu(false);
        dck();
        this.jdField_a_of_type_Afwe.bx(0, true);
      }
      else
      {
        this.cUO = 0;
        dcY();
      }
    }
  }
  
  public void a(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    ExtendFriendCampusVerifyTipsView.d(this.mActivity, this.mApp);
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullUpToRefresh  mRecyclerViewScrollY:" + this.cUP);
    }
  }
  
  public void b(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    afxn.F(this.mApp, false);
    ddb();
  }
  
  protected void bV(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.bV(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) || (paramBoolean2)) {
      ddc();
    }
  }
  
  public void dca()
  {
    super.dca();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "limitchat enter match");
    }
    if (PA())
    {
      anot.a(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
      }
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$a.dcN();
      afxv.a().NF(2);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void dcd()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    ArrayList localArrayList = null;
    Object localObject1 = localObject2;
    boolean bool2 = bool3;
    int i;
    if (this.mLayoutManager != null)
    {
      localObject1 = localObject2;
      bool2 = bool3;
      if (this.jdField_a_of_type_Afwe != null)
      {
        i = this.mLayoutManager.findFirstVisibleItemPosition();
        int j = this.mLayoutManager.findLastVisibleItemPosition();
        localObject1 = localArrayList;
        bool2 = bool1;
        if (i <= j)
        {
          localObject1 = this.jdField_a_of_type_Afwe.a(i);
          localObject2 = this.mRecyclerView.findViewHolderForPosition(i);
          if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof aftm)))
          {
            localObject2 = (aftm)localObject2;
            localObject1 = a(((afua)localObject1).mUin, ((afua)localObject1).mNickName, ((aftm)localObject2).zb);
            ((aftm)localObject2).zb.setImageDrawable((Drawable)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject1 instanceof aftf))
      {
        localObject1 = ((aftf)localObject1).wt.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aftg)((Iterator)localObject1).next();
            if (((aftg)localObject2).type == 0)
            {
              bool1 = true;
              localArrayList = ((aftg)localObject2).wu;
              break;
              if (this.cbq)
              {
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.IJ(bool2);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.kC((List)localObject1);
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      brD();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1031)
    {
      dcm();
      bV(true, true);
      if (paramInt2 == 8193) {
        dcl();
      }
      this.cUx = -1;
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) || (paramInt2 != -1)) {
          break;
        }
        paramIntent = this.jdField_a_of_type_Afwe.a(this.cUw);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_Afwe.notifyItemChanged(this.cUw);
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1))
      {
        bV(false, true);
        return;
      }
    } while ((paramInt1 != 3) || (paramInt2 != -1) || (paramIntent == null));
    if (paramIntent.getBooleanExtra("has_entered_profile", false)) {
      bV(true, true);
    }
    if (paramIntent.hasExtra("add_frd_list")) {
      kB(paramIntent.getStringArrayListExtra("add_frd_list"));
    }
    if (paramIntent.hasExtra("remain_match_count"))
    {
      paramInt1 = paramIntent.getIntExtra("remain_match_count", 0);
      if (paramInt1 != this.jdField_a_of_type_Aftq.cUo)
      {
        this.jdField_a_of_type_Aftq.cUo = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aftq.cUo) }));
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramIntent.hasExtra("limit_chat_duration"))
      {
        paramInt2 = paramIntent.getIntExtra("limit_chat_duration", 0);
        if (paramInt2 != this.jdField_a_of_type_Aftq.cUp)
        {
          this.jdField_a_of_type_Aftq.cUp = paramInt2;
          paramInt1 = i;
          if (QLog.isColorLevel())
          {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aftq.cUp) }));
            paramInt1 = i;
          }
        }
      }
      while ((paramInt1 != 0) && (this.jdField_a_of_type_Afwe != null)) {
        return;
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.c);
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
      ((afsi)this.mApp.getManager(264)).bR(this.mActivity);
    }
    this.n = new auru(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Afvl = new afvl(this.mApp);
    dda();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.cUh = wja.dp2px(35.0F, getResources());
    this.cUQ = wja.dp2px(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131561345, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373844));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.mLayoutManager = new afzj(this.mActivity);
    this.mRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.bX());
    this.mRecyclerView.setId(2131376994);
    this.mRecyclerView.setLayoutManager(this.mLayoutManager);
    ((SimpleItemAnimator)this.mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.mRecyclerView.setOnScrollListener(new afvy(this));
    this.jdField_a_of_type_Afwf = new afwf(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new afvz(this);
    this.jdField_a_of_type_Afwe = new afwe(this, this, this, this, this.mRecyclerView, this.mActivity, 0, this.mGdtAppReceiver);
    this.jdField_a_of_type_Afwe.Nv(wja.dp2px(35.0F, getResources()));
    this.jdField_a_of_type_Afwe.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_Afwe.a(this.jdField_a_of_type_Afvl);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_Afwe);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.mActivity.findViewById(2131368498));
    paramViewGroup = this.mActivity.findViewById(2131365382);
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new afwa(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramLayoutInflater.findViewById(2131377783));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(new afwb(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramLayoutInflater.findViewById(2131363629));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.b(this.mApp, this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new afwc(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Afvl != null)
    {
      this.jdField_a_of_type_Afvl.flush();
      this.jdField_a_of_type_Afvl = null;
    }
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.c);
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
      this.mApp = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_Afwe.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_Afwe.onDestroy();
    this.mActivity = null;
    this.jdField_b_of_type_Afsg = null;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onResume");
    }
    super.onResume();
    if ((!this.cbn) && (isAdded()))
    {
      boolean bool = b(true, null);
      long l = System.currentTimeMillis() - this.mUpdateTime;
      if ((!bool) || (l > 60000L) || (akt()))
      {
        this.cbo = false;
        this.mSearchKey = afsi.DEFAULT_TAG;
        List localList = this.jdField_a_of_type_Afsi.Y(2);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
        this.n.removeMessages(11);
        this.n.sendEmptyMessageDelayed(11, 500L);
        this.cbn = true;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) }));
        }
        this.n.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
      }
    }
    for (;;)
    {
      r(this.cUP, 0.0F);
      return;
      this.cbo = true;
      break;
      if (akt())
      {
        this.cbo = false;
        this.n.removeMessages(11);
        this.n.sendEmptyMessageDelayed(11, 500L);
      }
      else
      {
        ddb();
        this.jdField_a_of_type_Afwe.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */