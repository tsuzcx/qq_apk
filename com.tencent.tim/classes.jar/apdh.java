import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.group_effect.UserConfig;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class apdh
{
  public Vector<apdh.c> R = new Vector();
  public apdh.a a;
  private Comparator<apdh.c> ag = new apdi(this);
  public boolean cPX;
  public AtomicBoolean ec = new AtomicBoolean(false);
  
  public void SJ(String paramString)
  {
    int i = 0;
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optJSONArray("effectSwitch");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        ((JSONArray)localObject).getJSONObject(0);
        this.cPX = false;
      }
      paramString = paramString.optJSONArray("grayMsgList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        while (i < paramString.length())
        {
          localObject = paramString.getJSONObject(i);
          apdh.c localc = new apdh.c();
          localc.bI((JSONObject)localObject);
          this.R.add(localc);
          i += 1;
        }
        Collections.sort(this.R, this.ag);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Config", 2, "config mergeFromJSON enable = " + this.cPX + " graytips: " + this.R.size());
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("TroopEnterEffect.Config", 1, "mergeFromJSON error: " + paramString.getMessage());
    }
  }
  
  public static class a
  {
    public String cos;
    public int dTA;
    public int dTz = 600;
    public ConcurrentHashMap<String, apdh.b> iK = new ConcurrentHashMap();
    
    public group_effect_commu.TGetMyEffectRsp0x2 a()
    {
      group_effect_commu.TGetMyEffectRsp0x2 localTGetMyEffectRsp0x2 = new group_effect_commu.TGetMyEffectRsp0x2();
      localTGetMyEffectRsp0x2.query_interval.set(this.dTz);
      localTGetMyEffectRsp0x2.global_effect_id.set(this.dTA);
      new group_effect.EffectInfo().name.set(this.cos);
      if (this.iK.size() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.iK.entrySet().iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(((apdh.b)((Map.Entry)localIterator.next()).getValue()).a());
        }
        localTGetMyEffectRsp0x2.rpt_userconfig.set(localArrayList);
      }
      return localTGetMyEffectRsp0x2;
    }
    
    public void a(group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2)
    {
      this.dTz = paramTGetMyEffectRsp0x2.query_interval.get();
      this.dTA = paramTGetMyEffectRsp0x2.global_effect_id.get();
      Object localObject = (group_effect.EffectInfo)paramTGetMyEffectRsp0x2.st_global_effectinfo.get();
      if (localObject != null) {
        this.cos = ((group_effect.EffectInfo)localObject).name.get();
      }
      if ((paramTGetMyEffectRsp0x2.rpt_userconfig.has()) && (paramTGetMyEffectRsp0x2.rpt_userconfig.size() > 0))
      {
        paramTGetMyEffectRsp0x2 = paramTGetMyEffectRsp0x2.rpt_userconfig.get();
        int i = 0;
        while (i < paramTGetMyEffectRsp0x2.size())
        {
          localObject = (group_effect_commu.TEffectDetail)paramTGetMyEffectRsp0x2.get(i);
          apdh.b localb = new apdh.b();
          localb.a((group_effect_commu.TEffectDetail)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.EffectInfo", 2, "mergeFromPB rpt_userconfig index = " + i + " detail = " + localb.toString());
          }
          this.iK.put(localb.groupCode + "", localb);
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.EffectInfo", 2, "mergeFromPB nextReqTime = " + this.dTz + " global_effectId = " + this.dTA + " global_effectName = " + this.cos + " individual effect size = " + this.iK.size());
      }
    }
  }
  
  public static class b
  {
    public String aVQ;
    public boolean cPY;
    public int effectId;
    public long groupCode;
    
    public group_effect_commu.TEffectDetail a()
    {
      group_effect_commu.TEffectDetail localTEffectDetail = new group_effect_commu.TEffectDetail();
      Object localObject = new group_effect.UserConfig();
      ((group_effect.UserConfig)localObject).effect_id.set(this.effectId);
      ((group_effect.UserConfig)localObject).group_code.set(this.groupCode);
      localObject = ((group_effect.UserConfig)localObject).status;
      if (this.cPY) {}
      for (long l = 1L;; l = 0L)
      {
        ((PBUInt64Field)localObject).set(l);
        new group_effect.EffectInfo().name.set(this.aVQ);
        return localTEffectDetail;
      }
    }
    
    public void a(group_effect_commu.TEffectDetail paramTEffectDetail)
    {
      group_effect.UserConfig localUserConfig = (group_effect.UserConfig)paramTEffectDetail.st_userconfig.get();
      paramTEffectDetail = (group_effect.EffectInfo)paramTEffectDetail.st_effectinfo.get();
      this.effectId = localUserConfig.effect_id.get();
      this.aVQ = paramTEffectDetail.name.get();
      this.groupCode = localUserConfig.group_code.get();
      if (localUserConfig.status.get() != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        this.cPY = bool;
        return;
      }
    }
    
    public String toString()
    {
      return "{groupCode: " + this.groupCode + ", effectId: " + this.effectId + ", isOn: " + this.cPY + "}";
    }
  }
  
  public static class c
  {
    private static final String cot = acfp.m(2131715662);
    public ArrayList<apdh.c.a> BU = new ArrayList();
    public ArrayList<Integer> BV = new ArrayList();
    public String aid;
    public boolean cPZ;
    public int dTB;
    public int dTC;
    public int dTD;
    public int id;
    public boolean isValid;
    public int linkType;
    public int openMonth;
    public int priority;
    public String serviceCode;
    public String wording;
    
    private void dYK()
    {
      while (this.wording.indexOf('[') > 0)
      {
        int k = this.wording.indexOf('[');
        this.wording = this.wording.replaceFirst("\\[", "");
        int j = this.wording.indexOf(']', k);
        int i = j;
        if (j > 0)
        {
          this.wording = this.wording.replaceFirst("]", "");
          i = j - 1;
        }
        if ((i < this.wording.length() - 1) && (this.wording.charAt(i + 1) == '('))
        {
          j = i + 2;
          int m = this.wording.indexOf(')', j);
          if (m > 0)
          {
            String str = this.wording.substring(j, m);
            this.wording = (this.wording.substring(0, j - 1) + this.wording.substring(m + 1, this.wording.length()));
            apdh.c.a locala = new apdh.c.a();
            locala.start = k;
            locala.end = (i + 1);
            locala.url = str;
            this.BU.add(locala);
          }
        }
      }
    }
    
    public void bI(JSONObject paramJSONObject)
    {
      int i = 0;
      if (paramJSONObject == null)
      {
        QLog.e("TroopEnterEffect.GrayTips", 1, "mergeFromJson error grayTipsObj == null");
        return;
      }
      this.id = paramJSONObject.optInt("id");
      if (paramJSONObject.optInt("isValid") == 1)
      {
        bool = true;
        this.isValid = bool;
        this.priority = paramJSONObject.optInt("priority");
        this.wording = paramJSONObject.optString("wording");
        dYK();
        if (paramJSONObject.optInt("noLongerPrompt") != 1) {
          break label236;
        }
      }
      for (boolean bool = true;; bool = false) {
        for (;;)
        {
          this.cPZ = bool;
          if (this.cPZ) {
            this.wording += cot;
          }
          this.linkType = paramJSONObject.optInt("linkType");
          this.serviceCode = paramJSONObject.optString("serviceCode");
          this.dTB = paramJSONObject.optInt("hardType");
          this.openMonth = paramJSONObject.optInt("openMonth");
          this.dTC = paramJSONObject.optInt("hardMonth");
          this.aid = paramJSONObject.optString("aidAndroid");
          try
          {
            JSONArray localJSONArray = paramJSONObject.optJSONArray("vipType");
            if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
              break label272;
            }
            while (i < localJSONArray.length())
            {
              this.BV.add(Integer.valueOf(localJSONArray.getInt(i)));
              i += 1;
            }
            bool = false;
          }
          catch (Exception localException)
          {
            label236:
            QLog.e("TroopEnterEffect.GrayTips", 1, "mergeFromJson error: " + localException.getMessage());
            this.dTD = paramJSONObject.optInt("settingStatus");
          }
        }
      }
      label272:
    }
    
    public boolean br(int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.isValid) {
        if (paramInt1 != this.dTD)
        {
          bool1 = bool2;
          if (this.dTD != 0) {}
        }
        else if (!this.BV.contains(Integer.valueOf(paramInt2)))
        {
          bool1 = bool2;
          if (!this.BV.contains(Integer.valueOf(0))) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public static class a
    {
      int end;
      int start;
      String url;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdh
 * JD-Core Version:    0.7.0.1
 */