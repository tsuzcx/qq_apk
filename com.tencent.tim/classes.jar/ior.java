import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ior
{
  private boolean TE;
  private final LinkedHashMap<String, ior.a> i = new LinkedHashMap(12);
  
  public ior()
  {
    init();
  }
  
  private void init()
  {
    this.i.clear();
    this.i.put("BEAUTY_SKIN", new ior.a(null, 1, 50, 0));
    this.i.put("COLOR_TONE", new ior.a(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
    this.i.put("EYE_LIGHTEN", new ior.a(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
    this.i.put("TOOTH_WHITEN", new ior.a(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
    this.i.put("ENLARGE_EYE", new ior.a(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
    this.i.put("MOUTH_SHAPE", new ior.a(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
    this.i.put("CHIN", new ior.a(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
    this.i.put("FACE_THIN", new ior.a(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
    this.i.put("FACE_V", new ior.a(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
    this.i.put("FACE_SHAPE_4", new ior.a(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
    this.i.put("FACE_SHORTEN", new ior.a(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
    this.i.put("NOSE_THIN", new ior.a(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
  }
  
  public void a(ior paramior)
  {
    if (paramior == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramior.i.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ior.a locala = (ior.a)this.i.get(str);
        if (locala != null) {
          locala.level = paramior.at(str);
        }
      }
    }
  }
  
  public void aj(String paramString, int paramInt)
  {
    paramString = (ior.a)this.i.get(paramString);
    if ((paramString != null) && (paramString.level != paramInt))
    {
      paramString.level = paramInt;
      this.TE = true;
    }
  }
  
  public void aoQ()
  {
    this.TE = false;
  }
  
  public int at(String paramString)
  {
    paramString = (ior.a)this.i.get(paramString);
    if (paramString != null) {
      return paramString.level;
    }
    return 0;
  }
  
  public int au(String paramString)
  {
    paramString = (ior.a)this.i.get(paramString);
    if (paramString != null) {
      return paramString.arh;
    }
    return 0;
  }
  
  public void bj(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramString = paramString.split(",");
    int k = paramString.length;
    int j = 0;
    label24:
    Object localObject1;
    if (j < k)
    {
      localObject1 = paramString[j];
      if (localObject1 != null) {
        break label46;
      }
    }
    for (;;)
    {
      j += 1;
      break label24;
      break;
      label46:
      localObject1 = ((String)localObject1).split(":");
      if (localObject1.length == 2)
      {
        Object localObject2 = localObject1[0];
        try
        {
          int m = Integer.parseInt(localObject1[1]);
          localObject1 = (ior.a)this.i.get(localObject2);
          if (localObject1 != null) {
            ((ior.a)localObject1).level = m;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
    }
  }
  
  public void clear()
  {
    Iterator localIterator = this.i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ior.a locala = (ior.a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.level != locala.arh))
      {
        locala.level = locala.arh;
        this.TE = true;
      }
    }
  }
  
  void f(int paramInt, List<ior.a> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.i.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ior.a locala = (ior.a)((Map.Entry)localIterator.next()).getValue();
        if ((locala != null) && ((paramInt == 0) || (locala.type == paramInt))) {
          paramList.add(locala);
        }
      }
    }
  }
  
  public String getConfigStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList(this.i.keySet());
    Collections.sort(localArrayList);
    int j = 0;
    if (j < localArrayList.size())
    {
      String str = (String)localArrayList.get(j);
      ior.a locala = (ior.a)this.i.get(str);
      if (locala == null) {}
      for (;;)
      {
        j += 1;
        break;
        if (j != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str).append(":").append(locala.level);
      }
    }
    return localStringBuilder.toString();
  }
  
  public void reset()
  {
    Iterator localIterator = this.i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ior.a locala = (ior.a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.level != locala.arf))
      {
        locala.level = locala.arf;
        this.TE = true;
      }
    }
  }
  
  public boolean uS()
  {
    return this.TE;
  }
  
  public boolean uT()
  {
    Iterator localIterator = this.i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ior.a locala = (ior.a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.level != locala.arh)) {
        return true;
      }
    }
    return false;
  }
  
  public static class a
  {
    final BeautyRealConfig.TYPE a;
    final int arf;
    final int arh;
    public int level;
    public final int type;
    
    a(BeautyRealConfig.TYPE paramTYPE, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramTYPE;
      this.type = paramInt1;
      this.level = paramInt2;
      this.arf = paramInt2;
      this.arh = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ior
 * JD-Core Version:    0.7.0.1
 */