import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class nnl
{
  private static String TAG = "HtmlChangeUtil";
  private static String TAG_P = "p";
  private static String TAG_SPAN;
  private static String amA = "section";
  private static String amB = "strong";
  private static String amC = "i";
  private static String amD = "u";
  private static String amE = "img";
  private static String amF = "video";
  private static String amG = "a";
  private static String amH = "proteus";
  private static String amI;
  private static String amJ;
  private static String amK;
  private static String amL;
  private static String amM;
  private static String amN;
  private static String amO;
  public static final HashMap<String, String> ew;
  
  static
  {
    TAG_SPAN = "span";
    amI = "ul";
    amJ = "li";
    amK = "ol";
    amL = "blockquote";
    amM = "text-decoration";
    amN = "color";
    amO = "background-color";
    ew = new HashMap();
    ew.put("aqua", "#00FFFF");
    ew.put("black", "#000000");
    ew.put("blue", "#0000FF");
    ew.put("fuchsia", "#FF00FF");
    ew.put("gray", "#808080");
    ew.put("green", "#008000");
    ew.put("lime", "#00FF00");
    ew.put("maroon", "#800000");
    ew.put("navy", "#000080");
    ew.put("olive", "#808000");
    ew.put("purple", "#800080");
    ew.put("red", "#FF0000");
    ew.put("silver", "#C0C0C0");
    ew.put("teal", "#008080");
    ew.put("white", "#FFFFFF");
    ew.put("yellow", "#FFFF00");
  }
  
  private static List<Object> F(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    for (;;)
    {
      int j;
      Object localObject;
      try
      {
        String[] arrayOfString = paramString.split(";");
        j = 0;
        if (j < arrayOfString.length)
        {
          localObject = arrayOfString[j].split(":");
          if (localObject.length != 2) {
            break label391;
          }
          paramString = localObject[0].trim();
          localObject = localObject[1].trim();
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label391;
          }
          if (!amM.equals(paramString)) {
            break label168;
          }
          if (!"underline".equals(localObject)) {
            break label140;
          }
          localArrayList.add(nnl.b.a(3, new Object[0]));
        }
      }
      catch (Exception paramString)
      {
        QLog.e(TAG, 2, paramString, new Object[0]);
      }
      return localArrayList;
      label140:
      if ("line-through".equals(localObject))
      {
        localArrayList.add(nnl.b.a(5, new Object[0]));
        break label391;
        label168:
        if ((amN.equals(paramString)) || (amO.equals(paramString)))
        {
          int i;
          if (((String)localObject).startsWith("rgb("))
          {
            localObject = localObject.split("\\(")[1].split("\\)")[0].split(",");
            if (localObject.length != 3) {
              break label386;
            }
            i = Color.rgb(Integer.valueOf(localObject[0].trim()).intValue(), Integer.valueOf(localObject[1].trim()).intValue(), Integer.valueOf(localObject[2].trim()).intValue());
          }
          while (i != -1)
          {
            if ("color".equals(paramString)) {}
            for (paramString = nnl.b.a(2, new Object[] { Integer.valueOf(i) });; paramString = nnl.b.a(1, new Object[] { Integer.valueOf(i) }))
            {
              localArrayList.add(paramString);
              break label391;
              if (((String)localObject).startsWith("#"))
              {
                i = Color.parseColor((String)localObject);
                break;
              }
              if (!ew.containsKey(((String)localObject).toLowerCase())) {
                break label386;
              }
              i = Color.parseColor((String)ew.get(((String)localObject).toLowerCase()));
              break;
            }
            i = -1;
          }
        }
      }
      label386:
      label391:
      j += 1;
    }
  }
  
  private static boolean FR()
  {
    return Aladdin.getConfig(267).getIntegerFromString("enable_filter_small_pic", 0) == 1;
  }
  
  public static BaseData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, nnl.d paramd, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject1 = "";
    int i = paramd.getEventType();
    if (i != 1)
    {
      Object localObject4 = localObject2;
      Object localObject5 = localObject3;
      Object localObject6 = localObject1;
      switch (i)
      {
      default: 
        localObject6 = localObject1;
        localObject5 = localObject3;
        localObject4 = localObject2;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          i = paramd.next();
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          break;
          if (!paramd.getName().equals(amE)) {
            break label340;
          }
          int j = paramd.getAttributeCount();
          i = 0;
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          if (i < j)
          {
            String str = paramd.getAttributeName(i);
            if (str.equals("src"))
            {
              localObject1 = paramd.getAttributeValue(i);
              localObject5 = localObject3;
              localObject6 = localObject2;
              localObject4 = localObject1;
              if (((String)localObject1).indexOf("http") == -1)
              {
                localObject4 = "http::" + (String)localObject1;
                localObject6 = localObject2;
                localObject5 = localObject3;
              }
            }
            for (;;)
            {
              i += 1;
              localObject3 = localObject5;
              localObject2 = localObject6;
              localObject1 = localObject4;
              break;
              if (str.equals("width"))
              {
                localObject6 = paramd.getAttributeValue(i);
                localObject5 = localObject3;
                localObject4 = localObject1;
              }
              else
              {
                localObject5 = localObject3;
                localObject6 = localObject2;
                localObject4 = localObject1;
                if (str.equals("height"))
                {
                  localObject5 = paramd.getAttributeValue(i);
                  localObject6 = localObject2;
                  localObject4 = localObject1;
                }
              }
            }
          }
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject6 = localObject3;
        }
        label340:
        throw new IllegalArgumentException("img tag error: has other start tag");
      }
      if (!amE.equals(paramd.getName())) {}
    }
    else
    {
      if (!FR()) {
        break label414;
      }
      i = qK();
      if ((Integer.valueOf((String)localObject3).intValue() >= i) || (Integer.valueOf((String)localObject1).intValue() >= i)) {
        break label414;
      }
      return null;
    }
    throw new IllegalArgumentException("img tag error: has other end tag");
    label414:
    return nmx.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject2, (String)localObject3, (String)localObject1, paramSparseArray);
  }
  
  public static BaseData a(nnl.d paramd)
    throws XmlPullParserException, IOException, JSONException
  {
    ProteusBookData localProteusBookData = new ProteusBookData();
    int i = paramd.getEventType();
    Object localObject;
    String str2;
    String str1;
    if (i != 1) {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
        int j;
        do
        {
          i = paramd.next();
          break;
          if (!paramd.getName().equals(amH)) {
            break label304;
          }
          j = paramd.getAttributeCount();
          i = 0;
        } while (i >= j);
        localObject = paramd.getAttributeName(i);
        if (((String)localObject).equals("id")) {
          localProteusBookData.id = paramd.getAttributeValue(i);
        }
        while (!((String)localObject).equals("data"))
        {
          i += 1;
          break;
        }
        str2 = paramd.getAttributeValue(i);
        if (!TextUtils.isEmpty(str2))
        {
          JSONObject localJSONObject = new JSONObject(str2);
          str1 = localJSONObject.getString("source_id");
          localObject = npi.a("native_article", true);
          if (localObject != null)
          {
            localObject = ((npi)localObject).getTemplateBean(localJSONObject);
            label183:
            if (localJSONObject.has("id")) {
              localProteusBookData.amb = localJSONObject.getString("id");
            }
            if (localJSONObject.has("card_type")) {
              localProteusBookData.ama = localJSONObject.getString("card_type");
            }
            if (localJSONObject.has("sid")) {
              localProteusBookData.amc = localJSONObject.getString("sid");
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, "data: " + str2);
      localProteusBookData.d = ((TemplateBean)localObject);
      localProteusBookData.sourceId = str1;
      break;
      localObject = null;
      break label183;
      label304:
      throw new IllegalArgumentException("proteus tag error: has other start tag");
      if (amH.equals(paramd.getName())) {
        return localProteusBookData;
      }
      throw new IllegalArgumentException("proteus tag error: has other end tag");
      str1 = null;
      localObject = null;
    }
  }
  
  private static BaseData a(nnl.d paramd, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i = paramd.getEventType();
    Object localObject1 = "";
    if (i != 1)
    {
      Object localObject2 = localObject1;
      switch (i)
      {
      default: 
        localObject2 = localObject1;
      case 0: 
      case 1: 
      case 2: 
      case 4: 
        for (;;)
        {
          i = paramd.next();
          localObject1 = localObject2;
          break;
          localObject2 = paramd.getName();
          if (!((String)localObject2).equals(amG)) {}
          localXmlSerializer.startTag("", (String)localObject2);
          int j = paramd.getAttributeCount();
          i = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i >= j) {
              break;
            }
            String str = paramd.getAttributeName(i);
            localObject2 = paramd.getAttributeValue(i);
            if (str.equals("href")) {
              localObject1 = localObject2;
            }
            localXmlSerializer.attribute("", str, (String)localObject2);
            i += 1;
          }
          localXmlSerializer.text(paramd.getText());
          localObject2 = localObject1;
        }
      }
      if (amG.equals(paramd.getName())) {
        localXmlSerializer.endTag("", amG);
      }
    }
    else
    {
      localXmlSerializer.flush();
      return nmx.a(localStringWriter.toString(), (String)localObject1, paramSparseArray);
    }
    throw new IllegalArgumentException("a tag error: has other end tag");
  }
  
  public static List<BaseData> a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException, JSONException
  {
    Object localObject = paramFastWebArticleInfo.articleContent;
    ArrayList localArrayList = new ArrayList();
    nnl.c localc = new nnl.c(null);
    nnl.d locald = new nnl.d(Xml.newPullParser(), localc);
    locald.setInput(new StringReader((String)localObject));
    int i = locald.getEventType();
    while (i != 1)
    {
      switch (i)
      {
      }
      for (;;)
      {
        if (locald.getEventType() != 2)
        {
          i = locald.next();
          break;
          localObject = locald.getName();
          if ((((String)localObject).equals(TAG_P)) || (((String)localObject).equals(amA)))
          {
            a(paramArticleInfo, paramFastWebArticleInfo, locald, localArrayList, localc, paramSparseArray);
          }
          else if (((String)localObject).equals(amG))
          {
            localArrayList.add(a(locald, paramSparseArray));
          }
          else
          {
            if (((String)localObject).equals(amB))
            {
              a(locald, localc, localArrayList, paramSparseArray);
              if (2 != locald.getEventType()) {
                continue;
              }
              i = locald.getEventType();
              break;
            }
            if (((String)localObject).equals(amL))
            {
              locald.next();
              c(paramArticleInfo, paramFastWebArticleInfo, locald, localArrayList, localc, paramSparseArray);
            }
            else if (((String)localObject).equals(amE))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, locald, paramSparseArray);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(amF))
            {
              localArrayList.add(b(paramArticleInfo, paramFastWebArticleInfo, locald, paramSparseArray));
            }
            else if (((String)localObject).equals(amH))
            {
              localArrayList.add(a(locald));
            }
            else if (((String)localObject).equals(TAG_SPAN))
            {
              a(locald, localc, localArrayList, paramSparseArray);
            }
            else if ((((String)localObject).equals(amI)) || (((String)localObject).equals(amK)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, locald, localArrayList, localc, paramSparseArray);
              continue;
              a(locald, localc, localArrayList, paramSparseArray);
              if (2 == locald.getEventType())
              {
                i = locald.getEventType();
                break;
              }
            }
          }
        }
      }
      i = 2;
    }
    return localArrayList;
  }
  
  private static void a(SpannableString paramSpannableString, SparseArray<Object> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return;
    }
    int i = 0;
    label7:
    Object localObject1;
    if (i < paramSparseArray.size())
    {
      localObject1 = paramSparseArray.valueAt(i);
      if (localObject1 != null) {
        break label34;
      }
    }
    for (;;)
    {
      i += 1;
      break label7;
      break;
      label34:
      if ((localObject1 instanceof ArrayList))
      {
        localObject1 = (ArrayList)localObject1;
        int j = 0;
        while (j < ((ArrayList)localObject1).size())
        {
          Object localObject2 = ((nnl.b)((ArrayList)localObject1).get(j)).build();
          if ((localObject2 instanceof nnl.a)) {
            ((nnl.a)localObject2).setTarget(paramSpannableString.toString());
          }
          paramSpannableString.setSpan(localObject2, 0, paramSpannableString.length(), 33);
          j += 1;
        }
      }
      else
      {
        localObject1 = ((nnl.b)localObject1).build();
        if ((localObject1 instanceof nnl.a)) {
          ((nnl.a)localObject1).setTarget(paramSpannableString.toString());
        }
        paramSpannableString.setSpan(localObject1, 0, paramSpannableString.length(), 33);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, nnl.d paramd, List<BaseData> paramList, nnl.c paramc, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    int i = paramd.getEventType();
    int k = paramd.getDepth();
    for (;;)
    {
      int j;
      if (i != 1) {
        j = paramd.getEventType();
      }
      switch (j)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        do
        {
          Object localObject;
          do
          {
            i = paramd.next();
            break;
            localObject = paramd.getName();
            if (ed((String)localObject))
            {
              a(paramd, paramc, paramList, paramSparseArray);
              i = j;
              break;
            }
            if (((String)localObject).equals(amE))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, paramd, paramSparseArray);
              i = j;
              if (localObject == null) {
                break;
              }
              paramList.add(localObject);
              i = j;
              break;
            }
            if (((String)localObject).equals(amF))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramd, paramSparseArray));
              i = j;
              break;
            }
            if (((String)localObject).equals(amG))
            {
              paramList.add(a(paramd, paramSparseArray));
              i = j;
              break;
            }
            if ((((String)localObject).equals(amI)) || (((String)localObject).equals(amK)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, paramd, paramList, paramc, paramSparseArray);
              i = j;
              break;
            }
            if (((String)localObject).equals(amL))
            {
              paramd.next();
              c(paramArticleInfo, paramFastWebArticleInfo, paramd, paramList, paramc, paramSparseArray);
              i = j;
              break;
            }
          } while ((((String)localObject).equals(TAG_P)) || (((String)localObject).equals(amA)));
          return;
        } while (((!paramd.getName().equals(TAG_P)) && (!paramd.getName().equals(amA))) || (k != paramd.getDepth()));
        return;
      }
      a(paramd, paramc, paramList, paramSparseArray);
      i = j;
    }
  }
  
  public static void a(nnl.d paramd, nnl.c paramc, List<BaseData> paramList, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    int m = paramc.qL();
    int n = paramc.getTextStyle();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int k = paramd.getEventType();
    int j = 0;
    int i;
    if (k != 1)
    {
      i = j;
      switch (k)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      k = paramd.next();
      j = i;
      break;
      i = j + 1;
      if (!ed(paramd.getName()))
      {
        do
        {
          paramd = localSpannableStringBuilder.toString();
          if (!TextUtils.isEmpty(paramd.replaceAll(" ", "").trim())) {
            paramList.add(nmx.a(paramd, localSpannableStringBuilder, m, n, paramSparseArray));
          }
          return;
          SpannableString localSpannableString = new SpannableString(paramd.getText().replaceAll(" +", " ").replaceAll("\t+", " "));
          a(localSpannableString, paramc.aC);
          localSpannableStringBuilder.append(localSpannableString);
          i = j;
          break;
        } while (j == 0);
        i = j - 1;
      }
    }
  }
  
  public static BaseData b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, nnl.d paramd, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    int i2 = paramd.getEventType();
    Object localObject5 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int j = 0;
    int k = 0;
    int i = 1;
    if (i2 != 1)
    {
      Object localObject6 = localObject3;
      Object localObject7 = localObject5;
      int m = j;
      int n = k;
      Object localObject8 = localObject1;
      Object localObject9 = localObject2;
      Object localObject10 = localObject4;
      int i1 = i;
      switch (i2)
      {
      default: 
        i1 = i;
        localObject10 = localObject4;
        localObject9 = localObject2;
        localObject8 = localObject1;
        n = k;
        m = j;
        localObject7 = localObject5;
        localObject6 = localObject3;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          i2 = paramd.next();
          localObject3 = localObject6;
          localObject5 = localObject7;
          j = m;
          k = n;
          localObject1 = localObject8;
          localObject2 = localObject9;
          localObject4 = localObject10;
          i = i1;
          break;
          if (!paramd.getName().equals(amF)) {
            break label749;
          }
          i2 = paramd.getAttributeCount();
          m = 0;
          n = i;
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          i = j;
          localObject3 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject6;
          j = k;
          k = n;
          if (m < i2)
          {
            String str = paramd.getAttributeName(m);
            if (str.equals("vid"))
            {
              localObject10 = paramd.getAttributeValue(m);
              localObject9 = localObject1;
              localObject8 = localObject5;
              localObject7 = localObject2;
              localObject6 = localObject4;
              i1 = i;
              n = j;
            }
            for (;;)
            {
              m += 1;
              j = n;
              i = i1;
              localObject4 = localObject6;
              localObject2 = localObject7;
              localObject5 = localObject8;
              localObject1 = localObject9;
              localObject3 = localObject10;
              break;
              if (str.equals("width"))
              {
                i1 = Integer.valueOf(paramd.getAttributeValue(m)).intValue();
                n = j;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("height"))
              {
                n = Integer.valueOf(paramd.getAttributeValue(m)).intValue();
                i1 = i;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("cover"))
              {
                localObject9 = paramd.getAttributeValue(m);
                n = j;
                i1 = i;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject10 = localObject3;
              }
              else if (str.equals("tid"))
              {
                localObject8 = paramd.getAttributeValue(m);
                n = j;
                i1 = i;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appid"))
              {
                localObject7 = paramd.getAttributeValue(m);
                n = j;
                i1 = i;
                localObject6 = localObject4;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appkey"))
              {
                localObject6 = paramd.getAttributeValue(m);
                n = j;
                i1 = i;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else
              {
                n = j;
                i1 = i;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
                if (str.equals("busitype"))
                {
                  k = Integer.valueOf(paramd.getAttributeValue(m)).intValue();
                  n = j;
                  i1 = i;
                  localObject6 = localObject4;
                  localObject7 = localObject2;
                  localObject8 = localObject5;
                  localObject9 = localObject1;
                  localObject10 = localObject3;
                }
              }
            }
          }
          localObject6 = localObject1;
          localObject7 = localObject3;
          m = i;
          n = j;
          localObject8 = localObject2;
          localObject9 = localObject4;
          localObject10 = localObject5;
          i1 = k;
        }
        label749:
        throw new IllegalArgumentException("video tag error: has other start tag");
      }
      if (!amF.equals(paramd.getName())) {}
    }
    else
    {
      return nmx.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject3, (String)localObject5, j, k, (String)localObject1, (String)localObject2, (String)localObject4, i, paramSparseArray);
    }
    throw new IllegalArgumentException("video tag error: has other end tag");
  }
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, nnl.d paramd, List<BaseData> paramList, nnl.c paramc, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    int i = paramd.getEventType();
    int k = paramd.getDepth();
    for (;;)
    {
      int j;
      if (i != 1) {
        j = paramd.getEventType();
      }
      switch (j)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        Object localObject;
        do
        {
          do
          {
            i = paramd.next();
            break;
            localObject = paramd.getName();
            if (ed((String)localObject))
            {
              a(paramd, paramc, paramList, paramSparseArray);
              i = j;
              break;
            }
            if (((String)localObject).equals(amE))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, paramd, paramSparseArray);
              i = j;
              if (localObject == null) {
                break;
              }
              paramList.add(localObject);
              i = j;
              break;
            }
            if (((String)localObject).equals(amF))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramd, paramSparseArray));
              i = j;
              break;
            }
            if (((String)localObject).equals(amG))
            {
              paramList.add(a(paramd, paramSparseArray));
              i = j;
              break;
            }
          } while ((((String)localObject).equals(amK)) || (((String)localObject).equals(amI)));
          if ((!((String)localObject).equals(TAG_P)) && (!((String)localObject).equals(amA))) {
            break label274;
          }
          a(paramArticleInfo, paramFastWebArticleInfo, paramd, paramList, paramc, paramSparseArray);
        } while (k != paramd.getDepth());
        return;
        if (((String)localObject).equals(amJ))
        {
          paramd.next();
          a(paramd, paramc, paramList, paramSparseArray);
          i = j;
        }
        else
        {
          throw new IOException("illegal tag include in list element(ul or ol)");
        }
        break;
      case 4: 
        label274:
        a(paramd, paramc, paramList, paramSparseArray);
        i = j;
      }
    }
  }
  
  public static void c(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, nnl.d paramd, List<BaseData> paramList, nnl.c paramc, SparseArray<Float> paramSparseArray)
    throws XmlPullParserException, IOException
  {
    int i = paramd.getEventType();
    switch (i)
    {
    }
    label36:
    do
    {
      paramd.next();
      while (i == 1)
      {
        return;
        String str = paramd.getName();
        if ((str.equals(TAG_P)) || (str.equals(amA)))
        {
          a(paramArticleInfo, paramFastWebArticleInfo, paramd, paramList, paramc, paramSparseArray);
          break label36;
        }
        if (!ed(str)) {
          throw new IOException("blockquote tag include no text tag !");
        }
        a(paramd, paramc, paramList, paramSparseArray);
      }
    } while (!paramd.getName().equals(amL));
  }
  
  private static boolean ed(String paramString)
  {
    return (paramString.equals(amB)) || (paramString.equals(amC)) || (paramString.equals(amD)) || (paramString.equals(TAG_SPAN));
  }
  
  private static HashMap<String, String> g(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split(";");
    int i = 0;
    if (i < paramString.length)
    {
      Object localObject = paramString[i].split(":");
      if (localObject.length != 2) {}
      for (;;)
      {
        i += 1;
        break;
        String str = localObject[0].trim();
        localObject = localObject[1].trim();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str.toLowerCase(), ((String)localObject).toLowerCase());
        }
      }
    }
    return localHashMap;
  }
  
  private static int qK()
  {
    return Aladdin.getConfig(267).getIntegerFromString("filter_small_pic_size", 30);
  }
  
  public static class a
    implements LineBackgroundSpan
  {
    private int color;
    private String target;
    
    public a(int paramInt)
    {
      this.color = paramInt;
    }
    
    public void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8) {}
    
    public void setTarget(String paramString)
    {
      this.target = paramString;
    }
  }
  
  static class b
  {
    private int bax;
    private int color;
    int type;
    
    public static b a(int paramInt, Object... paramVarArgs)
    {
      b localb = new b();
      localb.type = paramInt;
      switch (paramInt)
      {
      case 3: 
      default: 
        return localb;
      case 1: 
      case 2: 
        localb.color = ((Integer)paramVarArgs[0]).intValue();
        return localb;
      }
      localb.bax = ((Integer)paramVarArgs[0]).intValue();
      return localb;
    }
    
    public Object build()
    {
      switch (this.type)
      {
      default: 
        return null;
      case 1: 
        return new nnl.a(this.color);
      case 2: 
        return new ForegroundColorSpan(this.color);
      case 5: 
        return new StrikethroughSpan();
      case 4: 
        return new StyleSpan(this.bax);
      }
      return new UnderlineSpan();
    }
  }
  
  static class c
  {
    SparseArray<Integer> aB = new SparseArray();
    SparseArray<Object> aC = new SparseArray();
    Stack<String> b = new Stack();
    
    public int getTextStyle()
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        String str = (String)this.b.get(i);
        if (nnl.amL.equals(str)) {
          return 3;
        }
        if (nnl.amJ.equals(str)) {
          return 2;
        }
        i -= 1;
      }
      return 1;
    }
    
    public int qL()
    {
      int j = -1;
      int i = 3;
      int k = 0;
      if (k < this.aB.size())
      {
        if (this.aB.keyAt(k) <= j) {
          break label72;
        }
        i = this.aB.keyAt(k);
        j = ((Integer)this.aB.valueAt(k)).intValue();
      }
      for (;;)
      {
        int m = k + 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        return i;
        label72:
        m = j;
        j = i;
        i = m;
      }
    }
  }
  
  static class d
  {
    nnl.c jdField_a_of_type_Nnl$c;
    XmlPullParser jdField_a_of_type_OrgXmlpullV1XmlPullParser;
    
    public d(XmlPullParser paramXmlPullParser, nnl.c paramc)
    {
      this.jdField_a_of_type_OrgXmlpullV1XmlPullParser = paramXmlPullParser;
      this.jdField_a_of_type_Nnl$c = paramc;
    }
    
    public void aZy()
      throws XmlPullParserException
    {
      int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
      int m = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
      switch (i)
      {
      default: 
      case 2: 
        String str;
        do
        {
          for (;;)
          {
            return;
            str = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
            this.jdField_a_of_type_Nnl$c.b.push(str);
            QLog.d("fast_web", 2, new Object[] { "【start】 depth : ", Integer.valueOf(m), ", name : ", str });
            if (!nnl.TAG_SPAN.equals(str)) {
              break;
            }
            i = 0;
            while (i < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount())
            {
              if (this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(i).trim().equals("style"))
              {
                this.jdField_a_of_type_Nnl$c.aC.put(m, nnl.G(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(i).trim()));
                return;
              }
              i += 1;
            }
          }
          if (nnl.amB.equals(str))
          {
            this.jdField_a_of_type_Nnl$c.aC.put(m, nnl.b.a(4, new Object[] { Integer.valueOf(1) }));
            return;
          }
          if (nnl.amD.equals(str))
          {
            this.jdField_a_of_type_Nnl$c.aC.put(m, nnl.b.a(3, new Object[0]));
            return;
          }
          if (nnl.amC.equals(str))
          {
            this.jdField_a_of_type_Nnl$c.aC.put(m, nnl.b.a(4, new Object[] { Integer.valueOf(2) }));
            return;
          }
        } while ((!nnl.TAG_P.equals(str)) && (!nnl.amA.equals(str)));
        int j = 0;
        int k = 0;
        if (j < this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount())
        {
          if (!this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(j).trim().equals("style")) {
            i = k;
          }
          for (;;)
          {
            j += 1;
            k = i;
            break;
            str = (String)nnl.h(this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(j)).get("text-align");
            i = k;
            if (!TextUtils.isEmpty(str)) {
              if ("right".equals(str))
              {
                i = 2;
              }
              else if ("left".equals(str))
              {
                i = 0;
              }
              else
              {
                i = k;
                if ("center".equals(str)) {
                  i = 1;
                }
              }
            }
          }
        }
        this.jdField_a_of_type_Nnl$c.aB.put(m, Integer.valueOf(k));
        return;
      }
      QLog.d("fast_web", 2, new Object[] { "【remove】 depth : ", Integer.valueOf(m), ", name : ", this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName(), " size : ", Integer.valueOf(this.jdField_a_of_type_Nnl$c.aC.size()) });
      if (!this.jdField_a_of_type_Nnl$c.b.isEmpty())
      {
        this.jdField_a_of_type_Nnl$c.b.pop();
        this.jdField_a_of_type_Nnl$c.aC.remove(m);
        this.jdField_a_of_type_Nnl$c.aB.remove(m);
        return;
      }
      throw new RuntimeException("tag is not close !");
    }
    
    public int getAttributeCount()
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeCount();
    }
    
    public String getAttributeName(int paramInt)
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeName(paramInt);
    }
    
    public String getAttributeValue(int paramInt)
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getAttributeValue(paramInt);
    }
    
    public int getDepth()
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getDepth();
    }
    
    public int getEventType()
      throws XmlPullParserException
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getEventType();
    }
    
    public String getName()
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getName();
    }
    
    public String getText()
    {
      return this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.getText();
    }
    
    public int next()
      throws XmlPullParserException, IOException
    {
      int i = this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.next();
      aZy();
      return i;
    }
    
    public void setInput(Reader paramReader)
      throws XmlPullParserException
    {
      this.jdField_a_of_type_OrgXmlpullV1XmlPullParser.setInput(paramReader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnl
 * JD-Core Version:    0.7.0.1
 */