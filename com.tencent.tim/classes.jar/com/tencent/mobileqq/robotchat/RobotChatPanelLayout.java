package com.tencent.mobileqq.robotchat;

import amio;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import aprg;
import aptw;
import aqmj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.a;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.c;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;
import ydw;

public class RobotChatPanelLayout
  extends RobotPanelLayoutBase
{
  public RobotChatPanelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RobotChatPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RobotChatPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void PE(String paramString)
  {
    if (this.b == null) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          paramString = this.b.i("1", paramString);
          if (paramString == null) {
            break label99;
          }
          try
          {
            cmd0x934.RspBody localRspBody = new cmd0x934.RspBody();
            localRspBody.mergeFrom(paramString);
            paramString = a(localRspBody);
            if ((paramString == null) || (paramString.size() <= 0)) {
              break;
            }
            yW(false);
            Y(paramString, true);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramString) {}
        } while (!QLog.isColorLevel());
        QLog.d("RobotChatPanelLayout", 2, paramString.getMessage());
        return;
      } while (!QLog.isColorLevel());
      QLog.d("RobotChatPanelLayout", 2, "listDatas is null");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "data is null");
  }
  
  private String a(String paramString1, String paramString2, RobotPanelLayoutBase.c paramc, aptw paramaptw)
  {
    String str = "";
    int i;
    if (paramc.cPY)
    {
      paramc.cPY = false;
      paramaptw.ebO();
      i = paramc.b.url.indexOf("content=");
      paramString2 = str;
      if (i > 0) {
        paramString2 = paramc.b.url.substring(i + 8);
      }
      str = paramc.b.title;
      paramaptw = paramString2;
      paramString2 = str;
    }
    for (;;)
    {
      b("1", paramString1, paramaptw, paramc);
      return paramString2;
      str = paramc.a.title;
      paramc.cPY = true;
      paramaptw.ie(paramString1, paramString2);
      i = paramc.a.url.indexOf("content=");
      if (i > 0)
      {
        paramaptw = paramc.a.url.substring(i + 8);
        paramString2 = str;
      }
      else
      {
        paramaptw = "";
        paramString2 = str;
      }
    }
  }
  
  public String a(RobotPanelLayoutBase.c paramc)
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      paramc = null;
    }
    String str;
    do
    {
      return paramc;
      str = a(this.cro, this.crF, paramc, this.b);
      paramc = str;
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "talking: " + str);
    return str;
  }
  
  public void a(RobotPanelLayoutBase.c paramc)
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    do
    {
      return;
      a(getContext(), paramc.a.title, this.cro, this.crF, false, this.c);
    } while (!QLog.isColorLevel());
    QLog.d("RobotChatPanelLayout", 2, "send to robot: " + paramc.a.title);
  }
  
  public void a(RobotPanelLayoutBase.c paramc, String paramString)
  {
    aprg.d(this.c.app, "0X800A48C", this.cro, paramString);
  }
  
  public void a(String paramString1, String paramString2, ydw paramydw, RobotPanelLayoutBase.a parama)
  {
    super.a(paramString1, paramString2, paramydw, parama);
    this.cro = paramString1;
    this.crF = paramString2;
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramString1);
        if (l == 0L) {
          continue;
        }
        if ((!TextUtils.isEmpty(this.cro)) && (!this.cro.equals(paramString1))) {
          yW(false);
        }
        int i = aqmj.aX(getContext(), "1_" + paramString1);
        this.b.a(l, i, new amio(this, l, i, paramString1, parama));
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
  
  public void b(RobotPanelLayoutBase.c paramc)
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RobotChatPanelLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    int i = paramc.a.url.indexOf("content=");
    if (i > 0) {}
    for (String str = paramc.a.url.substring(i + 8);; str = null)
    {
      a(getContext(), paramc.a.title, this.cro, this.crF, true, this.c);
      a("1", this.cro, str, paramc);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RobotChatPanelLayout", 2, "send to server: " + paramc.a.title);
      return;
    }
  }
  
  public void cbt()
  {
    super.cbt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatPanelLayout
 * JD-Core Version:    0.7.0.1
 */