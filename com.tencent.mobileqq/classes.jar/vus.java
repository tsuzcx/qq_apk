import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.photo.PhotoListConfigManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class vus
  implements Runnable
{
  public vus(PhotoListPanel paramPhotoListPanel) {}
  
  public void run()
  {
    int k = 0;
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "QueryMediaTask start" + l1 + "to qurey time=" + (this.a.jdField_b_of_type_Long - l1));
    }
    Object localObject1 = PhotoListConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = ((PhotoListConfigManager)localObject1).jdField_a_of_type_Int;
    int j = ((PhotoListConfigManager)localObject1).b;
    localObject1 = ((PhotoListConfigManager)localObject1).jdField_a_of_type_JavaUtilSet;
    Object localObject3;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0))
    {
      localObject2 = new ArrayList(((Set)localObject1).size());
      localObject3 = ((Set)localObject1).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (String)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(AppConstants.aJ + (String)localObject1);
      }
    }
    localObject1 = null;
    Object localObject2 = AlbumUtil.a(this.a.jdField_a_of_type_AndroidAppActivity, "$RecentAlbumId", null, 100, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, i, j, true, (ArrayList)localObject1, false, -1L);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder("get album medias cost: ").append(l2 - l1);
      ((StringBuilder)localObject3).append(" limitSize:").append(i).append(" limitWidth:").append(j).append(" blackLists:").append(localObject1);
      QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject3).toString());
    }
    if ((localObject2 == null) || (((List)localObject2).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "QueryMediaTask getAlbumMedias is null");
      }
      PhotoListPanel.g = 0;
      this.a.jdField_a_of_type_AndroidOsHandler.post(new vut(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "get album medias size : " + ((List)localObject2).size());
    }
    int m = ((List)localObject2).size();
    this.a.jdField_b_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
    PhotoListPanel.g = m;
    i = 0;
    if (k < m) {}
    for (;;)
    {
      int n;
      try
      {
        localObject1 = (LocalMediaInfo)((List)localObject2).get(k);
        if (((LocalMediaInfo)localObject1).path == null) {
          break label759;
        }
        n = AlbumUtil.a((LocalMediaInfo)localObject1);
        if (n != 0) {
          break label766;
        }
        j = i;
        if (this.a.jdField_b_of_type_JavaUtilArrayList != null)
        {
          this.a.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).path);
          j = i;
        }
        ((LocalMediaInfo)localObject1).position = Integer.valueOf(k - j);
        if ((((LocalMediaInfo)localObject1).orientation == 90) || (((LocalMediaInfo)localObject1).orientation == 270))
        {
          ((LocalMediaInfo)localObject1).thumbWidth = this.a.c;
          ((LocalMediaInfo)localObject1).thumbHeight = 0;
          if ((((LocalMediaInfo)localObject1).mediaWidth > 0) && (((LocalMediaInfo)localObject1).mediaHeight > 0))
          {
            FlowThumbDecoder.a((LocalMediaInfo)localObject1, ((LocalMediaInfo)localObject1).mediaWidth, ((LocalMediaInfo)localObject1).mediaHeight);
            i = ((LocalMediaInfo)localObject1).thumbWidth;
            ((LocalMediaInfo)localObject1).thumbWidth = ((LocalMediaInfo)localObject1).thumbHeight;
            ((LocalMediaInfo)localObject1).thumbHeight = i;
            i = j;
            break label759;
          }
        }
        else
        {
          ((LocalMediaInfo)localObject1).thumbWidth = 0;
          ((LocalMediaInfo)localObject1).thumbHeight = this.a.c;
          if ((((LocalMediaInfo)localObject1).mediaWidth > 0) && (((LocalMediaInfo)localObject1).mediaHeight > 0)) {
            FlowThumbDecoder.a((LocalMediaInfo)localObject1, ((LocalMediaInfo)localObject1).mediaWidth, ((LocalMediaInfo)localObject1).mediaHeight);
          }
        }
        i = j;
      }
      catch (Exception localException)
      {
        if ((QLog.isColorLevel()) && (this.a.jdField_b_of_type_JavaUtilArrayList != null)) {
          QLog.d("PhotoListPanel", 2, localException + "get album medias size : " + ((List)localObject2).size() + "mPhotos size" + this.a.jdField_b_of_type_JavaUtilArrayList.size());
        }
      }
      this.a.jdField_a_of_type_AndroidOsHandler.post(new vuu(this, (List)localObject2));
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.b((List)localObject2);
      return;
      label759:
      k += 1;
      break;
      label766:
      j = i;
      if (n == 1) {
        j = i + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vus
 * JD-Core Version:    0.7.0.1
 */