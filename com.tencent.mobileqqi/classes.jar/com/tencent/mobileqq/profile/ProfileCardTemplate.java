package com.tencent.mobileqq.profile;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardTemplate
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public long a;
  public String a;
  public HashMap a;
  public boolean a;
  public String b;
  private HashMap b;
  public String c;
  private HashMap c;
  public String d;
  public String e;
  public int f;
  public String f;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
  }
  
  public ProfileCardTemplate()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap.put("top", Integer.valueOf(48));
    this.jdField_b_of_type_JavaUtilHashMap.put("bottom", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("left", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("right", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("center_vertical", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("fill_vertical", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("center_horizontal", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("fill_horizontal", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("center", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("fill", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("clip_vertical", Integer.valueOf(80));
    this.jdField_b_of_type_JavaUtilHashMap.put("clip_horizontal", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("clamp", Shader.TileMode.CLAMP);
    this.jdField_c_of_type_JavaUtilHashMap.put("repeat", Shader.TileMode.REPEAT);
    this.jdField_c_of_type_JavaUtilHashMap.put("mirror", Shader.TileMode.MIRROR);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    if ((paramView != null) && (paramProfileCardTemplate != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramProfileCardTemplate = paramProfileCardTemplate.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
      if (paramProfileCardTemplate != null)
      {
        if ((!paramString1.equalsIgnoreCase("color")) || (!(paramView instanceof TextView))) {
          break label102;
        }
        paramView = (TextView)paramView;
        if (!(paramProfileCardTemplate instanceof ColorStateList)) {
          break label72;
        }
        paramView.setTextColor((ColorStateList)paramProfileCardTemplate);
      }
    }
    label71:
    label72:
    label102:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          do
                          {
                            return;
                          } while (!(paramProfileCardTemplate instanceof String));
                          paramString1 = (String)paramProfileCardTemplate;
                        } while (!paramString1.startsWith("#"));
                        paramView.setTextColor(Color.parseColor(paramString1));
                        return;
                        if (!paramString1.equalsIgnoreCase("background")) {
                          break;
                        }
                        if ((paramProfileCardTemplate instanceof Drawable))
                        {
                          paramString1 = ((Drawable)paramProfileCardTemplate).getConstantState().newDrawable();
                          if (Build.VERSION.SDK_INT >= 16)
                          {
                            paramView.setBackground(paramString1);
                            return;
                          }
                          paramProfileCardTemplate = new Rect();
                          paramString1.getPadding(paramProfileCardTemplate);
                          int n = paramView.getPaddingTop();
                          int i1 = paramProfileCardTemplate.top;
                          int i2 = paramView.getPaddingLeft();
                          int i3 = paramProfileCardTemplate.left;
                          int i4 = paramView.getPaddingRight();
                          int i5 = paramProfileCardTemplate.right;
                          int i6 = paramView.getPaddingBottom();
                          int i7 = paramProfileCardTemplate.bottom;
                          paramView.setBackgroundDrawable(paramString1);
                          paramView.setPadding(i2 + i3, n + i1, i4 + i5, i7 + i6);
                          return;
                        }
                      } while (!(paramProfileCardTemplate instanceof String));
                      paramString1 = (String)paramProfileCardTemplate;
                    } while (!paramString1.startsWith("#"));
                    paramView.setBackgroundColor(Color.parseColor(paramString1));
                    return;
                    if ((!paramString1.equalsIgnoreCase("drawableleft")) || (!(paramView instanceof TextView))) {
                      break;
                    }
                  } while (!(paramProfileCardTemplate instanceof Drawable));
                  paramView = (TextView)paramView;
                } while (!(paramProfileCardTemplate instanceof Drawable));
                paramView.setCompoundDrawablesWithIntrinsicBounds(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable(), null, null, null);
                return;
                if ((!paramString1.equalsIgnoreCase("drawableright")) || (!(paramView instanceof TextView))) {
                  break;
                }
              } while (!(paramProfileCardTemplate instanceof Drawable));
              paramView = (TextView)paramView;
            } while (!(paramProfileCardTemplate instanceof Drawable));
            paramView.setCompoundDrawablesWithIntrinsicBounds(null, null, ((Drawable)paramProfileCardTemplate).getConstantState().newDrawable(), null);
            return;
            if ((!paramString1.equalsIgnoreCase("src")) || (!(paramView instanceof ImageView))) {
              break;
            }
          } while (!(paramProfileCardTemplate instanceof Drawable));
          paramView = (ImageView)paramView;
        } while (!(paramProfileCardTemplate instanceof Drawable));
        paramView.setImageDrawable(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable());
        return;
      } while ((!paramString1.equalsIgnoreCase("contentBackground")) || (!(paramView instanceof ListView)) || (!(paramProfileCardTemplate instanceof Drawable)));
      paramView = (ListView)paramView;
    } while (!(paramProfileCardTemplate instanceof Drawable));
    paramView.setContentBackground(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable());
  }
  
  public ColorStateList a(JSONArray paramJSONArray)
  {
    int i3;
    int i2;
    Object localObject1;
    Object localObject2;
    int i4;
    Object localObject3;
    int n;
    int i1;
    int i5;
    if (paramJSONArray != null)
    {
      i3 = 20;
      i2 = 0;
      localObject1 = new int[20];
      localObject2 = new int[20][];
      int i6 = paramJSONArray.length();
      i4 = 0;
      if (i4 < i6)
      {
        localObject3 = paramJSONArray.optJSONObject(i4);
        if ((localObject3 == null) || (!((JSONObject)localObject3).has("color"))) {
          break label699;
        }
        Object localObject4 = ((JSONObject)localObject3).optString("color");
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label699;
        }
        Object localObject5 = ((JSONObject)localObject3).keys();
        int[] arrayOfInt = new int[((JSONObject)localObject3).length()];
        n = -65536;
        i1 = 0;
        if (((Iterator)localObject5).hasNext())
        {
          String str = (String)((Iterator)localObject5).next();
          if (str.equalsIgnoreCase("state_pressed")) {
            if (((JSONObject)localObject3).optBoolean("state_pressed"))
            {
              i5 = 16842919;
              label156:
              arrayOfInt[i1] = i5;
              i5 = i1 + 1;
              i1 = n;
              n = i5;
            }
          }
          for (;;)
          {
            label172:
            i5 = i1;
            i1 = n;
            n = i5;
            break;
            i5 = -16842919;
            break label156;
            if (str.equalsIgnoreCase("state_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_focused")) {}
              for (i5 = 16842908;; i5 = -16842908)
              {
                arrayOfInt[i1] = i5;
                i5 = i1 + 1;
                i1 = n;
                n = i5;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_selected"))
            {
              if (((JSONObject)localObject3).optBoolean("state_selected")) {}
              for (i5 = 16842913;; i5 = -16842913)
              {
                arrayOfInt[i1] = i5;
                i5 = i1 + 1;
                i1 = n;
                n = i5;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checkable"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checkable")) {}
              for (i5 = 16842911;; i5 = -16842911)
              {
                arrayOfInt[i1] = i5;
                i5 = i1 + 1;
                i1 = n;
                n = i5;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checked"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checked")) {}
              for (i5 = 16842912;; i5 = -16842912)
              {
                arrayOfInt[i1] = i5;
                i5 = i1 + 1;
                i1 = n;
                n = i5;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_enabled"))
            {
              if (((JSONObject)localObject3).optBoolean("state_enabled")) {}
              for (i5 = 16842910;; i5 = -16842910)
              {
                arrayOfInt[i1] = i5;
                i5 = i1 + 1;
                i1 = n;
                n = i5;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_window_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_window_focused")) {}
              for (i5 = 16842909;; i5 = -16842909)
              {
                arrayOfInt[i1] = i5;
                i5 = i1 + 1;
                i1 = n;
                n = i5;
                break;
              }
            }
            if (!str.equalsIgnoreCase("color")) {
              break label688;
            }
            i5 = Color.parseColor((String)localObject4);
            n = i1;
            i1 = i5;
          }
        }
        localObject5 = StateSet.trimStateSet(arrayOfInt, i1);
        if (i2 + 1 < i3) {
          break label682;
        }
        i1 = i2 + 1;
        localObject3 = new int[i1];
        System.arraycopy(localObject1, 0, localObject3, 0, i2);
        localObject4 = new int[i1][];
        System.arraycopy(localObject2, 0, localObject4, 0, i2);
        localObject1 = localObject3;
        localObject2 = localObject4;
        label603:
        localObject1[i2] = n;
        localObject2[i2] = localObject5;
        n = i2 + 1;
        i3 = i1;
      }
    }
    for (;;)
    {
      i4 += 1;
      i2 = n;
      break;
      paramJSONArray = new int[i2];
      localObject3 = new int[i2][];
      System.arraycopy(localObject1, 0, paramJSONArray, 0, i2);
      System.arraycopy(localObject2, 0, localObject3, 0, i2);
      return new ColorStateList((int[][])localObject3, paramJSONArray);
      return null;
      label682:
      i1 = i3;
      break label603;
      label688:
      i5 = n;
      n = i1;
      i1 = i5;
      break label172;
      label699:
      n = i2;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable fileName=" + paramString);
    }
    String str = null;
    Object localObject2 = null;
    label649:
    label680:
    label685:
    label688:
    for (;;)
    {
      Resources localResources;
      int n;
      try
      {
        localResources = paramQQAppInterface.a().getResources();
        localObject1 = str;
        if (paramString == null) {
          break label685;
        }
        localObject1 = str;
        if (paramString.length() <= 0) {
          break label685;
        }
        Object localObject3 = a(paramQQAppInterface);
        localObject1 = str;
        if (localObject3 == null) {
          break label685;
        }
        localObject1 = str;
        if (((String)localObject3).length() <= 0) {
          break label685;
        }
        localObject1 = (String)localObject3 + File.separator + paramString;
        str = "profilecard:" + (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable filePath=" + (String)localObject1);
        }
        if (paramBoolean)
        {
          localObject3 = (Pair)BaseApplicationImpl.a.get(str);
          if ((localObject3 != null) && (((Pair)localObject3).first != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable form sImageCache filePath=" + (String)localObject1);
            }
            return ((Drawable.ConstantState)((Pair)localObject3).first).newDrawable();
          }
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inDensity = 320;
        ((BitmapFactory.Options)localObject3).inScreenDensity = paramQQAppInterface.a().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inTargetDensity = paramQQAppInterface.a().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inScaled = true;
        if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
          ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramQQAppInterface = BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
        if (paramQQAppInterface == null) {
          break label649;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap density=" + paramQQAppInterface.getDensity() + ",width=" + paramQQAppInterface.getWidth() + ",height=" + paramQQAppInterface.getHeight());
        }
        n = Utils.getBitmapSize(paramQQAppInterface);
        if (!paramString.endsWith(".9.png")) {
          break label574;
        }
        localObject1 = paramQQAppInterface.getNinePatchChunk();
        if (localObject1 == null) {
          break label680;
        }
        paramQQAppInterface = new NinePatchDrawable(localResources, paramQQAppInterface, (byte[])localObject1, new Rect(0, 0, 0, 0), null);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable exception fileName=" + paramString + ",msg=" + paramQQAppInterface.getMessage());
        return null;
      }
      Object localObject1 = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface;
        if (paramBoolean)
        {
          BaseApplicationImpl.a.put(str, new Pair(paramQQAppInterface.getConstantState(), Integer.valueOf(n)));
          return paramQQAppInterface;
          label574:
          if ((paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")))
          {
            paramQQAppInterface = new BitmapDrawable(localResources, paramQQAppInterface);
            paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
            continue;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable file not ");
            paramQQAppInterface = localObject2;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap is null");
            }
            n = 0;
            paramQQAppInterface = localObject2;
            continue;
          }
          paramQQAppInterface = localObject2;
          continue;
          paramQQAppInterface = null;
          break label688;
        }
      }
      return localObject1;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("src")))
    {
      Object localObject = paramJSONObject.optString("src");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = (BitmapDrawable)a(paramQQAppInterface, (String)localObject, true);
        Iterator localIterator = paramJSONObject.keys();
        if (localObject != null) {
          for (;;)
          {
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramQQAppInterface = (String)localIterator.next();
            if (paramQQAppInterface.equalsIgnoreCase("antialias"))
            {
              ((BitmapDrawable)localObject).setAntiAlias(paramJSONObject.optBoolean("antialias"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("dither"))
            {
              ((BitmapDrawable)localObject).setDither(paramJSONObject.optBoolean("dither"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("filter"))
            {
              ((BitmapDrawable)localObject).setFilterBitmap(paramJSONObject.optBoolean("filter"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("gravity"))
            {
              paramQQAppInterface = paramJSONObject.optString("gravity").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface))) {
                ((BitmapDrawable)localObject).setGravity(((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramQQAppInterface)).intValue());
              }
            }
            else if (paramQQAppInterface.equalsIgnoreCase("tileMode"))
            {
              paramQQAppInterface = paramJSONObject.optString("tileMode", "disabled").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface)))
              {
                paramQQAppInterface = (Shader.TileMode)this.jdField_c_of_type_JavaUtilHashMap.get(paramQQAppInterface);
                ((BitmapDrawable)localObject).setTileModeXY(paramQQAppInterface, paramQQAppInterface);
              }
              else
              {
                ((BitmapDrawable)localObject).setTileModeXY(null, null);
              }
            }
          }
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  public StateListDrawable a(QQAppInterface paramQQAppInterface, JSONArray paramJSONArray)
  {
    StateListDrawable localStateListDrawable;
    int i1;
    Object localObject;
    String str1;
    int[] arrayOfInt;
    int n;
    Drawable localDrawable;
    label97:
    String str2;
    int i2;
    if (paramJSONArray != null)
    {
      localStateListDrawable = new StateListDrawable();
      int i3 = paramJSONArray.length();
      i1 = 0;
      if (i1 < i3)
      {
        localObject = paramJSONArray.optJSONObject(i1);
        if ((localObject != null) && (((JSONObject)localObject).has("drawable")))
        {
          str1 = ((JSONObject)localObject).optString("drawable");
          if ((str1 != null) && (str1.length() > 0))
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            arrayOfInt = new int[((JSONObject)localObject).length()];
            n = 0;
            localDrawable = null;
            if (localIterator.hasNext())
            {
              str2 = (String)localIterator.next();
              i2 = Build.VERSION.SDK_INT;
              if (str2.equalsIgnoreCase("state_pressed")) {
                if (((JSONObject)localObject).optBoolean("state_pressed"))
                {
                  i2 = 16842919;
                  label151:
                  arrayOfInt[n] = i2;
                  n += 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break label97;
      i2 = -16842919;
      break label151;
      if (str2.equalsIgnoreCase("state_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_focused")) {}
        for (i2 = 16842908;; i2 = -16842908)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_hovered")) && (i2 >= 14))
      {
        if (((JSONObject)localObject).optBoolean("state_hovered")) {}
        for (i2 = 16843623;; i2 = -16843623)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_selected"))
      {
        if (((JSONObject)localObject).optBoolean("state_selected")) {}
        for (i2 = 16842913;; i2 = -16842913)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checkable"))
      {
        if (((JSONObject)localObject).optBoolean("state_checkable")) {}
        for (i2 = 16842911;; i2 = -16842911)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checked"))
      {
        if (((JSONObject)localObject).optBoolean("state_checked")) {}
        for (i2 = 16842912;; i2 = -16842912)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_enabled"))
      {
        if (((JSONObject)localObject).optBoolean("state_enabled")) {}
        for (i2 = 16842910;; i2 = -16842910)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_activated")) && (i2 >= 11))
      {
        if (((JSONObject)localObject).optBoolean("state_activated")) {}
        for (i2 = 16843518;; i2 = -16843518)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_window_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_window_focused")) {}
        for (i2 = 16842909;; i2 = -16842909)
        {
          arrayOfInt[n] = i2;
          n += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("drawable"))
      {
        localDrawable = a(paramQQAppInterface, str1, true);
        continue;
        localObject = StateSet.trimStateSet(arrayOfInt, n);
        if (localDrawable != null) {
          localStateListDrawable.addState((int[])localObject, localDrawable);
        }
        i1 += 1;
        break;
        return localStateListDrawable;
        return null;
      }
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    if (this.jdField_a_of_type_Long != jdField_a_of_type_Int) {
      return paramQQAppInterface + File.separator + this.jdField_a_of_type_Long + "_" + this.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  /* Error */
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 357	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +13 -> 21
    //   11: ldc_w 359
    //   14: iconst_2
    //   15: ldc_w 615
    //   18: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 389	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +901 -> 931
    //   33: aload 5
    //   35: invokevirtual 287	java/lang/String:length	()I
    //   38: ifle +893 -> 931
    //   41: new 361	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   48: aload 5
    //   50: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: getstatic 394	java/io/File:separator	Ljava/lang/String;
    //   56: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 617
    //   62: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 6
    //   70: ldc 42
    //   72: astore 5
    //   74: new 391	java/io/File
    //   77: dup
    //   78: aload 6
    //   80: invokespecial 620	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore 6
    //   85: aload 6
    //   87: invokevirtual 623	java/io/File:exists	()Z
    //   90: ifeq +713 -> 803
    //   93: new 625	java/io/FileInputStream
    //   96: dup
    //   97: aload 6
    //   99: invokespecial 628	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: astore 8
    //   104: aload 5
    //   106: astore 7
    //   108: aload 8
    //   110: astore 6
    //   112: new 630	java/io/ByteArrayOutputStream
    //   115: dup
    //   116: invokespecial 631	java/io/ByteArrayOutputStream:<init>	()V
    //   119: astore 9
    //   121: aload 5
    //   123: astore 7
    //   125: aload 8
    //   127: astore 6
    //   129: sipush 4096
    //   132: newarray byte
    //   134: astore 10
    //   136: aload 5
    //   138: astore 7
    //   140: aload 8
    //   142: astore 6
    //   144: aload 8
    //   146: aload 10
    //   148: iconst_0
    //   149: sipush 4096
    //   152: invokevirtual 637	java/io/InputStream:read	([BII)I
    //   155: istore_2
    //   156: iload_2
    //   157: iconst_m1
    //   158: if_icmpeq +162 -> 320
    //   161: aload 5
    //   163: astore 7
    //   165: aload 8
    //   167: astore 6
    //   169: aload 9
    //   171: aload 10
    //   173: iconst_0
    //   174: iload_2
    //   175: invokevirtual 641	java/io/ByteArrayOutputStream:write	([BII)V
    //   178: goto -42 -> 136
    //   181: astore_1
    //   182: aload 7
    //   184: astore 5
    //   186: aload 8
    //   188: astore 6
    //   190: invokestatic 357	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +85 -> 278
    //   196: aload 8
    //   198: astore 6
    //   200: new 361	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   207: aload_1
    //   208: invokevirtual 645	java/lang/Object:getClass	()Ljava/lang/Class;
    //   211: invokevirtual 650	java/lang/Class:getName	()Ljava/lang/String;
    //   214: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 652
    //   220: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_1
    //   224: invokevirtual 653	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 7
    //   235: aload 8
    //   237: astore 6
    //   239: ldc_w 359
    //   242: iconst_2
    //   243: new 361	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 655
    //   253: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 5
    //   258: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 657
    //   264: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 7
    //   269: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload 8
    //   280: astore 6
    //   282: aload_1
    //   283: invokevirtual 658	java/lang/Exception:printStackTrace	()V
    //   286: aload 8
    //   288: ifnull +638 -> 926
    //   291: aload 8
    //   293: invokevirtual 661	java/io/InputStream:close	()V
    //   296: iconst_0
    //   297: istore_2
    //   298: iload_2
    //   299: ifeq +603 -> 902
    //   302: aload_0
    //   303: getfield 79	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   306: invokevirtual 664	java/util/HashMap:size	()I
    //   309: istore_2
    //   310: iload_2
    //   311: ifle +591 -> 902
    //   314: iconst_1
    //   315: istore_3
    //   316: aload_0
    //   317: monitorexit
    //   318: iload_3
    //   319: ireturn
    //   320: aload 5
    //   322: astore 7
    //   324: aload 8
    //   326: astore 6
    //   328: new 153	java/lang/String
    //   331: dup
    //   332: aload 9
    //   334: invokevirtual 667	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   337: ldc_w 669
    //   340: invokespecial 672	java/lang/String:<init>	([BLjava/lang/String;)V
    //   343: astore 9
    //   345: aload 9
    //   347: ifnull +498 -> 845
    //   350: aload 5
    //   352: astore 7
    //   354: aload 8
    //   356: astore 6
    //   358: aload 9
    //   360: invokevirtual 287	java/lang/String:length	()I
    //   363: ifle +482 -> 845
    //   366: aload 5
    //   368: astore 7
    //   370: aload 8
    //   372: astore 6
    //   374: new 279	org/json/JSONObject
    //   377: dup
    //   378: aload 9
    //   380: invokespecial 673	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   383: astore 10
    //   385: aload 5
    //   387: astore 7
    //   389: aload 8
    //   391: astore 6
    //   393: aload 10
    //   395: invokevirtual 291	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   398: astore 11
    //   400: aload 5
    //   402: astore 7
    //   404: aload 8
    //   406: astore 6
    //   408: aload 11
    //   410: invokeinterface 299 1 0
    //   415: ifeq +430 -> 845
    //   418: aload 5
    //   420: astore 7
    //   422: aload 8
    //   424: astore 6
    //   426: aload 11
    //   428: invokeinterface 303 1 0
    //   433: checkcast 153	java/lang/String
    //   436: astore 9
    //   438: aload 8
    //   440: astore 6
    //   442: aload 10
    //   444: aload 9
    //   446: invokevirtual 676	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   449: astore 7
    //   451: aload 7
    //   453: ifnull +489 -> 942
    //   456: aload 8
    //   458: astore 6
    //   460: aload 7
    //   462: ldc_w 678
    //   465: invokevirtual 286	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   468: astore 5
    //   470: aload 5
    //   472: ifnull +470 -> 942
    //   475: aload 8
    //   477: astore 6
    //   479: aload 5
    //   481: invokevirtual 287	java/lang/String:length	()I
    //   484: ifle +458 -> 942
    //   487: aload 8
    //   489: astore 6
    //   491: aload 5
    //   493: ldc_w 680
    //   496: invokevirtual 157	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   499: ifeq +45 -> 544
    //   502: aload 8
    //   504: astore 6
    //   506: aload_0
    //   507: aload 7
    //   509: ldc_w 682
    //   512: invokevirtual 686	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   515: invokevirtual 688	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lorg/json/JSONArray;)Landroid/content/res/ColorStateList;
    //   518: astore 5
    //   520: aload 5
    //   522: ifnull +198 -> 720
    //   525: aload 8
    //   527: astore 6
    //   529: aload_0
    //   530: getfield 79	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   533: aload 9
    //   535: aload 5
    //   537: invokevirtual 95	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   540: pop
    //   541: goto +401 -> 942
    //   544: aload 8
    //   546: astore 6
    //   548: aload 5
    //   550: ldc_w 690
    //   553: invokevirtual 157	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   556: ifeq +26 -> 582
    //   559: aload 8
    //   561: astore 6
    //   563: aload_0
    //   564: aload_1
    //   565: aload 7
    //   567: ldc_w 682
    //   570: invokevirtual 286	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   573: iconst_1
    //   574: invokevirtual 534	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Landroid/graphics/drawable/Drawable;
    //   577: astore 5
    //   579: goto -59 -> 520
    //   582: aload 8
    //   584: astore 6
    //   586: aload 5
    //   588: ldc_w 692
    //   591: invokevirtual 157	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   594: ifeq +25 -> 619
    //   597: aload 8
    //   599: astore 6
    //   601: aload_0
    //   602: aload_1
    //   603: aload 7
    //   605: ldc_w 682
    //   608: invokevirtual 676	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   611: invokevirtual 694	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lorg/json/JSONObject;)Landroid/graphics/drawable/Drawable;
    //   614: astore 5
    //   616: goto -96 -> 520
    //   619: aload 8
    //   621: astore 6
    //   623: aload 5
    //   625: ldc_w 696
    //   628: invokevirtual 157	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   631: ifeq +25 -> 656
    //   634: aload 8
    //   636: astore 6
    //   638: aload_0
    //   639: aload_1
    //   640: aload 7
    //   642: ldc_w 682
    //   645: invokevirtual 686	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   648: invokevirtual 698	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lorg/json/JSONArray;)Landroid/graphics/drawable/StateListDrawable;
    //   651: astore 5
    //   653: goto -133 -> 520
    //   656: aload 8
    //   658: astore 6
    //   660: aload 5
    //   662: ldc_w 700
    //   665: invokevirtual 157	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   668: ifeq +20 -> 688
    //   671: aload 8
    //   673: astore 6
    //   675: aload 7
    //   677: ldc_w 682
    //   680: invokevirtual 286	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   683: astore 5
    //   685: goto -165 -> 520
    //   688: aload 8
    //   690: astore 6
    //   692: aload 5
    //   694: ldc_w 702
    //   697: invokevirtual 157	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   700: ifeq +236 -> 936
    //   703: aload 8
    //   705: astore 6
    //   707: aload 7
    //   709: ldc_w 682
    //   712: invokevirtual 286	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   715: astore 5
    //   717: goto -197 -> 520
    //   720: aload 8
    //   722: astore 6
    //   724: invokestatic 357	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +41 -> 768
    //   730: aload 8
    //   732: astore 6
    //   734: ldc_w 359
    //   737: iconst_2
    //   738: new 361	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 704
    //   748: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 9
    //   753: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: ldc_w 706
    //   759: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: iload 4
    //   770: istore_3
    //   771: aload 8
    //   773: ifnull -457 -> 316
    //   776: aload 8
    //   778: invokevirtual 661	java/io/InputStream:close	()V
    //   781: iload 4
    //   783: istore_3
    //   784: goto -468 -> 316
    //   787: astore_1
    //   788: aload_1
    //   789: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   792: iload 4
    //   794: istore_3
    //   795: goto -479 -> 316
    //   798: astore_1
    //   799: aload_0
    //   800: monitorexit
    //   801: aload_1
    //   802: athrow
    //   803: invokestatic 357	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq +13 -> 819
    //   809: ldc_w 359
    //   812: iconst_2
    //   813: ldc_w 709
    //   816: invokestatic 375	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   819: iload 4
    //   821: istore_3
    //   822: iconst_0
    //   823: ifeq -507 -> 316
    //   826: new 711	java/lang/NullPointerException
    //   829: dup
    //   830: invokespecial 712	java/lang/NullPointerException:<init>	()V
    //   833: athrow
    //   834: astore_1
    //   835: aload_1
    //   836: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   839: iload 4
    //   841: istore_3
    //   842: goto -526 -> 316
    //   845: aload 8
    //   847: ifnull +84 -> 931
    //   850: aload 8
    //   852: invokevirtual 661	java/io/InputStream:close	()V
    //   855: iconst_1
    //   856: istore_2
    //   857: goto -559 -> 298
    //   860: astore_1
    //   861: aload_1
    //   862: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   865: goto -10 -> 855
    //   868: astore_1
    //   869: aload_1
    //   870: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   873: goto -577 -> 296
    //   876: astore_1
    //   877: aconst_null
    //   878: astore 6
    //   880: aload 6
    //   882: ifnull +8 -> 890
    //   885: aload 6
    //   887: invokevirtual 661	java/io/InputStream:close	()V
    //   890: aload_1
    //   891: athrow
    //   892: astore 5
    //   894: aload 5
    //   896: invokevirtual 707	java/io/IOException:printStackTrace	()V
    //   899: goto -9 -> 890
    //   902: iconst_0
    //   903: istore_3
    //   904: goto -588 -> 316
    //   907: astore_1
    //   908: goto -28 -> 880
    //   911: astore_1
    //   912: aconst_null
    //   913: astore 8
    //   915: goto -729 -> 186
    //   918: astore_1
    //   919: aload 9
    //   921: astore 5
    //   923: goto -737 -> 186
    //   926: iconst_0
    //   927: istore_2
    //   928: goto -630 -> 298
    //   931: iconst_1
    //   932: istore_2
    //   933: goto -635 -> 298
    //   936: aconst_null
    //   937: astore 5
    //   939: goto -419 -> 520
    //   942: aload 9
    //   944: astore 5
    //   946: goto -546 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	ProfileCardTemplate
    //   0	949	1	paramQQAppInterface	QQAppInterface
    //   155	778	2	n	int
    //   315	589	3	bool1	boolean
    //   1	839	4	bool2	boolean
    //   26	690	5	localObject1	Object
    //   892	3	5	localIOException	java.io.IOException
    //   921	24	5	localObject2	Object
    //   68	818	6	localObject3	Object
    //   106	602	7	localObject4	Object
    //   102	812	8	localFileInputStream	java.io.FileInputStream
    //   119	824	9	localObject5	Object
    //   134	309	10	localObject6	Object
    //   398	29	11	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   112	121	181	java/lang/Exception
    //   129	136	181	java/lang/Exception
    //   144	156	181	java/lang/Exception
    //   169	178	181	java/lang/Exception
    //   328	345	181	java/lang/Exception
    //   358	366	181	java/lang/Exception
    //   374	385	181	java/lang/Exception
    //   393	400	181	java/lang/Exception
    //   408	418	181	java/lang/Exception
    //   426	438	181	java/lang/Exception
    //   776	781	787	java/io/IOException
    //   5	21	798	finally
    //   21	28	798	finally
    //   33	70	798	finally
    //   291	296	798	finally
    //   302	310	798	finally
    //   776	781	798	finally
    //   788	792	798	finally
    //   826	834	798	finally
    //   835	839	798	finally
    //   850	855	798	finally
    //   861	865	798	finally
    //   869	873	798	finally
    //   885	890	798	finally
    //   890	892	798	finally
    //   894	899	798	finally
    //   826	834	834	java/io/IOException
    //   850	855	860	java/io/IOException
    //   291	296	868	java/io/IOException
    //   74	104	876	finally
    //   803	819	876	finally
    //   885	890	892	java/io/IOException
    //   112	121	907	finally
    //   129	136	907	finally
    //   144	156	907	finally
    //   169	178	907	finally
    //   190	196	907	finally
    //   200	235	907	finally
    //   239	278	907	finally
    //   282	286	907	finally
    //   328	345	907	finally
    //   358	366	907	finally
    //   374	385	907	finally
    //   393	400	907	finally
    //   408	418	907	finally
    //   426	438	907	finally
    //   442	451	907	finally
    //   460	470	907	finally
    //   479	487	907	finally
    //   491	502	907	finally
    //   506	520	907	finally
    //   529	541	907	finally
    //   548	559	907	finally
    //   563	579	907	finally
    //   586	597	907	finally
    //   601	616	907	finally
    //   623	634	907	finally
    //   638	653	907	finally
    //   660	671	907	finally
    //   675	685	907	finally
    //   692	703	907	finally
    //   707	717	907	finally
    //   724	730	907	finally
    //   734	768	907	finally
    //   74	104	911	java/lang/Exception
    //   803	819	911	java/lang/Exception
    //   442	451	918	java/lang/Exception
    //   460	470	918	java/lang/Exception
    //   479	487	918	java/lang/Exception
    //   491	502	918	java/lang/Exception
    //   506	520	918	java/lang/Exception
    //   529	541	918	java/lang/Exception
    //   548	559	918	java/lang/Exception
    //   563	579	918	java/lang/Exception
    //   586	597	918	java/lang/Exception
    //   601	616	918	java/lang/Exception
    //   623	634	918	java/lang/Exception
    //   638	653	918	java/lang/Exception
    //   660	671	918	java/lang/Exception
    //   675	685	918	java/lang/Exception
    //   692	703	918	java/lang/Exception
    //   707	717	918	java/lang/Exception
    //   724	730	918	java/lang/Exception
    //   734	768	918	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = getClass().getFields();
    localStringBuilder.append("ProfileCardTemplate:");
    int n = 0;
    int i1 = arrayOfField.length;
    for (;;)
    {
      Field localField;
      if (n < i1)
      {
        localField = arrayOfField[n];
        if (localField.getModifiers() == 8) {}
      }
      try
      {
        Object localObject = localField.get(this);
        localStringBuilder.append(localField.getName());
        localStringBuilder.append('=');
        localStringBuilder.append(localObject);
        localStringBuilder.append(',');
        label91:
        n += 1;
        continue;
        return localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        break label91;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardTemplate
 * JD-Core Version:    0.7.0.1
 */