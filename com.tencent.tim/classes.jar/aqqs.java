import com.tencent.mobileqq.persistence.unique;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqqs
{
  public aqqs.b a;
  public aqqs.a[] a;
  public String actUrl;
  public String backgroundColor;
  public String cover;
  public String cvY;
  public String cvZ;
  public String cwa;
  public String cwb;
  public String cwc;
  public String cwd;
  public String cwe;
  public String cwf;
  public String cwg;
  public String cwh;
  public String cwi;
  public int ecb;
  public int ecc;
  public String endTime;
  public AtomicBoolean er = new AtomicBoolean(false);
  public int feeType;
  public String fontColor;
  public String icon;
  @unique
  public String id;
  public int materialVersion;
  public String name;
  public int platId;
  public String shadowColor;
  public int signType;
  public int type;
  public String view;
  
  public aqqs() {}
  
  public aqqs(String paramString)
  {
    this.id = paramString;
    if (paramString.equals("0")) {
      efa();
    }
    this.a = new aqqs.a[5];
    while (i < 5)
    {
      this.a[i] = new aqqs.a();
      i += 1;
    }
  }
  
  public void efa()
  {
    this.id = "0";
    this.name = acfp.m(2131714565);
    this.feeType = 1;
    this.type = -1;
    this.fontColor = "#FF03081A";
    this.cwg = "#FF878B99";
  }
  
  public class a
  {
    public String cwj;
    public int ecd;
    public int ece;
    public float height;
    public int interval;
    public float posX;
    public float posY;
    public float width;
    
    public a() {}
  }
  
  public class b
  {
    public String content;
    public String coverUrl;
    public int height;
    public String imgUrl;
    public int width;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqs
 * JD-Core Version:    0.7.0.1
 */