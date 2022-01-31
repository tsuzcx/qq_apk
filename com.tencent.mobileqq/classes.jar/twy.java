import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class twy
  extends twq
{
  private final MsgTabPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo;
  private final List<tff> jdField_a_of_type_JavaUtilList;
  
  public twy(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo = paramMsgTabPlayInfo;
    tfy localtfy = (tfy)tsr.a().getManager(251);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      thd.a(localtfy.a().b(), this.jdField_a_of_type_JavaUtilList, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static tso a(List<tso> paramList)
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
        localObject2 = (tso)paramList.get(i);
        if (!((tso)localObject2).b) {
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
      if ((localObject1.jdField_a_of_type_Boolean) && (!((tso)localObject2).jdField_a_of_type_Boolean))
      {
        return (tso)paramList.get(i);
        label100:
        return localObject1;
      }
    }
  }
  
  public List<tws> a(List<twl> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new txa((twz)paramList.next()));
    }
    return localArrayList;
  }
  
  public two a()
  {
    Object localObject = new twz(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    ((twz)localObject).jdField_a_of_type_Tff = ((tfy)QQStoryContext.a().getManager(251)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    two localtwo = new two((twl)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVideoFeedId);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap.isEmpty()))
    {
      localObject = new twm((twl)localObject);
      ((twm)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids;
      ((twm)localObject).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap;
      localtwo.a = ((twm)localObject);
    }
    return localtwo;
  }
  
  public void a() {}
  
  public void a(int paramInt, twr paramtwr)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source == 1)
    {
      localObject = ((stc)tsr.a().getManager(197)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.uin);
      if (localObject == null) {
        break label112;
      }
      ((tff)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(twz.a((tff)localIterator.next()));
      }
      label112:
      ved.d("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
    }
    paramtwr.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(twm paramtwm)
  {
    if ((paramtwm == null) || (!paramtwm.d()))
    {
      ved.c("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
      return true;
    }
    vxp.a(paramtwm.jdField_a_of_type_Twl instanceof twz);
    twz localtwz = (twz)paramtwm.jdField_a_of_type_Twl;
    if (localtwz.jdField_a_of_type_Boolean)
    {
      ved.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", localtwz.a());
      return false;
    }
    int i = localtwz.jdField_a_of_type_Int;
    if (paramtwm.jdField_a_of_type_Int != i) {
      ved.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", localtwz.a(), Integer.valueOf(paramtwm.jdField_a_of_type_Int), Integer.valueOf(i));
    }
    if ((i < 0) || (paramtwm.jdField_a_of_type_JavaUtilList.size() - i < 10))
    {
      ved.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramtwm.jdField_a_of_type_JavaUtilList.size()), paramtwm);
      return true;
    }
    ved.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramtwm.jdField_a_of_type_JavaUtilList.size()), paramtwm);
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twy
 * JD-Core Version:    0.7.0.1
 */