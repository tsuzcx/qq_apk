package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import ara;
import arb;
import arc;
import ard;
import arf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividuationSetActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 5;
  public static final int e = 6;
  private static final int jdField_f_of_type_Int = 1;
  private static final int jdField_g_of_type_Int = 2;
  private static final int jdField_h_of_type_Int = 1;
  private static final int jdField_i_of_type_Int = 2;
  private static final int jdField_j_of_type_Int = 3;
  private static final int jdField_k_of_type_Int = 5;
  public float a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new ara(this);
  private SVIPHandler jdField_a_of_type_ComTencentMobileqqAppSVIPHandler;
  EmojiJsHandler jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler = null;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new arf(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View jdField_g_of_type_AndroidViewView;
  private View jdField_h_of_type_AndroidViewView;
  private View jdField_i_of_type_AndroidViewView;
  private View jdField_j_of_type_AndroidViewView;
  private View jdField_k_of_type_AndroidViewView;
  private View l;
  
  public IndividuationSetActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private int a(int paramInt)
  {
    if (this.app == null) {
      return -1;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("100005.");
    if (paramInt == 1) {
      localStringBuilder.append(100002);
    }
    for (;;)
    {
      return localGameCenterManagerImp.a(localStringBuilder.toString());
      if (paramInt == 3) {
        localStringBuilder.append(100003);
      } else if (paramInt == 5) {
        localStringBuilder.append(100011);
      }
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return 1;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
    } while ((paramString1.length < 3) || (paramString2.length < 3));
    int n = paramString1.length;
    int m = 0;
    for (;;)
    {
      if (m >= n) {
        break label93;
      }
      int i1 = Integer.valueOf(paramString1[m]).intValue();
      int i2 = Integer.valueOf(paramString2[m]).intValue();
      if (i1 > i2) {
        break;
      }
      if (i1 < i2) {
        return -1;
      }
      m += 1;
    }
    label93:
    return 0;
  }
  
  private Bitmap a(int paramInt1, int paramInt2)
  {
    String str1 = ChatBackgroundSettingActivity.b(this, this.app.a());
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "currBgThumbName is:" + str1);
    }
    Object localObject1 = getResources();
    Object localObject6 = null;
    if (str1.equals("null")) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = SkinUtils.a(((Resources)localObject1).getDrawable(2130839220));
        return ImageUtil.a(a((Bitmap)localObject1, paramInt1, paramInt2), this.jdField_a_of_type_Float * 4.0F);
      }
      catch (NullPointerException localNullPointerException1)
      {
        localObject2 = localObject6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ThemeDownloadTrace", 2, "CHAT_BACKGOURND_DEFUALT getCurrBgThumb = null");
        localObject2 = localObject6;
        continue;
      }
      catch (Exception localException1)
      {
        localObject2 = localObject6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ThemeDownloadTrace", 2, "CHAT_BACKGOURND_DEFUALT e" + localException1);
        localObject2 = localObject6;
        continue;
      }
      Object localObject3;
      if (localException1.equals("none"))
      {
        try
        {
          localObject2 = SkinUtils.a(((Resources)localObject2).getDrawable(2130837672));
        }
        catch (NullPointerException localNullPointerException2)
        {
          localObject3 = localObject6;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ThemeDownloadTrace", 2, "CHAT_BACKGROUND_NULL getCurrBgThumb = null");
          localObject3 = localObject6;
        }
        catch (Exception localException2)
        {
          localObject3 = localObject6;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ThemeDownloadTrace", 2, "CHAT_BACKGROUND_NULL e" + localException2);
          localObject3 = localObject6;
        }
      }
      else
      {
        String str2;
        if (localException2.equals("__other_thumb"))
        {
          str2 = super.getSharedPreferences("chat_background_path_" + this.app.a(), 0).getString("chat_uniform_bg", "null");
          if (new File(str2).exists())
          {
            localObject3 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.ARGB_8888;
            ((BitmapFactory.Options)localObject3).inDensity = 160;
            ((BitmapFactory.Options)localObject3).inTargetDensity = 160;
            ((BitmapFactory.Options)localObject3).inScreenDensity = 160;
            ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
          }
        }
        try
        {
          BitmapFactory.decodeFile(str2, (BitmapFactory.Options)localObject3);
          ((BitmapFactory.Options)localObject3).inSampleSize = ImageUtil.a((BitmapFactory.Options)localObject3, paramInt1, paramInt2, true);
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloadTrace", 2, "sampleSize is:" + ((BitmapFactory.Options)localObject3).inSampleSize);
          }
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
          localObject3 = BitmapFactory.decodeFile(str2);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          String str3;
          Object localObject4;
          Object localObject5 = localObject6;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "custom pic does not exist,get default bg");
        }
        try
        {
          localObject3 = SkinUtils.a(((Resources)localObject3).getDrawable(2130839220));
        }
        catch (Exception localException3)
        {
          localObject3 = localObject6;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ThemeDownloadTrace", 2, "OTHER_THUMB e" + localException3);
          localObject3 = localObject6;
          continue;
          str3 = AppConstants.ba + localException3 + ".png";
          if (new File(str3).exists())
          {
            try
            {
              localObject3 = BitmapFactory.decodeFile(str3);
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              localObject4 = localObject6;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("ThemeDownloadTrace", 2, "OutOfMemoryError");
              localObject4 = localObject6;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDownloadTrace", 2, "thumb does not exist,get default bg");
            }
            localObject4 = SkinUtils.a(((Resources)localObject4).getDrawable(2130839220));
          }
        }
      }
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    if (paramBitmap == null) {
      return paramBitmap;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (localBitmap != null)
      {
        m = paramBitmap.getWidth();
        n = paramBitmap.getHeight();
        if (m * paramInt2 > paramInt1 * n)
        {
          f3 = paramInt2 / n;
          f2 = (paramInt1 - m * f3) * 0.5F;
          Canvas localCanvas = new Canvas(localBitmap);
          Matrix localMatrix = new Matrix();
          localMatrix.setScale(f3, f3);
          localMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
          localCanvas.drawBitmap(paramBitmap, localMatrix, null);
        }
      }
      else
      {
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        int m;
        int n;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "getFixedBitmap(),oom occurs");
        }
        Object localObject = null;
        continue;
        float f3 = paramInt1 / m;
        f1 = paramInt2;
        float f4 = n;
        float f2 = 0.0F;
        f1 = (f1 - f4 * f3) * 0.5F;
      }
    }
  }
  
  private BusinessInfoCheckUpdate.AppInfo a()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.app.getManager(32)).a("100005.100001");
      return localAppInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramInt = paramView.getId();
    }
    paramView = (RedTouchManager)this.app.getManager(32);
    if (paramInt == 2131297211)
    {
      paramView.b("100005.100002");
      if (!BaseApplicationImpl.jdField_a_of_type_Boolean)
      {
        Toast.makeText(this, getString(2131363264), 0).show();
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_theme_mall", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      if (Utils.e())
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("updateFlag", this.jdField_c_of_type_Boolean);
        paramInt = b(6);
        if (paramInt != 0)
        {
          paramView.putExtra("updateFlag", true);
          paramView.putExtra("updateId", paramInt);
        }
        VasWebviewUtil.a(this, "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&updateId=[updateId]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, paramView, true, 2);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_Boolean = false;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
      }
      Toast.makeText(this, getString(2131363511), 0).show();
      break;
      if (paramInt == 2131297209)
      {
        paramView = new Intent(this, ChatBackgroundSettingActivity.class);
        paramView.putExtra("bg_replace_entrance", 8);
        super.startActivityForResult(paramView, 1);
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_background", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2131297193)
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("updateFlag", this.jdField_d_of_type_Boolean);
        paramInt = b(2);
        if (paramInt != 0)
        {
          localIntent.putExtra("updateFlag", true);
          localIntent.putExtra("updateId", paramInt);
        }
        VasWebviewUtil.a(this, "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, localIntent, false, -1);
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = false;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramView.b("100005.100003");
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_bubble_mall", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2131297206)
      {
        super.startActivity(new Intent(this, ChatTextSizeSettingActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_font_size", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2131297187)
      {
        paramView.b("100005.100001");
        this.jdField_c_of_type_AndroidViewView.setVisibility(4);
        this.jdField_d_of_type_AndroidViewView.setVisibility(4);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_ep_mall", 52, 0, "", "", "", "");
        EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.app.getAccount(), 3, this.app.getSid());
        return;
      }
    } while (paramInt != 2131297199);
    paramView.b("100005.100011");
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    paramView = new Intent(this, QQBrowserActivity.class);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      paramView.putExtra("updateFlag", true);
    }
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramInt = b(3);
    if (paramInt != 0)
    {
      paramView.putExtra("updateFlag", true);
      paramView.putExtra("updateId", paramInt);
    }
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    VasWebviewUtil.a(this, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, paramView, false, -1);
    ReportController.b(this.app, "CliOper", "", "", "Font_Mall", "enter_mall", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.l.setContentDescription("Emoji表情，已下载");
      return;
    }
    if (EmojiUtil.a())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131364082);
      this.l.setContentDescription("Emoji表情，继续下载");
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.l.setContentDescription("Emoji表情，立即下载");
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return 0;
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (paramInt == ((Bundle)this.jdField_a_of_type_JavaUtilList.get(m)).getInt("bizType")) {
          return ((Bundle)this.jdField_a_of_type_JavaUtilList.get(m)).getInt("newId");
        }
        m += 1;
      }
    }
  }
  
  private void c()
  {
    if ((EmojiUtil.a(this) != EmotcationConstants.f) && (!EmojiUtil.a(521705))) {
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new arc(this));
      return;
      a(true);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler = new EmojiJsHandler(getActivity());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", "http://i.gtimg.cn/qqshow/admindata/comdata/vip_mobile_theme_lite_night/emoji2.zip");
      localJSONObject.put("size", 521705);
      this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.a(localJSONObject, new IndividuationSetActivity.EmojiJsBridgeListener(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.app != null) {
      this.app.a(new ard(this));
    }
  }
  
  private void f()
  {
    a(1);
    a(3);
    a(2);
    a(5);
  }
  
  private void g()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.app.getManager(11);
    if (localGameCenterManagerImp != null) {}
    for (int m = localGameCenterManagerImp.a("100005");; m = -1)
    {
      if (m != -1) {}
      for (m = 1;; m = 0)
      {
        if (m != 0) {
          BusinessInfoCheckUpdateItem.a(this.app, "100005", false);
        }
        return;
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    int n;
    do
    {
      return;
      n = 0;
    } while (n >= this.jdField_a_of_type_JavaUtilList.size());
    int m;
    switch (((Bundle)this.jdField_a_of_type_JavaUtilList.get(n)).getInt("bizType"))
    {
    case 4: 
    default: 
      m = -1;
    }
    for (;;)
    {
      if (m != -1)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(m);
        ImageView localImageView = new ImageView(this);
        localImageView.setImageDrawable(getResources().getDrawable(2130838955));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(9, -1);
        localLayoutParams.addRule(10, -1);
        localRelativeLayout.addView(localImageView, localLayoutParams);
      }
      n += 1;
      break;
      m = 2131297187;
      continue;
      m = 2131297193;
      continue;
      m = 2131297199;
      continue;
      m = 2131297209;
      continue;
      m = 2131297211;
    }
  }
  
  private void i()
  {
    if (true == this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.app, this);
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.registerModeCallback(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
    b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131297211));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    super.findViewById(2131297217).setVisibility(8);
    this.j = super.findViewById(2131297209);
    this.j.setOnClickListener(this);
    this.g = super.findViewById(2131297193);
    this.g.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297195));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297206));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.h = super.findViewById(2131297187);
    this.h.setOnClickListener(this);
    this.i = super.findViewById(2131297199);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297213);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297216);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297215));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297196));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297198));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297197));
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131297189);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131297192);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297190));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297191));
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131297203);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131297205);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297204));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297210));
    this.k = findViewById(2131297218);
    this.k.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131297220));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297219));
    if ("1000".equals(ThemeUtil.getUserCurrentThemeId(this.app))) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
    }
    for (;;)
    {
      this.k.setContentDescription("夜间模式");
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new arb(this));
      this.l = findViewById(2131297221);
      this.l.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297222));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297223));
      c();
      e();
      h();
      return;
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = (RedTouchManager)this.app.getManager(32);
    if (paramInt != 2) {}
    for (int m = a(paramInt);; m = -1)
    {
      if (paramInt == 1) {
        switch (m)
        {
        case 2: 
        case 3: 
        default: 
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      label662:
      label699:
      do
      {
        for (;;)
        {
          return;
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          Object localObject2 = ((RedTouchManager)localObject1).a("100005.100002");
          this.jdField_c_of_type_Boolean = true;
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((RedTouchManager)localObject1).a((BusinessInfoCheckUpdate.AppInfo)localObject2));
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130839339);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          return;
          if (paramInt != 2) {
            break label699;
          }
          localObject2 = a();
          if ((localObject2 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 0)) {
            break label662;
          }
          switch (((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get())
          {
          case 2: 
          default: 
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          case 1: 
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          case 3: 
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            localObject1 = ((BusinessInfoCheckUpdate.AppInfo)localObject2).icon_url.get();
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              try
              {
                if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                  this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839029);
                }
                localObject2 = URLDrawable.getDrawable((String)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
                if (localObject2 != null)
                {
                  paramInt = (int)(35.0F * this.jdField_a_of_type_Float);
                  ((URLDrawable)localObject2).setBounds(0, 0, paramInt, paramInt);
                  this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
                  this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                  return;
                }
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("IndividuationSetActivity", 2, "red icon load fail, iconUrl=" + (String)localObject1);
                }
                localObject1 = getResources().getDrawable(2130839029);
                this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
                this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                localException.printStackTrace();
                return;
              }
            }
            break;
          }
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((RedTouchManager)localObject1).a(localException));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839339);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        if (paramInt == 3)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.b();
          Object localObject3 = (BubbleManager)this.app.getManager(40);
          this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(((BubbleManager)localObject3).a(paramInt));
          switch (m)
          {
          case 2: 
          case 3: 
          default: 
            this.jdField_d_of_type_Boolean = false;
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          case 1: 
            this.jdField_d_of_type_Boolean = true;
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          case 0: 
            this.jdField_d_of_type_Boolean = true;
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          }
          localObject3 = ((RedTouchManager)localObject1).a("100005.100003");
          this.jdField_d_of_type_Boolean = true;
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(((RedTouchManager)localObject1).a((BusinessInfoCheckUpdate.AppInfo)localObject3));
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130839339);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
        }
      } while (paramInt != 5);
      ((TextView)super.findViewById(2131297208)).setText(ChatActivityUtils.a(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.i.setVisibility(8);
      return;
    }
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int n = getWindowManager().getDefaultDisplay().getWidth();
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i1, i2);
    int m = paramTextView.getMeasuredWidth();
    paramView.measure(i1, i2);
    i1 = paramView.getMeasuredWidth();
    float f1 = getResources().getDisplayMetrics().density;
    n = n - i1 - (int)(20 * f1 + 0.5F);
    if (m > n)
    {
      paramTextView.setMaxWidth(n - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    int n = this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.getNightModeStatus();
    int m;
    if (this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked())
    {
      m = 1;
      if (n == m) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (n != 1) {
        break label72;
      }
      this.jdField_a_of_type_ComTencentWidgetSwitch.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    }
    label72:
    while (n != 2)
    {
      return;
      m = 2;
      break;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setClickable(true);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected String b_()
  {
    return super.getString(2131363113);
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload_1
    //   4: sipush 4001
    //   7: if_icmpne +18 -> 25
    //   10: invokestatic 918	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   13: aload_0
    //   14: getfield 82	com/tencent/mobileqq/activity/IndividuationSetActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 140	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   20: aload_3
    //   21: invokestatic 922	com/tencent/mobileqq/vaswebviewplugin/EmojiHomeUiPlugin:statisticEmojiHomePageInfo	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
    //   24: return
    //   25: iload_1
    //   26: iconst_1
    //   27: if_icmpeq +8 -> 35
    //   30: iload_1
    //   31: iconst_2
    //   32: if_icmpne +27 -> 59
    //   35: aload_0
    //   36: getfield 419	com/tencent/mobileqq/activity/IndividuationSetActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   39: ifnull +15 -> 54
    //   42: aload_0
    //   43: getfield 425	com/tencent/mobileqq/activity/IndividuationSetActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   46: ifnull +8 -> 54
    //   49: aload_0
    //   50: iconst_1
    //   51: invokevirtual 645	com/tencent/mobileqq/activity/IndividuationSetActivity:a	(I)V
    //   54: aload_0
    //   55: invokespecial 762	com/tencent/mobileqq/activity/IndividuationSetActivity:e	()V
    //   58: return
    //   59: iload_1
    //   60: iconst_4
    //   61: if_icmpne -37 -> 24
    //   64: aload_3
    //   65: ifnull -41 -> 24
    //   68: ldc_w 924
    //   71: aload_3
    //   72: ldc_w 926
    //   75: invokevirtual 930	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   78: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq -57 -> 24
    //   84: aload_3
    //   85: ldc_w 932
    //   88: invokevirtual 930	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_3
    //   92: new 617	org/json/JSONObject
    //   95: dup
    //   96: aload_3
    //   97: invokespecial 933	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 6
    //   102: aload 6
    //   104: ldc_w 935
    //   107: invokevirtual 937	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: invokestatic 940	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: istore_2
    //   114: aload 6
    //   116: ldc_w 942
    //   119: invokevirtual 937	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokestatic 940	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: istore_1
    //   126: aload 6
    //   128: ldc_w 944
    //   131: invokevirtual 937	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 940	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: istore 5
    //   139: iload 5
    //   141: istore 4
    //   143: aload 6
    //   145: ifnull -121 -> 24
    //   148: iload_2
    //   149: ifne -125 -> 24
    //   152: iload_1
    //   153: ifne -129 -> 24
    //   156: iload 4
    //   158: ifne -134 -> 24
    //   161: aload_0
    //   162: getfield 82	com/tencent/mobileqq/activity/IndividuationSetActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   165: bipush 38
    //   167: invokevirtual 947	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   170: checkcast 949	com/tencent/mobileqq/app/UniPayHandler
    //   173: ldc_w 375
    //   176: invokevirtual 951	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   179: return
    //   180: astore_3
    //   181: iconst_m1
    //   182: istore_2
    //   183: aconst_null
    //   184: astore 6
    //   186: iconst_m1
    //   187: istore_1
    //   188: aload_3
    //   189: invokevirtual 637	org/json/JSONException:printStackTrace	()V
    //   192: goto -49 -> 143
    //   195: astore_3
    //   196: iconst_m1
    //   197: istore_1
    //   198: iconst_m1
    //   199: istore_2
    //   200: goto -12 -> 188
    //   203: astore_3
    //   204: iconst_m1
    //   205: istore_1
    //   206: goto -18 -> 188
    //   209: astore_3
    //   210: goto -22 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	IndividuationSetActivity
    //   0	213	1	paramInt1	int
    //   0	213	2	paramInt2	int
    //   0	213	3	paramIntent	Intent
    //   1	156	4	m	int
    //   137	3	5	n	int
    //   100	85	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   92	102	180	org/json/JSONException
    //   102	114	195	org/json/JSONException
    //   114	126	203	org/json/JSONException
    //   126	139	209	org/json/JSONException
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    super.setContentView(2130903213);
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.app.a(12));
    this.jdField_a_of_type_JavaUtilList = ClubContentJsonTask.a(this.app.getApplication().getApplicationContext());
    a();
    super.setTitle(2131363191);
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler = new EmojiJsHandler(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.destroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean) {
      i();
    }
    f();
    b();
  }
  
  public int getPathNodeID()
  {
    return 24;
  }
  
  public void onClick(View paramView)
  {
    a(paramView, -1);
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onPostThemeChanged();
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.IndividuationSetActivity
 * JD-Core Version:    0.7.0.1
 */