import java.util.List;

public class jgf
{
  private static jgf b;
  private static int sPoolSize;
  public static final Object sPoolSync = new Object();
  private aofk jdField_a_of_type_Aofk;
  private jgf jdField_a_of_type_Jgf;
  private int ayS;
  private String filepath;
  private String header;
  private String imageUrl;
  private String msgId;
  private long ph;
  private String time;
  private int type;
  
  public static jgf a()
  {
    synchronized (sPoolSync)
    {
      if (b != null)
      {
        jgf localjgf = b;
        b = localjgf.jdField_a_of_type_Jgf;
        localjgf.jdField_a_of_type_Jgf = null;
        sPoolSize -= 1;
        return localjgf;
      }
      return new jgf();
    }
  }
  
  public static void bz(List<jgf> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        jgf localjgf = (jgf)paramList.remove(i);
        if (localjgf != null) {
          localjgf.recycle();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence getContent()
  {
    return this.jdField_a_of_type_Aofk;
  }
  
  public String getMsgId()
  {
    return this.msgId;
  }
  
  public String hm()
  {
    return this.header;
  }
  
  public void ks(String paramString)
  {
    this.header = paramString;
  }
  
  public void recycle()
  {
    this.type = 0;
    this.jdField_a_of_type_Aofk = null;
    this.filepath = null;
    this.ayS = 0;
    this.header = null;
    this.imageUrl = null;
    this.ph = 0L;
    this.time = null;
    this.msgId = null;
    synchronized (sPoolSync)
    {
      if (sPoolSize < 200)
      {
        this.jdField_a_of_type_Jgf = b;
        b = this;
        sPoolSize += 1;
      }
      return;
    }
  }
  
  public void setContent(String paramString)
  {
    this.jdField_a_of_type_Aofk = ily.a(paramString, 16);
  }
  
  public void setMsgId(String paramString)
  {
    this.msgId = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    return "VideoChatMessage{type=" + this.type + ", content='" + this.jdField_a_of_type_Aofk + '\'' + ", filepath='" + this.filepath + '\'' + ", sendState=" + this.ayS + ", time='" + this.time + '\'' + ", header='" + this.header + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", voiceTime=" + this.ph + ", msgId='" + this.msgId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgf
 * JD-Core Version:    0.7.0.1
 */