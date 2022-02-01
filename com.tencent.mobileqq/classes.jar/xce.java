import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class xce
  extends xdt
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((xzh)wpm.a(7)).a(this.a);
    xxe localxxe = (xxe)wpm.a(24);
    xww localxww = localxxe.a(localShareGroupItem.headerUnionIdList);
    if (localxww == null)
    {
      localxxe.a(localShareGroupItem.headerUnionIdList, new xcf(this));
      return;
    }
    a(localxww);
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
  
  protected void a(xww paramxww)
  {
    a("ShareGroupAvatarJob_sga", paramxww.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xce
 * JD-Core Version:    0.7.0.1
 */