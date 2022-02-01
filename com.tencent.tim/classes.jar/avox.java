import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class avox
{
  public static final List<String> LG = new ArrayList(Arrays.asList(new String[] { "4", "5", "7" }));
  public static final List<String> LH = new ArrayList(Arrays.asList(new String[] { "1", "4", "5", "7" }));
  public static final List<String> LI = new ArrayList(Arrays.asList(new String[] { "2", "3", "6", "", null }));
  public static final List<String> LJ = new ArrayList(Arrays.asList(new String[] { "2", "3", "", null }));
  public static final List<String> LK = new ArrayList(Arrays.asList(new String[] { "2", "3" }));
  public static final List<String> LL = new ArrayList(Arrays.asList(new String[] { "6" }));
  
  public static void a(Bundle paramBundle, avox.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    for (Object localObject = parama.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      localArrayList.addAll(Arrays.asList(((Class)localObject).getDeclaredFields()));
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject = (Field)localArrayList.get(i);
      String str1 = ((Field)localObject).getName();
      String str2 = ((Field)localObject).getType().getSimpleName();
      QLog.i("HbInfo", 2, "key = " + str1 + " tname = " + str2);
      String str3 = paramBundle.getString(str1);
      if (str3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          QLog.i("HbInfo", 2, "set " + str1 + " = " + str3);
          if (str2.equals("String")) {
            ((Field)localObject).set(parama, str3);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static class a
  {
    public String biz_params;
    public String bus_type;
    public String people_num;
    public String pick_entry;
    public String recv_type;
    
    public String toString()
    {
      return new StringBuilder().append("people_num: ").append(this.people_num).toString() + new StringBuilder().append("recv_type: ").append(this.recv_type).toString() + new StringBuilder().append("bus_type: ").append(this.bus_type).toString() + new StringBuilder().append("pick_entry: ").append(this.pick_entry).toString() + new StringBuilder().append("biz_params: ").append(this.biz_params).toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avox
 * JD-Core Version:    0.7.0.1
 */