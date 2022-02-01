import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.JumpActivity.a;
import com.tencent.mobileqq.activity.JumpActivity.c;
import com.tencent.mobileqq.activity.JumpActivity.d;
import com.tencent.mobileqq.activity.JumpActivity.e;
import com.tencent.mobileqq.activity.JumpActivity.f;
import com.tencent.mobileqq.activity.JumpActivity.g;
import com.tencent.mobileqq.activity.JumpActivity.i;
import com.tencent.mobileqq.activity.JumpActivity.j;
import com.tencent.mobileqq.activity.JumpActivity.k;
import com.tencent.mobileqq.activity.JumpActivity.l;
import com.tencent.mobileqq.activity.JumpActivity.m;
import com.tencent.mobileqq.activity.JumpActivity.n;
import com.tencent.mobileqq.activity.JumpActivity.o;
import com.tencent.mobileqq.activity.JumpActivity.p;
import com.tencent.mobileqq.activity.JumpActivity.q;
import com.tencent.mobileqq.activity.JumpActivity.r;
import com.tencent.mobileqq.activity.JumpActivity.s;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public class acgq
{
  private static volatile acgq a;
  private HashMap<Integer, Class> iO = new HashMap();
  
  private acgq()
  {
    this.iO.put(Integer.valueOf(800), JumpActivity.f.class);
    this.iO.put(Integer.valueOf(880), JumpActivity.f.class);
    this.iO.put(Integer.valueOf(18), JumpActivity.c.class);
    this.iO.put(Integer.valueOf(19), JumpActivity.g.class);
    this.iO.put(Integer.valueOf(20), JumpActivity.l.class);
    this.iO.put(Integer.valueOf(21), JumpActivity.n.class);
    this.iO.put(Integer.valueOf(22), JumpActivity.m.class);
    this.iO.put(Integer.valueOf(26), JumpActivity.k.class);
    this.iO.put(Integer.valueOf(27), JumpActivity.j.class);
    this.iO.put(Integer.valueOf(24), JumpActivity.d.class);
    this.iO.put(Integer.valueOf(1), JumpActivity.e.class);
    this.iO.put(Integer.valueOf(2), JumpActivity.i.class);
    this.iO.put(Integer.valueOf(571), JumpActivity.q.class);
    this.iO.put(Integer.valueOf(572), JumpActivity.p.class);
    this.iO.put(Integer.valueOf(25), JumpActivity.s.class);
    this.iO.put(Integer.valueOf(570), JumpActivity.o.class);
    this.iO.put(Integer.valueOf(573), JumpActivity.r.class);
  }
  
  public static acgq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acgq();
      }
      return a;
    }
    finally {}
  }
  
  public JumpActivity.a a(int paramInt, JumpActivity paramJumpActivity)
  {
    try
    {
      Class localClass = (Class)this.iO.get(Integer.valueOf(paramInt));
      if (localClass != null)
      {
        paramJumpActivity = localClass.getDeclaredConstructors()[0].newInstance(new Object[] { paramJumpActivity });
        if ((paramJumpActivity instanceof JumpActivity.a)) {
          return (JumpActivity.a)paramJumpActivity;
        }
        QLog.e("JumpActivityResultFactory", 1, "doCreateResultPlugin error: not extends BaseResultPlugin");
      }
      else
      {
        QLog.e("JumpActivityResultFactory", 1, "doCreateResultPlugin error: sResultPluginMap does not contain the key:" + paramInt);
      }
    }
    catch (Exception paramJumpActivity)
    {
      QLog.e("JumpActivityResultFactory", 1, "doCreateResultPlugin error: " + paramJumpActivity.getMessage());
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgq
 * JD-Core Version:    0.7.0.1
 */