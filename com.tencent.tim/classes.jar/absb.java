import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class absb
  extends absc
{
  public absb(int paramInt, abse paramabse, absa paramabsa)
  {
    super(paramInt, paramabse, paramabsa);
  }
  
  public absb(int paramInt, String paramString, abse paramabse, absa paramabsa)
  {
    super(paramInt, paramString, paramabse, paramabsa);
  }
  
  private abjp a()
  {
    abjp localabjp = new abjp();
    localabjp.bDs = true;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      QQAppInterface localQQAppInterface = ApolloUtil.a();
      if (localQQAppInterface != null)
      {
        localJSONObject.put("is3DBetaTester", abrj.y(localQQAppInterface));
        localabjp.bgF = localJSONObject.toString();
      }
      return localabjp;
    }
    catch (Exception localException)
    {
      QLog.e("CmShow_SpriteActionScript", 1, localException, new Object[0]);
    }
    return localabjp;
  }
  
  private abjp a(String paramString, ApolloRender paramApolloRender)
  {
    try
    {
      paramString = new JSONObject(paramString);
      float f1 = (float)paramString.optDouble("x");
      float f2 = (float)paramString.optDouble("y");
      float f3 = (float)paramString.optDouble("w");
      float f4 = (float)paramString.optDouble("h");
      float f5 = (float)paramString.optDouble("bX");
      float f6 = (float)paramString.optDouble("bY");
      float f7 = (float)paramString.optDouble("bW");
      float f8 = (float)paramString.optDouble("bH");
      float f9 = (float)paramString.optDouble("gX");
      float f10 = (float)paramString.optDouble("gY");
      float f11 = (float)paramString.optDouble("gW");
      float f12 = (float)paramString.optDouble("gH");
      ApolloRender.AABBCallback(f1, f2, f3, f4, paramString.optString("name"), paramString.optString("extendString"), f5, f6, f7, f8, f9, f10, f11, f12, paramString.optInt("dispose"));
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleBoundingListUpdate exception = " + paramString.toString());
      }
    }
  }
  
  private abjp b(String paramString)
  {
    try
    {
      QLog.d("CmShow_SpriteActionScript", 1, new Object[] { "handleJsError mSpriteFrom:", Integer.valueOf(this.jdField_a_of_type_Abse.cqU) });
      paramString = new JSONObject(paramString).optString("data");
      abwh.a(abrj.gf(this.jdField_a_of_type_Abse.cqU), 1000, 50, new Object[] { paramString });
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleJsError:", paramString);
      }
    }
  }
  
  private abjp c(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abse == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      abwh.bU(paramString.optInt("featureId"), paramString.optString("receiveUin"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private abjp d(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abse == null) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("featureId");
      if ((i == abrj.gf(1)) || (i == abrj.gf(2))) {
        abwh.b(i, null, new int[] { abwg.a(i, false, this.jdField_a_of_type_Abse.cqS, -1, true) });
      }
      abwh.Im(i);
      if ((i == abrj.gf(1)) || (i == abrj.gf(2)))
      {
        abwh.bl(abrj.gf(this.jdField_a_of_type_Abse.cqU), false);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceEnd:", paramString);
    }
    return null;
  }
  
  private abjp e(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Abse == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtil.go(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtil.Y((String)localObject);
          i = j;
        }
      }
      abwh.a(k, null, m, -100, l3, i, l1, new Object[] { paramString });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceSpanBegin:", paramString);
    }
    return null;
  }
  
  private abjp f(String paramString)
  {
    long l2 = 0L;
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Abse == null) {
        return null;
      }
      Object localObject = new JSONObject(paramString);
      int k = ((JSONObject)localObject).optInt("featureId");
      int m = ((JSONObject)localObject).optInt("spanId");
      int n = ((JSONObject)localObject).optInt("errCode");
      paramString = ((JSONObject)localObject).optString("msg");
      long l3 = ((JSONObject)localObject).optLong("timestamp");
      localObject = ((JSONObject)localObject).optString("spanDesc");
      long l1 = l2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int j = ApolloUtil.go(m);
        i = j;
        l1 = l2;
        if (j > 0)
        {
          l1 = ApolloUtil.Y((String)localObject);
          i = j;
        }
      }
      abwh.a(k, null, m, n, l3, i, l1, new Object[] { paramString });
      if ((n == 57) && (!Za()))
      {
        cEu();
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceSpanEnd:", paramString);
    }
    return null;
  }
  
  private abjp g(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abse == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("featureId");
      int j = paramString.optInt("spanId");
      String str = paramString.optString("msg");
      abwh.a(i, j, -100, paramString.optLong("timestamp"), new Object[] { str });
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  private abjp h(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abse.cqU != 0) {
        return null;
      }
      ApolloUtil.Db(new JSONObject(paramString).optString("text"));
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private abjp i(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uinList");
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        bv(paramString.optString(i), true);
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
  }
  
  private abjp j(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abse.cqU != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("status");
      int j = paramString.optInt("whiteHeight");
      if (QLog.isColorLevel())
      {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private abjp k(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Abse.cqU != 0) {
        return null;
      }
      new JSONObject(paramString).optInt("status");
      paramString = this.jdField_a_of_type_Absa;
      if (paramString != null) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private abjp l(String paramString)
  {
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("taskId");
      j = paramString.optInt("status");
      paramString = paramString.optString("uin");
      if (!QLog.isColorLevel()) {
        break label137;
      }
      QLog.d("CmShow_SpriteActionScript.callback", 2, new Object[] { "taskId:", Integer.valueOf(i), ",status:", Integer.valueOf(j) });
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      break label164;
    }
    if (this.jdField_a_of_type_Abrk != null)
    {
      this.jdField_a_of_type_Abrk.dk(paramString, i);
      break label164;
      if (this.jdField_a_of_type_Abrk != null)
      {
        this.jdField_a_of_type_Abrk.Z(paramString, i, j);
        break label164;
        label137:
        switch (j)
        {
        }
      }
    }
    label164:
    return null;
  }
  
  private abjp p(String paramString)
  {
    label124:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject();
        if ("pet".equals(paramString.getString("config_name")))
        {
          paramString = new JSONArray();
          Object localObject = ApolloUtil.a();
          if (localObject != null)
          {
            localObject = (abhh)((QQAppInterface)localObject).getManager(153);
            if (((abhh)localObject).bfZ == null) {
              break label124;
            }
            paramString = new JSONArray(((abhh)localObject).bfZ);
            localJSONObject.put("petConfig", paramString);
            paramString = new abjp();
            paramString.bDs = true;
            paramString.bgF = localJSONObject.toString();
            return paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleGetLocalData error:", paramString);
      }
      return null;
    }
  }
  
  private abjp q(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (!QLog.isColorLevel()) {
        break label182;
      }
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "handlePlayAction from:", Integer.valueOf(j) });
    }
    catch (JSONException paramString)
    {
      label71:
      Object localObject;
      paramString.printStackTrace();
      return null;
    }
    paramString = this.jdField_a_of_type_Abse.a();
    if (paramString != null)
    {
      paramString.TI();
      return null;
      if (j == 0)
      {
        paramString = paramString.optString("uinList");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new JSONArray(paramString);
          paramString = new ArrayList();
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        String str = ((JSONArray)localObject).optString(i);
        if (!TextUtils.isEmpty(str)) {
          paramString.add(str);
        }
      }
      else
      {
        if (paramString.size() != 0)
        {
          localObject = abrj.a(ApolloUtil.a());
          if (localObject != null)
          {
            ((abrd)localObject).ia(paramString);
            return null;
            label182:
            if (j == 1) {
              break;
            }
            if (j != 2) {
              break label71;
            }
            break;
          }
        }
        return null;
      }
      i += 1;
    }
  }
  
  private abjp r(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (j != 0) {
        break label177;
      }
      localObject = paramString.optString("url");
      if ((this.jdField_a_of_type_Abse == null) || (this.jdField_a_of_type_Abse.d() == null))
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick mSpriteContent is nil");
        return null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label122;
      }
      if (this.jdField_a_of_type_Abse.d().a() == null)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick activity is nil");
        return null;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "Exception:", paramString);
      return null;
    }
    ApolloUtil.bp(this.jdField_a_of_type_Abse.d().a(), (String)localObject);
    return null;
    label122:
    paramString = paramString.optString("gameId");
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (i > 0)
    {
      ApolloGameUtil.a(this.jdField_a_of_type_Abse.d(), i, 333002, "message", 1);
      return null;
    }
    QLog.e("CmShow_SpriteActionScript", 1, "handleOnApolloClick gameStr is nil");
    return null;
    label177:
    i = paramString.optInt("apolloStatus");
    int k = paramString.optInt("clickPart");
    paramString = paramString.optString("apolloId");
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "handleOnApolloClick", ",from:", Integer.valueOf(j), ",apolloStatus:", Integer.valueOf(i), ",clickPart:", Integer.valueOf(k), "apolloId:", paramString });
    }
    Object localObject = this.jdField_a_of_type_Abse.a();
    if (localObject != null) {
      ((abrm)localObject).A(i, k, paramString);
    }
    return null;
  }
  
  public void A(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ",url:", paramString1 });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("apolloId", paramString2);
      }
      paramString1 = ApolloUtil.a();
      if (paramString1 != null)
      {
        ApolloCmdChannel.getChannel(paramString1).callbackFromRequest(this.jdField_a_of_type_Abse.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
        return;
      }
      paramString1 = ApolloUtil.b();
      if (paramString1 != null)
      {
        ApolloCmdChannel.getChannelFromOtherProcess(paramString1).callbackFromRequest(this.jdField_a_of_type_Abse.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void HP(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramInt);
      ApolloUtil.a().callbackFromRequest(this.jdField_a_of_type_Abse.a().getLuaState(), 0, "sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmShow_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public abjp a(long paramLong, String paramString1, String paramString2)
  {
    abix localabix = a();
    if ((localabix == null) || (localabix.getLuaState() != paramLong)) {}
    do
    {
      do
      {
        return null;
        if ((!paramString1.startsWith("apollo_")) || (paramString1.startsWith("cs.")) || (paramString1.endsWith(".local")) || (abjn.jq(paramString1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CmShow_SpriteActionScript", 2, "ssoCmdRule, [aio],cmd:" + paramString1);
      return null;
      if ("cs.script_action_status_notify.local".equals(paramString1)) {
        return l(paramString2);
      }
      if ("cs.script_change_panel_status.local".equals(paramString1)) {
        return k(paramString2);
      }
      if ("cs.script_get_dress_data.local".equals(paramString1)) {
        return i(paramString2);
      }
      if ("cs.script_sprite_status_change.local".equals(paramString1)) {
        return j(paramString2);
      }
      if ("cs.script_get_show_action.local".equals(paramString1)) {
        return m(paramString2);
      }
      if ("cs.script_is_allow_play_audio.local".equals(paramString1)) {
        return b();
      }
      if ("cs.script_show_barrage.local".equals(paramString1)) {
        return n(paramString2);
      }
      if ("cs.script_send_action_msg.local".equals(paramString1)) {
        return o(paramString2);
      }
      if ("cs.script_show_toast.local".equals(paramString1)) {
        return h(paramString2);
      }
      if ("cs.script_get_config.local".equals(paramString1)) {
        return p(paramString2);
      }
      if ("cs.script_play_action.local".equals(paramString1)) {
        return q(paramString2);
      }
      if ("cs.script_action_apollo_click.local".equals(paramString1)) {
        return r(paramString2);
      }
      if ("cs.script_update_boundinglist.local".equals(paramString1)) {
        return a(paramString2, localabix.getRenderImpl().getRender());
      }
      if ("cs.get_cm3D_state.local".equals(paramString1)) {
        return a();
      }
      if ("cs.trace_begin.local".equals(paramString1)) {
        return c(paramString2);
      }
      if ("cs.trace_end.local".equals(paramString1)) {
        return d(paramString2);
      }
      if ("cs.trace_span_begin.local".equals(paramString1)) {
        return e(paramString2);
      }
      if ("cs.trace_span_end.local".equals(paramString1)) {
        return f(paramString2);
      }
      if ("cs.trace_log.local".equals(paramString1)) {
        return g(paramString2);
      }
    } while (("cs.script_sprite_model_change_notify.local".equals(paramString1)) || (!"cs.xy_error_info.local".equals(paramString1)));
    return b(paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    int i = 2;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",vHeight:", Integer.valueOf(paramInt3), ",aioType:", Integer.valueOf(paramInt4), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt5) });
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Abse == null) {
          return;
        }
        Object localObject = ApolloUtil.a();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", "android");
        if (!this.jdField_a_of_type_Abse.bEV) {
          break label890;
        }
        localJSONObject.put("panelStatus", i);
        if (localObject != null)
        {
          localJSONObject.put("phoneModel", ApolloUtil.b.sModel);
          localJSONObject.put("osVersion", ApolloUtil.b.sOsVersion);
          localJSONObject.put("cpuType", ApolloUtil.b.bke);
          localJSONObject.put("cpuNumber", ApolloUtil.b.ctM);
          localJSONObject.put("cpuFrequency", ApolloUtil.b.OY);
          localJSONObject.put("freeMemory", ((ApolloUtil.b)localObject).Pb);
          localJSONObject.put("totalMemory", ((ApolloUtil.b)localObject).Pa);
          localJSONObject.put("maxMemory", ((ApolloUtil.b)localObject).OZ);
        }
        localJSONObject.put("aioType", ApolloGameUtil.a(ApolloUtil.a(), paramInt4, this.jdField_a_of_type_Abse.mFriendUin));
        localJSONObject.put("friendUin", paramString);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("vHeight", paramInt3);
        localJSONObject.put("screenW", aqgz.hK());
        localJSONObject.put("screenH", aqgz.hL());
        localJSONObject.put("qqVer", "3.4.4");
        localJSONObject.put("uin", this.jdField_a_of_type_Abse.mSelfUin);
        localJSONObject.put("density", aqgz.density);
        localJSONObject.put("wait", "def/basic/action/1/action/action");
        localJSONObject.put("standup", "def/basic/action/4/action/action");
        localJSONObject.put("think", "def/basic/action/3/action/action");
        localJSONObject.put("sitdown", "def/basic/action/2/action/action");
        localJSONObject.put("isHide", 0);
        c(localJSONObject, paramInt5);
        paramString = new JSONArray();
        localObject = new int[7];
        Object tmp482_480 = localObject;
        tmp482_480[0] = 1;
        Object tmp486_482 = tmp482_480;
        tmp486_482[1] = 2;
        Object tmp490_486 = tmp486_482;
        tmp490_486[2] = 3;
        Object tmp494_490 = tmp490_486;
        tmp494_490[3] = 4;
        Object tmp498_494 = tmp494_490;
        tmp498_494[4] = 5;
        Object tmp502_498 = tmp498_494;
        tmp502_498[5] = 6;
        Object tmp507_502 = tmp502_498;
        tmp507_502[6] = 7;
        tmp507_502;
        paramInt4 = localObject.length;
        paramInt2 = 0;
        if (paramInt2 < paramInt4)
        {
          paramString.put(abvg.z(1, Integer.valueOf(localObject[paramInt2]).intValue()));
          paramInt2 += 1;
          continue;
        }
        localJSONObject.put("defDress", paramString);
        localJSONObject.put("defRole", abvg.z(0, 0));
        localJSONObject.put("from", paramInt5);
        localJSONObject.put("traceFeatureId", this.jdField_a_of_type_Abse.zM());
        paramString = new File(abxi.biu);
        if (!paramString.isDirectory()) {
          break label865;
        }
        paramString = paramString.listFiles();
        if ((paramString != null) && (paramString.length > 0))
        {
          localObject = new JSONArray();
          paramInt2 = j;
          if (paramInt2 < paramString.length)
          {
            ((JSONArray)localObject).put(paramString[paramInt2].getName());
            if (!QLog.isColorLevel()) {
              break label896;
            }
            QLog.i("CmShow_SpriteActionScript", 2, "init shaderCode name:" + paramString[paramInt2].getName());
            break label896;
          }
          localJSONObject.put("shaderCodes", localObject);
          if (QLog.isColorLevel()) {
            QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes jsonArray:" + localObject);
          }
          paramString = new StringBuilder();
          paramString.append("if(commonInit){commonInit('").append(localJSONObject.toString()).append("');}");
          QLog.d("CmShow_SpriteActionScript", 1, "sava TraceReport CmShowStatUtil commitJS:(commonInit)");
          if ((paramInt1 != 0) && (paramInt3 != 0)) {
            break label877;
          }
          j(paramString.toString(), 0, true);
          if (!QLog.isColorLevel()) {
            break label889;
          }
          QLog.d("CmShow_SpriteActionScript", 2, localJSONObject.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CmShow_SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
        return;
      }
      QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes file no exist");
      continue;
      label865:
      QLog.i("CmShow_SpriteActionScript", 1, "commonInit shaderCodes dir no exist");
      continue;
      label877:
      CN(paramString.toString());
      continue;
      label889:
      return;
      label890:
      i = 1;
      continue;
      label896:
      paramInt2 += 1;
    }
  }
  
  public abjp b()
  {
    abjp localabjp;
    label247:
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = ApolloUtil.a();
        if (localQQAppInterface == null) {
          return null;
        }
        localabjp = new abjp();
        localabjp.bDs = true;
        JSONObject localJSONObject = new JSONObject();
        if ((1 == localQQAppInterface.AI()) && (((this.jdField_a_of_type_Abse.mAioType != 1) && (this.jdField_a_of_type_Abse.mAioType != 3000)) || (((1 == localQQAppInterface.AG()) || (this.jdField_a_of_type_Abse.mAioType == 0) || (this.jdField_a_of_type_Abse.mAioType == -2)) && (!localQQAppInterface.YI()) && (!localQQAppInterface.YJ()) && (localQQAppInterface.YK()) && (!MediaPlayerManager.a(localQQAppInterface).isPlaying()) && ((localQQAppInterface.a() == null) || (!localQQAppInterface.a().OQ())) && (!localQQAppInterface.bF()))))
        {
          if (localQQAppInterface.a() == null) {
            break label247;
          }
          if (!localQQAppInterface.a().OR())
          {
            break label247;
            localJSONObject.put("isAllowed", i);
            localabjp.bgF = localJSONObject.toString();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
            break;
          }
        }
        abrj.ce(localQQAppInterface);
        int i = 0;
        continue;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CmShow_SpriteActionScript", 1, localThrowable, new Object[0]);
        return null;
      }
    }
    return localabjp;
  }
  
  public void c(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2;
    try
    {
      localObject2 = new File(abxi.bio + "/def/role/0/3D");
      localObject1 = new File(abxi.bio + "/def/role/0/3D/3DConfig.json");
      if (!((File)localObject2).exists())
      {
        QLog.w("CmShow_SpriteActionScript", 1, "3D dir NOT exist.");
        return;
      }
      if (!((File)localObject1).exists())
      {
        QLog.w("CmShow_SpriteActionScript", 1, "3DConfig NOT exist.");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramJSONObject, new Object[0]);
      return;
    }
    Object localObject1 = abxi.biH;
    JSONObject localJSONObject = new JSONObject();
    if (new File((File)localObject2, "1/action.bin").exists()) {
      localJSONObject.put("wait", (String)localObject1 + "1");
    }
    if (new File((File)localObject2, "4/action.bin").exists()) {
      localJSONObject.put("standup", (String)localObject1 + "4");
    }
    if (new File((File)localObject2, "3/action.bin").exists()) {
      localJSONObject.put("think", (String)localObject1 + "3");
    }
    if (new File((File)localObject2, "2/action.bin").exists()) {
      localJSONObject.put("sitdown", (String)localObject1 + "2");
    }
    if (new File((File)localObject2, "android/skeleton/skeleton.bin").exists()) {
      localJSONObject.put("defRole", (String)localObject1 + "android/skeleton");
    }
    if (new File((File)localObject2, "transformAction/3to2/action.bin").exists()) {
      localJSONObject.put("3to2DAction", (String)localObject1 + "transformAction/3to2");
    }
    if ((new File((File)localObject2, "transformAction/2to3/action.atlas").exists()) && (new File((File)localObject2, "transformAction/2to3/action.png").exists()) && (new File((File)localObject2, "transformAction/2to3/action.json").exists())) {
      localJSONObject.put("2to3DAction", (String)localObject1 + "transformAction/2to3");
    }
    if ((paramInt == 2) && (new File((File)localObject2, "friendcard/1/action.bin").exists()))
    {
      localJSONObject.put("friendcard_up", (String)localObject1 + "friendcard/1");
      localJSONObject.put("friendcard_down", (String)localObject1 + "friendcard/2");
    }
    if (new File((File)localObject2, "sayhi/1/action.bin").exists()) {
      localJSONObject.put("sayhi", (String)localObject1 + "sayhi/1");
    }
    if (new File((File)localObject2, "bubble").exists()) {
      localJSONObject.put("bubble", (String)localObject1 + "bubble");
    }
    Object localObject3 = new File((File)localObject2, "android/dress");
    int i;
    if (((File)localObject3).exists())
    {
      localObject2 = new JSONArray();
      localObject3 = ((File)localObject3).listFiles();
      i = localObject3.length;
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject4 = localObject3[paramInt];
        if ((localObject4 != null) && (localObject4.exists()) && (localObject4.isDirectory())) {
          ((JSONArray)localObject2).put((String)localObject1 + "android/dress/" + localObject4.getName());
        }
      }
      else
      {
        localJSONObject.put("defDress", localObject2);
        paramJSONObject.put("3DObject", localJSONObject);
        return;
      }
      paramInt += 1;
    }
  }
  
  public abjp m(String paramString)
  {
    abjp localabjp;
    JSONObject localJSONObject1;
    try
    {
      if (this.jdField_a_of_type_Abse.cqU != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray1 = new JSONArray(paramString.optString("uinList"));
      JSONArray localJSONArray2 = new JSONArray();
      localabjp = new abjp();
      localabjp.bDs = true;
      localJSONObject1 = new JSONObject();
      int j = paramString.optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteActionScript", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      absk localabsk = this.jdField_a_of_type_Absa.a();
      if (localabsk != null)
      {
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject = localJSONArray1.optString(i);
          localJSONObject2.put("uin", localObject);
          if (j == 1) {
            localJSONObject2.put("petPath", localabsk.a(new JSONArray(paramString.optString("actionList"))));
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject2);
            i += 1;
            break;
            localObject = localabsk.b((String)localObject);
            localJSONObject2.put("path", ((Pair)localObject).first);
            localJSONObject2.put("actionType", ((Pair)localObject).second);
          }
        }
      }
      localJSONObject1.put("path", localJSONArray2);
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localabjp.bgF = localJSONObject1.toString();
    return localabjp;
  }
  
  public abjp n(String paramString)
  {
    abix localabix;
    try
    {
      localabix = a();
      if (localabix == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      if (1 == paramString.optInt("isShow"))
      {
        localabix.bulkApolloBarrages("", new String(aqgo.decode(paramString.optString("text").getBytes("utf-8"), 0)), true);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localabix.removeAllApolloBarrages(true);
    return null;
  }
  
  public abjp o(String paramString)
  {
    try
    {
      int i = this.jdField_a_of_type_Abse.cqU;
      if (i != 0) {}
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("CmShow_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  public void onLoadFinish()
  {
    if ((this.jdField_a_of_type_Abse != null) && (this.jdField_a_of_type_Abse.a() != null)) {
      a(this.jdField_a_of_type_Abse.a().getWidth(), this.jdField_a_of_type_Abse.a().getInitHeight(), this.jdField_a_of_type_Abse.a().getHeight(), this.jdField_a_of_type_Abse.mAioType, this.jdField_a_of_type_Abse.mFriendUin, this.jdField_a_of_type_Abse.cqU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absb
 * JD-Core Version:    0.7.0.1
 */