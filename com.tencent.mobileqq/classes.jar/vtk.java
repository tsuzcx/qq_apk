import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class vtk
  extends FMObserver
{
  public vtk(AIOImageProviderService paramAIOImageProviderService) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (AIOImageProviderService.b(this.a) == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    label258:
    for (;;)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.jdField_a_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return;
      }
      catch (AccountNotMatchException paramThumbnailInfo)
      {
        paramThumbnailInfo.printStackTrace();
        return;
      }
      long l = paramThumbnailInfo.a;
      Object localObject = AIOImageProviderService.b(this.a).iterator();
      FileManagerEntity localFileManagerEntity;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      } while (localFileManagerEntity.nSessionId != l);
      for (;;)
      {
        if (localFileManagerEntity == null) {
          break label258;
        }
        AIOImageProviderService.b(this.a).remove(localFileManagerEntity);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (localObject == null) {
          break;
        }
        int i = 18;
        if (paramThumbnailInfo.jdField_b_of_type_Int == 5) {
          i = 16;
        }
        if (FileUtil.a(paramThumbnailInfo.jdField_b_of_type_JavaLangString))
        {
          ((IAIOImageProviderCallBack)localObject).a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramThumbnailInfo.jdField_b_of_type_JavaLangString, false);
          this.a.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramThumbnailInfo.jdField_b_of_type_JavaLangString);
          return;
        }
        ((IAIOImageProviderCallBack)localObject).a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, null, false);
        this.a.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
        return;
        localFileManagerEntity = null;
      }
    }
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo, int paramInt)
  {
    if (AIOImageProviderService.b(this.a) == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    label154:
    for (;;)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.jdField_a_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return;
      }
      catch (AccountNotMatchException paramThumbnailInfo)
      {
        paramThumbnailInfo.printStackTrace();
        return;
      }
      long l = paramThumbnailInfo.a;
      Object localObject = AIOImageProviderService.b(this.a).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramThumbnailInfo = (FileManagerEntity)((Iterator)localObject).next();
      } while (paramThumbnailInfo.nSessionId != l);
      for (;;)
      {
        if (paramThumbnailInfo == null) {
          break label154;
        }
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if ((localObject == null) || (paramThumbnailInfo == null)) {
          break;
        }
        ((IAIOImageProviderCallBack)localObject).a(paramThumbnailInfo.uniseq, paramThumbnailInfo.status, 18, paramInt, paramThumbnailInfo.fileSize, false);
        return;
        paramThumbnailInfo = null;
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (AIOImageProviderService.a(this.a) == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    IAIOImageProviderCallBack localIAIOImageProviderCallBack;
    do
    {
      do
      {
        try
        {
          ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.jdField_a_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
          return;
        }
        catch (AccountNotMatchException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        localIAIOImageProviderCallBack = null;
        Iterator localIterator = AIOImageProviderService.a(this.a).iterator();
        do
        {
          paramString = localIAIOImageProviderCallBack;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (FileManagerEntity)localIterator.next();
        } while (paramString.nSessionId != paramLong2);
      } while (paramString == null);
      localIAIOImageProviderCallBack = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    } while ((localIAIOImageProviderCallBack == null) || (paramString == null));
    localIAIOImageProviderCallBack.a(paramLong1, paramString.status, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (AIOImageProviderService.a(this.a) == null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {}
    }
    label331:
    for (;;)
    {
      try
      {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.jdField_a_of_type_JavaLangString)).a().deleteObserver(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return;
      }
      catch (AccountNotMatchException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString1 = AIOImageProviderService.a(this.a).iterator();
      Object localObject;
      for (;;)
      {
        if (paramString1.hasNext())
        {
          localObject = (FileManagerEntity)paramString1.next();
          if (((FileManagerEntity)localObject).nSessionId == paramLong2)
          {
            paramString1 = (String)localObject;
            if (paramBoolean)
            {
              paramString1 = (String)localObject;
              if (TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
                QLog.d("AIOImageProviderService", 2, "find tempEntity,cloudtype: " + ((FileManagerEntity)localObject).cloudType + ",filepath:" + ((FileManagerEntity)localObject).strFilePath + ",sessionid:" + ((FileManagerEntity)localObject).nSessionId);
              }
            }
          }
        }
      }
      for (paramString1 = null;; paramString1 = null)
      {
        if (paramString1 == null) {
          break label331;
        }
        AIOImageProviderService.a(this.a).remove(paramString1);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
        if (localObject == null) {
          break;
        }
        if (paramBoolean)
        {
          ((IAIOImageProviderCallBack)localObject).a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.a.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
        if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
          paramString1.status = 16;
        }
        ((IAIOImageProviderCallBack)localObject).a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.a.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtk
 * JD-Core Version:    0.7.0.1
 */