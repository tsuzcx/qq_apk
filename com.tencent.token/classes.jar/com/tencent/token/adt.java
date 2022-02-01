package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;

public final class adt
{
  public static final long a = ;
  
  public static String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder("T:");
    localStringBuilder.append(a);
    localStringBuilder.append(",");
    localStringBuilder.append("LT:");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - a);
    localStringBuilder.append(((StringBuilder)localObject1).toString());
    localStringBuilder.append(",");
    localStringBuilder.append("F:");
    if (paramBoolean1) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append("PT:");
    localStringBuilder.append("0");
    localStringBuilder.append(",");
    localStringBuilder.append("PKG:");
    if (paramBoolean2) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append("SC:");
    if (paramBoolean3) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = adp.a;
    localObject1 = adp.b(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localStringBuilder.append(",");
      localStringBuilder.append("CL:");
      localStringBuilder.append((String)localObject1);
    }
    Object localObject2 = adi.a(paramContext, "204");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = aeu.a("0_");
      if (paramBoolean1) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localStringBuilder.append(",");
      localStringBuilder.append("R:");
      localStringBuilder.append((String)localObject1);
    }
    localStringBuilder.append(",");
    localStringBuilder.append("US:");
    localStringBuilder.append(adi.a(paramContext));
    paramContext = adi.a(paramContext, "111");
    if (!TextUtils.isEmpty(paramContext))
    {
      localStringBuilder.append(",");
      localStringBuilder.append("ND:");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adt
 * JD-Core Version:    0.7.0.1
 */