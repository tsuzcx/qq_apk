package com.tencent.mobileqq.activity.history;

import aetz;
import aeua;
import agmy;
import ahao;
import ahcb;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aobh;
import aobw;
import aqgv;
import aurf;
import ausj;
import auss;
import aviz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import top;
import wkj;
import ymn;
import zem;
import zem.b;
import zen;
import zeo;
import zep;
import zeq;
import zer;
import zja;
import zjl;
import zmq;

public class ChatHistoryBaseTenDocFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback
{
  private static final int[] jb = { -2011, -5008, -1000 };
  private boolean AI = true;
  private long FH = 9223372036854775807L;
  private long FI = 9223372036854775807L;
  private long FJ = 9223372036854775807L;
  private TextView MI;
  private ymn jdField_a_of_type_Ymn;
  private zem.b jdField_a_of_type_Zem$b;
  private zem jdField_a_of_type_Zem;
  private int bFx = 3;
  private View.OnClickListener bJ;
  private boolean bqY;
  private int cdm = 1;
  private XListView l;
  private Context mContext;
  private List<Object> mData = new ArrayList();
  private SessionInfo mSessionInfo;
  private int mUinType;
  private MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void V(Map<String, List<TencentDocItem>> paramMap)
  {
    if ((this.mData == null) || (paramMap == null)) {
      return;
    }
    if (this.AI) {
      this.AI = false;
    }
    this.mData.clear();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      this.mData.add(localObject);
      localObject = (List)paramMap.get(localObject);
      if (localObject != null) {
        this.mData.addAll((Collection)localObject);
      }
    }
    coT();
  }
  
  private TencentDocItem a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    label225:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return null;
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              paramMessageRecord = (MessageForStructing)paramMessageRecord;
              if ((paramMessageRecord.structingMsg != null) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgUrl)) && (agmy.mt(paramMessageRecord.structingMsg.mMsgUrl))) {
                return a(paramMessageRecord.structingMsg.mMsgUrl);
              }
            }
            else
            {
              if (!(paramMessageRecord instanceof MessageForArkApp)) {
                break label225;
              }
              paramMessageRecord = (MessageForArkApp)paramMessageRecord;
              Object localObject = paramMessageRecord.ark_app_message.metaList;
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  if (((JSONObject)localObject).has(paramMessageRecord.ark_app_message.appView))
                  {
                    paramMessageRecord = new JSONObject(((JSONObject)localObject).getString(paramMessageRecord.ark_app_message.appView));
                    localObject = paramMessageRecord.optString("appid");
                    String str = paramMessageRecord.optString("qqdocurl");
                    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(String.valueOf(aobw.aoS)))) {
                      return a(paramMessageRecord.getString("jumpUrl").replace("\\", ""));
                    }
                    if ((!TextUtils.isEmpty(str)) && (agmy.mt(str)))
                    {
                      paramMessageRecord = a(str);
                      return paramMessageRecord;
                    }
                  }
                }
                catch (JSONException paramMessageRecord) {}
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("ChatHistoryBaseTenDocFragment", 2, paramMessageRecord.getMessage());
        return null;
      } while (!(paramMessageRecord instanceof MessageForText));
      paramMessageRecord = (MessageForText)paramMessageRecord;
    } while (!agmy.mt(paramMessageRecord.msg));
    return a(paramMessageRecord.msg);
  }
  
  private TencentDocItem a(String paramString)
  {
    try
    {
      Object localObject = Uri.parse(paramString).buildUpon().clearQuery().build().toString();
      JSONObject localJSONObject = aobh.f((String)localObject, this.mUin);
      if (localJSONObject.getInt("retcode") != 0) {
        return null;
      }
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject(localJSONObject, null, localTencentDocData);
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatHistoryBaseTenDocFragment", 4, paramString + " " + (String)localObject + " fetch info: " + localTencentDocData.docIcon + " " + localTencentDocData.title);
      }
      if (!TextUtils.isEmpty(localTencentDocData.title))
      {
        localObject = new TencentDocItem();
        ((TencentDocItem)localObject).mIcon = aobw.nW(paramString);
        ((TencentDocItem)localObject).mTitle = localTencentDocData.title;
        ((TencentDocItem)localObject).mUrl = paramString;
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryBaseTenDocFragment", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  private String a(String paramString, MessageRecord paramMessageRecord)
  {
    if (top.fs(this.mUinType))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append('\n');
      if (paramMessageRecord == null) {
        return localStringBuilder.toString();
      }
      paramString = aqgv.a(this.mApp, paramMessageRecord.senderuin, this.mUin, 1, 0);
      localStringBuilder.append(paramMessageRecord.senderuin).append('\n');
      localStringBuilder.append(paramString).append('\n');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append('\n');
    if (paramMessageRecord == null) {
      return localStringBuilder.toString();
    }
    if (paramMessageRecord.isSend()) {}
    for (paramString = paramMessageRecord.frienduin;; paramString = paramMessageRecord.senderuin)
    {
      paramMessageRecord = aqgv.s(this.mApp, paramString);
      localStringBuilder.append(paramString).append('\n');
      localStringBuilder.append(paramMessageRecord).append('\n');
      return localStringBuilder.toString();
    }
  }
  
  private Map<String, List<TencentDocItem>> a(boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    List localList1;
    if (paramBoolean) {
      localList1 = this.mApp.b().a(this.mUin, this.mUinType, jb, 2147483647);
    }
    while ((localList1 == null) || (localList1.isEmpty()))
    {
      return localLinkedHashMap;
      if (top.fs(this.mUinType))
      {
        this.FI -= 1L;
        localList1 = this.mApp.b().a(this.mUin, this.mUinType, this.FH, this.bFx, this.FI, jb, 2147483647);
      }
      else
      {
        localList1 = this.mApp.b().a(this.mUin, this.mUinType, this.FH, this.bFx, this.FJ, jb, 2147483647);
      }
    }
    if (localList1.size() < 2147483647) {
      this.bqY = true;
    }
    int k = localList1.size() - 1;
    Object localObject;
    int j;
    TencentDocItem localTencentDocItem;
    int i;
    if (k >= 0)
    {
      localObject = (MessageRecord)localList1.get(k);
      switch (h((MessageRecord)localObject))
      {
      default: 
        j = 0;
        localTencentDocItem = null;
        i = 0;
      }
    }
    for (;;)
    {
      label243:
      if (localTencentDocItem == null) {
        if ((i != 0) && (localObject != null)) {
          c((MessageRecord)localObject, false);
        }
      }
      for (;;)
      {
        k -= 1;
        break;
        localTencentDocItem = a((MessageRecord)localObject);
        j = 1;
        i = 1;
        break label243;
        localTencentDocItem = b((MessageRecord)localObject);
        if (localTencentDocItem != null) {
          break label544;
        }
        localTencentDocItem = a((MessageRecord)localObject);
        j = 1;
        i = 0;
        break label243;
        if (((MessageRecord)localObject).shmsgseq < this.FI) {
          this.FI = ((MessageRecord)localObject).shmsgseq;
        }
        if (((MessageRecord)localObject).versionCode < this.bFx) {
          this.bFx = ((MessageRecord)localObject).versionCode;
        }
        if ((((MessageRecord)localObject).getId() > 0L) && (((MessageRecord)localObject).getId() < this.FH)) {
          this.FH = ((MessageRecord)localObject).getId();
        }
        if (((MessageRecord)localObject).time < this.FJ) {
          this.FJ = ((MessageRecord)localObject).time;
        }
        localTencentDocItem.mDescription = k((MessageRecord)localObject);
        localTencentDocItem.mRecord = ((MessageRecord)localObject);
        localTencentDocItem.mSearchWords = a(localTencentDocItem.mTitle, (MessageRecord)localObject);
        if (i != 0) {
          c((MessageRecord)localObject, true);
        }
        if (j != 0) {
          a(localTencentDocItem, (MessageRecord)localObject);
        }
        String str = ahcb.bt(((MessageRecord)localObject).time * 1000L);
        List localList2 = (List)localLinkedHashMap.get(str);
        localObject = localList2;
        if (localList2 == null)
        {
          localObject = new ArrayList();
          localLinkedHashMap.put(str, localObject);
        }
        ((List)localObject).add(localTencentDocItem);
      }
      return localLinkedHashMap;
      label544:
      j = 0;
      i = 0;
    }
  }
  
  private void a(TencentDocItem paramTencentDocItem, MessageRecord paramMessageRecord)
  {
    if ((paramTencentDocItem == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_title", paramTencentDocItem.mTitle);
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_icon", paramTencentDocItem.mIcon);
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_url", paramTencentDocItem.mUrl);
  }
  
  private TencentDocItem b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    do
    {
      return null;
      str1 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_title");
      str2 = paramMessageRecord.getExtInfoFromExtStr("ten_doc_icon");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ten_doc_url");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(paramMessageRecord)));
    TencentDocItem localTencentDocItem = new TencentDocItem();
    localTencentDocItem.mUrl = paramMessageRecord;
    localTencentDocItem.mIcon = str2;
    localTencentDocItem.mTitle = str1;
    return localTencentDocItem;
  }
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("ten_doc_is_ten_doc", String.valueOf(paramBoolean));
  }
  
  private void coS()
  {
    aetz localaetz = aeua.a();
    if (localaetz.ahX()) {
      QQToast.a(this.mContext, 2131720878, 1).show();
    }
    int i;
    do
    {
      return;
      i = this.mApp.getPreferences().getInt("key_tencent_doc_history_tab_tips_count", 0);
    } while (i >= localaetz.Cz());
    QQToast.a(this.mContext, 2131720878, 1).show();
    this.mApp.getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", i + 1).apply();
  }
  
  private void coT()
  {
    boolean bool = false;
    if (this.mData.isEmpty())
    {
      if (this.l.getVisibility() != 8) {
        anot.a(this.mApp, "dc00898", "", "", "0X800A169", "0X800A169", this.cdm, 0, "", "", "s_qq_history_tab", "");
      }
      this.l.setVisibility(8);
      this.MI.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zem != null)
      {
        zer localzer = this.jdField_a_of_type_Zer;
        if (this.jdField_a_of_type_Zem.getCount() != 0) {
          bool = true;
        }
        localzer.BB(bool);
      }
      return;
      this.l.setVisibility(0);
      this.MI.setVisibility(8);
    }
  }
  
  private void coU()
  {
    ThreadManager.excute(new ChatHistoryBaseTenDocFragment.5(this), 128, null, false);
  }
  
  private List<TencentDocItem> dl()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Zja.dl();
    if (localObject1 == null) {
      return localArrayList;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof TencentDocItem)) {
        localArrayList.add((TencentDocItem)localObject2);
      }
    }
    return localArrayList;
  }
  
  private void fO(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (RelativeLayout)paramView.findViewById(2131377786);
    TextView localTextView = (TextView)paramView.findViewById(2131380917);
    EditText localEditText = (EditText)paramView.findViewById(2131366542);
    localTextView.setText(getString(2131691434));
    paramView.findViewById(2131363801).setVisibility(8);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this.bJ);
    paramView.setLayerType(0, null);
    this.mSessionInfo = new SessionInfo();
    this.mSessionInfo.aTl = this.mUin;
    this.mSessionInfo.cZ = this.mUinType;
    this.mSessionInfo.a = new wkj();
    this.mSessionInfo.cN = ChatTextSizeSettingActivity.ag(getActivity());
  }
  
  private void gX()
  {
    zmq localzmq = new zmq(getActivity(), this.mApp, this.mSessionInfo, this.cdm);
    localzmq.setData(this.mData);
    localzmq.show();
  }
  
  private int h(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return -2;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ten_doc_is_ten_doc");
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return -1;
    }
    if (Boolean.parseBoolean(paramMessageRecord)) {
      return 0;
    }
    return 1;
  }
  
  private void hh(List<TencentDocItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.mData.removeAll(paramList);
    if (!this.mData.isEmpty())
    {
      this.mData.add("");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mData.iterator();
      Object localObject1 = null;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localArrayList.add(localObject2);
        if ((localObject2 instanceof String))
        {
          paramList = localObject2;
          if (localObject1 != null) {
            localArrayList.remove(localObject1);
          }
        }
        for (paramList = localObject2;; paramList = null)
        {
          localObject1 = paramList;
          break;
        }
      }
      if (!localArrayList.isEmpty()) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      this.mData.clear();
      this.mData.addAll(localArrayList);
    }
    ahao.OT(2131692514);
    this.jdField_a_of_type_Zem.notifyDataSetChanged();
    coT();
  }
  
  private String k(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (top.fs(this.mUinType)) {
      return ahcb.bu(paramMessageRecord.time * 1000L) + " " + localBaseApplicationImpl.getString(2131693552) + " " + aqgv.a(this.mApp, paramMessageRecord.senderuin, this.mUin, 1, 0) + " " + localBaseApplicationImpl.getString(2131693542);
    }
    if (paramMessageRecord.isSend()) {}
    for (String str = localBaseApplicationImpl.getString(2131693587) + " " + aqgv.s(this.mApp, paramMessageRecord.frienduin);; str = localBaseApplicationImpl.getString(2131693552) + " " + aqgv.s(this.mApp, paramMessageRecord.senderuin)) {
      return ahcb.bu(paramMessageRecord.time * 1000L) + " " + str + " " + localBaseApplicationImpl.getString(2131693542);
    }
  }
  
  private void kJ()
  {
    if (this.bJ == null) {
      this.bJ = new zeo(this);
    }
    if (this.jdField_a_of_type_Zem$b == null) {
      this.jdField_a_of_type_Zem$b = new zep(this);
    }
    aobw.a(this.MI, new zeq(this));
  }
  
  void BA(boolean paramBoolean)
  {
    super.BA(paramBoolean);
    if (this.jdField_a_of_type_Zem != null) {
      this.jdField_a_of_type_Zem.setSelectMode(paramBoolean);
    }
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  protected void coH()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Zjl.hk(localArrayList);
  }
  
  protected void coM()
  {
    super.coM();
    Object localObject = dl();
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ahao.OU(2131691424);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = ((TencentDocItem)((Iterator)localObject).next()).mRecord;
      if ((localMessageRecord instanceof ChatMessage)) {
        localArrayList.add((ChatMessage)localMessageRecord);
      }
    }
    this.jdField_a_of_type_Ymn.gG(localArrayList);
    coI();
    anot.a(this.mApp, "dc00898", "", "", "0X800A173", "0X800A173", this.cdm, 0, "", "", "s_qq_history_tab", "");
  }
  
  protected void coN()
  {
    super.coN();
    if (dl().isEmpty())
    {
      ahao.OU(2131691424);
      return;
    }
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.setMainTitle(2131698325);
    localausj.addButton(getString(2131693518), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new zen(this, localausj));
    localausj.show();
  }
  
  protected void coO()
  {
    super.coO();
    Object localObject = dl();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TencentDocItem localTencentDocItem = (TencentDocItem)((Iterator)localObject).next();
      String str = this.mApp.getAccount();
      aviz.a(localTencentDocItem.mUrl).c(str).b(this.mActivity, str);
    }
    coI();
  }
  
  void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1121) {
      coS();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    coI();
    if (this.jdField_a_of_type_Zem != null) {
      this.jdField_a_of_type_Zem.notifyDataSetChanged();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    coT();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof Map))
      {
        V((Map)paramMessage.obj);
        continue;
        if ((paramMessage.obj instanceof List)) {
          hh((List)paramMessage.obj);
        }
        anot.a(this.mApp, "dc00898", "", "", "0X800A172", "0X800A172", this.cdm, 0, "", "", "s_qq_history_tab", "");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContext = getActivity();
    paramBundle = getActivity().getIntent().getExtras();
    if (paramBundle != null)
    {
      this.mUinType = paramBundle.getInt("uintype");
      if (!top.fs(this.mUinType)) {
        break label222;
      }
    }
    label222:
    for (this.cdm = 2;; this.cdm = 1)
    {
      paramLayoutInflater = (RelativeLayout)paramLayoutInflater.inflate(2131558947, paramViewGroup, false);
      this.MI = ((TextView)paramLayoutInflater.findViewById(2131380770));
      this.l = ((XListView)paramLayoutInflater.findViewById(2131378827));
      this.MI.setVisibility(0);
      this.l.setCacheColorHint(0);
      this.jdField_a_of_type_Ymn = new ymn(getActivity(), 9101);
      this.jdField_a_of_type_Ymn.onCreate();
      kJ();
      this.jdField_a_of_type_Zem = new zem(this.mContext);
      this.jdField_a_of_type_Zem.setData(this.mData);
      this.jdField_a_of_type_Zem.y(this.bJ);
      this.jdField_a_of_type_Zem.a(this.jdField_a_of_type_Zem$b);
      this.l.setAdapter(this.jdField_a_of_type_Zem);
      fO(paramLayoutInflater);
      coT();
      coU();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mUinType = 1;
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    anot.a(this.mApp, "dc00898", "", "", "0X800A167", "0X800A167", this.cdm, 0, "", "", "s_qq_history_tab", "");
  }
  
  public void pH(boolean paramBoolean)
  {
    super.pH(paramBoolean);
    if (paramBoolean) {
      anot.a(this.mApp, "dc00898", "", "", "0X800A168", "0X800A168", this.cdm, 0, "", "", "s_qq_history_tab", "");
    }
  }
  
  protected int yg()
  {
    return 1602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment
 * JD-Core Version:    0.7.0.1
 */