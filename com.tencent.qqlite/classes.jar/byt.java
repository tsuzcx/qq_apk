import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class byt
  implements Runnable
{
  public byt(AIOImageProviderService paramAIOImageProviderService) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localIAIOImageProviderCallBack = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (localIAIOImageProviderCallBack == null) {
          return;
        }
        Object localObject1 = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a.b);
        if (!AIOImageProviderService.a(this.a))
        {
          localObject1 = ((QQAppInterface)localObject1).a().a(this.a.c, this.a.jdField_a_of_type_Int, new int[] { -20000, -2000, -1035 });
          localArrayList2 = new ArrayList();
          localArrayList1 = new ArrayList();
          if (!QLog.isColorLevel()) {
            break label605;
          }
          QLog.d("AIOImageProviderService", 2, "init tempList.size is " + ((List)localObject1).size());
          break label605;
          if (i >= ((List)localObject1).size()) {
            continue;
          }
          localObject3 = (MessageRecord)((List)localObject1).get(i);
          j = ((MessageRecord)localObject3).msgtype;
          if (!(localObject3 instanceof MessageForPic)) {
            continue;
          }
          localObject3 = (MessageForPic)localObject3;
          ((MessageForPic)localObject3).parse();
          if ((j == -3000) || (j == -30003))
          {
            if (!QLog.isColorLevel()) {
              break label610;
            }
            QLog.i("AIOImageProviderService", 2, "loadImages msgType is " + j);
            break label610;
          }
        }
        else
        {
          localObject1 = ((QQAppInterface)localObject1).a().a(AIOImageProviderService.a(this.a));
          continue;
        }
        localArrayList2.add(AIOGalleryUtils.a((MessageForPic)localObject3));
        localArrayList1.add(localObject3);
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AIOImageProviderService", 2, "no appRuntime");
          return;
          if ((localObject3 instanceof MessageForMixedMsg))
          {
            localObject3 = (MessageForMixedMsg)localObject3;
            ((MessageForMixedMsg)localObject3).parse();
            int k = ((MessageForMixedMsg)localObject3).msgElemList.size();
            if (!QLog.isColorLevel()) {
              break label617;
            }
            QLog.i("AIOImageProviderService", 2, "AIOImageProviderService.loadImages mixed.msgElemList.size is " + k);
            break label617;
            if (j < k)
            {
              MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
              if (!(localMessageRecord instanceof MessageForPic)) {
                break label622;
              }
              localArrayList2.add(AIOGalleryUtils.a((MessageForPic)localMessageRecord));
              localArrayList1.add((MessageForPic)localMessageRecord);
              break label622;
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("AIOImageProviderService", 2, "loadImages " + ((MessageRecord)localObject3).getBaseInfoString());
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        IAIOImageProviderCallBack localIAIOImageProviderCallBack;
        ArrayList localArrayList2;
        ArrayList localArrayList1;
        Object localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AIOImageProviderService", 2, "out of memory", localOutOfMemoryError);
          return;
          if ((QLog.isColorLevel()) && (localArrayList2.isEmpty()))
          {
            localObject2 = localOutOfMemoryError.iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              QLog.i("AIOImageProviderService", 2, "loadImages dump mr " + ((MessageRecord)localObject3).getBaseInfoString());
              continue;
            }
          }
          Object localObject2 = (AIOImageData[])localArrayList2.toArray(new AIOImageData[0]);
          this.a.jdField_a_of_type_JavaUtilList = localArrayList1;
          localIAIOImageProviderCallBack.a((AIOImageData[])localObject2, -1);
        }
      }
      return;
      label605:
      int i = 0;
      continue;
      label610:
      i += 1;
      continue;
      label617:
      int j = 0;
      continue;
      label622:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     byt
 * JD-Core Version:    0.7.0.1
 */