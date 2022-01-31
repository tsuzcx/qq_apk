package com.tencent.mobileqq.profile;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ListView;
import java.lang.reflect.Field;
import java.util.HashMap;

public class ProfileCardTemplate
{
  public static long a = 0L;
  public static final String a = "background";
  public static long b = 0L;
  public static final String b = "style";
  public static long c = 0L;
  public static final String c = "53";
  public static long d = 0L;
  public static final int e = 0;
  public static long e = 0L;
  public static final int f = 1;
  public static final int g = 2;
  public int a;
  public HashMap a;
  public boolean a;
  public int b;
  private HashMap b;
  public int c;
  private HashMap c;
  public int d;
  public String d;
  public String e;
  public long f;
  public String f;
  public String g = "";
  public int h;
  public String h = "";
  public int i;
  public String i = "";
  public int j;
  public String j = "";
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 1L;
    jdField_c_of_type_Long = 4L;
    jdField_d_of_type_Long = 6L;
    jdField_e_of_type_Long = 8L;
  }
  
  public ProfileCardTemplate()
  {
    this.jdField_f_of_type_Long = 0L;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "0";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
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
                          int i1 = paramView.getPaddingTop();
                          int i2 = paramProfileCardTemplate.top;
                          int i3 = paramView.getPaddingLeft();
                          int i4 = paramProfileCardTemplate.left;
                          int i5 = paramView.getPaddingRight();
                          int i6 = paramProfileCardTemplate.right;
                          int i7 = paramView.getPaddingBottom();
                          int i8 = paramProfileCardTemplate.bottom;
                          paramView.setBackgroundDrawable(paramString1);
                          paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = getClass().getFields();
    localStringBuilder.append("ProfileCardTemplate:");
    int i1 = 0;
    int i2 = arrayOfField.length;
    for (;;)
    {
      Field localField;
      if (i1 < i2)
      {
        localField = arrayOfField[i1];
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
        i1 += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardTemplate
 * JD-Core Version:    0.7.0.1
 */