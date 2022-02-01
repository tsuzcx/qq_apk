import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupVisitorInfo;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class acgf
  implements acci
{
  protected void Jg(int paramInt) {}
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1) {}
  
  protected void a(boolean paramBoolean, int paramInt, List<cmd0x897.GroupVisitorInfo> paramList, Long paramLong) {}
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ArrayList<String> paramArrayList) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList) {}
  
  public void a(boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2) {}
  
  protected void a(boolean paramBoolean, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void e(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void f(String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void g(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void i(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = false;
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
                        do
                        {
                          return;
                          if (paramBoolean) {}
                          for (paramInt = 0;; paramInt = -1)
                          {
                            Jg(paramInt);
                            return;
                          }
                          if (paramObject == null)
                          {
                            a(null, null, paramBoolean, null, null, null);
                            return;
                          }
                          paramObject = (Object[])paramObject;
                          if (paramBoolean)
                          {
                            a((String)paramObject[2], (String)paramObject[1], paramBoolean, (String)paramObject[0], (String)paramObject[3], (Boolean)paramObject[4]);
                            return;
                          }
                          a("", (String)paramObject[0], paramBoolean, (String)paramObject[1], (String)paramObject[2], null);
                          return;
                        } while (!(paramObject instanceof Object[]));
                        paramObject = (Object[])paramObject;
                        f((String)paramObject[0], paramBoolean, (String)paramObject[1]);
                        return;
                      } while (!(paramObject instanceof Object[]));
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (HotChatInfo)paramObject[0], (Common.WifiPOIInfo)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (byte[])paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (String)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4], (List)paramObject[5]);
                      return;
                      paramObject = (Object[])paramObject;
                      List localList = (List)paramObject[4];
                      ArrayList localArrayList = new ArrayList();
                      paramInt = 0;
                      while (paramInt < localList.size())
                      {
                        localArrayList.add(localList.get(paramInt) + "");
                        paramInt += 1;
                      }
                      a(paramBoolean, (String)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), localArrayList);
                      return;
                      paramObject = (Object[])paramObject;
                      r(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
                      return;
                      paramObject = (Object[])paramObject;
                      b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
                      return;
                      paramObject = (Object[])paramObject;
                      i(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
                      return;
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (Long)paramObject[3]);
                      return;
                      paramObject = (Object[])paramObject;
                      e(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
                      return;
                      paramObject = (Object[])paramObject;
                      a((String)paramObject[0], (HotChatManager.HotChatStateWrapper)paramObject[1]);
                      return;
                      paramObject = (Object[])paramObject;
                    } while (paramObject == null);
                    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1], (Long)paramObject[2]);
                    return;
                    paramObject = (Object[])paramObject;
                  } while (paramObject == null);
                  if (paramObject.length > 2) {
                    bool = ((Boolean)paramObject[2]).booleanValue();
                  }
                } while (!bool);
                if (paramObject.length > 3)
                {
                  a(paramBoolean, (oidb_0x88d.GroupInfo)paramObject[3]);
                  return;
                }
                a(paramBoolean, null);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3]);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            g(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
            return;
          } while (!(paramObject instanceof Object[]));
          paramObject = (Object[])paramObject;
          x(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
        f((String)paramObject[0], paramBoolean, (String)paramObject[1]);
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
      y(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
      return;
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    a(paramBoolean, (ArrayList)paramObject[0], (ArrayList)paramObject[1]);
  }
  
  public void r(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void x(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void y(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgf
 * JD-Core Version:    0.7.0.1
 */