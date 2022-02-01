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

public class pjp
{
  public static final DateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  private pjp.a a;
  private int biV = -1;
  
  public pjp()
  {
    loadConfig();
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.c().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().find(Card.class, (String)localObject);
    if (localObject == null) {
      ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<pku.b> a(@NonNull pjp.b paramb, long paramLong1, long paramLong2)
    throws ParseException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramb.type == 1) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      if (paramb.year == 0) {
        break;
      }
      paramb = new pku.b(paramb, paramb.year);
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramb });
      localArrayList.add(paramb);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      rom.fail("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      ram.b("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(roq.aJ(1000L * l)).intValue();
      int j = Integer.valueOf(roq.aJ(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        pku.b localb = new pku.b(paramb, i);
        ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localb });
        localArrayList.add(localb);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<pku.b> a(@NonNull pjp.b paramb, long paramLong1, long paramLong2, Card paramCard)
    throws ParseException
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramb.duration <= 0) || (TextUtils.isEmpty(paramb.asP)))
    {
      rom.fail("init birthday rule failed:" + paramb, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      rom.fail("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramb, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      ram.b("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(roq.aJ(1000L * l)).intValue();
      int j = Integer.valueOf(roq.aJ(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramb, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private pjp.a a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label364:
    int i;
    try
    {
      locala = new pjp.a();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label583;
      }
      locala.aAe = bool;
      locala.asN = ((JSONObject)localObject1).optString("album_mp4");
      locala.asO = ((JSONObject)localObject1).optString("album_cover");
      locala.biW = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        locala.biX = ((JSONObject)localObject2).optInt("first_scan", 500);
        locala.biY = ((JSONObject)localObject2).optInt("inc_scan", 100);
        locala.biZ = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (locala.lL == null) {
        locala.lL = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new pjp.c(2);
        ((pjp.c)localObject3).a((JSONObject)localObject2, 6);
        locala.lL.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new pjp.c(4);
        ((pjp.c)localObject3).a((JSONObject)localObject2, 10);
        locala.lL.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new pjp.c(3);
        ((pjp.c)localObject3).a((JSONObject)localObject2, 10);
        locala.lL.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label450;
      }
      if (locala.lM != null) {
        break label571;
      }
      locala.lM = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      pjp.a locala;
      Object localObject3;
      ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
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
          locala.lM.add(localObject3);
          break label576;
          label450:
          ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
        }
      }
    }
    else
    {
      localObject1 = ((JSONObject)localObject1).optJSONArray("mutableFestivalList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = j;
        if (localJSONException.lM == null)
        {
          localJSONException.lM = new ArrayList();
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
            localJSONException.lM.add(localObject2);
            break label589;
            ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
        }
      }
      else
      {
        return localJSONException;
        label571:
        i = 0;
        break label364;
        label576:
        i += 1;
        break label364;
        label583:
        bool = false;
        break;
      }
      label589:
      i += 1;
    }
  }
  
  private pjp.b a(JSONObject paramJSONObject, boolean paramBoolean)
    throws JSONException
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    pjp.b localb = new pjp.b(i);
    localb.a(paramJSONObject, 6);
    localb.name = paramJSONObject.optString("name", "");
    localb.startAge = paramJSONObject.optInt("start_age", -2147483648);
    localb.endAge = paramJSONObject.optInt("end_age", -2147483648);
    if ((localb.startAge == -2147483648) || (localb.endAge == -2147483648))
    {
      ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localb.type == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localb.asP = paramJSONObject.optString("start", "");
        localb.duration = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localb;
      localb.year = paramJSONObject.optInt("year", 0);
      if ((localb.year == 0) && (paramBoolean))
      {
        ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localb.asP = paramJSONObject.optString("start", "");
        localb.asQ = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private pku.b a(@NonNull pjp.b paramb, Card paramCard, int paramInt)
    throws ParseException
  {
    paramb = new pku.b(paramb, paramCard, paramInt);
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramb });
    return paramb;
  }
  
  private pku.c a(@NonNull pjp.c paramc)
  {
    paramc = new pku.c(paramc);
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramc });
    return paramc;
  }
  
  private int ba(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  public boolean HZ()
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.a });
    return this.a != null;
  }
  
  public boolean Ia()
  {
    if (this.a != null) {
      return this.a.aAe;
    }
    return true;
  }
  
  public boolean Ib()
  {
    if (this.a != null)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.biV) });
      return this.biV != 0;
    }
    return false;
  }
  
  public List<pku.c> bA()
  {
    if ((this.a == null) || (this.a.lL == null) || (this.a.lL.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.lL.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((pjp.c)localIterator.next()));
    }
    return localArrayList;
  }
  
  public void bli()
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    psr.rk("");
    this.a = null;
  }
  
  public void blj()
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    psr.rl("");
    this.biV = -1;
  }
  
  public boolean eS(String paramString)
  {
    pjp.a locala = a(paramString);
    if (locala != null)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.a, paramString });
      psr.rk(paramString);
      this.a = locala;
      return true;
    }
    return false;
  }
  
  public boolean eT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.biV) });
      this.biV = ba(paramString);
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.biV) });
    } while (this.biV == -1);
    psr.rl(paramString);
    return true;
  }
  
  public List<pjy> g(long paramLong1, long paramLong2)
  {
    if ((this.a == null) || (this.a.lM == null) || (this.a.lM.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.a.lM.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (pjp.b)((Iterator)localObject1).next();
        if ((((pjp.b)localObject2).startAge >= 0) && ((localCard == null) || (localCard.age < ((pjp.b)localObject2).startAge)))
        {
          ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((pjp.b)localObject2).endAge >= 0) && ((localCard == null) || (localCard.age > ((pjp.b)localObject2).endAge)))
        {
          ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((pjp.b)localObject2).type)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((pjp.b)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new pka((pku.b)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.a, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              pku.b localb = (pku.b)localIterator.next();
              if ((localb.mStartTime > 0L) && (localb.mEndTime > 0L)) {
                localArrayList.add(0, new pka(localb));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            ram.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String getCoverUrl()
  {
    if (this.a != null) {
      return this.a.asO;
    }
    return null;
  }
  
  public void loadConfig()
  {
    String str2 = psr.mA();
    if (!TextUtils.isEmpty(str2)) {
      this.a = a(str2);
    }
    String str3 = psr.mB();
    this.biV = ba(str3);
    String str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    for (;;)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public String me()
  {
    if (this.a != null) {
      return this.a.asN;
    }
    return null;
  }
  
  public int q(boolean paramBoolean)
  {
    if (this.a != null)
    {
      if (paramBoolean) {
        return this.a.biY;
      }
      return this.a.biX;
    }
    return 0;
  }
  
  public int sf()
  {
    if (this.a != null) {
      return this.a.biZ;
    }
    return 0;
  }
  
  public int sg()
  {
    if (this.a != null) {
      return this.a.biW;
    }
    return 8;
  }
  
  public static class a
  {
    public boolean aAe;
    public String asN;
    public String asO;
    public int biW;
    public int biX = 500;
    public int biY = 100;
    public int biZ = 15;
    public List<pjp.c> lL;
    public List<pjp.b> lM;
  }
  
  public static class b
    extends pjp.c
  {
    public String asP;
    public String asQ;
    public int duration;
    public int endAge;
    public String name;
    public int startAge;
    public int year;
    
    public b(int paramInt)
    {
      super();
      this.bja = 6;
    }
  }
  
  public static class c
  {
    public String asR;
    public int bja;
    public List<String> lN;
    public int textId;
    public String transId;
    public int type;
    
    public c(int paramInt)
    {
      this.type = paramInt;
    }
    
    public c a(JSONObject paramJSONObject, int paramInt)
      throws JSONException
    {
      this.transId = paramJSONObject.optString("transId", "");
      this.bja = paramJSONObject.optInt("min_limit", paramInt);
      this.asR = paramJSONObject.optString("wording");
      this.textId = paramJSONObject.optInt("text_id", -1);
      paramJSONObject = paramJSONObject.optJSONArray("transList");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        this.lN = new ArrayList();
        paramInt = 0;
        while (paramInt < paramJSONObject.length())
        {
          this.lN.add(paramJSONObject.getString(paramInt));
          paramInt += 1;
        }
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjp
 * JD-Core Version:    0.7.0.1
 */