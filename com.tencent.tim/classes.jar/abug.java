import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class abug
  implements BusinessObserver
{
  private abug.a a;
  private String bhD;
  private String mCurrentUin;
  private LRULinkedHashMap<String, String> n;
  
  public abug(abug.a parama)
  {
    this.a = parama;
    this.n = new LRULinkedHashMap(32);
  }
  
  public void a(Context paramContext, long paramLong, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.thank_zan");
        if (!TextUtils.isEmpty(paramString1)) {
          break label232;
        }
        paramString1 = "android";
        ((JSONObject)localObject).put("from", paramString1);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString2));
        ((JSONObject)localObject).put("chestid", paramLong);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, ailu.class);
        paramContext.putExtra("extra_cmd", "apollo_interact.thank_zan");
        paramContext.putExtra("extra_callbackid", paramString2);
        paramContext.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramContext.setObserver(this);
        paramAppInterface.startServlet(paramContext);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("BoxCardHandler", 2, "addFlower failed ", paramContext);
      return;
      label232:
      paramString1 = "android." + paramString1;
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramString1 == null)) {
      return;
    }
    this.bhD = paramString1;
    this.mCurrentUin = paramAppInterface.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.take_chips");
        if (!TextUtils.isEmpty(paramString2)) {
          break label246;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("dstuin", Long.parseLong(paramString1));
        ((JSONObject)localObject).put("skey", ((TicketManager)paramAppInterface.getManager(2)).getSkey(this.mCurrentUin));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, ailu.class);
        paramContext.putExtra("extra_cmd", "apollo_interact.take_chips");
        paramContext.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramContext.putExtra("extra_callbackid", paramString1);
        paramContext.setObserver(this);
        paramAppInterface.startServlet(paramContext);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("BoxCardHandler", 2, "OpenPandora failed ", paramContext);
      return;
      label246:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    long l2;
    label236:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                i = paramBundle.getInt("extra_result_code");
                str1 = paramBundle.getString("extra_callbackid");
                str2 = paramBundle.getString("extra_cmd");
                if (QLog.isColorLevel()) {
                  QLog.d("BoxCardHandler", 2, "OpenPandora onReceive type:" + paramInt + ", isSuccess: " + paramBoolean + ", svrRet: " + i + ", uin:" + str1);
                }
                l2 = -9223372036854775808L;
                if (!paramBoolean) {
                  break label2493;
                }
                l1 = l2;
                try
                {
                  paramBundle = paramBundle.getByteArray("extra_data");
                  l1 = l2;
                  localObject1 = new WebSSOAgent.UniSsoServerRsp();
                  l1 = l2;
                  ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
                  l1 = l2;
                  l2 = ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get();
                  l1 = l2;
                  if (!"apollo_interact.thank_zan".equals(str2)) {
                    break label236;
                  }
                  l1 = l2;
                  if (this.a != null)
                  {
                    l1 = l2;
                    this.a.a("apollo_interact.thank_zan", paramBoolean, l2, null, str1);
                    return;
                  }
                }
                catch (Exception paramBundle)
                {
                  if (this.a != null) {
                    this.a.a(str2, false, l1, null, str1);
                  }
                }
              }
            } while (!QLog.isColorLevel());
            QLog.e("BoxCardHandler", 2, paramBundle.getMessage());
            return;
            l1 = l2;
            if (!"apollo_core.get_user_info".equals(str2)) {
              break;
            }
            l1 = l2;
            paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
            l1 = l2;
            if (QLog.isColorLevel())
            {
              l1 = l2;
              QLog.d("BoxCardHandler", 2, "get Url onReceive retCode->" + l2 + " respStr->" + paramBundle);
            }
            l1 = l2;
            paramBundle = new JSONObject(paramBundle).optJSONObject("data").optString("qq_head");
            l1 = l2;
            if (!TextUtils.isEmpty(paramBundle))
            {
              l1 = l2;
              this.n.put(str1, paramBundle);
            }
            l1 = l2;
          } while (this.a == null);
          l1 = l2;
          this.a.a("apollo_core.get_user_info", true, 0L, paramBundle, str1);
          return;
          l1 = l2;
        } while (!"apollo_interact.take_chips".equals(str2));
        l1 = l2;
        if (TextUtils.isEmpty(this.bhD)) {
          break;
        }
        l1 = l2;
      } while (!this.bhD.equals(str1));
      if (l2 != -501028L) {
        break;
      }
      l1 = l2;
    } while (this.a == null);
    long l1 = l2;
    this.a.a("apollo_interact.take_chips", paramBoolean, l2, null, str1);
    return;
    l1 = l2;
    paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get();
    l1 = l2;
    if (QLog.isColorLevel())
    {
      l1 = l2;
      QLog.d("BoxCardHandler", 2, "onReceive retCode->" + l2 + " respStr->" + paramBundle);
    }
    l1 = l2;
    Object localObject2 = new JSONObject(paramBundle).optJSONObject("data");
    l1 = l2;
    ((JSONObject)localObject2).optLong("checkpoint");
    l1 = l2;
    long l3 = ((JSONObject)localObject2).optLong("master");
    l1 = l2;
    long l4 = ((JSONObject)localObject2).optLong("chestid");
    l1 = l2;
    short s = (short)((JSONObject)localObject2).optInt("chipnum");
    l1 = l2;
    int i = ((JSONObject)localObject2).optInt("mine_chipnum");
    l1 = l2;
    int j = ((JSONObject)localObject2).optInt("goldNum");
    l1 = l2;
    Object localObject3 = ((JSONObject)localObject2).optString("back_color");
    l1 = l2;
    Object localObject1 = ((JSONObject)localObject2).optString("card_mask_color");
    l1 = l2;
    paramBundle = ((JSONObject)localObject2).optString("nick");
    l1 = l2;
    if (TextUtils.isEmpty(paramBundle)) {}
    label708:
    abud localabud;
    ArrayList localArrayList;
    label888:
    JSONObject localJSONObject;
    for (paramBundle = "TA";; paramBundle = paramBundle + "...")
    {
      l1 = l2;
      localabud = new abud();
      l1 = l2;
      localabud.bhK = paramBundle;
      l1 = l2;
      localabud.Ow = ((JSONObject)localObject2).optLong("firstcode");
      l1 = l2;
      localArrayList = new ArrayList(4);
      l1 = l2;
      localabud.bhD = str1;
      l1 = l2;
      localabud.Ox = l4;
      l1 = l2;
      localabud.mCurrentUin = this.mCurrentUin;
      l1 = l2;
      localabud.zl = l2;
      l1 = l2;
      localabud.csg = ApolloUtil.cj((String)localObject3);
      l1 = l2;
      localabud.bhL = ((JSONObject)localObject2).optString("topUrl");
      l1 = l2;
      localabud.bhM = ((JSONObject)localObject2).optString("bottomUrl");
      l1 = l2;
      localObject3 = ((JSONObject)localObject2).optJSONArray("giftTotalList");
      if (localObject3 == null) {
        break label1133;
      }
      l1 = l2;
      int k = ((JSONArray)localObject3).length();
      paramInt = 0;
      if (paramInt >= k) {
        break label1133;
      }
      l1 = l2;
      localJSONObject = ((JSONArray)localObject3).optJSONObject(paramInt);
      if (localJSONObject != null) {
        break;
      }
      break label2525;
      l1 = l2;
      if (jji.length(paramBundle) <= 20) {
        break label2522;
      }
      l1 = l2;
      paramBundle = jji.subString(paramBundle, 0, 20);
      l1 = l2;
    }
    l1 = l2;
    Object localObject4 = new abud.b();
    l1 = l2;
    ((abud.b)localObject4).cso = localJSONObject.optInt("giftType");
    l1 = l2;
    ((abud.b)localObject4).csp = localJSONObject.optInt("giftTotal");
    l1 = l2;
    ((abud.b)localObject4).mIconUrl = localJSONObject.optString("iconUrl");
    l1 = l2;
    ((abud.b)localObject4).bhQ = localJSONObject.optString("jumpUrl");
    l1 = l2;
    boolean bool;
    if (localJSONObject.optInt("isShow") == 1)
    {
      bool = true;
      label1067:
      l1 = l2;
      ((abud.b)localObject4).mIsShow = bool;
      l1 = l2;
      if (((abud.b)localObject4).mIsShow)
      {
        l1 = l2;
        localabud.iA.put(Integer.valueOf(((abud.b)localObject4).cso), localObject4);
        l1 = l2;
        localabud.wx.add(localObject4);
        break label2525;
        label1133:
        l1 = l2;
        localObject3 = (abud.b)localabud.iA.get(Integer.valueOf(3));
        if (localObject3 != null)
        {
          l1 = l2;
          if (((abud.b)localObject3).csp == 0)
          {
            l1 = l2;
            ((abud.b)localObject3).csp = i;
          }
        }
        l1 = l2;
        localObject3 = (abud.b)localabud.iA.get(Integer.valueOf(7));
        if (localObject3 != null)
        {
          l1 = l2;
          if (((abud.b)localObject3).csp == 0)
          {
            l1 = l2;
            ((abud.b)localObject3).csp = j;
          }
        }
        l1 = l2;
        localObject3 = ((JSONObject)localObject2).optJSONArray("tooklist");
        l1 = l2;
        localObject2 = ((JSONObject)localObject2).optJSONArray("tookGiftList");
        i = -1;
        l1 = l2;
        if (localabud.Ow != 0L) {
          break label2538;
        }
        l1 = l2;
        if (localabud.zl != -501031L) {
          break label2556;
        }
        break label2538;
        label1296:
        j = i;
        if (l2 == -501040L) {
          break label2571;
        }
        paramInt = i;
        if (localObject3 != null)
        {
          l1 = l2;
          paramInt = i;
          if (((JSONArray)localObject3).length() > 0)
          {
            j = 0;
            label1335:
            l1 = l2;
            paramInt = i;
            if (j < ((JSONArray)localObject3).length())
            {
              l1 = l2;
              localJSONObject = (JSONObject)((JSONArray)localObject3).get(j);
              l1 = l2;
              localObject4 = new abud.a();
              l1 = l2;
              ((abud.a)localObject4).mName = localJSONObject.optString("name");
              l1 = l2;
              ((abud.a)localObject4).Oy = localJSONObject.optLong("uin");
              l1 = l2;
              ((abud.a)localObject4).Ov = localJSONObject.optLong("finishts");
              l1 = l2;
              ((abud.a)localObject4).Ou = localJSONObject.optLong("redeemts");
              l1 = l2;
              ((abud.a)localObject4).mId = localJSONObject.optInt("id");
              l1 = l2;
              ((abud.a)localObject4).OA = localJSONObject.optLong("ts");
              l1 = l2;
              ((abud.a)localObject4).bhN = localJSONObject.optString("grade");
              l1 = l2;
              ((abud.a)localObject4).bhP = localJSONObject.optString("gradeUrl");
              l1 = l2;
              ((abud.a)localObject4).aGC = localJSONObject.optString("nick");
              l1 = l2;
              ((abud.a)localObject4).aGE = localJSONObject.optString("head");
              l1 = l2;
              ((abud.a)localObject4).mVipLevel = localJSONObject.optInt("viplevel");
              l1 = l2;
              ((abud.a)localObject4).csi = localJSONObject.optInt("chiptotal");
              l1 = l2;
              ((abud.a)localObject4).csj = localJSONObject.optInt("minenum");
              l1 = l2;
              ((abud.a)localObject4).bhO = localJSONObject.optString("picUrl");
              l1 = l2;
              ((abud.a)localObject4).mDesc = localJSONObject.optString("picDesc");
              l1 = l2;
              ((abud.a)localObject4).csn = localJSONObject.optInt("isSquare");
              l1 = l2;
              ((abud.a)localObject4).csl = localJSONObject.optInt("giftNum", 1);
              l1 = l2;
              if (((abud.a)localObject4).Oz == ((abud.a)localObject4).Oy)
              {
                l1 = l2;
                if (TextUtils.isEmpty(((abud.a)localObject4).aGC))
                {
                  l1 = l2;
                  ((abud.a)localObject4).aGC = paramBundle;
                }
              }
              l1 = l2;
              if (TextUtils.isEmpty(((abud.a)localObject4).aGC))
              {
                l1 = l2;
                ((abud.a)localObject4).aGC = "TA";
              }
              l1 = l2;
              ((abud.a)localObject4).O = ((short)localJSONObject.optInt("type"));
              l1 = l2;
              ((abud.a)localObject4).P = s;
              l1 = l2;
              ((abud.a)localObject4).Oz = l3;
              l1 = l2;
              ((abud.a)localObject4).bFE = bool;
              l1 = l2;
              ((abud.a)localObject4).csk = ApolloUtil.cj((String)localObject1);
              l1 = l2;
              paramInt = i;
              if (!TextUtils.isEmpty(this.mCurrentUin))
              {
                l1 = l2;
                paramInt = i;
                if (this.mCurrentUin.equals(String.valueOf(((abud.a)localObject4).Oy)))
                {
                  l1 = l2;
                  paramInt = i;
                  if (localJSONObject.optInt("zanmark") == 0) {
                    paramInt = 0;
                  }
                }
              }
              l1 = l2;
              ((abud.a)localObject4).csm = 0;
              l1 = l2;
              if (localJSONObject.has("layoutStyle"))
              {
                l1 = l2;
                ((abud.a)localObject4).csm = localJSONObject.optInt("layoutStyle");
              }
              l1 = l2;
              ((abud.a)localObject4).bFD = ((abud.a)localObject4).jB(this.mCurrentUin);
              l1 = l2;
              if (((abud.a)localObject4).bFD)
              {
                l1 = l2;
                localArrayList.add(0, localObject4);
                break label2544;
              }
              l1 = l2;
              localArrayList.add(localObject4);
              break label2544;
            }
          }
        }
        j = paramInt;
        if (localObject2 == null) {
          break label2571;
        }
        l1 = l2;
        j = paramInt;
        if (((JSONArray)localObject2).length() <= 0) {
          break label2571;
        }
        i = 0;
        label2000:
        l1 = l2;
        j = paramInt;
        if (i >= ((JSONArray)localObject2).length()) {
          break label2571;
        }
        l1 = l2;
        paramBundle = ((JSONArray)localObject2).getJSONObject(i);
        l1 = l2;
        localObject1 = new abud.a();
        l1 = l2;
        ((abud.a)localObject1).Oy = paramBundle.optLong("uin");
        l1 = l2;
        ((abud.a)localObject1).OA = paramBundle.optLong("ts");
        l1 = l2;
        ((abud.a)localObject1).O = ((short)paramBundle.optInt("giftType"));
        l1 = l2;
        if (((abud.a)localObject1).O == 7)
        {
          l1 = l2;
          ((abud.a)localObject1).csm = 2;
        }
        for (;;)
        {
          l1 = l2;
          if (paramBundle.has("layoutStyle"))
          {
            l1 = l2;
            ((abud.a)localObject1).csm = paramBundle.optInt("layoutStyle");
          }
          l1 = l2;
          localObject3 = (abud.b)localabud.iA.get(Short.valueOf(((abud.a)localObject1).O));
          if (localObject3 == null) {
            break;
          }
          l1 = l2;
          if (((abud.b)localObject3).mIsShow) {
            break;
          }
          break label2562;
          l1 = l2;
          if (((abud.a)localObject1).O == 15)
          {
            l1 = l2;
            ((abud.a)localObject1).csm = 3;
          }
        }
        l1 = l2;
        ((abud.a)localObject1).csl = paramBundle.optInt("giftNum");
        l1 = l2;
        ((abud.a)localObject1).aGC = paramBundle.optString("nick");
        l1 = l2;
        ((abud.a)localObject1).aGE = paramBundle.optString("head");
        l1 = l2;
        ((abud.a)localObject1).bhN = paramBundle.optString("grade");
        l1 = l2;
        ((abud.a)localObject1).bhP = paramBundle.optString("gradeUrl");
        l1 = l2;
        if (!TextUtils.isEmpty(this.mCurrentUin))
        {
          l1 = l2;
          if (this.mCurrentUin.equals(String.valueOf(((abud.a)localObject1).Oy)))
          {
            l1 = l2;
            if (paramBundle.optInt("zanmark") == 0)
            {
              paramInt = 0;
              label2349:
              l1 = l2;
              ((abud.a)localObject1).bFD = ((abud.a)localObject1).jB(this.mCurrentUin);
              l1 = l2;
              if (((abud.a)localObject1).bFD)
              {
                l1 = l2;
                localArrayList.add(0, localObject1);
                break label2562;
              }
              l1 = l2;
              localArrayList.add(localObject1);
              break label2562;
            }
          }
        }
      }
    }
    for (;;)
    {
      label2413:
      l1 = l2;
      localabud.bFC = bool;
      l1 = l2;
      Collections.sort(localArrayList);
      l1 = l2;
      localabud.mItems = localArrayList;
      l1 = l2;
      localabud.cFs();
      l1 = l2;
      if (this.a == null) {
        break;
      }
      l1 = l2;
      this.a.a("apollo_interact.take_chips", paramBoolean, l2, localabud, str1);
      return;
      label2493:
      label2522:
      label2525:
      label2538:
      label2544:
      label2556:
      do
      {
        bool = false;
        break label2413;
        if (this.a == null) {
          break;
        }
        this.a.a(str2, false, -9223372036854775808L, null, str1);
        return;
        break label2349;
        break label708;
        paramInt += 1;
        break label888;
        bool = false;
        break label1067;
        bool = true;
        break label1296;
        j += 1;
        i = paramInt;
        break label1335;
        bool = false;
        break label1296;
        i += 1;
        break label2000;
      } while (j != 0);
      label2562:
      label2571:
      bool = true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, boolean paramBoolean, long paramLong, Object paramObject, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abug
 * JD-Core Version:    0.7.0.1
 */