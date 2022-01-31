import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tpu
  extends trj
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((umy)tdc.a(7)).a(this.a);
    ukv localukv = (ukv)tdc.a(24);
    ukn localukn = localukv.a(localShareGroupItem.headerUnionIdList);
    if (localukn == null)
    {
      localukv.a(localShareGroupItem.headerUnionIdList, new tpv(this));
      return;
    }
    a(localukn);
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
  
  protected void a(ukn paramukn)
  {
    a("ShareGroupAvatarJob_sga", paramukn.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpu
 * JD-Core Version:    0.7.0.1
 */