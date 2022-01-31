import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class udx
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private udy jdField_a_of_type_Udy;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public udx()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      wsv.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().a(Card.class, (String)localObject);
    if (localObject == null) {
      wsv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<ufo> a(@NonNull udz paramudz, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramudz.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      xmh.a(bool);
      if (paramudz.jdField_a_of_type_Int == 0) {
        break;
      }
      paramudz = new ufo(paramudz, paramudz.jdField_a_of_type_Int);
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramudz });
      localArrayList.add(paramudz);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      xmh.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      wsv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(xmq.c(1000L * l)).intValue();
      int j = Integer.valueOf(xmq.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        ufo localufo = new ufo(paramudz, i);
        wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localufo });
        localArrayList.add(localufo);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<ufo> a(@NonNull udz paramudz, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramudz.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramudz.jdField_b_of_type_JavaLangString)))
    {
      xmh.a("init birthday rule failed:" + paramudz, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      xmh.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramudz, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      wsv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(xmq.c(1000L * l)).intValue();
      int j = Integer.valueOf(xmq.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramudz, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private udy a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label360:
    int i;
    try
    {
      localudy = new udy();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label579;
      }
      localudy.jdField_a_of_type_Boolean = bool;
      localudy.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localudy.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localudy.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localudy.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localudy.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localudy.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localudy.jdField_a_of_type_JavaUtilList == null) {
        localudy.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new uea(2);
        ((uea)localObject3).a((JSONObject)localObject2, 6);
        localudy.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new uea(4);
        ((uea)localObject3).a((JSONObject)localObject2, 10);
        localudy.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new uea(3);
        ((uea)localObject3).a((JSONObject)localObject2, 10);
        localudy.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label446;
      }
      if (localudy.jdField_b_of_type_JavaUtilList != null) {
        break label567;
      }
      localudy.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      udy localudy;
      Object localObject3;
      wsv.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
      return null;
    }
    if (i < ((JSONArray)localObject2).length())
    {
      localObject3 = ((JSONArray)localObject2).getJSONObject(i);
      if (localObject3 != null)
      {
        localObject3 = a((JSONObject)localObject3, false);
        if (localObject3 != null)
        {
          localudy.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label572;
          label446:
          wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
        }
      }
    }
    else
    {
      localObject1 = ((JSONObject)localObject1).optJSONArray("mutableFestivalList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = j;
        if (localJSONException.jdField_b_of_type_JavaUtilList == null)
        {
          localJSONException.jdField_b_of_type_JavaUtilList = new ArrayList();
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject2 != null)
        {
          localObject2 = a((JSONObject)localObject2, true);
          if (localObject2 != null)
          {
            localJSONException.jdField_b_of_type_JavaUtilList.add(localObject2);
            break label585;
            wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
        }
      }
      else
      {
        return localJSONException;
        label567:
        i = 0;
        break label360;
        label572:
        i += 1;
        break label360;
        label579:
        bool = false;
        break;
      }
      label585:
      i += 1;
    }
  }
  
  private udz a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    udz localudz = new udz(i);
    localudz.a(paramJSONObject, 6);
    localudz.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localudz.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localudz.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localudz.jdField_c_of_type_Int == -2147483648) || (localudz.d == -2147483648))
    {
      wsv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localudz.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localudz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localudz.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localudz;
      localudz.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localudz.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        wsv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localudz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localudz.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private ufo a(@NonNull udz paramudz, Card paramCard, int paramInt)
  {
    paramudz = new ufo(paramudz, paramCard, paramInt);
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramudz });
    return paramudz;
  }
  
  private ufp a(@NonNull uea paramuea)
  {
    paramuea = new ufp(paramuea);
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramuea });
    return paramuea;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Udy != null) {
      return this.jdField_a_of_type_Udy.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Udy != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_Udy.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_Udy.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Udy != null) {
      return this.jdField_a_of_type_Udy.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<ufp> a()
  {
    if ((this.jdField_a_of_type_Udy == null) || (this.jdField_a_of_type_Udy.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Udy.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Udy.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((uea)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<uek> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Udy == null) || (this.jdField_a_of_type_Udy.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Udy.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_Udy.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (udz)((Iterator)localObject1).next();
        if ((((udz)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((udz)localObject2).jdField_c_of_type_Int)))
        {
          wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((udz)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((udz)localObject2).d)))
        {
          wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((udz)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((udz)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new uen((ufo)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            wsv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_Udy, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              ufo localufo = (ufo)localIterator.next();
              if ((localufo.a > 0L) && (localufo.b > 0L)) {
                localArrayList.add(0, new uen(localufo));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            wsv.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = urk.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Udy = a(str2);
    }
    String str3 = urk.g();
    this.jdField_a_of_type_Int = a(str3);
    String str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    for (;;)
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_Udy });
    return this.jdField_a_of_type_Udy != null;
  }
  
  public boolean a(String paramString)
  {
    udy localudy = a(paramString);
    if (localudy != null)
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_Udy, paramString });
      urk.h(paramString);
      this.jdField_a_of_type_Udy = localudy;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Udy != null) {
      return this.jdField_a_of_type_Udy.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Udy != null) {
      return this.jdField_a_of_type_Udy.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    urk.h("");
    this.jdField_a_of_type_Udy = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Udy != null) {
      return this.jdField_a_of_type_Udy.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    urk.i(paramString);
    return true;
  }
  
  public void c()
  {
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    urk.i("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Udy != null)
    {
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udx
 * JD-Core Version:    0.7.0.1
 */