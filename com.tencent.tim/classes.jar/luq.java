import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.a;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PkgInstallInfo;

public class luq
{
  public static class a
  {
    public int aPU = 1;
    public boolean isInstalled;
    public String packageName;
    
    public oidb_cmd0x68b.PkgInstallInfo a()
    {
      int i = 1;
      oidb_cmd0x68b.PkgInstallInfo localPkgInstallInfo = new oidb_cmd0x68b.PkgInstallInfo();
      localPkgInstallInfo.uint32_platform_type.set(1);
      PBUInt32Field localPBUInt32Field = localPkgInstallInfo.uint32_is_installed;
      if (this.isInstalled) {}
      for (;;)
      {
        localPBUInt32Field.set(i);
        if (!TextUtils.isEmpty(this.packageName)) {
          localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(this.packageName));
        }
        return localPkgInstallInfo;
        i = 0;
      }
    }
  }
  
  public static class b
  {
    public LebaKDCellInfo a;
    public lwh.b a;
    public int aPV = 1;
    public int aPW = 1;
    public int aPX;
    public int aPY;
    public int aPZ = 1;
    public boolean ald;
    public boolean ale;
    public boolean alf;
    public boolean alg;
    public long algorithmId;
    public boolean alh;
    public boolean ali;
    public boolean alj;
    public boolean alk;
    public boolean alm;
    public String articleTitle;
    public byte[] bm;
    public byte[] bo;
    public int channelID;
    public int channelType;
    public SelectPositionModule.PositionData e;
    public Bundle extraData;
    public String innerUniqId;
    public List<Long> it;
    public List<Long> iu;
    public List<KandianMergeManager.a> iv = new ArrayList();
    public List<luq.a> iw;
    public int notifyType;
    public String pushContext;
    public int reqType;
    public int serviceType;
    public long tn;
    public long uH;
    public long uI;
    public long uJ = -1L;
    
    public static int a(KandianMergeManager.a parama)
    {
      if (parama.launchFrom == 13) {
        return 11;
      }
      return 1;
    }
  }
  
  public static class c
  {
    public int aQa;
    public int aQb;
    public int aQc;
    public int aQd;
    public boolean aln;
    public boolean alo;
    public boolean alp;
    public boolean alq;
    public boolean alr;
    public boolean als;
    public boolean alt;
    public boolean alu;
    public boolean alv;
    public boolean alw;
    public boolean alx;
    public boolean debug;
    public int notifyType;
  }
  
  public static class d
  {
    public luq.d.a a;
    public int aPY;
    public int aQe;
    public String afM;
    public String afN;
    public byte[] businessInfo;
    public int channelID;
    public int channelType;
    public List<Long> iu;
    public long uH;
    public long uI;
    public long uK;
    public long uL;
    
    public String toString()
    {
      return "channelID:" + this.channelID + " channelType:" + this.channelType + " upDateTimes：" + this.aQe + " beginRecommendSeq：" + this.uH + " endRecommendSeq：" + this.uI + " beginCollectionID:" + this.uK + " endCollectionID:" + this.uL + "   subscriptionArticleList:" + this.iu + " innerMsg:" + this.a;
    }
    
    public static class a
    {
      public int aQf;
      public int aQg;
      public String innerUniqId;
      public String pushContext;
      public int strategyID;
      public int templateID;
      public String title;
      public long uM;
      
      public String toString()
      {
        return "InnerMsg{innerUniqId='" + this.innerUniqId + '\'' + ", title='" + this.title + '\'' + ", algorithID=" + this.uM + ", strategyID=" + this.strategyID + ", jumpSrcType=" + this.aQf + ", pushContext='" + this.pushContext + '\'' + ", templateID=" + this.templateID + ", articleContentType=" + this.aQg + '}';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     luq
 * JD-Core Version:    0.7.0.1
 */