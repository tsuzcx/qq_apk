package com.tencent.av.ui;

import acfp;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import aqcx;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import iiv;
import ini;
import izl;
import java.util.ArrayList;
import jjn;

public class GAudioMembersCtrlActivity$7$4
  implements Runnable
{
  public GAudioMembersCtrlActivity$7$4(izl paramizl, ArrayList paramArrayList) {}
  
  public void run()
  {
    TextPaint localTextPaint = new TextView(GAudioMembersCtrlActivity.a(this.a.this$0)).getPaint();
    String str2 = acfp.m(2131706851);
    float f3 = GAudioMembersCtrlActivity.a(this.a.this$0).getDisplayMetrics().widthPixels;
    float f4 = localTextPaint.measureText(str2);
    StringBuilder localStringBuilder = new StringBuilder();
    int m = this.iI.size();
    float f1;
    if (m == 1)
    {
      f1 = f3 - aqcx.dip2px(GAudioMembersCtrlActivity.b(this.a.this$0), 60.0F) - f4;
      if (f1 > 0.0F) {
        break label645;
      }
      f1 = GAudioMembersCtrlActivity.b(this.a.this$0).getDimensionPixelSize(2131297428);
    }
    label640:
    label645:
    for (;;)
    {
      ini localini = (ini)this.iI.get(0);
      String str1 = this.a.this$0.a.d(String.valueOf(localini.account), String.valueOf(this.a.this$0.a.b().ll), 1);
      if (TextUtils.isEmpty(str1)) {
        str1 = String.valueOf(String.valueOf(localini.account));
      }
      for (;;)
      {
        jjn.b(localStringBuilder, str1, localTextPaint, f1);
        for (;;)
        {
          localStringBuilder.append(str2);
          QQToast.a(this.a.this$0, localStringBuilder.toString(), 1).show();
          if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
          }
          return;
          f1 = localTextPaint.measureText("等99人" + str2);
          float f5 = localTextPaint.measureText("...");
          float f2 = f3 - aqcx.dip2px(GAudioMembersCtrlActivity.c(this.a.this$0), 60.0F) - f1 - f5;
          f1 = f2;
          if (f2 <= 0.0F) {
            f1 = GAudioMembersCtrlActivity.c(this.a.this$0).getDimensionPixelSize(2131297428);
          }
          float f6 = localTextPaint.measureText("、");
          int i = 0;
          int j = 0;
          label358:
          if (i < 2)
          {
            int k = 0;
            for (;;)
            {
              if (k < m)
              {
                localini = (ini)this.iI.get(k);
                str1 = this.a.this$0.a.d(String.valueOf(localini.account), String.valueOf(this.a.this$0.a.b().ll), 1);
                if (TextUtils.isEmpty(str1))
                {
                  str1 = String.valueOf(String.valueOf(localini.account));
                  f2 = jjn.a(localStringBuilder, str1, localTextPaint, f1);
                  if ((2.0F * f6 < f2) && (k < m - 1))
                  {
                    localStringBuilder.append("、");
                    k += 1;
                    f1 = f2;
                    continue;
                  }
                  if ((k == 0) && (f2 == f1) && (!TextUtils.isEmpty(str1))) {
                    jjn.a(localStringBuilder, str1, localTextPaint, GAudioMembersCtrlActivity.d(this.a.this$0).getDimensionPixelSize(2131297428));
                  }
                  if (f5 > f2)
                  {
                    localStringBuilder.append("...等");
                    localStringBuilder.append(m);
                    localStringBuilder.append("人");
                  }
                }
              }
            }
          }
          for (;;)
          {
            label452:
            if ((f5 < f2) || (j != 0)) {
              break label640;
            }
            localStringBuilder.delete(0, localStringBuilder.length());
            f1 = f3 - aqcx.dip2px(GAudioMembersCtrlActivity.d(this.a.this$0), 60.0F) - f4;
            i += 1;
            j = 1;
            break label358;
            break;
            break label452;
            f2 = f1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.7.4
 * JD-Core Version:    0.7.0.1
 */