import java.util.HashMap;
import java.util.regex.Pattern;

public class sdy
{
  public static final Pattern A;
  public static final Pattern B;
  public static final Pattern C;
  public static final String[] EMO_FAST_SYMBOL;
  public static final Pattern L;
  public static final Pattern N;
  public static boolean Oq;
  public static final Pattern SMILEY_PATTERN;
  public static String aDL;
  public static final String[] aG;
  public static final String[] cc;
  private static HashMap<String, Integer> cs;
  public static final int[] eA;
  public static final int[] ez;
  private static HashMap<String, Integer> fI;
  public static final Pattern q;
  public static final Pattern s = Pattern.compile("<uin:.*?,nickname:.*?>");
  public static final Pattern u;
  
  static
  {
    A = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);
    Oq = true;
    aG = new String[] { "[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[em]e175[/em]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]" };
    EMO_FAST_SYMBOL = new String[] { "[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[/钱]", "[em]e175[/em]", "[/美女]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]", "[em]e121001[/em]", "[em]e121002[/em]", "[em]e121003[/em]", "[em]e121005[/em]", "[em]e121009[/em]", "[em]e121010[/em]", "[em]e121011[/em]", "[em]e121012[/em]", "[em]e121013[/em]", "[em]e121016[/em]", "[em]e121023[/em]", "[em]e121033[/em]", "[em]e121034[/em]", "[em]e241[/em]", "[em]e242[/em]", "[em]e243[/em]", "[em]e244[/em]", "[em]e245[/em]", "[em]e246[/em]", "[em]e247[/em]", "[em]e248[/em]", "[em]e249[/em]", "[em]e250[/em]", "[em]e251[/em]", "[em]e252[/em]", "[em]e253[/em]", "[em]e254[/em]", "[em]e255[/em]", "[em]e256[/em]", "[em]e257[/em]", "[em]e258[/em]", "[em]e259[/em]", "[em]e260[/em]", "[em]e261[/em]", "[em]e262[/em]", "[em]e263[/em]", "[em]e264[/em]", "[em]e265[/em]", "[em]e266[/em]", "[em]e267[/em]", "[em]e268[/em]", "[em]e269[/em]", "[em]e270[/em]", "[em]e271[/em]", "[em]e272[/em]", "[em]e273[/em]", "[em]e274[/em]", "[em]e275[/em]", "[em]e276[/em]", "[em]e277[/em]", "[em]e278[/em]", "[em]e279[/em]", "[em]e280[/em]", "[em]e281[/em]", "[em]e282[/em]", "[em]e283[/em]", "[em]e284[/em]", "[em]e285[/em]", "[em]e286[/em]", "[em]e287[/em]", "[em]e288[/em]", "[em]e289[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e292[/em]", "[em]e293[/em]", "[em]e295[/em]", "[em]e296[/em]", "[em]e297[/em]", "[em]e294[/em]", "[em]e298[/em]" };
    cc = new String[] { "[em]e252[/em]", "[em]e249[/em]", "[em]e243[/em]", "[em]e244[/em]", "[em]e282[/em]", "[em]e245[/em]", "[em]e248[/em]", "[em]e247[/em]", "[em]e250[/em]", "[em]e246[/em]", "[em]e241[/em]", "[em]e205[/em]", "[em]e206[/em]", "[em]e207[/em]", "[em]e209[/em]", "[em]e213[/em]", "[em]e215[/em]", "[em]e216[/em]", "[em]e217[/em]", "[em]e220[/em]", "[em]e227[/em]", "[em]e237[/em]", "[em]e238[/em]", "[em]e258[/em]", "[em]e262[/em]", "[em]e254[/em]", "[em]e255[/em]", "[em]e260[/em]", "[em]e257[/em]", "[em]e263[/em]", "[em]e264[/em]", "[em]e267[/em]", "[em]e268[/em]", "[em]e269[/em]", "[em]e270[/em]", "[em]e271[/em]", "[em]e272[/em]", "[em]e273[/em]", "[em]e274[/em]", "[em]e275[/em]", "[em]e276[/em]", "[em]e277[/em]", "[em]e278[/em]", "[/飚泪]", "[em]e281[/em]" };
    ez = new int[] { 2130840296, 2130840306, 2130840303, 2130840297, 2130840298, 2130840293, 2130840299, 2130840302, 2130840301, 2130840304, 2130840305, 2130837868, 2130837869, 2130837870, 2130837872, 2130837876, 2130837878, 2130837879, 2130837880, 2130837883, 2130837890, 2130837900, 2130837901, 2130840312, 2130840316, 2130840308, 2130840309, 2130840314, 2130840311, 2130840317, 2130840275, 2130840278, 2130840279, 2130840280, 2130840281, 2130840282, 2130840283, 2130840284, 2130840285, 2130840286, 2130840287, 2130840288, 2130840289, 2130840291, 2130840292 };
    eA = new int[] { 2130838784, 2130838785, 2130838786, 2130838787, 2130838788, 2130838789, 2130838790, 2130837767, 2130837768, 2130838793, 2130838794, 2130838795, 2130838796, 2130838797, 2130838798, 2130838799, 2130837776, 2130838801, 2130838802, 2130838803, 2130838804, 2130838805, 2130838806, 2130838807, 2130838808, 2130838809, 2130838810, 2130838811, 2130837788, 2130838813, 2130838814, 2130838815, 2130837792, 2130838817, 2130838818, 2130838819, 2130838820, 2130838821, 2130838822, 2130837799, 2130838824, 2130838825, 2130838826, 2130838827, 2130838828, 2130838829, 2130838830, 2130837807, 2130838832, 2130838833, 2130838834, 2130838835, 2130838836, 2130838837, 2130838838, 2130838839, 2130838840, 2130837817, 2130837818, 2130838843, 2130838235, 2130838845, 2130838846, 2130838847, 2130837824, 2130838849, 2130838850, 2130837827, 2130837828, 2130837829, 2130838854, 2130837831, 2130838856, 2130838240, 2130838858, 2130837835, 2130837836, 2130838239, 2130837838, 2130838863, 2130837840, 2130838865, 2130838866, 2130838867, 2130838868, 2130838869, 2130838870, 2130838871, 2130838872, 2130838873, 2130838874, 2130838875, 2130838876, 2130838877, 2130838241, 2130838879, 2130838880, 2130838881, 2130838882, 2130838883, 2130838884, 2130838885, 2130838886, 2130838887, 2130838888, 2130838889, 2130838890, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902 };
    q = Pattern.compile("@?\\{uid:.*?\\}");
    L = Pattern.compile("#?\\{id:.*?,title:.*?\\}#");
    u = Pattern.compile("\\{url:.*?,text:.*?\\}");
    SMILEY_PATTERN = Pattern.compile("\\[/(.+?)\\]", 2);
    N = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
    B = Pattern.compile("\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\]", 2);
    C = Pattern.compile("\\{text:.*?,color:.*?\\}");
    aDL = ".gif";
    alm();
    bxZ();
  }
  
  private static void alm()
  {
    cs = new HashMap();
    int i = 0;
    while (i < EMO_FAST_SYMBOL.length)
    {
      cs.put(EMO_FAST_SYMBOL[i], Integer.valueOf(i));
      i += 1;
    }
  }
  
  public static int bm(String paramString)
  {
    if (cs != null)
    {
      paramString = (Integer)cs.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return -1;
  }
  
  public static int bn(String paramString)
  {
    if ((fI != null) && (fI.containsKey(paramString)))
    {
      Integer localInteger = (Integer)fI.get(paramString);
      if (localInteger == null)
      {
        ooz.e("emotion", paramString + " 's index is null!!!!!!!!!!!!");
        return -2;
      }
      return localInteger.intValue();
    }
    return -2;
  }
  
  private static void bxZ()
  {
    if (fI == null)
    {
      fI = new HashMap();
      int i = 0;
      while (i < cc.length)
      {
        fI.put(cc[i], Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdy
 * JD-Core Version:    0.7.0.1
 */