import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oal
{
  public int aOr;
  protected WeakReference<QQAppInterface> cD;
  public WeakReference<MessageRecord> cE;
  public List<oam> mItems = new ArrayList();
  public int mType = -1;
  public String mUin = "";
  public long yu;
  
  public oal(QQAppInterface paramQQAppInterface)
  {
    this.cD = new WeakReference(paramQQAppInterface);
  }
  
  public static oal a(QQAppInterface paramQQAppInterface, Context paramContext, TroopBarData paramTroopBarData)
  {
    Object localObject3 = paramTroopBarData.mLatestMessage;
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = paramQQAppInterface.b().a(paramTroopBarData.mUin, 1008);
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if ((localObject2 instanceof MessageRecord)) {
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return null;
      }
    }
    Object localObject1 = new oal(paramQQAppInterface);
    localObject3 = paramQQAppInterface.a();
    if (localObject3 != null) {}
    for (int i = ((tog)localObject3).A(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);; i = 0)
    {
      long l;
      if (paramTroopBarData.mLastMsgTime > paramTroopBarData.mLastDraftTime)
      {
        l = paramTroopBarData.mLastMsgTime;
        ((oal)localObject1).yu = l;
        ((oal)localObject1).mUin = ((MessageRecord)localObject2).frienduin;
        ((oal)localObject1).aOr = i;
        try
        {
          if ((localObject2 instanceof MessageForPubAccount))
          {
            ((MessageForPubAccount)localObject2).parse();
            ((oal)localObject1).mType = 1;
            paramQQAppInterface = ((MessageForPubAccount)localObject2).mPAMessage;
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface = paramQQAppInterface.items.iterator();
              while (paramQQAppInterface.hasNext())
              {
                paramContext = (PAMessage.Item)paramQQAppInterface.next();
                paramTroopBarData = new oam();
                paramTroopBarData.type = 1;
                paramTroopBarData.coverUrl = paramContext.cover;
                paramTroopBarData.aoI = paramContext.url;
                paramTroopBarData.actionData = paramContext.actionData;
                paramTroopBarData.title = paramContext.title;
                ((oal)localObject1).mItems.add(paramTroopBarData);
              }
            }
            ((oal)localObject1).cE = new WeakReference(localObject2);
          }
        }
        catch (Exception paramQQAppInterface)
        {
          ((oal)localObject1).mType = 0;
          paramContext = new oam();
          paramContext.type = 0;
          paramContext.aoP = ((MessageRecord)localObject2).msg;
          ((oal)localObject1).mItems.clear();
          ((oal)localObject1).mItems.add(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed exception: ", paramQQAppInterface);
          }
        }
      }
      for (;;)
      {
        return localObject1;
        l = paramTroopBarData.mLastDraftTime;
        break;
        if ((localObject2 instanceof MessageForStructing))
        {
          ((MessageForStructing)localObject2).parse();
          ((oal)localObject1).mType = 1;
          paramContext = ((MessageForStructing)localObject2).structingMsg;
          if ((paramContext != null) && ((paramContext instanceof AbsShareMsg)))
          {
            paramQQAppInterface = ((AbsShareMsg)paramContext).getStructMsgItemLists();
            if ((QLog.isColorLevel()) && ((paramQQAppInterface == null) || (paramQQAppInterface.isEmpty()))) {
              QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed MessageForStructing itemlist size = 0");
            }
            paramTroopBarData = paramQQAppInterface.iterator();
            label800:
            label809:
            label816:
            for (;;)
            {
              label443:
              oam localoam;
              if (paramTroopBarData.hasNext())
              {
                localObject3 = (anqu)paramTroopBarData.next();
                localoam = new oam();
                localoam.type = 1;
                localoam.aoP = ((anqu)localObject3).chb;
                localoam.tagName = paramContext.mTagName;
                if (!(localObject3 instanceof anqv)) {
                  break label809;
                }
                paramQQAppInterface = ((anqv)localObject3).rz.iterator();
                for (;;)
                {
                  if (!paramQQAppInterface.hasNext()) {
                    break label726;
                  }
                  Object localObject4 = (anqu)paramQQAppInterface.next();
                  if ((localObject4 instanceof ansr))
                  {
                    localoam.coverUrl = ((ansr)localObject4).aNt;
                  }
                  else if ((localObject4 instanceof StructMsgItemTitle))
                  {
                    localoam.title = ((StructMsgItemTitle)localObject4).getText();
                  }
                  else if ((localObject4 instanceof anvf))
                  {
                    localoam.coverUrl = ((anvf)localObject4).imgUrl;
                  }
                  else if ((localObject4 instanceof anun))
                  {
                    localoam.coverUrl = ((anun)localObject4).mCoverUrl;
                  }
                  else if ((localObject4 instanceof anur))
                  {
                    localoam.coverUrl = ((anur)localObject4).imgUrl;
                  }
                  else if ((localObject4 instanceof anru))
                  {
                    localObject4 = ((anru)localObject4).uh.iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      anqu localanqu = (anqu)((Iterator)localObject4).next();
                      if (!(localanqu instanceof StructMsgItemTitle)) {
                        break;
                      }
                      localoam.title = ((StructMsgItemTitle)localanqu).getText();
                    }
                  }
                }
                label726:
                if (!TextUtils.isEmpty(((anqu)localObject3).ku)) {
                  break label800;
                }
                paramQQAppInterface = paramContext.mMsgUrl;
                label742:
                localoam.aoI = paramQQAppInterface;
              }
              for (;;)
              {
                if ((((anqv)localObject3).rz.size() == 1) && (((anqu)((anqv)localObject3).rz.get(0) instanceof anst))) {
                  break label816;
                }
                ((oal)localObject1).mItems.add(localoam);
                break label443;
                break;
                paramQQAppInterface = ((anqu)localObject3).ku;
                break label742;
                localoam.type = 0;
              }
            }
          }
        }
        else
        {
          if (!(localObject2 instanceof MessageForPic)) {
            break label911;
          }
          ((MessageForPic)localObject2).parse();
          ((oal)localObject1).mType = 3;
          paramTroopBarData = new oam();
          paramTroopBarData.type = 2;
          paramTroopBarData.aoP = paramQQAppInterface.b().b(paramContext, (MessageRecord)localObject2, false);
          paramTroopBarData.picPath = ((MessageForPic)localObject2).path;
          paramTroopBarData.i = aoop.a((MessageForPic)localObject2, 65537, null);
          ((oal)localObject1).mItems.add(paramTroopBarData);
        }
      }
      label911:
      if ((localObject2 instanceof MessageForText))
      {
        ((oal)localObject1).mType = 0;
        ((MessageForText)localObject2).parse();
      }
      for (;;)
      {
        paramTroopBarData = new oam();
        paramTroopBarData.type = 0;
        paramTroopBarData.aoP = paramQQAppInterface.b().b(paramContext, (MessageRecord)localObject2, false);
        ((oal)localObject1).mItems.add(paramTroopBarData);
        break;
        if ((localObject2 instanceof MessageForVideo))
        {
          ((oal)localObject1).mType = 2;
          ((MessageForVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForShortVideo))
        {
          ((oal)localObject1).mType = 2;
          ((MessageForShortVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForPtt))
        {
          ((oal)localObject1).mType = 4;
        }
      }
    }
  }
  
  public void bcT()
  {
    if ((this.cD == null) || (this.cD.get() == null)) {}
    QQMessageFacade.Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return;
        localMessage = null;
        int i = ocp.e((QQAppInterface)this.cD.get(), this.mUin);
        localObject = ((QQAppInterface)this.cD.get()).b();
        if (localObject != null) {
          localMessage = ((QQMessageFacade)localObject).a(this.mUin, i);
        }
      } while (localMessage == null);
      this.aOr = 0;
      oan.a().l((QQAppInterface)this.cD.get(), localMessage.frienduin);
      localObject = ((QQAppInterface)this.cD.get()).a();
    } while (localObject == null);
    ((tog)localObject).h(localMessage.frienduin, localMessage.istroop, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (oal)paramObject;
      if (this.mUin != null) {
        return this.mUin.equals(paramObject.mUin);
      }
    } while (paramObject.mUin == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.mUin != null) {
      return this.mUin.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oal
 * JD-Core Version:    0.7.0.1
 */