package com.tencent.mobileqq.activity;

import abdp;
import acbn;
import acfd;
import achq;
import acmf;
import aeif;
import aeoa;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anot;
import anxi;
import anxj;
import anxk;
import anxq;
import anxr;
import anxs;
import anxt;
import aqfy;
import aqgv;
import aqha;
import aqju;
import ausj;
import auss;
import auuo;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ugg;
import ugh;
import ugi;
import ugj;
import ugk;
import ugl;
import ugm;
import ugn;
import ugo;
import wja;

public class AssociatedAccountActivity
  extends SubAccountBaseActivity
  implements Observer
{
  public long Fk;
  public abdp a;
  private acmf jdField_a_of_type_Acmf = new ugj(this);
  private auuo jdField_a_of_type_Auuo = new ugl(this);
  public SubAccountInfo a;
  public PullRefreshHeader a;
  public String aKS;
  public boolean aRs;
  public boolean aRt;
  public boolean aRu;
  public boolean aRv;
  public boolean aRw = true;
  public boolean aRx = true;
  public boolean aRy;
  public boolean acq = true;
  public abdp b;
  public MqqHandler b;
  public int bDV;
  public int bDW;
  private View.OnClickListener cn = new ugh(this);
  public SlideDetectListView d;
  private acfd e = new ugi(this);
  public HorizontalListView k;
  private achq mMsgObserver = new ugk(this);
  public ArrayList<SubAccountInfo> oM;
  public ArrayList<SimpleAccount> oN;
  public ArrayList<anxi> oO;
  public ArrayList<anxi> oP;
  public View rt;
  
  public AssociatedAccountActivity()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler();
  }
  
  private void O(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanOneSubAccountMessagesUnread");
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          this.app.b().ca(paramString, 7000);
          if ((this.oN != null) && (this.oN.size() > 0))
          {
            localObject = this.oN.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
              if (paramString.equals(localSimpleAccount.getUin()))
              {
                anxk.a(this.app, localSimpleAccount);
                return;
              }
            }
          }
        } while ((this.oM == null) || (this.oM.size() <= 0));
        localObject = this.oM.iterator();
      }
    } while (!paramString.equals(((SubAccountInfo)((Iterator)localObject).next()).subuin));
    Object localObject = this.app;
    if ((paramBoolean) || (this.bDW > 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      anxk.c((QQAppInterface)localObject, paramBoolean, null, paramString);
      return;
    }
  }
  
  private void P(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnreadAsync");
    }
    ThreadManager.post(new AssociatedAccountActivity.7(this, paramBoolean, paramString), 8, null, true);
  }
  
  private void a(anxt paramanxt)
  {
    int i;
    if ((this.oO != null) && (this.oO.size() > 0))
    {
      paramanxt = this.oO.iterator();
      for (i = 0; paramanxt.hasNext(); i = 1)
      {
        label27:
        anxi localanxi = (anxi)paramanxt.next();
        if ((localanxi == null) || (localanxi.type != 6) || (localanxi.eY == null)) {
          break label27;
        }
        SimpleAccount localSimpleAccount = (SimpleAccount)localanxi.eY;
        int j = anxk.l(this.app, localSimpleAccount.getUin());
        if (localanxi.unreadNum == j) {
          break label139;
        }
        localanxi.unreadNum = j;
      }
    }
    label139:
    for (;;)
    {
      break;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateThirdQQUnread changed");
        }
        this.jdField_a_of_type_Abdp.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    if (this.rightViewText != null)
    {
      this.rightViewText.setEnabled(paramBoolean);
      this.rightViewText.setAlpha(paramFloat);
    }
  }
  
  private boolean a(String paramString, anxs paramanxs)
  {
    return (TextUtils.isEmpty(paramString)) || (isFinishing()) || (paramanxs == null);
  }
  
  private boolean a(String paramString, anxt paramanxt)
  {
    return (isFinishing()) || (paramanxt == null) || (this.app == null) || (!TextUtils.equals(paramString, this.app.getCurrentUin()));
  }
  
  private void aD(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "getDataList needChangeReaded = " + paramBoolean1 + " isRefresh = " + paramBoolean2);
    }
    if (paramBoolean2) {
      this.aRs = true;
    }
    if (this.aRt)
    {
      this.bDV = 0;
      this.aRu = false;
    }
    vO(paramBoolean1);
    if ((this.oN != null) && (this.oN.size() > 0))
    {
      if ((System.currentTimeMillis() - this.Fk >= 30000L) || (!paramBoolean2)) {
        break label220;
      }
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.3(this), 800L);
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "getDataList current-last<30000ms, startGetThirdQQUnreadNum be ignored.");
      }
    }
    for (;;)
    {
      if ((this.aRt) && (this.bDV == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.tT(0);
        this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.4(this), 800L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "getDataList mPullReqNeedBackNum = " + this.bDV);
      }
      return;
      label220:
      paramBoolean1 = anxk.j(this.app, false);
      if ((this.aRt) && (paramBoolean1)) {
        this.bDV += 1;
      }
      if (paramBoolean2) {
        this.Fk = System.currentTimeMillis();
      }
    }
  }
  
  private void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() mPullReqNeedBackNum = " + this.bDV);
    }
    this.bDV -= 1;
    if ((paramBoolean1) && (!this.aRu)) {
      this.aRu = true;
    }
    if (this.bDV <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() end");
      }
      this.aRs = false;
      this.bDV = 0;
      this.aRt = false;
      PullRefreshHeader localPullRefreshHeader = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (this.aRu) {
        i = 0;
      }
      localPullRefreshHeader.tT(i);
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.9(this), 800L);
      if (this.aRu) {
        bFZ();
      }
      this.aRu = false;
    }
  }
  
  private void bFW()
  {
    this.bDW = 0;
    anxr localanxr = (anxr)this.app.getManager(61);
    Iterator localIterator = this.oM.iterator();
    while (localIterator.hasNext()) {
      if (localanxr.eA(((SubAccountInfo)localIterator.next()).subuin) > 0) {
        this.bDW += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "checkNeed2ConfirmMsgNum mNeed2ConfirmMsgNum = " + this.bDW);
    }
  }
  
  private void bFp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail");
    }
    if (TextUtils.isEmpty(this.aKS)) {
      return;
    }
    aff();
    aqju localaqju = aqha.a(this, 230).setTitle(getString(2131720549)).setMessage(getString(2131720548));
    localaqju.setPositiveButton(2131691970, new ugn(this));
    localaqju.setCancelable(true);
    localaqju.show();
  }
  
  private void bGa()
  {
    if ((this.rt == null) || (this.leftView == null) || (this.jdField_a_of_type_Abdp == null) || (this.jdField_b_of_type_Abdp == null)) {
      return;
    }
    if (this.oN.size() > 0)
    {
      this.rt.setVisibility(0);
      this.jdField_a_of_type_Abdp.notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_b_of_type_Abdp.notifyDataSetChanged();
      if (this.leftView != null) {
        this.leftView.setText("");
      }
      bFW();
      return;
      this.rt.setVisibility(8);
    }
  }
  
  private void bGc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "gotoManageAssociatedAccount");
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, AssociatedAccountManageActivity.class);
    if (this.aRy) {
      localIntent.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    }
    startActivityForResult(localIntent, 1012);
    overridePendingTransition(2130772009, 2130772002);
  }
  
  private void bGd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount currentUin=" + this.app.getCurrentUin());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (anxr)this.app.getManager(61);
    if (localObject2 != null) {
      ((List)localObject1).addAll(((anxr)localObject2).dK());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount binded = " + ((List)localObject1).size());
    }
    Intent localIntent;
    if (((List)localObject1).size() < 2)
    {
      localIntent = new Intent();
      localObject2 = new ArrayList();
      Object localObject3 = this.app.getApplication().getAllAccounts();
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject2).addAll((Collection)localObject3);
      }
      localObject2 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (SimpleAccount)((Iterator)localObject2).next();
      } while ((localObject3 == null) || (TextUtils.equals(((SimpleAccount)localObject3).getUin(), this.app.getCurrentUin())) || (((List)localObject1).contains(((SimpleAccount)localObject3).getUin())));
    }
    for (localObject1 = SubAccountBindActivity.class;; localObject1 = SubLoginActivity.class)
    {
      localIntent.setClass(this, (Class)localObject1);
      localObject2 = this.aOa;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = AssociatedAccountActivity.class.getSimpleName();
      }
      localIntent.putExtra("fromWhere", (String)localObject1);
      startActivity(localIntent);
      return;
      anxk.a(this.app, this);
      return;
    }
  }
  
  private void iA(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchAccount to Uin = " + paramString);
    }
    if (paramString == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = this.app.getApplication().getAllAccounts();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    } while (((List)localObject1).size() < 1);
    Object localObject2 = ((List)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SimpleAccount)((Iterator)localObject2).next();
    } while (!((SimpleAccount)localObject1).getUin().equalsIgnoreCase(paramString));
    for (;;)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "switchAccount change ");
        }
        this.aKS = paramString;
        this.aRv = true;
        sendBroadcast(new Intent("before_account_change"));
        this.app.switchAccount((SimpleAccount)localObject1, null);
        anxj.j(this.app, this);
        aqfy.edD();
        return;
      }
      ath();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AssociatedAccountActivity", 2, "switchAccount no change ");
      return;
      localObject1 = null;
    }
  }
  
  private void ii()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.setMainTitle(2131721527);
    localausj.addButton(2131721079, 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new ugm(this, localausj));
    localausj.show();
  }
  
  private void initData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initData");
    }
    this.oP = new ArrayList();
    this.jdField_b_of_type_Abdp = new abdp(this.app, this.oP, this.cn);
    this.d.setAdapter(this.jdField_b_of_type_Abdp);
    this.oO = new ArrayList();
    this.jdField_a_of_type_Abdp = new abdp(this.app, this.oO, this.cn);
    this.k.setAdapter(this.jdField_a_of_type_Abdp);
    bFX();
    bFZ();
  }
  
  private void initUI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initUI");
    }
    setTitle(2131720509);
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131720513);
    localTextView.setOnClickListener(new ugg(this));
    this.d = ((SlideDetectListView)findViewById(2131378926));
    this.rt = findViewById(2131379613);
    this.k = ((HorizontalListView)findViewById(2131379612));
    this.k.setDividerWidth(wja.dp2px(22.0F, getResources()));
    if (AppSetting.enableTalkBack) {
      localTextView.setContentDescription(getText(2131720513));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559847, this.d, false));
    this.d.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.d.setOverScrollListener(this.jdField_a_of_type_Auuo);
    this.d.setBackgroundResource(2130838900);
  }
  
  private void vN(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "refreshAllData direct=" + paramBoolean);
    }
    if (isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      bFX();
      bFZ();
      return;
    }
    this.jdField_b_of_type_MqqOsMqqHandler.post(new AssociatedAccountActivity.2(this));
  }
  
  private void vQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "showSettingDialog underTwo = " + paramBoolean);
    }
    ausj localausj = (ausj)auss.a(this, null);
    if (paramBoolean) {
      localausj.addButton(getResources().getString(2131720510), 5);
    }
    localausj.addButton(getResources().getString(2131721526), 5);
    localausj.addButton(getResources().getString(2131720514), 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new ugo(this, paramBoolean, localausj));
    localausj.show();
  }
  
  public boolean OG()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.oP != null)
    {
      bool1 = bool2;
      if (this.oP.size() > 0)
      {
        bool1 = bool2;
        if (this.oM != null)
        {
          bool1 = bool2;
          if (this.oM.size() > 0)
          {
            anxr localanxr = null;
            i = 0;
            bool1 = false;
            if (i < this.oP.size())
            {
              Object localObject = (anxi)this.oP.get(i);
              if ((((anxi)localObject).type == 2) && (((anxi)localObject).eY != null) && ((((anxi)localObject).eY instanceof ArrayList)))
              {
                if (localanxr != null) {
                  break label268;
                }
                localanxr = (anxr)this.app.getManager(61);
                label127:
                bool2 = bool1;
                if (localanxr == null) {
                  break label274;
                }
                localObject = ((ArrayList)((anxi)localObject).eY).iterator();
                bool2 = bool1;
                if (!((Iterator)localObject).hasNext()) {
                  break label274;
                }
                anxi localanxi = (anxi)((Iterator)localObject).next();
                int j = localanxr.ey(((SubAccountInfo)localanxi.eY).subuin);
                if (((j != 1) || (localanxi.status == 0)) && ((j == 1) || (localanxi.status != 0))) {
                  break label271;
                }
                if (j == 1) {}
                for (localanxi.status = 0;; localanxi.status = 1)
                {
                  bool1 = true;
                  label229:
                  break;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((bool1) && (this.jdField_b_of_type_Abdp != null)) {
        this.jdField_b_of_type_Abdp.notifyDataSetChanged();
      }
      return bool1;
      label268:
      break label127;
      label271:
      break label229;
      label274:
      bool1 = bool2;
    }
  }
  
  public void bFX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadAccountList");
    }
    if (this.oM == null)
    {
      this.oM = new ArrayList();
      Object localObject = (anxr)this.app.getManager(61);
      this.oM.addAll(((anxr)localObject).dL());
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mSubAccountList.size() = " + this.oM.size());
      }
      localObject = this.app.getApplication().getAllAccounts();
      fy((List)localObject);
      if ((this.oM.size() <= 0) && (this.oN.size() <= 0) && ((this.aRx) || (localObject == null) || (((List)localObject).size() <= 1))) {
        break label174;
      }
      a(true, 1.0F);
    }
    for (;;)
    {
      bFY();
      return;
      this.oM.clear();
      break;
      label174:
      a(false, 0.5F);
    }
  }
  
  public void bFY()
  {
    Object localObject = getIntent();
    String str;
    if (localObject != null)
    {
      str = ((Intent)localObject).getStringExtra("subAccount");
      ((Intent)localObject).removeExtra("subAccount");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin;
      }
      for (;;)
      {
        if (this.oM.size() > 0) {
          if (!TextUtils.isEmpty(str))
          {
            localObject = this.oM.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject).next();
              if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(str))) {
                this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = localSubAccountInfo;
              }
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountInfo)this.oM.get(0));
          }
          return;
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
          return;
        }
      }
      str = null;
    }
  }
  
  public void bFZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadItemDataList");
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    boolean bool1;
    ArrayList localArrayList2;
    int i;
    SubAccountInfo localSubAccountInfo;
    boolean bool2;
    anxi localanxi;
    Object localObject2;
    if (this.oM.size() > 0)
    {
      localObject3 = (anxr)this.app.getManager(61);
      int m = this.oM.size();
      localObject4 = new ArrayList();
      localObject1 = this.app.getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject1);
      }
      bool1 = false;
      localArrayList2 = new ArrayList(m);
      i = 0;
      for (;;)
      {
        if (i < m)
        {
          localSubAccountInfo = (SubAccountInfo)this.oM.get(i);
          bool2 = bool1;
          if (localSubAccountInfo != null)
          {
            if (TextUtils.isEmpty(localSubAccountInfo.subuin)) {
              bool2 = bool1;
            }
          }
          else
          {
            i += 1;
            bool1 = bool2;
            continue;
          }
          localanxi = new anxi();
          localanxi.type = 2;
          localObject2 = aqgv.c(this.app, localSubAccountInfo.subuin, true);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localSubAccountInfo.subuin;
          }
          localanxi.bQA = ((String)localObject1);
          localanxi.content = localSubAccountInfo.subuin;
          localanxi.eY = localSubAccountInfo;
          localanxi.extraInfo = "";
          if (localSubAccountInfo.subuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))
          {
            localanxi.cKq = true;
            label275:
            if (localSubAccountInfo.status == 1) {
              break label448;
            }
            localanxi.status = 1;
            localObject1 = ((List)localObject4).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (SimpleAccount)((Iterator)localObject1).next();
            } while ((localObject2 == null) || (!TextUtils.equals(localSubAccountInfo.subuin, ((SimpleAccount)localObject2).getUin())));
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localanxi.isLogined = true;
        label354:
        localanxi.dNg = 0;
        if (AppSetting.enableTalkBack) {
          localanxi.ciA = getString(2131720523, new Object[] { localanxi.bQA });
        }
        if (!localSubAccountInfo.subuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)) {
          break label905;
        }
        bool1 = localanxi.isLogined;
      }
      label905:
      for (;;)
      {
        localArrayList2.add(localanxi);
        bool2 = bool1;
        break;
        localanxi.cKq = false;
        break label275;
        localanxi.isLogined = false;
        break label354;
        label448:
        localanxi.status = 0;
        break label354;
        localObject1 = new anxi();
        ((anxi)localObject1).type = 2;
        ((anxi)localObject1).eY = localArrayList2;
        ((anxi)localObject1).extraInfo = "";
        localArrayList1.add(localObject1);
        localObject1 = ((anxr)localObject3).aQ(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size();
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount msg msgSize = " + j);
          }
          if (j > 0)
          {
            localObject2 = anxk.b(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
            i = 0;
            if (i < j)
            {
              localObject3 = (SubAccountMessage)((List)localObject1).get(i);
              localObject4 = new anxi();
              ((anxi)localObject4).type = 3;
              if (i == j - 1) {}
              for (((anxi)localObject4).dNg = 2;; ((anxi)localObject4).dNg = 1)
              {
                if ((localObject2 != null) && (((ArrayList)localObject2).contains(((SubAccountMessage)localObject3).senderuin))) {
                  ((anxi)localObject4).dNh = 2;
                }
                if (i == 0) {
                  ((anxi)localObject4).cKq = true;
                }
                ((anxi)localObject4).eY = localObject3;
                localArrayList1.add(localObject4);
                i += 1;
                break;
              }
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount no msg");
          }
          localObject1 = new anxi();
          ((anxi)localObject1).type = 7;
          ((anxi)localObject1).cKq = true;
          ((anxi)localObject1).dNg = 3;
          ((anxi)localObject1).eY = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
          ((anxi)localObject1).isLogined = bool1;
          localArrayList1.add(localObject1);
        }
        for (;;)
        {
          this.oP.clear();
          this.oP.addAll(localArrayList1);
          bGb();
          bGa();
          return;
          localObject1 = new anxi();
          ((anxi)localObject1).type = 4;
          ((anxi)localObject1).dNg = 3;
          ((anxi)localObject1).bQA = getResources().getString(2131720510);
          ((anxi)localObject1).content = getResources().getString(2131720511);
          if (AppSetting.enableTalkBack)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((anxi)localObject1).bQA).append(",");
            ((StringBuilder)localObject2).append(((anxi)localObject1).content);
            ((anxi)localObject1).ciA = ((StringBuilder)localObject2).toString();
          }
          localArrayList1.add(localObject1);
        }
      }
    }
  }
  
  public void bGb()
  {
    if (this.oN.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(this.oN.size());
      int j = this.oN.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (SimpleAccount)this.oN.get(i);
        anxi localanxi = new anxi();
        localanxi.type = 6;
        localanxi.bQA = anxk.a(this.app, (SimpleAccount)localObject);
        localanxi.unreadNum = anxk.l(this.app, ((SimpleAccount)localObject).getUin());
        localanxi.eY = localObject;
        if (AppSetting.enableTalkBack)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localanxi.bQA);
          localanxi.ciA = ((StringBuilder)localObject).toString();
        }
        localArrayList.add(localanxi);
        i += 1;
      }
      this.oO.clear();
      this.oO.addAll(localArrayList);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode=" + paramInt2);
    }
    switch (paramInt1)
    {
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      finish();
      return;
      bool = anxk.bH(this.app);
    } while ((paramInt2 != -1) && (this.aRx == bool));
    this.aRx = bool;
    vN(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563134);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnCreate");
    }
    this.aRw = anxk.l(this.app, true);
    this.aRx = anxk.bH(this.app);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.aRy = true;
    }
    initUI();
    initData();
    addObserver(this.e);
    addObserver(this.jdField_a_of_type_Acmf);
    addObserver(this.mMsgObserver);
    this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
    this.app.b().addObserver(this);
    sendBroadcast(new Intent("before_account_change"));
    anxj.ea(this.app);
    anxj.dZ(this.app);
    anxj.eb(this.app);
    if (QM()) {
      aD(false, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.S(0L);
    paramBundle = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.aRy) {}
    for (int i = 1;; i = 0)
    {
      anot.a(paramBundle, "dc00898", "", "", "0X800AC3B", "0X800AC3B", 0, 0, i + "", "", "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnDestroy");
    }
    removeObserver(this.e);
    removeObserver(this.jdField_a_of_type_Acmf);
    removeObserver(this.mMsgObserver);
    this.app.removeHandler(getClass());
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    ath();
    if (this.d != null)
    {
      this.d.setOverscrollHeader(null);
      this.d.setOverScrollListener(null);
      this.d.setAdapter(null);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnPause");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnResume");
    }
    ath();
    if (!this.acq) {
      OG();
    }
    this.acq = false;
  }
  
  public void fy(List<SimpleAccount> paramList)
  {
    label157:
    SimpleAccount localSimpleAccount;
    int i;
    if (this.oN == null)
    {
      this.oN = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, new Object[] { "loadAccountList mThirdAccountList.mIsDisplayThirdFuc = ", Boolean.valueOf(this.aRw), " mIsFromAccountManage=", Boolean.valueOf(this.aRy), " mIsDisplayThirdQQChecked=", Boolean.valueOf(this.aRx) });
      }
      if ((!this.aRw) || (this.aRy) || (!this.aRx)) {
        break label318;
      }
      Object localObject = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        ((List)localObject).addAll(paramList);
      }
      if (((List)localObject).size() <= 0) {
        break label280;
      }
      paramList = this.app.getAccount();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
          if ((localSimpleAccount != null) && (!paramList.equals(localSimpleAccount.getUin())))
          {
            Iterator localIterator = this.oM.iterator();
            i = 0;
            label205:
            if (localIterator.hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                break label319;
              }
              i = 1;
            }
          }
        }
      }
    }
    label280:
    label318:
    label319:
    for (;;)
    {
      break label205;
      this.oN.clear();
      break;
      if (i != 0) {
        break label157;
      }
      this.oN.add(localSimpleAccount);
      break label157;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mThirdAccountList.size() = " + this.oN.size());
      }
      return;
    }
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccountChanged() mClick2Switch=" + this.aRv);
    }
    super.onAccountChanged();
    removeObserver(this.e);
    removeObserver(this.mMsgObserver);
    removeObserver(this.jdField_a_of_type_Acmf);
    if ((this.app != null) && (this.app.b() != null)) {
      this.app.b().deleteObserver(this);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if ((!this.aRv) || (this.app != null))
    {
      this.app.removeHandler(getClass());
      this.app.getApplication().refreAccountList();
    }
    anxj.k(this.app, this);
    ath();
    this.aKS = null;
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  public void onAccoutChangeFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccoutChangeFailed");
    }
    ath();
    bFp();
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onBackEvent");
    }
    if ((this.oN != null) && (this.oN.size() > 0) && (!this.aRy)) {
      anxk.bG(this.app);
    }
    this.app.b().ca(acbn.bku, 7000);
    if (!this.aRy)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void p(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (anxr)paramQQAppInterface.getManager(61);
    Iterator localIterator = this.oM.iterator();
    while (localIterator.hasNext()) {
      paramQQAppInterface.RA(((SubAccountInfo)localIterator.next()).subuin);
    }
    vP(true);
    wA(paramString);
    bFZ();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "update()");
    }
    if ((paramObject instanceof MessageRecord)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!acbn.bku.equals(paramObservable[0])));
    runOnUiThread(new AssociatedAccountActivity.16(this));
  }
  
  public void vO(boolean paramBoolean)
  {
    anxr localanxr = (anxr)this.app.getManager(61);
    Iterator localIterator = this.oM.iterator();
    while (localIterator.hasNext())
    {
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
      if (localanxr != null)
      {
        if (paramBoolean) {
          localanxr.Ry(localSubAccountInfo.subuin);
        }
        localanxr.RD(localSubAccountInfo.subuin);
      }
      anxk.d(this.app, localSubAccountInfo.subuin, false);
      if (this.aRt) {
        this.bDV += 1;
      }
      aeoa localaeoa = (aeoa)aeif.a().o(607);
      if ((localaeoa != null) && (!localaeoa.bVj)) {
        anxq.a(this.app, localSubAccountInfo.subuin);
      }
    }
  }
  
  public void vP(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnread");
    }
    if (((this.oN != null) && (this.oN.size() > 0)) || (this.aRy)) {
      anxk.bG(this.app);
    }
    QQAppInterface localQQAppInterface;
    if ((this.oM != null) && (this.oM.size() > 0))
    {
      this.app.b().ca(acbn.bku, 7000);
      localQQAppInterface = this.app;
      if ((!paramBoolean) && (this.bDW <= 0)) {
        break label105;
      }
    }
    label105:
    for (paramBoolean = true;; paramBoolean = false)
    {
      anxk.d(localQQAppInterface, paramBoolean, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity
 * JD-Core Version:    0.7.0.1
 */