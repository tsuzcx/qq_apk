import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class aluk
{
  public static final long[] aq = { 10009L, 10010L, 10011L, 32L };
  public long ahJ = 1514736000L;
  public long[] ar = { 10009L, 10010L, 10011L, 32L };
  public double cQ = 3.0D;
  public int dxE = 0;
  public int dxF = 100;
  public int dxG = 15;
  public int dxH = 2;
  public int dxI = 3;
  public int dxJ = 3;
  public int dxK = 10;
  public int dxL = 1;
  public int dxM = 21;
  public int dxN = 3;
  public int dxO = 5;
  public int dxP = 1;
  public int dxQ = 1;
  public int dxR = 5;
  public int dxS = 1;
  public int dxT = 10;
  public int dxU = 1;
  public int dxV;
  public int dxW = 200;
  public int dxX = 24;
  public int dxY = 48;
  public float yT = 0.01F;
  public float yU = 0.5F;
  
  public aluk(QQAppInterface paramQQAppInterface)
  {
    OY(aqmj.k(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "batch_add_friend_for_troop_config"));
  }
  
  public void OY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 4, "update content is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("switchOn")) {
          this.dxE = paramString.getInt("switchOn");
        }
        if (paramString.has("troopMemberNumLimit")) {
          this.dxF = paramString.getInt("troopMemberNumLimit");
        }
        if (paramString.has("troopJoinDayLimit")) {
          this.dxG = paramString.getInt("troopJoinDayLimit");
        }
        if (paramString.has("commonFriendProportionLimit")) {
          this.yT = ((float)paramString.getDouble("commonFriendProportionLimit"));
        }
        Object localObject;
        if (paramString.has("troopJoinLine")) {
          localObject = paramString.getString("troopJoinLine");
        }
        try
        {
          this.ahJ = (new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse((String)localObject).getTime() / 1000L);
          if (paramString.has("nonFriendProportionLimit")) {
            this.yU = ((float)paramString.getDouble("nonFriendProportionLimit"));
          }
          if (paramString.has("tipsTotalCountForTroopEveryday")) {
            this.dxI = paramString.getInt("tipsTotalCountForTroopEveryday");
          }
          if (paramString.has("tipsTotalCountForUin")) {
            this.dxJ = paramString.getInt("tipsTotalCountForUin");
          }
          if (paramString.has("activeUser"))
          {
            localObject = paramString.getJSONObject("activeUser");
            if (localObject != null)
            {
              if (((JSONObject)localObject).has("totalCommonFriends")) {
                this.dxK = ((JSONObject)localObject).getInt("totalCommonFriends");
              }
              if (((JSONObject)localObject).has("switchOn")) {
                this.dxL = ((JSONObject)localObject).getInt("switchOn");
              }
            }
          }
          if (paramString.has("highFreqInteract"))
          {
            localObject = paramString.getJSONObject("highFreqInteract");
            if (localObject != null)
            {
              if (((JSONObject)localObject).has("interactDuration")) {
                this.dxM = ((JSONObject)localObject).getInt("interactDuration");
              }
              if (((JSONObject)localObject).has("interactRounds")) {
                this.dxN = ((JSONObject)localObject).getInt("interactRounds");
              }
              if (((JSONObject)localObject).has("commonFriends")) {
                this.dxO = ((JSONObject)localObject).getInt("commonFriends");
              }
              if (((JSONObject)localObject).has("switchOn")) {
                this.dxP = ((JSONObject)localObject).getInt("switchOn");
              }
            }
          }
          if (paramString.has("newMember"))
          {
            localObject = paramString.getJSONObject("newMember");
            if (localObject != null)
            {
              if (((JSONObject)localObject).has("newMemberIndex")) {
                this.dxQ = ((JSONObject)localObject).getInt("newMemberIndex");
              }
              if (((JSONObject)localObject).has("commonFriends")) {
                this.dxR = ((JSONObject)localObject).getInt("commonFriends");
              }
              if (((JSONObject)localObject).has("switchOn")) {
                this.dxS = ((JSONObject)localObject).getInt("switchOn");
              }
            }
          }
          if (paramString.has("atMeOrReplyMe"))
          {
            localObject = paramString.getJSONObject("atMeOrReplyMe");
            if (localObject != null)
            {
              if (((JSONObject)localObject).has("maxDateLenth")) {
                this.cQ = ((JSONObject)localObject).getDouble("maxDateLenth");
              }
              if (((JSONObject)localObject).has("maxMsgCount")) {
                this.dxT = ((JSONObject)localObject).getInt("maxMsgCount");
              }
              if (((JSONObject)localObject).has("switchOn")) {
                this.dxU = ((JSONObject)localObject).getInt("switchOn");
              }
              if (((JSONObject)localObject).has("commonFriends")) {
                this.dxV = ((JSONObject)localObject).getInt("commonFriends");
              }
            }
          }
          if (paramString.has("troopMemberCount_ahn")) {
            this.dxW = paramString.getInt("troopMemberCount_ahn");
          }
          if (!paramString.has("troopType_ahn")) {
            break label991;
          }
          localObject = paramString.getJSONArray("troopType_ahn");
          this.ar = new long[((JSONArray)localObject).length()];
          int i = 0;
          while (i < this.ar.length)
          {
            this.ar[i] = ((JSONArray)localObject).optInt(i);
            i += 1;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramString.printStackTrace();
          QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, "update exception ", paramString);
        }
      }
    }
    for (;;)
    {
      QLog.i("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, String.format(Locale.getDefault(), "update {switchOn: %s, troopMemberNumLimit: %s, troopJoinDayLimit: %s, commonFriendProportionLimit:%s, troopJoinLine: %s, insertGrayTipLimit: %s, nonFriendProportionLimit: %s}", new Object[] { Integer.valueOf(this.dxE), Integer.valueOf(this.dxF), Integer.valueOf(this.dxG), Float.valueOf(this.yT), Long.valueOf(this.ahJ), Integer.valueOf(this.dxH), Float.valueOf(this.yU) }));
      QLog.d("troopBatchAddFrd.BatchAddFriendForTroopConfig", 2, "update tipsTotalCountForTroopEveryday = " + this.dxI + ",tipsTotalCountForUin = " + this.dxJ + ",au_totalCommonFriends = " + this.dxK + ",au_switchOn = " + this.dxL + ",hfi_interactDuration = " + this.dxM + ",hfi_interactRounds = " + this.dxN + ",hfi_commonFriends = " + this.dxO + ",nm_newMemberIndex = " + this.dxQ + ",nm_commonFriends = " + this.dxR + ",nm_switchOn = " + this.dxS + ",aor_maxDateLength = " + this.cQ + ",aor_maxMsgCount = " + this.dxT + ",aor_switchOn = " + this.dxU + ",aor_commonFriends = " + this.dxV + ",troopMemberCount_ahn = " + this.dxW + ",troopType_ahn = " + Arrays.toString(this.ar) + ",cacheTimeCmnFrdCntData = " + this.dxX + ",cacheTimeRemarkData = " + this.dxY);
      return;
      label991:
      if (paramString.has("cacheTimeCmnFrdCntData")) {
        this.dxX = paramString.getInt("cacheTimeCmnFrdCntData");
      }
      if (paramString.has("cacheTimeRemarkData")) {
        this.dxY = paramString.getInt("cacheTimeRemarkData");
      }
    }
  }
  
  public boolean a(TroopInfo paramTroopInfo, long[] paramArrayOfLong)
  {
    if (paramTroopInfo == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = paramArrayOfLong[i];
        if (paramTroopInfo.dwGroupClassExt == l) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public int iM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 10;
    case 2: 
      return this.dxK;
    case 3: 
      return this.dxO;
    case 4: 
      return this.dxR;
    }
    return this.dxV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluk
 * JD-Core Version:    0.7.0.1
 */