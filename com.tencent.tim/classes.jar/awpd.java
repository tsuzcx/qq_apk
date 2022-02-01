import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.weiyun.WeiyunAIOUtils.4;
import cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1;
import cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class awpd
{
  private static boolean Z(ChatMessage paramChatMessage)
  {
    return (acfx.W(paramChatMessage)) || (acei.W(paramChatMessage));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
    awou.ah(localChatMessage.frienduin, localChatMessage.senderuin, localChatMessage.istroop);
    int i = 0;
    if (i < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if ((localChatMessage instanceof MessageForTroopFile)) {
        ((ArrayList)localObject2).add(localChatMessage);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localChatMessage instanceof MessageForFile)) {
          ((ArrayList)localObject1).add((MessageForFile)localChatMessage);
        } else if ((localChatMessage instanceof MessageForPic)) {
          localArrayList1.add((MessageForPic)localChatMessage);
        } else if ((localChatMessage instanceof MessageForShortVideo))
        {
          if (!(localChatMessage instanceof MessageForLightVideo)) {
            localArrayList2.add((MessageForShortVideo)localChatMessage);
          }
        }
        else if (acrb.E(localChatMessage)) {
          localArrayList3.add((StructMsgForImageShare)((MessageForStructing)localChatMessage).structingMsg);
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramList = (ChatMessage)((ArrayList)localObject2).get(0);
      if (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramList.frienduin)) == null) {
        return false;
      }
      paramList = apsv.a(paramQQAppInterface, (MessageForTroopFile)paramList);
      if ((paramList == null) || (paramList.FilePath == null)) {
        return false;
      }
      apsv.a(paramActivity, paramQQAppInterface, (List)localObject2);
    }
    boolean bool = false;
    if (((ArrayList)localObject1).size() > 0)
    {
      paramActivity = new ArrayList();
      paramList = ((ArrayList)localObject1).iterator();
      label320:
      int j;
      for (i = 0; paramList.hasNext(); i = j)
      {
        localObject1 = (MessageForFile)paramList.next();
        localObject2 = ahav.a(paramQQAppInterface, (MessageForFile)localObject1);
        if ((((FileManagerEntity)localObject2).cloudType == 0) || (((FileManagerEntity)localObject2).status == 16)) {
          break label320;
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (agzy.a((FileManagerEntity)localObject2).bd(false)) {
            j = 1;
          }
        }
        paramActivity.add(localObject1);
      }
      if (paramActivity.size() == 0)
      {
        ahao.OS(2131693822);
        return false;
      }
      if (i != 0) {
        ahal.a(BaseActivity.sTopActivity, 2131693826, 2131693832, new awpe(paramActivity, paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt));
      }
    }
    while (bool)
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131694101, 0).show(paramInt);
      return true;
      paramActivity = paramActivity.iterator();
      for (bool = false; paramActivity.hasNext(); bool = ahav.a(paramQQAppInterface, (MessageForFile)paramActivity.next(), BaseActivity.sTopActivity, true)) {}
      bool |= a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt);
      continue;
      bool = a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt);
    }
    QQToast.a(paramQQAppInterface.getApp(), 2131694153, 0).show(paramInt);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, MqqHandler paramMqqHandler)
  {
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
    if (!aqiw.isNetSupport(paramActivity))
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131693404, 0).show(paramInt);
      return false;
    }
    List localList = ajlc.a().fH();
    if (localList.size() == 0)
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131700602, 0).show(paramInt);
      return false;
    }
    if (localList.size() == 1) {
      return b(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
    }
    return a(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, ArrayList<MessageForPic> paramArrayList, ArrayList<MessageForShortVideo> paramArrayList1, ArrayList<StructMsgForImageShare> paramArrayList2, MqqHandler paramMqqHandler, int paramInt)
  {
    if (((paramArrayList != null) && (paramArrayList.size() > 0)) || ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) || ((paramArrayList2 != null) && (paramArrayList2.size() > 0)))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList2 = paramArrayList2.iterator();
        label58:
        if (paramArrayList2.hasNext())
        {
          Iterator localIterator = ((StructMsgForImageShare)paramArrayList2.next()).mStructMsgItemLists.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label58;
            }
            Object localObject1 = (anqu)localIterator.next();
            if (!anqv.class.isInstance(localObject1)) {
              break;
            }
            localObject1 = ((anqv)localObject1).rz.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (anqu)((Iterator)localObject1).next();
              if (ansu.class.isInstance(localObject2))
              {
                localObject2 = (ansu)localObject2;
                if ((!Z(((ansu)localObject2).j)) && (!ykm.d(((ansu)localObject2).j))) {
                  localArrayList.add(((ansu)localObject2).j);
                }
              }
            }
          }
        }
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramArrayList2 = (MessageForPic)paramArrayList.next();
          if ((!Z(paramArrayList2)) && (!ykm.d(paramArrayList2))) {
            localArrayList.add(paramArrayList2);
          }
        }
      }
      if ((localArrayList.size() == 0) && ((paramArrayList1 == null) || (paramArrayList1.size() == 0))) {
        return false;
      }
      paramQQAppInterface.a().a().a(localArrayList, paramArrayList1, new awpd.a(paramMqqHandler, paramQQAppInterface.getApp(), paramQQAppInterface, paramInt));
      return true;
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    paramList = (ChatMessage)paramList.get(0);
    awou.ah(paramList.frienduin, paramList.senderuin, paramList.istroop);
    if ((paramList instanceof MessageForTroopFile)) {
      apsv.d(paramActivity, paramQQAppInterface, paramList);
    }
    for (;;)
    {
      return true;
      if ((paramList instanceof MessageForFile))
      {
        paramActivity = ahav.a(paramQQAppInterface, (MessageForFile)paramList);
        if (paramActivity.cloudType == 0)
        {
          ahao.OS(2131693822);
          return false;
        }
        if (paramActivity.status == 16)
        {
          ahao.OS(2131694128);
          return false;
        }
        if (agzy.a((MessageForFile)paramList).bd(false))
        {
          if (armm.a(BaseActivity.sTopActivity, 5, new awpf(paramQQAppInterface, paramList))) {
            ahal.a(BaseActivity.sTopActivity, 2131693826, 2131693830, new awpg(paramQQAppInterface, paramList));
          }
        }
        else {
          ahav.a(paramQQAppInterface, paramList, BaseActivity.sTopActivity);
        }
      }
      else if (((paramList instanceof MessageForPic)) || ((paramList instanceof MessageForShortVideo)))
      {
        if (Z(paramList))
        {
          ahao.OS(2131693822);
          return false;
        }
        if (((paramList instanceof MessageForPic)) && (ykm.d((MessageForPic)paramList)))
        {
          ahao.OS(2131693822);
          return false;
        }
        paramQQAppInterface.a().a().a(paramList, new awpd.a(paramMqqHandler, paramActivity, paramQQAppInterface, paramInt));
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ThreadManager.getUIHandler().post(new WeiyunAIOUtils.4(paramQQAppInterface, paramInt));
        } else {
          QQToast.a(paramQQAppInterface.getApp(), 2131694101, 0).show(paramInt);
        }
      }
      else
      {
        if (!acrb.E(paramList)) {
          break;
        }
        paramList = (StructMsgForImageShare)((MessageForStructing)paramList).structingMsg;
        paramActivity = new ArrayList();
        paramList = paramList.mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (anqu)paramList.next();
          if (anqv.class.isInstance(localObject1))
          {
            localObject1 = ((anqv)localObject1).rz.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (anqu)((Iterator)localObject1).next();
              if (ansu.class.isInstance(localObject2))
              {
                localObject2 = (ansu)localObject2;
                if (!Z(((ansu)localObject2).j)) {
                  paramActivity.add(((ansu)localObject2).j);
                }
              }
            }
          }
        }
        if (paramActivity.size() > 0)
        {
          a(paramQQAppInterface, paramActivity, null, null, paramMqqHandler, paramInt);
          QQToast.a(paramQQAppInterface.getApp(), 2131694101, 0).show(paramInt);
        }
        else
        {
          QQToast.a(paramQQAppInterface.getApp(), 2131694153, 0).show(paramInt);
        }
      }
    }
    QQToast.a(paramQQAppInterface.getApp(), 2131694153, 0).show(paramInt);
    return false;
  }
  
  public static void cL(Activity paramActivity)
  {
    String str = String.format("https://jump.weiyun.com?from=3092&aid=%s", new Object[] { "qq_an_wyshouxian" });
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramActivity.startActivityForResult(localIntent, 21);
  }
  
  public static class a
    implements agmf.a
  {
    private QQAppInterface mApp;
    private Context mContext;
    private int mTitleHeight;
    public MqqHandler q;
    
    public a(MqqHandler paramMqqHandler, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
    {
      this.q = paramMqqHandler;
      this.mTitleHeight = paramInt;
      this.mContext = paramContext;
      this.mApp = paramQQAppInterface;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.q != null)
      {
        this.q.sendMessageDelayed(this.q.obtainMessage(101, paramInt, 0, paramString), 1500L);
        return;
      }
      ThreadManager.getUIHandler().post(new WeiyunAIOUtils.WeiyunCallbackImpl.2(this, paramString));
    }
    
    public void onSuccess(Object paramObject)
    {
      if (this.q != null)
      {
        this.q.sendEmptyMessageDelayed(100, 1500L);
        return;
      }
      ThreadManager.getUIHandler().post(new WeiyunAIOUtils.WeiyunCallbackImpl.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpd
 * JD-Core Version:    0.7.0.1
 */