import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;

public class aado
{
  private static volatile aado a;
  private static final String[] dd = { acfp.m(2131713809), acfp.m(2131713799), acfp.m(2131713780) };
  private static final String[] de = { acfp.m(2131713805), acfp.m(2131713800), acfp.m(2131713785) };
  
  public static aado a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aado();
      }
      return a;
    }
    finally {}
  }
  
  public boolean Wh()
  {
    Object localObject = aagd.getQQAppInterface();
    if (localObject != null)
    {
      localObject = (aaai)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((aaai)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
  
  public String cU(int paramInt)
  {
    Object localObject1 = aagd.getQQAppInterface();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (aaai)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((aaai)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
          if (paramInt != 0) {
            break label110;
          }
          localObject1 = dd;
          label59:
          localObject2 = localObject1;
          if (localJSONArray != null)
          {
            if (localJSONArray.length() != 0) {
              break label117;
            }
            localObject2 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        return localObject2[(new java.util.Random().nextInt(localObject2.length + 0) + 0)];
        localObject1 = "thx_text_list";
        break;
        label110:
        localObject1 = de;
        break label59;
        label117:
        localObject2 = new String[localJSONArray.length()];
        paramInt = 0;
      }
      while (paramInt < localJSONArray.length())
      {
        localObject2[paramInt] = localJSONArray.optString(paramInt);
        paramInt += 1;
        continue;
        return null;
      }
      continue;
      localObject2 = null;
    }
  }
  
  public int yz()
  {
    Object localObject = aagd.getQQAppInterface();
    if (localObject != null)
    {
      localObject = (aaai)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((aaai)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aado
 * JD-Core Version:    0.7.0.1
 */