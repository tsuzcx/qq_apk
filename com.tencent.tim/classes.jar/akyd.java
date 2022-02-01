import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class akyd
{
  public static String SP_NAME = "struct_msg_pic_pre";
  public static boolean cvp;
  public static boolean mIsOpen = true;
  public static int mStructMsgPicSwitch;
  
  public static int Hl()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return BaseApplicationImpl.getApplication().getSharedPreferences(localQQAppInterface.getCurrentAccountUin() + "_" + SP_NAME, 0).getInt("mStructMsgPicSwitch", 0);
    }
    return 0;
  }
  
  public static void Sv(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      mStructMsgPicSwitch = paramInt;
      cvp = true;
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences(((QQAppInterface)localObject).getCurrentAccountUin() + "_" + SP_NAME, 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("mStructMsgPicSwitch", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void a(anqu paramanqu, List<String> paramList)
  {
    if ((paramanqu != null) && ((paramanqu instanceof anqv)))
    {
      paramanqu = ((anqv)paramanqu).rz;
      if ((paramanqu != null) && (paramanqu.size() > 0)) {
        paramanqu = paramanqu.iterator();
      }
    }
    else
    {
      while (paramanqu.hasNext())
      {
        a((anqu)paramanqu.next(), paramList);
        continue;
        if ((paramanqu != null) && ((paramanqu instanceof ansr)))
        {
          paramanqu = ((ansr)paramanqu).aNt;
          if ((TextUtils.isEmpty(paramanqu)) || (!paramanqu.startsWith("http"))) {
            break;
          }
        }
      }
    }
    try
    {
      if (nS(new URL(paramanqu).getHost())) {
        paramList.add(paramanqu);
      }
      return;
    }
    catch (MalformedURLException paramanqu)
    {
      paramanqu.printStackTrace();
    }
  }
  
  public static void a(String paramString, aoli paramaoli)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http"))) {
      aolf.a(paramString, paramaoli, null, 1);
    }
  }
  
  public static void b(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    int i = akxo.Hi();
    if (!cvp)
    {
      mStructMsgPicSwitch = Hl();
      cvp = true;
    }
    if ((i != 0) && (mStructMsgPicSwitch == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgPicPreDelegate", 2, "not wifi not pre download");
      }
    }
    for (;;)
    {
      return;
      if (paramMessageForStructing != null)
      {
        paramQQAppInterface = paramMessageForStructing.structingMsg;
        ArrayList localArrayList = new ArrayList();
        if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof AbsShareMsg)))
        {
          localObject = ((AbsShareMsg)paramQQAppInterface).getStructMsgItemLists();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              a((anqu)((Iterator)localObject).next(), localArrayList);
            }
          }
        }
        if (localArrayList.size() <= 0) {
          break;
        }
        Object localObject = new aoli();
        ((aoli)localObject).dPw = paramQQAppInterface.mMsgServiceID;
        ((aoli)localObject).dPx = paramQQAppInterface.mMsgTemplateID;
        ((aoli)localObject).clN = String.valueOf(paramMessageForStructing.istroop);
        ((aoli)localObject).isPreDownload = true;
        paramMessageForStructing = localArrayList.iterator();
        while (paramMessageForStructing.hasNext()) {
          a((String)paramMessageForStructing.next(), (aoli)localObject);
        }
      }
    }
  }
  
  public static boolean nS(String paramString)
  {
    boolean bool = Pattern.compile("((\\.|^)(qq\\.com|soso\\.com|gtimg\\.cn|url\\.cn|qpic\\.cn|qlogo\\.cn|idqqimg\\.com)$)").matcher(paramString).find();
    if (QLog.isDevelopLevel()) {
      QLog.d("StructMsgPicPreDelegate", 4, " host = " + paramString + " ,isTencentDomain = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyd
 * JD-Core Version:    0.7.0.1
 */