import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class alik
{
  public static final int dun = ListenChangeVoicePanel.hm.length;
  int As = -1;
  public int dZ;
  int duo = 1;
  int dup = -1;
  int duq = -1;
  public int dur;
  private int dus;
  int dut = 0;
  int duu = 0;
  public int[] mE = new int[dun];
  public float yJ = 0.75F;
  float yK = 0.05F;
  
  public alik()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
    try
    {
      localObject = ((SharedPreferences)localObject).getString("PttVoiceChangePreSender", "[]");
      JSONArray localJSONArray = new JSONArray((String)localObject);
      if (localJSONArray.length() == dun + 2)
      {
        int i = 0;
        while (i < dun)
        {
          this.mE[i] = localJSONArray.getInt(i);
          i += 1;
        }
        this.dur = localJSONArray.getInt(dun);
        this.dZ = localJSONArray.getInt(dun + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "get send record " + (String)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      this.mE = new int[dun];
      this.dur = 0;
      this.dZ = 0;
      localException.printStackTrace();
    }
  }
  
  private int HB()
  {
    int i = 0;
    int m = 0;
    int k;
    for (int j = 0; i < dun; j = k)
    {
      k = j;
      if (j < this.mE[i])
      {
        k = this.mE[i];
        m = i;
      }
      i += 1;
    }
    return m;
  }
  
  private void dGj()
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.mE;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((JSONArray)localObject1).put(localObject2[i]);
      i += 1;
    }
    ((JSONArray)localObject1).put(this.dur);
    ((JSONArray)localObject1).put(this.dZ);
    localObject2 = BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit();
    localObject1 = ((JSONArray)localObject1).toString();
    ((SharedPreferences.Editor)localObject2).putString("PttVoiceChangePreSender", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
    if (QLog.isColorLevel()) {
      QLog.d("PttInfoCollector", 2, "save send record " + (String)localObject1);
    }
  }
  
  private float v(int paramInt)
  {
    return this.mE[paramInt] / this.dur;
  }
  
  public void F(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Hz();
    if (this.dup != -1)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800608D", "0X800608D", this.dut + 10, 0, this.dup + "", paramInt + "", "", "3.4.4");
      if (this.dut == 2)
      {
        if (this.dup != paramInt) {
          break label235;
        }
        this.yJ -= this.yJ * this.yK;
        if (this.yJ >= 0.55F) {
          break label258;
        }
        f = 0.55F;
        label127:
        this.yJ = f;
        if (this.yJ <= 0.9F) {
          break label266;
        }
      }
    }
    label258:
    label266:
    for (float f = 0.9F;; f = this.yJ)
    {
      this.yJ = f;
      HA();
      if (this.duq != -1) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X800608D", "0X800608D", this.duu + 20, 0, this.duq + "", paramInt + "", "", "3.4.4");
      }
      if (paramInt >= 0) {
        break label274;
      }
      return;
      label235:
      this.yJ += (1.0F - this.yJ) * this.yK;
      break;
      f = this.yJ;
      break label127;
    }
    label274:
    if (paramInt == this.As)
    {
      this.duo += 1;
      this.dZ += 1;
    }
    for (;;)
    {
      this.As = paramInt;
      paramQQAppInterface = this.mE;
      paramQQAppInterface[paramInt] += 1;
      this.dur += 1;
      this.dus += 1;
      if (this.dus % 5 == 0) {
        dGj();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttInfoCollector", 2, "real send type " + paramInt);
      return;
      this.duo = 1;
    }
  }
  
  public int HA()
  {
    if ((this.As == -1) || (this.dur < 5))
    {
      this.duq = -1;
      return -1;
    }
    if (this.duo >= 2)
    {
      this.duq = this.As;
      this.duu = 1;
    }
    for (;;)
    {
      return this.duq;
      int i = HB();
      if (this.As == i)
      {
        this.duq = this.As;
        this.duu = 2;
      }
      else if (this.dZ / this.dur > 0.85D)
      {
        this.duq = this.As;
        this.duu = 3;
      }
      else
      {
        this.duq = -1;
        this.duu = -1;
      }
    }
  }
  
  public int Hz()
  {
    if (this.dur < 5)
    {
      this.dup = -1;
      return -1;
    }
    if ((this.duo >= 2) && (this.As >= 0))
    {
      this.dup = this.As;
      this.dut = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "pre-send type " + this.dup);
      }
      return this.dup;
      int i = HB();
      if (v(i) >= this.yJ)
      {
        this.dup = i;
        this.dut = 2;
      }
      else if ((this.As >= 0) && (this.dZ / this.dur > 0.8D))
      {
        this.dup = this.As;
        this.dut = 3;
      }
      else
      {
        this.dup = -1;
        this.dut = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alik
 * JD-Core Version:    0.7.0.1
 */