import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tpr
  extends trg
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((umv)tcz.a(7)).a(this.a);
    uks localuks = (uks)tcz.a(24);
    ukk localukk = localuks.a(localShareGroupItem.headerUnionIdList);
    if (localukk == null)
    {
      localuks.a(localShareGroupItem.headerUnionIdList, new tps(this));
      return;
    }
    a(localukk);
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
  
  protected void a(ukk paramukk)
  {
    a("ShareGroupAvatarJob_sga", paramukk.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpr
 * JD-Core Version:    0.7.0.1
 */