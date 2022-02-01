package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import appb;
import aprg;
import aptw;
import apvj;
import apvk;
import apvl;
import apvm;
import aqmj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import xwn;

public class TroopAIORobotLayout
  extends RobotPanelLayoutBase
{
  public String cov;
  
  public TroopAIORobotLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopAIORobotLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopAIORobotLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.c paramc, aptw paramaptw)
  {
    int i;
    if (paramc.cPY)
    {
      paramc.cPY = false;
      paramaptw.ebO();
      i = paramc.b.url.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = paramc.b.url.substring(i + 8);; paramString3 = "")
    {
      String str = paramc.b.title;
      aptw.report("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        paramaptw.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new apvl(this, paramc));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = paramc.a.title;
      paramc.cPY = true;
      paramaptw.be(paramString1, paramString2, paramString3);
      i = paramc.a.url.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = paramc.a.url.substring(i + 8);; paramString3 = "")
      {
        aptw.report("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, aptw paramaptw, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = getItemCount();
      if (j <= 0) {
        return;
      }
      int i = 0;
      RobotPanelLayoutBase.c localc;
      if (i < j)
      {
        localc = (RobotPanelLayoutBase.c)i(i);
        if ((localc != null) && (!TextUtils.isEmpty(localc.b.title)))
        {
          localc.cPY = paramBoolean;
          if (!paramBoolean)
          {
            i = localc.b.url.indexOf("content=");
            if (i > 0) {
              str = localc.b.url.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          paramaptw.be(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            paramaptw.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new apvm(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localc.a.url.indexOf("content=");
          if (i > 0) {
            str = localc.a.url.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          paramaptw.ebO();
        }
      }
    }
  }
  
  private void a(xwn paramxwn, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramxwn == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = appb.a(paramxwn.app, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramxwn.a.setText(localSpannableString);
    }
    for (;;)
    {
      paramxwn.a.append(" ");
      paramxwn.a.setSelection(paramxwn.a.getText().length());
      paramxwn.b(paramString1, paramString2, true, 0);
      return;
      label93:
      paramxwn.a.append(localSpannableString);
    }
  }
  
  private boolean aBC()
  {
    if ((this.c == null) || (this.c.a == null)) {}
    String str;
    do
    {
      return true;
      str = this.c.a.getEditableText().toString();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str.replaceFirst("@" + this.crF, "").trim())));
    return false;
  }
  
  public String a(RobotPanelLayoutBase.c paramc)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      paramc = null;
    }
    do
    {
      return paramc;
      localObject = a(this.cov, this.cro, this.crF, paramc, (aptw)localObject);
      paramc = (RobotPanelLayoutBase.c)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a(RobotPanelLayoutBase.c paramc)
  {
    aptw localaptw = a();
    if (localaptw == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (aBC())
      {
        this.c.a.append(paramc.a.title);
        ((xwn)this.c).aCV = true;
        this.c.send();
        ((xwn)this.c).aCV = false;
        if (!localaptw.aBy()) {
          a((xwn)this.c, this.cro, this.crF, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + paramc.a.title);
        return;
        a(getContext(), paramc.a.title, this.cro, this.crF, false, this.c);
      }
    }
  }
  
  public void a(RobotPanelLayoutBase.c paramc, String paramString)
  {
    aprg.d(this.c.app, "0X8009FA2", this.cro, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, xwn paramxwn, RobotPanelLayoutBase.a parama)
  {
    super.a(paramString2, paramString3, paramxwn, parama);
    paramxwn = a();
    if (paramxwn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString1);
      l1 = l2;
      l3 = Long.parseLong(paramString2);
      l1 = l3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        long l3 = 0L;
        long l2 = l1;
        l1 = l3;
      }
    }
    if ((!TextUtils.isEmpty(this.cro)) && (!this.cro.equals(paramString2))) {
      yW(false);
    }
    i = aqmj.aX(getContext(), paramString1 + "_" + paramString2);
    paramxwn.a(l2, l1, i, new apvj(this, i, paramString2, paramString1, paramString3, parama));
  }
  
  public void b(RobotPanelLayoutBase.c paramc)
  {
    aptw localaptw = a();
    if (localaptw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = Long.parseLong(this.cov);
        long l2 = Long.parseLong(this.cro);
        String str = null;
        int i = paramc.a.url.indexOf("content=");
        if (i > 0) {
          str = paramc.a.url.substring(i + 8);
        }
        if (!aBC()) {
          continue;
        }
        this.c.a.append(paramc.a.title);
        ((xwn)this.c).aCV = true;
        this.c.aSL = true;
        this.c.send();
        ((xwn)this.c).aCV = false;
        if (!localaptw.aBy()) {
          a((xwn)this.c, this.cro, this.crF, false);
        }
        localaptw.a(l1, l2, str, new apvk(this, paramc));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + paramc.a.title);
      return;
      a(getContext(), paramc.a.title, this.cro, this.crF, true, this.c);
    }
  }
  
  public void b(RobotPanelLayoutBase.c paramc, String paramString)
  {
    aptw.report("panel", "clk", this.cov, this.cro, paramString, "");
  }
  
  public void cbt()
  {
    super.cbt();
  }
  
  public void d(RobotPanelLayoutBase.c paramc, String paramString)
  {
    aptw.report("panel", "clk", this.cov, this.cro, paramString, "");
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.cov = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout
 * JD-Core Version:    0.7.0.1
 */