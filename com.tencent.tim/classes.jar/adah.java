import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class adah
  implements acci
{
  public static final String TAG = "AppletsObserver";
  
  protected void onAppletsSettingSwitchChange(int paramInt) {}
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList) {}
  
  protected void onGetAppletsPushUnreadInfo(Object paramObject) {}
  
  protected void onGetAppletsSettingSwitch(boolean paramBoolean, List<adao> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, "onGetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (aagv)((QQAppInterface)localObject1).getManager(315);; localObject1 = null)
    {
      if (localObject1 == null) {
        return;
      }
      HashSet localHashSet = new HashSet();
      if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject2 = (adao)paramList.next();
          if ((((adao)localObject2).items != null) && (((adao)localObject2).items.size() > 0) && (((adao)localObject2).items.get(0) != null) && (((AppletItem)((adao)localObject2).items.get(0)).getId() == 1L))
          {
            localObject2 = (AppletItem)((adao)localObject2).items.get(0);
            if (((AppletItem)localObject2).getValue() == 1) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((aagv)localObject1).Ci(paramBoolean);
              onAppletsSettingSwitchChange(((AppletItem)localObject2).getValue());
              break;
            }
          }
          if ((((adao)localObject2).items != null) && (((adao)localObject2).items.size() > 0))
          {
            localObject2 = ((adao)localObject2).items.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              AppletItem localAppletItem = (AppletItem)((Iterator)localObject2).next();
              if ((localAppletItem.getId() != 1L) && (localAppletItem.getValue() != 1)) {
                localHashSet.add(String.valueOf(localAppletItem.getId()));
              }
            }
          }
        }
      }
      ((aagv)localObject1).l(localHashSet);
      return;
    }
  }
  
  protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> paramMap) {}
  
  protected void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, "onSetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    aagv localaagv = null;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localaagv = (aagv)((QQAppInterface)localObject).getManager(315);
    }
    if (localaagv == null) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (paramBoolean))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (AppletItem)paramList.next();
          int i = ((AppletItem)localObject).getValue();
          if (((AppletItem)localObject).getId() == 1L)
          {
            if (i == 1) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              localaagv.Ci(paramBoolean);
              onAppletsSettingSwitchChange(i);
              break;
            }
          }
          if (localaagv != null) {
            if (i == 0) {
              localaagv.Ap(String.valueOf(((AppletItem)localObject).getId()));
            } else {
              localaagv.Aq(String.valueOf(((AppletItem)localObject).getId()));
            }
          }
        }
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      onGetAppletsDetail(paramBoolean, (List)paramObject);
      return;
    case 2: 
      onGetAppletsSettingSwitch(paramBoolean, (List)paramObject);
      return;
    case 3: 
      onSetAppletsSettingSwitch(paramBoolean, (List)paramObject);
      return;
    case 8: 
      onReceiveAppletsMessageUnreadInfo((Map)paramObject);
      return;
    }
    onGetAppletsPushUnreadInfo(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adah
 * JD-Core Version:    0.7.0.1
 */