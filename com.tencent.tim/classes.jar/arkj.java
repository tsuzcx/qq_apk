public class arkj
{
  private static final String[] im = { "初", "十", "廿", "卅" };
  private static final String[] in = { "", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
  private static final String[] io = { "", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊" };
  private static int[] pr = { 1887, 5780, 5802, 19157, 2742, 50359, 1198, 2646, 46378, 7466, 3412, 30122, 5482, 67949, 2396, 5294, 43597, 6732, 6954, 36181, 2772, 4954, 18781, 2396, 54427, 5274, 6730, 47781, 5800, 6868, 21210, 4790, 59703, 2350, 5270, 46667, 3402, 3496, 38325, 1388, 4782, 18735, 2350, 52374, 6804, 7498, 44457, 2906, 1388, 29294, 4700, 63789, 6442, 6804, 56138, 5802, 2772, 38235, 1210, 4698, 22827, 5418, 63125, 3476, 5802, 43701, 2484, 5302, 27223, 2646, 70954, 7466, 3412, 54698, 5482, 2412, 38062, 5294, 2636, 32038, 6954, 60245, 2772, 4826, 43357, 2394, 5274, 39501, 6730, 72357, 5800, 5844, 53978, 4790, 2358, 38039, 5270, 87627, 3402, 3496, 54708, 5484, 4782, 43311, 2350, 3222, 27978, 7498, 68965, 2904, 5484, 45677, 4700, 6444, 39573, 6804, 6986, 19285, 2772, 62811, 1210, 4698, 47403, 5418, 5780, 38570, 5546, 76469, 2420, 5302, 51799, 2646, 5414, 36501, 3412, 5546, 18869, 2412, 54446, 5276, 6732, 48422, 6822, 2900, 28010, 4826, 92509, 2394, 5274, 55883, 6730, 6820, 47956, 5812, 2778, 18779, 2358, 62615, 5270, 5450, 46757, 3492, 5556, 27318, 4718, 67887, 2350, 3222, 52554, 7498, 3428, 38252, 5468, 4700, 31022, 6444, 64149, 6804, 6986, 43861, 2772, 5338, 35421, 2650, 70955, 5418, 5780, 54954, 5546, 2740, 38074, 5302, 2646, 29991, 3366, 61011, 3412, 5546, 43445, 2412, 5294, 35406, 6732, 72998, 6820, 6996, 52586, 2778, 2396, 38045, 5274, 6698, 23333, 6820, 64338, 5812, 2746, 43355, 2358, 5270, 39499, 5450, 79525, 3492, 5548 };
  private static int[] ps = { 1887, 966732, 967231, 967733, 968265, 968766, 969297, 969798, 970298, 970829, 971330, 971830, 972362, 972863, 973395, 973896, 974397, 974928, 975428, 975929, 976461, 976962, 977462, 977994, 978494, 979026, 979526, 980026, 980558, 981059, 981559, 982091, 982593, 983124, 983624, 984124, 984656, 985157, 985656, 986189, 986690, 987191, 987722, 988222, 988753, 989254, 989754, 990286, 990788, 991288, 991819, 992319, 992851, 993352, 993851, 994383, 994885, 995385, 995917, 996418, 996918, 997450, 997949, 998481, 998982, 999483, 1000014, 1000515, 1001016, 1001548, 1002047, 1002578, 1003080, 1003580, 1004111, 1004613, 1005113, 1005645, 1006146, 1006645, 1007177, 1007678, 1008209, 1008710, 1009211, 1009743, 1010243, 1010743, 1011275, 1011775, 1012306, 1012807, 1013308, 1013840, 1014341, 1014841, 1015373, 1015874, 1016404, 1016905, 1017405, 1017937, 1018438, 1018939, 1019471, 1019972, 1020471, 1021002, 1021503, 1022035, 1022535, 1023036, 1023568, 1024069, 1024568, 1025100, 1025601, 1026102, 1026633, 1027133, 1027666, 1028167, 1028666, 1029198, 1029699, 1030199, 1030730, 1031231, 1031763, 1032264, 1032764, 1033296, 1033797, 1034297, 1034828, 1035329, 1035830, 1036362, 1036861, 1037393, 1037894, 1038394, 1038925, 1039427, 1039927, 1040459, 1040959, 1041491, 1041992, 1042492, 1043023, 1043524, 1044024, 1044556, 1045057, 1045558, 1046090, 1046590, 1047121, 1047622, 1048122, 1048654, 1049154, 1049655, 1050187, 1050689, 1051219, 1051720, 1052220, 1052751, 1053252, 1053752, 1054284, 1054786, 1055285, 1055817, 1056317, 1056849, 1057349, 1057850, 1058382, 1058883, 1059383, 1059915, 1060415, 1060947, 1061447, 1061947, 1062479, 1062981, 1063480, 1064012, 1064514, 1065014, 1065545, 1066045, 1066577, 1067078, 1067578, 1068110, 1068611, 1069112, 1069642, 1070142, 1070674, 1071175, 1071675, 1072207, 1072709, 1073209, 1073740, 1074241, 1074741, 1075273, 1075773, 1076305, 1076807, 1077308, 1077839, 1078340, 1078840, 1079372, 1079871, 1080403, 1080904 };
  
  public static arkj.a a(arkj.b paramb)
  {
    arkj.a locala = new arkj.a();
    int j = paramb.ejg - ps[0];
    int k = paramb.ejg;
    int m = paramb.ejf;
    int n = paramb.eje;
    int i = j;
    if (ps[j] > (k << 9 | m << 5 | n)) {
      i = j - 1;
    }
    m = ps[i];
    j = u(m, 12, 9);
    k = u(m, 4, 5);
    m = u(m, 5, 0);
    long l1 = c(paramb.ejg, paramb.ejf, paramb.eje);
    long l2 = c(j, k, m);
    int i2 = pr[i];
    n = u(i2, 4, 13);
    int i1 = ps[0];
    j = 1;
    l1 = 1L + (l1 - l2);
    k = 0;
    if (k < 13)
    {
      if (u(i2, 1, 12 - k) == 1) {}
      for (m = 30;; m = 29)
      {
        if (l1 <= m) {
          break label219;
        }
        j += 1;
        l1 -= m;
        k += 1;
        break;
      }
    }
    label219:
    k = (int)l1;
    locala.ejd = (i + i1);
    locala.ejc = j;
    locala.dca = false;
    if ((n != 0) && (j > n))
    {
      locala.ejc = (j - 1);
      if (j == n + 1) {
        locala.dca = true;
      }
    }
    locala.ejb = k;
    locala.cAC = a(locala);
    return locala;
  }
  
  private static arkj.b a(long paramLong)
  {
    long l3 = (10000L * paramLong + 14780L) / 3652425L;
    long l4 = paramLong - (365L * l3 + l3 / 4L - l3 / 100L + l3 / 400L);
    long l2 = l4;
    long l1 = l3;
    if (l4 < 0L)
    {
      l1 = l3 - 1L;
      l2 = paramLong - (365L * l1 + l1 / 4L - l1 / 100L + l1 / 400L);
    }
    paramLong = (100L * l2 + 52L) / 3060L;
    l3 = (2L + paramLong) / 12L;
    l4 = (paramLong * 306L + 5L) / 10L;
    arkj.b localb = new arkj.b();
    localb.ejg = ((int)(l1 + l3));
    localb.ejf = ((int)((2L + paramLong) % 12L + 1L));
    localb.eje = ((int)(l2 - l4 + 1L));
    return localb;
  }
  
  public static arkj.b a(arkj.a parama)
  {
    int n = pr[(parama.ejd - pr[0])];
    int j = u(n, 4, 13);
    int i = j;
    if (!parama.dca)
    {
      if ((parama.ejc <= j) || (j == 0)) {
        i = parama.ejc - 1;
      }
    }
    else
    {
      k = 0;
      j = 0;
      label57:
      if (k >= i) {
        break label107;
      }
      if (u(n, 1, 12 - k) != 1) {
        break label100;
      }
    }
    label100:
    for (int m = 30;; m = 29)
    {
      j += m;
      k += 1;
      break label57;
      i = parama.ejc;
      break;
    }
    label107:
    i = parama.ejb;
    int k = ps[(parama.ejd - ps[0])];
    long l = c(u(k, 12, 9), u(k, 4, 5), u(k, 5, 0));
    return a(i + j + l - 1L);
  }
  
  public static String a(arkj.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (parama.ejb == 1)
    {
      if (parama.dca) {
        localStringBuilder.append("闰");
      }
      localStringBuilder.append(io[parama.ejc]).append("月");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (parama.ejb == 10)
      {
        localStringBuilder.append("初十");
      }
      else if (parama.ejb == 20)
      {
        localStringBuilder.append("二十");
      }
      else if (parama.ejb == 30)
      {
        localStringBuilder.append("三十");
      }
      else
      {
        localStringBuilder.append(im[(parama.ejb / 10)]);
        localStringBuilder.append(in[(parama.ejb % 10)]);
      }
    }
  }
  
  private static long c(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = (paramInt2 + 9) % 12;
    paramInt1 -= paramInt2 / 10;
    int i = paramInt1 / 4;
    int j = paramInt1 / 100;
    int k = paramInt1 / 400;
    return (paramInt2 * 306 + 5) / 10 + (k + (paramInt1 * 365 + i - j)) + (paramInt3 - 1);
  }
  
  private static int u(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((1 << paramInt2) - 1 << paramInt3 & paramInt1) >> paramInt3;
  }
  
  public static class a
  {
    public String cAC;
    public boolean dca;
    public int ejb;
    public int ejc;
    public int ejd;
    
    public boolean a(a parama)
    {
      int j = 100;
      boolean bool = false;
      int k = this.ejd;
      int m = this.ejc;
      int n = this.ejb;
      int i;
      int i1;
      int i2;
      int i3;
      if (this.dca)
      {
        i = 100;
        i1 = parama.ejd;
        i2 = parama.ejc;
        i3 = parama.ejb;
        if (!parama.dca) {
          break label107;
        }
      }
      for (;;)
      {
        if (i + (n + (k * 10000 + m * 100)) < j + (i1 * 10000 + i2 * 100 + i3)) {
          bool = true;
        }
        return bool;
        i = 0;
        break;
        label107:
        j = 0;
      }
    }
  }
  
  public static class b
  {
    public String cAD;
    public int eje;
    public int ejf;
    public int ejg;
    
    public boolean a(b paramb)
    {
      return this.ejg * 10000 + this.ejf * 100 + this.eje <= paramb.ejg * 10000 + paramb.ejf * 100 + paramb.eje;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkj
 * JD-Core Version:    0.7.0.1
 */