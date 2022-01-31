package com.tencent.mobileqq.richstatus;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class RichStatus
  implements Cloneable
{
  public static final float a = -0.1F;
  public static final int a = 0;
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
  public static final String a = "[L]";
  public static final float b = 1.1F;
  public static final String b = "[S]";
  public static final float c = 0.9F;
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private static final int k = 4;
  private static final int l = 128;
  private static final int m = 129;
  private static final int n = 130;
  private static final int o = 2;
  private static final int p = 8;
  private static final int q = 8;
  private static final int r = 10;
  private static final int s = 10;
  private static final int t = 12;
  private static final int u = 12;
  private static final int v = 256;
  private static final int w = 2;
  public long a;
  public ArrayList a;
  public byte[] a;
  public int b = 0;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  public RichStatus(String paramString)
  {
    this.jdField_c_of_type_Int = 0;
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  private static int a(String paramString)
  {
    return paramString.getBytes().length;
  }
  
  public static RichStatus a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    return jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  }
  
  public static RichStatus a(byte[] paramArrayOfByte)
  {
    RichStatus localRichStatus = new RichStatus(null);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {
      return localRichStatus;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    Object localObject1 = null;
    int i1 = 0;
    label82:
    int i3;
    int i2;
    for (;;)
    {
      if (localByteBuffer.hasRemaining())
      {
        if (localByteBuffer.remaining() >= 2) {
          break label82;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          localRichStatus.a((String)localObject1);
        }
        return localRichStatus;
        i3 = localByteBuffer.get();
        int i4 = localByteBuffer.get();
        i2 = i3;
        if (i3 < 0) {
          i2 = i3 + 256;
        }
        i3 = i4;
        if (i4 < 0) {
          i3 = i4 + 256;
        }
        if (localByteBuffer.remaining() >= i3) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      i1 += 2;
      if ((i2 <= 0) || (i2 >= 128)) {
        break;
      }
      String str = new String(paramArrayOfByte, i1, i3);
      i1 = i3 + i1;
      localByteBuffer.position(i1);
      switch (i2)
      {
      case 3: 
      default: 
        if (localObject1 == null) {
          localObject1 = str;
        }
        break;
      case 1: 
        localRichStatus.jdField_c_of_type_JavaLangString = str;
        break;
      case 2: 
        localRichStatus.jdField_d_of_type_JavaLangString = str;
        break;
      case 4: 
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          localRichStatus.a((String)localObject1);
          localObject2 = null;
        }
        if (localRichStatus.jdField_a_of_type_JavaUtilArrayList != null) {}
        for (localRichStatus.jdField_d_of_type_Int = localRichStatus.jdField_a_of_type_JavaUtilArrayList.size();; localRichStatus.jdField_d_of_type_Int = 0)
        {
          localRichStatus.jdField_e_of_type_JavaLangString = str;
          localObject1 = localObject2;
          break;
        }
        localObject1 = (String)localObject1 + str;
      }
    }
    switch (i2)
    {
    }
    for (;;)
    {
      i1 += i3;
      localByteBuffer.position(i1);
      break;
      if (localByteBuffer.remaining() < 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      else
      {
        localRichStatus.b = localByteBuffer.getInt();
        localRichStatus.jdField_c_of_type_Int = localByteBuffer.getInt();
        continue;
        if (localByteBuffer.remaining() < 8)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
          }
        }
        else
        {
          localRichStatus.jdField_e_of_type_Int = localByteBuffer.getInt();
          localRichStatus.f = localByteBuffer.getInt();
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.getBytes();
      paramByteBuffer.put((byte)paramInt).put((byte)paramString.length).put(paramString, 0, paramString.length);
    }
  }
  
  public int a()
  {
    int i1 = 0;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      i1 = 0 + (a(this.jdField_c_of_type_JavaLangString) + 12);
    }
    int i2 = i1;
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      i2 = i1 + (a(this.jdField_d_of_type_JavaLangString) + 2);
    }
    i1 = i2;
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      i1 = i2 + (a(this.jdField_e_of_type_JavaLangString) + 12);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label134;
      }
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str)) {
        break label136;
      }
      i1 = a(str) + 2 + i1;
    }
    label134:
    label136:
    for (;;)
    {
      break;
      i2 = i1;
      return i2;
    }
  }
  
  public SpannableString a(String paramString)
  {
    return a(paramString, -8947849);
  }
  
  public SpannableString a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -2039584);
  }
  
  public SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder(str);
    a(paramString, this.jdField_c_of_type_JavaLangString);
    a(paramString, this.jdField_d_of_type_JavaLangString);
    int i3 = paramString.length();
    if (i3 > str.length()) {
      paramString.append(' ');
    }
    int i1 = 0;
    while (i1 < this.jdField_d_of_type_Int)
    {
      a(paramString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
      i1 += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (i1 = this.jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      int i2 = this.jdField_d_of_type_Int;
      while (i2 < i1)
      {
        a(paramString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i2));
        i2 += 1;
      }
    }
    paramString = new SpannableString(paramString.toString());
    if (i3 > str.length()) {
      paramString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, i3, 33);
    }
    return paramString;
  }
  
  public CharSequence a(TextView paramTextView)
  {
    return a(paramTextView, "");
  }
  
  public CharSequence a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      return paramCharSequence;
    }
    Object localObject2 = new StringBuilder();
    Object localObject1;
    if (paramCharSequence != null)
    {
      localObject1 = " " + paramCharSequence;
      localObject1 = new SpannableString((String)localObject1 + "[L]" + " " + this.jdField_e_of_type_JavaLangString);
      localObject2 = paramTextView.getResources();
      if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
        jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource((Resources)localObject2, 2130839117);
      }
      i1 = (int)(paramTextView.getTextSize() * 0.9F + 0.5F);
      int i2 = jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * i1 / jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      paramTextView = new StatableBitmapDrawable((Resources)localObject2, jdField_a_of_type_AndroidGraphicsBitmap, false, true);
      paramTextView.setBounds(0, 0, i2, i1);
      paramTextView = new OffsetableImageSpan(paramTextView, 0).a(-0.1F);
      if (paramCharSequence == null) {
        break label212;
      }
    }
    label212:
    for (int i1 = paramCharSequence.length() + 1;; i1 = 0)
    {
      ((SpannableString)localObject1).setSpan(paramTextView, i1, "[L]".length() + i1, 33);
      return localObject1;
      localObject1 = "";
      break;
    }
  }
  
  public boolean a()
  {
    return (this.b == 0) && (this.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_JavaUtilArrayList == null) && (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString));
  }
  
  public byte[] a()
  {
    int i2 = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(a());
    a(localByteBuffer, 1, this.jdField_c_of_type_JavaLangString);
    a(localByteBuffer, 2, this.jdField_d_of_type_JavaLangString);
    int i1 = 0;
    while (i1 < this.jdField_d_of_type_Int)
    {
      a(localByteBuffer, 3, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
      i1 += 1;
    }
    a(localByteBuffer, 4, this.jdField_e_of_type_JavaLangString);
    i1 = i2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    i2 = this.jdField_d_of_type_Int;
    while (i2 < i1)
    {
      a(localByteBuffer, 3, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i2));
      i2 += 1;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      localByteBuffer.put((byte)-127).put((byte)8).putInt(this.b).putInt(this.jdField_c_of_type_Int);
    }
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localByteBuffer.put((byte)-126).put((byte)8).putInt(this.jdField_e_of_type_Int).putInt(this.f);
    }
    return localByteBuffer.array();
  }
  
  public int b()
  {
    return (a() + 2) / 3;
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      RichStatus localRichStatus = (RichStatus)super.clone();
      localObject = localRichStatus;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      localObject.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatus
 * JD-Core Version:    0.7.0.1
 */