import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class wrx
  implements vcd
{
  wrx(wrw paramwrw, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    wxe.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      wxe.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.jdField_a_of_type_Wrw.jdField_a_of_type_Wtb != null)
      {
        this.jdField_a_of_type_Wrw.jdField_a_of_type_Wtb.a(this.jdField_a_of_type_Wrw.a());
        return;
      }
      wxe.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (uvx)uwa.a(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((uvx)localObject1).a((String)localObject2);
      wxe.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        wxe.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((uvx)localObject1).a(QQStoryContext.a().b(), 0, localArrayList, true);
    localIterator = ((uvx)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = wpr.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((uvx)localObject1).a(((StoryVideoItem)localObject2).mVid);
        wxe.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        wpr.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((uvx)localObject1).b(QQStoryContext.a().b());
    wrw.a(this.jdField_a_of_type_Wrw).b();
    wrw.a(this.jdField_a_of_type_Wrw).a((List)localObject1);
    wrw.a(this.jdField_a_of_type_Wrw).jdField_a_of_type_Uxd = this.jdField_a_of_type_Wrw.jdField_a_of_type_Wsc.jdField_a_of_type_Uxd;
    wrw.a(this.jdField_a_of_type_Wrw).b = this.jdField_a_of_type_Wrw.jdField_a_of_type_Wsc.jdField_a_of_type_Boolean;
    Collections.sort(wrw.a(this.jdField_a_of_type_Wrw).a());
    if (wrw.a(this.jdField_a_of_type_Wrw) != null) {
      wrw.a(this.jdField_a_of_type_Wrw).a(wrw.a(this.jdField_a_of_type_Wrw));
    }
    if (this.jdField_a_of_type_Wrw.jdField_a_of_type_Wtb != null)
    {
      this.jdField_a_of_type_Wrw.jdField_a_of_type_Wtb.a(this.jdField_a_of_type_Wrw.a());
      return;
    }
    wxe.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrx
 * JD-Core Version:    0.7.0.1
 */