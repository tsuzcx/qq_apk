import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import java.util.ArrayList;
import java.util.List;

public abstract interface aoql
{
  public static class a
  {
    public List<aoql.a.k> He = new ArrayList();
    aoql.b a = new aoql.b();
    public ProtoReqManager a;
    public aoqm.a b;
    ProtoReqManager.c c;
    public String cmy;
    public int commandId;
    public byte[] gc;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.He.size())
      {
        localStringBuilder.append("index:");
        localStringBuilder.append(i);
        localStringBuilder.append(" ");
        localStringBuilder.append(((aoql.a.k)this.He.get(i)).toString());
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public static class a
      extends aoql.a.k
    {
      public boolean cNW;
      public int fileType;
      public int msgTime;
      public int protocolType;
      public String storageSource;
      public String uuid;
    }
    
    public static class b
      extends aoql.a.k
    {
      public int autoToText;
      public int busiType;
      public boolean cNX;
      public int dRl;
      public String storageSource;
      public String uuid;
      public int voiceType;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" uuid:");
        localStringBuilder.append(this.uuid);
        localStringBuilder.append(" storageSource:");
        localStringBuilder.append(this.storageSource);
        localStringBuilder.append(" isSelfSend:");
        localStringBuilder.append(this.cNX);
        localStringBuilder.append(" voiceType:").append(this.voiceType);
        localStringBuilder.append(" busiType:").append(this.busiType);
        localStringBuilder.append(" downType:").append(this.dRl);
        return localStringBuilder.toString();
      }
    }
    
    public static class c
      extends aoql.a.k
    {
      public int fileType;
      public long groupFileID;
      public byte[] md5;
      public int msgTime;
      public int protocolType;
    }
    
    public static class d
      extends aoql.a.k
    {
      public String cmz;
      public int dRl;
      public long groupFileID;
      public byte[] md5;
      public int voiceType;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" groupFileID:");
        localStringBuilder.append(this.groupFileID);
        localStringBuilder.append(" groupFileKey:");
        localStringBuilder.append(this.cmz);
        localStringBuilder.append(" md5:");
        localStringBuilder.append(this.md5);
        localStringBuilder.append(" voiceType:").append(this.voiceType);
        localStringBuilder.append(" downType:").append(this.dRl);
        return localStringBuilder.toString();
      }
    }
    
    public static class e
      extends aoql.a.k
    {
      public String cmA;
      
      public String toString()
      {
        return this.cmA;
      }
    }
    
    public static class f
      extends aoql.a.k
    {
      public int dPD;
      public byte[] gd;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" msgResId:");
        localStringBuilder.append(this.gd);
        return localStringBuilder.toString();
      }
    }
    
    public static class g
      extends aoql.a.k
    {
      public int dPD;
      public byte[] md5;
      public long size;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.size);
        localStringBuilder.append(" storeType:");
        return localStringBuilder.toString();
      }
    }
    
    public static class h
      extends aoql.a.k
    {
      public String uin;
      
      public String toString()
      {
        return this.uin;
      }
    }
    
    public static class i
      extends aoql.a.k
    {
      public int busiType;
      public boolean cMs;
      public boolean cNW;
      public boolean cNY;
      public String cmB;
      public int dRm;
      public String fileName;
      public long fileSize;
      public int height;
      public byte[] md5;
      public int picType;
      public int width;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" name:");
        localStringBuilder.append(this.fileName);
        localStringBuilder.append(" width:");
        localStringBuilder.append(this.width);
        localStringBuilder.append(" height:");
        localStringBuilder.append(this.height);
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.fileSize);
        localStringBuilder.append(" isRaw:");
        localStringBuilder.append(this.cMs);
        localStringBuilder.append(" isContant:");
        localStringBuilder.append(this.cNW);
        localStringBuilder.append(" md5:");
        localStringBuilder.append(HexUtil.bytes2HexStr(this.md5));
        localStringBuilder.append(" picType:");
        localStringBuilder.append(this.picType);
        localStringBuilder.append(" busiType:");
        localStringBuilder.append(this.busiType);
        localStringBuilder.append("typeHotPic:");
        localStringBuilder.append(this.dRm);
        localStringBuilder.append("transferUrl:");
        localStringBuilder.append(this.cmB);
        return localStringBuilder.toString();
      }
    }
    
    public static class j
      extends aoql.a.k
    {
      public int audioPanelType;
      public int autoToText;
      public boolean cNZ = false;
      public String fileName;
      public int fileSize;
      public byte[] md5;
      public int voiceLength;
      public int voiceType;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" name:");
        localStringBuilder.append(this.fileName);
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.fileSize);
        localStringBuilder.append(" voiceLength:");
        localStringBuilder.append(this.voiceLength);
        localStringBuilder.append(" autoToText:");
        localStringBuilder.append(this.autoToText);
        localStringBuilder.append(" type:").append(this.voiceType).append(" audioPanel:").append(this.audioPanelType);
        return localStringBuilder.toString();
      }
    }
    
    public static class k
    {
      public String cmC;
      public String peerUin;
      public String selfUin;
      public int uinType;
    }
    
    public static class l
      extends aoql.a.k
    {
      public int IH;
      public int busiType;
      public int chatType;
      public int clientType;
      public int dRl;
      public int dRn;
      public String fileId;
      public int fileType;
      public byte[] md5;
      public int seq;
      public int subBusiType;
      public String troopUin;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" chatType:");
        localStringBuilder.append(this.chatType);
        localStringBuilder.append(" clientType:");
        localStringBuilder.append(this.clientType);
        localStringBuilder.append(" seq:");
        localStringBuilder.append(this.seq);
        localStringBuilder.append(" fileId:");
        localStringBuilder.append(this.fileId);
        localStringBuilder.append(" troopUin:");
        localStringBuilder.append(this.troopUin);
        localStringBuilder.append(" agentType:");
        localStringBuilder.append(this.dRn);
        localStringBuilder.append(" md5:");
        localStringBuilder.append(HexUtil.bytes2HexStr(this.md5));
        localStringBuilder.append(" busiType:");
        localStringBuilder.append(this.busiType);
        localStringBuilder.append(" fileType:");
        localStringBuilder.append(this.fileType);
        localStringBuilder.append(" downType:");
        localStringBuilder.append(this.dRl);
        localStringBuilder.append(" sceneType:");
        localStringBuilder.append(this.IH);
        localStringBuilder.append(" subBusiType:");
        localStringBuilder.append(this.subBusiType);
        return localStringBuilder.toString();
      }
    }
    
    public static class m
      extends aoql.a.k
    {
      public long JW;
      public int clientType;
      public int dFm;
      public int dFn;
      public int dFo;
      public int dRn;
      public int dRo;
      public int dRp;
      public byte[] fG;
      public String fileName;
      public long fileSize;
      public int format;
      public int fromChatType;
      public String fromUin;
      public byte[] md5;
      public int seq;
      public int toChatType;
      public String troopUin;
      public String uuid;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" fromChatType:").append(this.fromChatType);
        localStringBuilder.append(" toChatType:").append(this.toChatType);
        localStringBuilder.append(" fromBusiType:").append(this.dFm);
        localStringBuilder.append(" toBusiType:").append(this.dFn);
        localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.md5));
        localStringBuilder.append(" format:").append(this.format);
        localStringBuilder.append(" str_file_name:").append(this.fileName);
        localStringBuilder.append(" uint64_file_size:").append(this.fileSize);
        localStringBuilder.append(" fileTime:").append(this.dFo);
        localStringBuilder.append(" uuid:").append(this.uuid);
        localStringBuilder.append(" fromUin:").append(this.fromUin);
        return localStringBuilder.toString();
      }
    }
    
    public static class n
      extends aoql.a.k
    {
      public long JW;
      public int busiType;
      public int chatType;
      public int clientType;
      public int dFo;
      public int dRn;
      public int dRo;
      public int dRp;
      public int dRq;
      public byte[] fG;
      public String fileName;
      public long fileSize;
      public int format;
      public byte[] md5;
      public int seq;
      public int subBusiType;
      public String troopUin;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" chatType:");
        localStringBuilder.append(this.chatType);
        localStringBuilder.append(" md5:");
        localStringBuilder.append(this.md5);
        localStringBuilder.append(" format:");
        localStringBuilder.append(this.format);
        localStringBuilder.append(" str_file_name:");
        localStringBuilder.append(this.fileName);
        localStringBuilder.append(" uint64_file_size:");
        localStringBuilder.append(this.fileSize);
        localStringBuilder.append(" fileTime:");
        localStringBuilder.append(this.dFo);
        localStringBuilder.append(" busiType:");
        localStringBuilder.append(this.busiType);
        localStringBuilder.append(" subBusiType:");
        localStringBuilder.append(this.subBusiType);
        localStringBuilder.append(" userCnt:");
        localStringBuilder.append(this.dRq);
        return localStringBuilder.toString();
      }
    }
  }
  
  public static class b
  {
    public List<aoql.b.m> Hf = new ArrayList();
    
    public static class a
      extends aoql.b.m
    {
      public int blockSize;
      public boolean cOa = false;
      public boolean cOb = false;
      public String clu = "";
      public String clv = "";
      public String clw = "";
      public String clx = "";
      public long groupFileID;
      public boolean isExist;
      public String mUkey;
      public String resid = "";
      public long startOffset = 0L;
      public int transferedSize;
      public ArrayList<aonh> xp = new ArrayList();
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" fileID:");
        localStringBuilder.append(this.groupFileID);
        localStringBuilder.append(" isExist:");
        localStringBuilder.append(this.isExist);
        localStringBuilder.append(" blockSize:");
        localStringBuilder.append(this.blockSize);
        localStringBuilder.append(" netChg:");
        localStringBuilder.append(this.cOa);
        localStringBuilder.append(" downDomain:");
        localStringBuilder.append(this.clu);
        localStringBuilder.append(" thumbDownUrl");
        localStringBuilder.append(this.clw);
        localStringBuilder.append(" bigDownUrl:");
        localStringBuilder.append(this.clx);
        localStringBuilder.append(" orgiDownUrl:");
        localStringBuilder.append(this.clv);
        return localStringBuilder.toString();
      }
    }
    
    public static class b
      extends aoql.b.m
    {
      public int blockSize;
      public boolean cOa = false;
      public String cmD;
      public boolean isExist = false;
      public String mResid;
      public String mUkey;
      public String mUuid;
      public long startOffset = 0L;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" mResid:");
        localStringBuilder.append(this.mResid);
        localStringBuilder.append(" isExist:");
        localStringBuilder.append(this.isExist);
        localStringBuilder.append(" blockSize:");
        localStringBuilder.append(this.blockSize);
        localStringBuilder.append(" netChg:");
        localStringBuilder.append(this.cOa);
        localStringBuilder.append(" startOffset:").append(this.startOffset);
        return localStringBuilder.toString();
      }
    }
    
    public static class c
      extends aoql.b.m
    {
      public ArrayList<aonh> Bw = new ArrayList();
      public String cmE;
      public String downloadUrl;
      public ArrayList<aonh> xp = new ArrayList();
    }
    
    public static class d
      extends aoql.b.m
    {
      public int blockSize;
      public ArrayList<aonh> ipList = new ArrayList();
      public boolean isExist;
      public String mUkey;
      public String uuid;
    }
    
    public static class e
      extends aoql.b.m
    {
      public int blockSize;
      public boolean cOa = false;
      public boolean cOb = false;
      public long groupFileID;
      public boolean isExist;
      public String mUkey;
      public long startOffset = 0L;
      public int transferedSize;
      public ArrayList<aonh> xp = new ArrayList();
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" fileID:");
        localStringBuilder.append(this.groupFileID);
        localStringBuilder.append(" isExist:");
        localStringBuilder.append(this.isExist);
        localStringBuilder.append(" blockSize:");
        localStringBuilder.append(this.blockSize);
        localStringBuilder.append(" netChg:");
        localStringBuilder.append(this.cOa);
        return localStringBuilder.toString();
      }
    }
    
    public static class f
      extends aoql.b.m
    {
      public ArrayList<aonh> Bw = new ArrayList();
      public String cmE;
      public String urlPath;
      public ArrayList<aonh> xp = new ArrayList();
    }
    
    public static class g
      extends aoql.b.m
    {
      public int blockSize;
      public byte[] gf;
      public long groupFileID;
      public ArrayList<aonh> ipList = new ArrayList();
      public boolean isExist;
      public String mUkey;
      public int transferedSize;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" fileID:");
        localStringBuilder.append(this.groupFileID);
        return localStringBuilder.toString();
      }
    }
    
    public static class h
      extends aoql.b.m
    {
      public mobileqq_mp.RetInfo a;
      public String cmF;
      public String cmG;
    }
    
    public static class i
      extends aoql.b.m
    {
      public ArrayList<aonh> Bw = new ArrayList();
      public String cmH;
      public byte[] gh;
      public byte[] gi;
      public ArrayList<aonh> ipList = new ArrayList();
      public int mChannelType;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" urlParam:");
        localStringBuilder.append(this.cmH);
        localStringBuilder.append(" msgUkey:");
        localStringBuilder.append(this.gi);
        localStringBuilder.append(" ipList:");
        localStringBuilder.append(this.ipList);
        localStringBuilder.append(" mIpv6List:");
        localStringBuilder.append(this.Bw);
        localStringBuilder.append(" resId:");
        localStringBuilder.append(this.gh);
        return localStringBuilder.toString();
      }
    }
    
    public static class j
      extends aoql.b.m
    {
      public int blockSize;
      public byte[] gh;
      public byte[] gj;
      public byte[] gk;
      public byte[] gl;
      public ArrayList<aonh> ipList = new ArrayList();
      public int transferedSize;
    }
    
    public static class k
      extends aoql.b.m
    {
      public byte[] sessionKey;
    }
    
    public static class l
      extends aoql.b.m
    {
      public ArrayList<aonh> Bw = new ArrayList();
      public String domain;
      public int protocolType;
      public String urlPath;
      public ArrayList<aonh> xp = new ArrayList();
    }
    
    public static class m
    {
      public boolean cOc = false;
      public boolean cOd = true;
      public int errCode;
      public String errStr;
      public int failCount;
      public String reason;
      public int result = -1;
      public int successCount;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("result:");
        localStringBuilder.append(this.result);
        localStringBuilder.append(" errCode:");
        localStringBuilder.append(this.errCode);
        localStringBuilder.append(" errStr:");
        localStringBuilder.append(this.errStr);
        localStringBuilder.append(" reason:");
        localStringBuilder.append(this.reason);
        localStringBuilder.append(" succCnt:");
        localStringBuilder.append(this.successCount);
        localStringBuilder.append(" failCnt");
        localStringBuilder.append(this.failCount);
        localStringBuilder.append(" isSendByQuickHttp");
        localStringBuilder.append(this.cOc);
        localStringBuilder.append(" isAllowRetry");
        localStringBuilder.append(this.cOd);
        return localStringBuilder.toString();
      }
    }
    
    public static class n
      extends aoql.b.m
    {
      public ArrayList<aonh> Bw = new ArrayList();
      public int dRr;
      public byte[] gm;
      public String mDomain;
      public String mUkey;
      public String mUrl;
      public byte[] md5;
      public ArrayList<aonh> xp = new ArrayList();
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" mUkey:");
        localStringBuilder.append(this.mUkey);
        localStringBuilder.append(" mIpList:").append(this.xp.toString());
        localStringBuilder.append(" mIpv6List:").append(this.Bw.toString());
        localStringBuilder.append(" md5:").append(HexUtil.bytes2HexStr(this.md5));
        localStringBuilder.append(" aesKey:").append(HexUtil.bytes2HexStr(this.gm));
        return localStringBuilder.toString();
      }
    }
    
    public static class o
      extends aoql.b.m
    {
      public String fileId;
      public boolean isExist;
      public long startOffset = 0L;
      public int videoAttr = 0;
      public int videoKandianType = 0;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" isExist:");
        localStringBuilder.append(this.isExist);
        localStringBuilder.append(" fileId:");
        localStringBuilder.append(this.fileId);
        localStringBuilder.append(" startOffset:").append(this.startOffset);
        localStringBuilder.append(" videoAttr:").append(this.videoAttr);
        localStringBuilder.append(" videoKandianType:").append(this.videoKandianType);
        return localStringBuilder.toString();
      }
    }
    
    public static class p
      extends aoql.b.m
    {
      public String fileId;
      public boolean isExist;
      public long startOffset = 0L;
      public int videoAttr = 0;
      public int videoKandianType = 0;
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.toString());
        localStringBuilder.append(" isExist:");
        localStringBuilder.append(this.isExist);
        localStringBuilder.append(" fileId:");
        localStringBuilder.append(this.fileId);
        localStringBuilder.append(" startOffset:").append(this.startOffset);
        localStringBuilder.append(" videoAttr:").append(this.videoAttr);
        localStringBuilder.append(" videoKandianType:").append(this.videoKandianType);
        return localStringBuilder.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoql
 * JD-Core Version:    0.7.0.1
 */