import com.tencent.cloudfile.CloudDir;
import java.util.Arrays;

public class atin
  implements atiu
{
  public CloudDir a;
  private String cGP;
  private boolean dhQ = true;
  private int epL = 1;
  private boolean mClickable = true;
  public String name;
  public long sortTime = 9223372036854775807L;
  public int subDirCount;
  public int subFileCount;
  public int totalCount;
  
  public atin(CloudDir paramCloudDir)
  {
    this(paramCloudDir.showName);
    this.a = paramCloudDir;
    this.subDirCount = paramCloudDir.subDirCount;
    this.subFileCount = paramCloudDir.subFileCount;
  }
  
  public atin(String paramString)
  {
    this.name = paramString;
  }
  
  public atin(String paramString, boolean paramBoolean)
  {
    this(paramString);
    this.dhQ = paramBoolean;
  }
  
  private byte[] aH()
  {
    if (this.a != null) {
      return this.a.pLogicDirKey;
    }
    return null;
  }
  
  public String EP()
  {
    if (this.a != null) {
      return this.a.getIdString();
    }
    return null;
  }
  
  public String EQ()
  {
    return this.cGP;
  }
  
  public byte[] Y()
  {
    if (this.a != null) {
      return this.a.cloudId;
    }
    return null;
  }
  
  public void YN(String paramString)
  {
    this.cGP = paramString;
  }
  
  public void aat(int paramInt)
  {
    this.epL = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof atin)) {}
    do
    {
      return false;
      paramObject = (atin)paramObject;
    } while ((!Arrays.equals(paramObject.Y(), Y())) || (!Arrays.equals(paramObject.aH(), aH())));
    return true;
  }
  
  public int getCloudFileType()
  {
    return this.epL;
  }
  
  public long getCreateTime()
  {
    if (this.a != null) {
      return this.a.createTime;
    }
    return 0L;
  }
  
  public long getModifyTime()
  {
    if (this.a != null) {
      return this.a.modifyTime;
    }
    return 0L;
  }
  
  public long getSortSeq()
  {
    if (this.a != null) {
      return this.a.sortSeq;
    }
    return 0L;
  }
  
  public long getSortTime()
  {
    if (this.a != null) {
      this.sortTime = this.a.sortTime;
    }
    return this.sortTime;
  }
  
  public int getTotalCount()
  {
    if (this.a != null) {
      this.totalCount = (this.a.subDirCount + this.a.subFileCount);
    }
    return this.totalCount;
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public void nm(long paramLong)
  {
    this.sortTime = paramLong;
  }
  
  public void setTotalCount(int paramInt)
  {
    this.totalCount = paramInt;
  }
  
  public void setmClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atin
 * JD-Core Version:    0.7.0.1
 */