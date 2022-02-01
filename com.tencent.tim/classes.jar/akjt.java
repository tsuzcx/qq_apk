import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class akjt
{
  public static HashMap<Integer, Integer> lY = new HashMap();
  public List<String> DX = new ArrayList();
  public int bHY = -1;
  public int bHZ;
  public String bPN = "";
  public String bTF = "";
  public String bTG = "";
  public int dmW;
  public int dmX;
  
  static
  {
    lY.put(Integer.valueOf(11), Integer.valueOf(20));
    lY.put(Integer.valueOf(3), Integer.valueOf(40));
    lY.put(Integer.valueOf(5), Integer.valueOf(60));
    lY.put(Integer.valueOf(0), Integer.valueOf(80));
    lY.put(Integer.valueOf(-1), Integer.valueOf(100));
  }
  
  public void Nw(String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(paramString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("NearbyRedInfo", 1, localNumberFormatException, new Object[0]);
        this.bPN = paramString;
      }
    }
    this.bHZ = (i + this.bHZ);
  }
  
  public void RX(int paramInt)
  {
    if (((Integer)lY.get(Integer.valueOf(paramInt))).intValue() < ((Integer)lY.get(Integer.valueOf(this.bHY))).intValue()) {
      this.bHY = paramInt;
    }
  }
  
  public void RY(int paramInt)
  {
    this.bHZ += paramInt;
  }
  
  public String toString()
  {
    return "[redType=" + this.bHY + ", redNum=" + this.bHZ + ", redTxt=" + this.bPN + ", redAppIdType=" + this.dmX + ", url=" + this.DX + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjt
 * JD-Core Version:    0.7.0.1
 */