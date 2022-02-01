import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aoee
  implements acci
{
  public static String TAG = "GroupTeamWorkObserver";
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List<GPadInfo> paramList) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean1, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "GroupTeamWorkObserver type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (paramObject == null);
                      paramObject = (Object[])paramObject;
                    } while (paramObject.length != 5);
                    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (List)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
                    return;
                  } while (paramObject == null);
                  paramObject = (Object[])paramObject;
                } while (paramObject.length != 3);
                a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (List)paramObject[2]);
                return;
              } while (paramObject == null);
              paramObject = (Object[])paramObject;
            } while (paramObject.length != 5);
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (List)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
            return;
          } while (paramObject == null);
          paramObject = (Object[])paramObject;
        } while (paramObject.length != 2);
        u(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 3);
    v(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
  }
  
  public void u(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void v(boolean paramBoolean, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoee
 * JD-Core Version:    0.7.0.1
 */