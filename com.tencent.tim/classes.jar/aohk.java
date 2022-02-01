import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Comparator;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

class aohk
  implements Comparator<oidb_0xe61.BeancurdCubeInfoResult>
{
  private final wkh a;
  private final QQAppInterface app;
  private final aixa<aoho, QQAppInterface> c;
  
  public aohk(QQAppInterface paramQQAppInterface, wkh paramwkh, aixa<aoho, QQAppInterface> paramaixa)
  {
    this.app = paramQQAppInterface;
    this.a = paramwkh;
    this.c = paramaixa;
  }
  
  private int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    int i = aohm.jy((int)((oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
    paramBeancurdCubeInfoResult = ((aoho)this.c.get(this.app)).a(i);
    if (paramBeancurdCubeInfoResult != null) {
      return paramBeancurdCubeInfoResult.KG();
    }
    return 0;
  }
  
  private boolean a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    return (paramBeancurdCubeInfoResult != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.has()) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.get() != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has());
  }
  
  public int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult1, oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult2)
  {
    if ((a(paramBeancurdCubeInfoResult1)) && (a(paramBeancurdCubeInfoResult2)))
    {
      int i = a(paramBeancurdCubeInfoResult1);
      int j = a(paramBeancurdCubeInfoResult2);
      return this.a.getPriority(i) - this.a.getPriority(j);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohk
 * JD-Core Version:    0.7.0.1
 */