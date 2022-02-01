package com.tencent.mobileqq.richstatus;

import acff;
import acfp;
import aclv;
import amgi;
import amgj;
import amgk;
import amgl;
import amgm;
import amgn;
import amgo;
import amgp;
import amgq;
import amgr;
import amgs;
import amgt;
import amgu;
import amgv;
import amgw;
import amgx;
import amgy;
import amgz;
import amha;
import amhc;
import amhj;
import amho;
import amhq;
import amhr;
import amie;
import amif;
import amif.a;
import amii;
import amii.a;
import amin;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anlm;
import anot;
import aqcx;
import aqgv;
import aqha;
import aqiw;
import aqju;
import aqnl;
import aqnm;
import arhz;
import aurd;
import ausj;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureHandler.RspGetHistorySig;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.a;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jll;
import ku;
import ku.a;
import mqq.os.MqqHandler;
import rpq;
import wja;

public class SignatureHistoryFragment
  extends IphoneTitleBarFragment
  implements amif.a, amii.a, Handler.Callback, View.OnClickListener, SoftInputDetectView.a, AbsListView.e
{
  View.OnTouchListener B = new amgj(this);
  private ImageView Dm;
  private ImageView Dn;
  private View GE;
  public View GF;
  private TextView HU;
  private String Vx;
  private EditText W;
  private Button X;
  private TextView Yl;
  private TextView Ym;
  protected amho a;
  private arhz jdField_a_of_type_Arhz;
  public SignatureHandler a;
  private a jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a;
  private CommentItem jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem;
  ku.a jdField_a_of_type_Ku$a = new amgl(this);
  private HashSet<amif> aE = new HashSet();
  private String aWf;
  private ausj ao;
  protected aclv b;
  protected amhj b;
  protected SignatureManager b;
  private boolean cCA;
  private boolean cCB;
  private boolean cCz;
  private int cUE;
  private int cai = 0;
  private boolean cuv;
  private boolean cuw;
  private EmoticonMainPanel d;
  private int dBL = 0;
  private int dbo;
  private Drawable eS;
  private ViewGroup et;
  View.OnClickListener fJ = new amgk(this);
  private ImageView gR;
  private Button hc;
  private boolean isRefresh;
  private TextView jQ;
  private RelativeLayout lQ;
  private View lg;
  View.OnLayoutChangeListener mLayoutChangeListener = new amgr(this);
  protected XListView mListView;
  private HashMap<String, ArrayList<String>> mN = new HashMap();
  protected int mNumColumns;
  private HashMap<String, Boolean> mO = new HashMap();
  private TextView mTitle;
  private Handler mUIHandler;
  private String mUin;
  private TextView nameText;
  private View rM;
  private View rV;
  private ArrayList<String> zq = new ArrayList();
  private ArrayList<HistorySignItem> zr;
  
  private void Bz(int paramInt)
  {
    if (paramInt == 1)
    {
      this.Ym.setText(acfp.m(2131714571));
      this.Dn.setImageDrawable(this.eS);
      this.eS.setVisible(true, true);
      return;
    }
    this.eS.setVisible(false, false);
    this.Dn.setImageResource(2130851444);
    if (paramInt == 3)
    {
      this.Ym.setText(acfp.m(2131714562));
      return;
    }
    this.Ym.setText(acfp.m(2131714567));
  }
  
  private void G(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = t(this.lQ);
    this.mUIHandler.post(new SignatureHistoryFragment.17(this, paramInt1, i, paramInt2, paramBoolean));
  }
  
  private void Nj(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Nk(false);
      aurd.aO(this.W);
      return;
    }
    aurd.hide(this.W);
  }
  
  private void Nk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.cuv)
      {
        this.dBL = 1;
        Nj(false);
        return;
      }
      dNq();
      return;
    }
    this.cuw = false;
    this.gR.setImageResource(2130850880);
    this.gR.setContentDescription(getActivity().getString(2131690680));
    this.gR.setOnClickListener(new amgo(this));
    this.d.setVisibility(8);
  }
  
  private void PB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((getActivity() != null) && (!TextUtils.isEmpty(getActivity().getCurrentAccountUin())) && (getActivity().getCurrentAccountUin().equals(paramString))) {
      paramString = new ProfileActivity.AllInOne(paramString, 0);
    }
    for (;;)
    {
      ProfileActivity.b(getActivity(), paramString);
      return;
      if (isFriend(paramString)) {
        paramString = new ProfileActivity.AllInOne(paramString, 1);
      } else {
        paramString = new ProfileActivity.AllInOne(paramString, 19);
      }
    }
  }
  
  private void Pf(boolean paramBoolean)
  {
    int j = this.mListView.getFirstVisiblePosition();
    int k = this.mListView.getLastVisiblePosition();
    int m = this.mListView.getHeaderViewsCount();
    int i = j - 1;
    if (i <= k)
    {
      Object localObject = this.mListView.getChildAt(m + i - j);
      if ((localObject != null) && ((((View)localObject).getTag() instanceof amie)))
      {
        localObject = (amie)((View)localObject).getTag();
        ((amie)localObject).setScrolling(paramBoolean);
        if (((amie)localObject).l != null)
        {
          if (!paramBoolean) {
            break label110;
          }
          ((amie)localObject).l.pauseAnimation();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        ((amie)localObject).l.shouldStartAnimation = true;
        ((amie)localObject).l.startAnimation(false, false);
      }
    }
  }
  
  private void Pg(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rV.setVisibility(8);
      return;
    }
    if (this.cCA)
    {
      this.rV.setVisibility(0);
      if ((this.zq == null) || (this.zq.isEmpty()))
      {
        this.hc.setTextColor(getActivity().getResources().getColor(2131167268));
        this.hc.setText(getString(2131720317));
        this.hc.setOnTouchListener(null);
      }
      for (;;)
      {
        this.hc.setBackgroundResource(2130848307);
        return;
        this.hc.setTextColor(getActivity().getResources().getColor(2131167267));
        this.hc.setText(String.format(getActivity().getResources().getString(2131720319), new Object[] { Integer.valueOf(this.zq.size()) }));
        this.hc.setOnTouchListener(jll.a);
      }
    }
    if (this.mUin.equals(this.aWf))
    {
      this.rV.setVisibility(0);
      this.hc.setText(getString(2131718858));
      this.hc.setTextColor(getResources().getColor(2131167654));
      this.hc.setBackgroundResource(2130839524);
      return;
    }
    this.rV.setVisibility(8);
  }
  
  private void T(String paramString1, String paramString2, int paramInt)
  {
    Iterator localIterator;
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1)) && (this.zr != null) && (this.zr.size() > 0)) {
      localIterator = this.zr.iterator();
    }
    HistorySignItem localHistorySignItem;
    Object localObject2;
    Object localObject1;
    label129:
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        while (localIterator.hasNext())
        {
          localHistorySignItem = (HistorySignItem)localIterator.next();
          if ((localHistorySignItem.richStatus != null) && (paramString1.equals(localHistorySignItem.richStatus.feedsId)))
          {
            localObject2 = localHistorySignItem.likeItemList;
            localObject1 = localObject2;
            if (paramInt == 1)
            {
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new ArrayList();
              }
            }
            if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2))) {
              break label129;
            }
          }
        }
        return;
        if (paramInt != 0) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
      }
      localObject2 = (amhq)((Iterator)localObject1).next();
    } while ((((amhq)localObject2).user == null) || (!paramString2.equals(((amhq)localObject2).user.uin)));
    ((Iterator)localObject1).remove();
    localHistorySignItem.totalLikeNum -= 1L;
    return;
    ((List)localObject1).add(0, new amhq(NetConnInfoCenter.getServerTime() / 1000L, new amhr(paramString2, nb(paramString2))));
    localHistorySignItem.totalLikeNum += 1L;
  }
  
  private static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new amgm(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.bYZ = true;
    paramView.bZc = true;
    paramView.bYX = false;
    paramView.bYY = true;
    paramView.bZb = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new amgn());
    paramView.a.setOverScrollMode(2);
    return paramView;
  }
  
  private void a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)) && (this.zr != null) && (this.zr.size() > 0))
    {
      Iterator localIterator = this.zr.iterator();
      while (localIterator.hasNext())
      {
        HistorySignItem localHistorySignItem = (HistorySignItem)localIterator.next();
        if ((localHistorySignItem.richStatus != null) && (paramCommentItem.feedId.equals(localHistorySignItem.richStatus.feedsId)))
        {
          if (localHistorySignItem.commentItemList == null) {
            localHistorySignItem.commentItemList = new ArrayList();
          }
          localHistorySignItem.commentItemList.add(paramCommentItem);
        }
      }
    }
  }
  
  private void a(CommentItem paramCommentItem, String paramString)
  {
    ausj localausj = ausj.b(getActivity());
    localausj.addButton(2131693962, 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new amgq(this, paramCommentItem, paramString, localausj));
    localausj.show();
  }
  
  private boolean a(CommentItem paramCommentItem)
  {
    if ((paramCommentItem != null) && (!TextUtils.isEmpty(paramCommentItem.feedId)) && (this.zr != null) && (this.zr.size() > 0))
    {
      Object localObject;
      do
      {
        Iterator localIterator = this.zr.iterator();
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (HistorySignItem)localIterator.next();
          } while ((((HistorySignItem)localObject).richStatus == null) || (!paramCommentItem.feedId.equals(((HistorySignItem)localObject).richStatus.feedsId)) || (((HistorySignItem)localObject).commentItemList == null) || (((HistorySignItem)localObject).commentItemList.size() <= 0));
          localObject = ((HistorySignItem)localObject).commentItemList.iterator();
        }
      } while (((CommentItem)((Iterator)localObject).next()).id != paramCommentItem.id);
      ((Iterator)localObject).remove();
      return true;
    }
    return false;
  }
  
  private int b(List<amhq> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      amhq localamhq = (amhq)paramList.next();
      if ((localamhq.user != null) && (paramString.equals(localamhq.user.uin))) {
        return 1;
      }
    }
    return 0;
  }
  
  private boolean b(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.cuv) || (this.cuw) || (this.et.getVisibility() == 0))
    {
      if ((this.W != null) && (paramBoolean)) {
        this.W.setText("");
      }
      this.cuw = false;
      this.cuv = false;
      aurd.hide(paramView);
      this.et.setVisibility(8);
      this.lQ.setVisibility(8);
      this.lQ.setVisibility(8);
      this.lQ.removeOnLayoutChangeListener(this.mLayoutChangeListener);
      bool = true;
    }
    return bool;
  }
  
  private void bZe()
  {
    ThreadManager.getFileThreadHandler().post(new SignatureHistoryFragment.4(this));
  }
  
  private void dNp()
  {
    if (this.Vx == null) {
      return;
    }
    String str2 = this.Vx;
    String str1 = str2;
    if (str2.length() == 0) {
      str1 = String.valueOf(this.mUin);
    }
    this.nameText.setText(str1);
    this.nameText.invalidate();
    str2 = getActivity().getString(2131692177) + ":";
    this.nameText.setContentDescription(str2 + str1);
  }
  
  private void dNq()
  {
    this.cuw = true;
    this.gR.setImageResource(2130837612);
    this.gR.setContentDescription(getActivity().getString(2131690681));
    this.gR.setOnClickListener(new amgp(this));
    this.d.setVisibility(0);
    if (this.cUE > ankt.cIE / 4) {}
    for (int i = this.cUE;; i = ankt.cIE / 3)
    {
      ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
      localLayoutParams.height = i;
      this.d.setMinimumHeight(localLayoutParams.height);
      this.d.setLayoutParams(localLayoutParams);
      ((RelativeLayout.LayoutParams)this.lQ.getLayoutParams()).bottomMargin = i;
      this.dBL = 0;
      return;
    }
  }
  
  private void dNr()
  {
    boolean bool;
    if (!this.cCA)
    {
      bool = true;
      this.cCA = bool;
      if (!this.cCA) {
        break label82;
      }
      anot.a(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
      Pg(false);
      this.jQ.setText(2131721066);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a.notifyDataSetChanged();
      return;
      bool = false;
      break;
      label82:
      Pg(false);
      this.jQ.setText(2131720323);
      this.zq.clear();
    }
  }
  
  private int t(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void yk(boolean paramBoolean)
  {
    stopTitleProgress();
    if (paramBoolean)
    {
      this.mUIHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
    }
    ba(1, 2131720480);
    this.mListView.springBackOverScrollHeaderView();
  }
  
  public LinearLayout a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    Object localObject = (CheckBox)LayoutInflater.from(getActivity()).inflate(2131561703, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.leftMargin = wja.dp2px(16.0F, getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    int i = wja.dp2px(10.0F, getResources());
    localObject = new LinearLayout.LayoutParams(aqnm.getScreenWidth() - i * 2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = i;
    ((LinearLayout.LayoutParams)localObject).rightMargin = i;
    localLinearLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
    return localLinearLayout;
  }
  
  public void a(amii paramamii, View paramView)
  {
    if (this.cCA) {}
    do
    {
      return;
      QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick topic=", paramamii });
      paramamii = paramamii.getData();
    } while (!(paramamii instanceof Pair));
    paramamii = (Pair)paramamii;
    if (QLog.isColorLevel()) {
      QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", new Object[] { paramamii.first, paramamii.second }));
    }
    amin.u(getActivity(), amin.K(((Integer)paramamii.first).intValue(), (String)paramamii.second), -1);
  }
  
  public void a(View paramView, int paramInt, amif paramamif)
  {
    QLog.d("SignatureHistoryFragment", 1, new Object[] { "onClick viewType=", paramView });
    if (paramInt == 3) {
      if (!this.cCA) {}
    }
    label462:
    do
    {
      for (;;)
      {
        return;
        anot.a(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
        this.et.setVisibility(0);
        this.lQ.setVisibility(0);
        this.W.requestFocus();
        this.W.setHint(2131700896);
        Nj(true);
        paramInt = t(paramView);
        int i = paramView.getHeight();
        this.GF = paramView;
        this.mUIHandler.postDelayed(new SignatureHistoryFragment.9(this, paramInt, i), 200L);
        if ((paramamif instanceof amie))
        {
          paramView = ((amie)paramamif).richStatus;
          if ((paramView != null) && (getActivity() != null) && (getActivity().app != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = new CommentItem();
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId = 0L;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId = paramView.feedsId;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.toReplyUser = null;
            this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.user = new amhr(this.aWf, this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.bd(Long.valueOf(this.aWf).longValue()));
            return;
            if (paramInt != 4) {
              break;
            }
            if (!this.cCA)
            {
              anot.a(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
              if (!aqiw.isNetSupport(getActivity()))
              {
                QQToast.a(getActivity(), 2131694663, 0).show();
                return;
              }
              if ((paramamif instanceof amie))
              {
                if (((amie)paramamif).zanFlag == 0) {
                  ((amie)paramamif).zanFlag = 1;
                }
                for (paramInt = 1;; paramInt = 0)
                {
                  if ((((amie)paramamif).richStatus == null) || (TextUtils.isEmpty(((amie)paramamif).richStatus.feedsId))) {
                    break label462;
                  }
                  T(((amie)paramamif).richStatus.feedsId, this.aWf, ((amie)paramamif).zanFlag);
                  if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a != null) {
                    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a.notifyDataSetChanged();
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.l(this.mUin, ((amie)paramamif).richStatus.feedsId, 255, paramInt);
                  return;
                  ((amie)paramamif).zanFlag = 0;
                }
              }
            }
          }
        }
      }
    } while ((paramInt != 2) || (!(paramamif instanceof amie)) || (this.ao != null));
    this.cCB = true;
    hB(((amie)paramamif).getContent());
  }
  
  protected void aV(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("SignatureHistoryFragment", 2, "updateData: refresh=" + paramBoolean1 + " user=" + paramBoolean2);
    long l;
    if (aqiw.isNetSupport(getActivity()))
    {
      this.isRefresh = paramBoolean1;
      if (paramBoolean1)
      {
        l = 2147483647L;
        int i = (int)l;
        this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.G(Long.valueOf(this.mUin).longValue(), 0, i);
        label84:
        if (this.zr.size() == 0) {
          Bz(1);
        }
        if (!paramBoolean2) {
          break label192;
        }
        stopTitleProgress();
      }
    }
    label192:
    while (!paramBoolean1)
    {
      return;
      l = ((HistorySignItem)this.zr.get(this.zr.size() - 1)).richStatus.time - 1L;
      break;
      Message localMessage = this.mUIHandler.obtainMessage(0, 1, 0);
      this.mUIHandler.sendMessageDelayed(localMessage, 1000L);
      if (paramBoolean1) {
        break label84;
      }
      this.cai = 3;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a == null) {
        break label84;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a.notifyDataSetChanged();
      break label84;
    }
    startTitleProgress();
  }
  
  public void aq(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)this.lQ.getLayoutParams()).bottomMargin = 0;
      this.cUE = paramInt;
      Nk(false);
      Pg(true);
      this.cuv = paramBoolean;
      return;
    }
    if (this.dBL == 1) {
      dNq();
    }
    for (;;)
    {
      Pg(false);
      break;
      this.lQ.setVisibility(8);
    }
  }
  
  public void ba(int paramInt1, int paramInt2)
  {
    if ((getActivity() != null) && (getActivity().isResume())) {
      QQToast.a(getActivity(), paramInt1, getResources().getString(paramInt2), 0).show(getActivity().getTitleBarHeight());
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mUIHandler = new Handler(this);
    ((ku)getActivity().app.getManager(42)).a(this.jdField_a_of_type_Ku$a);
    this.zr = new ArrayList();
    this.Vx = getActivity().getIntent().getStringExtra("key_uin_name");
    this.mUin = getActivity().getIntent().getStringExtra("key_uin");
    this.aWf = getActivity().app.getCurrentUin();
    paramLayoutInflater = getActivity().getIntent().getStringExtra("key_open_via");
    VasWebviewUtil.reportCommercialDrainage(getActivity().app.getCurrentUin(), "signature", "signature_8", paramLayoutInflater, 1, 0, 0, "", "", "");
    label621:
    boolean bool;
    if (this.aWf.equalsIgnoreCase(this.mUin))
    {
      i = 1;
      anot.a(getActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i, 0, "0", "0", "", "");
      this.leftView.setTextColor(getResources().getColor(2131165381));
      this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840658));
      this.centerView.setTextColor(getResources().getColor(2131165381));
      paramLayoutInflater = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramLayoutInflater);
      i = paramLayoutInflater.widthPixels;
      int j = aqcx.dip2px(getActivity(), 69.0F);
      this.dbo = Math.min(aqcx.dip2px(getActivity(), 260.0F), i - j);
      this.mNumColumns = ((this.dbo - aqcx.dip2px(getActivity(), 70.0F)) / aqcx.dip2px(getActivity(), 28.0F));
      this.jdField_b_of_type_ComTencentMobileqqAppSignatureManager = ((SignatureManager)getActivity().app.getManager(58));
      this.jdField_b_of_type_Amhj = ((amhj)getActivity().app.getManager(15));
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler = ((SignatureHandler)getActivity().app.getBusinessHandler(41));
      this.jdField_a_of_type_Amho = new d(null);
      getActivity().app.registObserver(this.jdField_a_of_type_Amho);
      this.jdField_b_of_type_Aclv = new c(null);
      getActivity().app.addObserver(this.jdField_b_of_type_Aclv);
      this.mTitle = ((TextView)this.mContentView.findViewById(2131380935));
      this.mTitle.setText(2131720322);
      this.jQ = ((TextView)this.mContentView.findViewById(2131380934));
      this.jQ.setOnClickListener(this);
      this.HU = ((TextView)this.mContentView.findViewById(2131380933));
      this.HU.setOnClickListener(this);
      this.HU.setContentDescription(getText(2131691039));
      i = rpq.dip2px(getActivity(), 3.0F);
      j = rpq.dip2px(getActivity(), 10.0F);
      rpq.h(this.HU, i, i, j, j);
      if (!this.mUin.equals(this.aWf)) {
        break label1504;
      }
      this.jQ.setVisibility(0);
      this.jQ.setText(2131720323);
      this.lg = LayoutInflater.from(getActivity()).inflate(2131563110, this.mListView, false);
      this.Ym = ((TextView)this.lg.findViewById(2131366429));
      this.Ym.setCompoundDrawables(null, null, null, null);
      this.Dn = ((ImageView)this.lg.findViewById(2131366414));
      this.eS = getResources().getDrawable(2130839657);
      this.Dn.setImageDrawable(this.eS);
      this.eS.setVisible(true, true);
      this.hc = ((Button)this.mContentView.findViewById(2131378389));
      this.hc.setOnClickListener(this);
      this.rV = this.mContentView.findViewById(2131378388);
      Pg(false);
      this.rM = LayoutInflater.from(getActivity()).inflate(2131563111, null);
      this.Dm = ((ImageView)this.rM.findViewById(2131378386));
      this.Dm.setOnClickListener(this);
      this.nameText = ((TextView)this.rM.findViewById(2131378387));
      this.Yl = ((TextView)this.rM.findViewById(2131378396));
      this.mListView = ((XListView)this.mContentView.findViewById(2131365384));
      this.mListView.addHeaderView(this.rM, null, false);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a = new a(null);
      this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a);
      this.mListView.setOnScrollListener(this);
      this.GE = this.mContentView.findViewById(2131380116);
      this.GE.setOnTouchListener(new amgi(this));
      this.lQ = ((RelativeLayout)this.mContentView.findViewById(2131377483));
      this.lQ.setVisibility(8);
      this.W = ((EditText)this.mContentView.findViewById(2131366527));
      this.W.setEditableFactory(new amgs(this));
      this.W.addTextChangedListener(new amgt(this));
      this.X = ((Button)this.mContentView.findViewById(2131363985));
      this.X.setOnClickListener(this);
      paramLayoutInflater = this.X;
      if (TextUtils.isEmpty(this.X.getText())) {
        break label1516;
      }
      bool = true;
      label1054:
      paramLayoutInflater.setEnabled(bool);
      this.et = ((ViewGroup)this.mContentView.findViewById(2131366347));
      this.et.setVisibility(8);
      this.gR = ((ImageView)this.mContentView.findViewById(2131366375));
      this.gR.setOnTouchListener(jll.a);
      paramLayoutInflater = (SoftInputDetectView)this.mContentView.findViewById(2131369291);
      paramLayoutInflater.setExcludeStatusBar(false);
      paramLayoutInflater.setOnImStateChangedListener(this);
      this.d = a(getActivity().app, getActivity(), this.mContentView, 2131366348, this.W);
      this.d.setVisibility(8);
      this.cuv = false;
      this.cuw = false;
      if (getTitleBarView() != null) {
        getTitleBarView().setVisibility(8);
      }
      if ((getActivity() != null) && (getActivity().getWindow() != null))
      {
        getActivity().getWindow().setSoftInputMode(16);
        getActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(2130848311));
        if (ImmersiveUtils.isSupporImmersive() != 0)
        {
          paramLayoutInflater = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
          paramLayoutInflater.init();
          if (!ImmersiveUtils.aJW()) {
            break label1522;
          }
          ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
          paramLayoutInflater.setStatusBarColor(getResources().getColor(2131167595));
        }
      }
      label1303:
      bZe();
      if ((this.Vx == null) || (this.Vx.equals(""))) {
        this.Vx = aqgv.A(getActivity().app, this.mUin);
      }
      dNp();
      if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.hP(Long.parseLong(this.mUin));
      }
      if (!this.mUin.equals(this.aWf)) {
        break label1532;
      }
    }
    label1504:
    label1516:
    label1522:
    label1532:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i, 0, "" + i, "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("signature_history", "pv", "", 0, 0, 0, "", "", "" + i, "", "", "", "", 0, 0, 0, 0);
      return;
      i = 2;
      break;
      this.jQ.setVisibility(8);
      break label621;
      bool = false;
      break label1054;
      paramLayoutInflater.setStatusBarColor(anlm.dJT);
      break label1303;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131563114;
  }
  
  public void hB(View paramView)
  {
    if (this.mUin.equals(this.aWf)) {}
    do
    {
      return;
      VasWebviewUtil.reportCommercialDrainage("signature_history", "cove_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    } while (!this.cCB);
    this.cCB = false;
    Object localObject2 = paramView.getTag(2131378407);
    int i = 1;
    int k = 0;
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      int m;
      int j;
      try
      {
        localObject1 = Integer.valueOf(0);
        m = 0;
        if (paramView.getTag(2131378415) == null) {
          break label348;
        }
        j = ((Integer)paramView.getTag(2131378415)).intValue();
        i = j;
        if (j <= 1) {
          break label348;
        }
        i = 1;
        m = i;
        if (paramView.getTag(2131378408) != null)
        {
          int n = ((Integer)paramView.getTag(2131378408)).intValue();
          m = i;
          k = n;
          if (n > 0)
          {
            m = 1;
            k = n;
          }
        }
        if ((this.ao != null) && (this.ao.isShowing())) {
          break;
        }
        this.ao = ausj.b(getActivity());
        if (((Integer)localObject1).intValue() == 2)
        {
          this.ao.addRadioButton(2131693016, false);
          i = 1;
          this.ao.addCancelButton(2131721058);
          this.ao.show();
          this.ao.a(new amgw(this, i, j, k));
          this.ao.a(new amgx(this));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      if (m != 0)
      {
        if (j > 1)
        {
          this.ao.addRadioButton(2131693013, false);
          i = 3;
        }
        else
        {
          this.ao.addRadioButton(2131693015, false);
          i = 2;
        }
      }
      else
      {
        this.ao.addRadioButton(2131693011, false);
        i = 4;
        continue;
        label348:
        j = i;
        i = m;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          stopTitleProgress();
          this.mListView.springBackOverScrollHeaderView();
        } while (paramMessage.arg1 != 1);
        if (this.zr.size() == 0) {
          Bz(2);
        }
        ba(1, 2131720480);
        return true;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusSignatureHistoryFragment$a.notifyDataSetChanged();
        return true;
        this.Dm.setImageBitmap((Bitmap)paramMessage.obj);
        return true;
      } while (!isAdded());
      if (paramMessage.arg1 >= 0)
      {
        this.Yl.setVisibility(0);
        this.Yl.setText(String.format(getString(2131720321), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.Yl.setVisibility(8);
      return true;
      if (paramMessage.arg1 == 1)
      {
        ba(1, 2131706117);
        return true;
      }
    } while (paramMessage.arg1 != 2);
    ba(1, 2131698607);
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
  }
  
  public boolean isFriend(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {
      return false;
    }
    return ((acff)getActivity().app.getManager(51)).isFriend(paramString);
  }
  
  public String nb(String paramString)
  {
    if ((getActivity() == null) || (getActivity().app == null)) {}
    Friends localFriends;
    do
    {
      return paramString;
      localFriends = ((acff)getActivity().app.getManager(51)).e(paramString);
    } while (localFriends == null);
    return localFriends.getFriendNickWithAlias();
  }
  
  public boolean onBackEvent()
  {
    if ((!getActivity().isFinishing()) && (this.d.getVisibility() == 0))
    {
      Nk(false);
      return true;
    }
    if (("history-msglist".equalsIgnoreCase(getActivity().getIntent().getStringExtra("key_open_via"))) && (getActivity() != null) && (this.mUin != null) && (this.mUin.equalsIgnoreCase(this.aWf)))
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.mUin, 0);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("single_top", true);
      ProfileActivity.a(getActivity(), localAllInOne, localBundle);
      getActivity().overridePendingTransition(2130772000, 2130772001);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
      continue;
      dNr();
      continue;
      if (this.cCA)
      {
        synchronized (this.zq)
        {
          if (!this.zq.isEmpty()) {}
        }
        if (!aqiw.isNetSupport(getActivity()))
        {
          QQToast.a(getActivity(), getString(2131693404), 0).show();
        }
        else
        {
          anot.a(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
          aqha.a(getActivity(), 230).setTitle(getString(2131720318)).setPositiveButton(getString(2131691404), new amgv(this)).setNegativeButton(getString(2131721058), new amgu(this)).show();
        }
      }
      else
      {
        VasWebviewUtil.reportCommercialDrainage("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        aqnl.a(getActivity(), getActivity().app, 0, "signature_history");
        continue;
        if (this.W != null)
        {
          ??? = this.W.getText().toString();
          if (!TextUtils.isEmpty((CharSequence)???)) {
            if (!aqiw.isNetSupport(getActivity()))
            {
              QQToast.a(getActivity(), getString(2131693404), 0).show();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content = ((String)???);
              if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler != null)
              {
                if (this.jdField_a_of_type_Arhz == null) {
                  this.jdField_a_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
                }
                this.jdField_a_of_type_Arhz.setMessage(null);
                this.jdField_a_of_type_Arhz.show();
                this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.mUin).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.targetId, Long.valueOf(this.aWf).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
              }
              b(paramView, true);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (getActivity() != null))
              {
                ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.content);
                this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem = null;
                continue;
                if (!aqiw.isNetSupport(getActivity()))
                {
                  QQToast.a(getActivity(), 2131694663, 0).show();
                }
                else if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem != null) && (!TextUtils.isEmpty(this.mUin)) && (!TextUtils.isEmpty(this.aWf)))
                {
                  if (this.jdField_a_of_type_Arhz == null) {
                    this.jdField_a_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
                  }
                  this.jdField_a_of_type_Arhz.setMessage(null);
                  this.jdField_a_of_type_Arhz.show();
                  this.jdField_a_of_type_ComTencentMobileqqAppSignatureHandler.a(Long.valueOf(this.mUin).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.feedId, Long.valueOf(this.aWf).longValue(), this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentBeanCommentItem.id);
                  continue;
                  hB(paramView);
                  continue;
                  if ((!TextUtils.isEmpty(this.mUin)) && (!this.cCA)) {
                    PB(this.mUin);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.aE.iterator();
    while (localIterator.hasNext()) {
      ((amif)localIterator.next()).destroy();
    }
    getActivity().app.unRegistObserver(this.jdField_a_of_type_Amho);
    getActivity().app.removeObserver(this.jdField_b_of_type_Aclv);
    ((ku)getActivity().app.getManager(42)).b(this.jdField_a_of_type_Ku$a);
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    aV(true, false);
    if ((getActivity() != null) && (getActivity().app != null)) {
      setMask(ThemeUtil.isInNightMode(getActivity().app));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      VasFaceManager.resume();
      ETTextView.enableAnimation = true;
      Pf(false);
      return;
    }
    URLDrawable.pause();
    VasFaceManager.pause();
    ETTextView.enableAnimation = false;
    Pf(true);
  }
  
  public void setMask(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131372394);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131372394);
        localFragmentActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    while (localView == null)
    {
      return;
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  public class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      int i = SignatureHistoryFragment.b(SignatureHistoryFragment.this).size();
      if (i == 0) {
        return 1;
      }
      return i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      if (paramInt >= SignatureHistoryFragment.b(SignatureHistoryFragment.this).size()) {
        return null;
      }
      return SignatureHistoryFragment.b(SignatureHistoryFragment.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return getItemViewType(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      int i = SignatureHistoryFragment.b(SignatureHistoryFragment.this).size();
      if (i == 0) {
        return 2;
      }
      if (paramInt < i) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      if (i == 2)
      {
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).setLayoutParams(new AbsListView.LayoutParams(SignatureHistoryFragment.this.mListView.getWidth(), SignatureHistoryFragment.this.mListView.getHeight()));
        paramView = SignatureHistoryFragment.a(SignatureHistoryFragment.this);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (i == 0)
        {
          localObject2 = (HistorySignItem)SignatureHistoryFragment.b(SignatureHistoryFragment.this).get(paramInt);
          if (paramView == null)
          {
            localObject1 = new BoxShadowLayout(SignatureHistoryFragment.this.getActivity());
            paramView = SignatureHistoryFragment.this.a((View)localObject1);
            localObject1 = new amie(SignatureHistoryFragment.this.getActivity(), SignatureHistoryFragment.this.getActivity().app, (View)localObject1, SignatureHistoryFragment.a(SignatureHistoryFragment.this));
            SignatureHistoryFragment.a(SignatureHistoryFragment.this).add(localObject1);
            ((amie)localObject1).a(SignatureHistoryFragment.this);
            ((amie)localObject1).a(SignatureHistoryFragment.this);
            Object localObject3 = (LinearLayout)((amie)localObject1).cr();
            ((amie)localObject1).getContent().setOnTouchListener(SignatureHistoryFragment.this.B);
            ((amie)localObject1).getContent().setOnClickListener(SignatureHistoryFragment.this);
            LayoutInflater.from(SignatureHistoryFragment.this.getActivity()).inflate(2131561704, (ViewGroup)localObject3);
            paramView.setTag(localObject1);
            label252:
            ((amie)localObject1).Q = ((CheckBox)paramView.findViewById(2131364359));
            ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView = ((CommentsView)paramView.findViewById(2131364820));
            ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnSpanItemClick(new amgy(this));
            ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemClickListener(new amgz(this, (HistorySignItem)localObject2));
            ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.setOnItemLongClickListener(new amha(this, (HistorySignItem)localObject2));
            ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView = ((LikesView)paramView.findViewById(2131370767));
            ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.setOnItemClickListener(new amhc(this));
            paramView.setTag(localObject1);
            paramView.setClickable(true);
            if ((localObject2 == null) || (((HistorySignItem)localObject2).richStatus == null) || (((HistorySignItem)localObject2).richStatus.feedsId == null)) {
              break label675;
            }
            ((amie)localObject1).Q.setTag(((HistorySignItem)localObject2).richStatus.feedsId);
            label413:
            if (!SignatureHistoryFragment.b(SignatureHistoryFragment.this)) {
              break label689;
            }
            ((amie)localObject1).Q.setVisibility(0);
            ((amie)localObject1).Q.setOnClickListener(SignatureHistoryFragment.this.fJ);
            label447:
            if ((localObject2 == null) || (((HistorySignItem)localObject2).richStatus == null) || (((HistorySignItem)localObject2).richStatus.feedsId == null)) {
              break label714;
            }
            if (!SignatureHistoryFragment.a(SignatureHistoryFragment.this).contains(((HistorySignItem)localObject2).richStatus.feedsId)) {
              break label702;
            }
            ((amie)localObject1).Q.setChecked(true);
            label501:
            ((amie)localObject1).index = paramInt;
            ((amie)localObject1).uin = SignatureHistoryFragment.a(SignatureHistoryFragment.this);
            localObject3 = ((HistorySignItem)localObject2).richStatus;
            ((amie)localObject1).richStatus = ((RichStatus)localObject3);
            ((amie)localObject1).a((RichStatus)localObject3);
            if (((((HistorySignItem)localObject2).likeItemList == null) || (((HistorySignItem)localObject2).likeItemList.size() <= 0)) && ((((HistorySignItem)localObject2).commentItemList == null) || (((HistorySignItem)localObject2).commentItemList.size() <= 0))) {
              break label726;
            }
            if (((amie)localObject1).cr() != null)
            {
              ((amie)localObject1).cr().setVisibility(0);
              ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.f(((HistorySignItem)localObject2).likeItemList, ((HistorySignItem)localObject2).totalLikeNum);
              ((amie)localObject1).jdField_b_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView.lY(((HistorySignItem)localObject2).commentItemList);
            }
          }
          for (;;)
          {
            ((amie)localObject1).zanFlag = SignatureHistoryFragment.a(SignatureHistoryFragment.this, ((HistorySignItem)localObject2).likeItemList, SignatureHistoryFragment.b(SignatureHistoryFragment.this));
            ((amie)localObject1).dNE();
            break;
            localObject1 = (amie)paramView.getTag();
            break label252;
            label675:
            ((amie)localObject1).Q.setTag("");
            break label413;
            label689:
            ((amie)localObject1).Q.setVisibility(8);
            break label447;
            label702:
            ((amie)localObject1).Q.setChecked(false);
            break label501;
            label714:
            ((amie)localObject1).Q.setChecked(false);
            break label501;
            label726:
            if (((amie)localObject1).cr() != null) {
              ((amie)localObject1).cr().setVisibility(8);
            }
          }
        }
        Object localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = SignatureHistoryFragment.this.getActivity().getLayoutInflater().inflate(2131559672, null);
          ((View)localObject1).setBackgroundColor(SignatureHistoryFragment.this.getResources().getColor(2131167595));
          paramView = new SignatureHistoryFragment.b();
          ((View)localObject1).setTag(paramView);
          paramView.al = ((ProgressBar)((View)localObject1).findViewById(2131377037));
          ((View)localObject1).findViewById(2131370781).setVisibility(8);
          paramView.ny = ((TextView)((View)localObject1).findViewById(2131371975));
          paramView.ny.setTextColor(SignatureHistoryFragment.this.getResources().getColor(2131165381));
        }
        if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) == 1)
        {
          SignatureHistoryFragment.a(SignatureHistoryFragment.this, 2);
          SignatureHistoryFragment.this.aV(false, false);
        }
        paramView = (SignatureHistoryFragment.b)((View)localObject1).getTag();
        Object localObject2 = new AbsListView.LayoutParams(-1, -2);
        if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) == 3)
        {
          paramView.al.setVisibility(8);
          paramView.ny.setText(acfp.m(2131714558));
          ((AbsListView.LayoutParams)localObject2).height = wja.dp2px(60.0F, SignatureHistoryFragment.this.getResources());
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramView = (View)localObject1;
        }
        else if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) == 2)
        {
          paramView.al.setVisibility(0);
          paramView.ny.setText(acfp.m(2131714544));
          ((AbsListView.LayoutParams)localObject2).height = wja.dp2px(60.0F, SignatureHistoryFragment.this.getResources());
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramView = (View)localObject1;
        }
        else
        {
          if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) == 0)
          {
            paramView.al.setVisibility(8);
            paramView.ny.setVisibility(8);
            ((AbsListView.LayoutParams)localObject2).height = (ankt.cIE / 4);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          paramView = (View)localObject1;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public boolean isEnabled(int paramInt)
    {
      return 2 != getItemViewType(paramInt);
    }
  }
  
  public static class b
  {
    public ProgressBar al;
    public TextView ny;
  }
  
  class c
    extends aclv
  {
    private c() {}
    
    public void aL(boolean paramBoolean, Object arg2)
    {
      int i = 0;
      Object localObject1;
      Object localObject3;
      if (paramBoolean)
      {
        ??? = (Bundle)???;
        paramBoolean = ???.getBoolean("firstFlag", false);
        localObject1 = ???.getString("feedid");
        boolean bool = ???.getBoolean("overFlag", true);
        localObject3 = ???.getStringArrayList("uins");
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).put(localObject1, Boolean.valueOf(bool));
        ??? = (ArrayList)SignatureHistoryFragment.b(SignatureHistoryFragment.this).get(localObject1);
        if (localObject3 != null) {}
      }
      else
      {
        return;
      }
      SignatureHistoryFragment.b(SignatureHistoryFragment.this).put(localObject1, ???);
      for (;;)
      {
        RichStatus localRichStatus;
        synchronized (SignatureHistoryFragment.b(SignatureHistoryFragment.this))
        {
          if (i >= SignatureHistoryFragment.b(SignatureHistoryFragment.this).size()) {
            break label246;
          }
          localRichStatus = ((HistorySignItem)SignatureHistoryFragment.b(SignatureHistoryFragment.this).get(i)).richStatus;
          if (!localRichStatus.feedsId.equals(localObject1)) {
            break label299;
          }
          if (paramBoolean) {
            localRichStatus.mUins = null;
          }
          if (localRichStatus.mUins != null)
          {
            localObject1 = ((ArrayList)localObject3).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label246;
            }
            localObject3 = (String)((Iterator)localObject1).next();
            if (localRichStatus.mUins.contains(localObject3)) {
              continue;
            }
            localRichStatus.mUins.add(localObject3);
          }
        }
        localRichStatus.mUins = ((List)localObject3);
        label246:
        if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null)
        {
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).removeMessages(1);
          Message localMessage = SignatureHistoryFragment.a(SignatureHistoryFragment.this).obtainMessage(1);
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).sendMessageDelayed(localMessage, 500L);
        }
        return;
        label299:
        i += 1;
      }
    }
    
    public void aO(boolean paramBoolean, Object paramObject)
    {
      int i = ((Integer)paramObject).intValue();
      if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null)
      {
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).removeMessages(3);
        paramObject = SignatureHistoryFragment.a(SignatureHistoryFragment.this).obtainMessage(3);
        paramObject.arg1 = i;
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).sendMessageDelayed(paramObject, 500L);
      }
    }
    
    public void aP(boolean paramBoolean, Object paramObject)
    {
      if ((SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) && (SignatureHistoryFragment.a(SignatureHistoryFragment.this).isShowing())) {
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).dismiss();
      }
      if (paramBoolean)
      {
        long l = ((Long)paramObject).longValue();
        if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null)
        {
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).id = l;
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).timeStamp = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
          SignatureHistoryFragment.a(SignatureHistoryFragment.this, SignatureHistoryFragment.a(SignatureHistoryFragment.this));
          SignatureHistoryFragment.a(SignatureHistoryFragment.this, null);
          if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) {
            SignatureHistoryFragment.a(SignatureHistoryFragment.this).notifyDataSetChanged();
          }
        }
        return;
      }
      paramObject = SignatureHistoryFragment.a(SignatureHistoryFragment.this).obtainMessage();
      paramObject.what = 4;
      paramObject.arg1 = 1;
      SignatureHistoryFragment.a(SignatureHistoryFragment.this).sendMessage(paramObject);
    }
    
    public void aQ(boolean paramBoolean, Object paramObject)
    {
      if ((SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) && (SignatureHistoryFragment.a(SignatureHistoryFragment.this).isShowing())) {
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).dismiss();
      }
      if (paramBoolean)
      {
        paramBoolean = SignatureHistoryFragment.a(SignatureHistoryFragment.this, SignatureHistoryFragment.a(SignatureHistoryFragment.this));
        SignatureHistoryFragment.a(SignatureHistoryFragment.this, null);
        if ((SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) && (paramBoolean)) {
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).notifyDataSetChanged();
        }
        return;
      }
      paramObject = SignatureHistoryFragment.a(SignatureHistoryFragment.this).obtainMessage();
      paramObject.what = 4;
      paramObject.arg1 = 2;
      SignatureHistoryFragment.a(SignatureHistoryFragment.this).sendMessage(paramObject);
    }
    
    public void aR(boolean paramBoolean, Object paramObject)
    {
      SignatureHistoryFragment.c(SignatureHistoryFragment.this, paramBoolean);
      int i;
      if (paramBoolean)
      {
        paramObject = (SignatureHandler.RspGetHistorySig)paramObject;
        boolean bool = paramObject.over;
        if ((SignatureHistoryFragment.this.getActivity() != null) && (SignatureHistoryFragment.this.getActivity().app != null)) {
          SignatureHistoryFragment.this.getActivity().app.setVisibilityForStatus(true, true);
        }
        if ((paramObject != null) && (paramObject.historySignItems != null))
        {
          paramObject = paramObject.historySignItems;
          if ((SignatureHistoryFragment.c(SignatureHistoryFragment.this)) && (SignatureHistoryFragment.b(SignatureHistoryFragment.this).size() > 0)) {
            SignatureHistoryFragment.b(SignatureHistoryFragment.this).clear();
          }
          if (SignatureHistoryFragment.b(SignatureHistoryFragment.this).size() > 0)
          {
            Iterator localIterator = paramObject.iterator();
            RichStatus localRichStatus1 = ((HistorySignItem)SignatureHistoryFragment.b(SignatureHistoryFragment.this).get(SignatureHistoryFragment.b(SignatureHistoryFragment.this).size() - 1)).richStatus;
            if (localRichStatus1 != null) {
              while (localIterator.hasNext())
              {
                RichStatus localRichStatus2 = ((HistorySignItem)localIterator.next()).richStatus;
                if ((localRichStatus2.time <= localRichStatus1.time) && ((localRichStatus2.time != localRichStatus1.time) || (!Arrays.equals(localRichStatus2.encode(), localRichStatus1.encode())))) {
                  break;
                }
                localIterator.remove();
              }
            }
          }
          SignatureHistoryFragment.b(SignatureHistoryFragment.this).addAll(SignatureHistoryFragment.b(SignatureHistoryFragment.this).size(), paramObject);
          paramObject = SignatureHistoryFragment.this;
          if (!bool)
          {
            i = 1;
            SignatureHistoryFragment.a(paramObject, i);
          }
        }
        else
        {
          label285:
          if (SignatureHistoryFragment.b(SignatureHistoryFragment.this).size() != 0) {
            break label367;
          }
          paramObject = SignatureHistoryFragment.this;
          if (!paramBoolean) {
            break label362;
          }
          i = 3;
          label309:
          SignatureHistoryFragment.a(paramObject, i);
        }
      }
      for (;;)
      {
        if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) {
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).notifyDataSetChanged();
        }
        return;
        i = 0;
        break;
        if (!SignatureHistoryFragment.c(SignatureHistoryFragment.this)) {
          break label285;
        }
        SignatureHistoryFragment.a(SignatureHistoryFragment.this, 3);
        break label285;
        label362:
        i = 2;
        break label309;
        label367:
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).setVisible(false, false);
      }
    }
  }
  
  class d
    extends amho
  {
    private d() {}
    
    public void d(boolean paramBoolean, List<byte[]> paramList, List<Integer> paramList1)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onDeleteStatus. isSuccess=").append(paramBoolean).append(", keyListSize=").append(paramList.size()).append(", errorCodeSize=");
        if (paramList1 != null) {
          break label231;
        }
      }
      label231:
      for (paramList1 = "null";; paramList1 = Integer.valueOf(paramList1.size()))
      {
        QLog.d("SignatureHistoryFragment", 2, paramList1);
        if ((SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) && (SignatureHistoryFragment.a(SignatureHistoryFragment.this).isShowing())) {
          SignatureHistoryFragment.a(SignatureHistoryFragment.this).dismiss();
        }
        if ((!paramBoolean) || (paramList == null)) {
          break label419;
        }
        if (SignatureHistoryFragment.this.getActivity() != null) {
          SignatureHistoryFragment.this.ba(2, 2131692514);
        }
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label244;
          }
          paramList1 = (byte[])paramList.next();
          localObject = SignatureHistoryFragment.b(SignatureHistoryFragment.this).iterator();
          if (((Iterator)localObject).hasNext())
          {
            HistorySignItem localHistorySignItem = (HistorySignItem)((Iterator)localObject).next();
            if ((localHistorySignItem == null) || (localHistorySignItem.richStatus == null) || (!localHistorySignItem.richStatus.feedsId.equals(new String(paramList1)))) {
              break;
            }
            ((Iterator)localObject).remove();
          }
        }
      }
      label244:
      if (SignatureHistoryFragment.b(SignatureHistoryFragment.this).size() == 0) {
        SignatureHistoryFragment.a(SignatureHistoryFragment.this, 3);
      }
      SignatureHistoryFragment.a(SignatureHistoryFragment.this).clear();
      SignatureHistoryFragment.b(SignatureHistoryFragment.this, false);
      SignatureHistoryFragment.a(SignatureHistoryFragment.this).setText(2131720323);
      SignatureHistoryFragment.b(SignatureHistoryFragment.this, false);
      if (SignatureHistoryFragment.a(SignatureHistoryFragment.this) != null) {
        SignatureHistoryFragment.a(SignatureHistoryFragment.this).notifyDataSetChanged();
      }
      for (;;)
      {
        if ((paramBoolean) && (SignatureHistoryFragment.this.getActivity() != null))
        {
          BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putBoolean(SignatureHistoryFragment.b(SignatureHistoryFragment.this) + "_has_history_sig_del_key", true).apply();
          if (SignatureHistoryFragment.this.a != null) {
            SignatureHistoryFragment.this.a.hP(Long.parseLong(SignatureHistoryFragment.a(SignatureHistoryFragment.this)));
          }
        }
        return;
        label419:
        if (SignatureHistoryFragment.this.getActivity() != null) {
          SignatureHistoryFragment.this.ba(1, 2131701581);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment
 * JD-Core Version:    0.7.0.1
 */