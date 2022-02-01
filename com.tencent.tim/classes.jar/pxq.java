import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.handler.GetUserIconHandler.1;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqIconPostfix;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class pxq
{
  public static boolean aCB;
  private static Set<String> aI = new HashSet();
  private static final ArrayList<String> mO = new ArrayList();
  
  public static void V(String paramString)
  {
    synchronized (mO)
    {
      if (!aI.contains(paramString))
      {
        mO.add(paramString);
        aI.add(paramString);
      }
      if (!aCB)
      {
        aCB = true;
        ThreadManager.post(new GetUserIconHandler.1(), 5, null, true);
      }
      return;
    }
  }
  
  public static void ck(ArrayList<String> paramArrayList)
  {
    paramArrayList = new pxq.a(paramArrayList);
    pxq.b localb = new pxq.b();
    pri.a().a(paramArrayList, localb);
  }
  
  public static class a
    extends prk
  {
    private ArrayList<String> mP;
    
    public a(ArrayList<String> paramArrayList)
    {
      this.mP = paramArrayList;
    }
    
    public prl a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspIconPostfix localRspIconPostfix = new qqstory_service.RspIconPostfix();
      try
      {
        localRspIconPostfix.mergeFrom(paramArrayOfByte);
        return new pxq.b(localRspIconPostfix);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ram.w("GetUserIconHandler", "" + paramArrayOfByte);
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqIconPostfix localReqIconPostfix = new qqstory_service.ReqIconPostfix();
      Iterator localIterator = this.mP.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          localReqIconPostfix.union_id_list.add(ByteStringMicro.copyFromUtf8(str));
        }
      }
      return localReqIconPostfix.toByteArray();
    }
    
    public String mg()
    {
      return ppf.fQ("StorySvc.batch_get_user_icon_info");
    }
  }
  
  public static class b
    extends prl
  {
    qqstory_service.RspIconPostfix a;
    
    public b() {}
    
    public b(qqstory_service.RspIconPostfix paramRspIconPostfix)
    {
      super();
      this.a = paramRspIconPostfix;
    }
    
    public void aJ(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetUserIconHandler", 2, "GetUserIconListResponse errorCode:" + paramInt + " errorMsg:" + paramString);
      }
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetUserIconHandler", 2, "GetUserIconListResponse onNetError errorCode " + paramInt);
      }
    }
    
    public void onSuccess()
    {
      if ((this.a.icon_info.has()) && (this.a.icon_info.size() > 0)) {
        Bosses.get().postJob(new pxr(this, "GetUserIconHandler"));
      }
    }
  }
  
  public static class c
    extends plt
  {
    public HashMap<String, String[]> fl;
    
    public String toString()
    {
      return "InteractionInfoChangeEvent{iconMap=" + this.fl + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxq
 * JD-Core Version:    0.7.0.1
 */