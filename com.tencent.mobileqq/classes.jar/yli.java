import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class yli
  implements wvp
{
  yli(ylh paramylh, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    yqp.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      yqp.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Ylh.jdField_a_of_type_Ymm != null)
      {
        this.jdField_a_of_type_Ylh.jdField_a_of_type_Ymm.a(this.jdField_a_of_type_Ylh.a());
        return;
      }
      yqp.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (wpj)wpm.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((wpj)localObject1).a((String)localObject2);
      yqp.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        yqp.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((wpj)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((wpj)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = yjc.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((wpj)localObject1).a(((StoryVideoItem)localObject2).mVid);
        yqp.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        yjc.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((wpj)localObject1).b(QQStoryContext.a().b());
    ylh.a(this.jdField_a_of_type_Ylh).b();
    ylh.a(this.jdField_a_of_type_Ylh).a((List)localObject1);
    ylh.a(this.jdField_a_of_type_Ylh).jdField_a_of_type_Wqp = this.jdField_a_of_type_Ylh.jdField_a_of_type_Yln.jdField_a_of_type_Wqp;
    ylh.a(this.jdField_a_of_type_Ylh).b = this.jdField_a_of_type_Ylh.jdField_a_of_type_Yln.jdField_a_of_type_Boolean;
    Collections.sort(ylh.a(this.jdField_a_of_type_Ylh).a());
    if (ylh.a(this.jdField_a_of_type_Ylh) != null) {
      ylh.a(this.jdField_a_of_type_Ylh).a(ylh.a(this.jdField_a_of_type_Ylh));
    }
    if (this.jdField_a_of_type_Ylh.jdField_a_of_type_Ymm != null)
    {
      this.jdField_a_of_type_Ylh.jdField_a_of_type_Ymm.a(this.jdField_a_of_type_Ylh.a());
      return;
    }
    yqp.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yli
 * JD-Core Version:    0.7.0.1
 */