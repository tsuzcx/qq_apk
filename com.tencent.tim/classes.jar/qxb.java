import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class qxb
  implements pxd.a
{
  qxb(qxa paramqxa, ArrayList paramArrayList) {}
  
  public void sx(boolean paramBoolean)
  {
    ram.w("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      ram.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.a.jdField_a_of_type_Qxo$b != null)
      {
        this.a.jdField_a_of_type_Qxo$b.si(this.a.getKey());
        return;
      }
      ram.w("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (psu)psx.a(5);
    Iterator localIterator = this.np.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((psu)localObject1).a((String)localObject2);
      ram.d("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        ram.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((psu)localObject1).a(QQStoryContext.a().getCurrentUid(), 0, localArrayList, true);
    localIterator = ((psu)localObject1).g(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = qvt.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((psu)localObject1).qV(((StoryVideoItem)localObject2).mVid);
        ram.w("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        qvt.f((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((psu)localObject1).Q(QQStoryContext.a().getCurrentUid());
    qxa.a(this.a).clear();
    qxa.a(this.a).eH((List)localObject1);
    qxa.a(this.a).a = this.a.jdField_a_of_type_Qxd$a.b;
    qxa.a(this.a).aFS = this.a.jdField_a_of_type_Qxd$a.aFS;
    Collections.sort(qxa.a(this.a).bu());
    if (qxa.a(this.a) != null) {
      qxa.a(this.a).a(qxa.a(this.a));
    }
    if (this.a.jdField_a_of_type_Qxo$b != null)
    {
      this.a.jdField_a_of_type_Qxo$b.si(this.a.getKey());
      return;
    }
    ram.w("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxb
 * JD-Core Version:    0.7.0.1
 */