import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aozp
{
  private static aozp a;
  private static final HashMap<String, Integer> od = new HashMap();
  protected JSONArray Q;
  protected JSONObject bQ;
  protected HashMap<String, aozp.a> oe;
  
  static
  {
    od.put("10009", Integer.valueOf(2130844496));
    od.put("10010", Integer.valueOf(2130844497));
    od.put("10011", Integer.valueOf(2130844498));
    od.put("24", Integer.valueOf(2130844499));
    od.put("25", Integer.valueOf(2130844500));
    od.put("26", Integer.valueOf(2130844501));
    od.put("27", Integer.valueOf(2130844502));
    od.put("28", Integer.valueOf(2130844503));
    od.put("29", Integer.valueOf(2130844504));
    od.put("30", Integer.valueOf(2130844505));
    od.put("31", Integer.valueOf(2130844506));
    od.put("32", Integer.valueOf(2130844507));
    od.put("20001", Integer.valueOf(2130844416));
    od.put("20002", Integer.valueOf(2130844417));
    od.put("20003", Integer.valueOf(2130847807));
  }
  
  private aozp()
  {
    try
    {
      this.oe = new LinkedHashMap();
      this.bQ = new JSONObject("{\"0\":[\"TOP\",\"23\",\"28\",\"29\",\"25\",\"31\",\"30\",\"27\",\"24\",\"26\",\"32\"],\"23\":[\"同事•朋友\",\"10009\",\"10010\",\"10011\",\"10012\"],\"24\":[\"置业安家\",\"10015\",\"10017\",\"30007\",\"30008\"],\"25\":[\"游戏\"],\"26\":[\"品牌产品\"],\"27\":[\"粉丝\"],\"28\":[\"兴趣爱好\",\"10018\",\"10019\",\"10020\",\"10021\",\"10022\",\"10023\",\"10024\",\"30000\",\"30001\",\"30002\",\"10026\"],\"29\":[\"生活休闲\",\"10029\",\"10028\",\"30003\",\"10027\",\"10031\",\"10032\",\"30004\",\"10033\",\"30005\",\"30006\",\"10014\",\"10034\"],\"30\":[\"学习考试\",\"10035\",\"10036\",\"10037\",\"10038\",\"10039\",\"10040\",\"10041\",\"10042\",\"10043\",\"10044\",\"10045\",\"10046\"],\"31\":[\"行业交流\",\"10047\",\"10048\",\"10049\",\"10050\",\"10051\",\"10052\",\"10053\",\"10054\",\"10055\",\"10056\",\"10057\",\"10058\"],\"32\":[\"家校\"],\"10009\":[\"同事\"],\"10010\":[\"亲友\"],\"10011\":[\"同学\"],\"10012\":[\"办公\"],\"10013\":[\"同城\"],\"10014\":[\"同乡\"],\"10015\":[\"业主\"],\"10017\":[\"装修\"],\"10018\":[\"影视\"],\"10019\":[\"音乐\"],\"10020\":[\"星座\"],\"10021\":[\"动漫\"],\"10022\":[\"运动\"],\"10023\":[\"读书\"],\"10024\":[\"摄影\"],\"10026\":[\"其他\"],\"10027\":[\"购物\"],\"10028\":[\"旅游\"],\"10029\":[\"美食\"],\"10030\":[\"美容\"],\"10031\":[\"宠物\"],\"10032\":[\"健康\"],\"10033\":[\"母婴\"],\"10034\":[\"其他\"],\"10035\":[\"托福\"],\"10036\":[\"雅思\"],\"10037\":[\"CET 4/6\"],\"10038\":[\"GRE\"],\"10039\":[\"GMAT\"],\"10040\":[\"MBA\"],\"10041\":[\"考研\"],\"10042\":[\"高考\"],\"10043\":[\"中考\"],\"10044\":[\"职业认证\"],\"10045\":[\"公务员\"],\"10046\":[\"其他\"],\"10047\":[\"投资\"],\"10048\":[\"IT/互联网\"],\"10049\":[\"建筑工程\"],\"10050\":[\"服务\"],\"10051\":[\"传媒\"],\"10052\":[\"营销与广告\"],\"10053\":[\"教师\"],\"10054\":[\"律师\"],\"10055\":[\"公务员\"],\"10056\":[\"银行\"],\"10057\":[\"咨询\"],\"10058\":[\"其他\"], \"20001\":[\"2000人群\"], \"20002\":[\"3000人群\"], \"20003\":[\"靓号群\"], \"30000\":[\"舞蹈\"], \"30001\":[\"电子产品\"], \"30002\":[\"汽车\"], \"30003\":[\"交友\"],\"30004\":[\"兼职\"],\"30005\":[\"二手闲置\"],\"30006\":[\"公益\"],\"30007\":[\"房屋租赁\"],\"30008\":[\"房屋出售\"]}");
      if (aeqz.c().bWb)
      {
        this.Q = new JSONArray("[{\"title\":\"熟人与家校\",\"cates\":[\"23:10011\",\"23:10009\",\"23:10010\",\"32\"]},{\"title\":\"兴趣娱乐\",\"cates\":[\"25\",\"27\",\"28\",\"29\"]},{\"title\":\"学习交流\",\"cates\":[\"31\",\"30\",\"24\",\"26\"]},{\"title\":\"靓号群与超大群\",\"cates\":[\"20001\", \"20002\", \"20003\"]}]");
        return;
      }
      this.Q = new JSONArray("[{\"title\":\"熟人与家校\",\"cates\":[\"23:10011\",\"23:10009\",\"23:10010\",\"32\"]},{\"title\":\"兴趣娱乐\",\"cates\":[\"25\",\"27\",\"28\",\"29\"]},{\"title\":\"学习交流\",\"cates\":[\"31\",\"30\",\"24\",\"26\"]},{\"title\":\"超大群\",\"cates\":[\"20001\", \"20002\"]}]");
      return;
    }
    catch (JSONException localJSONException)
    {
      this.bQ = new JSONObject();
      this.Q = new JSONArray();
      localJSONException.printStackTrace();
    }
  }
  
  public static aozp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aozp();
      }
      return a;
    }
    finally {}
  }
  
  public aozp.a a(String paramString, boolean paramBoolean)
  {
    int i = paramString.indexOf(":");
    Object localObject1;
    if (i != -1)
    {
      localObject1 = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    }
    for (;;)
    {
      if (localObject1 == null) {}
      for (i = 1; this.oe.containsKey(paramString); i = 0)
      {
        localObject2 = (aozp.a)this.oe.get(paramString);
        if ((paramBoolean) && ((((aozp.a)localObject2).list == null) || (((aozp.a)localObject2).list.isEmpty()))) {
          break;
        }
        return localObject2;
      }
      Object localObject2 = this.bQ.optJSONArray(paramString);
      aozp.a locala = new aozp.a();
      locala.SE(paramString);
      locala.parentId = ((String)localObject1);
      locala.type = i;
      locala.name = ((JSONArray)localObject2).optString(0);
      int j = ((JSONArray)localObject2).length();
      if (j > 1)
      {
        locala.cPt = true;
        if (paramBoolean)
        {
          locala.list = new ArrayList(j);
          localObject1 = new StringBuilder();
          i = 1;
          if (i < j)
          {
            Object localObject3 = ((JSONArray)localObject2).optString(i);
            JSONArray localJSONArray = this.bQ.optJSONArray((String)localObject3);
            if ((localJSONArray == null) || (localJSONArray.length() == 0)) {}
            for (;;)
            {
              i += 1;
              break;
              localObject3 = new aozp.a((String)localObject3, localJSONArray.optString(0));
              ((aozp.a)localObject3).parentId = paramString;
              locala.list.add(localObject3);
              if (i <= 2)
              {
                if (i != 1) {
                  ((StringBuilder)localObject1).append("、");
                }
                ((StringBuilder)localObject1).append(((aozp.a)localObject3).name);
              }
            }
          }
          locala.description = ((StringBuilder)localObject1).toString();
        }
      }
      this.oe.put(paramString, locala);
      return locala;
      localObject1 = null;
    }
  }
  
  public ArrayList<aozp.a> dR()
  {
    ArrayList localArrayList = new ArrayList(this.Q.length());
    int k = this.Q.length();
    int i = 0;
    while (i < k)
    {
      Object localObject = this.Q.optJSONObject(i);
      aozp.a locala1 = new aozp.a();
      locala1.type = 2;
      locala1.name = ((JSONObject)localObject).optString("title");
      localArrayList.add(locala1);
      locala1.list = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("cates");
      int m = ((JSONArray)localObject).length();
      int j = 0;
      if (j < m)
      {
        aozp.a locala2 = a(((JSONArray)localObject).optString(j), true);
        if (locala2 == null) {}
        for (;;)
        {
          j += 1;
          break;
          locala1.list.add(locala2);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static class a
  {
    public boolean cPt;
    public String description;
    public int iconResId;
    public String id;
    public ArrayList<a> list;
    public String name;
    public String parentId;
    public int type;
    
    public a() {}
    
    public a(String paramString1, String paramString2)
    {
      this.id = paramString1;
      this.name = paramString2;
    }
    
    public void SE(String paramString)
    {
      this.id = paramString;
      this.iconResId = ((Integer)aozp.od.get(paramString)).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozp
 * JD-Core Version:    0.7.0.1
 */