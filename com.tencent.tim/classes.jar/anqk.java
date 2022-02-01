import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class anqk
  extends RecyclablePool.Recyclable
{
  public long accessTime;
  public long anR;
  public long anS;
  public boolean isFile;
  public String name;
  public String path;
  public long size;
  
  public void recycle()
  {
    super.recycle();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("StorageItem info[size=").append(this.size);
    localStringBuilder.append(",accessTime=").append(this.accessTime);
    localStringBuilder.append(",isFile=").append(this.isFile);
    localStringBuilder.append(",fileCount=").append(this.anR);
    localStringBuilder.append(",dirCount=").append(this.anS);
    localStringBuilder.append(",name=").append(this.name);
    localStringBuilder.append(",path=").append(this.path);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqk
 * JD-Core Version:    0.7.0.1
 */