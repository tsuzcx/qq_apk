package com.tencent.mobileqq.activity.contact.addcontact;

import abex;
import abex.c;
import abfm;
import accv;
import accv.b;
import accv.c;
import acfp;
import acgr;
import acgs;
import achg;
import afck;
import afsi;
import afsi.a;
import ahyj;
import ajrb;
import amxk;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import anot;
import anwa;
import aqdf;
import aqgz;
import aqiw;
import aqmj;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import wja;
import ync;
import ynd;
import yne;
import ynf;
import yng;
import yni;
import ynj;
import ynk;
import ynl;
import ypj;
import yuw;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String aZb = acfp.m(2131702042);
  private long Ku;
  private long Kv;
  abex.c jdField_a_of_type_Abex$c = new ynf(this);
  private abex jdField_a_of_type_Abex;
  accv.b jdField_a_of_type_Accv$b = new ynk(this);
  accv.c jdField_a_of_type_Accv$c = new ynl(this);
  acgs jdField_a_of_type_Acgs = new ynd(this);
  private aqdf jdField_a_of_type_Aqdf;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  abex.c jdField_b_of_type_Abex$c = new yng(this);
  abfm jdField_b_of_type_Abfm;
  FormMutiItem jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
  SwipListView.a jdField_b_of_type_ComTencentWidgetSwipListView$a = new ynj(this);
  boolean bnF;
  boolean bnG;
  public boolean bnH = false;
  public boolean bnI = false;
  private boolean bnJ;
  public accv c;
  FormMutiItem c;
  private String[] cQ;
  public String[] cR = null;
  int cab = 0;
  FormMutiItem d;
  FormMutiItem e;
  private Runnable eI = new AddContactsView.13(this);
  FormMutiItem f;
  FormMutiItem g;
  public SwipListView g;
  public PopupWindow h;
  FormMutiItem h;
  FormMutiItem i;
  RelativeLayout ik;
  public RelativeLayout il;
  View.OnTouchListener jdField_j_of_type_AndroidViewView$OnTouchListener = new ync(this);
  private ClearableEditText jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText;
  public FormMutiItem j;
  public HorizontalListView o;
  
  public AddContactsView(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  private void Am(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hideFace2FaceAddFriendGuideTips, save=").append(paramBoolean).append(" isShowing:");
      if (this.jdField_h_of_type_AndroidWidgetPopupWindow != null) {
        break label116;
      }
    }
    label116:
    for (boolean bool = false;; bool = this.jdField_h_of_type_AndroidWidgetPopupWindow.isShowing())
    {
      QLog.d("AddContactsView", 2, bool);
      if (this.jdField_h_of_type_AndroidWidgetPopupWindow != null)
      {
        if ((this.jdField_h_of_type_AndroidWidgetPopupWindow.isShowing()) && (paramBoolean))
        {
          this.bnJ = false;
          ypj.bi(this.app);
        }
        this.jdField_h_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_h_of_type_AndroidWidgetPopupWindow = null;
      }
      if (this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.removeCallbacks(this.eI);
      }
      return;
    }
  }
  
  private void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.mContext.getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = new FormMutiWithAvatarItem(this.mContext);; localObject = new FormMutiItem(this.mContext))
    {
      ((FormMutiItem)localObject).setId(paramInt1);
      ((FormMutiItem)localObject).setClickable(true);
      ((FormMutiItem)localObject).setFocusable(true);
      ((FormMutiItem)localObject).setBgType(3);
      ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131167311));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, wja.dp2px(56.0F, getResources()));
      if (paramInt3 == 0) {
        localLayoutParams.topMargin = ((int)(12.0F * aqgz.getDesity()));
      }
      ((FormMutiItem)localObject).setLayoutParams(localLayoutParams);
      ((FormMutiItem)localObject).setBackgroundResource(2130839637);
      return localObject;
    }
  }
  
  private void cjQ()
  {
    achg localachg = (achg)this.app.getManager(159);
    this.bnF = true;
    if ((localachg.kl("sp_mayknow_entry_list_add")) && (!anwa.aze())) {}
    for (boolean bool = true;; bool = false)
    {
      this.bnG = bool;
      return;
    }
  }
  
  private void cjR()
  {
    this.bnH = this.jdField_c_of_type_Accv.ZK();
    String[] arrayOfString = this.jdField_c_of_type_Accv.H();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initSearchConditions|autoReqLocation = " + this.bnH + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.bnH) || ("0".equals(arrayOfString[0])))
    {
      if ((afck.aiI()) || (!aqiw.isNetSupport(this.mContext))) {
        break label176;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getApp().addObserver(this.jdField_a_of_type_Acgs);
      ((acgr)this.app.getBusinessHandler(3)).cJs();
    }
    for (;;)
    {
      if (this.bnH)
      {
        this.jdField_c_of_type_Accv.addListener(this.jdField_a_of_type_Accv$b);
        this.jdField_c_of_type_Accv.a(this.jdField_a_of_type_Accv$c);
      }
      return;
      label176:
      this.cR = new String[] { "-1", "-1", "-1", "-1" };
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
      }
    }
  }
  
  private void cjT()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", new Object[] { Long.valueOf(this.Ku), Long.valueOf(this.Kv) }));
    }
    Object localObject1;
    Object localObject2;
    if ((this.Ku <= 0L) || ((this.Ku > 0L) && (l - this.Ku > this.Kv)))
    {
      boolean bool = ahyj.isProcessExist("com.tencent.mobileqq:tool");
      this.Ku = l;
      if (!bool) {
        break label214;
      }
      l = 1000L;
      this.Kv = l;
      localObject1 = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
      localObject2 = aqmj.d(this.app.getApp(), this.app.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label221;
      }
    }
    for (;;)
    {
      localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.mContext.startActivity((Intent)localObject2);
      anot.a(this.app, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
      return;
      label214:
      l = 2000L;
      break;
      label221:
      localObject1 = localObject2;
    }
  }
  
  private void cjU()
  {
    Intent localIntent;
    if (!ajrb.nF(this.app.getAccount()))
    {
      localIntent = new Intent(this.mContext, NearbyActivity.class);
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.mContext.getResources().getText(2131721053));
      NearbyFakeActivity.S(this.mContext, localIntent);
    }
    for (;;)
    {
      anot.c(this.app, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
      return;
      localIntent = new Intent(this.mContext, NearbyGuideActivity.class);
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.mContext.getResources().getText(2131721053));
      this.mContext.startActivity(localIntent);
    }
  }
  
  private void cjV()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(null);
    }
    this.mContext.startActivity(new Intent(this.mContext, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.bnH));
    anot.a(this.app, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
  }
  
  private void cjW()
  {
    int k = ((PhoneContactManagerImp)this.app.getManager(11)).xy();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onClick ADD_PHONE_CONTACTS_ID selfBindState=" + k);
    }
    Object localObject;
    if ((k == 2) || (k == 4) || (k == 9) || (k == 8))
    {
      localObject = new AddContactsView.7(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this.mContext, 2);
      yuw.a(this.mContext, this.app, (Runnable)localObject, localDenyRunnable);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
      anot.a(this.app, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
      if ((k == 1) || (k == 5)) {
        anot.a(this.app, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
      }
      return;
      if ((k == 3) || (k == 6) || (k == 7) || (k == 1) || (k == 5) || (k == 0))
      {
        localObject = new Intent(this.mContext, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("kSrouce", 14);
        this.mContext.startActivity((Intent)localObject);
      }
    }
  }
  
  private void cjY()
  {
    this.cQ = "1365".split("\\|");
  }
  
  private void cjZ()
  {
    ThreadManager.getSubThreadHandler().post(new AddContactsView.12(this));
  }
  
  private void cka()
  {
    if ((this.bnJ) && (this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem != null) && (this.jdField_h_of_type_AndroidWidgetPopupWindow == null))
    {
      this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.removeCallbacks(this.eI);
      this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.postDelayed(this.eI, 100L);
    }
  }
  
  private void createConfigView()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366484);
    if ((this.cQ != null) && (this.cQ.length > 0))
    {
      int k = 0;
      while (k < this.cQ.length)
      {
        int m = 0;
        if (m < this.cQ[k].length())
        {
          switch (this.cQ[k].charAt(m))
          {
          }
          for (;;)
          {
            m += 1;
            break;
            if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
            {
              this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, k, m);
              localLinearLayout.addView(this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem);
              continue;
              if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
              {
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, k, m);
                localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem);
                continue;
                if (this.f == null)
                {
                  this.f = a(1006, k, m);
                  localLinearLayout.addView(this.f);
                  continue;
                  if ((this.d == null) && (!anwa.aze()))
                  {
                    this.d = a(1003, k, m);
                    localLinearLayout.addView(this.d);
                    continue;
                    if (this.e == null)
                    {
                      this.e = a(1004, k, m);
                      localLinearLayout.addView(this.e);
                      continue;
                      if (this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                      {
                        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1010, k, m);
                        localLinearLayout.addView(this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem);
                        ypj.u("0X800AB5C", "", "", "");
                        continue;
                        if ((this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!anwa.aze()))
                        {
                          this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1007, k, m);
                          localLinearLayout.addView(this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem);
                          anot.a(this.app, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
                          continue;
                          if (this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                          {
                            this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1008, k, m);
                            localLinearLayout.addView(this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem);
                            continue;
                            if ((this.i == null) && (!anwa.aze()))
                            {
                              this.i = a(1009, k, m, true);
                              localLinearLayout.addView(this.i);
                              anot.a(this.app, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        k += 1;
      }
    }
  }
  
  private void initData()
  {
    cjR();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity().getIntent();
    achg localachg = (achg)this.app.getManager(159);
    if (localachg != null) {
      localachg.iu(5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initData  addPageDisplayAsVerticalListItem = " + this.bnF + "shouldShowMayknowEnty=" + this.bnG);
    }
    ArrayList localArrayList = new ArrayList();
    if (localachg != null) {
      localArrayList = localachg.cw();
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        cjS();
      }
      while (this.bnF)
      {
        this.jdField_b_of_type_Abfm = new abfm(this.mContext, this.app, this.jdField_g_of_type_ComTencentWidgetSwipListView, localIntent.getIntExtra("EntranceId", 0), this.jdField_b_of_type_Abex$c);
        this.jdField_b_of_type_Abfm.GZ(21);
        int k = this.mContext.getResources().getDimensionPixelSize(2131297808);
        this.jdField_b_of_type_Abfm.GY(k);
        this.jdField_b_of_type_Abfm.gJ(localArrayList);
        this.jdField_g_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_b_of_type_ComTencentWidgetSwipListView$a);
        this.jdField_g_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new yni(this));
        return;
        this.il.setVisibility(8);
        this.o.setVisibility(8);
        this.jdField_g_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      }
      this.jdField_a_of_type_Abex = new abex(this.mContext, this.app, this.o, this.jdField_a_of_type_Abex$c, 21, localIntent.getIntExtra("EntranceId", 0));
      return;
    }
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131362196));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new yne(this));
    this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131366535));
    this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131298644), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130851339);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      this.jdField_j_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(acfp.m(2131702044));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130845863));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.mContext.getString(2131689882));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.showArrow(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130845620));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689878));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.showArrow(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(acfp.m(2131702040));
      }
    }
    if (this.d != null)
    {
      this.d.setLeftIcon(getResources().getDrawable(2130845619));
      this.d.setFirstLineText(acfp.m(2131702045));
      this.d.setSecondLineVisible(false);
      this.d.showArrow(true);
      this.d.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.d.setContentDescription(acfp.m(2131702041));
      }
    }
    this.il = ((RelativeLayout)findViewById(2131376937));
    this.ik = ((RelativeLayout)findViewById(2131362224));
    this.ik.setOnClickListener(this);
    this.ik.setOnTouchListener(this.jdField_j_of_type_AndroidViewView$OnTouchListener);
    this.o = ((HorizontalListView)findViewById(2131371197));
    this.o.setDividerWidth(wja.dp2px(9.0F, getResources()));
    this.o.setAdapter(this.jdField_a_of_type_Abex);
    this.jdField_g_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376928));
    this.jdField_g_of_type_ComTencentWidgetSwipListView.setFocusable(false);
    this.jdField_g_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if (this.e != null)
    {
      this.e.setLeftIcon(getResources().getDrawable(2130837701));
      this.e.setFirstLineText(getResources().getString(2131689888));
      this.e.setSecondLineVisible(false);
      this.e.showArrow(true);
      this.e.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.e.setContentDescription(getResources().getString(2131689889));
      }
    }
    if (this.f != null)
    {
      this.f.setLeftIcon(getResources().getDrawable(2130837698));
      this.f.setFirstLineText(getResources().getString(2131689923));
      this.f.setSecondLineVisible(false);
      this.f.showArrow(true);
      this.f.setOnClickListener(this);
    }
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130846028));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.showArrow(true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      localObject = ((afsi)this.app.getManager(264)).a();
      if (localObject == null) {
        break label989;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(((afsi.a)localObject).bFk);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
      {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130846223));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem.showArrow(true);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
        String str = getResources().getString(2131717048);
        localObject = getResources().getString(2131717047);
        str = aqmj.d(this.app.getApp(), this.app.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
        aqmj.d(this.app.getApp(), this.app.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(str);
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      }
      if (this.i != null)
      {
        this.i.setLeftIcon(getResources().getDrawable(2130837699));
        this.i.showArrow(true);
        this.i.setOnClickListener(this);
        this.jdField_a_of_type_Aqdf = new aqdf(this.mContext, this.app);
        this.i.setFirstLineText(2131689884);
        this.i.setSecondLineVisible(false);
      }
      if (this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
      {
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130840357));
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.showArrow(true);
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(2131693369);
        this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      }
      return;
      label989:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(2131701111);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
    }
  }
  
  public void cjS()
  {
    if (this.bnG) {
      if (this.bnF)
      {
        this.jdField_g_of_type_ComTencentWidgetSwipListView.setVisibility(0);
        this.o.setVisibility(8);
        this.ik.setVisibility(8);
        this.il.setVisibility(0);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "updateMayknowRecommendListStyle,addPageDisplayAsVerticalListItem = " + this.bnF + " shouldShowMayknowEnty=" + this.bnG);
      }
      return;
      this.jdField_g_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      this.o.setVisibility(0);
      this.ik.setVisibility(0);
      this.il.setVisibility(0);
      continue;
      this.jdField_g_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      this.o.setVisibility(8);
      this.ik.setVisibility(8);
      this.il.setVisibility(8);
    }
  }
  
  public void cjX()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("fillSearchConditions | autoReqLocation = ").append(this.bnH).append(" | code one = ");
      if ((this.cR == null) || (this.cR.length != 4)) {
        break label94;
      }
    }
    label94:
    for (Object localObject = this.cR[0];; localObject = Integer.valueOf(-1000))
    {
      QLog.d("AddContactsView", 2, localObject);
      ThreadManager.postImmediately(new AddContactsView.10(this, new StringBuilder(aZb)), null, true);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000000) && (QLog.isColorLevel())) {
      QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 14);
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onClick id=" + paramView.getId());
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.cjO();
      amxk.d("add_page", "search", "active_frame", 1, 0, new String[] { "" });
      anot.a(this.app, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      continue;
      cjV();
      continue;
      cjW();
      continue;
      cjU();
      continue;
      Intent localIntent = new Intent(this.mContext, CreateFaceToFaceDiscussionActivity.class);
      localIntent.putExtra("create_source", 7);
      this.mContext.startActivity(localIntent);
      anot.a(this.app, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
      continue;
      ExtendFriendPublicFragmentActivity.ao(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity(), 1);
      anot.a(this.app, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
      continue;
      cjT();
      continue;
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity().getIntent().getIntExtra("EntranceId", 0);
      switch (k)
      {
      }
      for (;;)
      {
        localIntent = new Intent(this.mContext, RecommendFriendActivity.class);
        localIntent.putExtra("EntranceId", k);
        this.mContext.startActivity(localIntent);
        break;
        anot.a(this.app, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
      }
      localIntent = new Intent(this.mContext, ScannerActivity.class);
      localIntent.putExtra("from", "AddContactsActivity");
      localIntent.setFlags(67108864);
      localIntent.putExtra("QRDecode", true);
      this.mContext.startActivity(localIntent);
      anot.a(this.app, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
      continue;
      localIntent = new Intent();
      PublicFragmentActivity.start(this.mContext, localIntent, ConnectionsExplorationFragment.class);
      anot.a(this.app, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
      continue;
      Am(true);
      Face2FaceAddContactFragment.s(this.mContext, new Intent());
      ypj.u("0X800AB5E", "", "", "");
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    super.setContentView(2131558528);
    this.jdField_c_of_type_Accv = ((accv)this.app.getManager(59));
    cjQ();
    cjY();
    createConfigView();
    initView();
    initData();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Am(false);
    this.jdField_c_of_type_Accv.aW(this);
    this.jdField_c_of_type_Accv.removeListener(this.jdField_a_of_type_Accv$b);
    this.jdField_c_of_type_Accv.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getApp().removeObserver(this.jdField_a_of_type_Acgs);
    if (this.jdField_a_of_type_Abex != null) {
      this.jdField_a_of_type_Abex.destroy();
    }
    if (this.jdField_b_of_type_Abfm != null) {
      this.jdField_b_of_type_Abfm.destroy();
    }
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Abex != null)
    {
      this.jdField_a_of_type_Abex.cli();
      this.jdField_a_of_type_Abex.onPause();
    }
    if (this.jdField_b_of_type_Abfm != null) {
      this.jdField_b_of_type_Abfm.cli();
    }
    if ((this.jdField_g_of_type_ComTencentWidgetSwipListView != null) && (this.jdField_g_of_type_ComTencentWidgetSwipListView.getVisibility() == 0)) {
      this.jdField_g_of_type_ComTencentWidgetSwipListView.AP();
    }
    Am(false);
  }
  
  public void onResume()
  {
    super.onResume();
    cjX();
    this.jdField_c_of_type_Accv.aV(this);
    if (this.jdField_b_of_type_Abfm != null) {
      this.jdField_b_of_type_Abfm.onResume();
    }
    if (this.jdField_a_of_type_Abex != null) {
      this.jdField_a_of_type_Abex.onResume();
    }
    if (this.i != null) {
      cjZ();
    }
    int k = this.mContext.getIntent().getIntExtra("entrence_data_report", 0);
    anot.a(this.app, "CliOper", "", "", "0X800760D", "0X800760D", k, 0, "", "", "", "");
    if (k != 0) {
      anot.a(this.app, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
    if (this.cab == 1) {
      anot.a(this.app, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
    }
    amxk.d("add_page", "search_people", "exp", 0, 0, new String[] { "" });
    if (this.jdField_j_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.bnJ = ypj.E(this.app);
      cka();
    }
  }
  
  public void setListViewHeightBasedOnChildren(ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "setListViewHeightBasedOnChildren");
    }
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int k = 0;
    int m = 0;
    while (k < localListAdapter.getCount())
    {
      localObject = localListAdapter.getView(k, null, paramListView);
      ((View)localObject).measure(0, 0);
      m += ((View)localObject).getMeasuredHeight();
      k += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + m + paramListView.getPaddingTop() + paramListView.getPaddingBottom());
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public int xg()
  {
    return getResources().getDimensionPixelSize(2131298554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */