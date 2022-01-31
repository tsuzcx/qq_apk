import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class vmg
  extends vkr<TroopAssistantHomeFeedPlayInfo>
{
  public vmg(TroopAssistantHomeFeedPlayInfo paramTroopAssistantHomeFeedPlayInfo)
  {
    super(paramTroopAssistantHomeFeedPlayInfo);
    paramTroopAssistantHomeFeedPlayInfo = (wkp)urr.a(11);
    if (paramTroopAssistantHomeFeedPlayInfo.b != null) {
      this.a = paramTroopAssistantHomeFeedPlayInfo.b;
    }
  }
  
  public wkh a(String paramString)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wkh localwkh = (wkh)localIterator.next();
      if (localwkh.a.equals(paramString)) {
        return localwkh;
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, int paramInt, vlj paramvlj)
  {
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramvlj.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      wsv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new vbw();
    ((vbw)localObject).a = this.a.a();
    wsv.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((vbw)localObject).a);
    ung.a().a((unk)localObject, new vmh(this, paramvlj));
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmg
 * JD-Core Version:    0.7.0.1
 */