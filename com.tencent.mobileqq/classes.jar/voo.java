import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.AIOImageProviderListener;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class voo
  implements Runnable
{
  public voo(AIOImageProviderService paramAIOImageProviderService) {}
  
  public void run()
  {
    Object localObject7;
    ArrayList localArrayList1;
    Object localObject8;
    for (;;)
    {
      try
      {
        this.a.jdField_c_of_type_Boolean = true;
        if (this.a.jdField_d_of_type_Int < 60)
        {
          this.a.jdField_c_of_type_Boolean = false;
          this.a.b();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] start");
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null))
        {
          this.a.jdField_c_of_type_Boolean = false;
          this.a.b();
          return;
        }
        l = System.currentTimeMillis();
        localObject7 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.jdField_a_of_type_JavaLangString);
        localArrayList2 = new ArrayList();
        localArrayList1 = new ArrayList();
        if (this.a.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.a.jdField_b_of_type_JavaLangString == null)
        {
          this.a.jdField_c_of_type_Boolean = false;
          this.a.b();
          return;
        }
        localObject8 = new int[7];
        Object tmp194_192 = localObject8;
        tmp194_192[0] = -20000;
        Object tmp200_194 = tmp194_192;
        tmp200_194[1] = -2000;
        Object tmp206_200 = tmp200_194;
        tmp206_200[2] = -1035;
        Object tmp212_206 = tmp206_200;
        tmp212_206[3] = -2011;
        Object tmp218_212 = tmp212_206;
        tmp218_212[4] = -2022;
        Object tmp224_218 = tmp218_212;
        tmp224_218[5] = -2005;
        Object tmp230_224 = tmp224_218;
        tmp230_224[6] = -2017;
        tmp230_224;
        if (this.a.jdField_b_of_type_Boolean) {
          continue;
        }
        localObject6 = ((QQAppInterface)localObject7).a(this.a.jdField_a_of_type_Int).a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, (int[])localObject8);
        localObject1 = localObject6;
        if (((List)localObject6).size() < 60)
        {
          localObject1 = ((QQAppInterface)localObject7).a().a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, (int[])localObject8, 60);
          this.a.jdField_d_of_type_Int = ((List)localObject1).size();
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        long l;
        ArrayList localArrayList2;
        Object localObject6;
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
        return;
        localObject2 = ((QQAppInterface)localObject7).a().a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Int, this.a.jdField_d_of_type_Long, (int[])localObject8, 60);
        continue;
        if ((((QQAppInterface)localObject7).a() != null) && (!this.a.jdField_b_of_type_Boolean)) {
          continue;
        }
        this.a.jdField_c_of_type_Boolean = false;
        this.a.b();
        return;
        localObject2 = ((QQAppInterface)localObject7).a().a(this.a.jdField_a_of_type_Long);
        continue;
        localArrayList2.addAll(0, (Collection)localObject2);
        localArrayList1.addAll(0, AIOImageProviderService.a(this.a, (QQAppInterface)localObject7, (List)localObject2));
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label513:
        label581:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AIOImageProviderService", 2, "out of memory", localOutOfMemoryError);
        return;
        localList = this.a.jdField_b_of_type_JavaUtilList;
        continue;
        localObject8 = this.a.jdField_b_of_type_JavaUtilList;
        i = 0;
        try
        {
          if (i >= localList.size()) {
            break label1084;
          }
          localAIORichMediaData = (AIORichMediaData)localList.get(i);
          if (this.a.a(localAIORichMediaData)) {
            break label1129;
          }
          ((List)localObject7).add(localAIORichMediaData);
        }
        finally {}
      }
      finally
      {
        this.a.jdField_c_of_type_Boolean = false;
      }
      if (this.a.jdField_b_of_type_Boolean) {
        continue;
      }
      localArrayList2.addAll((Collection)localObject1);
      localArrayList1.addAll(AIOImageProviderService.a(this.a, (QQAppInterface)localObject7, (List)localObject1));
      this.a.jdField_b_of_type_Boolean = true;
      if ((this.a.jdField_a_of_type_Boolean) || (localArrayList1.size() >= 30) || (this.a.jdField_d_of_type_Int < 60))
      {
        if (localArrayList1.size() <= 0) {
          break label1112;
        }
        localObject6 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (localObject6 != null)
        {
          localObject7 = new ArrayList();
          if (this.a.jdField_a_of_type_Int == 1) {
            break label1122;
          }
          if (this.a.jdField_a_of_type_Int != 1026) {
            continue;
          }
          break label1122;
          if (this.a.jdField_a_of_type_Int != 1) {
            continue;
          }
          localObject1 = (AIORichMediaData[])((List)localObject1).toArray(new AIORichMediaData[((List)localObject1).size()]);
          if (localObject1.length > 0) {
            ((IAIOImageProviderCallBack)localObject6).a((AIORichMediaData[])localObject1, -1);
          }
        }
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
        if (localObject1 != null)
        {
          localObject6 = (AIORichMediaData[])localArrayList1.toArray(new AIORichMediaData[localArrayList1.size()]);
          if (localObject6.length > 0) {
            ((AIOImageProviderService.AIOImageProviderListener)localObject1).a((AIORichMediaData[])localObject6, -1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + this.a.jdField_a_of_type_Boolean + ", tempList.size: " + localArrayList2.size() + ", tempDataList.size: " + localArrayList1.size() + ", cost:" + (System.currentTimeMillis() - l));
        }
        this.a.jdField_c_of_type_Boolean = false;
        return;
        if (!MsgProxy.a(this.a.jdField_a_of_type_Int)) {
          continue;
        }
        localObject1 = this.a;
        ((AIOImageProviderService)localObject1).jdField_c_of_type_Long -= 1L;
        localObject1 = ((QQAppInterface)localObject7).a().a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Int, this.a.jdField_c_of_type_Long, (int[])localObject8, 60);
        this.a.jdField_d_of_type_Int = ((List)localObject1).size();
        localObject6 = this.a;
        ((AIOImageProviderService)localObject6).e += 1;
      }
    }
    for (;;)
    {
      Object localObject2;
      List localList;
      int i;
      AIORichMediaData localAIORichMediaData;
      label1084:
      Object localObject5 = (AIORichMediaData[])((List)localObject7).toArray(new AIORichMediaData[((List)localObject7).size()]);
      break label513;
      label1112:
      this.a.b();
      break label581;
      label1122:
      localObject5 = localArrayList1;
      break;
      label1129:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     voo
 * JD-Core Version:    0.7.0.1
 */