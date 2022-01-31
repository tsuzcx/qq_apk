import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class txo
  extends tvz<TroopAssistantHomeFeedPlayInfo>
{
  public txo(TroopAssistantHomeFeedPlayInfo paramTroopAssistantHomeFeedPlayInfo)
  {
    super(paramTroopAssistantHomeFeedPlayInfo);
    paramTroopAssistantHomeFeedPlayInfo = (uvx)tcz.a(11);
    if (paramTroopAssistantHomeFeedPlayInfo.b != null) {
      this.a = paramTroopAssistantHomeFeedPlayInfo.b;
    }
  }
  
  public uvp a(String paramString)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uvp localuvp = (uvp)localIterator.next();
      if (localuvp.a.equals(paramString)) {
        return localuvp;
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, int paramInt, twr paramtwr)
  {
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramtwr.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      ved.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new tne();
    ((tne)localObject).a = this.a.a();
    ved.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((tne)localObject).a);
    syo.a().a((sys)localObject, new txp(this, paramtwr));
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txo
 * JD-Core Version:    0.7.0.1
 */