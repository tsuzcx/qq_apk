import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class alir
{
  public static final int dun = ListenChangeVoicePanel.hm.length;
  int As = -1;
  public int dZ;
  int duo = 1;
  int dup = -1;
  public int dur;
  private int dus;
  int dut = 0;
  public int[] mE = new int[dun];
  public float yJ = 0.75F;
  float yK = 0.05F;
  
  public alir(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    try
    {
      paramQQAppInterface = paramQQAppInterface.getString("PttVoiceChangePreSender", "[]");
      JSONArray localJSONArray = new JSONArray(paramQQAppInterface);
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
        QLog.d("PttPreSendManager", 2, "init : get send record " + paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      this.mE = new int[dun];
      this.dur = 0;
      this.dZ = 0;
      paramQQAppInterface.printStackTrace();
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
  
  private String getDataString()
  {
    JSONArray localJSONArray = new JSONArray();
    int[] arrayOfInt = this.mE;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(arrayOfInt[i]);
      i += 1;
    }
    localJSONArray.put(this.dur);
    localJSONArray.put(this.dZ);
    return localJSONArray.toString();
  }
  
  private float v(int paramInt)
  {
    return this.mE[paramInt] / this.dur;
  }
  
  public void F(QQAppInterface paramQQAppInterface, int paramInt)
  {
    float f = 0.55F;
    if ((this.dup != -1) && (this.dut == 2))
    {
      if (this.dup != paramInt) {
        break label88;
      }
      this.yJ -= this.yJ * this.yK;
      if (this.yJ >= 0.55F) {
        break label111;
      }
      label55:
      this.yJ = f;
      if (this.yJ <= 0.9F) {
        break label119;
      }
    }
    label88:
    label111:
    label119:
    for (f = 0.9F;; f = this.yJ)
    {
      this.yJ = f;
      if (paramInt >= 0) {
        break label127;
      }
      this.As = paramInt;
      return;
      this.yJ += (1.0F - this.yJ) * this.yK;
      break;
      f = this.yJ;
      break label55;
    }
    label127:
    if (paramInt == this.As)
    {
      this.duo += 1;
      this.dZ += 1;
    }
    for (;;)
    {
      this.As = paramInt;
      int[] arrayOfInt = this.mE;
      arrayOfInt[paramInt] += 1;
      this.dur += 1;
      this.dus += 1;
      if (this.dus % 5 == 0) {
        dJ(paramQQAppInterface);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttInfoCollector", 2, "real send type " + paramInt);
      return;
      this.duo = 1;
    }
  }
  
  public int Hz()
  {
    if ((this.dur < 5) || (this.As < 0))
    {
      this.dup = -1;
      return -1;
    }
    if (this.duo >= 2)
    {
      this.dup = this.As;
      this.dut = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "guess type, result : " + this.dup + " case : " + this.dut + ", datas : " + getDataString());
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
  
  public void dJ(QQAppInterface paramQQAppInterface)
  {
    String str = getDataString();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putString("PttVoiceChangePreSender", str);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("PttInfoCollector", 2, "save send record " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alir
 * JD-Core Version:    0.7.0.1
 */