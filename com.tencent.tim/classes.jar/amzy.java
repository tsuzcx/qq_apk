import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class amzy
{
  private ArrayList<String> Ai = new ArrayList();
  private Long ag;
  private Long ah;
  private String ccG;
  private int dEJ;
  private DataLineMsgRecord f;
  private ToServiceMsg h;
  private int nextIndex;
  
  public amzy(String paramString, Long paramLong, DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.ah = paramLong;
    this.ccG = paramString;
    this.ag = Long.valueOf(0L);
    this.nextIndex = 0;
    this.dEJ = ((this.ccG.length() + 160 - 1) / 160);
    if (i < this.ccG.length())
    {
      if (i + 160 > this.ccG.length()) {}
      for (int j = this.ccG.length() - i;; j = 160)
      {
        this.Ai.add(this.ccG.substring(i, j + i));
        i += 160;
        break;
      }
    }
    this.f = paramDataLineMsgRecord;
  }
  
  public int Jf()
  {
    return this.dEJ;
  }
  
  public void S(ToServiceMsg paramToServiceMsg)
  {
    this.h = paramToServiceMsg;
  }
  
  public int a(StringBuffer paramStringBuffer)
  {
    if (this.Ai.isEmpty()) {
      return -1;
    }
    paramStringBuffer.append((String)this.Ai.remove(0));
    int i = this.nextIndex;
    this.nextIndex = (i + 1);
    return i;
  }
  
  public boolean aws()
  {
    return this.Ai.isEmpty();
  }
  
  public DataLineMsgRecord b()
  {
    return this.f;
  }
  
  public ToServiceMsg b()
  {
    return this.h;
  }
  
  public Long e()
  {
    return this.ah;
  }
  
  public String zs()
  {
    return this.ccG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzy
 * JD-Core Version:    0.7.0.1
 */