import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.List;

public class dfh
  implements Runnable
{
  public dfh(FastImagePreviewLayout paramFastImagePreviewLayout) {}
  
  public void run()
  {
    int i = MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal();
    Object localObject = AlbumUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 210, 1, MediaFileFilter.filterOfOrdinal(i));
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage called");
    }
    LocalMediaInfo localLocalMediaInfo;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localLocalMediaInfo = (LocalMediaInfo)((List)localObject).get(0);
      if ((PlusPanelUtils.b == null) || (!PlusPanelUtils.b.equals(localLocalMediaInfo.jdField_a_of_type_JavaLangString))) {
        break label91;
      }
    }
    for (;;)
    {
      return;
      label91:
      PlusPanelUtils.b = localLocalMediaInfo.jdField_a_of_type_JavaLangString;
      if (((PlusPanelUtils.jdField_a_of_type_JavaLangString != null) && (PlusPanelUtils.b.equals(PlusPanelUtils.jdField_a_of_type_JavaLangString))) || (localLocalMediaInfo.jdField_a_of_type_JavaLangString.contains("/tencent/zebra/cache/"))) {
        continue;
      }
      ColorDrawable localColorDrawable = new ColorDrawable(570425344);
      URL localURL = null;
      try
      {
        localObject = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839034);
        localURL = AlbumUtil.a(localLocalMediaInfo, AlbumThumbDownloader.a);
        long l1 = System.currentTimeMillis();
        long l2 = l1 - localLocalMediaInfo.c * 1000L;
        if (QLog.isColorLevel()) {
          QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage called, spentTime = " + l2 + ",currentTime = " + l1 + ",addedTime = " + localLocalMediaInfo.c + ",modifiedTime = " + localLocalMediaInfo.d);
        }
        if (l2 >= 30000L) {
          continue;
        }
        this.a.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, localColorDrawable, (Drawable)localObject);
        this.a.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
        this.a.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new dfi(this));
        return;
      }
      catch (EmptyStackException localEmptyStackException)
      {
        for (;;)
        {
          localObject = localURL;
          if (QLog.isColorLevel())
          {
            QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage EmptyStackException = " + localEmptyStackException);
            localObject = localURL;
          }
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          localObject = localURL;
          if (QLog.isColorLevel())
          {
            QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage NullPointerException = " + localNullPointerException);
            localObject = localURL;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfh
 * JD-Core Version:    0.7.0.1
 */