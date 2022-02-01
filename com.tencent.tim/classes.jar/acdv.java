import QQService.RespAddDiscussMember;
import QQService.RespGetDiscussInfo;
import android.util.Pair;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class acdv
  implements acci
{
  private void a(boolean paramBoolean, FlyTicket.DiscussSigDecodeResponse paramDiscussSigDecodeResponse)
  {
    if ((paramDiscussSigDecodeResponse != null) && (((FlyTicket.RetInfo)paramDiscussSigDecodeResponse.ret_info.get()).ret_code.get() == 0))
    {
      W(paramBoolean, paramDiscussSigDecodeResponse.sig.get());
      return;
    }
    W(false, null);
  }
  
  private void af(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = false;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      String str = (String)paramObject[0];
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      int i = ((Integer)paramObject[2]).intValue();
      int j = ((Integer)paramObject[3]).intValue();
      if (paramObject.length >= 5) {
        bool1 = ((Boolean)paramObject[4]).booleanValue();
      }
      a(paramBoolean, str, bool2, i, j, bool1);
    }
  }
  
  private void f(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = Integer.parseInt((String)paramArrayOfObject[0]);
    FlyTicket.DiscussGetUrlResponse localDiscussGetUrlResponse = (FlyTicket.DiscussGetUrlResponse)paramArrayOfObject[1];
    long l = ((Long)paramArrayOfObject[2]).longValue();
    if ((localDiscussGetUrlResponse != null) && (i == 0))
    {
      String str = localDiscussGetUrlResponse.url.get();
      paramArrayOfObject = str;
      if (str != null)
      {
        paramArrayOfObject = str;
        if (!localDiscussGetUrlResponse.url.get().endsWith("#flyticket"))
        {
          paramArrayOfObject = str;
          if (!str.endsWith(localDiscussGetUrlResponse.sig.get())) {
            paramArrayOfObject = str + localDiscussGetUrlResponse.sig.get();
          }
        }
      }
      str = "";
      if (localDiscussGetUrlResponse.short_url.get() != null) {
        str = localDiscussGetUrlResponse.short_url.get();
      }
      a(paramBoolean, i, localDiscussGetUrlResponse.v_time.get(), paramArrayOfObject, str, l);
      return;
    }
    a(false, i, 0L, null, "", l);
  }
  
  private void g(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      i = ((Integer)paramArrayOfObject[2]).intValue();
      if (paramArrayOfObject[0] != null) {
        break label44;
      }
    }
    label44:
    for (long l = 0L;; l = ((Long)paramArrayOfObject[0]).longValue())
    {
      a(paramBoolean, i, l, (String)paramArrayOfObject[1]);
      return;
    }
  }
  
  private void h(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (!(paramArrayOfObject[1] instanceof Integer)) {
      return;
    }
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    if (paramBoolean)
    {
      paramArrayOfObject = (RespAddDiscussMember)paramArrayOfObject[2];
      Map localMap = paramArrayOfObject.AddResult;
      Object localObject = localMap.keySet();
      ArrayList localArrayList = new ArrayList();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (((Integer)localMap.get(localLong)).intValue() == 0) {
          localArrayList.add(String.valueOf(localLong));
        }
      }
      b(true, i, paramArrayOfObject.DiscussUin, localArrayList);
      return;
    }
    b(false, i, Long.valueOf((String)paramArrayOfObject[0]).longValue(), null);
  }
  
  protected void AW(boolean paramBoolean) {}
  
  protected void B(boolean paramBoolean, long paramLong) {}
  
  protected void N(boolean paramBoolean, String paramString) {}
  
  protected void V(boolean paramBoolean, String paramString) {}
  
  protected void W(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2) {}
  
  protected void a(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void a(boolean paramBoolean, Long paramLong) {}
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList) {}
  
  protected void b(boolean paramBoolean, Long paramLong) {}
  
  protected void bMN() {}
  
  protected void cmq() {}
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Discussion", 2, "Discussion DiscussObserver onUpdate type" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      AW(paramBoolean);
      return;
    case 1001: 
      p(paramBoolean, paramObject);
      return;
    case 1003: 
      h(paramBoolean, (Object[])paramObject);
      return;
    case 1005: 
      N(paramBoolean, (String)paramObject);
      return;
    case 1002: 
      g(paramBoolean, (Object[])paramObject);
      return;
    case 1004: 
      ivv.jL("deleteDiscuss_onQuitDiscussion");
      V(paramBoolean, (String)paramObject);
      return;
    case 1007: 
      paramObject = (Pair)paramObject;
      d(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
      return;
    case 2000: 
      w((Object[])paramObject);
      return;
    case 1008: 
      bMN();
      return;
    case 1009: 
      cmq();
      return;
    case 1010: 
      B(paramBoolean, ((Long)paramObject).longValue());
      return;
    case 1011: 
      f(paramBoolean, (Object[])paramObject);
      return;
    case 1012: 
      a(paramBoolean, (FlyTicket.DiscussSigDecodeResponse)paramObject);
      return;
    case 1013: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, Integer.parseInt((String)paramObject[0]), (RespGetDiscussInfo)paramObject[1]);
      return;
    case 1014: 
      paramObject = (Long[])paramObject;
      a(paramBoolean, paramObject[1].longValue(), paramObject[0].intValue());
      return;
    case 1015: 
      paramObject = (long[])paramObject;
      a(paramBoolean, Long.valueOf(paramObject[0]), Long.valueOf(paramObject[1]));
      return;
    case 1016: 
      a(paramBoolean, (Long)paramObject);
      return;
    case 1017: 
      b(paramBoolean, (Long)paramObject);
      return;
    }
    af(paramBoolean, paramObject);
  }
  
  protected void p(boolean paramBoolean, Object paramObject) {}
  
  protected void w(Object[] paramArrayOfObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acdv
 * JD-Core Version:    0.7.0.1
 */