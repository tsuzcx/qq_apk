import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.text.EmotcationConstants.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class aoff
{
  public static final SparseIntArray ah;
  public static int dOp;
  public static int dOq;
  public static final String[] hj;
  public static String[] hk;
  public static String[] hl = { "f001", "f004", "f005", "f009", "f010", "f013", "f018", "f019", "f020", "f025", "f037", "f043", "f098", "f099", "f100", "f217", "f218", "f219" };
  public static final short[] n;
  public static final Map<String, Integer> nu;
  public static final short[] o;
  public static final int[] ol = { 2130837760, 2130837761, 2130837762, 2130837763, 2130837764, 2130837765, 2130837766, 2130837767, 2130837768, 2130837769, 2130837770, 2130837771, 2130837772, 2130837773, 2130837774, 2130837775, 2130837776, 2130837777, 2130837778, 2130837779, 2130837780, 2130837781, 2130837782, 2130837783, 2130837784, 2130837785, 2130837786, 2130837787, 2130837788, 2130837789, 2130837790, 2130837791, 2130837792, 2130837793, 2130837794, 2130837795, 2130837796, 2130837797, 2130837798, 2130837799, 2130837800, 2130837801, 2130837802, 2130837803, 2130837804, 2130837805, 2130837806, 2130837807, 2130837808, 2130837809, 2130837810, 2130837811, 2130837812, 2130837813, 2130837814, 2130837815, 2130837816, 2130837817, 2130837818, 2130837819, 2130838235, 2130837821, 2130837822, 2130837823, 2130837824, 2130837825, 2130837826, 2130837827, 2130837828, 2130837829, 2130837830, 2130837831, 2130837832, 2130838236, 2130837834, 2130837835, 2130837836, 2130837837, 2130837838, 2130837839, 2130837840, 2130837841, 2130837842, 2130837843, 2130837844, 2130837845, 2130837846, 2130837847, 2130837848, 2130837849, 2130837850, 2130837851, 2130837852, 2130837853, 2130838237, 2130837855, 2130837856, 2130837857, 2130837858, 2130837859, 2130837860, 2130837861, 2130837862, 2130837863, 2130837864, 2130837865, 2130837866, 2130837867, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902, 2130840197, 2130840198, 2130840199, 2130840200, 2130840201, 2130840202, 2130840203, 2130840204, 2130840205, 2130840206, 2130840207, 2130840208, 2130840209, 2130840210, 2130840211, 2130840212, 2130840213, 2130840214, 2130840215, 2130840216, 2130840217, 2130840218, 2130840219, 2130840220, 2130840221, 2130840222, 2130840223, 2130840224, 2130840225, 2130840226, 2130840227, 2130840228, 2130840229, 2130840230, 2130840231, 2130840232, 2130840233, 2130840234, 2130840235, 2130840236, 2130840237, 2130840238, 2130840239, 2130840240, 2130840241, 2130840242, 2130840243, 2130840244, 2130840245, 2130840246, 2130840247, 2130840248, 2130840249, 2130840250, 2130840251, 2130840252, 2130840253, 2130840254, 2130840255, 2130840256, 2130840257, 2130840258, 2130840259, 2130840260, 2130840261, 2130840262, 2130840263, 2130840264, 2130840265, 2130840266, 2130840267, 2130840268, 2130840269, 2130840270, 2130840271, 2130840272, 2130840273 };
  public static final int[] om = { 2130838784, 2130838785, 2130838786, 2130838787, 2130838788, 2130838789, 2130838790, 2130837767, 2130837768, 2130838793, 2130838794, 2130838795, 2130838796, 2130838797, 2130838798, 2130838799, 2130837776, 2130838801, 2130838802, 2130838803, 2130838804, 2130838805, 2130838806, 2130838807, 2130838808, 2130838809, 2130838810, 2130838811, 2130837788, 2130838813, 2130838814, 2130838815, 2130837792, 2130838817, 2130838818, 2130838819, 2130838820, 2130838821, 2130838822, 2130837799, 2130838824, 2130838825, 2130838826, 2130838827, 2130838828, 2130838829, 2130838830, 2130837807, 2130838832, 2130838833, 2130838834, 2130838835, 2130838836, 2130838837, 2130838838, 2130838839, 2130838840, 2130837817, 2130837818, 2130838843, 2130838235, 2130838845, 2130838846, 2130838847, 2130837824, 2130838849, 2130838850, 2130837827, 2130837828, 2130837829, 2130838854, 2130837831, 2130838856, 2130838240, 2130838858, 2130837835, 2130837836, 2130838239, 2130837838, 2130838863, 2130837840, 2130838865, 2130838866, 2130838867, 2130838868, 2130838869, 2130838870, 2130838871, 2130838872, 2130838873, 2130838874, 2130838875, 2130838876, 2130838877, 2130838241, 2130838879, 2130838880, 2130838881, 2130838882, 2130838883, 2130838884, 2130838885, 2130838886, 2130838887, 2130838888, 2130838889, 2130838890, 2130837867, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902, 2130840275, 2130840276, 2130840277, 2130840278, 2130840279, 2130840280, 2130840281, 2130840282, 2130840283, 2130840284, 2130840285, 2130840286, 2130840287, 2130840288, 2130840289, 2130840290, 2130840291, 2130840292, 2130840293, 2130840294, 2130840295, 2130840296, 2130840297, 2130840298, 2130840299, 2130840300, 2130840301, 2130840302, 2130840303, 2130840304, 2130840305, 2130840306, 2130840307, 2130840308, 2130840309, 2130840310, 2130840311, 2130840312, 2130840313, 2130840314, 2130840315, 2130840316, 2130840317, 2130840318, 2130840319, 2130840320, 2130840321, 2130840322, 2130840323, 2130840324, 2130840325, 2130840326, 2130840327, 2130840328, 2130840329, 2130840330, 2130840331, 2130840332, 2130840333, 2130840334, 2130840335, 2130840336, 2130840337, 2130840338, 2130840339, 2130840340, 2130840341, 2130840342, 2130840343, 2130840344, 2130840345, 2130840346, 2130840347, 2130840348, 2130840349, 2130840350, 2130840351 };
  public static int[] on = { 133, 121, 142, 136, 131, 125, 122, 129, 139, 124, 111, 135, 115, 137, 134, 132, 138, 128, 113, 114, 126, 127, 107 };
  public static int[] oo;
  public static final int[] op;
  public static final int[] oq;
  public static final int[] or;
  
  static
  {
    dOp = om.length;
    hj = new String[] { "/呲牙", "/调皮", "/流汗", "/偷笑", "/再见", "/敲打", "/擦汗", "/猪头", "/玫瑰", "/流泪", "/大哭", "/嘘...", "/酷", "/抓狂", "/委屈", "/便便", "/炸弹", "/菜刀", "/可爱", "/色", "/害羞", "/得意", "/吐", "/微笑", "/发怒", "/尴尬", "/惊恐", "/冷汗", "/爱心", "/示爱", "/白眼", "/傲慢", "/难过", "/惊讶", "/疑问", "/睡", "/亲亲", "/憨笑", "/爱情", "/衰", "/撇嘴", "/阴险", "/奋斗", "/发呆", "/右哼哼", "/拥抱", "/坏笑", "/飞吻", "/鄙视", "/晕", "/悠闲", "/可怜", "/赞", "/踩", "/握手", "/胜利", "/抱拳", "/凋谢", "/饭", "/蛋糕", "/西瓜", "/啤酒", "/瓢虫", "/勾引", "/OK", "/爱你", "/咖啡", "/钱", "/月亮", "/美女", "/刀", "/发抖", "/差劲", "/拳头", "/心碎", "/太阳", "/礼物", "/足球", "/骷髅", "/挥手", "/闪电", "/饥饿", "/困", "/咒骂", "/折磨", "/抠鼻", "/鼓掌", "/糗大了", "/左哼哼", "/哈欠", "/快哭了", "/吓", "/篮球", "/乒乓", "/NO", "/跳跳", "/怄火", "/转圈", "/磕头", "/回头", "/跳绳", "/激动", "/街舞", "/献吻", "/左太极", "/右太极", "/闭嘴", "/招财进宝", "/双喜", "/鞭炮", "/灯笼", "/发财", "/K歌", "/购物", "/邮件", "/帅", "/喝彩", "/祈祷", "/爆筋", "/棒棒糖", "/喝奶", "/下面", "/香蕉", "/飞机", "/开车", "/高铁左车头", "/车厢", "/高铁右车头", "/多云", "/下雨", "/钞票", "/熊猫", "/灯泡", "/风车", "/闹钟", "/打伞", "/彩球", "/钻戒", "/沙发", "/纸巾", "/药", "/手枪", "/青蛙", "/不开心", "/啊", "/惶恐", "/冷漠", "/呃", "/好棒", "/拜托", "/点赞", "/无聊", "/托脸", "/吃", "/送花", "/害怕", "/花痴", "/小样儿", "/脸红", "/飙泪", "/我不看", "/托腮", "/哇哦", "/茶", "/眨眼睛", "/泪奔", "/无奈", "/卖萌", "/小纠结", "/喷血", "/斜眼笑", "/doge", "/惊喜", "/骚扰", "/笑哭", "/我最美", "/河蟹", "/羊驼", "/栗子", "/幽灵", "/蛋", "/马赛克", "/菊花", "/肥皂", "/红包", "/大笑", "/啵啵", "/糊脸", "/拍头", "/扯一扯", "/舔一舔", "/蹭一蹭", "/拽炸天", "/顶呱呱", "/抱抱", "/暴击", "/开枪", "/撩一撩", "/拍桌", "/拍手", "/恭喜", "/干杯", "/嘲讽", "/哼", "/佛系", "/掐一掐", "/惊呆", "/颤抖", "/啃头", "/偷看", "/扇脸", "/原谅", "/喷脸", "/生日快乐", "/头撞击", "/甩头", "/扔狗", "/加油必胜", "/加油抱抱", "/口罩护体" };
    dOq = 247;
    oo = new int[] { 128522, 128524, 128538, 128531, 128560, 128541, 128513, 128540, 9786, 128521, 128525, 128532, 128516, 128527, 128530, 128563, 128536, 128557, 128561, 128514, 128170, 128074, 128077, 9757, 128079, 9996, 128078, 128591, 128076, 128072, 128073, 128070, 128071, 128064, 128067, 128068, 128066, 127834, 127837, 127836, 127833, 127847, 127843, 127874, 127838, 127828, 127859, 127839, 127866, 127867, 127864, 9749, 127822, 127818, 127827, 127817, 128138, 128684, 127876, 127801, 127881, 127796, 128157, 127872, 127880, 128026, 128141, 128163, 128081, 128276, 11088, 10024, 128168, 128166, 128293, 127942, 128176, 128164, 9889, 128099, 128169, 128137, 9832, 128235, 128273, 128274, 9992, 128644, 128663, 128676, 128690, 128014, 128640, 128652, 9973, 128105, 128104, 128103, 128102, 128053, 128025, 128055, 128128, 128036, 128040, 128046, 128020, 128056, 128123, 128027, 128032, 128054, 128047, 128124, 128039, 128051, 128045, 128082, 128087, 128132, 128096, 128098, 127746, 128092, 128089, 128085, 128095, 9729, 9728, 9748, 127769, 9924, 11093, 10060, 10068, 10069, 9742, 128247, 128241, 128224, 128187, 127909, 127908, 128299, 128191, 128147, 9827, 126980, 12349, 127920, 128677, 128679, 127928, 128136, 128704, 128701, 127968, 9962, 127974, 127973, 127976, 127975, 127978, 128697, 128698, 169, 174, 8482, 9786, 9888, 9917, 9925, 9978, 9989, 9994, 9995, 10052, 12951, 127383, 127804, 127808, 127812, 127815, 127820, 127821, 127824, 127846, 127853, 127868, 127918, 127923, 127925, 127929, 127931, 127934, 127936, 127946, 128009, 128013, 128044, 128126, 128127, 128148, 128162, 128175, 128552, 128201, 128205, 128222, 128512, 128545, 128515, 128516, 128517, 128518, 128519, 128520, 128522, 128523, 128525, 128526, 128528, 128529, 128531, 128533, 128535, 128537, 128539, 128542, 128543, 128544, 128547, 128548, 128550, 128551, 128553, 128554, 128555, 128556, 128558, 128559, 128562, 128565, 128566, 128567, 128534, 128549, 128546, 128114, 128115, 128110, 128119, 128130, 128118, 128116, 128117, 128113, 128120, 128570, 128568, 128571, 128573, 128572, 128576, 128575, 128569, 128574, 128121, 128122, 128584, 128585, 128586, 128125, 127775, 128171, 128165, 128167, 128069, 128075, 128080, 128588, 128694, 127939, 128131, 128107, 128106, 128108, 128109, 128143, 128145, 128111, 128582, 128581, 128129, 128587, 128134, 128135, 128133, 128112, 128590, 128589, 128583, 127913, 128094, 128097, 128084, 128090, 127933, 128086, 128088, 128188, 128093, 128091, 128083, 128155, 128153, 128156, 128154, 10084, 128151, 128149, 128150, 128158, 128152, 128140, 128139, 128142, 128100, 128101, 128172, 128173, 128058, 128049, 128057, 128048, 128059, 128061, 128023, 128018, 128052, 128017, 128024, 128060, 128038, 128037, 128035, 128034, 128029, 128028, 128030, 128012, 128031, 128011, 128004, 128015, 128000, 128003, 128005, 128007, 128016, 128019, 128021, 128022, 128001, 128002, 128050, 128033, 128010, 128043, 128042, 128006, 128008, 128041, 128062, 128144, 127800, 127799, 127803, 127802, 127809, 127811, 127810, 127807, 127806, 127797, 127794, 127795, 127792, 127793, 127760, 127774, 127773, 127770, 127761, 127762, 127763, 127764, 127765, 127766, 127767, 127768, 127772, 127771, 127757, 127758, 127759, 127755, 127756, 127776, 127744, 127745, 127752, 127754, 127885, 127886, 127890, 127891, 127887, 127878, 127879, 127888, 127889, 127875, 127877, 127873, 127883, 127882, 127884, 128302, 128249, 128252, 128192, 128189, 128190, 128223, 128225, 128250, 128251, 128266, 128265, 128264, 128263, 128277, 128226, 128227, 9203, 8987, 9200, 8986, 128275, 128271, 128272, 128270, 128161, 128294, 128262, 128261, 128268, 128267, 128269, 128705, 128703, 128295, 128297, 128296, 128682, 128298, 128180, 128181, 128183, 128182, 128179, 128184, 128242, 128231, 128229, 128228, 9993, 128233, 128232, 128239, 128234, 128236, 128237, 128238, 128230, 128221, 128196, 128195, 128209, 128202, 128220, 128203, 128197, 128198, 128199, 128193, 128194, 9986, 128204, 128206, 10002, 9999, 128207, 128208, 128213, 128215, 128216, 128217, 128211, 128212, 128210, 128218, 128214, 128278, 128219, 128300, 128301, 128240, 127911, 127932, 127926, 127930, 127927, 127183, 127924, 127922, 127919, 127944, 9918, 127921, 127945, 9971, 128693, 128692, 127937, 127943, 127935, 127938, 127940, 127907, 127861, 127862, 127865, 127863, 127860, 127829, 127831, 127830, 127835, 127844, 127857, 127845, 127832, 127858, 127842, 127841, 127849, 127854, 127848, 127856, 127850, 127851, 127852, 127855, 127823, 127819, 127826, 127825, 127816, 127840, 127814, 127813, 127805, 127969, 127979, 127970, 127971, 127977, 128146, 127980, 127972, 127751, 127750, 127983, 127984, 127981, 128508, 128510, 128507, 127748, 127749, 127747, 128509, 127753, 127904, 127905, 9970, 127906, 128674, 128675, 9875, 128186, 128641, 128642, 128650, 128649, 128670, 128646, 128645, 128648, 128647, 128669, 128651, 128643, 128654, 128653, 128665, 128664, 128661, 128662, 128667, 128666, 128680, 128660, 128656, 128673, 128671, 128672, 128668, 128655, 127915, 128678, 128304, 9981, 127982, 128511, 127914, 127917, 128681, 128287, 128290, 128291, 11014, 11015, 11013, 128288, 128289, 128292, 8599, 8598, 8600, 8601, 8596, 8597, 128260, 9664, 9654, 128316, 128317, 8617, 8618, 8505, 9194, 9193, 9195, 9196, 10549, 10548, 128256, 128257, 128258, 127381, 127385, 127378, 127379, 127382, 128246, 127910, 127489, 127535, 127539, 127541, 127540, 127538, 127568, 127545, 127546, 127542, 127514, 128699, 128700, 128702, 128688, 128686, 127359, 9855, 128685, 127543, 127544, 127490, 9410, 128706, 128708, 128709, 128707, 127569, 12953, 127377, 127384, 127380, 128683, 128286, 128245, 128687, 128689, 128691, 128695, 128696, 9940, 10035, 10055, 10062, 10036, 128159, 127386, 128243, 128244, 127344, 127345, 127374, 127358, 128160, 10175, 9851, 9800, 9801, 9802, 9803, 9804, 9805, 9806, 9807, 9808, 9809, 9810, 9811, 9934, 128303, 128185, 128178, 128177, 8252, 8265, 10071, 10067, 128285, 128282, 128281, 128283, 128284, 128359, 128336, 128348, 128337, 128349, 128338, 128350, 128339, 128351, 128340, 128352, 128341, 128342, 128343, 128344, 128345, 128346, 128353, 128354, 128355, 128356, 128357, 128358, 10006, 10133, 10134, 10135, 9824, 9829, 9830, 128174, 10004, 9745, 128280, 128279, 10160, 12336, 128305, 9724, 9723, 9726, 9725, 9642, 9643, 128314, 128306, 128307, 9899, 9898, 128308, 128309, 128315, 11036, 11035, 128310, 128311, 128312, 128313, 128657, 128658, 128659 };
    hk = new String[] { "嘿嘿", "羞涩", "亲亲", "汗", "紧张", "吐舌", "呲牙", "淘气", "可爱", "媚眼", "花痴", "失落", "高兴", "哼哼", "不屑", "瞪眼", "飞吻", "大哭", "害怕", "激动", "肌肉", "拳头", "厉害", "向上", "鼓掌", "胜利", "鄙视", "合十", "好的", "向左", "向右", "向上", "向下", "眼睛", "鼻子", "嘴唇", "耳朵", "米饭", "意面", "拉面", "饭团", "刨冰", "寿司", "蛋糕", "起司", "汉堡", "煎蛋", "薯条", "啤酒", "干杯", "高脚杯", "咖啡", "苹果", "橙子", "草莓", "西瓜", "药丸", "吸烟", "圣诞树", "玫瑰", "庆祝", "椰子树", "礼物", "蝴蝶结", "气球", "海螺", "戒指", "炸弹", "皇冠", "铃铛", "星星", "闪光", "吹气", "水", "火", "奖杯", "钱", "睡觉", "闪电", "脚印", "便便", "打针", "热", "文件", "钥匙", "锁", "飞机", "列车", "汽车", "快艇", "自行车", "骑马", "火箭", "公交", "船", "妈妈", "爸爸", "女孩", "男孩", "猴", "章鱼", "猪", "骷髅", "小鸡", "树懒", "牛", "公鸡", "青蛙", "幽灵", "虫", "鱼", "狗", "老虎", "天使", "企鹅", "海豚", "老鼠", "帽子", "连衣裙", "口红", "高跟鞋", "鞋子", "雨伞", "包", "内衣", "衣服", "鞋子", "云朵", "晴天", "雨天", "月亮", "雪人", "正确", "错误", "问好", "叹号", "电话", "相机", "手机", "传真", "电脑", "摄影机", "话筒", "手枪", "光碟", "爱心", "扑克", "麻将", "股票", "老虎机", "信号灯", "路障", "吉他", "理发厅", "浴缸", "马桶", "家", "教堂", "银行", "医院", "酒店", "取款机", "超市", "男性", "女性" };
    long l = SystemClock.uptimeMillis();
    ah = new SparseIntArray(oo.length);
    nu = new HashMap(300);
    int i = 0;
    while (i < dOq)
    {
      int j = oo[i];
      ah.put(j, i);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppleEmojiManager", 2, "old init cost:" + (SystemClock.uptimeMillis() - l) + "EMOJI_CODES.length=" + oo.length);
    }
    dUt();
    op = new int[] { 13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    oq = new int[] { 33, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
    n = new short[] { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    o = new short[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 41, 20, 44, 22, 10, 21, 107, 36, 11, 26, 25, 2, 1, 24, 0, 70, 0, 0, 0, 0, 48, 0, 96, 0, 72, 97, 39, 0, 78, 0, 0, 61, 9, 58, 0, 29, 75, 60, 77, 0, 0, 76, 0, 0, 69, 53, 54, 0, 0, 33, 13, 0, 14, 23, 27, 3, 38, 51, 8, 0, 0, 46, 67, 59, 0, 0, 0, 0, 0, 0, 55, 16, 4, 19, 31, 32, 82, 83, 43, 84, 35, 12, 50, 85, 40, 79, 6, 5, 68, 0, 81, 17, 71, 0, 56, 28, 7, 86, 87, 88, 47, 89, 45, 90, 49, 15, 91, 42, 37, 92, 52, 18, 62, 93, 94, 30, 63, 57, 64, 74, 73, 66, 95, 65, 98, 99, 100, 101, 80, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    or = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 67, 69, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
  }
  
  public static int aO(int paramInt1, int paramInt2)
  {
    if (((paramInt2 > 127994) && (paramInt2 < 128000)) || ((paramInt1 > 127461) && (paramInt1 < 127488)) || ((paramInt1 <= 34) || (paramInt1 >= 64) || (nu == null))) {
      return -1;
    }
    Integer localInteger = (Integer)nu.get(paramInt1 + "|" + paramInt2);
    if (localInteger != null) {}
    for (paramInt1 = localInteger.intValue();; paramInt1 = -1) {
      return paramInt1;
    }
  }
  
  public static String c(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString1;
      if (Character.codePointCount(paramString1, 0, paramString1.length()) != paramString1.length()) {
        break;
      }
    } while (!paramString1.contains(new String(new char[] { '\024' })));
    if (QLog.isColorLevel()) {
      QLog.i(aoff.class.getSimpleName(), 2, "beforeXml:" + paramString1);
    }
    StringBuilder localStringBuilder1 = new StringBuilder("[emoji:0x%05x");
    StringBuilder localStringBuilder2 = new StringBuilder("[sysEmo:%03d-%03d");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder1.append(paramString2);
      localStringBuilder2.append(paramString2);
    }
    localStringBuilder1.append(']');
    localStringBuilder2.append(']');
    paramString2 = null;
    if (QLog.isColorLevel()) {
      paramString2 = new StringBuilder(1024).append("beforXml start");
    }
    int m = paramString1.length();
    int k = 0;
    String str1 = paramString1;
    if (k < m)
    {
      int i1 = str1.codePointAt(k);
      String str2;
      int j;
      int i;
      if (i1 > 65535)
      {
        str2 = str1.substring(k, k + 2);
        paramString1 = String.format(localStringBuilder1.toString(), new Object[] { Integer.valueOf(i1) });
        str1 = str1.replace(str2, paramString1);
        k += paramString1.length() - 1;
        m = str1.length();
        j = k;
        i = m;
        paramString1 = str1;
        if (QLog.isColorLevel())
        {
          paramString2.append("\n").append("unicode").append(":").append(i1);
          paramString1 = str1;
          i = m;
          j = k;
        }
      }
      for (;;)
      {
        k = j + 1;
        m = i;
        str1 = paramString1;
        break;
        j = k;
        i = m;
        paramString1 = str1;
        if (i1 == 20)
        {
          j = k;
          i = m;
          paramString1 = str1;
          if (k + 2 < m)
          {
            j = k;
            i = m;
            paramString1 = str1;
            if (paramBoolean)
            {
              i1 = str1.codePointAt(k + 1);
              int i2 = str1.codePointAt(k + 2);
              str2 = str1.substring(k, k + 3);
              paramString1 = String.format(localStringBuilder2.toString(), new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
              str1 = str1.replace(str2, paramString1);
              k += paramString1.length() - 1;
              m = str1.length();
              j = k;
              i = m;
              paramString1 = str1;
              if (QLog.isColorLevel())
              {
                paramString2.append("\n").append("sysEmo").append(":").append(i1).append("|").append(i2);
                j = k;
                i = m;
                paramString1 = str1;
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmotcationConstants", 2, paramString2.toString());
    }
    return str1;
  }
  
  public static String d(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      j = paramString1.length();
      if (paramString2 != null) {
        break label30;
      }
    }
    label30:
    for (int i = 0; j < i + 15; i = paramString2.length()) {
      return paramString1;
    }
    Object localObject1 = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
    Object localObject2 = new StringBuilder("\\[sysEmo:[0-9]{3}-[0-9]{3}");
    int j = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject2).append(paramString2);
      j = paramString2.length();
    }
    ((StringBuilder)localObject1).append("\\]");
    ((StringBuilder)localObject2).append("\\]");
    Object localObject3 = Pattern.compile(((StringBuilder)localObject1).toString()).matcher(paramString1);
    localObject1 = new StringBuffer();
    paramString2 = null;
    if (QLog.isColorLevel()) {
      paramString2 = new StringBuilder(1024).append("afterXml src:").append(paramString1).append(" start");
    }
    i = 0;
    int k;
    int m;
    while (((Matcher)localObject3).find())
    {
      k = 1;
      m = Integer.valueOf(paramString1.substring(((Matcher)localObject3).start() + 9, ((Matcher)localObject3).end() - 1 - j), 16).intValue();
      if (m > 65535) {
        ((Matcher)localObject3).appendReplacement((StringBuffer)localObject1, new String(new int[] { m }, 0, 1));
      }
      i = k;
      if (QLog.isColorLevel())
      {
        paramString2.append("\n").append("unicode").append(":").append(m);
        i = k;
      }
    }
    ((Matcher)localObject3).appendTail((StringBuffer)localObject1);
    if (paramBoolean)
    {
      localObject3 = ((StringBuffer)localObject1).toString();
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher((CharSequence)localObject3);
      localObject1 = new StringBuffer();
      if (((Matcher)localObject2).find())
      {
        k = 1;
        String[] arrayOfString = ((String)localObject3).substring(((Matcher)localObject2).start() + 8, ((Matcher)localObject2).end() - 1 - j).split("-");
        m = Integer.valueOf(arrayOfString[0], 10).intValue();
        int i1 = Integer.valueOf(arrayOfString[1], 10).intValue();
        if (m != 92) {
          ((Matcher)localObject2).appendReplacement((StringBuffer)localObject1, new String(new char[] { '\024', (char)m }));
        }
        for (;;)
        {
          ((StringBuffer)localObject1).append((char)i1);
          i = k;
          if (!QLog.isColorLevel()) {
            break;
          }
          paramString2.append("\n").append("sysEmo").append(":").append(m).append("|").append(i1);
          i = k;
          break;
          ((Matcher)localObject2).appendReplacement((StringBuffer)localObject1, new String(new char[] { '\024' }));
          ((StringBuffer)localObject1).append((char)m);
        }
      }
      ((Matcher)localObject2).appendTail((StringBuffer)localObject1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmotcationConstants", 2, paramString2.toString());
      }
      if (i == 0) {
        break;
      }
      return ((StringBuffer)localObject1).toString();
    }
  }
  
  public static void dUt()
  {
    SystemClock.uptimeMillis();
    long l = SystemClock.uptimeMillis();
    File localFile1 = new File(aofd.INDEX_FILE);
    File localFile2 = new File(aofd.ckz);
    Object localObject2 = BaseApplicationImpl.getContext();
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferencesName((Context)localObject2);
      localObject1 = ((Context)localObject2).getSharedPreferences((String)localObject1, 4);
      boolean bool = ((SharedPreferences)localObject1).getBoolean("build_emoji_file", false);
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "loadEmojiMapFormDisk buildSuccess=" + bool);
      }
      if ((!bool) || (!localFile1.exists()) || (!localFile2.exists())) {
        break label192;
      }
      g(localFile1, localFile2);
    }
    label408:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "init full emoji index cost:" + (SystemClock.uptimeMillis() - l));
      }
      return;
      localObject1 = ((Context)localObject2).getPackageName() + "_preferences";
      break;
      label192:
      localObject1 = ((SharedPreferences)localObject1).getString("apple_emoji_file", "");
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "loadEmojiMapFormDisk filepath=" + (String)localObject1);
      }
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ThreadManager.post(new EmotcationConstants.1(localFile1, localFile2, (File)localObject2), 5, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("MF", 2, "zipfile path=" + (String)localObject1);
          }
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label408;
        }
        QLog.d("AppleEmojiManager", 2, "emoji index file not exist,load fail");
        break;
        BaseApplication.getContext().getSharedPreferences(new AppleEmojiData().getSharedPreferencesName(), 4).edit().clear().commit();
        nu.clear();
        dUu();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AppleEmojiManager", 2, "apple_emoji_file sp is null reload");
        }
        dUu();
      }
    }
  }
  
  public static void dUu()
  {
    try
    {
      Object localObject = (afem)BaseApplicationImpl.getApplication().getRuntime().getManager(77);
      if (localObject != null)
      {
        localObject = (afer)((afem)localObject).a("qq.android.appleemoji");
        if (localObject != null) {
          ((afer)localObject).HL(true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "clear sharePreference info,zipfile path is null restartDownload");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AppleEmojiManager", 2, "reDownloadAppleEmoji e=" + localException);
    }
  }
  
  public static String fv(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= hk.length)) {
      return " 未知 ";
    }
    return hk[paramInt] + " ";
  }
  
  /* Error */
  public static void g(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +20 -> 25
    //   8: invokestatic 1928	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +13 -> 24
    //   14: ldc_w 1930
    //   17: iconst_2
    //   18: ldc_w 2509
    //   21: invokestatic 1956	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: invokestatic 1905	android/os/SystemClock:uptimeMillis	()J
    //   28: lstore 5
    //   30: invokestatic 2352	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: astore 8
    //   35: getstatic 2357	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 24
    //   40: if_icmplt +220 -> 260
    //   43: aload 8
    //   45: invokestatic 2363	android/preference/PreferenceManager:getDefaultSharedPreferencesName	(Landroid/content/Context;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload 8
    //   52: aload 7
    //   54: iconst_4
    //   55: invokevirtual 2369	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   58: ldc_w 2371
    //   61: iconst_0
    //   62: invokeinterface 2377 3 0
    //   67: ifeq -43 -> 24
    //   70: aload_0
    //   71: invokevirtual 2385	java/io/File:exists	()Z
    //   74: ifeq -50 -> 24
    //   77: aload_1
    //   78: invokevirtual 2385	java/io/File:exists	()Z
    //   81: ifeq -57 -> 24
    //   84: getstatic 1918	aoff:nu	Ljava/util/Map;
    //   87: invokeinterface 2457 1 0
    //   92: new 2511	java/io/BufferedInputStream
    //   95: dup
    //   96: new 2513	java/io/FileInputStream
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 2516	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 2519	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_1
    //   108: aload_1
    //   109: astore_0
    //   110: aload_1
    //   111: invokevirtual 2522	java/io/BufferedInputStream:read	()I
    //   114: istore_2
    //   115: iload_2
    //   116: iconst_m1
    //   117: if_icmpeq +258 -> 375
    //   120: iload_2
    //   121: iconst_1
    //   122: if_icmpne +167 -> 289
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokestatic 2525	aofd:b	(Ljava/io/InputStream;)I
    //   131: istore_2
    //   132: aload_1
    //   133: astore_0
    //   134: aload_1
    //   135: invokestatic 2525	aofd:b	(Ljava/io/InputStream;)I
    //   138: istore_3
    //   139: aload_1
    //   140: astore_0
    //   141: getstatic 1913	aoff:ah	Landroid/util/SparseIntArray;
    //   144: iload_2
    //   145: iload_3
    //   146: sipush 1000
    //   149: iadd
    //   150: invokevirtual 1922	android/util/SparseIntArray:put	(II)V
    //   153: goto -45 -> 108
    //   156: astore 7
    //   158: aload_1
    //   159: astore_0
    //   160: ldc_w 1930
    //   163: iconst_1
    //   164: ldc_w 2406
    //   167: aload 7
    //   169: invokestatic 2529	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 2532	java/io/BufferedInputStream:close	()V
    //   180: invokestatic 1928	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq -159 -> 24
    //   186: ldc_w 1930
    //   189: iconst_2
    //   190: new 1932	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 1934	java/lang/StringBuilder:<init>	()V
    //   197: invokestatic 2395	wja:b	()Ljava/lang/StringBuilder;
    //   200: ldc_w 2534
    //   203: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokestatic 1905	android/os/SystemClock:uptimeMillis	()J
    //   209: lload 5
    //   211: lsub
    //   212: invokevirtual 1943	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 1952	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 2536
    //   224: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: getstatic 1913	aoff:ah	Landroid/util/SparseIntArray;
    //   230: invokevirtual 2539	android/util/SparseIntArray:size	()I
    //   233: invokevirtual 1948	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc_w 2541
    //   239: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: getstatic 1918	aoff:nu	Ljava/util/Map;
    //   245: invokeinterface 2542 1 0
    //   250: invokevirtual 1948	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 1952	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 1956	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: return
    //   260: new 1932	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 1934	java/lang/StringBuilder:<init>	()V
    //   267: aload 8
    //   269: invokevirtual 2400	android/content/Context:getPackageName	()Ljava/lang/String;
    //   272: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 2402
    //   278: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 1952	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 7
    //   286: goto -236 -> 50
    //   289: aload_1
    //   290: astore_0
    //   291: aload_1
    //   292: invokestatic 2525	aofd:b	(Ljava/io/InputStream;)I
    //   295: istore_2
    //   296: aload_1
    //   297: astore_0
    //   298: aload_1
    //   299: invokestatic 2525	aofd:b	(Ljava/io/InputStream;)I
    //   302: istore_3
    //   303: aload_1
    //   304: astore_0
    //   305: aload_1
    //   306: invokestatic 2525	aofd:b	(Ljava/io/InputStream;)I
    //   309: istore 4
    //   311: aload_1
    //   312: astore_0
    //   313: getstatic 1918	aoff:nu	Ljava/util/Map;
    //   316: new 1932	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 1934	java/lang/StringBuilder:<init>	()V
    //   323: iload_2
    //   324: invokevirtual 1948	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 2187
    //   330: invokevirtual 1940	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: iload_3
    //   334: invokevirtual 1948	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: invokevirtual 1952	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: iload 4
    //   342: sipush 1000
    //   345: iadd
    //   346: invokestatic 2258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: invokeinterface 2545 3 0
    //   354: pop
    //   355: goto -247 -> 108
    //   358: astore 7
    //   360: aload_0
    //   361: astore_1
    //   362: aload 7
    //   364: astore_0
    //   365: aload_1
    //   366: ifnull +7 -> 373
    //   369: aload_1
    //   370: invokevirtual 2532	java/io/BufferedInputStream:close	()V
    //   373: aload_0
    //   374: athrow
    //   375: aload_1
    //   376: ifnull -196 -> 180
    //   379: aload_1
    //   380: invokevirtual 2532	java/io/BufferedInputStream:close	()V
    //   383: goto -203 -> 180
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 2548	java/io/IOException:printStackTrace	()V
    //   391: goto -211 -> 180
    //   394: astore_0
    //   395: aload_0
    //   396: invokevirtual 2548	java/io/IOException:printStackTrace	()V
    //   399: goto -219 -> 180
    //   402: astore_1
    //   403: aload_1
    //   404: invokevirtual 2548	java/io/IOException:printStackTrace	()V
    //   407: goto -34 -> 373
    //   410: astore_0
    //   411: aconst_null
    //   412: astore_1
    //   413: goto -48 -> 365
    //   416: astore 7
    //   418: aconst_null
    //   419: astore_1
    //   420: goto -262 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramFile1	File
    //   0	423	1	paramFile2	File
    //   114	210	2	i	int
    //   138	196	3	j	int
    //   309	37	4	k	int
    //   28	182	5	l	long
    //   48	5	7	str1	String
    //   156	12	7	localIOException1	java.io.IOException
    //   284	1	7	str2	String
    //   358	5	7	localObject	Object
    //   416	1	7	localIOException2	java.io.IOException
    //   33	235	8	localBaseApplication	BaseApplication
    // Exception table:
    //   from	to	target	type
    //   110	115	156	java/io/IOException
    //   127	132	156	java/io/IOException
    //   134	139	156	java/io/IOException
    //   141	153	156	java/io/IOException
    //   291	296	156	java/io/IOException
    //   298	303	156	java/io/IOException
    //   305	311	156	java/io/IOException
    //   313	355	156	java/io/IOException
    //   110	115	358	finally
    //   127	132	358	finally
    //   134	139	358	finally
    //   141	153	358	finally
    //   160	172	358	finally
    //   291	296	358	finally
    //   298	303	358	finally
    //   305	311	358	finally
    //   313	355	358	finally
    //   379	383	386	java/io/IOException
    //   176	180	394	java/io/IOException
    //   369	373	402	java/io/IOException
    //   92	108	410	finally
    //   92	108	416	java/io/IOException
  }
  
  public static int jw(int paramInt)
  {
    int m = 0;
    int j = -1;
    int k = 1;
    if ((paramInt > 8251) && (paramInt < 13056)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramInt > 126979) && (paramInt < 129473)) {
        if (paramInt > 127461)
        {
          i = m;
          if (paramInt < 127488) {}
        }
        else
        {
          if ((paramInt <= 41) || (paramInt >= 64)) {
            break label107;
          }
          i = m;
        }
      }
      for (;;)
      {
        if ((i == 0) && (paramInt > 65) && (paramInt < 175)) {
          i = k;
        }
        for (;;)
        {
          if (i != 0) {
            j = ah.get(paramInt, -1);
          }
          return j;
          label107:
          i = 1;
          break;
        }
      }
    }
  }
  
  public static boolean lM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoff
 * JD-Core Version:    0.7.0.1
 */