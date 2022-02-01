import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ygn
{
  private static final SparseIntArray L = new SparseIntArray();
  
  static
  {
    L.put(2, 10);
    L.put(3, 20);
    L.put(4, 30);
  }
  
  private static <T extends ygk> boolean a(List<T> paramList, T paramT)
  {
    if ((paramList == null) || (paramT == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (ygk)paramList.next();
      if (((ygk)localObject2).wJ() != paramT.wJ())
      {
        Object localObject3;
        Object localObject1;
        String str;
        if ((((ygk)localObject2).wJ() == 2) && (paramT.wJ() == 4))
        {
          localObject2 = (yhd)localObject2;
          localObject3 = (yhb)paramT;
          localObject1 = ((yhb)localObject3).a.emoPath;
          localObject3 = ((yhb)localObject3).a.eId;
          str = ((yhd)localObject2).f.epId;
          localObject2 = ((yhd)localObject2).f.eId;
          if ((localObject1 != null) && (((String)localObject1).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject2))) {
            return true;
          }
        }
        else if ((((ygk)localObject2).wJ() == 4) && (paramT.wJ() == 2))
        {
          localObject1 = (yhd)paramT;
          localObject3 = (yhb)localObject2;
          localObject2 = ((yhb)localObject3).a.emoPath;
          localObject3 = ((yhb)localObject3).a.eId;
          str = ((yhd)localObject1).f.epId;
          localObject1 = ((yhd)localObject1).f.eId;
          if ((localObject2 != null) && (((String)localObject2).equals(str)) && (localObject3 != null) && (((String)localObject3).equals(localObject1))) {
            return true;
          }
        }
        else
        {
          if ((((ygk)localObject2).wJ() == 4) && (paramT.wJ() == 3) && (((yhb)localObject2).pz() != null) && (((yhb)localObject2).pz().equals(((ygu)paramT).pz()))) {
            return true;
          }
          if ((((ygk)localObject2).wJ() == 3) && (paramT.wJ() == 4) && (((yhb)paramT).pz() != null) && (((yhb)paramT).pz().equals(((ygu)localObject2).pz()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static <T extends ygk> List<T> b(QQAppInterface paramQQAppInterface, List<T> paramList)
  {
    paramQQAppInterface = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + paramList.size());
      }
      Collections.sort(paramList, new ygo());
      if (paramList.size() > 0) {
        paramQQAppInterface.add(paramList.remove(0));
      }
      if (paramList.size() > 0) {
        z(paramList, paramQQAppInterface);
      }
      if (paramList.size() > 0)
      {
        Collections.sort(paramList, new ygp());
        z(paramList, paramQQAppInterface);
      }
      if (QLog.isColorLevel()) {
        paramList = paramQQAppInterface.iterator();
      }
    }
    else
    {
      while (paramList.hasNext())
      {
        ygk localygk = (ygk)paramList.next();
        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + localygk.wI() + ",item.ExposeNum: " + localygk.wH());
        continue;
        return paramQQAppInterface;
      }
      QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + paramQQAppInterface.size());
    }
    return paramQQAppInterface;
  }
  
  private static <T extends ygk> void z(List<T> paramList1, List<T> paramList2)
  {
    if (paramList2 == null) {}
    ygk localygk;
    do
    {
      do
      {
        return;
      } while ((paramList1 == null) || (paramList1.isEmpty()));
      for (localygk = (ygk)paramList1.remove(0); (a(paramList2, localygk)) && (paramList1.size() > 0); localygk = (ygk)paramList1.remove(0)) {}
    } while (a(paramList2, localygk));
    paramList2.add(localygk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygn
 * JD-Core Version:    0.7.0.1
 */