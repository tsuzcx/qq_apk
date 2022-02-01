import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apkl
  extends apku
  implements apkr
{
  private CopyOnWriteArrayList<apkl.a> aq = new CopyOnWriteArrayList();
  
  public apkl(JSONObject paramJSONObject)
    throws JSONException
  {
    bN(paramJSONObject);
  }
  
  public int Lu()
  {
    return this.aq.size();
  }
  
  public int Lv()
  {
    if (this.aq.size() > 0) {
      return 1;
    }
    return 0;
  }
  
  public void SX(String paramString)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("imgs");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        apkl.a locala = new apkl.a();
        locala.ak(localJSONObject);
        int j = this.aq.indexOf(locala);
        if (j >= 0) {
          locala.copy(this.aq.get(j));
        }
        localCopyOnWriteArrayList.add(locala);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArithmeticInfo", 2, "mergeData ,json = " + paramString);
      }
      this.aq = localCopyOnWriteArrayList;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    super.SX(paramString);
  }
  
  public apkl.a a(int paramInt)
  {
    if (paramInt >= this.aq.size()) {
      return null;
    }
    return (apkl.a)this.aq.get(paramInt);
  }
  
  public void a(apkl.a parama)
  {
    this.aq.add(parama);
  }
  
  public boolean aBi()
  {
    Iterator localIterator = this.aq.iterator();
    while (localIterator.hasNext())
    {
      apkl.a locala = (apkl.a)localIterator.next();
      if ((locala.mUploadStatus != 3) && (locala.mUploadStatus != 0)) {
        return false;
      }
    }
    return true;
  }
  
  public JSONObject af()
  {
    return k(0);
  }
  
  public void b(apkl.a parama)
  {
    this.aq.remove(parama);
  }
  
  public void bN(JSONObject paramJSONObject)
    throws JSONException
  {
    this.aq = new CopyOnWriteArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("imgs");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        apkl.a locala = new apkl.a();
        locala.ak(localJSONObject);
        this.aq.add(locala);
        i += 1;
      }
    }
  }
  
  public void c(apkl.a parama)
  {
    Iterator localIterator = this.aq.iterator();
    while (localIterator.hasNext())
    {
      apkl.a locala = (apkl.a)localIterator.next();
      if (locala.equals(parama)) {
        locala.copy(parama);
      }
    }
  }
  
  public void eax()
  {
    Iterator localIterator = this.aq.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      apkl.a locala = (apkl.a)localIterator.next();
      int j = this.HX.indexOf(Integer.valueOf(locala.mUploadStatus));
      if (j <= i) {
        break label79;
      }
      i = j;
    }
    label79:
    for (;;)
    {
      break;
      this.mUploadStatus = ((Integer)this.HX.get(i)).intValue();
      return;
    }
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int getType()
  {
    return 7;
  }
  
  public List<apkl.a> gz()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.aq.iterator();
    while (localIterator.hasNext())
    {
      apkl.a locala = (apkl.a)localIterator.next();
      if ((TextUtils.isEmpty(locala.cpN)) && (!TextUtils.isEmpty(locala.dQ))) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  public JSONObject k(int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      Iterator localIterator = this.aq.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject2 = ((apkl.a)localIterator.next()).l(paramInt);
        if (localJSONObject2 != null) {
          localJSONArray.put(localJSONObject2);
        }
      }
      localJSONObject1.put("type", "calculation").put("imgs", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject1;
    }
    return localJSONObject1;
  }
  
  public static class a
    implements plu
  {
    public String cpN;
    public String dQ;
    public int dUQ = -1;
    public int mUploadStatus = -1;
    
    public void ak(JSONObject paramJSONObject)
    {
      this.cpN = paramJSONObject.optString("raw_url");
      this.dQ = paramJSONObject.optString("fake_url");
    }
    
    public void copy(Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if (!TextUtils.isEmpty(paramObject.cpN)) {
          this.cpN = paramObject.cpN;
        }
        if (!TextUtils.isEmpty(paramObject.dQ)) {
          this.dQ = paramObject.dQ;
        }
        if (paramObject.dUQ != -1) {
          this.dUQ = paramObject.dUQ;
        }
        if (paramObject.mUploadStatus != -1) {
          this.mUploadStatus = paramObject.mUploadStatus;
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.dQ != null) && (paramObject.dQ != null)) {
          return TextUtils.equals(this.dQ, paramObject.dQ);
        }
        return TextUtils.equals(this.cpN, paramObject.cpN);
      }
      return false;
    }
    
    @Nullable
    public JSONObject l(int paramInt)
      throws JSONException
    {
      int j = 1;
      int i = 1;
      JSONObject localJSONObject = new JSONObject();
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
      while (paramInt != 0)
      {
        return null;
        paramInt = i;
        if (!TextUtils.isEmpty(this.cpN))
        {
          localJSONObject.put("raw_url", this.cpN);
          paramInt = 0;
          continue;
          paramInt = j;
          if (!TextUtils.isEmpty(this.cpN))
          {
            localJSONObject.put("raw_url", this.cpN);
            paramInt = 0;
          }
          if (!TextUtils.isEmpty(this.dQ))
          {
            localJSONObject.put("fake_url", this.dQ);
            paramInt = 0;
          }
        }
      }
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkl
 * JD-Core Version:    0.7.0.1
 */