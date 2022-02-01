import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlRspHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebViewConfigRsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aivr
  implements andh
{
  public static final String Tag = aivr.class.getSimpleName();
  QQAppInterface app;
  Set<String> cG = new HashSet();
  boolean clW = false;
  boolean clY = false;
  private int interval;
  
  public aivr(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void duR()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new File(this.app.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.bPG);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebCoreDump", 2, "Can't create dir: " + localObject);
        }
      }
      else
      {
        localJSONObject.put("js_report", this.clW);
        localJSONObject.put("url_check", this.clY);
        if (this.cG.size() > 0)
        {
          localObject = new JSONArray();
          Iterator localIterator = this.cG.iterator();
          while (localIterator.hasNext()) {
            ((JSONArray)localObject).put((String)localIterator.next());
          }
        }
      }
      long l;
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        QLog.w("WebCoreDump", 2, "-->save config failed:" + localJSONException.toString());
        return;
        localJSONException.put("url_list", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreDump", 2, "Http capture white list=" + this.cG);
        }
        if (this.interval > 0)
        {
          localObject = this.app.getPreferences();
          l = System.currentTimeMillis() + this.interval * 1000;
          ((SharedPreferences)localObject).edit().putLong("nextCheckWebviewTime", l).commit();
          if (QLog.isColorLevel())
          {
            localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l));
            QLog.d(Tag, 2, "handleCheckUpdateItemData nextCheckUpdateTime" + (String)localObject);
          }
        }
        localObject = new FileOutputStream(new File(this.app.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.bPG + this.app.getCurrentAccountUin() + "config.json"));
        ((FileOutputStream)localObject).write(localJSONException.toString().getBytes());
        ((FileOutputStream)localObject).close();
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (QLog.isColorLevel())
      {
        QLog.w("WebCoreDump", 2, "-->save config failed:" + localFileNotFoundException.toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebCoreDump", 2, "-->url white list is empty!");
        }
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebCoreDump", 2, "-->save config failed:" + localIOException.toString());
      }
    }
  }
  
  public ReqItem a(int paramInt)
  {
    if (!apI()) {
      return null;
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 126;
    Object localObject1 = new PreloadInfoCheckUpdate.WebViewConfigReq();
    Object localObject2 = new PreloadInfoCheckUpdate.ControlReqHead();
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).protocol_ver.set(1);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_plat_id.set(109);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).client_ver.set("3.4.4.3058");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).os_ver.set("1d5677cf");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject2).uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).head.set((MessageMicro)localObject2);
    localObject1 = ((PreloadInfoCheckUpdate.WebViewConfigReq)localObject1).toByteArray();
    paramInt = localObject1.length;
    int i = paramInt + 4;
    localObject2 = new byte[i];
    System.arraycopy(aqcz.intToByte(i), 0, localObject2, 0, 4);
    System.arraycopy(localObject1, 0, localObject2, 4, paramInt);
    localReqItem.vecParam = ((byte[])localObject2);
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem == null) {}
    while (paramRespItem.eServiceID != 126) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(Tag, 2, "handleCheckUpdateItemData respitem.cResult:" + paramRespItem.cResult);
    }
    this.clW = false;
    this.clY = false;
    this.cG.clear();
    int i = paramRespItem.cResult;
    Object localObject = paramRespItem.vecUpdate;
    if ((i == 2) && (localObject.length > 4))
    {
      i = (int)aqoj.getLongData((byte[])localObject, 0);
      paramRespItem = new byte[i - 4];
      aqoj.copyData(paramRespItem, 0, (byte[])localObject, 4, i - 4);
    }
    for (;;)
    {
      try
      {
        localObject = new PreloadInfoCheckUpdate.WebViewConfigRsp();
        ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).mergeFrom(paramRespItem);
        if (((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).head.code.get() == 0)
        {
          this.clW = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).js_report.get();
          this.clY = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).url_check.get();
          this.cG.addAll(((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).url_list.get());
          this.interval = ((PreloadInfoCheckUpdate.WebViewConfigRsp)localObject).interval.get();
          if (QLog.isColorLevel()) {
            QLog.d("WebCoreDump", 2, "handleCheckUpdateItemData IsReportLog" + this.clW + ", Url_Check=" + this.clY + ", interval=" + this.interval);
          }
        }
        duR();
        if (VipWebViewReportLog.bv.get() == 1) {
          break;
        }
        VipWebViewReportLog.cF = this.cG;
        VipWebViewReportLog.clW = this.clW;
        VipWebViewReportLog.clX = this.clY;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebCoreDump", 2, "Update VipWebViewReportLog members");
        return;
      }
      catch (Exception paramRespItem)
      {
        paramRespItem.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebCoreDump", 2, "-->exception during handle checkup data:" + paramRespItem.toString());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 2, "-->checkup error:result=" + i + ",data length:" + localObject.length);
      }
    }
  }
  
  public boolean apI()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        long l1 = this.app.getPreferences().getLong("nextCheckWebviewTime", 0L);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l1));
          String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(l2));
          localObject1 = Tag;
          localObject2 = new StringBuilder().append("isSendTemplateCheckUpdate nextCheckUpdateTime=").append((String)localObject2).append(",systemTimestamp=").append(str).append(",isSend=");
          if (l2 <= l1) {
            continue;
          }
          bool1 = true;
          QLog.d((String)localObject1, 2, bool1);
        }
        Object localObject1 = new File(this.app.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.bPG + this.app.getCurrentAccountUin() + "config.json");
        if (l2 <= l1)
        {
          boolean bool3 = ((File)localObject1).exists();
          bool1 = bool2;
          if (bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      catch (Exception localException)
      {
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(Tag, 2, "Can't handle JS log and HTTP capture white list config: " + localException);
      }
      return bool1;
      bool1 = false;
    }
    return false;
  }
  
  public int mT()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivr
 * JD-Core Version:    0.7.0.1
 */