package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.model.AttachmentUI;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.ftn.Ftn.File;
import com.tencent.qqmail.ftn.Ftn.ItemRarPreviewOutput;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMTopBar;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZipOnlinePreviewActivity
  extends BaseActivityEx
{
  public static final String ARG_ATTACH = "attach";
  public static final String ARG_ATTACH_TYPE = "attachType";
  public static final String ARG_MAILID = "id";
  private static final int HANDLE_CGIERROR_TIPS = 2;
  private static final int HANDLE_NETWORK_TIPS = 1;
  private static final int HANDLE_SET_ADAPTER = 0;
  private static final int PREVIEW_BIG_ATTACH = 2;
  private static final int PREVIEW_FTN_ATTACH = 3;
  private static final int PREVIEW_NORMAL_ATTACH = 1;
  public static final String TAG = "ZipAttachmentActivity";
  private Account account;
  private ZipOnlinePreviewAdapter attachmentAdapter;
  private AttachmentUI attachmentUI;
  private String downloadUrl;
  private String fid;
  private MailBigAttach ftnAttach;
  private Handler handler = new ZipOnlinePreviewActivity.8(this);
  private AdapterView.OnItemClickListener itemClickListener = new ZipOnlinePreviewActivity.7(this);
  private ListView listView;
  private RelativeLayout loadingLayout;
  private QMLoading loadingView;
  private int mAttachType;
  private Attach mailAttach;
  private String mailId;
  private IObserver observerGetFileRarPreviewError = new ZipOnlinePreviewActivity.2(this, null);
  private IObserver observerGetFileRarPreviewSuccess = new ZipOnlinePreviewActivity.1(this, null);
  private String packageName;
  private final Stack<List<AttachmentUI>> stack_ui = new Stack();
  private QMTopBar topBar;
  private String zipDownCGIHost;
  
  private String analyzeMailAttach(Attach paramAttach)
    throws UnsupportedEncodingException
  {
    String str3 = paramAttach.getPreview().getDownloadUrl().replace("&amp;", "&").split(",")[0];
    String str1 = "";
    String str2 = URLEncoder.encode(paramAttach.getName(), "gb2312");
    if (str3.contains("download"))
    {
      paramAttach = str3.split("\\?");
      paramAttach = StringExtention.urlEncode(paramAttach[(paramAttach.length - 1)]);
      paramAttach = paramAttach + "&cpsfile=" + str2 + "&action=applist";
    }
    for (;;)
    {
      return paramAttach.replace("%26", "&");
      paramAttach = str1;
      if (str3.contains("groupattachment"))
      {
        paramAttach = str3.split("\\?");
        paramAttach = StringExtention.urlEncode(paramAttach[(paramAttach.length - 1)]);
        paramAttach = (paramAttach + "&filename=" + StringExtention.urlEncode(str2) + "&cpsfile=" + str2 + "&action=applist").replace("att=", "resurl=/cgi-bin/groupattachment?att=");
      }
    }
  }
  
  public static Intent createIntentForBigAttach(Attach paramAttach, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ZipOnlinePreviewActivity.class);
    localIntent.putExtra("attachType", 2);
    localIntent.putExtra("attach", paramAttach);
    localIntent.putExtra("id", paramString);
    return localIntent;
  }
  
  public static Intent createIntentForFtnAttach(Attach paramAttach, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ZipOnlinePreviewActivity.class);
    localIntent.putExtra("attachType", 3);
    localIntent.putExtra("attach", paramAttach);
    localIntent.putExtra("id", paramString);
    return localIntent;
  }
  
  public static Intent createIntentForNormalAttach(Attach paramAttach, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ZipOnlinePreviewActivity.class);
    localIntent.putExtra("attachType", 1);
    localIntent.putExtra("attach", paramAttach);
    localIntent.putExtra("id", paramString);
    return localIntent;
  }
  
  private void downloadAttach(Attach paramAttach)
  {
    if (this.attachmentUI != null)
    {
      this.handler.sendEmptyMessage(0);
      return;
    }
    if (QMNetworkUtils.isNetworkConnected(this))
    {
      newDownloadAttach(paramAttach);
      return;
    }
    QMLog.log(6, "ZipAttachmentActivity", "Download zipattachment network exception!");
    QMUIHelper.showToast(this, 2131696288, "");
  }
  
  private void downloadFtn(MailBigAttach paramMailBigAttach)
  {
    if (QMNetworkUtils.isNetworkConnected(this))
    {
      newDownloadFtn(paramMailBigAttach);
      return;
    }
    QMUIHelper.showToast(this, 2131696288, "");
  }
  
  private String getDownloadUrl(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = paramString.split("\\?");
    paramString = paramString[(paramString.length - 1)].replaceAll("\\{", "%7B").replaceAll("\\}", "%7D");
    String str = paramString;
    if (!"viewcompress".equals("viewcompress"))
    {
      str = paramString;
      if (!"viewcompress".equals("attdownload"))
      {
        String[] arrayOfString = paramString.split("&");
        str = paramString;
        if (arrayOfString.length > 0)
        {
          str = paramString;
          if (paramString.contains("&filename="))
          {
            paramString = "";
            int i = 0;
            str = paramString;
            if (i < arrayOfString.length - 1)
            {
              if (i == arrayOfString.length - 1) {}
              for (paramString = paramString + arrayOfString[i];; paramString = paramString + arrayOfString[i] + "&")
              {
                i += 1;
                break;
              }
            }
          }
        }
      }
    }
    return QMNetworkConfig.getCgiRequestHost(this.mailAttach.getAccountId()) + "/cgi-bin/" + "viewcompress" + "?" + str;
  }
  
  private String getFtnDownloadUrl(String paramString1, String paramString2, String paramString3)
    throws UnsupportedEncodingException
  {
    String str = paramString1;
    if (paramString1.contains("&amp;")) {
      str = paramString1.replace("&amp;", "&");
    }
    paramString1 = str.split("\\?");
    paramString1 = paramString1[(paramString1.length - 1)].replace("%26", "&");
    return paramString1 + "key=" + paramString2 + "&path=" + paramString3;
  }
  
  private void handleZipAttachDir(int paramInt)
  {
    AttachmentUI localAttachmentUI1 = (AttachmentUI)this.attachmentAdapter.getItem(paramInt);
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.attachmentAdapter.getAttachmentUI().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AttachmentUI localAttachmentUI2 = (AttachmentUI)((Iterator)localObject).next();
      try
      {
        localArrayList.add((AttachmentUI)localAttachmentUI2.clone());
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    this.stack_ui.push(localArrayList);
    localArrayList = new ArrayList();
    localObject = new AttachmentUI();
    ((AttachmentUI)localObject).setType("back");
    ((AttachmentUI)localObject).setDirName(localAttachmentUI1.getDirName());
    ((AttachmentUI)localObject).setUrlEncodeDirName(localAttachmentUI1.getUrlEncodeDirName());
    localArrayList.add(localObject);
    localArrayList.addAll(localAttachmentUI1.getAttachmentUIs());
    QMLog.log(4, "ZipAttachmentActivity", "handle-zipattach-dir dirname: " + ((AttachmentUI)localObject).getDirName());
    this.attachmentAdapter.setAttachmentUI(localArrayList);
  }
  
  private void handleZipAttachFile(int paramInt)
  {
    if (isFtnAttach())
    {
      onItemClickFromFtn(paramInt);
      return;
    }
    onItemClickFromMail(paramInt);
  }
  
  private void hideLoading()
  {
    if (this.loadingLayout != null)
    {
      this.loadingLayout.setVisibility(8);
      this.loadingView.stop();
    }
  }
  
  private void initFtnAttach()
  {
    this.ftnAttach = ((MailBigAttach)getIntent().getSerializableExtra("attach"));
    FtnCommonUtils.parseFtnNeceParamFromUrl(this.ftnAttach);
    this.downloadUrl = this.ftnAttach.getPreview().getDownloadUrl();
  }
  
  private void initListView()
  {
    this.loadingView = new QMLoading(getApplicationContext());
    this.loadingLayout = ((RelativeLayout)findViewById(2131382445));
    this.loadingLayout.addView(this.loadingView);
    this.listView = ((ListView)findViewById(2131382444));
    this.listView.setOnItemClickListener(this.itemClickListener);
  }
  
  private void initMailAttach()
  {
    this.mailAttach = ((Attach)getIntent().getSerializableExtra("attach"));
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.mailAttach.getAccountId());
    this.mailId = getIntent().getStringExtra("id");
    this.downloadUrl = this.mailAttach.getPreview().getDownloadUrl();
  }
  
  private void initMailBigInfo()
  {
    if (!StringExtention.isNullOrEmpty(this.attachmentUI.getDownHost()))
    {
      String[] arrayOfString1 = this.attachmentUI.getDownHost().split("\\?");
      if (arrayOfString1.length == 2)
      {
        arrayOfString1 = arrayOfString1[1].split("&");
        int i = 0;
        if (i < arrayOfString1.length)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length == 2)
          {
            if (!arrayOfString2[0].equals("fid")) {
              break label91;
            }
            this.fid = arrayOfString2[1];
          }
          for (;;)
          {
            i += 1;
            break;
            label91:
            if (arrayOfString2[0].equals("packname")) {
              this.packageName = arrayOfString2[1];
            }
          }
        }
      }
    }
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    if (this.mailAttach != null)
    {
      this.topBar.setTitle(this.mailAttach.getName());
      this.topBar.getTitleView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }
    for (;;)
    {
      this.topBar.setCenterOnclickListener(new ZipOnlinePreviewActivity.3(this));
      this.topBar.setButtonLeftNormal(2131691552);
      this.topBar.getButtonLeft().setOnClickListener(new ZipOnlinePreviewActivity.4(this));
      return;
      if (this.ftnAttach != null)
      {
        this.topBar.setTitle(this.ftnAttach.getName());
        this.topBar.getTitleView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
      }
    }
  }
  
  private boolean isFtnAttach()
  {
    return this.ftnAttach != null;
  }
  
  private void json2FileTree(JSONObject paramJSONObject, AttachmentUI paramAttachmentUI)
  {
    label569:
    label574:
    for (;;)
    {
      try
      {
        Object localObject1 = paramJSONObject.getJSONArray("file");
        if (localObject1 == null) {
          break label569;
        }
        localObject1 = ((JSONArray)localObject1).getJSONObject(0);
        Object localObject2 = (String)((JSONObject)localObject1).get("count");
        if ((localObject2 == null) || (((String)localObject2).equals(""))) {
          break label569;
        }
        int k = 0;
        int j = 0;
        i = j;
        Object localObject3;
        if (k < Integer.parseInt((String)localObject2))
        {
          Object localObject4 = ((JSONObject)localObject1).getJSONArray("item");
          localObject3 = new AttachmentUI();
          localObject4 = ((JSONArray)localObject4).getJSONObject(k);
          ((AttachmentUI)localObject3).setDirName(((JSONObject)localObject4).getJSONArray("name").getJSONObject(0).getString("DATA").replace("&nbsp;", " "));
          ((AttachmentUI)localObject3).setDirPath(((JSONObject)localObject4).getJSONArray("fullpath").getJSONObject(0).getString("DATA"));
          ((AttachmentUI)localObject3).setUrlEncodeDirName(((JSONObject)localObject4).getJSONArray("urlencodename").getJSONObject(0).getString("DATA"));
          ((AttachmentUI)localObject3).setUrlEncodeDirPath(((JSONObject)localObject4).getJSONArray("urlencodefullpath").getJSONObject(0).getString("DATA"));
          ((AttachmentUI)localObject3).setSize(((JSONObject)localObject4).getJSONArray("size").getJSONObject(0).getString("DATA"));
          ((AttachmentUI)localObject3).setIviewType(((JSONObject)localObject4).getJSONArray("iviewtype").getJSONObject(0).getString("DATA"));
          ((AttachmentUI)localObject3).setType("file");
          ((AttachmentUI)localObject3).setZipFileName("");
          paramAttachmentUI.getAttachmentUIs().add(localObject3);
          k += 1;
          j += 1;
          continue;
        }
        paramJSONObject = paramJSONObject.getJSONArray("dir");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.getJSONObject(0);
          localObject1 = (String)paramJSONObject.get("count");
          if ((localObject1 != null) && (!((String)localObject1).equals("")))
          {
            j = 0;
            if (j >= Integer.parseInt((String)localObject1)) {
              break label574;
            }
            localObject3 = paramJSONObject.getJSONArray("item");
            localObject2 = new AttachmentUI();
            localObject3 = ((JSONArray)localObject3).getJSONObject(j);
            ((AttachmentUI)localObject2).setDirName(((JSONObject)localObject3).getJSONArray("dirname").getJSONObject(0).getString("DATA").replace("&nbsp;", " "));
            ((AttachmentUI)localObject2).setDirPath(((JSONObject)localObject3).getJSONArray("dirpath").getJSONObject(0).getString("DATA"));
            ((AttachmentUI)localObject2).setUrlEncodeDirName(((JSONObject)localObject3).getJSONArray("urlencodedirname").getJSONObject(0).getString("DATA"));
            ((AttachmentUI)localObject2).setUrlEncodeDirPath(((JSONObject)localObject3).getJSONArray("urlencodedirpath").getJSONObject(0).getString("DATA"));
            ((AttachmentUI)localObject2).setSize("");
            ((AttachmentUI)localObject2).setIviewType("");
            ((AttachmentUI)localObject2).setType("dir");
            ((AttachmentUI)localObject2).setZipFileName("");
            json2FileTree((JSONObject)localObject3, (AttachmentUI)localObject2);
            paramAttachmentUI.getAttachmentUIs().add(localObject2);
            localObject2 = (String)paramJSONObject.get("count");
            i += 1;
            j += 1;
            continue;
            if ((i > 0) && (paramAttachmentUI != null)) {
              paramAttachmentUI.setDirFileCount(i);
            }
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      continue;
      int i = 0;
    }
  }
  
  private AttachmentUI json2Object(JSONObject paramJSONObject, AttachmentUI paramAttachmentUI)
  {
    paramJSONObject = paramJSONObject.getJSONArray("compress");
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getJSONObject(0);
      Object localObject = paramJSONObject.getJSONArray("cpsrawname");
      if (localObject != null)
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        paramAttachmentUI.setSize((String)((JSONObject)localObject).get("size"));
        paramAttachmentUI.setDirName((String)((JSONObject)localObject).get("DATA"));
      }
      paramJSONObject = paramJSONObject.getJSONArray("dir");
      if (paramJSONObject != null)
      {
        localObject = paramJSONObject.getJSONObject(0);
        paramJSONObject = (String)((JSONObject)localObject).get("count");
        if ((paramJSONObject != null) && (!paramJSONObject.equals("")))
        {
          localObject = ((JSONObject)localObject).getJSONArray("item");
          int i = 0;
          while (i < Integer.parseInt(paramJSONObject))
          {
            if (localObject != null)
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
              paramAttachmentUI.setDirPath(localJSONObject.getJSONArray("dirpath").getJSONObject(0).getString("DATA"));
              paramAttachmentUI.setUrlEncodeDirName(localJSONObject.getJSONArray("urlencodedirname").getJSONObject(0).getString("DATA"));
              paramAttachmentUI.setUrlEncodeDirPath(localJSONObject.getJSONArray("urlencodedirpath").getJSONObject(0).getString("DATA"));
              paramAttachmentUI.setIviewType("0");
              paramAttachmentUI.setType("compressed");
              json2FileTree(localJSONObject, paramAttachmentUI);
            }
            i += 1;
          }
        }
      }
    }
    return paramAttachmentUI;
  }
  
  private void newDownloadAttach(Attach paramAttach)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = analyzeMailAttach(paramAttach);
      localObject1 = localObject2;
      localObject2 = ((String)localObject2).replaceAll("\\{", "%7B");
      localObject1 = localObject2;
      localObject2 = ((String)localObject2).replaceAll("\\}", "%7D");
      localObject1 = localObject2;
      QMLog.log(4, "ZipAttachmentActivity", "newDownloadAttach: " + (String)localObject2);
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        String str;
        QMLog.log(6, "ZipAttachmentActivity", "newDownloadAttach " + paramAttach.toString());
      }
    }
    if (localObject1 == null)
    {
      QMLog.log(6, "ZipAttachmentActivity", "newDownloadAttach str is null!");
      finish();
    }
    str = "zip";
    localObject2 = str;
    if (paramAttach != null)
    {
      localObject2 = str;
      if (paramAttach.getSuffix() != null)
      {
        localObject2 = str;
        if (!paramAttach.getSuffix().equals("")) {
          localObject2 = paramAttach.getSuffix();
        }
      }
    }
    downloadJson(localObject1, (String)localObject2);
  }
  
  private void newDownloadFtn(MailBigAttach paramMailBigAttach)
  {
    this.attachmentUI = new AttachmentUI();
    paramMailBigAttach.getPreview().setDownloadUrl(this.downloadUrl);
    FtnManager.sharedInstance().getFileRarPreview(paramMailBigAttach.getFid(), paramMailBigAttach.getKey(), paramMailBigAttach.getCode(), paramMailBigAttach.getName());
  }
  
  private void onItemClickFromFtn(int paramInt)
  {
    try
    {
      AttachmentUI localAttachmentUI = (AttachmentUI)this.attachmentAdapter.getItem(paramInt);
      MailBigAttach localMailBigAttach = new MailBigAttach(false);
      localMailBigAttach.setAccountId(this.ftnAttach.getAccountId());
      localMailBigAttach.setSize(localAttachmentUI.getSize());
      localMailBigAttach.setName(localAttachmentUI.getDirName());
      localMailBigAttach.getPreview().setIviewtype(localAttachmentUI.getIviewType());
      String str = FileUtil.getFileNameSuffix(localAttachmentUI.getDirName());
      localMailBigAttach.setSuffix(str);
      localMailBigAttach.getPreview().setItype(AttachType.valueOf(QMAttachUtils.attachFileType(str)));
      localMailBigAttach.getPreview().setDownloadUrl(getFtnDownloadUrl(this.attachmentUI.getDownHost(), this.attachmentUI.getvKey(), localAttachmentUI.getUrlEncodeDirPath()));
      str = this.attachmentUI.getDownHost();
      paramInt = str.lastIndexOf("/cgi-bin/");
      if (paramInt > 0) {
        this.zipDownCGIHost = str.substring(0, paramInt);
      }
      str = this.zipDownCGIHost + "/cgi-bin/ftnviewcpsfile?" + localMailBigAttach.getPreview().getDownloadUrl();
      localMailBigAttach.getPreview().setDownloadUrl(str);
      startActivity(ZipInnerAttachDownloadActivity.createIntentForMailBig(this, localMailBigAttach, this.fid, this.packageName, localAttachmentUI.getUrlEncodeDirPath()));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void onItemClickFromMail(int paramInt)
  {
    AttachmentUI localAttachmentUI;
    Attach localAttach;
    Object localObject;
    if (this.mailAttach != null)
    {
      localAttachmentUI = (AttachmentUI)this.attachmentAdapter.getItem(paramInt);
      localAttach = new Attach(false);
      localAttach.setAccountId(this.mailAttach.getAccountId());
      localAttach.setSize(localAttachmentUI.getSize());
      localAttach.getPreview().setIviewtype(localAttachmentUI.getIviewType());
      localObject = localAttachmentUI.getUrlEncodeDirName();
    }
    try
    {
      String str = URLDecoder.decode((String)localObject, "utf-8");
      localObject = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localAttach.getPreview().setDownloadUrl(getDownloadUrl(getMailDownloadUrl(localAttachmentUI, this.downloadUrl, (String)localObject)));
    localAttach.setName((String)localObject);
    localAttach.setSuffix(FileUtil.getFileNameSuffix(localAttach.getName()));
    localAttach.getPreview().setItype(AttachType.valueOf(QMAttachUtils.attachFileType(localAttach.getSuffix())));
    startActivity(ZipInnerAttachDownloadActivity.createIntentForNormal(this, localAttach));
  }
  
  private AttachmentUI proto2AttachmentUI(ItemRarPreviewOutput paramItemRarPreviewOutput, String paramString1, String paramString2, AttachmentUI paramAttachmentUI)
  {
    if ((paramItemRarPreviewOutput == null) || (paramAttachmentUI == null)) {}
    for (;;)
    {
      return paramAttachmentUI;
      try
      {
        paramAttachmentUI.setSize(paramString2);
        paramAttachmentUI.setDirName(paramString1);
        paramAttachmentUI.setUrlEncodeDirName("/");
        paramAttachmentUI.setUrlEncodeDirPath("/");
        paramAttachmentUI.setIviewType("0");
        paramAttachmentUI.setType("compressed");
        paramItemRarPreviewOutput.fileList.size();
        paramItemRarPreviewOutput = paramItemRarPreviewOutput.fileList.iterator();
        while (paramItemRarPreviewOutput.hasNext())
        {
          paramString1 = (File)paramItemRarPreviewOutput.next();
          paramAttachmentUI.setDirPath(paramString1.path);
          proto2FileTree(paramString1, paramAttachmentUI);
        }
        return paramAttachmentUI;
      }
      catch (Exception paramItemRarPreviewOutput)
      {
        paramItemRarPreviewOutput.printStackTrace();
      }
    }
  }
  
  private void proto2FileTree(File paramFile, AttachmentUI paramAttachmentUI)
  {
    if (paramFile.type == 1) {
      paramAttachmentUI.setDirFileCount(paramFile.subDir.size());
    }
    paramFile = paramFile.subDir.iterator();
    if (paramFile.hasNext())
    {
      File localFile = (File)paramFile.next();
      AttachmentUI localAttachmentUI = new AttachmentUI();
      localAttachmentUI.setDirName(localFile.name);
      localAttachmentUI.setUrlEncodeDirName(localFile.name);
      localAttachmentUI.setUrlEncodeDirPath(localFile.path);
      localAttachmentUI.setUrlEncodeFullPath("");
      localAttachmentUI.setIviewType(Integer.toString(localFile.viewtype));
      if (localFile.type == 0)
      {
        localAttachmentUI.setDirPath(localFile.fullname);
        localAttachmentUI.setSize(Long.toString(localFile.filesize));
        localAttachmentUI.setType("file");
        localAttachmentUI.setZipFileName("");
      }
      for (;;)
      {
        paramAttachmentUI.getAttachmentUIs().add(localAttachmentUI);
        break;
        localAttachmentUI.setDirPath(localFile.fullname);
        localAttachmentUI.setSize("");
        localAttachmentUI.setType("dir");
        localAttachmentUI.setZipFileName("");
        proto2FileTree(localFile, localAttachmentUI);
      }
    }
  }
  
  private void renderListView()
  {
    if (this.attachmentAdapter == null)
    {
      this.attachmentAdapter = new ZipOnlinePreviewAdapter(this, this.attachmentUI);
      this.listView.setAdapter(this.attachmentAdapter);
      return;
    }
    this.attachmentAdapter.setAttachmentUI(this.attachmentUI.getAttachmentUIs());
    this.attachmentAdapter.notifyDataSetChanged();
  }
  
  public void back()
  {
    if (this.stack_ui.size() > 1)
    {
      List localList = (List)this.stack_ui.pop();
      this.attachmentAdapter.setAttachmentUI(localList);
      return;
    }
    finish();
  }
  
  public void downloadJson(String paramString1, String paramString2)
  {
    this.attachmentUI = new AttachmentUI();
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new ZipOnlinePreviewActivity.5(this, paramString2));
    localQMCallback.setOnError(new ZipOnlinePreviewActivity.6(this, paramString2));
    QMLog.log(4, "ZipAttachmentActivity", "downloadJson: " + CGIManager.removeSid(paramString1));
    CGIManager.httpGetExcludeHttps(this.account.getId(), "viewcompress", CGIManager.removeSid(paramString1), localQMCallback);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772423, 2130772402);
  }
  
  public String getMailDownloadUrl(AttachmentUI paramAttachmentUI, String paramString1, String paramString2)
  {
    try
    {
      str = URLEncoder.encode(paramString2, "gb2312");
      paramString2 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        try
        {
          String str = StringExtention.urlEncode(paramString1);
          paramString1 = str.replace("%26", "&");
          paramString1 = (paramString1 + "&cpsfile=" + paramString2 + "&action=download&viewtype=txt&redirect=false&t=attachments_content").replace("att=", "resurl=/cgi-bin/groupattachment?att=");
          return paramString1 + "&curfile=" + paramAttachmentUI.getUrlEncodeDirPath() + "&iviewtype=" + paramAttachmentUI.getIviewType();
        }
        catch (UnsupportedEncodingException paramAttachmentUI)
        {
          QMLog.log(6, "FileUtil", "downUrl: " + paramString1 + " is not utf8");
        }
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        QMLog.log(6, "FileUtil", "name: " + paramString2 + " is not gb2312");
      }
    }
    paramString1 = paramString1.replace("&amp;", "&").split("\\?");
    paramString1 = paramString1[(paramString1.length - 1)];
    return null;
  }
  
  public void initDataSource()
  {
    this.mAttachType = getIntent().getIntExtra("attachType", 1);
    Serializable localSerializable = getIntent().getSerializableExtra("attach");
    if (localSerializable == null)
    {
      QMLog.log(6, "ZipAttachmentActivity", "get intent mail attach object is null");
      finish();
      return;
    }
    if ((localSerializable instanceof MailBigAttach))
    {
      initFtnAttach();
      return;
    }
    initMailAttach();
  }
  
  public void initDom()
  {
    if (this.mailAttach == null)
    {
      finish();
      return;
    }
    initTopBar();
    initListView();
    if (isFtnAttach())
    {
      downloadFtn(this.ftnAttach);
      return;
    }
    downloadAttach(this.mailAttach);
  }
  
  public void initUI()
  {
    setContentView(2131558526);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramInt2 == 1))
    {
      paramIntent = paramIntent.getStringExtra("filePath");
      IntentUtil.openFile(this, paramIntent, FileUtil.getFileNameSuffix(paramIntent), AttachPreviewType.MailNormalAttachPreview);
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("actiongetfilerarpreviewsucc", this.observerGetFileRarPreviewSuccess);
      QMNotification.registNotification("actiongetfilerarpreviewerror", this.observerGetFileRarPreviewError);
      return;
    }
    QMNotification.unregistNotification("actiongetfilerarpreviewsucc", this.observerGetFileRarPreviewSuccess);
    QMNotification.unregistNotification("actiongetfilerarpreviewerror", this.observerGetFileRarPreviewError);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      back();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity
 * JD-Core Version:    0.7.0.1
 */