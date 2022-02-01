import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryFileView.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uog
  extends uou
  implements abdx.b, Handler.Callback
{
  final String TAG = "ChatHistoryFileView<FileAssistant>";
  abdx jdField_a_of_type_Abdx;
  private aghq jdField_a_of_type_Aghq;
  boolean aUa = false;
  View.OnClickListener de;
  View.OnClickListener df;
  LinearLayout fU;
  XListView l;
  public QQAppInterface mApp;
  public Context mContext;
  private List<Object> mData;
  private int mDataType;
  View mSubView;
  private String mUin;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    paramLinkedHashMap = paramLinkedHashMap.values().iterator();
    while (paramLinkedHashMap.hasNext()) {
      Collections.sort((List)paramLinkedHashMap.next(), new uoh(this));
    }
  }
  
  private void a(JSONObject paramJSONObject, LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = d(paramJSONObject);
      if (aobw.d(paramJSONObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFileView<FileAssistant>", 1, "tencent doc size: " + paramJSONObject.size());
        }
        paramJSONObject = paramJSONObject.iterator();
        while (paramJSONObject.hasNext())
        {
          TencentDocData localTencentDocData = (TencentDocData)paramJSONObject.next();
          String str = ahcb.bt(localTencentDocData.aioTime);
          if (!paramLinkedHashMap.containsKey(str)) {
            paramLinkedHashMap.put(str, new ArrayList());
          }
          ((List)paramLinkedHashMap.get(str)).add(localTencentDocData);
        }
        ahau.JH("0X8009A9E");
      }
      a(paramLinkedHashMap);
    }
    paramJSONObject = new Message();
    paramJSONObject.what = 1;
    paramJSONObject.obj = paramLinkedHashMap;
    this.uiHandler.sendMessage(paramJSONObject);
  }
  
  private LinkedHashMap<String, List<Object>> b()
  {
    Object localObject = new ArrayList(this.mApp.a().av(this.mUin));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio)) {
        if (this.mDataType == 1)
        {
          if ((localFileManagerEntity.nFileType != 3) && (localFileManagerEntity.nFileType != 9) && (localFileManagerEntity.nFileType != 7) && (localFileManagerEntity.nFileType != 6) && (localFileManagerEntity.nFileType != 10)) {}
        }
        else {
          do
          {
            do
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("ChatHistoryFileView<FileAssistant>", 1, "ChatHistory Query Entity[" + localFileManagerEntity.getId() + "] SessionId:" + localFileManagerEntity.nSessionId);
              }
              String str = ahcb.bt(localFileManagerEntity.srvTime);
              if (!localLinkedHashMap.containsKey(str)) {
                localLinkedHashMap.put(str, new ArrayList());
              }
              ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
              break;
            } while (this.mDataType != 3);
            if ((localFileManagerEntity.nFileType == 3) || (localFileManagerEntity.nFileType == 9) || (localFileManagerEntity.nFileType == 7) || (localFileManagerEntity.nFileType == 6) || (localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 10)) {
              break;
            }
          } while (localFileManagerEntity.nFileType != 2);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private void b(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {}
    for (;;)
    {
      return;
      if (this.mData != null)
      {
        this.mData.clear();
        Iterator localIterator = paramLinkedHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.mData.add(str);
          this.mData.addAll((Collection)paramLinkedHashMap.get(str));
        }
      }
    }
  }
  
  private void bKg()
  {
    ThreadManager.post(new ChatHistoryFileView.1(this), 8, null, true);
  }
  
  private void bKh()
  {
    b(b());
    bKi();
  }
  
  private void bKi()
  {
    if ((this.mData == null) || (this.mData.size() == 0))
    {
      this.fU.setVisibility(0);
      this.l.setVisibility(8);
    }
    for (;;)
    {
      this.mSubView.setVisibility(0);
      this.jdField_a_of_type_Abdx.notifyDataSetChanged();
      return;
      this.fU.setVisibility(8);
      this.l.setVisibility(0);
    }
  }
  
  private void bKj()
  {
    if (this.df != null) {
      return;
    }
    this.df = new uoi(this);
  }
  
  private void bKk()
  {
    if (this.de != null) {
      return;
    }
    this.de = new uoj(this);
  }
  
  private ArrayList<TencentDocData> d(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") == 0)
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("recent_file_list");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get(i);
          TencentDocData localTencentDocData = new TencentDocData();
          JSONObject localJSONObject2 = (JSONObject)localJSONObject1.get("doc_info");
          localTencentDocData.peerTips = localJSONObject1.getString("peer_tips");
          TencentDocData.obtainFromJsonObject(localJSONObject2, (JSONObject)localJSONObject1.get("qq_share_common_msg"), localTencentDocData);
          localArrayList.add(localTencentDocData);
          i += 1;
        }
        return localArrayList;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFileView<FileAssistant>", 1, paramJSONObject.getMessage());
      }
    }
    return null;
  }
  
  public void At(int paramInt)
  {
    this.mDataType = paramInt;
    if (this.mDataType == 1)
    {
      bKg();
      return;
    }
    bKh();
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    bKk();
    bKj();
    this.mUin = paramIntent.getStringExtra("uin");
    this.mData = new ArrayList();
    this.jdField_a_of_type_Abdx = new abdx(this.mContext, this.mData, this.df, this.de, this);
    this.jdField_a_of_type_Abdx.a(this);
    this.mSubView = View.inflate(this.mContext, 2131561018, null);
    this.l = ((XListView)this.mSubView.findViewById(2131370584));
    this.fU = ((LinearLayout)this.mSubView.findViewById(2131372448));
    this.l.setVisibility(8);
    this.fU.setVisibility(8);
    this.l.setAdapter(this.jdField_a_of_type_Abdx);
    paramIntent = this.mSubView.findViewById(2131367060);
    paramQQAppInterface = paramIntent.findViewById(2131374641);
    paramIntent.setVisibility(8);
    paramQQAppInterface.setVisibility(8);
  }
  
  public View aI()
  {
    return this.mSubView;
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
  }
  
  public boolean bC()
  {
    return this.aUa;
  }
  
  public void bJW()
  {
    if (this.jdField_a_of_type_Aghq != null) {
      return;
    }
    this.jdField_a_of_type_Aghq = new uom(this);
    this.mApp.a().addObserver(this.jdField_a_of_type_Aghq);
  }
  
  public void bJX()
  {
    if (this.jdField_a_of_type_Aghq != null)
    {
      this.mApp.a().deleteObserver(this.jdField_a_of_type_Aghq);
      this.jdField_a_of_type_Aghq = null;
    }
  }
  
  public void bJY()
  {
    this.aUa = true;
    this.jdField_a_of_type_Abdx.BG(true);
    this.jdField_a_of_type_Abdx.notifyDataSetChanged();
  }
  
  public void bJZ()
  {
    this.aUa = false;
    this.jdField_a_of_type_Abdx.BG(false);
    this.jdField_a_of_type_Abdx.notifyDataSetChanged();
  }
  
  public void c(TencentDocData paramTencentDocData)
  {
    if (bC()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramTencentDocData);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Abdx.notifyDataSetChanged();
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.Pm());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramTencentDocData);
      continue;
      aobw.h(paramTencentDocData.docUrl, this.mContext);
      ahau.JH("0X8009A9F");
    }
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.a().aIH();
    if (bC()) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        if ((paramFileManagerEntity.cloudType == 3) && (!ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())))
        {
          ahao.JD(ahav.kY(paramFileManagerEntity.fileName) + acfp.m(2131703618));
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramFileManagerEntity);
        }
        this.jdField_a_of_type_Abdx.notifyDataSetChanged();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.Pm());
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramFileManagerEntity);
      break;
      if (H()) {
        break label146;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
    return;
    label146:
    aM();
    Object localObject = new ahau.a();
    ((ahau.a)localObject).bJE = "file_viewer_in";
    ((ahau.a)localObject).cYX = 73;
    ((ahau.a)localObject).bJF = ahbj.getExtension(paramFileManagerEntity.fileName);
    ((ahau.a)localObject).nFileSize = paramFileManagerEntity.fileSize;
    ahau.a(this.mApp.getCurrentAccountUin(), (ahau.a)localObject);
    ahau.JH("0X8004AE4");
    localObject = new agvl(this.mApp, this.mContext, paramFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    if ((this.mUin != null) && (this.mUin.trim().length() != 0))
    {
      localBundle.putString("c2c_discussion_recentfile", this.mUin);
      localBundle.putString("file_browser_extra_params_uin", this.mUin);
    }
    ((agvl)localObject).cB(localBundle);
    localObject = new agvn(this.mContext, (agvq)localObject);
    ((agvn)localObject).Oy(7);
    if (paramFileManagerEntity.peerType == 0) {
      ((agvn)localObject).Oy(2);
    }
    for (;;)
    {
      ((agvn)localObject).JE(true);
      ((agvn)localObject).djN();
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        ((agvn)localObject).Oy(6);
      }
    }
  }
  
  public void cg()
  {
    if (this.jdField_a_of_type_Aghq != null)
    {
      this.mApp.a().deleteObserver(this.jdField_a_of_type_Aghq);
      this.jdField_a_of_type_Aghq = null;
    }
    super.cg();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    b((LinkedHashMap)paramMessage.obj);
    bKi();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uog
 * JD-Core Version:    0.7.0.1
 */