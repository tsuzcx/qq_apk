import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class adxm
{
  public adxk a;
  @Deprecated
  public adye.a a;
  public adxk b;
  public boolean bRF;
  public HashSet<String> ba = new HashSet();
  public int bubbleId;
  public adxk c;
  public int cKL;
  public int cKM = -1;
  public int cKN = 2;
  public double cs;
  public adxk d;
  public adxk e;
  public adxk f;
  public int fontColor;
  public boolean hasStroke;
  public HashMap<String, adye> jN = new HashMap(4);
  public HashMap<String, adyc> jO;
  public int[] kJ;
  public int linkColor;
  public String name;
  public int strokeColor;
  public ArrayList<adxk> uY;
  public ArrayList<Integer> uZ;
  public ArrayList<String> va;
  
  public adxm(int paramInt)
  {
    this.bubbleId = paramInt;
  }
  
  private boolean g(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = new File(paramFile, paramString);
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      bool1 = bool2;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.list();
        bool1 = bool2;
        if (paramFile != null)
        {
          bool1 = bool2;
          if (paramFile.length > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int BW()
  {
    if (afM()) {
      return ((Integer)this.uZ.get(this.cKL)).intValue();
    }
    return -1;
  }
  
  public boolean afM()
  {
    return (this.uZ != null) && (this.uZ.size() > 0);
  }
  
  public void cUV()
  {
    if (afM())
    {
      this.cKL = ((this.cKL + 1) % this.uZ.size());
      if (QLog.isColorLevel()) {
        QLog.i("BubbleConfig", 2, "now change bubble sub id: " + this.uZ.get(this.cKL));
      }
      return;
    }
    this.cKL = 0;
  }
  
  public boolean iS(int paramInt)
  {
    return (this.uZ != null) && (this.uZ.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean ll(String paramString)
  {
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[ bubbleId=" + this.bubbleId).append(",");
    localStringBuffer.append("name=" + this.name).append(" ]");
    return localStringBuffer.toString();
  }
  
  public boolean x(File paramFile)
  {
    Iterator localIterator = this.ba.iterator();
    while (localIterator.hasNext()) {
      if (g(paramFile, (String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxm
 * JD-Core Version:    0.7.0.1
 */