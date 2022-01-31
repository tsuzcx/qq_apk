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

public class twb
  extends twt
  implements syt<tmh, tof>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private two jdField_a_of_type_Two;
  private twu jdField_a_of_type_Twu;
  
  public twb(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Two = new two(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    twp localtwp = new twp(this.jdField_a_of_type_Two);
    localtwp.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localtwp.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localtwp.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Twu.b(new ErrorMessage(), Collections.singletonList(localtwp), true);
  }
  
  public List<twv> a(List<two> paramList)
  {
    return null;
  }
  
  public twr a()
  {
    return new twr(this.jdField_a_of_type_Two, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, twu paramtwu)
  {
    this.jdField_a_of_type_Twu = paramtwu;
    paramtwu = ((tci)tdc.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramtwu != null) && (paramtwu.bannerInfoList.size() == paramtwu.totalCount) && (paramtwu.totalCount > 0))
    {
      veg.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramtwu.totalCount));
      a(paramtwu);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    vxs.a(paramString1);
    tmh localtmh = new tmh();
    localtmh.b = paramString1;
    localtmh.c = paramString2;
    syr.a().a(localtmh, this);
  }
  
  public void a(@NonNull tmh paramtmh, @Nullable tof paramtof, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtof == null))
    {
      veg.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramtmh.b);
      this.jdField_a_of_type_Twu.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (tci)tdc.a(22);
    paramErrorMessage.a(paramtmh.b, paramtof);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramtmh.b);
    }
    if ((paramtof.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramtmh.b, paramtof.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twb
 * JD-Core Version:    0.7.0.1
 */