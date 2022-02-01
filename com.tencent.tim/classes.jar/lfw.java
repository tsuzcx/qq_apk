import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lfw
{
  public static boolean F(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("ReadInJoyChannelGuidingJumpUtils", 1, "context or scheme is null");
      return false;
    }
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], scheme = " + paramString);
    Object localObject = Uri.parse(paramString);
    String str1 = ((Uri)localObject).getQueryParameter("target");
    String str2 = ((Uri)localObject).getQueryParameter("channelid");
    String str3 = ((Uri)localObject).getQueryParameter("ispush");
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], target = " + str1 + ", channelID = " + str2 + ", isPush = " + str3 + ",doDynamicOrder = " + paramBoolean);
    int i = -1;
    try
    {
      int j = Integer.parseInt(str2);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], e = " + localNumberFormatException);
      }
      if (!paramBoolean) {
        break label301;
      }
      paramBoolean = awit.aMZ();
      if ((!paramBoolean) || (!dE(i))) {
        break label362;
      }
      if (dF(i)) {
        break label318;
      }
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] channelID = " + str2 + " not my channel");
      lbz.a().cG(i, 1);
      if (!l(str3, i)) {
        break label400;
      }
      kxm.a(paramContext, paramString, null);
      for (;;)
      {
        return true;
        QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] channelID = " + str2 + " is my channel");
        lbz.a().c(i, 1, false, true);
        break;
        QLog.d("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] isDynamicOrderSwitchOn = " + paramBoolean + ", channelID = " + str2);
        break;
        paramString = kgw.b(paramContext, 0, i);
        if (!(paramContext instanceof BaseActivity)) {
          paramString.setFlags(268435456);
        }
        paramContext.startActivity(paramString);
      }
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] failed, target = " + str1 + ", scheme = " + paramString);
    }
    localObject = ((Uri)localObject).getQueryParameter("v_url_base64");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReadInJoyViolaChannelFragment.at(i, (String)localObject);
    }
    if (("2".equals(str1)) && (!TextUtils.isEmpty(str2))) {
      if (lfy.G(paramContext, paramString))
      {
        QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], jump to recommend channel, using floating window.");
        return true;
      }
    }
    label301:
    label318:
    label362:
    return false;
  }
  
  private static boolean dE(int paramInt)
  {
    boolean bool2 = false;
    List localList = lbz.a().aC();
    boolean bool1 = bool2;
    int i;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      mgw localmgw;
      int j;
      if (i < localList.size())
      {
        localmgw = (mgw)localList.get(i);
        j = 0;
      }
      while (j < localmgw.iK.size())
      {
        if (paramInt == ((TabChannelCoverInfo)localmgw.iK.get(j)).mChannelCoverId)
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private static boolean dF(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = lbz.a().aC();
    boolean bool1 = bool2;
    int i;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((List)localObject).size() > 0)
      {
        localObject = (mgw)((List)localObject).get(0);
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < ((mgw)localObject).iK.size())
      {
        if (paramInt == ((TabChannelCoverInfo)((mgw)localObject).iK.get(i)).mChannelCoverId) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean dG(int paramInt)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject != null)
    {
      localObject = (lcd)((QQAppInterface)localObject).getManager(163);
      if ((localObject != null) && (((lcd)localObject).b() != null))
      {
        localObject = ((lcd)localObject).b().aD();
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = false, myChannelList is empty.");
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramInt == ((TabChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId)
          {
            QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = true, channelID = " + paramInt);
            return true;
          }
        }
      }
    }
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = false, channelID = " + paramInt);
    return false;
  }
  
  public static boolean l(String paramString, int paramInt)
  {
    boolean bool1 = TextUtils.equals(paramString, "1");
    boolean bool2 = awit.aMG();
    boolean bool3 = dG(paramInt);
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[shouldPushNewPage, isPushBoolean = " + bool1 + ", KDTab = " + bool2 + ", isInMyChannel = " + bool3 + ", channelID = " + paramInt);
    return (bool1) || (!bool2) || (!bool3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfw
 * JD-Core Version:    0.7.0.1
 */