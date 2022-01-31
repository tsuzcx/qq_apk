import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class vis
  extends vkh
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((wfw)uwa.a(7)).a(this.a);
    wdt localwdt = (wdt)uwa.a(24);
    wdl localwdl = localwdt.a(localShareGroupItem.headerUnionIdList);
    if (localwdl == null)
    {
      localwdt.a(localShareGroupItem.headerUnionIdList, new vit(this));
      return;
    }
    a(localwdl);
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarJob", 2, paramError, new Object[0]);
    }
    b(false);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarJob_sgi"))) {
      this.a = ((String)a("ShareGroupAvatarJob_sgi"));
    }
  }
  
  protected void a(wdl paramwdl)
  {
    a("ShareGroupAvatarJob_sga", paramwdl.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vis
 * JD-Core Version:    0.7.0.1
 */