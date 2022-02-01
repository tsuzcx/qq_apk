import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class acje
  implements acci
{
  public void AB(boolean paramBoolean) {}
  
  public void DH(int paramInt) {}
  
  public void I(boolean paramBoolean, int paramInt) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void a(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp) {}
  
  public void a(boolean paramBoolean, jzs.a parama) {}
  
  public void aH(int paramInt, boolean paramBoolean) {}
  
  public void aL(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void aZ(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo) {}
  
  public void cfI() {}
  
  public void f(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void h(boolean paramBoolean, ArrayList<Long> paramArrayList) {}
  
  public void m(boolean paramBoolean, String paramString) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (100 == paramInt)
    {
      paramObject = (acje.b)paramObject;
      aH(paramObject.mErrCode, paramObject.fV);
    }
    do
    {
      return;
      if (101 == paramInt)
      {
        if ((paramObject instanceof acje.a))
        {
          paramObject = (acje.a)paramObject;
          b(paramObject.mErrCode, paramObject.a);
          return;
        }
        if ((paramObject instanceof Integer))
        {
          aZ(paramBoolean, ((Integer)paramObject).intValue());
          return;
        }
        m(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (102 == paramInt)
      {
        if ((paramObject instanceof acje.a))
        {
          paramObject = (acje.a)paramObject;
          a(paramObject.mErrCode, paramObject.a);
          return;
        }
        v(paramBoolean, String.valueOf(paramObject));
        return;
      }
      if (103 == paramInt)
      {
        cfI();
        return;
      }
      if (104 == paramInt)
      {
        AB(paramBoolean);
        return;
      }
      if (105 == paramInt)
      {
        DH(((Integer)paramObject).intValue());
        return;
      }
      if (106 == paramInt)
      {
        aL(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      if (109 == paramInt)
      {
        a(paramBoolean, (jzs.a)paramObject);
        return;
      }
      if (108 == paramInt)
      {
        paramObject = (HashMap)paramObject;
        a(paramBoolean, ((Integer)paramObject.get("seq")).intValue(), ((Long)paramObject.get("uin")).longValue());
        return;
      }
      if (110 == paramInt)
      {
        h(paramBoolean, (ArrayList)paramObject);
        return;
      }
      if (111 == paramInt)
      {
        paramObject = (HashMap)paramObject;
        long l = 0L;
        paramInt = 0;
        if (paramObject != null)
        {
          l = ((Long)paramObject.get("uin")).longValue();
          paramInt = ((Integer)paramObject.get("status")).intValue();
        }
        f(paramBoolean, l, paramInt);
        return;
      }
    } while ((112 != paramInt) || (!(paramObject instanceof SetRecvMsgStateRsp)));
    a(paramBoolean, (SetRecvMsgStateRsp)paramObject);
  }
  
  public void v(boolean paramBoolean, String paramString) {}
  
  public static class a
  {
    public PublicAccountInfo a;
    public int mErrCode;
  }
  
  public static class b
  {
    public boolean fV;
    public int mErrCode;
    public List<PublicAccountInfo> mList;
    public long mTotalCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acje
 * JD-Core Version:    0.7.0.1
 */