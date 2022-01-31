package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cxb;
import cxc;
import cxd;
import cxe;
import cxf;
import mqq.util.NativeUtil;

public class ScreenShot
{
  static final int jdField_a_of_type_Int = -16847;
  public static final String a;
  public final Context a;
  public Bitmap a;
  public Drawable a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Window a;
  public Button a;
  public final cxf a;
  public Bitmap b;
  public Drawable b;
  public Button b;
  public Bitmap c;
  public Button c;
  public Button d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aq + "/QQ_Screenshot/";
  }
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      for (paramWindow = (Activity)this.jdField_a_of_type_AndroidContentContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
    }
    for (this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();; this.jdField_a_of_type_AndroidViewWindow = paramWindow)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839140);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839139);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903609, null));
      this.jdField_a_of_type_Cxf = new cxf(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Cxf, 0);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298725));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298726));
      this.d = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298724));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298723));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new cxb(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cxc(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new cxd(this));
      return;
    }
  }
  
  public static final Uri a()
  {
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("LastScreenShotUri", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return Uri.parse(str);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    if (((k == i) && (j == m)) || ((k == m) && (j == i)))
    {
      localObject = new int[k];
      paramBitmap.getPixels((int[])localObject, 0, k, 0, j / 2, k, 1);
      i = 0;
      while (i < k)
      {
        if (localObject[i] != -16777216) {
          return true;
        }
        i += 1;
      }
      localObject = new int[j];
      paramBitmap.getPixels((int[])localObject, 0, 1, k / 2, 0, 1, j);
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label151;
        }
        if (localObject[i] != -16777216) {
          break;
        }
        i += 1;
      }
    }
    label151:
    return false;
  }
  
  private void b()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!a())
    {
      localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.type = 2003;
      localLayoutParams.format = 1;
      localLayoutParams.flags |= 0x100;
      this.d.setOnClickListener(new cxe(this));
    }
    try
    {
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("qqBaseActivity", 2, "", localThrowable);
    }
  }
  
  private void c()
  {
    if (a()) {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private boolean c()
  {
    return (!Build.MODEL.contains("Galaxy Nexus")) && (!Build.MODEL.contains("HTC S720")) && (!Build.MODEL.contains("SM-N9006")) && ((!Build.MODEL.contains("ZTE U930")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("HTC One X")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("GT-I9260")) || (Build.VERSION.SDK_INT != 16)) && (!d());
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.MANUFACTURER.contains("Meizu")) {
      if ((!Build.MODEL.contains("M351")) && (!Build.MODEL.contains("M353")) && (!Build.MODEL.contains("M355")))
      {
        bool1 = bool2;
        if (!Build.MODEL.contains("M356")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static native int snapScreen(int paramInt1, int paramInt2);
  
  public void a()
  {
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null;
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Cxf.k = 0;
    this.jdField_a_of_type_Cxf.a.setEmpty();
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if (c()) {}
    try
    {
      Bitmap localBitmap = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      this.jdField_c_of_type_AndroidGraphicsBitmap = localBitmap;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!a(this.jdField_a_of_type_AndroidGraphicsBitmap)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "", localThrowable);
        }
      }
      b();
      ReportController.b(null, "CliOper", "", "", "Shake_screenshot", "Shake_screenshot", 0, 0, "", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot
 * JD-Core Version:    0.7.0.1
 */