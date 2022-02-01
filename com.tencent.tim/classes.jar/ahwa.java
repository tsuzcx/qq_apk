import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahwa
{
  public static final int[] lv = { 1, 131073, 131078, 135176, 1376257, 2097153, 2097154, 2097155, 2097156, 1245186, 1245187, 65560, 2359297, 65560, 655362, 2424833, 2490369, 2555907, 1179651, 2686977, 2621441, 2359298, 3145729, 2555906, 3145729, 3211265, 135178, 135179, 655378, 655379, 655369, 655376, 3276801, 3276802, 655377, 1179653, 3342339, 3342337, 3342338, 135180, 135181, 655381, 131080, 131081, 655383, 655392, 131082, 655384, 655385, 2359299, 3276804, 655393, 131083, 655397, 131084, 131085, 131087, 131086, 131088, 2 };
  public String bLT;
  protected boolean ciC = true;
  protected boolean ciD = true;
  protected boolean ciE = true;
  public boolean ciF = true;
  public boolean ciG;
  public boolean ciH = true;
  public int dbK;
  public int dbL;
  public int[] lw;
  public int msgtype;
  public String senderUin;
  public long time;
  public String uin;
  public int uinType;
  public String wording;
  public ArrayList<MessageForGrayTips.HightlightItem> xg;
  
  public ahwa(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.uin = paramString1;
    this.senderUin = paramString2;
    this.wording = paramString3;
    this.uinType = paramInt1;
    this.msgtype = paramInt2;
    this.dbK = paramInt3;
    this.time = paramLong;
    dqz();
  }
  
  private void dqz()
  {
    if (this.msgtype == -5020)
    {
      this.ciC = false;
      return;
    }
    if (this.msgtype == -5021)
    {
      this.ciE = false;
      return;
    }
    if (this.msgtype == -5022)
    {
      this.ciC = false;
      this.ciD = false;
      return;
    }
    if (this.msgtype == -5023)
    {
      this.ciC = false;
      this.ciE = false;
      return;
    }
    this.msgtype = -5040;
  }
  
  public boolean HQ()
  {
    boolean bool = top.fB(this.msgtype);
    int[] arrayOfInt = lv;
    int k = arrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (arrayOfInt[i] == this.dbK) {
        j = 1;
      }
      i += 1;
    }
    return (bool) && (j != 0);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 >= paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.e(ahwb.TAG, 2, new Object[] { "revoke msg UniteGrayTipParam addHightlightItem start >= end error,start=", Integer.valueOf(paramInt1), ",end=", Integer.valueOf(paramInt2) });
      }
      return;
    }
    Object localObject7 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject3 = null;
    int k = 0;
    String str1 = null;
    String str3 = "";
    int j;
    label76:
    Object localObject2;
    int i;
    Object localObject1;
    Object localObject4;
    String str2;
    label348:
    long l;
    if (paramBundle == null)
    {
      j = -1;
      localObject2 = localObject6;
      i = k;
      localObject1 = localObject7;
      localObject4 = localObject5;
      str2 = str3;
      switch (j)
      {
      default: 
        str2 = str3;
        localObject4 = localObject5;
        localObject1 = localObject7;
        i = k;
        localObject2 = localObject6;
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 17: 
      case 18: 
      case 22: 
      case 25: 
      case 26: 
      case 31: 
      case 34: 
      case 35: 
      case 37: 
      case 41: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
        if (this.xg == null) {
          this.xg = new ArrayList();
        }
        l = 0L;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label696;
        }
        paramBundle = "#FF1e6fff";
        k = Color.parseColor(paramBundle);
        this.xg.add(new MessageForGrayTips.HightlightItem(paramInt1, paramInt2, l, i, j, (String)localObject1, (String)localObject4, str1, null, k, str2, 0));
        return;
      }
      catch (NumberFormatException paramBundle) {}
      j = paramBundle.getInt("key_action");
      localObject3 = paramBundle.getString("textColor");
      str1 = paramBundle.getString("image_resource");
      break label76;
      localObject2 = paramBundle.getString("troop_mem_uin");
      if (paramBundle.getBoolean("need_update_nick"))
      {
        i = 1;
        localObject1 = localObject7;
        localObject4 = localObject5;
        str2 = str3;
        break label348;
      }
      i = 0;
      continue;
      localObject1 = paramBundle.getString("key_action_DATA");
      localObject4 = paramBundle.getString("key_a_action_DATA");
      localObject2 = localObject6;
      i = k;
      str2 = str3;
      break label348;
      localObject2 = paramBundle.getString("troop_mem_uin");
      i = k;
      localObject1 = localObject7;
      localObject4 = localObject5;
      str2 = str3;
      break label348;
      localObject1 = paramBundle.getString("key_action_DATA");
      localObject2 = localObject6;
      i = k;
      localObject4 = localObject5;
      str2 = str3;
      break label348;
      localObject1 = paramBundle.getString("key_action_DATA");
      localObject4 = paramBundle.getString("key_a_action_DATA");
      localObject2 = paramBundle.getString("troop_mem_uin");
      i = k;
      str2 = str3;
      break label348;
      localObject1 = paramBundle.getString("key_action_DATA");
      localObject2 = localObject6;
      i = k;
      localObject4 = localObject5;
      str2 = str3;
      break label348;
      str2 = paramBundle.getString("remark");
      localObject2 = localObject6;
      i = k;
      localObject1 = localObject7;
      localObject4 = localObject5;
      break label348;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(ahwb.TAG, 2, "getHightlightMsgText ==>NumberFormatException");
      return;
      label696:
      paramBundle = (Bundle)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwa
 * JD-Core Version:    0.7.0.1
 */