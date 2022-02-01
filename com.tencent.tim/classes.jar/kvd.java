import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class kvd
  implements ViewBase.OnClickListener
{
  kvd(kvc paramkvc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return;
    case 1093: 
      kxm.a(kva.a(this.a.b), kva.a(this.a.b), kyq.eD(kva.a(this.a.b).innerUniqueID));
      this.a.b.pS(2);
      this.a.b.dismiss();
      paramViewBase = new kxm.b();
      paramViewBase.j().b("wording", "" + kyq.iZ());
      ksz.a("0X8009FE8", kva.a(this.a.b), paramViewBase);
      return;
    }
    this.a.b.pS(1);
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvd
 * JD-Core Version:    0.7.0.1
 */