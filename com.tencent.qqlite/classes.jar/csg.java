import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class csg
  implements EmosmHandler.EmosmHandlerListener
{
  public csg(EmoticonManagerImp paramEmoticonManagerImp, EmosmHandler paramEmosmHandler) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    List localList;
    boolean bool;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramInt == 2) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      localList = paramEmosmResp.data;
      localList.addAll(paramEmosmResp.magicData);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerImp", 2, "getEmosmList respone in initEmoticon,rlistSuze=" + localList.size());
      }
      bool = false;
      paramBoolean = false;
      EmojiManager localEmojiManager = (EmojiManager)EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getManager(39);
      try
      {
        localObject1 = new ArrayList();
        paramInt = 0;
        bool = paramBoolean;
        if (paramInt >= localList.size()) {
          break label887;
        }
        bool = paramBoolean;
        localObject2 = (EmoticonPackage)localList.get(paramInt);
        bool = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.jdField_a_of_type_JavaUtilMap.put(((EmoticonPackage)localObject2).epId, localObject2);
        bool = paramBoolean;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b(((EmoticonPackage)localObject2).epId);
        if (localObject3 != null)
        {
          bool = paramBoolean;
          if (((EmoticonPackage)localObject3).valid == ((EmoticonPackage)localObject2).valid)
          {
            bool = paramBoolean;
            if (((EmoticonPackage)localObject3).wordingId == ((EmoticonPackage)localObject2).wordingId)
            {
              bool = paramBoolean;
              if (((EmoticonPackage)localObject3).expiretime == ((EmoticonPackage)localObject2).expiretime)
              {
                bool = paramBoolean;
                if (((EmoticonPackage)localObject3).jobType == ((EmoticonPackage)localObject2).jobType) {
                  break label383;
                }
              }
            }
          }
          bool = paramBoolean;
          if (QLog.isColorLevel())
          {
            bool = paramBoolean;
            QLog.d("EmoticonManagerImp", 2, "update EmosmList in initEmoticon,epid=" + ((EmoticonPackage)localObject3).epId + ";valid=" + ((EmoticonPackage)localObject3).valid + ";wordingId=" + ((EmoticonPackage)localObject3).wordingId);
          }
          bool = paramBoolean;
          ((EmoticonPackage)localObject3).expiretime = ((EmoticonPackage)localObject2).expiretime;
          bool = paramBoolean;
          ((EmoticonPackage)localObject3).valid = ((EmoticonPackage)localObject2).valid;
          bool = paramBoolean;
          ((EmoticonPackage)localObject3).wordingId = ((EmoticonPackage)localObject2).wordingId;
          bool = paramBoolean;
          ((EmoticonPackage)localObject3).jobType = ((EmoticonPackage)localObject2).jobType;
          bool = paramBoolean;
          ((List)localObject1).add(localObject3);
          paramBoolean = true;
          break label959;
        }
        label383:
        if (localObject3 != null) {
          break label966;
        }
        bool = paramBoolean;
        if (this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(((EmoticonPackage)localObject2).epId) == null)
        {
          bool = paramBoolean;
          if (QLog.isColorLevel())
          {
            bool = paramBoolean;
            QLog.i("EmoticonManagerImp", 2, "emoPackage is not exist: " + ((EmoticonPackage)localObject2).epId);
          }
          bool = paramBoolean;
          localEmojiManager.a(((EmoticonPackage)localObject2).epId, EmojiManager.c, EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp));
        }
        for (;;)
        {
          bool = paramBoolean;
          if (((EmoticonPackage)localObject2).jobType != 0) {
            break;
          }
          bool = paramBoolean;
          localEmojiManager.a.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
          bool = paramBoolean;
          localEmojiManager.a((EmoticonPackage)localObject2);
          break label959;
          bool = paramBoolean;
          this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(((EmoticonPackage)localObject2).epId);
        }
        EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getApplication().getSharedPreferences("QQLite", 0);
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
        paramEmosmResp.name = EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getApplication().getString(2131364091);
        paramEmosmResp.mark = EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getApplication().getString(2131364091);
        paramEmosmResp.valid = true;
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(paramEmosmResp);
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(paramEmosmResp.epId);
      }
      paramEmosmResp = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b().iterator();
    }
    label675:
    label697:
    label954:
    label957:
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (paramEmosmResp.hasNext())
      {
        localEmoticonPackage = (EmoticonPackage)paramEmosmResp.next();
        paramInt = 0;
        if (paramInt >= localList.size()) {
          break label954;
        }
        localObject1 = (EmoticonPackage)localList.get(paramInt);
        if (!localEmoticonPackage.epId.equals(((EmoticonPackage)localObject1).epId)) {}
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramInt != 0) || (localEmoticonPackage.jobType == 1) || (localEmoticonPackage.jobType == 2) || ("100000".equals(localEmoticonPackage.epId))) {
          break label957;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b(localEmoticonPackage.epId);
        paramBoolean = true;
        break label675;
        bool = paramBoolean;
        localObject3 = EmosmUtils.getCoverUrl(2, ((EmoticonPackage)localObject2).epId);
        bool = paramBoolean;
        localObject2 = new File(EmosmUtils.getCoverPath(2, ((EmoticonPackage)localObject2).epId));
        bool = paramBoolean;
        if (((File)localObject2).exists()) {
          break label966;
        }
        bool = paramBoolean;
        localObject2 = new DownloadTask((String)localObject3, (File)localObject2);
        bool = paramBoolean;
        ((DownloaderFactory)EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp).getManager(41)).a(1).a((DownloadTask)localObject2, null, null);
        break label966;
        label887:
        bool = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a((List)localObject1);
        break;
        paramInt += 1;
        break label697;
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
    label959:
    label966:
    for (;;)
    {
      paramInt += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     csg
 * JD-Core Version:    0.7.0.1
 */