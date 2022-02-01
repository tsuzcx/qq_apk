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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uqv
{
  public int a;
  public long a;
  public String a;
  protected WeakReference<QQAppInterface> a;
  public List<uqw> a;
  public int b;
  public WeakReference<MessageRecord> b;
  
  public uqv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static uqv a(QQAppInterface paramQQAppInterface, Context paramContext, TroopBarData paramTroopBarData)
  {
    Object localObject3 = paramTroopBarData.mLatestMessage;
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = paramQQAppInterface.getMessageFacade().getLastMessage(paramTroopBarData.mUin, 1008);
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
    Object localObject1 = new uqv(paramQQAppInterface);
    localObject3 = paramQQAppInterface.getConversationFacade();
    if (localObject3 != null) {}
    for (int i = ((acmw)localObject3).a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);; i = 0)
    {
      long l;
      if (paramTroopBarData.mLastMsgTime > paramTroopBarData.mLastDraftTime)
      {
        l = paramTroopBarData.mLastMsgTime;
        ((uqv)localObject1).jdField_a_of_type_Long = l;
        ((uqv)localObject1).jdField_a_of_type_JavaLangString = ((MessageRecord)localObject2).frienduin;
        ((uqv)localObject1).jdField_b_of_type_Int = i;
        try
        {
          if ((localObject2 instanceof MessageForPubAccount))
          {
            ((MessageForPubAccount)localObject2).parse();
            ((uqv)localObject1).jdField_a_of_type_Int = 1;
            paramQQAppInterface = ((MessageForPubAccount)localObject2).mPAMessage;
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface = paramQQAppInterface.items.iterator();
              while (paramQQAppInterface.hasNext())
              {
                paramContext = (PAMessage.Item)paramQQAppInterface.next();
                paramTroopBarData = new uqw();
                paramTroopBarData.jdField_a_of_type_Int = 1;
                paramTroopBarData.jdField_a_of_type_JavaLangString = paramContext.cover;
                paramTroopBarData.d = paramContext.url;
                paramTroopBarData.e = paramContext.actionData;
                paramTroopBarData.b = paramContext.title;
                ((uqv)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
              }
            }
            ((uqv)localObject1).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
          }
        }
        catch (Exception paramQQAppInterface)
        {
          ((uqv)localObject1).jdField_a_of_type_Int = 0;
          paramContext = new uqw();
          paramContext.jdField_a_of_type_Int = 0;
          paramContext.c = ((MessageRecord)localObject2).msg;
          ((uqv)localObject1).jdField_a_of_type_JavaUtilList.clear();
          ((uqv)localObject1).jdField_a_of_type_JavaUtilList.add(paramContext);
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
          ((uqv)localObject1).jdField_a_of_type_Int = 1;
          paramContext = ((MessageForStructing)localObject2).structingMsg;
          if ((paramContext != null) && ((paramContext instanceof AbsShareMsg)))
          {
            paramQQAppInterface = ((AbsShareMsg)paramContext).getStructMsgItemLists();
            if ((QLog.isColorLevel()) && ((paramQQAppInterface == null) || (paramQQAppInterface.isEmpty()))) {
              QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed MessageForStructing itemlist size = 0");
            }
            if (paramQQAppInterface != null)
            {
              paramTroopBarData = paramQQAppInterface.iterator();
              label804:
              label813:
              label820:
              for (;;)
              {
                label447:
                uqw localuqw;
                if (paramTroopBarData.hasNext())
                {
                  localObject3 = (bdnu)paramTroopBarData.next();
                  localuqw = new uqw();
                  localuqw.jdField_a_of_type_Int = 1;
                  localuqw.c = ((bdnu)localObject3).g;
                  localuqw.g = paramContext.mTagName;
                  if (!(localObject3 instanceof bdnv)) {
                    break label813;
                  }
                  paramQQAppInterface = ((bdnv)localObject3).a.iterator();
                  for (;;)
                  {
                    if (!paramQQAppInterface.hasNext()) {
                      break label730;
                    }
                    Object localObject4 = (bdnu)paramQQAppInterface.next();
                    if ((localObject4 instanceof bdpx))
                    {
                      localuqw.jdField_a_of_type_JavaLangString = ((bdpx)localObject4).ac;
                    }
                    else if ((localObject4 instanceof StructMsgItemTitle))
                    {
                      localuqw.b = ((StructMsgItemTitle)localObject4).b();
                    }
                    else if ((localObject4 instanceof bdte))
                    {
                      localuqw.jdField_a_of_type_JavaLangString = ((bdte)localObject4).ac;
                    }
                    else if ((localObject4 instanceof bdsk))
                    {
                      localuqw.jdField_a_of_type_JavaLangString = ((bdsk)localObject4).ac;
                    }
                    else if ((localObject4 instanceof bdsp))
                    {
                      localuqw.jdField_a_of_type_JavaLangString = ((bdsp)localObject4).ac;
                    }
                    else if ((localObject4 instanceof bdox))
                    {
                      localObject4 = ((bdox)localObject4).jdField_a_of_type_JavaUtilList.iterator();
                      if (((Iterator)localObject4).hasNext())
                      {
                        bdnu localbdnu = (bdnu)((Iterator)localObject4).next();
                        if (!(localbdnu instanceof StructMsgItemTitle)) {
                          break;
                        }
                        localuqw.b = ((StructMsgItemTitle)localbdnu).b();
                      }
                    }
                  }
                  label730:
                  if (!TextUtils.isEmpty(((bdnu)localObject3).b)) {
                    break label804;
                  }
                  paramQQAppInterface = paramContext.mMsgUrl;
                  label746:
                  localuqw.d = paramQQAppInterface;
                }
                for (;;)
                {
                  if ((((bdnv)localObject3).a.size() == 1) && (((bdnu)((bdnv)localObject3).a.get(0) instanceof bdpz))) {
                    break label820;
                  }
                  ((uqv)localObject1).jdField_a_of_type_JavaUtilList.add(localuqw);
                  break label447;
                  break;
                  paramQQAppInterface = ((bdnu)localObject3).b;
                  break label746;
                  localuqw.jdField_a_of_type_Int = 0;
                }
              }
            }
          }
        }
        else
        {
          if (!(localObject2 instanceof MessageForPic)) {
            break label915;
          }
          ((MessageForPic)localObject2).parse();
          ((uqv)localObject1).jdField_a_of_type_Int = 3;
          paramTroopBarData = new uqw();
          paramTroopBarData.jdField_a_of_type_Int = 2;
          paramTroopBarData.c = paramQQAppInterface.getMessageFacade().getMsgSummary(paramContext, (MessageRecord)localObject2, false);
          paramTroopBarData.f = ((MessageForPic)localObject2).path;
          paramTroopBarData.jdField_a_of_type_JavaNetURL = URLDrawableHelper.getURL((MessageForPic)localObject2, 65537, null);
          ((uqv)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
        }
      }
      label915:
      if ((localObject2 instanceof MessageForText))
      {
        ((uqv)localObject1).jdField_a_of_type_Int = 0;
        ((MessageForText)localObject2).parse();
      }
      for (;;)
      {
        paramTroopBarData = new uqw();
        paramTroopBarData.jdField_a_of_type_Int = 0;
        paramTroopBarData.c = paramQQAppInterface.getMessageFacade().getMsgSummary(paramContext, (MessageRecord)localObject2, false);
        ((uqv)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
        break;
        if ((localObject2 instanceof MessageForVideo))
        {
          ((uqv)localObject1).jdField_a_of_type_Int = 2;
          ((MessageForVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForShortVideo))
        {
          ((uqv)localObject1).jdField_a_of_type_Int = 2;
          ((MessageForShortVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForPtt))
        {
          ((uqv)localObject1).jdField_a_of_type_Int = 4;
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    QQMessageFacade.Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return;
        localMessage = null;
        int i = uuc.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString);
        localObject = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade();
        if (localObject != null) {
          localMessage = ((QQMessageFacade)localObject).getLastMessage(this.jdField_a_of_type_JavaLangString, i);
        }
      } while (localMessage == null);
      this.jdField_b_of_type_Int = 0;
      uqx.a().a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localMessage.frienduin);
      localObject = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getConversationFacade();
    } while (localObject == null);
    ((acmw)localObject).a(localMessage.frienduin, localMessage.istroop, true);
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
      paramObject = (uqv)paramObject;
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    } while (paramObject.jdField_a_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqv
 * JD-Core Version:    0.7.0.1
 */