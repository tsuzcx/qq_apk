import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class ajqm
{
  private static ajqm a = new ajqm();
  
  public static ajqm a()
  {
    return a;
  }
  
  public void i(QQAppInterface paramQQAppInterface, List<BusinessInfoCheckUpdate.NumRedInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfos");
    }
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      paramList = paramList.iterator();
      Object localObject2;
      while (paramList.hasNext())
      {
        localObject2 = (BusinessInfoCheckUpdate.NumRedInfo)paramList.next();
        if ((((BusinessInfoCheckUpdate.NumRedInfo)localObject2).appid.get() == 7719) && (((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().size() > 0))
        {
          localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject2).next();
            QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "numRedPath = " + localNumRedPath.str_path.get() + "msg_id = " + localNumRedPath.uint64_msgid.get());
            if (!((Map)localObject1).containsKey(Long.valueOf(localNumRedPath.uint64_msgid.get()))) {
              ((Map)localObject1).put(String.valueOf(localNumRedPath.uint64_msgid.get()), localNumRedPath);
            }
          }
        }
      }
      paramList = ((Map)localObject1).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Map.Entry)paramList.next();
        localObject2 = new Submsgtype0x89.NumRedBusiInfo();
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint64_msgid.set(((BusinessInfoCheckUpdate.NumRedPath)((Map.Entry)localObject1).getValue()).uint64_msgid.get());
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint32_android_app_id.set(7719);
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).str_android_path.set(((BusinessInfoCheckUpdate.NumRedPath)((Map.Entry)localObject1).getValue()).str_path.get());
        localArrayList.add(localObject2);
      }
      ((altl)paramQQAppInterface.getManager(65)).a(localArrayList, "nearby_num_red_dot", new ajqn(this, paramQQAppInterface));
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface, List<NumRedMsg.NumMsgBusi> paramList)
  {
    Object localObject1 = null;
    long l1 = 0L;
    HashMap localHashMap1 = new HashMap();
    jnv localjnv = (jnv)paramQQAppInterface.getManager(70);
    HashMap localHashMap2 = new HashMap();
    Object localObject2 = paramList.iterator();
    paramList = (List<NumRedMsg.NumMsgBusi>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      NumRedMsg.NumMsgBusi localNumMsgBusi = (NumRedMsg.NumMsgBusi)((Iterator)localObject2).next();
      i = localNumMsgBusi.ui_appid.get();
      long l2 = localNumMsgBusi.ui64_msgid.get();
      String str = localNumMsgBusi.str_path.get();
      localObject1 = localNumMsgBusi.str_ext.get();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: appid = " + i + ", path = " + str + ", content = " + (String)localObject1);
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0) && (str != null) && (str.length() > 0)) {}
      try
      {
        Object localObject3 = Base64.decode(new JSONObject((String)localObject1).getString("_red_ext_0x69"), 0);
        localObject1 = new oidb_0x791.RedDotInfo();
        ((oidb_0x791.RedDotInfo)localObject1).mergeFrom((byte[])localObject3);
        localObject3 = (altq)paramQQAppInterface.getManager(36);
        if ((!str.equals("7719.771901")) && (!str.equals("7719.771903")) && (!str.equals("7719.771904"))) {
          break label1068;
        }
        i = ((altq)localObject3).ag(str, 0);
        i = ((altq)localObject3).ag(str, 1) + i;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          continue;
          continue;
          continue;
          i = 0;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: num = " + i);
      }
      ((oidb_0x791.RedDotInfo)localObject1).uint32_number.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: str_custom_buffer = " + ((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get());
      }
      if (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() == 38) {
        localHashMap1.put(Long.valueOf(l2), localObject1);
      }
      if ((((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 38) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 42) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 59) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 60) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 54) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 53)) {
        break label1065;
      }
      if (localNumMsgBusi.ui64_msgid.get() <= l1) {
        break label1062;
      }
      l2 = localNumMsgBusi.ui64_msgid.get();
      l1 = l2;
      try
      {
        localHashMap2.put(Integer.valueOf(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get()), localObject1);
        paramList = (List<NumRedMsg.NumMsgBusi>)localObject1;
      }
      catch (Exception localException4)
      {
        try
        {
          akjq.a().b(paramQQAppInterface, (oidb_0x791.RedDotInfo)localObject1);
        }
        catch (Exception localException2)
        {
          Integer localInteger;
          break label541;
        }
        localException4 = localException4;
        paramList = (List<NumRedMsg.NumMsgBusi>)localObject1;
        localObject1 = localException4;
      }
      label541:
      ((Exception)localObject1).printStackTrace();
    }
    localObject1 = localHashMap2.keySet().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject1).next();
      localObject2 = localjnv.a(localInteger.intValue());
      if ((localObject2 != null) && (((oidb_0x791.RedDotInfo)localObject2).uint32_number.get() == ((oidb_0x791.RedDotInfo)localHashMap2.get(localInteger)).uint32_number.get())) {
        QLog.d("NearbyNewRedDotManager", 2, "this appid not has new reddot: appid  = " + localInteger + " num =  " + ((oidb_0x791.RedDotInfo)localHashMap2.get(localInteger)).uint32_number.get());
      }
      for (;;)
      {
        break;
        localjnv.f((oidb_0x791.RedDotInfo)localHashMap2.get(localInteger));
        i = 1;
      }
    }
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: unread num not change, just return");
      }
    }
    do
    {
      return;
      localjnv.ls(true);
      try
      {
        localjnv.B(localHashMap1);
        new anov(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("nearby_push_red_tmp").a(new String[] { paramList.uint32_appid.get() + "" }).report();
        if (paramList.uint32_appid.get() == 59)
        {
          new anov(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_exp_red").report();
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "setAllRedDotMsgInfo exp: e = " + localException1.getMessage());
          }
        }
        if (paramList.uint32_appid.get() == 60)
        {
          if (paramList.uint64_cmd_uin.get() == 1822701914L)
          {
            new anov(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_exp_red").report();
            return;
          }
          new anov(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_exp_red").report();
          return;
        }
      }
    } while (paramList.uint32_appid.get() != 61);
    new anov(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_exp_red").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqm
 * JD-Core Version:    0.7.0.1
 */