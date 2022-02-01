import android.util.SparseArray;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aabj
{
  private SparseArray<aadm> bN = new SparseArray();
  
  public aabj()
  {
    localObject = aagd.getQQAppInterface();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((aaai)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
      if (localJSONArray != null) {
        break label63;
      }
      QLog.i("ConfigLogic", 2, "no pkg list...");
    }
    for (;;)
    {
      return;
      label63:
      localObject = null;
      int i = 0;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            aadm localaadm = new aadm();
            localaadm.id = ((JSONObject)localObject).optString("id", "");
            localaadm.type = ((JSONObject)localObject).optInt("type", -1);
            localaadm.name = ((JSONObject)localObject).optString("name", "");
            localaadm.icon = ((JSONObject)localObject).optString("icon_pic", "");
            localaadm.params = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localaadm);
            }
            this.bN.put(localaadm.type, localaadm);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public aadm a(int paramInt1, int paramInt2)
  {
    paramInt2 = aabk.an(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (aadm)this.bN.get(paramInt2);
  }
  
  public ArrayList<WordChainHbFragment.b> a(int paramInt, avox.a parama)
  {
    int i = 2;
    if (parama != null) {
      i = avor.c(parama.bus_type, 2);
    }
    parama = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((aadm)localObject).params != null))
    {
      localObject = ((aadm)localObject).params.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          WordChainHbFragment.b localb = new WordChainHbFragment.b();
          localb.name = localJSONObject.optString("name");
          localb.subChannel = localJSONObject.optInt("sub_channel");
          localb.maxLength = localJSONObject.optInt("max_length", 0);
          localb.hint = localJSONObject.optString("hint");
          parama.add(localb);
          paramInt += 1;
        }
      }
    }
    return parama;
  }
  
  public String c(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((aadm)localObject).params != null)
      {
        localObject = ((aadm)localObject).params.optJSONArray("hint");
        QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", hint array: " + localObject);
        str = paramString;
        if (localObject != null)
        {
          str = paramString;
          if (((JSONArray)localObject).length() > 0) {
            str = ((JSONArray)localObject).optString(0, paramString);
          }
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabj
 * JD-Core Version:    0.7.0.1
 */