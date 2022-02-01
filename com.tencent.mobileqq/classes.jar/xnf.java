import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class xnf
  extends xmx
{
  private final MsgTabPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo;
  private final List<wvn> jdField_a_of_type_JavaUtilList;
  
  public xnf(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo = paramMsgTabPlayInfo;
    wwg localwwg = (wwg)xiz.a().getManager(251);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      wxl.a(localwwg.a().b(), this.jdField_a_of_type_JavaUtilList, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static xiw a(List<xiw> paramList)
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
        localObject2 = (xiw)paramList.get(i);
        if (!((xiw)localObject2).b) {
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
      if ((localObject1.jdField_a_of_type_Boolean) && (!((xiw)localObject2).jdField_a_of_type_Boolean))
      {
        return (xiw)paramList.get(i);
        label100:
        return localObject1;
      }
    }
  }
  
  public List<xmz> a(List<xms> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new xnh((xng)paramList.next()));
    }
    return localArrayList;
  }
  
  public xmv a()
  {
    Object localObject = new xng(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    ((xng)localObject).jdField_a_of_type_Wvn = ((wwg)QQStoryContext.a().getManager(251)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    xmv localxmv = new xmv((xms)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVideoFeedId);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap.isEmpty()))
    {
      localObject = new xmt((xms)localObject);
      ((xmt)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids;
      ((xmt)localObject).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap;
      localxmv.a = ((xmt)localObject);
    }
    return localxmv;
  }
  
  public void a() {}
  
  public void a(int paramInt, xmy paramxmy)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source == 1)
    {
      localObject = ((wjk)xiz.a().getManager(197)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.uin);
      if (localObject == null) {
        break label112;
      }
      ((wvn)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(xng.a((wvn)localIterator.next()));
      }
      label112:
      yuk.d("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
    }
    paramxmy.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(xmt paramxmt)
  {
    if ((paramxmt == null) || (!paramxmt.d()))
    {
      yuk.c("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
      return true;
    }
    znw.a(paramxmt.jdField_a_of_type_Xms instanceof xng);
    xng localxng = (xng)paramxmt.jdField_a_of_type_Xms;
    if (localxng.jdField_a_of_type_Boolean)
    {
      yuk.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", localxng.a());
      return false;
    }
    int i = localxng.jdField_a_of_type_Int;
    if (paramxmt.jdField_a_of_type_Int != i) {
      yuk.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", localxng.a(), Integer.valueOf(paramxmt.jdField_a_of_type_Int), Integer.valueOf(i));
    }
    if ((i < 0) || (paramxmt.jdField_a_of_type_JavaUtilList.size() - i < 10))
    {
      yuk.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramxmt.jdField_a_of_type_JavaUtilList.size()), paramxmt);
      return true;
    }
    yuk.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramxmt.jdField_a_of_type_JavaUtilList.size()), paramxmt);
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */