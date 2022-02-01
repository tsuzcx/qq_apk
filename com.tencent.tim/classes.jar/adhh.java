public class adhh
  extends adhs
{
  public adhh.a[] a = null;
  public String bsP = "";
  public int cFR = -1;
  public int cFS = 0;
  public int cFT = 0;
  public String path;
  public int retCode = -1;
  public String retMsg = "";
  public int score = 0;
  public String sessionId = "";
  
  public static boolean a(adhh paramadhh)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramadhh != null)
    {
      bool1 = bool2;
      if (paramadhh.retCode == 0)
      {
        bool1 = bool2;
        if (paramadhh.cFR == 0)
        {
          bool1 = bool2;
          if (paramadhh.a != null)
          {
            bool1 = bool2;
            if (paramadhh.a[0].cFW == 0)
            {
              bool1 = bool2;
              if (paramadhh.a[0].dl != null) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    if (this.a != null)
    {
      String str1 = "ImageTags{";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.a.length) {
          break;
        }
        str1 = str1 + ", imageTags[" + i + "] = " + this.a[i];
        i += 1;
      }
    }
    String str2 = "null";
    return "ARCloudMarkerRecogResult{retCode = " + this.retCode + ", retMsg = " + this.retMsg + ", recogSvrRetCode = " + this.cFR + ", recogSvrRetMsg = " + this.bsP + ", sessionId = " + this.sessionId + ", imageTags = " + str2 + ", timeLen = " + this.cFS + ", score = " + this.score + ", kptNum = " + this.cFT + super.toString() + '}';
  }
  
  public static class a
  {
    public int cFU = 0;
    public int cFV = 0;
    public int cFW = -1;
    public byte[] dl = null;
    public String imageId = "";
    public String tagName = "";
    public float uQ = 0.0F;
    
    public String toString()
    {
      try
      {
        String str1 = new String(this.dl, "utf-8");
        return "ImageTag{imageId = " + this.imageId + ", tagName = " + this.tagName + ", tagConfidence = " + this.cFU + ", tagConfidence_f = " + this.uQ + ", need_check_lbs = " + this.cFV + ", cdbRetCode = " + this.cFW + ", cdbRes = " + str1 + '}';
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */