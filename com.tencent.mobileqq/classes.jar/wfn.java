import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
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

public class wfn
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private wfo jdField_a_of_type_Wfo;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public wfn()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      yuk.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().find(Card.class, (String)localObject);
    if (localObject == null) {
      yuk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<whe> a(@NonNull wfp paramwfp, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramwfp.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      znw.a(bool);
      if (paramwfp.jdField_a_of_type_Int == 0) {
        break;
      }
      paramwfp = new whe(paramwfp, paramwfp.jdField_a_of_type_Int);
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramwfp });
      localArrayList.add(paramwfp);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      znw.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      yuk.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(zof.c(1000L * l)).intValue();
      int j = Integer.valueOf(zof.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        whe localwhe = new whe(paramwfp, i);
        yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localwhe });
        localArrayList.add(localwhe);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<whe> a(@NonNull wfp paramwfp, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramwfp.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramwfp.jdField_b_of_type_JavaLangString)))
    {
      znw.a("init birthday rule failed:" + paramwfp, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      znw.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramwfp, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      yuk.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(zof.c(1000L * l)).intValue();
      int j = Integer.valueOf(zof.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramwfp, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private wfo a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label361:
    int i;
    try
    {
      localwfo = new wfo();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label580;
      }
      localwfo.jdField_a_of_type_Boolean = bool;
      localwfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localwfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localwfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localwfo.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localwfo.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localwfo.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localwfo.jdField_a_of_type_JavaUtilList == null) {
        localwfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new wfq(2);
        ((wfq)localObject3).a((JSONObject)localObject2, 6);
        localwfo.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new wfq(4);
        ((wfq)localObject3).a((JSONObject)localObject2, 10);
        localwfo.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new wfq(3);
        ((wfq)localObject3).a((JSONObject)localObject2, 10);
        localwfo.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label447;
      }
      if (localwfo.jdField_b_of_type_JavaUtilList != null) {
        break label568;
      }
      localwfo.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      wfo localwfo;
      Object localObject3;
      yuk.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
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
          localwfo.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label573;
          label447:
          yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
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
            break label586;
            yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
        }
      }
      else
      {
        return localJSONException;
        label568:
        i = 0;
        break label361;
        label573:
        i += 1;
        break label361;
        label580:
        bool = false;
        break;
      }
      label586:
      i += 1;
    }
  }
  
  private wfp a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    wfp localwfp = new wfp(i);
    localwfp.a(paramJSONObject, 6);
    localwfp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localwfp.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localwfp.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localwfp.jdField_c_of_type_Int == -2147483648) || (localwfp.d == -2147483648))
    {
      yuk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localwfp.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localwfp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localwfp.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localwfp;
      localwfp.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localwfp.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        yuk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localwfp.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localwfp.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private whe a(@NonNull wfp paramwfp, Card paramCard, int paramInt)
  {
    paramwfp = new whe(paramwfp, paramCard, paramInt);
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramwfp });
    return paramwfp;
  }
  
  private whf a(@NonNull wfq paramwfq)
  {
    paramwfq = new whf(paramwfq);
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramwfq });
    return paramwfq;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Wfo != null) {
      return this.jdField_a_of_type_Wfo.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wfo != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_Wfo.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_Wfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Wfo != null) {
      return this.jdField_a_of_type_Wfo.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<whf> a()
  {
    if ((this.jdField_a_of_type_Wfo == null) || (this.jdField_a_of_type_Wfo.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Wfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Wfo.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((wfq)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<wga> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Wfo == null) || (this.jdField_a_of_type_Wfo.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Wfo.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_Wfo.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (wfp)((Iterator)localObject1).next();
        if ((((wfp)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((wfp)localObject2).jdField_c_of_type_Int)))
        {
          yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((wfp)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((wfp)localObject2).d)))
        {
          yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((wfp)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((wfp)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new wgd((whe)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            yuk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_Wfo, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              whe localwhe = (whe)localIterator.next();
              if ((localwhe.a > 0L) && (localwhe.b > 0L)) {
                localArrayList.add(0, new wgd(localwhe));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            yuk.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = wta.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Wfo = a(str2);
    }
    String str3 = wta.g();
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
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_Wfo });
    return this.jdField_a_of_type_Wfo != null;
  }
  
  public boolean a(String paramString)
  {
    wfo localwfo = a(paramString);
    if (localwfo != null)
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_Wfo, paramString });
      wta.h(paramString);
      this.jdField_a_of_type_Wfo = localwfo;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Wfo != null) {
      return this.jdField_a_of_type_Wfo.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Wfo != null) {
      return this.jdField_a_of_type_Wfo.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    wta.h("");
    this.jdField_a_of_type_Wfo = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Wfo != null) {
      return this.jdField_a_of_type_Wfo.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    wta.i(paramString);
    return true;
  }
  
  public void c()
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    wta.i("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Wfo != null)
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfn
 * JD-Core Version:    0.7.0.1
 */