import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

class abfl
  extends acdv
{
  abfl(abfd paramabfd) {}
  
  protected void N(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      gt(Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      gt(paramLong);
    }
  }
  
  public void gt(long paramLong)
  {
    if (paramLong == 0L) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
      } while (!this.this$0.jdField_do.containsKey(Long.valueOf(paramLong)));
      str1 = (String)this.this$0.jdField_do.get(Long.valueOf(paramLong));
      str2 = aqgv.u(this.this$0.mApp, String.valueOf(paramLong));
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        abfd.a(this.this$0, false);
      }
    } while (!QLog.isColorLevel());
    QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate [uin: %d, pre: %s, cur: %s]", new Object[] { Long.valueOf(paramLong), str1, str2 }));
  }
  
  protected void p(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      if (!(paramObject instanceof ArrayList)) {
        break label70;
      }
    }
    label70:
    for (paramObject = (ArrayList)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            gt(((Long)localObject).longValue());
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfl
 * JD-Core Version:    0.7.0.1
 */