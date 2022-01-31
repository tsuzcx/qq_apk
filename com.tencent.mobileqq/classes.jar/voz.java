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

public class voz
  extends vpr
  implements urr<vff, vhd>
{
  private int jdField_a_of_type_Int;
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private vpm jdField_a_of_type_Vpm;
  private vps jdField_a_of_type_Vps;
  
  public voz(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.jdField_a_of_type_Vpm = new vpm(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    vpn localvpn = new vpn(this.jdField_a_of_type_Vpm);
    localvpn.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        localvpn.jdField_a_of_type_JavaUtilList.add(localBannerInfo.jdField_a_of_type_JavaLangString);
        localvpn.jdField_a_of_type_JavaUtilMap.put(localBannerInfo.jdField_a_of_type_JavaLangString, localBannerInfo.b);
      }
    }
    this.jdField_a_of_type_Vps.b(new ErrorMessage(), Collections.singletonList(localvpn), true);
  }
  
  public List<vpt> a(List<vpm> paramList)
  {
    return null;
  }
  
  public vpp a()
  {
    return new vpp(this.jdField_a_of_type_Vpm, null, null);
  }
  
  public void a() {}
  
  public void a(int paramInt, vps paramvps)
  {
    this.jdField_a_of_type_Vps = paramvps;
    paramvps = ((uvg)uwa.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramvps != null) && (paramvps.bannerInfoList.size() == paramvps.totalCount) && (paramvps.totalCount > 0))
    {
      wxe.a(this.jdField_a_of_type_JavaLangString, "get group data from cache, count:%d", Integer.valueOf(paramvps.totalCount));
      a(paramvps);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int += 1;
    xqq.a(paramString1);
    vff localvff = new vff();
    localvff.b = paramString1;
    localvff.c = paramString2;
    urp.a().a(localvff, this);
  }
  
  public void a(@NonNull vff paramvff, @Nullable vhd paramvhd, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvhd == null))
    {
      wxe.a(this.jdField_a_of_type_JavaLangString, "get banner info back failed. bannerId =%s ", paramvff.b);
      this.jdField_a_of_type_Vps.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (uvg)uwa.a(22);
    paramErrorMessage.a(paramvff.b, paramvhd);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saved banner info to db. bannerId = " + paramvff.b);
    }
    if ((paramvhd.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    a(paramvff.b, paramvhd.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voz
 * JD-Core Version:    0.7.0.1
 */