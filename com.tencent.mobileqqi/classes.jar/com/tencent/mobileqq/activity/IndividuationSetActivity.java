package com.tencent.mobileqq.activity;

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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cqr;
import cqs;
import cqt;
import cqu;
import cqw;
import java.io.File;

public class IndividuationSetActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "updateFlag";
  private static final int jdField_b_of_type_Int = 2;
  private float jdField_a_of_type_Float;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new cqr(this);
  private SVIPHandler jdField_a_of_type_ComTencentMobileqqAppSVIPHandler;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_a_of_type_Boolean = false;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  
  private int a()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    return localGameCenterManagerImp.a("100005.100011");
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      return m;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      if (j > paramInt2) {
        break;
      }
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label55;
      n = m;
    }
  }
  
  private Bitmap a(int paramInt1, int paramInt2)
  {
    String str1 = ChatBackgroundSettingActivity.b(this, ChatBackgroundSettingActivity.a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
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
        localObject1 = SkinUtils.a(((Resources)localObject1).getDrawable(2130840058));
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
          localObject2 = SkinUtils.a(((Resources)localObject2).getDrawable(2130837753));
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
          str2 = getSharedPreferences("chat_background_path_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getString("chat_uniform_bg", "null");
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
          ((BitmapFactory.Options)localObject3).inSampleSize = a((BitmapFactory.Options)localObject3, paramInt1, paramInt2);
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
          localObject3 = SkinUtils.a(((Resources)localObject3).getDrawable(2130840058));
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
          str3 = AppConstants.aV + localException3 + ".png";
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
            localObject4 = SkinUtils.a(((Resources)localObject4).getDrawable(2130840058));
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
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (i * paramInt2 > paramInt1 * j)
        {
          f3 = paramInt2 / j;
          f2 = (paramInt1 - i * f3) * 0.5F;
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
        int i;
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "getFixedBitmap(),oom occurs");
        }
        Object localObject = null;
        continue;
        float f3 = paramInt1 / i;
        f1 = paramInt2;
        float f4 = j;
        float f2 = 0.0F;
        f1 = (f1 - f4 * f3) * 0.5F;
      }
    }
  }
  
  private BusinessInfoCheckUpdate.AppInfo a()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a("100005.100001");
      return localAppInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private int b()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    return localGameCenterManagerImp.a("100005.100006");
  }
  
  private int c()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    return localGameCenterManagerImp.a("100005.100012");
  }
  
  private void d()
  {
    Object localObject1 = (URLImageView)findViewById(2131231786);
    Object localObject2 = (Button)findViewById(2131231788);
    if (((SVIPHandler)((QQAppInterface)getAppRuntime()).a(12)).c() >= 1)
    {
      ((Button)localObject2).setVisibility(8);
      return;
    }
    ((Button)localObject2).setOnClickListener(new cqs(this));
    localObject2 = getResources().getDrawable(2130839198);
    ((Drawable)localObject2).mutate().setAlpha(0);
    localObject2 = URLDrawable.getDrawable("http://imgcache.qq.com/club/themes/mobile/biaoqing/img/themes_banner_700x208.jpg", (Drawable)localObject2, (Drawable)localObject2);
    ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
    if (((URLDrawable)localObject2).getStatus() == 1)
    {
      localObject1 = (RelativeLayout.LayoutParams)((URLImageView)localObject1).getLayoutParams();
      float f = ((URLDrawable)localObject2).getIntrinsicHeight() / ((URLDrawable)localObject2).getIntrinsicWidth();
      localObject2 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(f * ((DisplayMetrics)localObject2).widthPixels + 0.5F));
      return;
    }
    ((URLImageView)localObject1).setURLDrawableDownListener(new cqt(this));
  }
  
  private int e()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    return localGameCenterManagerImp.a("100005.100001");
  }
  
  private void e()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.b();
    Object localObject1 = (BubbleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((BubbleManager)localObject1).a(i));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ChatActivityUtils.a(this));
    localObject1 = (ImageView)findViewById(2131231797);
    Object localObject2 = (ImageView)findViewById(2131231798);
    label109:
    Object localObject3;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    switch (g())
    {
    default: 
      this.c = false;
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(8);
      localObject2 = findViewById(2131231791);
      localObject3 = findViewById(2131231793);
      localObject1 = (ImageView)findViewById(2131231792);
      localAppInfo = a();
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
        switch (localAppInfo.type.get())
        {
        case 2: 
        default: 
          this.jdField_b_of_type_Boolean = false;
          ((View)localObject2).setVisibility(8);
          ((View)localObject3).setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          label220:
          findViewById(2131231808).setOnClickListener(this);
          localObject2 = (URLImageView)findViewById(2131231810);
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((localObject1 == null) || ("".equals(localObject1))) {
            ((URLImageView)localObject2).setVisibility(4);
          }
          localObject1 = ((FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a((String)localObject1);
          if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid()))
          {
            ((URLImageView)localObject2).setVisibility(0);
            ((URLImageView)localObject2).setImageDrawable(AvatarPendantUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((ExtensionInfo)localObject1).pendantId, 5));
            label318:
            localObject2 = findViewById(2131231811);
            localObject3 = findViewById(2131231812);
            switch (b())
            {
            default: 
              this.d = false;
              ((View)localObject2).setVisibility(8);
              ((View)localObject3).setVisibility(8);
            }
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        if (((FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).jdField_a_of_type_Boolean) {
          break label815;
        }
        findViewById(2131231807).setVisibility(0);
        findViewById(2131231800).setVisibility(8);
        label419:
        localObject1 = findViewById(2131231823);
        localObject2 = findViewById(2131231825);
        switch (c())
        {
        default: 
          ((View)localObject1).setVisibility(8);
          ((View)localObject2).setVisibility(8);
          return;
          this.c = true;
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject2).setVisibility(8);
          break label109;
          this.c = true;
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject2).setVisibility(0);
          break label109;
          this.jdField_b_of_type_Boolean = true;
          ((View)localObject2).setVisibility(0);
          ((View)localObject3).setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          break label220;
          this.jdField_b_of_type_Boolean = true;
          ((View)localObject2).setVisibility(8);
          ((View)localObject3).setVisibility(8);
          ((ImageView)localObject1).setVisibility(8);
          localObject2 = localAppInfo.icon_url.get();
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label220;
          }
          try
          {
            if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839215);
            }
            localObject3 = URLDrawable.getDrawable((String)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
            if (localObject3 == null) {
              break label220;
            }
            i = (int)(35.0F * this.jdField_a_of_type_Float);
            ((URLDrawable)localObject3).setBounds(0, 0, i, i);
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
            ((ImageView)localObject1).setVisibility(0);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("IndividuationSetActivity", 2, "red icon load fail, iconUrl=" + (String)localObject2);
            }
            ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130839215));
            ((ImageView)localObject1).setVisibility(0);
            localException.printStackTrace();
          }
        }
      }
      break label220;
      this.jdField_b_of_type_Boolean = true;
      ((View)localObject2).setVisibility(8);
      localException.setVisibility(0);
      ((ImageView)localObject1).setVisibility(8);
      break label220;
      this.jdField_b_of_type_Boolean = false;
      ((View)localObject2).setVisibility(8);
      localException.setVisibility(8);
      ((ImageView)localObject1).setVisibility(8);
      break label220;
      ((URLImageView)localObject2).setVisibility(8);
      break label318;
      this.d = true;
      ((View)localObject2).setVisibility(0);
      localException.setVisibility(8);
      continue;
      this.d = true;
      ((View)localObject2).setVisibility(8);
      localException.setVisibility(0);
    }
    label815:
    findViewById(2131231807).setVisibility(8);
    localObject2 = findViewById(2131231800);
    ((View)localObject2).setVisibility(0);
    ((View)localObject2).setOnClickListener(this);
    localObject2 = (URLImageView)findViewById(2131231802);
    ((TextView)findViewById(2131231803)).setText(ChatActivityUtils.a(this));
    if (localObject1 != null) {}
    for (i = (int)((ExtensionInfo)localObject1).uVipFont;; i = 0)
    {
      localObject1 = FontManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i);
      if (localObject1 != null)
      {
        ((URLImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        ((URLImageView)localObject2).setVisibility(0);
      }
      for (;;)
      {
        localObject1 = findViewById(2131231804);
        localObject2 = findViewById(2131231805);
        switch (a())
        {
        default: 
          this.e = false;
          ((View)localObject1).setVisibility(8);
          ((View)localObject2).setVisibility(8);
          break label419;
          ((URLImageView)localObject2).setVisibility(8);
        }
      }
      this.e = true;
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(8);
      break;
      this.e = true;
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(0);
      break;
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(8);
      return;
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(0);
      return;
    }
  }
  
  private int f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return -1;
    }
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    return localGameCenterManagerImp.a("100005.100002");
  }
  
  private void f()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp != null) {}
    for (int i = localGameCenterManagerImp.a("100005");; i = -1)
    {
      if (i != -1) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          BusinessInfoCheckUpdateItem.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "100005", false);
        }
        return;
      }
    }
  }
  
  private int g()
  {
    GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localGameCenterManagerImp == null) {
      return -1;
    }
    return localGameCenterManagerImp.a("100005.100003");
  }
  
  public void a()
  {
    d();
    ((ViewGroup)findViewById(2131231821)).setOnClickListener(this);
    ((ViewGroup)findViewById(2131231815)).setOnClickListener(this);
    View localView1 = findViewById(2131231817);
    View localView2 = findViewById(2131231819);
    switch (f())
    {
    default: 
      this.jdField_a_of_type_Boolean = false;
      localView1.setVisibility(8);
      localView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqu(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231814));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      findViewById(2131231794).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231796));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131231807));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      findViewById(2131231789).setOnClickListener(this);
      findViewById(2131231826).setOnClickListener(this);
      return;
      this.jdField_a_of_type_Boolean = true;
      localView1.setVisibility(0);
      localView2.setVisibility(8);
      continue;
      this.jdField_a_of_type_Boolean = true;
      localView1.setVisibility(8);
      localView2.setVisibility(0);
    }
  }
  
  protected String a_()
  {
    return getString(2131561692);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    View localView;
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      paramIntent = findViewById(2131231817);
      localView = findViewById(2131231819);
      if ((paramIntent != null) && (localView != null)) {
        switch (f())
        {
        default: 
          this.jdField_a_of_type_Boolean = false;
          paramIntent.setVisibility(8);
          localView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqw(this));
      }
      return;
      this.jdField_a_of_type_Boolean = true;
      paramIntent.setVisibility(0);
      localView.setVisibility(8);
      continue;
      this.jdField_a_of_type_Boolean = true;
      paramIntent.setVisibility(8);
      localView.setVisibility(0);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentView(2130903252);
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler = ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(12));
    a();
    setTitle(2131561902);
    a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    f();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    e();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131231815)
    {
      ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100002");
      if (!BaseApplicationImpl.jdField_a_of_type_Boolean)
      {
        Toast.makeText(this, getString(2131562952), 0).show();
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Enter_theme_mall", 0, 0, "", "", "", "");
      }
    }
    do
    {
      return;
      Object localObject;
      if (Utils.e())
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("updateFlag", this.jdField_a_of_type_Boolean);
        VasWebviewUtil.a(this, "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, paramView, true, 2);
        paramView = findViewById(2131231817);
        localObject = findViewById(2131231819);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = false;
        }
        paramView.setVisibility(8);
        ((View)localObject).setVisibility(8);
        break;
      }
      Toast.makeText(this, getString(2131562496), 0).show();
      break;
      if (i == 2131231814)
      {
        paramView = new Intent(this, ChatBackgroundSettingActivity.class);
        paramView.putExtra("bg_replace_entrance", 8);
        startActivityForResult(paramView, 1);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Enter_background", 0, 0, "", "", "", "");
        return;
      }
      if (i == 2131231794)
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("updateFlag", this.c);
        VasWebviewUtil.a(this, "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, (Intent)localObject, false, -1);
        if (this.c) {
          this.c = false;
        }
        paramView.findViewById(2131231797).setVisibility(8);
        paramView.findViewById(2131231798).setVisibility(8);
        ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100003");
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Enter_bubble_mall", 0, 0, "", "", "", "");
        return;
      }
      if (i == 2131231807)
      {
        startActivity(new Intent(this, ChatTextSizeSettingActivity.class));
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Enter_font_size", 0, 0, "", "", "", "");
        return;
      }
      if (i == 2131231789)
      {
        ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100001");
        paramView.findViewById(2131231791).setVisibility(4);
        paramView.findViewById(2131231793).setVisibility(4);
        paramView.findViewById(2131231792).setVisibility(4);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if (i == 2131231808)
      {
        if (!Utils.e())
        {
          Toast.makeText(this, getString(2131562496), 0).show();
          return;
        }
        ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100006");
        paramView = new Intent(this, AvatarPendantMarketActivity.class);
        if (this.d)
        {
          this.d = false;
          paramView.putExtra("key_update_flag", true);
        }
        findViewById(2131231811).setVisibility(8);
        findViewById(2131231812).setVisibility(8);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramView.putExtra("url", VasWebviewConstants.AVATAR_PENDANT_URL);
        paramView.putExtra("business", 512L);
        paramView.putExtra("isShowAd", false);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        startActivity(paramView);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "TabClick", 0, 0, "", "", "", "");
        return;
      }
      if (i == 2131231800)
      {
        ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100011");
        findViewById(2131231804).setVisibility(8);
        findViewById(2131231805).setVisibility(8);
        paramView = new Intent(this, QQBrowserActivity.class);
        if (this.e)
        {
          this.e = false;
          paramView.putExtra("updateFlag", true);
        }
        paramView.putExtra("url", VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL);
        paramView.putExtra("business", 4096L);
        paramView.putExtra("isShowAd", false);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramView);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Font_Mall", "enter_mall", 0, 0, "", "", "", "");
        return;
      }
      if (i == 2131231821)
      {
        ((RedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005.100012");
        findViewById(2131231823).setVisibility(8);
        findViewById(2131231825).setVisibility(8);
        paramView = new Intent(this, ProfileCardBrowserActivity.class);
        localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        if (localObject != null)
        {
          localObject = ((FriendsManager)localObject).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((localObject != null) && (((Card)localObject).lCurrentTemplateId > 0L) && (((Card)localObject).templateRet == 0)) {
            paramView.putExtra("CurrentTemplateId", ((Card)localObject).lCurrentTemplateId);
          }
        }
        paramView.putExtra("AllInOne", new ProfileActivity.AllInOne(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0));
        paramView.putExtra("formActivity", "IndividuationSetActivity");
        startActivity(paramView);
        return;
      }
    } while (i != 2131231826);
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", VasWebviewConstants.PERSONALITY_QQ_SUIT_URL);
    paramView.putExtra("isShowAd", false);
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramView.putExtra("business", 262144L);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivity(paramView);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Enter_gxsuit_tab", "gxsuit", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.IndividuationSetActivity
 * JD-Core Version:    0.7.0.1
 */