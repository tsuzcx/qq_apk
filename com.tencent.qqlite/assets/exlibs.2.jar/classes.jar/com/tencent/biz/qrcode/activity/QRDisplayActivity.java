package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import pu;
import pv;
import pw;
import px;
import py;
import qa;
import qb;
import qc;
import qd;
import qe;
import qg;
import qh;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, CodeMaskManager.Callback
{
  protected static final int a = 60000;
  public static final String a;
  protected static final int b = 1;
  public static final String b = "qrcode";
  protected static final int c = 2;
  public static final String c = "user";
  public static final String d = "group";
  public static final String e = "discussion";
  protected static final int h = -160;
  protected static final int i = -161;
  protected static final String k = "memberUin";
  protected long a;
  public Bitmap a;
  public Bundle a;
  protected Handler a;
  protected View a;
  public ImageView a;
  public BitMatrix a;
  protected CodeMaskManager a;
  QRDisplayActivity.GetNicknameObserver jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver = new pu(this);
  public DiscussionHandler a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new px(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public Runnable a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public long b;
  public Bitmap b;
  public View b;
  public ActionSheet b;
  public Runnable b;
  public List b;
  public boolean b;
  public View c;
  protected Runnable c;
  protected boolean c;
  protected int d;
  public View d;
  public boolean d;
  public int e;
  public View e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  int j;
  public String j;
  public int k;
  public String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = QRDisplayActivity.class.getSimpleName();
  }
  
  public QRDisplayActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new py(this);
    this.jdField_b_of_type_JavaLangRunnable = new qa(this);
    this.jdField_c_of_type_JavaLangRunnable = new qb(this);
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramString = "user" + paramString;
    }
    for (;;)
    {
      paramString = getSharedPreferences("qrcode", 0).getString(paramString, null);
      if (paramString != null) {
        break label104;
      }
      return null;
      if (paramInt1 == 2)
      {
        paramString = "group" + paramString;
      }
      else
      {
        if (paramInt1 != 5) {
          break;
        }
        paramString = "discussion" + paramString;
      }
    }
    return null;
    label104:
    return QRUtils.a(paramString, paramInt2);
  }
  
  public String a()
  {
    String str;
    if (this.jdField_e_of_type_Int == 1) {
      str = "user" + this.jdField_h_of_type_JavaLangString;
    }
    for (;;)
    {
      return getSharedPreferences("qrcode", 0).getString(str, null);
      if (this.jdField_e_of_type_Int == 2)
      {
        str = "group" + this.jdField_h_of_type_JavaLangString;
      }
      else
      {
        if (this.jdField_e_of_type_Int != 5) {
          break;
        }
        str = "discussion" + this.jdField_h_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  public String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int m = 0;
    while (m < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(m));
      if (m != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      m += 1;
    }
    return localStringBuffer.toString();
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131362434, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131362435, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.d(2131362790);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new qc(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new qd(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = "获取讨论组链接失败";
    }
    for (;;)
    {
      a(2130837979, str);
      finish();
      return;
      str = "讨论组不存在";
      continue;
      str = "你已不在此讨论组";
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "template ready, draw qrcode");
    }
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int i2 = paramBundle.getInt("B");
    int i3 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      m = paramBundle.getInt("qrsz");
      localObject1 = a();
      if (localObject1 != null) {
        this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a((String)localObject1, m);
      }
    }
    int i4 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
    Object localObject1 = new int[i4 * i4];
    int m = 0;
    while (m < i4)
    {
      int n = 0;
      if (n < i4)
      {
        if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(n, m)) {}
        for (int i1 = i2;; i1 = i3)
        {
          localObject1[(m * i4 + n)] = i1;
          n += 1;
          break;
        }
      }
      m += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject1, 0, i4, 0, 0, i4, i4);
    Object localObject2 = null;
    localObject1 = localObject2;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_d_of_type_Int == 2) {
        localObject1 = BitmapFactory.decodeResource(getResources(), 2130838183);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = QRUtils.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.f, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.g, localRect, localArrayList, (Bitmap)localObject1);
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label434;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      localObject1 = localObject2;
      if (this.jdField_d_of_type_Int != 1) {
        break;
      }
      localObject1 = BitmapFactory.decodeResource(getResources(), 2130838246);
      break;
      label434:
      if (super.isResume())
      {
        paramBundle = DialogUtil.a(this, 230);
        paramBundle.setMessage(2131362380);
        paramBundle.setPositiveButton(2131362791, new qg(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 1) {}
    for (paramString1 = "user" + paramString1;; paramString1 = "group" + paramString1)
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      do
      {
        return;
      } while (paramInt != 2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void b()
  {
    ThreadManager.b(new qe(this));
    String str = null;
    if (this.jdField_e_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_e_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool2 = this.jdField_c_of_type_Boolean;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool2, bool1, this.jdField_d_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.jdField_e_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131362379);
      localQQCustomDialog.setPositiveButton(2131362791, new pv(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label91;
      }
      a(0, getString(2131362433));
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "shareQRCode success");
      }
      if ((this.k & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label91:
      if (paramInt1 == 2)
      {
        Intent localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtras(paramIntent);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2130903354);
    paramBundle = super.getIntent();
    this.k = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.f = paramBundle.getStringExtra("nick");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("type", 1);
    this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.jdField_d_of_type_Int = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    Object localObject2;
    Object localObject1;
    int m;
    if (this.jdField_e_of_type_Int == 1)
    {
      this.g = getString(2131362423);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297815);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297819));
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131297814);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297820);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131297821);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131297822);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131363857));
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "display qrcode, type: " + this.jdField_e_of_type_Int);
      }
      if (this.jdField_e_of_type_Int != 5) {
        break label1009;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(getString(2131362505));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131362506));
      setResult(-1, getIntent());
      paramBundle = (FriendsManagerImp)this.app.getManager(8);
      localObject2 = (DiscussionManager)this.app.getManager(45);
      localObject1 = ((DiscussionManager)localObject2).a(this.jdField_h_of_type_JavaLangString);
      if (localObject1 != null) {
        break label589;
      }
      d();
      m = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
      if (m != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.f + "," + this.g);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.k & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      return true;
      if (this.jdField_e_of_type_Int == 2)
      {
        this.g = getString(2131362424);
        break;
      }
      if (this.jdField_e_of_type_Int != 5) {
        break;
      }
      this.g = getString(2131362425);
      break;
      label589:
      localObject2 = ((DiscussionManager)localObject2).a(this.jdField_h_of_type_JavaLangString);
      if (localObject2 != null)
      {
        this.jdField_j_of_type_Int = ((List)localObject2).size();
        if ((((DiscussionInfo)localObject1).DiscussionFlag & 0x40) >>> 6 != 0L)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "title not defined, join by nicks");
          }
          if (localObject2 != null) {
            localObject1 = ((List)localObject2).iterator();
          }
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label833;
          }
          localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
          if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
          {
            this.jdField_b_of_type_JavaUtilList.add(ContactUtils.g(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
            continue;
            this.jdField_j_of_type_Int = 0;
            break;
          }
          Friends localFriends = paramBundle.c(((DiscussionMemberInfo)localObject2).memberUin);
          if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
            this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
          } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
            this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
          } else {
            this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
          }
        }
        label833:
        if ((this.jdField_b_of_type_JavaUtilList.size() < 5) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "fetch nicks from server");
          }
          paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          m = 0;
          while (((Iterator)localObject1).hasNext())
          {
            paramBundle[m] = ((String)((Iterator)localObject1).next());
            m += 1;
          }
          ((DiscussionHandler)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
        }
        for (int n = 0;; n = 1)
        {
          m = n;
          if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
            break;
          }
          Collections.sort(this.jdField_b_of_type_JavaUtilList, new qh(this));
          this.f = a(this.jdField_b_of_type_JavaUtilList);
          m = n;
          break;
        }
      }
      label1009:
      m = 1;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_e_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297821) {
      if (!this.jdField_a_of_type_Boolean) {
        a();
      }
    }
    while (paramView.getId() != 2131297825) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = new LinkShareActionSheetBuilder(this).a(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      label62:
      DiscussionInfoCardActivity.c += 1;
      ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramView)
    {
      break label62;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      int m = -1;
      if (!WXShareHelper.a().a()) {
        m = 2131363703;
      }
      for (;;)
      {
        if (m == -1) {
          break label89;
        }
        QRUtils.a(1, m);
        break;
        if (!WXShareHelper.a().b()) {
          m = 2131363704;
        }
      }
      label89:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new pw(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      paramView = this.app;
      label132:
      String str1;
      Bitmap localBitmap;
      String str2;
      if (paramInt == 1)
      {
        paramAdapterView = "1";
        ReportController.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        this.l = String.valueOf(System.currentTimeMillis());
        paramAdapterView = WXShareHelper.a();
        paramView = this.l;
        str1 = String.format(getString(2131363971), new Object[] { this.f });
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str2 = this.i;
        if (paramInt != 1) {
          break label249;
        }
      }
      label249:
      for (paramInt = 0;; paramInt = 1)
      {
        paramAdapterView.a(paramView, str1, localBitmap, "", str2, paramInt);
        break;
        paramAdapterView = "0";
        break label132;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363564);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.f, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.i, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity
 * JD-Core Version:    0.7.0.1
 */