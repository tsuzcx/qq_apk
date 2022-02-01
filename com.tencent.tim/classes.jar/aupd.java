import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.todo.data.TodoInfo;
import java.util.ArrayList;
import java.util.List;

public class aupd
  implements acci
{
  public static String TAG = "TodoObserver";
  
  public void Dq(boolean paramBoolean) {}
  
  public void VV(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, TodoInfo paramTodoInfo, int paramInt2) {}
  
  public void a(boolean paramBoolean, TodoInfo paramTodoInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, TodoInfo paramTodoInfo) {}
  
  public void aq(boolean paramBoolean, String paramString) {}
  
  public void bY(boolean paramBoolean, int paramInt) {}
  
  public void c(boolean paramBoolean, long paramLong, List<TodoInfo> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "TeamObserver type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if ((paramObject instanceof Object[]))
      {
        localObject2 = (Object[])paramObject;
        if (localObject2.length == 3) {
          if (!(localObject2[0] instanceof Integer)) {
            break label606;
          }
        }
      }
      break;
    }
    label410:
    label606:
    for (paramInt = ((Integer)localObject2[0]).intValue();; paramInt = 0)
    {
      if ((localObject2[1] instanceof String)) {}
      for (paramObject = (String)localObject2[1];; paramObject = null)
      {
        if ((localObject2[2] instanceof TodoInfo))
        {
          localObject1 = (TodoInfo)localObject2[2];
          j = 0;
          i = paramInt;
          paramInt = j;
        }
        for (;;)
        {
          a(paramBoolean, i, paramObject, (TodoInfo)localObject1, paramInt);
          return;
          if ((localObject2.length == 1) && ((localObject2[0] instanceof Integer)))
          {
            paramInt = ((Integer)localObject2[0]).intValue();
            paramObject = null;
            continue;
            Dq(paramBoolean);
            return;
            long l1;
            long l2;
            if ((paramObject instanceof Object[]))
            {
              localObject1 = (Object[])paramObject;
              if (localObject1.length == 2) {
                if ((localObject1[0] instanceof Long))
                {
                  l1 = ((Long)localObject1[0]).longValue();
                  l2 = l1;
                  paramObject = arrayOfObject;
                  if ((localObject1[1] instanceof List))
                  {
                    paramObject = (ArrayList)localObject1[1];
                    l2 = l1;
                  }
                }
              }
            }
            for (;;)
            {
              c(paramBoolean, l2, paramObject);
              return;
              if ((paramObject instanceof TodoInfo)) {}
              for (paramObject = (TodoInfo)paramObject;; paramObject = null)
              {
                a(paramBoolean, paramObject);
                return;
                if ((paramObject instanceof Object[]))
                {
                  arrayOfObject = (Object[])paramObject;
                  if (arrayOfObject.length == 3) {
                    if ((arrayOfObject[0] instanceof String))
                    {
                      paramObject = (String)arrayOfObject[0];
                      if ((arrayOfObject[1] instanceof Integer))
                      {
                        paramInt = ((Integer)arrayOfObject[1]).intValue();
                        localObject1 = paramObject;
                        i = paramInt;
                        if ((arrayOfObject[2] instanceof TodoInfo))
                        {
                          localObject2 = (TodoInfo)arrayOfObject[2];
                          i = paramInt;
                        }
                      }
                    }
                  }
                }
                for (localObject1 = paramObject;; localObject1 = null)
                {
                  a(paramBoolean, (String)localObject1, i, (TodoInfo)localObject2);
                  return;
                  if ((paramObject instanceof String)) {}
                  for (paramObject = (String)paramObject;; paramObject = null)
                  {
                    aq(paramBoolean, paramObject);
                    return;
                    VV(paramBoolean);
                    return;
                    paramInt = j;
                    if ((paramObject instanceof Object[]))
                    {
                      paramObject = (Object[])paramObject;
                      paramInt = j;
                      if (paramObject.length == 1)
                      {
                        paramInt = j;
                        if ((paramObject[0] instanceof Integer)) {
                          paramInt = ((Integer)paramObject[0]).intValue();
                        }
                      }
                    }
                    bY(paramBoolean, paramInt);
                    return;
                  }
                  paramInt = 1;
                  break label410;
                  paramObject = null;
                  break;
                  i = 1;
                }
              }
              l1 = -1L;
              break;
              l2 = -1L;
              paramObject = arrayOfObject;
            }
          }
          else
          {
            paramInt = 0;
            paramObject = null;
            continue;
            j = 0;
            i = paramInt;
            paramInt = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */