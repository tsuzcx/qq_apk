import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class qbs
  extends qdh
{
  protected String awF;
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarJob_sgi"))) {
      this.awF = ((String)k("ShareGroupAvatarJob_sgi"));
    }
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarJob", 2, paramError, new Object[0]);
    }
    sA(false);
  }
  
  protected void a(qpc paramqpc)
  {
    p("ShareGroupAvatarJob_sga", paramqpc.S());
    sA(true);
  }
  
  public void bnE()
  {
    ShareGroupItem localShareGroupItem = ((qqe)psx.a(7)).a(this.awF);
    qph localqph = (qph)psx.a(24);
    qpc localqpc = localqph.a(localShareGroupItem.headerUnionIdList);
    if (localqpc == null)
    {
      localqph.a(localShareGroupItem.headerUnionIdList, new qbt(this));
      return;
    }
    a(localqpc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbs
 * JD-Core Version:    0.7.0.1
 */