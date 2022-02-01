import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.lottieNew.model.layer.Layer;
import com.tencent.lottieNew.model.layer.Layer.LayerType;
import com.tencent.lottieNew.model.layer.Layer.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class trx
{
  private final long EO;
  private final long EP;
  private final tsh a = new tsh();
  private final int bCY;
  private final int bCz;
  private final Rect bounds;
  private final float dpScale;
  private final Map<String, tue> fonts = new HashMap();
  private final float frameRate;
  private final aure<Layer> g = new aure();
  private final Map<Integer, tuf> gW = new HashMap();
  private final Map<String, tse> images = new HashMap();
  private final List<Layer> layers = new ArrayList();
  private final int majorVersion;
  private final Map<String, List<Layer>> precomps = new HashMap();
  private final HashSet<String> warnings = new HashSet();
  
  private trx(Rect paramRect, long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.bounds = paramRect;
    this.EO = paramLong1;
    this.EP = paramLong2;
    this.frameRate = paramFloat1;
    this.dpScale = paramFloat2;
    this.majorVersion = paramInt1;
    this.bCY = paramInt2;
    this.bCz = paramInt3;
    if (!twy.a(this, 4, 5, 0)) {
      addWarning("Lottie only supports bodymovin >= 4.5.0");
    }
  }
  
  public Map<Integer, tuf> U()
  {
    return this.gW;
  }
  
  public Layer a(long paramLong)
  {
    return (Layer)this.g.get(paramLong);
  }
  
  public tsh a()
  {
    return this.a;
  }
  
  public float aE()
  {
    return this.dpScale;
  }
  
  public void addWarning(String paramString)
  {
    Log.w("LOTTIE", paramString);
    this.warnings.add(paramString);
  }
  
  public long ei()
  {
    return this.EO;
  }
  
  public long ej()
  {
    return this.EP;
  }
  
  public Rect getBounds()
  {
    return this.bounds;
  }
  
  public long getDuration()
  {
    return ((float)(this.EP - this.EO) / this.frameRate * 1000.0F);
  }
  
  public float getDurationFrames()
  {
    return (float)getDuration() * this.frameRate / 1000.0F;
  }
  
  public Map<String, tue> getFonts()
  {
    return this.fonts;
  }
  
  Map<String, tse> getImages()
  {
    return this.images;
  }
  
  public List<Layer> getLayers()
  {
    return this.layers;
  }
  
  public int getMajorVersion()
  {
    return this.majorVersion;
  }
  
  public int getMinorVersion()
  {
    return this.bCY;
  }
  
  @Nullable
  public List<Layer> getPrecomps(String paramString)
  {
    return (List)this.precomps.get(paramString);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator localIterator = this.layers.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Layer)localIterator.next()).toString("\t"));
    }
    return localStringBuilder.toString();
  }
  
  public int uX()
  {
    return this.bCz;
  }
  
  public static class a
  {
    public static trn a(Context paramContext, InputStream paramInputStream, tsg paramtsg)
    {
      paramContext = new tud(paramContext.getResources(), paramtsg);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
      return paramContext;
    }
    
    public static trn a(Context paramContext, String paramString, tsg paramtsg)
    {
      try
      {
        InputStream localInputStream = paramContext.getAssets().open(paramString);
        return a(paramContext, localInputStream, paramtsg);
      }
      catch (IOException paramContext)
      {
        throw new IllegalStateException("Unable to find file " + paramString, paramContext);
      }
    }
    
    public static trn a(Resources paramResources, JSONObject paramJSONObject, tsg paramtsg)
    {
      paramResources = new tug(paramResources, paramtsg);
      paramResources.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      return paramResources;
    }
    
    @Nullable
    public static trx a(Resources paramResources, InputStream paramInputStream)
    {
      try
      {
        byte[] arrayOfByte = new byte[paramInputStream.available()];
        paramInputStream.read(arrayOfByte);
        paramResources = a(paramResources, new JSONObject(new String(arrayOfByte, "UTF-8")));
        return paramResources;
      }
      catch (IOException paramResources)
      {
        Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to find file.", paramResources));
        return null;
      }
      catch (JSONException paramResources)
      {
        for (;;)
        {
          Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to load JSON.", paramResources));
          twy.closeQuietly(paramInputStream);
        }
      }
      finally
      {
        twy.closeQuietly(paramInputStream);
      }
    }
    
    public static trx a(Resources paramResources, JSONObject paramJSONObject)
    {
      int m = 0;
      float f1 = paramResources.getDisplayMetrics().density;
      int i = paramJSONObject.optInt("w", -1);
      int j = paramJSONObject.optInt("h", -1);
      if ((i != -1) && (j != -1)) {}
      int k;
      for (Object localObject = new Rect(0, 0, (int)(i * f1), (int)(j * f1));; localObject = null)
      {
        long l1 = paramJSONObject.optLong("ip", 0L);
        long l2 = paramJSONObject.optLong("op", 0L);
        float f2 = (float)paramJSONObject.optDouble("fr", 0.0D);
        paramResources = paramJSONObject.optString("v");
        for (;;)
        {
          try
          {
            paramResources = paramResources.split("[.]");
            i = Integer.parseInt(paramResources[0]);
            paramResources.printStackTrace();
          }
          catch (Exception paramResources)
          {
            try
            {
              j = Integer.parseInt(paramResources[1]);
            }
            catch (Exception paramResources)
            {
              for (;;)
              {
                j = 0;
                k = i;
                i = j;
              }
            }
            try
            {
              k = Integer.parseInt(paramResources[2]);
              m = k;
              k = i;
              paramResources = new trx((Rect)localObject, l1, l2, f2, f1, k, j, m, null);
              localObject = paramJSONObject.optJSONArray("assets");
              b((JSONArray)localObject, paramResources);
              a((JSONArray)localObject, paramResources);
              b(paramJSONObject.optJSONObject("fonts"), paramResources);
              c(paramJSONObject.optJSONArray("chars"), paramResources);
              a(paramJSONObject, paramResources);
              return paramResources;
            }
            catch (Exception paramResources)
            {
              k = i;
              i = j;
              break label214;
            }
            paramResources = paramResources;
            i = 0;
            k = 0;
          }
          label214:
          j = i;
        }
      }
    }
    
    private static void a(List<Layer> paramList, aure<Layer> paramaure, Layer paramLayer)
    {
      paramList.add(paramLayer);
      paramaure.put(paramLayer.getId(), paramLayer);
    }
    
    private static void a(@Nullable JSONArray paramJSONArray, trx paramtrx)
    {
      if (paramJSONArray == null) {
        return;
      }
      int k = paramJSONArray.length();
      int i = 0;
      label13:
      Object localObject;
      JSONArray localJSONArray;
      if (i < k)
      {
        localObject = paramJSONArray.optJSONObject(i);
        localJSONArray = ((JSONObject)localObject).optJSONArray("layers");
        if (localJSONArray != null) {
          break label47;
        }
      }
      for (;;)
      {
        i += 1;
        break label13;
        break;
        label47:
        ArrayList localArrayList = new ArrayList(localJSONArray.length());
        aure localaure = new aure();
        int j = 0;
        while (j < localJSONArray.length())
        {
          Layer localLayer = Layer.a.a(localJSONArray.optJSONObject(j), paramtrx);
          localaure.put(localLayer.getId(), localLayer);
          localArrayList.add(localLayer);
          j += 1;
        }
        localObject = ((JSONObject)localObject).optString("id");
        trx.a(paramtrx).put(localObject, localArrayList);
      }
    }
    
    private static void a(JSONObject paramJSONObject, trx paramtrx)
    {
      int j = 0;
      paramJSONObject = paramJSONObject.optJSONArray("layers");
      if (paramJSONObject == null) {}
      do
      {
        return;
        int m = paramJSONObject.length();
        int i = 0;
        while (i < m)
        {
          Layer localLayer = Layer.a.a(paramJSONObject.optJSONObject(i), paramtrx);
          int k = j;
          if (localLayer.a() == Layer.LayerType.Image) {
            k = j + 1;
          }
          a(trx.a(paramtrx), trx.a(paramtrx), localLayer);
          i += 1;
          j = k;
        }
      } while (j <= 4);
      paramtrx.addWarning("You have " + j + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
    }
    
    private static void b(@Nullable JSONArray paramJSONArray, trx paramtrx)
    {
      if (paramJSONArray == null) {
        return;
      }
      int j = paramJSONArray.length();
      int i = 0;
      label12:
      Object localObject;
      if (i < j)
      {
        localObject = paramJSONArray.optJSONObject(i);
        if (((JSONObject)localObject).has("p")) {
          break label42;
        }
      }
      for (;;)
      {
        i += 1;
        break label12;
        break;
        label42:
        localObject = tse.a.a((JSONObject)localObject);
        trx.b(paramtrx).put(((tse)localObject).getId(), localObject);
      }
    }
    
    private static void b(@Nullable JSONObject paramJSONObject, trx paramtrx)
    {
      if (paramJSONObject == null) {}
      for (;;)
      {
        return;
        paramJSONObject = paramJSONObject.optJSONArray("list");
        if (paramJSONObject != null)
        {
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            tue localtue = tue.a.a(paramJSONObject.optJSONObject(i));
            trx.c(paramtrx).put(localtue.getName(), localtue);
            i += 1;
          }
        }
      }
    }
    
    private static void c(@Nullable JSONArray paramJSONArray, trx paramtrx)
    {
      if (paramJSONArray == null) {}
      for (;;)
      {
        return;
        int j = paramJSONArray.length();
        int i = 0;
        while (i < j)
        {
          tuf localtuf = tuf.a.a(paramJSONArray.optJSONObject(i), paramtrx);
          trx.d(paramtrx).put(Integer.valueOf(localtuf.hashCode()), localtuf);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     trx
 * JD-Core Version:    0.7.0.1
 */