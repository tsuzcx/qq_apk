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

public class vkq
  extends vli
  implements uni<vaw, vcu>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private vld jdField_a_of_type_Vld;
  private vlj jdField_a_of_type_Vlj;
  
  public vkq(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Vld = new vld(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    vle localvle = new vle(this.jdField_a_of_type_Vld);
    localvle.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localvle.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localvle.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Vlj.b(new ErrorMessage(), Collections.singletonList(localvle), true);
  }
  
  public List<vlk> a(List<vld> paramList)
  {
    return null;
  }
  
  public vlg a()
  {
    return new vlg(this.jdField_a_of_type_Vld, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, vlj paramvlj)
  {
    this.jdField_a_of_type_Vlj = paramvlj;
    paramvlj = ((uqx)urr.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramvlj != null) && (paramvlj.bannerInfoList.size() == paramvlj.totalCount) && (paramvlj.totalCount > 0))
    {
      wsv.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramvlj.totalCount));
      a(paramvlj);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    xmh.a(paramString1);
    vaw localvaw = new vaw();
    localvaw.b = paramString1;
    localvaw.c = paramString2;
    ung.a().a(localvaw, this);
  }
  
  public void a(@NonNull vaw paramvaw, @Nullable vcu paramvcu, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvcu == null))
    {
      wsv.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramvaw.b);
      this.jdField_a_of_type_Vlj.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (uqx)urr.a(22);
    paramErrorMessage.a(paramvaw.b, paramvcu);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramvaw.b);
    }
    if ((paramvcu.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramvaw.b, paramvcu.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkq
 * JD-Core Version:    0.7.0.1
 */