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

public class wvq
  extends JobSegment<List<xiw>, List<xiw>>
{
  wvn a;
  
  public wvq(wvn paramwvn)
  {
    this.a = paramwvn;
  }
  
  protected void a(JobContext paramJobContext, List<xiw> paramList)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.a.jdField_a_of_type_Int == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobLocalVideo", 2, "self node, check local video");
      }
      paramJobContext = (wte)wth.a(5);
      localObject1 = ((wwg)QQStoryContext.a().getManager(251)).a().a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString);
      if ((localObject1 == null) || (((wvn)localObject1).b == null) || (((wvn)localObject1).b.isEmpty())) {
        break label410;
      }
      localObject1 = ((wvn)localObject1).b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (xiw)((Iterator)localObject1).next();
        localObject3 = paramJobContext.a(((xiw)localObject2).jdField_b_of_type_JavaLangString);
        if (localObject3 != null)
        {
          ((xiw)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject3);
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
            localObject3 = new xiw();
            ((xiw)localObject3).jdField_a_of_type_Boolean = false;
            ((xiw)localObject3).jdField_a_of_type_JavaLangString = ((StoryVideoItem)localObject2).mAttachedFeedId;
            ((xiw)localObject3).jdField_b_of_type_JavaLangString = ((StoryVideoItem)localObject2).mVid;
            ((xiw)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject2);
            ((xiw)localObject3).jdField_b_of_type_Boolean = true;
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
          localObject2 = (xiw)((Iterator)localObject1).next();
          if (((xiw)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
            ((xiw)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramJobContext.a(((xiw)localObject2).jdField_b_of_type_JavaLangString);
          }
          if (((xiw)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
          {
            notifyError(new ErrorMessage(940001, "should not be null"));
            return;
          }
        }
        Collections.sort(paramList, new wvr(this));
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
 * Qualified Name:     wvq
 * JD-Core Version:    0.7.0.1
 */