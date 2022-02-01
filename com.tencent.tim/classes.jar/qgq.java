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

public class qgq
  extends qgz.a
  implements ppv.b<pyr, qae>
{
  private String TAG = "Q.qqstory.player.data.DiscoverBannerPlayPageLoader";
  private DiscoverBannerPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo;
  private qgz.b jdField_a_of_type_Qgz$b;
  private qgy.c d;
  private int mRequestCount;
  
  public qgq(DiscoverBannerPlayInfo paramDiscoverBannerPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo = paramDiscoverBannerPlayInfo;
    this.d = new qgy.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
  }
  
  private void a(DiscoverBannerVideoEntry paramDiscoverBannerVideoEntry)
  {
    qgy.d locald = new qgy.d(this.d);
    locald.nv = new ArrayList();
    if (paramDiscoverBannerVideoEntry != null)
    {
      paramDiscoverBannerVideoEntry = paramDiscoverBannerVideoEntry.bannerInfoList.iterator();
      while (paramDiscoverBannerVideoEntry.hasNext())
      {
        DiscoverBannerVideoEntry.BannerInfo localBannerInfo = (DiscoverBannerVideoEntry.BannerInfo)paramDiscoverBannerVideoEntry.next();
        locald.nv.add(localBannerInfo.vid);
        locald.fR.put(localBannerInfo.vid, localBannerInfo.feedId);
      }
    }
    this.jdField_a_of_type_Qgz$b.b(new ErrorMessage(), Collections.singletonList(locald), true);
  }
  
  public void a(int paramInt, qgz.b paramb)
  {
    this.jdField_a_of_type_Qgz$b = paramb;
    paramb = ((psh)psx.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId);
    if ((paramb != null) && (paramb.bannerInfoList.size() == paramb.totalCount) && (paramb.totalCount > 0))
    {
      ram.b(this.TAG, "get group data from cache, count:%d", Integer.valueOf(paramb.totalCount));
      a(paramb);
      return;
    }
    this.mRequestCount = 0;
    cv(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId, "");
  }
  
  public void a(@NonNull pyr parampyr, @Nullable qae paramqae, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramqae == null))
    {
      ram.b(this.TAG, "get banner info back failed. bannerId =%s ", parampyr.bannerId);
      this.jdField_a_of_type_Qgz$b.a(paramErrorMessage, null, false);
      return;
    }
    paramErrorMessage = (psh)psx.a(22);
    paramErrorMessage.a(parampyr.bannerId, paramqae);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "saved banner info to db. bannerId = " + parampyr.bannerId);
    }
    if ((paramqae.isEnd) || (this.mRequestCount > 10))
    {
      a(paramErrorMessage.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceDiscoverBannerPlayInfo.bannerId));
      return;
    }
    cv(parampyr.bannerId, paramqae.nextCookie);
  }
  
  public List<qgz.c> ap(List<qgy.c> paramList)
  {
    return null;
  }
  
  public qgy.f b()
  {
    return new qgy.f(this.d, null, null);
  }
  
  public void create() {}
  
  public void cv(String paramString1, String paramString2)
  {
    this.mRequestCount += 1;
    rom.sF(paramString1);
    pyr localpyr = new pyr();
    localpyr.bannerId = paramString1;
    localpyr.avV = paramString2;
    ppv.a().a(localpyr, this);
  }
  
  public void destroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgq
 * JD-Core Version:    0.7.0.1
 */