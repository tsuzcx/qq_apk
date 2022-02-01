package com.tencent.mobileqq.emoticonview;

import abhh;
import afgc;
import ajdg;
import android.util.SparseIntArray;
import anot;
import aoff;
import aofy;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReportWorker
  implements Runnable
{
  private WeakReference<EmoticonMainPanel> gK;
  private QQAppInterface mAppInterface;
  private int mCurType;
  private boolean mIsForward;
  private String mMsg;
  
  public ReportWorker(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mMsg = paramString;
    this.mIsForward = paramBoolean;
    this.mAppInterface = paramQQAppInterface;
    this.gK = new WeakReference(paramEmoticonMainPanel);
    this.mCurType = paramInt;
  }
  
  public void run()
  {
    if ((this.mMsg == null) || ("".equals(this.mMsg))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mMsg);
    int i = 0;
    label35:
    int j;
    int k;
    if (i < localStringBuilder.length())
    {
      j = localStringBuilder.codePointAt(i);
      if ((j != 20) || (i >= localStringBuilder.length() - 1)) {
        break label592;
      }
      k = localStringBuilder.charAt(i + 1);
      if ((k >= aoff.dOp) && (250 != k)) {
        break label245;
      }
      if (250 != k) {
        break label702;
      }
      k = 10;
    }
    label702:
    for (;;)
    {
      anot.a(this.mAppInterface, "CliOper", "", "", "ep_mall", "0X80057A3", 0, 0, k + "", "", "", "");
      if (aofy.jq(k)) {
        VipUtils.a(this.mAppInterface, "cmshow", "Apollo", "0X800812E", ApolloUtil.gi(this.mCurType), 0, new String[] { String.valueOf(k), String.valueOf(abhh.x(this.mAppInterface)) });
      }
      ajdg.fc("0", 1);
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("ReportWorker", 2, "report emoji send amount, index:" + k);
        j = i;
      }
      label245:
      do
      {
        i = j + 1;
        break label35;
        break;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length()) {
        break;
      }
      Object localObject = new char[4];
      localObject[0] = localStringBuilder.charAt(i + 4);
      localObject[1] = localStringBuilder.charAt(i + 3);
      localObject[2] = localStringBuilder.charAt(i + 2);
      localObject[3] = localStringBuilder.charAt(i + 1);
      j = 0;
      if (j < 3)
      {
        if (localObject[j] == 'ú') {
          localObject[j] = 10;
        }
        for (;;)
        {
          j += 1;
          break;
          if (localObject[j] == 'þ') {
            localObject[j] = 13;
          }
        }
      }
      localObject = afgc.a((char[])localObject);
      if ((localObject != null) && (localObject.length == 2))
      {
        k = localObject[0];
        j = localObject[1];
      }
      for (;;)
      {
        int n = -1;
        int m = n;
        if (this.gK != null)
        {
          m = n;
          if (this.gK.get() != null) {
            m = ((EmoticonMainPanel)this.gK.get()).cN(Integer.toString(k));
          }
        }
        String str = Integer.toString(m);
        if (this.mIsForward) {}
        for (localObject = "0X800588C";; localObject = "0X80057AF")
        {
          anot.a(this.mAppInterface, "CliOper", "", "", "ep_mall", (String)localObject, 0, 0, k + "", j + "", str, "");
          ajdg.fc("0", 5);
          if (QLog.isColorLevel()) {
            QLog.d("ReportWorker", 2, "report small emoticon send amount, epId:" + k + ",eId:" + j + ",tabOrder:" + str);
          }
          j = i + 4;
          break;
        }
        label592:
        k = aoff.ah.get(j, -1);
        j = i;
        if (k < 0) {
          break;
        }
        anot.a(this.mAppInterface, "CliOper", "", "", "ep_mall", "0X80057A4", 0, 0, k + "", "", "", "");
        ajdg.fc("0", 1);
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReportWorker", 2, "report system emoticon send amount, emoIdx:" + k);
        j = i;
        break;
        j = 0;
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ReportWorker
 * JD-Core Version:    0.7.0.1
 */