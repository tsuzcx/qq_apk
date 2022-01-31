package com.tencent.mobileqq.troopshare;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QZoneShareManager;
import gzw;
import gzx;
import gzy;
import gzz;
import haa;
import java.util.ArrayList;

public class TroopShareUtility
  implements WXShareHelper.WXShareListener
{
  private static final int jdField_a_of_type_Int = -1;
  public static final String a = "TroopShareUtility";
  private static final int jdField_b_of_type_Int = 3;
  private static final int jdField_c_of_type_Int = 4;
  private static final int jdField_d_of_type_Int = 2;
  private static final int jdField_e_of_type_Int = 1;
  private static final int f = 5;
  private static final int g = 0;
  private static final int h = -1;
  private static final int i = 0;
  private static final int j = 1;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new haa(this);
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public boolean a;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private int k = -1;
  private int l = -1;
  
  public TroopShareUtility(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    WXShareHelper.a().a(this);
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    if (paramBitmap != null)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
    }
    return localBitmap;
  }
  
  public static Bitmap a(String paramString, Resources paramResources)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = QRUtils.a(paramString, -1);
    int i2 = ((BitMatrix)localObject).a();
    paramString = new int[i2 * i2];
    int m = 0;
    while (m < i2)
    {
      int n = 0;
      if (n < i2)
      {
        if (((BitMatrix)localObject).a(n, m)) {}
        for (int i1 = -16777216;; i1 = 16777215)
        {
          paramString[(m * i2 + n)] = i1;
          n += 1;
          break;
        }
      }
      m += 1;
    }
    localObject = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, i2, 0, 0, i2, i2);
    try
    {
      paramString = Bitmap.createBitmap(540, 540, Bitmap.Config.ARGB_8888);
      if (paramString == null)
      {
        ((Bitmap)localObject).recycle();
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = Bitmap.createBitmap(540, 540, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopShareUtility", 2, paramString.getMessage());
          }
          return null;
        }
      }
      Canvas localCanvas = new Canvas(paramString);
      Paint localPaint = new Paint();
      localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
      localCanvas.drawRect(0.0F, 0.0F, 540.0F, 540.0F, localPaint);
      localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(70, 70, 470, 470), null);
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Rect localRect = new Rect(217, 217, 323, 323);
      paramResources = BitmapFactory.decodeResource(paramResources, 2130837996);
      localCanvas.drawBitmap(paramResources, null, localRect, localPaint);
      paramResources.recycle();
      ((Bitmap)localObject).recycle();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "getQrCode cost time:" + (l2 - l1));
      }
    }
    return paramString;
  }
  
  private String a()
  {
    if (this.l == -1) {
      return null;
    }
    if (this.l == 0) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals(""))
      {
        paramString.trim();
        str = paramString;
        if (paramString.length() >= 16) {
          str = paramString.substring(0, 16) + "...";
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int + "/" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.u + "\n" + str + "\n" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131561837);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        this.jdField_a_of_type_Boolean = true;
      }
      d();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.l = 0;
    h();
  }
  
  private void h()
  {
    Object localObject = null;
    String str;
    label52:
    QQAppInterface localQQAppInterface;
    if (this.l == 1)
    {
      str = "0";
      switch (this.k)
      {
      default: 
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject, 0, 0, str, "", "", "");
        bool = NetworkUtil.e(BaseApplication.getContext());
        if ((!bool) && (this.k != 5))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562452), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
          if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
          }
          this.k = -1;
          this.l = -1;
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          }
        }
        break;
      }
    }
    do
    {
      return;
      str = "1";
      break;
      localObject = "Grplink_moments";
      break label52;
      localObject = "Grplink_wechat";
      break label52;
      localObject = "Grplink_qq";
      break label52;
      localObject = "Grplink_qzone";
      break label52;
      localObject = "Copy_grplink";
      break label52;
      if (a() != null) {
        break label353;
      }
      if ((bool) || (this.k != 5)) {
        break label319;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562452), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      this.k = -1;
      this.l = -1;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity));
    ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
    return;
    label319:
    a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    if (this.l == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localQQAppInterface.a((String)localObject, bool);
      return;
    }
    label353:
    switch (this.k)
    {
    default: 
      return;
    case 1: 
      i();
      return;
    case 2: 
      j();
      return;
    case 3: 
      localObject = localQQAppInterface.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      if (localObject != null) {
        this.d = ((Setting)localObject).url;
      }
      if (this.d == null) {
        ((FriendListHandler)localQQAppInterface.a(1)).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      l();
      return;
    case 4: 
      k();
      return;
    }
    m();
  }
  
  private void i()
  {
    this.e = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = a(((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)1, false, false));
    String str3 = a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131561849), new Object[] { str1 }) + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")";
    WXShareHelper.a().a(this.e, str1, localBitmap, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, str3);
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "shareToFriendCircle.transaction: " + this.e + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m + " shareLink:" + str3);
    }
    this.k = -1;
    this.l = -1;
  }
  
  private void j()
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    localObject = a(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130838415));
    String str2 = a();
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    if (TextUtils.isEmpty(localStringBuffer)) {
      localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    }
    localStringBuffer.append("(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")");
    String str3 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
    WXShareHelper.a().b(str1, localStringBuffer.toString(), (Bitmap)localObject, str3, str2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "shareToWXFriend.transaction: " + str1 + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l + " shareLink:" + str2);
    }
    this.k = -1;
    this.l = -1;
  }
  
  private void k()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    Object localObject = "temp_troop_link_share_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ".png";
    String str2 = QRUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject, a(a(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
    if (TextUtils.isEmpty(str2))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131562035, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
      this.k = -1;
      this.l = -1;
      return;
    }
    String str3 = a();
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(str2)) {
      localArrayList.add(str2);
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131560597), new Object[] { localObject }) + "(" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562197) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")," + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131560598) + a();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", (String)localObject);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m.equals(""))) {
      localBundle.putString("desc", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562266));
    }
    for (;;)
    {
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", str3);
      localBundle.putString("url", str3);
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("troop_wording", str1);
      localBundle.putString("bizname", "JoinTroopLink");
      QZoneShareManager.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle, null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "shareToQzone.troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + " filePath:" + str2 + " shareLink:" + str3 + " desc:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
      }
      this.k = -1;
      this.l = -1;
      return;
      localBundle.putString("desc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
    }
  }
  
  private void l()
  {
    String str1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562253);
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562733) + (String)localObject1).c(a()).a((String)localObject2, null).a();
    if (!TextUtils.isEmpty(this.d)) {
      str1 = this.d + "100";
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "shareToMobileQQ.coverUrl:" + str1);
    }
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
    if (str2 != null)
    {
      localObject2 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562266);
    }
    localAbsStructMsgItem.a(str1, (String)localObject1, (String)localObject2);
    localAbsShareMsg.addItem(localAbsStructMsgItem);
    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ForwardRecentActivity.class);
    ((Intent)localObject1).putExtra("forward_type", -3);
    ((Intent)localObject1).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject1, 4);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "shareToMobileQQ.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + str1 + " mSourceName:" + localAbsShareMsg.mSourceName);
    }
    this.k = -1;
    this.l = -1;
  }
  
  @TargetApi(11)
  private void m()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562122), new Object[] { str1, a() });
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "copyTroopLink.text:" + str1);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setText(str1);
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562246), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
      this.k = -1;
      this.l = -1;
      return;
      ((android.content.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("troop_url", str1));
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.e == null) || (!this.e.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562035), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562917), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
  }
  
  public void a(TroopInfoData paramTroopInfoData)
  {
    ReportController.b((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    c();
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopShareUtility", 2, localException.toString());
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131562908);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new gzw(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562137);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131562715);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131560516);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131561882);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new gzx(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void d()
  {
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131561682);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131563148);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.d(2131561746);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new gzy(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new gzz(this));
    String str;
    switch (this.k)
    {
    default: 
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562640);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(str);
      if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562284), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563208) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562284), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563207) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562284), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562137) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562284), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562715) });
    }
  }
  
  public void e()
  {
    this.k = -1;
    this.l = -1;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    WXShareHelper.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131560515));
    localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("GroupFlagExt", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.b);
    localIntent.putExtra("AuthGroupType", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long);
    localIntent.putExtra("face", ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)3, false, false));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility
 * JD-Core Version:    0.7.0.1
 */