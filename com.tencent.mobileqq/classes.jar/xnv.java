import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xnv
  extends xmg<TroopAssistantHomeFeedPlayInfo>
{
  public xnv(TroopAssistantHomeFeedPlayInfo paramTroopAssistantHomeFeedPlayInfo)
  {
    super(paramTroopAssistantHomeFeedPlayInfo);
    paramTroopAssistantHomeFeedPlayInfo = (yme)wth.a(11);
    if (paramTroopAssistantHomeFeedPlayInfo.b != null) {
      this.a = paramTroopAssistantHomeFeedPlayInfo.b;
    }
  }
  
  public ylw a(String paramString)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ylw localylw = (ylw)localIterator.next();
      if (localylw.a.equals(paramString)) {
        return localylw;
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, int paramInt, xmy paramxmy)
  {
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramxmy.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      yuk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new xdm();
    ((xdm)localObject).a = this.a.a();
    yuk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((xdm)localObject).a);
    wow.a().a((wpa)localObject, new xnw(this, paramxmy));
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnv
 * JD-Core Version:    0.7.0.1
 */