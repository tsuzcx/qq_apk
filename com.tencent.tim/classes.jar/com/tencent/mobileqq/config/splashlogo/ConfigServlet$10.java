package com.tencent.mobileqq.config.splashlogo;

import aagd;
import aevk;
import android.text.TextUtils;
import android.util.Base64;
import aqds;
import aqmj;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import zxs;
import zyn;

public class ConfigServlet$10
  implements Runnable
{
  public ConfigServlet$10(aevk paramaevk, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.getAppRuntime();
    Object localObject1 = null;
    Object localObject3 = null;
    HashMap localHashMap = new HashMap(8);
    int m = aqmj.ap(localQQAppInterface.getApp(), aevk.mCurUin);
    int i;
    int j;
    label127:
    Object localObject4;
    JSONObject localJSONObject;
    label332:
    Object localObject2;
    label439:
    String str2;
    if ((this.a != null) && (this.a.version != null))
    {
      i = this.a.version.get();
      if ((this.a != null) && (i != m))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, String.format("qwallet config update %s -> %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i) }));
        }
        if (i == m) {
          break label1715;
        }
        j = i;
        if ((this.a == null) || (this.a.content_list == null) || (this.a.content_list.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content_list is empty ,version: " + i);
          }
          return;
        }
        int n = this.a.content_list.size();
        int k = 0;
        for (localObject1 = localObject3;; localObject1 = localObject4)
        {
          localObject3 = localObject1;
          if (k >= n) {
            break label1533;
          }
          localObject4 = (String)this.a.content_list.get(k);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 42,content: " + (String)localObject4 + ",version: " + this.a.version.get());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break;
          }
          localObject4 = localObject1;
          k += 1;
        }
        localObject3 = localObject1;
        do
        {
          try
          {
            localJSONObject = new JSONObject((String)localObject4);
            localObject3 = localObject1;
            Iterator localIterator = localJSONObject.keys();
            for (;;)
            {
              localObject4 = localObject1;
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = localObject1;
              localObject4 = (String)localIterator.next();
              localObject3 = localObject1;
              if (!"hb_face".equals(localObject4)) {
                break label439;
              }
              localObject3 = localObject1;
              localObject4 = localJSONObject.optJSONObject((String)localObject4);
              localObject3 = localObject1;
              aqds.a().b(localQQAppInterface, (JSONObject)localObject4);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException1)
          {
            localObject4 = localObject3;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException1);
          localObject4 = localObject3;
          break;
          localObject3 = localException1;
          if ("hb_normal".equals(localObject4))
          {
            localObject3 = localException1;
            localObject4 = localJSONObject.optJSONObject((String)localObject4);
            if (i <= j) {
              break label1712;
            }
            localObject2 = localObject4;
            break label1726;
          }
          localObject3 = localObject2;
          if (!"F2FRedpack".equals(localObject4)) {
            break label718;
          }
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
        } while (localObject4 == null);
        localObject3 = localObject2;
        str2 = aevk.mCurUin;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackEntry", 0) != 1) {
          break label1729;
        }
        bool = true;
        label538:
        localObject3 = localObject2;
        zyn.u(str2, "F2FRedpackEntry", bool);
        localObject3 = localObject2;
        str2 = aevk.mCurUin;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackQRCheck", 1) != 1) {
          break label1735;
        }
        bool = true;
        label579:
        localObject3 = localObject2;
        zyn.u(str2, "F2FRedpackQRCheck", bool);
        localObject3 = localObject2;
        str2 = aevk.mCurUin;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optInt("F2FRedpackGIF", 1) != 1) {
          break label1741;
        }
      }
    }
    label1674:
    label1712:
    label1715:
    label1726:
    label1729:
    label1735:
    label1741:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        localObject3 = localObject2;
        zyn.u(str2, "F2FRedpackGIF", bool);
        localObject3 = localObject2;
        long l1 = aagd.X(((JSONObject)localObject4).optString("EntryColorBeginTime"));
        localObject3 = localObject2;
        long l2 = aagd.X(((JSONObject)localObject4).optString("EntryColorEndTime"));
        if ((l1 < 0L) || (l2 < 0L)) {
          break label332;
        }
        localObject3 = localObject2;
        zyn.putLong(aevk.mCurUin, "F2FRedpack_EntryColorBeginTime", l1 / 1000L);
        localObject3 = localObject2;
        zyn.putLong(aevk.mCurUin, "F2FRedpack_EntryColorEndTime", l2 / 1000L);
        break label332;
        label718:
        localObject3 = localObject2;
        int i1;
        if ("preload_config".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label332;
          }
          localObject3 = localObject2;
          i1 = ((JSONObject)localObject4).optInt("deal_delay_interval", 0);
          localObject3 = localObject2;
          int i2 = ((JSONObject)localObject4).optInt("need_wait_size", 0);
          localObject3 = localObject2;
          ((PreloadManager)localQQAppInterface.getManager(151)).gl(i1, i2);
          localObject3 = localObject2;
          zyn.putInt(aevk.mCurUin, "deal_delay_interval", i1);
          localObject3 = localObject2;
          zyn.putInt(aevk.mCurUin, "need_wait_size", i2);
          break label332;
        }
        localObject3 = localObject2;
        if ("skin_map".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        if ("skin_entry_error_tips".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.getString((String)localObject4);
          localObject3 = localObject2;
          zyn.putString(aevk.mCurUin, "skin_entry_error_tips", (String)localObject4);
          break label332;
        }
        localObject3 = localObject2;
        if ("InterceptAppOpenConfig".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONArray((String)localObject4);
          localObject3 = localObject2;
          zxs.a().b((JSONArray)localObject4, aevk.mCurUin);
          break label332;
        }
        localObject3 = localObject2;
        if ("strangerchat_ext".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optString((String)localObject4, "");
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label332;
          }
          localObject3 = localObject2;
          zyn.putString("", "strangerchat_ext", Base64.encodeToString(((String)localObject4).getBytes(), 0));
          break label332;
        }
        localObject3 = localObject2;
        if ("RedpackPopWnd".equals(localObject4))
        {
          localObject3 = localObject2;
          localObject4 = localJSONObject.optJSONObject((String)localObject4);
          if (localObject4 == null) {
            break label332;
          }
          localObject3 = localObject2;
          i1 = ((JSONObject)localObject4).optInt("PopWndID");
          localObject3 = localObject2;
          zyn.putInt(aevk.mCurUin, "redpack_popwnd_id", ((JSONObject)localObject4).optInt("PopWndID"));
          localObject3 = localObject2;
          zyn.putString(aevk.mCurUin, "redpack_popwnd_group_type_" + i1, ((JSONObject)localObject4).optString("GroupType"));
          localObject3 = localObject2;
          zyn.putString(aevk.mCurUin, "redpack_popwnd_url_" + i1, ((JSONObject)localObject4).optString("URL"));
          localObject3 = localObject2;
          zyn.putString(aevk.mCurUin, "redpack_popwnd_state_" + i1, ((JSONObject)localObject4).optString("RedpackState"));
          localObject3 = localObject2;
          zyn.putInt(aevk.mCurUin, "redpack_popwnd_freq_" + i1, ((JSONObject)localObject4).optInt("PopWndFreq"));
          localObject3 = localObject2;
          zyn.putInt(aevk.mCurUin, "redpack_popwnd_total_" + i1, ((JSONObject)localObject4).optInt("PopWndTotalCount"));
          localObject3 = localObject2;
          zyn.putString(aevk.mCurUin, "redpack_popwnd_network_" + i1, ((JSONObject)localObject4).optString("PopWndNetworkType"));
          localObject3 = localObject2;
          l1 = aagd.X(((JSONObject)localObject4).optString("PopWndBeginTime"));
          localObject3 = localObject2;
          l2 = aagd.X(((JSONObject)localObject4).optString("PopWndEndTime"));
          localObject3 = localObject2;
          zyn.putLong(aevk.mCurUin, "redpack_popwnd_begin_time_" + i1, l1 / 1000L);
          localObject3 = localObject2;
          zyn.putLong(aevk.mCurUin, "redpack_popwnd_end_time_" + i1, l2 / 1000L);
          break label332;
        }
        localObject3 = localObject2;
        if ("image_urls".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        if ("hb_theme".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        if ("hb_theme_group".equals(localObject4)) {
          break label332;
        }
        localObject3 = localObject2;
        localHashMap.put(localObject4, localJSONObject.opt((String)localObject4));
        break label332;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG remote version: " + i + " | localVersion: " + m);
          localObject3 = localObject2;
        }
        try
        {
          label1533:
          if ((this.a == null) || (i == m)) {
            break;
          }
          aqmj.S(localQQAppInterface.getApp(), aevk.mCurUin, i);
          localObject2 = new JSONObject();
          if (localObject3 != null) {
            ((JSONObject)localObject2).put("hb_normal", localObject3);
          }
          if (localHashMap.isEmpty()) {
            break label1674;
          }
          localObject3 = localHashMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            ((JSONObject)localObject2).put((String)((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue());
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException2) {}
      }
      QLog.e("SPLASH_ConfigServlet", 2, "received QWALLET_SETTING_CONFIG error", localException2);
      return;
      localHashMap.clear();
      localObject3 = aqds.a();
      if (localException2.length() > 0) {}
      for (String str1 = localException2.toString();; str1 = "")
      {
        ((aqds)localObject3).bc(localQQAppInterface, str1);
        return;
      }
      break label1726;
      j = m;
      break label127;
      i = 0;
      break;
      break label332;
      bool = false;
      break label538;
      bool = false;
      break label579;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.10
 * JD-Core Version:    0.7.0.1
 */