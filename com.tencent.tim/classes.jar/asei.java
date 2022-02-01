import java.util.Arrays;

public class asei
{
  public static final class a
  {
    public int aqx;
    public int aww;
    public int bDB;
    public byte[] bc;
    public int elI;
    public int elJ;
    public String mOpenId;
    public long mUin;
    
    public String toString()
    {
      return "MultiParams{mRelationType=" + this.aqx + ", mMultiAVType=" + this.aww + ", mMultiAVSubType=" + this.elI + ", mRoomId=" + this.elJ + ", mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + '\'' + ", mSourceId=" + this.bDB + ", mSig=" + Arrays.toString(this.bc) + '}';
    }
  }
  
  public static final class b
  {
    public boolean mMicOn;
    public String mOpenId;
    public long mUin;
    
    public String toString()
    {
      return "MultiUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + '\'' + ", mMicOn=" + this.mMicOn + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asei
 * JD-Core Version:    0.7.0.1
 */