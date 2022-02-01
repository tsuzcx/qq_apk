import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class xfz
  extends xho
{
  protected String a;
  
  public void a()
  {
    ShareGroupItem localShareGroupItem = ((ydc)wth.a(7)).a(this.a);
    yaz localyaz = (yaz)wth.a(24);
    yar localyar = localyaz.a(localShareGroupItem.headerUnionIdList);
    if (localyar == null)
    {
      localyaz.a(localShareGroupItem.headerUnionIdList, new xga(this));
      return;
    }
    a(localyar);
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
  
  protected void a(yar paramyar)
  {
    a("ShareGroupAvatarJob_sga", paramyar.a());
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfz
 * JD-Core Version:    0.7.0.1
 */