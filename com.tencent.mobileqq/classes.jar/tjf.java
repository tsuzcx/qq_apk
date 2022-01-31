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

public class tjf
  extends tjx
  implements slx<szl, tbj>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private tjs jdField_a_of_type_Tjs;
  private tjy jdField_a_of_type_Tjy;
  
  public tjf(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Tjs = new tjs(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    tjt localtjt = new tjt(this.jdField_a_of_type_Tjs);
    localtjt.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localtjt.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localtjt.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Tjy.b(new ErrorMessage(), Collections.singletonList(localtjt), true);
  }
  
  public List<tjz> a(List<tjs> paramList)
  {
    return null;
  }
  
  public tjv a()
  {
    return new tjv(this.jdField_a_of_type_Tjs, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, tjy paramtjy)
  {
    this.jdField_a_of_type_Tjy = paramtjy;
    paramtjy = ((spm)sqg.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramtjy != null) && (paramtjy.bannerInfoList.size() == paramtjy.totalCount) && (paramtjy.totalCount > 0))
    {
      urk.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramtjy.totalCount));
      a(paramtjy);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    vkw.a(paramString1);
    szl localszl = new szl();
    localszl.b = paramString1;
    localszl.c = paramString2;
    slv.a().a(localszl, this);
  }
  
  public void a(@NonNull szl paramszl, @Nullable tbj paramtbj, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramtbj == null))
    {
      urk.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramszl.b);
      this.jdField_a_of_type_Tjy.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (spm)sqg.a(22);
    paramErrorMessage.a(paramszl.b, paramtbj);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramszl.b);
    }
    if ((paramtbj.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramszl.b, paramtbj.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjf
 * JD-Core Version:    0.7.0.1
 */