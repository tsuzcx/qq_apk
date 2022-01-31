import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class dil
  extends FMObserver
{
  public dil(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {
      return;
    }
    if ((paramThumbnailInfo.a instanceof FileManagerEntity))
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
        QfileBaseCloudFileTabView.o(this.a).a().c(localFileManagerEntity);
      }
    }
    this.a.i();
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    FMDataCache.a(paramString1);
    FileManagerUtil.a(paramInteger.intValue(), paramString2);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(false);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = FMDataCache.a(paramString1);
    if ((!this.a.b(paramString2)) && (this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramString2 = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString2.hasNext())
      {
        WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramString2.next();
        if (localWeiYunFileInfo.a.equalsIgnoreCase(paramString1) == true) {
          this.a.b(localWeiYunFileInfo);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseCloudFileTabView.a(this.a, new dim(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseCloudFileTabView.b(this.a, new din(this, paramLong2));
  }
  
  protected void d()
  {
    super.d();
    QfileBaseCloudFileTabView.c(this.a, new dio(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dil
 * JD-Core Version:    0.7.0.1
 */