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

public class xcl
  extends xdd
  implements wfk<wsx, wuv>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private xcy jdField_a_of_type_Xcy;
  private xde jdField_a_of_type_Xde;
  
  public xcl(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Xcy = new xcy(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    xcz localxcz = new xcz(this.jdField_a_of_type_Xcy);
    localxcz.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localxcz.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localxcz.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Xde.b(new ErrorMessage(), Collections.singletonList(localxcz), true);
  }
  
  public List<xdf> a(List<xcy> paramList)
  {
    return null;
  }
  
  public xdb a()
  {
    return new xdb(this.jdField_a_of_type_Xcy, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, xde paramxde)
  {
    this.jdField_a_of_type_Xde = paramxde;
    paramxde = ((wiy)wjs.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramxde != null) && (paramxde.bannerInfoList.size() == paramxde.totalCount) && (paramxde.totalCount > 0))
    {
      ykq.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramxde.totalCount));
      a(paramxde);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    zdl.a(paramString1);
    wsx localwsx = new wsx();
    localwsx.b = paramString1;
    localwsx.c = paramString2;
    wfi.a().a(localwsx, this);
  }
  
  public void a(@NonNull wsx paramwsx, @Nullable wuv paramwuv, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwuv == null))
    {
      ykq.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramwsx.b);
      this.jdField_a_of_type_Xde.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (wiy)wjs.a(22);
    paramErrorMessage.a(paramwsx.b, paramwuv);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramwsx.b);
    }
    if ((paramwuv.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramwsx.b, paramwuv.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcl
 * JD-Core Version:    0.7.0.1
 */