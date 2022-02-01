import android.util.SparseArray;
import java.util.ArrayList;

public class adxk
{
  public boolean bRC;
  public boolean bRD = true;
  public String bvS = "";
  public String bvT = "";
  public String bvU;
  public int cKA;
  public int cKB;
  public int cKC = -1;
  public int cKD;
  public int cKE;
  public int cKF;
  public int cKG;
  public int cKH;
  public int cKI;
  public int count;
  public SparseArray<adxk.a> cr;
  public String[] ev;
  public int[] kG;
  public int[] kH;
  public int[] kI;
  public boolean mirror = true;
  public int time;
  public ArrayList<adyc> uX = new ArrayList();
  public String zipName = "";
  
  public static void a(adxk paramadxk)
  {
    if (paramadxk == null) {}
    adxk.a locala;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramadxk.uX.size() > 0) || ((paramadxk.cKC != 10) && (paramadxk.cKC != 11)) || (paramadxk.cr == null) || (paramadxk.cr.size() != 3));
        localObject2 = (adxk.a)paramadxk.cr.get(0);
        localObject1 = (adxk.a)paramadxk.cr.get(1);
        locala = (adxk.a)paramadxk.cr.get(2);
      } while ((localObject2 == null) || (localObject1 == null) || (locala == null));
      if (paramadxk.cKC == 10)
      {
        localb1 = new adyc.b();
        localb1.key = "step1";
        localb1.bwg = ((adxk.a)localObject2).bvV;
        localb1.cLb = ((adxk.a)localObject2).cKJ;
        localb1.startX = 0.1F;
        localb1.startY = 0.0F;
        localb1.aH = 0.1F;
        localb1.aI = 0.0F;
        localb1.duration = (((adxk.a)localObject2).cKJ * 125);
        paramadxk.uX.add(localb1);
        localb1 = new adyc.b();
        localb1.key = "step2";
        localb1.bwg = ((adxk.a)localObject1).bvV;
        localb1.cLb = ((adxk.a)localObject1).cKJ;
        localb1.startX = 0.1F;
        localb1.startY = 0.0F;
        localb1.aH = 0.9F;
        localb1.aI = 0.0F;
        localb1.duration = 600L;
        paramadxk.uX.add(localb1);
        localb2 = new adyc.b();
        localb2.key = "step3";
        localb2.bwg = locala.bvV;
        localb2.cLb = locala.cKJ;
        localb2.startX = 0.9F;
        localb2.startY = 0.0F;
        localb2.aH = 0.9F;
        localb2.aI = 0.0F;
        localb2.duration = (locala.cKJ * 125);
        paramadxk.uX.add(localb2);
        paramadxk.uX.add(localb1.a());
      }
    } while (paramadxk.cKC != 11);
    adyc.b localb1 = new adyc.b();
    localb1.key = "step1";
    localb1.bwg = ((adxk.a)localObject2).bvV;
    localb1.cLb = ((adxk.a)localObject2).cKJ;
    localb1.startX = 0.1F;
    localb1.startY = 0.0F;
    localb1.aH = 0.1F;
    localb1.aI = 0.0F;
    localb1.duration = (((adxk.a)localObject2).cKJ * 125);
    paramadxk.uX.add(localb1);
    Object localObject2 = new adyc.b();
    ((adyc.b)localObject2).key = "step2";
    ((adyc.b)localObject2).bwg = ((adxk.a)localObject1).bvV;
    ((adyc.b)localObject2).cLb = ((adxk.a)localObject1).cKJ;
    ((adyc.b)localObject2).startX = 0.1F;
    ((adyc.b)localObject2).startY = 0.0F;
    ((adyc.b)localObject2).aH = 0.9F;
    ((adyc.b)localObject2).aI = 0.0F;
    ((adyc.b)localObject2).duration = 800L;
    paramadxk.uX.add(localObject2);
    adyc.b localb2 = new adyc.b();
    localb2.key = "step3";
    localb2.bwg = ((adxk.a)localObject1).bvV;
    localb2.cLb = ((adxk.a)localObject1).cKJ;
    localb2.startX = 0.9F;
    localb2.startY = 0.0F;
    localb2.aH = 1.0F;
    localb2.aI = 0.1F;
    localb2.vv = 0.95F;
    localb2.vw = 0.0F;
    localb2.vx = 1.0F;
    localb2.vy = 0.05F;
    localb2.cLg = 0;
    localb2.cLh = -90;
    localb2.duration = 600L;
    paramadxk.uX.add(localb2);
    adyc.b localb3 = new adyc.b();
    localb3.key = "step4";
    localb3.bwg = ((adxk.a)localObject1).bvV;
    localb3.cLb = ((adxk.a)localObject1).cKJ;
    localb3.startX = 1.0F;
    localb3.startY = 0.1F;
    localb3.aH = 1.0F;
    localb3.aI = 0.9F;
    localb3.cLg = -90;
    localb3.cLh = -90;
    localb3.duration = 800L;
    paramadxk.uX.add(localb3);
    adyc.b localb4 = new adyc.b();
    localb4.key = "step5";
    localb4.bwg = ((adxk.a)localObject1).bvV;
    localb4.cLb = ((adxk.a)localObject1).cKJ;
    localb4.startX = 1.0F;
    localb4.startY = 0.9F;
    localb4.aH = 0.9F;
    localb4.aI = 1.0F;
    localb4.vv = 1.0F;
    localb4.vw = 0.95F;
    localb4.vx = 0.95F;
    localb4.vy = 1.0F;
    localb4.cLg = -90;
    localb4.cLh = -180;
    localb4.duration = 600L;
    paramadxk.uX.add(localb4);
    adyc.b localb5 = new adyc.b();
    localb5.key = "step6";
    localb5.bwg = ((adxk.a)localObject1).bvV;
    localb5.cLb = ((adxk.a)localObject1).cKJ;
    localb5.startX = 0.9F;
    localb5.startY = 1.0F;
    localb5.aH = 0.1F;
    localb5.aI = 1.0F;
    localb5.cLg = -180;
    localb5.cLh = -180;
    localb5.duration = 800L;
    paramadxk.uX.add(localb5);
    adyc.b localb6 = new adyc.b();
    localb6.key = "step7";
    localb6.bwg = ((adxk.a)localObject1).bvV;
    localb6.cLb = ((adxk.a)localObject1).cKJ;
    localb6.startX = 0.1F;
    localb6.startY = 1.0F;
    localb6.aH = 0.0F;
    localb6.aI = 0.9F;
    localb6.vv = 0.05F;
    localb6.vw = 1.0F;
    localb6.vx = 0.0F;
    localb6.vy = 0.95F;
    localb6.cLg = -180;
    localb6.cLh = -270;
    localb6.duration = 600L;
    paramadxk.uX.add(localb6);
    adyc.b localb7 = new adyc.b();
    localb7.key = "step8";
    localb7.bwg = ((adxk.a)localObject1).bvV;
    localb7.cLb = ((adxk.a)localObject1).cKJ;
    localb7.startX = 0.0F;
    localb7.startY = 0.9F;
    localb7.aH = 0.0F;
    localb7.aI = 0.1F;
    localb7.cLg = -270;
    localb7.cLh = -270;
    localb7.duration = 800L;
    paramadxk.uX.add(localb7);
    Object localObject1 = new adyc.b();
    ((adyc.b)localObject1).key = "turnback";
    ((adyc.b)localObject1).bwg = locala.bvV;
    ((adyc.b)localObject1).cLb = locala.cKJ;
    ((adyc.b)localObject1).startX = 0.0F;
    ((adyc.b)localObject1).startY = 0.1F;
    ((adyc.b)localObject1).aH = 0.0F;
    ((adyc.b)localObject1).aI = 0.1F;
    ((adyc.b)localObject1).cLg = -270;
    ((adyc.b)localObject1).cLh = -270;
    ((adyc.b)localObject1).duration = (locala.cKJ * 125);
    paramadxk.uX.add(localObject1);
    paramadxk.uX.add(localb7.a());
    paramadxk.uX.add(localb6.a());
    paramadxk.uX.add(localb5.a());
    paramadxk.uX.add(localb4.a());
    paramadxk.uX.add(localb3.a());
    paramadxk.uX.add(localb2.a());
    paramadxk.uX.add(((adyc.b)localObject2).a());
    paramadxk.uX.add(localb1.a());
  }
  
  public static class a
  {
    public String bvV;
    public int cKJ;
    public int cKK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxk
 * JD-Core Version:    0.7.0.1
 */