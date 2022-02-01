import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class yzv
{
  private boolean bpB;
  public String[] cV;
  public ArrayList<zad> eF = new ArrayList();
  public int[] iX;
  
  public yzv(boolean paramBoolean)
  {
    if ((paramBoolean) && (!anwa.aze())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bpB = paramBoolean;
      buildData();
      return;
    }
  }
  
  public boolean UU()
  {
    return this.bpB;
  }
  
  public boolean aE(boolean paramBoolean)
  {
    if ((paramBoolean) && (!anwa.aze()))
    {
      paramBoolean = true;
      if (paramBoolean == this.bpB) {
        break label200;
      }
      this.bpB = paramBoolean;
      if (!paramBoolean) {
        break label146;
      }
      this.eF.add(0, new zad(0, 2131365318, acfp.m(2131704424)));
    }
    int j;
    for (;;)
    {
      j = this.eF.size();
      this.cV = new String[j];
      this.iX = new int[j];
      int i = 0;
      while (i < j)
      {
        zad localzad = (zad)this.eF.get(i);
        if (localzad.id == 5) {
          localzad.aZR = obt.lb();
        }
        this.iX[i] = localzad.ccr;
        this.cV[i] = localzad.aZR;
        i += 1;
      }
      paramBoolean = false;
      break;
      label146:
      this.eF.remove(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend1:" + paramBoolean + " tabSize:" + j);
    }
    return true;
    label200:
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend2:" + paramBoolean + " tabSize:" + this.eF.size());
    }
    return false;
  }
  
  protected void buildData()
  {
    this.eF.clear();
    this.eF.add(new zad(6, 2131365315, acfp.m(2131704456)));
    this.eF.add(new zad(1, 2131365314, acfp.m(2131704427)));
    this.eF.add(new zad(2, 2131365319, acfp.m(2131704469)));
    this.eF.add(new zad(3, 2131365312, acfp.m(2131704453)));
    this.eF.add(new zad(4, 2131365316, acfp.m(2131704449)));
    this.eF.add(new zad(5, 2131365317, obt.lb()));
    int j = this.eF.size();
    this.cV = new String[j];
    this.iX = new int[j];
    int i = 0;
    while (i < j)
    {
      this.iX[i] = ((zad)this.eF.get(i)).ccr;
      this.cV[i] = ((zad)this.eF.get(i)).aZR;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "buildData showRecommend:" + this.bpB + " tabSize:" + j);
    }
  }
  
  public int fy(int paramInt)
  {
    int i = 0;
    while (i < this.eF.size())
    {
      if (((zad)this.eF.get(i)).id == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.eF.size())) {
      return ((zad)this.eF.get(paramInt)).id;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzv
 * JD-Core Version:    0.7.0.1
 */