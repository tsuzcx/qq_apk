package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import hbm;
import java.util.ArrayList;
import java.util.Arrays;

public class AtTroopMemberSpan
  extends DynamicDrawableSpan
{
  public static final String c = "@";
  public static final String d = " ";
  private static final String f = "...";
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public String a;
  private int b;
  public String b;
  private String e = "";
  
  private AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt, EditText paramEditText)
  {
    super(0);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = a(String.format("%s%s", new Object[] { "@", paramString2 }));
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramEditText);
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, EditText paramEditText)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), AtTroopMemberSpan.class);
    int i = 0;
    while (i < arrayOfAtTroopMemberSpan.length)
    {
      if (arrayOfAtTroopMemberSpan[i].jdField_a_of_type_JavaLangString.contentEquals(paramString2)) {
        return null;
      }
      i += 1;
    }
    i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean, i - j - k, paramEditText);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      paramString1 = new SpannableString(paramContext + " ");
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), AtTroopMemberSpan.class);
    int i = 0;
    while (i < arrayOfAtTroopMemberSpan.length)
    {
      if (arrayOfAtTroopMemberSpan[i].jdField_a_of_type_JavaLangString.contentEquals(paramString2)) {
        return null;
      }
      i += 1;
    }
    i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, i - j - k, paramEditText, paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
      paramString1 = new SpannableString(paramContext + " ");
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static AtTroopMemberSpan a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, EditText paramEditText)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt <= 0)) {}
    for (;;)
    {
      return null;
      if ((!paramBoolean) && (!paramString2.equalsIgnoreCase("0"))) {}
      for (paramQQAppInterface = ContactUtils.d(paramQQAppInterface, paramString1, paramString2); !TextUtils.isEmpty(paramQQAppInterface); paramQQAppInterface = paramString3) {
        return new AtTroopMemberSpan(paramContext, paramString2, paramQQAppInterface, paramInt, paramEditText);
      }
    }
  }
  
  private static AtTroopMemberSpan a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, EditText paramEditText, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt <= 0)) {}
    for (;;)
    {
      return null;
      if (paramBoolean2) {
        if ((!paramBoolean1) && (!paramString2.equalsIgnoreCase("0")))
        {
          paramString1 = ContactUtils.e(paramQQAppInterface, paramString1, paramString2);
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1))
          {
            paramQQAppInterface = paramString1;
            if (!TextUtils.isEmpty(paramString3)) {
              paramQQAppInterface = paramString3;
            }
          }
        }
      }
      while (!TextUtils.isEmpty(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("_At_Me_DISC", 2, " memUin:" + paramString2 + " troopMemName:" + Utils.a(paramQQAppInterface) + " isTroop:" + paramBoolean2);
        }
        return new AtTroopMemberSpan(paramContext, paramString2, paramQQAppInterface, paramInt, paramEditText);
        paramQQAppInterface = paramString3;
        continue;
        if (!paramString2.equalsIgnoreCase("0"))
        {
          paramString1 = ContactUtils.c(paramQQAppInterface, paramString2, true);
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1))
          {
            paramQQAppInterface = paramString1;
            if (!TextUtils.isEmpty(paramString3)) {
              paramQQAppInterface = paramString3;
            }
          }
        }
        else
        {
          paramQQAppInterface = paramString3;
        }
      }
    }
  }
  
  public static String a(Editable paramEditable, ArrayList paramArrayList)
  {
    int i = 0;
    if ((paramArrayList == null) || (paramEditable == null)) {
      return "";
    }
    paramArrayList.clear();
    StringBuffer localStringBuffer = new StringBuffer(paramEditable.toString());
    AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditable.getSpans(0, localStringBuffer.length() - 1, AtTroopMemberSpan.class);
    if (arrayOfAtTroopMemberSpan.length == 0) {
      return localStringBuffer.toString();
    }
    if (arrayOfAtTroopMemberSpan.length > 1) {
      Arrays.sort(arrayOfAtTroopMemberSpan, new hbm(paramEditable));
    }
    int j = 0;
    while (i < arrayOfAtTroopMemberSpan.length)
    {
      AtTroopMemberSpan localAtTroopMemberSpan = arrayOfAtTroopMemberSpan[i];
      int k = paramEditable.getSpanStart(localAtTroopMemberSpan) + j;
      int m = paramEditable.getSpanEnd(localAtTroopMemberSpan) + j;
      localStringBuffer.replace(k, m, localAtTroopMemberSpan.jdField_b_of_type_JavaLangString);
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
      localAtTroopMemberInfo.uin = Long.valueOf(localAtTroopMemberSpan.jdField_a_of_type_JavaLangString).longValue();
      if ((localAtTroopMemberSpan.jdField_a_of_type_JavaLangString != null) && (localAtTroopMemberSpan.jdField_a_of_type_JavaLangString.equalsIgnoreCase("0"))) {
        localAtTroopMemberInfo.flag = 1;
      }
      localAtTroopMemberInfo.startPos = ((short)k);
      localAtTroopMemberInfo.textLen = ((short)localAtTroopMemberSpan.jdField_b_of_type_JavaLangString.length());
      paramArrayList.add(localAtTroopMemberInfo);
      j += localAtTroopMemberInfo.textLen - (m - k);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (EmotcationConstants.a.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_Int != -1) {}
    for (;;)
    {
      return;
      float f1 = paramPaint.measureText(" ");
      this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.jdField_b_of_type_JavaLangString) + f1 * 2.0F));
      if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
      {
        this.e = String.format("%s%s%s", new Object[] { " ", this.jdField_b_of_type_JavaLangString, " " });
        return;
      }
      int i = this.jdField_b_of_type_JavaLangString.length() - 1;
      float f2 = paramPaint.measureText("...");
      while (i > 0)
      {
        this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.jdField_b_of_type_JavaLangString, 0, i) + f2 + f1 * 2.0F));
        if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
        {
          this.e = String.format("%s%s%s%s", new Object[] { " ", this.jdField_b_of_type_JavaLangString.substring(0, i), "...", " " });
          return;
        }
        i -= 1;
      }
    }
  }
  
  private void a(EditText paramEditText)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    int k = paramEditText.getShadowColor();
    float f1 = paramEditText.getShadowDx();
    float f2 = paramEditText.getShadowDy();
    float f3 = paramEditText.getShadowRadius();
    if (Build.VERSION.SDK_INT >= 25) {
      paramEditText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    Object localObject1 = paramEditText.getPaint();
    a((Paint)localObject1);
    Object localObject2 = ((Paint)localObject1).getFontMetrics();
    float f4 = -((Paint.FontMetrics)localObject2).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top);
    localObject2 = new RectF(0.0F, ((Paint.FontMetrics)localObject2).ascent - ((Paint.FontMetrics)localObject2).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject2).descent + f4);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    i = ((Paint)localObject1).getColor();
    ((Paint)localObject1).setColor(-4331268);
    localCanvas.drawRect((RectF)localObject2, (Paint)localObject1);
    ((Paint)localObject1).setColor(i);
    localCanvas.drawText(this.e, 0.0F, f4, (Paint)localObject1);
    localCanvas.save(31);
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
    i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (i > 0) {
      if (j <= 0) {
        break label292;
      }
    }
    for (;;)
    {
      ((Drawable)localObject1).setBounds(0, 0, i, j);
      paramEditText.setShadowLayer(f3, f1, f2, k);
      return;
      i = 0;
      break;
      label292:
      j = 0;
    }
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.AtTroopMemberSpan
 * JD-Core Version:    0.7.0.1
 */