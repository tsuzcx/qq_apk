import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class umd
  implements swj
{
  umd(umc paramumc, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    urk.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      urk.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Umc.jdField_a_of_type_Unh != null)
      {
        this.jdField_a_of_type_Umc.jdField_a_of_type_Unh.a(this.jdField_a_of_type_Umc.a());
        return;
      }
      urk.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (sqd)sqg.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((sqd)localObject1).a((String)localObject2);
      urk.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        urk.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((sqd)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((sqd)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = ujx.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((sqd)localObject1).a(((StoryVideoItem)localObject2).mVid);
        urk.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        ujx.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((sqd)localObject1).b(QQStoryContext.a().b());
    umc.a(this.jdField_a_of_type_Umc).b();
    umc.a(this.jdField_a_of_type_Umc).a((List)localObject1);
    umc.a(this.jdField_a_of_type_Umc).jdField_a_of_type_Srj = this.jdField_a_of_type_Umc.jdField_a_of_type_Umi.jdField_a_of_type_Srj;
    umc.a(this.jdField_a_of_type_Umc).b = this.jdField_a_of_type_Umc.jdField_a_of_type_Umi.jdField_a_of_type_Boolean;
    Collections.sort(umc.a(this.jdField_a_of_type_Umc).a());
    if (umc.a(this.jdField_a_of_type_Umc) != null) {
      umc.a(this.jdField_a_of_type_Umc).a(umc.a(this.jdField_a_of_type_Umc));
    }
    if (this.jdField_a_of_type_Umc.jdField_a_of_type_Unh != null)
    {
      this.jdField_a_of_type_Umc.jdField_a_of_type_Unh.a(this.jdField_a_of_type_Umc.a());
      return;
    }
    urk.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umd
 * JD-Core Version:    0.7.0.1
 */