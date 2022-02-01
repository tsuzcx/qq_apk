import android.graphics.RectF;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchDetail;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSkuItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch.Rectangle;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class adin
  extends adhi
  implements adhj.a
{
  public static final String btf = acfp.m(2131702862);
  public adin.c a;
  public adin.f a;
  public adin.g[] a;
  public String btg = "";
  public int cGR;
  public int iRetCode;
  public int retCode = -1;
  public String retMsg;
  public String sMsg;
  public String skey;
  public long timeStamp;
  
  public adin()
  {
    super(2, 0);
  }
  
  public static adin.c a(JDSearch.JdSearchRsp paramJdSearchRsp)
  {
    int j = -1;
    float f2 = 0.0F;
    adin.c localc = new adin.c();
    int i;
    Object localObject1;
    label57:
    label106:
    Object localObject2;
    label132:
    label158:
    float f1;
    label212:
    label243:
    adin.b localb;
    if (paramJdSearchRsp.jd_search_errorcode.has())
    {
      i = paramJdSearchRsp.jd_search_errorcode.get();
      localc.cGS = i;
      if (!paramJdSearchRsp.jd_search_errormsg.has()) {
        break label633;
      }
      localObject1 = paramJdSearchRsp.jd_search_errormsg.get();
      localc.btk = ((String)localObject1);
      if (!paramJdSearchRsp.jd_search_detail.has()) {
        break label707;
      }
      localObject1 = (JDSearch.JdSearchDetail)paramJdSearchRsp.jd_search_detail.get();
      if (!((JDSearch.JdSearchDetail)localObject1).errorcode.has()) {
        break label640;
      }
      i = ((JDSearch.JdSearchDetail)localObject1).errorcode.get();
      localc.errCode = i;
      if (!((JDSearch.JdSearchDetail)localObject1).errormsg.has()) {
        break label645;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).errormsg.get();
      localc.errMsg = paramJdSearchRsp;
      if (!((JDSearch.JdSearchDetail)localObject1).jd_more_url.has()) {
        break label651;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_more_url.get();
      localc.moreUrl = paramJdSearchRsp;
      if (((JDSearch.JdSearchDetail)localObject1).rectangle.has())
      {
        paramJdSearchRsp = (JDSearch.Rectangle)((JDSearch.JdSearchDetail)localObject1).rectangle.get();
        localObject2 = localc.au;
        if (!paramJdSearchRsp.left.has()) {
          break label657;
        }
        f1 = paramJdSearchRsp.left.get();
        ((RectF)localObject2).left = f1;
        localObject2 = localc.au;
        if (!paramJdSearchRsp.top.has()) {
          break label662;
        }
        f1 = paramJdSearchRsp.top.get();
        ((RectF)localObject2).top = f1;
        localObject2 = localc.au;
        if (!paramJdSearchRsp.right.has()) {
          break label667;
        }
        f1 = paramJdSearchRsp.right.get();
        label274:
        ((RectF)localObject2).right = f1;
        localObject2 = localc.au;
        f1 = f2;
        if (paramJdSearchRsp.bottom.has()) {
          f1 = paramJdSearchRsp.bottom.get();
        }
        ((RectF)localObject2).bottom = f1;
        i = j;
        if (paramJdSearchRsp.is_user_rectangle.has()) {
          i = paramJdSearchRsp.is_user_rectangle.get();
        }
        localc.cGT = i;
      }
      if (!((JDSearch.JdSearchDetail)localObject1).jd_sku_item.has()) {
        break label672;
      }
      paramJdSearchRsp = ((JDSearch.JdSearchDetail)localObject1).jd_sku_item.get();
      label360:
      if ((paramJdSearchRsp != null) && (!paramJdSearchRsp.isEmpty())) {
        localc.a = new adin.b[paramJdSearchRsp.size()];
      }
      if ((paramJdSearchRsp == null) || (paramJdSearchRsp.size() <= 0)) {
        break label707;
      }
      localObject1 = paramJdSearchRsp.iterator();
      i = 0;
      label410:
      if (!((Iterator)localObject1).hasNext()) {
        break label707;
      }
      localObject2 = (JDSearch.JdSkuItem)((Iterator)localObject1).next();
      localc.a[i] = new adin.b();
      localb = localc.a[i];
      if (!((JDSearch.JdSkuItem)localObject2).detail_url.has()) {
        break label677;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).detail_url.get();
      label475:
      localb.detailUrl = paramJdSearchRsp;
      localb = localc.a[i];
      if (!((JDSearch.JdSkuItem)localObject2).image_url.has()) {
        break label683;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).image_url.get();
      label510:
      localb.imageUrl = paramJdSearchRsp;
      localb = localc.a[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_id.has()) {
        break label689;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_id.get();
      label545:
      localb.bth = paramJdSearchRsp;
      localb = localc.a[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_name.has()) {
        break label695;
      }
      paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_name.get();
      label580:
      localb.bti = paramJdSearchRsp;
      localb = localc.a[i];
      if (!((JDSearch.JdSkuItem)localObject2).sku_price.has()) {
        break label701;
      }
    }
    label640:
    label645:
    label651:
    label657:
    label662:
    label667:
    label672:
    label677:
    label683:
    label689:
    label695:
    label701:
    for (paramJdSearchRsp = ((JDSearch.JdSkuItem)localObject2).sku_price.get();; paramJdSearchRsp = "")
    {
      localb.btj = paramJdSearchRsp;
      i += 1;
      break label410;
      i = -1;
      break;
      label633:
      localObject1 = "";
      break label57;
      i = -1;
      break label106;
      paramJdSearchRsp = "";
      break label132;
      paramJdSearchRsp = "";
      break label158;
      f1 = 0.0F;
      break label212;
      f1 = 0.0F;
      break label243;
      f1 = 0.0F;
      break label274;
      paramJdSearchRsp = null;
      break label360;
      paramJdSearchRsp = "";
      break label475;
      paramJdSearchRsp = "";
      break label510;
      paramJdSearchRsp = "";
      break label545;
      paramJdSearchRsp = "";
      break label580;
    }
    label707:
    return localc;
  }
  
  private adin.e a()
  {
    boolean bool2 = false;
    if (aeB())
    {
      adin.e locale = new adin.e();
      adin.h localh = a();
      if (localh == null) {
        return null;
      }
      if (this.jdField_a_of_type_Adin$f != null)
      {
        locale.av = new RectF(this.jdField_a_of_type_Adin$f.cGU, this.jdField_a_of_type_Adin$f.cGW, this.jdField_a_of_type_Adin$f.cGV, this.jdField_a_of_type_Adin$f.cGX);
        if (!localh.bNH) {
          break label127;
        }
        locale.btp = localh.btq;
        locale.bNE = false;
        locale.ch = localh.cj;
      }
      for (;;)
      {
        return locale;
        locale.av = new RectF();
        break;
        label127:
        locale.btp = localh.a.btl;
        boolean bool1 = bool2;
        if (localh.jdField_do != null)
        {
          bool1 = bool2;
          if (localh.jdField_do.length > 20) {
            bool1 = true;
          }
        }
        locale.bNE = bool1;
        locale.ch = localh.cj;
        locale.jdField_do = localh.jdField_do;
        locale.bsv = localh.sTitle;
        locale.bsw = localh.bts;
        locale.bsx = localh.adO;
        locale.bNF = localh.bNG;
      }
    }
    return null;
  }
  
  private adin.h a()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!aeB()) {}
    do
    {
      do
      {
        return localObject2;
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfAdin$g.length)
        {
          int j = 0;
          while ((this.jdField_a_of_type_ArrayOfAdin$g[i].a != null) && (j < this.jdField_a_of_type_ArrayOfAdin$g[i].a.length))
          {
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (this.jdField_a_of_type_ArrayOfAdin$g[i].a[j].cj >= ((adin.h)localObject1).cj) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ArrayOfAdin$g[i].a[i];
            }
            j += 1;
            localObject1 = localObject2;
          }
          i += 1;
        }
        localObject2 = localObject1;
      } while (localObject1 != null);
      localObject2 = localObject1;
    } while (this.jdField_a_of_type_ArrayOfAdin$g.length != 1);
    localObject1 = new adin.h();
    ((adin.h)localObject1).bNH = true;
    ((adin.h)localObject1).btq = this.jdField_a_of_type_ArrayOfAdin$g[0].btq;
    ((adin.h)localObject1).cj = this.jdField_a_of_type_ArrayOfAdin$g[0].ci;
    ((adin.h)localObject1).btr = this.jdField_a_of_type_ArrayOfAdin$g[0].btq;
    ((adin.h)localObject1).cHa = 0;
    ((adin.h)localObject1).imageId = "";
    return localObject1;
  }
  
  public byte[] U()
  {
    adin.e locale = a();
    if ((locale != null) && (locale.bNE)) {
      return locale.jdField_do;
    }
    return null;
  }
  
  public adin.a a()
  {
    adin.a locala = new adin.a();
    locala.bNB = true;
    locala.b = this.jdField_a_of_type_Adin$c;
    locala.a = a();
    locala.bND = false;
    return locala;
  }
  
  public boolean aeA()
  {
    return (this.retCode == 0) && (this.jdField_a_of_type_Adin$c != null) && (this.jdField_a_of_type_Adin$c.cGS == 0) && (this.jdField_a_of_type_Adin$c.errCode == 0) && (this.jdField_a_of_type_Adin$c.a != null) && (this.jdField_a_of_type_Adin$c.a.length > 0);
  }
  
  public boolean aeB()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.retCode == 0)
    {
      bool1 = bool2;
      if (this.iRetCode == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfAdin$g != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ArrayOfAdin$g.length > 0)
          {
            bool1 = bool2;
            if (!this.jdField_a_of_type_ArrayOfAdin$g[0].btq.equalsIgnoreCase(btf)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean aeC()
  {
    boolean bool = true;
    adin.h localh = a();
    if (localh == null) {
      return false;
    }
    if (localh.cHa == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean aet()
  {
    return aeB();
  }
  
  public boolean b(adin paramadin)
  {
    if (paramadin == null) {}
    adin.h localh;
    do
    {
      return false;
      paramadin = paramadin.a();
      localh = a();
    } while ((paramadin == null) || (localh == null) || (!paramadin.btq.equalsIgnoreCase(localh.btq)));
    return true;
  }
  
  public int getRenderType()
  {
    if (!aet()) {
      return -1;
    }
    if (aeB())
    {
      adin.h localh = a();
      if ((localh != null) && (localh.jdField_do != null) && (localh.jdField_do.length > 20)) {
        return 1;
      }
    }
    return 0;
  }
  
  public String sA()
  {
    adin.h localh = a();
    if (localh == null) {
      return "";
    }
    return localh.imageId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (aeB()) {
      localStringBuilder.append("\n {migObjectClassifyResult:" + this.jdField_a_of_type_ArrayOfAdin$g[0].toString() + "} \n");
    }
    if (aeA()) {
      localStringBuilder.append("\n {jdSearchResult:" + this.jdField_a_of_type_Adin$c.toString() + "}\n");
    }
    return localStringBuilder.toString();
  }
  
  public static class a
    extends adim
  {
    public static final a a = new a(false);
    public adin.e a;
    public adin.c b;
    public boolean bNB;
    public boolean bNC;
    public boolean bND;
    
    public a()
    {
      this.Sl = 128L;
    }
    
    public a(boolean paramBoolean)
    {
      this.Sl = 128L;
      this.bNB = paramBoolean;
    }
  }
  
  public static class b
  {
    public String bth;
    public String bti;
    public String btj;
    public String detailUrl;
    public String imageUrl;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skuId:").append(this.bth).append(",skuName:").append(this.bti).append(",skuPrice:").append(this.btj).append(",imageUrl:").append(this.imageUrl).append(",detailUrl:").append(this.detailUrl);
      return localStringBuilder.toString();
    }
  }
  
  public static class c
  {
    adin.b[] a;
    public RectF au = new RectF();
    public String btk;
    public int cGS;
    public int cGT = -1;
    public int errCode;
    public String errMsg;
    public String moreUrl;
    public String sessionId;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ssoErrCode:").append(this.cGS).append(",ssoErrMsg:").append(this.btk).append(",errCode:").append(this.errCode).append(",errMsg:").append(this.errMsg).append(",sessionId:").append(this.sessionId).append(",moreUrl:").append(this.moreUrl);
      int i = 0;
      while ((this.a != null) && (i < this.a.length))
      {
        localStringBuilder.append("\n{index=").append(i).append(":").append(this.a[i].toString()).append("}\n");
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  public static class d
  {
    public String btl;
    public String btm;
    public String bto;
    public String sCity;
    public String sCountry;
    public String sTitle;
  }
  
  public static class e
  {
    public RectF av;
    public boolean bNE;
    public boolean bNF;
    public String bsv;
    public String bsw;
    public String bsx;
    public String btp;
    public double ch;
    public byte[] jdField_do;
  }
  
  public static class f
  {
    public int cGU;
    public int cGV;
    public int cGW;
    public int cGX;
    public int cGY;
    public float uR;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("xMIN:").append(this.cGU).append(",xMAX:").append(this.cGV).append(",yMIN:").append(this.cGW).append(",yMAX:").append(this.cGX);
      return localStringBuilder.toString();
    }
  }
  
  public static class g
  {
    public adin.h[] a;
    public String btq;
    public int cGZ;
    public double ci;
    public int iStatus;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      int i;
      if ((this.a != null) && (this.a.length > 0)) {
        i = 0;
      }
      while (i < this.a.length)
      {
        localStringBuilder.append("\n index:").append(i).append(this.a[i].toString()).append('\n');
        i += 1;
        continue;
        localStringBuilder.append("\n only have one itemContent:" + this.btq + ",prob:" + this.ci).append('\n');
      }
      return localStringBuilder.toString();
    }
  }
  
  public static class h
  {
    public adin.d a;
    public String adO;
    public boolean bNG;
    public boolean bNH;
    public String btq;
    public String btr;
    public String bts;
    public int cGZ;
    public int cHa;
    public double cj;
    public byte[] jdField_do;
    public int iSource;
    public String imageId = "";
    public String sPicUrl;
    public String sTitle;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("result:{sclass:");
      if (this.btq != null)
      {
        str = this.btq;
        localStringBuilder = localStringBuilder.append(str).append(",").append("sItemId:");
        if (this.a == null) {
          break label230;
        }
        str = this.a.btl;
        label56:
        localStringBuilder = localStringBuilder.append(str).append(",").append("dProb:").append(this.cj).append(",").append("sTitle:").append(this.sTitle).append(",").append("sWiki:").append(this.bts).append(",").append("sJumpUrl:").append(this.adO).append(",").append("sCdbRes:");
        if (this.jdField_do == null) {
          break label236;
        }
      }
      label230:
      label236:
      for (String str = new String(this.jdField_do);; str = "")
      {
        return str + "," + "isAutoJump:" + this.bNG + "," + "iNeedCheckLBS:" + this.cHa + "," + "imageId:" + this.imageId + "}";
        str = "";
        break;
        str = "";
        break label56;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adin
 * JD-Core Version:    0.7.0.1
 */