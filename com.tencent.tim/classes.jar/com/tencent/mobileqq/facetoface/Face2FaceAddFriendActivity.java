package com.tencent.mobileqq.facetoface;

import acbn;
import acci;
import acfd;
import acff;
import acfp;
import acgr;
import acgs;
import achq;
import acia;
import acib;
import acrp;
import afzo;
import afzr;
import afzs;
import afzt;
import afzu;
import afzv;
import afzw;
import afzx;
import afzy;
import afzz;
import agaa;
import agab;
import agac;
import agad;
import agaf;
import agag;
import agah;
import agai;
import agaj;
import agan;
import agas;
import agay;
import agaz;
import agba;
import agbb;
import agbc;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anzd;
import aqge;
import aqha;
import aqhu;
import aqiw;
import aqju;
import arhz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import ysf;

public class Face2FaceAddFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, INetInfoHandler
{
  public static String TAG = "Face2FaceAddFriendActivity";
  public static String TAG_TIME;
  public static long XW = 1000L;
  public static String bFZ = "Face2FaceAddFriendActivity.troop";
  public static int cVM;
  public static int cVS;
  public static int cVT;
  public static int cVU = 2000;
  private static Calendar g;
  public List<agba> AD = new ArrayList();
  public List<agba> AE = new ArrayList();
  public List<agba> AF = new ArrayList();
  public List<agba> AG = new ArrayList();
  public List<String> AH = new ArrayList();
  public View CA;
  protected View CB;
  protected View CC;
  protected View CD;
  public XListView M;
  public arhz O;
  public TextView RU;
  public TextView RV;
  protected TextView RW;
  protected TextView RX;
  protected TextView RY;
  protected TextView RZ;
  protected long XX;
  long XY = 0L;
  public long XZ;
  acfd jdField_a_of_type_Acfd = new agaj(this);
  acgr jdField_a_of_type_Acgr;
  private acib jdField_a_of_type_Acib = new afzo(this);
  public agan a;
  public agaz a;
  public FriendListHandler a;
  private a jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a = new a();
  protected Face2FaceDetailBaseView.a a;
  public Face2FaceFriendDetailView a;
  public Face2FaceTroopDetailView a;
  public SnowView a;
  public CopyOnWriteArrayList<agba> ae = new CopyOnWriteArrayList();
  achq b;
  public ysf b;
  public int bDA = 0;
  public String bGa;
  public String bGb;
  public String bGc;
  public String bGd = "";
  public EditText bf;
  private boolean bfo;
  boolean bie = true;
  public int cVN = 0;
  int cVO = 0;
  int cVP = 0;
  public int cVQ;
  public int cVR;
  public int cVV;
  public int cVW;
  int cVX = 0;
  int cVY = 0;
  public boolean cbZ;
  private boolean cca;
  public boolean ccb;
  public boolean ccc;
  public boolean ccd;
  public boolean cce = true;
  public boolean ccf;
  public boolean ccg;
  public boolean cch;
  public boolean cci = true;
  public boolean ccj;
  protected boolean cck;
  public boolean ccl = false;
  acgs d = new agah(this);
  boolean hasData = false;
  public LinearLayout iO;
  public LinearLayout iP;
  int idx = 0;
  public Point j;
  public HashMap<String, Integer> kA = new HashMap();
  public HashMap<String, String> ky = new HashMap();
  public HashMap<String, Integer> kz = new HashMap();
  public long lastClickTime = 0L;
  public FrameLayout root;
  long tT = 0L;
  ArrayList<agbb> wy = new ArrayList();
  AlphaAnimation z;
  public ImageView zx;
  ImageView zy;
  
  static
  {
    TAG_TIME = "Face2FaceAddFriendActivity.time";
    cVM = 3021;
    cVS = 500;
    cVT = 300000;
  }
  
  public Face2FaceAddFriendActivity()
  {
    this.jdField_b_of_type_Achq = new agai(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a = new afzz(this);
  }
  
  private void Ix(String paramString)
  {
    new ArrayList();
    Object localObject = this.app.b().k(acbn.bkJ, 0);
    structmsg.StructMsg localStructMsg = null;
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "systemMsgList is null");
      }
    }
    int i;
    label139:
    long l1;
    long l2;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      do
      {
        return;
        if ((((List)localObject).size() <= 0) || ((((List)localObject).get(0) instanceof MessageForSystemMsg))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "systemMsgList error");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "answerAddFriend systemMsgList size" + ((List)localObject).size());
      }
      i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localStructMsg = ((MessageForSystemMsg)((List)localObject).get(i)).getSystemMsg();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(localStructMsg.req_uin.get()) + "friendUin=" + paramString);
        }
        if (!paramString.equals(String.valueOf(localStructMsg.req_uin.get()))) {
          break;
        }
      }
      if ((localStructMsg == null) || (!paramString.equals(String.valueOf(localStructMsg.req_uin.get())))) {
        break label522;
      }
      i = localStructMsg.msg_type.get();
      l1 = localStructMsg.msg_seq.get();
      l2 = localStructMsg.req_uin.get();
      k = localStructMsg.msg.sub_type.get();
      m = localStructMsg.msg.src_id.get();
      n = localStructMsg.msg.sub_src_id.get();
      i1 = localStructMsg.msg.group_msg_type.get();
      localObject = localStructMsg.msg.actions.get();
    } while ((localObject == null) || (((List)localObject).size() >= 0));
    int i2 = this.bDA;
    paramString = this.bf.getText().toString();
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).remark.set(paramString);
      ((structmsg.SystemMsgActionInfo)localObject).group_id.set(i2);
      this.app.a().a().a(i, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)localObject, 0, localStructMsg, false);
      a(localStructMsg, localStructMsg.msg_seq.get());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(localStructMsg.req_uin.get()));
      return;
      i -= 1;
      break label139;
      label522:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
      return;
    }
  }
  
  private void NK(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "notifyNeedReplace ask replace type" + paramInt);
    }
    agba localagba2 = d();
    agba localagba1 = f();
    if (paramInt == 1) {
      if (localagba2 != null)
      {
        localagba1 = localagba2;
        if (localagba1 == null) {
          break label125;
        }
        d(localagba1);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "notifyNeedReplace replaceData type" + localagba1.type);
        }
      }
    }
    label125:
    while (!QLog.isColorLevel())
    {
      return;
      if (localagba1 != null)
      {
        break;
        if (localagba1 != null) {
          break;
        }
        localagba1 = localagba2;
        if (localagba2 != null) {
          break;
        }
      }
      localagba1 = null;
      break;
    }
    QLog.d(TAG, 2, "notifyNeedReplace no data can replace");
  }
  
  private int a(agba paramagba)
  {
    return this.AG.indexOf(paramagba);
  }
  
  private agba a()
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.bGd))) {
      QLog.d(TAG, 2, "getHasShowFriendData正在查看详情Uin" + this.bGd.substring(0, 4));
    }
    Object localObject = this.ae.iterator();
    agba localagba;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localagba = (agba)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(this.bGd)) && (localagba.bGh.equals(this.bGd)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getHasShowFriendData需要替换但是正在查看详情");
          }
        }
        else if ((localagba.type == 1) && (mh(localagba.bGh)))
        {
          localObject = localagba;
          if (QLog.isColorLevel())
          {
            localObject = localagba;
            if (!TextUtils.isEmpty(localagba.bGh)) {
              QLog.d(TAG, 2, "getHasShowFriendData可替换好友" + localagba.bGh.substring(0, 4));
            }
          }
        }
      }
    }
    for (localObject = localagba;; localObject = null)
    {
      if ((localObject == null) && (QLog.isColorLevel())) {
        QLog.d(TAG, 2, "getHasShowFriendData 没有可替换好友");
      }
      return localObject;
    }
  }
  
  private Face2FaceFriendBubbleView a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_Agan.AI.iterator();
    while (localIterator.hasNext())
    {
      Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)localIterator.next();
      if ((paramString.equals(localFace2FaceFriendBubbleView.getUin())) && (localFace2FaceFriendBubbleView.lk() == paramInt)) {
        return localFace2FaceFriendBubbleView;
      }
    }
    return null;
  }
  
  private void a(int paramInt, String paramString1, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString2, Bitmap paramBitmap)
  {
    this.bGb = paramString1;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362214);
    k((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367700), paramString2);
    ((ImageView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367670)).setImageBitmap(paramBitmap);
    paramBitmap = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362217);
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362208);
    paramString2 = "";
    if (this.ky.containsKey(paramString1)) {
      paramString2 = (String)this.ky.get(paramString1);
    }
    this.bf.setText(paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      this.bf.setSelection(paramString2.length());
    }
    this.cch = true;
    if (this.kz.containsKey(paramString1)) {
      this.bDA = ((Integer)this.kz.get(paramString1)).intValue();
    }
    this.RV.setText(ee(this.bDA));
    this.bGc = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.ac(this.bGc, 3021, 0);
    this.iO.setOnClickListener(new afzu(this));
    localButton.setOnClickListener(new afzv(this, paramString1));
    if (paramInt == 2)
    {
      k(paramBitmap, acfp.m(2131706027));
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = new afzx(this, paramString1);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.a(this, this.root, paramFace2FaceFriendBubbleView, paramString1, this.ky, paramString2);
      return;
      if ((paramInt == 4) || (paramInt == 1))
      {
        if (paramInt == 4) {
          k(paramBitmap, acfp.m(2131706017));
        }
        for (;;)
        {
          k(localButton, acfp.m(2131706023));
          localLinearLayout.setVisibility(0);
          break;
          k(paramBitmap, "");
        }
      }
      if (paramInt == 3)
      {
        this.ccf = true;
        k(paramBitmap, acfp.m(2131706022));
        localLinearLayout.setVisibility(0);
        k(localButton, acfp.m(2131706015));
        localButton.setOnClickListener(new afzw(this, paramString1));
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      anzd.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      anzd.a().lC(l);
      anzd.a().lB(paramLong);
    }
  }
  
  private boolean a(agba paramagba)
  {
    if (paramagba == null) {}
    while (((paramagba.type != 1) || (!mh(paramagba.bGh))) && ((paramagba.type != 2) || (!mi(paramagba.bGh)))) {
      return false;
    }
    return true;
  }
  
  private void addObserver()
  {
    if (this.cVN == 0)
    {
      addObserver(this.jdField_b_of_type_Achq);
      addObserver(this.d);
    }
    addObserver(this.jdField_a_of_type_Acfd);
    addObserver(this.jdField_a_of_type_Acib);
  }
  
  private boolean akE()
  {
    if (this.cVN == 1) {}
    for (String str = "sp_facetoface_showguide_for_troop";; str = "sp_facetoface_showguide")
    {
      localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (localObject != null) {
        break;
      }
      return false;
    }
    this.cca = ((SharedPreferences)localObject).getBoolean(str, false);
    if (this.cca) {
      return false;
    }
    Object localObject = LayoutInflater.from(getApplicationContext()).inflate(2131559071, null);
    Button localButton = (Button)((View)localObject).findViewById(2131366627);
    ((View)localObject).setBackgroundResource(2130840371);
    ((View)localObject).setOnClickListener(this);
    if (this.cVN == 1) {
      ((TextView)((View)localObject).findViewById(2131366626)).setText(2131693357);
    }
    this.root.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    localButton.setOnClickListener(new agad(this, str, (View)localObject));
    return true;
  }
  
  private agba b()
  {
    Iterator localIterator = this.ae.iterator();
    while (localIterator.hasNext())
    {
      agba localagba = (agba)localIterator.next();
      if ((!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.isShowing()) || (!this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.d.equals(localagba)))
      {
        if ((this.cVN == 1) && (this.wy.contains(localagba))) {
          return localagba;
        }
        if ((localagba.type == 2) && (mi(localagba.bGh))) {
          return localagba;
        }
      }
    }
    return null;
  }
  
  private void bFD()
  {
    ((FriendListHandler)this.app.getBusinessHandler(1)).j(this.bGc, 3021, 0, "");
  }
  
  private agba c()
  {
    Iterator localIterator = this.AD.iterator();
    while (localIterator.hasNext())
    {
      agba localagba = (agba)localIterator.next();
      if ((localagba != null) && (mh(localagba.bGh)) && (!this.ae.contains(localagba))) {
        return localagba;
      }
    }
    return null;
  }
  
  private void c(agba paramagba)
  {
    if ((this.AG == null) || (paramagba == null)) {
      QLog.d(TAG, 2, "pushDataToUI mNeedShowList= nuull  pushData = null!");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "pushDataToUI mShowdataList=" + this.AG.size() + "currentFriendIndex=" + this.cVO + "showtype=pushData.type=" + paramagba.type + "mFriendDataList.size()" + this.AD.size() + "troop size" + this.AE.size());
            }
          } while (this.AG.contains(paramagba));
          if (this.jdField_a_of_type_Agan != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(TAG, 2, "pushDataToUI face2FaceAddFriendAnim has null");
        return;
        if (this.AD.size() + this.AE.size() <= 10) {
          break;
        }
      } while (a(paramagba));
      if (this.cVN == 0)
      {
        d(paramagba);
        this.ccg = true;
        return;
      }
      d(paramagba);
      return;
      if ((this.AG.size() == 0) && (!this.hasData))
      {
        this.AG.add(paramagba);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "pushDataToUI mShowdataList=" + this.AG.size() + "currentFriendIndex=" + this.cVO + "hasData" + this.hasData);
        }
        this.hasData = true;
        return;
      }
      this.AG.add(paramagba);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "pushDataToUI mShowdataList=" + this.AG.size() + "currentFriendIndex=" + this.cVO);
      }
    } while (this.AG.size() != this.cVO + 1);
    k(true, this.cVO, false);
  }
  
  private boolean c(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (paramString.equals(this.app.getCurrentAccountUin()))
    {
      QQToast.a(this, 2131691260, 0).show(getTitleBarHeight());
      return false;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        acff localacff = (acff)this.app.getManager(51);
        if (localacff != null)
        {
          paramString = localacff.e(paramString);
          if ((paramString == null) || (paramString.groupid < 0)) {
            break;
          }
          QQToast.a(this.app.getApplication(), 2131690304, 0).show(getTitleBarHeight());
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
      paramString = null;
    }
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this.app.getApplication(), 2131696272, 0).show(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  private void co(int paramInt, String paramString)
  {
    if (!paramString.equals(this.bGb)) {}
    TextView localTextView;
    Button localButton;
    do
    {
      return;
      localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362217);
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362214);
      localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131362208);
      if (paramInt == 3)
      {
        this.ccf = true;
        k(localTextView, acfp.m(2131706019));
        k(localButton, acfp.m(2131706024));
        localButton.setOnClickListener(new afzy(this, paramString));
        return;
      }
      if (paramInt == 2)
      {
        if (this.ky.containsKey(paramString))
        {
          paramString = (String)this.ky.get(paramString);
          if (!TextUtils.isEmpty(paramString)) {
            ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367700)).setText(paramString);
          }
        }
        k(localTextView, acfp.m(2131706030));
        localLinearLayout.setVisibility(8);
        return;
      }
    } while (paramInt != 4);
    k(localTextView, acfp.m(2131706029));
    k(localButton, acfp.m(2131706026));
  }
  
  private agba d()
  {
    Iterator localIterator = this.AD.iterator();
    while (localIterator.hasNext())
    {
      agba localagba = (agba)localIterator.next();
      if ((localagba != null) && (!mh(localagba.bGh)) && (!this.ae.contains(localagba))) {
        return localagba;
      }
    }
    return null;
  }
  
  private void d(agba paramagba)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Agan == null) {
      return;
    }
    Object localObject1 = this.ae.iterator();
    int k = 0;
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      int m;
      if (((agba)((Iterator)localObject1).next()).type == 1)
      {
        m = k;
        k = i + 1;
      }
      for (i = m;; i = m)
      {
        m = k;
        k = i;
        i = m;
        break;
        m = k + 1;
        k = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "pushDataToReplace 显示列表 mfriendCount=" + i + "mtroopCount=" + k);
    }
    localObject1 = a();
    Object localObject2 = b();
    if (paramagba.type == 1)
    {
      if (localObject1 != null) {}
      label264:
      for (;;)
      {
        label153:
        if (localObject1 != null)
        {
          localObject2 = ((agba)localObject1).bGh;
          if ((localObject1 instanceof agay)) {
            localObject2 = ((agba)localObject1).bGh + "_" + ((agay)localObject1).bGg;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pushDataToReplace rRplaceData!=null && replace type=" + ((agba)localObject1).type);
          }
          this.jdField_a_of_type_Agan.Iy((String)localObject2);
          if (this.cVN == 1)
          {
            this.jdField_a_of_type_Agan.a((agba)localObject1, bool);
            i = a((agba)localObject1);
            if ((i == -1) || (i >= this.AG.size())) {
              break;
            }
            this.AG.set(i, paramagba);
            k(true, i, true);
            return;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              continue;
            }
            if ((i >= 5) || (k <= 5) || (this.cVN != 0)) {
              break label549;
            }
            i = 0;
            localObject2 = null;
            label354:
            localObject1 = localObject2;
            if (i >= this.ae.size()) {
              continue;
            }
            localObject1 = (agba)this.ae.get(i);
            if ((localObject1 == null) || (((agba)localObject1).type != 2) || (mi(((agba)localObject1).bGh))) {
              break label555;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      localObject2 = localObject1;
      break label354;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        break label153;
      }
      if (localObject1 != null) {
        break label153;
      }
      if ((i > 5) && (k < 5))
      {
        i = 0;
        localObject2 = null;
        label454:
        localObject1 = localObject2;
        if (i >= this.ae.size()) {
          break label153;
        }
        localObject1 = (agba)this.ae.get(i);
        if ((localObject1 != null) && (((agba)localObject1).type == 1) && (!mh(((agba)localObject1).bGh))) {}
        for (;;)
        {
          i += 1;
          localObject2 = localObject1;
          break label454;
          bool = true;
          break label264;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(TAG, 2, "pushDataToReplace rRplaceData=null 没有可以替换的数据");
          return;
          localObject1 = localObject2;
        }
      }
      label549:
      localObject1 = null;
      break label153;
      label555:
      localObject1 = localObject2;
    }
  }
  
  private void dej()
  {
    this.ccl = true;
    des();
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessageDelayed(3, 0L);
    dek();
  }
  
  private void dem()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendHeartRequest");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.obtainMessage(5);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendMessageDelayed(localMessage, cVT);
  }
  
  private void deq()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2131559070, null);
    this.jdField_a_of_type_Agan = new agan(this.app, this);
    this.jdField_a_of_type_Agan.a(this.app, localView, this.cVN, this.bGa);
    this.root.addView(localView);
    this.CD = localView;
    if (this.cVN == 1)
    {
      this.cbZ = false;
      this.CC = localView.findViewById(2131365117);
      this.RZ = ((TextView)localView.findViewById(2131365113));
      this.RY = ((TextView)localView.findViewById(2131365116));
      this.RY.setText(2131693387);
      this.RY.setVisibility(0);
      localView.findViewById(2131365114).setOnClickListener(this);
      this.CC.setOnClickListener(this);
      this.RY.setOnClickListener(this);
    }
  }
  
  private void deu()
  {
    if (QLog.isColorLevel())
    {
      QLog.d(TAG, 2, "mergeShowList isFriendDataBack=" + this.ccb + "isTroopDataBack=" + this.ccc);
      QLog.d(TAG, 2, "mergeShowList isFriendBackSuccess=" + this.cVQ + "isTroopBackSuccess=" + this.cVR);
    }
    if ((this.cVQ == 0) || (this.cVR == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "mergeShowList return wait successStatus");
      }
    }
    int i;
    int k;
    do
    {
      do
      {
        do
        {
          return;
          if ((this.cVQ != 1) || (this.cVR != 1) || ((this.ccb) && (this.ccc))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(TAG, 2, "mergeShowList return");
        return;
        if (!this.ccd) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "mergeShowList return has merged");
      return;
      i = this.AD.size();
      k = this.AE.size();
      this.ccd = true;
      this.cVV += i;
      this.cVW += k;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "mergeShowList mFriendSize=" + i + "mTroopSize=" + k);
      }
    } while (i + k == 0);
    Object localObject;
    if (i + k > 10) {
      if ((i >= 5) && (k >= 5))
      {
        localObject = new ArrayList(k(this.AD, 5));
        ArrayList localArrayList = new ArrayList(j(this.AE, 5));
        L(this.AG, (List)localObject);
        L(this.AG, localArrayList);
        label360:
        localObject = this.AG.iterator();
        i = 0;
        label372:
        if (!((Iterator)localObject).hasNext()) {
          break label508;
        }
        if (!a((agba)((Iterator)localObject).next())) {
          break label620;
        }
        i += 1;
      }
    }
    label620:
    for (;;)
    {
      break label372;
      if (i < 5)
      {
        this.AG.addAll(this.AD);
        localObject = new ArrayList(j(this.AE, 10 - this.AD.size()));
        L(this.AG, (List)localObject);
        break label360;
      }
      if (k >= 5) {
        break label360;
      }
      localObject = new ArrayList(k(this.AD, 10 - this.AE.size()));
      L(this.AG, (List)localObject);
      break label360;
      label508:
      k = 0;
      label510:
      if ((k >= i) || (!akF())) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "mergeShowList size=" + this.AG.size());
        }
        this.hasData = true;
        if (this.cVO <= 0) {
          break;
        }
        k(false, this.cVO, false);
        return;
        k += 1;
        break label510;
        L(this.AG, this.AD);
        L(this.AG, this.AE);
      }
    }
  }
  
  private void dew()
  {
    if ((!this.app.bF()) && (!this.app.YI()) && (!this.app.YJ()) && (this.app.YK()) && (this.cck)) {
      aqge.ce(2131230758, false);
    }
  }
  
  private void dex()
  {
    if ((this.cce) && (this.ccf))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "clearSystemMsgData");
      }
      this.jdField_b_of_type_Ysf.clt();
    }
  }
  
  private void dey()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "findReplaceData ");
    }
    agba localagba2 = d();
    agba localagba3 = f();
    agba localagba1 = c();
    agba localagba4 = e();
    if (this.AD.size() + this.AE.size() < 10) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "findReplaceData friend count=" + this.AD.size() + "troop count" + this.AE.size());
      }
    }
    label198:
    for (;;)
    {
      return;
      if (localagba3 != null) {
        localagba1 = localagba3;
      }
      for (;;)
      {
        if (localagba1 == null) {
          break label198;
        }
        this.AG.add(localagba1);
        if (this.AG.size() != this.cVO + 1) {
          break;
        }
        k(true, this.cVO, false);
        return;
        if (localagba2 != null) {
          localagba1 = localagba2;
        } else if ((localagba4 == null) && (localagba1 == null)) {
          localagba1 = null;
        }
      }
    }
  }
  
  private agba e()
  {
    Iterator localIterator = this.AE.iterator();
    while (localIterator.hasNext())
    {
      agba localagba = (agba)localIterator.next();
      if ((localagba != null) && (mi(localagba.bGh)) && (!this.ae.contains(localagba))) {
        return localagba;
      }
    }
    return null;
  }
  
  private void eB(String paramString, int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = a(paramString, 1);
    if (localFace2FaceFriendBubbleView != null)
    {
      localFace2FaceFriendBubbleView.setStatusWithAnimation(paramInt);
      if (this.kA.containsKey(paramString))
      {
        this.kA.remove(paramString);
        this.kA.put(paramString, Integer.valueOf(paramInt));
      }
    }
    else
    {
      return;
    }
    this.kA.put(paramString, Integer.valueOf(paramInt));
  }
  
  private agba f()
  {
    Iterator localIterator = this.AE.iterator();
    while (localIterator.hasNext())
    {
      agba localagba = (agba)localIterator.next();
      if ((localagba != null) && (!mi(localagba.bGh)) && (!this.ae.contains(localagba))) {
        return localagba;
      }
    }
    return null;
  }
  
  private void initUI()
  {
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.zx = ((ImageView)findViewById(2131373546));
    this.zy = ((ImageView)findViewById(2131365558));
    this.z = new AlphaAnimation(0.0F, 1.0F);
    this.z.setDuration(1500L);
    this.z.setFillAfter(true);
    deq();
    this.j = new Point(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView = new SnowView(this);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.setSnowView(this.j);
    this.root.addView(this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView);
    localObject = getLayoutInflater();
    View localView = ((LayoutInflater)localObject).inflate(2131559323, null);
    this.root.addView(localView);
    localObject = ((LayoutInflater)localObject).inflate(2131559324, null);
    this.root.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView = ((Face2FaceTroopDetailView)this.root.findViewById(2131380248));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView = ((Face2FaceFriendDetailView)this.root.findViewById(2131367665));
    this.bf = ((EditText)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367669));
    this.RV = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367725));
    this.iO = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367715));
    this.iP = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.findViewById(2131367716));
    this.bf.addTextChangedListener(new agaa(this));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.setInfc(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a);
    this.CB = findViewById(2131378557);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.CB.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.RW = ((TextView)findViewById(2131378555));
    this.RX = ((TextView)findViewById(2131378556));
    this.RW.setOnClickListener(this);
    this.RW.setOnTouchListener(this);
    if (this.cVN == 1)
    {
      this.RX.setVisibility(0);
      this.RX.setOnClickListener(this);
      this.RX.setOnTouchListener(this);
      this.RW.setText(2131693282);
      return;
    }
    this.RX.setVisibility(8);
  }
  
  private List<agba> j(List<agba> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      agba localagba;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localagba = (agba)((Iterator)localObject).next();
      } while (mi(localagba.bGh));
      localArrayList.add(localagba);
    } while (localArrayList.size() != paramInt);
    if (localArrayList.size() < paramInt)
    {
      paramList = paramList.iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (agba)paramList.next();
        } while (!mi(((agba)localObject).bGh));
        localArrayList.add(localObject);
      } while (localArrayList.size() != paramInt);
    }
    return localArrayList;
  }
  
  private void jg(long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.obtainMessage(7);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendDelayAskRequest delaytime=" + paramLong);
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendMessageDelayed(localMessage, paramLong);
  }
  
  private List<agba> k(List<agba> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt < 1)) {
      return localArrayList;
    }
    Object localObject = paramList.iterator();
    do
    {
      agba localagba;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localagba = (agba)((Iterator)localObject).next();
      } while (mh(localagba.bGh));
      localArrayList.add(localagba);
    } while (localArrayList.size() != paramInt);
    if (localArrayList.size() < paramInt)
    {
      paramList = paramList.iterator();
      do
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (agba)paramList.next();
        } while (!mh(((agba)localObject).bGh));
        localArrayList.add(localObject);
      } while (localArrayList.size() != paramInt);
    }
    return localArrayList;
  }
  
  private void k(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.setContentDescription(paramString);
  }
  
  private void k(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "delayPushToUI mShowdataList.size()=" + this.AG.size() + "ispush=" + paramBoolean1 + "changeIndex" + paramInt + "isReplash=" + paramBoolean2);
    }
    int i = this.cVO;
    if (paramBoolean1) {}
    for (;;)
    {
      if (paramInt < this.AG.size())
      {
        Message localMessage = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.obtainMessage();
        localMessage.what = 4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("key_data _ispush", paramBoolean1);
        ((Bundle)localObject).putBoolean("key_data _hasfriend", paramBoolean2);
        localMessage.setData((Bundle)localObject);
        localMessage.arg1 = paramInt;
        localObject = (agba)this.AG.get(paramInt);
        localMessage.arg2 = ((agba)localObject).type;
        localMessage.obj = localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.hasMessages(4)) {
          this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(4);
        }
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendMessageDelayed(localMessage, cVS);
      }
      return;
      paramInt = i;
    }
  }
  
  private boolean mh(String paramString)
  {
    acff localacff = (acff)this.app.getManager(51);
    if ((localacff != null) && (!TextUtils.isEmpty(paramString))) {
      return localacff.isFriend(paramString);
    }
    return false;
  }
  
  private boolean mj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "addFriend uin is null");
      }
    }
    do
    {
      return false;
      this.bGc = paramString;
    } while (!c(1, paramString));
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString))) {
      QLog.d(TAG, 2, "addFriend uin" + paramString.substring(0, 4));
    }
    ((FriendListHandler)this.app.getBusinessHandler(1)).l("OidbSvc.0x476_147", Long.parseLong(paramString), 147);
    return true;
  }
  
  private void removeObserver()
  {
    if (this.cVN == 0)
    {
      removeObserver(this.jdField_b_of_type_Achq);
      removeObserver(this.d);
    }
    removeObserver(this.jdField_a_of_type_Acfd);
    removeObserver(this.jdField_a_of_type_Acib);
  }
  
  public int DV()
  {
    if (this.ae.size() < this.AG.size()) {}
    for (int i = (this.AG.size() - this.ae.size()) * 500 + 2500;; i = 2000)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getReplaceDelay=" + i);
      }
      return i;
    }
  }
  
  public void L(List<agba> paramList1, List<agba> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      agba localagba = (agba)paramList2.next();
      if (!paramList1.contains(localagba)) {
        paramList1.add(localagba);
      }
    }
  }
  
  public int U(long paramLong)
  {
    g.setTimeInMillis(paramLong);
    return g.get(11);
  }
  
  public void a(agba paramagba)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 14;
    localMessage.obj = paramagba;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void a(agba paramagba, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onADDShowData isPush" + paramBoolean1 + "currentFriendIndex=" + this.cVO + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    this.ae.add(paramagba);
  }
  
  public boolean a(agba paramagba, List<agba> paramList)
  {
    boolean bool = false;
    if (paramList.contains(paramagba))
    {
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramagba.bGh))) {
        QLog.d(TAG, 2, "datalist has contains data" + paramagba.bGh.substring(0, 4));
      }
      bool = true;
    }
    return bool;
  }
  
  public void addObserver(acci paramacci)
  {
    if (this.app != null) {
      this.app.addObserver(paramacci);
    }
  }
  
  public boolean akF()
  {
    agba localagba2;
    int i;
    label168:
    do
    {
      agba localagba1;
      do
      {
        Iterator localIterator1 = this.AG.iterator();
        break label168;
        break label168;
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            do
            {
              if (!localIterator1.hasNext()) {
                break label247;
              }
              localagba1 = (agba)localIterator1.next();
              if ((localagba1.type != 1) || (!mh(localagba1.bGh))) {
                break;
              }
              localIterator2 = this.AE.iterator();
            } while (!localIterator2.hasNext());
            localagba2 = (agba)localIterator2.next();
            if ((this.AG.contains(localagba2)) || (mi(localagba2.bGh))) {
              break;
            }
            i = this.AG.indexOf(localagba1);
            if (i == -1) {
              break;
            }
            this.AG.set(i, localagba2);
            return true;
          } while ((localagba1.type != 2) || (!mi(localagba1.bGh)));
          localIterator2 = this.AD.iterator();
        }
        localagba2 = (agba)localIterator2.next();
      } while ((this.AG.contains(localagba2)) || (mh(localagba2.bGh)));
      i = this.AG.indexOf(localagba1);
    } while (i == -1);
    this.AG.set(i, localagba2);
    return true;
    label247:
    return false;
  }
  
  public void ar(long paramLong1, long paramLong2)
  {
    int k = U(paramLong1);
    int m = (int)((paramLong1 - paramLong2) / 1000L / 60L);
    int i;
    if ((k >= 5) && (k < 11))
    {
      i = 4;
      if (m < 6) {
        break label300;
      }
      this.zx.setVisibility(0);
      switch (i)
      {
      default: 
        label84:
        this.zy.startAnimation(this.z);
        this.z.setAnimationListener(new agab(this));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG_TIME, 2, "startBkAnim 本次进入时间点：" + k + "和上一次时间差" + m + "小时");
      }
      return;
      if ((k >= 11) && (k < 17))
      {
        i = 1;
        break;
      }
      if ((k >= 17) && (k < 23))
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      this.zx.setBackgroundResource(2130840371);
      this.zy.setBackgroundResource(2130840370);
      break label84;
      this.zx.setBackgroundResource(2130840370);
      this.zy.setBackgroundResource(2130840372);
      break label84;
      this.zx.setBackgroundResource(2130840372);
      this.zy.setBackgroundResource(2130840369);
      break label84;
      this.zx.setBackgroundResource(2130840369);
      this.zy.setBackgroundResource(2130840371);
      break label84;
      label300:
      this.zx.setVisibility(4);
      switch (i)
      {
      default: 
        break;
      case 1: 
        this.zy.setBackgroundResource(2130840370);
        break;
      case 2: 
        this.zy.setBackgroundResource(2130840372);
        break;
      case 3: 
        this.zy.setBackgroundResource(2130840369);
        break;
      case 4: 
        this.zy.setBackgroundResource(2130840371);
      }
    }
  }
  
  public void b(agay paramagay)
  {
    if (paramagay == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "deleteGroupData mhasShowList = " + this.ae.size());
    }
    if (this.ae.contains(paramagay))
    {
      this.jdField_a_of_type_Agan.a(paramagay, true);
      String str = paramagay.bGh + "_" + paramagay.bGg;
      this.jdField_a_of_type_Agan.Iy(str);
      this.AG.remove(paramagay);
      this.AE.remove(paramagay);
      if (this.cVO > 0) {
        this.cVO -= 1;
      }
      dey();
      return;
    }
    this.AE.remove(paramagay);
  }
  
  public void b(agba paramagba)
  {
    if ((this.jdField_a_of_type_Agan == null) || (paramagba == null) || (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(14, paramagba);
      paramagba = this.jdField_a_of_type_Agan.a(paramagba.bGh);
    } while (paramagba == null);
    paramagba.setAnimation(new AlphaAnimation(1.0F, 1.0F));
  }
  
  public void b(agba paramagba, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.cVO += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onInAnimEnd isPush" + paramBoolean1 + "currentFriendIndex=" + this.cVO + "isFilterShow=hasFriend=" + paramBoolean2);
    }
    k(paramBoolean1, this.cVO, false);
    if (this.cVN == 1) {
      a(paramagba);
    }
  }
  
  public void b(agbb paramagbb)
  {
    if ((this.jdField_a_of_type_Agan == null) || (paramagbb == null)) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_Agan.a(paramagbb.bGh);
    } while (localObject1 == null);
    Object localObject2 = getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject2).widthPixels / 2;
    int k = ((View)localObject1).getLeft();
    int m = ((View)localObject1).getWidth() / 2;
    int n = ((DisplayMetrics)localObject2).heightPixels / 2;
    int i1 = ((View)localObject1).getTop();
    int i2 = ((View)localObject1).getHeight() / 2;
    localObject2 = new TranslateAnimation(0.0F, i - k - m, 0.0F, n - i1 - i2);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(1000L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new agaf(this, (View)localObject1));
    ((View)localObject1).setClickable(false);
    ((View)localObject1).startAnimation(localAnimationSet);
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = 15;
    ((Message)localObject1).obj = paramagbb;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendMessageDelayed((Message)localObject1, 1500L);
  }
  
  public void by(int paramInt, boolean paramBoolean)
  {
    if (this.hasData)
    {
      if (this.bie == true) {
        this.bie = false;
      }
      this.hasData = false;
      k(false, this.cVO, false);
    }
    do
    {
      return;
      if ((paramInt == 1) && (this.bie))
      {
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessageDelayed(3, 0L);
        return;
      }
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void dek()
  {
    if (QLog.isColorLevel()) {
      QLog.d(bFZ, 2, "openFace2FaceTroop, from_type=" + this.cVN + ", fromTroopUin=" + this.bGa);
    }
    acia localacia = (acia)this.app.getBusinessHandler(57);
    if ((localacia == null) || (this.jdField_a_of_type_Acgr == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(bFZ, 2, "openFace2FaceTroop, getBusinessHandler==null");
      }
      return;
    }
    if (!aqiw.isNetSupport(this))
    {
      if (QLog.isColorLevel()) {
        QLog.d(bFZ, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.a(this.app.getApplication(), 2131696272, 0).show(getTitleBarHeight());
      return;
    }
    ThreadManager.post(new Face2FaceAddFriendActivity.1(this, localacia), 8, null, false);
  }
  
  public void del()
  {
    if (QLog.isColorLevel()) {
      QLog.d(bFZ, 2, "closeFace2faceTroop, from_type=" + this.cVN + ", fromTroopUin=" + this.bGa);
    }
    acia localacia = (acia)this.app.getBusinessHandler(57);
    if (localacia == null) {
      if (QLog.isColorLevel()) {
        QLog.d(bFZ, 2, "closeFace2faceTroop, getBusinessHandler==null");
      }
    }
    do
    {
      return;
      if (this.cVN != 1) {
        break;
      }
    } while (TextUtils.isEmpty(this.bGa));
    try
    {
      localacia.ay(Long.valueOf(this.bGa).longValue(), 1);
      return;
    }
    catch (Exception localException)
    {
      return;
    }
    localException.ay(0L, 1);
  }
  
  public void den()
  {
    this.ccj = true;
    Object localObject;
    if (this.M == null)
    {
      localObject = LayoutInflater.from(getApplicationContext());
      this.CA = ((LayoutInflater)localObject).inflate(2131559327, null);
      View localView = this.CA.findViewById(2131379771);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      this.root.addView(this.CA);
      this.M = ((XListView)this.CA.findViewById(2131380194));
      localView = this.CA.findViewById(2131366625);
      this.M.setEmptyView(localView);
      localObject = ((LayoutInflater)localObject).inflate(2131559325, this.M, false);
      this.RU = ((TextView)((View)localObject).findViewById(2131380192));
      this.M.addHeaderView((View)localObject);
      localObject = (TextView)this.CA.findViewById(2131369587);
      ((TextView)localObject).setOnClickListener(this);
      ((TextView)localObject).setOnTouchListener(this);
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 0, ((TextView)localObject).getPaddingRight(), 0);
      this.jdField_a_of_type_Agaz = new agaz(this, this.M);
    }
    for (;;)
    {
      this.jdField_a_of_type_Agaz.kE(this.AD);
      this.RU.setText(String.valueOf(this.jdField_a_of_type_Agaz.getCount()));
      localObject = AnimationUtils.loadAnimation(this, 2130771991);
      this.CA.startAnimation((Animation)localObject);
      return;
      this.CA.setVisibility(0);
    }
  }
  
  public void deo()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771990);
    localAnimation.setAnimationListener(new agac(this));
    this.CA.startAnimation(localAnimation);
    dep();
  }
  
  public void dep()
  {
    int i = this.AD.size();
    if (i > 0)
    {
      if ((this.RY != null) && (this.RY.getVisibility() == 0)) {
        this.RY.setVisibility(8);
      }
      if ((this.CC != null) && (this.CC.getVisibility() != 0)) {
        this.CC.setVisibility(0);
      }
      this.RZ.setText(String.valueOf(i));
    }
  }
  
  public void der()
  {
    if (this.cVN != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(9);
    long l = SystemClock.elapsedRealtime() - this.XX;
    if (QLog.isColorLevel()) {
      QLog.d("time_tick", 2, "checkTroopShareValidity, durition=" + l + ", mInitTroopShareTimeStamp=" + this.XX);
    }
    if (l >= 1200000L)
    {
      aqha.a(this, 230, getString(2131721103), "此次分享已满20分钟", 2131721058, 2131693282, new agag(this), null).show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessageDelayed(9, 10000L);
  }
  
  public void des()
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sleep(100L);
  }
  
  public void det()
  {
    if (QLog.isColorLevel()) {
      QLog.d("snow", 2, "stopSnow");
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(0);
  }
  
  public void dev()
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessageDelayed(8, 0L);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.bDA = paramInt1;
    this.RV.setText(ee(paramInt1));
    this.kz.put(this.bGb, Integer.valueOf(this.bDA));
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView != null) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.akG();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView != null) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.akG();
      return;
    }
    if ((this.ccj) && (this.CA != null) && (this.CA.getVisibility() == 0))
    {
      deo();
      return;
    }
    if ((this.cVN == 1) && (this.cbZ))
    {
      aqha.a(this, 230, getString(2131721103), getString(2131693355), 2131721058, 2131693282, new afzr(this), new afzs(this)).show();
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentViewNoTitle(2131559069);
    this.XX = SystemClock.elapsedRealtime();
    paramBundle = getIntent();
    String str = paramBundle.getStringExtra("options");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(str);
        this.cVN = paramBundle.optInt("activity_from_type");
        this.bGa = paramBundle.optString("activity_troop_uin");
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "doOnCreate, from_type=" + this.cVN + ", fromTroopUin=" + this.bGa);
        }
        this.root = ((FrameLayout)findViewById(2131377546));
        this.jdField_a_of_type_Acgr = ((acgr)this.app.getBusinessHandler(3));
        g = Calendar.getInstance();
        initUI();
        addObserver();
        this.jdField_b_of_type_Ysf = ((ysf)this.app.getManager(34));
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
        if (AppNetConnInfo.getConnInfo() == -1) {
          QQToast.a(this.app.getApplication(), 2131696272, 0).show(getTitleBarHeight());
        }
        if (this.jdField_b_of_type_Ysf.xp() != 0) {
          break label279;
        }
        this.cce = true;
        if (!akE()) {
          break;
        }
        this.ccl = false;
        return true;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      this.cVN = paramBundle.getIntExtra("activity_from_type", 0);
      this.bGa = paramBundle.getStringExtra("activity_troop_uin");
      continue;
      label279:
      this.cce = false;
    }
    dej();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver();
    dex();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "Face2FaceAddFriendActivity doOnDestroy");
    }
    this.bfo = true;
    agas.Yc = System.currentTimeMillis();
    del();
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(5);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(7);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(9);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(4);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(11);
    if (this.jdField_a_of_type_Acgr != null) {
      this.jdField_a_of_type_Acgr.Eb(this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this);
      this.jdField_a_of_type_Agan.clearData();
      if (this.ccg) {
        anot.a(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Agaz != null) {
        this.jdField_a_of_type_Agaz.destroy();
      }
      anot.a(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.cVV), String.valueOf(this.cVW), "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "doOnDestroy mLbsHandler is null");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "doOnPause!");
    }
    this.cck = false;
    aqge.m(this, false);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "doOnResume!");
    }
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
    this.cck = true;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    aqge.m(this, true);
    des();
    der();
    agas.Ya = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG_TIME, 2, "face2face doOnStart inface2faceTime=" + U(agas.Ya) + "showBkAnim=" + this.ccl);
    }
    if (this.ccl)
    {
      if (agas.Ya >= agas.Yb) {
        ar(agas.Ya, agas.Yb);
      }
    }
    else {
      return;
    }
    ar(agas.Ya, 0L);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "doOnStop!");
    }
    det();
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.removeMessages(4);
    agas.Yb = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(TAG_TIME, 2, "face2face doOnStop outface2faceTime=" + U(agas.Yb));
    }
  }
  
  public void e(agba paramagba)
  {
    if (this.ae.contains(paramagba)) {
      this.ae.remove(paramagba);
    }
  }
  
  public String ee(int paramInt)
  {
    Groups localGroups = ((acff)this.app.getManager(51)).a(paramInt + "");
    if (localGroups != null) {
      return localGroups.group_name;
    }
    return "";
  }
  
  public boolean mi(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager != null) {}
    for (paramString = localTroopManager.b(paramString + "");; paramString = null)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendDetailView.isShowing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2131366683) {
        if (i == 2131378555)
        {
          doOnBackPressed();
        }
        else if ((i == 2131378556) || (i == 2131365114) || (i == 2131365117) || (i == 2131365116))
        {
          if (this.cVN == 1) {
            den();
          }
        }
        else if (i == 2131369587)
        {
          if (this.cVN == 1) {
            deo();
          }
        }
        else
        {
          Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)paramView;
          Object localObject2;
          Object localObject1;
          if (localFace2FaceFriendBubbleView.lk() == 1)
          {
            String str = localFace2FaceFriendBubbleView.getUin();
            if (TextUtils.isEmpty(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getBubbleview uin is null");
              }
            }
            else
            {
              this.bGd = str;
              if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.bGd))) {
                QLog.d(TAG, 2, "showdetail 进入详情页mShowDetailUin=" + this.bGd.substring(0, 4));
              }
              localObject2 = this.app.a(str, (byte)3, true);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = aqhu.G();
              }
              localObject2 = (agbc)localFace2FaceFriendBubbleView.g();
              if (localObject2 == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "getBubbleview nearbyUser is null");
                }
              }
              else
              {
                if (((agbc)localObject2).remark.equals("")) {}
                for (localObject2 = ((agbc)localObject2).nick;; localObject2 = ((agbc)localObject2).remark)
                {
                  a(localFace2FaceFriendBubbleView.getStatus(), str, localFace2FaceFriendBubbleView, (String)localObject2, (Bitmap)localObject1);
                  anot.a(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
                  if (this.cVN != 1) {
                    break;
                  }
                  anot.a(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.bGa, "", "", "");
                  break;
                }
              }
            }
          }
          else if (localFace2FaceFriendBubbleView.lk() == 2)
          {
            localObject1 = localFace2FaceFriendBubbleView.g();
            if (localObject1 != null)
            {
              this.bGc = ((agba)localObject1).bGh;
              this.bGd = this.bGc;
              localObject2 = new afzt(this, (agba)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.setBindData((agba)localObject1, (View.OnClickListener)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceTroopDetailView.a(this.root, localFace2FaceFriendBubbleView);
              if (this.cVN == 1) {
                b((agba)localObject1);
              }
            }
            anot.a(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessage(18);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    dek();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    dek();
  }
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onNetWifi2None");
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity$a.sendEmptyMessage(18);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      paramView = (TextView)paramView;
      if (paramMotionEvent.getAction() == 0) {
        paramView.setTextColor(getResources().getColor(2131167251));
      } else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setTextColor(getResources().getColor(2131167654));
      }
    }
  }
  
  public void removeObserver(acci paramacci)
  {
    if (this.app != null) {
      this.app.removeObserver(paramacci);
    }
  }
  
  public class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool1 = false;
      int i;
      int k;
      Object localObject;
      boolean bool2;
      int j;
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        return;
      case 0: 
        Face2FaceAddFriendActivity.this.jdField_a_of_type_ComTencentMobileqqFacetofaceSnowView.invalidate();
        sleep(20L);
        return;
      case 2: 
        Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this, (String)paramMessage.obj, paramMessage.arg1);
        return;
      case 3: 
        Face2FaceAddFriendActivity.this.jdField_a_of_type_Agan.bz(1, false);
        return;
      case 4: 
        i = paramMessage.arg1;
        k = paramMessage.arg2;
        Bundle localBundle = paramMessage.getData();
        localObject = Boolean.valueOf(localBundle.getBoolean("key_data _ispush"));
        bool2 = localBundle.getBoolean("key_data _hasfriend");
        j = Face2FaceAddFriendActivity.this.AG.size();
        if (j >= 10) {
          j = 10;
        }
        break;
      }
      for (;;)
      {
        if (Face2FaceAddFriendActivity.this.ae.contains(paramMessage.obj))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(Face2FaceAddFriendActivity.TAG, 2, "push的数据是显示列表中已有数据");
          return;
        }
        if (i >= j) {
          break;
        }
        if (k == 1)
        {
          paramMessage = (agbc)paramMessage.obj;
          if (paramMessage.isFriend)
          {
            i = 2;
            if (Face2FaceAddFriendActivity.this.cVO != j - 1) {
              break label1253;
            }
          }
        }
        label444:
        label1245:
        label1253:
        for (bool1 = true;; bool1 = false)
        {
          if (((Boolean)localObject).booleanValue())
          {
            Face2FaceAddFriendActivity.this.jdField_a_of_type_Agan.deE();
            bool1 = true;
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(Face2FaceAddFriendActivity.TAG, 2, "show next isPush=" + localObject + "isNeedShake=" + bool1 + "currentFriendIndex=" + Face2FaceAddFriendActivity.this.cVO + "count=" + j);
            }
            Face2FaceAddFriendActivity.this.jdField_a_of_type_Agan.a(paramMessage, ((Boolean)localObject).booleanValue(), i, bool2, bool1);
            if (Face2FaceAddFriendActivity.this.kA.containsKey(paramMessage.bGh))
            {
              Face2FaceAddFriendActivity.this.kA.remove(paramMessage.bGh);
              Face2FaceAddFriendActivity.this.kA.put(paramMessage.bGh, Integer.valueOf(i));
            }
            do
            {
              for (;;)
              {
                Face2FaceAddFriendActivity.b(Face2FaceAddFriendActivity.this);
                return;
                i = 1;
                break;
                Face2FaceAddFriendActivity.this.kA.put(paramMessage.bGh, Integer.valueOf(i));
              }
            } while (k != 2);
            paramMessage = (agba)paramMessage.obj;
            if (Face2FaceAddFriendActivity.this.cVN == 0)
            {
              if (!Face2FaceAddFriendActivity.this.mi(paramMessage.bGh)) {
                break label1245;
              }
              i = 2;
            }
            for (;;)
            {
              if (Face2FaceAddFriendActivity.this.cVO == j - 1) {
                bool1 = true;
              }
              if (((Boolean)localObject).booleanValue())
              {
                Face2FaceAddFriendActivity.this.jdField_a_of_type_Agan.deE();
                bool1 = true;
              }
              Face2FaceAddFriendActivity.this.jdField_a_of_type_Agan.a(paramMessage, ((Boolean)localObject).booleanValue(), i, bool2, bool1);
              if (Face2FaceAddFriendActivity.this.kA.containsKey(paramMessage.bGh))
              {
                Face2FaceAddFriendActivity.this.kA.remove(paramMessage.bGh);
                Face2FaceAddFriendActivity.this.kA.put(paramMessage.bGh, Integer.valueOf(i));
                break label444;
                if ((Face2FaceAddFriendActivity.this.cVN != 1) || (((TroopManager)Face2FaceAddFriendActivity.this.app.getManager(52)).b(Face2FaceAddFriendActivity.this.bGa, paramMessage.bGh) == null)) {
                  break label1245;
                }
                i = 2;
                continue;
              }
              Face2FaceAddFriendActivity.this.kA.put(paramMessage.bGh, Integer.valueOf(i));
              break label444;
              if (Face2FaceAddFriendActivity.this.jdField_a_of_type_Acgr == null) {
                break;
              }
              Face2FaceAddFriendActivity.this.jdField_a_of_type_Acgr.x(Face2FaceAddFriendActivity.this.app.getCurrentAccountUin(), true);
              sendMessageDelayed(obtainMessage(5), Face2FaceAddFriendActivity.cVT);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(Face2FaceAddFriendActivity.TAG, 2, "FTF_MSG_SEND_HEARTBEAT=" + Face2FaceAddFriendActivity.this.app.getCurrentAccountUin());
              return;
              if (Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this)) {
                break;
              }
              paramMessage = Face2FaceAddFriendActivity.this.getResources().getString(2131693353);
              QQToast.a(Face2FaceAddFriendActivity.this, 0, paramMessage, 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
              return;
              Face2FaceAddFriendActivity.this.dek();
              return;
              Face2FaceAddFriendActivity.this.jdField_a_of_type_Agan.deD();
              return;
              Face2FaceAddFriendActivity.this.der();
              return;
              Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this, (agba)paramMessage.obj);
              return;
              Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this, paramMessage.arg1);
              return;
              Face2FaceAddFriendActivity.this.b((agay)paramMessage.obj);
              return;
              paramMessage = Face2FaceAddFriendActivity.this.ae.iterator();
              while (paramMessage.hasNext())
              {
                localObject = (agba)paramMessage.next();
                if ((((agba)localObject).type == 1) && (Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this, ((agba)localObject).bGh))) {
                  Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this, ((agba)localObject).type);
                } else if ((((agba)localObject).type == 2) && (Face2FaceAddFriendActivity.this.mi(((agba)localObject).bGh))) {
                  Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this, ((agba)localObject).type);
                }
              }
              long l = Face2FaceAddFriendActivity.this.cVY;
              paramMessage = new agbb(l + 2396794490L + "", "Member " + Face2FaceAddFriendActivity.this.cVY, 1, 1, "");
              localObject = Face2FaceAddFriendActivity.this;
              ((Face2FaceAddFriendActivity)localObject).cVY += 1;
              Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this).a(paramMessage);
              Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this).sendEmptyMessageDelayed(17, 300L);
              return;
              if (!(paramMessage.obj instanceof agbb)) {
                break;
              }
              paramMessage = (agbb)paramMessage.obj;
              Face2FaceAddFriendActivity.this.b(paramMessage);
              return;
              if (!(paramMessage.obj instanceof agbb)) {
                break;
              }
              Face2FaceAddFriendActivity.this.wy.add((agbb)paramMessage.obj);
              return;
              if (!(paramMessage.obj instanceof agbb)) {
                break;
              }
              Face2FaceAddFriendActivity.a(Face2FaceAddFriendActivity.this).a((agbb)paramMessage.obj);
              return;
              QQToast.a(Face2FaceAddFriendActivity.this.app.getApplication(), 2131696272, 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
              return;
              i = 1;
            }
          }
        }
      }
    }
    
    public void sleep(long paramLong)
    {
      removeMessages(0);
      sendMessageDelayed(obtainMessage(0), paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity
 * JD-Core Version:    0.7.0.1
 */