import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class wwk
  extends wxz
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((xti)wjs.a(7)).a(this.a);
    if (localShareGroupItem == null) {
      return;
    }
    xrf localxrf = (xrf)wjs.a(24);
    xqx localxqx = localxrf.a(localShareGroupItem.headerUnionIdList);
    if (localxqx == null)
    {
      localxrf.a(localShareGroupItem.headerUnionIdList, new wwl(this));
      return;
    }
    a(localxqx);
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
  
  protected void a(xqx paramxqx)
  {
    a("ShareGroupAvatarJob_sga", paramxqx.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwk
 * JD-Core Version:    0.7.0.1
 */