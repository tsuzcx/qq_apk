package com.tencent.biz.pubaccount.readinjoy.ugc;

import afpu;
import ahav;
import ahyv;
import ahzd;
import ahzs;
import akyr;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import ankq;
import anpc;
import aoko;
import aooi;
import aook;
import aool;
import aqhs;
import arhz;
import ausj;
import auss;
import awit;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kbp;
import kqi;
import kxm;
import lbz;
import lcc;
import lce;
import mjb;
import mjc;
import mje;
import mjf;
import mjg;
import mjh;
import mji;
import mjj;
import mjk;
import mjl;
import mjt;
import mkt;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverUGCActivity
  extends ReadInJoyBaseDeliverActivity
{
  public static Drawable cF = new ColorDrawable(-855310);
  private String Zm;
  private String Zn;
  private String Zo;
  private DeliverData jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData = new DeliverData();
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$a = new a();
  private ReadInJoyNinePicDeliverDynamicGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView;
  private mjt jdField_a_of_type_Mjt;
  private int aIP;
  private int aLa = 40000;
  private int aTr;
  private int aTs;
  private int aTt;
  private int aTu;
  private Handler aZ = new Handler();
  private boolean acX;
  private String ajf = "";
  private boolean amT;
  private boolean amW;
  private boolean amZ;
  private boolean ana;
  private boolean anb;
  private boolean anc;
  private JSONObject av = new JSONObject();
  lce e = new mje(this);
  private List<String> fl = new ArrayList();
  private boolean isFinish;
  private boolean isUpdating;
  private float jC;
  private float jD;
  private List<Integer> jb = new ArrayList();
  private List<b> jc = Collections.synchronizedList(new ArrayList());
  private List<aool> jd = Collections.synchronizedList(new ArrayList());
  private List<String> je = Collections.synchronizedList(new ArrayList());
  private ausj mActionSheet;
  private arhz mProgress;
  private int mRequestCode = 0;
  private ArrayList<SocializeFeedsInfo.BiuCommentInfo> multiBiuStruct;
  private long wd;
  
  private boolean DP()
  {
    if (pu() != 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Mjt.getItems().size() - 1)
      {
        if (!(this.jdField_a_of_type_Mjt.getItems().get(i) instanceof HotPicData)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void U(Object paramObject)
  {
    List localList = this.jdField_a_of_type_Mjt.getItems();
    if (pu() < 9)
    {
      if ((!(paramObject instanceof String)) || (!localList.contains(paramObject))) {
        break label134;
      }
      paramObject = eT((String)paramObject);
    }
    label134:
    for (;;)
    {
      Object localObject1 = paramObject;
      if ((paramObject instanceof HotPicData))
      {
        localObject1 = paramObject;
        if (!localList.contains(paramObject)) {}
      }
      try
      {
        localObject1 = ((HotPicData)paramObject).clone();
        this.jdField_a_of_type_Mjt.j(localList.size() - 1, localObject1);
        V(localObject1);
        if (localList.size() > 9) {
          this.jdField_a_of_type_Mjt.ab(localList.get(9));
        }
        aPo();
        return;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          localCloneNotSupportedException.printStackTrace();
          Object localObject2 = paramObject;
        }
      }
    }
  }
  
  private void V(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      if (akyr.lP((String)paramObject))
      {
        this.jb.add(Integer.valueOf(2));
        return;
      }
      this.jb.add(Integer.valueOf(3));
      return;
    }
    this.jb.add(Integer.valueOf(2));
  }
  
  public static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = cF;
    localURLDrawableOptions.mFailedDrawable = cF;
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      if (paramHotPicData.getDataType() != 2) {
        break label65;
      }
    }
    label65:
    for (paramHotPicData = ahzs.a((HotVideoData)paramHotPicData);; paramHotPicData = ahyv.getURL(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label76;
      }
      return null;
      bool = false;
      break;
    }
    label76:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  private void aPi()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.sc = localIntent.getLongExtra("readinjoy_draftbox_id", -1L);
      if (this.sc != -1L) {
        ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.5(this));
      }
    }
  }
  
  private void aPj()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDeliverUGCActivity.6(this));
  }
  
  private void aPk()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.CAMERA") != 0))
    {
      requestPermissions(new mjc(this), 2000, new String[] { "android.permission.CAMERA" });
      return;
    }
    aPl();
  }
  
  private void aPm()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    localIntent.putExtra("peak.myUin", this.app.getAccount());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra.busi_type", 8);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9 - pu());
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    if (9 - pu() == 1) {
      localIntent.putExtra("from_readinjoy_ugc", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 25);
      startActivityForResult(localIntent, 1000);
      this.mRequestCode = 1000;
      overridePendingTransition(2130771991, 2130771989);
      return;
      localIntent.putExtra("from_readinjoy_ugc_deliver_preview", true);
    }
  }
  
  private void aPn()
  {
    ThreadManager.executeOnFileThread(new ReadInJoyDeliverUGCActivity.11(this));
  }
  
  private void aPp()
  {
    this.aTr = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData.clear();
  }
  
  private void aPq()
  {
    aPp();
    Iterator localIterator = this.jc.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).and = false;
    }
    localIterator = this.jd.iterator();
    while (localIterator.hasNext())
    {
      aool localaool = (aool)localIterator.next();
      this.app.a().a(localaool);
    }
    this.jc.clear();
  }
  
  private String br(int paramInt)
  {
    String str = kxm.iS();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("save", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return str;
  }
  
  private void cL(List<?> paramList)
  {
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        U(paramList.next());
      }
    }
  }
  
  private boolean dR(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      return false;
    }
    List localList = this.jdField_a_of_type_Mjt.getItems();
    if (((localList.get(paramInt) instanceof HotPicData)) || (this.ajf.equals(localList.get(paramInt)))) {
      return true;
    }
    String str = getMd5(localList.get(paramInt));
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        break label98;
      }
      if (str.equals(getMd5(localList.get(i)))) {
        break;
      }
      i += 1;
    }
    label98:
    return true;
  }
  
  public static String eS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("\\/", "/").replaceAll("https://qqpublic.qpic.cn/qq_public/", "");
  }
  
  private void f(Object paramObject, int paramInt)
  {
    new Thread(new ReadInJoyDeliverUGCActivity.15(this, paramObject, paramInt)).start();
  }
  
  private void g(Object paramObject, int paramInt)
  {
    List localList = this.jdField_a_of_type_Mjt.getItems();
    this.jdField_a_of_type_Mjt.j(paramInt, paramObject);
    h(paramObject, paramInt);
    if (localList.size() > 9) {
      this.jdField_a_of_type_Mjt.ab(localList.get(9));
    }
    aPo();
  }
  
  private String getMd5(Object paramObject)
  {
    String str = this.ajf;
    if ((this.ajf.equals(paramObject)) || (!(paramObject instanceof String))) {
      paramObject = str;
    }
    do
    {
      do
      {
        return paramObject;
        str = (String)paramObject;
        paramObject = str;
      } while (TextUtils.isEmpty(str));
      paramObject = str;
    } while (!new File(str).exists());
    return aqhs.bytes2HexStr(ahav.t(str));
  }
  
  private void h(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String))
    {
      if (akyr.lP((String)paramObject))
      {
        this.jb.add(paramInt, Integer.valueOf(2));
        return;
      }
      this.jb.add(paramInt, Integer.valueOf(3));
      return;
    }
    this.jb.add(paramInt, Integer.valueOf(2));
  }
  
  private void openCamera()
  {
    kqi.bO(this);
    this.mRequestCode = 1001;
    overridePendingTransition(2130771991, 2130771989);
  }
  
  private int pt()
  {
    if ((pu() == 0) && (!TextUtils.isEmpty(this.N.getText()))) {
      return 3;
    }
    if ((pu() != 0) && (TextUtils.isEmpty(this.N.getText())))
    {
      if (DP()) {
        return 4;
      }
      return 1;
    }
    if ((pu() != 0) && (!TextUtils.isEmpty(this.N.getText())))
    {
      if (DP()) {
        return 5;
      }
      return 2;
    }
    return 0;
  }
  
  private int pu()
  {
    if (this.jdField_a_of_type_Mjt != null)
    {
      int j = this.jdField_a_of_type_Mjt.getItems().size();
      int i = j;
      if (this.jdField_a_of_type_Mjt.getItems().get(this.jdField_a_of_type_Mjt.getItems().size() - 1).equals(this.ajf)) {
        i = j - 1;
      }
      return i;
    }
    return 0;
  }
  
  private void rQ(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {}
    do
    {
      Object localObject;
      HotPicData localHotPicData;
      do
      {
        return;
        localObject = this.jdField_a_of_type_Mjt.getItems().get(paramInt);
        if (!(localObject instanceof HotPicData)) {
          break;
        }
        localHotPicData = (HotPicData)localObject;
      } while (HotPicPageView.a((HotPicData)localObject) != 0);
      ahyv.f(localHotPicData.url).getAbsolutePath();
      rR(paramInt);
      return;
      if (!((String)this.jdField_a_of_type_Mjt.getItems().get(paramInt)).equals(this.ajf)) {
        break;
      }
    } while (9 - pu() <= 0);
    Qq();
    kbp.a(null, "", "0X8008238", "0X8008238", 0, 0, "", "", "", kxm.iS(), false);
    return;
    rR(paramInt);
  }
  
  private void rR(int paramInt)
  {
    Intent localIntent = new Intent();
    this.aTs = paramInt;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Mjt.getItems().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!localObject.equals(this.ajf)) {
        if ((localObject instanceof String)) {
          localArrayList.add((String)localObject);
        } else if ((localObject instanceof HotPicData)) {
          localArrayList.add(ahyv.f(((HotPicData)localObject).url).getAbsolutePath());
        }
      }
    }
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverUGCActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("from_readinjoy_ugc_deliver", true);
    localIntent.putExtra("keep_selected_status_after_finish", true);
    localIntent.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    localIntent.setClass(this, NewPhotoPreviewActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("extra.busi_type", 8);
    startActivityForResult(localIntent, 1002);
    this.mRequestCode = 1002;
    overridePendingTransition(2130772360, 2130772362);
  }
  
  private void rS(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.wd;
    anpc localanpc = anpc.a(this);
    String str = this.app.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str, "actReadInJoyUGCPicture", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void rT(int paramInt)
  {
    this.jdField_a_of_type_Mjt.ab(this.jdField_a_of_type_Mjt.getItems().get(paramInt));
    this.jb.remove(paramInt);
    if (pu() == 0)
    {
      lW(false);
      if (this.aTu == 1)
      {
        lW(true);
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    aPo();
  }
  
  protected void Qq()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ausj)auss.a(this, null));
      this.mActionSheet.addCancelButton(2131721058);
      this.mActionSheet.setOnDismissListener(new mjj(this));
      this.mActionSheet.a(new mjk(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      this.aIL = this.aIK;
      this.acX = false;
      this.mActionSheet.show();
    }
  }
  
  public void a(afpu paramafpu)
  {
    getActivity().getApplicationContext();
    lW(true);
  }
  
  public void aAt()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
  }
  
  public void aCT()
  {
    super.aCT();
    kbp.a(null, "", "0X800823E", "0X800823E", 0, 0, "" + pt(), "", "", kxm.iS(), false);
  }
  
  public void aCV()
  {
    this.mFrom = 1;
    super.aCV();
    kbp.a(null, "", "0X800957A", "0X800957A", 0, 0, "", "", "", kxm.iS(), false);
  }
  
  public void aCW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onEmotionBtn!");
    }
    kbp.a(null, "", "0X800823F", "0X800823F", 0, 0, "", "", "", kxm.iS(), false);
    super.aCW();
  }
  
  public void aCY()
  {
    kbp.a(null, "", "0X800823D", "0X800823D", 0, 0, "", "", "", br(1), false);
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDeliverUGCActivity.13(this));
  }
  
  protected void aGf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onGifBtn!");
    }
    if (this.aIK == 3)
    {
      oM(1);
      return;
    }
    oM(3);
    kbp.a(null, "", "0X8008449", "0X8008449", 0, 0, "", "", "", kxm.iS(), false);
  }
  
  public void aPl()
  {
    openCamera();
    kbp.a(null, "", "0X800823A", "0X800823A", 0, 0, "", "", "", kxm.iS(), false);
  }
  
  public void aPo()
  {
    List localList = this.jdField_a_of_type_Mjt.getItems();
    if (localList.size() == 0) {
      this.jdField_a_of_type_Mjt.add(this.ajf);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mjt.notifyDataSetChanged();
      return;
      if ((localList.size() < 9) && (!localList.get(localList.size() - 1).equals(this.ajf))) {
        this.jdField_a_of_type_Mjt.add(this.ajf);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (pu() != 0)
    {
      lW(true);
      return;
    }
    if (paramEditable.length() <= 0)
    {
      lW(false);
      return;
    }
    if (this.aTu == 1)
    {
      lW(true);
      if (pu() == 0)
      {
        this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      this.rightViewText.setTextColor(Color.parseColor("#262626"));
      return;
    }
    String str = UUID.randomUUID().toString();
    if (mkt.V(paramEditable.toString(), str).trim().length() <= 0)
    {
      lW(false);
      return;
    }
    lW(true);
  }
  
  public void b(HotPicData paramHotPicData)
  {
    if ((paramHotPicData != null) && (paramHotPicData.url != null))
    {
      U(paramHotPicData);
      lW(true);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "url=" + paramHotPicData.url);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jC = paramMotionEvent.getY();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.jD = paramMotionEvent.getY();
      if ((this.jC - this.jD > 50.0F) || (this.jD - this.jC > 50.0F)) {
        this.amZ = false;
      }
      if (!this.amZ) {
        break label94;
      }
      rQ(this.aTt);
      this.amZ = false;
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label94:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.bap();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560348);
    ankq.f(this.app, BaseApplicationImpl.getContext());
    overridePendingTransition(2130771991, 2130771989);
    if (isInMultiWindow())
    {
      finish();
      return true;
    }
    this.aTu = getIntent().getIntExtra("ugcPushType", 0);
    if (this.aTu == 1) {}
    initViews();
    initData();
    return true;
  }
  
  public void doOnDestroy()
  {
    Iterator localIterator = this.jc.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      this.app.a().b(localb);
      this.jc.clear();
    }
    this.aZ.removeCallbacksAndMessages(null);
    lcc.a().c(this.e);
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.mRequestCode == 1002)
    {
      String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(str))
      {
        this.jb.remove(this.aTs);
        this.jdField_a_of_type_Mjt.ab(this.jdField_a_of_type_Mjt.getItems().get(this.aTs));
        g(str, this.aTs);
        this.je.add(str);
      }
    }
    if (this.mRequestCode == 1001)
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(paramIntent)) {
        U(paramIntent);
      }
    }
    label217:
    do
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "doOnNewIntent mRequestCode=" + this.mRequestCode + ", path=");
        }
        lW(true);
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
        this.mRequestCode = 0;
        this.aIL = 0;
        return;
      } while (this.mRequestCode != 1000);
      int i;
      if (9 - pu() == 1)
      {
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!(paramIntent instanceof String)) {
          break label288;
        }
        paramIntent = (String)paramIntent;
        if (!TextUtils.isEmpty(paramIntent)) {
          U(paramIntent);
        }
        i = 1;
      }
      for (;;)
      {
        this.ana = true;
        kbp.a(null, "", "0X800823A", "0X800823A", 0, 0, String.valueOf(i), "", "", kxm.iS(), false);
        break;
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        break label217;
        if (paramIntent == null) {
          break label312;
        }
        paramIntent = (List)paramIntent;
        i = paramIntent.size();
        cL(paramIntent);
      }
    } while (!QLog.isColorLevel());
    label288:
    label312:
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "error  back empty path ");
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    AbstractGifImage.resumeAll();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
  }
  
  /* Error */
  public String eT(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: iconst_0
    //   4: aload_1
    //   5: bipush 46
    //   7: invokevirtual 1040	java/lang/String:indexOf	(I)I
    //   10: invokevirtual 1044	java/lang/String:substring	(II)Ljava/lang/String;
    //   13: astore 5
    //   15: aload_1
    //   16: aload_1
    //   17: bipush 46
    //   19: invokevirtual 1040	java/lang/String:indexOf	(I)I
    //   22: aload_1
    //   23: invokevirtual 915	java/lang/String:length	()I
    //   26: invokevirtual 1044	java/lang/String:substring	(II)Ljava/lang/String;
    //   29: astore 4
    //   31: new 830	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   38: aload 5
    //   40: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 1046
    //   46: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 5
    //   54: new 830	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   61: aload 5
    //   63: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 4
    //   68: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 5
    //   76: new 639	java/io/File
    //   79: dup
    //   80: aload 5
    //   82: invokespecial 640	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 643	java/io/File:exists	()Z
    //   88: ifeq +12 -> 100
    //   91: aload_0
    //   92: aload 5
    //   94: invokevirtual 174	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eT	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_3
    //   98: aload_3
    //   99: areturn
    //   100: new 1048	java/io/FileInputStream
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 1049	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   108: astore 4
    //   110: new 1051	java/io/FileOutputStream
    //   113: dup
    //   114: aload 5
    //   116: invokespecial 1052	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   119: astore_1
    //   120: sipush 1024
    //   123: newarray byte
    //   125: astore_3
    //   126: aload 4
    //   128: aload_3
    //   129: invokevirtual 1058	java/io/InputStream:read	([B)I
    //   132: istore_2
    //   133: iload_2
    //   134: ifle +53 -> 187
    //   137: aload_1
    //   138: aload_3
    //   139: iconst_0
    //   140: iload_2
    //   141: invokevirtual 1064	java/io/OutputStream:write	([BII)V
    //   144: goto -18 -> 126
    //   147: astore_3
    //   148: aload 4
    //   150: astore_3
    //   151: aload_0
    //   152: getfield 120	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:ajf	Ljava/lang/String;
    //   155: astore 4
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 1067	java/io/InputStream:close	()V
    //   165: aload 4
    //   167: astore_3
    //   168: aload_1
    //   169: ifnull -71 -> 98
    //   172: aload_1
    //   173: invokevirtual 1068	java/io/OutputStream:close	()V
    //   176: aload 4
    //   178: areturn
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 1069	java/io/IOException:printStackTrace	()V
    //   184: aload 4
    //   186: areturn
    //   187: aload_0
    //   188: getfield 89	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:fl	Ljava/util/List;
    //   191: aload 5
    //   193: invokeinterface 209 2 0
    //   198: pop
    //   199: aload 4
    //   201: ifnull +8 -> 209
    //   204: aload 4
    //   206: invokevirtual 1067	java/io/InputStream:close	()V
    //   209: aload 5
    //   211: astore_3
    //   212: aload_1
    //   213: ifnull -115 -> 98
    //   216: aload_1
    //   217: invokevirtual 1068	java/io/OutputStream:close	()V
    //   220: aload 5
    //   222: areturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 1069	java/io/IOException:printStackTrace	()V
    //   228: aload 5
    //   230: areturn
    //   231: astore_3
    //   232: aload_3
    //   233: invokevirtual 1069	java/io/IOException:printStackTrace	()V
    //   236: goto -27 -> 209
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 1069	java/io/IOException:printStackTrace	()V
    //   244: goto -79 -> 165
    //   247: astore_3
    //   248: aconst_null
    //   249: astore_1
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 1067	java/io/InputStream:close	()V
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 1068	java/io/OutputStream:close	()V
    //   271: aload_3
    //   272: athrow
    //   273: astore 4
    //   275: aload 4
    //   277: invokevirtual 1069	java/io/IOException:printStackTrace	()V
    //   280: goto -17 -> 263
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 1069	java/io/IOException:printStackTrace	()V
    //   288: goto -17 -> 271
    //   291: astore_3
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -41 -> 253
    //   297: astore_3
    //   298: goto -45 -> 253
    //   301: astore 5
    //   303: aload_3
    //   304: astore 4
    //   306: aload 5
    //   308: astore_3
    //   309: goto -56 -> 253
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_1
    //   315: goto -164 -> 151
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_1
    //   321: aload 4
    //   323: astore_3
    //   324: goto -173 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	ReadInJoyDeliverUGCActivity
    //   0	327	1	paramString	String
    //   132	9	2	i	int
    //   1	138	3	localObject1	Object
    //   147	1	3	localException	Exception
    //   150	62	3	localObject2	Object
    //   231	2	3	localIOException1	java.io.IOException
    //   239	2	3	localIOException2	java.io.IOException
    //   247	25	3	localObject3	Object
    //   291	1	3	localObject4	Object
    //   297	7	3	localObject5	Object
    //   308	16	3	localObject6	Object
    //   29	230	4	localObject7	Object
    //   273	3	4	localIOException3	java.io.IOException
    //   304	18	4	localObject8	Object
    //   13	216	5	str	String
    //   301	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   120	126	147	java/lang/Exception
    //   126	133	147	java/lang/Exception
    //   137	144	147	java/lang/Exception
    //   187	199	147	java/lang/Exception
    //   172	176	179	java/io/IOException
    //   216	220	223	java/io/IOException
    //   204	209	231	java/io/IOException
    //   161	165	239	java/io/IOException
    //   100	110	247	finally
    //   258	263	273	java/io/IOException
    //   267	271	283	java/io/IOException
    //   110	120	291	finally
    //   120	126	297	finally
    //   126	133	297	finally
    //   137	144	297	finally
    //   187	199	297	finally
    //   151	157	301	finally
    //   100	110	312	java/lang/Exception
    //   110	120	318	java/lang/Exception
  }
  
  public void finish()
  {
    if (this.av != null)
    {
      String str = this.av.toString();
      getIntent().putExtra("arg_result_json", str);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "finish resultJson=" + eS(str));
      }
    }
    super.finish();
  }
  
  public void initData()
  {
    boolean bool = false;
    this.afk = true;
    this.afl = true;
    this.aff = getIntent().getBooleanExtra("support_topic", false);
    this.afg = getIntent().getBooleanExtra("support_linkify", true);
    super.initData();
    this.Zp = "0X800865D";
    this.jdField_a_of_type_Mjt = new mjt(getApplicationContext(), 3);
    this.jdField_a_of_type_Mjt.a(new mjb(this));
    this.jdField_a_of_type_Mjt.a(new mjg(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnItemLongClickListener(new mjh(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setOnDragListener(new mji(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView.setAdapter(this.jdField_a_of_type_Mjt);
    aPo();
    this.Zm = getIntent().getStringExtra("arg_topic_id");
    this.Zn = getIntent().getStringExtra("arg_topic_name");
    this.aIP = getIntent().getIntExtra("arg_ad_tag", 0);
    this.Zo = getIntent().getStringExtra("arg_ugc_edit_cookie");
    this.amT = getIntent().getBooleanExtra("is_from_dian_dian", false);
    this.amW = getIntent().getBooleanExtra("is_from_kan_dian", false);
    this.anc = getIntent().getBooleanExtra("is_from_poly_topic", false);
    lcc.a().b(this.e);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "initData mTopicId=" + this.Zm + ", mTopicName=" + this.Zn + ", mAdTag=" + this.aIP);
    }
    String str1;
    if (TextUtils.isEmpty(this.Zm))
    {
      str1 = "0";
      if (!this.amT) {
        break label421;
      }
    }
    label421:
    for (String str2 = "1";; str2 = "2")
    {
      kbp.a(null, "", "0X8008237", "0X8008237", 0, 0, "", str1, str2, kxm.iS(), false);
      if (awit.u(this.app) == 0) {
        bool = true;
      }
      this.afe = bool;
      if ((!this.afe) && (this.hZ != null)) {
        this.hZ.setVisibility(8);
      }
      aPi();
      return;
      str1 = String.valueOf(this.Zm);
      break;
    }
  }
  
  public void initViews()
  {
    this.aIO = 178;
    super.initViews();
    this.mProgress = new arhz(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView = ((ReadInJoyNinePicDeliverDynamicGridView)findViewById(2131376727));
    this.hY = ((ImageView)findViewById(2131368018));
    this.ia = ((ImageView)findViewById(2131380071));
    int i = awit.t(this.app);
    if ((!ahzd.a(this.app).aoB()) || (i == 1) || (this.aTu == 1)) {
      this.hY.setVisibility(8);
    }
    while (this.aTu == 1)
    {
      this.ia.setVisibility(8);
      return;
      this.hY.setOnClickListener(this);
    }
    this.ia.setOnClickListener(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1002))
    {
      paramInt1 = paramIntent.getIntExtra("PhotoConst.readinjoy_delete_pic_position", -1);
      if (paramInt1 != -1) {
        rT(paramInt1);
      }
      this.aIL = 0;
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.aIK == 2) || (this.aIK == 3))
    {
      oM(0);
      return true;
    }
    if (((this.N.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Mjt.getItems().size() > 1)) && (!this.anb))
    {
      aCX();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aGf();
      continue;
      if ((this.aIK == 2) || (this.aIK == 3)) {
        oM(0);
      }
      if (((this.N.getEditableText().toString().trim().length() > 0) || (this.jdField_a_of_type_Mjt.getItems().size() > 1)) && (!this.anb))
      {
        aCX();
      }
      else
      {
        finish();
        continue;
        if ((this.aTu != 1) || (pu() != 0)) {
          zp();
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void showLoading(int paramInt)
  {
    this.mProgress = new arhz(this, super.getTitleBarHeight());
    this.mProgress.setOnDismissListener(new mjf(this));
    this.mProgress.setMessage(paramInt);
    if (!this.mProgress.isShowing()) {
      this.mProgress.show();
    }
  }
  
  /* Error */
  public boolean zp()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 414	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 507	com/tencent/mobileqq/app/QQAppInterface:a	()Laooi;
    //   7: aload_0
    //   8: invokevirtual 1279	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   11: new 1281	mjd
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 1282	mjd:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity;)V
    //   19: invokevirtual 1285	aooi:a	(Ljava/lang/String;Laooi$b;)V
    //   22: invokestatic 855	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +13 -> 38
    //   28: ldc_w 857
    //   31: iconst_2
    //   32: ldc_w 1287
    //   35: invokestatic 862	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: ldc 118
    //   41: ldc_w 1289
    //   44: ldc_w 1289
    //   47: iconst_0
    //   48: iconst_0
    //   49: aload_0
    //   50: invokespecial 837	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:pt	()I
    //   53: invokestatic 729	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   56: aload_0
    //   57: invokespecial 141	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:pu	()I
    //   60: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: invokevirtual 1290	java/lang/Integer:toString	()Ljava/lang/String;
    //   66: ldc 118
    //   68: aload_0
    //   69: invokevirtual 1293	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:ih	()Ljava/lang/String;
    //   72: iconst_0
    //   73: invokestatic 703	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   76: aload_0
    //   77: invokespecial 1294	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:zp	()Z
    //   80: ifne +5 -> 85
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_0
    //   86: invokespecial 141	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:pu	()I
    //   89: ifne +167 -> 256
    //   92: iconst_1
    //   93: istore_1
    //   94: aload_0
    //   95: getfield 125	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:av	Lorg/json/JSONObject;
    //   98: ldc_w 1296
    //   101: iload_1
    //   102: invokevirtual 548	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_0
    //   107: ldc_w 1297
    //   110: invokevirtual 1299	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:showLoading	(I)V
    //   113: aload_0
    //   114: iconst_1
    //   115: putfield 563	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:isUpdating	Z
    //   118: aload_0
    //   119: new 86	java/util/ArrayList
    //   122: dup
    //   123: invokespecial 87	java/util/ArrayList:<init>	()V
    //   126: putfield 302	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:multiBiuStruct	Ljava/util/ArrayList;
    //   129: aload_0
    //   130: getfield 224	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:N	Landroid/widget/EditText;
    //   133: aload_0
    //   134: getfield 414	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   137: invokevirtual 748	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 530	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:afl	Z
    //   144: aload_0
    //   145: getfield 302	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:multiBiuStruct	Ljava/util/ArrayList;
    //   148: invokestatic 1302	mkt:a	(Landroid/widget/EditText;Ljava/lang/String;ZLjava/util/List;)Z
    //   151: pop
    //   152: aload_0
    //   153: invokestatic 738	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   156: putfield 740	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:wd	J
    //   159: iload_1
    //   160: iconst_1
    //   161: if_icmpne +149 -> 310
    //   164: aload_0
    //   165: getfield 125	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:av	Lorg/json/JSONObject;
    //   168: ldc_w 1304
    //   171: iconst_0
    //   172: invokevirtual 548	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   175: pop
    //   176: invokestatic 1309	lbz:a	()Llbz;
    //   179: aload_0
    //   180: getfield 414	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: invokevirtual 1312	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   186: aload_0
    //   187: getfield 299	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:Zm	Ljava/lang/String;
    //   190: aload_0
    //   191: getfield 522	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:Zo	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 518	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:aIP	I
    //   198: aload_0
    //   199: getfield 91	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jb	Ljava/util/List;
    //   202: aload_0
    //   203: invokevirtual 574	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:ii	()Ljava/lang/String;
    //   206: aconst_null
    //   207: aload_0
    //   208: getfield 106	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   211: invokevirtual 1316	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:x	()[I
    //   214: aload_0
    //   215: getfield 106	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity$DeliverData	Lcom/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData;
    //   218: invokevirtual 1319	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity$DeliverData:w	()[I
    //   221: aconst_null
    //   222: aload_0
    //   223: getfield 481	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:aTr	I
    //   226: aload_0
    //   227: getfield 302	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:multiBiuStruct	Ljava/util/ArrayList;
    //   230: aload_0
    //   231: getfield 578	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:amT	Z
    //   234: aload_0
    //   235: getfield 290	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI	Lcom/tencent/mobileqq/troop/data/TroopBarPOI;
    //   238: aload_0
    //   239: getfield 236	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam	Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;
    //   242: aload_0
    //   243: getfield 632	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:aTu	I
    //   246: invokevirtual 1322	lbz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;[Ljava/lang/String;[I[I[Ljava/lang/String;ILjava/util/ArrayList;ZLcom/tencent/mobileqq/troop/data/TroopBarPOI;Lcom/tencent/biz/pubaccount/readinjoy/struct/VisibleSetParam;I)V
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 563	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:isUpdating	Z
    //   254: iconst_1
    //   255: ireturn
    //   256: aload_0
    //   257: getfield 1325	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:afj	Z
    //   260: ifne +150 -> 410
    //   263: aload_0
    //   264: invokestatic 1331	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   267: ifne +143 -> 410
    //   270: aload_0
    //   271: invokevirtual 1334	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:aCZ	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_2
    //   277: ldc_w 857
    //   280: iconst_2
    //   281: new 830	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 1336
    //   291: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_2
    //   295: invokevirtual 1337	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 862	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: goto -201 -> 106
    //   310: aload_0
    //   311: getfield 143	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:jdField_a_of_type_Mjt	Lmjt;
    //   314: invokevirtual 149	mjt:getItems	()Ljava/util/List;
    //   317: astore_2
    //   318: iconst_0
    //   319: istore_1
    //   320: aload_2
    //   321: invokeinterface 491 1 0
    //   326: astore_2
    //   327: aload_2
    //   328: invokeinterface 496 1 0
    //   333: ifeq -79 -> 254
    //   336: aload_2
    //   337: invokeinterface 499 1 0
    //   342: astore_3
    //   343: aload_0
    //   344: getfield 563	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:isUpdating	Z
    //   347: ifeq +57 -> 404
    //   350: invokestatic 855	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +30 -> 383
    //   356: ldc_w 857
    //   359: iconst_2
    //   360: new 830	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 831	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 1339
    //   370: invokevirtual 835	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload_1
    //   374: invokevirtual 840	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 841	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 862	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload_0
    //   384: iload_1
    //   385: invokespecial 1341	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:dR	(I)Z
    //   388: ifeq +9 -> 397
    //   391: aload_0
    //   392: aload_3
    //   393: iload_1
    //   394: invokespecial 1343	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:f	(Ljava/lang/Object;I)V
    //   397: iload_1
    //   398: iconst_1
    //   399: iadd
    //   400: istore_1
    //   401: goto -74 -> 327
    //   404: iconst_1
    //   405: ireturn
    //   406: astore_2
    //   407: goto -231 -> 176
    //   410: iconst_2
    //   411: istore_1
    //   412: goto -318 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	ReadInJoyDeliverUGCActivity
    //   93	319	1	i	int
    //   276	19	2	localException1	Exception
    //   317	20	2	localObject1	Object
    //   406	1	2	localException2	Exception
    //   342	51	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   94	106	276	java/lang/Exception
    //   164	176	406	java/lang/Exception
  }
  
  public static class DeliverData
    implements Parcelable
  {
    public static final Parcelable.Creator<DeliverData> CREATOR = new mjl();
    private int aTv = 9;
    private String[] bw = new String[this.aTv];
    private String[] bx = new String[this.aTv];
    private int[] dm = new int[this.aTv];
    private int[] dn = new int[this.aTv];
    
    public DeliverData() {}
    
    public DeliverData(Parcel paramParcel)
    {
      if (paramParcel.readInt() > 0) {
        paramParcel.readIntArray(this.dm);
      }
      if (paramParcel.readInt() > 0) {
        paramParcel.readIntArray(this.dn);
      }
      if (paramParcel.readInt() > 0) {
        paramParcel.readStringArray(this.bw);
      }
      if (paramParcel.readInt() > 0) {
        paramParcel.readStringArray(this.bx);
      }
    }
    
    public String[] A()
    {
      return this.bx;
    }
    
    public void a(int paramInt, Integer paramInteger)
    {
      if (paramInt < this.aTv) {
        this.dm[paramInt] = paramInteger.intValue();
      }
    }
    
    public void aw(int paramInt, String paramString)
    {
      if (paramInt < this.aTv) {
        this.bw[paramInt] = paramString;
      }
    }
    
    public void ax(int paramInt, String paramString)
    {
      if (paramInt < this.aTv) {
        this.bx[paramInt] = paramString;
      }
    }
    
    public void b(int paramInt, Integer paramInteger)
    {
      if (paramInt < this.aTv) {
        this.dn[paramInt] = paramInteger.intValue();
      }
    }
    
    public void clear()
    {
      this.dm = new int[this.aTv];
      this.dn = new int[this.aTv];
      this.bw = new String[this.aTv];
      this.bx = new String[this.aTv];
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int[] w()
    {
      return this.dm;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if ((this.dm != null) && (this.dm.length > 0))
      {
        paramParcel.writeInt(this.dm.length);
        paramParcel.writeIntArray(this.dm);
        if ((this.dn == null) || (this.dn.length <= 0)) {
          break label137;
        }
        paramParcel.writeInt(this.dn.length);
        paramParcel.writeIntArray(this.dn);
        label64:
        if ((this.bw == null) || (this.bw.length <= 0)) {
          break label145;
        }
        paramParcel.writeInt(this.bw.length);
        paramParcel.writeStringArray(this.bw);
      }
      for (;;)
      {
        if ((this.bx == null) || (this.bx.length <= 0)) {
          break label153;
        }
        paramParcel.writeInt(this.bx.length);
        paramParcel.writeStringArray(this.bx);
        return;
        paramParcel.writeInt(0);
        break;
        label137:
        paramParcel.writeInt(0);
        break label64;
        label145:
        paramParcel.writeInt(0);
      }
      label153:
      paramParcel.writeInt(0);
    }
    
    public int[] x()
    {
      return this.dn;
    }
    
    public String[] z()
    {
      return this.bw;
    }
  }
  
  public class a
  {
    private long[] I = new long[this.aTv];
    private long[] J = new long[this.aTv];
    private long[] K = new long[this.aTv];
    private long[] L = new long[this.aTv];
    private long[] M = new long[this.aTv];
    private long[] N = new long[this.aTv];
    private int aTv = 9;
    
    public a() {}
    
    public void H(int paramInt, long paramLong)
    {
      if (paramInt < this.aTv) {
        this.I[paramInt] = paramLong;
      }
    }
    
    public void I(int paramInt, long paramLong)
    {
      if (paramInt < this.aTv) {
        this.J[paramInt] = paramLong;
      }
    }
    
    public void J(int paramInt, long paramLong)
    {
      if (paramInt < this.aTv) {
        this.K[paramInt] = paramLong;
      }
    }
    
    public void K(int paramInt, long paramLong)
    {
      if (paramInt < this.aTv) {
        this.L[paramInt] = paramLong;
      }
    }
    
    public void L(int paramInt, long paramLong)
    {
      if (paramInt < this.aTv) {
        this.M[paramInt] = paramLong;
      }
    }
    
    public void M(int paramInt, long paramLong)
    {
      if (paramInt < this.aTv) {
        this.N[paramInt] = paramLong;
      }
    }
    
    public long[] a()
    {
      return this.K;
    }
    
    public long[] b()
    {
      return this.L;
    }
    
    public long[] c()
    {
      return this.J;
    }
    
    public long[] e()
    {
      return this.I;
    }
    
    public long[] f()
    {
      return this.N;
    }
    
    public long[] g()
    {
      return this.M;
    }
  }
  
  class b
    extends aook
  {
    boolean and = false;
    
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      aoko localaoko = (aoko)paramMessage.obj;
      if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 10)) {}
      do
      {
        do
        {
          for (;;)
          {
            return;
            switch (paramMessage.what)
            {
            default: 
              return;
            case 1003: 
              if (this.and)
              {
                int j = (int)localaoko.uniseq;
                ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).M(j, NetConnInfoCenter.getServerTimeMillis());
                kbp.a(ReadInJoyDeliverUGCActivity.this.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).e()[j]), String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).c()[j]), String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).b()[j] - ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).a()[j]), String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).f()[j] - ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).g()[j]));
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send finished!");
                }
                try
                {
                  ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).put("picCount", 1);
                  paramMessage = new JSONArray();
                  localObject = new JSONObject();
                  ((JSONObject)localObject).put("url", localaoko.fileUrl);
                  ((JSONObject)localObject).put("md5", localaoko.fileMd5);
                  paramMessage.put(localObject);
                  ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).put("picList", paramMessage);
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=" + ReadInJoyDeliverUGCActivity.eS(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).toString()));
                  }
                  if ((j < ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this)) && (!localaoko.fileUrl.equals(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).z()[j])) && (!localaoko.fileMd5.equals(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).A()[j])))
                  {
                    paramMessage = ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).getItems();
                    localObject = paramMessage.get(j);
                    localObject = ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this, localObject);
                    i = j;
                    if ((i < paramMessage.size()) && (!ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).equals(paramMessage.get(i)))) {}
                  }
                  else
                  {
                    if ((ReadInJoyDeliverUGCActivity.d(ReadInJoyDeliverUGCActivity.this) != ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this)) || (ReadInJoyDeliverUGCActivity.g(ReadInJoyDeliverUGCActivity.this))) {
                      continue;
                    }
                    ReadInJoyDeliverUGCActivity.d(ReadInJoyDeliverUGCActivity.this, true);
                    lbz.a().a(ReadInJoyDeliverUGCActivity.this.app.getCurrentUin(), ReadInJoyDeliverUGCActivity.c(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.b(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.e(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.e(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).z(), ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).w(), ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).x(), ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).A(), ReadInJoyDeliverUGCActivity.d(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.d(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.b(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.b(ReadInJoyDeliverUGCActivity.this), ReadInJoyDeliverUGCActivity.g(ReadInJoyDeliverUGCActivity.this));
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("ReadInJoyDeliverUGCActivity", 2, "allFinishUp");
                    return;
                  }
                }
                catch (Exception paramMessage)
                {
                  Object localObject;
                  for (;;)
                  {
                    QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=log error");
                  }
                  if (i == j)
                  {
                    ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).aw(i, localaoko.fileUrl);
                    ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).ax(i, localaoko.fileMd5);
                    ReadInJoyDeliverUGCActivity.f(ReadInJoyDeliverUGCActivity.this);
                    if (QLog.isColorLevel()) {
                      QLog.d("ReadInJoyDeliverUGCActivity", 2, "finishUp" + i);
                    }
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    if (((String)localObject).equals(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this, paramMessage.get(i))))
                    {
                      ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).aw(i, localaoko.fileUrl);
                      ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).ax(i, localaoko.fileMd5);
                      ReadInJoyDeliverUGCActivity.f(ReadInJoyDeliverUGCActivity.this);
                      if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyDeliverUGCActivity", 2, "finishUp" + i);
                      }
                    }
                  }
                }
              }
              break;
            }
          }
        } while (!this.and);
        int i = (int)localaoko.uniseq;
        ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).M(i, NetConnInfoCenter.getServerTimeMillis());
        kbp.a(ReadInJoyDeliverUGCActivity.this.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).e()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).b()[i] - ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).f()[i] - ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.this).g()[i]));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send error or cancel!");
        }
        ReadInJoyDeliverUGCActivity.this.aAt();
        ReadInJoyDeliverUGCActivity.this.aCY();
        ReadInJoyDeliverUGCActivity.c(ReadInJoyDeliverUGCActivity.this, 1002);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "handleMessage: FileMsg.STATUS_SEND_CANCEL.\nfilePath: " + localaoko.filePath + "\nfileMd5: " + localaoko.fileMd5 + "\nfileUrl: " + localaoko.fileUrl + "\n");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity
 * JD-Core Version:    0.7.0.1
 */