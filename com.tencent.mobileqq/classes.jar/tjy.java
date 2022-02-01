import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.PtsData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class tjy
{
  private static String a;
  public static final HashMap<String, String> a;
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  
  static
  {
    jdField_a_of_type_JavaLangString = "HtmlChangeUtil";
    b = "p";
    c = "section";
    d = "strong";
    e = "i";
    f = "u";
    g = "img";
    h = "video";
    i = "a";
    j = "proteus";
    k = "span";
    l = "ul";
    m = "li";
    n = "ol";
    o = "blockquote";
    p = "text-decoration";
    q = "color";
    r = "background-color";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("aqua", "#00FFFF");
    jdField_a_of_type_JavaUtilHashMap.put("black", "#000000");
    jdField_a_of_type_JavaUtilHashMap.put("blue", "#0000FF");
    jdField_a_of_type_JavaUtilHashMap.put("fuchsia", "#FF00FF");
    jdField_a_of_type_JavaUtilHashMap.put("gray", "#808080");
    jdField_a_of_type_JavaUtilHashMap.put("green", "#008000");
    jdField_a_of_type_JavaUtilHashMap.put("lime", "#00FF00");
    jdField_a_of_type_JavaUtilHashMap.put("maroon", "#800000");
    jdField_a_of_type_JavaUtilHashMap.put("navy", "#000080");
    jdField_a_of_type_JavaUtilHashMap.put("olive", "#808000");
    jdField_a_of_type_JavaUtilHashMap.put("purple", "#800080");
    jdField_a_of_type_JavaUtilHashMap.put("red", "#FF0000");
    jdField_a_of_type_JavaUtilHashMap.put("silver", "#C0C0C0");
    jdField_a_of_type_JavaUtilHashMap.put("teal", "#008080");
    jdField_a_of_type_JavaUtilHashMap.put("white", "#FFFFFF");
    jdField_a_of_type_JavaUtilHashMap.put("yellow", "#FFFF00");
  }
  
  private static int a()
  {
    return Aladdin.getConfig(267).getIntegerFromString("filter_small_pic_size", 30);
  }
  
  private static BaseData a(int paramInt, tkd paramtkd)
  {
    paramtkd = paramtkd.b(paramInt);
    try
    {
      if (!TextUtils.isEmpty(paramtkd))
      {
        paramtkd = new JSONObject(paramtkd);
        if (tjj.a(paramtkd))
        {
          if (!rad.a().a()) {
            return null;
          }
          return tjj.a(paramtkd);
        }
        paramtkd = a(paramtkd);
        return paramtkd;
      }
    }
    catch (Exception paramtkd)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "parseProteusData error!  msg=" + paramtkd);
    }
    return null;
  }
  
  public static BaseData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, tkd paramtkd, SparseArray<Float> paramSparseArray)
  {
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject1 = "";
    int i1 = paramtkd.c();
    if (i1 != 1)
    {
      Object localObject4 = localObject2;
      Object localObject5 = localObject3;
      Object localObject6 = localObject1;
      switch (i1)
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
          i1 = paramtkd.d();
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          break;
          if (!paramtkd.b().equals(g)) {
            break label336;
          }
          int i2 = paramtkd.b();
          i1 = 0;
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          if (i1 < i2)
          {
            String str = paramtkd.a(i1);
            if (str.equals("src"))
            {
              localObject1 = paramtkd.b(i1);
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
              i1 += 1;
              localObject3 = localObject5;
              localObject2 = localObject6;
              localObject1 = localObject4;
              break;
              if (str.equals("width"))
              {
                localObject6 = paramtkd.b(i1);
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
                  localObject5 = paramtkd.b(i1);
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
        label336:
        throw new IllegalArgumentException("img tag error: has other start tag");
      }
      if (!g.equals(paramtkd.b())) {}
    }
    else
    {
      if (!a()) {
        break label404;
      }
      i1 = a();
      if ((Integer.parseInt((String)localObject3) >= i1) || (Integer.parseInt((String)localObject1) >= i1)) {
        break label404;
      }
      return null;
    }
    throw new IllegalArgumentException("img tag error: has other end tag");
    label404:
    return tjf.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject2, (String)localObject3, (String)localObject1, paramSparseArray);
  }
  
  public static BaseData a(tkd paramtkd)
  {
    Object localObject2 = null;
    Object localObject1 = "";
    int i1 = paramtkd.c();
    Object localObject3 = "unknown";
    if (i1 != 1)
    {
      Object localObject4;
      switch (i1)
      {
      case 1: 
      default: 
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject4;
      case 0: 
      case 2: 
        int i2;
        Object localObject5;
        Object localObject6;
        do
        {
          for (;;)
          {
            i1 = paramtkd.d();
            localObject4 = localObject3;
            localObject3 = localObject1;
            localObject1 = localObject4;
            break;
            localObject4 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject4;
          }
          if (!paramtkd.b().equals(j)) {
            break label241;
          }
          i2 = paramtkd.b();
          i1 = 0;
          localObject4 = localObject2;
          localObject5 = localObject1;
          localObject6 = localObject3;
          localObject1 = localObject6;
          localObject3 = localObject5;
          localObject2 = localObject4;
        } while (i1 >= i2);
        localObject3 = paramtkd.a(i1);
        if (((String)localObject3).equals("id"))
        {
          localObject1 = paramtkd.b(i1);
          localObject2 = localObject4;
        }
        for (;;)
        {
          i1 += 1;
          localObject5 = localObject1;
          localObject4 = localObject2;
          break;
          if (((String)localObject3).equals("data"))
          {
            localObject2 = a(i1, paramtkd);
            localObject1 = localObject5;
          }
          else
          {
            localObject1 = localObject5;
            localObject2 = localObject4;
            if (((String)localObject3).equals("type"))
            {
              localObject6 = paramtkd.b(i1);
              localObject1 = localObject5;
              localObject2 = localObject4;
            }
          }
        }
        label241:
        throw new IllegalArgumentException("proteus tag error: has other start tag");
      }
      if (!j.equals(paramtkd.b())) {}
    }
    else
    {
      if ((!(localObject2 instanceof ProteusBookData)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label303;
      }
      ((ProteusBookData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
    }
    label303:
    while (!(localObject2 instanceof PtsData))
    {
      return localObject2;
      throw new IllegalArgumentException("proteus tag error: has other end tag");
    }
    ((PtsData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
    return localObject2;
  }
  
  private static BaseData a(tkd paramtkd, SparseArray<Float> paramSparseArray)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i1 = paramtkd.c();
    Object localObject1 = "";
    if (i1 != 1)
    {
      Object localObject2 = localObject1;
      switch (i1)
      {
      default: 
        localObject2 = localObject1;
      case 0: 
      case 1: 
      case 2: 
      case 4: 
        for (;;)
        {
          i1 = paramtkd.d();
          localObject1 = localObject2;
          break;
          localObject2 = paramtkd.b();
          if (!((String)localObject2).equals(i)) {
            throw new IllegalArgumentException(anvx.a(2131705109));
          }
          localXmlSerializer.startTag("", (String)localObject2);
          int i2 = paramtkd.b();
          i1 = 0;
          for (;;)
          {
            localObject2 = localObject1;
            if (i1 >= i2) {
              break;
            }
            String str = paramtkd.a(i1);
            localObject2 = paramtkd.b(i1);
            if (str.equals("href")) {
              localObject1 = localObject2;
            }
            localXmlSerializer.attribute("", str, (String)localObject2);
            i1 += 1;
          }
          localXmlSerializer.text(paramtkd.a());
          localObject2 = localObject1;
        }
      }
      if (i.equals(paramtkd.b())) {
        localXmlSerializer.endTag("", i);
      }
    }
    else
    {
      localXmlSerializer.flush();
      return tjf.a(localStringWriter.toString(), (String)localObject1, paramSparseArray);
    }
    throw new IllegalArgumentException("a tag error: has other end tag");
  }
  
  private static ProteusBookData a(JSONObject paramJSONObject)
  {
    localProteusBookData = new ProteusBookData();
    try
    {
      String str = paramJSONObject.getString("source_id");
      Object localObject = tmh.a("native_article", true);
      if (localObject != null) {}
      for (localObject = ((tmh)localObject).getTemplateBean(paramJSONObject);; localObject = null)
      {
        if (paramJSONObject.has("id")) {
          localProteusBookData.d = paramJSONObject.getString("id");
        }
        if (paramJSONObject.has("card_type")) {
          localProteusBookData.c = paramJSONObject.getString("card_type");
        }
        if (paramJSONObject.has("sid")) {
          localProteusBookData.e = paramJSONObject.getString("sid");
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "data: " + paramJSONObject);
        localProteusBookData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject);
        localProteusBookData.b = str;
        return localProteusBookData;
      }
      return localProteusBookData;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "parseBookData error!  msg=" + paramJSONObject);
    }
  }
  
  public static List<BaseData> a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    Object localObject = paramFastWebArticleInfo.jdField_a_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    tkc localtkc = new tkc(null);
    tkd localtkd = new tkd(Xml.newPullParser(), localtkc);
    localtkd.a(new StringReader((String)localObject));
    int i1 = localtkd.c();
    while (i1 != 1)
    {
      switch (i1)
      {
      }
      for (;;)
      {
        if (localtkd.c() != 2)
        {
          i1 = localtkd.d();
          break;
          localObject = localtkd.b();
          if ((((String)localObject).equals(b)) || (((String)localObject).equals(c)))
          {
            a(paramArticleInfo, paramFastWebArticleInfo, localtkd, localArrayList, localtkc, paramSparseArray);
          }
          else if (((String)localObject).equals(i))
          {
            localArrayList.add(a(localtkd, paramSparseArray));
          }
          else
          {
            if (((String)localObject).equals(d))
            {
              a(localtkd, localtkc, localArrayList, paramSparseArray);
              if (2 != localtkd.c()) {
                continue;
              }
              i1 = localtkd.c();
              break;
            }
            if (((String)localObject).equals(o))
            {
              localtkd.d();
              c(paramArticleInfo, paramFastWebArticleInfo, localtkd, localArrayList, localtkc, paramSparseArray);
            }
            else if (((String)localObject).equals(g))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, localtkd, paramSparseArray);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(h))
            {
              localArrayList.add(b(paramArticleInfo, paramFastWebArticleInfo, localtkd, paramSparseArray));
            }
            else if (((String)localObject).equals(j))
            {
              localObject = a(localtkd);
              if (localObject != null) {
                localArrayList.add(localObject);
              }
            }
            else if (((String)localObject).equals(k))
            {
              a(localtkd, localtkc, localArrayList, paramSparseArray);
            }
            else if ((((String)localObject).equals(l)) || (((String)localObject).equals(n)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, localtkd, localArrayList, localtkc, paramSparseArray);
            }
            else
            {
              throw new IllegalArgumentException(anvx.a(2131705108) + (String)localObject);
              a(localtkd, localtkc, localArrayList, paramSparseArray);
              if (2 == localtkd.c())
              {
                i1 = localtkd.c();
                break;
              }
            }
          }
        }
      }
      i1 = 2;
    }
    return localArrayList;
  }
  
  private static void a(SpannableString paramSpannableString, SparseArray<Object> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return;
    }
    int i1 = 0;
    label7:
    Object localObject1;
    if (i1 < paramSparseArray.size())
    {
      localObject1 = paramSparseArray.valueAt(i1);
      if (localObject1 != null) {
        break label34;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label7;
      break;
      label34:
      if ((localObject1 instanceof ArrayList))
      {
        localObject1 = (ArrayList)localObject1;
        int i2 = 0;
        while (i2 < ((ArrayList)localObject1).size())
        {
          Object localObject2 = ((tkb)((ArrayList)localObject1).get(i2)).a();
          if ((localObject2 instanceof tka)) {
            ((tka)localObject2).a(paramSpannableString.toString());
          }
          paramSpannableString.setSpan(localObject2, 0, paramSpannableString.length(), 33);
          i2 += 1;
        }
      }
      else
      {
        localObject1 = ((tkb)localObject1).a();
        if ((localObject1 instanceof tka)) {
          ((tka)localObject1).a(paramSpannableString.toString());
        }
        paramSpannableString.setSpan(localObject1, 0, paramSpannableString.length(), 33);
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, tkd paramtkd, List<BaseData> paramList, tkc paramtkc, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramtkd.c();
    int i3 = paramtkd.a();
    for (;;)
    {
      int i2;
      if (i1 != 1) {
        i2 = paramtkd.c();
      }
      switch (i2)
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
            i1 = paramtkd.d();
            break;
            localObject = paramtkd.b();
            if (a((String)localObject))
            {
              a(paramtkd, paramtkc, paramList, paramSparseArray);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(g))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramSparseArray);
              i1 = i2;
              if (localObject == null) {
                break;
              }
              paramList.add(localObject);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(h))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramSparseArray));
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(i))
            {
              paramList.add(a(paramtkd, paramSparseArray));
              i1 = i2;
              break;
            }
            if ((((String)localObject).equals(l)) || (((String)localObject).equals(n)))
            {
              b(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramList, paramtkc, paramSparseArray);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(o))
            {
              paramtkd.d();
              c(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramList, paramtkc, paramSparseArray);
              i1 = i2;
              break;
            }
          } while ((((String)localObject).equals(b)) || (((String)localObject).equals(c)));
          return;
        } while (((!paramtkd.b().equals(b)) && (!paramtkd.b().equals(c))) || (i3 != paramtkd.a()));
        return;
      }
      a(paramtkd, paramtkc, paramList, paramSparseArray);
      i1 = i2;
    }
  }
  
  public static void a(tkd paramtkd, tkc paramtkc, List<BaseData> paramList, SparseArray<Float> paramSparseArray)
  {
    int i4 = paramtkc.a();
    int i5 = paramtkc.b();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i3 = paramtkd.c();
    int i2 = 0;
    int i1;
    if (i3 != 1)
    {
      i1 = i2;
      switch (i3)
      {
      default: 
        i1 = i2;
      }
    }
    for (;;)
    {
      i3 = paramtkd.d();
      i2 = i1;
      break;
      i1 = i2 + 1;
      if (!a(paramtkd.b()))
      {
        do
        {
          paramtkd = localSpannableStringBuilder.toString();
          if (!TextUtils.isEmpty(paramtkd.replaceAll(" ", "").trim())) {
            paramList.add(tjf.a(paramtkd, localSpannableStringBuilder, i4, i5, paramSparseArray));
          }
          return;
          SpannableString localSpannableString = new SpannableString(paramtkd.a().replaceAll(" +", " ").replaceAll("\t+", " "));
          a(localSpannableString, paramtkc.b);
          localSpannableStringBuilder.append(localSpannableString);
          i1 = i2;
          break;
        } while (i2 == 0);
        i1 = i2 - 1;
      }
    }
  }
  
  private static boolean a()
  {
    return Aladdin.getConfig(267).getIntegerFromString("enable_filter_small_pic", 0) == 1;
  }
  
  private static boolean a(String paramString)
  {
    return (paramString.equals(d)) || (paramString.equals(e)) || (paramString.equals(f)) || (paramString.equals(k));
  }
  
  public static BaseData b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, tkd paramtkd, SparseArray<Float> paramSparseArray)
  {
    int i7 = paramtkd.c();
    Object localObject5 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int i2 = 0;
    int i3 = 0;
    int i1 = 1;
    if (i7 != 1)
    {
      Object localObject6 = localObject3;
      Object localObject7 = localObject5;
      int i4 = i2;
      int i5 = i3;
      Object localObject8 = localObject1;
      Object localObject9 = localObject2;
      Object localObject10 = localObject4;
      int i6 = i1;
      switch (i7)
      {
      default: 
        i6 = i1;
        localObject10 = localObject4;
        localObject9 = localObject2;
        localObject8 = localObject1;
        i5 = i3;
        i4 = i2;
        localObject7 = localObject5;
        localObject6 = localObject3;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          i7 = paramtkd.d();
          localObject3 = localObject6;
          localObject5 = localObject7;
          i2 = i4;
          i3 = i5;
          localObject1 = localObject8;
          localObject2 = localObject9;
          localObject4 = localObject10;
          i1 = i6;
          break;
          if (!paramtkd.b().equals(h)) {
            break label741;
          }
          i7 = paramtkd.b();
          i4 = 0;
          i5 = i1;
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          i1 = i2;
          localObject3 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject6;
          i2 = i3;
          i3 = i5;
          if (i4 < i7)
          {
            String str = paramtkd.a(i4);
            if (str.equals("vid"))
            {
              localObject10 = paramtkd.b(i4);
              localObject9 = localObject1;
              localObject8 = localObject5;
              localObject7 = localObject2;
              localObject6 = localObject4;
              i6 = i1;
              i5 = i2;
            }
            for (;;)
            {
              i4 += 1;
              i2 = i5;
              i1 = i6;
              localObject4 = localObject6;
              localObject2 = localObject7;
              localObject5 = localObject8;
              localObject1 = localObject9;
              localObject3 = localObject10;
              break;
              if (str.equals("width"))
              {
                i6 = Integer.valueOf(paramtkd.b(i4)).intValue();
                i5 = i2;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("height"))
              {
                i5 = Integer.valueOf(paramtkd.b(i4)).intValue();
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("cover"))
              {
                localObject9 = paramtkd.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject10 = localObject3;
              }
              else if (str.equals("tid"))
              {
                localObject8 = paramtkd.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appid"))
              {
                localObject7 = paramtkd.b(i4);
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else if (str.equals("appkey"))
              {
                localObject6 = paramtkd.b(i4);
                i5 = i2;
                i6 = i1;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
              }
              else
              {
                i5 = i2;
                i6 = i1;
                localObject6 = localObject4;
                localObject7 = localObject2;
                localObject8 = localObject5;
                localObject9 = localObject1;
                localObject10 = localObject3;
                if (str.equals("busitype"))
                {
                  i3 = Integer.valueOf(paramtkd.b(i4)).intValue();
                  i5 = i2;
                  i6 = i1;
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
          i4 = i1;
          i5 = i2;
          localObject8 = localObject2;
          localObject9 = localObject4;
          localObject10 = localObject5;
          i6 = i3;
        }
        label741:
        throw new IllegalArgumentException("video tag error: has other start tag");
      }
      if (!h.equals(paramtkd.b())) {}
    }
    else
    {
      return tjf.a(paramArticleInfo, paramFastWebArticleInfo, (String)localObject3, (String)localObject5, i2, i3, (String)localObject1, (String)localObject2, (String)localObject4, i1, paramSparseArray);
    }
    throw new IllegalArgumentException("video tag error: has other end tag");
  }
  
  private static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split(";");
    int i1 = 0;
    if (i1 < paramString.length)
    {
      Object localObject = paramString[i1].split(":");
      if (localObject.length != 2) {}
      for (;;)
      {
        i1 += 1;
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
  
  private static List<Object> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    for (;;)
    {
      int i2;
      Object localObject;
      try
      {
        String[] arrayOfString = paramString.split(";");
        i2 = 0;
        if (i2 < arrayOfString.length)
        {
          localObject = arrayOfString[i2].split(":");
          if (localObject.length != 2) {
            break label399;
          }
          paramString = localObject[0].trim();
          localObject = localObject[1].trim();
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label399;
          }
          if (!p.equals(paramString)) {
            break label172;
          }
          if (!"underline".equals(localObject)) {
            break label143;
          }
          localArrayList.add(tkb.a(3, new Object[0]));
        }
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramString, new Object[0]);
      }
      return localArrayList;
      label143:
      if ("line-through".equals(localObject))
      {
        localArrayList.add(tkb.a(5, new Object[0]));
        break label399;
        label172:
        if ((q.equals(paramString)) || (r.equals(paramString)))
        {
          int i1;
          if (((String)localObject).startsWith("rgb("))
          {
            localObject = localObject.split("\\(")[1].split("\\)")[0].split(",");
            if (localObject.length != 3) {
              break label394;
            }
            i1 = Color.rgb(Integer.valueOf(localObject[0].trim()).intValue(), Integer.valueOf(localObject[1].trim()).intValue(), Integer.valueOf(localObject[2].trim()).intValue());
          }
          while (i1 != -1)
          {
            if ("color".equals(paramString)) {}
            for (paramString = tkb.a(2, new Object[] { Integer.valueOf(i1) });; paramString = tkb.a(1, new Object[] { Integer.valueOf(i1) }))
            {
              localArrayList.add(paramString);
              break label399;
              if (((String)localObject).startsWith("#"))
              {
                i1 = Color.parseColor((String)localObject);
                break;
              }
              if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((String)localObject).toLowerCase())) {
                break label394;
              }
              i1 = Color.parseColor((String)jdField_a_of_type_JavaUtilHashMap.get(((String)localObject).toLowerCase()));
              break;
            }
            i1 = -1;
          }
        }
      }
      label394:
      label399:
      i2 += 1;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, tkd paramtkd, List<BaseData> paramList, tkc paramtkc, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramtkd.c();
    int i3 = paramtkd.a();
    for (;;)
    {
      int i2;
      if (i1 != 1) {
        i2 = paramtkd.c();
      }
      switch (i2)
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
            i1 = paramtkd.d();
            break;
            localObject = paramtkd.b();
            if (a((String)localObject))
            {
              a(paramtkd, paramtkc, paramList, paramSparseArray);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(g))
            {
              localObject = a(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramSparseArray);
              i1 = i2;
              if (localObject == null) {
                break;
              }
              paramList.add(localObject);
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(h))
            {
              paramList.add(b(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramSparseArray));
              i1 = i2;
              break;
            }
            if (((String)localObject).equals(i))
            {
              paramList.add(a(paramtkd, paramSparseArray));
              i1 = i2;
              break;
            }
          } while ((((String)localObject).equals(n)) || (((String)localObject).equals(l)));
          if ((!((String)localObject).equals(b)) && (!((String)localObject).equals(c))) {
            break label274;
          }
          a(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramList, paramtkc, paramSparseArray);
        } while (i3 != paramtkd.a());
        return;
        if (((String)localObject).equals(m))
        {
          paramtkd.d();
          a(paramtkd, paramtkc, paramList, paramSparseArray);
          i1 = i2;
        }
        else
        {
          throw new IOException("illegal tag include in list element(ul or ol)");
        }
        break;
      case 4: 
        label274:
        a(paramtkd, paramtkc, paramList, paramSparseArray);
        i1 = i2;
      }
    }
  }
  
  public static void c(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, tkd paramtkd, List<BaseData> paramList, tkc paramtkc, SparseArray<Float> paramSparseArray)
  {
    int i1 = paramtkd.c();
    switch (i1)
    {
    }
    label36:
    do
    {
      paramtkd.d();
      while (i1 == 1)
      {
        return;
        String str = paramtkd.b();
        if ((str.equals(b)) || (str.equals(c)))
        {
          a(paramArticleInfo, paramFastWebArticleInfo, paramtkd, paramList, paramtkc, paramSparseArray);
          break label36;
        }
        if (!a(str)) {
          throw new IOException("blockquote tag include no text tag !");
        }
        a(paramtkd, paramtkc, paramList, paramSparseArray);
      }
    } while (!paramtkd.b().equals(o));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tjy
 * JD-Core Version:    0.7.0.1
 */