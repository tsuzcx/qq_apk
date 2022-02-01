import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.math.BigInteger;
import org.jetbrains.annotations.NotNull;

public class kqf
{
  private int aLh;
  private int aLi;
  private String abH;
  private String abI;
  private String abJ;
  private ArticleInfo b;
  private String mCardJumpUrl;
  private String mCommentId;
  private int mCommentType;
  private int mContentSrc;
  private boolean mIsSecondReply;
  private int mListShowType;
  private String mReplyCommentId;
  private String mReplyParentCommentId;
  private String mReplyUin;
  private int mResultCode;
  private String yr;
  
  public ArticleInfo a()
  {
    return this.b;
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.b = paramArticleInfo;
  }
  
  public long ch()
  {
    if (!TextUtils.isEmpty(this.yr)) {
      return new BigInteger(this.yr).longValue();
    }
    return 0L;
  }
  
  public String getCardJumpUrl()
  {
    return this.mCardJumpUrl;
  }
  
  public String getCommentId()
  {
    return this.mCommentId;
  }
  
  public int getCommentType()
  {
    return this.mCommentType;
  }
  
  public int getContentSrc()
  {
    return this.mContentSrc;
  }
  
  public int getFeedsType()
  {
    return this.aLh;
  }
  
  public String getReplyCommentId()
  {
    return this.mReplyCommentId;
  }
  
  public String getReplyUin()
  {
    return this.mReplyUin;
  }
  
  public int getResultCode()
  {
    return this.mResultCode;
  }
  
  public String iE()
  {
    return this.abJ;
  }
  
  public String iF()
  {
    return this.abI;
  }
  
  public String ii()
  {
    return this.abH;
  }
  
  public boolean isIsSecondReply()
  {
    return this.mIsSecondReply;
  }
  
  public void mp(String paramString)
  {
    this.abJ = paramString;
  }
  
  public void mq(String paramString)
  {
    this.abH = paramString;
  }
  
  public void mr(String paramString)
  {
    this.mCardJumpUrl = paramString;
  }
  
  public void ms(String paramString)
  {
    this.abI = paramString;
  }
  
  public int nB()
  {
    return this.aLi;
  }
  
  public void px(int paramInt)
  {
    this.aLi = paramInt;
  }
  
  public void setCommentId(String paramString)
  {
    this.mCommentId = paramString;
  }
  
  public void setCommentType(int paramInt)
  {
    this.mCommentType = paramInt;
  }
  
  public void setContentSrc(int paramInt)
  {
    this.mContentSrc = paramInt;
  }
  
  public void setFeedsId(String paramString)
  {
    this.yr = paramString;
  }
  
  public void setFeedsType(int paramInt)
  {
    this.aLh = paramInt;
  }
  
  public void setIsSecondReply(boolean paramBoolean)
  {
    this.mIsSecondReply = paramBoolean;
  }
  
  public void setListShowType(int paramInt)
  {
    this.mListShowType = paramInt;
  }
  
  public void setReplyCommentId(String paramString)
  {
    this.mReplyCommentId = paramString;
  }
  
  public void setReplyParentCommentId(String paramString)
  {
    this.mReplyParentCommentId = paramString;
  }
  
  public void setReplyUin(String paramString)
  {
    this.mReplyUin = paramString;
  }
  
  public void setResultCode(int paramInt)
  {
    this.mResultCode = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    return "RIJBiuAndCommentRespData{mResultCode=" + this.mResultCode + ", mCommentId='" + this.mCommentId + '\'' + ", mFeedsId='" + this.yr + '\'' + ", mFeedsType=" + this.aLh + ", mCommentString='" + this.abH + '\'' + ", mCommentShareUrl='" + this.abJ + '\'' + ", mCardAvailable=" + this.aLi + ", mCardJumpUrl='" + this.mCardJumpUrl + '\'' + ", mCommentBtnUrl='" + this.abI + '\'' + ", mArticleInfo=" + this.b + ", mContentSrc=" + this.mContentSrc + ", mCommentType=" + this.mCommentType + ", mListShowType=" + this.mListShowType + ", mIsSecondReply=" + this.mIsSecondReply + ", mReplyCommentId='" + this.mReplyCommentId + '\'' + ", mReplyUin='" + this.mReplyUin + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqf
 * JD-Core Version:    0.7.0.1
 */