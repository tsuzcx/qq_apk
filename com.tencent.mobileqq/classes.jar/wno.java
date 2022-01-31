import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class wno
  implements uxu
{
  wno(wnn paramwnn, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    wsv.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      wsv.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Wnn.jdField_a_of_type_Wos != null)
      {
        this.jdField_a_of_type_Wnn.jdField_a_of_type_Wos.a(this.jdField_a_of_type_Wnn.a());
        return;
      }
      wsv.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (uro)urr.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((uro)localObject1).a((String)localObject2);
      wsv.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        wsv.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((uro)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((uro)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = wli.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((uro)localObject1).a(((StoryVideoItem)localObject2).mVid);
        wsv.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        wli.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((uro)localObject1).b(QQStoryContext.a().b());
    wnn.a(this.jdField_a_of_type_Wnn).b();
    wnn.a(this.jdField_a_of_type_Wnn).a((List)localObject1);
    wnn.a(this.jdField_a_of_type_Wnn).jdField_a_of_type_Usu = this.jdField_a_of_type_Wnn.jdField_a_of_type_Wnt.jdField_a_of_type_Usu;
    wnn.a(this.jdField_a_of_type_Wnn).b = this.jdField_a_of_type_Wnn.jdField_a_of_type_Wnt.jdField_a_of_type_Boolean;
    Collections.sort(wnn.a(this.jdField_a_of_type_Wnn).a());
    if (wnn.a(this.jdField_a_of_type_Wnn) != null) {
      wnn.a(this.jdField_a_of_type_Wnn).a(wnn.a(this.jdField_a_of_type_Wnn));
    }
    if (this.jdField_a_of_type_Wnn.jdField_a_of_type_Wos != null)
    {
      this.jdField_a_of_type_Wnn.jdField_a_of_type_Wos.a(this.jdField_a_of_type_Wnn.a());
      return;
    }
    wsv.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wno
 * JD-Core Version:    0.7.0.1
 */