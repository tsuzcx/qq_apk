import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class aoko
{
  public static String clA = "richfile";
  public static String defaultTag;
  static String[] hn = { "up", "down", "down" };
  static String[] ho = { "file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg" };
  private static String[] hp = { "LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown" };
  public aojn a;
  public aoko.a a;
  public aoko.b a;
  public int actionType = -1;
  public long apI;
  public long apJ;
  public long apK;
  public aoko.a b;
  public aoko.b b;
  public aoko.a c = new aoko.a();
  public boolean cMv;
  public boolean cMw;
  public String clB = "";
  public String clC;
  public String clr;
  public String cls;
  public String clt;
  public String clu;
  public String clv;
  public String clw;
  public String clx;
  public String cly;
  public String clz = "";
  public int commandId;
  public int dOx = -1;
  public int dPr;
  public int dPs;
  public String domain;
  public long endTime;
  public int errorCode;
  public byte[] fL;
  public File file;
  public String fileKey = "";
  public String fileMd5;
  public String filePath = "";
  public long fileSize;
  public int fileType = -1;
  public String fileUrl;
  public String friendUin;
  public InputStream i;
  public String logTag = defaultTag;
  public String mUin;
  public String peerUin = "";
  public String selfUin = "";
  public String serverPath;
  public long startTime;
  public int status = -1;
  public String thumbPath = "";
  public String thumbUrl;
  public String tmpFilePath = "";
  public long transferedSize;
  public int uinType = -1;
  public long uniseq;
  public String[] urls;
  
  static
  {
    defaultTag = "defaultTag";
  }
  
  public aoko()
  {
    this.jdField_a_of_type_Aoko$a = new aoko.a();
    this.jdField_b_of_type_Aoko$a = new aoko.a();
    this.jdField_a_of_type_Aoko$b = new aoko.b();
    this.jdField_b_of_type_Aoko$b = new aoko.b();
    this.startTime = System.currentTimeMillis();
  }
  
  public aoko(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Aoko$a = new aoko.a();
    this.jdField_b_of_type_Aoko$a = new aoko.a();
    this.jdField_a_of_type_Aoko$b = new aoko.b();
    this.jdField_b_of_type_Aoko$b = new aoko.b();
    try
    {
      this.startTime = System.currentTimeMillis();
      this.mUin = paramString1;
      this.actionType = paramInt;
      if (paramString2 == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.filePath = paramString2;
        this.file = new File(this.filePath);
        if (this.file.exists())
        {
          this.fileSize = this.file.length();
          paramInt = paramString2.lastIndexOf(".");
          if ((paramInt >= 0) && (paramInt < paramString2.length())) {
            this.clr = paramString2.substring(paramInt).toLowerCase();
          }
        }
        RW(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    this.serverPath = paramString2;
  }
  
  private void RW(String paramString)
    throws FileNotFoundException
  {
    this.i = new FileInputStream(paramString);
  }
  
  public static String vd()
  {
    try
    {
      Thread.sleep(10L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void dVw()
  {
    try
    {
      if (this.i != null) {
        this.i.close();
      }
      label14:
      this.i = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void jJ(int paramInt1, int paramInt2)
  {
    aoko.b localb;
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      localb = this.jdField_a_of_type_Aoko$b;
      localb.retryCount += 1;
      return;
    case 4: 
      localb = this.jdField_a_of_type_Aoko$b;
      localb.apN += paramInt2;
      return;
    case 3: 
      localb = this.jdField_a_of_type_Aoko$b;
      localb.apM += paramInt2;
      return;
    }
    this.jdField_a_of_type_Aoko$b.cMx = true;
  }
  
  public void lG(long paramLong)
  {
    this.uniseq = paramLong;
  }
  
  public void setFileType(int paramInt)
  {
    this.fileType = paramInt;
  }
  
  public static class a
  {
    public long apL = 9223372036854775807L;
    public int dPb;
    public int dPc;
    public int errCode = 9001;
    public String errDesc = "";
    public long finishTime;
    public boolean isReported;
    public boolean result = true;
    public int retryCount = 1;
    public long startTime;
    
    public String AM()
    {
      if (Nt())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("elapsed:" + hl());
        localStringBuilder.append(",tryCount:" + this.retryCount);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      return "{}";
    }
    
    public boolean Nt()
    {
      return (this.startTime != 0L) || (this.finishTime != 0L);
    }
    
    public String fE(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      if (this.result) {
        if (this.startTime > 0L)
        {
          localStringBuilder.append("1");
          localStringBuilder.append("_");
        }
      }
      for (;;)
      {
        if ((!(this instanceof aoko.b)) && (!this.result) && (this.dPb > 0))
        {
          this.dPc += this.dPb;
          this.dPb = 0;
        }
        localStringBuilder.append(this.dPb).append("_");
        localStringBuilder.append(this.dPc).append("_");
        localStringBuilder.append(this.finishTime - this.startTime);
        return localStringBuilder.toString();
        localStringBuilder.append("-1");
        break;
        localStringBuilder.append("0").append("_");
      }
    }
    
    public long hl()
    {
      long l = 0L;
      if ((this.startTime != 0L) && (this.finishTime != 0L)) {
        l = this.finishTime - this.startTime;
      }
      while ((this.startTime == 0L) && (this.finishTime == 0L)) {
        return l;
      }
      return 612345L;
    }
    
    public void reset()
    {
      this.result = true;
      this.startTime = 0L;
      this.finishTime = 0L;
      this.errCode = 9001;
      this.errDesc = "";
      this.isReported = false;
      this.retryCount = 1;
      this.dPb = 0;
      this.dPc = 0;
      this.apL = 9223372036854775807L;
    }
    
    public String toString()
    {
      return "result:" + this.result + " startTime:" + this.startTime + " finishTime:" + this.finishTime + " errCode:" + this.errCode;
    }
  }
  
  public static class b
    extends aoko.a
  {
    public long apM;
    public long apN;
    public boolean cMx;
    public boolean cMy;
    public int cRn;
    public String clD;
    public String clE;
    public String clF;
    public long contentSize;
    public HashMap<String, String> gu = new HashMap();
    
    public String AM()
    {
      if (Nt())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("elapsed:" + hl());
        localStringBuilder.append(",tryCount:" + this.retryCount);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      return "{}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoko
 * JD-Core Version:    0.7.0.1
 */