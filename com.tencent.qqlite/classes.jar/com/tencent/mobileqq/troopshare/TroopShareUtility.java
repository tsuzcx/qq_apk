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
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
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
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.ActionSheetHelper;
import eri;
import erj;
import erk;
import erl;
import erm;
import ern;
import java.util.ArrayList;
import java.util.List;

public class TroopShareUtility
  implements WXShareHelper.WXShareListener
{
  private static final int jdField_a_of_type_Int = -1;
  public static final String a = "TroopShareUtility";
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ern(this);
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private ActionSheetAdapter jdField_a_of_type_ComTencentWidgetActionSheetAdapter = null;
  public boolean a;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = -1;
  private String jdField_e_of_type_JavaLangString;
  
  public TroopShareUtility(BaseActivity paramBaseActivity, TroopInfoData paramTroopInfoData)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
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
    int m = ((BitMatrix)localObject).a();
    paramString = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      if (j < m)
      {
        if (((BitMatrix)localObject).a(j, i)) {}
        for (int k = -16777216;; k = 16777215)
        {
          paramString[(i * m + j)] = k;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
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
      paramResources = BitmapFactory.decodeResource(paramResources, 2130838017);
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
    if (this.jdField_e_of_type_Int == -1) {
      return null;
    }
    if (this.jdField_e_of_type_Int == 0) {
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
    return this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int + "/" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.u + "\n" + str + "\n" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363704);
  }
  
  private void h()
  {
    Object localObject1 = null;
    label48:
    QQAppInterface localQQAppInterface;
    if (this.jdField_e_of_type_Int == 1)
    {
      localObject2 = "0";
      switch (this.jdField_d_of_type_Int)
      {
      default: 
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Grp", (String)localObject1, 0, 0, (String)localObject2, "", "", "");
        bool = NetworkUtil.e(BaseApplication.getContext());
        if ((!bool) && (this.jdField_d_of_type_Int != 3))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362790), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
          }
          this.jdField_d_of_type_Int = -1;
          this.jdField_e_of_type_Int = -1;
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
      localObject2 = "1";
      break;
      localObject1 = "Grplink_moments";
      break label48;
      localObject1 = "Grplink_wechat";
      break label48;
      localObject1 = "Grplink_qq";
      break label48;
      localObject1 = "Copy_grplink";
      break label48;
      if (a() != null) {
        break label352;
      }
      if ((bool) || (this.jdField_d_of_type_Int != 3)) {
        break label308;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362790), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
      }
      this.jdField_d_of_type_Int = -1;
      this.jdField_e_of_type_Int = -1;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity));
    ((TroopCreateLogicActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
    return;
    label308:
    a();
    localObject1 = (TroopHandler)localQQAppInterface.a(17);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    if (this.jdField_e_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((TroopHandler)localObject1).a((String)localObject2, bool);
      return;
    }
    label352:
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    case 0: 
      String str = localQQAppInterface.a(4, 3000, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      localObject2 = localQQAppInterface.a(str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localQQAppInterface.b(str);
      }
      if (localObject1 != null) {
        this.jdField_d_of_type_JavaLangString = ((Setting)localObject1).url;
      }
      if (this.jdField_d_of_type_JavaLangString == null) {
        ((FriendListHandler)localQQAppInterface.a(1)).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      k();
      return;
    case 2: 
      i();
      return;
    case 1: 
      j();
      return;
    }
    l();
  }
  
  private void i()
  {
    this.jdField_e_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = a(((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)1, false, false));
    String str3 = a();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363706), new Object[] { str1 }) + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")";
    WXShareHelper.a().a(this.jdField_e_of_type_JavaLangString, str1, localBitmap, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, str3);
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "shareToFriendCircle.transaction: " + this.jdField_e_of_type_JavaLangString + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m + " shareLink:" + str3);
    }
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  private void j()
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    Bitmap localBitmap = a(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130838297));
    String str2 = a();
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    if (TextUtils.isEmpty(localStringBuffer)) {
      localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    }
    localStringBuffer.append("(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")");
    String str3 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
    WXShareHelper.a().b(str1, localStringBuffer.toString(), localBitmap, str3, str2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "shareToWXFriend.transaction: " + str1 + " troopname:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + " memo:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l + " shareLink:" + str2);
    }
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  private void k()
  {
    String str1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363700);
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363699) + (String)localObject1).e(a()).a((String)localObject2, null).a();
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      str1 = this.jdField_d_of_type_JavaLangString + "100";
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363703);
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
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  @TargetApi(11)
  private void l()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    str1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363701), new Object[] { str1, a() });
    if (QLog.isColorLevel()) {
      QLog.i("TroopShareUtility", 2, "copyTroopLink.text:" + str1);
    }
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("clipboard")).setText(str1);
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363702), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_d_of_type_Int = -1;
      this.jdField_e_of_type_Int = -1;
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363558);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
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
    if ((this.jdField_e_of_type_JavaLangString == null) || (!this.jdField_e_of_type_JavaLangString.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363689), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363688), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    Object localObject = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {}
    for (int i = 4;; i = 3)
    {
      int j = 0;
      while (j <= i)
      {
        ((List)localObject).add(ActionSheetAdapter.a(j));
        j += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a((List)localObject);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      localObject = new eri(this);
      erj localerj = new erj(this);
      erk localerk = new erk(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, (AdapterView.OnItemClickListener)localObject, localerj, localerk, false);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, 2131624119));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131363695);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131363696);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.d(2131362794);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new erl(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new erm(this));
    String str;
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363694);
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
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363691), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363692) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363691), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363693) });
      continue;
      str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363691), new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363686) });
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    WXShareHelper.a().b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
    localIntent.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131362424));
    localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("GroupFlagExt", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.b);
    localIntent.putExtra("AuthGroupType", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long);
    localIntent.putExtra("face", ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)3, false, false));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility
 * JD-Core Version:    0.7.0.1
 */