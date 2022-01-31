import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class vej
  extends vfy
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((wbn)urr.a(7)).a(this.a);
    vzk localvzk = (vzk)urr.a(24);
    vzc localvzc = localvzk.a(localShareGroupItem.headerUnionIdList);
    if (localvzc == null)
    {
      localvzk.a(localShareGroupItem.headerUnionIdList, new vek(this));
      return;
    }
    a(localvzc);
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
  
  protected void a(vzc paramvzc)
  {
    a("ShareGroupAvatarJob_sga", paramvzc.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vej
 * JD-Core Version:    0.7.0.1
 */