import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class abuk
{
  private VasWebviewJsPlugin a;
  private SparseArray<abis.b> mListeners = new SparseArray();
  
  public abuk(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    this.a = paramVasWebviewJsPlugin;
  }
  
  private JSONObject a(int paramInt1, String paramString, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resType", paramInt1);
      localJSONObject.put("resId", paramString);
      localJSONObject.put("resultCode", paramInt2);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloPluginRscLoader", 1, paramString, new Object[0]);
    }
    return localJSONObject;
  }
  
  private static void a(WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse != null)
    {
      Map localMap = paramWebResourceResponse.getResponseHeaders();
      Object localObject = localMap;
      if (localMap == null) {
        localObject = new HashMap();
      }
      ((Map)localObject).put("Access-Control-Allow-Origin", "*");
      paramWebResourceResponse.setResponseHeaders((Map)localObject);
    }
  }
  
  private void a(int[] paramArrayOfInt, String paramString, JSONArray paramJSONArray)
  {
    int k = 0;
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc");
    AppInterface localAppInterface;
    ArrayList localArrayList;
    int i;
    if (paramArrayOfInt != null)
    {
      localAppInterface = this.a.mRuntime.a();
      localArrayList = new ArrayList();
      i = 0;
      int j = 0;
      if (i < paramArrayOfInt.length)
      {
        abip.a locala = abip.a().a(8, paramArrayOfInt[i]);
        if (locala == null) {
          j = 1;
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(locala);
        }
      }
      if (j != 0)
      {
        localArrayList.clear();
        i = paramArrayOfInt.hashCode();
        paramArrayOfInt = new abup(this, i, paramArrayOfInt, localArrayList, localAppInterface, paramJSONArray, paramString);
        this.mListeners.put(i, paramArrayOfInt);
        abis.a().a(i, paramArrayOfInt);
        abis.a().a(localAppInterface, i, true);
      }
    }
    else
    {
      return;
    }
    if (localArrayList.isEmpty())
    {
      i = k;
      while (i < paramArrayOfInt.length)
      {
        paramJSONArray.put(a(8, String.valueOf(paramArrayOfInt[i]), 2));
        i += 1;
      }
      a(paramString, acfp.m(2131702641), paramJSONArray);
      return;
    }
    abiq.a(localAppInterface, "", new abur(this, paramArrayOfInt, paramJSONArray, paramString), localArrayList, false, null);
  }
  
  private byte[] a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int j;
      String str;
      Object localObject3;
      int i;
      try
      {
        localObject1 = new File(paramString);
        if (!((File)localObject1).exists()) {
          return null;
        }
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          int m = localObject1.length;
          k = 6;
          j = 0;
          if (j >= m) {
            break label231;
          }
          str = localObject1[j];
          localObject3 = str.getName();
          if (paramBoolean)
          {
            i = k;
            if (((String)localObject3).endsWith("face.json"))
            {
              i = (int)(k + (((String)localObject3).getBytes().length + 1 + 4 + str.length()));
              ((List)localObject2).add(localObject3);
            }
          }
          else if ((!((String)localObject3).endsWith("bin")) && (!((String)localObject3).endsWith("etc")) && (!((String)localObject3).endsWith("png")))
          {
            i = k;
            if (!((String)localObject3).endsWith("pvr")) {}
          }
          else
          {
            i = (int)(k + (((String)localObject3).getBytes().length + 1 + 4 + str.length()));
            ((List)localObject2).add(localObject3);
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPluginRscLoader", 1, paramString, new Object[0]);
      }
      return null;
      label231:
      Object localObject1 = new ByteArrayOutputStream(k);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 24 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 16 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 8 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 0 & 0xFF);
      ((ByteArrayOutputStream)localObject1).write((byte)paramInt2);
      ((ByteArrayOutputStream)localObject1).write((byte)((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        localObject3 = new File(paramString, str);
        paramInt1 = (int)((File)localObject3).length();
        byte[] arrayOfByte = aqhq.readFile(((File)localObject3).getAbsolutePath());
        if (arrayOfByte != null)
        {
          ((ByteArrayOutputStream)localObject1).write((byte)str.getBytes().length);
          ((ByteArrayOutputStream)localObject1).write(str.getBytes("utf-8"));
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 24 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 16 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 8 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(paramInt1 >>> 0 & 0xFF);
          ((ByteArrayOutputStream)localObject1).write(arrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, new Object[] { "getResourceResponse name:", str, " length:" + ((File)localObject3).length() });
        }
      }
      paramString = ((ByteArrayOutputStream)localObject1).toByteArray();
      return paramString;
      j += 1;
      int k = i;
    }
  }
  
  private WebResourceResponse b(String paramString)
  {
    int i;
    Object localObject3;
    Object localObject5;
    if (paramString.contains("https://cmshow.qq.com/3dresource/combination"))
    {
      QLog.i("ApolloPluginRscLoader", 1, "getCombination url:" + paramString);
      i = -1;
      localObject3 = null;
      localObject5 = null;
    }
    for (;;)
    {
      AppInterface localAppInterface;
      Object localObject4;
      int i2;
      Object localObject2;
      Object localObject8;
      int m;
      int k;
      String str1;
      WebResourceResponse localWebResourceResponse;
      try
      {
        localAppInterface = this.a.mRuntime.a();
        Object localObject7 = Uri.parse(paramString);
        Object localObject1;
        if (((Uri)localObject7).isHierarchical())
        {
          localObject4 = ((Uri)localObject7).getQueryParameter("roleId");
          i2 = 1;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            i = ApolloUtil.ck((String)localObject4);
            i2 = true & ApolloUtil.ih(i);
            QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination roleId:", Integer.valueOf(i), " resExsit:", Boolean.valueOf(i2) });
          }
          Object localObject6 = ((Uri)localObject7).getQueryParameter("dressIds");
          int i3 = i2;
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject6))
          {
            localObject4 = (String)localObject4 + (String)localObject6;
            localObject8 = new JSONArray((String)localObject6);
            i3 = i2;
            localObject2 = localObject4;
            localObject1 = localObject3;
            if (localObject8 != null)
            {
              i3 = i2;
              localObject2 = localObject4;
              localObject1 = localObject3;
              if (((JSONArray)localObject8).length() > 0)
              {
                m = ((JSONArray)localObject8).length();
                localObject3 = new int[m];
                int j = 0;
                i3 = i2;
                localObject2 = localObject4;
                localObject1 = localObject3;
                if (j < m)
                {
                  localObject3[j] = ((JSONArray)localObject8).optInt(j);
                  i3 = ApolloUtil.ig(localObject3[j]);
                  j += 1;
                  i2 = i3 & i2;
                  continue;
                }
              }
            }
          }
          localObject8 = ((Uri)localObject7).getQueryParameter("faceDataUrl");
          str1 = ((Uri)localObject7).getQueryParameter("callbackId");
          localObject3 = null;
          i2 = i3;
          if (!TextUtils.isEmpty((CharSequence)localObject8))
          {
            localObject3 = arwv.toMD5(URLDecoder.decode((String)localObject8));
            localObject3 = new File(abxi.biv + (String)localObject3 + File.separator + (String)localObject3 + ".zip");
            i2 = i3 & ((File)localObject3).exists();
          }
          QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination faceDataUrl:", localObject8, " resExsit:", Boolean.valueOf(i2) });
          String str2 = ((Uri)localObject7).getQueryParameter("roomIds");
          localObject7 = new ArrayList();
          i3 = i2;
          localObject4 = localObject5;
          if (!TextUtils.isEmpty(str2))
          {
            new StringBuilder().append((String)localObject2).append((String)localObject6).toString();
            localObject6 = new JSONArray(str2);
            i3 = i2;
            localObject4 = localObject5;
            if (localObject6 != null)
            {
              i3 = i2;
              localObject4 = localObject5;
              if (((JSONArray)localObject6).length() > 0)
              {
                int i1 = ((JSONArray)localObject6).length();
                localObject2 = new int[i1];
                k = 0;
                i3 = i2;
                localObject4 = localObject2;
                if (k < i1)
                {
                  localObject2[k] = ((JSONArray)localObject6).optInt(k);
                  localObject4 = abip.a().a(8, localObject2[k]);
                  if ((localObject4 == null) || (!((abip.a)localObject4).isResourceReady())) {
                    break label1316;
                  }
                  m = 1;
                  if (localObject4 == null) {
                    break label1302;
                  }
                  ((List)localObject7).add(localObject4);
                  break label1302;
                }
              }
            }
          }
          QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination roomIdStr:", str2, " resExsit:", Boolean.valueOf(i3) });
          if (i3 != 0)
          {
            localObject2 = new ByteArrayOutputStream();
            if (localObject3 != null)
            {
              localObject3 = a(0, 6, ((File)localObject3).getParent(), true);
              if (localObject3 != null) {
                ((ByteArrayOutputStream)localObject2).write((byte[])localObject3);
              }
            }
            if (i <= 0) {
              break label1322;
            }
            localObject3 = a(i, 1, abxi.bis + i + File.separator, false);
            if (localObject3 == null) {
              break label1322;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3);
            break label1322;
            if (i >= localObject1.length) {
              break label1339;
            }
            k = localObject1[i];
            localObject1[i] = k;
            QLog.d("ApolloPluginRscLoader", 2, new Object[] { "getCombination dressId:", Integer.valueOf(k) });
            localObject3 = a(k, 2, abxi.bir + k + File.separator, false);
            if (localObject3 == null) {
              break label1332;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3);
            break label1332;
            if (i < ((List)localObject7).size())
            {
              localObject1 = (abip.a)((List)localObject7).get(i);
              localObject1 = a(((abip.a)localObject1).mId, 8, abxi.bit + ((abip.a)localObject1).mId + File.separator, false);
              if (localObject1 == null) {
                break label1344;
              }
              ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
              break label1344;
            }
            localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
            QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination url:", paramString, " retBytes:" + localObject1.length });
            localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", new ByteArrayInputStream((byte[])localObject1));
            a((WebResourceResponse)localObject1);
            return localObject1;
          }
          localObject2 = new JSONArray();
          if ((i > 0) || ((localObject1 != null) && (localObject1.length > 0))) {
            abto.b(localAppInterface, "", new abul(this, (JSONArray)localObject2, (File)localObject3, localAppInterface, (String)localObject8, (int[])localObject4, str1), i, (int[])localObject1, -1, -1, false);
          }
        }
        else
        {
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", new abvf(null, null, null));
          a((WebResourceResponse)localObject1);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloPluginRscLoader", 1, localException, new Object[0]);
        localWebResourceResponse = new WebResourceResponse("application/octet-stream", "utf-8", new abvf(null, null, null));
        a(localWebResourceResponse);
        QLog.e("ApolloPluginRscLoader", 1, "getCombination url 解析失败:" + paramString);
        M(iO(paramString), -1, acfp.m(2131702651));
        return localWebResourceResponse;
      }
      if ((localObject3 != null) && (!((File)localObject3).exists()))
      {
        abto.a(localAppInterface, (String)localObject8, new abuo(this, (String)localObject8, (File)localObject3, (JSONArray)localObject2, (int[])localObject4, str1));
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject8)) {
          ((JSONArray)localObject2).put(a(6, (String)localObject8, 0));
        }
        if ((localObject4 == null) || (localObject4.length <= 0))
        {
          a(str1, acfp.m(2131702637), (JSONArray)localObject2);
        }
        else
        {
          a((int[])localObject4, str1, (JSONArray)localObject2);
          continue;
          return null;
          label1302:
          k += 1;
          i2 = m & i2;
          continue;
          label1316:
          int n = 0;
          continue;
          label1322:
          if (localWebResourceResponse != null)
          {
            i = 0;
            continue;
            label1332:
            i += 1;
          }
          else
          {
            label1339:
            i = 0;
            continue;
            label1344:
            i += 1;
          }
        }
      }
    }
  }
  
  private static String iM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("/");
    if (i > 0) {
      return paramString.substring(0, i);
    }
    return "";
  }
  
  private static String iN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int i;
    String str;
    do
    {
      return paramString;
      i = paramString.indexOf("/");
      str = paramString;
      if (i > 0) {
        str = paramString.substring(i + 1);
      }
      i = str.indexOf("?");
      paramString = str;
    } while (i <= 0);
    return str.substring(0, i);
  }
  
  private static String iO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Uri.parse(paramString);
        if (paramString.isHierarchical())
        {
          paramString = paramString.getQueryParameter("callbackId");
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPluginRscLoader", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  private static boolean jC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.contains("..")) {
      return false;
    }
    return true;
  }
  
  void M(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      if (this.a == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      this.a.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloPluginRscLoader", 2, localException.getMessage());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.i("ApolloPluginRscLoader", 2, "callbackId->" + paramString1 + " retCode:" + paramInt + " errorMsg: " + paramString2);
      return;
    }
  }
  
  void a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    int i = 0;
    try
    {
      if (this.a == null) {
        return;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", paramString2);
      if (paramJSONArray == null) {
        break label97;
      }
      localJSONObject.put("IdStates", paramJSONArray);
      j = paramJSONArray.length();
    }
    catch (Exception paramString1)
    {
      JSONObject localJSONObject;
      int j;
      label97:
      while (QLog.isColorLevel())
      {
        QLog.e("ApolloPluginRscLoader", 2, paramString1.getMessage());
        return;
        i += 1;
      }
    }
    if (i < j)
    {
      paramString2 = paramJSONArray.optJSONObject(i);
      if ((paramString2 != null) && (paramString2.optInt("resultCode") != 0)) {
        localJSONObject.put("result", 2);
      }
    }
    else
    {
      this.a.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("ApolloPluginRscLoader", 2, "callbackIdStatesResult result:" + localJSONObject);
      return;
    }
  }
  
  public WebResourceResponse c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((this.a == null) || (this.a.mRuntime == null)) {
      return null;
    }
    AppInterface localAppInterface = this.a.mRuntime.a();
    Object localObject3;
    do
    {
      try
      {
        paramString = paramString.replace("https://open.cmshow.qq.com", "https://cmshow.qq.com");
        localObject1 = b(paramString);
        if (localObject1 != null)
        {
          a((WebResourceResponse)localObject1);
          QLog.i("ApolloPluginRscLoader", 1, "getApolloRsc getCombination resourceUrl:" + paramString);
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloPluginRscLoader", 2, paramString, new Object[0]);
        return null;
      }
      int i;
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Room/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Room/", "");
        i = ApolloUtil.ck(iM(paramString));
        localObject1 = iN(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " roomId:" + i);
          return null;
        }
        if (!jC((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " roomId:" + i);
          return null;
        }
        localObject2 = abxi.bit + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download roomId:" + i);
        localObject2 = abip.a().a(8, i);
        if (localObject2 == null)
        {
          QLog.i("ApolloPluginRscLoader", 1, "idolRscItem == null ");
          int j = ((File)localObject1).hashCode();
          abis.a().a(localAppInterface, j, true);
          abis.a().a(j, new abus(this, i, paramString, localAppInterface, (File)localObject1));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new abvf(null, null, null));
          a(paramString);
          return paramString;
          if (((abip.a)localObject2).isResourceReady())
          {
            if (((File)localObject1).exists())
            {
              paramString = new FileInputStream((File)localObject1);
              localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
              }
              a((WebResourceResponse)localObject1);
              return localObject1;
            }
            localObject1 = iO(paramString);
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
              return null;
            }
            M((String)localObject1, 1, i + acfp.m(2131702636));
          }
          else
          {
            localObject3 = new ArrayList();
            ((List)localObject3).add(localObject2);
            abiq.a(localAppInterface, "", new abuu(this, paramString, (File)localObject1, i), (List)localObject3, false, null);
          }
        }
      }
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Role/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Role/", "");
        i = ApolloUtil.ck(iM(paramString));
        localObject1 = iN(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " roleId:" + i);
          return null;
        }
        if (!jC((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1);
          return null;
        }
        localObject2 = abxi.bis + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
          }
          a((WebResourceResponse)localObject1);
          return localObject1;
        }
        localObject2 = iO(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
          return null;
        }
        if (ApolloUtil.ih(i)) {
          M((String)localObject2, 1, i + acfp.m(2131702645));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new abvf(null, null, null));
          a(paramString);
          return paramString;
          QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download roleId:" + i);
          abto.b(localAppInterface, null, new abuv(this, (File)localObject1, (String)localObject2), i, null, -1, -1, false);
        }
      }
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Dress/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Dress/", "");
        i = ApolloUtil.ck(iM(paramString));
        localObject1 = iN(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " dressId:" + i);
          return null;
        }
        if (!jC((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1);
          return null;
        }
        localObject2 = abxi.bir + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
          }
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          a(paramString);
          return paramString;
        }
        localObject2 = iO(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
          return null;
        }
        if (ApolloUtil.ig(i)) {
          M((String)localObject2, 1, i + acfp.m(2131702657));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new abvf(null, null, null));
          a(paramString);
          return paramString;
          QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download dressId:" + i);
          abto.b(localAppInterface, null, new abuw(this, i, (File)localObject1, (String)localObject2), -1, new int[] { i }, -1, -1, false);
        }
      }
      if (paramString.startsWith("https://cmshow.qq.com/3dresource/Action/"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
        }
        paramString = paramString.replace("https://cmshow.qq.com/3dresource/Action/", "");
        i = ApolloUtil.ck(iM(paramString));
        localObject1 = iN(paramString);
        if ((i <= 0) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1 + " actionId:" + i);
          return null;
        }
        if (!jC((String)localObject1))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + (String)localObject1);
          return null;
        }
        localObject2 = abxi.bip + i + File.separator + (String)localObject1;
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + (String)localObject2);
        }
        if (((File)localObject1).exists())
        {
          paramString = new FileInputStream((File)localObject1);
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", paramString);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + paramString.available());
          }
          a((WebResourceResponse)localObject1);
          return localObject1;
        }
        localObject2 = iO(paramString);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + paramString);
          return null;
        }
        if (ApolloUtil.aF(i, 0)) {
          M((String)localObject2, 1, i + acfp.m(2131702646));
        }
        for (;;)
        {
          paramString = new WebResourceResponse("application/octet-stream", "utf-8", new abvf(null, null, null));
          a(paramString);
          return paramString;
          QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download actionId:" + i);
          abto.b(localAppInterface, null, new abux(this, (File)localObject1, (String)localObject2), -1, null, i, -1, false);
        }
      }
    } while (!paramString.startsWith("https://cmshow.qq.com/3dresource/FaceData/"));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc resourceUrl:" + paramString);
    }
    String str4 = paramString.replace("https://cmshow.qq.com/3dresource/FaceData/", "");
    String str3 = iN(str4);
    if (TextUtils.isEmpty(str3))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + str3);
      return null;
    }
    if (!jC(str3))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error rscName:" + str3);
      return null;
    }
    Object localObject2 = null;
    paramString = null;
    Object localObject1 = localObject2;
    String str1;
    try
    {
      localObject3 = iM(str4);
      paramString = (String)localObject3;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramString = (String)localObject3;
        localObject1 = localObject2;
        QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc faceDataUrl is null");
        return null;
      }
      paramString = (String)localObject3;
      localObject1 = localObject2;
      localObject3 = URLDecoder.decode((String)localObject3);
      paramString = (String)localObject3;
      localObject1 = localObject2;
      String str2 = arwv.toMD5((String)localObject3);
      localObject2 = localObject3;
      localObject4 = str2;
      paramString = (String)localObject3;
      localObject1 = str2;
      if (QLog.isColorLevel())
      {
        paramString = (String)localObject3;
        localObject1 = str2;
        QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc faceDataUrl:" + (String)localObject3);
        localObject4 = str2;
        localObject2 = localObject3;
      }
    }
    catch (Exception localException)
    {
      Object localObject4;
      for (;;)
      {
        QLog.e("ApolloPluginRscLoader", 1, "checkDownloadFaceData e" + localException);
        str1 = paramString;
        localObject4 = localObject1;
      }
      new File(abxi.bir).mkdir();
      new File(abxi.biv).mkdir();
      paramString = abxi.biv + (String)localObject4 + File.separator + str3;
      localObject1 = new File(paramString);
      if (!QLog.isColorLevel()) {
        break label2505;
      }
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc path:" + paramString);
      label2505:
      if (!((File)localObject1).exists()) {
        break label2621;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      return null;
    }
    QLog.i("ApolloPluginRscLoader", 1, "checkDownloadFaceData url data is exists:" + str4);
    if (str3.endsWith(".json")) {}
    for (paramString = "application/json";; paramString = "application/octet-stream")
    {
      localObject1 = new FileInputStream((File)localObject1);
      paramString = new WebResourceResponse(paramString, "utf-8", (InputStream)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc inputStream.available();:" + ((FileInputStream)localObject1).available());
      }
      a(paramString);
      return paramString;
      label2621:
      paramString = iO(str4);
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc faceDataUrl callbackId is null");
        return null;
      }
      QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc start download faceDataUrl:" + str1);
      abto.a(localAppInterface, str1, new abun(this, (File)localObject1, paramString));
      localObject1 = new abvf(null, null, null);
      if (str3.endsWith(".json")) {}
      for (paramString = "application/json";; paramString = "application/octet-stream")
      {
        paramString = new WebResourceResponse(paramString, "utf-8", (InputStream)localObject1);
        a(paramString);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuk
 * JD-Core Version:    0.7.0.1
 */