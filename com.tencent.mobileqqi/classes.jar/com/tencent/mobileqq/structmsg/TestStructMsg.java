package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class TestStructMsg
{
  private static final String a = TestStructMsg.class.getSimpleName();
  
  public static AbsStructMsg a(int paramInt)
  {
    return a(1, true, paramInt);
  }
  
  public static AbsStructMsg a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mFlag = 3;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = paramInt1;
    localStructMsgForGeneralShare.mMsgBrief = " 的分享";
    localStructMsgForGeneralShare.mMsgAction = "web";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "http://gamecenter.qq.com/gcjump?appid=100692648&pf=invite&plat=qq";
    Object localObject;
    if (paramInt2 < 10)
    {
      localObject = StructMsgElementFactory.a(2, 3);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover("http://url.cn/NAxhL2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle("天天酷跑1"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      ((AbsStructMsgItem)localObject).c = "web";
      ((AbsStructMsgItem)localObject).b = "http://www.qq.com";
      localStructMsgForGeneralShare.addItem((AbsStructMsgElement)localObject);
      localObject = StructMsgElementFactory.a(2, 3);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover("http://url.cn/NAxhL2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle("天天酷跑2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      ((AbsStructMsgItem)localObject).c = "web";
      ((AbsStructMsgItem)localObject).b = "http://www.google.com";
      localStructMsgForGeneralShare.addItem((AbsStructMsgElement)localObject);
      localObject = StructMsgElementFactory.a(2, 3);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover("http://url.cn/NAxhL2"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle("天天酷跑3"));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      ((AbsStructMsgItem)localObject).c = "web";
      ((AbsStructMsgItem)localObject).b = "http://www.bing.com";
      localStructMsgForGeneralShare.addItem((AbsStructMsgElement)localObject);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localStructMsgForGeneralShare.mHasSource = paramBoolean;
        localStructMsgForGeneralShare.mSourceName = "天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑天天酷跑";
        localStructMsgForGeneralShare.mSource_A_ActionData = "com.tencent.pao";
        localStructMsgForGeneralShare.mSource_I_ActionData = "tencent100692648://";
        localStructMsgForGeneralShare.mSourceAction = "app";
        localStructMsgForGeneralShare.mSourceAppid = 100692648L;
        localStructMsgForGeneralShare.mSourceUrl = "http://web.p.qq.com/qqmpmobile/aio/app.html?id=100692648";
        localStructMsgForGeneralShare.mSourceIcon = "http://qzonestyle.gtimg.cn/ac/qzone/applogo/64/648/100692648_64.gif";
        localStructMsgForGeneralShare.uniseq = 0L;
      }
      return localStructMsgForGeneralShare;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new StructMsgItemCover("http://url.cn/NAxhL2"));
      ((ArrayList)localObject).add(new StructMsgItemTitle("天天酷跑"));
      ((ArrayList)localObject).add(new StructMsgItemTimer("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>", "游戏已开始", MessageCache.a(), paramInt2, 0));
      localStructMsgForGeneralShare.addItem(StructMsgElementFactory.a(2, (Collection)localObject));
    }
  }
  
  public static AbsStructMsg a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    StructMsgParserHandler localStructMsgParserHandler = new StructMsgParserHandler();
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    try
    {
      localSAXParserFactory.newSAXParser().parse(paramString, localStructMsgParserHandler);
      paramString.close();
      paramString = localStructMsgParserHandler.a();
      return paramString;
    }
    catch (ParserConfigurationException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
      }
      return null;
    }
    catch (SAXException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getStructMsgFromXmlBuffByStream", paramString);
        }
      }
    }
  }
  
  public static StructMsgForGeneralShare a(String paramString1, String paramString2)
  {
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mFlag = 3;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = " 的分享";
    localStructMsgForGeneralShare.mMsgAction = "web";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "http://www.baidu.com";
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2, 1);
    localAbsStructMsgItem.a(new StructMsgItemCover("http://url.cn/NAxhL2"));
    localAbsStructMsgItem.a(new StructMsgItemTitle(paramString1));
    localAbsStructMsgItem.a(new StructMsgItemSummary(paramString2));
    localAbsStructMsgItem.c = "web";
    localAbsStructMsgItem.b = "http://www.qq.com";
    localStructMsgForGeneralShare.addItem(localAbsStructMsgItem);
    return localStructMsgForGeneralShare;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    localArrayList.add(a("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进3333333入萌的小泡泡，不捏它捏谁，点击进3333333入萌的小泡泡，不捏它捏谁，点击进3333333入>>"));
    localArrayList.add(a("后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    localArrayList.add(a("后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    localArrayList.add(a("后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏后开始游戏", "又贱又萌的小泡泡，不捏它捏谁，点击进入>>"));
    return localArrayList;
  }
  
  public static void a(String paramString1, Context paramContext, String paramString2)
  {
    String str3 = null;
    Object localObject;
    if (paramString2.indexOf("?") > 0)
    {
      paramString2 = paramString2.split("\\?");
      if (paramString2.length != 2) {
        break label248;
      }
      localObject = paramString2[0];
      paramString2 = paramString2[1];
    }
    for (;;)
    {
      String str1 = paramString2;
      String str2;
      if (localObject == null)
      {
        paramString2 = (String)localObject;
        str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.d(a, 2, "pluginName is null");
          str2 = str3;
          paramString2 = (String)localObject;
        }
      }
      for (;;)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("account", paramString1);
        ((Intent)localObject).putExtra("load_from_third_app", true);
        ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
        ((Intent)localObject).putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
        str3 = PluginUtils.installPlugin(paramContext, paramString2, "25030");
        if (str3 != null) {
          break label217;
        }
        ((Intent)localObject).setClassName(paramContext, str2);
        paramString1 = new Bundle();
        if (str1 != null) {
          paramString1.putString("plugin_data", str1);
        }
        ((Intent)localObject).putExtras(paramString1);
        paramContext.startActivity((Intent)localObject);
        return;
        str1 = null;
        localObject = paramString2;
        break;
        String[] arrayOfString = ((String)localObject).split("/");
        paramString2 = (String)localObject;
        str2 = str3;
        if (arrayOfString.length == 2)
        {
          paramString2 = arrayOfString[0];
          str2 = arrayOfString[1];
        }
      }
      label217:
      localObject = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        localObject = paramString2.substring(0, paramString2.indexOf("."));
      }
      PluginStatisticsCollector.a(paramContext, paramString1, (String)localObject, str3);
      return;
      label248:
      paramString2 = null;
      localObject = null;
    }
  }
  
  public static AbsStructMsg b(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare = new StructMsgForGeneralShare();
    localStructMsgForGeneralShare.fwFlag = 0;
    localStructMsgForGeneralShare.mMsgTemplateID = 1;
    localStructMsgForGeneralShare.mMsgServiceID = 1;
    localStructMsgForGeneralShare.mMsgBrief = "上传3张照片到《专辑封面》";
    localStructMsgForGeneralShare.mMsgAction = "plugin";
    localStructMsgForGeneralShare.mMsgActionData = "";
    localStructMsgForGeneralShare.mMsg_A_ActionData = "";
    localStructMsgForGeneralShare.mMsg_I_ActionData = "";
    localStructMsgForGeneralShare.mMsgUrl = "";
    if (paramInt == 1)
    {
      localAbsStructMsgItem1 = StructMsgElementFactory.a(2);
      localAbsStructMsgItem1.a(new StructMsgItemCover("http://url.cn/NAxhL2"));
      localAbsStructMsgItem1.a(new StructMsgItemTitle("上传1张照片到《专辑封面》"));
      localAbsStructMsgItem1.a(new StructMsgItemSummary("游览西冲"));
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
      return localStructMsgForGeneralShare;
    }
    AbsStructMsgItem localAbsStructMsgItem1 = StructMsgElementFactory.a(3);
    if (paramInt == 2)
    {
      localAbsStructMsgItem1.a(new StructMsgItemCover("http://imgs.soufun.com/house/2013_06/17/sz/1371454628500_000.jpg"));
      localAbsStructMsgItem1.a(new StructMsgItemCover("http://imgs.soufun.com/house/2013_06/17/sz/1371453678695_000.jpg"));
    }
    for (;;)
    {
      AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
      localAbsStructMsgItem2.a(new StructMsgItemTitle("上传3张照片到《专辑封面》"));
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem1);
      localStructMsgForGeneralShare.addItem(localAbsStructMsgItem2);
      return localStructMsgForGeneralShare;
      localAbsStructMsgItem1.a(new StructMsgItemCover("http://imgs.soufun.com/house/2012_07/04/sz/1341380854786_000.jpg"));
      localAbsStructMsgItem1.a(new StructMsgItemCover("http://imgs.soufun.com/house/2013_06/17/sz/1371454628500_000.jpg"));
      localAbsStructMsgItem1.a(new StructMsgItemCover("http://imgs.soufun.com/house/2013_06/17/sz/1371453678695_000.jpg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.TestStructMsg
 * JD-Core Version:    0.7.0.1
 */