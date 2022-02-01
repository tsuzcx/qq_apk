import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class aqii
  extends aqgp
{
  private static volatile aqii a;
  private List<Pair<String, String>> IO = new ArrayList();
  private boolean isInited;
  private SharedPreferences sp = BaseApplicationImpl.getApplication().getSharedPreferences("qq_safe_jump_whitelist", 0);
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    aTt = localBaseApplication.getFilesDir().getAbsoluteFile() + File.separator + "jumpConfig/";
    aTu = aTt + "qq_safe_jump_whitelist.xml";
  }
  
  public static aqii a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqii();
      }
      return a;
    }
    finally {}
  }
  
  private void io(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpFilterHelper", 2, "reportIllegalJump pkg=" + paramString1 + ";cmp=" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "JumpIllegal", true, 0L, 0L, localHashMap, null);
  }
  
  protected void B(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpFilterHelper", 2, "updateConfigVersion version=" + paramLong);
    }
    this.sp.edit().putLong("key_jump_whitelist_version", paramLong).commit();
  }
  
  protected int LS()
  {
    return 2131886101;
  }
  
  protected Object a(XmlPullParser paramXmlPullParser)
    throws Exception
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    for (int i = paramXmlPullParser.getEventType(); i != 1; i = paramXmlPullParser.next()) {
      if ((i == 2) && (paramXmlPullParser.getName().equalsIgnoreCase("Item")))
      {
        String str1 = paramXmlPullParser.getAttributeValue(null, "pkg");
        String str2 = paramXmlPullParser.getAttributeValue(null, "cmp");
        if ((str1 != null) && (str2 != null)) {
          localArrayList.add(new Pair(str1, str2));
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpFilterHelper", 2, "doParseRules pkg=" + str1 + ";cmp=" + str2);
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("JumpFilterHelper", 2, "doParseRules :  cost time:" + (l2 - l1) + "ms;size=" + localArrayList.size());
    }
    return localArrayList;
  }
  
  protected void bA(Object paramObject)
  {
    this.IO = ((List)paramObject);
    this.isInited = true;
  }
  
  public long eO()
  {
    long l = this.sp.getLong("key_jump_whitelist_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("JumpFilterHelper", 2, "getConfigVersion version=" + l);
    }
    return l;
  }
  
  public boolean q(Context paramContext, String paramString1, String paramString2)
  {
    Pair localPair = new Pair(paramString1, paramString2);
    if (!this.isInited) {}
    synchronized (a)
    {
      if (!this.isInited) {
        dj(paramContext);
      }
      if (!this.IO.contains(localPair))
      {
        io(paramString1, paramString2);
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpFilterHelper", 2, "isIllegalJump pkg=" + paramString1 + ";cmp=" + paramString2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqii
 * JD-Core Version:    0.7.0.1
 */