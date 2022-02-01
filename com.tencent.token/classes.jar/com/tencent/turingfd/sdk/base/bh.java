package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;

public class bh
{
  public static final long a = ;
  
  public static String a(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("T:");
    localStringBuilder.append(a);
    localStringBuilder.append(",");
    localStringBuilder.append("LT:");
    localStringBuilder.append("" + (System.currentTimeMillis() - a));
    localStringBuilder.append(",");
    localStringBuilder.append("F:");
    label170:
    label203:
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",");
      localStringBuilder.append("PT:");
      localStringBuilder.append("" + paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append("PKG:");
      if (!paramBoolean2) {
        break label407;
      }
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",");
      localStringBuilder.append("SC:");
      if (!paramBoolean3) {
        break label414;
      }
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      localObject1 = bd.a.b(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("CL:");
        localStringBuilder.append((String)localObject1);
      }
      localObject2 = aw.a(paramContext, "204");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ci.a("0_");
        if (!paramBoolean1) {
          break label421;
        }
      }
    }
    label407:
    label414:
    label421:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      localObject1 = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("R:");
        localStringBuilder.append((String)localObject1);
      }
      localStringBuilder.append(",");
      localStringBuilder.append("US:");
      localStringBuilder.append(aw.a(paramContext));
      paramContext = aw.a(paramContext, "111");
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("ND:");
        localStringBuilder.append(paramContext);
      }
      return localStringBuilder.toString();
      localObject1 = "0";
      break;
      localObject1 = "0";
      break label170;
      localObject1 = "0";
      break label203;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bh
 * JD-Core Version:    0.7.0.1
 */