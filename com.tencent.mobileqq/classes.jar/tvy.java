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

public class tvy
  extends twq
  implements syq<tme, toc>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private twl jdField_a_of_type_Twl;
  private twr jdField_a_of_type_Twr;
  
  public tvy(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Twl = new twl(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    twm localtwm = new twm(this.jdField_a_of_type_Twl);
    localtwm.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localtwm.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localtwm.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Twr.b(new ErrorMessage(), Collections.singletonList(localtwm), true);
  }
  
  public List<tws> a(List<twl> paramList)
  {
    return null;
  }
  
  public two a()
  {
    return new two(this.jdField_a_of_type_Twl, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, twr paramtwr)
  {
    this.jdField_a_of_type_Twr = paramtwr;
    paramtwr = ((tcf)tcz.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramtwr != null) && (paramtwr.bannerInfoList.size() == paramtwr.totalCount) && (paramtwr.totalCount > 0))
    {
      ved.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramtwr.totalCount));
      a(paramtwr);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    vxp.a(paramString1);
    tme localtme = new tme();
    localtme.b = paramString1;
    localtme.c = paramString2;
    syo.a().a(localtme, this);
  }
  
  public void a(@NonNull tme paramtme, @Nullable toc paramtoc, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtoc == null))
    {
      ved.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramtme.b);
      this.jdField_a_of_type_Twr.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (tcf)tcz.a(22);
    paramErrorMessage.a(paramtme.b, paramtoc);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramtme.b);
    }
    if ((paramtoc.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramtme.b, paramtoc.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvy
 * JD-Core Version:    0.7.0.1
 */