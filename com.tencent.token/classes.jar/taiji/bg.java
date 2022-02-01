package taiji;

import Protocol.MMGRAuth.AuthSolutionConfig;
import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.qqpimsecure.taiji.g;
import java.util.ArrayList;
import java.util.Iterator;

public class bg
{
  private static final SparseIntArray a = new SparseIntArray();
  private static final SparseIntArray b = new SparseIntArray();
  private static final SparseArray<int[]> c = new SparseArray();
  private static final ArrayList<String> d = new ArrayList();
  
  static
  {
    a.put(1, 30011);
    a.put(2, 30010);
    a.put(3, 30004);
    a.put(4, 30017);
    a.put(5, 30009);
    a.put(6, 30007);
    a.put(7, 0);
    a.put(8, 30002);
    a.put(9, 30011);
    a.put(10, 30011);
    a.put(11, 30011);
    a.put(12, 30011);
    a.put(13, 30011);
    a.put(14, 30012);
    a.put(15, 30012);
    a.put(16, 30012);
    a.put(17, 30012);
    a.put(18, 30012);
    a.put(19, 30012);
    a.put(20, 30012);
    a.put(21, 30013);
    a.put(22, 30013);
    a.put(23, 30013);
    a.put(24, 30014);
    a.put(25, 30003);
    a.put(26, 0);
    a.put(27, 30015);
    a.put(28, 30015);
    a.put(29, 30016);
    a.put(30, 30019);
    a.put(31, 30029);
    a.put(32, 0);
    a.put(33, 0);
    a.put(34, 0);
    a.put(35, 0);
    a.put(36, 30018);
    a.put(38, 30020);
    a.put(39, 30021);
    a.put(40, 30022);
    a.put(41, 30023);
    a.put(42, 30024);
    a.put(43, 30025);
    a.put(44, 30026);
    a.put(45, 30007);
    a.put(46, 30028);
    a.put(47, 30030);
    a.put(48, 30031);
    a.put(49, 30027);
    b.put(1, 30111);
    b.put(2, 30110);
    b.put(3, 30104);
    b.put(4, 30117);
    b.put(5, 30109);
    b.put(6, 30107);
    b.put(7, 30111);
    b.put(8, 30102);
    b.put(9, 30111);
    b.put(10, 30111);
    b.put(11, 30111);
    b.put(12, 30111);
    b.put(13, 30111);
    b.put(14, 30112);
    b.put(15, 30112);
    b.put(16, 30112);
    b.put(17, 30112);
    b.put(18, 30112);
    b.put(19, 30112);
    b.put(20, 30112);
    b.put(21, 30113);
    b.put(22, 30113);
    b.put(23, 30113);
    b.put(24, 30114);
    b.put(25, 30103);
    b.put(26, 30111);
    b.put(27, 30115);
    b.put(28, 30115);
    b.put(29, 30116);
    b.put(30, 30119);
    b.put(31, 30129);
    b.put(32, 30111);
    b.put(33, 30111);
    b.put(34, 30111);
    b.put(35, 30111);
    b.put(36, 30118);
    b.put(38, 30120);
    b.put(39, 30121);
    b.put(40, 30122);
    b.put(41, 30123);
    b.put(42, 30124);
    b.put(43, 30125);
    b.put(44, 30126);
    b.put(45, 30107);
    b.put(46, 30128);
    b.put(47, 30130);
    b.put(48, 30131);
    b.put(49, 30127);
    c.put(30002, new int[] { 8 });
    c.put(30003, new int[] { 25 });
    c.put(30004, new int[] { 3 });
    c.put(30007, new int[] { 6 });
    c.put(30009, new int[] { 5 });
    c.put(30010, new int[] { 2 });
    c.put(30011, new int[] { 1, 9, 10, 11, 12, 13 });
    c.put(30012, new int[] { 14, 15, 16, 17, 18, 19, 20 });
    c.put(30013, new int[] { 21, 22, 23 });
    c.put(30014, new int[] { 24 });
    c.put(30015, new int[] { 27, 28 });
    c.put(30016, new int[] { 29 });
    c.put(30017, new int[] { 4 });
    c.put(30018, new int[] { 36 });
    c.put(30019, new int[] { 30 });
    c.put(30020, new int[] { 38 });
    c.put(30021, new int[] { 39 });
    c.put(30022, new int[] { 40 });
    c.put(30023, new int[] { 41 });
    c.put(30024, new int[] { 42 });
    c.put(30025, new int[] { 43 });
    c.put(30026, new int[] { 44 });
    c.put(30007, new int[] { 45 });
    c.put(30028, new int[] { 46 });
    c.put(30030, new int[] { 47 });
    c.put(30031, new int[] { 48 });
    c.put(30027, new int[] { 49 });
    d.add("");
    d.add("读取手机状态");
    d.add("存储");
    d.add("");
    d.add("自启动");
    d.add("悬浮窗");
    d.add("");
    d.add("读取已安装应用列表");
    d.add("");
    d.add("监听通话");
    d.add("拨打电话");
    d.add("读通话记录");
    d.add("写通话记录");
    d.add("删除通话记录");
    d.add("读短信");
    d.add("写短信");
    d.add("发送短信");
    d.add("通知类短信");
    d.add("读彩信");
    d.add("写彩信");
    d.add("发送彩信");
    d.add("读联系人/通讯录");
    d.add("写联系人/通讯录");
    d.add("删除联系人/通讯录");
    d.add("位置/定位");
    d.add("");
    d.add("创建桌面快捷方式");
    d.add("读日历");
    d.add("写日历");
    d.add("相机/摄像头");
    d.add("录音");
    d.add("修改系统设置");
    d.add("获取帐号");
    d.add("移动网络");
    d.add("WIFI/WLAN");
    d.add("蓝牙");
    d.add("");
    d.add("");
    d.add("");
    d.add("");
    d.add("关联启动");
    d.add("");
    d.add("锁屏显示");
    d.add("");
    d.add("");
    d.add("");
    d.add("");
    d.add("");
    d.add("后台弹出界面");
    d.add("GPS开关");
  }
  
  public static int a(int paramInt)
  {
    return a.get(paramInt);
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = g.a(paramContext).a(10001);
    if ((paramContext != null) && (paramContext.soluInfo != null))
    {
      paramContext = (AuthSolutionConfig)bj.a(paramContext.soluInfo, new AuthSolutionConfig(), false);
      if ((paramContext != null) && (paramContext.authSolutionConfigList != null) && (!paramContext.authSolutionConfigList.isEmpty())) {
        return !((String)paramContext.authSolutionConfigList.get(0)).equals("1");
      }
    }
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    paramContext = g.a(paramContext).a(20002);
    if ((paramContext != null) && (paramContext.soluInfo != null))
    {
      paramContext = (AuthSolutionConfig)bj.a(paramContext.soluInfo, new AuthSolutionConfig(), false);
      if ((paramContext != null) && (paramContext.authSolutionConfigList != null) && (!paramContext.authSolutionConfigList.isEmpty()))
      {
        paramContext = paramContext.authSolutionConfigList.iterator();
        while (paramContext.hasNext()) {
          if (((String)paramContext.next()).equals(String.valueOf(paramInt))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    return b.get(paramInt);
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    paramContext = g.a(paramContext).a(30201);
    if ((paramContext != null) && (paramContext.soluInfo != null))
    {
      paramContext = (AuthSolutionConfig)bj.a(paramContext.soluInfo, new AuthSolutionConfig(), false);
      if ((paramContext != null) && (paramContext.authSolutionConfigList != null) && (!paramContext.authSolutionConfigList.isEmpty()) && (paramInt < paramContext.authSolutionConfigList.size())) {
        return (String)paramContext.authSolutionConfigList.get(paramInt);
      }
    }
    if ((paramInt >= 0) && (paramInt < d.size())) {
      return (String)d.get(paramInt);
    }
    return "";
  }
  
  public static int[] c(int paramInt)
  {
    return (int[])c.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bg
 * JD-Core Version:    0.7.0.1
 */