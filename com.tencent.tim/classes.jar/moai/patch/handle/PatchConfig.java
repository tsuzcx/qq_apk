package moai.patch.handle;

import java.util.ArrayList;
import java.util.List;

public class PatchConfig
{
  private String cmd;
  private List<String> natives = new ArrayList();
  private long new_dex_merge_file_adler32;
  private long new_res_merge_file_adler32;
  private long old_dex_merge_file_adler32;
  private long old_res_merge_file_adler32;
  
  public String getCmd()
  {
    return this.cmd;
  }
  
  public List<String> getNatives()
  {
    return this.natives;
  }
  
  public long getNew_dex_merge_file_adler32()
  {
    return this.new_dex_merge_file_adler32;
  }
  
  public long getNew_res_merge_file_adler32()
  {
    return this.new_res_merge_file_adler32;
  }
  
  public long getOld_dex_merge_file_adler32()
  {
    return this.old_dex_merge_file_adler32;
  }
  
  public long getOld_res_merge_file_adler32()
  {
    return this.old_res_merge_file_adler32;
  }
  
  public void setCmd(String paramString)
  {
    this.cmd = paramString;
  }
  
  public void setNatives(List<String> paramList)
  {
    this.natives = paramList;
  }
  
  public void setNew_dex_merge_file_adler32(long paramLong)
  {
    this.new_dex_merge_file_adler32 = paramLong;
  }
  
  public void setNew_res_merge_file_adler32(long paramLong)
  {
    this.new_res_merge_file_adler32 = paramLong;
  }
  
  public void setOld_dex_merge_file_adler32(long paramLong)
  {
    this.old_dex_merge_file_adler32 = paramLong;
  }
  
  public void setOld_res_merge_file_adler32(long paramLong)
  {
    this.old_res_merge_file_adler32 = paramLong;
  }
  
  public String toString()
  {
    return "PatchConfig{cmd='" + this.cmd + '\'' + ", old_dex_merge_file_adler32=" + this.old_dex_merge_file_adler32 + ", new_dex_merge_file_adler32=" + this.new_dex_merge_file_adler32 + ", old_res_merge_file_adler32=" + this.old_res_merge_file_adler32 + ", new_res_merge_file_adler32=" + this.new_res_merge_file_adler32 + ", natives=" + this.natives + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.PatchConfig
 * JD-Core Version:    0.7.0.1
 */