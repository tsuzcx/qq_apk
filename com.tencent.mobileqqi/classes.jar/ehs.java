import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class ehs
  implements Runnable
{
  public ehs(AIOImageProviderService paramAIOImageProviderService) {}
  
  public void run()
  {
    int i;
    int j;
    try
    {
      IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
      if (localIAIOImageProviderCallBack == null) {
        return;
      }
      localObject1 = ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.a.b)).a().a(this.a.c, this.a.jdField_a_of_type_Int, new int[] { -20000, -2000, -1035 });
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      if ((!((List)localObject1).isEmpty()) || (!QLog.isColorLevel())) {
        break label378;
      }
      QLog.d("AIOImageProviderService", 2, "init error,tempList.isEmpty()");
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      ArrayList localArrayList2;
      ArrayList localArrayList1;
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      if (!(localObject2 instanceof MessageForMixedMsg)) {
        break label383;
      }
      Object localObject2 = (MessageForMixedMsg)localObject2;
      ((MessageForMixedMsg)localObject2).parse();
      k = ((MessageForMixedMsg)localObject2).msgElemList.size();
      j = 0;
      if (j >= k) {
        break label383;
      }
      localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(j);
      if (!(localMessageRecord instanceof MessageForPic)) {
        break label390;
      }
      localArrayList2.add(AIOGalleryUtils.a((MessageForPic)localMessageRecord));
      localArrayList1.add((MessageForPic)localMessageRecord);
      break label390;
      Object localObject1 = (AIOImageData[])localArrayList2.toArray(new AIOImageData[0]);
      this.a.jdField_a_of_type_JavaUtilList = localArrayList1;
      localAccountNotMatchException.a((AIOImageData[])localObject1, -1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("AIOImageProviderService", 2, "out of memory", localOutOfMemoryError);
    }
    if (i < ((List)localObject1).size())
    {
      localObject2 = (MessageRecord)((List)localObject1).get(i);
      j = ((MessageRecord)localObject2).msgtype;
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject2;
        ((MessageForPic)localObject2).parse();
        if ((j == -3000) || (j == -30003)) {
          break label383;
        }
        localArrayList2.add(AIOGalleryUtils.a((MessageForPic)localObject2));
        localArrayList1.add(localObject2);
        break label383;
      }
    }
    for (;;)
    {
      int k;
      MessageRecord localMessageRecord;
      label377:
      return;
      label378:
      i = 0;
      break;
      label383:
      i += 1;
      break;
      label390:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehs
 * JD-Core Version:    0.7.0.1
 */