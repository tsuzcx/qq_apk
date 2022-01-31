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

public class uig
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private uih jdField_a_of_type_Uih;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public uig()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      wxe.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().a(Card.class, (String)localObject);
    if (localObject == null) {
      wxe.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<ujx> a(@NonNull uii paramuii, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramuii.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      xqq.a(bool);
      if (paramuii.jdField_a_of_type_Int == 0) {
        break;
      }
      paramuii = new ujx(paramuii, paramuii.jdField_a_of_type_Int);
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramuii });
      localArrayList.add(paramuii);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      xqq.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      wxe.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(xqz.c(1000L * l)).intValue();
      int j = Integer.valueOf(xqz.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        ujx localujx = new ujx(paramuii, i);
        wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localujx });
        localArrayList.add(localujx);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<ujx> a(@NonNull uii paramuii, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramuii.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramuii.jdField_b_of_type_JavaLangString)))
    {
      xqq.a("init birthday rule failed:" + paramuii, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      xqq.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramuii, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      wxe.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(xqz.c(1000L * l)).intValue();
      int j = Integer.valueOf(xqz.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramuii, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private uih a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label360:
    int i;
    try
    {
      localuih = new uih();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label579;
      }
      localuih.jdField_a_of_type_Boolean = bool;
      localuih.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localuih.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localuih.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localuih.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localuih.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localuih.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localuih.jdField_a_of_type_JavaUtilList == null) {
        localuih.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new uij(2);
        ((uij)localObject3).a((JSONObject)localObject2, 6);
        localuih.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new uij(4);
        ((uij)localObject3).a((JSONObject)localObject2, 10);
        localuih.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new uij(3);
        ((uij)localObject3).a((JSONObject)localObject2, 10);
        localuih.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label446;
      }
      if (localuih.jdField_b_of_type_JavaUtilList != null) {
        break label567;
      }
      localuih.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      uih localuih;
      Object localObject3;
      wxe.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
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
          localuih.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label572;
          label446:
          wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
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
            wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
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
  
  private uii a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    uii localuii = new uii(i);
    localuii.a(paramJSONObject, 6);
    localuii.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localuii.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localuii.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localuii.jdField_c_of_type_Int == -2147483648) || (localuii.d == -2147483648))
    {
      wxe.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localuii.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localuii.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localuii.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localuii;
      localuii.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localuii.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        wxe.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localuii.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localuii.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private ujx a(@NonNull uii paramuii, Card paramCard, int paramInt)
  {
    paramuii = new ujx(paramuii, paramCard, paramInt);
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramuii });
    return paramuii;
  }
  
  private ujy a(@NonNull uij paramuij)
  {
    paramuij = new ujy(paramuij);
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramuij });
    return paramuij;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Uih != null) {
      return this.jdField_a_of_type_Uih.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uih != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_Uih.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_Uih.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Uih != null) {
      return this.jdField_a_of_type_Uih.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<ujy> a()
  {
    if ((this.jdField_a_of_type_Uih == null) || (this.jdField_a_of_type_Uih.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Uih.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Uih.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((uij)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<uit> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Uih == null) || (this.jdField_a_of_type_Uih.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Uih.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_Uih.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (uii)((Iterator)localObject1).next();
        if ((((uii)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((uii)localObject2).jdField_c_of_type_Int)))
        {
          wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((uii)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((uii)localObject2).d)))
        {
          wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((uii)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((uii)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new uiw((ujx)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            wxe.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_Uih, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              ujx localujx = (ujx)localIterator.next();
              if ((localujx.a > 0L) && (localujx.b > 0L)) {
                localArrayList.add(0, new uiw(localujx));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            wxe.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = uvt.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Uih = a(str2);
    }
    String str3 = uvt.g();
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
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_Uih });
    return this.jdField_a_of_type_Uih != null;
  }
  
  public boolean a(String paramString)
  {
    uih localuih = a(paramString);
    if (localuih != null)
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_Uih, paramString });
      uvt.h(paramString);
      this.jdField_a_of_type_Uih = localuih;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Uih != null) {
      return this.jdField_a_of_type_Uih.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Uih != null) {
      return this.jdField_a_of_type_Uih.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    uvt.h("");
    this.jdField_a_of_type_Uih = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Uih != null) {
      return this.jdField_a_of_type_Uih.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    uvt.i(paramString);
    return true;
  }
  
  public void c()
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    uvt.i("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Uih != null)
    {
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uig
 * JD-Core Version:    0.7.0.1
 */