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

public class wnq
  extends woi
  implements vqp<wec, wga>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private wod jdField_a_of_type_Wod;
  private woj jdField_a_of_type_Woj;
  
  public wnq(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Wod = new wod(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    woe localwoe = new woe(this.jdField_a_of_type_Wod);
    localwoe.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localwoe.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localwoe.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Woj.b(new ErrorMessage(), Collections.singletonList(localwoe), true);
  }
  
  public List<wok> a(List<wod> paramList)
  {
    return null;
  }
  
  public wog a()
  {
    return new wog(this.jdField_a_of_type_Wod, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, woj paramwoj)
  {
    this.jdField_a_of_type_Woj = paramwoj;
    paramwoj = ((vud)vux.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramwoj != null) && (paramwoj.bannerInfoList.size() == paramwoj.totalCount) && (paramwoj.totalCount > 0))
    {
      xvv.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramwoj.totalCount));
      a(paramwoj);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    yos.a(paramString1);
    wec localwec = new wec();
    localwec.b = paramString1;
    localwec.c = paramString2;
    vqn.a().a(localwec, this);
  }
  
  public void a(@NonNull wec paramwec, @Nullable wga paramwga, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwga == null))
    {
      xvv.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramwec.b);
      this.jdField_a_of_type_Woj.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (vud)vux.a(22);
    paramErrorMessage.a(paramwec.b, paramwga);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramwec.b);
    }
    if ((paramwga.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramwec.b, paramwga.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnq
 * JD-Core Version:    0.7.0.1
 */