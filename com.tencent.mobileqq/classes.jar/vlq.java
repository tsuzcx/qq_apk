import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class vlq
  extends vli
{
  private final MsgTabPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo;
  private final List<utx> jdField_a_of_type_JavaUtilList;
  
  public vlq(MsgTabPlayInfo paramMsgTabPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo = paramMsgTabPlayInfo;
    uuq localuuq = (uuq)vhj.a().getManager(251);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramMsgTabPlayInfo.source == 0) {
      uvv.a(localuuq.a().b(), this.jdField_a_of_type_JavaUtilList, paramMsgTabPlayInfo.nodeUnionId);
    }
  }
  
  public static vhg a(List<vhg> paramList)
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
        localObject2 = (vhg)paramList.get(i);
        if (!((vhg)localObject2).b) {
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
      if ((localObject1.jdField_a_of_type_Boolean) && (!((vhg)localObject2).jdField_a_of_type_Boolean))
      {
        return (vhg)paramList.get(i);
        label100:
        return localObject1;
      }
    }
  }
  
  public List<vlk> a(List<vld> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new vls((vlr)paramList.next()));
    }
    return localArrayList;
  }
  
  public vlg a()
  {
    Object localObject = new vlr(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    ((vlr)localObject).jdField_a_of_type_Utx = ((uuq)QQStoryContext.a().getManager(251)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.nodeUnionId);
    vlg localvlg = new vlg((vld)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mStartVideoFeedId);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids.isEmpty()) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap.isEmpty()))
    {
      localObject = new vle((vld)localObject);
      ((vle)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mVids;
      ((vle)localObject).jdField_a_of_type_JavaUtilMap = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.mFeedIdMap;
      localvlg.a = ((vle)localObject);
    }
    return localvlg;
  }
  
  public void a() {}
  
  public void a(int paramInt, vlj paramvlj)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source == 1)
    {
      localObject = ((uhu)vhj.a().getManager(197)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.uin);
      if (localObject == null) {
        break label112;
      }
      ((utx)localObject).f = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMsgTabPlayInfo.source;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
    for (;;)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(vlr.a((utx)localIterator.next()));
      }
      label112:
      wsv.d("Q.qqstory.player.data.MsgTabPlayPageLoader", "no data for header group");
    }
    paramvlj.a(new ErrorMessage(), (List)localObject, true);
  }
  
  public boolean a(vle paramvle)
  {
    if ((paramvle == null) || (!paramvle.d()))
    {
      wsv.c("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync");
      return true;
    }
    xmh.a(paramvle.jdField_a_of_type_Vld instanceof vlr);
    vlr localvlr = (vlr)paramvle.jdField_a_of_type_Vld;
    if (localvlr.jdField_a_of_type_Boolean)
    {
      wsv.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "won't needSyncVidList. groupId %s is end", localvlr.a());
      return false;
    }
    int i = localvlr.jdField_a_of_type_Int;
    if (paramvle.jdField_a_of_type_Int != i) {
      wsv.a("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList() groupId %s, position not match: %d != %d", localvlr.a(), Integer.valueOf(paramvle.jdField_a_of_type_Int), Integer.valueOf(i));
    }
    if ((i < 0) || (paramvle.jdField_a_of_type_JavaUtilList.size() - i < 10))
    {
      wsv.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramvle.jdField_a_of_type_JavaUtilList.size()), paramvle);
      return true;
    }
    wsv.b("Q.qqstory.player.data.MsgTabPlayPageLoader", "needSyncVidList. not need sync postion=%d, vidlist.size=%d, group=%s", Integer.valueOf(i), Integer.valueOf(paramvle.jdField_a_of_type_JavaUtilList.size()), paramvle);
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlq
 * JD-Core Version:    0.7.0.1
 */