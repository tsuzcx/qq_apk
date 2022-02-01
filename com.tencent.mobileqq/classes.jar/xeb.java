import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import java.util.Iterator;
import java.util.List;

public class xeb
  extends xcm<TroopAssistantHomeFeedPlayInfo>
{
  public xeb(TroopAssistantHomeFeedPlayInfo paramTroopAssistantHomeFeedPlayInfo)
  {
    super(paramTroopAssistantHomeFeedPlayInfo);
    paramTroopAssistantHomeFeedPlayInfo = (yck)wjs.a(11);
    if (paramTroopAssistantHomeFeedPlayInfo.b != null) {
      this.a = paramTroopAssistantHomeFeedPlayInfo.b;
    }
  }
  
  public ycc a(String paramString)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ycc localycc = (ycc)localIterator.next();
      if (localycc.a.equals(paramString)) {
        return localycc;
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, int paramInt, xde paramxde)
  {
    Object localObject = this.a.jdField_a_of_type_JavaUtilList;
    if ((paramBoolean) && (((List)localObject).size() > 0))
    {
      List localList = b((List)localObject);
      paramxde.a(new ErrorMessage(), localList, this.a.jdField_a_of_type_Boolean);
      ykq.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "return cache data size %d", Integer.valueOf(((List)localObject).size()));
      return;
    }
    localObject = new wtx();
    ((wtx)localObject).a = this.a.a();
    ykq.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "start request next feed id list with cookie %s", ((wtx)localObject).a);
    wfi.a().a((wfm)localObject, new xec(this, paramxde));
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xeb
 * JD-Core Version:    0.7.0.1
 */