import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class xdl
  extends xdd
{
  private final MsgTabPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo;
  private final List<wly> jdField_a_of_type_JavaUtilList;
  
  public xdl(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo = paramMsgTabPlayInfo;
    wmr localwmr = (wmr)wzk.a().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      wnw.a(localwmr.a().b(), this.jdField_a_of_type_JavaUtilList, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static wzh a(List<wzh> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    int i;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        int j = paramList.size();
        i = 0;
        localObject1 = null;
        if (i >= j) {
          break label100;
        }
        localObject2 = (wzh)paramList.get(i);
        if (!((wzh)localObject2).b) {
          break label60;
        }
      }
    }
    return localObject2;
    label60:
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject1.jdField_a_of_type_Boolean) && (!((wzh)localObject2).jdField_a_of_type_Boolean))
      {
        return (wzh)paramList.get(i);
        label100:
        return localObject1;
      }
    }
  }
  
  public List<xdf> a(List<xcy> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new xdn((xdm)paramList.next()));
    }
    return localArrayList;
  }
  
  public xdb a()
  {
    Object localObject = new xdm(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    ((xdm)localObject).jdField_a_of_type_Wly = ((wmr)QQStoryContext.a().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    xdb localxdb = new xdb((xcy)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVideoFeedId);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap.isEmpty()))
    {
      localObject = new xcz((xcy)localObject);
      ((xcz)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids;
      ((xcz)localObject).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap;
      localxdb.a = ((xcz)localObject);
    }
    return localxdb;
  }
  
  public void a() {}
  
  public void a(int paramInt, xde paramxde)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source == 1)
    {
      localObject = ((wae)wzk.a().getManager(QQManagerFactory.STORY_HALO_MANAGER)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.uin);
      if (localObject == null) {
        break label112;
      }
      ((wly)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(xdm.a((wly)localIterator.next()));
      }
      label112:
      ykq.d("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
    }
    paramxde.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(xcz paramxcz)
  {
    if ((paramxcz == null) || (!paramxcz.d()))
    {
      ykq.c("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
      return true;
    }
    zdl.a(paramxcz.jdField_a_of_type_Xcy instanceof xdm);
    xdm localxdm = (xdm)paramxcz.jdField_a_of_type_Xcy;
    if (localxdm.jdField_a_of_type_Boolean)
    {
      ykq.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", localxdm.a());
      return false;
    }
    int i = localxdm.jdField_a_of_type_Int;
    if (paramxcz.jdField_a_of_type_Int != i) {
      ykq.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", localxdm.a(), Integer.valueOf(paramxcz.jdField_a_of_type_Int), Integer.valueOf(i));
    }
    if ((i < 0) || (paramxcz.jdField_a_of_type_JavaUtilList.size() - i < 10))
    {
      ykq.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramxcz.jdField_a_of_type_JavaUtilList.size()), paramxcz);
      return true;
    }
    ykq.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramxcz.jdField_a_of_type_JavaUtilList.size()), paramxcz);
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdl
 * JD-Core Version:    0.7.0.1
 */