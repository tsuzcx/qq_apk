import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class acup
{
  private static volatile acup a;
  private ArrayList<acum> tW = new ArrayList();
  
  private acup()
  {
    b("mqqapi://qqidentifier/web", acuj.class);
    b("mqqapi://groupopenapp/openapp", acxj.class);
    b("mqqapi://commonBuddyGroup/commonBuddyGroup", acxh.class);
    b("mqqapi://manage_troop/main_page", acxf.class);
    b("mqqapi://nearby_entry/nearby_feed", actx.class);
    b("mqqapi://now/playmedia", acwx.class);
    b("mqqapi://wsgzh/waterfall", acxn.class);
    b("mqqapi://wsgzh/miniapp_player", acxp.class);
    b("mqqzone", acwm.class);
    b("mqqapi://qzoneschema", acwt.class);
    b("mqqapi://qzone/publicaccount", acwo.class);
    b("mqqapi://qboss/loader", acvq.class);
    b("qqfav://operation/", acve.class);
    b("mqq://shop/apollo_store", actp.class);
    b("mqqapi://shop/apollo_store", actp.class);
    b("mqqapi://cmshow/game_invite", acto.class);
    b("mqqapi://assistant_setting/ASSISTANT_SETTING", actj.class);
    b("mqqapi://qzone/to_publish_queue", acwq.class);
    b("mqqapi://qzone/to_friend_feeds", acwj.class);
    b("mqqapi://qzone/activefeed", acwj.class);
    b("mqqapi://qzone/open_homepage", acwl.class);
    b("mqqapi://ftssearch/tab", actv.class);
    b("mqqapi://ftssearch/openmixweb", actt.class);
    b("mqqapi://qzone/to_qzone_dialog", acwh.class);
    b("mqqapi://qzone/to_redpocket_share", acws.class);
    b("qapp://", acvo.class);
    b("mqqapi://qqreg", acvi.class);
    b("mqqapi://microapp/open?", acud.class);
    b("mqqapi://miniapp/open?", acuf.class);
    b("mqqapi://miniapp/adopen", acuf.class);
    b("mqqapi://buscard/open", acvy.class);
    b("mqqapi://wxminiapp/launch", acwc.class);
    b("mqqapi://qqnotify/subscribe", acvg.class);
    b("mqqapi://qqnotify/open", acwe.class);
    b("mqqapi://wallet/open", acwa.class);
    b("mqqmdpass://wallet/modify_pass", acvw.class);
    b("mqqapi://gamecenter/install", acxl.class);
    b("mqqapi://asyncmsg/showdetail?", actl.class);
    b("mqqapi://schedule/showDetail?", acwv.class);
    b("mqqapi://huayang", acuh.class);
    b("mqqapi://od", acuw.class);
    b("mqqapi://0odAddFriend", acuu.class);
    b("mqqapi://teamwork/opendoclist", acxd.class);
    b("mqqapi://qstory/opencontent", acvm.class);
    b("qqstory://qstory/opencontent", acvm.class);
    b("mqqapi://contact/add", actr.class);
    b("mqqapi://profile/setting", acuy.class);
    b("mqqapi://stickynote", acwz.class);
    b("mqqapi://groupvideo", actz.class);
    b("mqqapi://qwerewolf/enterHomePage", acva.class);
    b("mqqapi://lightapp/open", acus.class);
    b("mqqapi://qsubscribe", acxb.class);
    b("mqqapi://qcircle", acvc.class);
    b("mqqapi://troop_homework/publish", acub.class);
    b("https://qm.qq.com/cgi-bin/qm/qr", acvs.class);
  }
  
  public static acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (a == null) {}
      try
      {
        if (a == null) {
          a = new acup();
        }
        paramQQAppInterface = a.b(paramQQAppInterface, paramContext, paramString);
        return paramQQAppInterface;
      }
      finally {}
      return null;
    }
    catch (Exception paramQQAppInterface)
    {
      paramContext = new HashMap(1);
      paramContext.put("keyJumpParserUtilUrlErrorKey", paramString);
      paramContext.put("keyJumpParserUtilSceneErrorKey", "1");
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, paramContext, "", false);
      QLog.e("JumpParserUtil", 1, "parse error: " + paramQQAppInterface.getMessage());
    }
  }
  
  private static acuo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      paramString = null;
      return paramString;
    }
    acuo localacuo = new acuo("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    String[] arrayOfString1;
    if (i > 0)
    {
      localacuo.setScheme(paramString.substring(0, i));
      QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localacuo.getScheme());
      arrayOfString1 = paramString.split("\\?");
      if (arrayOfString1.length != 2) {
        break label278;
      }
      paramString = arrayOfString1[0].substring(i + 3);
    }
    for (;;)
    {
      String[] arrayOfString2 = paramString.split("/");
      if (arrayOfString2.length == 0)
      {
        localacuo.Gf(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localacuo.rW());
        paramString = localacuo;
        if (arrayOfString1.length != 2) {
          break;
        }
        arrayOfString1 = arrayOfString1[1].split("&");
        i = 0;
        label188:
        paramString = localacuo;
        if (i >= arrayOfString1.length) {
          break;
        }
        paramString = arrayOfString1[i].split("=");
        if (paramString.length != 2) {}
      }
      try
      {
        paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
        localacuo.fj(paramString[0], paramString[1]);
        i += 1;
        break label188;
        localacuo.setScheme(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localacuo.getScheme());
        return localacuo;
        label278:
        paramString = paramString.substring(i + 3);
        continue;
        localacuo.Gf(arrayOfString2[0]);
        localacuo.setAction(paramString.substring(paramString.indexOf("/") + 1));
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localacuo.rW() + " action is: " + localacuo.getAction());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("JumpParserUtil", 1, "failed to decode param value,keyValues[1] is:" + paramString[1] + ",keyValues[2] is:" + paramString[1], localException);
        }
      }
    }
  }
  
  private void b(String paramString, Class paramClass)
  {
    if (paramClass == null)
    {
      QLog.e("JumpParserUtil", 1, "registerParser error: class is null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "registerParser error: urlStartStr is empty");
      return;
    }
    this.tW.add(new acum(paramString, paramClass));
  }
  
  private String jD(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("JumpParserUtil", 1, "shouldPreDecodeUrl error: url is null");
    }
    while ((paramString.startsWith("mqqapi://qqidentifier/web")) || (paramString.startsWith("mqqapi://groupopenapp/openapp")) || (paramString.startsWith("mqqapi://commonBuddyGroup/commonBuddyGroup")) || (paramString.startsWith("mqqapi://manage_troop/main_page")) || (paramString.startsWith("mqqapi://nearby_entry/nearby_feed")) || (paramString.startsWith("mqqapi://now/playmedia")) || (paramString.startsWith("mqqapi://wsgzh/waterfall")) || (paramString.startsWith("mqqapi://wsgzh/miniapp_player")) || (paramString.startsWith("mqqzone")) || (paramString.startsWith("mqqapi://qzoneschema")) || (paramString.startsWith("mqqapi://qzone/publicaccount")) || (paramString.startsWith("mqqapi://qboss/loader")) || (paramString.startsWith("qqfav://operation/")) || (paramString.startsWith("mqq://shop/apollo_store")) || (paramString.startsWith("mqqapi://shop/apollo_store")) || (paramString.startsWith("mqqapi://cmshow/game_invite")) || (paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING")) || (!paramString.contains("videochat")) || (!paramString.contains("uinType=21"))) {
      return paramString;
    }
    QLog.d("JumpParserUtil", 1, "shouldPreDecodeUrl execute for containing videochat and uinType=21");
    return URLDecoder.decode(paramString);
  }
  
  public acuk b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QLog.d("JumpParserUtil", 1, "doParse url: " + paramString);
    if (paramString == null)
    {
      QLog.d("JumpParserUtil", 1, "doParse url is null, return");
      return null;
    }
    Object localObject = jD(paramString);
    paramString = (String)localObject;
    if (AudioHelper.isDev())
    {
      paramString = (String)localObject;
      if (AudioHelper.jY(8) == 1)
      {
        paramString = (String)localObject;
        if (((String)localObject).startsWith("mqqconferenceflyticket://")) {
          paramString = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";
        }
      }
    }
    localObject = a(paramString);
    acul localacul = acun.a((acuo)localObject, cI());
    if (localacul != null)
    {
      QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + paramString);
      return localacul.a(paramQQAppInterface, paramContext, paramString, (acuo)localObject);
    }
    QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + paramString);
    return null;
  }
  
  public ArrayList<acum> cI()
  {
    return this.tW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acup
 * JD-Core Version:    0.7.0.1
 */