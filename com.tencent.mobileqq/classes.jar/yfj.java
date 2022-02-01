import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class yfj
  implements wpv
{
  yfj(yfi paramyfi, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    ykq.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ykq.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Yfi.jdField_a_of_type_Ygn != null)
      {
        this.jdField_a_of_type_Yfi.jdField_a_of_type_Ygn.a(this.jdField_a_of_type_Yfi.a());
        return;
      }
      ykq.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (wjp)wjs.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((wjp)localObject1).a((String)localObject2);
      ykq.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        ykq.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((wjp)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((wjp)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = ydd.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((wjp)localObject1).a(((StoryVideoItem)localObject2).mVid);
        ykq.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        ydd.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((wjp)localObject1).b(QQStoryContext.a().b());
    yfi.a(this.jdField_a_of_type_Yfi).b();
    yfi.a(this.jdField_a_of_type_Yfi).a((List)localObject1);
    yfi.a(this.jdField_a_of_type_Yfi).jdField_a_of_type_Wkv = this.jdField_a_of_type_Yfi.jdField_a_of_type_Yfo.jdField_a_of_type_Wkv;
    yfi.a(this.jdField_a_of_type_Yfi).b = this.jdField_a_of_type_Yfi.jdField_a_of_type_Yfo.jdField_a_of_type_Boolean;
    Collections.sort(yfi.a(this.jdField_a_of_type_Yfi).a());
    if (yfi.a(this.jdField_a_of_type_Yfi) != null) {
      yfi.a(this.jdField_a_of_type_Yfi).a(yfi.a(this.jdField_a_of_type_Yfi));
    }
    if (this.jdField_a_of_type_Yfi.jdField_a_of_type_Ygn != null)
    {
      this.jdField_a_of_type_Yfi.jdField_a_of_type_Ygn.a(this.jdField_a_of_type_Yfi.a());
      return;
    }
    ykq.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfj
 * JD-Core Version:    0.7.0.1
 */