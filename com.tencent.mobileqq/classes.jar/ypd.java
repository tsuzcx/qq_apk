import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ypd
  implements wzk
{
  ypd(ypc paramypc, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    yuk.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      yuk.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Ypc.jdField_a_of_type_Yqh != null)
      {
        this.jdField_a_of_type_Ypc.jdField_a_of_type_Yqh.a(this.jdField_a_of_type_Ypc.a());
        return;
      }
      yuk.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (wte)wth.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((wte)localObject1).a((String)localObject2);
      yuk.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        yuk.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((wte)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((wte)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = ymx.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((wte)localObject1).a(((StoryVideoItem)localObject2).mVid);
        yuk.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        ymx.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((wte)localObject1).b(QQStoryContext.a().b());
    ypc.a(this.jdField_a_of_type_Ypc).b();
    ypc.a(this.jdField_a_of_type_Ypc).a((List)localObject1);
    ypc.a(this.jdField_a_of_type_Ypc).jdField_a_of_type_Wuk = this.jdField_a_of_type_Ypc.jdField_a_of_type_Ypi.jdField_a_of_type_Wuk;
    ypc.a(this.jdField_a_of_type_Ypc).b = this.jdField_a_of_type_Ypc.jdField_a_of_type_Ypi.jdField_a_of_type_Boolean;
    Collections.sort(ypc.a(this.jdField_a_of_type_Ypc).a());
    if (ypc.a(this.jdField_a_of_type_Ypc) != null) {
      ypc.a(this.jdField_a_of_type_Ypc).a(ypc.a(this.jdField_a_of_type_Ypc));
    }
    if (this.jdField_a_of_type_Ypc.jdField_a_of_type_Yqh != null)
    {
      this.jdField_a_of_type_Ypc.jdField_a_of_type_Yqh.a(this.jdField_a_of_type_Ypc.a());
      return;
    }
    yuk.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypd
 * JD-Core Version:    0.7.0.1
 */