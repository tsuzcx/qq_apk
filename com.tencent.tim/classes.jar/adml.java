import android.content.Context;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.OCRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.ScanEntryProviderView;
import java.util.ArrayList;

public class adml
{
  public boolean bPS = true;
  public boolean bPT = true;
  private final String[] er = { acfp.m(2131713996), acfp.m(2131719028), "AR" };
  private final int[] kA = { 2131375287, 2131372587 };
  private final int[] kB = { 2130845775, 2130845776, 2130845777, 2130845778, 2130845779, 2130845780, 2130845781, 2130845782 };
  private final int[] kC = { 2130845767, 2130845768, 2130845769, 2130845770, 2130845771, 2130845772, 2130845773, 2130845774 };
  private int mType;
  private ArrayList<adml.a> uB = new ArrayList();
  
  public adml(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public int BR()
  {
    return this.kB.length;
  }
  
  public String[] L()
  {
    return this.er;
  }
  
  public int[] O()
  {
    return this.kA;
  }
  
  public adml.a a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return (adml.a)this.uB.get(paramInt);
    }
    return null;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, admh paramadmh)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramadmh);
    case 3: 
      return new ARScanEntryView(paramContext, paramadmh);
    }
    return new OCRScanEntryView(paramContext, paramadmh);
  }
  
  public int gQ(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return 2;
  }
  
  public int getCount()
  {
    return this.uB.size();
  }
  
  public void ie()
  {
    if (this.mType == 1)
    {
      if (this.bPS) {
        this.uB.add(new adml.a(1, acfp.m(2131713997)));
      }
      if (this.bPT) {
        this.uB.add(new adml.a(2, "OCR"));
      }
    }
  }
  
  public int[] k(int paramInt)
  {
    if (paramInt == 0) {
      return this.kB;
    }
    if (paramInt == 1) {
      return this.kC;
    }
    return null;
  }
  
  public static class a
  {
    public String buB;
    public int cdN;
    
    public a(int paramInt, String paramString)
    {
      this.cdN = paramInt;
      this.buB = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adml
 * JD-Core Version:    0.7.0.1
 */