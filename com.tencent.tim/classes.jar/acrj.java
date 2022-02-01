import android.support.annotation.NonNull;
import java.util.HashSet;

public class acrj
{
  public static final HashSet<acrj> aW = new HashSet();
  public boolean bdR;
  public long fromUin;
  public long msgSeq;
  public int msgTime;
  public int msgType;
  public long msgUid;
  
  public acrj(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.fromUin = paramLong1;
    this.msgSeq = paramLong2;
    this.msgUid = paramLong3;
    this.msgType = paramInt1;
    this.msgTime = paramInt2;
    this.bdR = paramBoolean;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PushMsg0x210_c7Info{");
    localStringBuilder.append("fromUin:").append(this.fromUin).append(", ");
    localStringBuilder.append("msgSeq:").append(this.msgSeq).append(", ");
    localStringBuilder.append("msgTime:").append(this.msgTime).append(", ");
    localStringBuilder.append("onlinePush:").append(this.bdR).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrj
 * JD-Core Version:    0.7.0.1
 */