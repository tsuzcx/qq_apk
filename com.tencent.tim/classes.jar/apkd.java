import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteDisplayView.b;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apkd
{
  private static final String TAG = apkd.class.getSimpleName();
  protected List<ParagraphInfo> HU;
  protected JSONArray S;
  protected ReciteDisplayView.b a;
  protected JSONObject bV;
  protected int dUN;
  protected long mStartTime;
  
  public apkd(List<ParagraphInfo> paramList, ReciteDisplayView.b paramb, String paramString)
  {
    this.a = paramb;
    this.HU = paramList;
    this.mStartTime = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.S = new JSONArray(paramString);
      return;
    }
    catch (JSONException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, paramList.toString());
    }
  }
  
  public String Bp()
  {
    if ((this.HU == null) || (this.S == null)) {
      return null;
    }
    return this.S.toString();
  }
  
  public void WO(int paramInt)
  {
    if ((this.HU == null) || (this.S == null)) {}
    for (;;)
    {
      return;
      float f;
      if (this.dUN < this.S.length()) {
        f = paramInt / 1000.0F;
      }
      try
      {
        if (this.bV != null)
        {
          long l = this.bV.getLong("t");
          if (f <= (float)l) {
            continue;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(TAG, 2, localJSONException1.toString());
            continue;
            if (QLog.isColorLevel()) {
              QLog.e(TAG, 2, "w error:" + j);
            }
          }
        }
      }
      paramInt = this.dUN;
      while (paramInt < this.S.length())
      {
        for (;;)
        {
          try
          {
            localJSONObject = (JSONObject)this.S.get(paramInt);
            localObject = localJSONObject.optString("t");
          }
          catch (JSONException localJSONException2)
          {
            JSONObject localJSONObject;
            Object localObject;
            int i;
            int j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(TAG, 2, "JSONException:" + localJSONException2.toString());
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(TAG, 2, "p error:" + i);
            continue;
            this.bV = localJSONException2;
          }
          try
          {
            if (f <= Float.valueOf((String)localObject).floatValue()) {
              continue;
            }
            i = localJSONObject.optInt("p");
            j = localJSONObject.optInt("w");
            if ((i < 0) || (i >= this.HU.size())) {
              continue;
            }
            localObject = ((ParagraphInfo)this.HU.get(i)).generateOrGetWordInfoList(i);
            if ((j < 0) || (j >= ((List)localObject).size())) {
              continue;
            }
            localObject = (WordInfo)((List)localObject).get(j);
            ((WordInfo)localObject).setColor(localJSONObject.optInt("s"));
            if (this.a != null) {
              this.a.a((WordInfo)localObject);
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(TAG, 2, "NumberFormatException:" + localNumberFormatException.toString());
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public void be(int paramInt1, int paramInt2, int paramInt3)
  {
    float f = (float)(System.currentTimeMillis() - this.mStartTime) / 1000.0F;
    if (this.S == null) {
      this.S = new JSONArray();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("p", paramInt1);
      localJSONObject.put("s", paramInt3);
      localJSONObject.put("t", f);
      localJSONObject.put("w", paramInt2);
      this.S.put(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "addWordResult:" + localJSONException.toString());
    }
  }
  
  public void eat()
  {
    if (this.S == null) {
      return;
    }
    int i = this.dUN;
    for (;;)
    {
      if (i < this.S.length())
      {
        int j;
        try
        {
          JSONObject localJSONObject = (JSONObject)this.S.get(i);
          j = localJSONObject.optInt("p");
          int k = localJSONObject.optInt("w");
          if ((j < 0) || (j >= this.HU.size())) {
            break label224;
          }
          Object localObject = ((ParagraphInfo)this.HU.get(j)).generateOrGetWordInfoList(j);
          if ((k >= 0) && (k < ((List)localObject).size()))
          {
            localObject = (WordInfo)((List)localObject).get(k);
            ((WordInfo)localObject).setColor(localJSONObject.optInt("s"));
            if (this.a != null) {
              this.a.a((WordInfo)localObject);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(TAG, 2, "w error:" + k);
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label270;
          }
        }
        QLog.e(TAG, 2, "JSONException:" + localJSONException.toString());
        break label270;
        label224:
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "p error:" + j);
        }
      }
      else
      {
        this.dUN = 0;
        this.bV = null;
        return;
      }
      label270:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkd
 * JD-Core Version:    0.7.0.1
 */