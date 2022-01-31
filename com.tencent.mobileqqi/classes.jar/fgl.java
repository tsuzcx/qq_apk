import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.emoticon.EPCoverTask;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class fgl
  implements EmosmHandler.EmosmHandlerListener
{
  public fgl(EmoticonManagerImp paramEmoticonManagerImp, EmosmHandler paramEmosmHandler) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    boolean bool;
    Object localObject1;
    Object localObject2;
    label366:
    EmoticonPackage localEmoticonPackage;
    if ((paramInt == 2) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      List localList = paramEmosmResp.data;
      localList.addAll(paramEmosmResp.magicData);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerImp", 2, "getEmosmList respone in initEmoticon,rlistSuze=" + localList.size());
      }
      bool = false;
      paramBoolean = false;
      try
      {
        ArrayList localArrayList = new ArrayList();
        paramInt = 0;
        bool = paramBoolean;
        if (paramInt >= localList.size()) {
          break label872;
        }
        bool = paramBoolean;
        localObject1 = (EmoticonPackage)localList.get(paramInt);
        bool = paramBoolean;
        EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).put(((EmoticonPackage)localObject1).epId, localObject1);
        bool = paramBoolean;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b(((EmoticonPackage)localObject1).epId);
        if (localObject2 != null)
        {
          bool = paramBoolean;
          if (((EmoticonPackage)localObject2).valid == ((EmoticonPackage)localObject1).valid)
          {
            bool = paramBoolean;
            if (((EmoticonPackage)localObject2).wordingId == ((EmoticonPackage)localObject1).wordingId)
            {
              bool = paramBoolean;
              if (((EmoticonPackage)localObject2).expiretime == ((EmoticonPackage)localObject1).expiretime)
              {
                bool = paramBoolean;
                if (((EmoticonPackage)localObject2).jobType == ((EmoticonPackage)localObject1).jobType) {
                  break label366;
                }
              }
            }
          }
          bool = paramBoolean;
          if (QLog.isColorLevel())
          {
            bool = paramBoolean;
            QLog.d("EmoticonManagerImp", 2, "update EmosmList in initEmoticon,epid=" + ((EmoticonPackage)localObject2).epId + ";valid=" + ((EmoticonPackage)localObject2).valid + ";wordingId=" + ((EmoticonPackage)localObject2).wordingId);
          }
          bool = paramBoolean;
          ((EmoticonPackage)localObject2).expiretime = ((EmoticonPackage)localObject1).expiretime;
          bool = paramBoolean;
          ((EmoticonPackage)localObject2).valid = ((EmoticonPackage)localObject1).valid;
          bool = paramBoolean;
          ((EmoticonPackage)localObject2).wordingId = ((EmoticonPackage)localObject1).wordingId;
          bool = paramBoolean;
          ((EmoticonPackage)localObject2).jobType = ((EmoticonPackage)localObject1).jobType;
          bool = paramBoolean;
          localArrayList.add(localObject2);
          paramBoolean = true;
          break label947;
        }
        if (localObject2 != null) {
          break label954;
        }
        bool = paramBoolean;
        if (this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(((EmoticonPackage)localObject1).epId) == null)
        {
          bool = paramBoolean;
          if (QLog.isColorLevel())
          {
            bool = paramBoolean;
            QLog.i("EmoticonManagerImp", 2, "emoPackage is not exist: " + ((EmoticonPackage)localObject1).epId);
          }
          bool = paramBoolean;
          EmoticonController.a(EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp)).b(((EmoticonPackage)localObject1).epId);
        }
        for (;;)
        {
          bool = paramBoolean;
          if (((EmoticonPackage)localObject1).jobType != 0) {
            break;
          }
          bool = paramBoolean;
          EmoticonController.a(EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp)).a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a);
          bool = paramBoolean;
          new EPCoverTask((EmoticonPackage)localObject1, EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp)).a();
          break label947;
          bool = paramBoolean;
          this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(((EmoticonPackage)localObject1).epId);
        }
        EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getApplication().getSharedPreferences("mobileQQi", 0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramBoolean = bool;
      }
      if ((paramEmosmResp.magicData.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b("100000") == null))
      {
        paramEmosmResp = new EmoticonPackage();
        paramEmosmResp.epId = "100000";
        paramEmosmResp.type = 1;
        paramEmosmResp.name = EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getApplication().getString(2131562336);
        paramEmosmResp.mark = EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getApplication().getString(2131562336);
        paramEmosmResp.valid = true;
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(paramEmosmResp);
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(paramEmosmResp.epId);
      }
      paramEmosmResp = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b().iterator();
      label673:
      if (paramEmosmResp.hasNext())
      {
        localEmoticonPackage = (EmoticonPackage)paramEmosmResp.next();
        paramInt = 0;
        label695:
        if (paramInt >= localList.size()) {
          break label942;
        }
        localObject1 = (EmoticonPackage)localList.get(paramInt);
        if (!localEmoticonPackage.epId.equals(((EmoticonPackage)localObject1).epId)) {}
      }
    }
    label942:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt == 0) && (localEmoticonPackage.jobType != 1) && (localEmoticonPackage.jobType != 2) && (!"100000".equals(localEmoticonPackage.epId)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b(localEmoticonPackage.epId);
        paramBoolean = true;
      }
      for (;;)
      {
        break label673;
        bool = paramBoolean;
        localObject2 = EmosmUtils.getCoverUrl(2, ((EmoticonPackage)localObject1).epId);
        bool = paramBoolean;
        localObject1 = new File(EmosmUtils.getCoverPath(2, ((EmoticonPackage)localObject1).epId));
        bool = paramBoolean;
        if (((File)localObject1).exists()) {
          break label954;
        }
        bool = paramBoolean;
        localObject1 = new DownloadInfo((String)localObject2, (File)localObject1, 2);
        bool = paramBoolean;
        HttpDownloadUtil.a(EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp), (DownloadInfo)localObject1, null, null);
        break label954;
        label872:
        bool = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(localEmoticonPackage);
        break;
        paramInt += 1;
        break label695;
        bool = paramBoolean;
        if (!paramBoolean)
        {
          bool = paramBoolean;
          if (!EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).d(EmoticonKeyword.class.getSimpleName())) {
            bool = true;
          }
        }
        EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp, bool, 30000L);
        return;
      }
    }
    label947:
    label954:
    for (;;)
    {
      paramInt += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgl
 * JD-Core Version:    0.7.0.1
 */