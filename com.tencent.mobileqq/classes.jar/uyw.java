import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class uyw
  implements tjc
{
  uyw(uyv paramuyv, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    ved.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ved.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Uyv.jdField_a_of_type_Vaa != null)
      {
        this.jdField_a_of_type_Uyv.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyv.a());
        return;
      }
      ved.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (tcw)tcz.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((tcw)localObject1).a((String)localObject2);
      ved.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        ved.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((tcw)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((tcw)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = uwq.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((tcw)localObject1).a(((StoryVideoItem)localObject2).mVid);
        ved.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        uwq.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((tcw)localObject1).b(QQStoryContext.a().b());
    uyv.a(this.jdField_a_of_type_Uyv).b();
    uyv.a(this.jdField_a_of_type_Uyv).a((List)localObject1);
    uyv.a(this.jdField_a_of_type_Uyv).jdField_a_of_type_Tec = this.jdField_a_of_type_Uyv.jdField_a_of_type_Uzb.jdField_a_of_type_Tec;
    uyv.a(this.jdField_a_of_type_Uyv).b = this.jdField_a_of_type_Uyv.jdField_a_of_type_Uzb.jdField_a_of_type_Boolean;
    Collections.sort(uyv.a(this.jdField_a_of_type_Uyv).a());
    if (uyv.a(this.jdField_a_of_type_Uyv) != null) {
      uyv.a(this.jdField_a_of_type_Uyv).a(uyv.a(this.jdField_a_of_type_Uyv));
    }
    if (this.jdField_a_of_type_Uyv.jdField_a_of_type_Vaa != null)
    {
      this.jdField_a_of_type_Uyv.jdField_a_of_type_Vaa.a(this.jdField_a_of_type_Uyv.a());
      return;
    }
    ved.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyw
 * JD-Core Version:    0.7.0.1
 */