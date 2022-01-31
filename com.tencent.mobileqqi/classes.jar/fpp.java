import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fpp
  extends FMObserver
{
  public fpp(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    if (!paramString2.equalsIgnoreCase(this.a.jdField_c_of_type_JavaLangString)) {
      return;
    }
    FMToastUtil.a(2131562097);
    CloudFileBrowserActivity.b(this.a);
    CloudFileBrowserActivity.c(this.a);
    CloudFileBrowserActivity.b(this.a, 1);
    CloudFileBrowserActivity.a(this.a, false);
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if ((paramThumbnailInfo == null) || (paramThumbnailInfo.a == null)) {
      return;
    }
    if ((paramThumbnailInfo.a instanceof WeiYunFileInfo)) {
      ((WeiYunFileInfo)paramThumbnailInfo.a).g = paramThumbnailInfo.b;
    }
    for (;;)
    {
      CloudFileBrowserActivity.a(this.a, true);
      return;
      if ((paramThumbnailInfo.a instanceof OfflineFileInfo)) {
        ((OfflineFileInfo)paramThumbnailInfo.a).jdField_c_of_type_JavaLangString = paramThumbnailInfo.b;
      } else if ((paramThumbnailInfo.a instanceof FileManagerEntity)) {
        ((FileManagerEntity)paramThumbnailInfo.a).strThumbPath = paramThumbnailInfo.b;
      }
    }
  }
  
  protected void a(Boolean paramBoolean, List paramList)
  {
    super.a(paramBoolean, paramList);
    this.a.l = true;
    this.a.j = paramBoolean.booleanValue();
    if (this.a.jdField_a_of_type_Long != 9L) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      OfflineFileInfo localOfflineFileInfo = (OfflineFileInfo)localIterator.next();
      if (FileManagerUtil.a(localOfflineFileInfo.b) == 0)
      {
        String str = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localOfflineFileInfo.jdField_a_of_type_JavaLangString, 3, localOfflineFileInfo.jdField_a_of_type_Boolean, localOfflineFileInfo);
        if (str != null) {
          localOfflineFileInfo.jdField_c_of_type_JavaLangString = str;
        }
      }
    }
    if ((!this.a.d) && (!this.a.e)) {
      FMToastUtil.b(2131563136);
    }
    if (this.a.jdField_c_of_type_Boolean)
    {
      this.a.jdField_b_of_type_JavaUtilArrayList.clear();
      this.a.jdField_c_of_type_Boolean = false;
    }
    this.a.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean.booleanValue())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      CloudFileBrowserActivity.b(this.a);
      CloudFileBrowserActivity.c(this.a);
      CloudFileBrowserActivity.b(this.a, 0);
      CloudFileBrowserActivity.a(this.a, true);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected void a(Integer paramInteger, String paramString)
  {
    super.a(paramInteger, paramString);
    if (this.a.jdField_a_of_type_Long != 9L) {
      return;
    }
    FMToastUtil.a(2131562097);
    CloudFileBrowserActivity.b(this.a);
    CloudFileBrowserActivity.c(this.a);
    CloudFileBrowserActivity.b(this.a, 1);
    CloudFileBrowserActivity.a(this.a, false);
  }
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean)
  {
    super.a(paramString1, paramString2, paramInteger, paramString3, paramBoolean);
    CloudFileBrowserActivity.a(this.a, true);
    paramString1 = FileManagerUtil.d(paramString2);
    paramString2 = paramString1 + this.a.getString(2131558762);
    if ((paramInteger.intValue() == -100000) || (paramInteger.intValue() == -100003) || (paramInteger.intValue() == -100002) || (paramInteger.intValue() == -100001))
    {
      FMToastUtil.a(paramString2);
      return;
    }
    paramString1 = paramString2;
    if (paramString3 != null)
    {
      paramString1 = paramString2;
      if (paramString3.length() > 0) {
        paramString1 = paramString2 + "，" + paramString3;
      }
    }
    FMToastUtil.a(paramString1);
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    super.a(paramString1, paramString2, paramBoolean);
    if (paramBoolean) {
      CloudFileBrowserActivity.a(this.a, paramString1);
    }
    for (;;)
    {
      CloudFileBrowserActivity.a(this.a, true);
      return;
      CloudFileBrowserActivity.b(this.a, paramString1);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, List paramList, int paramInt2)
  {
    this.a.k = true;
    this.a.i = paramBoolean;
    this.a.jdField_b_of_type_Int = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (FileManagerUtil.a(localWeiYunFileInfo.b) == 0)
      {
        String str = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.b, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.g = str;
        }
      }
    }
    if (!paramString.equals(this.a.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if ((!this.a.d) && (!this.a.e)) {
      FMToastUtil.b(2131563136);
    }
    if (this.a.jdField_c_of_type_Boolean)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      this.a.jdField_c_of_type_Boolean = false;
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean)
    {
      this.a.f = true;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      CloudFileBrowserActivity.b(this.a);
      CloudFileBrowserActivity.c(this.a);
      CloudFileBrowserActivity.b(this.a, 0);
      CloudFileBrowserActivity.jdField_b_of_type_Long = paramLong;
      CloudFileBrowserActivity.a(this.a, true);
      return;
      this.a.f = false;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fpp
 * JD-Core Version:    0.7.0.1
 */