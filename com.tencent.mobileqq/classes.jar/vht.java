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

public class vht
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private vhu jdField_a_of_type_Vhu;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public vht()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      xvv.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().find(Card.class, (String)localObject);
    if (localObject == null) {
      xvv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<vjj> a(@NonNull vhv paramvhv, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramvhv.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      yos.a(bool);
      if (paramvhv.jdField_a_of_type_Int == 0) {
        break;
      }
      paramvhv = new vjj(paramvhv, paramvhv.jdField_a_of_type_Int);
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramvhv });
      localArrayList.add(paramvhv);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      yos.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      xvv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(ypb.c(1000L * l)).intValue();
      int j = Integer.valueOf(ypb.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        vjj localvjj = new vjj(paramvhv, i);
        xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localvjj });
        localArrayList.add(localvjj);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<vjj> a(@NonNull vhv paramvhv, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramvhv.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramvhv.jdField_b_of_type_JavaLangString)))
    {
      yos.a("init birthday rule failed:" + paramvhv, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      yos.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramvhv, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      xvv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(ypb.c(1000L * l)).intValue();
      int j = Integer.valueOf(ypb.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramvhv, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private vhu a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label361:
    int i;
    try
    {
      localvhu = new vhu();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label580;
      }
      localvhu.jdField_a_of_type_Boolean = bool;
      localvhu.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localvhu.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localvhu.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localvhu.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localvhu.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localvhu.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localvhu.jdField_a_of_type_JavaUtilList == null) {
        localvhu.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new vhw(2);
        ((vhw)localObject3).a((JSONObject)localObject2, 6);
        localvhu.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new vhw(4);
        ((vhw)localObject3).a((JSONObject)localObject2, 10);
        localvhu.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new vhw(3);
        ((vhw)localObject3).a((JSONObject)localObject2, 10);
        localvhu.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label447;
      }
      if (localvhu.jdField_b_of_type_JavaUtilList != null) {
        break label568;
      }
      localvhu.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      vhu localvhu;
      Object localObject3;
      xvv.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
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
          localvhu.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label573;
          label447:
          xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
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
            xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
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
  
  private vhv a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    vhv localvhv = new vhv(i);
    localvhv.a(paramJSONObject, 6);
    localvhv.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localvhv.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localvhv.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localvhv.jdField_c_of_type_Int == -2147483648) || (localvhv.d == -2147483648))
    {
      xvv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localvhv.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localvhv.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localvhv.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localvhv;
      localvhv.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localvhv.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        xvv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localvhv.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localvhv.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private vjj a(@NonNull vhv paramvhv, Card paramCard, int paramInt)
  {
    paramvhv = new vjj(paramvhv, paramCard, paramInt);
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramvhv });
    return paramvhv;
  }
  
  private vjk a(@NonNull vhw paramvhw)
  {
    paramvhw = new vjk(paramvhw);
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramvhw });
    return paramvhw;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Vhu != null) {
      return this.jdField_a_of_type_Vhu.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vhu != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_Vhu.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_Vhu.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Vhu != null) {
      return this.jdField_a_of_type_Vhu.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<vjk> a()
  {
    if ((this.jdField_a_of_type_Vhu == null) || (this.jdField_a_of_type_Vhu.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Vhu.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Vhu.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((vhw)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<vif> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Vhu == null) || (this.jdField_a_of_type_Vhu.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Vhu.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_Vhu.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (vhv)((Iterator)localObject1).next();
        if ((((vhv)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((vhv)localObject2).jdField_c_of_type_Int)))
        {
          xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((vhv)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((vhv)localObject2).d)))
        {
          xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((vhv)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((vhv)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new vii((vjj)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            xvv.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_Vhu, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              vjj localvjj = (vjj)localIterator.next();
              if ((localvjj.a > 0L) && (localvjj.b > 0L)) {
                localArrayList.add(0, new vii(localvjj));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            xvv.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = vuq.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Vhu = a(str2);
    }
    String str3 = vuq.g();
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
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_Vhu });
    return this.jdField_a_of_type_Vhu != null;
  }
  
  public boolean a(String paramString)
  {
    vhu localvhu = a(paramString);
    if (localvhu != null)
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_Vhu, paramString });
      vuq.g(paramString);
      this.jdField_a_of_type_Vhu = localvhu;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vhu != null) {
      return this.jdField_a_of_type_Vhu.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Vhu != null) {
      return this.jdField_a_of_type_Vhu.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    vuq.g("");
    this.jdField_a_of_type_Vhu = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Vhu != null) {
      return this.jdField_a_of_type_Vhu.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    vuq.h(paramString);
    return true;
  }
  
  public void c()
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    vuq.h("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Vhu != null)
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vht
 * JD-Core Version:    0.7.0.1
 */