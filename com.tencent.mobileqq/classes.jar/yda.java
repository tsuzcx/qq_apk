import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribeGetRecommendUserListRequest;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class yda
  implements ycy
{
  private static String jdField_a_of_type_JavaLangString = "TopPanelPresenter";
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private ycz jdField_a_of_type_Ycz;
  
  public yda(ycz paramycz)
  {
    this.jdField_a_of_type_Ycz = paramycz;
    this.jdField_a_of_type_Ycz.setPresenter(this);
  }
  
  private List<ydn> a(CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramStGetRecommendUserListRsp.expType.get() == 0)
    {
      if (paramStGetRecommendUserListRsp.vecUser.has())
      {
        paramStGetRecommendUserListRsp = paramStGetRecommendUserListRsp.vecUser.get().iterator();
        while (paramStGetRecommendUserListRsp.hasNext()) {
          localArrayList.add(new ydn((CertifiedAccountMeta.StUser)paramStGetRecommendUserListRsp.next()));
        }
      }
    }
    else if ((paramStGetRecommendUserListRsp.expType.get() == 1) && (paramStGetRecommendUserListRsp.vecUserWithFeed.has()))
    {
      paramStGetRecommendUserListRsp = paramStGetRecommendUserListRsp.vecUserWithFeed.get().iterator();
      while (paramStGetRecommendUserListRsp.hasNext()) {
        localArrayList.add(new ydn((CertifiedAccountMeta.StFeed)paramStGetRecommendUserListRsp.next()));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = System.currentTimeMillis();
    localObject = new SubscribeGetRecommendUserListRequest((String)localObject, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt, 100, 0);
    ((SubscribeGetRecommendUserListRequest)localObject).setEnableCache(false);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new ydb(this, l));
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ycz != null)
    {
      this.jdField_a_of_type_Ycz.setPresenter(null);
      this.jdField_a_of_type_Ycz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yda
 * JD-Core Version:    0.7.0.1
 */