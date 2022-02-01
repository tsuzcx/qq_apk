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

public class xmf
  extends xmx
  implements woy<xcm, xek>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private xms jdField_a_of_type_Xms;
  private xmy jdField_a_of_type_Xmy;
  
  public xmf(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Xms = new xms(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    xmt localxmt = new xmt(this.jdField_a_of_type_Xms);
    localxmt.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localxmt.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localxmt.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Xmy.b(new ErrorMessage(), Collections.singletonList(localxmt), true);
  }
  
  public List<xmz> a(List<xms> paramList)
  {
    return null;
  }
  
  public xmv a()
  {
    return new xmv(this.jdField_a_of_type_Xms, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, xmy paramxmy)
  {
    this.jdField_a_of_type_Xmy = paramxmy;
    paramxmy = ((wsn)wth.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramxmy != null) && (paramxmy.bannerInfoList.size() == paramxmy.totalCount) && (paramxmy.totalCount > 0))
    {
      yuk.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramxmy.totalCount));
      a(paramxmy);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    znw.a(paramString1);
    xcm localxcm = new xcm();
    localxcm.b = paramString1;
    localxcm.c = paramString2;
    wow.a().a(localxcm, this);
  }
  
  public void a(@NonNull xcm paramxcm, @Nullable xek paramxek, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxek == null))
    {
      yuk.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramxcm.b);
      this.jdField_a_of_type_Xmy.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (wsn)wth.a(22);
    paramErrorMessage.a(paramxcm.b, paramxek);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramxcm.b);
    }
    if ((paramxek.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramxcm.b, paramxek.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmf
 * JD-Core Version:    0.7.0.1
 */