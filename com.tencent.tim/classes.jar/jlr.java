import java.util.HashMap;

public class jlr
{
  public int QV = 3;
  public jls a;
  public int aBo = 5000;
  public int aBp = 60000;
  public HashMap<String, String> mHeaders;
  public String mUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrl = ").append(this.mUrl);
    localStringBuilder.append(",mConnectionTimeout = ").append(this.aBo);
    localStringBuilder.append(",mSocketTimeout = ").append(this.aBp);
    if (this.a != null)
    {
      localStringBuilder.append(",mResult.mIsSucc = ").append(this.a.mIsSucc);
      localStringBuilder.append(",mResult.mFileLength = ").append(this.a.mFileLength);
      localStringBuilder.append(",mResult.mErrCode = ").append(this.a.mErrCode);
      localStringBuilder.append(",mResult.mErrStr = ").append(this.a.SX);
      localStringBuilder.append(",mResult.mTryCount = ").append(this.a.QV);
      localStringBuilder.append(",mResult.mCostTime = ").append(this.a.mCostTime).append("ms");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(",mResult = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlr
 * JD-Core Version:    0.7.0.1
 */