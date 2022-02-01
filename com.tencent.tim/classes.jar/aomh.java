import java.util.HashMap;

public class aomh
{
  long aao = 0L;
  public long apU;
  public long apV;
  public long apW;
  public long apX;
  long apY;
  public long apZ;
  public long apv;
  public long aqa;
  public aomg b;
  public String clO;
  public int dPH;
  public int dPI;
  public int dPy;
  public int mErrCode;
  public byte[] mRespData;
  public int mResult = 2;
  public HashMap<String, String> nR = new HashMap();
  public long reqCost;
  
  public aomh(aomg paramaomg)
  {
    this.b = paramaomg;
    this.apY = System.currentTimeMillis();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, HashMap<String, String> paramHashMap)
  {
    this.mResult = paramInt1;
    this.mErrCode = paramInt2;
    this.clO = paramString;
    if (paramHashMap != null) {
      this.nR.putAll(paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomh
 * JD-Core Version:    0.7.0.1
 */