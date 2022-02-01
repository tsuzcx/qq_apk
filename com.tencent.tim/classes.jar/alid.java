import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class alid
{
  private static int duf = 4000;
  private static final Map<String, alid.a> mz = new ConcurrentHashMap(2);
  
  public static void Of(String paramString)
  {
    cG(paramString, true);
  }
  
  private static void a(alid.a parama, boolean paramBoolean)
    throws IOException
  {
    if ((parama != null) && (parama.g != null))
    {
      File localFile;
      if (parama.g.size() > 0)
      {
        if (parama.aG == null)
        {
          localFile = new File(parama.mKey + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parama.j = new FileOutputStream(localFile);
          parama.aG = localFile;
        }
        parama.g.writeTo(parama.j);
      }
      if (paramBoolean)
      {
        if (parama.j != null)
        {
          parama.j.flush();
          parama.j.close();
          parama.j = null;
        }
        if (parama.aG != null)
        {
          localFile = new File(parama.mKey);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!parama.aG.renameTo(localFile))
          {
            aqhq.copyFile(parama.aG, localFile);
            parama.aG.delete();
          }
          parama.aG = null;
        }
      }
    }
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (alid.a)mz.get(paramString);
    if (paramString != null)
    {
      if (paramString.g == null) {
        paramString.g = new ByteArrayOutputStream(paramInt << 1);
      }
      paramString.g.write(paramArrayOfByte, 0, paramInt);
      if (paramString.g.size() < duf) {}
    }
    try
    {
      a(paramString, false);
      label66:
      paramString.g.reset();
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      break label66;
    }
  }
  
  private static void cG(String paramString, boolean paramBoolean)
  {
    alid.a locala = (alid.a)mz.get(paramString);
    if ((locala == null) || (locala.g != null)) {}
    try
    {
      locala.g.close();
      label31:
      if (locala.j != null) {}
      try
      {
        locala.j.close();
        label45:
        locala.j = null;
        if ((paramBoolean) && (locala.aG != null))
        {
          locala.aG.delete();
          locala.aG = null;
        }
        mz.remove(paramString);
        return;
      }
      catch (Exception localException1)
      {
        break label45;
      }
    }
    catch (Exception localException2)
    {
      break label31;
    }
  }
  
  public static boolean nY(String paramString)
  {
    if ((alid.a)mz.get(paramString) == null)
    {
      alid.a locala = new alid.a();
      locala.mKey = paramString;
      mz.put(paramString, locala);
    }
    return true;
  }
  
  public static boolean nZ(String paramString)
  {
    alid.a locala = (alid.a)mz.get(paramString);
    if ((locala != null) && (locala.g != null)) {}
    try
    {
      a(locala, true);
      label29:
      locala.g.reset();
      cG(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
  
  public static class a
  {
    public File aG;
    public ByteArrayOutputStream g;
    public FileOutputStream j;
    public String mKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alid
 * JD-Core Version:    0.7.0.1
 */