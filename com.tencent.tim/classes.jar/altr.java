import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

class altr
  extends altk
{
  altr(altq paramaltq, altq.b paramb, int paramInt) {}
  
  public void g(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    ArraySet localArraySet = new ArraySet();
    ArrayList localArrayList = new ArrayList();
    if ("QQCircleRedCircle".equals(paramString))
    {
      QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle updateNumMsg");
      if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          paramList = (NumRedMsg.NumMsgBusi)paramString.next();
          if ((paramList != null) && (paramList.str_ext.get() != null)) {
            try
            {
              JSONObject localJSONObject = new JSONObject(paramList.str_ext.get());
              localArraySet.add(localJSONObject.optString("_red_ext_uin"));
              long l = altq.a(this.this$0);
              if (l > 0L) {
                try
                {
                  if (Long.parseLong(localJSONObject.optString("_red_ext_feed_time")) < altq.a(this.this$0))
                  {
                    localArrayList.add(Long.valueOf(paramList.ui64_msgid.get()));
                    altq.a(this.this$0, 140000, (int)paramList.ui64_msgid.get(), 3);
                  }
                }
                catch (Exception paramList)
                {
                  paramList.printStackTrace();
                  QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle ", paramList);
                }
              }
            }
            catch (Exception paramList)
            {
              paramList.printStackTrace();
              QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle ", paramList);
            }
          }
        }
        paramString = new ArrayList(localArraySet);
        if (this.a != null)
        {
          this.a.z(paramString, this.dxp);
          QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle listener returns successfully: " + paramString.size() + ", num = " + this.dxp);
        }
        if (altq.a(this.this$0) > 0L)
        {
          altq.a(this.this$0, 0L);
          if (localArrayList.size() > 0)
          {
            paramString = this.this$0.getAppInfoByPath("140000");
            altq.a(this.this$0, paramString, 9, false, null, localArrayList, "");
            QLog.d("RedPointManage", 1, "getPassiveRedNumQQCircle updateNumMsg updateMsgId: " + localArrayList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altr
 * JD-Core Version:    0.7.0.1
 */