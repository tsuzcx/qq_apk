import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ppw<Respond extends ppu>
{
  public ppw.a<Respond> a;
  public int bjM = 2;
  private int hash;
  public int mRetryTime;
  public long timeOut = -1L;
  
  @NonNull
  public static List<ByteStringMicro> ak(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public abstract ppu a(byte[] paramArrayOfByte);
  
  public ppw.a<Respond> a()
  {
    return this.a;
  }
  
  public void a(ppw.a<Respond> parama)
  {
    this.a = parama;
  }
  
  protected abstract byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException;
  
  public String fR(String paramString)
    throws QQStoryCmdHandler.IllegalUinException
  {
    return paramString;
  }
  
  public abstract String mg();
  
  public int sr()
  {
    int i = this.hash;
    String str = mg();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (str.length() > 0)
      {
        j = 0;
        while (j < str.length())
        {
          i = i * 31 + str.charAt(j);
          j += 1;
        }
        this.hash = i;
        j = i;
      }
    }
    return j;
  }
  
  public static abstract interface a<T extends ppu>
  {
    public abstract void a(int paramInt, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppw
 * JD-Core Version:    0.7.0.1
 */