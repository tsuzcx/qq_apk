import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

public class addi
  extends addc
{
  public Boolean ao = Boolean.valueOf(false);
  public Boolean ap = Boolean.valueOf(false);
  public String bse = "";
  public String bsf;
  public int cBI = 1;
  public int cCU = 3;
  public ArrayList<adbm.a> ud = new ArrayList();
  
  public addi(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3, ArrayList<adbm.a> paramArrayList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    super(paramString1, paramInt1, 2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.ao = paramBoolean1;
    this.ap = paramBoolean2;
    this.cBI = paramInt4;
    this.cCU = paramInt5;
    this.ud = paramArrayList;
    this.bse = paramString2;
    this.bsf = paramString3;
  }
  
  public adbm.a a()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromRandFunction");
    if (this.ud.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ud.iterator();
    while (localIterator.hasNext())
    {
      adbm.a locala = (adbm.a)localIterator.next();
      if (locala.mTriggerType == 3) {
        localArrayList.add(locala);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return (adbm.a)localArrayList.get(new Random().nextInt(localArrayList.size()));
  }
  
  public adbm.a a(int paramInt)
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromClickOperation");
    if (this.ud.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.ud.iterator();
    while (localIterator.hasNext())
    {
      adbm.a locala = (adbm.a)localIterator.next();
      if ((paramInt <= locala.cBL) && (paramInt >= locala.cBK) && (locala.mTriggerType == 1)) {
        return locala;
      }
    }
    return null;
  }
  
  public adbm.a b()
  {
    QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromTime");
    if (this.ud.isEmpty()) {
      return null;
    }
    int i = Calendar.getInstance().get(11);
    Iterator localIterator = this.ud.iterator();
    while (localIterator.hasNext())
    {
      adbm.a locala = (adbm.a)localIterator.next();
      if ((i < locala.cBL) && (i >= locala.cBK) && (locala.mTriggerType == 2)) {
        return locala;
      }
    }
    return null;
  }
  
  public boolean iM(int paramInt)
  {
    if (this.ud.isEmpty()) {
      return false;
    }
    Iterator localIterator = this.ud.iterator();
    while (localIterator.hasNext()) {
      if (((adbm.a)localIterator.next()).mTriggerType == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public String sj()
  {
    if ((this.ud.isEmpty()) || (this.ud.size() > 1)) {
      return null;
    }
    return ((adbm.a)this.ud.get(0)).mVideoUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addi
 * JD-Core Version:    0.7.0.1
 */