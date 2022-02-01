import com.tencent.mobileqq.app.QQAppInterface;
import java.text.DecimalFormat;

public class aafg
{
  public static String bcH = "https://i.gtimg.cn/channel/exclusive_hb/socialpay_makehb_ani_";
  public static String bcI = "https://i.gtimg.cn/channel/exclusive_hb/socialpay_aio_ani_";
  public static String bcJ = bcH;
  private static String bcK = bcI;
  private static boolean bvm;
  public static DecimalFormat g = new DecimalFormat("#0.00");
  public long LN;
  public long LO;
  public int cgl;
  public int skinId;
  
  public static String qs()
  {
    if (!bvm)
    {
      QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
      if (localQQAppInterface != null) {
        bcK = ((aaai)localQQAppInterface.getManager(245)).a("hb_exclusive", bcI, new String[] { "aio_red", "prefix" });
      }
    }
    return bcK;
  }
  
  public String toString()
  {
    return "SpecifyAnimInfo{aId=" + this.cgl + ", minPrice=" + this.LN + ", maxPrice=" + this.LO + ", skinId=" + this.skinId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafg
 * JD-Core Version:    0.7.0.1
 */