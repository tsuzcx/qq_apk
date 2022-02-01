import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.qun.group_activity.group_activity.GroupAct;

public class accd
  implements acci
{
  private final String TAG = "BizTroopObserver";
  
  protected void J(boolean paramBoolean, List<group_activity.GroupAct> paramList) {}
  
  protected void W(boolean paramBoolean, Object paramObject) {}
  
  protected void X(boolean paramBoolean, Object paramObject) {}
  
  protected void Y(boolean paramBoolean, Object paramObject) {}
  
  protected void Z(boolean paramBoolean, Object paramObject) {}
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString) {}
  
  protected void a(apsw.b paramb) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List<group_activity_info.GroupActInfo> paramList) {}
  
  protected void aK(Object paramObject) {}
  
  protected void aU(Object paramObject) {}
  
  protected void aa(boolean paramBoolean, Object paramObject) {}
  
  protected void ab(boolean paramBoolean, Object paramObject) {}
  
  protected void ac(boolean paramBoolean, Object paramObject) {}
  
  protected void ad(boolean paramBoolean, Object paramObject) {}
  
  protected void ae(boolean paramBoolean, Object paramObject) {}
  
  protected void ar(Object paramObject) {}
  
  protected void az(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<aprd.a> paramArrayList, int paramInt4) {}
  
  protected void bd(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {}
  
  protected void c(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void e(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void m(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void n(boolean paramBoolean, Object paramObject) {}
  
  protected void o(boolean paramBoolean, Object paramObject) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof Object[])) {}
    for (Object localObject = (Object[])paramObject;; localObject = null)
    {
      switch (paramInt)
      {
      case 3: 
      case 4: 
      case 5: 
      case 7: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 19: 
      case 23: 
      case 25: 
      case 26: 
      case 34: 
      case 35: 
      case 37: 
      default: 
      case 2: 
      case 9: 
      case 6: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 20: 
      case 18: 
        do
        {
          do
          {
            do
            {
              return;
              W(paramBoolean, paramObject);
              return;
              ar(paramObject);
              return;
            } while (localObject == null);
            if (paramBoolean)
            {
              a(paramBoolean, (String)localObject[0], ((Boolean)localObject[1]).booleanValue(), (List)localObject[2]);
              return;
            }
            a(paramBoolean, (String)localObject[0], ((Boolean)localObject[1]).booleanValue(), null);
            return;
            X(paramBoolean, paramObject);
            return;
            Y(paramBoolean, paramObject);
            return;
            J(paramBoolean, (List)paramObject);
            return;
          } while (localObject == null);
          if (paramBoolean)
          {
            b(true, ((Integer)localObject[0]).intValue(), ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue(), (ArrayList)localObject[3], 0);
            return;
          }
          b(false, ((Integer)localObject[2]).intValue(), 0, 0, null, ((Integer)localObject[4]).intValue());
          return;
          aK(paramObject);
          return;
          aU(paramObject);
          return;
        } while (localObject == null);
        if ((localObject.length != 5) || (localObject[4] == null)) {
          break;
        }
      }
      for (paramObject = (String)localObject[4];; paramObject = null)
      {
        c((String)localObject[0], ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue(), (String)localObject[3], paramObject);
        return;
        if ((localObject == null) || (localObject.length <= 0))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BizTroopObserver", 2, "onUpdate(), case BizTroopHandler.TYPE_SET_COMMONLY_USED_TROOP_LIST, array is null or empty ...");
          return;
        }
        if ((localObject[0] instanceof Integer))
        {
          paramInt = ((Integer)localObject[0]).intValue();
          if ((localObject[1] instanceof Integer)) {
            i = ((Integer)localObject[1]).intValue();
          }
          if (!(localObject[2] instanceof Map)) {
            break label592;
          }
          paramObject = (Map)localObject[2];
          label557:
          if (!(localObject[3] instanceof String)) {
            break label597;
          }
        }
        label592:
        label597:
        for (localObject = (String)localObject[3];; localObject = null)
        {
          a(paramInt, i, paramObject, (String)localObject);
          return;
          paramInt = -1;
          break;
          paramObject = null;
          break label557;
        }
        Z(paramBoolean, paramObject);
        return;
        aa(paramBoolean, paramObject);
        return;
        if ((localObject == null) || (localObject.length == 0))
        {
          e(false, -1L, "");
          return;
        }
        e(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1]);
        return;
        ad(paramBoolean, paramObject);
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
        }
        a((apsw.b)paramObject);
        return;
        az(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
        ae(paramBoolean, paramObject);
        return;
        if (localObject == null) {
          break;
        }
        c(paramBoolean, ((Long)localObject[0]).longValue(), ((Long)localObject[1]).longValue());
        return;
        if (localObject == null) {
          break;
        }
        m(paramBoolean, ((Integer)localObject[1]).intValue(), ((Integer)localObject[2]).intValue());
        return;
        if (localObject == null) {
          break;
        }
        bd(paramBoolean, ((Boolean)localObject[1]).booleanValue());
        return;
        n(paramBoolean, paramObject);
        return;
        o(paramBoolean, paramObject);
        return;
        if ((paramBoolean) && (localObject != null))
        {
          b(((Long)localObject[0]).longValue(), ((Long)localObject[1]).longValue(), ((Long)localObject[2]).longValue(), (String)localObject[3]);
          return;
        }
        b(-1L, -1L, -1L, "");
        return;
        ab(paramBoolean, paramObject);
        return;
        ac(paramBoolean, paramObject);
        return;
        if ((localObject != null) && (localObject.length >= 1)) {}
        for (paramInt = ((Integer)localObject[0]).intValue(); (paramBoolean) && (localObject != null) && (localObject.length >= 4); paramInt = 2131698365)
        {
          a(paramBoolean, paramInt, (String)localObject[1], (String)localObject[2], (Boolean)localObject[3]);
          return;
        }
        a(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
        return;
        if (localObject == null) {
          break;
        }
        if (localObject.length >= 4) {}
        for (paramInt = ((Integer)localObject[3]).intValue();; paramInt = 0)
        {
          a(paramBoolean, (String)localObject[0], (String)localObject[1], (String)localObject[2], paramInt);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accd
 * JD-Core Version:    0.7.0.1
 */