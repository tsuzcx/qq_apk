package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupSort
  extends JceStruct
{
  public long dwGroupID = 0L;
  public long dwSortID = 0L;
  
  public GroupSort() {}
  
  public GroupSort(long paramLong1, long paramLong2)
  {
    this.dwGroupID = paramLong1;
    this.dwSortID = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
    this.dwSortID = paramJceInputStream.read(this.dwSortID, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
    paramJceOutputStream.write(this.dwSortID, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     IMMsgBodyPack.GroupSort
 * JD-Core Version:    0.7.0.1
 */