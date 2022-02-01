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

public class ucy
{
  public int a;
  public long a;
  public String a;
  protected WeakReference<QQAppInterface> a;
  public List<ucz> a;
  public int b;
  public WeakReference<MessageRecord> b;
  
  public ucy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static ucy a(QQAppInterface paramQQAppInterface, Context paramContext, TroopBarData paramTroopBarData)
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
    Object localObject1 = new ucy(paramQQAppInterface);
    localObject3 = paramQQAppInterface.getConversationFacade();
    if (localObject3 != null) {}
    for (int i = ((abwp)localObject3).a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);; i = 0)
    {
      long l;
      if (paramTroopBarData.mLastMsgTime > paramTroopBarData.mLastDraftTime)
      {
        l = paramTroopBarData.mLastMsgTime;
        ((ucy)localObject1).jdField_a_of_type_Long = l;
        ((ucy)localObject1).jdField_a_of_type_JavaLangString = ((MessageRecord)localObject2).frienduin;
        ((ucy)localObject1).jdField_b_of_type_Int = i;
        try
        {
          if ((localObject2 instanceof MessageForPubAccount))
          {
            ((MessageForPubAccount)localObject2).parse();
            ((ucy)localObject1).jdField_a_of_type_Int = 1;
            paramQQAppInterface = ((MessageForPubAccount)localObject2).mPAMessage;
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface = paramQQAppInterface.items.iterator();
              while (paramQQAppInterface.hasNext())
              {
                paramContext = (PAMessage.Item)paramQQAppInterface.next();
                paramTroopBarData = new ucz();
                paramTroopBarData.jdField_a_of_type_Int = 1;
                paramTroopBarData.jdField_a_of_type_JavaLangString = paramContext.cover;
                paramTroopBarData.d = paramContext.url;
                paramTroopBarData.e = paramContext.actionData;
                paramTroopBarData.b = paramContext.title;
                ((ucy)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
              }
            }
            ((ucy)localObject1).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
          }
        }
        catch (Exception paramQQAppInterface)
        {
          ((ucy)localObject1).jdField_a_of_type_Int = 0;
          paramContext = new ucz();
          paramContext.jdField_a_of_type_Int = 0;
          paramContext.c = ((MessageRecord)localObject2).msg;
          ((ucy)localObject1).jdField_a_of_type_JavaUtilList.clear();
          ((ucy)localObject1).jdField_a_of_type_JavaUtilList.add(paramContext);
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
          ((ucy)localObject1).jdField_a_of_type_Int = 1;
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
                ucz localucz;
                if (paramTroopBarData.hasNext())
                {
                  localObject3 = (bcgw)paramTroopBarData.next();
                  localucz = new ucz();
                  localucz.jdField_a_of_type_Int = 1;
                  localucz.c = ((bcgw)localObject3).g;
                  localucz.g = paramContext.mTagName;
                  if (!(localObject3 instanceof bcgx)) {
                    break label813;
                  }
                  paramQQAppInterface = ((bcgx)localObject3).a.iterator();
                  for (;;)
                  {
                    if (!paramQQAppInterface.hasNext()) {
                      break label730;
                    }
                    Object localObject4 = (bcgw)paramQQAppInterface.next();
                    if ((localObject4 instanceof bciz))
                    {
                      localucz.jdField_a_of_type_JavaLangString = ((bciz)localObject4).ac;
                    }
                    else if ((localObject4 instanceof StructMsgItemTitle))
                    {
                      localucz.b = ((StructMsgItemTitle)localObject4).b();
                    }
                    else if ((localObject4 instanceof bcme))
                    {
                      localucz.jdField_a_of_type_JavaLangString = ((bcme)localObject4).ac;
                    }
                    else if ((localObject4 instanceof bclk))
                    {
                      localucz.jdField_a_of_type_JavaLangString = ((bclk)localObject4).ac;
                    }
                    else if ((localObject4 instanceof bclp))
                    {
                      localucz.jdField_a_of_type_JavaLangString = ((bclp)localObject4).ac;
                    }
                    else if ((localObject4 instanceof bchz))
                    {
                      localObject4 = ((bchz)localObject4).jdField_a_of_type_JavaUtilList.iterator();
                      if (((Iterator)localObject4).hasNext())
                      {
                        bcgw localbcgw = (bcgw)((Iterator)localObject4).next();
                        if (!(localbcgw instanceof StructMsgItemTitle)) {
                          break;
                        }
                        localucz.b = ((StructMsgItemTitle)localbcgw).b();
                      }
                    }
                  }
                  label730:
                  if (!TextUtils.isEmpty(((bcgw)localObject3).b)) {
                    break label804;
                  }
                  paramQQAppInterface = paramContext.mMsgUrl;
                  label746:
                  localucz.d = paramQQAppInterface;
                }
                for (;;)
                {
                  if ((((bcgx)localObject3).a.size() == 1) && (((bcgw)((bcgx)localObject3).a.get(0) instanceof bcjb))) {
                    break label820;
                  }
                  ((ucy)localObject1).jdField_a_of_type_JavaUtilList.add(localucz);
                  break label447;
                  break;
                  paramQQAppInterface = ((bcgw)localObject3).b;
                  break label746;
                  localucz.jdField_a_of_type_Int = 0;
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
          ((ucy)localObject1).jdField_a_of_type_Int = 3;
          paramTroopBarData = new ucz();
          paramTroopBarData.jdField_a_of_type_Int = 2;
          paramTroopBarData.c = paramQQAppInterface.getMessageFacade().getMsgSummary(paramContext, (MessageRecord)localObject2, false);
          paramTroopBarData.f = ((MessageForPic)localObject2).path;
          paramTroopBarData.jdField_a_of_type_JavaNetURL = URLDrawableHelper.getURL((MessageForPic)localObject2, 65537, null);
          ((ucy)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
        }
      }
      label915:
      if ((localObject2 instanceof MessageForText))
      {
        ((ucy)localObject1).jdField_a_of_type_Int = 0;
        ((MessageForText)localObject2).parse();
      }
      for (;;)
      {
        paramTroopBarData = new ucz();
        paramTroopBarData.jdField_a_of_type_Int = 0;
        paramTroopBarData.c = paramQQAppInterface.getMessageFacade().getMsgSummary(paramContext, (MessageRecord)localObject2, false);
        ((ucy)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
        break;
        if ((localObject2 instanceof MessageForVideo))
        {
          ((ucy)localObject1).jdField_a_of_type_Int = 2;
          ((MessageForVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForShortVideo))
        {
          ((ucy)localObject1).jdField_a_of_type_Int = 2;
          ((MessageForShortVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForPtt))
        {
          ((ucy)localObject1).jdField_a_of_type_Int = 4;
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
        int i = ugf.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString);
        localObject = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade();
        if (localObject != null) {
          localMessage = ((QQMessageFacade)localObject).getLastMessage(this.jdField_a_of_type_JavaLangString, i);
        }
      } while (localMessage == null);
      this.jdField_b_of_type_Int = 0;
      uda.a().a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localMessage.frienduin);
      localObject = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getConversationFacade();
    } while (localObject == null);
    ((abwp)localObject).a(localMessage.frienduin, localMessage.istroop, true);
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
      paramObject = (ucy)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucy
 * JD-Core Version:    0.7.0.1
 */