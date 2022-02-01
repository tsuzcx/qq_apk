import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageRecord;
import com.wx.voice.vad.WXVadSeg;
import java.io.OutputStream;

public class aool
{
  public MessageRecord F;
  public aoom a;
  public URLDrawableHandler a;
  public WXVadSeg a;
  public String aIf;
  public String aLy;
  public long apI;
  public long apQ;
  public long aqp;
  public akxb b;
  public akyf b;
  public boolean bEnableEnc;
  public String bN;
  public PhotoSendParams c;
  public boolean cFo;
  public boolean cMb = true;
  public boolean cNA = true;
  public boolean cNB;
  public boolean cNC;
  public boolean cND;
  public boolean cNE;
  public boolean cNF;
  public boolean cNG;
  public boolean cNH;
  public boolean cNI;
  public boolean cNy;
  public boolean cNz;
  public int chatType;
  public String ckW = "";
  public String clM;
  public String clR;
  public String cmn;
  public String cmo;
  public String cmp;
  public String cmq;
  public boolean cvb;
  public int dOM;
  public int dPD;
  public int dPo = 1;
  public String dQ;
  public int dQF = 5;
  public int dQG;
  public int dQH;
  public int dQI;
  public int dQJ;
  public int dQK;
  public int dQL;
  public int dQM;
  public int dQN;
  public int dpB;
  public Object en;
  public Object extraObject;
  public byte[] fT;
  public byte[] gb;
  public boolean isQzonePic;
  public int mBusiType;
  public int mFileType;
  private String mKey;
  public String mMd5;
  public long mMsgTime;
  public boolean mNeedReport = true;
  public OutputStream mOut;
  public String mPeerUin;
  public String mSelfUin;
  public int mUinType;
  public long mUniseq;
  
  public String AO()
  {
    return this.mPeerUin + this.mUniseq;
  }
  
  public String getKey()
  {
    if (this.mKey == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mPeerUin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.mFileType);
      localStringBuilder.append("_");
      localStringBuilder.append(this.mUniseq);
      localStringBuilder.append("_");
      localStringBuilder.append(this.apI);
      return localStringBuilder.toString();
    }
    return this.mKey;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TransferRequest\n");
    localStringBuilder.append("mUniseq=" + this.mUniseq);
    localStringBuilder.append(",mMd5=" + this.mMd5);
    localStringBuilder.append(",mIsIp=" + this.cNy);
    localStringBuilder.append(",mUinType=" + this.mUinType);
    localStringBuilder.append(",mFileType=" + this.mFileType);
    localStringBuilder.append(",mSelfUin=" + this.mSelfUin);
    localStringBuilder.append(",mPeerUin=" + this.mPeerUin);
    localStringBuilder.append(",mSecondId=" + this.cmn);
    localStringBuilder.append(",mServerPath=" + this.cmo);
    localStringBuilder.append(",mLocalPath=" + this.dQ);
    localStringBuilder.append(",mBusiType=" + this.mBusiType);
    localStringBuilder.append(",mGroupFileID=" + this.apQ);
    localStringBuilder.append(",mExtraObj={" + this.en + "}");
    localStringBuilder.append(",mPrioty=" + this.dPo);
    localStringBuilder.append(",mLogicCallBack=" + this.b);
    localStringBuilder.append(",bEnableEnc=" + this.bEnableEnc);
    localStringBuilder.append(",isQzonePic=" + this.isQzonePic);
    localStringBuilder.append(",pcmForVadPath=" + this.aLy);
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public String cmr;
    public String packName;
    public String sourceIconBig;
    public String sourceName;
    public String sourceUrl;
    public int status;
  }
  
  public static class b
  {
    public long aqq;
    public String mShareUrl;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAppShareID:" + this.aqq);
      localStringBuilder.append(",mShareUrl:" + this.mShareUrl);
      return localStringBuilder.toString();
    }
  }
  
  public static class c
  {
    public URLDrawableHandler a;
    public String cms;
    public int dQO;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUrlFromMsg:" + this.cms);
      localStringBuilder.append(",mStartDownOffset:" + this.dQO);
      return localStringBuilder.toString();
    }
  }
  
  public static class d
  {
    public aool.b a;
    public boolean cNJ;
    public boolean cNK;
    public int mUinType;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUinType:" + this.mUinType);
      localStringBuilder.append(",mIsRaw:" + this.cNJ);
      localStringBuilder.append(",mIsShareAppPic:" + this.cNK);
      localStringBuilder.append(",mShareAppInfo:{" + this.a + "}");
      return localStringBuilder.toString();
    }
  }
  
  public static class e
  {
    public int dQP;
    public int mFromType;
    
    public e(int paramInt1, int paramInt2)
    {
      this.mFromType = paramInt1;
      this.dQP = paramInt2;
    }
  }
  
  public static class f
  {
    public long appId;
    public String audioUrl;
    public aool.a b;
    public int dQQ;
    public int dQR;
    public int forwardType;
    public String imageUrl;
    public String pkgName;
    public int serviceType;
    public String summary;
    public String targetUrl;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aool
 * JD-Core Version:    0.7.0.1
 */