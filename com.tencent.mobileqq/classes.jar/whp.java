import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class whp
  extends wje
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((xen)vux.a(7)).a(this.a);
    if (localShareGroupItem == null) {
      return;
    }
    xck localxck = (xck)vux.a(24);
    xcc localxcc = localxck.a(localShareGroupItem.headerUnionIdList);
    if (localxcc == null)
    {
      localxck.a(localShareGroupItem.headerUnionIdList, new whq(this));
      return;
    }
    a(localxcc);
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
  
  protected void a(xcc paramxcc)
  {
    a("ShareGroupAvatarJob_sga", paramxcc.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whp
 * JD-Core Version:    0.7.0.1
 */