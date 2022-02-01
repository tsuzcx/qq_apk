package com.tencent.mobileqq.nearby.redtouch;

import ajrb;
import akjq;
import akju;
import android.util.Log;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import jnv;

public class NearbyOfficalReportHelper$1
  implements Runnable
{
  public NearbyOfficalReportHelper$1(akjq paramakjq, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = ((jnv)this.val$app.getManager(70)).a();
    String str3;
    String str1;
    String str2;
    if (((akju)localObject).dmY > 0)
    {
      str3 = String.valueOf(ajrb.c(this.val$app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      if (((akju)localObject).dna <= 0) {
        break label167;
      }
      str1 = "1";
      if (((akju)localObject).dmZ <= 0) {
        break label173;
      }
      str2 = "1";
      label64:
      if (((akju)localObject).num <= 1) {
        break label179;
      }
    }
    label167:
    label173:
    label179:
    for (localObject = "1";; localObject = "0")
    {
      anot.a(null, "dc00899", "grp_lbs", "", this.bTz, this.azN, 0, 0, str3, str1, str2, "");
      Log.i(" NearbyRecommend", "reportLebaRedDotEvent op_name = " + this.azN + " d1 = " + str3 + " d2 = " + str1 + " d3 = " + str2 + " d4 = " + (String)localObject);
      return;
      str1 = "0";
      break;
      str2 = "0";
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper.1
 * JD-Core Version:    0.7.0.1
 */