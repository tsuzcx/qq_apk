import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vxg
  extends JobSegment<List<wkm>, List<wkm>>
{
  vxd a;
  
  public vxg(vxd paramvxd)
  {
    this.a = paramvxd;
  }
  
  protected void a(JobContext paramJobContext, List<wkm> paramList)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.a.jdField_a_of_type_Int == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobLocalVideo", 2, "self node, check local video");
      }
      paramJobContext = (vuu)vux.a(5);
      localObject1 = ((vxw)QQStoryContext.a().getManager(251)).a().a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString);
      if ((localObject1 == null) || (((vxd)localObject1).b == null) || (((vxd)localObject1).b.isEmpty())) {
        break label410;
      }
      localObject1 = ((vxd)localObject1).b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wkm)((Iterator)localObject1).next();
        localObject3 = paramJobContext.a(((wkm)localObject2).jdField_b_of_type_JavaLangString);
        if (localObject3 != null)
        {
          ((wkm)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject3);
          paramList.add(localObject2);
        }
      }
    }
    label410:
    for (int i = 1;; i = 0)
    {
      localObject1 = paramJobContext.a(false);
      int j = i;
      if (localObject1 != null)
      {
        j = i;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
            localObject3 = new wkm();
            ((wkm)localObject3).jdField_a_of_type_Boolean = false;
            ((wkm)localObject3).jdField_a_of_type_JavaLangString = ((StoryVideoItem)localObject2).mAttachedFeedId;
            ((wkm)localObject3).jdField_b_of_type_JavaLangString = ((StoryVideoItem)localObject2).mVid;
            ((wkm)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject2);
            ((wkm)localObject3).jdField_b_of_type_Boolean = true;
            paramList.add(localObject3);
          }
          j = 1;
        }
      }
      if (j != 0)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (wkm)((Iterator)localObject1).next();
          if (((wkm)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
            ((wkm)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramJobContext.a(((wkm)localObject2).jdField_b_of_type_JavaLangString);
          }
          if (((wkm)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            notifyError(new ErrorMessage(940001, "should not be null"));
            return;
          }
        }
        Collections.sort(paramList, new vxh(this));
      }
      if (paramList.isEmpty())
      {
        notifyError(new ErrorMessage(103, "nodeInfo not valid"));
        return;
      }
      notifyResult(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxg
 * JD-Core Version:    0.7.0.1
 */