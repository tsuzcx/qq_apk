import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xik
  extends xjc
  implements wld<wyr, xap>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private xix jdField_a_of_type_Xix;
  private xjd jdField_a_of_type_Xjd;
  
  public xik(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Xix = new xix(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    xiy localxiy = new xiy(this.jdField_a_of_type_Xix);
    localxiy.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localxiy.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localxiy.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Xjd.b(new ErrorMessage(), Collections.singletonList(localxiy), true);
  }
  
  public List<xje> a(List<xix> paramList)
  {
    return null;
  }
  
  public xja a()
  {
    return new xja(this.jdField_a_of_type_Xix, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, xjd paramxjd)
  {
    this.jdField_a_of_type_Xjd = paramxjd;
    paramxjd = ((wos)wpm.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramxjd != null) && (paramxjd.bannerInfoList.size() == paramxjd.totalCount) && (paramxjd.totalCount > 0))
    {
      yqp.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramxjd.totalCount));
      a(paramxjd);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    zkb.a(paramString1);
    wyr localwyr = new wyr();
    localwyr.b = paramString1;
    localwyr.c = paramString2;
    wlb.a().a(localwyr, this);
  }
  
  public void a(@NonNull wyr paramwyr, @Nullable xap paramxap, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxap == null))
    {
      yqp.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramwyr.b);
      this.jdField_a_of_type_Xjd.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (wos)wpm.a(22);
    paramErrorMessage.a(paramwyr.b, paramxap);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramwyr.b);
    }
    if ((paramxap.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramwyr.b, paramxap.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xik
 * JD-Core Version:    0.7.0.1
 */