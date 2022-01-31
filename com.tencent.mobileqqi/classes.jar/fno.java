import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.os.Debug.MemoryInfo;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.debug.DebugActivity;
import com.tencent.mobileqq.debug.DebugMemoryMgr;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class fno
  implements Runnable
{
  public fno(DebugActivity paramDebugActivity) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (this.a.isFinishing()) {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject1 = new DecimalFormat();
        ((DecimalFormat)localObject1).applyPattern("0.0");
        l1 = DeviceInfoUtil.c() / 1024L / 1024L;
        long l2 = DeviceInfoUtil.d() / 1024L / 1024L;
        float f1 = ((android.app.ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0].getTotalPss() / 1024.0F;
        float f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
        localArrayList.add("内存概况:\n总共:" + l1 + "M,可用:" + l2 + "M\n使用:" + ((DecimalFormat)localObject1).format(f1) + "M,空闲:" + ((DecimalFormat)localObject1).format(f2) + "M");
        localArrayList.add("登录帐号:\n" + AppRuntime.showInfo());
        localArrayList.add("内存泄漏检测:\n" + DebugMemoryMgr.a());
        if (DebugMemoryMgr.a)
        {
          localObject3 = DebugMemoryMgr.a();
          localObject2 = new StringBuilder();
          localObject3 = Utils.a((ArrayList)localObject3);
          i = 0;
          if (i < ((ArrayList)localObject3).size())
          {
            localObject4 = (Pair)((ArrayList)localObject3).get(i);
            ((StringBuilder)localObject2).append("\n[").append((String)((Pair)localObject4).first).append(":").append(DebugActivity.a(this.a, (DecimalFormat)localObject1, ((Long)((Pair)localObject4).second).longValue())).append("]");
            i += 1;
            continue;
          }
          localArrayList.add("内存告警Activity:" + ((StringBuilder)localObject2).toString());
        }
        localObject3 = BaseApplicationImpl.a;
        i = ((MQLruCache)localObject3).size();
        int j = ((MQLruCache)localObject3).maxSize();
        f1 = i / 1024.0F / 1024.0F;
        f2 = j / 1024.0F / 1024.0F;
        j = ((MQLruCache)localObject3).hitCount();
        i = ((MQLruCache)localObject3).missCount();
        if (j + i <= 0) {
          break label1097;
        }
        i = j * 100 / (i + j);
        ((DecimalFormat)localObject1).applyPattern("0.0");
        localArrayList.add("图片缓存概况:\nsImageCache size:" + ((DecimalFormat)localObject1).format(f1) + "M, maxSize:" + ((DecimalFormat)localObject1).format(f2) + "M, hitRate:" + i + "%, hitCount:" + j);
        localObject2 = new ArrayList();
        if (((MQLruCache)localObject3).size() <= 0) {
          break label792;
        }
        localObject3 = ((MQLruCache)localObject3).snapshot().entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label683;
        }
        Object localObject5 = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = ((Map.Entry)localObject5).getValue();
        if (localObject4 == null) {
          continue;
        }
        localObject5 = ((String)((Map.Entry)localObject5).getKey()).trim();
        if ((localObject4 instanceof Pair))
        {
          l1 = ((Integer)((Pair)localObject4).second).intValue();
          ((ArrayList)localObject2).add(Pair.create(((String)localObject5).trim(), Long.valueOf(l1)));
          continue;
        }
        if (!(localObject4 instanceof Bitmap)) {
          break label1091;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject4 = (Bitmap)localObject4;
      long l1 = ((Bitmap)localObject4).getRowBytes() * ((Bitmap)localObject4).getHeight();
      continue;
      label683:
      if (((ArrayList)localObject2).size() > 0)
      {
        localException.add("图片缓存详细: ");
        localObject2 = Utils.a((ArrayList)localObject2);
        i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          localObject3 = (Pair)((ArrayList)localObject2).get(i);
          localException.add(DebugActivity.a(this.a, (DecimalFormat)localObject1, ((Long)((Pair)localObject3).second).longValue()) + ": " + (String)((Pair)localObject3).first);
          i += 1;
        }
      }
      label792:
      Object localObject2 = BitmapManager.a();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localException.add("其他图片详细: ");
        localObject2 = Utils.a((ArrayList)localObject2);
        i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          localObject3 = (Pair)((ArrayList)localObject2).get(i);
          localException.add(DebugActivity.a(this.a, (DecimalFormat)localObject1, ((Long)((Pair)localObject3).second).longValue()) + ": " + (String)((Pair)localObject3).first);
          i += 1;
        }
      }
      if (DebugActivity.a(this.a) == null) {
        DebugActivity.a(this.a, new AlertDialog.Builder(this.a));
      }
      if (DebugActivity.a(this.a) != null) {
        DebugActivity.a(this.a).dismiss();
      }
      DebugActivity.a(this.a, DebugActivity.a(this.a).setTitle("内存信息").setItems((CharSequence[])localException.toArray(new String[0]), new fnp(this.a, null)).create());
      DebugActivity.a(this.a).show();
      if (!QLog.isColorLevel()) {
        break;
      }
      Object localObject1 = new StringBuilder("MemoryInfo: \n");
      int i = 0;
      while (i < localException.size())
      {
        ((StringBuilder)localObject1).append((String)localException.get(i)).append("\n");
        i += 1;
      }
      QLog.i("DumpMemInfoHandler", 2, ((StringBuilder)localObject1).toString());
      return;
      label1091:
      l1 = 0L;
      continue;
      label1097:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fno
 * JD-Core Version:    0.7.0.1
 */