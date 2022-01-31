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
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import eof;
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
  
  private AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint)
  {
    super(0);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = a(String.format("%s%s", new Object[] { "@", paramString2 }));
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramPaint);
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
    paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramEditText.getWidth() - paramEditText.getPaddingLeft() - paramEditText.getPaddingRight(), paramEditText.getPaint());
    if (paramQQAppInterface == null) {
      return null;
    }
    paramContext = paramQQAppInterface.jdField_b_of_type_JavaLangString;
    paramString1 = new SpannableString(paramContext + " ");
    paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    return paramString1;
  }
  
  public static AtTroopMemberSpan a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Paint paramPaint)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt <= 0)) {}
    for (;;)
    {
      return null;
      if ((!paramBoolean) && (!paramString2.equalsIgnoreCase("0"))) {}
      for (paramQQAppInterface = ContactUtils.d(paramQQAppInterface, paramString1, paramString2); !TextUtils.isEmpty(paramQQAppInterface); paramQQAppInterface = paramString3) {
        return new AtTroopMemberSpan(paramContext, paramString2, paramQQAppInterface, paramInt, paramPaint);
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
      Arrays.sort(arrayOfAtTroopMemberSpan, new eof(paramEditable));
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
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    b(paramPaint);
    Object localObject = paramPaint.getFontMetrics();
    float f1 = -((Paint.FontMetrics)localObject).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
    localObject = new RectF(0.0F, ((Paint.FontMetrics)localObject).ascent - ((Paint.FontMetrics)localObject).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject).descent + f1);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    i = paramPaint.getColor();
    paramPaint.setColor(-4331268);
    localCanvas.drawRect((RectF)localObject, paramPaint);
    paramPaint.setColor(i);
    localCanvas.drawText(this.e, 0.0F, f1, paramPaint);
    localCanvas.save(31);
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
    i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    paramPaint = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (i > 0) {
      if (j <= 0) {
        break label218;
      }
    }
    for (;;)
    {
      paramPaint.setBounds(0, 0, i, j);
      return;
      i = 0;
      break;
      label218:
      j = 0;
    }
  }
  
  private void b(Paint paramPaint)
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
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.AtTroopMemberSpan
 * JD-Core Version:    0.7.0.1
 */